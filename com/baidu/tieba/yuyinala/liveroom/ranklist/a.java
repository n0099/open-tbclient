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
    private int aIL;
    private String aZH;
    private long fYO;
    private String hsf;
    private boolean mIsHost;
    private String mPortrait;
    private String mRoomId;
    private String mRoomName;
    private String nSF;
    private String oae;
    public RankListView oaf;
    private int oag;
    private String oah;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, String str, String str2, boolean z, String str3, String str4, String str5, long j, String str6, int i2, String str7, String str8, String str9) {
        this.aIL = i;
        this.oae = str;
        this.oah = str8;
        this.mRoomName = str9;
        this.hsf = str2;
        this.mIsHost = z;
        this.mPortrait = str3;
        this.aZH = str5;
        this.fYO = j;
        this.nSF = str6;
        this.oag = i2;
        this.otherParams = str4;
        this.mRoomId = str7;
    }

    public void cCd() {
        if (this.oaf != null) {
            this.oaf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.ranklist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new b(a.this.getPageContext().getPageActivity(), a.this.aIL, a.this.oae, a.this.hsf, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, a.this.mIsHost, a.this.mPortrait, a.this.otherParams, a.this.aZH, a.this.fYO, a.this.nSF, a.this.mRoomId, a.this.oah, a.this.mRoomName)));
                    a.this.dYk();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.nSF);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roomranking_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        aB(viewGroup);
    }

    private void aB(ViewGroup viewGroup) {
        if (this.oaf != null && this.oaf.getParent() != null) {
            ((ViewGroup) this.oaf.getParent()).removeView(this.oaf);
        }
        if (this.oaf == null) {
            this.oaf = new RankListView(getPageContext().getPageActivity());
        }
        this.oaf.setId(a.f.ala_liveroom_ranklist);
        this.oaf.setmTvText(this.oag);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.guard_club_entry_id);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.oaf, layoutParams);
    }

    public void MN(int i) {
        if (this.oaf != null) {
            this.oaf.setmTvText(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CD() {
        super.CD();
        if (this.oaf != null && this.oaf.getParent() != null) {
            ((ViewGroup) this.oaf.getParent()).removeView(this.oaf);
        }
        if (this.oaf != null) {
            this.oaf.destory();
            this.oaf = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.oaf != null) {
            this.oaf.destory();
            this.oaf = null;
        }
    }

    public void cgu() {
    }

    public void cgv() {
    }
}
