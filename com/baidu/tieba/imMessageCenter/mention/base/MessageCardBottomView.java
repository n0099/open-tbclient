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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView aor;
    private String awU;
    private ViewGroup eqj;
    private ImageView eqk;
    private TextView eql;

    public MessageCardBottomView(Context context) {
        super(context);
        bo(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bo(context);
    }

    private void bo(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.i.message_card_bottom_layout, (ViewGroup) this, true);
        this.aor = (TextView) inflate.findViewById(d.g.message_bottom_bar_name);
        this.eqj = (ViewGroup) inflate.findViewById(d.g.message_bottom_reply_container);
        this.eqk = (ImageView) inflate.findViewById(d.g.message_bottom_reply_img);
        this.eql = (TextView) inflate.findViewById(d.g.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && an.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.eqj.setVisibility(z ? 0 : 8);
        if (an.isEmpty(str)) {
            this.aor.setVisibility(8);
            return;
        }
        this.awU = str;
        this.aor.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.aor.setVisibility(0);
    }

    public void onChangeSkinType() {
        ak.h(this.aor, d.C0126d.cp_cont_d);
        ak.h(this.eql, d.f.selector_comment_and_prise_item_text_color);
        ak.c(this.eqk, d.f.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.eqj;
    }
}
