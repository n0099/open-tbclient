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
    private w aFN;
    public PlayIntroduceView onz;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void Z(w wVar) {
        this.aFN = wVar;
    }

    public void cGw() {
        if (this.onz != null) {
            this.onz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new d(g.this.getPageContext().getPageActivity()).ac(g.this.aFN);
                    g.this.edJ();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "gamerule_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        aB(viewGroup);
    }

    private void aB(ViewGroup viewGroup) {
        if (this.onz != null && this.onz.getParent() != null) {
            ((ViewGroup) this.onz.getParent()).removeView(this.onz);
        }
        if (this.onz == null) {
            this.onz = new PlayIntroduceView(getPageContext().getPageActivity());
        }
        this.onz.setId(a.f.ala_liveroom_play_introduce);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_charm_rank);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.onz, layoutParams);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void En() {
        super.En();
        if (this.onz != null && this.onz.getParent() != null) {
            ((ViewGroup) this.onz.getParent()).removeView(this.onz);
        }
        if (this.onz != null) {
            this.onz.destory();
            this.onz = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.onz != null) {
            this.onz.destory();
            this.onz = null;
        }
    }

    public void cko() {
    }

    public void ckp() {
    }
}
