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
    public TextView f26225a;

    /* renamed from: b  reason: collision with root package name */
    public GetCardInfoResponse.CertificateTypeInfo f26226b;

    public CertificateMenuItemView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_menu_cert_item_view"), this);
        this.f26225a = (TextView) findViewById(ResUtils.id(getContext(), "certi_text"));
    }

    public GetCardInfoResponse.CertificateTypeInfo getCertificateTypeInfo() {
        return this.f26226b;
    }

    public void updateItem(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        if (certificateTypeInfo == null) {
            return;
        }
        this.f26226b = certificateTypeInfo;
        this.f26225a.setTextColor(ResUtils.getColor(getContext(), certificateTypeInfo.isDisplay() ? "wallet_base_mainColor" : "wallet_base_font_text2Color"));
        this.f26225a.setText(certificateTypeInfo.description);
    }
}
