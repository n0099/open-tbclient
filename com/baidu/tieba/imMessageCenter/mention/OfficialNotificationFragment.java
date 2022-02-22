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
import c.a.t0.d1.l0;
import c.a.t0.d1.o0;
import c.a.t0.f1.n.f;
import c.a.t0.f1.n.i;
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
/* loaded from: classes12.dex */
public class OfficialNotificationFragment extends BaseFragment implements NoNetworkView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f45467e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.u0.u1.b.q.b f45468f;

    /* renamed from: g  reason: collision with root package name */
    public OfficialNotificationListModel f45469g;

    /* renamed from: h  reason: collision with root package name */
    public String f45470h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f45471i;

    /* renamed from: j  reason: collision with root package name */
    public i f45472j;
    public e mMsgCallback;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialNotificationFragment a;

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
            this.a = officialNotificationFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(this.a.getPageContext().getPageActivity(), this.a.f45472j, aVar.a, aVar.f13044b, aVar.f13045c);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends l0<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OfficialNotificationFragment f45473b;

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
            this.f45473b = officialNotificationFragment;
            this.a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.d1.l0
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c.a.u0.t1.t.d.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.a.f45469g == null || this.a.f45468f == null || m.isEmpty(this.a.f45470h) || this.a.f45469g.getUser() == null || !StringHelper.equals(this.a.f45470h, this.a.f45469g.getUser().getUserId())) {
                return;
            }
            int loadDataMode = this.a.f45469g.getLoadDataMode();
            if (loadDataMode == 1) {
                this.a.f45468f.l(this.a.f45469g.getData());
            } else if (loadDataMode == 2) {
                this.a.f45468f.n(this.a.f45469g.getData());
            } else if (loadDataMode != 3) {
            } else {
                this.a.f45468f.k(this.a.f45469g.getData());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OfficialNotificationFragment f45474e;

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
            this.f45474e = officialNotificationFragment;
        }

        @Override // c.a.t0.f1.n.i
        public c.a.d.f.k.b<GifView> getGifViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.t0.f1.n.i
        public c.a.d.f.k.b<ImageView> getImageViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.t0.f1.n.i
        public c.a.d.f.k.b<ItemCardView> getItemCardViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.t0.f1.n.i
        public ListView getListView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (ListView) invokeV.objValue;
        }

        @Override // c.a.t0.f1.n.i
        public c.a.d.f.k.b<RelativeLayout> getRelativeLayoutPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.t0.f1.n.i
        public int getRichTextViewId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.t0.f1.n.i
        public c.a.d.f.k.b<TextView> getTextViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.t0.f1.n.i
        public c.a.d.f.k.b<LinearLayout> getTextVoiceViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.t0.f1.n.i
        public c.a.d.f.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.t0.f1.n.i
        public c.a.d.f.k.b<View> getVoiceViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (c.a.d.f.k.b) invokeV.objValue;
        }

        @Override // c.a.t0.f1.n.i
        public void onAtClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            }
        }

        @Override // c.a.t0.f1.n.i
        public void onLinkButtonClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
            }
        }

        @Override // c.a.t0.f1.n.i
        public void onLinkClicked(Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048588, this, context, str, z) == null) {
                UrlManager.getInstance().dealOneLink(this.f45474e.getPageContext(), new String[]{str});
            }
        }

        @Override // c.a.t0.f1.n.i
        public void onPhoneClicked(Context context, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, context, str, str2) == null) {
            }
        }

        @Override // c.a.t0.f1.n.i
        public void onSongClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            }
        }

        @Override // c.a.t0.f1.n.i
        public void onVideoClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) {
            }
        }

        @Override // c.a.t0.f1.n.i
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
        this.f45471i = new a(this, 2001332);
        this.mMsgCallback = new c(this);
        this.f45472j = new d(this);
    }

    public boolean getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            OfficialNotificationListModel officialNotificationListModel = this.f45469g;
            if (officialNotificationListModel == null || officialNotificationListModel.getData() == null) {
                return true;
            }
            return this.f45469g.getData().getIsNewAdd();
        }
        return invokeV.booleanValue;
    }

    public boolean initData(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.f45470h = c.a.t0.t.d.b.g0().D();
            OfficialNotificationListModel officialNotificationListModel = new OfficialNotificationListModel(this.f45467e);
            this.f45469g = officialNotificationListModel;
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) || (officialNotificationListModel = this.f45469g) == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        onInitParam(bundle);
    }

    public void loadNextPage() {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (officialNotificationListModel = this.f45469g) == null) {
            return;
        }
        officialNotificationListModel.loadPrepage();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.u0.u1.b.q.b bVar = this.f45468f;
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
            if ((id == R.id.iv_head || id == R.id.tv_user_name) && !m.isEmpty(this.f45470h)) {
                TiebaStatic.log("c12938");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.f45470h))));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            this.f45467e = getPageContext();
            initData(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            c.a.u0.u1.b.q.b bVar = new c.a.u0.u1.b.q.b(this.f45467e, this, viewGroup);
            this.f45468f = bVar;
            OfficialNotificationListModel officialNotificationListModel = this.f45469g;
            if (officialNotificationListModel != null) {
                bVar.f(officialNotificationListModel.getData());
                this.f45469g.loadFirst(null);
            }
            return this.f45468f.i();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            this.f45469g.onDestroy();
            this.f45469g.setLoadDataCallBack(null);
        }
    }

    public void onInitParam(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) || bundle == null || bundle.getString("user") == null) {
            return;
        }
        UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
        saveToUserData(userData);
        this.f45469g.setUser(userData);
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
            MessageManager.getInstance().unRegisterListener(this.f45471i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            registerListener(this.f45471i);
        }
    }

    public void saveToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, userData) == null) {
            o0.c(new b(this, userData), null);
        }
    }

    public void initParam() {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (officialNotificationListModel = this.f45469g) == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        onInitParam();
    }

    public void onInitParam() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || m.isEmpty(this.f45470h) || this.f45467e == null || this.f45469g == null) {
            return;
        }
        UserData userData = new UserData(Long.parseLong(this.f45470h), this.f45467e.getString(R.string.system_message), null, 0);
        saveToUserData(userData);
        this.f45469g.setUser(userData);
    }
}
