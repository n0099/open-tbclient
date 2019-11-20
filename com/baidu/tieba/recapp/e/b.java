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
    private TextView crw;
    private HeadImageView fZX;
    private TextView iNi;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fZX = (HeadImageView) yv(R.id.user_portrait);
        this.fZX.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fZX.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fZX.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fZX.setIsRound(true);
        this.crw = (TextView) yv(R.id.user_name);
        this.iNi = (TextView) yv(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fZX.startLoad(fVar.iID, 10, false);
        this.crw.setText(fVar.userName);
        this.iNi.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aL(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.iNs != null) {
                    b.this.iNs.yo(302);
                    com.baidu.tieba.recapp.report.c.cgG().a(b.this.iNs);
                }
                if (b.this.iNu != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.iNu);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.crw, R.color.cp_mask_c_alpha83, 1);
        am.setViewTextColor(this.iNi, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.iNi, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
