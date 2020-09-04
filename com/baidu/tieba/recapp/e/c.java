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
    private TextView dTU;
    private HeadImageView iDr;
    private TextView lIl;
    private CountDownTextView lIr;
    private boolean lIs;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.iDr = (HeadImageView) Gs(R.id.user_portrait);
        this.iDr.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iDr.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iDr.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iDr.setIsRound(true);
        this.dTU = (TextView) Gs(R.id.user_name);
        this.lIr = (CountDownTextView) Gs(R.id.count_down_text);
        this.lIl = (TextView) Gs(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.iDr.startLoad(fVar.lDU, 10, false);
        this.dTU.setText(fVar.userName);
        this.lIl.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aR(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.lIv != null) {
                    c.this.lIv.Gl(302);
                    com.baidu.tieba.recapp.report.d.dol().a(c.this.lIv);
                }
                if (c.this.lIx != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.lIx);
                }
                c.this.vr(false);
            }
        });
        this.lIr.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void dos() {
        super.dos();
        this.lIr.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.lIr.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        ap.setViewTextColor(this.dTU, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.lIl, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.lIl, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void vr(boolean z) {
        this.lIs = z;
        if (this.lIr != null) {
            this.lIr.setEnableTimeoutListener(this.lIs);
        }
    }
}
