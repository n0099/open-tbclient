package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class b extends e {
    private TextView ayY;
    private HeadImageView dPG;
    private TextView guh;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.dPG = (HeadImageView) sr(d.g.user_portrait);
        this.dPG.setDefaultResource(d.f.icon_default_avatar100);
        this.dPG.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dPG.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.dPG.setIsRound(true);
        this.ayY = (TextView) sr(d.g.user_name);
        this.guh = (TextView) sr(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dPG.startLoad(fVar.gpB, 10, false);
        this.ayY.setText(fVar.userName);
        this.guh.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.ao(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.guq != null) {
                    b.this.guq.sl(302);
                    com.baidu.tieba.recapp.report.c.boi().a(b.this.guq);
                }
                if (b.this.gus != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.gus);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.j(this.mRootView, d.C0140d.cp_cont_b_alpha80);
        am.c(this.ayY, d.C0140d.cp_cont_i, 1);
        am.c(this.guh, d.C0140d.cp_cont_i, 1);
        am.e(this.guh, d.C0140d.cp_link_tip_a, 1);
    }
}
