package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.pb.main.PbVideoDetailBrowseModeEmotionHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class nm8 extends bl8<zi8, PbVideoDetailBrowseModeEmotionHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm8(wp8 activity, BdUniqueId mType) {
        super(activity, mType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, mType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((wp8) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mType, "mType");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: u */
    public PbVideoDetailBrowseModeEmotionHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View view2 = LayoutInflater.from(this.mContext).inflate(R.layout.video_detail_pb_browse_mode_emotion, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return new PbVideoDetailBrowseModeEmotionHolder(view2);
        }
        return (PbVideoDetailBrowseModeEmotionHolder) invokeL.objValue;
    }

    public final void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.g = onClickListener;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: x */
    public void onFillViewHolder(int i, ViewGroup viewGroup, PbVideoDetailBrowseModeEmotionHolder pbVideoDetailBrowseModeEmotionHolder, zi8 zi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), viewGroup, pbVideoDetailBrowseModeEmotionHolder, zi8Var}) == null) {
            super.onFillViewHolder(i, viewGroup, pbVideoDetailBrowseModeEmotionHolder, zi8Var);
            if (pbVideoDetailBrowseModeEmotionHolder != null) {
                pbVideoDetailBrowseModeEmotionHolder.a();
                pbVideoDetailBrowseModeEmotionHolder.b(this.g);
            }
        }
    }
}
