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
    private static a oWD;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData oWE = new AlaMoreFunctionDialogData();
    private b oWF;

    private a() {
    }

    public static a ejo() {
        if (oWD == null) {
            synchronized (a.class) {
                if (oWD == null) {
                    oWD = new a();
                }
            }
        }
        return oWD;
    }

    public void aS(ab abVar) {
        if (abVar != null) {
            if (this.oWF == null || !this.oWF.isShowing()) {
                this.oWE.parseData(abVar.aIS);
                this.oWE.setLiveId(abVar.mLiveInfo == null ? null : String.valueOf(abVar.mLiveInfo.live_id));
                this.oWE.setRoomId(abVar.aIU == null ? null : abVar.aIU.aTK);
                this.oWE.setCustomRoomId(abVar.aIU == null ? null : abVar.aIU.croom_id);
                this.oWE.setGroupId(abVar.mLiveInfo != null ? String.valueOf(abVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, e eVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oWF = null;
        }
        if (this.oWE != null && !ListUtils.isEmpty(this.oWE.getGroupList())) {
            if (this.oWF == null) {
                this.oWF = new b(tbPageContext, this.oWE);
                this.oWF.a(eVar);
            } else {
                this.oWF.a((b) this.oWE);
            }
            this.oWF.show();
            ejp();
        }
    }

    private void ejp() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oWE != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oWE.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aG(boolean z, boolean z2) {
        this.oWE.setShowFirstCharge(z, z2);
    }

    public void FA() {
        if (this.oWF != null && this.oWF.isShowing()) {
            this.oWF.dismiss();
        }
    }
}
