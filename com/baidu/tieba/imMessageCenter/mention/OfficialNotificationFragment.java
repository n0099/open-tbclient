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
import com.repackage.a9;
import com.repackage.bg;
import com.repackage.bg5;
import com.repackage.fb7;
import com.repackage.ky4;
import com.repackage.li;
import com.repackage.s77;
import com.repackage.sd5;
import com.repackage.vd5;
import com.repackage.yf5;
/* loaded from: classes3.dex */
public class OfficialNotificationFragment extends BaseFragment implements NoNetworkView.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public fb7 b;
    public OfficialNotificationListModel c;
    public String d;
    public CustomMessageListener e;
    public a9 f;
    public bg5 g;

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yf5.a)) {
                yf5.a aVar = (yf5.a) customResponsedMessage.getData();
                yf5.a(this.a.getPageContext().getPageActivity(), this.a.g, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends sd5<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserData a;
        public final /* synthetic */ OfficialNotificationFragment b;

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
            this.b = officialNotificationFragment;
            this.a = userData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sd5
        /* renamed from: a */
        public Void doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                s77.j().m(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), this.a);
                return null;
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends a9 {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || this.a.c == null || this.a.b == null || li.isEmpty(this.a.d) || this.a.c.getUser() == null || !StringHelper.equals(this.a.d, this.a.c.getUser().getUserId())) {
                return;
            }
            int loadDataMode = this.a.c.getLoadDataMode();
            if (loadDataMode == 1) {
                this.a.b.l(this.a.c.getData());
            } else if (loadDataMode == 2) {
                this.a.b.n(this.a.c.getData());
            } else if (loadDataMode != 3) {
            } else {
                this.a.b.k(this.a.c.getData());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements bg5 {
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

        @Override // com.repackage.bg5
        public bg<GifView> getGifViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (bg) invokeV.objValue;
        }

        @Override // com.repackage.bg5
        public bg<ImageView> getImageViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (bg) invokeV.objValue;
        }

        @Override // com.repackage.bg5
        public bg<ItemCardView> getItemCardViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (bg) invokeV.objValue;
        }

        @Override // com.repackage.bg5
        public ListView getListView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (ListView) invokeV.objValue;
        }

        @Override // com.repackage.bg5
        public bg<RelativeLayout> getRelativeLayoutPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (bg) invokeV.objValue;
        }

        @Override // com.repackage.bg5
        public int getRichTextViewId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.bg5
        public bg<TextView> getTextViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (bg) invokeV.objValue;
        }

        @Override // com.repackage.bg5
        public bg<LinearLayout> getTextVoiceViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return null;
            }
            return (bg) invokeV.objValue;
        }

        @Override // com.repackage.bg5
        public bg<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return (bg) invokeV.objValue;
        }

        @Override // com.repackage.bg5
        public bg<View> getVoiceViewPool() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (bg) invokeV.objValue;
        }

        @Override // com.repackage.bg5
        public void onAtClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            }
        }

        @Override // com.repackage.bg5
        public void onLinkButtonClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, context, str) == null) {
            }
        }

        @Override // com.repackage.bg5
        public void onLinkClicked(Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048588, this, context, str, z) == null) {
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str});
            }
        }

        @Override // com.repackage.bg5
        public void onPhoneClicked(Context context, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, context, str, str2) == null) {
            }
        }

        @Override // com.repackage.bg5
        public void onSongClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, context, str) == null) {
            }
        }

        @Override // com.repackage.bg5
        public void onVideoClicked(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) {
            }
        }

        @Override // com.repackage.bg5
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
        this.e = new a(this, 2001332);
        this.f = new c(this);
        this.g = new d(this);
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            OfficialNotificationListModel officialNotificationListModel = this.c;
            if (officialNotificationListModel == null || officialNotificationListModel.getData() == null) {
                return true;
            }
            return this.c.getData().getIsNewAdd();
        }
        return invokeV.booleanValue;
    }

    public boolean G0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
            this.d = ky4.h0().D();
            OfficialNotificationListModel officialNotificationListModel = new OfficialNotificationListModel(this.a);
            this.c = officialNotificationListModel;
            officialNotificationListModel.setLoadDataCallBack(this.f);
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (officialNotificationListModel = this.c) == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        K0();
    }

    public void I0(Bundle bundle) {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) || (officialNotificationListModel = this.c) == null) {
            return;
        }
        officialNotificationListModel.setIsAcceptNotify(true);
        L0(bundle);
    }

    public void J0() {
        OfficialNotificationListModel officialNotificationListModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (officialNotificationListModel = this.c) == null) {
            return;
        }
        officialNotificationListModel.loadPrepage();
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || li.isEmpty(this.d) || this.a == null || this.c == null) {
            return;
        }
        UserData userData = new UserData(Long.parseLong(this.d), this.a.getString(R.string.obfuscated_res_0x7f0f133a), null, 0);
        M0(userData);
        this.c.setUser(userData);
    }

    public void L0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) || bundle == null || bundle.getString("user") == null) {
            return;
        }
        UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
        M0(userData);
        this.c.setUser(userData);
    }

    public void M0(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, userData) == null) {
            vd5.c(new b(this, userData), null);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            fb7 fb7Var = this.b;
            if (fb7Var != null) {
                fb7Var.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            super.onClick(view2);
            int id = view2.getId();
            if ((id == R.id.obfuscated_res_0x7f090fde || id == R.id.obfuscated_res_0x7f092265) && !li.isEmpty(this.d)) {
                TiebaStatic.log("c12938");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.d))));
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
            fb7 fb7Var = new fb7(this.a, this, viewGroup);
            this.b = fb7Var;
            OfficialNotificationListModel officialNotificationListModel = this.c;
            if (officialNotificationListModel != null) {
                fb7Var.f(officialNotificationListModel.getData());
                this.c.loadFirst(null);
            }
            return this.b.i();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            this.c.onDestroy();
            this.c.setLoadDataCallBack(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            registerListener(this.e);
        }
    }
}
