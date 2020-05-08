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
    View.OnClickListener aOQ;
    private TbPageContext duK;
    private com.baidu.tbadk.core.data.as jyA;
    private com.baidu.tbadk.core.data.as jyB;
    private com.baidu.tbadk.core.data.as jyC;
    private ab jyD;
    private a jyE;
    public LinearLayout jym;
    public View jyn;
    public RelativeLayout jyo;
    public TbImageView jyp;
    public TextView jyq;
    public TextView jyr;
    public TextView jys;
    public LinearLayout jyt;
    public ImageView jyu;
    public TextView jyv;
    public LinearLayout jyw;
    public ImageView jyx;
    public TextView jyy;
    public View jyz;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void b(ab abVar);
    }

    public ad(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aOQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ad.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ad.this.duK.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ad.this.jyE != null) {
                        ad.this.jyE.b(ad.this.jyD);
                    }
                    if (view2 == ad.this.jyo) {
                        if (ad.this.jyA != null && !TextUtils.isEmpty(ad.this.jyA.dpq)) {
                            ba.aOV().b((TbPageContext) com.baidu.adp.base.i.G(ad.this.duK.getPageActivity()), new String[]{ad.this.jyA.dpq});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").cI("obj_source", ad.this.jyA.dpq));
                        }
                    } else if (view2 == ad.this.jyt) {
                        BdLog.e("link: " + ad.this.jyB.dpq);
                        if (ad.this.jyB != null && !TextUtils.isEmpty(ad.this.jyB.dpq)) {
                            ba.aOV().b((TbPageContext) com.baidu.adp.base.i.G(ad.this.duK.getPageActivity()), new String[]{ad.this.jyB.dpq});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").cI("obj_source", ad.this.jyB.dpq));
                        }
                    } else if (view2 == ad.this.jyw && ad.this.jyC != null && !TextUtils.isEmpty(ad.this.jyC.dpq)) {
                        ba.aOV().b((TbPageContext) com.baidu.adp.base.i.G(ad.this.duK.getPageActivity()), new String[]{ad.this.jyC.dpq});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").cI("obj_source", ad.this.jyC.dpq));
                    }
                }
            }
        };
        this.duK = tbPageContext;
        this.jyE = aVar;
        this.jym = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.jyn = view.findViewById(R.id.pb_list_item_top_line);
        this.jyo = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.jyp = (TbImageView) view.findViewById(R.id.top_code_img);
        this.jyq = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.jyr = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.jys = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.jyt = (LinearLayout) view.findViewById(R.id.news_info);
        this.jyu = (ImageView) view.findViewById(R.id.news_info_img);
        this.jyv = (TextView) view.findViewById(R.id.news_info_text);
        this.jyw = (LinearLayout) view.findViewById(R.id.game_info);
        this.jyx = (ImageView) view.findViewById(R.id.game_info_img);
        this.jyy = (TextView) view.findViewById(R.id.game_info_text);
        this.jyz = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aOQ);
    }

    public void a(ab abVar) {
        if (abVar != null) {
            this.jyD = abVar;
            this.jyA = abVar.jyj;
            this.jyB = abVar.jyk;
            this.jyC = abVar.jyl;
            if (this.jyA != null) {
                this.jyp.startLoad(this.jyA.dpr, 10, false);
                this.jyr.setText(this.jyA.summary);
                this.jys.setText(this.jyA.subtitle);
                this.jyq.setText(this.jyA.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jyq, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jyq, (int) R.drawable.news_text_color_selector);
            } else {
                this.jyo.setVisibility(8);
            }
            if (this.jyB != null) {
                this.jyv.setText(this.jyB.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jyu, R.drawable.icon_frs_news);
            } else {
                this.jyt.setVisibility(8);
                this.jyv.setVisibility(8);
                this.jyu.setVisibility(8);
            }
            if (this.jyC != null) {
                this.jyy.setText(this.jyC.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jyx, R.drawable.icon_frs_game);
            } else {
                this.jyw.setVisibility(8);
                this.jyy.setVisibility(8);
                this.jyy.setVisibility(8);
            }
            this.jym.setTag(abVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.duK.getLayoutMode().setNightMode(i == 1);
            this.duK.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jyo.setOnClickListener(onClickListener);
        this.jyt.setOnClickListener(onClickListener);
        this.jyw.setOnClickListener(onClickListener);
    }
}
