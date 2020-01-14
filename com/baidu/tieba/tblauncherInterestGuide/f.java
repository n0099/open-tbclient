package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes7.dex */
public class f implements View.OnClickListener {
    private LikeModel dfN;
    private InterestFrsData.Tag kmC;
    private NewUserGuideActivity kne;
    private a knf;
    private y kng;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.kne = newUserGuideActivity;
        this.kmC = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.knf = new e(this.kne.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.knf = new b(this.kne.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.knf = new d(this.kne.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.dfN = new LikeModel(newUserGuideActivity.getPageContext());
        this.dfN.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.kne.showToast(R.string.neterror);
                } else if (obj instanceof t) {
                    int i = com.baidu.adp.lib.f.b.toInt(((t) obj).getFid(), 0);
                    f.this.knf.CJ(i);
                    f.this.S(i, true);
                    f.this.kne.sZ(true);
                    f.this.kne.sY(true);
                    TiebaStatic.eventStat(f.this.kne.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.kng = new y();
        this.kng.a(new y.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void D(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.knf.CK(i);
                f.this.S(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.y.a
            public void E(String str, long j) {
                f.this.kne.showToast(R.string.error);
            }
        });
        this.knf.setOnClickListener(this);
        this.knf.a(this.kmC);
        ((Dialog) this.knf).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.cMa();
            }
        });
    }

    public void S(int i, boolean z) {
        for (int i2 = 0; i2 < this.kmC.getCard_list().size(); i2++) {
            if (this.kmC.getCard_list().get(i2).getFid() == i) {
                this.kmC.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.knf.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.kng.L(card.getFname(), card.getFid());
            } else {
                this.dfN.au(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.kne == null || g.isActivityCanShowDialogOrPopupWindow(this.kne.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.knf.getRootView().setAnimation(scaleAnimation);
            this.knf.show();
        }
    }
}
