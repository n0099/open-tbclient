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
    private TextView cbK;
    private TextView eoi;
    private HeadImageView grj;
    private ImageView hOa;
    private TextView hOb;
    private int hOc;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.hOc = R.color.cp_cont_c;
        this.grj = (HeadImageView) view.findViewById(R.id.photo);
        this.grj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grj.setAutoChangeStyle(true);
        this.grj.setPlaceHolder(1);
        this.cbK = (TextView) view.findViewById(R.id.user_name);
        this.hOa = (ImageView) view.findViewById(R.id.fans_reply);
        this.eoi = (TextView) view.findViewById(R.id.time);
        this.hOb = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.grj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aQP().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aQP().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(FeedData feedData) {
        super.ai(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.cbK.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.hOc = R.color.cp_cont_r;
            } else {
                this.hOc = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.cbK, this.hOc);
            this.grj.setIsRound(true);
            this.grj.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.grj, replyer, 0);
            this.grj.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.grj.startLoad(avater, 12, false);
            } else {
                this.grj.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.hOa.setVisibility(0);
            } else {
                this.hOa.setVisibility(8);
            }
        }
        this.eoi.setText(aq.getFormatTime(feedData.getTime()));
        this.hOb.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eoi, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.hOa, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.hOb, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cbK, this.hOc);
        this.grj.invalidate();
        this.eoi.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
