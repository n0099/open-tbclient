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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class MessageCardBottomView extends LinearLayout {
    private String aJo;
    private TextView azY;
    private ViewGroup eQv;
    private ImageView eQw;
    private TextView eQx;

    public MessageCardBottomView(Context context) {
        super(context);
        cf(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cf(context);
    }

    private void cf(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.message_card_bottom_layout, (ViewGroup) this, true);
        this.azY = (TextView) inflate.findViewById(e.g.message_bottom_bar_name);
        this.eQv = (ViewGroup) inflate.findViewById(e.g.message_bottom_reply_container);
        this.eQw = (ImageView) inflate.findViewById(e.g.message_bottom_reply_img);
        this.eQx = (TextView) inflate.findViewById(e.g.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ao.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eQv.setVisibility(z ? 0 : 8);
        if (ao.isEmpty(str)) {
            this.azY.setVisibility(8);
            return;
        }
        this.aJo = str;
        this.azY.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.azY.setVisibility(0);
    }

    public void onChangeSkinType() {
        al.h(this.azY, e.d.cp_cont_d);
        al.h(this.eQx, e.f.selector_comment_and_prise_item_text_color);
        al.c(this.eQw, e.f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.eQv;
    }
}
