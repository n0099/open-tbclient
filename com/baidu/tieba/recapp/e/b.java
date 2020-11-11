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
    private TextView ewx;
    private HeadImageView jrW;
    private TextView myS;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jrW = (HeadImageView) If(R.id.user_portrait);
        this.jrW.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jrW.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jrW.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jrW.setIsRound(true);
        this.ewx = (TextView) If(R.id.user_name);
        this.myS = (TextView) If(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jrW.startLoad(fVar.muB, 10, false);
        this.ewx.setText(fVar.userName);
        this.myS.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aY(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.mzc != null) {
                    b.this.mzc.HY(302);
                    com.baidu.tieba.recapp.report.d.dBp().a(b.this.mzc);
                }
                if (b.this.mze != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.mze);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.ewx, R.color.cp_mask_c_alpha83, 1);
        ap.setViewTextColor(this.myS, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.myS, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
