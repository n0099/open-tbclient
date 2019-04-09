package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class b extends e {
    private TextView bUb;
    private HeadImageView fCM;
    private TextView imA;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fCM = (HeadImageView) xZ(d.g.user_portrait);
        this.fCM.setDefaultResource(d.f.icon_default_avatar100);
        this.fCM.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fCM.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.fCM.setIsRound(true);
        this.bUb = (TextView) xZ(d.g.user_name);
        this.imA = (TextView) xZ(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fCM.startLoad(fVar.ihW, 10, false);
        this.bUb.setText(fVar.userName);
        this.imA.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aS(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.imI != null) {
                    b.this.imI.xS(302);
                    com.baidu.tieba.recapp.report.c.bXA().a(b.this.imI);
                }
                if (b.this.imK != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.imK);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.d(this.bUb, d.C0277d.cp_btn_a, 1);
        al.d(this.imA, d.C0277d.cp_btn_a, 1);
        al.e(this.imA, d.f.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
