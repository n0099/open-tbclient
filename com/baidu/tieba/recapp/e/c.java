package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class c extends e {
    private TextView aHt;
    private HeadImageView egi;
    private TextView gKE;
    private CountDownTextView gKI;
    private boolean gKJ;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.egi = (HeadImageView) tF(e.g.user_portrait);
        this.egi.setDefaultResource(e.f.icon_default_avatar100);
        this.egi.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.egi.setDefaultBgResource(e.d.cp_bg_line_e);
        this.egi.setIsRound(true);
        this.aHt = (TextView) tF(e.g.user_name);
        this.gKI = (CountDownTextView) tF(e.g.count_down_text);
        this.gKE = (TextView) tF(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.egi.startLoad(fVar.gFY, 10, false);
        this.aHt.setText(fVar.userName);
        this.gKE.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aE(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gKM != null) {
                    c.this.gKM.tz(302);
                    com.baidu.tieba.recapp.report.c.btB().a(c.this.gKM);
                }
                if (c.this.gKO != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gKO);
                }
                c.this.mJ(false);
            }
        });
        this.gKI.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void btF() {
        super.btF();
        this.gKI.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gKI.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void mJ(boolean z) {
        this.gKJ = z;
        if (this.gKI != null) {
            this.gKI.setEnableTimeoutListener(this.gKJ);
        }
    }
}
