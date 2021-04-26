package com.baidu.tieba.themeCenter.avatarPendant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.c.e.p.k;
import d.a.j0.j3.d.c;
/* loaded from: classes5.dex */
public class AvatarPendantPerItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21880e;

    /* renamed from: f  reason: collision with root package name */
    public View f21881f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantView f21882g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f21883h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21884i;
    public TextView j;
    public DressItemData k;
    public c.a l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || AvatarPendantPerItemView.this.l == null) {
                return;
            }
            if (AvatarPendantPerItemView.this.k != null && AvatarPendantPerItemView.this.k.getInUse() && TbadkCoreApplication.isLogin()) {
                return;
            }
            AvatarPendantPerItemView.this.l.onItemClick(AvatarPendantPerItemView.this.k);
        }
    }

    public AvatarPendantPerItemView(Context context) {
        super(context);
        this.f21880e = context;
        d();
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(DressItemData dressItemData) {
        if (dressItemData == null) {
            return;
        }
        this.k = dressItemData;
        boolean inUse = dressItemData.getInUse();
        if (dressItemData.isPropIdEven()) {
            if (this.f21882g.getHeadView() != null) {
                this.f21882g.getHeadView().V(String.valueOf(R.drawable.pic_shop_woman), 24, false);
            }
        } else if (this.f21882g.getHeadView() != null) {
            this.f21882g.getHeadView().V(String.valueOf(R.drawable.pic_shop_man), 24, false);
        }
        if (k.byteLength(dressItemData.getTitle()) > 8) {
            this.j.setText(k.cutString(dressItemData.getTitle(), 8));
        } else {
            this.j.setText(dressItemData.getTitle());
        }
        if (inUse) {
            this.f21884i.setVisibility(0);
            SkinManager.setImageResource(this.f21884i, R.drawable.icon_shop_selected);
        } else {
            this.f21884i.setVisibility(8);
        }
        this.f21883h.V(dressItemData.getPermissionImgUrl(), 10, false);
        this.f21882g.l(dressItemData.getExampleImgUrl());
        this.f21882g.setOnClickListener(new a());
        SkinManager.setBackgroundColor(this.f21881f, R.color.CAM_X0201);
    }

    public final void d() {
        View inflate = LayoutInflater.from(this.f21880e).inflate(R.layout.avatar_pendant_per_item, this);
        this.f21881f = inflate;
        this.f21882g = (HeadPendantView) inflate.findViewById(R.id.avatar_image);
        TbImageView tbImageView = (TbImageView) this.f21881f.findViewById(R.id.permission_icon);
        this.f21883h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f21883h.setDefaultBgResource(R.drawable.transparent_bg);
        this.f21884i = (ImageView) this.f21881f.findViewById(R.id.choosed_icon);
        this.j = (TextView) this.f21881f.findViewById(R.id.text_pendant_name);
        this.f21882g.setHasPendantStyle();
        if (this.f21882g.getHeadView() != null) {
            this.f21882g.getHeadView().setIsRound(true);
            this.f21882g.getHeadView().setDrawBorder(false);
        }
        if (this.f21882g.getPendantView() != null) {
            this.f21882g.getPendantView().setIsRound(true);
            this.f21882g.getPendantView().setDrawBorder(false);
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.l = aVar;
    }

    public AvatarPendantPerItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21880e = context;
        d();
    }

    public AvatarPendantPerItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f21880e = context;
        d();
    }
}
