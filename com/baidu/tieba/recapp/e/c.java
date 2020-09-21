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
/* loaded from: classes25.dex */
public class c extends e {
    private TextView dWe;
    private HeadImageView iKM;
    private TextView lRf;
    private CountDownTextView lRl;
    private boolean lRm;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.iKM = (HeadImageView) GT(R.id.user_portrait);
        this.iKM.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iKM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iKM.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iKM.setIsRound(true);
        this.dWe = (TextView) GT(R.id.user_name);
        this.lRl = (CountDownTextView) GT(R.id.count_down_text);
        this.lRf = (TextView) GT(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.iKM.startLoad(fVar.lMO, 10, false);
        this.dWe.setText(fVar.userName);
        this.lRf.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aU(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.lRp != null) {
                    c.this.lRp.GM(302);
                    com.baidu.tieba.recapp.report.d.drV().a(c.this.lRp);
                }
                if (c.this.lRr != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.lRr);
                }
                c.this.vz(false);
            }
        });
        this.lRl.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void dsc() {
        super.dsc();
        this.lRl.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.lRl.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        ap.setViewTextColor(this.dWe, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.lRf, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.lRf, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void vz(boolean z) {
        this.lRm = z;
        if (this.lRl != null) {
            this.lRl.setEnableTimeoutListener(this.lRm);
        }
    }
}
