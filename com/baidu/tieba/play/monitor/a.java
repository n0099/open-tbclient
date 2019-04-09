package com.baidu.tieba.play.monitor;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.j.e;
import com.baidu.tieba.j.i;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements e.a {
    private String ctx;
    private String hWJ;
    private i hWu;

    public a(String str, String str2, i iVar) {
        this.ctx = str;
        this.hWJ = str2;
        this.hWu = iVar;
    }

    @Override // com.baidu.tieba.j.e.a
    public void vA(int i) {
        if (i == 1) {
            am amVar = new am("c12620");
            amVar.T("obj_locate", 1);
            amVar.bJ("tid", this.ctx);
            TiebaStatic.log(amVar);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
            httpMessage.addParam("thread_id", this.ctx);
            httpMessage.addParam(WebVideoActivityConfig.KEY_VIDEO_URL, this.hWJ);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.hWu != null) {
                this.hWu.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.j.b
                    public void bx(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void by(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void bz(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void onChange(final boolean z) {
        am amVar = new am("c12621");
        amVar.T("obj_locate", 1);
        amVar.T("obj_param1", z ? 1 : 0);
        amVar.bJ("tid", this.ctx);
        TiebaStatic.log(amVar);
        if (this.hWu != null) {
            this.hWu.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.j.b
                public void bx(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void by(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void bz(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void ms(boolean z) {
    }
}
