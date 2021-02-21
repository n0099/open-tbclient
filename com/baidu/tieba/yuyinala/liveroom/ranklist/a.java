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
    private int aKa;
    private String bdj;
    private long gpP;
    private String hNS;
    private boolean mIsHost;
    private String mPortrait;
    private String mRoomId;
    private String mRoomName;
    private String ooZ;
    public String otherParams;
    private String oyi;
    public RankListView oyj;
    private int oyk;
    private String oyl;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, String str, String str2, boolean z, String str3, String str4, String str5, long j, String str6, int i2, String str7, String str8, String str9) {
        this.aKa = i;
        this.oyi = str;
        this.oyl = str8;
        this.mRoomName = str9;
        this.hNS = str2;
        this.mIsHost = z;
        this.mPortrait = str3;
        this.bdj = str5;
        this.gpP = j;
        this.ooZ = str6;
        this.oyk = i2;
        this.otherParams = str4;
        this.mRoomId = str7;
    }

    public void cGZ() {
        if (this.oyj != null) {
            this.oyj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.ranklist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new b(a.this.getPageContext().getPageActivity(), a.this.aKa, a.this.oyi, a.this.hNS, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, a.this.mIsHost, a.this.mPortrait, a.this.otherParams, a.this.bdj, a.this.gpP, a.this.ooZ, a.this.mRoomId, a.this.oyl, a.this.mRoomName)));
                    a.this.ebL();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ooZ);
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
        if (this.oyj != null && this.oyj.getParent() != null) {
            ((ViewGroup) this.oyj.getParent()).removeView(this.oyj);
        }
        if (this.oyj == null) {
            this.oyj = new RankListView(getPageContext().getPageActivity());
        }
        this.oyj.setId(a.f.ala_liveroom_ranklist);
        this.oyj.setmTvText(this.oyk);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.guard_club_entry_id);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.oyj, layoutParams);
    }

    public void Mh(int i) {
        if (this.oyj != null) {
            this.oyj.setmTvText(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Ar() {
        super.Ar();
        if (this.oyj != null && this.oyj.getParent() != null) {
            ((ViewGroup) this.oyj.getParent()).removeView(this.oyj);
        }
        if (this.oyj != null) {
            this.oyj.destory();
            this.oyj = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.oyj != null) {
            this.oyj.destory();
            this.oyj = null;
        }
    }

    public void cks() {
    }

    public void ckt() {
    }
}
