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
/* loaded from: classes22.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView eBQ;
    private TextView gul;
    private ImageView kHI;
    private TextView kHJ;
    private int kHK;
    private HeadImageView kjT;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.kHK = R.color.CAM_X0108;
        this.kjT = (HeadImageView) view.findViewById(R.id.photo);
        this.kjT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kjT.setAutoChangeStyle(true);
        this.kjT.setPlaceHolder(1);
        this.eBQ = (TextView) view.findViewById(R.id.user_name);
        this.kHI = (ImageView) view.findViewById(R.id.fans_reply);
        this.gul = (TextView) view.findViewById(R.id.time);
        this.kHJ = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.kjT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.bEP().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FeedData data = a.this.getData();
                a.this.bEP().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, data, null, null));
                ar arVar = new ar("c13784");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.dY("fname", data.getFname());
                arVar.dY("tid", data.getThread_id());
                arVar.al("obj_type", 1);
                TiebaStatic.log(arVar);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                a.this.bEP().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9489, a.this.getData(), null, null));
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
            this.eBQ.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.kHK = R.color.cp_cont_r;
            } else {
                this.kHK = R.color.CAM_X0108;
            }
            ap.setViewTextColor(this.eBQ, this.kHK);
            this.kjT.setIsRound(true);
            this.kjT.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.kjT, replyer, 0);
            this.kjT.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.kjT.startLoad(avater, 12, false);
            } else {
                this.kjT.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.kHI.setVisibility(0);
            } else {
                this.kHI.setVisibility(8);
            }
        }
        this.gul.setText(au.getFormatTime(feedData.getTime()));
        this.kHJ.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(ap.pT(R.color.CAM_X0205));
        ap.setBackgroundColor(this.mLine, R.color.CAM_X0204);
        ap.setViewTextColor(this.gul, R.color.CAM_X0109);
        ap.setBackgroundResource(this.kHI, R.drawable.icon_pb_fans);
        ap.setViewTextColor(this.kHJ, R.color.CAM_X0105);
        ap.setViewTextColor(this.eBQ, this.kHK);
        this.kjT.invalidate();
        this.gul.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
