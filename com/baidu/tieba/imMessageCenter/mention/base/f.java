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
/* loaded from: classes9.dex */
public class f {
    private View iRO;
    private LinearLayout iRP;
    private ImageView iRQ;
    private HeadImageView iuG;
    private TextView iuH;
    private MessageRedDotView iuK;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.iRO = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.iRP = (LinearLayout) this.iRO.findViewById(R.id.reply_and_at_item);
        this.iRQ = (ImageView) this.iRO.findViewById(R.id.arrow_view);
        this.iuG = (HeadImageView) this.iRO.findViewById(R.id.reply_and_at_head);
        this.iuG.setIsRound(true);
        this.iuG.setDrawBorder(false);
        this.iuK = (MessageRedDotView) this.iRO.findViewById(R.id.new_message);
        this.iuH = (TextView) this.iRO.findViewById(R.id.desc_view);
    }

    public void bl(String str, int i) {
        this.iuH.setText(str);
        this.mIcon = i;
        crv();
    }

    public void U(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.iuK.refresh(i);
            this.iuK.setVisibility(0);
            return;
        }
        this.iuK.setVisibility(8);
    }

    public void crv() {
        am.setViewTextColor(this.iuH, R.color.cp_cont_b, 1);
        this.iRO.setBackgroundDrawable(am.le(R.color.cp_bg_line_e));
        SvgManager.aUW().a(this.iRQ, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.iuG, this.mIcon);
        if (this.iuK != null) {
            this.iuK.onChangeSkinType();
        }
    }

    public View getView() {
        return this.iRO;
    }
}
