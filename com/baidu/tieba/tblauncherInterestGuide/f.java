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
    private NewUserGuideActivity lNH;
    private a lNI;
    private InterestFrsData.Tag lNf;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.lNH = newUserGuideActivity;
        this.lNf = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.lNI = new e(this.lNH.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.lNI = new b(this.lNH.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.lNI = new d(this.lNH.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.egK = new LikeModel(newUserGuideActivity.getPageContext());
        this.egK.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.lNH.showToast(R.string.neterror);
                } else if (obj instanceof u) {
                    int i = com.baidu.adp.lib.f.b.toInt(((u) obj).getFid(), 0);
                    f.this.lNI.Fq(i);
                    f.this.ae(i, true);
                    f.this.lNH.uY(true);
                    f.this.lNH.uX(true);
                    TiebaStatic.eventStat(f.this.lNH.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.hlI = new ac();
        this.hlI.a(new ac.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ac.a
            public void z(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.lNI.Fr(i);
                f.this.ae(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ac.a
            public void A(String str, long j) {
                f.this.lNH.showToast(R.string.error);
            }
        });
        this.lNI.setOnClickListener(this);
        this.lNI.a(this.lNf);
        ((Dialog) this.lNI).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dkC();
            }
        });
    }

    public void ae(int i, boolean z) {
        for (int i2 = 0; i2 < this.lNf.getCard_list().size(); i2++) {
            if (this.lNf.getCard_list().get(i2).getFid() == i) {
                this.lNf.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.lNI.hide();
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
        if (this.lNH == null || g.isActivityCanShowDialogOrPopupWindow(this.lNH.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.lNI.getRootView().setAnimation(scaleAnimation);
            this.lNI.show();
        }
    }
}
