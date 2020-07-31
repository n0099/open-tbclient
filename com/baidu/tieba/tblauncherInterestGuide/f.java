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
/* loaded from: classes16.dex */
public class f implements View.OnClickListener {
    private LikeModel emT;
    private ac hru;
    private NewUserGuideActivity lUU;
    private a lUV;
    private InterestFrsData.Tag lUs;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.lUU = newUserGuideActivity;
        this.lUs = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.lUV = new e(this.lUU.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.lUV = new b(this.lUU.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.lUV = new d(this.lUU.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.emT = new LikeModel(newUserGuideActivity.getPageContext());
        this.emT.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.lUU.showToast(R.string.neterror);
                } else if (obj instanceof u) {
                    int i = com.baidu.adp.lib.f.b.toInt(((u) obj).getFid(), 0);
                    f.this.lUV.FM(i);
                    f.this.ad(i, true);
                    f.this.lUU.vC(true);
                    f.this.lUU.vB(true);
                    TiebaStatic.eventStat(f.this.lUU.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.hru = new ac();
        this.hru.a(new ac.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ac.a
            public void x(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.lUV.FN(i);
                f.this.ad(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ac.a
            public void y(String str, long j) {
                f.this.lUU.showToast(R.string.error);
            }
        });
        this.lUV.setOnClickListener(this);
        this.lUV.a(this.lUs);
        ((Dialog) this.lUV).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dnL();
            }
        });
    }

    public void ad(int i, boolean z) {
        for (int i2 = 0; i2 < this.lUs.getCard_list().size(); i2++) {
            if (this.lUs.getCard_list().get(i2).getFid() == i) {
                this.lUs.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.lUV.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.hru.J(card.getFname(), card.getFid());
            } else {
                this.emT.ay(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.lUU == null || g.isActivityCanShowDialogOrPopupWindow(this.lUU.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.lUV.getRootView().setAnimation(scaleAnimation);
            this.lUV.show();
        }
    }
}
