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
    private LikeModel bUq;
    private NewUserGuideActivity iNK;
    private a iNL;
    private w iNM;
    private InterestFrsData.Tag iNi;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.iNK = newUserGuideActivity;
        this.iNi = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.iNL = new e(this.iNK.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 2) {
            this.iNL = new b(this.iNK.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 3) {
            this.iNL = new d(this.iNK.getPageContext().getPageActivity(), d.k.NewUserDialog);
        }
        this.bUq = new LikeModel(newUserGuideActivity.getPageContext());
        this.bUq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj == null) {
                    f.this.iNK.showToast(d.j.neterror);
                } else if (obj instanceof r) {
                    int l = com.baidu.adp.lib.g.b.l(((r) obj).getFid(), 0);
                    f.this.iNL.zM(l);
                    f.this.K(l, true);
                    f.this.iNK.qq(true);
                    f.this.iNK.qp(true);
                    TiebaStatic.eventStat(f.this.iNK.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.iNM = new w();
        this.iNM.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void s(String str, long j) {
                int l = com.baidu.adp.lib.g.b.l(String.valueOf(j), 0);
                f.this.iNL.zN(l);
                f.this.K(l, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void t(String str, long j) {
                f.this.iNK.showToast(d.j.error);
            }
        });
        this.iNL.setOnClickListener(this);
        this.iNL.a(this.iNi);
        ((Dialog) this.iNL).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.chd();
            }
        });
    }

    public void K(int i, boolean z) {
        for (int i2 = 0; i2 < this.iNi.getCard_list().size(); i2++) {
            if (this.iNi.getCard_list().get(i2).getFid() == i) {
                this.iNi.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.box_close_layout) {
            this.iNL.hide();
        } else if ((view.getId() == d.g.ll_like || view.getId() == d.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.iNM.A(card.getFname(), card.getFid());
            } else {
                this.bUq.ac(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.iNK == null || g.q(this.iNK.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.iNL.getRootView().setAnimation(scaleAnimation);
            this.iNL.show();
        }
    }
}
