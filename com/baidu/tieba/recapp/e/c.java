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
    private TextView aLy;
    private HeadImageView eqz;
    private TextView gVs;
    private CountDownTextView gVw;
    private boolean gVx;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.eqz = (HeadImageView) up(e.g.user_portrait);
        this.eqz.setDefaultResource(e.f.icon_default_avatar100);
        this.eqz.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eqz.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eqz.setIsRound(true);
        this.aLy = (TextView) up(e.g.user_name);
        this.gVw = (CountDownTextView) up(e.g.count_down_text);
        this.gVs = (TextView) up(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.eqz.startLoad(fVar.gQK, 10, false);
        this.aLy.setText(fVar.userName);
        this.gVs.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aF(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gVA != null) {
                    c.this.gVA.uj(302);
                    com.baidu.tieba.recapp.report.c.bwO().a(c.this.gVA);
                }
                if (c.this.gVC != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gVC);
                }
                c.this.mQ(false);
            }
        });
        this.gVw.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bwS() {
        super.bwS();
        this.gVw.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gVw.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void mQ(boolean z) {
        this.gVx = z;
        if (this.gVw != null) {
            this.gVw.setEnableTimeoutListener(this.gVx);
        }
    }
}
