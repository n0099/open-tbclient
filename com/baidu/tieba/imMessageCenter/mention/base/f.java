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
    private View iCl;
    private LinearLayout iCm;
    private ImageView iCn;
    private HeadImageView ife;
    private TextView iff;
    private MessageRedDotView ifi;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.iCl = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.iCm = (LinearLayout) this.iCl.findViewById(R.id.reply_and_at_item);
        this.iCn = (ImageView) this.iCl.findViewById(R.id.arrow_view);
        this.ife = (HeadImageView) this.iCl.findViewById(R.id.reply_and_at_head);
        this.ife.setIsRound(true);
        this.ife.setDrawBorder(false);
        this.ifi = (MessageRedDotView) this.iCl.findViewById(R.id.new_message);
        this.iff = (TextView) this.iCl.findViewById(R.id.desc_view);
    }

    public void bk(String str, int i) {
        this.iff.setText(str);
        this.mIcon = i;
        ckO();
    }

    public void R(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.ifi.refresh(i);
            this.ifi.setVisibility(0);
            return;
        }
        this.ifi.setVisibility(8);
    }

    public void ckO() {
        am.setViewTextColor(this.iff, R.color.cp_cont_b, 1);
        this.iCl.setBackgroundDrawable(am.kC(R.color.cp_bg_line_e));
        SvgManager.aOU().a(this.iCn, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.ife, this.mIcon);
        if (this.ifi != null) {
            this.ifi.onChangeSkinType();
        }
    }

    public View getView() {
        return this.iCl;
    }
}
