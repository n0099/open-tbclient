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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView aiP;
    private String fName;
    private ViewGroup kwE;
    private ImageView kwF;
    private TextView kwG;

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
        this.aiP = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.kwE = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.kwF = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.kwG = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && at.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kwE.setVisibility(z ? 0 : 8);
        if (at.isEmpty(str)) {
            this.aiP.setVisibility(8);
            return;
        }
        this.fName = str;
        this.aiP.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.aiP.setVisibility(0);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.aiP, R.color.cp_cont_d);
        ap.setViewTextColor(this.kwG, R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.brn().a(this.kwF, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
    }

    public View getReplyContainer() {
        return this.kwE;
    }
}
