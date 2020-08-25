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
    private LikeModel ewX;
    private ad hEl;
    private NewUserGuideActivity mmJ;
    private a mmK;
    private InterestFrsData.Tag mmh;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.mmJ = newUserGuideActivity;
        this.mmh = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.mmK = new e(this.mmJ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.mmK = new b(this.mmJ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.mmK = new d(this.mmJ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.ewX = new LikeModel(newUserGuideActivity.getPageContext());
        this.ewX.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.mmJ.showToast(R.string.neterror);
                } else if (obj instanceof v) {
                    int i = com.baidu.adp.lib.f.b.toInt(((v) obj).getFid(), 0);
                    f.this.mmK.Ii(i);
                    f.this.af(i, true);
                    f.this.mmJ.wr(true);
                    f.this.mmJ.wq(true);
                    TiebaStatic.eventStat(f.this.mmJ.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.hEl = new ad();
        this.hEl.a(new ad.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void y(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.mmK.Ij(i);
                f.this.af(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void z(String str, long j) {
                f.this.mmJ.showToast(R.string.error);
            }
        });
        this.mmK.setOnClickListener(this);
        this.mmK.a(this.mmh);
        ((Dialog) this.mmK).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dzh();
            }
        });
    }

    public void af(int i, boolean z) {
        for (int i2 = 0; i2 < this.mmh.getCard_list().size(); i2++) {
            if (this.mmh.getCard_list().get(i2).getFid() == i) {
                this.mmh.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.mmK.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.hEl.K(card.getFname(), card.getFid());
            } else {
                this.ewX.ay(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.mmJ == null || g.isActivityCanShowDialogOrPopupWindow(this.mmJ.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.mmK.getRootView().setAnimation(scaleAnimation);
            this.mmK.show();
        }
    }
}
