package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.g.g;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes3.dex */
public class f implements View.OnClickListener {
    private LikeModel aGV;
    private NewUserGuideActivity hjL;
    private a hjM;
    private w hjN;
    private InterestFrsData.Tag hjj;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.hjL = newUserGuideActivity;
        this.hjj = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.hjM = new e(this.hjL.getPageContext().getPageActivity(), e.k.NewUserDialog);
        } else if (btype == 2) {
            this.hjM = new b(this.hjL.getPageContext().getPageActivity(), e.k.NewUserDialog);
        } else if (btype == 3) {
            this.hjM = new d(this.hjL.getPageContext().getPageActivity(), e.k.NewUserDialog);
        }
        this.aGV = new LikeModel(newUserGuideActivity.getPageContext());
        this.aGV.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj == null) {
                    f.this.hjL.showToast(e.j.neterror);
                } else if (obj instanceof r) {
                    int l = com.baidu.adp.lib.g.b.l(((r) obj).getFid(), 0);
                    f.this.hjM.uX(l);
                    f.this.E(l, true);
                    f.this.hjL.nw(true);
                    f.this.hjL.nv(true);
                    TiebaStatic.eventStat(f.this.hjL.getPageContext().getPageActivity(), "notlogin_12", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
            }
        });
        this.hjN = new w();
        this.hjN.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void p(String str, long j) {
                int l = com.baidu.adp.lib.g.b.l(String.valueOf(j), 0);
                f.this.hjM.uY(l);
                f.this.E(l, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void q(String str, long j) {
                f.this.hjL.showToast(e.j.error);
            }
        });
        this.hjM.setOnClickListener(this);
        this.hjM.a(this.hjj);
        ((Dialog) this.hjM).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.bEx();
            }
        });
    }

    public void E(int i, boolean z) {
        for (int i2 = 0; i2 < this.hjj.getCard_list().size(); i2++) {
            if (this.hjj.getCard_list().get(i2).getFid() == i) {
                this.hjj.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.box_close_layout) {
            this.hjM.hide();
        } else if ((view.getId() == e.g.ll_like || view.getId() == e.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.hjN.w(card.getFname(), card.getFid());
            } else {
                this.aGV.P(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.hjL == null || g.q(this.hjL.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.hjM.getRootView().setAnimation(scaleAnimation);
            this.hjM.show();
        }
    }
}
