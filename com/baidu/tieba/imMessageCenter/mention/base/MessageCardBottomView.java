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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView agZ;
    private String fName;
    private ViewGroup jiX;
    private ImageView jiY;
    private TextView jiZ;

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
        this.agZ = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.jiX = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.jiY = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.jiZ = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && ar.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jiX.setVisibility(z ? 0 : 8);
        if (ar.isEmpty(str)) {
            this.agZ.setVisibility(8);
            return;
        }
        this.fName = str;
        this.agZ.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.agZ.setVisibility(0);
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.agZ, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.jiZ, (int) R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.aWQ().a(this.jiY, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
    }

    public View getReplyContainer() {
        return this.jiX;
    }
}
