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
    private TextView ffh;
    private HeadImageView hqx;
    private ImageView iPd;
    private TextView iPe;
    private int iPf;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.iPf = R.color.cp_cont_c;
        this.hqx = (HeadImageView) view.findViewById(R.id.photo);
        this.hqx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hqx.setAutoChangeStyle(true);
        this.hqx.setPlaceHolder(1);
        this.dXU = (TextView) view.findViewById(R.id.user_name);
        this.iPd = (ImageView) view.findViewById(R.id.fans_reply);
        this.ffh = (TextView) view.findViewById(R.id.time);
        this.iPe = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.hqx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bfn().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bfn().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
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
                this.iPf = R.color.cp_cont_r;
            } else {
                this.iPf = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.dXU, this.iPf);
            this.hqx.setIsRound(true);
            this.hqx.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.hqx, replyer, 0);
            this.hqx.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.hqx.startLoad(avater, 12, false);
            } else {
                this.hqx.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.iPd.setVisibility(0);
            } else {
                this.iPd.setVisibility(8);
            }
        }
        this.ffh.setText(aq.getFormatTime(feedData.getTime()));
        this.iPe.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.le(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.ffh, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.iPd, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.iPe, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dXU, this.iPf);
        this.hqx.invalidate();
        this.ffh.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
