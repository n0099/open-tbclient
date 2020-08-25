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
    View.OnClickListener aBk;
    private TbPageContext efn;
    public LinearLayout kJd;
    public View kJe;
    public RelativeLayout kJf;
    public TbImageView kJg;
    public TextView kJh;
    public TextView kJi;
    public TextView kJj;
    public LinearLayout kJk;
    public ImageView kJl;
    public TextView kJm;
    public LinearLayout kJn;
    public ImageView kJo;
    public TextView kJp;
    public View kJq;
    private com.baidu.tbadk.core.data.ay kJr;
    private com.baidu.tbadk.core.data.ay kJs;
    private com.baidu.tbadk.core.data.ay kJt;
    private am kJu;
    private a kJv;
    private int mSkinType;

    /* loaded from: classes16.dex */
    public interface a {
        void b(am amVar);
    }

    public ao(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ao.this.efn.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ao.this.kJv != null) {
                        ao.this.kJv.b(ao.this.kJu);
                    }
                    if (view2 == ao.this.kJf) {
                        if (ao.this.kJr != null && !TextUtils.isEmpty(ao.this.kJr.dZp)) {
                            com.baidu.tbadk.core.util.be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.efn.getPageActivity()), new String[]{ao.this.kJr.dZp});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11410").dD("obj_source", ao.this.kJr.dZp));
                        }
                    } else if (view2 == ao.this.kJk) {
                        BdLog.e("link: " + ao.this.kJs.dZp);
                        if (ao.this.kJs != null && !TextUtils.isEmpty(ao.this.kJs.dZp)) {
                            com.baidu.tbadk.core.util.be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.efn.getPageActivity()), new String[]{ao.this.kJs.dZp});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11409").dD("obj_source", ao.this.kJs.dZp));
                        }
                    } else if (view2 == ao.this.kJn && ao.this.kJt != null && !TextUtils.isEmpty(ao.this.kJt.dZp)) {
                        com.baidu.tbadk.core.util.be.bju().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.efn.getPageActivity()), new String[]{ao.this.kJt.dZp});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11408").dD("obj_source", ao.this.kJt.dZp));
                    }
                }
            }
        };
        this.efn = tbPageContext;
        this.kJv = aVar;
        this.kJd = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.kJe = view.findViewById(R.id.pb_list_item_top_line);
        this.kJf = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.kJg = (TbImageView) view.findViewById(R.id.top_code_img);
        this.kJh = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.kJi = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.kJj = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.kJk = (LinearLayout) view.findViewById(R.id.news_info);
        this.kJl = (ImageView) view.findViewById(R.id.news_info_img);
        this.kJm = (TextView) view.findViewById(R.id.news_info_text);
        this.kJn = (LinearLayout) view.findViewById(R.id.game_info);
        this.kJo = (ImageView) view.findViewById(R.id.game_info_img);
        this.kJp = (TextView) view.findViewById(R.id.game_info_text);
        this.kJq = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aBk);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.kJu = amVar;
            this.kJr = amVar.kJa;
            this.kJs = amVar.kJb;
            this.kJt = amVar.kJc;
            if (this.kJr != null) {
                this.kJg.startLoad(this.kJr.dZq, 10, false);
                this.kJi.setText(this.kJr.summary);
                this.kJj.setText(this.kJr.subtitle);
                this.kJh.setText(this.kJr.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kJh, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kJh, R.drawable.news_text_color_selector);
            } else {
                this.kJf.setVisibility(8);
            }
            if (this.kJs != null) {
                this.kJm.setText(this.kJs.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kJl, R.drawable.icon_frs_news);
            } else {
                this.kJk.setVisibility(8);
                this.kJm.setVisibility(8);
                this.kJl.setVisibility(8);
            }
            if (this.kJt != null) {
                this.kJp.setText(this.kJt.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kJo, R.drawable.icon_frs_game);
            } else {
                this.kJn.setVisibility(8);
                this.kJp.setVisibility(8);
                this.kJp.setVisibility(8);
            }
            this.kJd.setTag(amVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.efn.getLayoutMode().setNightMode(i == 1);
            this.efn.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kJf.setOnClickListener(onClickListener);
        this.kJk.setOnClickListener(onClickListener);
        this.kJn.setOnClickListener(onClickListener);
    }
}
