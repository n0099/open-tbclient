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
    private TextView aGD;
    private HeadImageView eeN;
    private TextView gJc;
    private CountDownTextView gJg;
    private boolean gJh;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.eeN = (HeadImageView) tm(e.g.user_portrait);
        this.eeN.setDefaultResource(e.f.icon_default_avatar100);
        this.eeN.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eeN.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eeN.setIsRound(true);
        this.aGD = (TextView) tm(e.g.user_name);
        this.gJg = (CountDownTextView) tm(e.g.count_down_text);
        this.gJc = (TextView) tm(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.eeN.startLoad(fVar.gEw, 10, false);
        this.aGD.setText(fVar.userName);
        this.gJc.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aG(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gJl != null) {
                    c.this.gJl.tg(302);
                    com.baidu.tieba.recapp.report.c.buf().a(c.this.gJl);
                }
                if (c.this.gJn != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gJn);
                }
                c.this.my(false);
            }
        });
        this.gJg.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void buj() {
        super.buj();
        this.gJg.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gJg.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void my(boolean z) {
        this.gJh = z;
        if (this.gJg != null) {
            this.gJg.setEnableTimeoutListener(this.gJh);
        }
    }
}
