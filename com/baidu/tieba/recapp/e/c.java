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
/* loaded from: classes20.dex */
public class c extends e {
    private TextView dTQ;
    private HeadImageView iDl;
    private TextView lHY;
    private CountDownTextView lIe;
    private boolean lIf;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.iDl = (HeadImageView) Gs(R.id.user_portrait);
        this.iDl.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iDl.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iDl.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iDl.setIsRound(true);
        this.dTQ = (TextView) Gs(R.id.user_name);
        this.lIe = (CountDownTextView) Gs(R.id.count_down_text);
        this.lHY = (TextView) Gs(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.iDl.startLoad(fVar.lDJ, 10, false);
        this.dTQ.setText(fVar.userName);
        this.lHY.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aR(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.lIi != null) {
                    c.this.lIi.Gl(302);
                    com.baidu.tieba.recapp.report.d.doi().a(c.this.lIi);
                }
                if (c.this.lIk != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.lIk);
                }
                c.this.vp(false);
            }
        });
        this.lIe.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void dop() {
        super.dop();
        this.lIe.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.lIe.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        ap.setViewTextColor(this.dTQ, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.lHY, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.lHY, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void vp(boolean z) {
        this.lIf = z;
        if (this.lIe != null) {
            this.lIe.setEnableTimeoutListener(this.lIf);
        }
    }
}
