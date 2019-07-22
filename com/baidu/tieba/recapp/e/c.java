package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class c extends e {
    private TextView ccZ;
    private HeadImageView fYJ;
    private TextView iLG;
    private CountDownTextView iLK;
    private boolean iLL;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fYJ = (HeadImageView) zL(R.id.user_portrait);
        this.fYJ.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fYJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fYJ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fYJ.setIsRound(true);
        this.ccZ = (TextView) zL(R.id.user_name);
        this.iLK = (CountDownTextView) zL(R.id.count_down_text);
        this.iLG = (TextView) zL(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fYJ.startLoad(fVar.iHd, 10, false);
        this.ccZ.setText(fVar.userName);
        this.iLG.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aH(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.iLO != null) {
                    c.this.iLO.zE(302);
                    com.baidu.tieba.recapp.report.c.ciy().a(c.this.iLO);
                }
                if (c.this.iLQ != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.iLQ);
                }
                c.this.qt(false);
            }
        });
        this.iLK.zU(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void ciC() {
        super.ciC();
        this.iLK.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.iLK.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.f(this.ccZ, R.color.cp_btn_a, 1);
        am.f(this.iLG, R.color.cp_btn_a, 1);
        am.g(this.iLG, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void qt(boolean z) {
        this.iLL = z;
        if (this.iLK != null) {
            this.iLK.setEnableTimeoutListener(this.iLL);
        }
    }
}
