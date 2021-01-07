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
    private TextView mST;
    private CountDownTextView mSZ;
    private boolean mTa;

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
        this.mSZ = (CountDownTextView) Jr(R.id.count_down_text);
        this.mST = (TextView) Jr(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jTx.startLoad(fVar.mOo, 10, false);
        this.eLt.setText(fVar.userName);
        this.mST.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.x(c.this.mRootView.getContext(), fVar.scheme, null);
                if (c.this.mTd != null) {
                    c.this.mTd.Jk(302);
                    com.baidu.tieba.recapp.report.e.dFW().a(c.this.mTd);
                }
                if (c.this.mTf != null) {
                    com.baidu.tieba.lego.card.a.c.a(c.this.mTf);
                }
                c.this.xo(false);
            }
        });
        this.mSZ.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void dGd() {
        super.dGd();
        this.mSZ.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.mSZ.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        ao.setViewTextColor(this.eLt, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.mST, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.mST, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void xo(boolean z) {
        this.mTa = z;
        if (this.mSZ != null) {
            this.mSZ.setEnableTimeoutListener(this.mTa);
        }
    }
}
