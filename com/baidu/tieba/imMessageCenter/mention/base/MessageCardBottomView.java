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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class MessageCardBottomView extends LinearLayout {
    private String aFh;
    private TextView awz;
    private ViewGroup eBA;
    private ImageView eBB;
    private TextView eBC;

    public MessageCardBottomView(Context context) {
        super(context);
        by(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        by(context);
    }

    private void by(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.message_card_bottom_layout, (ViewGroup) this, true);
        this.awz = (TextView) inflate.findViewById(d.g.message_bottom_bar_name);
        this.eBA = (ViewGroup) inflate.findViewById(d.g.message_bottom_reply_container);
        this.eBB = (ImageView) inflate.findViewById(d.g.message_bottom_reply_img);
        this.eBC = (TextView) inflate.findViewById(d.g.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ao.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eBA.setVisibility(z ? 0 : 8);
        if (ao.isEmpty(str)) {
            this.awz.setVisibility(8);
            return;
        }
        this.aFh = str;
        this.awz.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.awz.setVisibility(0);
    }

    public void onChangeSkinType() {
        al.h(this.awz, d.C0141d.cp_cont_d);
        al.h(this.eBC, d.f.selector_comment_and_prise_item_text_color);
        al.c(this.eBB, d.f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.eBA;
    }
}
