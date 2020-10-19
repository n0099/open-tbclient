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
    View.OnClickListener aEX;
    private TbPageContext etO;
    public LinearLayout lgX;
    public View lgY;
    public RelativeLayout lgZ;
    public TbImageView lha;
    public TextView lhb;
    public TextView lhc;
    public TextView lhd;
    public LinearLayout lhe;
    public ImageView lhf;
    public TextView lhg;
    public LinearLayout lhh;
    public ImageView lhi;
    public TextView lhj;
    public View lhk;
    private com.baidu.tbadk.core.data.ay lhl;
    private com.baidu.tbadk.core.data.ay lhm;
    private com.baidu.tbadk.core.data.ay lhn;
    private am lho;
    private a lhp;
    private int mSkinType;

    /* loaded from: classes22.dex */
    public interface a {
        void b(am amVar);
    }

    public ao(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ao.this.etO.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ao.this.lhp != null) {
                        ao.this.lhp.b(ao.this.lho);
                    }
                    if (view2 == ao.this.lgZ) {
                        if (ao.this.lhl != null && !TextUtils.isEmpty(ao.this.lhl.enH)) {
                            com.baidu.tbadk.core.util.be.bmY().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.etO.getPageActivity()), new String[]{ao.this.lhl.enH});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11410").dK("obj_source", ao.this.lhl.enH));
                        }
                    } else if (view2 == ao.this.lhe) {
                        BdLog.e("link: " + ao.this.lhm.enH);
                        if (ao.this.lhm != null && !TextUtils.isEmpty(ao.this.lhm.enH)) {
                            com.baidu.tbadk.core.util.be.bmY().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.etO.getPageActivity()), new String[]{ao.this.lhm.enH});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11409").dK("obj_source", ao.this.lhm.enH));
                        }
                    } else if (view2 == ao.this.lhh && ao.this.lhn != null && !TextUtils.isEmpty(ao.this.lhn.enH)) {
                        com.baidu.tbadk.core.util.be.bmY().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.etO.getPageActivity()), new String[]{ao.this.lhn.enH});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11408").dK("obj_source", ao.this.lhn.enH));
                    }
                }
            }
        };
        this.etO = tbPageContext;
        this.lhp = aVar;
        this.lgX = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lgY = view.findViewById(R.id.pb_list_item_top_line);
        this.lgZ = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lha = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lhb = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lhc = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lhd = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lhe = (LinearLayout) view.findViewById(R.id.news_info);
        this.lhf = (ImageView) view.findViewById(R.id.news_info_img);
        this.lhg = (TextView) view.findViewById(R.id.news_info_text);
        this.lhh = (LinearLayout) view.findViewById(R.id.game_info);
        this.lhi = (ImageView) view.findViewById(R.id.game_info_img);
        this.lhj = (TextView) view.findViewById(R.id.game_info_text);
        this.lhk = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aEX);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.lho = amVar;
            this.lhl = amVar.lgU;
            this.lhm = amVar.lgV;
            this.lhn = amVar.lgW;
            if (this.lhl != null) {
                this.lha.startLoad(this.lhl.enI, 10, false);
                this.lhc.setText(this.lhl.summary);
                this.lhd.setText(this.lhl.subtitle);
                this.lhb.setText(this.lhl.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lhb, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lhb, R.drawable.news_text_color_selector);
            } else {
                this.lgZ.setVisibility(8);
            }
            if (this.lhm != null) {
                this.lhg.setText(this.lhm.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lhf, R.drawable.icon_frs_news);
            } else {
                this.lhe.setVisibility(8);
                this.lhg.setVisibility(8);
                this.lhf.setVisibility(8);
            }
            if (this.lhn != null) {
                this.lhj.setText(this.lhn.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lhi, R.drawable.icon_frs_game);
            } else {
                this.lhh.setVisibility(8);
                this.lhj.setVisibility(8);
                this.lhj.setVisibility(8);
            }
            this.lgX.setTag(amVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.etO.getLayoutMode().setNightMode(i == 1);
            this.etO.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lgZ.setOnClickListener(onClickListener);
        this.lhe.setOnClickListener(onClickListener);
        this.lhh.setOnClickListener(onClickListener);
    }
}
