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
    private TextView aLy;
    private HeadImageView eqz;
    private TextView gVs;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.eqz = (HeadImageView) up(e.g.user_portrait);
        this.eqz.setDefaultResource(e.f.icon_default_avatar100);
        this.eqz.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eqz.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eqz.setIsRound(true);
        this.aLy = (TextView) up(e.g.user_name);
        this.gVs = (TextView) up(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.eqz.startLoad(fVar.gQK, 10, false);
        this.aLy.setText(fVar.userName);
        this.gVs.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aF(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gVA != null) {
                    b.this.gVA.uj(302);
                    com.baidu.tieba.recapp.report.c.bwO().a(b.this.gVA);
                }
                if (b.this.gVC != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.gVC);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aLy, e.d.cp_cont_i, 1);
        al.c(this.gVs, e.d.cp_cont_i, 1);
        al.e(this.gVs, e.d.cp_link_tip_a, 1);
    }
}
