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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.r.s.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    public d.a.k0.f1.a.d.a adapter;
    public CustomMessageListener discoverSharelistener;
    public CustomMessageListener gameSharelistener;
    public BdListView listView;
    public NoDataView mNoDataView;
    public LinearLayout mRootView;
    public NavigationBar navigationBar;
    public HttpMessageListener httpListener = new a(CmdConfigHttp.CMD_GET_FRIEND_LIST);
    public int keyWhereFrom = -1;
    public CustomMessageListener getFriendListListener = new b(2001184);
    public AdapterView.OnItemClickListener itemClickListener = new d();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null && (httpResponsedMessage instanceof ResponseFriendListMessage)) {
                LinkedList<d.a.j0.s.f.a> friendList = ((ResponseFriendListMessage) httpResponsedMessage).getFriendList();
                if (friendList == null) {
                    friendList = new LinkedList<>();
                }
                if (friendList.size() > 0) {
                    SelectFriendActivity.this.mNoDataView.setVisibility(8);
                    SelectFriendActivity.this.adapter.b(friendList);
                    SelectFriendActivity.this.adapter.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof GetContactListResponsedMessage) {
                List<d.a.j0.s.f.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
                if (contacts == null) {
                    contacts = new LinkedList<>();
                }
                if (contacts.size() > 0) {
                    SelectFriendActivity.this.mNoDataView.setVisibility(8);
                    SelectFriendActivity.this.adapter.b(contacts);
                    SelectFriendActivity.this.adapter.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectFriendActivity.this.onBackPressed();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.OnItemClickListener {

        /* loaded from: classes4.dex */
        public class a extends CustomMessageListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f17600a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f17601b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f17602c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f17603d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(int i2, long j, String str, String str2, String str3) {
                super(i2);
                this.f17600a = j;
                this.f17601b = str;
                this.f17602c = str2;
                this.f17603d = str3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getData() == null || customResponsedMessage.getCmd() != 2001261) {
                    return;
                }
                SelectFriendActivity.this.showConfirmShareToFriendDialog((ShareFromGameCenterMsgData) customResponsedMessage.getData(), this.f17600a, this.f17601b, this.f17602c, this.f17603d);
            }
        }

        /* loaded from: classes4.dex */
        public class b extends CustomMessageListener {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f17605a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f17606b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f17607c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f17608d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(int i2, long j, String str, String str2, String str3) {
                super(i2);
                this.f17605a = j;
                this.f17606b = str;
                this.f17607c = str2;
                this.f17608d = str3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || customResponsedMessage.getData() == null || customResponsedMessage.getCmd() != 2921015) {
                    return;
                }
                SelectFriendActivity.this.showConfirmShareToFriendDialog((ShareFromPBMsgData) customResponsedMessage.getData(), this.f17605a, this.f17606b, this.f17607c, this.f17608d);
            }
        }

        public d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.j0.s.f.a item = SelectFriendActivity.this.adapter.getItem(i2);
            if (item != null) {
                long e2 = item.e();
                String f2 = item.f();
                String h2 = item.h();
                String g2 = item.g();
                if (SelectFriendActivity.this.keyWhereFrom == 0) {
                    if (SelectFriendActivity.this.gameSharelistener == null) {
                        SelectFriendActivity.this.gameSharelistener = new a(2001261, e2, f2, g2, h2);
                        SelectFriendActivity selectFriendActivity = SelectFriendActivity.this;
                        selectFriendActivity.registerListener(selectFriendActivity.gameSharelistener);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(2001261));
                } else if (SelectFriendActivity.this.keyWhereFrom == 1) {
                    if (SelectFriendActivity.this.discoverSharelistener == null) {
                        SelectFriendActivity.this.discoverSharelistener = new b(2921015, e2, f2, g2, h2);
                        SelectFriendActivity selectFriendActivity2 = SelectFriendActivity.this;
                        selectFriendActivity2.registerListener(selectFriendActivity2.discoverSharelistener);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(2921015));
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, e2);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, f2);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, h2);
                    intent.putExtra("name_show", g2);
                    SelectFriendActivity.this.setResult(-1, intent);
                    SelectFriendActivity.this.finish();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f17610e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareFromPBMsgData f17611f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f17612g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f17613h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f17614i;
        public final /* synthetic */ Game2GroupShareDialogView j;

        public e(long j, ShareFromPBMsgData shareFromPBMsgData, String str, String str2, String str3, Game2GroupShareDialogView game2GroupShareDialogView) {
            this.f17610e = j;
            this.f17611f = shareFromPBMsgData;
            this.f17612g = str;
            this.f17613h = str2;
            this.f17614i = str3;
            this.j = game2GroupShareDialogView;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            long t = d.a.k0.e1.k.b.o().t(String.valueOf(this.f17610e), 2);
            MessageUtils.createPersonalChatMessage(t, 9, this.f17611f.toChatMessageContent(), this.f17610e, this.f17612g, this.f17613h, this.f17614i);
            MessageUtils.createPersonalChatMessage(t + 1, 1, this.j.getLeaveMsg(), this.f17610e, this.f17612g, this.f17613h, this.f17614i);
            aVar.dismiss();
            SelectFriendActivity.this.setResult(-1);
            if (!j.z()) {
                SelectFriendActivity selectFriendActivity = SelectFriendActivity.this;
                selectFriendActivity.showToast(selectFriendActivity.getPageContext().getString(R.string.no_network_guide));
            } else {
                BdToast.i(SelectFriendActivity.this.getPageContext().getPageActivity(), SelectFriendActivity.this.getPageContext().getPageActivity().getString(R.string.share_alert_success), R.drawable.icon_pure_toast_succeed40_svg, true).q();
            }
            SelectFriendActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f17615e;

        public f(Game2GroupShareDialogView game2GroupShareDialogView) {
            this.f17615e = game2GroupShareDialogView;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            ((InputMethodManager) SelectFriendActivity.this.getPageContext().getPageActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f17615e.getWindowToken(), 2);
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f17617e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ShareFromGameCenterMsgData f17618f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f17619g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f17620h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f17621i;
        public final /* synthetic */ Game2GroupShareDialogView j;

        public g(long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, String str, String str2, String str3, Game2GroupShareDialogView game2GroupShareDialogView) {
            this.f17617e = j;
            this.f17618f = shareFromGameCenterMsgData;
            this.f17619g = str;
            this.f17620h = str2;
            this.f17621i = str3;
            this.j = game2GroupShareDialogView;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            long t = d.a.k0.e1.k.b.o().t(String.valueOf(this.f17617e), 2);
            MessageUtils.createPersonalChatMessage(t, 9, this.f17618f.toChatMessageContent(), this.f17617e, this.f17619g, this.f17620h, this.f17621i);
            MessageUtils.createPersonalChatMessage(t + 1, 1, this.j.getLeaveMsg(), this.f17617e, this.f17619g, this.f17620h, this.f17621i);
            aVar.dismiss();
            SelectFriendActivity.this.setResult(-1);
            if (!j.z()) {
                SelectFriendActivity selectFriendActivity = SelectFriendActivity.this;
                selectFriendActivity.showToast(selectFriendActivity.getPageContext().getString(R.string.no_network_guide));
            }
            SelectFriendActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Game2GroupShareDialogView f17622e;

        public h(Game2GroupShareDialogView game2GroupShareDialogView) {
            this.f17622e = game2GroupShareDialogView;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
            ((InputMethodManager) SelectFriendActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(this.f17622e.getWindowToken(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmShareToFriendDialog(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2, String str3) {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(getPageContext().getPageActivity());
        aVar.setContentViewSize(1);
        Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
        game2GroupShareDialogView.setShareData(shareFromPBMsgData);
        aVar.setContentView(game2GroupShareDialogView);
        aVar.setPositiveButton(R.string.share, new e(j, shareFromPBMsgData, str, str2, str3, game2GroupShareDialogView));
        aVar.setNegativeButton(R.string.cancel, new f(game2GroupShareDialogView));
        aVar.create(getPageContext()).show();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        this.navigationBar.onChangeSkinType(getPageContext(), i2);
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i2);
        }
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(findViewById(R.id.select_friend_root_view));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.select_friend_main);
        this.mRootView = (LinearLayout) findViewById(R.id.select_friend_root_view);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.select_friend_nevigation_bar);
        this.navigationBar = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
        this.navigationBar.setTitleText(R.string.select_friend_title);
        this.listView = (BdListView) findViewById(R.id.select_friend_listview);
        d.a.k0.f1.a.d.a aVar = new d.a.k0.f1.a.d.a(getPageContext().getPageActivity());
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
        NoDataView a2 = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds220)), NoDataViewFactory.e.a(R.string.select_friend_no_data_tip), null);
        this.mNoDataView = a2;
        this.mRootView.addView(a2, 1);
        if (bundle != null) {
            this.keyWhereFrom = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.keyWhereFrom = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mNoDataView.d(getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showConfirmShareToFriendDialog(ShareFromGameCenterMsgData shareFromGameCenterMsgData, long j, String str, String str2, String str3) {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(getPageContext().getPageActivity());
        aVar.setContentViewSize(1);
        Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
        game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
        aVar.setContentView(game2GroupShareDialogView);
        aVar.setPositiveButton(R.string.share, new g(j, shareFromGameCenterMsgData, str, str2, str3, game2GroupShareDialogView));
        aVar.setNegativeButton(R.string.cancel, new h(game2GroupShareDialogView));
        aVar.create(getPageContext()).show();
    }
}
