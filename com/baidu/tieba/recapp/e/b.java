package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class b extends e {
    private TextView aHt;
    private HeadImageView egi;
    private TextView gKE;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.egi = (HeadImageView) tF(e.g.user_portrait);
        this.egi.setDefaultResource(e.f.icon_default_avatar100);
        this.egi.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.egi.setDefaultBgResource(e.d.cp_bg_line_e);
        this.egi.setIsRound(true);
        this.aHt = (TextView) tF(e.g.user_name);
        this.gKE = (TextView) tF(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.egi.startLoad(fVar.gFY, 10, false);
        this.aHt.setText(fVar.userName);
        this.gKE.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aE(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gKM != null) {
                    b.this.gKM.tz(302);
                    com.baidu.tieba.recapp.report.c.btB().a(b.this.gKM);
                }
                if (b.this.gKO != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.gKO);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aHt, e.d.cp_cont_i, 1);
        al.c(this.gKE, e.d.cp_cont_i, 1);
        al.e(this.gKE, e.d.cp_link_tip_a, 1);
    }
}
