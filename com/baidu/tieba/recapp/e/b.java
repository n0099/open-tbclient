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
    private TextView cdg;
    private HeadImageView fZz;
    private TextView iMK;

    public b(View view, String str) {
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
        this.iMK = (TextView) zN(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fZz.startLoad(fVar.iIh, 10, false);
        this.cdg.setText(fVar.userName);
        this.iMK.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aH(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.iMS != null) {
                    b.this.iMS.zG(302);
                    com.baidu.tieba.recapp.report.c.ciQ().a(b.this.iMS);
                }
                if (b.this.iMU != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.iMU);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.f(this.cdg, R.color.cp_mask_e, 1);
        am.f(this.iMK, R.color.cp_btn_a, 1);
        am.g(this.iMK, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
