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
/* loaded from: classes6.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView bXt;
    private TextView eji;
    private HeadImageView glX;
    private ImageView hIx;
    private TextView hIy;
    private int hIz;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.hIz = R.color.cp_cont_c;
        this.glX = (HeadImageView) view.findViewById(R.id.photo);
        this.glX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.glX.setAutoChangeStyle(true);
        this.glX.setPlaceHolder(1);
        this.bXt = (TextView) view.findViewById(R.id.user_name);
        this.hIx = (ImageView) view.findViewById(R.id.fans_reply);
        this.eji = (TextView) view.findViewById(R.id.time);
        this.hIy = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.glX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aOf().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aOf().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ag(FeedData feedData) {
        super.ag(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.bXt.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.hIz = R.color.cp_cont_r;
            } else {
                this.hIz = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.bXt, this.hIz);
            this.glX.setIsRound(true);
            this.glX.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.glX, replyer, 0);
            this.glX.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.glX.startLoad(avater, 12, false);
            } else {
                this.glX.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.hIx.setVisibility(0);
            } else {
                this.hIx.setVisibility(8);
            }
        }
        this.eji.setText(aq.getFormatTime(feedData.getTime()));
        this.hIy.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eji, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.hIx, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.hIy, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bXt, this.hIz);
        this.glX.invalidate();
        this.eji.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
