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
import b.a.e.a.e;
import b.a.e.f.p.k;
import b.a.q0.c1.i0;
import b.a.q0.c1.l0;
import b.a.q0.e1.n.f;
import b.a.q0.e1.n.i;
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
/* loaded from: classes9.dex */
public class OfficialNotificationFragment extends BaseFragment implements NoNetworkView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f51719e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.m1.b.q.b f51720f;

    /* renamed from: g  reason: collision with root package name */
    public OfficialNotificationListModel f51721g;

    /* renamed from: h  reason: collision with root package name */
    public String f51722h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f51723i;
    public i j;
    public e mMsgCallback;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialNotificationFragment f51724a;

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
            this.f51724a = officialNotificationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(this.f51724a.getPageContext().getPageActivity(), this.f51724a.j, aVar.f13146a, aVar.f13147b, aVar.f13148c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends i0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserData f51725a;

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
            this.f51725a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.r0.l1.t.d.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.f51725a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialNotificationFragment f51726a;

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
            this.f51726a = officialNotificationFragment;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.f51726a.f51721g == null || this.f51726a.f51720f == null || k.isEmpty(this.f51726a.f51722h) || this.f51726a.f51721g.getUser() == null || !StringHelper.equals(this.f51726a.f51722h, this.f51726a.f51721g.getUser().getUserId())) {
                return;
            }
            int loadDataMode = this.f51726a.f51721g.getLoadDataMode();
            if (loadDataMode == 1) {
                this.f51726a.f51720f.l(this.f51726a.f51721g.getData());
            } else if (loadDataMode == 2) {
                this.f51726a.f51720f.n(this.f51726a.f51721g.getData());
            } else if (loadDataMode != 3) {
            } else {
                this.f51726a.f51720f.k(this.f51726a.f51721g.getData());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialNotificationFragment f51727e;

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
            this.f51727e = officialNotificationFragment;
        }

        @Override // b.a.q0.e1.n.i
        public b.a.e.f.k.b<GifView> getGifViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (b.a.e.f.k.b) invokeV.objValue;
        }

        @Override // b.a.q0.e1.n.i
        public b.a.e.f.k.b<ImageView> getImageViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (b.a.e.f.k.b) invokeV.objValue;
        }

        @Override // b.a.q0.e1.n.i
        public b.a.e.f.k.b<ItemCardView> getItemCardViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (b.a.e.f.k.b) invokeV.objValue;
        }

        @Override // b.a.q0.e1.n.i
        public ListView getListView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (ListView) invokeV.objValue;
        }

        @Override // b.a.q0.e1.n.i
        public b.a.e.f.k.b<RelativeLayout> getRelativeLayoutPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (b.a.e.f.k.b) invokeV.objValue;
        }

        @Override // b.a.q0.e1.n.i
        public int getRichTextViewId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // b.a.q0.e1.n.i
        public b.a.e.f.k.b<TextView> getTextViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (b.a.e.f.k.b) invokeV.objValue;
        }

        @Override // b.a.q0.e1.n.i
        public b.a.e.f.k.b<LinearLayout> getTextVoiceViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return null;
            }
            return (b.a.e.f.k.b) invokeV.objValue;
        }

        @Override // b.a.q0.e1.n.i
        public b.a.e.f.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return (b.a.e.f.k.b) invokeV.objValue;
        }

        @Override // b.a.q0.e1.n.i
        public b.a.e.f.k.b<View> getVoiceViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (b.a.e.f.k.b) invokeV.objValue;
        }

        @Override // b.a.q0.e1.n.i
        public void onAtClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            }
        }

        @Override // b.a.q0.e1.n.i
        public void onLinkButtonClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
            }
        }

        @Override // b.a.q0.e1.n.i
        public void onLinkClicked(Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048588, this, context, str, z) == null) {
                UrlManager.getInstance().dealOneLink(this.f51727e.getPageContext(), new String[]{str});
            }
        }

        @Override // b.a.q0.e1.n.i
        public void onPhoneClicked(Context context, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, context, str, str2) == null) {
            }
        }

        @Override // b.a.q0.e1.n.i
        public void onSongClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            }
        }

        @Override // b.a.q0.e1.n.i
        public void onVideoClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) {
            }
        }

        @Override // b.a.q0.e1.n.i
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51723i = new a(this, 2001332);
        this.mMsgCallback = new c(this);
        this.j = new d(this);
    }

    public boolean getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            OfficialNotificationListModel officialNotificationListModel = this.f51721g;
            if (officialNotificationListModel == null || officialNotificationListModel.getData() == null) {
                return true;
            }
            return this.f51721g.getData().getIsNewAdd();
        }
        return invokeV.booleanValue;
    }

    public boolean initData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.f51722h = b.a.q0.t.d.b.g0().D();
            OfficialNotificationListModel officialNotificationListModel = new OfficialNotificationListModel(this.f51719e);
            this.f51721g = officialNotificationListModel;
            officialNotificationListModel.setLoadDataCallBack(this.mMsgCallback);
            if (bundle != null) {
                initParam(bundle);
                return true;
            }
            initParam();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void initParam(Bundle bundle) {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) || (officialNotificationListModel = this.f51721g) == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        onInitParam(bundle);
    }

    public void loadNextPage() {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (officialNotificationListModel = this.f51721g) == null) {
            return;
        }
        officialNotificationListModel.loadPrepage();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            b.a.r0.m1.b.q.b bVar = this.f51720f;
            if (bVar != null) {
                bVar.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            super.onClick(view);
            int id = view.getId();
            if ((id == R.id.iv_head || id == R.id.tv_user_name) && !k.isEmpty(this.f51722h)) {
                TiebaStatic.log("c12938");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.f51722h))));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            this.f51719e = getPageContext();
            initData(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            b.a.r0.m1.b.q.b bVar = new b.a.r0.m1.b.q.b(this.f51719e, this, viewGroup);
            this.f51720f = bVar;
            OfficialNotificationListModel officialNotificationListModel = this.f51721g;
            if (officialNotificationListModel != null) {
                bVar.f(officialNotificationListModel.getData());
                this.f51721g.loadFirst(null);
            }
            return this.f51720f.i();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            this.f51721g.onDestroy();
            this.f51721g.setLoadDataCallBack(null);
        }
    }

    public void onInitParam(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) || bundle == null || bundle.getString("user") == null) {
            return;
        }
        UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
        saveToUserData(userData);
        this.f51721g.setUser(userData);
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void onNetworkChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.f51723i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            registerListener(this.f51723i);
        }
    }

    public void saveToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, userData) == null) {
            l0.c(new b(this, userData), null);
        }
    }

    public void initParam() {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (officialNotificationListModel = this.f51721g) == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        onInitParam();
    }

    public void onInitParam() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || k.isEmpty(this.f51722h) || this.f51719e == null || this.f51721g == null) {
            return;
        }
        UserData userData = new UserData(Long.parseLong(this.f51722h), this.f51719e.getString(R.string.system_message), null, 0);
        saveToUserData(userData);
        this.f51721g.setUser(userData);
    }
}
