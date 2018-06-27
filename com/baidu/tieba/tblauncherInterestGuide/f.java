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
    private LikeModel bwM;
    private NewUserGuideActivity gTG;
    private a gTH;
    private w gTI;
    private InterestFrsData.Tag gTe;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.gTG = newUserGuideActivity;
        this.gTe = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.gTH = new e(this.gTG.getPageContext().getPageActivity(), d.l.NewUserDialog);
        } else if (btype == 2) {
            this.gTH = new b(this.gTG.getPageContext().getPageActivity(), d.l.NewUserDialog);
        } else if (btype == 3) {
            this.gTH = new d(this.gTG.getPageContext().getPageActivity(), d.l.NewUserDialog);
        }
        this.bwM = new LikeModel(newUserGuideActivity.getPageContext());
        this.bwM.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj == null) {
                    f.this.gTG.showToast(d.k.neterror);
                } else if (obj instanceof r) {
                    int g = com.baidu.adp.lib.g.b.g(((r) obj).getFid(), 0);
                    f.this.gTH.uc(g);
                    f.this.E(g, true);
                    f.this.gTG.mX(true);
                    f.this.gTG.mW(true);
                    TiebaStatic.eventStat(f.this.gTG.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.gTI = new w();
        this.gTI.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                int g = com.baidu.adp.lib.g.b.g(String.valueOf(j), 0);
                f.this.gTH.ud(g);
                f.this.E(g, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
                f.this.gTG.showToast(d.k.error);
            }
        });
        this.gTH.setOnClickListener(this);
        this.gTH.a(this.gTe);
        ((Dialog) this.gTH).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.bzW();
            }
        });
    }

    public void E(int i, boolean z) {
        for (int i2 = 0; i2 < this.gTe.getCard_list().size(); i2++) {
            if (this.gTe.getCard_list().get(i2).getFid() == i) {
                this.gTe.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.box_close_layout) {
            this.gTH.hide();
        } else if ((view.getId() == d.g.ll_like || view.getId() == d.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.gTI.t(card.getFname(), card.getFid());
            } else {
                this.bwM.H(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.gTG == null || g.n(this.gTG.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.gTH.getRootView().setAnimation(scaleAnimation);
            this.gTH.show();
        }
    }
}
