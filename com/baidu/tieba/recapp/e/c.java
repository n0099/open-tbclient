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
    private TextView ewx;
    private HeadImageView jrW;
    private TextView myS;
    private CountDownTextView myY;
    private boolean myZ;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jrW = (HeadImageView) If(R.id.user_portrait);
        this.jrW.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jrW.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jrW.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jrW.setIsRound(true);
        this.ewx = (TextView) If(R.id.user_name);
        this.myY = (CountDownTextView) If(R.id.count_down_text);
        this.myS = (TextView) If(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jrW.startLoad(fVar.muB, 10, false);
        this.ewx.setText(fVar.userName);
        this.myS.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aY(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.mzc != null) {
                    c.this.mzc.HY(302);
                    com.baidu.tieba.recapp.report.d.dBp().a(c.this.mzc);
                }
                if (c.this.mze != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.mze);
                }
                c.this.wG(false);
            }
        });
        this.myY.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void dBw() {
        super.dBw();
        this.myY.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.myY.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        ap.setViewTextColor(this.ewx, R.color.cp_cont_a, 1);
        ap.setViewTextColor(this.myS, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.myS, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void wG(boolean z) {
        this.myZ = z;
        if (this.myY != null) {
            this.myY.setEnableTimeoutListener(this.myZ);
        }
    }
}
