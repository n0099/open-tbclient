package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class b extends e {
    private TextView cdZ;
    private HeadImageView gbq;
    private TextView iPg;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.gbq = (HeadImageView) zQ(R.id.user_portrait);
        this.gbq.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gbq.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gbq.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gbq.setIsRound(true);
        this.cdZ = (TextView) zQ(R.id.user_name);
        this.iPg = (TextView) zQ(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.gbq.startLoad(fVar.iKD, 10, false);
        this.cdZ.setText(fVar.userName);
        this.iPg.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aO(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.iPo != null) {
                    b.this.iPo.zJ(302);
                    com.baidu.tieba.recapp.report.c.cjE().a(b.this.iPo);
                }
                if (b.this.iPq != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.iPq);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.f(this.cdZ, R.color.cp_mask_c_alpha83, 1);
        am.f(this.iPg, R.color.cp_cont_a, 1);
        am.g(this.iPg, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
