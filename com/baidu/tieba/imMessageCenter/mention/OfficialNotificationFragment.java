package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.r0.b1.m.f;
import d.a.r0.b1.m.h;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
/* loaded from: classes5.dex */
public class OfficialNotificationFragment extends BaseFragment implements NoNetworkView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f17861e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.j1.b.q.b f17862f;

    /* renamed from: g  reason: collision with root package name */
    public OfficialNotificationListModel f17863g;

    /* renamed from: h  reason: collision with root package name */
    public String f17864h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f17865i;
    public e j;
    public h k;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialNotificationFragment f17866a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OfficialNotificationFragment officialNotificationFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialNotificationFragment, Integer.valueOf(i2)};
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
            this.f17866a = officialNotificationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(this.f17866a.getPageContext().getPageActivity(), this.f17866a.k, aVar.f55046a, aVar.f55047b, aVar.f55048c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends f0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f17867a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OfficialNotificationFragment f17868b;

        public b(OfficialNotificationFragment officialNotificationFragment, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialNotificationFragment, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17868b = officialNotificationFragment;
            this.f17867a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.s0.i1.t.d.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.f17867a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialNotificationFragment f17869a;

        public c(OfficialNotificationFragment officialNotificationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialNotificationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17869a = officialNotificationFragment;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.f17869a.f17863g == null || this.f17869a.f17862f == null || k.isEmpty(this.f17869a.f17864h) || this.f17869a.f17863g.getUser() == null || !StringHelper.equals(this.f17869a.f17864h, this.f17869a.f17863g.getUser().getUserId())) {
                return;
            }
            int loadDataMode = this.f17869a.f17863g.getLoadDataMode();
            if (loadDataMode == 1) {
                this.f17869a.f17862f.l(this.f17869a.f17863g.getData());
            } else if (loadDataMode == 2) {
                this.f17869a.f17862f.n(this.f17869a.f17863g.getData());
            } else if (loadDataMode != 3) {
            } else {
                this.f17869a.f17862f.k(this.f17869a.f17863g.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialNotificationFragment f17870e;

        public d(OfficialNotificationFragment officialNotificationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialNotificationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17870e = officialNotificationFragment;
        }

        @Override // d.a.r0.b1.m.h
        public d.a.c.e.k.b<GifView> getGifViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (d.a.c.e.k.b) invokeV.objValue;
        }

        @Override // d.a.r0.b1.m.h
        public d.a.c.e.k.b<ImageView> getImageViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (d.a.c.e.k.b) invokeV.objValue;
        }

        @Override // d.a.r0.b1.m.h
        public ListView getListView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (ListView) invokeV.objValue;
        }

        @Override // d.a.r0.b1.m.h
        public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (d.a.c.e.k.b) invokeV.objValue;
        }

        @Override // d.a.r0.b1.m.h
        public int getRichTextViewId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.a.r0.b1.m.h
        public d.a.c.e.k.b<TextView> getTextViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return null;
            }
            return (d.a.c.e.k.b) invokeV.objValue;
        }

        @Override // d.a.r0.b1.m.h
        public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (d.a.c.e.k.b) invokeV.objValue;
        }

        @Override // d.a.r0.b1.m.h
        public d.a.c.e.k.b<View> getVoiceViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return null;
            }
            return (d.a.c.e.k.b) invokeV.objValue;
        }

        @Override // d.a.r0.b1.m.h
        public void onAtClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
            }
        }

        @Override // d.a.r0.b1.m.h
        public void onLinkButtonClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, context, str) == null) {
            }
        }

        @Override // d.a.r0.b1.m.h
        public void onLinkClicked(Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048586, this, context, str, z) == null) {
                UrlManager.getInstance().dealOneLink(this.f17870e.getPageContext(), new String[]{str});
            }
        }

        @Override // d.a.r0.b1.m.h
        public void onPhoneClicked(Context context, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048587, this, context, str, str2) == null) {
            }
        }

        @Override // d.a.r0.b1.m.h
        public void onSongClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
            }
        }

        @Override // d.a.r0.b1.m.h
        public void onVideoClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, context, str) == null) {
            }
        }

        @Override // d.a.r0.b1.m.h
        public void onVideoP2PClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            }
        }
    }

    public OfficialNotificationFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17865i = new a(this, 2001332);
        this.j = new c(this);
        this.k = new d(this);
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            OfficialNotificationListModel officialNotificationListModel = this.f17863g;
            if (officialNotificationListModel == null || officialNotificationListModel.getData() == null) {
                return true;
            }
            return this.f17863g.getData().getIsNewAdd();
        }
        return invokeV.booleanValue;
    }

    public boolean K0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.f17864h = d.a.r0.s.d.b.g0().D();
            OfficialNotificationListModel officialNotificationListModel = new OfficialNotificationListModel(this.f17861e);
            this.f17863g = officialNotificationListModel;
            officialNotificationListModel.setLoadDataCallBack(this.j);
            if (bundle != null) {
                M0(bundle);
                return true;
            }
            L0();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void L0() {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (officialNotificationListModel = this.f17863g) == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        O0();
    }

    public void M0(Bundle bundle) {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) || (officialNotificationListModel = this.f17863g) == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        P0(bundle);
    }

    public void N0() {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (officialNotificationListModel = this.f17863g) == null) {
            return;
        }
        officialNotificationListModel.loadPrepage();
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || k.isEmpty(this.f17864h) || this.f17861e == null || this.f17863g == null) {
            return;
        }
        UserData userData = new UserData(Long.parseLong(this.f17864h), this.f17861e.getString(R.string.system_message), null, 0);
        Q0(userData);
        this.f17863g.setUser(userData);
    }

    public void P0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) || bundle == null || bundle.getString("user") == null) {
            return;
        }
        UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
        Q0(userData);
        this.f17863g.setUser(userData);
    }

    public void Q0(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, userData) == null) {
            i0.c(new b(this, userData), null);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.s0.j1.b.q.b bVar = this.f17862f;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            super.onClick(view);
            int id = view.getId();
            if ((id == R.id.iv_head || id == R.id.tv_user_name) && !k.isEmpty(this.f17864h)) {
                TiebaStatic.log("c12938");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.f17864h))));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            this.f17861e = getPageContext();
            K0(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            d.a.s0.j1.b.q.b bVar = new d.a.s0.j1.b.q.b(this.f17861e, this, viewGroup);
            this.f17862f = bVar;
            OfficialNotificationListModel officialNotificationListModel = this.f17863g;
            if (officialNotificationListModel != null) {
                bVar.f(officialNotificationListModel.getData());
                this.f17863g.loadFirst(null);
            }
            return this.f17862f.i();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            this.f17863g.onDestroy();
            this.f17863g.setLoadDataCallBack(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.f17865i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            registerListener(this.f17865i);
        }
    }
}
