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
    private TextView eGI;
    private TextView gAE;
    private ImageView kIm;
    private TextView kIn;
    private int kIo;
    private HeadImageView krU;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.kIo = R.color.CAM_X0108;
        this.krU = (HeadImageView) view.findViewById(R.id.photo);
        this.krU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.krU.setAutoChangeStyle(true);
        this.krU.setPlaceHolder(1);
        this.eGI = (TextView) view.findViewById(R.id.user_name);
        this.kIm = (ImageView) view.findViewById(R.id.fans_reply);
        this.gAE = (TextView) view.findViewById(R.id.time);
        this.kIn = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.krU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bDq().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.bDq().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                aq aqVar = new aq("c13784");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dW("fname", data.getFname());
                aqVar.dW("tid", data.getThread_id());
                aqVar.an("obj_type", 1);
                TiebaStatic.log(aqVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.bDq().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
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
            this.eGI.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.kIo = R.color.cp_cont_r;
            } else {
                this.kIo = R.color.CAM_X0108;
            }
            ao.setViewTextColor(this.eGI, this.kIo);
            this.krU.setIsRound(true);
            this.krU.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.krU, replyer, 0);
            this.krU.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.krU.startLoad(avater, 12, false);
            } else {
                this.krU.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.kIm.setVisibility(0);
            } else {
                this.kIm.setVisibility(8);
            }
        }
        this.gAE.setText(at.getFormatTime(feedData.getTime()));
        this.kIn.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ao.ox(R.color.CAM_X0205));
        ao.setBackgroundColor(this.mLine, R.color.CAM_X0204);
        ao.setViewTextColor(this.gAE, R.color.CAM_X0109);
        ao.setBackgroundResource(this.kIm, R.drawable.icon_pb_fans);
        ao.setViewTextColor(this.kIn, R.color.CAM_X0105);
        ao.setViewTextColor(this.eGI, this.kIo);
        this.krU.invalidate();
        this.gAE.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
