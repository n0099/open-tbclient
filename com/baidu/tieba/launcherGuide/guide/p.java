package com.baidu.tieba.launcherGuide.guide;

import android.app.Dialog;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.launcherGuide.guide.k;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private x Ml;
    private NewUserGuideActivity ciV;
    private a ciW;
    private aj ciX;
    private InterestFrsData.Tag cis;

    public p(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, k.a aVar) {
        this.ciV = newUserGuideActivity;
        this.cis = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.ciW = new o(this.ciV.getPageContext().getPageActivity(), n.j.NewUserDialog);
        } else if (btype == 2) {
            this.ciW = new e(this.ciV.getPageContext().getPageActivity(), n.j.NewUserDialog);
        } else if (btype == 3) {
            this.ciW = new g(this.ciV.getPageContext().getPageActivity(), n.j.NewUserDialog);
        }
        this.Ml = new x(newUserGuideActivity.getPageContext());
        this.Ml.setLoadDataCallBack(new q(this));
        this.ciX = new aj();
        this.ciX.a(new r(this));
        this.ciW.setOnClickListener(this);
        this.ciW.a(this.cis);
        ((Dialog) this.ciW).setOnDismissListener(new s(this, aVar));
    }

    public void o(int i, boolean z) {
        for (int i2 = 0; i2 < this.cis.getCard_list().size(); i2++) {
            if (this.cis.getCard_list().get(i2).getFid() == i) {
                this.cis.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == n.f.box_close_layout) {
            this.ciW.hide();
        } else if ((view.getId() == n.f.ll_like || view.getId() == n.f.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.ciX.m(card.getFname(), card.getFid());
            } else {
                this.Ml.u(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.ciV == null || com.baidu.adp.lib.h.j.k(this.ciV.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.ciW.getRootView().setAnimation(scaleAnimation);
            this.ciW.show();
        }
    }
}
