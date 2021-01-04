package com.baidu.tieba.yuyinala.liveroom.ranklist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.d.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aMi;
    private String beS;
    private long grz;
    private String hNM;
    private boolean mIsHost;
    private String mPortrait;
    private String mRoomId;
    private String mRoomName;
    private String ojm;
    public RankListView osA;
    private int osB;
    private String osC;
    private String osz;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, String str, String str2, boolean z, String str3, String str4, String str5, long j, String str6, int i2, String str7, String str8, String str9) {
        this.aMi = i;
        this.osz = str;
        this.osC = str8;
        this.mRoomName = str9;
        this.hNM = str2;
        this.mIsHost = z;
        this.mPortrait = str3;
        this.beS = str5;
        this.grz = j;
        this.ojm = str6;
        this.osB = i2;
        this.otherParams = str4;
        this.mRoomId = str7;
    }

    public void cJw() {
        if (this.osA != null) {
            this.osA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.ranklist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new b(a.this.getPageContext().getPageActivity(), a.this.aMi, a.this.osz, a.this.hNM, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, a.this.mIsHost, a.this.mPortrait, a.this.otherParams, a.this.beS, a.this.grz, a.this.ojm, a.this.mRoomId, a.this.osC, a.this.mRoomName)));
                    a.this.edh();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ojm);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "roomranking_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
    }

    private void aN(ViewGroup viewGroup) {
        if (this.osA != null && this.osA.getParent() != null) {
            ((ViewGroup) this.osA.getParent()).removeView(this.osA);
        }
        if (this.osA == null) {
            this.osA = new RankListView(getPageContext().getPageActivity());
        }
        this.osA.setId(a.f.ala_liveroom_ranklist);
        this.osA.setmTvText(this.osB);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.guard_club_entry_id);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.osA, layoutParams);
    }

    public void Ns(int i) {
        if (this.osA != null) {
            this.osA.setmTvText(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void DC() {
        super.DC();
        if (this.osA != null && this.osA.getParent() != null) {
            ((ViewGroup) this.osA.getParent()).removeView(this.osA);
        }
        if (this.osA != null) {
            this.osA.destory();
            this.osA = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.osA != null) {
            this.osA.destory();
            this.osA = null;
        }
    }

    public void cnd() {
    }

    public void cne() {
    }
}
