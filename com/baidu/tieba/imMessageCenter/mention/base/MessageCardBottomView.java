package com.baidu.tieba.imMessageCenter.mention.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView bSc;
    private String cbu;
    private ViewGroup gzC;
    private ImageView gzD;
    private TextView gzE;

    public MessageCardBottomView(Context context) {
        super(context);
        aX(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aX(context);
    }

    private void aX(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.message_card_bottom_layout, (ViewGroup) this, true);
        this.bSc = (TextView) inflate.findViewById(d.g.message_bottom_bar_name);
        this.gzC = (ViewGroup) inflate.findViewById(d.g.message_bottom_reply_container);
        this.gzD = (ImageView) inflate.findViewById(d.g.message_bottom_reply_img);
        this.gzE = (TextView) inflate.findViewById(d.g.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ap.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gzC.setVisibility(z ? 0 : 8);
        if (ap.isEmpty(str)) {
            this.bSc.setVisibility(8);
            return;
        }
        this.cbu = str;
        this.bSc.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.bSc.setVisibility(0);
    }

    public void onChangeSkinType() {
        al.j(this.bSc, d.C0277d.cp_cont_d);
        al.j(this.gzE, d.f.selector_comment_and_prise_item_text_color);
        al.c(this.gzD, d.f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.gzC;
    }
}
