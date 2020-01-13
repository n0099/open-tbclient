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
/* loaded from: classes7.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView bXF;
    private TextView ejW;
    private HeadImageView gpg;
    private ImageView hMa;
    private TextView hMb;
    private int hMc;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.hMc = R.color.cp_cont_c;
        this.gpg = (HeadImageView) view.findViewById(R.id.photo);
        this.gpg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gpg.setAutoChangeStyle(true);
        this.gpg.setPlaceHolder(1);
        this.bXF = (TextView) view.findViewById(R.id.user_name);
        this.hMa = (ImageView) view.findViewById(R.id.fans_reply);
        this.ejW = (TextView) view.findViewById(R.id.time);
        this.hMb = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.gpg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aOy().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aOy().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
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
            this.bXF.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.hMc = R.color.cp_cont_r;
            } else {
                this.hMc = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.bXF, this.hMc);
            this.gpg.setIsRound(true);
            this.gpg.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.gpg, replyer, 0);
            this.gpg.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.gpg.startLoad(avater, 12, false);
            } else {
                this.gpg.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.hMa.setVisibility(0);
            } else {
                this.hMa.setVisibility(8);
            }
        }
        this.ejW.setText(aq.getFormatTime(feedData.getTime()));
        this.hMb.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.ejW, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.hMa, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.hMb, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.bXF, this.hMc);
        this.gpg.invalidate();
        this.ejW.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
