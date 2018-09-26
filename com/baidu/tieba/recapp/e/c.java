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
    private TextView aBX;
    private HeadImageView dWU;
    private TextView gBE;
    private CountDownTextView gBI;
    private boolean gBJ;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.dWU = (HeadImageView) sP(e.g.user_portrait);
        this.dWU.setDefaultResource(e.f.icon_default_avatar100);
        this.dWU.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.dWU.setDefaultBgResource(e.d.cp_bg_line_e);
        this.dWU.setIsRound(true);
        this.aBX = (TextView) sP(e.g.user_name);
        this.gBI = (CountDownTextView) sP(e.g.count_down_text);
        this.gBE = (TextView) sP(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dWU.startLoad(fVar.gwW, 10, false);
        this.aBX.setText(fVar.userName);
        this.gBE.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aE(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gBN != null) {
                    c.this.gBN.sJ(302);
                    com.baidu.tieba.recapp.report.c.bqQ().a(c.this.gBN);
                }
                if (c.this.gBP != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gBP);
                }
                c.this.mg(false);
            }
        });
        this.gBI.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bqU() {
        super.bqU();
        this.gBI.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gBI.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void mg(boolean z) {
        this.gBJ = z;
        if (this.gBI != null) {
            this.gBI.setEnableTimeoutListener(this.gBJ);
        }
    }
}
