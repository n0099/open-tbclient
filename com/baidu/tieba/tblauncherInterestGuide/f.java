package com.baidu.tieba.tblauncherInterestGuide;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.animation.ScaleAnimation;
import com.baidu.adp.lib.g.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tblauncherInterestGuide.NewUserGuideMainFragment;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes4.dex */
public class f implements View.OnClickListener {
    private LikeModel cer;
    private InterestFrsData.Tag jpH;
    private NewUserGuideActivity jqj;
    private a jqk;
    private y jql;

    public f(NewUserGuideActivity newUserGuideActivity, InterestFrsData.Tag tag, final NewUserGuideMainFragment.a aVar) {
        this.jqj = newUserGuideActivity;
        this.jpH = tag;
        int btype = tag.getBtype();
        if (btype == 1) {
            this.jqk = new e(this.jqj.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 2) {
            this.jqk = new b(this.jqj.getPageContext().getPageActivity(), R.style.NewUserDialog);
        } else if (btype == 3) {
            this.jqk = new d(this.jqj.getPageContext().getPageActivity(), R.style.NewUserDialog);
        }
        this.cer = new LikeModel(newUserGuideActivity.getPageContext());
        this.cer.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.1
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj == null) {
                    f.this.jqj.showToast(R.string.neterror);
                } else if (obj instanceof t) {
                    int f = com.baidu.adp.lib.g.b.f(((t) obj).getFid(), 0);
                    f.this.jqk.BD(f);
                    f.this.S(f, true);
                    f.this.jqj.rx(true);
                    f.this.jqj.rw(true);
                    TiebaStatic.eventStat(f.this.jqj.getPageContext().getPageActivity(), "notlogin_12", "click", 1, new Object[0]);
                }
            }
        });
        this.jql = new y();
        this.jql.a(new y.a() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.2
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void w(String str, long j) {
                int f = com.baidu.adp.lib.g.b.f(String.valueOf(j), 0);
                f.this.jqk.BE(f);
                f.this.S(f, false);
            }

            @Override // com.baidu.tieba.tbadkCore.y.a
            public void x(String str, long j) {
                f.this.jqj.showToast(R.string.error);
            }
        });
        this.jqk.setOnClickListener(this);
        this.jqk.a(this.jpH);
        ((Dialog) this.jqk).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.f.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                aVar.ctb();
            }
        });
    }

    public void S(int i, boolean z) {
        for (int i2 = 0; i2 < this.jpH.getCard_list().size(); i2++) {
            if (this.jpH.getCard_list().get(i2).getFid() == i) {
                this.jpH.getCard_list().get(i2).setIs_like(z ? 1 : 0);
                return;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.box_close_layout) {
            this.jqk.hide();
        } else if ((view.getId() == R.id.ll_like || view.getId() == R.id.pic_layout) && view.getTag() != null && (view.getTag() instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) view.getTag();
            if (card.getIs_like() == 1) {
                this.jql.E(card.getFname(), card.getFid());
            } else {
                this.cer.ae(card.getFname(), String.valueOf(card.getFid()), "newuser");
            }
        }
    }

    public void show() {
        if (this.jqj == null || g.t(this.jqj.getPageContext().getPageActivity())) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
            scaleAnimation.setDuration(350L);
            this.jqk.getRootView().setAnimation(scaleAnimation);
            this.jqk.show();
        }
    }
}
