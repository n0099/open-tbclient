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
/* loaded from: classes22.dex */
public class f implements View.OnClickListener {
    private LikeModel fgf;
    private ae iEt;
    private NewUserGuideActivity ntU;
    private a ntV;
    private InterestFrsData.Tag nts;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.ntU = newUserGuideActivity;
        this.nts = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.ntV = new e(this.ntU.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.ntV = new b(this.ntU.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.ntV = new d(this.ntU.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.fgf = new LikeModel(newUserGuideActivity.getPageContext());
        this.fgf.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj == null) {
                    f.this.ntU.showToast(R.string.neterror);
                } else if (obj instanceof w) {
                    int i = com.baidu.adp.lib.f.b.toInt(((w) obj).getFid(), 0);
                    f.this.ntV.Ls(i);
                    f.this.ai(i, true);
                    f.this.ntU.yv(true);
                    f.this.ntU.yu(true);
                    TiebaStatic.eventStat(f.this.ntU.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.iEt = new ae();
        this.iEt.a(new ae.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.ae.a
            public void C(String str, long j) {
                int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(j), 0);
                f.this.ntV.Lt(i);
                f.this.ai(i, false);
            }

            @Override // com.baidu.tieba.tbadkCore.ae.a
            public void D(String str, long j) {
                f.this.ntU.showToast(R.string.error);
            }
        });
        this.ntV.setOnClickListener(this);
        this.ntV.a(this.nts);
        ((Dialog) this.ntV).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.dRX();
            }
        });
    }

    public void ai(int i, boolean z) {
        for (int i2 = 0; i2 < this.nts.getCard_list().size(); i2++) {
            if (this.nts.getCard_list().get(i2).getFid() == i) {
                this.nts.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.ntV.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.iEt.O(card.getFname(), card.getFid());
            } else {
                this.fgf.aL(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.ntU == null || g.isActivityCanShowDialogOrPopupWindow(this.ntU.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.ntV.getRootView().setAnimation(scaleAnimation);
            this.ntV.show();
        }
    }
}
