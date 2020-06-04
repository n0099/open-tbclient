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
    private HeadImageView hUH;
    private TextView kQp;
    private CountDownTextView kQv;
    private boolean kQw;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.hUH = (HeadImageView) Cz(R.id.user_portrait);
        this.hUH.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hUH.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hUH.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hUH.setIsRound(true);
        this.dXU = (TextView) Cz(R.id.user_name);
        this.kQv = (CountDownTextView) Cz(R.id.count_down_text);
        this.kQp = (TextView) Cz(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.hUH.startLoad(fVar.kLY, 10, false);
        this.dXU.setText(fVar.userName);
        this.kQp.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.aO(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.kQz != null) {
                    c.this.kQz.Cs(302);
                    com.baidu.tieba.recapp.report.d.cVA().a(c.this.kQz);
                }
                if (c.this.kQB != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.kQB);
                }
                c.this.tJ(false);
            }
        });
        this.kQv.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cVH() {
        super.cVH();
        this.kQv.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.kQv.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.setViewTextColor(this.dXU, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.kQp, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kQp, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void tJ(boolean z) {
        this.kQw = z;
        if (this.kQv != null) {
            this.kQv.setEnableTimeoutListener(this.kQw);
        }
    }
}
