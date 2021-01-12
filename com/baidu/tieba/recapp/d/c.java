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
/* loaded from: classes7.dex */
public class c extends e {
    private TextView eGI;
    private HeadImageView jOS;
    private TextView mOl;
    private CountDownTextView mOr;
    private boolean mOs;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jOS = (HeadImageView) HK(R.id.user_portrait);
        this.jOS.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jOS.setDefaultBgResource(R.color.CAM_X0205);
        this.jOS.setIsRound(true);
        this.eGI = (TextView) HK(R.id.user_name);
        this.mOr = (CountDownTextView) HK(R.id.count_down_text);
        this.mOl = (TextView) HK(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jOS.startLoad(fVar.mJK, 10, false);
        this.eGI.setText(fVar.userName);
        this.mOl.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.x(c.this.mRootView.getContext(), fVar.scheme, null);
                if (c.this.mOv != null) {
                    c.this.mOv.HD(302);
                    com.baidu.tieba.recapp.report.e.dCe().a(c.this.mOv);
                }
                if (c.this.mOx != null) {
                    com.baidu.tieba.lego.card.a.c.a(c.this.mOx);
                }
                c.this.xk(false);
            }
        });
        this.mOr.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void dCl() {
        super.dCl();
        this.mOr.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.mOr.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        ao.setViewTextColor(this.eGI, R.color.CAM_X0101, 1);
        ao.setViewTextColor(this.mOl, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.mOl, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void xk(boolean z) {
        this.mOs = z;
        if (this.mOr != null) {
            this.mOr.setEnableTimeoutListener(this.mOs);
        }
    }
}
