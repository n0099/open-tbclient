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
import d.b.c.e.p.k;
/* loaded from: classes4.dex */
public class MessageCardBottomView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f18044e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f18045f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f18046g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18047h;

    public MessageCardBottomView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.message_card_bottom_layout, (ViewGroup) this, true);
        this.f18044e = (TextView) inflate.findViewById(R.id.message_bottom_bar_name);
        this.f18045f = (ViewGroup) inflate.findViewById(R.id.message_bottom_reply_container);
        this.f18046g = (ImageView) inflate.findViewById(R.id.message_bottom_reply_img);
        this.f18047h = (TextView) inflate.findViewById(R.id.message_bottom_reply);
    }

    public void b() {
        SkinManager.setViewTextColor(this.f18044e, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f18047h, R.drawable.selector_comment_and_prise_item_text_color);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f18046g, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.CAM_X0107, null);
    }

    public View getReplyContainer() {
        return this.f18045f;
    }

    public void setData(String str, boolean z) {
        if (!z && k.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f18045f.setVisibility(z ? 0 : 8);
        if (k.isEmpty(str)) {
            this.f18044e.setVisibility(8);
            return;
        }
        this.f18044e.setText(UtilHelper.getForumNameWithBar(str, 5, true));
        this.f18044e.setVisibility(0);
    }

    public MessageCardBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
