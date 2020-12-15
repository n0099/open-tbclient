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
    private HeadImageView jGf;
    private TextView mNK;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jGf = (HeadImageView) Jx(R.id.user_portrait);
        this.jGf.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jGf.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.jGf.setDefaultBgResource(R.color.CAM_X0205);
        this.jGf.setIsRound(true);
        this.eBQ = (TextView) Jx(R.id.user_name);
        this.mNK = (TextView) Jx(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void a(final AdCard.f fVar) {
        super.a(fVar);
        this.jGf.startLoad(fVar.mJh, 10, false);
        this.eBQ.setText(fVar.userName);
        this.mNK.setText(fVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.e.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                s.aZ(b.this.mRootView.getContext(), fVar.scheme);
                if (b.this.mNU != null) {
                    b.this.mNU.Jq(302);
                    com.baidu.tieba.recapp.report.d.dGg().a(b.this.mNU);
                }
                if (b.this.mNW != null) {
                    com.baidu.tieba.lego.card.b.c.a(b.this.mNW);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.e.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eBQ, R.color.CAM_X0620, 1);
        ap.setViewTextColor(this.mNK, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.mNK, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
