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
    private View hSu;
    private LinearLayout hSv;
    private ImageView hSw;
    private HeadImageView hvr;
    private TextView hvs;
    private MessageRedDotView hvv;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.hSu = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.hSv = (LinearLayout) this.hSu.findViewById(R.id.reply_and_at_item);
        this.hSw = (ImageView) this.hSu.findViewById(R.id.arrow_view);
        this.hvr = (HeadImageView) this.hSu.findViewById(R.id.reply_and_at_head);
        this.hvr.setIsRound(true);
        this.hvr.setDrawBorder(false);
        this.hvv = (MessageRedDotView) this.hSu.findViewById(R.id.new_message);
        this.hvs = (TextView) this.hSu.findViewById(R.id.desc_view);
    }

    public void ba(String str, int i) {
        this.hvs.setText(str);
        this.mIcon = i;
        can();
    }

    public void L(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.hvv.refresh(i);
            this.hvv.setVisibility(0);
            return;
        }
        this.hvv.setVisibility(8);
    }

    public void can() {
        am.setViewTextColor(this.hvs, R.color.cp_cont_b, 1);
        this.hSu.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        SvgManager.aGG().a(this.hSw, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.hvr, this.mIcon);
        if (this.hvv != null) {
            this.hvv.onChangeSkinType();
        }
    }

    public View getView() {
        return this.hSu;
    }
}
