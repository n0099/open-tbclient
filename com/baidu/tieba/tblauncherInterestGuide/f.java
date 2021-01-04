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
    private LikeModel fpO;
    private ae iQH;
    private NewUserGuideActivity nzT;
    private a nzU;
    private InterestFrsData.Tag nzs;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.nzT = newUserGuideActivity;
        this.nzs = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.nzU = new e(this.nzT.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.nzU = new b(this.nzT.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.nzU = new d(this.nzT.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.fpO = new LikeModel(newUserGuideActivity.getPageContext());
        this.fpO.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.nzT.showToast(R.string.neterror);
                } else if (obj instanceof w) {
                    int i = com.baidu.adp.lib.f.b.toInt(((w) obj).getFid(), 0);
                    f.this.nzU.Lo(i);
                    f.this.ag(i, true);
                    f.this.nzT.yA(true);
                    f.this.nzT.yz(true);
                    TiebaStatic.eventStat(f.this.nzT.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.iQH = new ae();
        this.iQH.a(new ae.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ae.a
            public void C(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.nzU.Lp(i);
                f.this.ag(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ae.a
            public void D(String str, long j) {
                f.this.nzT.showToast(R.string.error);
            }
        });
        this.nzU.setOnClickListener(this);
        this.nzU.a(this.nzs);
        ((Dialog) this.nzU).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dSj();
            }
        });
    }

    public void ag(int i, boolean z) {
        for (int i2 = 0; i2 < this.nzs.getCard_list().size(); i2++) {
            if (this.nzs.getCard_list().get(i2).getFid() == i) {
                this.nzs.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.nzU.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.iQH.P(card.getFname(), card.getFid());
            } else {
                this.fpO.aO(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.nzT == null || g.isActivityCanShowDialogOrPopupWindow(this.nzT.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.nzU.getRootView().setAnimation(scaleAnimation);
            this.nzU.show();
        }
    }
}
