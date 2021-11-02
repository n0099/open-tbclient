package com.baidu.tieba.themeCenter.avatarPendant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.a.j;
import b.a.e.e.p.k;
import b.a.r0.r3.d.c;
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
/* loaded from: classes9.dex */
public class AvatarPendantPerItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_TITLE_LENGTH = 8;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f54510e;

    /* renamed from: f  reason: collision with root package name */
    public View f54511f;

    /* renamed from: g  reason: collision with root package name */
    public HeadPendantView f54512g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f54513h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f54514i;
    public TextView j;
    public DressItemData k;
    public c.a l;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AvatarPendantPerItemView f54515e;

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
            this.f54515e = avatarPendantPerItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f54515e.l == null) {
                return;
            }
            if (this.f54515e.k != null && this.f54515e.k.getInUse() && TbadkCoreApplication.isLogin()) {
                return;
            }
            this.f54515e.l.onItemClick(this.f54515e.k);
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
        this.f54510e = context;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f54510e).inflate(R.layout.avatar_pendant_per_item, this);
            this.f54511f = inflate;
            this.f54512g = (HeadPendantView) inflate.findViewById(R.id.avatar_image);
            TbImageView tbImageView = (TbImageView) this.f54511f.findViewById(R.id.permission_icon);
            this.f54513h = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f54513h.setDefaultBgResource(R.drawable.transparent_bg);
            this.f54514i = (ImageView) this.f54511f.findViewById(R.id.choosed_icon);
            this.j = (TextView) this.f54511f.findViewById(R.id.text_pendant_name);
            this.f54512g.setHasPendantStyle();
            if (this.f54512g.getHeadView() != null) {
                this.f54512g.getHeadView().setIsRound(true);
                this.f54512g.getHeadView().setDrawBorder(false);
            }
            if (this.f54512g.getPendantView() != null) {
                this.f54512g.getPendantView().setIsRound(true);
                this.f54512g.getPendantView().setDrawBorder(false);
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
            if (this.f54512g.getHeadView() != null) {
                this.f54512g.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_woman), 24, false);
            }
        } else if (this.f54512g.getHeadView() != null) {
            this.f54512g.getHeadView().startLoad(String.valueOf(R.drawable.pic_shop_man), 24, false);
        }
        if (k.byteLength(dressItemData.getTitle()) > 8) {
            this.j.setText(k.cutString(dressItemData.getTitle(), 8));
        } else {
            this.j.setText(dressItemData.getTitle());
        }
        if (inUse) {
            this.f54514i.setVisibility(0);
            SkinManager.setImageResource(this.f54514i, R.drawable.icon_shop_selected);
        } else {
            this.f54514i.setVisibility(8);
        }
        this.f54513h.startLoad(dressItemData.getPermissionImgUrl(), 10, false);
        this.f54512g.startLoadPendantUrl(dressItemData.getExampleImgUrl());
        this.f54512g.setOnClickListener(new a(this));
        SkinManager.setBackgroundColor(this.f54511f, R.color.CAM_X0201);
    }

    public void onChangeSkinType() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = (TbPageContext) j.a(this.f54510e)) == null) {
            return;
        }
        tbPageContext.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        tbPageContext.getLayoutMode().j(this.f54511f);
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
        this.f54510e = context;
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
        this.f54510e = context;
        c();
    }
}
