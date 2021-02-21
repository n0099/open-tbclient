package com.baidu.yuyinala.more;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.audiolive.e;
import com.baidu.live.data.ab;
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
    private static a oXd;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData oXe = new AlaMoreFunctionDialogData();
    private b oXf;

    private a() {
    }

    public static a ejw() {
        if (oXd == null) {
            synchronized (a.class) {
                if (oXd == null) {
                    oXd = new a();
                }
            }
        }
        return oXd;
    }

    public void aS(ab abVar) {
        if (abVar != null) {
            if (this.oXf == null || !this.oXf.isShowing()) {
                this.oXe.parseData(abVar.aIS);
                this.oXe.setLiveId(abVar.mLiveInfo == null ? null : String.valueOf(abVar.mLiveInfo.live_id));
                this.oXe.setRoomId(abVar.aIU == null ? null : abVar.aIU.aTK);
                this.oXe.setCustomRoomId(abVar.aIU == null ? null : abVar.aIU.croom_id);
                this.oXe.setGroupId(abVar.mLiveInfo != null ? String.valueOf(abVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, e eVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oXf = null;
        }
        if (this.oXe != null && !ListUtils.isEmpty(this.oXe.getGroupList())) {
            if (this.oXf == null) {
                this.oXf = new b(tbPageContext, this.oXe);
                this.oXf.a(eVar);
            } else {
                this.oXf.a((b) this.oXe);
            }
            this.oXf.show();
            ejx();
        }
    }

    private void ejx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oXe != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oXe.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aG(boolean z, boolean z2) {
        this.oXe.setShowFirstCharge(z, z2);
    }

    public void FA() {
        if (this.oXf != null && this.oXf.isShowing()) {
            this.oXf.dismiss();
        }
    }
}
