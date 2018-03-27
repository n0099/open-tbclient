package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.tieba.tblauncherInterestGuide.f;
/* loaded from: classes3.dex */
public class i implements View.OnClickListener {
    private LikeModel ccX;
    private NewUserGuideActivity hgY;
    private a hgZ;
    private InterestFrsData.Tag hgw;
    private x hha;

    public i(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final f.a aVar) {
        this.hgY = newUserGuideActivity;
        this.hgw = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.hgZ = new h(this.hgY.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 2) {
            this.hgZ = new b(this.hgY.getPageContext().getPageActivity(), d.k.NewUserDialog);
        } else if (btype == 3) {
            this.hgZ = new d(this.hgY.getPageContext().getPageActivity(), d.k.NewUserDialog);
        }
        this.ccX = new LikeModel(newUserGuideActivity.getPageContext());
        this.ccX.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.i.1
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj == null) {
                    i.this.hgY.showToast(d.j.neterror);
                } else if (obj instanceof s) {
                    int h = com.baidu.adp.lib.g.b.h(((s) obj).getFid(), 0);
                    i.this.hgZ.wh(h);
                    i.this.T(h, true);
                    i.this.hgY.nd(true);
                    i.this.hgY.nc(true);
                    TiebaStatic.eventStat(i.this.hgY.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.hha = new x();
        this.hha.a(new x.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.i.2
            @Override // com.baidu.tieba.tbadkCore.x.a
            public void m(String str, long j) {
                int h = com.baidu.adp.lib.g.b.h(String.valueOf(j), 0);
                i.this.hgZ.wi(h);
                i.this.T(h, false);
            }

            @Override // com.baidu.tieba.tbadkCore.x.a
            public void n(String str, long j) {
                i.this.hgY.showToast(d.j.error);
            }
        });
        this.hgZ.setOnClickListener(this);
        this.hgZ.a(this.hgw);
        ((Dialog) this.hgZ).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.i.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.bzl();
            }
        });
    }

    public void T(int i, boolean z) {
        for (int i2 = 0; i2 < this.hgw.getCard_list().size(); i2++) {
            if (this.hgw.getCard_list().get(i2).getFid() == i) {
                this.hgw.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.box_close_layout) {
            this.hgZ.hide();
        } else if ((view.getId() == d.g.ll_like || view.getId() == d.g.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.hha.t(card.getFname(), card.getFid());
            } else {
                this.ccX.L(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.hgY == null || com.baidu.adp.lib.g.g.o(this.hgY.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.hgZ.getRootView().setAnimation(scaleAnimation);
            this.hgZ.show();
        }
    }
}
