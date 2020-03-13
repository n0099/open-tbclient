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
    private View hQU;
    private LinearLayout hQV;
    private ImageView hQW;
    private HeadImageView htR;
    private TextView htS;
    private MessageRedDotView htV;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.hQU = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.hQV = (LinearLayout) this.hQU.findViewById(R.id.reply_and_at_item);
        this.hQW = (ImageView) this.hQU.findViewById(R.id.arrow_view);
        this.htR = (HeadImageView) this.hQU.findViewById(R.id.reply_and_at_head);
        this.htR.setIsRound(true);
        this.htR.setDrawBorder(false);
        this.htV = (MessageRedDotView) this.hQU.findViewById(R.id.new_message);
        this.htS = (TextView) this.hQU.findViewById(R.id.desc_view);
    }

    public void ba(String str, int i) {
        this.htS.setText(str);
        this.mIcon = i;
        bHt();
    }

    public void L(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.htV.refresh(i);
            this.htV.setVisibility(0);
            return;
        }
        this.htV.setVisibility(8);
    }

    public void bHt() {
        am.setViewTextColor(this.htS, R.color.cp_cont_b, 1);
        this.hQU.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        SvgManager.aGC().a(this.hQW, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.htR, this.mIcon);
        if (this.htV != null) {
            this.htV.onChangeSkinType();
        }
    }

    public View getView() {
        return this.hQU;
    }
}
