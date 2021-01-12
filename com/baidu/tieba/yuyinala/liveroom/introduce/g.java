package com.baidu.tieba.yuyinala.liveroom.introduce;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g extends com.baidu.tieba.yuyinala.liveroom.a {
    private x aBr;
    public PlayIntroduceView omi;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public void Y(x xVar) {
        this.aBr = xVar;
    }

    public void cFF() {
        if (this.omi != null) {
            this.omi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.introduce.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    new d(g.this.getPageContext().getPageActivity()).af(g.this.aBr);
                    g.this.dZk();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "gamerule_clk").setContentExt(jSONObject));
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        aN(viewGroup);
    }

    private void aN(ViewGroup viewGroup) {
        if (this.omi != null && this.omi.getParent() != null) {
            ((ViewGroup) this.omi.getParent()).removeView(this.omi);
        }
        if (this.omi == null) {
            this.omi = new PlayIntroduceView(getPageContext().getPageActivity());
        }
        this.omi.setId(a.f.ala_liveroom_play_introduce);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, a.f.ala_liveroom_charm_rank);
        layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
        layoutParams.leftMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds19);
        layoutParams.topMargin = getPageContext().getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
        viewGroup.addView(this.omi, layoutParams);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void zH() {
        super.zH();
        if (this.omi != null && this.omi.getParent() != null) {
            ((ViewGroup) this.omi.getParent()).removeView(this.omi);
        }
        if (this.omi != null) {
            this.omi.destory();
            this.omi = null;
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.a
    public void onDestroy() {
        if (this.omi != null) {
            this.omi.destory();
            this.omi = null;
        }
    }

    public void cjm() {
    }

    public void cjn() {
    }
}
