package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView dEL;
    private TextView fqs;
    private HeadImageView hDg;
    private ImageView jgf;
    private TextView jgg;
    private int jgh;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.jgh = R.color.cp_cont_c;
        this.hDg = (HeadImageView) view.findViewById(R.id.photo);
        this.hDg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hDg.setAutoChangeStyle(true);
        this.hDg.setPlaceHolder(1);
        this.dEL = (TextView) view.findViewById(R.id.user_name);
        this.jgf = (ImageView) view.findViewById(R.id.fans_reply);
        this.fqs = (TextView) view.findViewById(R.id.time);
        this.jgg = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.hDg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bhs().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.bhs().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                ao aoVar = new ao("c13784");
                aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar.dk("fname", data.getFname());
                aoVar.dk("tid", data.getThread_id());
                aoVar.ag("obj_type", 1);
                TiebaStatic.log(aoVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.bhs().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ao(FeedData feedData) {
        super.ao(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.dEL.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.jgh = R.color.cp_cont_r;
            } else {
                this.jgh = R.color.cp_cont_c;
            }
            an.setViewTextColor(this.dEL, this.jgh);
            this.hDg.setIsRound(true);
            this.hDg.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.hDg, replyer, 0);
            this.hDg.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.hDg.startLoad(avater, 12, false);
            } else {
                this.hDg.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.jgf.setVisibility(0);
            } else {
                this.jgf.setVisibility(8);
            }
        }
        this.fqs.setText(ar.getFormatTime(feedData.getTime()));
        this.jgg.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(an.ls(R.color.cp_bg_line_e));
        an.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        an.setViewTextColor(this.fqs, (int) R.color.cp_cont_d);
        an.setBackgroundResource(this.jgf, R.drawable.icon_pb_fans);
        an.setViewTextColor(this.jgg, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.dEL, this.jgh);
        this.hDg.invalidate();
        this.fqs.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
