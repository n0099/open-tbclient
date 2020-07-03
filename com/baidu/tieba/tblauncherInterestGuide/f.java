package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes9.dex */
public class f implements View.OnClickListener {
    private LikeModel egK;
    private ac hlI;
    private NewUserGuideActivity lNE;
    private a lNF;
    private InterestFrsData.Tag lNc;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.lNE = newUserGuideActivity;
        this.lNc = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.lNF = new e(this.lNE.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.lNF = new b(this.lNE.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.lNF = new d(this.lNE.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.egK = new LikeModel(newUserGuideActivity.getPageContext());
        this.egK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.lNE.showToast(R.string.neterror);
                } else if (obj instanceof u) {
                    int i = com.baidu.adp.lib.f.b.toInt(((u) obj).getFid(), 0);
                    f.this.lNF.Fq(i);
                    f.this.ae(i, true);
                    f.this.lNE.uY(true);
                    f.this.lNE.uX(true);
                    TiebaStatic.eventStat(f.this.lNE.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.hlI = new ac();
        this.hlI.a(new ac.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ac.a
            public void z(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.lNF.Fr(i);
                f.this.ae(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ac.a
            public void A(String str, long j) {
                f.this.lNE.showToast(R.string.error);
            }
        });
        this.lNF.setOnClickListener(this);
        this.lNF.a(this.lNc);
        ((Dialog) this.lNF).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dky();
            }
        });
    }

    public void ae(int i, boolean z) {
        for (int i2 = 0; i2 < this.lNc.getCard_list().size(); i2++) {
            if (this.lNc.getCard_list().get(i2).getFid() == i) {
                this.lNc.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.lNF.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.hlI.K(card.getFname(), card.getFid());
            } else {
                this.egK.az(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.lNE == null || g.isActivityCanShowDialogOrPopupWindow(this.lNE.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.lNF.getRootView().setAnimation(scaleAnimation);
            this.lNF.show();
        }
    }
}
