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
    private TextView eig;
    private HeadImageView iZE;
    private CountDownTextView mgD;
    private boolean mgE;
    private TextView mgx;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.iZE = (HeadImageView) Hz(R.id.user_portrait);
        this.iZE.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iZE.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iZE.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iZE.setIsRound(true);
        this.eig = (TextView) Hz(R.id.user_name);
        this.mgD = (CountDownTextView) Hz(R.id.count_down_text);
        this.mgx = (TextView) Hz(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.iZE.startLoad(fVar.mcf, 10, false);
        this.eig.setText(fVar.userName);
        this.mgx.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aW(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.mgH != null) {
                    c.this.mgH.Hs(302);
                    com.baidu.tieba.recapp.report.d.dvG().a(c.this.mgH);
                }
                if (c.this.mgJ != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.mgJ);
                }
                c.this.wg(false);
            }
        });
        this.mgD.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void dvN() {
        super.dvN();
        this.mgD.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.mgD.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        ap.setViewTextColor(this.eig, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.mgx, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.mgx, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void wg(boolean z) {
        this.mgE = z;
        if (this.mgD != null) {
            this.mgD.setEnableTimeoutListener(this.mgE);
        }
    }
}
