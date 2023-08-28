package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.GroupChatBottomSheetController;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.chatdialog.GroupChatDialogFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class nk8 implements yk1<vo5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements vo5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public GroupChatBottomSheetController b;
        @Nullable
        public GroupChatDialogFragment c;

        /* renamed from: com.baidu.tieba.nk8$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0425a implements pl8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0425a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.pl8
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                    this.a.c = null;
                }
            }
        }

        public a(nk8 nk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.vo5
        public void onChangeSkinType(int i) {
            GroupChatBottomSheetController groupChatBottomSheetController;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (groupChatBottomSheetController = this.b) != null) {
                groupChatBottomSheetController.a(i);
            }
        }

        @Override // com.baidu.tieba.ap5
        public void a(@NonNull TbPageContext tbPageContext, @Nullable List<Long> list, long j, String str, long j2, boolean z, FragmentManager fragmentManager, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, list, Long.valueOf(j), str, Long.valueOf(j2), Boolean.valueOf(z), fragmentManager, str2, str3}) == null) {
                GroupChatDialogFragment groupChatDialogFragment = this.c;
                if (groupChatDialogFragment == null) {
                    GroupChatDialogFragment groupChatDialogFragment2 = new GroupChatDialogFragment(j, str, j2, list, z, str2, str3);
                    this.c = groupChatDialogFragment2;
                    groupChatDialogFragment2.show(fragmentManager, str3);
                    this.c.k2(new C0425a(this));
                    return;
                }
                groupChatDialogFragment.j2(j, str, j2, list, z, str2);
            }
        }

        @Override // com.baidu.tieba.vo5
        public boolean isEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return fx8.a();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vo5
        public void onDestroy() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                GroupChatBottomSheetController groupChatBottomSheetController = this.b;
                if (groupChatBottomSheetController != null) {
                    groupChatBottomSheetController.b();
                }
                this.b = null;
            }
        }

        @Override // com.baidu.tieba.vo5
        public void onPause() {
            GroupChatBottomSheetController groupChatBottomSheetController;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (groupChatBottomSheetController = this.b) != null) {
                groupChatBottomSheetController.c();
            }
        }

        @Override // com.baidu.tieba.vo5
        public void onResume() {
            GroupChatBottomSheetController groupChatBottomSheetController;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (groupChatBottomSheetController = this.b) != null) {
                groupChatBottomSheetController.d();
            }
        }
    }

    public nk8() {
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
    @Override // com.baidu.tieba.yk1
    /* renamed from: a */
    public vo5 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (vo5) invokeV.objValue;
    }
}
