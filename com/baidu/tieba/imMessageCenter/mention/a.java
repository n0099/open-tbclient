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
    private TextView cbJ;
    private TextView eoh;
    private HeadImageView grh;
    private ImageView hNY;
    private TextView hNZ;
    private int hOa;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.hOa = R.color.cp_cont_c;
        this.grh = (HeadImageView) view.findViewById(R.id.photo);
        this.grh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grh.setAutoChangeStyle(true);
        this.grh.setPlaceHolder(1);
        this.cbJ = (TextView) view.findViewById(R.id.user_name);
        this.hNY = (ImageView) view.findViewById(R.id.fans_reply);
        this.eoh = (TextView) view.findViewById(R.id.time);
        this.hNZ = (TextView) view.findViewById(R.id.content);
        this.mLine = view.findViewById(R.id.line);
        this.grh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aQN().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aQN().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
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
            this.cbJ.setText(UtilHelper.getUserName(replyer));
            if (feedData.getReplyer().isBigV()) {
                this.hOa = R.color.cp_cont_r;
            } else {
                this.hOa = R.color.cp_cont_c;
            }
            am.setViewTextColor(this.cbJ, this.hOa);
            this.grh.setIsRound(true);
            this.grh.setVisibility(0);
            UtilHelper.showHeadImageViewBigV(this.grh, replyer, 0);
            this.grh.setTag(null);
            String avater = feedData.getReplyer().getAvater();
            if (avater != null && avater.length() > 0) {
                this.grh.startLoad(avater, 12, false);
            } else {
                this.grh.setImageResource(R.drawable.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.hNY.setVisibility(0);
            } else {
                this.hNY.setVisibility(8);
            }
        }
        this.eoh.setText(aq.getFormatTime(feedData.getTime()));
        this.hNZ.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        getRootView().setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        am.setBackgroundColor(this.mLine, R.color.cp_bg_line_c);
        am.setViewTextColor(this.eoh, (int) R.color.cp_cont_d);
        am.setBackgroundResource(this.hNY, R.drawable.icon_pb_fans);
        am.setViewTextColor(this.hNZ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cbJ, this.hOa);
        this.grh.invalidate();
        this.eoh.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
