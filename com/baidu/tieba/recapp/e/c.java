package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes20.dex */
public class c extends e {
    private TextView dKI;
    private HeadImageView iph;
    private TextView lrD;
    private CountDownTextView lrJ;
    private boolean lrK;

    public c(View view, String str) {
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
        this.lrJ = (CountDownTextView) DX(R.id.count_down_text);
        this.lrD = (TextView) DX(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.iph.startLoad(fVar.lnj, 10, false);
        this.dKI.setText(fVar.userName);
        this.lrD.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aN(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.lrN != null) {
                    c.this.lrN.DQ(302);
                    com.baidu.tieba.recapp.report.d.dcY().a(c.this.lrN);
                }
                if (c.this.lrP != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.lrP);
                }
                c.this.uC(false);
            }
        });
        this.lrJ.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void ddf() {
        super.ddf();
        this.lrJ.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.lrJ.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        ao.setViewTextColor(this.dKI, R.color.cp_cont_a, 1);
        ao.setViewTextColor(this.lrD, R.color.cp_cont_a, 1);
        ao.setBackgroundResource(this.lrD, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void uC(boolean z) {
        this.lrK = z;
        if (this.lrJ != null) {
            this.lrJ.setEnableTimeoutListener(this.lrK);
        }
    }
}
