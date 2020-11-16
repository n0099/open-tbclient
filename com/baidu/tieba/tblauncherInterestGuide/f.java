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
    private LikeModel eYI;
    private ad itB;
    private NewUserGuideActivity nfQ;
    private a nfR;
    private InterestFrsData.Tag nfo;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.nfQ = newUserGuideActivity;
        this.nfo = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.nfR = new e(this.nfQ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.nfR = new b(this.nfQ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.nfR = new d(this.nfQ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.eYI = new LikeModel(newUserGuideActivity.getPageContext());
        this.eYI.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.nfQ.showToast(R.string.neterror);
                } else if (obj instanceof v) {
                    int i = com.baidu.adp.lib.f.b.toInt(((v) obj).getFid(), 0);
                    f.this.nfR.KA(i);
                    f.this.ai(i, true);
                    f.this.nfQ.xQ(true);
                    f.this.nfQ.xP(true);
                    TiebaStatic.eventStat(f.this.nfQ.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.itB = new ad();
        this.itB.a(new ad.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void C(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.nfR.KB(i);
                f.this.ai(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ad.a
            public void D(String str, long j) {
                f.this.nfQ.showToast(R.string.error);
            }
        });
        this.nfR.setOnClickListener(this);
        this.nfR.a(this.nfo);
        ((Dialog) this.nfR).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dMF();
            }
        });
    }

    public void ai(int i, boolean z) {
        for (int i2 = 0; i2 < this.nfo.getCard_list().size(); i2++) {
            if (this.nfo.getCard_list().get(i2).getFid() == i) {
                this.nfo.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.nfR.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.itB.O(card.getFname(), card.getFid());
            } else {
                this.eYI.aI(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.nfQ == null || g.isActivityCanShowDialogOrPopupWindow(this.nfQ.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.nfR.getRootView().setAnimation(scaleAnimation);
            this.nfR.show();
        }
    }
}
