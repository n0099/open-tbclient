package com.baidu.tieba.themeCenter.avatarPendant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.p0.f4.d.c;
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
/* loaded from: classes6.dex */
public class AvatarPendantPerItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f36298b;

    /* renamed from: c  reason: collision with root package name */
    public HeadPendantView f36299c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f36300d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f36301e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f36302f;

    /* renamed from: g  reason: collision with root package name */
    public DressItemData f36303g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f36304h;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AvatarPendantPerItemView a;

        public a(AvatarPendantPerItemView avatarPendantPerItemView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {avatarPendantPerItemView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = avatarPendantPerItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.a.f36304h == null) {
                return;
            }
            if (this.a.f36303g != null && this.a.f36303g.getInUse() && TbadkCoreApplication.isLogin()) {
                return;
            }
            this.a.f36304h.onItemClick(this.a.f36303g);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        d();
    }

    @SuppressLint({"ResourceAsColor"})
    public void c(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        this.f36303g = dressItemData;
        boolean inUse = dressItemData.getInUse();
        if (dressItemData.isPropIdEven()) {
            if (this.f36299c.getHeadView() != null) {
                this.f36299c.getHeadView().J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080f50), 24, false);
            }
        } else if (this.f36299c.getHeadView() != null) {
            this.f36299c.getHeadView().J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080f4f), 24, false);
        }
        if (m.byteLength(dressItemData.getTitle()) > 8) {
            this.f36302f.setText(m.cutString(dressItemData.getTitle(), 8));
        } else {
            this.f36302f.setText(dressItemData.getTitle());
        }
        if (inUse) {
            this.f36301e.setVisibility(0);
            SkinManager.setImageResource(this.f36301e, R.drawable.icon_shop_selected);
        } else {
            this.f36301e.setVisibility(8);
        }
        this.f36300d.J(dressItemData.getPermissionImgUrl(), 10, false);
        this.f36299c.m(dressItemData.getExampleImgUrl());
        this.f36299c.setOnClickListener(new a(this));
        SkinManager.setBackgroundColor(this.f36298b, R.color.CAM_X0201);
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d012c, this);
            this.f36298b = inflate;
            this.f36299c = (HeadPendantView) inflate.findViewById(R.id.obfuscated_res_0x7f0902e7);
            TbImageView tbImageView = (TbImageView) this.f36298b.findViewById(R.id.obfuscated_res_0x7f09176d);
            this.f36300d = tbImageView;
            tbImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36300d.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            this.f36301e = (ImageView) this.f36298b.findViewById(R.id.obfuscated_res_0x7f090615);
            this.f36302f = (TextView) this.f36298b.findViewById(R.id.obfuscated_res_0x7f091f46);
            this.f36299c.setHasPendantStyle();
            if (this.f36299c.getHeadView() != null) {
                this.f36299c.getHeadView().setIsRound(true);
                this.f36299c.getHeadView().setDrawBorder(false);
            }
            if (this.f36299c.getPendantView() != null) {
                this.f36299c.getPendantView().setIsRound(true);
                this.f36299c.getPendantView().setDrawBorder(false);
            }
        }
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f36304h = aVar;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarPendantPerItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = context;
        d();
    }
}
