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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class MessageCardBottomView extends LinearLayout {
    private String aGa;
    private TextView awL;
    private ViewGroup eJf;
    private ImageView eJg;
    private TextView eJh;

    public MessageCardBottomView(Context context) {
        super(context);
        by(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        by(context);
    }

    private void by(Context context) {
        View inflate = LayoutInflater.from(context).inflate(f.h.message_card_bottom_layout, (ViewGroup) this, true);
        this.awL = (TextView) inflate.findViewById(f.g.message_bottom_bar_name);
        this.eJf = (ViewGroup) inflate.findViewById(f.g.message_bottom_reply_container);
        this.eJg = (ImageView) inflate.findViewById(f.g.message_bottom_reply_img);
        this.eJh = (TextView) inflate.findViewById(f.g.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ap.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eJf.setVisibility(z ? 0 : 8);
        if (ap.isEmpty(str)) {
            this.awL.setVisibility(8);
            return;
        }
        this.aGa = str;
        this.awL.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.awL.setVisibility(0);
    }

    public void onChangeSkinType() {
        am.h(this.awL, f.d.cp_cont_d);
        am.h(this.eJh, f.C0146f.selector_comment_and_prise_item_text_color);
        am.c(this.eJg, f.C0146f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.eJf;
    }
}
