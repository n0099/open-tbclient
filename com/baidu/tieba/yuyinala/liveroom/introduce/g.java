package com.baidu.tieba.yuyinala.liveroom.introduce;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.yuyinala.liveroom.a {
    private w aES;
    public PlayIntroduceView nWW;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void U(w wVar) {
        this.aES = wVar;
    }

    public void cCz() {
        if (this.nWW != null) {
            this.nWW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new d(g.this.getPageContext().getPageActivity()).X(g.this.aES);
                    g.this.dYg();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "gamerule_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        super.ax(viewGroup);
        aF(viewGroup);
    }

    private void aF(ViewGroup viewGroup) {
        if (this.nWW != null && this.nWW.getParent() != null) {
            ((ViewGroup) this.nWW.getParent()).removeView(this.nWW);
        }
        if (this.nWW == null) {
            this.nWW = new PlayIntroduceView(getPageContext().getPageActivity());
        }
        this.nWW.setId(a.f.ala_liveroom_play_introduce);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_charm_rank);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.nWW, layoutParams);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void Dm() {
        super.Dm();
        if (this.nWW != null && this.nWW.getParent() != null) {
            ((ViewGroup) this.nWW.getParent()).removeView(this.nWW);
        }
        if (this.nWW != null) {
            this.nWW.destory();
            this.nWW = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nWW != null) {
            this.nWW.destory();
            this.nWW = null;
        }
    }

    public void chb() {
    }

    public void chc() {
    }
}
