package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f {
    private HeadImageView iLM;
    private TextView iLN;
    private MessageRedDotView iLQ;
    private View jja;
    private LinearLayout jjb;
    private ImageView jjc;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.jja = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.jjb = (LinearLayout) this.jja.findViewById(R.id.reply_and_at_item);
        this.jjc = (ImageView) this.jja.findViewById(R.id.arrow_view);
        this.iLM = (HeadImageView) this.jja.findViewById(R.id.reply_and_at_head);
        this.iLM.setIsRound(true);
        this.iLM.setDrawBorder(false);
        this.iLQ = (MessageRedDotView) this.jja.findViewById(R.id.new_message);
        this.iLN = (TextView) this.jja.findViewById(R.id.desc_view);
    }

    public void bk(String str, int i) {
        this.iLN.setText(str);
        this.mIcon = i;
        aYi();
    }

    public void X(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.iLQ.refresh(i);
            this.iLQ.setVisibility(0);
            return;
        }
        this.iLQ.setVisibility(8);
    }

    public void aYi() {
        an.setViewTextColor(this.iLN, R.color.cp_cont_b, 1);
        this.jja.setBackgroundDrawable(an.ls(R.color.cp_bg_line_e));
        SvgManager.aWQ().a(this.jjc, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        an.setImageResource(this.iLM, this.mIcon);
        if (this.iLQ != null) {
            this.iLQ.onChangeSkinType();
        }
    }

    public View getView() {
        return this.jja;
    }
}
