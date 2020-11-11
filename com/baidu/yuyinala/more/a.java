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
    private static a otZ;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData oua = new AlaMoreFunctionDialogData();
    private b oub;

    private a() {
    }

    public static a eeU() {
        if (otZ == null) {
            synchronized (a.class) {
                if (otZ == null) {
                    otZ = new a();
                }
            }
        }
        return otZ;
    }

    public void ax(w wVar) {
        if (wVar != null) {
            if (this.oub == null || !this.oub.isShowing()) {
                this.oua.parseData(wVar.aJI);
                this.oua.setLiveId(wVar.mLiveInfo == null ? null : String.valueOf(wVar.mLiveInfo.live_id));
                this.oua.setRoomId(wVar.aJK == null ? null : wVar.aJK.aSP);
                this.oua.setCustomRoomId(wVar.aJK == null ? null : wVar.aJK.croom_id);
                this.oua.setGroupId(wVar.mLiveInfo != null ? String.valueOf(wVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, com.baidu.live.c.c cVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oub = null;
        }
        if (this.oub == null) {
            this.oub = new b(tbPageContext, this.oua);
            this.oub.a(cVar);
        } else {
            this.oub.a((b) this.oua);
        }
        this.oub.show();
        eeV();
    }

    private void eeV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oua != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oua.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aE(boolean z, boolean z2) {
        this.oua.setShowFirstCharge(z, z2);
    }

    public void Hv() {
        if (this.oub != null && this.oub.isShowing()) {
            this.oub.dismiss();
        }
    }
}
