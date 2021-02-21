package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes2.dex */
public class f implements View.OnClickListener {
    private LikeModel fnw;
    private ae iRW;
    private InterestFrsData.Tag nEX;
    private NewUserGuideActivity nFy;
    private a nFz;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.nFy = newUserGuideActivity;
        this.nEX = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.nFz = new e(this.nFy.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.nFz = new b(this.nFy.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.nFz = new d(this.nFy.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.fnw = new LikeModel(newUserGuideActivity.getPageContext());
        this.fnw.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.nFy.showToast(R.string.neterror);
                } else if (obj instanceof w) {
                    int i = com.baidu.adp.lib.f.b.toInt(((w) obj).getFid(), 0);
                    f.this.nFz.Kb(i);
                    f.this.ag(i, true);
                    f.this.nFy.yP(true);
                    f.this.nFy.yO(true);
                    TiebaStatic.eventStat(f.this.nFy.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.iRW = new ae();
        this.iRW.a(new ae.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ae.a
            public void B(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.nFz.Kc(i);
                f.this.ag(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ae.a
            public void C(String str, long j) {
                f.this.nFy.showToast(R.string.error);
            }
        });
        this.nFz.setOnClickListener(this);
        this.nFz.a(this.nEX);
        ((Dialog) this.nFz).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dQL();
            }
        });
    }

    public void ag(int i, boolean z) {
        for (int i2 = 0; i2 < this.nEX.getCard_list().size(); i2++) {
            if (this.nEX.getCard_list().get(i2).getFid() == i) {
                this.nEX.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.nFz.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.iRW.O(card.getFname(), card.getFid());
            } else {
                this.fnw.aP(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.nFy == null || g.isActivityCanShowDialogOrPopupWindow(this.nFy.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.nFz.getRootView().setAnimation(scaleAnimation);
            this.nFz.show();
        }
    }
}
