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
/* loaded from: classes16.dex */
public class f implements View.OnClickListener {
    private LikeModel exb;
    private ad hEr;
    private InterestFrsData.Tag mmz;
    private NewUserGuideActivity mnb;
    private a mnc;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.mnb = newUserGuideActivity;
        this.mmz = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.mnc = new e(this.mnb.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.mnc = new b(this.mnb.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.mnc = new d(this.mnb.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.exb = new LikeModel(newUserGuideActivity.getPageContext());
        this.exb.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.mnb.showToast(R.string.neterror);
                } else if (obj instanceof v) {
                    int i = com.baidu.adp.lib.f.b.toInt(((v) obj).getFid(), 0);
                    f.this.mnc.Ii(i);
                    f.this.af(i, true);
                    f.this.mnb.wt(true);
                    f.this.mnb.ws(true);
                    TiebaStatic.eventStat(f.this.mnb.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.hEr = new ad();
        this.hEr.a(new ad.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void y(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.mnc.Ij(i);
                f.this.af(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void z(String str, long j) {
                f.this.mnb.showToast(R.string.error);
            }
        });
        this.mnc.setOnClickListener(this);
        this.mnc.a(this.mmz);
        ((Dialog) this.mnc).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dzq();
            }
        });
    }

    public void af(int i, boolean z) {
        for (int i2 = 0; i2 < this.mmz.getCard_list().size(); i2++) {
            if (this.mmz.getCard_list().get(i2).getFid() == i) {
                this.mmz.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.mnc.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.hEr.K(card.getFname(), card.getFid());
            } else {
                this.exb.ay(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.mnb == null || g.isActivityCanShowDialogOrPopupWindow(this.mnb.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.mnc.getRootView().setAnimation(scaleAnimation);
            this.mnc.show();
        }
    }
}
