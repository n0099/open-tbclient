package com.baidu.yuyinala.more;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static a okC;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData okD = new AlaMoreFunctionDialogData();
    private b okE;

    private a() {
    }

    public static a ebf() {
        if (okC == null) {
            synchronized (a.class) {
                if (okC == null) {
                    okC = new a();
                }
            }
        }
        return okC;
    }

    public void X(w wVar) {
        if (wVar != null) {
            if (this.okE == null || !this.okE.isShowing()) {
                this.okD.parseData(wVar.aIR);
                this.okD.setLiveId(wVar.mLiveInfo == null ? null : String.valueOf(wVar.mLiveInfo.live_id));
                this.okD.setRoomId(wVar.aIS == null ? null : wVar.aIS.aRy);
                this.okD.setCustomRoomId(wVar.aIS == null ? null : wVar.aIS.croom_id);
                this.okD.setGroupId(wVar.mLiveInfo != null ? String.valueOf(wVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, com.baidu.live.c.c cVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.okE = null;
        }
        if (this.okE == null) {
            this.okE = new b(tbPageContext, this.okD);
            this.okE.a(cVar);
        } else {
            this.okE.a((b) this.okD);
        }
        this.okE.show();
        ebg();
    }

    private void ebg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.okD != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.okD.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aE(boolean z, boolean z2) {
        this.okD.setShowFirstCharge(z, z2);
    }

    public void GU() {
        if (this.okE != null && this.okE.isShowing()) {
            this.okE.dismiss();
        }
    }
}
