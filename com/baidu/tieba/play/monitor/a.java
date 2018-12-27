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
    private String biz;
    private i gFA;
    private String gFP;

    public a(String str, String str2, i iVar) {
        this.biz = str;
        this.gFP = str2;
        this.gFA = iVar;
    }

    @Override // com.baidu.tieba.j.e.a
    public void rT(int i) {
        if (i == 1) {
            am amVar = new am("c12620");
            amVar.x("obj_locate", 1);
            amVar.aA("tid", this.biz);
            TiebaStatic.log(amVar);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
            httpMessage.addParam("thread_id", this.biz);
            httpMessage.addParam(WebVideoActivityConfig.KEY_VIDEO_URL, this.gFP);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.gFA != null) {
                this.gFA.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.j.b
                    public void ao(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void ap(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void aq(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void onChange(final boolean z) {
        am amVar = new am("c12621");
        amVar.x("obj_locate", 1);
        amVar.x("obj_param1", z ? 1 : 0);
        amVar.aA("tid", this.biz);
        TiebaStatic.log(amVar);
        if (this.gFA != null) {
            this.gFA.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.j.b
                public void ao(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void ap(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void aq(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void jR(boolean z) {
    }
}
