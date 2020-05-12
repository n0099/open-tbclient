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
    private View iCr;
    private LinearLayout iCs;
    private ImageView iCt;
    private HeadImageView ifk;
    private TextView ifl;
    private MessageRedDotView ifo;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.iCr = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.iCs = (LinearLayout) this.iCr.findViewById(R.id.reply_and_at_item);
        this.iCt = (ImageView) this.iCr.findViewById(R.id.arrow_view);
        this.ifk = (HeadImageView) this.iCr.findViewById(R.id.reply_and_at_head);
        this.ifk.setIsRound(true);
        this.ifk.setDrawBorder(false);
        this.ifo = (MessageRedDotView) this.iCr.findViewById(R.id.new_message);
        this.ifl = (TextView) this.iCr.findViewById(R.id.desc_view);
    }

    public void bk(String str, int i) {
        this.ifl.setText(str);
        this.mIcon = i;
        ckN();
    }

    public void R(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.ifo.refresh(i);
            this.ifo.setVisibility(0);
            return;
        }
        this.ifo.setVisibility(8);
    }

    public void ckN() {
        am.setViewTextColor(this.ifl, R.color.cp_cont_b, 1);
        this.iCr.setBackgroundDrawable(am.kC(R.color.cp_bg_line_e));
        SvgManager.aOR().a(this.iCt, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.ifk, this.mIcon);
        if (this.ifo != null) {
            this.ifo.onChangeSkinType();
        }
    }

    public View getView() {
        return this.iCr;
    }
}
