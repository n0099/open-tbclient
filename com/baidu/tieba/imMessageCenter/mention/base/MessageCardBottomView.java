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
    private TextView ajt;
    private String fName;
    private ViewGroup kTE;
    private ImageView kTF;
    private TextView kTG;

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
        this.ajt = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.kTE = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.kTF = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.kTG = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void setData(String str, boolean z) {
        if (!z && au.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kTE.setVisibility(z ? 0 : 8);
        if (au.isEmpty(str)) {
            this.ajt.setVisibility(8);
            return;
        }
        this.fName = str;
        this.ajt.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.ajt.setVisibility(0);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ajt, R.color.CAM_X0109);
        ap.setViewTextColor(this.kTG, R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.bsR().a(this.kTF, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.CAM_X0107, (SvgManager.SvgResourceStateType) null);
    }

    public View getReplyContainer() {
        return this.kTE;
    }
}
