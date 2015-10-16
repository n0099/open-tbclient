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
    private w LT;
    private InterestFrsData.Tag bRK;
    private NewUserGuideActivity bSm;
    private a bSn;
    private ai bSo;

    public p(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, k.a aVar) {
        this.bSm = newUserGuideActivity;
        this.bRK = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.bSn = new o(this.bSm.getPageContext().getPageActivity(), i.C0057i.NewUserDialog);
        } else if (btype == 2) {
            this.bSn = new e(this.bSm.getPageContext().getPageActivity(), i.C0057i.NewUserDialog);
        } else if (btype == 3) {
            this.bSn = new g(this.bSm.getPageContext().getPageActivity(), i.C0057i.NewUserDialog);
        }
        this.LT = new w(newUserGuideActivity.getPageContext());
        this.LT.setLoadDataCallBack(new q(this));
        this.bSo = new ai();
        this.bSo.a(new r(this));
        this.bSn.setOnClickListener(this);
        this.bSn.a(this.bRK);
        ((Dialog) this.bSn).setOnDismissListener(new s(this, aVar));
    }

    public void m(int i, boolean z) {
        for (int i2 = 0; i2 < this.bRK.getCard_list().size(); i2++) {
            if (this.bRK.getCard_list().get(i2).getFid() == i) {
                this.bRK.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == i.f.box_close_layout) {
            this.bSn.hide();
        } else if ((view.getId() == i.f.ll_like || view.getId() == i.f.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.bSo.k(card.getFname(), card.getFid());
            } else {
                this.LT.r(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.bSm == null || com.baidu.adp.lib.g.j.k(this.bSm.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.bSn.getRootView().setAnimation(scaleAnimation);
            this.bSn.show();
        }
    }
}
