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
    private static a ovD;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData ovE = new AlaMoreFunctionDialogData();
    private b ovF;

    private a() {
    }

    public static a eeS() {
        if (ovD == null) {
            synchronized (a.class) {
                if (ovD == null) {
                    ovD = new a();
                }
            }
        }
        return ovD;
    }

    public void ax(w wVar) {
        if (wVar != null) {
            if (this.ovF == null || !this.ovF.isShowing()) {
                this.ovE.parseData(wVar.aHX);
                this.ovE.setLiveId(wVar.mLiveInfo == null ? null : String.valueOf(wVar.mLiveInfo.live_id));
                this.ovE.setRoomId(wVar.aHZ == null ? null : wVar.aHZ.aRe);
                this.ovE.setCustomRoomId(wVar.aHZ == null ? null : wVar.aHZ.croom_id);
                this.ovE.setGroupId(wVar.mLiveInfo != null ? String.valueOf(wVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, com.baidu.live.c.c cVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.ovF = null;
        }
        if (this.ovF == null) {
            this.ovF = new b(tbPageContext, this.ovE);
            this.ovF.a(cVar);
        } else {
            this.ovF.a((b) this.ovE);
        }
        this.ovF.show();
        eeT();
    }

    private void eeT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.ovE != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ovE.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aC(boolean z, boolean z2) {
        this.ovE.setShowFirstCharge(z, z2);
    }

    public void GM() {
        if (this.ovF != null && this.ovF.isShowing()) {
            this.ovF.dismiss();
        }
    }
}
