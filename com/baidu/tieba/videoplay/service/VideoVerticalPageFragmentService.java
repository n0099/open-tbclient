package com.baidu.tieba.videoplay.service;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.lm5;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
@Singleton
@Service
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0017H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/videoplay/service/VideoVerticalPageFragmentService;", "Lcom/baidu/tbadk/module/videoplay/IVideoLandingPage;", "()V", "bdUniqueId", "Lcom/baidu/adp/BdUniqueId;", "videoFragment", "Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "getVideoFragment", "()Lcom/baidu/tieba/videoplay/fragment/VideoVerticalPageFragment;", "videoFragment$delegate", "Lkotlin/Lazy;", "fragment", "Lcom/baidu/tbadk/core/BaseFragment;", "getMissionTid", "", "handleActivityResult", "", AiBotChatDispatcher.AI_SINGLE_REQUEST_CODE, "", "resultCode", "data", "Landroid/content/Intent;", "handleBackPress", "", "setPrimary", "isPrimary", "setUniqueId", "uniqueId", "setUserVisibleHint", "isVisibleToUser", "VideoPlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoVerticalPageFragmentService implements lm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public final Lazy b;

    public VideoVerticalPageFragmentService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<VideoVerticalPageFragment>(this) { // from class: com.baidu.tieba.videoplay.service.VideoVerticalPageFragmentService$videoFragment$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ VideoVerticalPageFragmentService this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoVerticalPageFragment invoke() {
                InterceptResult invokeV;
                BdUniqueId bdUniqueId;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (VideoVerticalPageFragment) invokeV.objValue;
                }
                bdUniqueId = this.this$0.a;
                return new VideoVerticalPageFragment(bdUniqueId, null, 0, 5, 6, null);
            }
        });
    }

    @Override // com.baidu.tieba.lm5
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return b().E();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lm5
    public BaseFragment F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return b();
        }
        return (BaseFragment) invokeV.objValue;
    }

    public final VideoVerticalPageFragment b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (VideoVerticalPageFragment) this.b.getValue();
        }
        return (VideoVerticalPageFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lm5
    public long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return b().u();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.lm5
    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            b().setPrimary(z);
        }
    }

    @Override // com.baidu.tieba.lm5
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.lm5
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            b().setUserVisibleHint(z);
        }
    }

    @Override // com.baidu.tieba.lm5
    public void B(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            b().B(i, i2, intent);
        }
    }
}
