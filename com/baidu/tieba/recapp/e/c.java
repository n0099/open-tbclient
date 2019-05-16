package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class c extends e {
    private TextView cbV;
    private HeadImageView fTJ;
    private TextView iFl;
    private CountDownTextView iFp;
    private boolean iFq;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fTJ = (HeadImageView) zg(R.id.user_portrait);
        this.fTJ.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fTJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fTJ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fTJ.setIsRound(true);
        this.cbV = (TextView) zg(R.id.user_name);
        this.iFp = (CountDownTextView) zg(R.id.count_down_text);
        this.iFl = (TextView) zg(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fTJ.startLoad(fVar.iAI, 10, false);
        this.cbV.setText(fVar.userName);
        this.iFl.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aG(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.iFt != null) {
                    c.this.iFt.yZ(302);
                    com.baidu.tieba.recapp.report.c.cfE().a(c.this.iFt);
                }
                if (c.this.iFv != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.iFv);
                }
                c.this.qd(false);
            }
        });
        this.iFp.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cfI() {
        super.cfI();
        this.iFp.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.iFp.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        al.f(this.cbV, R.color.cp_btn_a, 1);
        al.f(this.iFl, R.color.cp_btn_a, 1);
        al.g(this.iFl, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void qd(boolean z) {
        this.iFq = z;
        if (this.iFp != null) {
            this.iFp.setEnableTimeoutListener(this.iFq);
        }
    }
}
