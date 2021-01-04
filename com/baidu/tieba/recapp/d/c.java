package com.baidu.tieba.recapp.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes8.dex */
public class c extends e {
    private TextView eLt;
    private HeadImageView jTx;
    private TextView mSU;
    private CountDownTextView mTa;
    private boolean mTb;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jTx = (HeadImageView) Jr(R.id.user_portrait);
        this.jTx.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jTx.setDefaultBgResource(R.color.CAM_X0205);
        this.jTx.setIsRound(true);
        this.eLt = (TextView) Jr(R.id.user_name);
        this.mTa = (CountDownTextView) Jr(R.id.count_down_text);
        this.mSU = (TextView) Jr(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jTx.startLoad(fVar.mOp, 10, false);
        this.eLt.setText(fVar.userName);
        this.mSU.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.x(c.this.mRootView.getContext(), fVar.scheme, null);
                if (c.this.mTe != null) {
                    c.this.mTe.Jk(302);
                    com.baidu.tieba.recapp.report.e.dFV().a(c.this.mTe);
                }
                if (c.this.mTg != null) {
                    com.baidu.tieba.lego.card.a.c.a(c.this.mTg);
                }
                c.this.xo(false);
            }
        });
        this.mTa.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void dGc() {
        super.dGc();
        this.mTa.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.mTa.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        ao.setViewTextColor(this.eLt, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.mSU, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.mSU, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void xo(boolean z) {
        this.mTb = z;
        if (this.mTa != null) {
            this.mTa.setEnableTimeoutListener(this.mTb);
        }
    }
}
