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
    private TextView bRZ;
    private String cbs;
    private ViewGroup gzP;
    private ImageView gzQ;
    private TextView gzR;

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
        this.bRZ = (TextView) inflate.findViewById(d.g.message_bottom_bar_name);
        this.gzP = (ViewGroup) inflate.findViewById(d.g.message_bottom_reply_container);
        this.gzQ = (ImageView) inflate.findViewById(d.g.message_bottom_reply_img);
        this.gzR = (TextView) inflate.findViewById(d.g.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ap.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gzP.setVisibility(z ? 0 : 8);
        if (ap.isEmpty(str)) {
            this.bRZ.setVisibility(8);
            return;
        }
        this.cbs = str;
        this.bRZ.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.bRZ.setVisibility(0);
    }

    public void onChangeSkinType() {
        al.j(this.bRZ, d.C0236d.cp_cont_d);
        al.j(this.gzR, d.f.selector_comment_and_prise_item_text_color);
        al.c(this.gzQ, d.f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.gzP;
    }
}
