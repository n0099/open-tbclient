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
    private TextView cbW;
    private HeadImageView fTM;
    private TextView iFo;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.fTM = (HeadImageView) zg(R.id.user_portrait);
        this.fTM.setDefaultResource(R.drawable.icon_default_avatar100);
        this.fTM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fTM.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fTM.setIsRound(true);
        this.cbW = (TextView) zg(R.id.user_name);
        this.iFo = (TextView) zg(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.fTM.startLoad(fVar.iAL, 10, false);
        this.cbW.setText(fVar.userName);
        this.iFo.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aG(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.iFw != null) {
                    b.this.iFw.yZ(302);
                    com.baidu.tieba.recapp.report.c.cfH().a(b.this.iFw);
                }
                if (b.this.iFy != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.iFy);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        al.f(this.cbW, R.color.cp_mask_e, 1);
        al.f(this.iFo, R.color.cp_btn_a, 1);
        al.g(this.iFo, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
