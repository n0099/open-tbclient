package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class f {
    private View gQS;
    private LinearLayout gQT;
    private ImageView gQU;
    private HeadImageView gtQ;
    private TextView gtR;
    private MessageRedDotView gtU;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.gQS = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.gQT = (LinearLayout) this.gQS.findViewById(R.id.reply_and_at_item);
        this.gQU = (ImageView) this.gQS.findViewById(R.id.arrow_view);
        this.gtQ = (HeadImageView) this.gQS.findViewById(R.id.reply_and_at_head);
        this.gtQ.setIsRound(true);
        this.gtQ.setDrawBorder(false);
        this.mLine = this.gQS.findViewById(R.id.line);
        this.gtU = (MessageRedDotView) this.gQS.findViewById(R.id.new_message);
        this.gtR = (TextView) this.gQS.findViewById(R.id.desc_view);
    }

    public void aU(String str, int i) {
        this.gtR.setText(str);
        this.mIcon = i;
        bFA();
    }

    public void J(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gtU.refresh(i);
            this.gtU.setVisibility(0);
            return;
        }
        this.gtU.setVisibility(8);
    }

    public void bFA() {
        al.f(this.gtR, R.color.cp_cont_b, 1);
        al.k(this.gQS, R.drawable.addresslist_item_bg);
        al.k(this.mLine, R.color.cp_bg_line_c);
        al.c(this.gQU, (int) R.drawable.icon_arrow_gray_right_n);
        al.c(this.gtQ, this.mIcon);
        if (this.gtU != null) {
            this.gtU.onChangeSkinType();
        }
    }

    public void vF(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.gQS;
    }
}
