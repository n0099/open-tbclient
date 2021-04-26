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
    public static a f27173g;

    /* renamed from: a  reason: collision with root package name */
    public QRCodeShortUrlResponse.OrderParam f27174a;

    /* renamed from: b  reason: collision with root package name */
    public Button f27175b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f27176c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f27177d;

    /* renamed from: e  reason: collision with root package name */
    public String f27178e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27179f;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public static void ComfirmScanOrderInfo(Context context, QRCodeShortUrlResponse.OrderParam orderParam, String str, a aVar) {
        Intent intent = new Intent();
        f27173g = aVar;
        intent.setClass(context, ComfirmOrderActivity.class);
        intent.putExtra("orderinfo", orderParam);
        intent.putExtra(IMConstants.SERVICE_TYPE_ORDER, str);
        context.startActivity(intent);
    }

    private void a() {
        if (this.f27174a != null) {
            TextView textView = this.f27176c;
            textView.setText(ResUtils.getString(getActivity(), "wallet_base_unit") + StringUtils.fen2Yuan(this.f27174a.total_amount));
            this.f27177d.setText(this.f27174a.goods_name);
            this.f27179f.setText(this.f27174a.sp_name);
        }
    }

    public static void onOrderComfirm(boolean z) {
        a aVar = f27173g;
        if (aVar != null) {
            if (!z) {
                aVar.b();
            } else {
                aVar.a();
            }
            f27173g = null;
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        onOrderComfirm(false);
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f27175b) {
            BaiduPayDelegate.getInstance().doPay(getActivity(), this.f27178e, new PayCallBack() { // from class: com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.1
                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    return false;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(int i2, String str) {
                    if (i2 == 0) {
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

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ResUtils.layout(getActivity(), "wallet_qrscanner_confirm_pay"));
        initActionBar("wallet_confirm_order_title");
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("orderinfo");
            if (serializable != null && (serializable instanceof QRCodeShortUrlResponse.OrderParam)) {
                this.f27174a = (QRCodeShortUrlResponse.OrderParam) serializable;
            }
            this.f27178e = bundle.getString(IMConstants.SERVICE_TYPE_ORDER);
        } else if (getIntent() != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("orderinfo");
            if (serializableExtra != null && (serializableExtra instanceof QRCodeShortUrlResponse.OrderParam)) {
                this.f27174a = (QRCodeShortUrlResponse.OrderParam) serializableExtra;
            }
            this.f27178e = getIntent().getStringExtra(IMConstants.SERVICE_TYPE_ORDER);
        }
        this.f27176c = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_price"));
        this.f27177d = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_sp"));
        this.f27179f = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_pay"));
        Button button = (Button) findViewById(ResUtils.id(getActivity(), "ebpay_to_pay"));
        this.f27175b = button;
        button.setOnClickListener(this);
        a();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("orderinfo", this.f27174a);
        bundle.putString(IMConstants.SERVICE_TYPE_ORDER, this.f27178e);
        super.onSaveInstanceState(bundle);
    }
}
