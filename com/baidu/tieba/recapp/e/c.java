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
    private TextView aqm;
    private HeadImageView dyr;
    private TextView gdJ;
    private CountDownTextView gdN;
    private boolean gdO;

    public c(View view2, String str) {
        super(view2, str);
        init();
    }

    private void init() {
        this.dyr = (HeadImageView) rX(d.g.user_portrait);
        this.dyr.setDefaultResource(d.f.icon_default_avatar100);
        this.dyr.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dyr.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.dyr.setIsRound(true);
        this.aqm = (TextView) rX(d.g.user_name);
        this.gdN = (CountDownTextView) rX(d.g.count_down_text);
        this.gdJ = (TextView) rX(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dyr.startLoad(fVar.fZj, 10, false);
        this.aqm.setText(fVar.userName);
        this.gdJ.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                s.ak(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gdS != null) {
                    c.this.gdS.rR(302);
                    com.baidu.tieba.recapp.report.b.bkd().a(c.this.gdS);
                }
                c.this.lG(false);
            }
        });
        this.gdN.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bki() {
        super.bki();
        this.gdN.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gdN.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void lG(boolean z) {
        this.gdO = z;
        if (this.gdN != null) {
            this.gdN.setEnableTimeoutListener(this.gdO);
        }
    }
}
