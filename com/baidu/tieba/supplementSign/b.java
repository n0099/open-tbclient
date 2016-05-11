package com.baidu.tieba.supplementSign;

import android.webkit.JsPromptResult;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.tbadkCore.e.b {
    final /* synthetic */ SupplementSignActivity epZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SupplementSignActivity supplementSignActivity) {
        this.epZ = supplementSignActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        int i;
        int i2;
        if ("SupplementSignInterface".equalsIgnoreCase(str) && "signSuccess".equalsIgnoreCase(str2)) {
            if (!StringUtils.isNull(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    this.epZ.epV = jSONObject.optInt("all");
                    SupplementSignActivity supplementSignActivity = this.epZ;
                    i = supplementSignActivity.epW;
                    supplementSignActivity.epW = i + jSONObject.optInt("signed", 0);
                    SupplementSignActivity supplementSignActivity2 = this.epZ;
                    i2 = supplementSignActivity2.epX;
                    supplementSignActivity2.epX = jSONObject.optInt("bonus", 0) + i2;
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
