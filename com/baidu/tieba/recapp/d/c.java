package com.baidu.tieba.recapp.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.recapp.widget.CountDownTextView;
/* loaded from: classes8.dex */
public class c extends e {
    private TextView eIO;
    private HeadImageView jWI;
    private TextView mYa;
    private CountDownTextView mYg;
    private boolean mYh;

    public c(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jWI = (HeadImageView) Id(R.id.user_portrait);
        this.jWI.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jWI.setDefaultBgResource(R.color.CAM_X0205);
        this.jWI.setIsRound(true);
        this.eIO = (TextView) Id(R.id.user_name);
        this.mYg = (CountDownTextView) Id(R.id.count_down_text);
        this.mYa = (TextView) Id(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jWI.startLoad(fVar.mTv, 10, false);
        this.eIO.setText(fVar.userName);
        this.mYa.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.d.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                t.i(c.this.mRootView.getContext(), fVar.scheme, null, c.this.mYl != null ? c.this.mYl.extensionInfo : "");
                if (c.this.mYk != null) {
                    c.this.mYk.HW(302);
                    com.baidu.tieba.recapp.report.e.dEu().a(c.this.mYk);
                }
                if (c.this.mYm != null) {
                    com.baidu.tieba.lego.card.a.c.a(c.this.mYm);
                }
                c.this.xD(false);
            }
        });
        this.mYg.update(fVar.count);
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void dEB() {
        super.dEB();
        this.mYg.startCountDown();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void setTimeoutListener(CountDownTextView.b bVar) {
        super.setTimeoutListener(bVar);
        this.mYg.setTimeoutListener(bVar);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101, 1);
        ap.setViewTextColor(this.mYa, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.mYa, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void xD(boolean z) {
        this.mYh = z;
        if (this.mYg != null) {
            this.mYg.setEnableTimeoutListener(this.mYh);
        }
    }
}
