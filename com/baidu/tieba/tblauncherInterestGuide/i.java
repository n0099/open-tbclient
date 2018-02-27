package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.f;
/* loaded from: classes3.dex */
public class i implements View.OnClickListener {
    private LikeModel ccU;
    private InterestFrsData.Tag hfY;
    private NewUserGuideActivity hgA;
    private a hgB;
    private w hgC;

    public i(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final f.a aVar) {
        this.hgA = newUserGuideActivity;
        this.hfY = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.hgB = new h(this.hgA.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 2) {
            this.hgB = new b(this.hgA.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 3) {
            this.hgB = new d(this.hgA.getPageContext().getPageActivity(), d.k.NewUserDialog);
        }
        this.ccU = new LikeModel(newUserGuideActivity.getPageContext());
        this.ccU.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.i.1
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj == null) {
                    i.this.hgA.showToast(d.j.neterror);
                } else if (obj instanceof r) {
                    int h = com.baidu.adp.lib.g.b.h(((r) obj).getFid(), 0);
                    i.this.hgB.wh(h);
                    i.this.T(h, true);
                    i.this.hgA.mY(true);
                    i.this.hgA.mX(true);
                    TiebaStatic.eventStat(i.this.hgA.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.hgC = new w();
        this.hgC.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.i.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                int h = com.baidu.adp.lib.g.b.h(String.valueOf(j), 0);
                i.this.hgB.wi(h);
                i.this.T(h, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
                i.this.hgA.showToast(d.j.error);
            }
        });
        this.hgB.setOnClickListener(this);
        this.hgB.a(this.hfY);
        ((Dialog) this.hgB).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.i.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.bzg();
            }
        });
    }

    public void T(int i, boolean z) {
        for (int i2 = 0; i2 < this.hfY.getCard_list().size(); i2++) {
            if (this.hfY.getCard_list().get(i2).getFid() == i) {
                this.hfY.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.box_close_layout) {
            this.hgB.hide();
        } else if ((view.getId() == d.g.ll_like || view.getId() == d.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.hgC.t(card.getFname(), card.getFid());
            } else {
                this.ccU.L(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.hgA == null || com.baidu.adp.lib.g.g.o(this.hgA.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.hgB.getRootView().setAnimation(scaleAnimation);
            this.hgB.show();
        }
    }
}
