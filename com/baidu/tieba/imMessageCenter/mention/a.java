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
    private TextView crw;
    private TextView dyg;
    private HeadImageView fxA;
    private ImageView gUv;
    private TextView gUw;
    private int gUx;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gUx = R.color.cp_cont_c;
        this.fxA = (HeadImageView) view.findViewById(R.id.photo);
        this.fxA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fxA.setAutoChangeStyle(true);
        this.crw = (TextView) view.findViewById(R.id.user_name);
        this.gUv = (ImageView) view.findViewById(R.id.fans_reply);
        this.dyg = (TextView) view.findViewById(R.id.time);
        this.gUw = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.fxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.awv().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.awv().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ab(FeedData feedData) {
        super.ab(feedData);
        if (feedData.getReplyer() != null) {
            this.crw.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                this.gUx = R.color.cp_cont_r;
            } else {
                this.gUx = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.crw, this.gUx);
            this.fxA.setShowV(feedData.getReplyer().isBigV());
            this.fxA.setIsRound(true);
            this.fxA.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.fxA.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.fxA.startLoad(portrait, 12, false);
            } else {
                this.fxA.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.gUv.setVisibility(0);
            } else {
                this.gUv.setVisibility(8);
            }
        }
        this.dyg.setText(aq.getFormatTime(feedData.getTime()));
        this.gUw.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.is(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.dyg, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.gUv, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.gUw, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.crw, this.gUx);
        this.fxA.invalidate();
        this.dyg.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
