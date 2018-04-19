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
    private HeadImageView dxn;
    private TextView gcG;
    private CountDownTextView gcK;
    private boolean gcL;

    public c(View view2, String str) {
        super(view2, str);
        init();
    }

    private void init() {
        this.dxn = (HeadImageView) rY(d.g.user_portrait);
        this.dxn.setDefaultResource(d.f.icon_default_avatar100);
        this.dxn.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dxn.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.dxn.setIsRound(true);
        this.aqm = (TextView) rY(d.g.user_name);
        this.gcK = (CountDownTextView) rY(d.g.count_down_text);
        this.gcG = (TextView) rY(d.g.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.dxn.startLoad(fVar.fYg, 10, false);
        this.aqm.setText(fVar.userName);
        this.gcG.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                s.ak(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.gcP != null) {
                    c.this.gcP.rS(302);
                    com.baidu.tieba.recapp.report.b.bke().a(c.this.gcP);
                }
                c.this.lF(false);
            }
        });
        this.gcK.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void bkj() {
        super.bkj();
        this.gcK.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.gcK.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void lF(boolean z) {
        this.gcL = z;
        if (this.gcK != null) {
            this.gcK.setEnableTimeoutListener(this.gcL);
        }
    }
}
