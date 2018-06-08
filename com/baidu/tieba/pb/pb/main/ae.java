package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ae extends q.a {
    View.OnClickListener bWZ;
    public LinearLayout fyM;
    public View fyN;
    public RelativeLayout fyO;
    public TbImageView fyP;
    public TextView fyQ;
    public TextView fyR;
    public TextView fyS;
    public LinearLayout fyT;
    public ImageView fyU;
    public TextView fyV;
    public LinearLayout fyW;
    public ImageView fyX;
    public TextView fyY;
    public View fyZ;
    private com.baidu.tbadk.core.data.ao fza;
    private com.baidu.tbadk.core.data.ao fzb;
    private com.baidu.tbadk.core.data.ao fzc;
    private TbPageContext mContext;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bWZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.aU(ae.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.jU()) {
                    if (view2 == ae.this.fyO) {
                        if (ae.this.fza != null && !TextUtils.isEmpty(ae.this.fza.agT)) {
                            ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(ae.this.mContext.getPageActivity()), new String[]{ae.this.fza.agT});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fza.agT));
                        }
                    } else if (view2 == ae.this.fyT) {
                        BdLog.e("link: " + ae.this.fzb.agT);
                        if (ae.this.fzb != null && !TextUtils.isEmpty(ae.this.fzb.agT)) {
                            ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(ae.this.mContext.getPageActivity()), new String[]{ae.this.fzb.agT});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fzb.agT));
                        }
                    } else if (view2 == ae.this.fyW && ae.this.fzc != null && !TextUtils.isEmpty(ae.this.fzc.agT)) {
                        ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(ae.this.mContext.getPageActivity()), new String[]{ae.this.fzc.agT});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fzc.agT));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fyM = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.fyN = view.findViewById(d.g.pb_list_item_top_line);
        this.fyO = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fyP = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fyQ = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fyR = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fyS = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.fyT = (LinearLayout) view.findViewById(d.g.news_info);
        this.fyU = (ImageView) view.findViewById(d.g.news_info_img);
        this.fyV = (TextView) view.findViewById(d.g.news_info_text);
        this.fyW = (LinearLayout) view.findViewById(d.g.game_info);
        this.fyX = (ImageView) view.findViewById(d.g.game_info_img);
        this.fyY = (TextView) view.findViewById(d.g.game_info_text);
        this.fyZ = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.bWZ);
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.fza = acVar.fyH;
            this.fzb = acVar.fyI;
            this.fzc = acVar.fyJ;
            if (this.fza != null) {
                this.fyP.startLoad(this.fza.agV, 10, false);
                this.fyR.setText(this.fza.summary);
                this.fyS.setText(this.fza.subtitle);
                this.fyQ.setText(this.fza.buttonText);
                com.baidu.tbadk.core.util.al.i(this.fyQ, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.h(this.fyQ, d.f.news_text_color_selector);
            } else {
                this.fyO.setVisibility(8);
            }
            if (this.fzb != null) {
                this.fyV.setText(this.fzb.summary);
                com.baidu.tbadk.core.util.al.i(this.fyU, d.f.icon_frs_news);
            } else {
                this.fyT.setVisibility(8);
                this.fyV.setVisibility(8);
                this.fyU.setVisibility(8);
            }
            if (this.fzc != null) {
                this.fyY.setText(this.fzc.summary);
                com.baidu.tbadk.core.util.al.i(this.fyX, d.f.icon_frs_game);
            } else {
                this.fyW.setVisibility(8);
                this.fyY.setVisibility(8);
                this.fyY.setVisibility(8);
            }
            this.fyM.setTag(acVar);
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
        this.fyO.setOnClickListener(onClickListener);
        this.fyT.setOnClickListener(onClickListener);
        this.fyW.setOnClickListener(onClickListener);
    }
}
