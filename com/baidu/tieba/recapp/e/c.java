package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes3.dex */
public class c extends e {
    private TextView cdg;
    private HeadImageView fZz;
    private TextView iMK;
    private CountDownTextView iMO;
    private boolean iMP;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fZz = (HeadImageView) zN(R.id.user_portrait);
        this.fZz.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fZz.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fZz.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fZz.setIsRound(true);
        this.cdg = (TextView) zN(R.id.user_name);
        this.iMO = (CountDownTextView) zN(R.id.count_down_text);
        this.iMK = (TextView) zN(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fZz.startLoad(fVar.iIh, 10, false);
        this.cdg.setText(fVar.userName);
        this.iMK.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aH(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.iMS != null) {
                    c.this.iMS.zG(302);
                    com.baidu.tieba.recapp.report.c.ciQ().a(c.this.iMS);
                }
                if (c.this.iMU != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.iMU);
                }
                c.this.qu(false);
            }
        });
        this.iMO.zW(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void ciU() {
        super.ciU();
        this.iMO.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.iMO.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.f(this.cdg, R.color.cp_btn_a, 1);
        am.f(this.iMK, R.color.cp_btn_a, 1);
        am.g(this.iMK, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void qu(boolean z) {
        this.iMP = z;
        if (this.iMO != null) {
            this.iMO.setEnableTimeoutListener(this.iMP);
        }
    }
}
