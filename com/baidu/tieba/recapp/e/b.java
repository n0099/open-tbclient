package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class b extends e {
    private TextView csn;
    private HeadImageView gaO;
    private TextView iNZ;

    public b(View view, String str) {
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
        this.iNZ = (TextView) yw(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.gaO.startLoad(fVar.iJu, 10, false);
        this.csn.setText(fVar.userName);
        this.iNZ.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aL(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.iOj != null) {
                    b.this.iOj.yp(302);
                    com.baidu.tieba.recapp.report.c.cgI().a(b.this.iOj);
                }
                if (b.this.iOl != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.iOl);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.csn, R.color.cp_mask_c_alpha83, 1);
        am.setViewTextColor(this.iNZ, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.iNZ, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
