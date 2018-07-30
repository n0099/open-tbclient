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
    private LikeModel azq;
    private NewUserGuideActivity gUE;
    private a gUF;
    private w gUG;
    private InterestFrsData.Tag gUc;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.gUE = newUserGuideActivity;
        this.gUc = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.gUF = new e(this.gUE.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 2) {
            this.gUF = new b(this.gUE.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 3) {
            this.gUF = new d(this.gUE.getPageContext().getPageActivity(), d.k.NewUserDialog);
        }
        this.azq = new LikeModel(newUserGuideActivity.getPageContext());
        this.azq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj == null) {
                    f.this.gUE.showToast(d.j.neterror);
                } else if (obj instanceof r) {
                    int g = com.baidu.adp.lib.g.b.g(((r) obj).getFid(), 0);
                    f.this.gUF.ua(g);
                    f.this.D(g, true);
                    f.this.gUE.mI(true);
                    f.this.gUE.mH(true);
                    TiebaStatic.eventStat(f.this.gUE.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.gUG = new w();
        this.gUG.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                int g = com.baidu.adp.lib.g.b.g(String.valueOf(j), 0);
                f.this.gUF.ub(g);
                f.this.D(g, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
                f.this.gUE.showToast(d.j.error);
            }
        });
        this.gUF.setOnClickListener(this);
        this.gUF.a(this.gUc);
        ((Dialog) this.gUF).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.byz();
            }
        });
    }

    public void D(int i, boolean z) {
        for (int i2 = 0; i2 < this.gUc.getCard_list().size(); i2++) {
            if (this.gUc.getCard_list().get(i2).getFid() == i) {
                this.gUc.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.box_close_layout) {
            this.gUF.hide();
        } else if ((view.getId() == d.g.ll_like || view.getId() == d.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.gUG.t(card.getFname(), card.getFid());
            } else {
                this.azq.I(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.gUE == null || g.n(this.gUE.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.gUF.getRootView().setAnimation(scaleAnimation);
            this.gUF.show();
        }
    }
}
