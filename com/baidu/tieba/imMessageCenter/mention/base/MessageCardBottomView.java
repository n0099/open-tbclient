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
/* loaded from: classes9.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView dhd;
    private String fName;
    private ViewGroup hQD;
    private ImageView hQE;
    private TextView hQF;

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
        this.dhd = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.hQD = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.hQE = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.hQF = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && aq.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.hQD.setVisibility(z ? 0 : 8);
        if (aq.isEmpty(str)) {
            this.dhd.setVisibility(8);
            return;
        }
        this.fName = str;
        this.dhd.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.dhd.setVisibility(0);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.dhd, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hQF, (int) R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.aGA().a(this.hQE, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
    }

    public View getReplyContainer() {
        return this.hQD;
    }
}
