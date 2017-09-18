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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.widget.b;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    private LinearLayout aLH;
    BdListView bSE;
    NavigationBar baw;
    a dMt;
    private CustomMessageListener dMu;
    private CustomMessageListener dMv;
    private j mNoDataView;
    private HttpMessageListener httpListener = new HttpMessageListener(CmdConfigHttp.CMD_GET_FRIEND_LIST) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null && (httpResponsedMessage instanceof ResponseFriendListMessage)) {
                LinkedList<com.baidu.tbadk.coreExtra.relationship.a> friendList = ((ResponseFriendListMessage) httpResponsedMessage).getFriendList();
                if (friendList == null) {
                    friendList = new LinkedList<>();
                }
                if (friendList.size() > 0) {
                    SelectFriendActivity.this.mNoDataView.setVisibility(8);
                    SelectFriendActivity.this.dMt.setContacts(friendList);
                    SelectFriendActivity.this.dMt.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    };
    private int dMs = -1;
    private CustomMessageListener dMw = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_CONTACT_LIST) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof GetContactListResponsedMessage) {
                List<com.baidu.tbadk.coreExtra.relationship.a> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
                if (contacts == null) {
                    contacts = new LinkedList<>();
                }
                if (contacts.size() > 0) {
                    SelectFriendActivity.this.mNoDataView.setVisibility(8);
                    SelectFriendActivity.this.dMt.setContacts(contacts);
                    SelectFriendActivity.this.dMt.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    };
    private AdapterView.OnItemClickListener dMx = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tbadk.coreExtra.relationship.a item = SelectFriendActivity.this.dMt.getItem(i);
            if (item != null) {
                final long userId = item.getUserId();
                final String userName = item.getUserName();
                final String AS = item.AS();
                if (SelectFriendActivity.this.dMs == 0) {
                    if (SelectFriendActivity.this.dMu == null) {
                        SelectFriendActivity.this.dMu = new CustomMessageListener(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.framework.listener.MessageListener
                            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                                if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2001261) {
                                    SelectFriendActivity.this.a((ShareFromGameCenterMsgData) customResponsedMessage.getData(), userId, userName, AS);
                                }
                            }
                        };
                        SelectFriendActivity.this.registerListener(SelectFriendActivity.this.dMu);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA));
                } else if (SelectFriendActivity.this.dMs == 1) {
                    if (SelectFriendActivity.this.dMv == null) {
                        SelectFriendActivity.this.dMv = new CustomMessageListener(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.framework.listener.MessageListener
                            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                                if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2921015) {
                                    SelectFriendActivity.this.b((ShareFromPBMsgData) customResponsedMessage.getData(), userId, userName, AS);
                                }
                            }
                        };
                        SelectFriendActivity.this.registerListener(SelectFriendActivity.this.dMv);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA));
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, AS);
                    SelectFriendActivity.this.setResult(-1, intent);
                    SelectFriendActivity.this.finish();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.select_friend_main);
        this.aLH = (LinearLayout) findViewById(d.h.select_friend_root_view);
        this.baw = (NavigationBar) findViewById(d.h.select_friend_nevigation_bar);
        this.baw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectFriendActivity.this.onBackPressed();
            }
        });
        this.baw.setTitleText(d.l.select_friend_title);
        this.bSE = (BdListView) findViewById(d.h.select_friend_listview);
        this.dMt = new a(getPageContext().getPageActivity());
        this.bSE.setAdapter((ListAdapter) this.dMt);
        this.bSE.setOnItemClickListener(this.dMx);
        registerListener(this.dMw);
        registerListener(this.httpListener);
        if (TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_LIST));
        } else {
            MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, k.f(getActivity(), d.f.ds220)), NoDataViewFactory.d.dl(d.l.select_friend_no_data_tip), null);
        this.aLH.addView(this.mNoDataView, 1);
        if (bundle != null) {
            this.dMs = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.dMs = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dMu != null) {
            MessageManager.getInstance().unRegisterListener(this.dMu);
            this.dMu = null;
        }
        if (this.dMv != null) {
            MessageManager.getInstance().unRegisterListener(this.dMv);
            this.dMv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.baw.onChangeSkinType(getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(findViewById(d.h.select_friend_root_view));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mNoDataView.e(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mNoDataView.onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ce(1);
        final b bVar = new b(getPageContext().getPageActivity());
        bVar.setShareData(shareFromPBMsgData);
        aVar.v(bVar);
        aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long af = com.baidu.tieba.im.memorycache.b.aza().af(String.valueOf(j), 2);
                MessageUtils.createPersonalChatMessage(af, 9, shareFromPBMsgData.toChatMessageContent(), j, str, str2);
                MessageUtils.createPersonalChatMessage(af + 1, 1, bVar.getLeaveMsg(), j, str, str2);
                aVar2.dismiss();
                SelectFriendActivity.this.setResult(-1);
                if (!i.hi()) {
                    SelectFriendActivity.this.showToast(SelectFriendActivity.this.getPageContext().getString(d.l.no_network_guide));
                } else {
                    BdToast.b(SelectFriendActivity.this.getPageContext().getPageActivity(), SelectFriendActivity.this.getPageContext().getPageActivity().getString(d.l.share_alert_success), d.g.icon_toast_game_ok).tw();
                }
                SelectFriendActivity.this.finish();
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ((InputMethodManager) SelectFriendActivity.this.getPageContext().getPageActivity().getSystemService("input_method")).hideSoftInputFromWindow(bVar.getWindowToken(), 2);
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).to();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ShareFromGameCenterMsgData shareFromGameCenterMsgData, final long j, final String str, final String str2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ce(1);
        final b bVar = new b(getPageContext().getPageActivity());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.v(bVar);
        aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long af = com.baidu.tieba.im.memorycache.b.aza().af(String.valueOf(j), 2);
                MessageUtils.createPersonalChatMessage(af, 9, shareFromGameCenterMsgData.toChatMessageContent(), j, str, str2);
                MessageUtils.createPersonalChatMessage(af + 1, 1, bVar.getLeaveMsg(), j, str, str2);
                aVar2.dismiss();
                SelectFriendActivity.this.setResult(-1);
                if (!i.hi()) {
                    SelectFriendActivity.this.showToast(SelectFriendActivity.this.getPageContext().getString(d.l.no_network_guide));
                }
                SelectFriendActivity.this.finish();
            }
        });
        aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                ((InputMethodManager) SelectFriendActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(bVar.getWindowToken(), 2);
            }
        });
        aVar.b(getPageContext()).to();
    }
}
