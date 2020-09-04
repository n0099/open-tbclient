package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes20.dex */
public class b extends e {
    private TextView dTU;
    private HeadImageView iDr;
    private TextView lIl;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.iDr = (HeadImageView) Gs(R.id.user_portrait);
        this.iDr.setDefaultResource(R.drawable.icon_default_avatar100);
        this.iDr.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iDr.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iDr.setIsRound(true);
        this.dTU = (TextView) Gs(R.id.user_name);
        this.lIl = (TextView) Gs(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.iDr.startLoad(fVar.lDU, 10, false);
        this.dTU.setText(fVar.userName);
        this.lIl.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aR(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.lIv != null) {
                    b.this.lIv.Gl(302);
                    com.baidu.tieba.recapp.report.d.dol().a(b.this.lIv);
                }
                if (b.this.lIx != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.lIx);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.dTU, R.color.cp_mask_c_alpha83, 1);
        ap.setViewTextColor(this.lIl, R.color.cp_cont_a, 1);
        ap.setBackgroundResource(this.lIl, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
