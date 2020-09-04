package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ao extends af.a {
    View.OnClickListener aBm;
    private TbPageContext efr;
    private com.baidu.tbadk.core.data.ay kJA;
    private am kJB;
    private a kJC;
    public LinearLayout kJk;
    public View kJl;
    public RelativeLayout kJm;
    public TbImageView kJn;
    public TextView kJo;
    public TextView kJp;
    public TextView kJq;
    public LinearLayout kJr;
    public ImageView kJs;
    public TextView kJt;
    public LinearLayout kJu;
    public ImageView kJv;
    public TextView kJw;
    public View kJx;
    private com.baidu.tbadk.core.data.ay kJy;
    private com.baidu.tbadk.core.data.ay kJz;
    private int mSkinType;

    /* loaded from: classes16.dex */
    public interface a {
        void b(am amVar);
    }

    public ao(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ao.this.efr.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ao.this.kJC != null) {
                        ao.this.kJC.b(ao.this.kJB);
                    }
                    if (view2 == ao.this.kJm) {
                        if (ao.this.kJy != null && !TextUtils.isEmpty(ao.this.kJy.dZt)) {
                            com.baidu.tbadk.core.util.be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.efr.getPageActivity()), new String[]{ao.this.kJy.dZt});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11410").dD("obj_source", ao.this.kJy.dZt));
                        }
                    } else if (view2 == ao.this.kJr) {
                        BdLog.e("link: " + ao.this.kJz.dZt);
                        if (ao.this.kJz != null && !TextUtils.isEmpty(ao.this.kJz.dZt)) {
                            com.baidu.tbadk.core.util.be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.efr.getPageActivity()), new String[]{ao.this.kJz.dZt});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11409").dD("obj_source", ao.this.kJz.dZt));
                        }
                    } else if (view2 == ao.this.kJu && ao.this.kJA != null && !TextUtils.isEmpty(ao.this.kJA.dZt)) {
                        com.baidu.tbadk.core.util.be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.efr.getPageActivity()), new String[]{ao.this.kJA.dZt});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11408").dD("obj_source", ao.this.kJA.dZt));
                    }
                }
            }
        };
        this.efr = tbPageContext;
        this.kJC = aVar;
        this.kJk = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.kJl = view.findViewById(R.id.pb_list_item_top_line);
        this.kJm = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.kJn = (TbImageView) view.findViewById(R.id.top_code_img);
        this.kJo = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.kJp = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.kJq = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.kJr = (LinearLayout) view.findViewById(R.id.news_info);
        this.kJs = (ImageView) view.findViewById(R.id.news_info_img);
        this.kJt = (TextView) view.findViewById(R.id.news_info_text);
        this.kJu = (LinearLayout) view.findViewById(R.id.game_info);
        this.kJv = (ImageView) view.findViewById(R.id.game_info_img);
        this.kJw = (TextView) view.findViewById(R.id.game_info_text);
        this.kJx = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aBm);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.kJB = amVar;
            this.kJy = amVar.kJh;
            this.kJz = amVar.kJi;
            this.kJA = amVar.kJj;
            if (this.kJy != null) {
                this.kJn.startLoad(this.kJy.dZu, 10, false);
                this.kJp.setText(this.kJy.summary);
                this.kJq.setText(this.kJy.subtitle);
                this.kJo.setText(this.kJy.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kJo, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJo, R.drawable.news_text_color_selector);
            } else {
                this.kJm.setVisibility(8);
            }
            if (this.kJz != null) {
                this.kJt.setText(this.kJz.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kJs, R.drawable.icon_frs_news);
            } else {
                this.kJr.setVisibility(8);
                this.kJt.setVisibility(8);
                this.kJs.setVisibility(8);
            }
            if (this.kJA != null) {
                this.kJw.setText(this.kJA.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kJv, R.drawable.icon_frs_game);
            } else {
                this.kJu.setVisibility(8);
                this.kJw.setVisibility(8);
                this.kJw.setVisibility(8);
            }
            this.kJk.setTag(amVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.efr.getLayoutMode().setNightMode(i == 1);
            this.efr.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kJm.setOnClickListener(onClickListener);
        this.kJr.setOnClickListener(onClickListener);
        this.kJu.setOnClickListener(onClickListener);
    }
}
