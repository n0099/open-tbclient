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
import com.baidu.tieba.c67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rr6 implements c67.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f77 a;
        public final /* synthetic */ ItemData b;

        public a(rr6 rr6Var, f77 f77Var, ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rr6Var, f77Var, itemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f77Var;
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

    public rr6() {
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

    @Override // com.baidu.tieba.c67.s
    public void a(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof ItemCardView)) {
            ((ItemCardView) viewGroup).M();
        }
    }

    @Override // com.baidu.tieba.c67.j
    @NonNull
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new ItemCardView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.c67.j
    public void update(@NonNull ViewGroup viewGroup, @NonNull f77 f77Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, f77Var) == null) && viewGroup != null && f77Var != null && f77Var.a() != null) {
            n97 a2 = f77Var.a();
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
            if (f77Var.c() != null) {
                str = f77Var.c().a;
            } else {
                str = "";
            }
            if (f77Var.c() != null) {
                if (!ImageViewerConfig.FROM_CONCERN.equals(f77Var.c().b)) {
                    if ("recommend".equals(f77Var.c().b)) {
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
            if (f77Var.b()) {
                viewGroup.setOnClickListener(new a(this, f77Var, itemData));
            } else {
                viewGroup.setClickable(false);
            }
        }
    }
}
