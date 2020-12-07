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
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.yuyinala.liveroom.a {
    private int aLE;
    private String bdh;
    private long ggZ;
    private String hBJ;
    private boolean mIsHost;
    private String mPortrait;
    private String mRoomId;
    private String mRoomName;
    private String ohD;
    private String ope;
    public RankListView opf;
    private int opg;
    private String oph;
    public String otherParams;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void a(int i, String str, String str2, boolean z, String str3, String str4, String str5, long j, String str6, int i2, String str7, String str8, String str9) {
        this.aLE = i;
        this.ope = str;
        this.oph = str8;
        this.mRoomName = str9;
        this.hBJ = str2;
        this.mIsHost = z;
        this.mPortrait = str3;
        this.bdh = str5;
        this.ggZ = j;
        this.ohD = str6;
        this.opg = i2;
        this.otherParams = str4;
        this.mRoomId = str7;
    }

    public void cGw() {
        if (this.opf != null) {
            this.opf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.ranklist.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new b(a.this.getPageContext().getPageActivity(), a.this.aLE, a.this.ope, a.this.hBJ, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, a.this.mIsHost, a.this.mPortrait, a.this.otherParams, a.this.bdh, a.this.ggZ, a.this.ohD, a.this.mRoomId, a.this.oph, a.this.mRoomName)));
                    a.this.edO();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ohD);
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
        if (this.opf != null && this.opf.getParent() != null) {
            ((ViewGroup) this.opf.getParent()).removeView(this.opf);
        }
        if (this.opf == null) {
            this.opf = new RankListView(getPageContext().getPageActivity());
        }
        this.opf.setId(a.f.ala_liveroom_ranklist);
        this.opf.setmTvText(this.opg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.guard_club_entry_id);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.opf, layoutParams);
    }

    public void NF(int i) {
        if (this.opf != null) {
            this.opf.setmTvText(i);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void En() {
        super.En();
        if (this.opf != null && this.opf.getParent() != null) {
            ((ViewGroup) this.opf.getParent()).removeView(this.opf);
        }
        if (this.opf != null) {
            this.opf.destory();
            this.opf = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.opf != null) {
            this.opf.destory();
            this.opf = null;
        }
    }

    public void cko() {
    }

    public void ckp() {
    }
}
