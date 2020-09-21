package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes25.dex */
public class b extends e {
    private TextView dWe;
    private HeadImageView iKM;
    private TextView lRf;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.iKM = (HeadImageView) GT(R.id.user_portrait);
        this.iKM.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iKM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iKM.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iKM.setIsRound(true);
        this.dWe = (TextView) GT(R.id.user_name);
        this.lRf = (TextView) GT(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.iKM.startLoad(fVar.lMO, 10, false);
        this.dWe.setText(fVar.userName);
        this.lRf.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aU(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.lRp != null) {
                    b.this.lRp.GM(302);
                    com.baidu.tieba.recapp.report.d.drV().a(b.this.lRp);
                }
                if (b.this.lRr != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.lRr);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.dWe, R.color.cp_mask_c_alpha83, 1);
        ap.setViewTextColor(this.lRf, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.lRf, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
