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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class MessageCardBottomView extends LinearLayout {
    private String aGb;
    private TextView awO;
    private ViewGroup eJk;
    private ImageView eJl;
    private TextView eJm;

    public MessageCardBottomView(Context context) {
        super(context);
        by(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        by(context);
    }

    private void by(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.message_card_bottom_layout, (ViewGroup) this, true);
        this.awO = (TextView) inflate.findViewById(d.g.message_bottom_bar_name);
        this.eJk = (ViewGroup) inflate.findViewById(d.g.message_bottom_reply_container);
        this.eJl = (ImageView) inflate.findViewById(d.g.message_bottom_reply_img);
        this.eJm = (TextView) inflate.findViewById(d.g.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ap.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eJk.setVisibility(z ? 0 : 8);
        if (ap.isEmpty(str)) {
            this.awO.setVisibility(8);
            return;
        }
        this.aGb = str;
        this.awO.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.awO.setVisibility(0);
    }

    public void onChangeSkinType() {
        am.h(this.awO, d.C0140d.cp_cont_d);
        am.h(this.eJm, d.f.selector_comment_and_prise_item_text_color);
        am.c(this.eJl, d.f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.eJk;
    }
}
