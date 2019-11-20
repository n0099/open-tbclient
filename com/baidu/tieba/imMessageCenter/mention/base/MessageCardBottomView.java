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
    private TextView cpv;
    private String cxN;
    private ViewGroup gXb;
    private ImageView gXc;
    private TextView gXd;

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
        this.cpv = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.gXb = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.gXc = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.gXd = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && aq.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gXb.setVisibility(z ? 0 : 8);
        if (aq.isEmpty(str)) {
            this.cpv.setVisibility(8);
            return;
        }
        this.cxN = str;
        this.cpv.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.cpv.setVisibility(0);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.cpv, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gXd, (int) R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.amL().a(this.gXc, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, null);
    }

    public View getReplyContainer() {
        return this.gXb;
    }
}
