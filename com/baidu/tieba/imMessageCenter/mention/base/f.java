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
    private View gQV;
    private LinearLayout gQW;
    private ImageView gQX;
    private HeadImageView gtR;
    private TextView gtS;
    private MessageRedDotView gtV;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.gQV = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.gQW = (LinearLayout) this.gQV.findViewById(R.id.reply_and_at_item);
        this.gQX = (ImageView) this.gQV.findViewById(R.id.arrow_view);
        this.gtR = (HeadImageView) this.gQV.findViewById(R.id.reply_and_at_head);
        this.gtR.setIsRound(true);
        this.gtR.setDrawBorder(false);
        this.mLine = this.gQV.findViewById(R.id.line);
        this.gtV = (MessageRedDotView) this.gQV.findViewById(R.id.new_message);
        this.gtS = (TextView) this.gQV.findViewById(R.id.desc_view);
    }

    public void aU(String str, int i) {
        this.gtS.setText(str);
        this.mIcon = i;
        bFD();
    }

    public void J(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gtV.refresh(i);
            this.gtV.setVisibility(0);
            return;
        }
        this.gtV.setVisibility(8);
    }

    public void bFD() {
        al.f(this.gtS, R.color.cp_cont_b, 1);
        al.k(this.gQV, R.drawable.addresslist_item_bg);
        al.k(this.mLine, R.color.cp_bg_line_c);
        al.c(this.gQX, (int) R.drawable.icon_arrow_gray_right_n);
        al.c(this.gtR, this.mIcon);
        if (this.gtV != null) {
            this.gtV.onChangeSkinType();
        }
    }

    public void vF(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.gQV;
    }
}
