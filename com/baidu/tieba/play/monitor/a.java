package com.baidu.tieba.play.monitor;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.i.e;
import com.baidu.tieba.i.i;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements e.a {
    private String bCS;
    private i gtH;
    private String gtW;

    public a(String str, String str2, i iVar) {
        this.bCS = str;
        this.gtW = str2;
        this.gtH = iVar;
    }

    @Override // com.baidu.tieba.i.e.a
    public void sh(int i) {
        if (i == 1) {
            ak akVar = new ak("c12620");
            akVar.s("obj_locate", 1);
            akVar.ab("tid", this.bCS);
            TiebaStatic.log(akVar);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
            httpMessage.addParam("thread_id", this.bCS);
            httpMessage.addParam(WebVideoActivityConfig.KEY_VIDEO_URL, this.gtW);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.gtH != null) {
                this.gtH.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.i.b
                    public void M(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.i.b
                    public void N(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.i.b
                    public void O(JSONObject jSONObject) throws JSONException {
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
        akVar.ab("tid", this.bCS);
        TiebaStatic.log(akVar);
        if (this.gtH != null) {
            this.gtH.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.i.b
                public void M(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void N(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void O(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.i.e.a
    public void jh(boolean z) {
    }
}
