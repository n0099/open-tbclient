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
    private TextView bTY;
    private HeadImageView fCY;
    private TextView imN;
    private CountDownTextView imR;
    private boolean imS;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fCY = (HeadImageView) yd(d.g.user_portrait);
        this.fCY.setDefaultResource(d.f.icon_default_avatar100);
        this.fCY.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fCY.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.fCY.setIsRound(true);
        this.bTY = (TextView) yd(d.g.user_name);
        this.imR = (CountDownTextView) yd(d.g.count_down_text);
        this.imN = (TextView) yd(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fCY.startLoad(fVar.iij, 10, false);
        this.bTY.setText(fVar.userName);
        this.imN.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aS(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.imV != null) {
                    c.this.imV.xW(302);
                    com.baidu.tieba.recapp.report.c.bXE().a(c.this.imV);
                }
                if (c.this.imX != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.imX);
                }
                c.this.pp(false);
            }
        });
        this.imR.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bXI() {
        super.bXI();
        this.imR.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.imR.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void pp(boolean z) {
        this.imS = z;
        if (this.imR != null) {
            this.imR.setEnableTimeoutListener(this.imS);
        }
    }
}
