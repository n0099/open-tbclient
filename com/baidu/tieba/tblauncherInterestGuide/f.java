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
    private LikeModel dKs;
    private ac gKz;
    private InterestFrsData.Tag kZB;
    private NewUserGuideActivity lad;
    private a lae;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.lad = newUserGuideActivity;
        this.kZB = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.lae = new e(this.lad.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.lae = new b(this.lad.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.lae = new d(this.lad.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.dKs = new LikeModel(newUserGuideActivity.getPageContext());
        this.dKs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.lad.showToast(R.string.neterror);
                } else if (obj instanceof u) {
                    int i = com.baidu.adp.lib.f.b.toInt(((u) obj).getFid(), 0);
                    f.this.lae.DB(i);
                    f.this.X(i, true);
                    f.this.lad.ul(true);
                    f.this.lad.uk(true);
                    TiebaStatic.eventStat(f.this.lad.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.gKz = new ac();
        this.gKz.a(new ac.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ac.a
            public void A(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.lae.DC(i);
                f.this.X(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ac.a
            public void B(String str, long j) {
                f.this.lad.showToast(R.string.error);
            }
        });
        this.lae.setOnClickListener(this);
        this.lae.a(this.kZB);
        ((Dialog) this.lae).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.cYN();
            }
        });
    }

    public void X(int i, boolean z) {
        for (int i2 = 0; i2 < this.kZB.getCard_list().size(); i2++) {
            if (this.kZB.getCard_list().get(i2).getFid() == i) {
                this.kZB.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.lae.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.gKz.L(card.getFname(), card.getFid());
            } else {
                this.dKs.au(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.lad == null || g.isActivityCanShowDialogOrPopupWindow(this.lad.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.lae.getRootView().setAnimation(scaleAnimation);
            this.lae.show();
        }
    }
}
