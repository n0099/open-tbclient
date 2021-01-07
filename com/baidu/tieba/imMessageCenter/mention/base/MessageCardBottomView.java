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
    private TextView akv;
    private String fName;
    private ViewGroup kPS;
    private ImageView kPT;
    private TextView kPU;

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
        this.akv = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.kPS = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.kPT = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.kPU = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && at.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kPS.setVisibility(z ? 0 : 8);
        if (at.isEmpty(str)) {
            this.akv.setVisibility(8);
            return;
        }
        this.fName = str;
        this.akv.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.akv.setVisibility(0);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.akv, R.color.CAM_X0109);
        ao.setViewTextColor(this.kPU, R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.bwr().a(this.kPT, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.CAM_X0107, (SvgManager.SvgResourceStateType) null);
    }

    public View getReplyContainer() {
        return this.kPS;
    }
}
