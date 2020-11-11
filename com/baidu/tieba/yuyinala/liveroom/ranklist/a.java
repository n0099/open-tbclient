package com.baidu.tieba.yuyinala.liveroom.ranklist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.b.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aKw;
    private String bbt;
    private long fZh;
    private String hsy;
    private boolean mIsHost;
    private String mPortrait;
    private String mRoomId;
    private String mRoomName;
    private String nRc;
    private String nYB;
    public RankListView nYC;
    private int nYD;
    private String nYE;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, String str, String str2, boolean z, String str3, String str4, String str5, long j, String str6, int i2, String str7, String str8, String str9) {
        this.aKw = i;
        this.nYB = str;
        this.nYE = str8;
        this.mRoomName = str9;
        this.hsy = str2;
        this.mIsHost = z;
        this.mPortrait = str3;
        this.bbt = str5;
        this.fZh = j;
        this.nRc = str6;
        this.nYD = i2;
        this.otherParams = str4;
        this.mRoomId = str7;
    }

    public void cCz() {
        if (this.nYC != null) {
            this.nYC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.ranklist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new b(a.this.getPageContext().getPageActivity(), a.this.aKw, a.this.nYB, a.this.hsy, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, a.this.mIsHost, a.this.mPortrait, a.this.otherParams, a.this.bbt, a.this.fZh, a.this.nRc, a.this.mRoomId, a.this.nYE, a.this.mRoomName)));
                    a.this.dYl();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.nRc);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roomranking_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        super.ax(viewGroup);
        aF(viewGroup);
    }

    private void aF(ViewGroup viewGroup) {
        if (this.nYC != null && this.nYC.getParent() != null) {
            ((ViewGroup) this.nYC.getParent()).removeView(this.nYC);
        }
        if (this.nYC == null) {
            this.nYC = new RankListView(getPageContext().getPageActivity());
        }
        this.nYC.setId(a.f.ala_liveroom_ranklist);
        this.nYC.setmTvText(this.nYD);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.guard_club_entry_id);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.nYC, layoutParams);
    }

    public void Mk(int i) {
        if (this.nYC != null) {
            this.nYC.setmTvText(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Dm() {
        super.Dm();
        if (this.nYC != null && this.nYC.getParent() != null) {
            ((ViewGroup) this.nYC.getParent()).removeView(this.nYC);
        }
        if (this.nYC != null) {
            this.nYC.destory();
            this.nYC = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nYC != null) {
            this.nYC.destory();
            this.nYC = null;
        }
    }

    public void chb() {
    }

    public void chc() {
    }
}
