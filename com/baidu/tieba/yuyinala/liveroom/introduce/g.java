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
    private w aEc;
    public PlayIntroduceView nPN;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void Q(w wVar) {
        this.aEc = wVar;
    }

    public void czY() {
        if (this.nPN != null) {
            this.nPN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new d(g.this.getPageContext().getPageActivity()).P(g.this.aEc);
                    g.this.dVr();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aEc.aIS.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "gamerule_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void av(ViewGroup viewGroup) {
        super.av(viewGroup);
        aD(viewGroup);
    }

    private void aD(ViewGroup viewGroup) {
        if (this.nPN != null && this.nPN.getParent() != null) {
            ((ViewGroup) this.nPN.getParent()).removeView(this.nPN);
        }
        if (this.nPN == null) {
            this.nPN = new PlayIntroduceView(getPageContext().getPageActivity());
        }
        this.nPN.setId(a.g.ala_liveroom_play_introduce);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.g.ala_liveroom_charm_rank);
        layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
        viewGroup.addView(this.nPN, layoutParams);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void CT() {
        super.CT();
        if (this.nPN != null && this.nPN.getParent() != null) {
            ((ViewGroup) this.nPN.getParent()).removeView(this.nPN);
        }
        if (this.nPN != null) {
            this.nPN.destory();
            this.nPN = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.nPN != null) {
            this.nPN.destory();
            this.nPN = null;
        }
    }

    public void cey() {
    }

    public void cez() {
    }
}
