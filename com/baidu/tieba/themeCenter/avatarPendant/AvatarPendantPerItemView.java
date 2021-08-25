package com.baidu.tieba.themeCenter.avatarPendant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.e.e.p.k;
import c.a.q0.o3.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
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
/* loaded from: classes7.dex */
public class AvatarPendantPerItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_TITLE_LENGTH = 8;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f57241e;

    /* renamed from: f  reason: collision with root package name */
    public View f57242f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantView f57243g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f57244h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f57245i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f57246j;
    public DressItemData k;
    public c.a l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AvatarPendantPerItemView f57247e;

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
            this.f57247e = avatarPendantPerItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f57247e.l == null) {
                return;
            }
            if (this.f57247e.k != null && this.f57247e.k.getInUse() && TbadkCoreApplication.isLogin()) {
                return;
            }
            this.f57247e.l.onItemClick(this.f57247e.k);
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
        this.f57241e = context;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f57241e).inflate(R.layout.avatar_pendant_per_item, this);
            this.f57242f = inflate;
            this.f57243g = (HeadPendantView) inflate.findViewById(R.id.avatar_image);
            TbImageView tbImageView = (TbImageView) this.f57242f.findViewById(R.id.permission_icon);
            this.f57244h = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f57244h.setDefaultBgResource(R.drawable.transparent_bg);
            this.f57245i = (ImageView) this.f57242f.findViewById(R.id.choosed_icon);
            this.f57246j = (TextView) this.f57242f.findViewById(R.id.text_pendant_name);
            this.f57243g.setHasPendantStyle();
            if (this.f57243g.getHeadView() != null) {
                this.f57243g.getHeadView().setIsRound(true);
                this.f57243g.getHeadView().setDrawBorder(false);
            }
            if (this.f57243g.getPendantView() != null) {
                this.f57243g.getPendantView().setIsRound(true);
                this.f57243g.getPendantView().setDrawBorder(false);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void fillView(DressItemData dressItemData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dressItemData) == null) || dressItemData == null) {
            return;
        }
        this.k = dressItemData;
        boolean inUse = dressItemData.getInUse();
        if (dressItemData.isPropIdEven()) {
            if (this.f57243g.getHeadView() != null) {
                this.f57243g.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_woman), 24, false);
            }
        } else if (this.f57243g.getHeadView() != null) {
            this.f57243g.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_man), 24, false);
        }
        if (k.byteLength(dressItemData.getTitle()) > 8) {
            this.f57246j.setText(k.cutString(dressItemData.getTitle(), 8));
        } else {
            this.f57246j.setText(dressItemData.getTitle());
        }
        if (inUse) {
            this.f57245i.setVisibility(0);
            SkinManager.setImageResource(this.f57245i, R.drawable.icon_shop_selected);
        } else {
            this.f57245i.setVisibility(8);
        }
        this.f57244h.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
        this.f57243g.startLoadPendantUrl(dressItemData.getExampleImgUrl());
        this.f57243g.setOnClickListener(new a(this));
        SkinManager.setBackgroundColor(this.f57242f, R.color.CAM_X0201);
    }

    public void onChangeSkinType() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = (TbPageContext) j.a(this.f57241e)) == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f57242f);
    }

    public void setAvatarPendantItemClickListener(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
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
        this.f57241e = context;
        c();
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
        this.f57241e = context;
        c();
    }
}
