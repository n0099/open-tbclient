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
/* loaded from: classes4.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView aIW;
    private String aSf;
    private ViewGroup fgk;
    private ImageView fgl;
    private TextView fgm;

    public MessageCardBottomView(Context context) {
        super(context);
        cr(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cr(context);
    }

    private void cr(Context context) {
        View inflate = LayoutInflater.from(context).inflate(e.h.message_card_bottom_layout, (ViewGroup) this, true);
        this.aIW = (TextView) inflate.findViewById(e.g.message_bottom_bar_name);
        this.fgk = (ViewGroup) inflate.findViewById(e.g.message_bottom_reply_container);
        this.fgl = (ImageView) inflate.findViewById(e.g.message_bottom_reply_img);
        this.fgm = (TextView) inflate.findViewById(e.g.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ao.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fgk.setVisibility(z ? 0 : 8);
        if (ao.isEmpty(str)) {
            this.aIW.setVisibility(8);
            return;
        }
        this.aSf = str;
        this.aIW.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.aIW.setVisibility(0);
    }

    public void onChangeSkinType() {
        al.h(this.aIW, e.d.cp_cont_d);
        al.h(this.fgm, e.f.selector_comment_and_prise_item_text_color);
        al.c(this.fgl, e.f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.fgk;
    }
}
