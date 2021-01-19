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
    private static a oMx;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData oMy = new AlaMoreFunctionDialogData();
    private b oMz;

    private a() {
    }

    public static a egW() {
        if (oMx == null) {
            synchronized (a.class) {
                if (oMx == null) {
                    oMx = new a();
                }
            }
        }
        return oMx;
    }

    public void aP(x xVar) {
        if (xVar != null) {
            if (this.oMz == null || !this.oMz.isShowing()) {
                this.oMy.parseData(xVar.aGw);
                this.oMy.setLiveId(xVar.mLiveInfo == null ? null : String.valueOf(xVar.mLiveInfo.live_id));
                this.oMy.setRoomId(xVar.aGy == null ? null : xVar.aGy.aQH);
                this.oMy.setCustomRoomId(xVar.aGy == null ? null : xVar.aGy.croom_id);
                this.oMy.setGroupId(xVar.mLiveInfo != null ? String.valueOf(xVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, com.baidu.live.e.c cVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oMz = null;
        }
        if (this.oMy != null && !ListUtils.isEmpty(this.oMy.getGroupList())) {
            if (this.oMz == null) {
                this.oMz = new b(tbPageContext, this.oMy);
                this.oMz.a(cVar);
            } else {
                this.oMz.a((b) this.oMy);
            }
            this.oMz.show();
            egX();
        }
    }

    private void egX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oMy != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oMy.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aG(boolean z, boolean z2) {
        this.oMy.setShowFirstCharge(z, z2);
    }

    public void Ek() {
        if (this.oMz != null && this.oMz.isShowing()) {
            this.oMz.dismiss();
        }
    }
}
