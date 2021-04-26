package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
/* loaded from: classes5.dex */
public class CertificateMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26868a = CertificateMenuView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public boolean f26869b;

    /* renamed from: c  reason: collision with root package name */
    public ListView f26870c;

    /* renamed from: d  reason: collision with root package name */
    public a f26871d;

    /* renamed from: e  reason: collision with root package name */
    public b f26872e;

    /* loaded from: classes5.dex */
    public class a extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public GetCardInfoResponse.CertificateTypeInfo[] f26875b;

        public a() {
        }

        public void a(GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
            this.f26875b = certificateTypeInfoArr;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr = this.f26875b;
            if (certificateTypeInfoArr != null) {
                return certificateTypeInfoArr.length;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            CertificateMenuItemView certificateMenuItemView;
            if (view == null) {
                certificateMenuItemView = new CertificateMenuItemView(CertificateMenuView.this.getContext());
            } else {
                certificateMenuItemView = (CertificateMenuItemView) view;
            }
            certificateMenuItemView.updateItem(this.f26875b[i2]);
            return certificateMenuItemView;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo);
    }

    @SuppressLint({"NewApi"})
    public CertificateMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26869b = false;
        a();
    }

    public String getBackgroundResId() {
        return "wallet_base_certifcate_dialog";
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        return null;
    }

    public String getMenuItemViewLayoutId() {
        return "wallet_base_menu_item_view";
    }

    public int getSeparatorColor() {
        return -1710619;
    }

    public void layoutMenu(GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        Log.d(f26868a, "layout menu view");
        a aVar = this.f26871d;
        if (aVar != null) {
            aVar.a(certificateTypeInfoArr);
            this.f26871d.notifyDataSetChanged();
            return;
        }
        a aVar2 = new a();
        this.f26871d = aVar2;
        aVar2.a(certificateTypeInfoArr);
        this.f26870c.setAdapter((ListAdapter) this.f26871d);
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
    }

    @Override // com.baidu.wallet.base.widget.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        this.f26869b = false;
    }

    public void setCertificertSelectListener(b bVar) {
        this.f26872e = bVar;
    }

    private void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
        this.f26870c = new ListView(getContext());
        int dip2px = DisplayUtils.dip2px(getContext(), 115.0f);
        this.f26870c.setDivider(new ColorDrawable(getSeparatorColor()));
        this.f26870c.setDividerHeight(1);
        this.f26870c.setSelector(new ColorDrawable(0));
        this.f26870c.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.wallet.paysdk.ui.widget.CertificateMenuView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (view != null && (view instanceof CertificateMenuItemView)) {
                    GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = ((CertificateMenuItemView) view).getCertificateTypeInfo();
                    if (CertificateMenuView.this.f26872e != null) {
                        CertificateMenuView.this.f26872e.a(certificateTypeInfo);
                    }
                }
            }
        });
        addView(this.f26870c, new LinearLayout.LayoutParams(dip2px, -2));
        setFocusableInTouchMode(true);
    }

    public CertificateMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26869b = false;
        a();
    }

    public CertificateMenuView(Context context) {
        super(context);
        this.f26869b = false;
        a();
    }
}
