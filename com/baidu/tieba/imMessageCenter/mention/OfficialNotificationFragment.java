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
import c.a.d.a.e;
import c.a.d.f.p.m;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.o0.e1.n.f;
import c.a.o0.e1.n.i;
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
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class OfficialNotificationFragment extends BaseFragment implements NoNetworkView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.v1.b.q.b f34051b;

    /* renamed from: c  reason: collision with root package name */
    public OfficialNotificationListModel f34052c;

    /* renamed from: d  reason: collision with root package name */
    public String f34053d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f34054e;

    /* renamed from: f  reason: collision with root package name */
    public e f34055f;

    /* renamed from: g  reason: collision with root package name */
    public i f34056g;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialNotificationFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OfficialNotificationFragment officialNotificationFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialNotificationFragment, Integer.valueOf(i)};
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
            this.a = officialNotificationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(this.a.getPageContext().getPageActivity(), this.a.f34056g, aVar.a, aVar.f10185b, aVar.f10186c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends k0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OfficialNotificationFragment f34057b;

        public b(OfficialNotificationFragment officialNotificationFragment, UserData userData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialNotificationFragment, userData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34057b = officialNotificationFragment;
            this.a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.p0.u1.t.d.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialNotificationFragment a;

        public c(OfficialNotificationFragment officialNotificationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialNotificationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialNotificationFragment;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.a.f34052c == null || this.a.f34051b == null || m.isEmpty(this.a.f34053d) || this.a.f34052c.getUser() == null || !StringHelper.equals(this.a.f34053d, this.a.f34052c.getUser().getUserId())) {
                return;
            }
            int loadDataMode = this.a.f34052c.getLoadDataMode();
            if (loadDataMode == 1) {
                this.a.f34051b.l(this.a.f34052c.getData());
            } else if (loadDataMode == 2) {
                this.a.f34051b.n(this.a.f34052c.getData());
            } else if (loadDataMode != 3) {
            } else {
                this.a.f34051b.k(this.a.f34052c.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialNotificationFragment a;

        public d(OfficialNotificationFragment officialNotificationFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialNotificationFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialNotificationFragment;
        }

        @Override // c.a.o0.e1.n.i
        public c.a.d.f.k.b<GifView> getGifViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.o0.e1.n.i
        public c.a.d.f.k.b<ImageView> getImageViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.o0.e1.n.i
        public c.a.d.f.k.b<ItemCardView> getItemCardViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.o0.e1.n.i
        public ListView getListView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (ListView) invokeV.objValue;
        }

        @Override // c.a.o0.e1.n.i
        public c.a.d.f.k.b<RelativeLayout> getRelativeLayoutPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.o0.e1.n.i
        public int getRichTextViewId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.o0.e1.n.i
        public c.a.d.f.k.b<TextView> getTextViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.o0.e1.n.i
        public c.a.d.f.k.b<LinearLayout> getTextVoiceViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.o0.e1.n.i
        public c.a.d.f.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.o0.e1.n.i
        public c.a.d.f.k.b<View> getVoiceViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.o0.e1.n.i
        public void onAtClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            }
        }

        @Override // c.a.o0.e1.n.i
        public void onLinkButtonClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
            }
        }

        @Override // c.a.o0.e1.n.i
        public void onLinkClicked(Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048588, this, context, str, z) == null) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
        }

        @Override // c.a.o0.e1.n.i
        public void onPhoneClicked(Context context, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, context, str, str2) == null) {
            }
        }

        @Override // c.a.o0.e1.n.i
        public void onSongClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            }
        }

        @Override // c.a.o0.e1.n.i
        public void onVideoClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) {
            }
        }

        @Override // c.a.o0.e1.n.i
        public void onVideoP2PClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048592, this, context, str) == null) {
            }
        }
    }

    public OfficialNotificationFragment() {
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
        this.f34054e = new a(this, 2001332);
        this.f34055f = new c(this);
        this.f34056g = new d(this);
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            OfficialNotificationListModel officialNotificationListModel = this.f34052c;
            if (officialNotificationListModel == null || officialNotificationListModel.getData() == null) {
                return true;
            }
            return this.f34052c.getData().getIsNewAdd();
        }
        return invokeV.booleanValue;
    }

    public boolean G0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.f34053d = c.a.o0.s.d.b.g0().D();
            OfficialNotificationListModel officialNotificationListModel = new OfficialNotificationListModel(this.a);
            this.f34052c = officialNotificationListModel;
            officialNotificationListModel.setLoadDataCallBack(this.f34055f);
            if (bundle != null) {
                I0(bundle);
                return true;
            }
            H0();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void H0() {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (officialNotificationListModel = this.f34052c) == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        K0();
    }

    public void I0(Bundle bundle) {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) || (officialNotificationListModel = this.f34052c) == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        L0(bundle);
    }

    public void J0() {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (officialNotificationListModel = this.f34052c) == null) {
            return;
        }
        officialNotificationListModel.loadPrepage();
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || m.isEmpty(this.f34053d) || this.a == null || this.f34052c == null) {
            return;
        }
        UserData userData = new UserData(Long.parseLong(this.f34053d), this.a.getString(R.string.obfuscated_res_0x7f0f1311), null, 0);
        M0(userData);
        this.f34052c.setUser(userData);
    }

    public void L0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) || bundle == null || bundle.getString("user") == null) {
            return;
        }
        UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
        M0(userData);
        this.f34052c.setUser(userData);
    }

    public void M0(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, userData) == null) {
            n0.c(new b(this, userData), null);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            c.a.p0.v1.b.q.b bVar = this.f34051b;
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
            if ((id == R.id.obfuscated_res_0x7f090fd6 || id == R.id.obfuscated_res_0x7f092229) && !m.isEmpty(this.f34053d)) {
                TiebaStatic.log("c12938");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.f34053d))));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = getPageContext();
            G0(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.p0.v1.b.q.b bVar = new c.a.p0.v1.b.q.b(this.a, this, viewGroup);
            this.f34051b = bVar;
            OfficialNotificationListModel officialNotificationListModel = this.f34052c;
            if (officialNotificationListModel != null) {
                bVar.f(officialNotificationListModel.getData());
                this.f34052c.loadFirst(null);
            }
            return this.f34051b.i();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            this.f34052c.onDestroy();
            this.f34052c.setLoadDataCallBack(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.f34054e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            registerListener(this.f34054e);
        }
    }
}
