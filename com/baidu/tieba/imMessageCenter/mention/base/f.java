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
    private HeadImageView gCN;
    private TextView gCO;
    private MessageRedDotView gCR;
    private View gZT;
    private LinearLayout gZU;
    private ImageView gZV;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.gZT = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.gZU = (LinearLayout) this.gZT.findViewById(R.id.reply_and_at_item);
        this.gZV = (ImageView) this.gZT.findViewById(R.id.arrow_view);
        this.gCN = (HeadImageView) this.gZT.findViewById(R.id.reply_and_at_head);
        this.gCN.setIsRound(true);
        this.gCN.setDrawBorder(false);
        this.gCR = (MessageRedDotView) this.gZT.findViewById(R.id.new_message);
        this.gCO = (TextView) this.gZT.findViewById(R.id.desc_view);
    }

    public void aX(String str, int i) {
        this.gCO.setText(str);
        this.mIcon = i;
        bql();
    }

    public void M(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gCR.refresh(i);
            this.gCR.setVisibility(0);
            return;
        }
        this.gCR.setVisibility(8);
    }

    public void bql() {
        am.f(this.gCO, R.color.cp_cont_b, 1);
        this.gZT.setBackgroundDrawable(am.io(R.color.cp_bg_line_e));
        SvgManager.ajv().a(this.gZV, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.c(this.gCN, this.mIcon);
        if (this.gCR != null) {
            this.gCR.onChangeSkinType();
        }
    }

    public View getView() {
        return this.gZT;
    }
}
