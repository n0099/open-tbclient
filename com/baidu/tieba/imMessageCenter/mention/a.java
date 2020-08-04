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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes16.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView dKI;
    private TextView fvC;
    private HeadImageView hJe;
    private ImageView joD;
    private TextView joE;
    private int joF;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.joF = R.color.cp_cont_c;
        this.hJe = (HeadImageView) view.findViewById(R.id.photo);
        this.hJe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hJe.setAutoChangeStyle(true);
        this.hJe.setPlaceHolder(1);
        this.dKI = (TextView) view.findViewById(R.id.user_name);
        this.joD = (ImageView) view.findViewById(R.id.fans_reply);
        this.fvC = (TextView) view.findViewById(R.id.time);
        this.joE = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.hJe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bld().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.bld().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                ap apVar = new ap("c13784");
                apVar.t("uid", TbadkApplication.getCurrentAccountId());
                apVar.dn("fname", data.getFname());
                apVar.dn("tid", data.getThread_id());
                apVar.ah("obj_type", 1);
                TiebaStatic.log(apVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.bld().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
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
            this.dKI.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.joF = R.color.cp_cont_r;
            } else {
                this.joF = R.color.cp_cont_c;
            }
            ao.setViewTextColor(this.dKI, this.joF);
            this.hJe.setIsRound(true);
            this.hJe.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.hJe, replyer, 0);
            this.hJe.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.hJe.startLoad(avater, 12, false);
            } else {
                this.hJe.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.joD.setVisibility(0);
            } else {
                this.joD.setVisibility(8);
            }
        }
        this.fvC.setText(as.getFormatTime(feedData.getTime()));
        this.joE.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ao.lM(R.color.cp_bg_line_e));
        ao.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.fvC, R.color.cp_cont_d);
        ao.setBackgroundResource(this.joD, R.drawable.icon_pb_fans);
        ao.setViewTextColor(this.joE, R.color.cp_cont_b);
        ao.setViewTextColor(this.dKI, this.joF);
        this.hJe.invalidate();
        this.fvC.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
