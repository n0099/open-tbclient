package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes9.dex */
public class f implements View.OnClickListener {
    private LikeModel djU;
    private InterestFrsData.Tag knB;
    private NewUserGuideActivity kod;
    private a koe;
    private y kof;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.kod = newUserGuideActivity;
        this.knB = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.koe = new e(this.kod.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.koe = new b(this.kod.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.koe = new d(this.kod.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.djU = new LikeModel(newUserGuideActivity.getPageContext());
        this.djU.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.kod.showToast(R.string.neterror);
                } else if (obj instanceof t) {
                    int i = com.baidu.adp.lib.f.b.toInt(((t) obj).getFid(), 0);
                    f.this.koe.CP(i);
                    f.this.R(i, true);
                    f.this.kod.td(true);
                    f.this.kod.tc(true);
                    TiebaStatic.eventStat(f.this.kod.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.kof = new y();
        this.kof.a(new y.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void D(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.koe.CQ(i);
                f.this.R(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.y.a
            public void E(String str, long j) {
                f.this.kod.showToast(R.string.error);
            }
        });
        this.koe.setOnClickListener(this);
        this.koe.a(this.knB);
        ((Dialog) this.koe).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.cNx();
            }
        });
    }

    public void R(int i, boolean z) {
        for (int i2 = 0; i2 < this.knB.getCard_list().size(); i2++) {
            if (this.knB.getCard_list().get(i2).getFid() == i) {
                this.knB.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.koe.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.kof.L(card.getFname(), card.getFid());
            } else {
                this.djU.au(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.kod == null || g.isActivityCanShowDialogOrPopupWindow(this.kod.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.koe.getRootView().setAnimation(scaleAnimation);
            this.koe.show();
        }
    }
}
