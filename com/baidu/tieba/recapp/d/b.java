package com.baidu.tieba.recapp.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes8.dex */
public class b extends e {
    private TextView eIO;
    private HeadImageView jWu;
    private TextView mXA;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jWu = (HeadImageView) Id(R.id.user_portrait);
        this.jWu.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jWu.setDefaultBgResource(R.color.CAM_X0205);
        this.jWu.setIsRound(true);
        this.eIO = (TextView) Id(R.id.user_name);
        this.mXA = (TextView) Id(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jWu.startLoad(fVar.mST, 10, false);
        this.eIO.setText(fVar.userName);
        this.mXA.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.x(b.this.mRootView.getContext(), fVar.scheme, fVar.pkgName);
                if (b.this.mXK != null) {
                    b.this.mXK.HW(302);
                    com.baidu.tieba.recapp.report.e.dEm().a(b.this.mXK);
                }
                if (b.this.mXM != null) {
                    com.baidu.tieba.lego.card.a.c.a(b.this.mXM);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eIO, R.color.CAM_X0620, 1);
        ap.setViewTextColor(this.mXA, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.mXA, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
