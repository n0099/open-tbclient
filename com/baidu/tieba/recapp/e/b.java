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
    private TextView aKT;
    private HeadImageView ena;
    private TextView gRu;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.ena = (HeadImageView) tZ(e.g.user_portrait);
        this.ena.setDefaultResource(e.f.icon_default_avatar100);
        this.ena.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.ena.setDefaultBgResource(e.d.cp_bg_line_e);
        this.ena.setIsRound(true);
        this.aKT = (TextView) tZ(e.g.user_name);
        this.gRu = (TextView) tZ(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.ena.startLoad(fVar.gMO, 10, false);
        this.aKT.setText(fVar.userName);
        this.gRu.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aH(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gRC != null) {
                    b.this.gRC.tT(302);
                    com.baidu.tieba.recapp.report.c.bvu().a(b.this.gRC);
                }
                if (b.this.gRE != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.gRE);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aKT, e.d.cp_cont_i, 1);
        al.c(this.gRu, e.d.cp_cont_i, 1);
        al.e(this.gRu, e.d.cp_link_tip_a, 1);
    }
}
