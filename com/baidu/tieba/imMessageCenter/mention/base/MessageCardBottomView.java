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
/* loaded from: classes16.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView ahZ;
    private String fName;
    private ViewGroup jGD;
    private ImageView jGE;
    private TextView jGF;

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
        this.ahZ = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.jGD = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.jGE = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.jGF = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && at.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jGD.setVisibility(z ? 0 : 8);
        if (at.isEmpty(str)) {
            this.ahZ.setVisibility(8);
            return;
        }
        this.fName = str;
        this.ahZ.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.ahZ.setVisibility(0);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ahZ, R.color.cp_cont_d);
        ap.setViewTextColor(this.jGF, R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.bjq().a(this.jGE, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
    }

    public View getReplyContainer() {
        return this.jGD;
    }
}
