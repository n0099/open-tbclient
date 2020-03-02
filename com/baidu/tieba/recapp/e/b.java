package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes13.dex */
public class b extends e {
    private TextView cbK;
    private HeadImageView gTR;
    private TextView jMb;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.gTR = (HeadImageView) Bf(R.id.user_portrait);
        this.gTR.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gTR.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gTR.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gTR.setIsRound(true);
        this.cbK = (TextView) Bf(R.id.user_name);
        this.jMb = (TextView) Bf(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.gTR.startLoad(fVar.jHu, 10, false);
        this.cbK.setText(fVar.userName);
        this.jMb.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.be(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.jMl != null) {
                    b.this.jMl.AY(302);
                    com.baidu.tieba.recapp.report.c.cDp().a(b.this.jMl);
                }
                if (b.this.jMn != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.jMn);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.cbK, R.color.cp_mask_c_alpha83, 1);
        am.setViewTextColor(this.jMb, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.jMb, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
