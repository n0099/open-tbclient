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
    private TextView aBX;
    private HeadImageView dWU;
    private TextView gBE;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.dWU = (HeadImageView) sP(e.g.user_portrait);
        this.dWU.setDefaultResource(e.f.icon_default_avatar100);
        this.dWU.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.dWU.setDefaultBgResource(e.d.cp_bg_line_e);
        this.dWU.setIsRound(true);
        this.aBX = (TextView) sP(e.g.user_name);
        this.gBE = (TextView) sP(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dWU.startLoad(fVar.gwW, 10, false);
        this.aBX.setText(fVar.userName);
        this.gBE.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aE(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gBN != null) {
                    b.this.gBN.sJ(302);
                    com.baidu.tieba.recapp.report.c.bqQ().a(b.this.gBN);
                }
                if (b.this.gBP != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.gBP);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aBX, e.d.cp_cont_i, 1);
        al.c(this.gBE, e.d.cp_cont_i, 1);
        al.e(this.gBE, e.d.cp_link_tip_a, 1);
    }
}
