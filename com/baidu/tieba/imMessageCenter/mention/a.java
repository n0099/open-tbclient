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
    private TextView dTQ;
    private TextView fGU;
    private HeadImageView hWu;
    private ImageView jDB;
    private TextView jDC;
    private int jDD;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.jDD = R.color.cp_cont_c;
        this.hWu = (HeadImageView) view.findViewById(R.id.photo);
        this.hWu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hWu.setAutoChangeStyle(true);
        this.hWu.setPlaceHolder(1);
        this.dTQ = (TextView) view.findViewById(R.id.user_name);
        this.jDB = (ImageView) view.findViewById(R.id.fans_reply);
        this.fGU = (TextView) view.findViewById(R.id.time);
        this.jDC = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.hWu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.btQ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.btQ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
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
                a.this.btQ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
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
            this.dTQ.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.jDD = R.color.cp_cont_r;
            } else {
                this.jDD = R.color.cp_cont_c;
            }
            ap.setViewTextColor(this.dTQ, this.jDD);
            this.hWu.setIsRound(true);
            this.hWu.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.hWu, replyer, 0);
            this.hWu.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.hWu.startLoad(avater, 12, false);
            } else {
                this.hWu.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.jDB.setVisibility(0);
            } else {
                this.jDB.setVisibility(8);
            }
        }
        this.fGU.setText(at.getFormatTime(feedData.getTime()));
        this.jDC.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ap.nT(R.color.cp_bg_line_e));
        ap.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.fGU, R.color.cp_cont_d);
        ap.setBackgroundResource(this.jDB, R.drawable.icon_pb_fans);
        ap.setViewTextColor(this.jDC, R.color.cp_cont_b);
        ap.setViewTextColor(this.dTQ, this.jDD);
        this.hWu.invalidate();
        this.fGU.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
