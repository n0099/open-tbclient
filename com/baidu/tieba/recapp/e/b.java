package com.baidu.tieba.recapp.e;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes26.dex */
public class b extends e {
    private TextView eBQ;
    private HeadImageView jGd;
    private TextView mNI;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jGd = (HeadImageView) Jx(R.id.user_portrait);
        this.jGd.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jGd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jGd.setDefaultBgResource(R.color.CAM_X0205);
        this.jGd.setIsRound(true);
        this.eBQ = (TextView) Jx(R.id.user_name);
        this.mNI = (TextView) Jx(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jGd.startLoad(fVar.mJf, 10, false);
        this.eBQ.setText(fVar.userName);
        this.mNI.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aZ(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.mNS != null) {
                    b.this.mNS.Jq(302);
                    com.baidu.tieba.recapp.report.d.dGf().a(b.this.mNS);
                }
                if (b.this.mNU != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.mNU);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eBQ, R.color.CAM_X0620, 1);
        ap.setViewTextColor(this.mNI, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.mNI, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
