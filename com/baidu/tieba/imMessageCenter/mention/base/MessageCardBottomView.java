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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView bcZ;
    private String blp;
    private ViewGroup eUx;
    private ImageView eUy;
    private TextView eUz;

    public MessageCardBottomView(Context context) {
        super(context);
        bA(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bA(context);
    }

    private void bA(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.message_card_bottom_layout, (ViewGroup) this, true);
        this.bcZ = (TextView) inflate.findViewById(d.g.message_bottom_bar_name);
        this.eUx = (ViewGroup) inflate.findViewById(d.g.message_bottom_reply_container);
        this.eUy = (ImageView) inflate.findViewById(d.g.message_bottom_reply_img);
        this.eUz = (TextView) inflate.findViewById(d.g.message_bottom_reply);
    }

    public void J(String str, boolean z) {
        if (!z && am.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eUx.setVisibility(z ? 0 : 8);
        if (am.isEmpty(str)) {
            this.bcZ.setVisibility(8);
            return;
        }
        this.blp = str;
        this.bcZ.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.bcZ.setVisibility(0);
    }

    public void onChangeSkinType() {
        aj.r(this.bcZ, d.C0141d.cp_cont_d);
        aj.r(this.eUz, d.f.selector_comment_and_prise_item_text_color);
        aj.c(this.eUy, d.f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.eUx;
    }
}
