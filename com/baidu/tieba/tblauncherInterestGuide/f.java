package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes22.dex */
public class f implements View.OnClickListener {
    private LikeModel eTL;
    private ad imP;
    private NewUserGuideActivity mYT;
    private a mYU;
    private InterestFrsData.Tag mYr;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.mYT = newUserGuideActivity;
        this.mYr = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.mYU = new e(this.mYT.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.mYU = new b(this.mYT.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.mYU = new d(this.mYT.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.eTL = new LikeModel(newUserGuideActivity.getPageContext());
        this.eTL.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.mYT.showToast(R.string.neterror);
                } else if (obj instanceof v) {
                    int i = com.baidu.adp.lib.f.b.toInt(((v) obj).getFid(), 0);
                    f.this.mYU.JK(i);
                    f.this.ai(i, true);
                    f.this.mYT.xA(true);
                    f.this.mYT.xz(true);
                    TiebaStatic.eventStat(f.this.mYT.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.imP = new ad();
        this.imP.a(new ad.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void C(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.mYU.JL(i);
                f.this.ai(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void D(String str, long j) {
                f.this.mYT.showToast(R.string.error);
            }
        });
        this.mYU.setOnClickListener(this);
        this.mYU.a(this.mYr);
        ((Dialog) this.mYU).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dKe();
            }
        });
    }

    public void ai(int i, boolean z) {
        for (int i2 = 0; i2 < this.mYr.getCard_list().size(); i2++) {
            if (this.mYr.getCard_list().get(i2).getFid() == i) {
                this.mYr.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.mYU.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.imP.O(card.getFname(), card.getFid());
            } else {
                this.eTL.aH(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.mYT == null || g.isActivityCanShowDialogOrPopupWindow(this.mYT.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.mYU.getRootView().setAnimation(scaleAnimation);
            this.mYU.show();
        }
    }
}
