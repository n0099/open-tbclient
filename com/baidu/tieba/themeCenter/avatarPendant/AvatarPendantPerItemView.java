package com.baidu.tieba.themeCenter.avatarPendant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.q0.n3.d.c;
/* loaded from: classes4.dex */
public class AvatarPendantPerItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f21528e;

    /* renamed from: f  reason: collision with root package name */
    public View f21529f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantView f21530g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f21531h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21532i;
    public TextView j;
    public DressItemData k;
    public c.a l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AvatarPendantPerItemView f21533e;

        public a(AvatarPendantPerItemView avatarPendantPerItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {avatarPendantPerItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21533e = avatarPendantPerItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f21533e.l == null) {
                return;
            }
            if (this.f21533e.k != null && this.f21533e.k.getInUse() && TbadkCoreApplication.isLogin()) {
                return;
            }
            this.f21533e.l.onItemClick(this.f21533e.k);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPendantPerItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21528e = context;
        d();
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        this.k = dressItemData;
        boolean inUse = dressItemData.getInUse();
        if (dressItemData.isPropIdEven()) {
            if (this.f21530g.getHeadView() != null) {
                this.f21530g.getHeadView().M(String.valueOf(R.drawable.pic_shop_woman), 24, false);
            }
        } else if (this.f21530g.getHeadView() != null) {
            this.f21530g.getHeadView().M(String.valueOf(R.drawable.pic_shop_man), 24, false);
        }
        if (k.byteLength(dressItemData.getTitle()) > 8) {
            this.j.setText(k.cutString(dressItemData.getTitle(), 8));
        } else {
            this.j.setText(dressItemData.getTitle());
        }
        if (inUse) {
            this.f21532i.setVisibility(0);
            SkinManager.setImageResource(this.f21532i, R.drawable.icon_shop_selected);
        } else {
            this.f21532i.setVisibility(8);
        }
        this.f21531h.M(dressItemData.getPermissionImgUrl(), 10, false);
        this.f21530g.l(dressItemData.getExampleImgUrl());
        this.f21530g.setOnClickListener(new a(this));
        SkinManager.setBackgroundColor(this.f21529f, R.color.CAM_X0201);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.f21528e).inflate(R.layout.avatar_pendant_per_item, this);
            this.f21529f = inflate;
            this.f21530g = (HeadPendantView) inflate.findViewById(R.id.avatar_image);
            TbImageView tbImageView = (TbImageView) this.f21529f.findViewById(R.id.permission_icon);
            this.f21531h = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f21531h.setDefaultBgResource(R.drawable.transparent_bg);
            this.f21532i = (ImageView) this.f21529f.findViewById(R.id.choosed_icon);
            this.j = (TextView) this.f21529f.findViewById(R.id.text_pendant_name);
            this.f21530g.setHasPendantStyle();
            if (this.f21530g.getHeadView() != null) {
                this.f21530g.getHeadView().setIsRound(true);
                this.f21530g.getHeadView().setDrawBorder(false);
            }
            if (this.f21530g.getPendantView() != null) {
                this.f21530g.getPendantView().setIsRound(true);
                this.f21530g.getPendantView().setDrawBorder(false);
            }
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.l = aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPendantPerItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21528e = context;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPendantPerItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f21528e = context;
        d();
    }
}
