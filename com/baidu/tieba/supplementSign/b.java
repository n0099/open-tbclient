package com.baidu.tieba.supplementSign;

import android.webkit.JsPromptResult;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.tbadkCore.e.b {
    final /* synthetic */ SupplementSignActivity emK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SupplementSignActivity supplementSignActivity) {
        this.emK = supplementSignActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        int i;
        int i2;
        if ("SupplementSignInterface".equalsIgnoreCase(str) && "signSuccess".equalsIgnoreCase(str2)) {
            if (!StringUtils.isNull(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    this.emK.emG = jSONObject.optInt("all");
                    SupplementSignActivity supplementSignActivity = this.emK;
                    i = supplementSignActivity.emH;
                    supplementSignActivity.emH = i + jSONObject.optInt("signed", 0);
                    SupplementSignActivity supplementSignActivity2 = this.emK;
                    i2 = supplementSignActivity2.emI;
                    supplementSignActivity2.emI = jSONObject.optInt("bonus", 0) + i2;
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
