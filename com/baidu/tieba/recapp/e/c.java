package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class c extends e {
    private TextView cbV;
    private HeadImageView fTK;
    private TextView iFn;
    private CountDownTextView iFr;
    private boolean iFs;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fTK = (HeadImageView) zg(R.id.user_portrait);
        this.fTK.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fTK.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fTK.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fTK.setIsRound(true);
        this.cbV = (TextView) zg(R.id.user_name);
        this.iFr = (CountDownTextView) zg(R.id.count_down_text);
        this.iFn = (TextView) zg(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fTK.startLoad(fVar.iAK, 10, false);
        this.cbV.setText(fVar.userName);
        this.iFn.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aG(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.iFv != null) {
                    c.this.iFv.yZ(302);
                    com.baidu.tieba.recapp.report.c.cfG().a(c.this.iFv);
                }
                if (c.this.iFx != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.iFx);
                }
                c.this.qd(false);
            }
        });
        this.iFr.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cfK() {
        super.cfK();
        this.iFr.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.iFr.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        al.f(this.cbV, R.color.cp_btn_a, 1);
        al.f(this.iFn, R.color.cp_btn_a, 1);
        al.g(this.iFn, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void qd(boolean z) {
        this.iFs = z;
        if (this.iFr != null) {
            this.iFr.setEnableTimeoutListener(this.iFs);
        }
    }
}
