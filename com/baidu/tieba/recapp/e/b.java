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
    private TextView bTY;
    private HeadImageView fCY;
    private TextView imN;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fCY = (HeadImageView) yd(d.g.user_portrait);
        this.fCY.setDefaultResource(d.f.icon_default_avatar100);
        this.fCY.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fCY.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.fCY.setIsRound(true);
        this.bTY = (TextView) yd(d.g.user_name);
        this.imN = (TextView) yd(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fCY.startLoad(fVar.iij, 10, false);
        this.bTY.setText(fVar.userName);
        this.imN.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aS(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.imV != null) {
                    b.this.imV.xW(302);
                    com.baidu.tieba.recapp.report.c.bXE().a(b.this.imV);
                }
                if (b.this.imX != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.imX);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.d(this.bTY, d.C0277d.cp_btn_a, 1);
        al.d(this.imN, d.C0277d.cp_btn_a, 1);
        al.e(this.imN, d.f.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
