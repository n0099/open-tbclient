package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes11.dex */
public class b extends e {
    private TextView bXF;
    private HeadImageView gRP;
    private TextView jKY;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.gRP = (HeadImageView) AW(R.id.user_portrait);
        this.gRP.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gRP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gRP.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gRP.setIsRound(true);
        this.bXF = (TextView) AW(R.id.user_name);
        this.jKY = (TextView) AW(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.gRP.startLoad(fVar.jGw, 10, false);
        this.bXF.setText(fVar.userName);
        this.jKY.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.be(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.jLi != null) {
                    b.this.jLi.AP(302);
                    com.baidu.tieba.recapp.report.c.cBP().a(b.this.jLi);
                }
                if (b.this.jLk != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.jLk);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.bXF, R.color.cp_mask_c_alpha83, 1);
        am.setViewTextColor(this.jKY, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.jKY, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
