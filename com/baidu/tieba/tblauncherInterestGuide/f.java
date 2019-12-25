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
/* loaded from: classes6.dex */
public class f implements View.OnClickListener {
    private LikeModel dfB;
    private InterestFrsData.Tag kiU;
    private NewUserGuideActivity kjw;
    private a kjx;
    private y kjy;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.kjw = newUserGuideActivity;
        this.kiU = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.kjx = new e(this.kjw.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.kjx = new b(this.kjw.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.kjx = new d(this.kjw.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.dfB = new LikeModel(newUserGuideActivity.getPageContext());
        this.dfB.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.kjw.showToast(R.string.neterror);
                } else if (obj instanceof t) {
                    int i = com.baidu.adp.lib.f.b.toInt(((t) obj).getFid(), 0);
                    f.this.kjx.CD(i);
                    f.this.S(i, true);
                    f.this.kjw.sN(true);
                    f.this.kjw.sM(true);
                    TiebaStatic.eventStat(f.this.kjw.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.kjy = new y();
        this.kjy.a(new y.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void C(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.kjx.CE(i);
                f.this.S(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.y.a
            public void D(String str, long j) {
                f.this.kjw.showToast(R.string.error);
            }
        });
        this.kjx.setOnClickListener(this);
        this.kjx.a(this.kiU);
        ((Dialog) this.kjx).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.cKT();
            }
        });
    }

    public void S(int i, boolean z) {
        for (int i2 = 0; i2 < this.kiU.getCard_list().size(); i2++) {
            if (this.kiU.getCard_list().get(i2).getFid() == i) {
                this.kiU.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.kjx.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.kjy.K(card.getFname(), card.getFid());
            } else {
                this.dfB.at(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.kjw == null || g.isActivityCanShowDialogOrPopupWindow(this.kjw.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.kjx.getRootView().setAnimation(scaleAnimation);
            this.kjx.show();
        }
    }
}
