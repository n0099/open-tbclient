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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class MessageCardBottomView extends LinearLayout {
    private TextView akL;
    private String fName;
    private ViewGroup kVG;
    private ImageView kVH;
    private TextView kVI;

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
        this.akL = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.kVG = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.kVH = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.kVI = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && au.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kVG.setVisibility(z ? 0 : 8);
        if (au.isEmpty(str)) {
            this.akL.setVisibility(8);
            return;
        }
        this.fName = str;
        this.akL.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.akL.setVisibility(0);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.akL, R.color.CAM_X0109);
        ap.setViewTextColor(this.kVI, R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.bsU().a(this.kVH, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.CAM_X0107, (SvgManager.SvgResourceStateType) null);
    }

    public View getReplyContainer() {
        return this.kVG;
    }
}
