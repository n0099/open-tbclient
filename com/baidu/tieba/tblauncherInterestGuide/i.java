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
    private LikeModel cdg;
    private NewUserGuideActivity hgP;
    private a hgQ;
    private w hgR;
    private InterestFrsData.Tag hgn;

    public i(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final f.a aVar) {
        this.hgP = newUserGuideActivity;
        this.hgn = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.hgQ = new h(this.hgP.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 2) {
            this.hgQ = new b(this.hgP.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 3) {
            this.hgQ = new d(this.hgP.getPageContext().getPageActivity(), d.k.NewUserDialog);
        }
        this.cdg = new LikeModel(newUserGuideActivity.getPageContext());
        this.cdg.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.i.1
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj == null) {
                    i.this.hgP.showToast(d.j.neterror);
                } else if (obj instanceof r) {
                    int h = com.baidu.adp.lib.g.b.h(((r) obj).getFid(), 0);
                    i.this.hgQ.wg(h);
                    i.this.T(h, true);
                    i.this.hgP.mY(true);
                    i.this.hgP.mX(true);
                    TiebaStatic.eventStat(i.this.hgP.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.hgR = new w();
        this.hgR.a(new w.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.i.2
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void m(String str, long j) {
                int h = com.baidu.adp.lib.g.b.h(String.valueOf(j), 0);
                i.this.hgQ.wh(h);
                i.this.T(h, false);
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void n(String str, long j) {
                i.this.hgP.showToast(d.j.error);
            }
        });
        this.hgQ.setOnClickListener(this);
        this.hgQ.a(this.hgn);
        ((Dialog) this.hgQ).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.i.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.bzh();
            }
        });
    }

    public void T(int i, boolean z) {
        for (int i2 = 0; i2 < this.hgn.getCard_list().size(); i2++) {
            if (this.hgn.getCard_list().get(i2).getFid() == i) {
                this.hgn.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.box_close_layout) {
            this.hgQ.hide();
        } else if ((view.getId() == d.g.ll_like || view.getId() == d.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.hgR.t(card.getFname(), card.getFid());
            } else {
                this.cdg.L(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.hgP == null || com.baidu.adp.lib.g.g.o(this.hgP.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.hgQ.getRootView().setAnimation(scaleAnimation);
            this.hgQ.show();
        }
    }
}
