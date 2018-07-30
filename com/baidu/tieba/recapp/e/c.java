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
    private TextView ayY;
    private HeadImageView dPG;
    private TextView guh;
    private CountDownTextView gul;
    private boolean gum;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.dPG = (HeadImageView) sr(d.g.user_portrait);
        this.dPG.setDefaultResource(d.f.icon_default_avatar100);
        this.dPG.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dPG.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.dPG.setIsRound(true);
        this.ayY = (TextView) sr(d.g.user_name);
        this.gul = (CountDownTextView) sr(d.g.count_down_text);
        this.guh = (TextView) sr(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dPG.startLoad(fVar.gpB, 10, false);
        this.ayY.setText(fVar.userName);
        this.guh.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.ao(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.guq != null) {
                    c.this.guq.sl(302);
                    com.baidu.tieba.recapp.report.c.boi().a(c.this.guq);
                }
                if (c.this.gus != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gus);
                }
                c.this.lH(false);
            }
        });
        this.gul.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bom() {
        super.bom();
        this.gul.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gul.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void lH(boolean z) {
        this.gum = z;
        if (this.gul != null) {
            this.gul.setEnableTimeoutListener(this.gum);
        }
    }
}
