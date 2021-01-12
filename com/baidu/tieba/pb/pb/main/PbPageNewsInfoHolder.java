package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {
    View.OnClickListener aCu;
    private TbPageContext eSJ;
    private ba lOA;
    private ba lOB;
    private ba lOC;
    private af lOD;
    private a lOE;
    public LinearLayout lOm;
    public View lOn;
    public RelativeLayout lOo;
    public TbImageView lOp;
    public TextView lOq;
    public TextView lOr;
    public TextView lOs;
    public LinearLayout lOt;
    public ImageView lOu;
    public TextView lOv;
    public LinearLayout lOw;
    public ImageView lOx;
    public TextView lOy;
    public View lOz;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void b(af afVar);
    }

    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(PbPageNewsInfoHolder.this.eSJ.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (PbPageNewsInfoHolder.this.lOE != null) {
                        PbPageNewsInfoHolder.this.lOE.b(PbPageNewsInfoHolder.this.lOD);
                    }
                    if (view2 == PbPageNewsInfoHolder.this.lOo) {
                        if (PbPageNewsInfoHolder.this.lOA != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lOA.eMu)) {
                            be.bsB().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eSJ.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lOA.eMu});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11410").dW("obj_source", PbPageNewsInfoHolder.this.lOA.eMu));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lOt) {
                        BdLog.e("link: " + PbPageNewsInfoHolder.this.lOB.eMu);
                        if (PbPageNewsInfoHolder.this.lOB != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lOB.eMu)) {
                            be.bsB().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eSJ.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lOB.eMu});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11409").dW("obj_source", PbPageNewsInfoHolder.this.lOB.eMu));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lOw && PbPageNewsInfoHolder.this.lOC != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lOC.eMu)) {
                        be.bsB().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eSJ.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lOC.eMu});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11408").dW("obj_source", PbPageNewsInfoHolder.this.lOC.eMu));
                    }
                }
            }
        };
        this.eSJ = tbPageContext;
        this.lOE = aVar;
        this.lOm = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lOn = view.findViewById(R.id.pb_list_item_top_line);
        this.lOo = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lOp = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lOq = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lOr = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lOs = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lOt = (LinearLayout) view.findViewById(R.id.news_info);
        this.lOu = (ImageView) view.findViewById(R.id.news_info_img);
        this.lOv = (TextView) view.findViewById(R.id.news_info_text);
        this.lOw = (LinearLayout) view.findViewById(R.id.game_info);
        this.lOx = (ImageView) view.findViewById(R.id.game_info_img);
        this.lOy = (TextView) view.findViewById(R.id.game_info_text);
        this.lOz = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aCu);
    }

    public void a(af afVar) {
        if (afVar != null) {
            this.lOD = afVar;
            this.lOA = afVar.lOj;
            this.lOB = afVar.lOk;
            this.lOC = afVar.lOl;
            if (this.lOA != null) {
                this.lOp.startLoad(this.lOA.eMv, 10, false);
                this.lOr.setText(this.lOA.summary);
                this.lOs.setText(this.lOA.subtitle);
                this.lOq.setText(this.lOA.buttonText);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lOq, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lOq, R.drawable.news_text_color_selector);
            } else {
                this.lOo.setVisibility(8);
            }
            if (this.lOB != null) {
                this.lOv.setText(this.lOB.summary);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lOu, R.drawable.icon_frs_news);
            } else {
                this.lOt.setVisibility(8);
                this.lOv.setVisibility(8);
                this.lOu.setVisibility(8);
            }
            if (this.lOC != null) {
                this.lOy.setText(this.lOC.summary);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lOx, R.drawable.icon_frs_game);
            } else {
                this.lOw.setVisibility(8);
                this.lOy.setVisibility(8);
                this.lOy.setVisibility(8);
            }
            this.lOm.setTag(afVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eSJ.getLayoutMode().setNightMode(i == 1);
            this.eSJ.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lOo.setOnClickListener(onClickListener);
        this.lOt.setOnClickListener(onClickListener);
        this.lOw.setOnClickListener(onClickListener);
    }
}
