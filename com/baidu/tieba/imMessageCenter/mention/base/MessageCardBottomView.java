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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView bZV;
    private String cjw;
    private ViewGroup gQP;
    private ImageView gQQ;
    private TextView gQR;

    public MessageCardBottomView(Context context) {
        super(context);
        ap(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap(context);
    }

    private void ap(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.message_card_bottom_layout, (ViewGroup) this, true);
        this.bZV = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.gQP = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.gQQ = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.gQR = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ap.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gQP.setVisibility(z ? 0 : 8);
        if (ap.isEmpty(str)) {
            this.bZV.setVisibility(8);
            return;
        }
        this.cjw = str;
        this.bZV.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.bZV.setVisibility(0);
    }

    public void onChangeSkinType() {
        al.j(this.bZV, R.color.cp_cont_d);
        al.j(this.gQR, R.drawable.selector_comment_and_prise_item_text_color);
        al.c(this.gQQ, (int) R.drawable.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.gQP;
    }
}
