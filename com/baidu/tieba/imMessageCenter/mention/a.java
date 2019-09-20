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
    private TextView cdZ;
    private TextView drN;
    private HeadImageView efW;
    private ImageView gXl;
    private TextView gXm;
    private int gXn;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gXn = R.color.cp_cont_c;
        this.efW = (HeadImageView) view.findViewById(R.id.photo);
        this.efW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.efW.setAutoChangeStyle(true);
        this.cdZ = (TextView) view.findViewById(R.id.user_name);
        this.gXl = (ImageView) view.findViewById(R.id.fans_reply);
        this.drN = (TextView) view.findViewById(R.id.time);
        this.gXm = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.efW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.avg().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.avg().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(FeedData feedData) {
        super.af(feedData);
        if (feedData.getReplyer() != null) {
            this.cdZ.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                this.gXn = R.color.cp_cont_r;
            } else {
                this.gXn = R.color.cp_cont_c;
            }
            am.j(this.cdZ, this.gXn);
            this.efW.setShowV(feedData.getReplyer().isBigV());
            this.efW.setIsRound(true);
            this.efW.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.efW.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.efW.startLoad(portrait, 12, false);
            } else {
                this.efW.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.gXl.setVisibility(0);
            } else {
                this.gXl.setVisibility(8);
            }
        }
        this.drN.setText(aq.aD(feedData.getTime()));
        this.gXm.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.io(R.color.cp_bg_line_e));
        am.l(this.mLine, R.color.cp_bg_line_c);
        am.j(this.drN, R.color.cp_cont_d);
        am.k(this.gXl, R.drawable.icon_pb_fans);
        am.j(this.gXm, R.color.cp_cont_b);
        am.j(this.cdZ, this.gXn);
        this.efW.invalidate();
        this.drN.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
