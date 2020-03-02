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
    private View hQI;
    private LinearLayout hQJ;
    private ImageView hQK;
    private HeadImageView htF;
    private TextView htG;
    private MessageRedDotView htJ;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.hQI = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.hQJ = (LinearLayout) this.hQI.findViewById(R.id.reply_and_at_item);
        this.hQK = (ImageView) this.hQI.findViewById(R.id.arrow_view);
        this.htF = (HeadImageView) this.hQI.findViewById(R.id.reply_and_at_head);
        this.htF.setIsRound(true);
        this.htF.setDrawBorder(false);
        this.htJ = (MessageRedDotView) this.hQI.findViewById(R.id.new_message);
        this.htG = (TextView) this.hQI.findViewById(R.id.desc_view);
    }

    public void ba(String str, int i) {
        this.htG.setText(str);
        this.mIcon = i;
        bHs();
    }

    public void L(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.htJ.refresh(i);
            this.htJ.setVisibility(0);
            return;
        }
        this.htJ.setVisibility(8);
    }

    public void bHs() {
        am.setViewTextColor(this.htG, R.color.cp_cont_b, 1);
        this.hQI.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        SvgManager.aGC().a(this.hQK, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.htF, this.mIcon);
        if (this.htJ != null) {
            this.htJ.onChangeSkinType();
        }
    }

    public View getView() {
        return this.hQI;
    }
}
