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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView eIO;
    private TextView gDo;
    private HeadImageView kAb;
    private ImageView kQp;
    private TextView kQq;
    private int kQr;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.kQr = R.color.CAM_X0108;
        this.kAb = (HeadImageView) view.findViewById(R.id.photo);
        this.kAb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kAb.setAutoChangeStyle(true);
        this.kAb.setPlaceHolder(1);
        this.eIO = (TextView) view.findViewById(R.id.user_name);
        this.kQp = (ImageView) view.findViewById(R.id.fans_reply);
        this.gDo = (TextView) view.findViewById(R.id.time);
        this.kQq = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.kAb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bDI().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.bDI().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                ar arVar = new ar("c13784");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.dR("fname", data.getFname());
                arVar.dR("tid", data.getThread_id());
                arVar.ap("obj_type", 1);
                TiebaStatic.log(arVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.bDI().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
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
            this.eIO.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.kQr = R.color.cp_cont_r;
            } else {
                this.kQr = R.color.CAM_X0108;
            }
            ap.setViewTextColor(this.eIO, this.kQr);
            this.kAb.setIsRound(true);
            this.kAb.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.kAb, replyer, 0);
            this.kAb.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.kAb.startLoad(avater, 12, false);
            } else {
                this.kAb.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.kQp.setVisibility(0);
            } else {
                this.kQp.setVisibility(8);
            }
        }
        this.gDo.setText(au.getFormatTime(feedData.getTime()));
        this.kQq.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ap.oC(R.color.CAM_X0205));
        ap.setBackgroundColor(this.mLine, R.color.CAM_X0204);
        ap.setViewTextColor(this.gDo, R.color.CAM_X0109);
        ap.setBackgroundResource(this.kQp, R.drawable.icon_pb_fans);
        ap.setViewTextColor(this.kQq, R.color.CAM_X0105);
        ap.setViewTextColor(this.eIO, this.kQr);
        this.kAb.invalidate();
        this.gDo.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
