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
    private LikeModel foW;
    private ae iTF;
    private NewUserGuideActivity nHE;
    private a nHF;
    private InterestFrsData.Tag nHd;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.nHE = newUserGuideActivity;
        this.nHd = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.nHF = new e(this.nHE.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.nHF = new b(this.nHE.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.nHF = new d(this.nHE.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.foW = new LikeModel(newUserGuideActivity.getPageContext());
        this.foW.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.nHE.showToast(R.string.neterror);
                } else if (obj instanceof w) {
                    int i = com.baidu.adp.lib.f.b.toInt(((w) obj).getFid(), 0);
                    f.this.nHF.Kg(i);
                    f.this.ag(i, true);
                    f.this.nHE.yO(true);
                    f.this.nHE.yN(true);
                    TiebaStatic.eventStat(f.this.nHE.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.iTF = new ae();
        this.iTF.a(new ae.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ae.a
            public void B(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.nHF.Kh(i);
                f.this.ag(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ae.a
            public void C(String str, long j) {
                f.this.nHE.showToast(R.string.error);
            }
        });
        this.nHF.setOnClickListener(this);
        this.nHF.a(this.nHd);
        ((Dialog) this.nHF).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dQU();
            }
        });
    }

    public void ag(int i, boolean z) {
        for (int i2 = 0; i2 < this.nHd.getCard_list().size(); i2++) {
            if (this.nHd.getCard_list().get(i2).getFid() == i) {
                this.nHd.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.nHF.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.iTF.O(card.getFname(), card.getFid());
            } else {
                this.foW.aP(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.nHE == null || g.isActivityCanShowDialogOrPopupWindow(this.nHE.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.nHF.getRootView().setAnimation(scaleAnimation);
            this.nHF.show();
        }
    }
}
