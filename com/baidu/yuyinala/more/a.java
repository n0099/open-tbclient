package com.baidu.yuyinala.more;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static a oQY;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData oQZ = new AlaMoreFunctionDialogData();
    private b oRa;

    private a() {
    }

    public static a ekP() {
        if (oQY == null) {
            synchronized (a.class) {
                if (oQY == null) {
                    oQY = new a();
                }
            }
        }
        return oQY;
    }

    public void aP(x xVar) {
        if (xVar != null) {
            if (this.oRa == null || !this.oRa.isShowing()) {
                this.oQZ.parseData(xVar.aLj);
                this.oQZ.setLiveId(xVar.mLiveInfo == null ? null : String.valueOf(xVar.mLiveInfo.live_id));
                this.oQZ.setRoomId(xVar.aLl == null ? null : xVar.aLl.aVu);
                this.oQZ.setCustomRoomId(xVar.aLl == null ? null : xVar.aLl.croom_id);
                this.oQZ.setGroupId(xVar.mLiveInfo != null ? String.valueOf(xVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, com.baidu.live.e.c cVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oRa = null;
        }
        if (this.oQZ != null && !ListUtils.isEmpty(this.oQZ.getGroupList())) {
            if (this.oRa == null) {
                this.oRa = new b(tbPageContext, this.oQZ);
                this.oRa.a(cVar);
            } else {
                this.oRa.a((b) this.oQZ);
            }
            this.oRa.show();
            ekQ();
        }
    }

    private void ekQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oQZ != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oQZ.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aG(boolean z, boolean z2) {
        this.oQZ.setShowFirstCharge(z, z2);
    }

    public void If() {
        if (this.oRa != null && this.oRa.isShowing()) {
            this.oRa.dismiss();
        }
    }
}
