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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView eLt;
    private TextView gFk;
    private ImageView kMR;
    private TextView kMS;
    private int kMT;
    private HeadImageView kwz;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.kMT = R.color.CAM_X0108;
        this.kwz = (HeadImageView) view.findViewById(R.id.photo);
        this.kwz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kwz.setAutoChangeStyle(true);
        this.kwz.setPlaceHolder(1);
        this.eLt = (TextView) view.findViewById(R.id.user_name);
        this.kMR = (ImageView) view.findViewById(R.id.fans_reply);
        this.gFk = (TextView) view.findViewById(R.id.time);
        this.kMS = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.kwz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bHi().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.bHi().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                aq aqVar = new aq("c13784");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dX("fname", data.getFname());
                aqVar.dX("tid", data.getThread_id());
                aqVar.an("obj_type", 1);
                TiebaStatic.log(aqVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.bHi().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
                return true;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aw(FeedData feedData) {
        super.aw(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.eLt.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.kMT = R.color.cp_cont_r;
            } else {
                this.kMT = R.color.CAM_X0108;
            }
            ao.setViewTextColor(this.eLt, this.kMT);
            this.kwz.setIsRound(true);
            this.kwz.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.kwz, replyer, 0);
            this.kwz.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.kwz.startLoad(avater, 12, false);
            } else {
                this.kwz.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.kMR.setVisibility(0);
            } else {
                this.kMR.setVisibility(8);
            }
        }
        this.gFk.setText(at.getFormatTime(feedData.getTime()));
        this.kMS.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ao.qe(R.color.CAM_X0205));
        ao.setBackgroundColor(this.mLine, R.color.CAM_X0204);
        ao.setViewTextColor(this.gFk, R.color.CAM_X0109);
        ao.setBackgroundResource(this.kMR, R.drawable.icon_pb_fans);
        ao.setViewTextColor(this.kMS, R.color.CAM_X0105);
        ao.setViewTextColor(this.eLt, this.kMT);
        this.kwz.invalidate();
        this.gFk.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
