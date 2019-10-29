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
    private TextView cqm;
    private String cyE;
    private ViewGroup gXS;
    private ImageView gXT;
    private TextView gXU;

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
        this.cqm = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.gXS = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.gXT = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.gXU = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && aq.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gXS.setVisibility(z ? 0 : 8);
        if (aq.isEmpty(str)) {
            this.cqm.setVisibility(8);
            return;
        }
        this.cyE = str;
        this.cqm.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.cqm.setVisibility(0);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.cqm, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gXU, (int) R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.amN().a(this.gXT, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, null);
    }

    public View getReplyContainer() {
        return this.gXS;
    }
}
