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
    private TextView beW;
    private HeadImageView ecH;
    private TextView gHJ;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.ecH = (HeadImageView) uy(d.g.user_portrait);
        this.ecH.setDefaultResource(d.f.icon_default_avatar100);
        this.ecH.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ecH.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.ecH.setIsRound(true);
        this.beW = (TextView) uy(d.g.user_name);
        this.gHJ = (TextView) uy(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void a(final AdCard.e eVar) {
        super.a(eVar);
        this.ecH.startLoad(eVar.gDr, 10, false);
        this.beW.setText(eVar.userName);
        this.gHJ.setText(eVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.ap(b.this.mRootView.getContext(), eVar.scheme);
                if (b.this.gHP != null) {
                    b.this.gHP.us(302);
                    com.baidu.tieba.recapp.report.b.boX().a(b.this.gHP);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.d
    public void onChangeSkinType() {
        super.onChangeSkinType();
        aj.t(this.mRootView, d.C0141d.cp_cont_b_alpha80);
        aj.e(this.beW, d.C0141d.cp_cont_i, 1);
        aj.e(this.gHJ, d.C0141d.cp_cont_i, 1);
        aj.g(this.gHJ, d.C0141d.cp_link_tip_a, 1);
    }
}
