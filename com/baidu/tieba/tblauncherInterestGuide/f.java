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
    private LikeModel aLP;
    private InterestFrsData.Tag hwy;
    private NewUserGuideActivity hxa;
    private a hxb;
    private w hxc;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.hxa = newUserGuideActivity;
        this.hwy = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.hxb = new e(this.hxa.getPageContext().getPageActivity(), e.k.NewUserDialog);
        } else if (btype == 2) {
            this.hxb = new b(this.hxa.getPageContext().getPageActivity(), e.k.NewUserDialog);
        } else if (btype == 3) {
            this.hxb = new d(this.hxa.getPageContext().getPageActivity(), e.k.NewUserDialog);
        }
        this.aLP = new LikeModel(newUserGuideActivity.getPageContext());
        this.aLP.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj == null) {
                    f.this.hxa.showToast(e.j.neterror);
                } else if (obj instanceof r) {
                    int l = com.baidu.adp.lib.g.b.l(((r) obj).getFid(), 0);
                    f.this.hxb.wd(l);
                    f.this.E(l, true);
                    f.this.hxa.nQ(true);
                    f.this.hxa.nP(true);
                    TiebaStatic.eventStat(f.this.hxa.getPageContext().getPageActivity(), "notlogin_12", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
            }
        });
        this.hxc = new w();
        this.hxc.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void p(String str, long j) {
                int l = com.baidu.adp.lib.g.b.l(String.valueOf(j), 0);
                f.this.hxb.we(l);
                f.this.E(l, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void q(String str, long j) {
                f.this.hxa.showToast(e.j.error);
            }
        });
        this.hxb.setOnClickListener(this);
        this.hxb.a(this.hwy);
        ((Dialog) this.hxb).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.bHy();
            }
        });
    }

    public void E(int i, boolean z) {
        for (int i2 = 0; i2 < this.hwy.getCard_list().size(); i2++) {
            if (this.hwy.getCard_list().get(i2).getFid() == i) {
                this.hwy.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.box_close_layout) {
            this.hxb.hide();
        } else if ((view.getId() == e.g.ll_like || view.getId() == e.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.hxc.w(card.getFname(), card.getFid());
            } else {
                this.aLP.Q(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.hxa == null || g.q(this.hxa.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.hxb.getRootView().setAnimation(scaleAnimation);
            this.hxb.show();
        }
    }
}
