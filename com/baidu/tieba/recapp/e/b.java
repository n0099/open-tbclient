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
    private TextView azm;
    private HeadImageView dMT;
    private TextView gsU;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.dMT = (HeadImageView) st(d.g.user_portrait);
        this.dMT.setDefaultResource(d.f.icon_default_avatar100);
        this.dMT.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dMT.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.dMT.setIsRound(true);
        this.azm = (TextView) st(d.g.user_name);
        this.gsU = (TextView) st(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dMT.startLoad(fVar.gor, 10, false);
        this.azm.setText(fVar.userName);
        this.gsU.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.am(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gtd != null) {
                    b.this.gtd.sn(302);
                    com.baidu.tieba.recapp.report.b.bpD().a(b.this.gtd);
                }
                if (b.this.gtf != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.gtf);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.j(this.mRootView, d.C0142d.cp_cont_b_alpha80);
        am.c(this.azm, d.C0142d.cp_cont_i, 1);
        am.c(this.gsU, d.C0142d.cp_cont_i, 1);
        am.e(this.gsU, d.C0142d.cp_link_tip_a, 1);
    }
}
