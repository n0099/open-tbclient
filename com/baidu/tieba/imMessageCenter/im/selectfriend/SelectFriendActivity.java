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
import c.a.s0.s.s.a;
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
/* loaded from: classes12.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.u1.a.d.a adapter;
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

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectFriendActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectFriendActivity selectFriendActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, Integer.valueOf(i2)};
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
            this.a = selectFriendActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null && (httpResponsedMessage instanceof ResponseFriendListMessage)) {
                LinkedList<c.a.s0.t.f.a> friendList = ((ResponseFriendListMessage) httpResponsedMessage).getFriendList();
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

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectFriendActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SelectFriendActivity selectFriendActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, Integer.valueOf(i2)};
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
            this.a = selectFriendActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof GetContactListResponsedMessage)) {
                List<c.a.s0.t.f.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
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

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectFriendActivity f45267e;

        public c(SelectFriendActivity selectFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45267e = selectFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45267e.onBackPressed();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectFriendActivity f45268e;

        /* loaded from: classes12.dex */
        public class a extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f45269b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f45270c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f45271d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45272e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, int i2, long j2, String str, String str2, String str3) {
                super(i2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i2), Long.valueOf(j2), str, str2, str3};
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
                this.f45272e = dVar;
                this.a = j2;
                this.f45269b = str;
                this.f45270c = str2;
                this.f45271d = str3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || customResponsedMessage.getCmd() != 2001261) {
                    return;
                }
                this.f45272e.f45268e.showConfirmShareToFriendDialog((ShareFromGameCenterMsgData) customResponsedMessage.getData(), this.a, this.f45269b, this.f45270c, this.f45271d);
            }
        }

        /* loaded from: classes12.dex */
        public class b extends CustomMessageListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f45273b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f45274c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f45275d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f45276e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(d dVar, int i2, long j2, String str, String str2, String str3) {
                super(i2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i2), Long.valueOf(j2), str, str2, str3};
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
                this.f45276e = dVar;
                this.a = j2;
                this.f45273b = str;
                this.f45274c = str2;
                this.f45275d = str3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || customResponsedMessage.getCmd() != 2921015) {
                    return;
                }
                this.f45276e.f45268e.showConfirmShareToFriendDialog((ShareFromPBMsgData) customResponsedMessage.getData(), this.a, this.f45273b, this.f45274c, this.f45275d);
            }
        }

        public d(SelectFriendActivity selectFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45268e = selectFriendActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            c.a.s0.t.f.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.f45268e.adapter.getItem(i2)) == null) {
                return;
            }
            long e2 = item.e();
            String f2 = item.f();
            String h2 = item.h();
            String g2 = item.g();
            if (this.f45268e.keyWhereFrom == 0) {
                if (this.f45268e.gameSharelistener == null) {
                    this.f45268e.gameSharelistener = new a(this, 2001261, e2, f2, g2, h2);
                    SelectFriendActivity selectFriendActivity = this.f45268e;
                    selectFriendActivity.registerListener(selectFriendActivity.gameSharelistener);
                }
                this.f45268e.sendMessage(new CustomMessage(2001261));
            } else if (this.f45268e.keyWhereFrom == 1) {
                if (this.f45268e.discoverSharelistener == null) {
                    this.f45268e.discoverSharelistener = new b(this, 2921015, e2, f2, g2, h2);
                    SelectFriendActivity selectFriendActivity2 = this.f45268e;
                    selectFriendActivity2.registerListener(selectFriendActivity2.discoverSharelistener);
                }
                this.f45268e.sendMessage(new CustomMessage(2921015));
            } else {
                Intent intent = new Intent();
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, e2);
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, f2);
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, h2);
                intent.putExtra("name_show", g2);
                this.f45268e.setResult(-1, intent);
                this.f45268e.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f45277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f45278f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45279g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45280h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45281i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f45282j;
        public final /* synthetic */ SelectFriendActivity k;

        public e(SelectFriendActivity selectFriendActivity, long j2, ShareFromPBMsgData shareFromPBMsgData, String str, String str2, String str3, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, Long.valueOf(j2), shareFromPBMsgData, str, str2, str3, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = selectFriendActivity;
            this.f45277e = j2;
            this.f45278f = shareFromPBMsgData;
            this.f45279g = str;
            this.f45280h = str2;
            this.f45281i = str3;
            this.f45282j = game2GroupShareDialogView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                long t = c.a.t0.t1.k.b.o().t(String.valueOf(this.f45277e), 2);
                MessageUtils.createPersonalChatMessage(t, 9, this.f45278f.toChatMessageContent(), this.f45277e, this.f45279g, this.f45280h, this.f45281i);
                MessageUtils.createPersonalChatMessage(t + 1, 1, this.f45282j.getLeaveMsg(), this.f45277e, this.f45279g, this.f45280h, this.f45281i);
                aVar.dismiss();
                this.k.setResult(-1);
                if (!l.z()) {
                    SelectFriendActivity selectFriendActivity = this.k;
                    selectFriendActivity.showToast(selectFriendActivity.getPageContext().getString(R.string.no_network_guide));
                } else {
                    BdToast.i(this.k.getPageContext().getPageActivity(), this.k.getPageContext().getPageActivity().getString(R.string.share_alert_success), R.drawable.icon_pure_toast_succeed40_svg, true).q();
                }
                this.k.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f45283e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SelectFriendActivity f45284f;

        public f(SelectFriendActivity selectFriendActivity, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45284f = selectFriendActivity;
            this.f45283e = game2GroupShareDialogView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f45284f.getPageContext().getPageActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f45283e.getWindowToken(), 2);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f45285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareFromGameCenterMsgData f45286f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45287g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45288h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45289i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f45290j;
        public final /* synthetic */ SelectFriendActivity k;

        public g(SelectFriendActivity selectFriendActivity, long j2, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, String str3, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, Long.valueOf(j2), shareFromGameCenterMsgData, str, str2, str3, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = selectFriendActivity;
            this.f45285e = j2;
            this.f45286f = shareFromGameCenterMsgData;
            this.f45287g = str;
            this.f45288h = str2;
            this.f45289i = str3;
            this.f45290j = game2GroupShareDialogView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                long t = c.a.t0.t1.k.b.o().t(String.valueOf(this.f45285e), 2);
                MessageUtils.createPersonalChatMessage(t, 9, this.f45286f.toChatMessageContent(), this.f45285e, this.f45287g, this.f45288h, this.f45289i);
                MessageUtils.createPersonalChatMessage(t + 1, 1, this.f45290j.getLeaveMsg(), this.f45285e, this.f45287g, this.f45288h, this.f45289i);
                aVar.dismiss();
                this.k.setResult(-1);
                if (!l.z()) {
                    SelectFriendActivity selectFriendActivity = this.k;
                    selectFriendActivity.showToast(selectFriendActivity.getPageContext().getString(R.string.no_network_guide));
                }
                this.k.finish();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f45291e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SelectFriendActivity f45292f;

        public h(SelectFriendActivity selectFriendActivity, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectFriendActivity, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45292f = selectFriendActivity;
            this.f45291e = game2GroupShareDialogView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                ((InputMethodManager) this.f45292f.getSystemService("input_method")).hideSoftInputFromWindow(this.f45291e.getWindowToken(), 2);
            }
        }
    }

    public SelectFriendActivity() {
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
        this.httpListener = new a(this, CmdConfigHttp.CMD_GET_FRIEND_LIST);
        this.keyWhereFrom = -1;
        this.getFriendListListener = new b(this, 2001184);
        this.itemClickListener = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmShareToFriendDialog(ShareFromPBMsgData shareFromPBMsgData, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{shareFromPBMsgData, Long.valueOf(j2), str, str2, str3}) == null) {
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getPageContext().getPageActivity());
            aVar.setContentViewSize(1);
            Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
            game2GroupShareDialogView.setShareData(shareFromPBMsgData);
            aVar.setContentView(game2GroupShareDialogView);
            aVar.setPositiveButton(R.string.share, new e(this, j2, shareFromPBMsgData, str, str2, str3, game2GroupShareDialogView));
            aVar.setNegativeButton(R.string.cancel, new f(this, game2GroupShareDialogView));
            aVar.create(getPageContext()).show();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.navigationBar.onChangeSkinType(getPageContext(), i2);
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.onChangeSkinType(getPageContext(), i2);
            }
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(findViewById(R.id.select_friend_root_view));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.select_friend_main);
            this.mRootView = (LinearLayout) findViewById(R.id.select_friend_root_view);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.select_friend_nevigation_bar);
            this.navigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            this.navigationBar.setTitleText(R.string.select_friend_title);
            this.listView = (BdListView) findViewById(R.id.select_friend_listview);
            c.a.t0.u1.a.d.a aVar = new c.a.t0.u1.a.d.a(getPageContext().getPageActivity());
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
            NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, n.f(getActivity(), R.dimen.ds220)), NoDataViewFactory.e.a(R.string.select_friend_no_data_tip), null);
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
            this.mNoDataView.onActivityStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onStop();
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmShareToFriendDialog(ShareFromGameCenterMsgData shareFromGameCenterMsgData, long j2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{shareFromGameCenterMsgData, Long.valueOf(j2), str, str2, str3}) == null) {
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(getPageContext().getPageActivity());
            aVar.setContentViewSize(1);
            Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
            game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
            aVar.setContentView(game2GroupShareDialogView);
            aVar.setPositiveButton(R.string.share, new g(this, j2, shareFromGameCenterMsgData, str, str2, str3, game2GroupShareDialogView));
            aVar.setNegativeButton(R.string.cancel, new h(this, game2GroupShareDialogView));
            aVar.create(getPageContext()).show();
        }
    }
}
