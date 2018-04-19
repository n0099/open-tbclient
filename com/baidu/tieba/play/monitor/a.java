package com.baidu.tieba.play.monitor;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.j.e;
import com.baidu.tieba.j.i;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements e.a {
    private String aNu;
    private i fOJ;
    private String fOY;

    public a(String str, String str2, i iVar) {
        this.aNu = str;
        this.fOY = str2;
        this.fOJ = iVar;
    }

    @Override // com.baidu.tieba.j.e.a
    public void pC(int i) {
        if (i == 1) {
            al alVar = new al("c12620");
            alVar.r("obj_locate", 1);
            alVar.ac("tid", this.aNu);
            TiebaStatic.log(alVar);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
            httpMessage.addParam("thread_id", this.aNu);
            httpMessage.addParam(WebVideoActivityConfig.KEY_VIDEO_URL, this.fOY);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.fOJ != null) {
                this.fOJ.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.j.b
                    public void P(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void Q(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void R(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void onChange(final boolean z) {
        al alVar = new al("c12621");
        alVar.r("obj_locate", 1);
        alVar.r("obj_param1", z ? 1 : 0);
        alVar.ac("tid", this.aNu);
        TiebaStatic.log(alVar);
        if (this.fOJ != null) {
            this.fOJ.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.j.b
                public void P(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void Q(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void R(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void iI(boolean z) {
    }
}
