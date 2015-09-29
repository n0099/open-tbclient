package com.baidu.tieba.launcherGuide.guide;

import android.app.Dialog;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.launcherGuide.guide.k;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private w LS;
    private InterestFrsData.Tag bRz;
    private NewUserGuideActivity bSb;
    private a bSc;
    private ai bSd;

    public p(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, k.a aVar) {
        this.bSb = newUserGuideActivity;
        this.bRz = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.bSc = new o(this.bSb.getPageContext().getPageActivity(), i.C0057i.NewUserDialog);
        } else if (btype == 2) {
            this.bSc = new e(this.bSb.getPageContext().getPageActivity(), i.C0057i.NewUserDialog);
        } else if (btype == 3) {
            this.bSc = new g(this.bSb.getPageContext().getPageActivity(), i.C0057i.NewUserDialog);
        }
        this.LS = new w(newUserGuideActivity.getPageContext());
        this.LS.setLoadDataCallBack(new q(this));
        this.bSd = new ai();
        this.bSd.a(new r(this));
        this.bSc.setOnClickListener(this);
        this.bSc.a(this.bRz);
        ((Dialog) this.bSc).setOnDismissListener(new s(this, aVar));
    }

    public void m(int i, boolean z) {
        for (int i2 = 0; i2 < this.bRz.getCard_list().size(); i2++) {
            if (this.bRz.getCard_list().get(i2).getFid() == i) {
                this.bRz.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.box_close_layout) {
            this.bSc.hide();
        } else if ((view.getId() == i.f.ll_like || view.getId() == i.f.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.bSd.k(card.getFname(), card.getFid());
            } else {
                this.LS.s(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.bSb == null || com.baidu.adp.lib.g.j.k(this.bSb.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.bSc.getRootView().setAnimation(scaleAnimation);
            this.bSc.show();
        }
    }
}
