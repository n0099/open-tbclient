package com.baidu.tieba.videoplay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.s0.l4.g;
import c.a.s0.l4.h;
import c.a.s0.l4.i;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.VideoClickTabData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes12.dex */
public class VideoChannelDelegateStatic extends c.a.r0.i0.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageRedDotView a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f50595b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.c.g.a f50596c;

    /* loaded from: classes12.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                ((c.a.r0.i0.d) customResponsedMessage.getData()).a(new VideoChannelDelegateStatic());
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921610 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof VideoClickTabData)) {
                VideoMiddleFragment videoMiddleFragment = new VideoMiddleFragment();
                videoMiddleFragment.setActivityPageUniqueId(BdUniqueId.gen());
                VideoClickTabData videoClickTabData = (VideoClickTabData) customResponsedMessage.getData();
                if (videoClickTabData != null) {
                    videoMiddleFragment.setArguments(videoClickTabData.getVideoMiddleBundle());
                }
                videoClickTabData.setMiddleFragment(videoMiddleFragment);
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                VideoChannelDelegateStatic.a(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelDelegateStatic a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoChannelDelegateStatic videoChannelDelegateStatic, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelDelegateStatic, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoChannelDelegateStatic;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.a.e((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelDelegateStatic a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VideoChannelDelegateStatic videoChannelDelegateStatic, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelDelegateStatic, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoChannelDelegateStatic;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RedIcon redIcon;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && (responsedMessage instanceof c.a.r0.i0.f.a)) {
                c.a.r0.i0.f.a aVar = (c.a.r0.i0.f.a) responsedMessage;
                if (aVar.getResData() == null) {
                    return;
                }
                List<RedIcon> dataList = aVar.getDataList();
                if (ListUtils.isEmpty(dataList) || (redIcon = dataList.get(0)) == null || redIcon.type.intValue() != 1) {
                    return;
                }
                TbSingleton.getInstance().setVideoChannelRecommendRedIcon(null);
                TbSingleton.getInstance().setVideoChannelAttentionRedIcon(redIcon);
                this.a.d(redIcon);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1747432175, "Lcom/baidu/tieba/videoplay/fragment/VideoChannelDelegateStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1747432175, "Lcom/baidu/tieba/videoplay/fragment/VideoChannelDelegateStatic;");
                return;
            }
        }
        a aVar = new a(2007002);
        aVar.setPriority(5);
        MessageManager.getInstance().registerListener(aVar);
        b bVar = new b(2921610);
        bVar.setPriority(1);
        MessageManager.getInstance().registerListener(bVar);
        MessageManager.getInstance().registerListener(new c(2001384));
    }

    public VideoChannelDelegateStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static /* synthetic */ int a(int i2) {
        return i2;
    }

    @Override // c.a.r0.i0.b
    public c.a.r0.i0.c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.r0.i0.c cVar = new c.a.r0.i0.c();
            Bundle bundle = new Bundle();
            VideoChannelFragment videoChannelFragment = new VideoChannelFragment();
            videoChannelFragment.setActivityPageUniqueId(BdUniqueId.gen());
            cVar.a = videoChannelFragment;
            videoChannelFragment.setArguments(bundle);
            cVar.f12653e = 22;
            cVar.f12650b = i.video_channel;
            cVar.f12657i = c.a.r0.i0.c.l;
            cVar.f12654f = h.lottie_tab_video_channel;
            cVar.f12656h = c.a.r0.i0.e.c.d().c("channel");
            return cVar;
        }
        return (c.a.r0.i0.c) invokeV.objValue;
    }

    public final void d(@NonNull RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, redIcon) == null) {
            c.a.r0.i0.c cVar = new c.a.r0.i0.c();
            cVar.f12655g = redIcon.image;
            cVar.f12653e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
        }
    }

    public final void e(String str) {
        MessageRedDotView messageRedDotView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (messageRedDotView = this.a) == null) {
            return;
        }
        messageRedDotView.refresh(str, false);
        this.a.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    @Override // c.a.r0.i0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(g.maintab_bottom_indicator, (ViewGroup) null);
            this.a = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            TbFragmentTabIndicator tbFragmentTabIndicator = this.mIndicator;
            aVar.f42363f = tbFragmentTabIndicator;
            aVar.a = this.a;
            tbFragmentTabIndicator.addTipWrapContent("video_msg", aVar);
            this.a.setVisibility(4);
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // c.a.r0.i0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? MainTabActivityConfig.VIDEO_CHANNEL_TAB_AVAILABLE : invokeV.booleanValue;
    }

    @Override // c.a.r0.i0.b
    public void onAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f50595b = new d(this, 2921577);
            this.f50596c = new e(this, CmdConfigHttp.CMD_VIDEO_TAB_RED_ICON, 309708);
            MessageManager.getInstance().registerListener(this.f50596c);
            MessageManager.getInstance().registerListener(this.f50595b);
        }
    }

    @Override // c.a.r0.i0.b
    public void onRemove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onRemove();
            MessageManager.getInstance().unRegisterListener(this.f50596c);
            MessageManager.getInstance().unRegisterListener(this.f50595b);
            if (getFragmentTabStructure() == null || getFragmentTabStructure().a == null) {
                return;
            }
            getFragmentTabStructure().a.onDestroy();
        }
    }
}
