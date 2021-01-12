package com.baidu.tieba.recapp.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes7.dex */
public class b extends e {
    private TextView eGI;
    private HeadImageView jOS;
    private TextView mOl;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jOS = (HeadImageView) HK(R.id.user_portrait);
        this.jOS.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jOS.setDefaultBgResource(R.color.CAM_X0205);
        this.jOS.setIsRound(true);
        this.eGI = (TextView) HK(R.id.user_name);
        this.mOl = (TextView) HK(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jOS.startLoad(fVar.mJK, 10, false);
        this.eGI.setText(fVar.userName);
        this.mOl.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.x(b.this.mRootView.getContext(), fVar.scheme, fVar.pkgName);
                if (b.this.mOv != null) {
                    b.this.mOv.HD(302);
                    com.baidu.tieba.recapp.report.e.dCe().a(b.this.mOv);
                }
                if (b.this.mOx != null) {
                    com.baidu.tieba.lego.card.a.c.a(b.this.mOx);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setViewTextColor(this.eGI, R.color.CAM_X0620, 1);
        ao.setViewTextColor(this.mOl, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.mOl, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
