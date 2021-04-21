package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.b.i0.r.u.c;
/* loaded from: classes5.dex */
public class ForumSelectedView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f22055e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f22056f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22057g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22058h;
    public ImageView i;
    public View j;

    public ForumSelectedView(Context context) {
        this(context, null);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.cell_forum_selected_layout, (ViewGroup) this, true);
        this.f22056f = (ImageView) findViewById(R.id.cell_forum_selected_icon);
        this.f22057g = (TextView) findViewById(R.id.cell_forum_selected_name);
        this.f22058h = (TextView) findViewById(R.id.cell_forum_selected_tip);
        this.i = (ImageView) findViewById(R.id.cell_forum_selected_arrow);
        this.j = findViewById(R.id.cell_forum_selected_line);
        setOnClickListener(this);
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f22055e) {
            return;
        }
        this.f22055e = skinType;
        SkinManager.setBackgroundResource(this, R.drawable.forum_selected_view_bg);
        this.f22056f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(this.f22057g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f22058h, R.color.CAM_X0109);
        c d2 = c.d(this.f22058h);
        d2.k(R.string.J_X06);
        d2.f(R.color.CAM_X0206);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0210);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(getContext())));
    }

    public void setSelectedForum(String str) {
        this.f22058h.setVisibility(8);
        this.f22057g.setText(str);
    }

    public ForumSelectedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForumSelectedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22055e = 3;
        a();
    }
}
