package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes3.dex */
public class f implements View.OnClickListener {
    private LikeModel bvr;
    private InterestFrsData.Tag gOD;
    private NewUserGuideActivity gPf;
    private a gPg;
    private w gPh;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.gPf = newUserGuideActivity;
        this.gOD = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.gPg = new e(this.gPf.getPageContext().getPageActivity(), d.l.NewUserDialog);
        } else if (btype == 2) {
            this.gPg = new b(this.gPf.getPageContext().getPageActivity(), d.l.NewUserDialog);
        } else if (btype == 3) {
            this.gPg = new d(this.gPf.getPageContext().getPageActivity(), d.l.NewUserDialog);
        }
        this.bvr = new LikeModel(newUserGuideActivity.getPageContext());
        this.bvr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj == null) {
                    f.this.gPf.showToast(d.k.neterror);
                } else if (obj instanceof r) {
                    int g = com.baidu.adp.lib.g.b.g(((r) obj).getFid(), 0);
                    f.this.gPg.tU(g);
                    f.this.E(g, true);
                    f.this.gPf.mM(true);
                    f.this.gPf.mL(true);
                    TiebaStatic.eventStat(f.this.gPf.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.gPh = new w();
        this.gPh.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                int g = com.baidu.adp.lib.g.b.g(String.valueOf(j), 0);
                f.this.gPg.tV(g);
                f.this.E(g, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
                f.this.gPf.showToast(d.k.error);
            }
        });
        this.gPg.setOnClickListener(this);
        this.gPg.a(this.gOD);
        ((Dialog) this.gPg).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.bzo();
            }
        });
    }

    public void E(int i, boolean z) {
        for (int i2 = 0; i2 < this.gOD.getCard_list().size(); i2++) {
            if (this.gOD.getCard_list().get(i2).getFid() == i) {
                this.gOD.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.box_close_layout) {
            this.gPg.hide();
        } else if ((view.getId() == d.g.ll_like || view.getId() == d.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.gPh.t(card.getFname(), card.getFid());
            } else {
                this.bvr.J(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.gPf == null || g.n(this.gPf.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.gPg.getRootView().setAnimation(scaleAnimation);
            this.gPg.show();
        }
    }
}
