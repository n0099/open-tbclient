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
    private TextView cAX;
    private HeadImageView hFb;
    private TextView kxj;
    private CountDownTextView kxp;
    private boolean kxq;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.hFb = (HeadImageView) BN(R.id.user_portrait);
        this.hFb.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hFb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hFb.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hFb.setIsRound(true);
        this.cAX = (TextView) BN(R.id.user_name);
        this.kxp = (CountDownTextView) BN(R.id.count_down_text);
        this.kxj = (TextView) BN(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.hFb.startLoad(fVar.ksR, 10, false);
        this.cAX.setText(fVar.userName);
        this.kxj.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.aZ(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.kxt != null) {
                    c.this.kxt.BG(302);
                    com.baidu.tieba.recapp.report.d.cOl().a(c.this.kxt);
                }
                if (c.this.kxv != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.kxv);
                }
                c.this.tl(false);
            }
        });
        this.kxp.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cOs() {
        super.cOs();
        this.kxp.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.kxp.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.setViewTextColor(this.cAX, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.kxj, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kxj, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void tl(boolean z) {
        this.kxq = z;
        if (this.kxp != null) {
            this.kxp.setEnableTimeoutListener(this.kxq);
        }
    }
}
