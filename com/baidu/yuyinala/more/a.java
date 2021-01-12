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
/* loaded from: classes10.dex */
public class a {
    private static a oMw;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData oMx = new AlaMoreFunctionDialogData();
    private b oMy;

    private a() {
    }

    public static a egW() {
        if (oMw == null) {
            synchronized (a.class) {
                if (oMw == null) {
                    oMw = new a();
                }
            }
        }
        return oMw;
    }

    public void aP(x xVar) {
        if (xVar != null) {
            if (this.oMy == null || !this.oMy.isShowing()) {
                this.oMx.parseData(xVar.aGw);
                this.oMx.setLiveId(xVar.mLiveInfo == null ? null : String.valueOf(xVar.mLiveInfo.live_id));
                this.oMx.setRoomId(xVar.aGy == null ? null : xVar.aGy.aQH);
                this.oMx.setCustomRoomId(xVar.aGy == null ? null : xVar.aGy.croom_id);
                this.oMx.setGroupId(xVar.mLiveInfo != null ? String.valueOf(xVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, com.baidu.live.e.c cVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oMy = null;
        }
        if (this.oMx != null && !ListUtils.isEmpty(this.oMx.getGroupList())) {
            if (this.oMy == null) {
                this.oMy = new b(tbPageContext, this.oMx);
                this.oMy.a(cVar);
            } else {
                this.oMy.a((b) this.oMx);
            }
            this.oMy.show();
            egX();
        }
    }

    private void egX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oMx != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oMx.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aG(boolean z, boolean z2) {
        this.oMx.setShowFirstCharge(z, z2);
    }

    public void Ek() {
        if (this.oMy != null && this.oMy.isShowing()) {
            this.oMy.dismiss();
        }
    }
}
