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
    private TextView cbL;
    private HeadImageView gUd;
    private TextView jMn;
    private CountDownTextView jMt;
    private boolean jMu;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.gUd = (HeadImageView) Bf(R.id.user_portrait);
        this.gUd.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gUd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gUd.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gUd.setIsRound(true);
        this.cbL = (TextView) Bf(R.id.user_name);
        this.jMt = (CountDownTextView) Bf(R.id.count_down_text);
        this.jMn = (TextView) Bf(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.gUd.startLoad(fVar.jHG, 10, false);
        this.cbL.setText(fVar.userName);
        this.jMn.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.be(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.jMx != null) {
                    c.this.jMx.AY(302);
                    com.baidu.tieba.recapp.report.c.cDq().a(c.this.jMx);
                }
                if (c.this.jMz != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.jMz);
                }
                c.this.se(false);
            }
        });
        this.jMt.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cDx() {
        super.cDx();
        this.jMt.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.jMt.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.setViewTextColor(this.cbL, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.jMn, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.jMn, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void se(boolean z) {
        this.jMu = z;
        if (this.jMt != null) {
            this.jMt.setEnableTimeoutListener(this.jMu);
        }
    }
}
