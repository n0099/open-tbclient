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
/* loaded from: classes6.dex */
public class f {
    private View hLf;
    private LinearLayout hLg;
    private ImageView hLh;
    private HeadImageView hob;
    private TextView hoc;
    private MessageRedDotView hof;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.hLf = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.hLg = (LinearLayout) this.hLf.findViewById(R.id.reply_and_at_item);
        this.hLh = (ImageView) this.hLf.findViewById(R.id.arrow_view);
        this.hob = (HeadImageView) this.hLf.findViewById(R.id.reply_and_at_head);
        this.hob.setIsRound(true);
        this.hob.setDrawBorder(false);
        this.hof = (MessageRedDotView) this.hLf.findViewById(R.id.new_message);
        this.hoc = (TextView) this.hLf.findViewById(R.id.desc_view);
    }

    public void bb(String str, int i) {
        this.hoc.setText(str);
        this.mIcon = i;
        bEM();
    }

    public void M(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.hof.refresh(i);
            this.hof.setVisibility(0);
            return;
        }
        this.hof.setVisibility(8);
    }

    public void bEM() {
        am.setViewTextColor(this.hoc, R.color.cp_cont_b, 1);
        this.hLf.setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
        SvgManager.aDW().a(this.hLh, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.hob, this.mIcon);
        if (this.hof != null) {
            this.hof.onChangeSkinType();
        }
    }

    public View getView() {
        return this.hLf;
    }
}
