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
    private TextView csn;
    private HeadImageView gaO;
    private TextView iNZ;
    private CountDownTextView iOf;
    private boolean iOg;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.gaO = (HeadImageView) yw(R.id.user_portrait);
        this.gaO.setDefaultResource(R.drawable.icon_default_avatar100);
        this.gaO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gaO.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gaO.setIsRound(true);
        this.csn = (TextView) yw(R.id.user_name);
        this.iOf = (CountDownTextView) yw(R.id.count_down_text);
        this.iNZ = (TextView) yw(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.gaO.startLoad(fVar.iJu, 10, false);
        this.csn.setText(fVar.userName);
        this.iNZ.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aL(c.this.mRootView.getContext(), fVar.scheme);
                if (c.this.iOj != null) {
                    c.this.iOj.yp(302);
                    com.baidu.tieba.recapp.report.c.cgI().a(c.this.iOj);
                }
                if (c.this.iOl != null) {
                    com.baidu.tieba.lego.card.b.c.a(c.this.iOl);
                }
                c.this.qg(false);
            }
        });
        this.iOf.yF(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void cgP() {
        super.cgP();
        this.iOf.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.iOf.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        am.setViewTextColor(this.csn, R.color.cp_cont_a, 1);
        am.setViewTextColor(this.iNZ, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.iNZ, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void qg(boolean z) {
        this.iOg = z;
        if (this.iOf != null) {
            this.iOf.setEnableTimeoutListener(this.iOg);
        }
    }
}
