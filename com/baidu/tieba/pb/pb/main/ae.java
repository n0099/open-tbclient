package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ae extends j.a {
    private TbPageContext aca;
    View.OnClickListener bEZ;
    public ImageView faA;
    public TextView faB;
    public View faC;
    private com.baidu.tbadk.core.data.an faD;
    private com.baidu.tbadk.core.data.an faE;
    private com.baidu.tbadk.core.data.an faF;
    public LinearLayout fap;
    public View faq;
    public RelativeLayout far;
    public TbImageView fas;
    public TextView fat;
    public TextView fau;
    public TextView fav;
    public LinearLayout faw;
    public ImageView fax;
    public TextView fay;
    public LinearLayout faz;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bEZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aS(ae.this.aca.getPageActivity()) && com.baidu.adp.lib.util.l.hy()) {
                    if (view2 == ae.this.far) {
                        if (ae.this.faD != null && !TextUtils.isEmpty(ae.this.faD.XK)) {
                            com.baidu.tbadk.core.util.av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ae.this.aca.getPageActivity()), new String[]{ae.this.faD.XK});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.faD.XK));
                        }
                    } else if (view2 == ae.this.faw) {
                        BdLog.e("link: " + ae.this.faE.XK);
                        if (ae.this.faE != null && !TextUtils.isEmpty(ae.this.faE.XK)) {
                            com.baidu.tbadk.core.util.av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ae.this.aca.getPageActivity()), new String[]{ae.this.faE.XK});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.faE.XK));
                        }
                    } else if (view2 == ae.this.faz && ae.this.faF != null && !TextUtils.isEmpty(ae.this.faF.XK)) {
                        com.baidu.tbadk.core.util.av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ae.this.aca.getPageActivity()), new String[]{ae.this.faF.XK});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.faF.XK));
                    }
                }
            }
        };
        this.aca = tbPageContext;
        this.fap = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.faq = view.findViewById(d.g.pb_list_item_top_line);
        this.far = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fas = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fat = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fau = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fav = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.faw = (LinearLayout) view.findViewById(d.g.news_info);
        this.fax = (ImageView) view.findViewById(d.g.news_info_img);
        this.fay = (TextView) view.findViewById(d.g.news_info_text);
        this.faz = (LinearLayout) view.findViewById(d.g.game_info);
        this.faA = (ImageView) view.findViewById(d.g.game_info_img);
        this.faB = (TextView) view.findViewById(d.g.game_info_text);
        this.faC = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.bEZ);
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.faD = acVar.fak;
            this.faE = acVar.fal;
            this.faF = acVar.fam;
            if (this.faD != null) {
                this.fas.startLoad(this.faD.XM, 10, false);
                this.fau.setText(this.faD.summary);
                this.fav.setText(this.faD.subtitle);
                this.fat.setText(this.faD.buttonText);
                com.baidu.tbadk.core.util.aj.j(this.fat, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.i(this.fat, d.f.news_text_color_selector);
            } else {
                this.far.setVisibility(8);
            }
            if (this.faE != null) {
                this.fay.setText(this.faE.summary);
                com.baidu.tbadk.core.util.aj.j(this.fax, d.f.icon_frs_news);
            } else {
                this.faw.setVisibility(8);
                this.fay.setVisibility(8);
                this.fax.setVisibility(8);
            }
            if (this.faF != null) {
                this.faB.setText(this.faF.summary);
                com.baidu.tbadk.core.util.aj.j(this.faA, d.f.icon_frs_game);
            } else {
                this.faz.setVisibility(8);
                this.faB.setVisibility(8);
                this.faB.setVisibility(8);
            }
            this.fap.setTag(acVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aca.getLayoutMode().ag(i == 1);
            this.aca.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.far.setOnClickListener(onClickListener);
        this.faw.setOnClickListener(onClickListener);
        this.faz.setOnClickListener(onClickListener);
    }
}
