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
    private TextView aGD;
    private HeadImageView eeN;
    private TextView gJc;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.eeN = (HeadImageView) tm(e.g.user_portrait);
        this.eeN.setDefaultResource(e.f.icon_default_avatar100);
        this.eeN.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eeN.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eeN.setIsRound(true);
        this.aGD = (TextView) tm(e.g.user_name);
        this.gJc = (TextView) tm(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.eeN.startLoad(fVar.gEw, 10, false);
        this.aGD.setText(fVar.userName);
        this.gJc.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aG(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gJl != null) {
                    b.this.gJl.tg(302);
                    com.baidu.tieba.recapp.report.c.buf().a(b.this.gJl);
                }
                if (b.this.gJn != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.gJn);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.j(this.mRootView, e.d.cp_cont_b_alpha80);
        al.c(this.aGD, e.d.cp_cont_i, 1);
        al.c(this.gJc, e.d.cp_cont_i, 1);
        al.e(this.gJc, e.d.cp_link_tip_a, 1);
    }
}
