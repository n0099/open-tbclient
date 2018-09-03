package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class c extends e {
    private TextView ayV;
    private HeadImageView dPC;
    private TextView guk;
    private CountDownTextView guo;
    private boolean gup;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.dPC = (HeadImageView) sr(f.g.user_portrait);
        this.dPC.setDefaultResource(f.C0146f.icon_default_avatar100);
        this.dPC.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.dPC.setDefaultBgResource(f.d.cp_bg_line_e);
        this.dPC.setIsRound(true);
        this.ayV = (TextView) sr(f.g.user_name);
        this.guo = (CountDownTextView) sr(f.g.count_down_text);
        this.guk = (TextView) sr(f.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dPC.startLoad(fVar.gpE, 10, false);
        this.ayV.setText(fVar.userName);
        this.guk.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.ao(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gut != null) {
                    c.this.gut.sl(302);
                    com.baidu.tieba.recapp.report.c.boj().a(c.this.gut);
                }
                if (c.this.guv != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.guv);
                }
                c.this.lH(false);
            }
        });
        this.guo.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bon() {
        super.bon();
        this.guo.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.guo.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void lH(boolean z) {
        this.gup = z;
        if (this.guo != null) {
            this.guo.setEnableTimeoutListener(this.gup);
        }
    }
}
