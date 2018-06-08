package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class b extends e {
    private TextView ayt;
    private HeadImageView dJB;
    private TextView gpc;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.dJB = (HeadImageView) sj(d.g.user_portrait);
        this.dJB.setDefaultResource(d.f.icon_default_avatar100);
        this.dJB.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dJB.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dJB.setIsRound(true);
        this.ayt = (TextView) sj(d.g.user_name);
        this.gpc = (TextView) sj(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dJB.startLoad(fVar.gkB, 10, false);
        this.ayt.setText(fVar.userName);
        this.gpc.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.am(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gpl != null) {
                    b.this.gpl.sd(302);
                    com.baidu.tieba.recapp.report.b.bpc().a(b.this.gpl);
                }
                if (b.this.gpn != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.gpn);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, d.C0141d.cp_cont_b_alpha80);
        al.c(this.ayt, d.C0141d.cp_cont_i, 1);
        al.c(this.gpc, d.C0141d.cp_cont_i, 1);
        al.e(this.gpc, d.C0141d.cp_link_tip_a, 1);
    }
}
