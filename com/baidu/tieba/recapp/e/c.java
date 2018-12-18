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
    private TextView aKT;
    private HeadImageView ena;
    private TextView gRu;
    private CountDownTextView gRy;
    private boolean gRz;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.ena = (HeadImageView) tZ(e.g.user_portrait);
        this.ena.setDefaultResource(e.f.icon_default_avatar100);
        this.ena.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.ena.setDefaultBgResource(e.d.cp_bg_line_e);
        this.ena.setIsRound(true);
        this.aKT = (TextView) tZ(e.g.user_name);
        this.gRy = (CountDownTextView) tZ(e.g.count_down_text);
        this.gRu = (TextView) tZ(e.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.ena.startLoad(fVar.gMO, 10, false);
        this.aKT.setText(fVar.userName);
        this.gRu.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aH(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gRC != null) {
                    c.this.gRC.tT(302);
                    com.baidu.tieba.recapp.report.c.bvt().a(c.this.gRC);
                }
                if (c.this.gRE != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.gRE);
                }
                c.this.mM(false);
            }
        });
        this.gRy.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bvx() {
        super.bvx();
        this.gRy.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gRy.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void mM(boolean z) {
        this.gRz = z;
        if (this.gRy != null) {
            this.gRy.setEnableTimeoutListener(this.gRz);
        }
    }
}
