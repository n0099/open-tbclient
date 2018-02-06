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
    private TextView bfg;
    private HeadImageView ecD;
    private TextView gHI;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.ecD = (HeadImageView) ux(d.g.user_portrait);
        this.ecD.setDefaultResource(d.f.icon_default_avatar100);
        this.ecD.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ecD.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.ecD.setIsRound(true);
        this.bfg = (TextView) ux(d.g.user_name);
        this.gHI = (TextView) ux(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void a(final AdCard.e eVar) {
        super.a(eVar);
        this.ecD.startLoad(eVar.gDq, 10, false);
        this.bfg.setText(eVar.userName);
        this.gHI.setText(eVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.ap(b.this.mRootView.getContext(), eVar.scheme);
                if (b.this.gHO != null) {
                    b.this.gHO.ur(302);
                    com.baidu.tieba.recapp.report.b.boX().a(b.this.gHO);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void onChangeSkinType() {
        super.onChangeSkinType();
        aj.t(this.mRootView, d.C0140d.cp_cont_b_alpha80);
        aj.e(this.bfg, d.C0140d.cp_cont_i, 1);
        aj.e(this.gHI, d.C0140d.cp_cont_i, 1);
        aj.g(this.gHI, d.C0140d.cp_link_tip_a, 1);
    }
}
