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
    private TextView aKV;
    private HeadImageView epS;
    private TextView gUm;
    private CountDownTextView gUq;
    private boolean gUr;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.epS = (HeadImageView) um(e.g.user_portrait);
        this.epS.setDefaultResource(e.f.icon_default_avatar100);
        this.epS.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.epS.setDefaultBgResource(e.d.cp_bg_line_e);
        this.epS.setIsRound(true);
        this.aKV = (TextView) um(e.g.user_name);
        this.gUq = (CountDownTextView) um(e.g.count_down_text);
        this.gUm = (TextView) um(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.epS.startLoad(fVar.gPG, 10, false);
        this.aKV.setText(fVar.userName);
        this.gUm.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aH(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gUu != null) {
                    c.this.gUu.ug(302);
                    com.baidu.tieba.recapp.report.c.bwf().a(c.this.gUu);
                }
                if (c.this.gUw != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gUw);
                }
                c.this.mP(false);
            }
        });
        this.gUq.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bwj() {
        super.bwj();
        this.gUq.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gUq.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void mP(boolean z) {
        this.gUr = z;
        if (this.gUq != null) {
            this.gUq.setEnableTimeoutListener(this.gUr);
        }
    }
}
