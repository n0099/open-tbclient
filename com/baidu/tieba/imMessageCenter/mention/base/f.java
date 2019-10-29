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
/* loaded from: classes4.dex */
public class f {
    private HeadImageView gAM;
    private TextView gAN;
    private MessageRedDotView gAQ;
    private View gXV;
    private LinearLayout gXW;
    private ImageView gXX;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.gXV = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.gXW = (LinearLayout) this.gXV.findViewById(R.id.reply_and_at_item);
        this.gXX = (ImageView) this.gXV.findViewById(R.id.arrow_view);
        this.gAM = (HeadImageView) this.gXV.findViewById(R.id.reply_and_at_head);
        this.gAM.setIsRound(true);
        this.gAM.setDrawBorder(false);
        this.gAQ = (MessageRedDotView) this.gXV.findViewById(R.id.new_message);
        this.gAN = (TextView) this.gXV.findViewById(R.id.desc_view);
    }

    public void aS(String str, int i) {
        this.gAN.setText(str);
        this.mIcon = i;
        bnq();
    }

    public void K(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gAQ.refresh(i);
            this.gAQ.setVisibility(0);
            return;
        }
        this.gAQ.setVisibility(8);
    }

    public void bnq() {
        am.setViewTextColor(this.gAN, R.color.cp_cont_b, 1);
        this.gXV.setBackgroundDrawable(am.it(R.color.cp_bg_line_e));
        SvgManager.amN().a(this.gXX, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.gAM, this.mIcon);
        if (this.gAQ != null) {
            this.gAQ.onChangeSkinType();
        }
    }

    public View getView() {
        return this.gXV;
    }
}
