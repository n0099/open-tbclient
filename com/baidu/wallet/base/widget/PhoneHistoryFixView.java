package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import com.baidu.wallet.core.utils.contacts.PhoneContactsMananger;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class PhoneHistoryFixView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f23883a;

    /* renamed from: b  reason: collision with root package name */
    public View f23884b;

    /* renamed from: c  reason: collision with root package name */
    public View f23885c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f23886d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f23887e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23888f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23889g;

    /* renamed from: h  reason: collision with root package name */
    public a f23890h;
    public OnPhoneHistoryFixViewClickListener i;
    public boolean j;

    /* loaded from: classes5.dex */
    public interface OnPhoneHistoryFixViewClickListener {
        void onFixViewClickClearHistory();

        void onFixViewClickListViewItemAndSetText(String str);

        void onFixViewDisplayHistoryViews(boolean z);
    }

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public Context f23893b;

        /* renamed from: c  reason: collision with root package name */
        public final LayoutInflater f23894c;

        /* renamed from: d  reason: collision with root package name */
        public List<ContractInfo> f23895d = new ArrayList();

        public a(Context context) {
            this.f23893b = context;
            this.f23894c = LayoutInflater.from(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i) {
            return null;
        }

        public void a(List<ContractInfo> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.f23895d = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f23895d.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            SpannableString spannableString;
            if (view == null) {
                b bVar2 = new b();
                View inflate = this.f23894c.inflate(ResUtils.layout(this.f23893b, "wallet_base_fix_item"), (ViewGroup) null);
                bVar2.f23897b = (TextView) inflate.findViewById(ResUtils.id(this.f23893b, "wallet_phone_fix"));
                bVar2.f23898c = (TextView) inflate.findViewById(ResUtils.id(this.f23893b, "wallet_name_fix"));
                inflate.setTag(bVar2);
                bVar = bVar2;
                view = inflate;
            } else {
                bVar = (b) view.getTag();
            }
            if (i < this.f23895d.size()) {
                if (!PhoneHistoryFixView.this.j) {
                    spannableString = new SpannableString(this.f23895d.get(i).getMobile().replace(" ", ""));
                } else {
                    spannableString = new SpannableString(this.f23895d.get(i).getMobile());
                }
                int errordigit = this.f23895d.get(i).getErrordigit();
                if (errordigit != -1 && errordigit < spannableString.length()) {
                    spannableString.setSpan(new ForegroundColorSpan(ResUtils.getColor(this.f23893b, "bd_wallet_fp_fix_character")), errordigit, errordigit + 1, 34);
                }
                bVar.f23897b.setText(spannableString);
                bVar.f23898c.setText(this.f23895d.get(i).getName());
            }
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public TextView f23897b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f23898c;

        public b() {
        }
    }

    public PhoneHistoryFixView(Context context) {
        super(context);
        this.j = false;
        a();
    }

    public void displayContactInfoData(List<ContractInfo> list) {
        this.f23888f.setVisibility(8);
        this.f23889g.setVisibility(8);
        this.f23884b.setVisibility(8);
        this.f23885c.setVisibility(8);
        this.f23883a.setVisibility(8);
        this.f23887e.setVisibility(0);
        a(list);
    }

    public void displayHistoryData(ArrayList<String> arrayList) {
        displayHistoryData(a(arrayList));
    }

    public ListView getmListView() {
        return this.f23886d;
    }

    public boolean isShow() {
        return this.f23887e.isShown();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f23889g) {
            if (this.f23888f.getVisibility() == 0) {
                setListViewState(false, false);
                return;
            }
            OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener = this.i;
            if (onPhoneHistoryFixViewClickListener != null) {
                onPhoneHistoryFixViewClickListener.onFixViewClickClearHistory();
            }
            setListViewState(false, true);
        }
    }

    public void setInputNumberHasSpace(boolean z) {
        this.j = z;
    }

    public void setListViewState(boolean z, boolean z2) {
        this.f23887e.setVisibility(z ? 0 : 8);
        this.f23888f.setVisibility(z2 ? 8 : 0);
        this.f23883a.setVisibility(z2 ? 8 : 0);
        OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener = this.i;
        if (onPhoneHistoryFixViewClickListener != null) {
            onPhoneHistoryFixViewClickListener.onFixViewDisplayHistoryViews(z);
        }
        if (z) {
            this.f23889g.setText(z2 ? ResUtils.getString(getContext(), "wallet_fp_history_clear") : ResUtils.getString(getContext(), "wallet_fp_fix_sure"));
        }
    }

    public void setOnPhoneHistoryFixViewClickListener(OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener) {
        this.i = onPhoneHistoryFixViewClickListener;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_mobile_phone_history_fix"), this);
        this.f23887e = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_layout"));
        TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_select"));
        this.f23889g = textView;
        textView.setOnClickListener(this);
        this.f23888f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_msg"));
        this.f23883a = findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_line1"));
        this.f23884b = findViewById(ResUtils.id(getContext(), "wallet_mobile_divide_line1"));
        this.f23885c = findViewById(ResUtils.id(getContext(), "wallet_mobile_divide_line2"));
        this.f23886d = (ListView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_list"));
        a aVar = new a(getContext());
        this.f23890h = aVar;
        this.f23886d.setAdapter((ListAdapter) aVar);
        this.f23886d.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.wallet.base.widget.PhoneHistoryFixView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                b bVar;
                if (view == null || (bVar = (b) view.getTag()) == null) {
                    return;
                }
                PhoneHistoryFixView phoneHistoryFixView = PhoneHistoryFixView.this;
                phoneHistoryFixView.setListViewState(false, phoneHistoryFixView.f23888f.getVisibility() != 0);
                if (PhoneHistoryFixView.this.i != null) {
                    PhoneHistoryFixView.this.i.onFixViewClickListViewItemAndSetText(bVar.f23897b.getText().toString());
                }
            }
        });
    }

    public void displayHistoryData(List<ContractInfo> list) {
        this.f23889g.setVisibility(0);
        this.f23884b.setVisibility(0);
        this.f23885c.setVisibility(0);
        a(list);
    }

    public PhoneHistoryFixView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        a();
    }

    public PhoneHistoryFixView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        a();
    }

    private void a(List<ContractInfo> list) {
        this.f23886d.setLayoutParams(new LinearLayout.LayoutParams(-1, list.size() > 2 ? DisplayUtils.dip2px(getContext(), 165.0f) : DisplayUtils.dip2px(getContext(), list.size() * 55)));
        this.f23890h.a(list);
        this.f23890h.notifyDataSetChanged();
        this.f23886d.setSelection(0);
    }

    private List<ContractInfo> a(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= (arrayList.size() <= 5 ? arrayList.size() : 5)) {
                return arrayList2;
            }
            String str = arrayList.get(i);
            if (str.length() > 13) {
                str = str.substring(0, 13);
            }
            arrayList2.add(new ContractInfo(str, PhoneContactsMananger.getInstance(getContext().getApplicationContext()).getPayphoneInfo(str)));
            i++;
        }
    }
}
