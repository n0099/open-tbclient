package com.baidu.wallet.qrcodescanner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.core.beans.BeanActivity;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.qrcodescanner.datamodel.QRCodeShortUrlResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class ComfirmOrderActivity extends BeanActivity implements View.OnClickListener {

    /* renamed from: g  reason: collision with root package name */
    public static a f26673g;

    /* renamed from: a  reason: collision with root package name */
    public QRCodeShortUrlResponse.OrderParam f26674a;

    /* renamed from: b  reason: collision with root package name */
    public Button f26675b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26676c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26677d;

    /* renamed from: e  reason: collision with root package name */
    public String f26678e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26679f;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public static void ComfirmScanOrderInfo(Context context, QRCodeShortUrlResponse.OrderParam orderParam, String str, a aVar) {
        Intent intent = new Intent();
        f26673g = aVar;
        intent.setClass(context, ComfirmOrderActivity.class);
        intent.putExtra("orderinfo", orderParam);
        intent.putExtra(IMConstants.SERVICE_TYPE_ORDER, str);
        context.startActivity(intent);
    }

    private void a() {
        if (this.f26674a != null) {
            TextView textView = this.f26676c;
            textView.setText(ResUtils.getString(getActivity(), "wallet_base_unit") + StringUtils.fen2Yuan(this.f26674a.total_amount));
            this.f26677d.setText(this.f26674a.goods_name);
            this.f26679f.setText(this.f26674a.sp_name);
        }
    }

    public static void onOrderComfirm(boolean z) {
        a aVar = f26673g;
        if (aVar != null) {
            if (!z) {
                aVar.b();
            } else {
                aVar.a();
            }
            f26673g = null;
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        onOrderComfirm(false);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f26675b) {
            BaiduPayDelegate.getInstance().doPay(getActivity(), this.f26678e, new PayCallBack() { // from class: com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.1
                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    return false;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(int i, String str) {
                    if (i == 0) {
                        ComfirmOrderActivity.this.finish();
                        ComfirmOrderActivity.onOrderComfirm(true);
                        return;
                    }
                    ComfirmOrderActivity.this.finish();
                    ComfirmOrderActivity.onOrderComfirm(false);
                }
            });
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getActivity(), "wallet_qrscanner_confirm_pay"));
        initActionBar("wallet_confirm_order_title");
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("orderinfo");
            if (serializable != null && (serializable instanceof QRCodeShortUrlResponse.OrderParam)) {
                this.f26674a = (QRCodeShortUrlResponse.OrderParam) serializable;
            }
            this.f26678e = bundle.getString(IMConstants.SERVICE_TYPE_ORDER);
        } else if (getIntent() != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("orderinfo");
            if (serializableExtra != null && (serializableExtra instanceof QRCodeShortUrlResponse.OrderParam)) {
                this.f26674a = (QRCodeShortUrlResponse.OrderParam) serializableExtra;
            }
            this.f26678e = getIntent().getStringExtra(IMConstants.SERVICE_TYPE_ORDER);
        }
        this.f26676c = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_price"));
        this.f26677d = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_sp"));
        this.f26679f = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_pay"));
        Button button = (Button) findViewById(ResUtils.id(getActivity(), "ebpay_to_pay"));
        this.f26675b = button;
        button.setOnClickListener(this);
        a();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("orderinfo", this.f26674a);
        bundle.putString(IMConstants.SERVICE_TYPE_ORDER, this.f26678e);
        super.onSaveInstanceState(bundle);
    }
}
