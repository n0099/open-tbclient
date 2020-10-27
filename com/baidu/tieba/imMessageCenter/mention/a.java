package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView eqE;
    private TextView ggF;
    private HeadImageView iEX;
    private ImageView knG;
    private TextView knH;
    private int knI;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.knI = R.color.cp_cont_c;
        this.iEX = (HeadImageView) view.findViewById(R.id.photo);
        this.iEX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iEX.setAutoChangeStyle(true);
        this.iEX.setPlaceHolder(1);
        this.eqE = (TextView) view.findViewById(R.id.user_name);
        this.knG = (ImageView) view.findViewById(R.id.fans_reply);
        this.ggF = (TextView) view.findViewById(R.id.time);
        this.knH = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.iEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bzy().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.bzy().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                aq aqVar = new aq("c13784");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dR("fname", data.getFname());
                aqVar.dR("tid", data.getThread_id());
                aqVar.aj("obj_type", 1);
                TiebaStatic.log(aqVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.bzy().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(FeedData feedData) {
        super.au(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.eqE.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.knI = R.color.cp_cont_r;
            } else {
                this.knI = R.color.cp_cont_c;
            }
            ap.setViewTextColor(this.eqE, this.knI);
            this.iEX.setIsRound(true);
            this.iEX.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.iEX, replyer, 0);
            this.iEX.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.iEX.startLoad(avater, 12, false);
            } else {
                this.iEX.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.knG.setVisibility(0);
            } else {
                this.knG.setVisibility(8);
            }
        }
        this.ggF.setText(at.getFormatTime(feedData.getTime()));
        this.knH.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ap.oN(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.ggF, R.color.cp_cont_d);
        ap.setBackgroundResource(this.knG, R.drawable.icon_pb_fans);
        ap.setViewTextColor(this.knH, R.color.cp_cont_b);
        ap.setViewTextColor(this.eqE, this.knI);
        this.iEX.invalidate();
        this.ggF.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
