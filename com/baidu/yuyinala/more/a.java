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
    private static a oKJ;
    private TbPageContext mPageContext;
    private AlaMoreFunctionDialogData oKK = new AlaMoreFunctionDialogData();
    private b oKL;

    private a() {
    }

    public static a ekF() {
        if (oKJ == null) {
            synchronized (a.class) {
                if (oKJ == null) {
                    oKJ = new a();
                }
            }
        }
        return oKJ;
    }

    public void aC(w wVar) {
        if (wVar != null) {
            if (this.oKL == null || !this.oKL.isShowing()) {
                this.oKK.parseData(wVar.aKJ);
                this.oKK.setLiveId(wVar.mLiveInfo == null ? null : String.valueOf(wVar.mLiveInfo.live_id));
                this.oKK.setRoomId(wVar.aKL == null ? null : wVar.aKL.aUg);
                this.oKK.setCustomRoomId(wVar.aKL == null ? null : wVar.aKL.croom_id);
                this.oKK.setGroupId(wVar.mLiveInfo != null ? String.valueOf(wVar.mLiveInfo.group_id) : null);
            }
        }
    }

    public void a(TbPageContext tbPageContext, com.baidu.live.e.c cVar) {
        if (this.mPageContext != tbPageContext) {
            this.mPageContext = tbPageContext;
            this.oKL = null;
        }
        if (this.oKL == null) {
            this.oKL = new b(tbPageContext, this.oKK);
            this.oKL.a(cVar);
        } else {
            this.oKL.a((b) this.oKK);
        }
        this.oKL.show();
        ekG();
    }

    private void ekG() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oKK != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oKK.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "moretab_show").setContentExt(jSONObject));
    }

    public void aD(boolean z, boolean z2) {
        this.oKK.setShowFirstCharge(z, z2);
    }

    public void ID() {
        if (this.oKL != null && this.oKL.isShowing()) {
            this.oKL.dismiss();
        }
    }
}
