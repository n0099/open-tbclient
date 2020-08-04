package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes20.dex */
public class b extends e {
    private TextView dKI;
    private HeadImageView iph;
    private TextView lrD;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.iph = (HeadImageView) DX(R.id.user_portrait);
        this.iph.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iph.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iph.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iph.setIsRound(true);
        this.dKI = (TextView) DX(R.id.user_name);
        this.lrD = (TextView) DX(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.iph.startLoad(fVar.lnj, 10, false);
        this.dKI.setText(fVar.userName);
        this.lrD.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aN(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.lrN != null) {
                    b.this.lrN.DQ(302);
                    com.baidu.tieba.recapp.report.d.dcY().a(b.this.lrN);
                }
                if (b.this.lrP != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.lrP);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setViewTextColor(this.dKI, R.color.cp_mask_c_alpha83, 1);
        ao.setViewTextColor(this.lrD, R.color.cp_cont_a, 1);
        ao.setBackgroundResource(this.lrD, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
