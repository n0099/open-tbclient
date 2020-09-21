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
/* loaded from: classes21.dex */
public class f implements View.OnClickListener {
    private LikeModel ezi;
    private ad hLt;
    private InterestFrsData.Tag mvY;
    private NewUserGuideActivity mwA;
    private a mwB;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.mwA = newUserGuideActivity;
        this.mvY = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.mwB = new e(this.mwA.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.mwB = new b(this.mwA.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.mwB = new d(this.mwA.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.ezi = new LikeModel(newUserGuideActivity.getPageContext());
        this.ezi.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.mwA.showToast(R.string.neterror);
                } else if (obj instanceof v) {
                    int i = com.baidu.adp.lib.f.b.toInt(((v) obj).getFid(), 0);
                    f.this.mwB.IL(i);
                    f.this.ag(i, true);
                    f.this.mwA.wC(true);
                    f.this.mwA.wB(true);
                    TiebaStatic.eventStat(f.this.mwA.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.hLt = new ad();
        this.hLt.a(new ad.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void z(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.mwB.IM(i);
                f.this.ag(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void A(String str, long j) {
                f.this.mwA.showToast(R.string.error);
            }
        });
        this.mwB.setOnClickListener(this);
        this.mwB.a(this.mvY);
        ((Dialog) this.mwB).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dDk();
            }
        });
    }

    public void ag(int i, boolean z) {
        for (int i2 = 0; i2 < this.mvY.getCard_list().size(); i2++) {
            if (this.mvY.getCard_list().get(i2).getFid() == i) {
                this.mvY.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.mwB.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.hLt.L(card.getFname(), card.getFid());
            } else {
                this.ezi.ay(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.mwA == null || g.isActivityCanShowDialogOrPopupWindow(this.mwA.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.mwB.getRootView().setAnimation(scaleAnimation);
            this.mwB.show();
        }
    }
}
