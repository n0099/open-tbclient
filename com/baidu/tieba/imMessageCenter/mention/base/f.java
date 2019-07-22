package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f {
    private HeadImageView gAe;
    private TextView gAf;
    private MessageRedDotView gAi;
    private View gXh;
    private LinearLayout gXi;
    private ImageView gXj;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.gXh = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.gXi = (LinearLayout) this.gXh.findViewById(R.id.reply_and_at_item);
        this.gXj = (ImageView) this.gXh.findViewById(R.id.arrow_view);
        this.gAe = (HeadImageView) this.gXh.findViewById(R.id.reply_and_at_head);
        this.gAe.setIsRound(true);
        this.gAe.setDrawBorder(false);
        this.mLine = this.gXh.findViewById(R.id.line);
        this.gAi = (MessageRedDotView) this.gXh.findViewById(R.id.new_message);
        this.gAf = (TextView) this.gXh.findViewById(R.id.desc_view);
    }

    public void aV(String str, int i) {
        this.gAf.setText(str);
        this.mIcon = i;
        bIl();
    }

    public void L(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gAi.refresh(i);
            this.gAi.setVisibility(0);
            return;
        }
        this.gAi.setVisibility(8);
    }

    public void bIl() {
        am.f(this.gAf, R.color.cp_cont_b, 1);
        am.k(this.gXh, R.drawable.addresslist_item_bg);
        am.k(this.mLine, R.color.cp_bg_line_c);
        am.c(this.gXj, (int) R.drawable.icon_arrow_gray_right_n);
        am.c(this.gAe, this.mIcon);
        if (this.gAi != null) {
            this.gAi.onChangeSkinType();
        }
    }

    public void wh(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.gXh;
    }
}
