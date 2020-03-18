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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ad extends v.a {
    View.OnClickListener avi;
    private TbPageContext cVv;
    public LinearLayout iNZ;
    public View iOa;
    public RelativeLayout iOb;
    public TbImageView iOc;
    public TextView iOd;
    public TextView iOe;
    public TextView iOf;
    public LinearLayout iOg;
    public ImageView iOh;
    public TextView iOi;
    public LinearLayout iOj;
    public ImageView iOk;
    public TextView iOl;
    public View iOm;
    private com.baidu.tbadk.core.data.as iOn;
    private com.baidu.tbadk.core.data.as iOo;
    private com.baidu.tbadk.core.data.as iOp;
    private ab iOq;
    private a iOr;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void b(ab abVar);
    }

    public ad(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.avi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ad.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ad.this.cVv.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ad.this.iOr != null) {
                        ad.this.iOr.b(ad.this.iOq);
                    }
                    if (view2 == ad.this.iOb) {
                        if (ad.this.iOn != null && !TextUtils.isEmpty(ad.this.iOn.cQg)) {
                            ba.aGK().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVv.getPageActivity()), new String[]{ad.this.iOn.cQg});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").cx("obj_source", ad.this.iOn.cQg));
                        }
                    } else if (view2 == ad.this.iOg) {
                        BdLog.e("link: " + ad.this.iOo.cQg);
                        if (ad.this.iOo != null && !TextUtils.isEmpty(ad.this.iOo.cQg)) {
                            ba.aGK().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVv.getPageActivity()), new String[]{ad.this.iOo.cQg});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").cx("obj_source", ad.this.iOo.cQg));
                        }
                    } else if (view2 == ad.this.iOj && ad.this.iOp != null && !TextUtils.isEmpty(ad.this.iOp.cQg)) {
                        ba.aGK().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVv.getPageActivity()), new String[]{ad.this.iOp.cQg});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").cx("obj_source", ad.this.iOp.cQg));
                    }
                }
            }
        };
        this.cVv = tbPageContext;
        this.iOr = aVar;
        this.iNZ = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.iOa = view.findViewById(R.id.pb_list_item_top_line);
        this.iOb = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.iOc = (TbImageView) view.findViewById(R.id.top_code_img);
        this.iOd = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.iOe = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.iOf = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.iOg = (LinearLayout) view.findViewById(R.id.news_info);
        this.iOh = (ImageView) view.findViewById(R.id.news_info_img);
        this.iOi = (TextView) view.findViewById(R.id.news_info_text);
        this.iOj = (LinearLayout) view.findViewById(R.id.game_info);
        this.iOk = (ImageView) view.findViewById(R.id.game_info_img);
        this.iOl = (TextView) view.findViewById(R.id.game_info_text);
        this.iOm = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.avi);
    }

    public void a(ab abVar) {
        if (abVar != null) {
            this.iOq = abVar;
            this.iOn = abVar.iNW;
            this.iOo = abVar.iNX;
            this.iOp = abVar.iNY;
            if (this.iOn != null) {
                this.iOc.startLoad(this.iOn.cQh, 10, false);
                this.iOe.setText(this.iOn.summary);
                this.iOf.setText(this.iOn.subtitle);
                this.iOd.setText(this.iOn.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOd, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iOd, (int) R.drawable.news_text_color_selector);
            } else {
                this.iOb.setVisibility(8);
            }
            if (this.iOo != null) {
                this.iOi.setText(this.iOo.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOh, R.drawable.icon_frs_news);
            } else {
                this.iOg.setVisibility(8);
                this.iOi.setVisibility(8);
                this.iOh.setVisibility(8);
            }
            if (this.iOp != null) {
                this.iOl.setText(this.iOp.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iOk, R.drawable.icon_frs_game);
            } else {
                this.iOj.setVisibility(8);
                this.iOl.setVisibility(8);
                this.iOl.setVisibility(8);
            }
            this.iNZ.setTag(abVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cVv.getLayoutMode().setNightMode(i == 1);
            this.cVv.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iOb.setOnClickListener(onClickListener);
        this.iOg.setOnClickListener(onClickListener);
        this.iOj.setOnClickListener(onClickListener);
    }
}
