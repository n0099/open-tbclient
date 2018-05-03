package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class b extends e {
    private TextView aqm;
    private HeadImageView dxk;
    private TextView gcD;

    public b(View view2, String str) {
        super(view2, str);
        init();
    }

    private void init() {
        this.dxk = (HeadImageView) rY(d.g.user_portrait);
        this.dxk.setDefaultResource(d.f.icon_default_avatar100);
        this.dxk.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dxk.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.dxk.setIsRound(true);
        this.aqm = (TextView) rY(d.g.user_name);
        this.gcD = (TextView) rY(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dxk.startLoad(fVar.fYd, 10, false);
        this.aqm.setText(fVar.userName);
        this.gcD.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                s.ak(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.gcM != null) {
                    b.this.gcM.rS(302);
                    com.baidu.tieba.recapp.report.b.bke().a(b.this.gcM);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ak.j(this.mRootView, d.C0126d.cp_cont_b_alpha80);
        ak.c(this.aqm, d.C0126d.cp_cont_i, 1);
        ak.c(this.gcD, d.C0126d.cp_cont_i, 1);
        ak.e(this.gcD, d.C0126d.cp_link_tip_a, 1);
    }
}
