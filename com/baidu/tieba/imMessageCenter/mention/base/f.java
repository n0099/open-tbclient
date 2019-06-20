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
    private View gQX;
    private LinearLayout gQY;
    private ImageView gQZ;
    private HeadImageView gtT;
    private TextView gtU;
    private MessageRedDotView gtX;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.gQX = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.gQY = (LinearLayout) this.gQX.findViewById(R.id.reply_and_at_item);
        this.gQZ = (ImageView) this.gQX.findViewById(R.id.arrow_view);
        this.gtT = (HeadImageView) this.gQX.findViewById(R.id.reply_and_at_head);
        this.gtT.setIsRound(true);
        this.gtT.setDrawBorder(false);
        this.mLine = this.gQX.findViewById(R.id.line);
        this.gtX = (MessageRedDotView) this.gQX.findViewById(R.id.new_message);
        this.gtU = (TextView) this.gQX.findViewById(R.id.desc_view);
    }

    public void aU(String str, int i) {
        this.gtU.setText(str);
        this.mIcon = i;
        bFE();
    }

    public void J(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gtX.refresh(i);
            this.gtX.setVisibility(0);
            return;
        }
        this.gtX.setVisibility(8);
    }

    public void bFE() {
        al.f(this.gtU, R.color.cp_cont_b, 1);
        al.k(this.gQX, R.drawable.addresslist_item_bg);
        al.k(this.mLine, R.color.cp_bg_line_c);
        al.c(this.gQZ, (int) R.drawable.icon_arrow_gray_right_n);
        al.c(this.gtT, this.mIcon);
        if (this.gtX != null) {
            this.gtX.onChangeSkinType();
        }
    }

    public void vF(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.gQX;
    }
}
