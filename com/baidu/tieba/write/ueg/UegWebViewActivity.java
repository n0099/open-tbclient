package com.baidu.tieba.write.ueg;

import android.os.Bundle;
import android.webkit.JsPromptResult;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tbadkCore.e.b;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
/* loaded from: classes2.dex */
public class UegWebViewActivity extends TbWebViewActivity {
    @Override // com.baidu.tbadk.browser.TbWebViewActivity, com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addJsPromptInterface(new a());
    }

    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mView != null) {
            this.mView.vR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.browser.BaseWebViewActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mWebView != null) {
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements b {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.e.b
        public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if ("CommonJSBridge".equals(str)) {
                if ("callNativeSMS".equals(str2)) {
                    ur(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("copyToClipboard".equals(str2)) {
                    aE(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else if ("setBlockPopInfo".equals(str2)) {
                    us(str3);
                    jsPromptResult.confirm("1");
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void ur(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                UtilHelper.smsTo(UegWebViewActivity.this.getActivity(), jSONObject.optString("phoneNumber"), jSONObject.optString("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void aE(String str) {
            try {
                com.baidu.adp.lib.util.a.aE(new JSONObject(str).optString("content"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void us(String str) {
            try {
                BlockPopInfo.Builder builder = new BlockPopInfo.Builder();
                JSONObject jSONObject = new JSONObject(str);
                builder.can_post = Integer.valueOf(jSONObject.optInt("can_post"));
                builder.block_info = jSONObject.optString("block_info");
                builder.ahead_info = jSONObject.optString("ahead_info");
                builder.ahead_url = jSONObject.optString("ahead_url");
                builder.ok_info = jSONObject.optString("ok_info");
                builder.ahead_type = Integer.valueOf(jSONObject.optInt("ahead_type"));
                BlockPopInfo build = builder.build(false);
                com.baidu.tieba.p.a.d(build);
                com.baidu.tieba.p.a.e(build);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
