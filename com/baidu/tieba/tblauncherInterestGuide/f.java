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
    private NewUserGuideActivity kmZ;
    private InterestFrsData.Tag kmx;
    private a kna;
    private y knb;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.kmZ = newUserGuideActivity;
        this.kmx = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.kna = new e(this.kmZ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.kna = new b(this.kmZ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.kna = new d(this.kmZ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.dfN = new LikeModel(newUserGuideActivity.getPageContext());
        this.dfN.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.kmZ.showToast(R.string.neterror);
                } else if (obj instanceof t) {
                    int i = com.baidu.adp.lib.f.b.toInt(((t) obj).getFid(), 0);
                    f.this.kna.CJ(i);
                    f.this.S(i, true);
                    f.this.kmZ.sZ(true);
                    f.this.kmZ.sY(true);
                    TiebaStatic.eventStat(f.this.kmZ.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.knb = new y();
        this.knb.a(new y.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void D(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.kna.CK(i);
                f.this.S(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.y.a
            public void E(String str, long j) {
                f.this.kmZ.showToast(R.string.error);
            }
        });
        this.kna.setOnClickListener(this);
        this.kna.a(this.kmx);
        ((Dialog) this.kna).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.cLY();
            }
        });
    }

    public void S(int i, boolean z) {
        for (int i2 = 0; i2 < this.kmx.getCard_list().size(); i2++) {
            if (this.kmx.getCard_list().get(i2).getFid() == i) {
                this.kmx.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.kna.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.knb.L(card.getFname(), card.getFid());
            } else {
                this.dfN.au(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.kmZ == null || g.isActivityCanShowDialogOrPopupWindow(this.kmZ.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.kna.getRootView().setAnimation(scaleAnimation);
            this.kna.show();
        }
    }
}
