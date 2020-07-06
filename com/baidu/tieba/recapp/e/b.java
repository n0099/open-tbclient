package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.r;
/* loaded from: classes13.dex */
public class b extends e {
    private TextView dEL;
    private HeadImageView ijb;
    private TextView lki;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.ijb = (HeadImageView) DB(R.id.user_portrait);
        this.ijb.setDefaultResource(R.drawable.icon_default_avatar100);
        this.ijb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ijb.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ijb.setIsRound(true);
        this.dEL = (TextView) DB(R.id.user_name);
        this.lki = (TextView) DB(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.ijb.startLoad(fVar.lfS, 10, false);
        this.dEL.setText(fVar.userName);
        this.lki.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.aO(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.lks != null) {
                    b.this.lks.Du(302);
                    com.baidu.tieba.recapp.report.d.cZR().a(b.this.lks);
                }
                if (b.this.lku != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.lku);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        an.setViewTextColor(this.dEL, R.color.cp_mask_c_alpha83, 1);
        an.setViewTextColor(this.lki, R.color.cp_cont_a, 1);
        an.setBackgroundResource(this.lki, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
