package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class b extends e {
    private TextView ayV;
    private HeadImageView dPC;
    private TextView guk;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.dPC = (HeadImageView) sr(f.g.user_portrait);
        this.dPC.setDefaultResource(f.C0146f.icon_default_avatar100);
        this.dPC.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.dPC.setDefaultBgResource(f.d.cp_bg_line_e);
        this.dPC.setIsRound(true);
        this.ayV = (TextView) sr(f.g.user_name);
        this.guk = (TextView) sr(f.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dPC.startLoad(fVar.gpE, 10, false);
        this.ayV.setText(fVar.userName);
        this.guk.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.ao(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gut != null) {
                    b.this.gut.sl(302);
                    com.baidu.tieba.recapp.report.c.boj().a(b.this.gut);
                }
                if (b.this.guv != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.guv);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.j(this.mRootView, f.d.cp_cont_b_alpha80);
        am.c(this.ayV, f.d.cp_cont_i, 1);
        am.c(this.guk, f.d.cp_cont_i, 1);
        am.e(this.guk, f.d.cp_link_tip_a, 1);
    }
}
