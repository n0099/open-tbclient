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
/* loaded from: classes4.dex */
public class f implements View.OnClickListener {
    private LikeModel bUs;
    private InterestFrsData.Tag iMW;
    private w iNA;
    private NewUserGuideActivity iNy;
    private a iNz;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.iNy = newUserGuideActivity;
        this.iMW = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.iNz = new e(this.iNy.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 2) {
            this.iNz = new b(this.iNy.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 3) {
            this.iNz = new d(this.iNy.getPageContext().getPageActivity(), d.k.NewUserDialog);
        }
        this.bUs = new LikeModel(newUserGuideActivity.getPageContext());
        this.bUs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj == null) {
                    f.this.iNy.showToast(d.j.neterror);
                } else if (obj instanceof r) {
                    int l = com.baidu.adp.lib.g.b.l(((r) obj).getFid(), 0);
                    f.this.iNz.zI(l);
                    f.this.K(l, true);
                    f.this.iNy.qq(true);
                    f.this.iNy.qp(true);
                    TiebaStatic.eventStat(f.this.iNy.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.iNA = new w();
        this.iNA.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void s(String str, long j) {
                int l = com.baidu.adp.lib.g.b.l(String.valueOf(j), 0);
                f.this.iNz.zJ(l);
                f.this.K(l, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void t(String str, long j) {
                f.this.iNy.showToast(d.j.error);
            }
        });
        this.iNz.setOnClickListener(this);
        this.iNz.a(this.iMW);
        ((Dialog) this.iNz).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.chb();
            }
        });
    }

    public void K(int i, boolean z) {
        for (int i2 = 0; i2 < this.iMW.getCard_list().size(); i2++) {
            if (this.iMW.getCard_list().get(i2).getFid() == i) {
                this.iMW.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.box_close_layout) {
            this.iNz.hide();
        } else if ((view.getId() == d.g.ll_like || view.getId() == d.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.iNA.A(card.getFname(), card.getFid());
            } else {
                this.bUs.ac(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.iNy == null || g.q(this.iNy.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.iNz.getRootView().setAnimation(scaleAnimation);
            this.iNz.show();
        }
    }
}
