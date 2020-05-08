package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.r;
/* loaded from: classes13.dex */
public class b extends e {
    private TextView cBd;
    private HeadImageView hFh;
    private TextView kxn;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.hFh = (HeadImageView) BN(R.id.user_portrait);
        this.hFh.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hFh.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hFh.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hFh.setIsRound(true);
        this.cBd = (TextView) BN(R.id.user_name);
        this.kxn = (TextView) BN(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.hFh.startLoad(fVar.ksV, 10, false);
        this.cBd.setText(fVar.userName);
        this.kxn.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.aN(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.kxx != null) {
                    b.this.kxx.BG(302);
                    com.baidu.tieba.recapp.report.d.cOi().a(b.this.kxx);
                }
                if (b.this.kxz != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.kxz);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.cBd, R.color.cp_mask_c_alpha83, 1);
        am.setViewTextColor(this.kxn, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kxn, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
