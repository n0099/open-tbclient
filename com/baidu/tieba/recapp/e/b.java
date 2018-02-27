package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class b extends d {
    private TextView beT;
    private HeadImageView ecr;
    private TextView gHt;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.ecr = (HeadImageView) uy(d.g.user_portrait);
        this.ecr.setDefaultResource(d.f.icon_default_avatar100);
        this.ecr.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ecr.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.ecr.setIsRound(true);
        this.beT = (TextView) uy(d.g.user_name);
        this.gHt = (TextView) uy(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void a(final AdCard.e eVar) {
        super.a(eVar);
        this.ecr.startLoad(eVar.gDb, 10, false);
        this.beT.setText(eVar.userName);
        this.gHt.setText(eVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.ap(b.this.mRootView.getContext(), eVar.scheme);
                if (b.this.gHz != null) {
                    b.this.gHz.us(302);
                    com.baidu.tieba.recapp.report.b.boW().a(b.this.gHz);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void onChangeSkinType() {
        super.onChangeSkinType();
        aj.t(this.mRootView, d.C0141d.cp_cont_b_alpha80);
        aj.e(this.beT, d.C0141d.cp_cont_i, 1);
        aj.e(this.gHt, d.C0141d.cp_cont_i, 1);
        aj.g(this.gHt, d.C0141d.cp_link_tip_a, 1);
    }
}
