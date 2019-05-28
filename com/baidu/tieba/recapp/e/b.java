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
    private HeadImageView fTK;
    private TextView iFn;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fTK = (HeadImageView) zg(R.id.user_portrait);
        this.fTK.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fTK.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fTK.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fTK.setIsRound(true);
        this.cbV = (TextView) zg(R.id.user_name);
        this.iFn = (TextView) zg(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fTK.startLoad(fVar.iAK, 10, false);
        this.cbV.setText(fVar.userName);
        this.iFn.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aG(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.iFv != null) {
                    b.this.iFv.yZ(302);
                    com.baidu.tieba.recapp.report.c.cfG().a(b.this.iFv);
                }
                if (b.this.iFx != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.iFx);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.f(this.cbV, R.color.cp_mask_e, 1);
        al.f(this.iFn, R.color.cp_btn_a, 1);
        al.g(this.iFn, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
