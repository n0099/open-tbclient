package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes3.dex */
public class f implements View.OnClickListener {
    private LikeModel azn;
    private NewUserGuideActivity gUG;
    private a gUH;
    private w gUI;
    private InterestFrsData.Tag gUe;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.gUG = newUserGuideActivity;
        this.gUe = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.gUH = new e(this.gUG.getPageContext().getPageActivity(), f.k.NewUserDialog);
        } else if (btype == 2) {
            this.gUH = new b(this.gUG.getPageContext().getPageActivity(), f.k.NewUserDialog);
        } else if (btype == 3) {
            this.gUH = new d(this.gUG.getPageContext().getPageActivity(), f.k.NewUserDialog);
        }
        this.azn = new LikeModel(newUserGuideActivity.getPageContext());
        this.azn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj == null) {
                    f.this.gUG.showToast(f.j.neterror);
                } else if (obj instanceof r) {
                    int g = com.baidu.adp.lib.g.b.g(((r) obj).getFid(), 0);
                    f.this.gUH.ua(g);
                    f.this.D(g, true);
                    f.this.gUG.mI(true);
                    f.this.gUG.mH(true);
                    TiebaStatic.eventStat(f.this.gUG.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.gUI = new w();
        this.gUI.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                int g = com.baidu.adp.lib.g.b.g(String.valueOf(j), 0);
                f.this.gUH.ub(g);
                f.this.D(g, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
                f.this.gUG.showToast(f.j.error);
            }
        });
        this.gUH.setOnClickListener(this);
        this.gUH.a(this.gUe);
        ((Dialog) this.gUH).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.byB();
            }
        });
    }

    public void D(int i, boolean z) {
        for (int i2 = 0; i2 < this.gUe.getCard_list().size(); i2++) {
            if (this.gUe.getCard_list().get(i2).getFid() == i) {
                this.gUe.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f.g.box_close_layout) {
            this.gUH.hide();
        } else if ((view.getId() == f.g.ll_like || view.getId() == f.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.gUI.t(card.getFname(), card.getFid());
            } else {
                this.azn.I(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.gUG == null || g.m(this.gUG.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.gUH.getRootView().setAnimation(scaleAnimation);
            this.gUH.show();
        }
    }
}
