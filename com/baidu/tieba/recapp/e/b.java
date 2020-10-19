package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes26.dex */
public class b extends e {
    private TextView eig;
    private HeadImageView iZE;
    private TextView mgx;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.iZE = (HeadImageView) Hz(R.id.user_portrait);
        this.iZE.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iZE.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iZE.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iZE.setIsRound(true);
        this.eig = (TextView) Hz(R.id.user_name);
        this.mgx = (TextView) Hz(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.iZE.startLoad(fVar.mcf, 10, false);
        this.eig.setText(fVar.userName);
        this.mgx.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aW(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.mgH != null) {
                    b.this.mgH.Hs(302);
                    com.baidu.tieba.recapp.report.d.dvG().a(b.this.mgH);
                }
                if (b.this.mgJ != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.mgJ);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eig, R.color.cp_mask_c_alpha83, 1);
        ap.setViewTextColor(this.mgx, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.mgx, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
