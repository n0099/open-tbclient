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
    private TextView cAX;
    private TextView eSj;
    private HeadImageView hbs;
    private ImageView izD;
    private TextView izE;
    private int izF;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.izF = R.color.cp_cont_c;
        this.hbs = (HeadImageView) view.findViewById(R.id.photo);
        this.hbs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hbs.setAutoChangeStyle(true);
        this.hbs.setPlaceHolder(1);
        this.cAX = (TextView) view.findViewById(R.id.user_name);
        this.izD = (ImageView) view.findViewById(R.id.fans_reply);
        this.eSj = (TextView) view.findViewById(R.id.time);
        this.izE = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.hbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aZe().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aZe().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
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
            this.cAX.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.izF = R.color.cp_cont_r;
            } else {
                this.izF = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.cAX, this.izF);
            this.hbs.setIsRound(true);
            this.hbs.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.hbs, replyer, 0);
            this.hbs.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.hbs.startLoad(avater, 12, false);
            } else {
                this.hbs.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.izD.setVisibility(0);
            } else {
                this.izD.setVisibility(8);
            }
        }
        this.eSj.setText(aq.getFormatTime(feedData.getTime()));
        this.izE.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.kC(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eSj, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.izD, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.izE, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cAX, this.izF);
        this.hbs.invalidate();
        this.eSj.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
