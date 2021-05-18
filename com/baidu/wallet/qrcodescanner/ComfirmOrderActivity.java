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
    public static a f26418g;

    /* renamed from: a  reason: collision with root package name */
    public QRCodeShortUrlResponse.OrderParam f26419a;

    /* renamed from: b  reason: collision with root package name */
    public Button f26420b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26421c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26422d;

    /* renamed from: e  reason: collision with root package name */
    public String f26423e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26424f;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public static void ComfirmScanOrderInfo(Context context, QRCodeShortUrlResponse.OrderParam orderParam, String str, a aVar) {
        Intent intent = new Intent();
        f26418g = aVar;
        intent.setClass(context, ComfirmOrderActivity.class);
        intent.putExtra("orderinfo", orderParam);
        intent.putExtra(IMConstants.SERVICE_TYPE_ORDER, str);
        context.startActivity(intent);
    }

    private void a() {
        if (this.f26419a != null) {
            TextView textView = this.f26421c;
            textView.setText(ResUtils.getString(getActivity(), "wallet_base_unit") + StringUtils.fen2Yuan(this.f26419a.total_amount));
            this.f26422d.setText(this.f26419a.goods_name);
            this.f26424f.setText(this.f26419a.sp_name);
        }
    }

    public static void onOrderComfirm(boolean z) {
        a aVar = f26418g;
        if (aVar != null) {
            if (!z) {
                aVar.b();
            } else {
                aVar.a();
            }
            f26418g = null;
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
        if (view == this.f26420b) {
            BaiduPayDelegate.getInstance().doPay(getActivity(), this.f26423e, new PayCallBack() { // from class: com.baidu.wallet.qrcodescanner.ComfirmOrderActivity.1
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
                this.f26419a = (QRCodeShortUrlResponse.OrderParam) serializable;
            }
            this.f26423e = bundle.getString(IMConstants.SERVICE_TYPE_ORDER);
        } else if (getIntent() != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("orderinfo");
            if (serializableExtra != null && (serializableExtra instanceof QRCodeShortUrlResponse.OrderParam)) {
                this.f26419a = (QRCodeShortUrlResponse.OrderParam) serializableExtra;
            }
            this.f26423e = getIntent().getStringExtra(IMConstants.SERVICE_TYPE_ORDER);
        }
        this.f26421c = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_price"));
        this.f26422d = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_sp"));
        this.f26424f = (TextView) findViewById(ResUtils.id(getActivity(), "wallet_order_pay"));
        Button button = (Button) findViewById(ResUtils.id(getActivity(), "ebpay_to_pay"));
        this.f26420b = button;
        button.setOnClickListener(this);
        a();
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("orderinfo", this.f26419a);
        bundle.putString(IMConstants.SERVICE_TYPE_ORDER, this.f26423e);
        super.onSaveInstanceState(bundle);
    }
}
