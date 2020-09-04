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
/* loaded from: classes16.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView dTU;
    private TextView fGY;
    private HeadImageView hWA;
    private ImageView jDH;
    private TextView jDI;
    private int jDJ;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.jDJ = R.color.cp_cont_c;
        this.hWA = (HeadImageView) view.findViewById(R.id.photo);
        this.hWA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hWA.setAutoChangeStyle(true);
        this.hWA.setPlaceHolder(1);
        this.dTU = (TextView) view.findViewById(R.id.user_name);
        this.jDH = (ImageView) view.findViewById(R.id.fans_reply);
        this.fGY = (TextView) view.findViewById(R.id.time);
        this.jDI = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.hWA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.btR().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.btR().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                aq aqVar = new aq("c13784");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dD("fname", data.getFname());
                aqVar.dD("tid", data.getThread_id());
                aqVar.ai("obj_type", 1);
                TiebaStatic.log(aqVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.btR().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aq(FeedData feedData) {
        super.aq(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.dTU.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.jDJ = R.color.cp_cont_r;
            } else {
                this.jDJ = R.color.cp_cont_c;
            }
            ap.setViewTextColor(this.dTU, this.jDJ);
            this.hWA.setIsRound(true);
            this.hWA.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.hWA, replyer, 0);
            this.hWA.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.hWA.startLoad(avater, 12, false);
            } else {
                this.hWA.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.jDH.setVisibility(0);
            } else {
                this.jDH.setVisibility(8);
            }
        }
        this.fGY.setText(at.getFormatTime(feedData.getTime()));
        this.jDI.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ap.nT(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fGY, R.color.cp_cont_d);
        ap.setBackgroundResource(this.jDH, R.drawable.icon_pb_fans);
        ap.setViewTextColor(this.jDI, R.color.cp_cont_b);
        ap.setViewTextColor(this.dTU, this.jDJ);
        this.hWA.invalidate();
        this.fGY.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
