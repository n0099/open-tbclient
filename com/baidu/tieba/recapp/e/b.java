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
    private TextView aLx;
    private HeadImageView eqy;
    private TextView gVr;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.eqy = (HeadImageView) up(e.g.user_portrait);
        this.eqy.setDefaultResource(e.f.icon_default_avatar100);
        this.eqy.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eqy.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eqy.setIsRound(true);
        this.aLx = (TextView) up(e.g.user_name);
        this.gVr = (TextView) up(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.eqy.startLoad(fVar.gQJ, 10, false);
        this.aLx.setText(fVar.userName);
        this.gVr.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aF(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gVz != null) {
                    b.this.gVz.uj(302);
                    com.baidu.tieba.recapp.report.c.bwO().a(b.this.gVz);
                }
                if (b.this.gVB != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.gVB);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aLx, e.d.cp_cont_i, 1);
        al.c(this.gVr, e.d.cp_cont_i, 1);
        al.e(this.gVr, e.d.cp_link_tip_a, 1);
    }
}
