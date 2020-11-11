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
/* loaded from: classes22.dex */
public class ao extends af.a {
    View.OnClickListener aFV;
    private TbPageContext eIc;
    public TbImageView lzA;
    public TextView lzB;
    public TextView lzC;
    public TextView lzD;
    public LinearLayout lzE;
    public ImageView lzF;
    public TextView lzG;
    public LinearLayout lzH;
    public ImageView lzI;
    public TextView lzJ;
    public View lzK;
    private com.baidu.tbadk.core.data.ay lzL;
    private com.baidu.tbadk.core.data.ay lzM;
    private com.baidu.tbadk.core.data.ay lzN;
    private am lzO;
    private a lzP;
    public LinearLayout lzx;
    public View lzy;
    public RelativeLayout lzz;
    private int mSkinType;

    /* loaded from: classes22.dex */
    public interface a {
        void b(am amVar);
    }

    public ao(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ao.this.eIc.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ao.this.lzP != null) {
                        ao.this.lzP.b(ao.this.lzO);
                    }
                    if (view2 == ao.this.lzz) {
                        if (ao.this.lzL != null && !TextUtils.isEmpty(ao.this.lzL.eBY)) {
                            com.baidu.tbadk.core.util.be.brr().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.eIc.getPageActivity()), new String[]{ao.this.lzL.eBY});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11410").dR("obj_source", ao.this.lzL.eBY));
                        }
                    } else if (view2 == ao.this.lzE) {
                        BdLog.e("link: " + ao.this.lzM.eBY);
                        if (ao.this.lzM != null && !TextUtils.isEmpty(ao.this.lzM.eBY)) {
                            com.baidu.tbadk.core.util.be.brr().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.eIc.getPageActivity()), new String[]{ao.this.lzM.eBY});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11409").dR("obj_source", ao.this.lzM.eBY));
                        }
                    } else if (view2 == ao.this.lzH && ao.this.lzN != null && !TextUtils.isEmpty(ao.this.lzN.eBY)) {
                        com.baidu.tbadk.core.util.be.brr().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.eIc.getPageActivity()), new String[]{ao.this.lzN.eBY});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11408").dR("obj_source", ao.this.lzN.eBY));
                    }
                }
            }
        };
        this.eIc = tbPageContext;
        this.lzP = aVar;
        this.lzx = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lzy = view.findViewById(R.id.pb_list_item_top_line);
        this.lzz = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lzA = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lzB = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lzC = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lzD = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lzE = (LinearLayout) view.findViewById(R.id.news_info);
        this.lzF = (ImageView) view.findViewById(R.id.news_info_img);
        this.lzG = (TextView) view.findViewById(R.id.news_info_text);
        this.lzH = (LinearLayout) view.findViewById(R.id.game_info);
        this.lzI = (ImageView) view.findViewById(R.id.game_info_img);
        this.lzJ = (TextView) view.findViewById(R.id.game_info_text);
        this.lzK = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aFV);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.lzO = amVar;
            this.lzL = amVar.lzu;
            this.lzM = amVar.lzv;
            this.lzN = amVar.lzw;
            if (this.lzL != null) {
                this.lzA.startLoad(this.lzL.eBZ, 10, false);
                this.lzC.setText(this.lzL.summary);
                this.lzD.setText(this.lzL.subtitle);
                this.lzB.setText(this.lzL.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lzB, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzB, R.drawable.news_text_color_selector);
            } else {
                this.lzz.setVisibility(8);
            }
            if (this.lzM != null) {
                this.lzG.setText(this.lzM.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lzF, R.drawable.icon_frs_news);
            } else {
                this.lzE.setVisibility(8);
                this.lzG.setVisibility(8);
                this.lzF.setVisibility(8);
            }
            if (this.lzN != null) {
                this.lzJ.setText(this.lzN.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lzI, R.drawable.icon_frs_game);
            } else {
                this.lzH.setVisibility(8);
                this.lzJ.setVisibility(8);
                this.lzJ.setVisibility(8);
            }
            this.lzx.setTag(amVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eIc.getLayoutMode().setNightMode(i == 1);
            this.eIc.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lzz.setOnClickListener(onClickListener);
        this.lzE.setOnClickListener(onClickListener);
        this.lzH.setOnClickListener(onClickListener);
    }
}
