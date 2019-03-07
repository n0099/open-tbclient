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
    private TextView bTX;
    private HeadImageView fCZ;
    private TextView imT;
    private CountDownTextView imX;
    private boolean imY;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fCZ = (HeadImageView) yd(d.g.user_portrait);
        this.fCZ.setDefaultResource(d.f.icon_default_avatar100);
        this.fCZ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.fCZ.setDefaultBgResource(d.C0236d.cp_bg_line_e);
        this.fCZ.setIsRound(true);
        this.bTX = (TextView) yd(d.g.user_name);
        this.imX = (CountDownTextView) yd(d.g.count_down_text);
        this.imT = (TextView) yd(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fCZ.startLoad(fVar.iio, 10, false);
        this.bTX.setText(fVar.userName);
        this.imT.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aT(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.inb != null) {
                    c.this.inb.xW(302);
                    com.baidu.tieba.recapp.report.c.bXB().a(c.this.inb);
                }
                if (c.this.ind != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.ind);
                }
                c.this.pp(false);
            }
        });
        this.imX.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bXF() {
        super.bXF();
        this.imX.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.imX.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void pp(boolean z) {
        this.imY = z;
        if (this.imX != null) {
            this.imX.setEnableTimeoutListener(this.imY);
        }
    }
}
