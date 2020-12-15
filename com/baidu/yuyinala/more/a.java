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
    private static a oKL;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData oKM = new AlaMoreFunctionDialogData();
    private b oKN;

    private a() {
    }

    public static a ekG() {
        if (oKL == null) {
            synchronized (a.class) {
                if (oKL == null) {
                    oKL = new a();
                }
            }
        }
        return oKL;
    }

    public void aC(w wVar) {
        if (wVar != null) {
            if (this.oKN == null || !this.oKN.isShowing()) {
                this.oKM.parseData(wVar.aKJ);
                this.oKM.setLiveId(wVar.mLiveInfo == null ? null : String.valueOf(wVar.mLiveInfo.live_id));
                this.oKM.setRoomId(wVar.aKL == null ? null : wVar.aKL.aUg);
                this.oKM.setCustomRoomId(wVar.aKL == null ? null : wVar.aKL.croom_id);
                this.oKM.setGroupId(wVar.mLiveInfo != null ? String.valueOf(wVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, com.baidu.live.e.c cVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oKN = null;
        }
        if (this.oKN == null) {
            this.oKN = new b(tbPageContext, this.oKM);
            this.oKN.a(cVar);
        } else {
            this.oKN.a((b) this.oKM);
        }
        this.oKN.show();
        ekH();
    }

    private void ekH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oKM != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oKM.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aD(boolean z, boolean z2) {
        this.oKM.setShowFirstCharge(z, z2);
    }

    public void ID() {
        if (this.oKN != null && this.oKN.isShowing()) {
            this.oKN.dismiss();
        }
    }
}
