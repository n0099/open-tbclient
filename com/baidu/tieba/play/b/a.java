package com.baidu.tieba.play.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.i.e;
import com.baidu.tieba.i.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements e.a {
    private String bAT;
    private i grR;
    private String gsg;

    public a(String str, String str2, i iVar) {
        this.bAT = str;
        this.gsg = str2;
        this.grR = iVar;
    }

    @Override // com.baidu.tieba.i.e.a
    public void sd(int i) {
        if (i == 1) {
            ak akVar = new ak("c12620");
            akVar.s("obj_locate", 1);
            akVar.ab("tid", this.bAT);
            TiebaStatic.log(akVar);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
            httpMessage.addParam("thread_id", this.bAT);
            httpMessage.addParam("video_url", this.gsg);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.grR != null) {
                this.grR.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.b.a.1
                    @Override // com.baidu.tieba.i.b
                    public void H(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.i.b
                    public void I(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.i.b
                    public void J(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.i.e.a
    public void onChange(final boolean z) {
        ak akVar = new ak("c12621");
        akVar.s("obj_locate", 1);
        akVar.s("obj_param1", z ? 1 : 0);
        akVar.ab("tid", this.bAT);
        TiebaStatic.log(akVar);
        if (this.grR != null) {
            this.grR.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.b.a.2
                @Override // com.baidu.tieba.i.b
                public void H(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void I(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void J(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.i.e.a
    public void iV(boolean z) {
    }
}
