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
    private TextView aKV;
    private HeadImageView epS;
    private TextView gUm;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.epS = (HeadImageView) um(e.g.user_portrait);
        this.epS.setDefaultResource(e.f.icon_default_avatar100);
        this.epS.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.epS.setDefaultBgResource(e.d.cp_bg_line_e);
        this.epS.setIsRound(true);
        this.aKV = (TextView) um(e.g.user_name);
        this.gUm = (TextView) um(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.epS.startLoad(fVar.gPG, 10, false);
        this.aKV.setText(fVar.userName);
        this.gUm.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aH(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gUu != null) {
                    b.this.gUu.ug(302);
                    com.baidu.tieba.recapp.report.c.bwf().a(b.this.gUu);
                }
                if (b.this.gUw != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.gUw);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aKV, e.d.cp_cont_i, 1);
        al.c(this.gUm, e.d.cp_cont_i, 1);
        al.e(this.gUm, e.d.cp_link_tip_a, 1);
    }
}
