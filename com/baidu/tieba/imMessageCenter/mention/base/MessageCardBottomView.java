package com.baidu.tieba.imMessageCenter.mention.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView cbY;
    private String clE;
    private ViewGroup gZQ;
    private ImageView gZR;
    private TextView gZS;

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
        this.cbY = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.gZQ = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.gZR = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.gZS = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && aq.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gZQ.setVisibility(z ? 0 : 8);
        if (aq.isEmpty(str)) {
            this.cbY.setVisibility(8);
            return;
        }
        this.clE = str;
        this.cbY.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.cbY.setVisibility(0);
    }

    public void onChangeSkinType() {
        am.j(this.cbY, R.color.cp_cont_d);
        am.j(this.gZS, R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.ajv().a(this.gZR, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, null);
    }

    public View getReplyContainer() {
        return this.gZQ;
    }
}
