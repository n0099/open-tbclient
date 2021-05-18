package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
/* loaded from: classes5.dex */
public class CertificateMenuItemView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f26111a;

    /* renamed from: b  reason: collision with root package name */
    public GetCardInfoResponse.CertificateTypeInfo f26112b;

    public CertificateMenuItemView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_menu_cert_item_view"), this);
        this.f26111a = (TextView) findViewById(ResUtils.id(getContext(), "certi_text"));
    }

    public GetCardInfoResponse.CertificateTypeInfo getCertificateTypeInfo() {
        return this.f26112b;
    }

    public void updateItem(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        if (certificateTypeInfo == null) {
            return;
        }
        this.f26112b = certificateTypeInfo;
        this.f26111a.setTextColor(ResUtils.getColor(getContext(), certificateTypeInfo.isDisplay() ? "wallet_base_mainColor" : "wallet_base_font_text2Color"));
        this.f26111a.setText(certificateTypeInfo.description);
    }
}
