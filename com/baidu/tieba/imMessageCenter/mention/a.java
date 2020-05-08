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
    private TextView cBd;
    private TextView eSo;
    private HeadImageView hby;
    private ImageView izJ;
    private TextView izK;
    private int izL;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.izL = R.color.cp_cont_c;
        this.hby = (HeadImageView) view.findViewById(R.id.photo);
        this.hby.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hby.setAutoChangeStyle(true);
        this.hby.setPlaceHolder(1);
        this.cBd = (TextView) view.findViewById(R.id.user_name);
        this.izJ = (ImageView) view.findViewById(R.id.fans_reply);
        this.eSo = (TextView) view.findViewById(R.id.time);
        this.izK = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.hby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aZc().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aZc().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aj(FeedData feedData) {
        super.aj(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.cBd.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.izL = R.color.cp_cont_r;
            } else {
                this.izL = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.cBd, this.izL);
            this.hby.setIsRound(true);
            this.hby.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.hby, replyer, 0);
            this.hby.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.hby.startLoad(avater, 12, false);
            } else {
                this.hby.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.izJ.setVisibility(0);
            } else {
                this.izJ.setVisibility(8);
            }
        }
        this.eSo.setText(aq.getFormatTime(feedData.getTime()));
        this.izK.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.kC(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eSo, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.izJ, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.izK, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cBd, this.izL);
        this.hby.invalidate();
        this.eSo.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
