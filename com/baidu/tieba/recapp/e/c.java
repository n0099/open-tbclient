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
    private TextView ayt;
    private HeadImageView dJB;
    private TextView gpc;
    private CountDownTextView gpg;
    private boolean gph;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.dJB = (HeadImageView) sj(d.g.user_portrait);
        this.dJB.setDefaultResource(d.f.icon_default_avatar100);
        this.dJB.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dJB.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.dJB.setIsRound(true);
        this.ayt = (TextView) sj(d.g.user_name);
        this.gpg = (CountDownTextView) sj(d.g.count_down_text);
        this.gpc = (TextView) sj(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dJB.startLoad(fVar.gkB, 10, false);
        this.ayt.setText(fVar.userName);
        this.gpc.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.am(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gpl != null) {
                    c.this.gpl.sd(302);
                    com.baidu.tieba.recapp.report.b.bpc().a(c.this.gpl);
                }
                if (c.this.gpn != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gpn);
                }
                c.this.lM(false);
            }
        });
        this.gpg.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bpg() {
        super.bpg();
        this.gpg.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gpg.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void lM(boolean z) {
        this.gph = z;
        if (this.gpg != null) {
            this.gpg.setEnableTimeoutListener(this.gph);
        }
    }
}
