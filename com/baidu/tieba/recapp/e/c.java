package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes13.dex */
public class c extends e {
    private TextView dXU;
    private HeadImageView hTU;
    private TextView kPg;
    private CountDownTextView kPm;
    private boolean kPn;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.hTU = (HeadImageView) Cx(R.id.user_portrait);
        this.hTU.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hTU.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hTU.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hTU.setIsRound(true);
        this.dXU = (TextView) Cx(R.id.user_name);
        this.kPm = (CountDownTextView) Cx(R.id.count_down_text);
        this.kPg = (TextView) Cx(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.hTU.startLoad(fVar.kKP, 10, false);
        this.dXU.setText(fVar.userName);
        this.kPg.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.aO(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.kPq != null) {
                    c.this.kPq.Cq(302);
                    com.baidu.tieba.recapp.report.d.cVk().a(c.this.kPq);
                }
                if (c.this.kPs != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.kPs);
                }
                c.this.tJ(false);
            }
        });
        this.kPm.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cVr() {
        super.cVr();
        this.kPm.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.kPm.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.setViewTextColor(this.dXU, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.kPg, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kPg, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void tJ(boolean z) {
        this.kPn = z;
        if (this.kPm != null) {
            this.kPm.setEnableTimeoutListener(this.kPn);
        }
    }
}
