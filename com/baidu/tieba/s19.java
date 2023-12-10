package com.baidu.tieba;

import android.os.Bundle;
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
import java.io.Serializable;
import java.util.List;
/* loaded from: classes8.dex */
public class s19 implements gg1<bm5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements bm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public GroupChatBottomSheetController b;
        @Nullable
        public GroupChatDialogFragment c;

        @Override // com.baidu.tieba.bm5
        public boolean isEnable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        /* renamed from: com.baidu.tieba.s19$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0463a implements s29 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0463a(a aVar) {
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

            @Override // com.baidu.tieba.s29
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                    this.a.c = null;
                }
            }
        }

        public a(s19 s19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.bm5
        public void onChangeSkinType(int i) {
            GroupChatBottomSheetController groupChatBottomSheetController;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (groupChatBottomSheetController = this.b) != null) {
                groupChatBottomSheetController.a(i);
            }
        }

        @Override // com.baidu.tieba.gm5
        public void a(@NonNull TbPageContext tbPageContext, @Nullable List<Long> list, long j, String str, long j2, boolean z, FragmentManager fragmentManager, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, list, Long.valueOf(j), str, Long.valueOf(j2), Boolean.valueOf(z), fragmentManager, str2, str3}) == null) {
                GroupChatDialogFragment groupChatDialogFragment = this.c;
                if (groupChatDialogFragment == null) {
                    this.c = new GroupChatDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putLong("key_group_chat_forum_id", Long.valueOf(j).longValue());
                    bundle.putString("key_group_chat_forum_name", str);
                    bundle.putLong("key_group_chat_room_id", Long.valueOf(j2).longValue());
                    bundle.putSerializable("key_group_chat_hot_list", (Serializable) list);
                    bundle.putBoolean("key_group_chat_followed", z);
                    bundle.putString("key_group_chat_souce", str3);
                    bundle.putBoolean("key_is_dialog", true);
                    this.c.setArguments(bundle);
                    this.c.show(fragmentManager, str3);
                    this.c.Z2(new C0463a(this));
                    return;
                }
                groupChatDialogFragment.Y2(j, str, j2, list, z);
            }
        }

        @Override // com.baidu.tieba.bm5
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

        @Override // com.baidu.tieba.bm5
        public void onPause() {
            GroupChatBottomSheetController groupChatBottomSheetController;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (groupChatBottomSheetController = this.b) != null) {
                groupChatBottomSheetController.c();
            }
        }

        @Override // com.baidu.tieba.bm5
        public void onResume() {
            GroupChatBottomSheetController groupChatBottomSheetController;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (groupChatBottomSheetController = this.b) != null) {
                groupChatBottomSheetController.d();
            }
        }
    }

    public s19() {
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
    @Override // com.baidu.tieba.gg1
    /* renamed from: a */
    public bm5 getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (bm5) invokeV.objValue;
    }
}
