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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.l95;
import com.baidu.tieba.m95;
import com.baidu.tieba.n95;
import com.baidu.tieba.o95;
import com.baidu.tieba.pb;
import com.baidu.tieba.r95;
import com.baidu.tieba.s95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.VideoRedIcon.RedIcon;
/* loaded from: classes6.dex */
public class VideoChannelDelegateStatic extends l95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MessageRedDotView c;
    public CustomMessageListener d;
    public pb e;

    /* loaded from: classes6.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                ((n95) customResponsedMessage.getData()).a(new VideoChannelDelegateStatic());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                VideoChannelDelegateStatic.g(((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements o95.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public c(VideoChannelDelegateStatic videoChannelDelegateStatic, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelDelegateStatic, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tieba.o95.a
        public Object build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LayoutInflater.from(this.a).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null) : invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelDelegateStatic a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoChannelDelegateStatic videoChannelDelegateStatic, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelDelegateStatic, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.k((String) customResponsedMessage.getData());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoChannelDelegateStatic a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(VideoChannelDelegateStatic videoChannelDelegateStatic, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoChannelDelegateStatic, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoChannelDelegateStatic;
        }

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RedIcon redIcon;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && (responsedMessage instanceof s95)) {
                s95 s95Var = (s95) responsedMessage;
                if (s95Var.getResData() == null) {
                    return;
                }
                List<RedIcon> dataList = s95Var.getDataList();
                if (ListUtils.isEmpty(dataList) || (redIcon = dataList.get(0)) == null || redIcon.type.intValue() != 1) {
                    return;
                }
                TbSingleton.getInstance().setVideoChannelRecommendRedIcon(null);
                TbSingleton.getInstance().setVideoChannelAttentionRedIcon(redIcon);
                this.a.j(redIcon);
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
        if (!UbsABTestHelper.isMainTabShowA()) {
            MessageManager.getInstance().registerListener(aVar);
        }
        MessageManager.getInstance().registerListener(new b(2001384));
    }

    public VideoChannelDelegateStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static /* synthetic */ int g(int i) {
        return i;
    }

    @Override // com.baidu.tieba.l95
    public m95 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            m95 m95Var = new m95();
            Bundle bundle = new Bundle();
            VideoChannelFragment videoChannelFragment = new VideoChannelFragment();
            videoChannelFragment.R1(BdUniqueId.gen());
            m95Var.a = videoChannelFragment;
            videoChannelFragment.setArguments(bundle);
            m95Var.e = 22;
            m95Var.b = R.string.obfuscated_res_0x7f0f1530;
            m95Var.i = m95.l;
            m95Var.f = R.raw.lottie_tab_video_channel;
            m95Var.h = r95.d().c("channel");
            return m95Var;
        }
        return (m95) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l95
    public TbFragmentTabIndicator c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.b = (MaintabBottomIndicator) o95.e().d(1003, new c(this, context));
            this.c = new MessageRedDotView(context);
            TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
            TbFragmentTabIndicator tbFragmentTabIndicator = this.b;
            aVar.f = tbFragmentTabIndicator;
            aVar.a = this.c;
            tbFragmentTabIndicator.b("video_msg", aVar);
            this.c.setVisibility(4);
            return this.b;
        }
        return (TbFragmentTabIndicator) invokeL.objValue;
    }

    @Override // com.baidu.tieba.l95
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? MainTabActivityConfig.VIDEO_CHANNEL_TAB_AVAILABLE : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l95
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d = new d(this, 2921577);
            this.e = new e(this, CmdConfigHttp.CMD_VIDEO_TAB_RED_ICON, 309708);
            MessageManager.getInstance().registerListener(this.e);
            MessageManager.getInstance().registerListener(this.d);
        }
    }

    @Override // com.baidu.tieba.l95
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.f();
            MessageManager.getInstance().unRegisterListener(this.e);
            MessageManager.getInstance().unRegisterListener(this.d);
            if (b() == null || b().a == null) {
                return;
            }
            b().a.onDestroy();
        }
    }

    public final void j(@NonNull RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, redIcon) == null) {
            m95 m95Var = new m95();
            m95Var.g = redIcon.image;
            m95Var.e = 22;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921492, m95Var));
        }
    }

    public final void k(String str) {
        MessageRedDotView messageRedDotView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (messageRedDotView = this.c) == null) {
            return;
        }
        messageRedDotView.g(str, false);
        this.c.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
    }
}
