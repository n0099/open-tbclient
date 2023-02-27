package com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.yun.YunDialogDataManager;
import com.baidu.tbadk.core.dialog.yun.YunTask;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.FallingData;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect.ChatEggRainData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.o25;
import com.baidu.tieba.qt7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class EffectSlice extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FallingSlice i;
    @NonNull
    public final o25 j;
    public b k;
    @Nullable
    public ChatRoomDetail l;

    /* loaded from: classes4.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatEggRainData.EggRain e;
        public final /* synthetic */ int f;
        public final /* synthetic */ long g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ EffectSlice i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EffectSlice effectSlice, ChatEggRainData.EggRain eggRain, int i, long j, boolean z) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {effectSlice, eggRain, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = effectSlice;
            this.e = eggRain;
            this.f = i;
            this.g = j;
            this.h = z;
        }

        @Override // com.baidu.tbadk.core.dialog.yun.YunTask
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.i.i.K(this.i.D(this.e, this.f), this.g, this.h, this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public b() {
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

        public static b a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
                b bVar = new b();
                bVar.a = view2;
                return bVar;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class c extends YunTask implements qt7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.tieba.qt7
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d();
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public EffectSlice(@NonNull TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new o25(YunDialogDataManager.j().l());
        this.i = new FallingSlice(tbPageContext);
    }

    public void K(ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chatRoomDetail) == null) {
            this.l = chatRoomDetail;
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a((ViewGroup) this.k.a, this.i);
        }
    }

    @NonNull
    public FallingData D(ChatEggRainData.EggRain eggRain, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eggRain, i)) == null) {
            return new FallingData(eggRain.getPic(), eggRain.getPicClick(), eggRain.getJumpLink(), eggRain.getTitle(), i, eggRain.getAffectContent());
        }
        return (FallingData) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    public void w(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, bundle) == null) {
            super.w(view2, bundle);
            if (view2 != null) {
                this.k = b.a(view2);
            }
            C();
        }
    }

    public void E(@NonNull ChatEggRainData.EggRain eggRain, int i, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eggRain, Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            a aVar = new a(this, eggRain, i, j, z);
            aVar.j(eggRain.getAffectContent());
            aVar.k(eggRain.getWeight());
            aVar.l(YunTask.Type.ENQUEUE);
            this.j.a(aVar);
        }
    }

    public void G(@NonNull String str, long j, boolean z) {
        ChatRoomDetail chatRoomDetail;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)}) == null) && (chatRoomDetail = this.l) != null && chatRoomDetail.getGroupChatResource() != null && this.l.getGroupChatResource().getEggRainData() != null && this.l.getGroupChatResource().getEggRainData().getEggRainList() != null && this.l.getChatConf() != null && !ListUtils.isEmpty(this.l.getGroupChatResource().getEggRainData().getEggRainList())) {
            int resourceMaxTimeDelay = this.l.getChatConf().getResourceMaxTimeDelay() * 1000;
            List<ChatEggRainData.EggRain> eggRainList = this.l.getGroupChatResource().getEggRainData().getEggRainList();
            for (int i = 0; i < eggRainList.size(); i++) {
                ChatEggRainData.EggRain eggRain = eggRainList.get(i);
                if (eggRain != null && !StringUtils.isNull(eggRain.getAffectContent()) && !StringUtils.isNull(eggRain.getPic()) && str.contains(eggRain.getAffectContent()) && eggRain.getCanUse()) {
                    E(eggRain, resourceMaxTimeDelay, j, z);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice
    @Nullable
    public View l(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            return layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0827, viewGroup, false);
        }
        return (View) invokeLLL.objValue;
    }
}
