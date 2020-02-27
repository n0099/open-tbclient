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
    private View hQG;
    private LinearLayout hQH;
    private ImageView hQI;
    private HeadImageView htD;
    private TextView htE;
    private MessageRedDotView htH;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.hQG = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.hQH = (LinearLayout) this.hQG.findViewById(R.id.reply_and_at_item);
        this.hQI = (ImageView) this.hQG.findViewById(R.id.arrow_view);
        this.htD = (HeadImageView) this.hQG.findViewById(R.id.reply_and_at_head);
        this.htD.setIsRound(true);
        this.htD.setDrawBorder(false);
        this.htH = (MessageRedDotView) this.hQG.findViewById(R.id.new_message);
        this.htE = (TextView) this.hQG.findViewById(R.id.desc_view);
    }

    public void ba(String str, int i) {
        this.htE.setText(str);
        this.mIcon = i;
        bHq();
    }

    public void L(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.htH.refresh(i);
            this.htH.setVisibility(0);
            return;
        }
        this.htH.setVisibility(8);
    }

    public void bHq() {
        am.setViewTextColor(this.htE, R.color.cp_cont_b, 1);
        this.hQG.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        SvgManager.aGA().a(this.hQI, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.htD, this.mIcon);
        if (this.htH != null) {
            this.htH.onChangeSkinType();
        }
    }

    public View getView() {
        return this.hQG;
    }
}
