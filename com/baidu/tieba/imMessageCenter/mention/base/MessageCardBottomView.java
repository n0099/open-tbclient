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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView agQ;
    private String fName;
    private ViewGroup jrF;
    private ImageView jrG;
    private TextView jrH;

    public MessageCardBottomView(Context context) {
        super(context);
        initUI(context);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    private void initUI(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.message_card_bottom_layout, (ViewGroup) this, true);
        this.agQ = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.jrF = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.jrG = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.jrH = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && as.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jrF.setVisibility(z ? 0 : 8);
        if (as.isEmpty(str)) {
            this.agQ.setVisibility(8);
            return;
        }
        this.fName = str;
        this.agQ.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.agQ.setVisibility(0);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.agQ, R.color.cp_cont_d);
        ao.setViewTextColor(this.jrH, R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.baR().a(this.jrG, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
    }

    public View getReplyContainer() {
        return this.jrF;
    }
}
