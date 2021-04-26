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
import d.a.i0.r.u.c;
/* loaded from: classes5.dex */
public class ForumSelectedView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f22736e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f22737f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22738g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22739h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f22740i;
    public View j;

    public ForumSelectedView(Context context) {
        this(context, null);
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.cell_forum_selected_layout, (ViewGroup) this, true);
        this.f22737f = (ImageView) findViewById(R.id.cell_forum_selected_icon);
        this.f22738g = (TextView) findViewById(R.id.cell_forum_selected_name);
        this.f22739h = (TextView) findViewById(R.id.cell_forum_selected_tip);
        this.f22740i = (ImageView) findViewById(R.id.cell_forum_selected_arrow);
        this.j = findViewById(R.id.cell_forum_selected_line);
        setOnClickListener(this);
        b();
    }

    public void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f22736e) {
            return;
        }
        this.f22736e = skinType;
        SkinManager.setBackgroundResource(this, R.drawable.forum_selected_view_bg);
        this.f22737f.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_ba16, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        SkinManager.setViewTextColor(this.f22738g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f22739h, R.color.CAM_X0109);
        c d2 = c.d(this.f22739h);
        d2.k(R.string.J_X06);
        d2.f(R.color.CAM_X0206);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22740i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0210);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(getContext())));
    }

    public void setSelectedForum(String str) {
        this.f22739h.setVisibility(8);
        this.f22738g.setText(str);
    }

    public ForumSelectedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForumSelectedView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22736e = 3;
        a();
    }
}
