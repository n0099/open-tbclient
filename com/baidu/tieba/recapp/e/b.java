package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes10.dex */
public class b extends e {
    private TextView bXt;
    private HeadImageView gOv;
    private TextView jHw;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.gOv = (HeadImageView) AR(R.id.user_portrait);
        this.gOv.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gOv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gOv.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gOv.setIsRound(true);
        this.bXt = (TextView) AR(R.id.user_name);
        this.jHw = (TextView) AR(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.gOv.startLoad(fVar.jCU, 10, false);
        this.bXt.setText(fVar.userName);
        this.jHw.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.bd(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.jHG != null) {
                    b.this.jHG.AK(302);
                    com.baidu.tieba.recapp.report.c.cAJ().a(b.this.jHG);
                }
                if (b.this.jHI != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.jHI);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.bXt, R.color.cp_mask_c_alpha83, 1);
        am.setViewTextColor(this.jHw, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.jHw, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
