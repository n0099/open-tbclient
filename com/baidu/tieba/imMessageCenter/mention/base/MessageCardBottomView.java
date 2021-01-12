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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView ajE;
    private String fName;
    private ViewGroup kLn;
    private ImageView kLo;
    private TextView kLp;

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
        this.ajE = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.kLn = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.kLo = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.kLp = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && at.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kLn.setVisibility(z ? 0 : 8);
        if (at.isEmpty(str)) {
            this.ajE.setVisibility(8);
            return;
        }
        this.fName = str;
        this.ajE.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.ajE.setVisibility(0);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.ajE, R.color.CAM_X0109);
        ao.setViewTextColor(this.kLp, R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.bsx().a(this.kLo, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.CAM_X0107, (SvgManager.SvgResourceStateType) null);
    }

    public View getReplyContainer() {
        return this.kLn;
    }
}
