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
    private LikeModel bmW;
    private InterestFrsData.Tag gBY;
    private NewUserGuideActivity gCA;
    private a gCB;
    private w gCC;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.gCA = newUserGuideActivity;
        this.gBY = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.gCB = new e(this.gCA.getPageContext().getPageActivity(), d.l.NewUserDialog);
        } else if (btype == 2) {
            this.gCB = new b(this.gCA.getPageContext().getPageActivity(), d.l.NewUserDialog);
        } else if (btype == 3) {
            this.gCB = new d(this.gCA.getPageContext().getPageActivity(), d.l.NewUserDialog);
        }
        this.bmW = new LikeModel(newUserGuideActivity.getPageContext());
        this.bmW.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj == null) {
                    f.this.gCA.showToast(d.k.neterror);
                } else if (obj instanceof r) {
                    int g = com.baidu.adp.lib.g.b.g(((r) obj).getFid(), 0);
                    f.this.gCB.tJ(g);
                    f.this.E(g, true);
                    f.this.gCA.mF(true);
                    f.this.gCA.mE(true);
                    TiebaStatic.eventStat(f.this.gCA.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.gCC = new w();
        this.gCC.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                int g = com.baidu.adp.lib.g.b.g(String.valueOf(j), 0);
                f.this.gCB.tK(g);
                f.this.E(g, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
                f.this.gCA.showToast(d.k.error);
            }
        });
        this.gCB.setOnClickListener(this);
        this.gCB.a(this.gBY);
        ((Dialog) this.gCB).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.bun();
            }
        });
    }

    public void E(int i, boolean z) {
        for (int i2 = 0; i2 < this.gBY.getCard_list().size(); i2++) {
            if (this.gBY.getCard_list().get(i2).getFid() == i) {
                this.gBY.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.box_close_layout) {
            this.gCB.hide();
        } else if ((view2.getId() == d.g.ll_like || view2.getId() == d.g.pic_layout) && view2.getTag() != null && (view2.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view2.getTag();
            if (card.getIs_like() == 1) {
                this.gCC.t(card.getFname(), card.getFid());
            } else {
                this.bmW.I(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.gCA == null || g.o(this.gCA.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.gCB.getRootView().setAnimation(scaleAnimation);
            this.gCB.show();
        }
    }
}
