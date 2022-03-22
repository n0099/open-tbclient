package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
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
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.v1.a.d.a adapter;
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

    /* loaded from: classes5.dex */
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
                LinkedList<c.a.o0.s.f.a> friendList = ((ResponseFriendListMessage) httpResponsedMessage).getFriendList();
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

    /* loaded from: classes5.dex */
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
                List<c.a.o0.s.f.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
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

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.onBackPressed();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectFriendActivity a;

        /* loaded from: classes5.dex */
        public class a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f34003b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f34004c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f34005d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f34006e;

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
                this.f34006e = dVar;
                this.a = j;
                this.f34003b = str;
                this.f34004c = str2;
                this.f34005d = str3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || customResponsedMessage.getCmd() != 2001261) {
                    return;
                }
                this.f34006e.a.showConfirmShareToFriendDialog((ShareFromGameCenterMsgData) customResponsedMessage.getData(), this.a, this.f34003b, this.f34004c, this.f34005d);
            }
        }

        /* loaded from: classes5.dex */
        public class b extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f34007b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f34008c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f34009d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f34010e;

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
                this.f34010e = dVar;
                this.a = j;
                this.f34007b = str;
                this.f34008c = str2;
                this.f34009d = str3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || customResponsedMessage.getCmd() != 2921015) {
                    return;
                }
                this.f34010e.a.showConfirmShareToFriendDialog((ShareFromPBMsgData) customResponsedMessage.getData(), this.a, this.f34007b, this.f34008c, this.f34009d);
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.a.o0.s.f.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.adapter.getItem(i)) == null) {
                return;
            }
            long e2 = item.e();
            String f2 = item.f();
            String h2 = item.h();
            String g2 = item.g();
            if (this.a.keyWhereFrom == 0) {
                if (this.a.gameSharelistener == null) {
                    this.a.gameSharelistener = new a(this, 2001261, e2, f2, g2, h2);
                    SelectFriendActivity selectFriendActivity = this.a;
                    selectFriendActivity.registerListener(selectFriendActivity.gameSharelistener);
                }
                this.a.sendMessage(new CustomMessage(2001261));
            } else if (this.a.keyWhereFrom == 1) {
                if (this.a.discoverSharelistener == null) {
                    this.a.discoverSharelistener = new b(this, 2921015, e2, f2, g2, h2);
                    SelectFriendActivity selectFriendActivity2 = this.a;
                    selectFriendActivity2.registerListener(selectFriendActivity2.discoverSharelistener);
                }
                this.a.sendMessage(new CustomMessage(2921015));
            } else {
                Intent intent = new Intent();
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, e2);
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, f2);
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, h2);
                intent.putExtra("name_show", g2);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f34011b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f34012c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f34013d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f34014e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f34015f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SelectFriendActivity f34016g;

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
            this.f34016g = selectFriendActivity;
            this.a = j;
            this.f34011b = shareFromPBMsgData;
            this.f34012c = str;
            this.f34013d = str2;
            this.f34014e = str3;
            this.f34015f = game2GroupShareDialogView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                long t = c.a.p0.u1.k.b.o().t(String.valueOf(this.a), 2);
                MessageUtils.createPersonalChatMessage(t, 9, this.f34011b.toChatMessageContent(), this.a, this.f34012c, this.f34013d, this.f34014e);
                MessageUtils.createPersonalChatMessage(t + 1, 1, this.f34015f.getLeaveMsg(), this.a, this.f34012c, this.f34013d, this.f34014e);
                aVar.dismiss();
                this.f34016g.setResult(-1);
                if (!l.z()) {
                    SelectFriendActivity selectFriendActivity = this.f34016g;
                    selectFriendActivity.showToast(selectFriendActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c4c));
                } else {
                    BdToast.i(this.f34016g.getPageContext().getPageActivity(), this.f34016g.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1109), R.drawable.obfuscated_res_0x7f0809a1, true).q();
                }
                this.f34016g.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Game2GroupShareDialogView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SelectFriendActivity f34017b;

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
            this.f34017b = selectFriendActivity;
            this.a = game2GroupShareDialogView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f34017b.getPageContext().getPageActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 2);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ShareFromGameCenterMsgData f34018b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f34019c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f34020d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f34021e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f34022f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SelectFriendActivity f34023g;

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
            this.f34023g = selectFriendActivity;
            this.a = j;
            this.f34018b = shareFromGameCenterMsgData;
            this.f34019c = str;
            this.f34020d = str2;
            this.f34021e = str3;
            this.f34022f = game2GroupShareDialogView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                long t = c.a.p0.u1.k.b.o().t(String.valueOf(this.a), 2);
                MessageUtils.createPersonalChatMessage(t, 9, this.f34018b.toChatMessageContent(), this.a, this.f34019c, this.f34020d, this.f34021e);
                MessageUtils.createPersonalChatMessage(t + 1, 1, this.f34022f.getLeaveMsg(), this.a, this.f34019c, this.f34020d, this.f34021e);
                aVar.dismiss();
                this.f34023g.setResult(-1);
                if (!l.z()) {
                    SelectFriendActivity selectFriendActivity = this.f34023g;
                    selectFriendActivity.showToast(selectFriendActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c4c));
                }
                this.f34023g.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Game2GroupShareDialogView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SelectFriendActivity f34024b;

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
            this.f34024b = selectFriendActivity;
            this.a = game2GroupShareDialogView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                ((InputMethodManager) this.f34024b.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 2);
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
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
            aVar.setContentViewSize(1);
            Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
            game2GroupShareDialogView.setShareData(shareFromPBMsgData);
            aVar.setContentView(game2GroupShareDialogView);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f1107, new e(this, j, shareFromPBMsgData, str, str2, str3, game2GroupShareDialogView));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new f(this, game2GroupShareDialogView));
            aVar.create(getPageContext()).show();
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
            getLayoutMode().j(findViewById(R.id.obfuscated_res_0x7f091c75));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0764);
            this.mRootView = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091c75);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091c74);
            this.navigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            this.navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f10c6);
            this.listView = (BdListView) findViewById(R.id.obfuscated_res_0x7f091c73);
            c.a.p0.v1.a.d.a aVar = new c.a.p0.v1.a.d.a(getPageContext().getPageActivity());
            this.adapter = aVar;
            this.listView.setAdapter((ListAdapter) aVar);
            this.listView.setOnItemClickListener(this.itemClickListener);
            registerListener(this.getFriendListListener);
            registerListener(this.httpListener);
            if (TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null) {
                sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_LIST));
            } else {
                MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
            }
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(getActivity(), R.dimen.obfuscated_res_0x7f070271)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f10c5), null);
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
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
            aVar.setContentViewSize(1);
            Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
            game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
            aVar.setContentView(game2GroupShareDialogView);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f1107, new g(this, j, shareFromGameCenterMsgData, str, str2, str3, game2GroupShareDialogView));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new h(this, game2GroupShareDialogView));
            aVar.create(getPageContext()).show();
        }
    }
}
