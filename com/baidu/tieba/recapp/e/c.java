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
    private TextView azm;
    private HeadImageView dMT;
    private TextView gsU;
    private CountDownTextView gsY;
    private boolean gsZ;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.dMT = (HeadImageView) st(d.g.user_portrait);
        this.dMT.setDefaultResource(d.f.icon_default_avatar100);
        this.dMT.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dMT.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.dMT.setIsRound(true);
        this.azm = (TextView) st(d.g.user_name);
        this.gsY = (CountDownTextView) st(d.g.count_down_text);
        this.gsU = (TextView) st(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dMT.startLoad(fVar.gor, 10, false);
        this.azm.setText(fVar.userName);
        this.gsU.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.am(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gtd != null) {
                    c.this.gtd.sn(302);
                    com.baidu.tieba.recapp.report.b.bpD().a(c.this.gtd);
                }
                if (c.this.gtf != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gtf);
                }
                c.this.lW(false);
            }
        });
        this.gsY.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bpH() {
        super.bpH();
        this.gsY.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gsY.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void lW(boolean z) {
        this.gsZ = z;
        if (this.gsY != null) {
            this.gsY.setEnableTimeoutListener(this.gsZ);
        }
    }
}
