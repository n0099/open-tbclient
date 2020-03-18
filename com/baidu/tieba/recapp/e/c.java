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
/* loaded from: classes13.dex */
public class c extends e {
    private TextView cbW;
    private HeadImageView gVk;
    private TextView jNP;
    private CountDownTextView jNV;
    private boolean jNW;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.gVk = (HeadImageView) Bn(R.id.user_portrait);
        this.gVk.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gVk.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gVk.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gVk.setIsRound(true);
        this.cbW = (TextView) Bn(R.id.user_name);
        this.jNV = (CountDownTextView) Bn(R.id.count_down_text);
        this.jNP = (TextView) Bn(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.gVk.startLoad(fVar.jJf, 10, false);
        this.cbW.setText(fVar.userName);
        this.jNP.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.be(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.jNZ != null) {
                    c.this.jNZ.Bg(302);
                    com.baidu.tieba.recapp.report.c.cDK().a(c.this.jNZ);
                }
                if (c.this.jOb != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.jOb);
                }
                c.this.sk(false);
            }
        });
        this.jNV.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cDR() {
        super.cDR();
        this.jNV.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.jNV.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.setViewTextColor(this.cbW, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.jNP, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.jNP, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void sk(boolean z) {
        this.jNW = z;
        if (this.jNV != null) {
            this.jNV.setEnableTimeoutListener(this.jNW);
        }
    }
}
