package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.r;
/* loaded from: classes25.dex */
public class b extends e {
    private TextView euO;
    private HeadImageView jsD;
    private TextView mzx;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jsD = (HeadImageView) IG(R.id.user_portrait);
        this.jsD.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jsD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jsD.setDefaultBgResource(R.color.CAM_X0205);
        this.jsD.setIsRound(true);
        this.euO = (TextView) IG(R.id.user_name);
        this.mzx = (TextView) IG(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jsD.startLoad(fVar.muT, 10, false);
        this.euO.setText(fVar.userName);
        this.mzx.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.aV(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.mzH != null) {
                    b.this.mzH.Iz(302);
                    com.baidu.tieba.recapp.report.d.dAT().a(b.this.mzH);
                }
                if (b.this.mzJ != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.mzJ);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.euO, R.color.CAM_X0620, 1);
        ap.setViewTextColor(this.mzx, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.mzx, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
