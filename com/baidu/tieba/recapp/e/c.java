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
    private TextView aLx;
    private HeadImageView eqy;
    private TextView gVr;
    private CountDownTextView gVv;
    private boolean gVw;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.eqy = (HeadImageView) up(e.g.user_portrait);
        this.eqy.setDefaultResource(e.f.icon_default_avatar100);
        this.eqy.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eqy.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eqy.setIsRound(true);
        this.aLx = (TextView) up(e.g.user_name);
        this.gVv = (CountDownTextView) up(e.g.count_down_text);
        this.gVr = (TextView) up(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.eqy.startLoad(fVar.gQJ, 10, false);
        this.aLx.setText(fVar.userName);
        this.gVr.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aF(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gVz != null) {
                    c.this.gVz.uj(302);
                    com.baidu.tieba.recapp.report.c.bwO().a(c.this.gVz);
                }
                if (c.this.gVB != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gVB);
                }
                c.this.mQ(false);
            }
        });
        this.gVv.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bwS() {
        super.bwS();
        this.gVv.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gVv.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void mQ(boolean z) {
        this.gVw = z;
        if (this.gVv != null) {
            this.gVv.setEnableTimeoutListener(this.gVw);
        }
    }
}
