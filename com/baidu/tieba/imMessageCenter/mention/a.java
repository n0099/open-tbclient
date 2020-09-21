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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes21.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView dWe;
    private TextView fKk;
    private HeadImageView idE;
    private ImageView jMj;
    private TextView jMk;
    private int jMl;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.jMl = R.color.cp_cont_c;
        this.idE = (HeadImageView) view.findViewById(R.id.photo);
        this.idE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.idE.setAutoChangeStyle(true);
        this.idE.setPlaceHolder(1);
        this.dWe = (TextView) view.findViewById(R.id.user_name);
        this.jMj = (ImageView) view.findViewById(R.id.fans_reply);
        this.fKk = (TextView) view.findViewById(R.id.time);
        this.jMk = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.idE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.buV().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.buV().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                aq aqVar = new aq("c13784");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dF("fname", data.getFname());
                aqVar.dF("tid", data.getThread_id());
                aqVar.ai("obj_type", 1);
                TiebaStatic.log(aqVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.buV().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ar(FeedData feedData) {
        super.ar(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.dWe.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.jMl = R.color.cp_cont_r;
            } else {
                this.jMl = R.color.cp_cont_c;
            }
            ap.setViewTextColor(this.dWe, this.jMl);
            this.idE.setIsRound(true);
            this.idE.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.idE, replyer, 0);
            this.idE.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.idE.startLoad(avater, 12, false);
            } else {
                this.idE.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.jMj.setVisibility(0);
            } else {
                this.jMj.setVisibility(8);
            }
        }
        this.fKk.setText(at.getFormatTime(feedData.getTime()));
        this.jMk.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ap.of(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fKk, R.color.cp_cont_d);
        ap.setBackgroundResource(this.jMj, R.drawable.icon_pb_fans);
        ap.setViewTextColor(this.jMk, R.color.cp_cont_b);
        ap.setViewTextColor(this.dWe, this.jMl);
        this.idE.invalidate();
        this.fKk.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
