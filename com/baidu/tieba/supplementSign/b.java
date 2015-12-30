package com.baidu.tieba.supplementSign;

import android.webkit.JsPromptResult;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.tbadkCore.e.b {
    final /* synthetic */ SupplementSignActivity dEj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SupplementSignActivity supplementSignActivity) {
        this.dEj = supplementSignActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        int i;
        int i2;
        if ("SupplementSignInterface".equalsIgnoreCase(str) && "signSuccess".equalsIgnoreCase(str2)) {
            if (!StringUtils.isNull(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    this.dEj.dEf = jSONObject.optInt("all");
                    SupplementSignActivity supplementSignActivity = this.dEj;
                    i = supplementSignActivity.dEg;
                    supplementSignActivity.dEg = i + jSONObject.optInt("signed", 0);
                    SupplementSignActivity supplementSignActivity2 = this.dEj;
                    i2 = supplementSignActivity2.dEh;
                    supplementSignActivity2.dEh = jSONObject.optInt("bonus", 0) + i2;
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
