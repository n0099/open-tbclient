package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView cbW;
    private TextView eoM;
    private HeadImageView gsg;
    private ImageView hPM;
    private TextView hPN;
    private int hPO;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.hPO = R.color.cp_cont_c;
        this.gsg = (HeadImageView) view.findViewById(R.id.photo);
        this.gsg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gsg.setAutoChangeStyle(true);
        this.gsg.setPlaceHolder(1);
        this.cbW = (TextView) view.findViewById(R.id.user_name);
        this.hPM = (ImageView) view.findViewById(R.id.fans_reply);
        this.eoM = (TextView) view.findViewById(R.id.time);
        this.hPN = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.gsg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aQU().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aQU().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(FeedData feedData) {
        super.ai(feedData);
        if (feedData.getReplyer() != null) {
            MetaData replyer = feedData.getReplyer();
            this.cbW.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.hPO = R.color.cp_cont_r;
            } else {
                this.hPO = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.cbW, this.hPO);
            this.gsg.setIsRound(true);
            this.gsg.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.gsg, replyer, 0);
            this.gsg.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.gsg.startLoad(avater, 12, false);
            } else {
                this.gsg.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.hPM.setVisibility(0);
            } else {
                this.hPM.setVisibility(8);
            }
        }
        this.eoM.setText(aq.getFormatTime(feedData.getTime()));
        this.hPN.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eoM, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.hPM, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.hPN, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cbW, this.hPO);
        this.gsg.invalidate();
        this.eoM.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
