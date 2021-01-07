package com.baidu.tieba.recapp.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes8.dex */
public class b extends e {
    private TextView eLt;
    private HeadImageView jTx;
    private TextView mST;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jTx = (HeadImageView) Jr(R.id.user_portrait);
        this.jTx.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jTx.setDefaultBgResource(R.color.CAM_X0205);
        this.jTx.setIsRound(true);
        this.eLt = (TextView) Jr(R.id.user_name);
        this.mST = (TextView) Jr(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jTx.startLoad(fVar.mOo, 10, false);
        this.eLt.setText(fVar.userName);
        this.mST.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.x(b.this.mRootView.getContext(), fVar.scheme, fVar.pkgName);
                if (b.this.mTd != null) {
                    b.this.mTd.Jk(302);
                    com.baidu.tieba.recapp.report.e.dFW().a(b.this.mTd);
                }
                if (b.this.mTf != null) {
                    com.baidu.tieba.lego.card.a.c.a(b.this.mTf);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setViewTextColor(this.eLt, R.color.CAM_X0620, 1);
        ao.setViewTextColor(this.mST, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.mST, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
