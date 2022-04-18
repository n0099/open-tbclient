package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.widget.Game2GroupShareDialogView;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b77;
import com.repackage.cr4;
import com.repackage.iy4;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.u97;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u97 adapter;
    public CustomMessageListener discoverSharelistener;
    public CustomMessageListener gameSharelistener;
    public CustomMessageListener getFriendListListener;
    public HttpMessageListener httpListener;
    public AdapterView.OnItemClickListener itemClickListener;
    public int keyWhereFrom;
    public BdListView listView;
    public NoDataView mNoDataView;
    public LinearLayout mRootView;
    public NavigationBar navigationBar;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectFriendActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectFriendActivity selectFriendActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, Integer.valueOf(i)};
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
            this.a = selectFriendActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null && (httpResponsedMessage instanceof ResponseFriendListMessage)) {
                LinkedList<iy4> friendList = ((ResponseFriendListMessage) httpResponsedMessage).getFriendList();
                if (friendList == null) {
                    friendList = new LinkedList<>();
                }
                if (friendList.size() > 0) {
                    this.a.mNoDataView.setVisibility(8);
                    this.a.adapter.b(friendList);
                    this.a.adapter.notifyDataSetChanged();
                    return;
                }
                this.a.mNoDataView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectFriendActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SelectFriendActivity selectFriendActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, Integer.valueOf(i)};
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
            this.a = selectFriendActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof GetContactListResponsedMessage)) {
                List<iy4> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
                if (contacts == null) {
                    contacts = new LinkedList<>();
                }
                if (contacts.size() > 0) {
                    this.a.mNoDataView.setVisibility(8);
                    this.a.adapter.b(contacts);
                    this.a.adapter.notifyDataSetChanged();
                    return;
                }
                this.a.mNoDataView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectFriendActivity a;

        public c(SelectFriendActivity selectFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onBackPressed();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectFriendActivity a;

        /* loaded from: classes3.dex */
        public class a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, int i, long j, String str, String str2, String str3) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i), Long.valueOf(j), str, str2, str3};
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
                this.e = dVar;
                this.a = j;
                this.b = str;
                this.c = str2;
                this.d = str3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || customResponsedMessage.getCmd() != 2001261) {
                    return;
                }
                this.e.a.showConfirmShareToFriendDialog((ShareFromGameCenterMsgData) customResponsedMessage.getData(), this.a, this.b, this.c, this.d);
            }
        }

        /* loaded from: classes3.dex */
        public class b extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ d e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(d dVar, int i, long j, String str, String str2, String str3) {
                super(i);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i), Long.valueOf(j), str, str2, str3};
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
                this.e = dVar;
                this.a = j;
                this.b = str;
                this.c = str2;
                this.d = str3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || customResponsedMessage.getCmd() != 2921015) {
                    return;
                }
                this.e.a.showConfirmShareToFriendDialog((ShareFromPBMsgData) customResponsedMessage.getData(), this.a, this.b, this.c, this.d);
            }
        }

        public d(SelectFriendActivity selectFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectFriendActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            iy4 item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.adapter.getItem(i)) == null) {
                return;
            }
            long e = item.e();
            String f = item.f();
            String h = item.h();
            String g = item.g();
            if (this.a.keyWhereFrom == 0) {
                if (this.a.gameSharelistener == null) {
                    this.a.gameSharelistener = new a(this, 2001261, e, f, g, h);
                    SelectFriendActivity selectFriendActivity = this.a;
                    selectFriendActivity.registerListener(selectFriendActivity.gameSharelistener);
                }
                this.a.sendMessage(new CustomMessage(2001261));
            } else if (this.a.keyWhereFrom == 1) {
                if (this.a.discoverSharelistener == null) {
                    this.a.discoverSharelistener = new b(this, 2921015, e, f, g, h);
                    SelectFriendActivity selectFriendActivity2 = this.a;
                    selectFriendActivity2.registerListener(selectFriendActivity2.discoverSharelistener);
                }
                this.a.sendMessage(new CustomMessage(2921015));
            } else {
                Intent intent = new Intent();
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, e);
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, f);
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, h);
                intent.putExtra("name_show", g);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ ShareFromPBMsgData b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Game2GroupShareDialogView f;
        public final /* synthetic */ SelectFriendActivity g;

        public e(SelectFriendActivity selectFriendActivity, long j, ShareFromPBMsgData shareFromPBMsgData, String str, String str2, String str3, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, Long.valueOf(j), shareFromPBMsgData, str, str2, str3, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = selectFriendActivity;
            this.a = j;
            this.b = shareFromPBMsgData;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = game2GroupShareDialogView;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                long u = b77.p().u(String.valueOf(this.a), 2);
                MessageUtils.createPersonalChatMessage(u, 9, this.b.toChatMessageContent(), this.a, this.c, this.d, this.e);
                MessageUtils.createPersonalChatMessage(u + 1, 1, this.f.getLeaveMsg(), this.a, this.c, this.d, this.e);
                cr4Var.dismiss();
                this.g.setResult(-1);
                if (!mi.z()) {
                    SelectFriendActivity selectFriendActivity = this.g;
                    selectFriendActivity.showToast(selectFriendActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c4e));
                } else {
                    BdToast.i(this.g.getPageContext().getPageActivity(), this.g.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1110), R.drawable.obfuscated_res_0x7f0809ab, true).q();
                }
                this.g.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Game2GroupShareDialogView a;
        public final /* synthetic */ SelectFriendActivity b;

        public f(SelectFriendActivity selectFriendActivity, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = selectFriendActivity;
            this.a = game2GroupShareDialogView;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                ((InputMethodManager) this.b.getPageContext().getPageActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 2);
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ ShareFromGameCenterMsgData b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Game2GroupShareDialogView f;
        public final /* synthetic */ SelectFriendActivity g;

        public g(SelectFriendActivity selectFriendActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, String str3, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, Long.valueOf(j), shareFromGameCenterMsgData, str, str2, str3, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = selectFriendActivity;
            this.a = j;
            this.b = shareFromGameCenterMsgData;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = game2GroupShareDialogView;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                long u = b77.p().u(String.valueOf(this.a), 2);
                MessageUtils.createPersonalChatMessage(u, 9, this.b.toChatMessageContent(), this.a, this.c, this.d, this.e);
                MessageUtils.createPersonalChatMessage(u + 1, 1, this.f.getLeaveMsg(), this.a, this.c, this.d, this.e);
                cr4Var.dismiss();
                this.g.setResult(-1);
                if (!mi.z()) {
                    SelectFriendActivity selectFriendActivity = this.g;
                    selectFriendActivity.showToast(selectFriendActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c4e));
                }
                this.g.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Game2GroupShareDialogView a;
        public final /* synthetic */ SelectFriendActivity b;

        public h(SelectFriendActivity selectFriendActivity, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = selectFriendActivity;
            this.a = game2GroupShareDialogView;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                ((InputMethodManager) this.b.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 2);
            }
        }
    }

    public SelectFriendActivity() {
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
        this.httpListener = new a(this, CmdConfigHttp.CMD_GET_FRIEND_LIST);
        this.keyWhereFrom = -1;
        this.getFriendListListener = new b(this, 2001184);
        this.itemClickListener = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmShareToFriendDialog(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{shareFromPBMsgData, Long.valueOf(j), str, str2, str3}) == null) {
            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
            cr4Var.setContentViewSize(1);
            Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
            game2GroupShareDialogView.setShareData(shareFromPBMsgData);
            cr4Var.setContentView(game2GroupShareDialogView);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f110e, new e(this, j, shareFromPBMsgData, str, str2, str3, game2GroupShareDialogView));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new f(this, game2GroupShareDialogView));
            cr4Var.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.navigationBar.onChangeSkinType(getPageContext(), i);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
            getLayoutMode().k(i == 1);
            getLayoutMode().j(findViewById(R.id.obfuscated_res_0x7f091c64));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d075b);
            this.mRootView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091c64);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091c63);
            this.navigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            this.navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f10cd);
            this.listView = (BdListView) findViewById(R.id.obfuscated_res_0x7f091c62);
            u97 u97Var = new u97(getPageContext().getPageActivity());
            this.adapter = u97Var;
            this.listView.setAdapter((ListAdapter) u97Var);
            this.listView.setOnItemClickListener(this.itemClickListener);
            registerListener(this.getFriendListListener);
            registerListener(this.httpListener);
            if (TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null) {
                sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_LIST));
            } else {
                MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
            }
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, oi.f(getActivity(), R.dimen.obfuscated_res_0x7f07027d)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f10cc), null);
            this.mNoDataView = a2;
            this.mRootView.addView(a2, 1);
            if (bundle != null) {
                this.keyWhereFrom = bundle.getInt("key_from_where");
            } else if (getIntent() != null) {
                this.keyWhereFrom = getIntent().getIntExtra("key_from_where", -1);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            if (this.gameSharelistener != null) {
                MessageManager.getInstance().unRegisterListener(this.gameSharelistener);
                this.gameSharelistener = null;
            }
            if (this.discoverSharelistener != null) {
                MessageManager.getInstance().unRegisterListener(this.discoverSharelistener);
                this.discoverSharelistener = null;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onStart();
            this.mNoDataView.d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStop();
            this.mNoDataView.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmShareToFriendDialog(ShareFromGameCenterMsgData shareFromGameCenterMsgData, long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{shareFromGameCenterMsgData, Long.valueOf(j), str, str2, str3}) == null) {
            cr4 cr4Var = new cr4(getPageContext().getPageActivity());
            cr4Var.setContentViewSize(1);
            Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
            game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
            cr4Var.setContentView(game2GroupShareDialogView);
            cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f110e, new g(this, j, shareFromGameCenterMsgData, str, str2, str3, game2GroupShareDialogView));
            cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new h(this, game2GroupShareDialogView));
            cr4Var.create(getPageContext()).show();
        }
    }
}
