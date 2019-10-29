package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView csn;
    private TextView dyX;
    private HeadImageView fyr;
    private ImageView gVm;
    private TextView gVn;
    private int gVo;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gVo = R.color.cp_cont_c;
        this.fyr = (HeadImageView) view.findViewById(R.id.photo);
        this.fyr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fyr.setAutoChangeStyle(true);
        this.csn = (TextView) view.findViewById(R.id.user_name);
        this.gVm = (ImageView) view.findViewById(R.id.fans_reply);
        this.dyX = (TextView) view.findViewById(R.id.time);
        this.gVn = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.fyr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.awx().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.awx().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ab(FeedData feedData) {
        super.ab(feedData);
        if (feedData.getReplyer() != null) {
            this.csn.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                this.gVo = R.color.cp_cont_r;
            } else {
                this.gVo = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.csn, this.gVo);
            this.fyr.setShowV(feedData.getReplyer().isBigV());
            this.fyr.setIsRound(true);
            this.fyr.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.fyr.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.fyr.startLoad(portrait, 12, false);
            } else {
                this.fyr.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.gVm.setVisibility(0);
            } else {
                this.gVm.setVisibility(8);
            }
        }
        this.dyX.setText(aq.getFormatTime(feedData.getTime()));
        this.gVn.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.it(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.dyX, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.gVm, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.gVn, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.csn, this.gVo);
        this.fyr.invalidate();
        this.dyX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
