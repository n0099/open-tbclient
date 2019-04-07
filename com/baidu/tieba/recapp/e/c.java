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
    private TextView bUa;
    private HeadImageView fCM;
    private CountDownTextView imD;
    private boolean imE;
    private TextView imz;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fCM = (HeadImageView) xZ(d.g.user_portrait);
        this.fCM.setDefaultResource(d.f.icon_default_avatar100);
        this.fCM.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fCM.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.fCM.setIsRound(true);
        this.bUa = (TextView) xZ(d.g.user_name);
        this.imD = (CountDownTextView) xZ(d.g.count_down_text);
        this.imz = (TextView) xZ(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fCM.startLoad(fVar.ihV, 10, false);
        this.bUa.setText(fVar.userName);
        this.imz.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aS(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.imH != null) {
                    c.this.imH.xS(302);
                    com.baidu.tieba.recapp.report.c.bXA().a(c.this.imH);
                }
                if (c.this.imJ != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.imJ);
                }
                c.this.pp(false);
            }
        });
        this.imD.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bXE() {
        super.bXE();
        this.imD.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.imD.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void pp(boolean z) {
        this.imE = z;
        if (this.imD != null) {
            this.imD.setEnableTimeoutListener(this.imE);
        }
    }
}
