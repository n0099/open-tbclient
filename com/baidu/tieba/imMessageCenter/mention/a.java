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
/* loaded from: classes22.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView ewx;
    private TextView gmt;
    private HeadImageView iKU;
    private ImageView ktC;
    private TextView ktD;
    private int ktE;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ktE = R.color.cp_cont_c;
        this.iKU = (HeadImageView) view.findViewById(R.id.photo);
        this.iKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iKU.setAutoChangeStyle(true);
        this.iKU.setPlaceHolder(1);
        this.ewx = (TextView) view.findViewById(R.id.user_name);
        this.ktC = (ImageView) view.findViewById(R.id.fans_reply);
        this.gmt = (TextView) view.findViewById(R.id.time);
        this.ktD = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.iKU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bBX().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.bBX().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                aq aqVar = new aq("c13784");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dR("fname", data.getFname());
                aqVar.dR("tid", data.getThread_id());
                aqVar.al("obj_type", 1);
                TiebaStatic.log(aqVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.bBX().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(FeedData feedData) {
        super.au(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.ewx.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.ktE = R.color.cp_cont_r;
            } else {
                this.ktE = R.color.cp_cont_c;
            }
            ap.setViewTextColor(this.ewx, this.ktE);
            this.iKU.setIsRound(true);
            this.iKU.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.iKU, replyer, 0);
            this.iKU.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.iKU.startLoad(avater, 12, false);
            } else {
                this.iKU.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.ktC.setVisibility(0);
            } else {
                this.ktC.setVisibility(8);
            }
        }
        this.gmt.setText(at.getFormatTime(feedData.getTime()));
        this.ktD.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ap.oX(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.gmt, R.color.cp_cont_d);
        ap.setBackgroundResource(this.ktC, R.drawable.icon_pb_fans);
        ap.setViewTextColor(this.ktD, R.color.cp_cont_b);
        ap.setViewTextColor(this.ewx, this.ktE);
        this.iKU.invalidate();
        this.gmt.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
