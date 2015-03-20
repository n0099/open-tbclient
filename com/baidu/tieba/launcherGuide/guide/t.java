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
    private af LO;
    private InterestFrsData.Tag bwB;
    private NewUserGuideActivity bxd;
    private a bxe;
    private ax bxf;

    public t(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, p pVar) {
        this.bxd = newUserGuideActivity;
        this.bwB = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.bxe = new r(this.bxd.getPageContext().getPageActivity(), z.NewUserDialog);
        } else if (btype == 2) {
            this.bxe = new e(this.bxd.getPageContext().getPageActivity(), z.NewUserDialog);
        } else if (btype == 3) {
            this.bxe = new i(this.bxd.getPageContext().getPageActivity(), z.NewUserDialog);
        }
        this.LO = new af(newUserGuideActivity.getPageContext());
        this.LO.setLoadDataCallBack(new u(this));
        this.bxf = new ax();
        this.bxf.a(new v(this));
        this.bxe.setOnClickListener(this);
        this.bxe.a(this.bwB);
        ((Dialog) this.bxe).setOnDismissListener(new w(this, pVar));
    }

    public void o(int i, boolean z) {
        for (int i2 = 0; i2 < this.bwB.getCard_list().size(); i2++) {
            if (this.bwB.getCard_list().get(i2).getFid() == i) {
                this.bwB.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.box_close_layout) {
            this.bxe.hide();
        } else if ((view.getId() == com.baidu.tieba.v.ll_like || view.getId() == com.baidu.tieba.v.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.bxf.i(card.getFname(), card.getFid());
            } else {
                this.LO.p(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.bxd == null || com.baidu.adp.lib.g.k.k(this.bxd.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.bxe.getRootView().setAnimation(scaleAnimation);
            this.bxe.show();
        }
    }
}
