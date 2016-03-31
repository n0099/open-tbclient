package com.baidu.tieba.launcherGuide.guide;

import android.app.Dialog;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tieba.launcherGuide.data.InterestFrsData;
import com.baidu.tieba.launcherGuide.guide.k;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private w MY;
    private InterestFrsData.Tag cDC;
    private NewUserGuideActivity cEf;
    private a cEg;
    private aj cEh;

    public p(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, k.a aVar) {
        this.cEf = newUserGuideActivity;
        this.cDC = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.cEg = new o(this.cEf.getPageContext().getPageActivity(), t.k.NewUserDialog);
        } else if (btype == 2) {
            this.cEg = new e(this.cEf.getPageContext().getPageActivity(), t.k.NewUserDialog);
        } else if (btype == 3) {
            this.cEg = new g(this.cEf.getPageContext().getPageActivity(), t.k.NewUserDialog);
        }
        this.MY = new w(newUserGuideActivity.getPageContext());
        this.MY.setLoadDataCallBack(new q(this));
        this.cEh = new aj();
        this.cEh.a(new r(this));
        this.cEg.setOnClickListener(this);
        this.cEg.a(this.cDC);
        ((Dialog) this.cEg).setOnDismissListener(new s(this, aVar));
    }

    public void q(int i, boolean z) {
        for (int i2 = 0; i2 < this.cDC.getCard_list().size(); i2++) {
            if (this.cDC.getCard_list().get(i2).getFid() == i) {
                this.cDC.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == t.g.box_close_layout) {
            this.cEg.hide();
        } else if ((view.getId() == t.g.ll_like || view.getId() == t.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.cEh.m(card.getFname(), card.getFid());
            } else {
                this.MY.B(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.cEf == null || com.baidu.adp.lib.h.j.f(this.cEf.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.cEg.getRootView().setAnimation(scaleAnimation);
            this.cEg.show();
        }
    }
}
