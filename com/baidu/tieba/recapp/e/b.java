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
    private TextView cAX;
    private HeadImageView hFb;
    private TextView kxj;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.hFb = (HeadImageView) BN(R.id.user_portrait);
        this.hFb.setDefaultResource(R.drawable.icon_default_avatar100);
        this.hFb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hFb.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hFb.setIsRound(true);
        this.cAX = (TextView) BN(R.id.user_name);
        this.kxj = (TextView) BN(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.hFb.startLoad(fVar.ksR, 10, false);
        this.cAX.setText(fVar.userName);
        this.kxj.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.aZ(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.kxt != null) {
                    b.this.kxt.BG(302);
                    com.baidu.tieba.recapp.report.d.cOl().a(b.this.kxt);
                }
                if (b.this.kxv != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.kxv);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        am.setViewTextColor(this.cAX, R.color.cp_mask_c_alpha83, 1);
        am.setViewTextColor(this.kxj, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.kxj, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
