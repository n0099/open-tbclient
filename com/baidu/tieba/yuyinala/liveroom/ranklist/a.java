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
    private int aJw;
    private String baa;
    private long fTr;
    private String hmA;
    private boolean mIsHost;
    private String mPortrait;
    private String mRoomId;
    private String mRoomName;
    private String nLi;
    private String nRp;
    public RankListView nRq;
    private int nRr;
    private String nRs;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, String str, String str2, boolean z, String str3, String str4, String str5, long j, String str6, int i2, String str7, String str8, String str9) {
        this.aJw = i;
        this.nRp = str;
        this.nRs = str8;
        this.mRoomName = str9;
        this.hmA = str2;
        this.mIsHost = z;
        this.mPortrait = str3;
        this.baa = str5;
        this.fTr = j;
        this.nLi = str6;
        this.nRr = i2;
        this.otherParams = str4;
        this.mRoomId = str7;
    }

    public void czY() {
        if (this.nRq != null) {
            this.nRq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.ranklist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new b(a.this.getPageContext().getPageActivity(), a.this.aJw, a.this.nRp, a.this.hmA, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, a.this.mIsHost, a.this.mPortrait, a.this.otherParams, a.this.baa, a.this.fTr, a.this.nLi, a.this.mRoomId, a.this.nRs, a.this.mRoomName)));
                    a.this.dVw();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.nLi);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roomranking_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void av(ViewGroup viewGroup) {
        super.av(viewGroup);
        aD(viewGroup);
    }

    private void aD(ViewGroup viewGroup) {
        if (this.nRq != null && this.nRq.getParent() != null) {
            ((ViewGroup) this.nRq.getParent()).removeView(this.nRq);
        }
        if (this.nRq == null) {
            this.nRq = new RankListView(getPageContext().getPageActivity());
        }
        this.nRq.setId(a.g.ala_liveroom_ranklist);
        this.nRq.setmTvText(this.nRr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.g.guard_club_entry_id);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
        viewGroup.addView(this.nRq, layoutParams);
    }

    public void LT(int i) {
        if (this.nRq != null) {
            this.nRq.setmTvText(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CT() {
        super.CT();
        if (this.nRq != null && this.nRq.getParent() != null) {
            ((ViewGroup) this.nRq.getParent()).removeView(this.nRq);
        }
        if (this.nRq != null) {
            this.nRq.destory();
            this.nRq = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nRq != null) {
            this.nRq.destory();
            this.nRq = null;
        }
    }

    public void cey() {
    }

    public void cez() {
    }
}
