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
    View.OnClickListener dIo;
    public LinearLayout hub;
    public View huc;
    public RelativeLayout hud;
    public TbImageView hue;
    public TextView huf;
    public TextView hug;
    public TextView huh;
    public LinearLayout hui;
    public ImageView huj;
    public TextView huk;
    public LinearLayout hul;
    public ImageView hum;
    public TextView hun;
    public View huo;
    private com.baidu.tbadk.core.data.ap hup;
    private com.baidu.tbadk.core.data.ap huq;
    private com.baidu.tbadk.core.data.ap hur;
    private ad hus;
    private a hut;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.dIo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cZ(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo()) {
                    if (af.this.hut != null) {
                        af.this.hut.b(af.this.hus);
                    }
                    if (view2 == af.this.hud) {
                        if (af.this.hup != null && !TextUtils.isEmpty(af.this.hup.bzI)) {
                            ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.hup.bzI});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hup.bzI));
                        }
                    } else if (view2 == af.this.hui) {
                        BdLog.e("link: " + af.this.huq.bzI);
                        if (af.this.huq != null && !TextUtils.isEmpty(af.this.huq.bzI)) {
                            ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huq.bzI});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huq.bzI));
                        }
                    } else if (view2 == af.this.hul && af.this.hur != null && !TextUtils.isEmpty(af.this.hur.bzI)) {
                        ba.adA().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.hur.bzI});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hur.bzI));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hut = aVar;
        this.hub = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.huc = view.findViewById(d.g.pb_list_item_top_line);
        this.hud = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.hue = (TbImageView) view.findViewById(d.g.top_code_img);
        this.huf = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.hug = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.huh = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.hui = (LinearLayout) view.findViewById(d.g.news_info);
        this.huj = (ImageView) view.findViewById(d.g.news_info_img);
        this.huk = (TextView) view.findViewById(d.g.news_info_text);
        this.hul = (LinearLayout) view.findViewById(d.g.game_info);
        this.hum = (ImageView) view.findViewById(d.g.game_info_img);
        this.hun = (TextView) view.findViewById(d.g.game_info_text);
        this.huo = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.dIo);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.hus = adVar;
            this.hup = adVar.htW;
            this.huq = adVar.htX;
            this.hur = adVar.htY;
            if (this.hup != null) {
                this.hue.startLoad(this.hup.bzK, 10, false);
                this.hug.setText(this.hup.summary);
                this.huh.setText(this.hup.subtitle);
                this.huf.setText(this.hup.buttonText);
                com.baidu.tbadk.core.util.al.k(this.huf, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.j(this.huf, d.f.news_text_color_selector);
            } else {
                this.hud.setVisibility(8);
            }
            if (this.huq != null) {
                this.huk.setText(this.huq.summary);
                com.baidu.tbadk.core.util.al.k(this.huj, d.f.icon_frs_news);
            } else {
                this.hui.setVisibility(8);
                this.huk.setVisibility(8);
                this.huj.setVisibility(8);
            }
            if (this.hur != null) {
                this.hun.setText(this.hur.summary);
                com.baidu.tbadk.core.util.al.k(this.hum, d.f.icon_frs_game);
            } else {
                this.hul.setVisibility(8);
                this.hun.setVisibility(8);
                this.hun.setVisibility(8);
            }
            this.hub.setTag(adVar);
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
        this.hud.setOnClickListener(onClickListener);
        this.hui.setOnClickListener(onClickListener);
        this.hul.setOnClickListener(onClickListener);
    }
}
