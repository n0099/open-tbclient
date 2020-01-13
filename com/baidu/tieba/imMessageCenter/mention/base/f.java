package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class f {
    private View hOI;
    private LinearLayout hOJ;
    private ImageView hOK;
    private HeadImageView hrE;
    private TextView hrF;
    private MessageRedDotView hrI;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.hOI = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.hOJ = (LinearLayout) this.hOI.findViewById(R.id.reply_and_at_item);
        this.hOK = (ImageView) this.hOI.findViewById(R.id.arrow_view);
        this.hrE = (HeadImageView) this.hOI.findViewById(R.id.reply_and_at_head);
        this.hrE.setIsRound(true);
        this.hrE.setDrawBorder(false);
        this.hrI = (MessageRedDotView) this.hOI.findViewById(R.id.new_message);
        this.hrF = (TextView) this.hOI.findViewById(R.id.desc_view);
    }

    public void bc(String str, int i) {
        this.hrF.setText(str);
        this.mIcon = i;
        bFO();
    }

    public void M(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.hrI.refresh(i);
            this.hrI.setVisibility(0);
            return;
        }
        this.hrI.setVisibility(8);
    }

    public void bFO() {
        am.setViewTextColor(this.hrF, R.color.cp_cont_b, 1);
        this.hOI.setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
        SvgManager.aEp().a(this.hOK, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.hrE, this.mIcon);
        if (this.hrI != null) {
            this.hrI.onChangeSkinType();
        }
    }

    public View getView() {
        return this.hOI;
    }
}
