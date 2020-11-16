package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes25.dex */
public class c extends e {
    private TextView euO;
    private HeadImageView jsD;
    private CountDownTextView mzD;
    private boolean mzE;
    private TextView mzx;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jsD = (HeadImageView) IG(R.id.user_portrait);
        this.jsD.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jsD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jsD.setDefaultBgResource(R.color.CAM_X0205);
        this.jsD.setIsRound(true);
        this.euO = (TextView) IG(R.id.user_name);
        this.mzD = (CountDownTextView) IG(R.id.count_down_text);
        this.mzx = (TextView) IG(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jsD.startLoad(fVar.muT, 10, false);
        this.euO.setText(fVar.userName);
        this.mzx.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.aV(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.mzH != null) {
                    c.this.mzH.Iz(302);
                    com.baidu.tieba.recapp.report.d.dAT().a(c.this.mzH);
                }
                if (c.this.mzJ != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.mzJ);
                }
                c.this.wJ(false);
            }
        });
        this.mzD.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void dBa() {
        super.dBa();
        this.mzD.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.mzD.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        ap.setViewTextColor(this.euO, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.mzx, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.mzx, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void wJ(boolean z) {
        this.mzE = z;
        if (this.mzD != null) {
            this.mzD.setEnableTimeoutListener(this.mzE);
        }
    }
}
