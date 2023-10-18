package com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.subscribe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.mna;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SubscribeSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean j;
    public boolean k;
    public boolean l;
    public c m;
    @Nullable
    public ChatRoomDetail n;
    @NonNull
    public GroupChatFragment o;
    @NonNull
    public GroupChatRepo p;
    public Runnable q;

    /* loaded from: classes6.dex */
    public class b implements GroupChatRepo.Counter.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SubscribeSlice a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.r0();
                    this.a.a.p.a0();
                }
            }
        }

        public b(SubscribeSlice subscribeSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = subscribeSlice;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.Counter.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == TbSingleton.getInstance().getSecond() && !this.a.o.N2().w0() && !this.a.o.N2().q0()) {
                UiUtils.runOnUiThread(new a(this));
            }
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.Counter.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || i != JavaTypesHelper.toInt(TbSingleton.getInstance().getMsgCount(), -1) || this.a.l0()) {
                return;
            }
            this.a.k = true;
            this.a.o.N2().H0();
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.GroupChatRepo.Counter.d
        public void c(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || i != JavaTypesHelper.toInt(TbSingleton.getInstance().getDayCount(), -1) || this.a.n0()) {
                return;
            }
            this.a.l = true;
            this.a.o.N2().H0();
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SubscribeSlice a;

        public a(SubscribeSlice subscribeSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subscribeSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = subscribeSlice;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public SubscribeGuideView b;

        public c() {
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

        public static c a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                c cVar = new c();
                cVar.a = view2;
                cVar.b = (SubscribeGuideView) view2.findViewById(R.id.obfuscated_res_0x7f09231c);
                return cVar;
            }
            return (c) invokeL.objValue;
        }
    }

    public SubscribeSlice(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, GroupChatFragment groupChatFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, groupChatFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
        this.k = false;
        this.l = false;
        this.q = new a(this);
        this.o = groupChatFragment;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            SubscribeGuideView subscribeGuideView = this.m.b;
            if (subscribeGuideView != null) {
                subscribeGuideView.c();
            }
        }
    }

    public void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.m.b.setVisibility(i);
        }
    }

    public final void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            FrameLayout R2 = this.o.R2();
            if (z) {
                R2.setVisibility(0);
            } else {
                R2.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public void a0(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, bundle) == null) {
            super.a0(view2, bundle);
            if (view2 != null) {
                this.m = c.a(view2);
            }
        }
    }

    public void o0(ChatRoomDetail chatRoomDetail, GroupChatRepo groupChatRepo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, chatRoomDetail, groupChatRepo) == null) {
            this.n = chatRoomDetail;
            this.p = groupChatRepo;
            m0();
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice
    public View U(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d090f, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            p0(8);
            q0(true);
            mna.b(this.m.b, 600);
            this.m.b.a();
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            SafeHandler.getInst().removeCallbacks(this.q);
        }
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ChatRoomDetail chatRoomDetail = this.n;
            if (chatRoomDetail != null && chatRoomDetail.getBasicInfo() != null && this.n.getUserInfo() != null) {
                long id = this.n.getBasicInfo().getId();
                int isSubscription = this.n.getUserInfo().getIsSubscription();
                if (id > 0 && isSubscription != 1) {
                    SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                    String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount("key_show_subscribe_guide" + id);
                    long j = sharedPrefHelper.getLong(sharedPrefKeyWithAccount, 0L);
                    if (j > 0 && TimeHelper.isSameDay(j, System.currentTimeMillis())) {
                        return false;
                    }
                    sharedPrefHelper.putLong(sharedPrefKeyWithAccount, System.currentTimeMillis());
                    this.p.Y(new b(this));
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.m.b != null) {
            p0(0);
            q0(true);
            this.j = true;
            String guideTips = TbSingleton.getInstance().getGuideTips();
            if (guideTips != null) {
                this.m.b.d(guideTips);
            }
            SafeHandler.getInst().postDelayed(this.q, 3000L);
            TiebaStatic.log(new StatisticItem("c15256"));
        }
    }
}
