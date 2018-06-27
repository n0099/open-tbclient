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
    private TextView axi;
    private ViewGroup eFq;
    private ImageView eFr;
    private TextView eFs;

    public MessageCardBottomView(Context context) {
        super(context);
        bx(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bx(context);
    }

    private void bx(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.message_card_bottom_layout, (ViewGroup) this, true);
        this.axi = (TextView) inflate.findViewById(d.g.message_bottom_bar_name);
        this.eFq = (ViewGroup) inflate.findViewById(d.g.message_bottom_reply_container);
        this.eFr = (ImageView) inflate.findViewById(d.g.message_bottom_reply_img);
        this.eFs = (TextView) inflate.findViewById(d.g.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ap.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eFq.setVisibility(z ? 0 : 8);
        if (ap.isEmpty(str)) {
            this.axi.setVisibility(8);
            return;
        }
        this.aGb = str;
        this.axi.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.axi.setVisibility(0);
    }

    public void onChangeSkinType() {
        am.h(this.axi, d.C0142d.cp_cont_d);
        am.h(this.eFs, d.f.selector_comment_and_prise_item_text_color);
        am.c(this.eFr, d.f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.eFq;
    }
}
