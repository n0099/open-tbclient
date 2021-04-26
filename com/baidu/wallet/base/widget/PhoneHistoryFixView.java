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
    public View f24308a;

    /* renamed from: b  reason: collision with root package name */
    public View f24309b;

    /* renamed from: c  reason: collision with root package name */
    public View f24310c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f24311d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f24312e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f24313f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f24314g;

    /* renamed from: h  reason: collision with root package name */
    public a f24315h;

    /* renamed from: i  reason: collision with root package name */
    public OnPhoneHistoryFixViewClickListener f24316i;
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
        public Context f24319b;

        /* renamed from: c  reason: collision with root package name */
        public final LayoutInflater f24320c;

        /* renamed from: d  reason: collision with root package name */
        public List<ContractInfo> f24321d = new ArrayList();

        public a(Context context) {
            this.f24319b = context;
            this.f24320c = LayoutInflater.from(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: a */
        public String getItem(int i2) {
            return null;
        }

        public void a(List<ContractInfo> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.f24321d = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f24321d.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            SpannableString spannableString;
            if (view == null) {
                b bVar2 = new b();
                View inflate = this.f24320c.inflate(ResUtils.layout(this.f24319b, "wallet_base_fix_item"), (ViewGroup) null);
                bVar2.f24323b = (TextView) inflate.findViewById(ResUtils.id(this.f24319b, "wallet_phone_fix"));
                bVar2.f24324c = (TextView) inflate.findViewById(ResUtils.id(this.f24319b, "wallet_name_fix"));
                inflate.setTag(bVar2);
                bVar = bVar2;
                view = inflate;
            } else {
                bVar = (b) view.getTag();
            }
            if (i2 < this.f24321d.size()) {
                if (!PhoneHistoryFixView.this.j) {
                    spannableString = new SpannableString(this.f24321d.get(i2).getMobile().replace(" ", ""));
                } else {
                    spannableString = new SpannableString(this.f24321d.get(i2).getMobile());
                }
                int errordigit = this.f24321d.get(i2).getErrordigit();
                if (errordigit != -1 && errordigit < spannableString.length()) {
                    spannableString.setSpan(new ForegroundColorSpan(ResUtils.getColor(this.f24319b, "bd_wallet_fp_fix_character")), errordigit, errordigit + 1, 34);
                }
                bVar.f24323b.setText(spannableString);
                bVar.f24324c.setText(this.f24321d.get(i2).getName());
            }
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public TextView f24323b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f24324c;

        public b() {
        }
    }

    public PhoneHistoryFixView(Context context) {
        super(context);
        this.j = false;
        a();
    }

    public void displayContactInfoData(List<ContractInfo> list) {
        this.f24313f.setVisibility(8);
        this.f24314g.setVisibility(8);
        this.f24309b.setVisibility(8);
        this.f24310c.setVisibility(8);
        this.f24308a.setVisibility(8);
        this.f24312e.setVisibility(0);
        a(list);
    }

    public void displayHistoryData(ArrayList<String> arrayList) {
        displayHistoryData(a(arrayList));
    }

    public ListView getmListView() {
        return this.f24311d;
    }

    public boolean isShow() {
        return this.f24312e.isShown();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f24314g) {
            if (this.f24313f.getVisibility() == 0) {
                setListViewState(false, false);
                return;
            }
            OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener = this.f24316i;
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
        this.f24312e.setVisibility(z ? 0 : 8);
        this.f24313f.setVisibility(z2 ? 8 : 0);
        this.f24308a.setVisibility(z2 ? 8 : 0);
        OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener = this.f24316i;
        if (onPhoneHistoryFixViewClickListener != null) {
            onPhoneHistoryFixViewClickListener.onFixViewDisplayHistoryViews(z);
        }
        if (z) {
            this.f24314g.setText(z2 ? ResUtils.getString(getContext(), "wallet_fp_history_clear") : ResUtils.getString(getContext(), "wallet_fp_fix_sure"));
        }
    }

    public void setOnPhoneHistoryFixViewClickListener(OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener) {
        this.f24316i = onPhoneHistoryFixViewClickListener;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_mobile_phone_history_fix"), this);
        this.f24312e = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_layout"));
        TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_select"));
        this.f24314g = textView;
        textView.setOnClickListener(this);
        this.f24313f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_msg"));
        this.f24308a = findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_line1"));
        this.f24309b = findViewById(ResUtils.id(getContext(), "wallet_mobile_divide_line1"));
        this.f24310c = findViewById(ResUtils.id(getContext(), "wallet_mobile_divide_line2"));
        this.f24311d = (ListView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_list"));
        a aVar = new a(getContext());
        this.f24315h = aVar;
        this.f24311d.setAdapter((ListAdapter) aVar);
        this.f24311d.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.wallet.base.widget.PhoneHistoryFixView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                b bVar;
                if (view == null || (bVar = (b) view.getTag()) == null) {
                    return;
                }
                PhoneHistoryFixView phoneHistoryFixView = PhoneHistoryFixView.this;
                phoneHistoryFixView.setListViewState(false, phoneHistoryFixView.f24313f.getVisibility() != 0);
                if (PhoneHistoryFixView.this.f24316i != null) {
                    PhoneHistoryFixView.this.f24316i.onFixViewClickListViewItemAndSetText(bVar.f24323b.getText().toString());
                }
            }
        });
    }

    public void displayHistoryData(List<ContractInfo> list) {
        this.f24314g.setVisibility(0);
        this.f24309b.setVisibility(0);
        this.f24310c.setVisibility(0);
        a(list);
    }

    public PhoneHistoryFixView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        a();
    }

    public PhoneHistoryFixView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = false;
        a();
    }

    private void a(List<ContractInfo> list) {
        this.f24311d.setLayoutParams(new LinearLayout.LayoutParams(-1, list.size() > 2 ? DisplayUtils.dip2px(getContext(), 165.0f) : DisplayUtils.dip2px(getContext(), list.size() * 55)));
        this.f24315h.a(list);
        this.f24315h.notifyDataSetChanged();
        this.f24311d.setSelection(0);
    }

    private List<ContractInfo> a(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (true) {
            if (i2 >= (arrayList.size() <= 5 ? arrayList.size() : 5)) {
                return arrayList2;
            }
            String str = arrayList.get(i2);
            if (str.length() > 13) {
                str = str.substring(0, 13);
            }
            arrayList2.add(new ContractInfo(str, PhoneContactsMananger.getInstance(getContext().getApplicationContext()).getPayphoneInfo(str)));
            i2++;
        }
    }
}
