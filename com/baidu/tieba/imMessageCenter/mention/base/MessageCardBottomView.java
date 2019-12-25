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
/* loaded from: classes6.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView dcO;
    private String fName;
    private ViewGroup hLc;
    private ImageView hLd;
    private TextView hLe;

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
        this.dcO = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.hLc = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.hLd = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.hLe = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && aq.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.hLc.setVisibility(z ? 0 : 8);
        if (aq.isEmpty(str)) {
            this.dcO.setVisibility(8);
            return;
        }
        this.fName = str;
        this.dcO.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.dcO.setVisibility(0);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dcO, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hLe, (int) R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.aDW().a(this.hLd, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
    }

    public View getReplyContainer() {
        return this.hLc;
    }
}
