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
import d.b.c.e.p.k;
import d.b.j0.j3.d.c;
/* loaded from: classes5.dex */
public class AvatarPendantPerItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21277e;

    /* renamed from: f  reason: collision with root package name */
    public View f21278f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantView f21279g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f21280h;
    public ImageView i;
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
        this.f21277e = context;
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
            if (this.f21279g.getHeadView() != null) {
                this.f21279g.getHeadView().W(String.valueOf(R.drawable.pic_shop_woman), 24, false);
            }
        } else if (this.f21279g.getHeadView() != null) {
            this.f21279g.getHeadView().W(String.valueOf(R.drawable.pic_shop_man), 24, false);
        }
        if (k.byteLength(dressItemData.getTitle()) > 8) {
            this.j.setText(k.cutString(dressItemData.getTitle(), 8));
        } else {
            this.j.setText(dressItemData.getTitle());
        }
        if (inUse) {
            this.i.setVisibility(0);
            SkinManager.setImageResource(this.i, R.drawable.icon_shop_selected);
        } else {
            this.i.setVisibility(8);
        }
        this.f21280h.W(dressItemData.getPermissionImgUrl(), 10, false);
        this.f21279g.l(dressItemData.getExampleImgUrl());
        this.f21279g.setOnClickListener(new a());
        SkinManager.setBackgroundColor(this.f21278f, R.color.CAM_X0201);
    }

    public final void d() {
        View inflate = LayoutInflater.from(this.f21277e).inflate(R.layout.avatar_pendant_per_item, this);
        this.f21278f = inflate;
        this.f21279g = (HeadPendantView) inflate.findViewById(R.id.avatar_image);
        TbImageView tbImageView = (TbImageView) this.f21278f.findViewById(R.id.permission_icon);
        this.f21280h = tbImageView;
        tbImageView.setDefaultResource(R.drawable.transparent_bg);
        this.f21280h.setDefaultBgResource(R.drawable.transparent_bg);
        this.i = (ImageView) this.f21278f.findViewById(R.id.choosed_icon);
        this.j = (TextView) this.f21278f.findViewById(R.id.text_pendant_name);
        this.f21279g.setHasPendantStyle();
        if (this.f21279g.getHeadView() != null) {
            this.f21279g.getHeadView().setIsRound(true);
            this.f21279g.getHeadView().setDrawBorder(false);
        }
        if (this.f21279g.getPendantView() != null) {
            this.f21279g.getPendantView().setIsRound(true);
            this.f21279g.getPendantView().setDrawBorder(false);
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        this.l = aVar;
    }

    public AvatarPendantPerItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21277e = context;
        d();
    }

    public AvatarPendantPerItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f21277e = context;
        d();
    }
}
