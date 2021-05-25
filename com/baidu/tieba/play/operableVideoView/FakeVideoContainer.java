package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.m0.r.q.a2;
import d.a.m0.r.u.c;
/* loaded from: classes5.dex */
public class FakeVideoContainer extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f19958e;

    /* renamed from: f  reason: collision with root package name */
    public View f19959f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19960g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f19961h;

    public FakeVideoContainer(Context context) {
        super(context);
        a();
    }

    public void a() {
        RelativeLayout.inflate(getContext(), R.layout.fake_video_container, this);
        this.f19958e = (TbImageView) findViewById(R.id.video_thumbnail);
        this.f19959f = findViewById(R.id.black_mask);
        this.f19960g = (ImageView) findViewById(R.id.video_play);
        this.f19961h = (EMTextView) findViewById(R.id.fake_video_info);
        this.f19960g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        c d2 = c.d(this.f19961h);
        d2.s(R.color.CAM_X0101);
        d2.x(R.string.F_X01);
        this.f19958e.A();
        this.f19958e.setDrawCorner(false);
        this.f19958e.setPlaceHolder(3);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.i(getContext(), getContext().getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
    }

    public void setData(a2 a2Var) {
        if (a2Var == null || a2Var.w1() == null) {
            return;
        }
        a2Var.w1().is_vertical.intValue();
        this.f19958e.setPlaceHolder(3);
        if (!a2Var.w1().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !a2Var.w1().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            this.f19958e.V(a2Var.w1().thumbnail_url, 32, false);
        } else {
            this.f19958e.V(a2Var.w1().thumbnail_url, 10, false);
        }
    }

    public FakeVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FakeVideoContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
