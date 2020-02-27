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
    private TextView cbJ;
    private HeadImageView gTP;
    private TextView jLZ;
    private CountDownTextView jMf;
    private boolean jMg;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.gTP = (HeadImageView) Bf(R.id.user_portrait);
        this.gTP.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gTP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gTP.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gTP.setIsRound(true);
        this.cbJ = (TextView) Bf(R.id.user_name);
        this.jMf = (CountDownTextView) Bf(R.id.count_down_text);
        this.jLZ = (TextView) Bf(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.gTP.startLoad(fVar.jHs, 10, false);
        this.cbJ.setText(fVar.userName);
        this.jLZ.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.be(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.jMj != null) {
                    c.this.jMj.AY(302);
                    com.baidu.tieba.recapp.report.c.cDn().a(c.this.jMj);
                }
                if (c.this.jMl != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.jMl);
                }
                c.this.se(false);
            }
        });
        this.jMf.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cDu() {
        super.cDu();
        this.jMf.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.jMf.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.setViewTextColor(this.cbJ, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.jLZ, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.jLZ, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void se(boolean z) {
        this.jMg = z;
        if (this.jMf != null) {
            this.jMf.setEnableTimeoutListener(this.jMg);
        }
    }
}
