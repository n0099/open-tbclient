package com.baidu.tieba.recapp.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes8.dex */
public class c extends e {
    private TextView eIO;
    private HeadImageView jWu;
    private TextView mXA;
    private CountDownTextView mXG;
    private boolean mXH;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jWu = (HeadImageView) Id(R.id.user_portrait);
        this.jWu.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jWu.setDefaultBgResource(R.color.CAM_X0205);
        this.jWu.setIsRound(true);
        this.eIO = (TextView) Id(R.id.user_name);
        this.mXG = (CountDownTextView) Id(R.id.count_down_text);
        this.mXA = (TextView) Id(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jWu.startLoad(fVar.mST, 10, false);
        this.eIO.setText(fVar.userName);
        this.mXA.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.x(c.this.mRootView.getContext(), fVar.scheme, null);
                if (c.this.mXK != null) {
                    c.this.mXK.HW(302);
                    com.baidu.tieba.recapp.report.e.dEm().a(c.this.mXK);
                }
                if (c.this.mXM != null) {
                    com.baidu.tieba.lego.card.a.c.a(c.this.mXM);
                }
                c.this.xD(false);
            }
        });
        this.mXG.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void dEt() {
        super.dEt();
        this.mXG.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.mXG.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.mXA, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.mXA, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void xD(boolean z) {
        this.mXH = z;
        if (this.mXG != null) {
            this.mXG.setEnableTimeoutListener(this.mXH);
        }
    }
}
