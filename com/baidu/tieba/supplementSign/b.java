package com.baidu.tieba.supplementSign;

import android.webkit.JsPromptResult;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.tbadkCore.e.b {
    final /* synthetic */ SupplementSignActivity dUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SupplementSignActivity supplementSignActivity) {
        this.dUk = supplementSignActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        int i;
        int i2;
        if ("SupplementSignInterface".equalsIgnoreCase(str) && "signSuccess".equalsIgnoreCase(str2)) {
            if (!StringUtils.isNull(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    this.dUk.dUg = jSONObject.optInt("all");
                    SupplementSignActivity supplementSignActivity = this.dUk;
                    i = supplementSignActivity.dUh;
                    supplementSignActivity.dUh = i + jSONObject.optInt("signed", 0);
                    SupplementSignActivity supplementSignActivity2 = this.dUk;
                    i2 = supplementSignActivity2.dUi;
                    supplementSignActivity2.dUi = jSONObject.optInt("bonus", 0) + i2;
                } catch (Throwable th) {
                    BdLog.e(th);
                }
            }
            jsPromptResult.confirm();
            return true;
        }
        return false;
    }
}
