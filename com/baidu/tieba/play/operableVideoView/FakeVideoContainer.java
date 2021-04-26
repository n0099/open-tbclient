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
import d.a.i0.r.q.a2;
import d.a.i0.r.u.c;
/* loaded from: classes4.dex */
public class FakeVideoContainer extends RelativeLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f20748e;

    /* renamed from: f  reason: collision with root package name */
    public View f20749f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f20750g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f20751h;

    public FakeVideoContainer(Context context) {
        super(context);
        a();
    }

    public void a() {
        RelativeLayout.inflate(getContext(), R.layout.fake_video_container, this);
        this.f20748e = (TbImageView) findViewById(R.id.video_thumbnail);
        this.f20749f = findViewById(R.id.black_mask);
        this.f20750g = (ImageView) findViewById(R.id.video_play);
        this.f20751h = (EMTextView) findViewById(R.id.fake_video_info);
        this.f20750g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        c d2 = c.d(this.f20751h);
        d2.q(R.color.CAM_X0101);
        d2.v(R.string.F_X01);
        this.f20748e.A();
        this.f20748e.setDrawCorner(false);
        this.f20748e.setPlaceHolder(3);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BdToast.i(getContext(), getContext().getString(R.string.video_is_checking), R.drawable.icon_pure_toast_mistake40_svg, true).q();
    }

    public void setData(a2 a2Var) {
        if (a2Var == null || a2Var.u1() == null) {
            return;
        }
        a2Var.u1().is_vertical.intValue();
        this.f20748e.setPlaceHolder(3);
        if (!a2Var.u1().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) && !a2Var.u1().thumbnail_url.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS)) {
            this.f20748e.V(a2Var.u1().thumbnail_url, 32, false);
        } else {
            this.f20748e.V(a2Var.u1().thumbnail_url, 10, false);
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
