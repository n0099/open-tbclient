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
    private HeadImageView eeO;
    private TextView gJd;
    private CountDownTextView gJh;
    private boolean gJi;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.eeO = (HeadImageView) tm(e.g.user_portrait);
        this.eeO.setDefaultResource(e.f.icon_default_avatar100);
        this.eeO.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.eeO.setDefaultBgResource(e.d.cp_bg_line_e);
        this.eeO.setIsRound(true);
        this.aGD = (TextView) tm(e.g.user_name);
        this.gJh = (CountDownTextView) tm(e.g.count_down_text);
        this.gJd = (TextView) tm(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.eeO.startLoad(fVar.gEx, 10, false);
        this.aGD.setText(fVar.userName);
        this.gJd.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aG(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gJm != null) {
                    c.this.gJm.tg(302);
                    com.baidu.tieba.recapp.report.c.buf().a(c.this.gJm);
                }
                if (c.this.gJo != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gJo);
                }
                c.this.my(false);
            }
        });
        this.gJh.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void buj() {
        super.buj();
        this.gJh.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gJh.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void my(boolean z) {
        this.gJi = z;
        if (this.gJh != null) {
            this.gJh.setEnableTimeoutListener(this.gJi);
        }
    }
}
