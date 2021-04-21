package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class O2OBankCardInfoAdapter extends BaseAdapter {
    public static final String SELECTEDORENABLEFLAG = "1";
    public static final String SHOW_BIND_CARD_BTN_FLAG = "1";

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f25251b;

    /* renamed from: c  reason: collision with root package name */
    public Context f25252c;

    /* renamed from: a  reason: collision with root package name */
    public List<O2OBankInfo> f25250a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public int f25253d = 0;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public TextView f25254a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f25255b;

        public a() {
        }
    }

    public O2OBankCardInfoAdapter(Context context, List<O2OBankInfo> list) {
        this.f25252c = context;
        this.f25251b = (LayoutInflater) context.getSystemService("layout_inflater");
        if (list != null) {
            this.f25250a.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f25250a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f25251b.inflate(ResUtils.layout(this.f25252c, "wallet_base_bankinfo_item"), (ViewGroup) null);
            aVar = new a();
            aVar.f25254a = (TextView) view.findViewById(ResUtils.id(this.f25252c, "bd_wallet_bank_info"));
            aVar.f25255b = (ImageView) view.findViewById(ResUtils.id(this.f25252c, "bd_Wallet_bank_sel_imge"));
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        O2OBankInfo item = getItem(i);
        if (item == null) {
            return view;
        }
        if (i == 0) {
            view.setBackgroundResource(ResUtils.drawable(this.f25252c, "wallet_base_corners_top"));
        } else {
            view.setBackgroundResource(ResUtils.drawable(this.f25252c, "wallet_base_history_item_selector"));
        }
        if ("1".equalsIgnoreCase(item.enabled)) {
            aVar.f25254a.setEnabled(true);
            aVar.f25254a.setText(item.display_name);
            aVar.f25254a.setTextColor(ResUtils.getColor(this.f25252c, "bd_wallet_text_gray_color"));
        } else {
            aVar.f25254a.setEnabled(false);
            aVar.f25254a.setText(item.display_name);
            aVar.f25254a.setTextColor(ResUtils.getColor(this.f25252c, "bd_wallet_pwdpay_light_gray"));
        }
        if (i + 1 == this.f25253d) {
            aVar.f25255b.setImageDrawable(ResUtils.getDrawable(this.f25252c, "wallet_base_payset_checked"));
        } else {
            aVar.f25255b.setImageDrawable(ResUtils.getDrawable(this.f25252c, "wallet_base_payset_unchecked"));
        }
        return view;
    }

    public void setData(List<O2OBankInfo> list) {
        if (list != null) {
            this.f25250a.clear();
            this.f25250a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void setSelIndex(int i) {
        if (i > 0) {
            this.f25253d = i;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public O2OBankInfo getItem(int i) {
        if (i < 0 || i >= this.f25250a.size()) {
            return null;
        }
        return this.f25250a.get(i);
    }
}
