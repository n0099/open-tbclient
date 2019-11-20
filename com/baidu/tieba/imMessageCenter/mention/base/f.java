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
    private View gXe;
    private LinearLayout gXf;
    private ImageView gXg;
    private HeadImageView gzV;
    private TextView gzW;
    private MessageRedDotView gzZ;
    private int mIcon;

    public f(TbPageContext tbPageContext) {
        this.gXe = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.gXf = (LinearLayout) this.gXe.findViewById(R.id.reply_and_at_item);
        this.gXg = (ImageView) this.gXe.findViewById(R.id.arrow_view);
        this.gzV = (HeadImageView) this.gXe.findViewById(R.id.reply_and_at_head);
        this.gzV.setIsRound(true);
        this.gzV.setDrawBorder(false);
        this.gzZ = (MessageRedDotView) this.gXe.findViewById(R.id.new_message);
        this.gzW = (TextView) this.gXe.findViewById(R.id.desc_view);
    }

    public void aS(String str, int i) {
        this.gzW.setText(str);
        this.mIcon = i;
        bno();
    }

    public void K(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gzZ.refresh(i);
            this.gzZ.setVisibility(0);
            return;
        }
        this.gzZ.setVisibility(8);
    }

    public void bno() {
        am.setViewTextColor(this.gzW, R.color.cp_cont_b, 1);
        this.gXe.setBackgroundDrawable(am.is(R.color.cp_bg_line_e));
        SvgManager.amL().a(this.gXg, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setImageResource(this.gzV, this.mIcon);
        if (this.gzZ != null) {
            this.gzZ.onChangeSkinType();
        }
    }

    public View getView() {
        return this.gXe;
    }
}
