package com.baidu.tieba.recapp.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.t;
/* loaded from: classes8.dex */
public class b extends e {
    private TextView eIO;
    private HeadImageView jWI;
    private TextView mYa;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jWI = (HeadImageView) Id(R.id.user_portrait);
        this.jWI.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jWI.setDefaultBgResource(R.color.CAM_X0205);
        this.jWI.setIsRound(true);
        this.eIO = (TextView) Id(R.id.user_name);
        this.mYa = (TextView) Id(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jWI.startLoad(fVar.mTv, 10, false);
        this.eIO.setText(fVar.userName);
        this.mYa.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                t.i(b.this.mRootView.getContext(), fVar.scheme, fVar.pkgName, b.this.mYl != null ? b.this.mYl.extensionInfo : "");
                if (b.this.mYk != null) {
                    b.this.mYk.HW(302);
                    com.baidu.tieba.recapp.report.e.dEu().a(b.this.mYk);
                }
                if (b.this.mYm != null) {
                    com.baidu.tieba.lego.card.a.c.a(b.this.mYm);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eIO, R.color.CAM_X0620, 1);
        ap.setViewTextColor(this.mYa, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.mYa, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
