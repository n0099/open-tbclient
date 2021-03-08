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
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aLA;
    private String beL;
    private long gry;
    private String hPB;
    private boolean mIsHost;
    private String mPortrait;
    private String mRoomId;
    private String mRoomName;
    private String oAn;
    public RankListView oAo;
    private int oAp;
    private String oAq;
    private String orf;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, String str, String str2, boolean z, String str3, String str4, String str5, long j, String str6, int i2, String str7, String str8, String str9) {
        this.aLA = i;
        this.oAn = str;
        this.oAq = str8;
        this.mRoomName = str9;
        this.hPB = str2;
        this.mIsHost = z;
        this.mPortrait = str3;
        this.beL = str5;
        this.gry = j;
        this.orf = str6;
        this.oAp = i2;
        this.otherParams = str4;
        this.mRoomId = str7;
    }

    public void cHf() {
        if (this.oAo != null) {
            this.oAo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.ranklist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new b(a.this.getPageContext().getPageActivity(), a.this.aLA, a.this.oAn, a.this.hPB, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, a.this.mIsHost, a.this.mPortrait, a.this.otherParams, a.this.beL, a.this.gry, a.this.orf, a.this.mRoomId, a.this.oAq, a.this.mRoomName)));
                    a.this.ebT();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.orf);
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
        if (this.oAo != null && this.oAo.getParent() != null) {
            ((ViewGroup) this.oAo.getParent()).removeView(this.oAo);
        }
        if (this.oAo == null) {
            this.oAo = new RankListView(getPageContext().getPageActivity());
        }
        this.oAo.setId(a.f.ala_liveroom_ranklist);
        this.oAo.setmTvText(this.oAp);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.guard_club_entry_id);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.oAo, layoutParams);
    }

    public void Ml(int i) {
        if (this.oAo != null) {
            this.oAo.setmTvText(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Au() {
        super.Au();
        if (this.oAo != null && this.oAo.getParent() != null) {
            ((ViewGroup) this.oAo.getParent()).removeView(this.oAo);
        }
        if (this.oAo != null) {
            this.oAo.destory();
            this.oAo = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.oAo != null) {
            this.oAo.destory();
            this.oAo = null;
        }
    }

    public void cky() {
    }

    public void ckz() {
    }
}
