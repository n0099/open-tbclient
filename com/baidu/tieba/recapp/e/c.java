package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes26.dex */
public class c extends e {
    private TextView eqE;
    private HeadImageView jlY;
    private TextView msW;
    private CountDownTextView mtc;
    private boolean mtd;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jlY = (HeadImageView) HS(R.id.user_portrait);
        this.jlY.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jlY.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jlY.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jlY.setIsRound(true);
        this.eqE = (TextView) HS(R.id.user_name);
        this.mtc = (CountDownTextView) HS(R.id.count_down_text);
        this.msW = (TextView) HS(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jlY.startLoad(fVar.moE, 10, false);
        this.eqE.setText(fVar.userName);
        this.msW.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aY(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.mtg != null) {
                    c.this.mtg.HL(302);
                    com.baidu.tieba.recapp.report.d.dyN().a(c.this.mtg);
                }
                if (c.this.mti != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.mti);
                }
                c.this.wx(false);
            }
        });
        this.mtc.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void dyU() {
        super.dyU();
        this.mtc.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.mtc.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        ap.setViewTextColor(this.eqE, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.msW, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.msW, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void wx(boolean z) {
        this.mtd = z;
        if (this.mtc != null) {
            this.mtc.setEnableTimeoutListener(this.mtd);
        }
    }
}
