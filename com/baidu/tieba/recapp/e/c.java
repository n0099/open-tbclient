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
/* loaded from: classes10.dex */
public class c extends e {
    private TextView bXt;
    private HeadImageView gOv;
    private CountDownTextView jHC;
    private boolean jHD;
    private TextView jHw;

    public c(View view, String str) {
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
        this.jHC = (CountDownTextView) AR(R.id.count_down_text);
        this.jHw = (TextView) AR(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.gOv.startLoad(fVar.jCU, 10, false);
        this.bXt.setText(fVar.userName);
        this.jHw.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.bd(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.jHG != null) {
                    c.this.jHG.AK(302);
                    com.baidu.tieba.recapp.report.c.cAJ().a(c.this.jHG);
                }
                if (c.this.jHI != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.jHI);
                }
                c.this.rP(false);
            }
        });
        this.jHC.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cAQ() {
        super.cAQ();
        this.jHC.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.jHC.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.setViewTextColor(this.bXt, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.jHw, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.jHw, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void rP(boolean z) {
        this.jHD = z;
        if (this.jHC != null) {
            this.jHC.setEnableTimeoutListener(this.jHD);
        }
    }
}
