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
    private LikeModel eLp;
    private ad iao;
    private InterestFrsData.Tag mLI;
    private NewUserGuideActivity mMk;
    private a mMl;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.mMk = newUserGuideActivity;
        this.mLI = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.mMl = new e(this.mMk.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.mMl = new b(this.mMk.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.mMl = new d(this.mMk.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.eLp = new LikeModel(newUserGuideActivity.getPageContext());
        this.eLp.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.mMk.showToast(R.string.neterror);
                } else if (obj instanceof v) {
                    int i = com.baidu.adp.lib.f.b.toInt(((v) obj).getFid(), 0);
                    f.this.mMl.Js(i);
                    f.this.ai(i, true);
                    f.this.mMk.xj(true);
                    f.this.mMk.xi(true);
                    TiebaStatic.eventStat(f.this.mMk.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.iao = new ad();
        this.iao.a(new ad.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void z(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.mMl.Jt(i);
                f.this.ai(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void A(String str, long j) {
                f.this.mMk.showToast(R.string.error);
            }
        });
        this.mMl.setOnClickListener(this);
        this.mMl.a(this.mLI);
        ((Dialog) this.mMl).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dGW();
            }
        });
    }

    public void ai(int i, boolean z) {
        for (int i2 = 0; i2 < this.mLI.getCard_list().size(); i2++) {
            if (this.mLI.getCard_list().get(i2).getFid() == i) {
                this.mLI.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.mMl.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.iao.L(card.getFname(), card.getFid());
            } else {
                this.eLp.aA(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.mMk == null || g.isActivityCanShowDialogOrPopupWindow(this.mMk.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.mMl.getRootView().setAnimation(scaleAnimation);
            this.mMl.show();
        }
    }
}
