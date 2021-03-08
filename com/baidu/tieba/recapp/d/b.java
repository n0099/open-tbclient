package com.baidu.tieba.recapp.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.t;
/* loaded from: classes7.dex */
public class b extends e {
    private TextView eKp;
    private HeadImageView jYK;
    private TextView nak;

    public b(View view, String str) {
        super(view, str);
        init();
    }

    private void init() {
        this.jYK = (HeadImageView) Ih(R.id.user_portrait);
        this.jYK.setDefaultResource(R.drawable.icon_default_avatar100);
        this.jYK.setDefaultBgResource(R.color.CAM_X0205);
        this.jYK.setIsRound(true);
        this.eKp = (TextView) Ih(R.id.user_name);
        this.nak = (TextView) Ih(R.id.action);
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void a(final AdCard.g gVar) {
        super.a(gVar);
        this.jYK.startLoad(gVar.mVF, 10, false);
        this.eKp.setText(gVar.userName);
        this.nak.setText(gVar.buttonText);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.d.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                t.i(b.this.mRootView.getContext(), gVar.scheme, gVar.pkgName, b.this.naw != null ? b.this.naw.extensionInfo : "");
                if (b.this.nav != null) {
                    b.this.nav.Ia(302);
                    com.baidu.tieba.recapp.report.e.dEC().a(b.this.nav);
                }
                if (b.this.nax != null) {
                    com.baidu.tieba.lego.card.a.c.a(b.this.nax);
                }
            }
        });
        onChangeSkinType();
    }

    @Override // com.baidu.tieba.recapp.d.e
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setViewTextColor(this.eKp, R.color.CAM_X0620, 1);
        ap.setViewTextColor(this.nak, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.nak, R.drawable.tail_frame_action_btn_bg, TbadkCoreApplication.getInst().getSkinType());
    }
}
