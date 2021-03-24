package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FaceGroupMakeTitleBar extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public TextView f19237e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19238f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19239g;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((Activity) FaceGroupMakeTitleBar.this.getContext()).finish();
        }
    }

    public FaceGroupMakeTitleBar(Context context) {
        super(context);
        a();
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.face_group_make_title_bar, (ViewGroup) this, true);
        this.f19237e = (TextView) findViewById(R.id.tv_title);
        this.f19238f = (TextView) findViewById(R.id.tv_right);
        this.f19239g = (ImageView) findViewById(R.id.iv_close);
        SkinManager.setViewTextColor(this.f19237e, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f19238f, R.color.common_color_10140);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19239g, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0105, null);
        this.f19239g.setOnClickListener(new a());
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f19239g;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setRightListener(View.OnClickListener onClickListener) {
        this.f19238f.setOnClickListener(onClickListener);
    }

    public void setRightText(String str) {
        this.f19238f.setText(str);
    }

    public void setTitle(String str) {
        this.f19237e.setText(str);
    }

    public FaceGroupMakeTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FaceGroupMakeTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
