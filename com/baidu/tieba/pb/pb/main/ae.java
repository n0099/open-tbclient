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
    private TbPageContext abX;
    View.OnClickListener bEV;
    private com.baidu.tbadk.core.data.an faA;
    public LinearLayout fak;
    public View fal;
    public RelativeLayout fam;
    public TbImageView fan;
    public TextView fao;
    public TextView fap;
    public TextView faq;
    public LinearLayout far;
    public ImageView fas;
    public TextView fat;
    public LinearLayout fau;
    public ImageView fav;
    public TextView faw;
    public View fax;
    private com.baidu.tbadk.core.data.an fay;
    private com.baidu.tbadk.core.data.an faz;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bEV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aS(ae.this.abX.getPageActivity()) && com.baidu.adp.lib.util.l.hy()) {
                    if (view2 == ae.this.fam) {
                        if (ae.this.fay != null && !TextUtils.isEmpty(ae.this.fay.XH)) {
                            com.baidu.tbadk.core.util.av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ae.this.abX.getPageActivity()), new String[]{ae.this.fay.XH});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fay.XH));
                        }
                    } else if (view2 == ae.this.far) {
                        BdLog.e("link: " + ae.this.faz.XH);
                        if (ae.this.faz != null && !TextUtils.isEmpty(ae.this.faz.XH)) {
                            com.baidu.tbadk.core.util.av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ae.this.abX.getPageActivity()), new String[]{ae.this.faz.XH});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.faz.XH));
                        }
                    } else if (view2 == ae.this.fau && ae.this.faA != null && !TextUtils.isEmpty(ae.this.faA.XH)) {
                        com.baidu.tbadk.core.util.av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ae.this.abX.getPageActivity()), new String[]{ae.this.faA.XH});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.faA.XH));
                    }
                }
            }
        };
        this.abX = tbPageContext;
        this.fak = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.fal = view.findViewById(d.g.pb_list_item_top_line);
        this.fam = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fan = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fao = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fap = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.faq = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.far = (LinearLayout) view.findViewById(d.g.news_info);
        this.fas = (ImageView) view.findViewById(d.g.news_info_img);
        this.fat = (TextView) view.findViewById(d.g.news_info_text);
        this.fau = (LinearLayout) view.findViewById(d.g.game_info);
        this.fav = (ImageView) view.findViewById(d.g.game_info_img);
        this.faw = (TextView) view.findViewById(d.g.game_info_text);
        this.fax = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.bEV);
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.fay = acVar.faf;
            this.faz = acVar.fag;
            this.faA = acVar.fah;
            if (this.fay != null) {
                this.fan.startLoad(this.fay.XJ, 10, false);
                this.fap.setText(this.fay.summary);
                this.faq.setText(this.fay.subtitle);
                this.fao.setText(this.fay.buttonText);
                com.baidu.tbadk.core.util.aj.j(this.fao, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.i(this.fao, d.f.news_text_color_selector);
            } else {
                this.fam.setVisibility(8);
            }
            if (this.faz != null) {
                this.fat.setText(this.faz.summary);
                com.baidu.tbadk.core.util.aj.j(this.fas, d.f.icon_frs_news);
            } else {
                this.far.setVisibility(8);
                this.fat.setVisibility(8);
                this.fas.setVisibility(8);
            }
            if (this.faA != null) {
                this.faw.setText(this.faA.summary);
                com.baidu.tbadk.core.util.aj.j(this.fav, d.f.icon_frs_game);
            } else {
                this.fau.setVisibility(8);
                this.faw.setVisibility(8);
                this.faw.setVisibility(8);
            }
            this.fak.setTag(acVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.abX.getLayoutMode().ag(i == 1);
            this.abX.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fam.setOnClickListener(onClickListener);
        this.far.setOnClickListener(onClickListener);
        this.fau.setOnClickListener(onClickListener);
    }
}
