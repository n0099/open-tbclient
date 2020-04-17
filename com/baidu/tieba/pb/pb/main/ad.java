package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ad extends y.a {
    View.OnClickListener aOK;
    private TbPageContext duG;
    private a jyA;
    public LinearLayout jyi;
    public View jyj;
    public RelativeLayout jyk;
    public TbImageView jyl;
    public TextView jym;
    public TextView jyn;
    public TextView jyo;
    public LinearLayout jyp;
    public ImageView jyq;
    public TextView jyr;
    public LinearLayout jys;
    public ImageView jyt;
    public TextView jyu;
    public View jyv;
    private com.baidu.tbadk.core.data.as jyw;
    private com.baidu.tbadk.core.data.as jyx;
    private com.baidu.tbadk.core.data.as jyy;
    private ab jyz;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void b(ab abVar);
    }

    public ad(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aOK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ad.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ad.this.duG.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ad.this.jyA != null) {
                        ad.this.jyA.b(ad.this.jyz);
                    }
                    if (view2 == ad.this.jyk) {
                        if (ad.this.jyw != null && !TextUtils.isEmpty(ad.this.jyw.dpm)) {
                            ba.aOY().b((TbPageContext) com.baidu.adp.base.i.T(ad.this.duG.getPageActivity()), new String[]{ad.this.jyw.dpm});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").cI("obj_source", ad.this.jyw.dpm));
                        }
                    } else if (view2 == ad.this.jyp) {
                        BdLog.e("link: " + ad.this.jyx.dpm);
                        if (ad.this.jyx != null && !TextUtils.isEmpty(ad.this.jyx.dpm)) {
                            ba.aOY().b((TbPageContext) com.baidu.adp.base.i.T(ad.this.duG.getPageActivity()), new String[]{ad.this.jyx.dpm});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").cI("obj_source", ad.this.jyx.dpm));
                        }
                    } else if (view2 == ad.this.jys && ad.this.jyy != null && !TextUtils.isEmpty(ad.this.jyy.dpm)) {
                        ba.aOY().b((TbPageContext) com.baidu.adp.base.i.T(ad.this.duG.getPageActivity()), new String[]{ad.this.jyy.dpm});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").cI("obj_source", ad.this.jyy.dpm));
                    }
                }
            }
        };
        this.duG = tbPageContext;
        this.jyA = aVar;
        this.jyi = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.jyj = view.findViewById(R.id.pb_list_item_top_line);
        this.jyk = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.jyl = (TbImageView) view.findViewById(R.id.top_code_img);
        this.jym = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.jyn = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.jyo = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.jyp = (LinearLayout) view.findViewById(R.id.news_info);
        this.jyq = (ImageView) view.findViewById(R.id.news_info_img);
        this.jyr = (TextView) view.findViewById(R.id.news_info_text);
        this.jys = (LinearLayout) view.findViewById(R.id.game_info);
        this.jyt = (ImageView) view.findViewById(R.id.game_info_img);
        this.jyu = (TextView) view.findViewById(R.id.game_info_text);
        this.jyv = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aOK);
    }

    public void a(ab abVar) {
        if (abVar != null) {
            this.jyz = abVar;
            this.jyw = abVar.jyf;
            this.jyx = abVar.jyg;
            this.jyy = abVar.jyh;
            if (this.jyw != null) {
                this.jyl.startLoad(this.jyw.dpn, 10, false);
                this.jyn.setText(this.jyw.summary);
                this.jyo.setText(this.jyw.subtitle);
                this.jym.setText(this.jyw.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jym, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jym, (int) R.drawable.news_text_color_selector);
            } else {
                this.jyk.setVisibility(8);
            }
            if (this.jyx != null) {
                this.jyr.setText(this.jyx.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jyq, R.drawable.icon_frs_news);
            } else {
                this.jyp.setVisibility(8);
                this.jyr.setVisibility(8);
                this.jyq.setVisibility(8);
            }
            if (this.jyy != null) {
                this.jyu.setText(this.jyy.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jyt, R.drawable.icon_frs_game);
            } else {
                this.jys.setVisibility(8);
                this.jyu.setVisibility(8);
                this.jyu.setVisibility(8);
            }
            this.jyi.setTag(abVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.duG.getLayoutMode().setNightMode(i == 1);
            this.duG.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jyk.setOnClickListener(onClickListener);
        this.jyp.setOnClickListener(onClickListener);
        this.jys.setOnClickListener(onClickListener);
    }
}
