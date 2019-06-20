package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes4.dex */
public class f implements View.OnClickListener {
    private LikeModel cco;
    private InterestFrsData.Tag jfV;
    private NewUserGuideActivity jgx;
    private a jgy;
    private w jgz;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.jgx = newUserGuideActivity;
        this.jfV = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.jgy = new e(this.jgx.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.jgy = new b(this.jgx.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.jgy = new d(this.jgx.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.cco = new LikeModel(newUserGuideActivity.getPageContext());
        this.cco.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj == null) {
                    f.this.jgx.showToast(R.string.neterror);
                } else if (obj instanceof r) {
                    int f = com.baidu.adp.lib.g.b.f(((r) obj).getFid(), 0);
                    f.this.jgy.AQ(f);
                    f.this.P(f, true);
                    f.this.jgx.rg(true);
                    f.this.jgx.rf(true);
                    TiebaStatic.eventStat(f.this.jgx.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.jgz = new w();
        this.jgz.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void u(String str, long j) {
                int f = com.baidu.adp.lib.g.b.f(String.valueOf(j), 0);
                f.this.jgy.AR(f);
                f.this.P(f, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void v(String str, long j) {
                f.this.jgx.showToast(R.string.error);
            }
        });
        this.jgy.setOnClickListener(this);
        this.jgy.a(this.jfV);
        ((Dialog) this.jgy).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.cpi();
            }
        });
    }

    public void P(int i, boolean z) {
        for (int i2 = 0; i2 < this.jfV.getCard_list().size(); i2++) {
            if (this.jfV.getCard_list().get(i2).getFid() == i) {
                this.jfV.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.jgy.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.jgz.C(card.getFname(), card.getFid());
            } else {
                this.cco.ac(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.jgx == null || g.q(this.jgx.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.jgy.getRootView().setAnimation(scaleAnimation);
            this.jgy.show();
        }
    }
}
