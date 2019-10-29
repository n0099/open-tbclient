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
    private LikeModel csF;
    private InterestFrsData.Tag jpz;
    private NewUserGuideActivity jqb;
    private a jqc;
    private y jqd;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.jqb = newUserGuideActivity;
        this.jpz = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.jqc = new e(this.jqb.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.jqc = new b(this.jqb.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.jqc = new d(this.jqb.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.csF = new LikeModel(newUserGuideActivity.getPageContext());
        this.csF.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.jqb.showToast(R.string.neterror);
                } else if (obj instanceof t) {
                    int i = com.baidu.adp.lib.g.b.toInt(((t) obj).getFid(), 0);
                    f.this.jqc.Aj(i);
                    f.this.Q(i, true);
                    f.this.jqb.rg(true);
                    f.this.jqb.rf(true);
                    TiebaStatic.eventStat(f.this.jqb.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.jqd = new y();
        this.jqd.a(new y.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void A(String str, long j) {
                int i = com.baidu.adp.lib.g.b.toInt(String.valueOf(j), 0);
                f.this.jqc.Ak(i);
                f.this.Q(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.y.a
            public void B(String str, long j) {
                f.this.jqb.showToast(R.string.error);
            }
        });
        this.jqc.setOnClickListener(this);
        this.jqc.a(this.jpz);
        ((Dialog) this.jqc).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.cqQ();
            }
        });
    }

    public void Q(int i, boolean z) {
        for (int i2 = 0; i2 < this.jpz.getCard_list().size(); i2++) {
            if (this.jpz.getCard_list().get(i2).getFid() == i) {
                this.jpz.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.jqc.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.jqd.I(card.getFname(), card.getFid());
            } else {
                this.csF.ag(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.jqb == null || g.isActivityCanShowDialogOrPopupWindow(this.jqb.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.jqc.getRootView().setAnimation(scaleAnimation);
            this.jqc.show();
        }
    }
}
