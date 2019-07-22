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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView caY;
    private String ckC;
    private ViewGroup gXe;
    private ImageView gXf;
    private TextView gXg;

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
        this.caY = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.gXe = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.gXf = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.gXg = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && aq.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gXe.setVisibility(z ? 0 : 8);
        if (aq.isEmpty(str)) {
            this.caY.setVisibility(8);
            return;
        }
        this.ckC = str;
        this.caY.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.caY.setVisibility(0);
    }

    public void onChangeSkinType() {
        am.j(this.caY, R.color.cp_cont_d);
        am.j(this.gXg, R.drawable.selector_comment_and_prise_item_text_color);
        am.c(this.gXf, (int) R.drawable.icon_home_card_comment);
    }

    public View getReplyContainer() {
        return this.gXe;
    }
}
