package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes3.dex */
public class b extends e {
    private TextView cbV;
    private HeadImageView fTJ;
    private TextView iFl;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fTJ = (HeadImageView) zg(R.id.user_portrait);
        this.fTJ.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fTJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fTJ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fTJ.setIsRound(true);
        this.cbV = (TextView) zg(R.id.user_name);
        this.iFl = (TextView) zg(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fTJ.startLoad(fVar.iAI, 10, false);
        this.cbV.setText(fVar.userName);
        this.iFl.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aG(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.iFt != null) {
                    b.this.iFt.yZ(302);
                    com.baidu.tieba.recapp.report.c.cfE().a(b.this.iFt);
                }
                if (b.this.iFv != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.iFv);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.f(this.cbV, R.color.cp_mask_e, 1);
        al.f(this.iFl, R.color.cp_btn_a, 1);
        al.g(this.iFl, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
