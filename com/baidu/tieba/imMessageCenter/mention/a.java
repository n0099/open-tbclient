package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView dXU;
    private TextView feW;
    private HeadImageView hqm;
    private ImageView iOq;
    private TextView iOr;
    private int iOs;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.iOs = R.color.cp_cont_c;
        this.hqm = (HeadImageView) view.findViewById(R.id.photo);
        this.hqm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hqm.setAutoChangeStyle(true);
        this.hqm.setPlaceHolder(1);
        this.dXU = (TextView) view.findViewById(R.id.user_name);
        this.iOq = (ImageView) view.findViewById(R.id.fans_reply);
        this.feW = (TextView) view.findViewById(R.id.time);
        this.iOr = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.hqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bfm().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bfm().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void an(FeedData feedData) {
        super.an(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.dXU.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.iOs = R.color.cp_cont_r;
            } else {
                this.iOs = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.dXU, this.iOs);
            this.hqm.setIsRound(true);
            this.hqm.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.hqm, replyer, 0);
            this.hqm.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.hqm.startLoad(avater, 12, false);
            } else {
                this.hqm.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.iOq.setVisibility(0);
            } else {
                this.iOq.setVisibility(8);
            }
        }
        this.feW.setText(aq.getFormatTime(feedData.getTime()));
        this.iOr.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.lc(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.feW, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.iOq, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.iOr, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dXU, this.iOs);
        this.hqm.invalidate();
        this.feW.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
