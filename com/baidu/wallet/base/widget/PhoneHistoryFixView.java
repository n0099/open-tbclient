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
    public View f23482a;

    /* renamed from: b  reason: collision with root package name */
    public View f23483b;

    /* renamed from: c  reason: collision with root package name */
    public View f23484c;

    /* renamed from: d  reason: collision with root package name */
    public ListView f23485d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f23486e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f23487f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23488g;

    /* renamed from: h  reason: collision with root package name */
    public a f23489h;

    /* renamed from: i  reason: collision with root package name */
    public OnPhoneHistoryFixViewClickListener f23490i;
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
        public Context f23493b;

        /* renamed from: c  reason: collision with root package name */
        public final LayoutInflater f23494c;

        /* renamed from: d  reason: collision with root package name */
        public List<ContractInfo> f23495d = new ArrayList();

        public a(Context context) {
            this.f23493b = context;
            this.f23494c = LayoutInflater.from(context);
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
            this.f23495d = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f23495d.size();
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
                View inflate = this.f23494c.inflate(ResUtils.layout(this.f23493b, "wallet_base_fix_item"), (ViewGroup) null);
                bVar2.f23497b = (TextView) inflate.findViewById(ResUtils.id(this.f23493b, "wallet_phone_fix"));
                bVar2.f23498c = (TextView) inflate.findViewById(ResUtils.id(this.f23493b, "wallet_name_fix"));
                inflate.setTag(bVar2);
                bVar = bVar2;
                view = inflate;
            } else {
                bVar = (b) view.getTag();
            }
            if (i2 < this.f23495d.size()) {
                if (!PhoneHistoryFixView.this.j) {
                    spannableString = new SpannableString(this.f23495d.get(i2).getMobile().replace(" ", ""));
                } else {
                    spannableString = new SpannableString(this.f23495d.get(i2).getMobile());
                }
                int errordigit = this.f23495d.get(i2).getErrordigit();
                if (errordigit != -1 && errordigit < spannableString.length()) {
                    spannableString.setSpan(new ForegroundColorSpan(ResUtils.getColor(this.f23493b, "bd_wallet_fp_fix_character")), errordigit, errordigit + 1, 34);
                }
                bVar.f23497b.setText(spannableString);
                bVar.f23498c.setText(this.f23495d.get(i2).getName());
            }
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        public TextView f23497b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f23498c;

        public b() {
        }
    }

    public PhoneHistoryFixView(Context context) {
        super(context);
        this.j = false;
        a();
    }

    public void displayContactInfoData(List<ContractInfo> list) {
        this.f23487f.setVisibility(8);
        this.f23488g.setVisibility(8);
        this.f23483b.setVisibility(8);
        this.f23484c.setVisibility(8);
        this.f23482a.setVisibility(8);
        this.f23486e.setVisibility(0);
        a(list);
    }

    public void displayHistoryData(ArrayList<String> arrayList) {
        displayHistoryData(a(arrayList));
    }

    public ListView getmListView() {
        return this.f23485d;
    }

    public boolean isShow() {
        return this.f23486e.isShown();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f23488g) {
            if (this.f23487f.getVisibility() == 0) {
                setListViewState(false, false);
                return;
            }
            OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener = this.f23490i;
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
        this.f23486e.setVisibility(z ? 0 : 8);
        this.f23487f.setVisibility(z2 ? 8 : 0);
        this.f23482a.setVisibility(z2 ? 8 : 0);
        OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener = this.f23490i;
        if (onPhoneHistoryFixViewClickListener != null) {
            onPhoneHistoryFixViewClickListener.onFixViewDisplayHistoryViews(z);
        }
        if (z) {
            this.f23488g.setText(z2 ? ResUtils.getString(getContext(), "wallet_fp_history_clear") : ResUtils.getString(getContext(), "wallet_fp_fix_sure"));
        }
    }

    public void setOnPhoneHistoryFixViewClickListener(OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener) {
        this.f23490i = onPhoneHistoryFixViewClickListener;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_mobile_phone_history_fix"), this);
        this.f23486e = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_layout"));
        TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_select"));
        this.f23488g = textView;
        textView.setOnClickListener(this);
        this.f23487f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_msg"));
        this.f23482a = findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_line1"));
        this.f23483b = findViewById(ResUtils.id(getContext(), "wallet_mobile_divide_line1"));
        this.f23484c = findViewById(ResUtils.id(getContext(), "wallet_mobile_divide_line2"));
        this.f23485d = (ListView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_list"));
        a aVar = new a(getContext());
        this.f23489h = aVar;
        this.f23485d.setAdapter((ListAdapter) aVar);
        this.f23485d.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.wallet.base.widget.PhoneHistoryFixView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                b bVar;
                if (view == null || (bVar = (b) view.getTag()) == null) {
                    return;
                }
                PhoneHistoryFixView phoneHistoryFixView = PhoneHistoryFixView.this;
                phoneHistoryFixView.setListViewState(false, phoneHistoryFixView.f23487f.getVisibility() != 0);
                if (PhoneHistoryFixView.this.f23490i != null) {
                    PhoneHistoryFixView.this.f23490i.onFixViewClickListViewItemAndSetText(bVar.f23497b.getText().toString());
                }
            }
        });
    }

    public void displayHistoryData(List<ContractInfo> list) {
        this.f23488g.setVisibility(0);
        this.f23483b.setVisibility(0);
        this.f23484c.setVisibility(0);
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
        this.f23485d.setLayoutParams(new LinearLayout.LayoutParams(-1, list.size() > 2 ? DisplayUtils.dip2px(getContext(), 165.0f) : DisplayUtils.dip2px(getContext(), list.size() * 55)));
        this.f23489h.a(list);
        this.f23489h.notifyDataSetChanged();
        this.f23485d.setSelection(0);
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
