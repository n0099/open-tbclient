package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes4.dex */
public class f implements View.OnClickListener {
    private LikeModel cdy;
    private NewUserGuideActivity jnO;
    private a jnP;
    private y jnQ;
    private InterestFrsData.Tag jnm;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.jnO = newUserGuideActivity;
        this.jnm = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.jnP = new e(this.jnO.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.jnP = new b(this.jnO.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.jnP = new d(this.jnO.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.cdy = new LikeModel(newUserGuideActivity.getPageContext());
        this.cdy.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj == null) {
                    f.this.jnO.showToast(R.string.neterror);
                } else if (obj instanceof t) {
                    int f = com.baidu.adp.lib.g.b.f(((t) obj).getFid(), 0);
                    f.this.jnP.Bz(f);
                    f.this.R(f, true);
                    f.this.jnO.ru(true);
                    f.this.jnO.rt(true);
                    TiebaStatic.eventStat(f.this.jnO.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.jnQ = new y();
        this.jnQ.a(new y.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void u(String str, long j) {
                int f = com.baidu.adp.lib.g.b.f(String.valueOf(j), 0);
                f.this.jnP.BA(f);
                f.this.R(f, false);
            }

            @Override // com.baidu.tieba.tbadkCore.y.a
            public void v(String str, long j) {
                f.this.jnO.showToast(R.string.error);
            }
        });
        this.jnP.setOnClickListener(this);
        this.jnP.a(this.jnm);
        ((Dialog) this.jnP).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.csn();
            }
        });
    }

    public void R(int i, boolean z) {
        for (int i2 = 0; i2 < this.jnm.getCard_list().size(); i2++) {
            if (this.jnm.getCard_list().get(i2).getFid() == i) {
                this.jnm.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.jnP.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.jnQ.C(card.getFname(), card.getFid());
            } else {
                this.cdy.ac(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.jnO == null || g.t(this.jnO.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.jnP.getRootView().setAnimation(scaleAnimation);
            this.jnP.show();
        }
    }
}
