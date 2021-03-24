package com.baidu.wallet.scheme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class WalletSchemeActivity extends PayBaseBeanActivity {
    public String order;

    /* loaded from: classes5.dex */
    public static class SchemeOrder implements NoProguard, Serializable {
        public static final long serialVersionUID = -237137357302783447L;
        public Orderinfo kBWParameters;

        /* loaded from: classes5.dex */
        public static class Orderinfo implements NoProguard, Serializable {
            public static final long serialVersionUID = 7620618282105798227L;
            public String kBWPayInfoOrder;
        }
    }

    private void a(Intent intent) {
        Uri uri;
        if (intent == null) {
            finish();
            return;
        }
        try {
            uri = intent.getData();
        } catch (Exception unused) {
            uri = null;
        }
        if (uri == null) {
            finish();
            return;
        }
        String fragment = uri.getFragment();
        if (fragment == null) {
            finish();
            return;
        }
        String replace = fragment.replace("www.baifubao.com/pay#", "").replace("www.dxmpay.com/pay#", "");
        LogUtil.d("King", "fragment: " + uri.getFragment());
        LogUtil.d("King", "scheme: " + uri.getScheme());
        LogUtil.d("King", "scheme specific part : " + uri.getSchemeSpecificPart());
        LogUtil.d("King", "path : " + uri.getPath());
        LogUtil.d("King", "last path segment : " + uri.getLastPathSegment());
        LogUtil.d("King", "host : " + uri.getHost());
        LogUtil.d("King", "uri : " + uri.toString());
        if (TextUtils.isEmpty(replace)) {
            finish();
            return;
        }
        try {
            String str = new String(Base64Utils.decode(replace));
            if (TextUtils.isEmpty(str)) {
                finish();
                return;
            }
            SchemeOrder schemeOrder = (SchemeOrder) JsonUtils.fromJson(str, SchemeOrder.class);
            if (schemeOrder == null || schemeOrder.kBWParameters == null || TextUtils.isEmpty(schemeOrder.kBWParameters.kBWPayInfoOrder)) {
                return;
            }
            BaiduPayDelegate.getInstance().doPay(this, schemeOrder.kBWParameters.kBWPayInfoOrder, null);
            finish();
        } catch (Exception unused2) {
            finish();
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }
}
