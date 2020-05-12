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
    private TextView cBd;
    private HeadImageView hFh;
    private TextView kxn;
    private CountDownTextView kxt;
    private boolean kxu;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.hFh = (HeadImageView) BN(R.id.user_portrait);
        this.hFh.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hFh.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hFh.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hFh.setIsRound(true);
        this.cBd = (TextView) BN(R.id.user_name);
        this.kxt = (CountDownTextView) BN(R.id.count_down_text);
        this.kxn = (TextView) BN(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.hFh.startLoad(fVar.ksV, 10, false);
        this.cBd.setText(fVar.userName);
        this.kxn.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.aN(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.kxx != null) {
                    c.this.kxx.BG(302);
                    com.baidu.tieba.recapp.report.d.cOj().a(c.this.kxx);
                }
                if (c.this.kxz != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.kxz);
                }
                c.this.tl(false);
            }
        });
        this.kxt.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cOq() {
        super.cOq();
        this.kxt.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.kxt.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.setViewTextColor(this.cBd, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.kxn, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kxn, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void tl(boolean z) {
        this.kxu = z;
        if (this.kxt != null) {
            this.kxt.setEnableTimeoutListener(this.kxu);
        }
    }
}
