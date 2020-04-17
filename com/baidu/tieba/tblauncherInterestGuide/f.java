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
    private LikeModel dKo;
    private ac gKt;
    private NewUserGuideActivity kZZ;
    private InterestFrsData.Tag kZx;
    private a laa;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.kZZ = newUserGuideActivity;
        this.kZx = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.laa = new e(this.kZZ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.laa = new b(this.kZZ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.laa = new d(this.kZZ.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.dKo = new LikeModel(newUserGuideActivity.getPageContext());
        this.dKo.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.kZZ.showToast(R.string.neterror);
                } else if (obj instanceof u) {
                    int i = com.baidu.adp.lib.f.b.toInt(((u) obj).getFid(), 0);
                    f.this.laa.DB(i);
                    f.this.X(i, true);
                    f.this.kZZ.ul(true);
                    f.this.kZZ.uk(true);
                    TiebaStatic.eventStat(f.this.kZZ.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.gKt = new ac();
        this.gKt.a(new ac.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ac.a
            public void A(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.laa.DC(i);
                f.this.X(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ac.a
            public void B(String str, long j) {
                f.this.kZZ.showToast(R.string.error);
            }
        });
        this.laa.setOnClickListener(this);
        this.laa.a(this.kZx);
        ((Dialog) this.laa).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.cYP();
            }
        });
    }

    public void X(int i, boolean z) {
        for (int i2 = 0; i2 < this.kZx.getCard_list().size(); i2++) {
            if (this.kZx.getCard_list().get(i2).getFid() == i) {
                this.kZx.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.laa.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.gKt.L(card.getFname(), card.getFid());
            } else {
                this.dKo.au(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.kZZ == null || g.isActivityCanShowDialogOrPopupWindow(this.kZZ.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.laa.getRootView().setAnimation(scaleAnimation);
            this.laa.show();
        }
    }
}
