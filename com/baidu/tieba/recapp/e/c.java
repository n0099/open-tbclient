package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class c extends e {
    private TextView aqm;
    private HeadImageView dxk;
    private TextView gcD;
    private CountDownTextView gcH;
    private boolean gcI;

    public c(View view2, String str) {
        super(view2, str);
        init();
    }

    private void init() {
        this.dxk = (HeadImageView) rY(d.g.user_portrait);
        this.dxk.setDefaultResource(d.f.icon_default_avatar100);
        this.dxk.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dxk.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.dxk.setIsRound(true);
        this.aqm = (TextView) rY(d.g.user_name);
        this.gcH = (CountDownTextView) rY(d.g.count_down_text);
        this.gcD = (TextView) rY(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dxk.startLoad(fVar.fYd, 10, false);
        this.aqm.setText(fVar.userName);
        this.gcD.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                s.ak(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gcM != null) {
                    c.this.gcM.rS(302);
                    com.baidu.tieba.recapp.report.b.bke().a(c.this.gcM);
                }
                c.this.lF(false);
            }
        });
        this.gcH.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bkj() {
        super.bkj();
        this.gcH.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gcH.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void lF(boolean z) {
        this.gcI = z;
        if (this.gcH != null) {
            this.gcH.setEnableTimeoutListener(this.gcI);
        }
    }
}
