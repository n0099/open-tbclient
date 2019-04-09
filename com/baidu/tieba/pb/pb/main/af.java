package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class af extends v.a {
    View.OnClickListener dIp;
    public LinearLayout huc;
    public View hud;
    public RelativeLayout hue;
    public TbImageView huf;
    public TextView hug;
    public TextView huh;
    public TextView hui;
    public LinearLayout huj;
    public ImageView huk;
    public TextView hul;
    public LinearLayout hum;
    public ImageView hun;
    public TextView huo;
    public View hup;
    private com.baidu.tbadk.core.data.ap huq;
    private com.baidu.tbadk.core.data.ap hur;
    private com.baidu.tbadk.core.data.ap hus;
    private ad hut;
    private a huu;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.dIp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cZ(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo()) {
                    if (af.this.huu != null) {
                        af.this.huu.b(af.this.hut);
                    }
                    if (view2 == af.this.hue) {
                        if (af.this.huq != null && !TextUtils.isEmpty(af.this.huq.bzJ)) {
                            ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huq.bzJ});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huq.bzJ));
                        }
                    } else if (view2 == af.this.huj) {
                        BdLog.e("link: " + af.this.hur.bzJ);
                        if (af.this.hur != null && !TextUtils.isEmpty(af.this.hur.bzJ)) {
                            ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.hur.bzJ});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hur.bzJ));
                        }
                    } else if (view2 == af.this.hum && af.this.hus != null && !TextUtils.isEmpty(af.this.hus.bzJ)) {
                        ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.hus.bzJ});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hus.bzJ));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.huu = aVar;
        this.huc = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.hud = view.findViewById(d.g.pb_list_item_top_line);
        this.hue = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.huf = (TbImageView) view.findViewById(d.g.top_code_img);
        this.hug = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.huh = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.hui = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.huj = (LinearLayout) view.findViewById(d.g.news_info);
        this.huk = (ImageView) view.findViewById(d.g.news_info_img);
        this.hul = (TextView) view.findViewById(d.g.news_info_text);
        this.hum = (LinearLayout) view.findViewById(d.g.game_info);
        this.hun = (ImageView) view.findViewById(d.g.game_info_img);
        this.huo = (TextView) view.findViewById(d.g.game_info_text);
        this.hup = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.dIp);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.hut = adVar;
            this.huq = adVar.htX;
            this.hur = adVar.htY;
            this.hus = adVar.htZ;
            if (this.huq != null) {
                this.huf.startLoad(this.huq.bzL, 10, false);
                this.huh.setText(this.huq.summary);
                this.hui.setText(this.huq.subtitle);
                this.hug.setText(this.huq.buttonText);
                com.baidu.tbadk.core.util.al.k(this.hug, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.j(this.hug, d.f.news_text_color_selector);
            } else {
                this.hue.setVisibility(8);
            }
            if (this.hur != null) {
                this.hul.setText(this.hur.summary);
                com.baidu.tbadk.core.util.al.k(this.huk, d.f.icon_frs_news);
            } else {
                this.huj.setVisibility(8);
                this.hul.setVisibility(8);
                this.huk.setVisibility(8);
            }
            if (this.hus != null) {
                this.huo.setText(this.hus.summary);
                com.baidu.tbadk.core.util.al.k(this.hun, d.f.icon_frs_game);
            } else {
                this.hum.setVisibility(8);
                this.huo.setVisibility(8);
                this.huo.setVisibility(8);
            }
            this.huc.setTag(adVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hue.setOnClickListener(onClickListener);
        this.huj.setOnClickListener(onClickListener);
        this.hum.setOnClickListener(onClickListener);
    }
}
