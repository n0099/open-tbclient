package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.GroupChatBottomSheetController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class pc8 implements tl1<mo5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements mo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public GroupChatBottomSheetController b;

        public a(pc8 pc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.mo5
        public void onChangeSkinType(int i) {
            GroupChatBottomSheetController groupChatBottomSheetController;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (groupChatBottomSheetController = this.b) != null) {
                groupChatBottomSheetController.c0(i);
            }
        }

        @Override // com.baidu.tieba.ro5
        public void a(@NonNull TbPageContext tbPageContext, @Nullable List<Long> list, long j, String str, long j2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, list, Long.valueOf(j), str, Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                GroupChatBottomSheetController groupChatBottomSheetController = this.b;
                if (groupChatBottomSheetController == null) {
                    this.b = new GroupChatBottomSheetController(tbPageContext, j, str, j2, list, z, z2);
                } else {
                    groupChatBottomSheetController.j0(j, str, j2, list, z, z2);
                }
                this.b.l0();
            }
        }

        @Override // com.baidu.tieba.mo5
        public void onDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                GroupChatBottomSheetController groupChatBottomSheetController = this.b;
                if (groupChatBottomSheetController != null) {
                    groupChatBottomSheetController.d0();
                }
                this.b = null;
            }
        }

        @Override // com.baidu.tieba.mo5
        public void onPause() {
            GroupChatBottomSheetController groupChatBottomSheetController;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (groupChatBottomSheetController = this.b) != null) {
                groupChatBottomSheetController.f0();
            }
        }

        @Override // com.baidu.tieba.mo5
        public void onResume() {
            GroupChatBottomSheetController groupChatBottomSheetController;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (groupChatBottomSheetController = this.b) != null) {
                groupChatBottomSheetController.g0();
            }
        }
    }

    public pc8() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tl1
    /* renamed from: a */
    public mo5 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (mo5) invokeV.objValue;
    }
}
