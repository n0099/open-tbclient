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
    private TextView eig;
    private TextView fWB;
    private HeadImageView isB;
    private ImageView kbh;
    private TextView kbi;
    private int kbj;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.kbj = R.color.cp_cont_c;
        this.isB = (HeadImageView) view.findViewById(R.id.photo);
        this.isB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.isB.setAutoChangeStyle(true);
        this.isB.setPlaceHolder(1);
        this.eig = (TextView) view.findViewById(R.id.user_name);
        this.kbh = (ImageView) view.findViewById(R.id.fans_reply);
        this.fWB = (TextView) view.findViewById(R.id.time);
        this.kbi = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.isB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bxF().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.bxF().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                aq aqVar = new aq("c13784");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dK("fname", data.getFname());
                aqVar.dK("tid", data.getThread_id());
                aqVar.aj("obj_type", 1);
                TiebaStatic.log(aqVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.bxF().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
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
            this.eig.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.kbj = R.color.cp_cont_r;
            } else {
                this.kbj = R.color.cp_cont_c;
            }
            ap.setViewTextColor(this.eig, this.kbj);
            this.isB.setIsRound(true);
            this.isB.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.isB, replyer, 0);
            this.isB.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.isB.startLoad(avater, 12, false);
            } else {
                this.isB.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.kbh.setVisibility(0);
            } else {
                this.kbh.setVisibility(8);
            }
        }
        this.fWB.setText(at.getFormatTime(feedData.getTime()));
        this.kbi.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ap.oC(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fWB, R.color.cp_cont_d);
        ap.setBackgroundResource(this.kbh, R.drawable.icon_pb_fans);
        ap.setViewTextColor(this.kbi, R.color.cp_cont_b);
        ap.setViewTextColor(this.eig, this.kbj);
        this.isB.invalidate();
        this.fWB.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
