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
    private w LU;
    private NewUserGuideActivity bSH;
    private a bSI;
    private ai bSJ;
    private InterestFrsData.Tag bSf;

    public p(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, k.a aVar) {
        this.bSH = newUserGuideActivity;
        this.bSf = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.bSI = new o(this.bSH.getPageContext().getPageActivity(), i.C0057i.NewUserDialog);
        } else if (btype == 2) {
            this.bSI = new e(this.bSH.getPageContext().getPageActivity(), i.C0057i.NewUserDialog);
        } else if (btype == 3) {
            this.bSI = new g(this.bSH.getPageContext().getPageActivity(), i.C0057i.NewUserDialog);
        }
        this.LU = new w(newUserGuideActivity.getPageContext());
        this.LU.setLoadDataCallBack(new q(this));
        this.bSJ = new ai();
        this.bSJ.a(new r(this));
        this.bSI.setOnClickListener(this);
        this.bSI.a(this.bSf);
        ((Dialog) this.bSI).setOnDismissListener(new s(this, aVar));
    }

    public void m(int i, boolean z) {
        for (int i2 = 0; i2 < this.bSf.getCard_list().size(); i2++) {
            if (this.bSf.getCard_list().get(i2).getFid() == i) {
                this.bSf.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.box_close_layout) {
            this.bSI.hide();
        } else if ((view.getId() == i.f.ll_like || view.getId() == i.f.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.bSJ.k(card.getFname(), card.getFid());
            } else {
                this.LU.r(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.bSH == null || com.baidu.adp.lib.g.j.k(this.bSH.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.bSI.getRootView().setAnimation(scaleAnimation);
            this.bSI.show();
        }
    }
}
