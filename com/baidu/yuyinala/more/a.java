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
/* loaded from: classes10.dex */
public class a {
    private static a oZi;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData oZj = new AlaMoreFunctionDialogData();
    private b oZk;

    private a() {
    }

    public static a ejG() {
        if (oZi == null) {
            synchronized (a.class) {
                if (oZi == null) {
                    oZi = new a();
                }
            }
        }
        return oZi;
    }

    public void aS(ab abVar) {
        if (abVar != null) {
            if (this.oZk == null || !this.oZk.isShowing()) {
                this.oZj.parseData(abVar.aKs);
                this.oZj.setLiveId(abVar.mLiveInfo == null ? null : String.valueOf(abVar.mLiveInfo.live_id));
                this.oZj.setRoomId(abVar.aKu == null ? null : abVar.aKu.aVk);
                this.oZj.setCustomRoomId(abVar.aKu == null ? null : abVar.aKu.croom_id);
                this.oZj.setGroupId(abVar.mLiveInfo != null ? String.valueOf(abVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, e eVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oZk = null;
        }
        if (this.oZj != null && !ListUtils.isEmpty(this.oZj.getGroupList())) {
            if (this.oZk == null) {
                this.oZk = new b(tbPageContext, this.oZj);
                this.oZk.a(eVar);
            } else {
                this.oZk.a((b) this.oZj);
            }
            this.oZk.show();
            ejH();
        }
    }

    private void ejH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oZj != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oZj.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aG(boolean z, boolean z2) {
        this.oZj.setShowFirstCharge(z, z2);
    }

    public void FD() {
        if (this.oZk != null && this.oZk.isShowing()) {
            this.oZk.dismiss();
        }
    }
}
