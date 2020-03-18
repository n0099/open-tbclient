package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.z;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes9.dex */
public class f implements View.OnClickListener {
    private LikeModel dku;
    private NewUserGuideActivity kpT;
    private a kpU;
    private z kpV;
    private InterestFrsData.Tag kpr;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.kpT = newUserGuideActivity;
        this.kpr = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.kpU = new e(this.kpT.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.kpU = new b(this.kpT.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.kpU = new d(this.kpT.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.dku = new LikeModel(newUserGuideActivity.getPageContext());
        this.dku.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.kpT.showToast(R.string.neterror);
                } else if (obj instanceof u) {
                    int i = com.baidu.adp.lib.f.b.toInt(((u) obj).getFid(), 0);
                    f.this.kpU.CX(i);
                    f.this.R(i, true);
                    f.this.kpT.tj(true);
                    f.this.kpT.ti(true);
                    TiebaStatic.eventStat(f.this.kpT.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.kpV = new z();
        this.kpV.a(new z.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.z.a
            public void D(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.kpU.CY(i);
                f.this.R(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.z.a
            public void E(String str, long j) {
                f.this.kpT.showToast(R.string.error);
            }
        });
        this.kpU.setOnClickListener(this);
        this.kpU.a(this.kpr);
        ((Dialog) this.kpU).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.cNS();
            }
        });
    }

    public void R(int i, boolean z) {
        for (int i2 = 0; i2 < this.kpr.getCard_list().size(); i2++) {
            if (this.kpr.getCard_list().get(i2).getFid() == i) {
                this.kpr.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.kpU.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.kpV.L(card.getFname(), card.getFid());
            } else {
                this.dku.au(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.kpT == null || g.isActivityCanShowDialogOrPopupWindow(this.kpT.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.kpU.getRootView().setAnimation(scaleAnimation);
            this.kpU.show();
        }
    }
}
