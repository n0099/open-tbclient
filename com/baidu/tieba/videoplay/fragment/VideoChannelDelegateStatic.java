package com.baidu.tieba.videoplay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes7.dex */
public class VideoChannelDelegateStatic extends c.a.q0.h0.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static int f57996d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MessageRedDotView f57997a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f57998b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e.c.g.a f57999c;

    /* loaded from: classes7.dex */
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
                ((c.a.q0.h0.d) customResponsedMessage.getData()).a(new VideoChannelDelegateStatic());
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
                int unused = VideoChannelDelegateStatic.f57996d = ((Integer) customResponsedMessage.getData()).intValue();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelDelegateStatic f58000a;

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
            this.f58000a = videoChannelDelegateStatic;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                this.f58000a.f((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoChannelDelegateStatic f58001a;

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
            this.f58001a = videoChannelDelegateStatic;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RedIcon redIcon;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && (responsedMessage instanceof c.a.q0.h0.f.a)) {
                c.a.q0.h0.f.a aVar = (c.a.q0.h0.f.a) responsedMessage;
                if (aVar.getResData() == null) {
                    return;
                }
                List<RedIcon> dataList = aVar.getDataList();
                if (ListUtils.isEmpty(dataList) || (redIcon = dataList.get(0)) == null) {
                    return;
                }
                if (redIcon.type.intValue() == 1) {
                    TbSingleton.getInstance().setVideoChannelRecommendRedIcon(null);
                    TbSingleton.getInstance().setVideoChannelAttentionRedIcon(redIcon);
                    this.f58001a.e(redIcon);
                } else if (TbSingleton.getInstance().getVideoChannelAttentionRedIcon() != null || VideoChannelDelegateStatic.f57996d == 2) {
                } else {
                    TbSingleton.getInstance().setVideoChannelRecommendRedIcon(redIcon);
                    this.f58001a.e(redIcon);
                }
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

    @Override // c.a.q0.h0.b
    public c.a.q0.h0.c createFragmentTabStructure() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.q0.h0.c cVar = new c.a.q0.h0.c();
            Bundle bundle = new Bundle();
            VideoChannelFragment videoChannelFragment = new VideoChannelFragment();
            videoChannelFragment.setActivityPageUniqueId(BdUniqueId.gen());
            cVar.f13467a = videoChannelFragment;
            videoChannelFragment.setArguments(bundle);
            cVar.f13471e = 22;
            cVar.f13468b = R.string.video_channel;
            cVar.f13475i = c.a.q0.h0.c.l;
            cVar.f13472f = R.raw.lottie_tab_video_channel;
            cVar.f13474h = c.a.q0.h0.e.c.d().c("channel");
            return cVar;
        }
        return (c.a.q0.h0.c) invokeV.objValue;
    }

    public final void e(@NonNull RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, redIcon) == null) {
            c.a.q0.h0.c cVar = new c.a.q0.h0.c();
            cVar.f13473g = redIcon.image;
            cVar.f13471e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, cVar));
        }
    }

    public final void f(String str) {
        MessageRedDotView messageRedDotView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (messageRedDotView = this.f57997a) == null) {
            return;
        }
        messageRedDotView.refresh(str, false);
        this.f57997a.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }

    @Override // c.a.q0.h0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
            this.f57997a = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            TbFragmentTabIndicator tbFragmentTabIndicator = this.mIndicator;
            aVar.f48418f = tbFragmentTabIndicator;
            aVar.f48413a = this.f57997a;
            tbFragmentTabIndicator.addTipWrapContent("video_msg", aVar);
            this.f57997a.setVisibility(4);
            return this.mIndicator;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // c.a.q0.h0.b
    public boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? MainTabActivityConfig.VIDEO_CHANNEL_TAB_AVAILABLE : invokeV.booleanValue;
    }

    @Override // c.a.q0.h0.b
    public void onAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f57998b = new d(this, 2921577);
            this.f57999c = new e(this, CmdConfigHttp.CMD_VIDEO_TAB_RED_ICON, 309708);
            MessageManager.getInstance().registerListener(this.f57999c);
            MessageManager.getInstance().registerListener(this.f57998b);
        }
    }

    @Override // c.a.q0.h0.b
    public void onRemove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onRemove();
            MessageManager.getInstance().unRegisterListener(this.f57999c);
            MessageManager.getInstance().unRegisterListener(this.f57998b);
            if (getFragmentTabStructure() == null || getFragmentTabStructure().f13467a == null) {
                return;
            }
            getFragmentTabStructure().f13467a.onDestroy();
        }
    }
}
