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
    private HeadImageView ipf;
    private TextView lrB;
    private CountDownTextView lrH;
    private boolean lrI;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.ipf = (HeadImageView) DX(R.id.user_portrait);
        this.ipf.setDefaultResource(R.drawable.icon_default_avatar100);
        this.ipf.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ipf.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ipf.setIsRound(true);
        this.dKI = (TextView) DX(R.id.user_name);
        this.lrH = (CountDownTextView) DX(R.id.count_down_text);
        this.lrB = (TextView) DX(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.ipf.startLoad(fVar.lnh, 10, false);
        this.dKI.setText(fVar.userName);
        this.lrB.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aN(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.lrL != null) {
                    c.this.lrL.DQ(302);
                    com.baidu.tieba.recapp.report.d.dcY().a(c.this.lrL);
                }
                if (c.this.lrN != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.lrN);
                }
                c.this.uC(false);
            }
        });
        this.lrH.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void ddf() {
        super.ddf();
        this.lrH.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.lrH.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        ao.setViewTextColor(this.dKI, R.color.cp_cont_a, 1);
        ao.setViewTextColor(this.lrB, R.color.cp_cont_a, 1);
        ao.setBackgroundResource(this.lrB, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void uC(boolean z) {
        this.lrI = z;
        if (this.lrH != null) {
            this.lrH.setEnableTimeoutListener(this.lrI);
        }
    }
}
