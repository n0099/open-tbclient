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
    private HeadImageView gAW;
    private TextView gAX;
    private MessageRedDotView gBa;
    private View gXZ;
    private LinearLayout gYa;
    private ImageView gYb;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.gXZ = LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.reply_and_at_item, (ViewGroup) null, false);
        this.gYa = (LinearLayout) this.gXZ.findViewById(R.id.reply_and_at_item);
        this.gYb = (ImageView) this.gXZ.findViewById(R.id.arrow_view);
        this.gAW = (HeadImageView) this.gXZ.findViewById(R.id.reply_and_at_head);
        this.gAW.setIsRound(true);
        this.gAW.setDrawBorder(false);
        this.mLine = this.gXZ.findViewById(R.id.line);
        this.gBa = (MessageRedDotView) this.gXZ.findViewById(R.id.new_message);
        this.gAX = (TextView) this.gXZ.findViewById(R.id.desc_view);
    }

    public void aV(String str, int i) {
        this.gAX.setText(str);
        this.mIcon = i;
        bIz();
    }

    public void L(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gBa.refresh(i);
            this.gBa.setVisibility(0);
            return;
        }
        this.gBa.setVisibility(8);
    }

    public void bIz() {
        am.f(this.gAX, R.color.cp_cont_b, 1);
        am.k(this.gXZ, R.drawable.addresslist_item_bg);
        am.k(this.mLine, R.color.cp_bg_line_c);
        am.c(this.gYb, (int) R.drawable.icon_arrow_gray_right_n);
        am.c(this.gAW, this.mIcon);
        if (this.gBa != null) {
            this.gBa.onChangeSkinType();
        }
    }

    public void wj(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.gXZ;
    }
}
