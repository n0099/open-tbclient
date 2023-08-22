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
import com.baidu.tieba.y47;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nq6 implements y47.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b67 a;
        public final /* synthetic */ ItemData b;

        public a(nq6 nq6Var, b67 b67Var, ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nq6Var, b67Var, itemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b67Var;
            this.b = itemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = 1;
                int i2 = 2;
                if (this.a.c() != null) {
                    if (ImageViewerConfig.FROM_CONCERN.equals(this.a.c().b)) {
                        i = 2;
                    } else if ("recommend".equals(this.a.c().b)) {
                        i2 = 1;
                    }
                    ItemData itemData = this.b;
                    ItemClickJumpUtil.itemClickJump(itemData.forumName, String.valueOf(itemData.itemId), i, Integer.valueOf(i2));
                }
                i = 0;
                i2 = 0;
                ItemData itemData2 = this.b;
                ItemClickJumpUtil.itemClickJump(itemData2.forumName, String.valueOf(itemData2.itemId), i, Integer.valueOf(i2));
            }
        }
    }

    public nq6() {
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

    @Override // com.baidu.tieba.y47.r
    public void a(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof ItemCardView)) {
            ((ItemCardView) viewGroup).N();
        }
    }

    @Override // com.baidu.tieba.y47.i
    @NonNull
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new ItemCardView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.y47.i
    public void update(@NonNull ViewGroup viewGroup, @NonNull b67 b67Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, b67Var) == null) && viewGroup != null && b67Var != null && b67Var.a() != null) {
            i87 a2 = b67Var.a();
            ItemData itemData = new ItemData();
            itemData.itemId = a2.a;
            itemData.buttonName = a2.h;
            itemData.buttonLink = a2.i;
            int i = 2;
            itemData.buttonLinkType = 2;
            itemData.mIconUrl = a2.b;
            itemData.mTitle = a2.d;
            itemData.mTags = a2.g;
            itemData.mScore = a2.f;
            itemData.mStar = a2.e;
            itemData.mIconSize = a2.c;
            itemData.forumName = a2.k;
            int i2 = a2.j;
            if (i2 != 0) {
                ((ItemCardView) viewGroup).setBackGroundColor(i2);
            }
            if (b67Var.c() != null) {
                str = b67Var.c().a;
            } else {
                str = "";
            }
            if (b67Var.c() != null) {
                if (!ImageViewerConfig.FROM_CONCERN.equals(b67Var.c().b)) {
                    if ("recommend".equals(b67Var.c().b)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                }
                ((ItemCardView) viewGroup).setPosition(i);
            }
            ItemCardView itemCardView = (ItemCardView) viewGroup;
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setData(itemData, 13, str);
            if (b67Var.b()) {
                viewGroup.setOnClickListener(new a(this, b67Var, itemData));
            } else {
                viewGroup.setClickable(false);
            }
        }
    }
}
