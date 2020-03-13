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
    private TextView cbL;
    private TextView eov;
    private HeadImageView grw;
    private ImageView hOm;
    private TextView hOn;
    private int hOo;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.hOo = R.color.cp_cont_c;
        this.grw = (HeadImageView) view.findViewById(R.id.photo);
        this.grw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grw.setAutoChangeStyle(true);
        this.grw.setPlaceHolder(1);
        this.cbL = (TextView) view.findViewById(R.id.user_name);
        this.hOm = (ImageView) view.findViewById(R.id.fans_reply);
        this.eov = (TextView) view.findViewById(R.id.time);
        this.hOn = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.grw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aQQ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aQQ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
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
            this.cbL.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.hOo = R.color.cp_cont_r;
            } else {
                this.hOo = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.cbL, this.hOo);
            this.grw.setIsRound(true);
            this.grw.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.grw, replyer, 0);
            this.grw.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.grw.startLoad(avater, 12, false);
            } else {
                this.grw.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.hOm.setVisibility(0);
            } else {
                this.hOm.setVisibility(8);
            }
        }
        this.eov.setText(aq.getFormatTime(feedData.getTime()));
        this.hOn.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eov, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.hOm, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.hOn, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cbL, this.hOo);
        this.grw.invalidate();
        this.eov.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
