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
    private String aZG;
    private i gmQ;
    private String gnf;

    public a(String str, String str2, i iVar) {
        this.aZG = str;
        this.gnf = str2;
        this.gmQ = iVar;
    }

    @Override // com.baidu.tieba.j.e.a
    public void qv(int i) {
        if (i == 1) {
            am amVar = new am("c12620");
            amVar.w("obj_locate", 1);
            amVar.al("tid", this.aZG);
            TiebaStatic.log(amVar);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
            httpMessage.addParam("thread_id", this.aZG);
            httpMessage.addParam(WebVideoActivityConfig.KEY_VIDEO_URL, this.gnf);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.gmQ != null) {
                this.gmQ.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.j.b
                    public void ac(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void ad(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void ae(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void onChange(final boolean z) {
        am amVar = new am("c12621");
        amVar.w("obj_locate", 1);
        amVar.w("obj_param1", z ? 1 : 0);
        amVar.al("tid", this.aZG);
        TiebaStatic.log(amVar);
        if (this.gmQ != null) {
            this.gmQ.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.j.b
                public void ac(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void ad(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void ae(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void jj(boolean z) {
    }
}
