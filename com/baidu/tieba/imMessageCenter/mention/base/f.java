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
    private View iRb;
    private LinearLayout iRc;
    private ImageView iRd;
    private HeadImageView itT;
    private TextView itU;
    private MessageRedDotView itX;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.iRb = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.iRc = (LinearLayout) this.iRb.findViewById(R.id.reply_and_at_item);
        this.iRd = (ImageView) this.iRb.findViewById(R.id.arrow_view);
        this.itT = (HeadImageView) this.iRb.findViewById(R.id.reply_and_at_head);
        this.itT.setIsRound(true);
        this.itT.setDrawBorder(false);
        this.itX = (MessageRedDotView) this.iRb.findViewById(R.id.new_message);
        this.itU = (TextView) this.iRb.findViewById(R.id.desc_view);
    }

    public void bl(String str, int i) {
        this.itU.setText(str);
        this.mIcon = i;
        crm();
    }

    public void U(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.itX.refresh(i);
            this.itX.setVisibility(0);
            return;
        }
        this.itX.setVisibility(8);
    }

    public void crm() {
        am.setViewTextColor(this.itU, R.color.cp_cont_b, 1);
        this.iRb.setBackgroundDrawable(am.lc(R.color.cp_bg_line_e));
        SvgManager.aUV().a(this.iRd, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.itT, this.mIcon);
        if (this.itX != null) {
            this.itX.onChangeSkinType();
        }
    }

    public View getView() {
        return this.iRb;
    }
}
