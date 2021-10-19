package com.baidu.tieba.setting.usermutelist;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import c.a.e.e.p.k;
import c.a.q0.s.s.a;
import c.a.r0.c3.f.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.usermutelist.UserMuteQueryModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes7.dex */
public class UserMuteListActivity extends BaseActivity<UserMuteListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId MESSAGE_ID_USER_MUTE_LIST;
    public transient /* synthetic */ FieldHolder $fh;
    public String delUserId;
    public boolean isNeedRefresh;
    public c.a.r0.c3.f.a mAdapter;
    public UserMuteQueryModel.b mCallback;
    public c.a.e.a.f mCtx;
    public ArrayList<MuteUser> mData;
    public a.d mHeaderClickHandler;
    public CustomMessageListener mNeedRefreshListener;
    public a.e mRemoveClickHandler;
    public CustomMessageListener mRemoveItemListener;
    public c.a.q0.s.f0.c mToastMute;
    public CustomMessageListener mUserMuteDelListener;
    public UserMuteQueryModel mUserMuteQueryModel;
    public c.a.r0.c3.f.b mView;
    public c.a.q0.s.f0.a mWaitingDialog;
    public int page;
    public int rN;

    /* loaded from: classes7.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteListActivity f56830e;

        public a(UserMuteListActivity userMuteListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56830e = userMuteListActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements UserMuteQueryModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserMuteListActivity f56831a;

        public b(UserMuteListActivity userMuteListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56831a = userMuteListActivity;
        }

        @Override // com.baidu.tieba.setting.usermutelist.UserMuteQueryModel.b
        public void a(ArrayList<MuteUser> arrayList, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, arrayList, i2, str) == null) {
                this.f56831a.mWaitingDialog.h(false);
                if (i2 != UserMuteQueryModel.NET_SUCCESS) {
                    this.f56831a.mView.e();
                    this.f56831a.showToast(str);
                    return;
                }
                UserMuteListActivity.access$108(this.f56831a);
                this.f56831a.mData.addAll(arrayList);
                if (this.f56831a.mData == null || this.f56831a.mData.size() <= 0) {
                    this.f56831a.mView.e();
                } else {
                    this.f56831a.mAdapter.d(this.f56831a.mData);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserMuteListActivity f56832a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(UserMuteListActivity userMuteListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteListActivity, Integer.valueOf(i2)};
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
            this.f56832a = userMuteListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != UserMuteListActivity.MESSAGE_ID_USER_MUTE_LIST) {
                return;
            }
            this.f56832a.mWaitingDialog.h(false);
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
            if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                this.f56832a.mToastMute.c(this.f56832a.mCtx.getResources().getString(R.string.un_mute_success));
                return;
            }
            String muteMessage = userMuteDelResponseMessage.getMuteMessage();
            if (k.isEmpty(muteMessage)) {
                muteMessage = this.f56832a.mCtx.getResources().getString(R.string.un_mute_fail);
            }
            this.f56832a.mToastMute.b(muteMessage);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserMuteListActivity f56833a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(UserMuteListActivity userMuteListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteListActivity, Integer.valueOf(i2)};
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
            this.f56833a = userMuteListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f56833a.isNeedRefresh = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserMuteListActivity f56834a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(UserMuteListActivity userMuteListActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteListActivity, Integer.valueOf(i2)};
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
            this.f56834a = userMuteListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                if ((customResponsedMessage != null || this.f56834a.delUserId == null) && this.f56834a.mData != null && this.f56834a.mData.size() > 0) {
                    for (int i2 = 0; i2 < this.f56834a.mData.size(); i2++) {
                        MuteUser muteUser = (MuteUser) this.f56834a.mData.get(i2);
                        if (muteUser != null) {
                            if ((muteUser.user_id + "").equals(this.f56834a.delUserId)) {
                                this.f56834a.mData.remove(i2);
                                this.f56834a.mAdapter.notifyDataSetChanged();
                                if (this.f56834a.mData.size() == 0) {
                                    this.f56834a.mView.e();
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserMuteListActivity f56835a;

        public f(UserMuteListActivity userMuteListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56835a = userMuteListActivity;
        }

        @Override // c.a.r0.c3.f.a.e
        public void a(long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048576, this, j2, str) == null) {
                if (!c.a.e.e.p.j.z()) {
                    this.f56835a.showToast(R.string.neterror);
                    return;
                }
                TiebaStatic.log("c10047");
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(true, j2 + "", str, null, null, 2, null, UserMuteListActivity.MESSAGE_ID_USER_MUTE_LIST);
                UserMuteListActivity userMuteListActivity = this.f56835a;
                userMuteListActivity.delUserId = j2 + "";
                userMuteAddAndDelCustomMessage.setTag(UserMuteListActivity.MESSAGE_ID_USER_MUTE_LIST);
                this.f56835a.showUserMuteDialog(true, userMuteAddAndDelCustomMessage, null, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserMuteListActivity f56836a;

        public g(UserMuteListActivity userMuteListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56836a = userMuteListActivity;
        }

        @Override // c.a.r0.c3.f.a.d
        public void a(long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJL(1048576, this, j2, str) == null) {
                UserMuteListActivity userMuteListActivity = this.f56836a;
                Activity pageActivity = this.f56836a.getPageContext().getPageActivity();
                userMuteListActivity.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(pageActivity, j2 + "", str)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteListActivity f56837e;

        public h(UserMuteListActivity userMuteListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56837e = userMuteListActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                this.f56837e.mUserMuteQueryModel.y(c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), this.f56837e.page, this.f56837e.rN);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteListActivity f56838e;

        public i(UserMuteListActivity userMuteListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56838e = userMuteListActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.f56838e.mUserMuteQueryModel != null) {
                    this.f56838e.mUserMuteQueryModel.cancelLoadData();
                }
                MessageManager.getInstance().removeMessage(UserMuteListActivity.MESSAGE_ID_USER_MUTE_LIST);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f56839e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UserMuteListActivity f56840f;

        public j(UserMuteListActivity userMuteListActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userMuteListActivity, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56840f = userMuteListActivity;
            this.f56839e = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f56840f.showLoadingDialog();
                MessageManager.getInstance().sendMessage(this.f56839e);
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(237591274, "Lcom/baidu/tieba/setting/usermutelist/UserMuteListActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(237591274, "Lcom/baidu/tieba/setting/usermutelist/UserMuteListActivity;");
                return;
            }
        }
        MESSAGE_ID_USER_MUTE_LIST = BdUniqueId.gen();
    }

    public UserMuteListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mData = new ArrayList<>();
        this.isNeedRefresh = false;
        this.page = 1;
        this.rN = 10;
        this.mCallback = new b(this);
        this.mUserMuteDelListener = new c(this, 2001428);
        this.mNeedRefreshListener = new d(this, 2016304);
        this.mRemoveItemListener = new e(this, 2016303);
        this.mRemoveClickHandler = new f(this);
        this.mHeaderClickHandler = new g(this);
    }

    public static /* synthetic */ int access$108(UserMuteListActivity userMuteListActivity) {
        int i2 = userMuteListActivity.page;
        userMuteListActivity.page = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            if (!c.a.e.e.p.j.z()) {
                this.mView.f();
                return;
            }
            if (this.mWaitingDialog == null) {
                c.a.q0.s.f0.a aVar = new c.a.q0.s.f0.a(getPageContext());
                this.mWaitingDialog = aVar;
                aVar.e(new i(this));
            }
            this.mWaitingDialog.h(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteDialog(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2}) == null) {
            if (z) {
                showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.mCtx.getPageActivity());
            if (k.isEmpty(str)) {
                aVar.setMessage(this.mCtx.getResources().getString(R.string.block_mute_message_alert, str2));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new j(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new a(this));
            aVar.create(this.mCtx).show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            this.mAdapter = new c.a.r0.c3.f.a(this, this.mRemoveClickHandler, this.mHeaderClickHandler);
            this.mUserMuteQueryModel = new UserMuteQueryModel(this.mCallback);
            c.a.r0.c3.f.b bVar = new c.a.r0.c3.f.b(this, this.mAdapter);
            this.mView = bVar;
            bVar.d().setAdapter((ListAdapter) this.mAdapter);
            this.mView.d().setOnScrollListener(new h(this));
            showLoadingDialog();
            registerListener(this.mRemoveItemListener);
            registerListener(this.mNeedRefreshListener);
            this.mUserMuteQueryModel.x(c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.mCtx = getPageContext();
            c.a.q0.s.f0.c cVar = new c.a.q0.s.f0.c();
            this.mToastMute = cVar;
            cVar.f13832a = 1000L;
            registerListener(this.mUserMuteDelListener);
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            BdUniqueId bdUniqueId = MESSAGE_ID_USER_MUTE_LIST;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
            this.mCtx = null;
            this.mUserMuteQueryModel.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.mUserMuteDelListener);
            MessageManager.getInstance().unRegisterListener(MESSAGE_ID_USER_MUTE_LIST);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            if (this.isNeedRefresh) {
                this.isNeedRefresh = false;
                showLoadingDialog();
                this.mUserMuteQueryModel.x(c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
        }
    }
}
