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
    private TextView bSd;
    private String cbv;
    private ViewGroup gzD;
    private ImageView gzE;
    private TextView gzF;

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
        this.bSd = (TextView) inflate.findViewById(d.g.message_bottom_bar_name);
        this.gzD = (ViewGroup) inflate.findViewById(d.g.message_bottom_reply_container);
        this.gzE = (ImageView) inflate.findViewById(d.g.message_bottom_reply_img);
        this.gzF = (TextView) inflate.findViewById(d.g.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ap.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gzD.setVisibility(z ? 0 : 8);
        if (ap.isEmpty(str)) {
            this.bSd.setVisibility(8);
            return;
        }
        this.cbv = str;
        this.bSd.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.bSd.setVisibility(0);
    }

    public void onChangeSkinType() {
        al.j(this.bSd, d.C0277d.cp_cont_d);
        al.j(this.gzF, d.f.selector_comment_and_prise_item_text_color);
        al.c(this.gzE, d.f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.gzD;
    }
}
