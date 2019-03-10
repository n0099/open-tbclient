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
    private TextView bTX;
    private HeadImageView fCZ;
    private TextView imU;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fCZ = (HeadImageView) yd(d.g.user_portrait);
        this.fCZ.setDefaultResource(d.f.icon_default_avatar100);
        this.fCZ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fCZ.setDefaultBgResource(d.C0236d.cp_bg_line_e);
        this.fCZ.setIsRound(true);
        this.bTX = (TextView) yd(d.g.user_name);
        this.imU = (TextView) yd(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fCZ.startLoad(fVar.iip, 10, false);
        this.bTX.setText(fVar.userName);
        this.imU.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aT(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.inc != null) {
                    b.this.inc.xW(302);
                    com.baidu.tieba.recapp.report.c.bXC().a(b.this.inc);
                }
                if (b.this.ine != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.ine);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.d(this.bTX, d.C0236d.cp_btn_a, 1);
        al.d(this.imU, d.C0236d.cp_btn_a, 1);
        al.e(this.imU, d.f.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
