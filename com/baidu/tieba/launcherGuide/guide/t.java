package com.baidu.tieba.launcherGuide.guide;

import android.app.Dialog;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.tbadkCore.af;
import com.baidu.tieba.tbadkCore.ax;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    private af LQ;
    private InterestFrsData.Tag bwR;
    private NewUserGuideActivity bxt;
    private a bxu;
    private ax bxv;

    public t(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, p pVar) {
        this.bxt = newUserGuideActivity;
        this.bwR = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.bxu = new r(this.bxt.getPageContext().getPageActivity(), z.NewUserDialog);
        } else if (btype == 2) {
            this.bxu = new e(this.bxt.getPageContext().getPageActivity(), z.NewUserDialog);
        } else if (btype == 3) {
            this.bxu = new i(this.bxt.getPageContext().getPageActivity(), z.NewUserDialog);
        }
        this.LQ = new af(newUserGuideActivity.getPageContext());
        this.LQ.setLoadDataCallBack(new u(this));
        this.bxv = new ax();
        this.bxv.a(new v(this));
        this.bxu.setOnClickListener(this);
        this.bxu.a(this.bwR);
        ((Dialog) this.bxu).setOnDismissListener(new w(this, pVar));
    }

    public void o(int i, boolean z) {
        for (int i2 = 0; i2 < this.bwR.getCard_list().size(); i2++) {
            if (this.bwR.getCard_list().get(i2).getFid() == i) {
                this.bwR.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.box_close_layout) {
            this.bxu.hide();
        } else if ((view.getId() == com.baidu.tieba.v.ll_like || view.getId() == com.baidu.tieba.v.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.bxv.i(card.getFname(), card.getFid());
            } else {
                this.LQ.p(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.bxt == null || com.baidu.adp.lib.g.k.k(this.bxt.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.bxu.getRootView().setAnimation(scaleAnimation);
            this.bxu.show();
        }
    }
}
