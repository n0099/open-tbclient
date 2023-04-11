package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.av6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ApkDetail;
/* loaded from: classes5.dex */
public class li6 implements av6.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv6 a;
        public final /* synthetic */ ItemData b;

        public a(li6 li6Var, vv6 vv6Var, ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li6Var, vv6Var, itemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv6Var;
            this.b = itemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = 2;
                int i2 = 0;
                if (ImageViewerConfig.FROM_CONCERN.equals(this.a.c().b)) {
                    i2 = 2;
                } else {
                    i = 0;
                }
                ItemData itemData = this.b;
                ItemClickJumpUtil.itemClickJump(itemData.forumName, String.valueOf(itemData.itemId), i, Integer.valueOf(i2));
            }
        }
    }

    public li6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.av6.l
    public void a(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof ItemCardView)) {
            ((ItemCardView) viewGroup).G();
        }
    }

    @Override // com.baidu.tieba.av6.e
    @NonNull
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new ItemCardView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.av6.e
    public void update(@NonNull ViewGroup viewGroup, @NonNull vv6 vv6Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, vv6Var) == null) && viewGroup != null && vv6Var != null && vv6Var.a() != null) {
            pw6 a2 = vv6Var.a();
            ItemData itemData = new ItemData();
            itemData.itemId = a2.a;
            itemData.buttonName = a2.h;
            itemData.buttonLink = a2.r;
            itemData.buttonLinkType = 1;
            itemData.pkgName = a2.n;
            itemData.appId = a2.l;
            itemData.mIconUrl = a2.b;
            itemData.mTitle = a2.m;
            itemData.mTags = a2.g;
            itemData.mScore = a2.f;
            itemData.mStar = a2.e;
            itemData.mIconSize = a2.c;
            itemData.forumName = a2.k;
            ApkDetail.Builder builder = new ApkDetail.Builder();
            builder.developer = a2.s;
            builder.publisher = a2.t;
            builder.version = a2.o;
            builder.version_code = Integer.valueOf(a2.p);
            builder.size = String.valueOf(a2.q);
            builder.authority_url = a2.u;
            builder.privacy_url = a2.v;
            builder.pkg_source = Integer.valueOf(a2.w);
            itemData.apkDetail = builder.build(false);
            int i = a2.j;
            if (i != 0) {
                ((ItemCardView) viewGroup).setBackGroundColor(i);
            }
            if (vv6Var.c() != null) {
                str = vv6Var.c().a;
            } else {
                str = "";
            }
            ((ItemCardView) viewGroup).setData(itemData, 13, str);
            if (vv6Var.b()) {
                viewGroup.setOnClickListener(new a(this, vv6Var, itemData));
            } else {
                viewGroup.setClickable(false);
            }
        }
    }
}
