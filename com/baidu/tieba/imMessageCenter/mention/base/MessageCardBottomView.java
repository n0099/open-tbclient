package com.baidu.tieba.imMessageCenter.mention.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
/* loaded from: classes4.dex */
public class MessageCardBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f17704e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f17705f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f17706g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17707h;

    public MessageCardBottomView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.message_card_bottom_layout, (ViewGroup) this, true);
        this.f17704e = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.f17705f = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.f17706g = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.f17707h = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void b() {
        SkinManager.setViewTextColor(this.f17704e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f17707h, R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f17706g, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.CAM_X0107, null);
    }

    public View getReplyContainer() {
        return this.f17705f;
    }

    public void setData(String str, boolean z) {
        if (!z && k.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f17705f.setVisibility(z ? 0 : 8);
        if (k.isEmpty(str)) {
            this.f17704e.setVisibility(8);
            return;
        }
        this.f17704e.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.f17704e.setVisibility(0);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
