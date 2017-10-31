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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.view.f;
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
    private LinearLayout aLG;
    BdListView bZH;
    NavigationBar bcB;
    a dQj;
    private CustomMessageListener dQk;
    private CustomMessageListener dQl;
    private f mNoDataView;
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
                    SelectFriendActivity.this.dQj.setContacts(friendList);
                    SelectFriendActivity.this.dQj.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    };
    private int dQi = -1;
    private CustomMessageListener dQm = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_CONTACT_LIST) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.2
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
                    SelectFriendActivity.this.dQj.setContacts(contacts);
                    SelectFriendActivity.this.dQj.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    };
    private AdapterView.OnItemClickListener dQn = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tbadk.coreExtra.relationship.a item = SelectFriendActivity.this.dQj.getItem(i);
            if (item != null) {
                final long userId = item.getUserId();
                final String userName = item.getUserName();
                final String At = item.At();
                if (SelectFriendActivity.this.dQi == 0) {
                    if (SelectFriendActivity.this.dQk == null) {
                        SelectFriendActivity.this.dQk = new CustomMessageListener(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.framework.listener.MessageListener
                            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                                if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2001261) {
                                    SelectFriendActivity.this.a((ShareFromGameCenterMsgData) customResponsedMessage.getData(), userId, userName, At);
                                }
                            }
                        };
                        SelectFriendActivity.this.registerListener(SelectFriendActivity.this.dQk);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA));
                } else if (SelectFriendActivity.this.dQi == 1) {
                    if (SelectFriendActivity.this.dQl == null) {
                        SelectFriendActivity.this.dQl = new CustomMessageListener(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.framework.listener.MessageListener
                            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                                if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2921015) {
                                    SelectFriendActivity.this.b((ShareFromPBMsgData) customResponsedMessage.getData(), userId, userName, At);
                                }
                            }
                        };
                        SelectFriendActivity.this.registerListener(SelectFriendActivity.this.dQl);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA));
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, At);
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
        setContentView(d.h.select_friend_main);
        this.aLG = (LinearLayout) findViewById(d.g.select_friend_root_view);
        this.bcB = (NavigationBar) findViewById(d.g.select_friend_nevigation_bar);
        this.bcB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectFriendActivity.this.onBackPressed();
            }
        });
        this.bcB.setTitleText(d.j.select_friend_title);
        this.bZH = (BdListView) findViewById(d.g.select_friend_listview);
        this.dQj = new a(getPageContext().getPageActivity());
        this.bZH.setAdapter((ListAdapter) this.dQj);
        this.bZH.setOnItemClickListener(this.dQn);
        registerListener(this.dQm);
        registerListener(this.httpListener);
        if (TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_LIST));
        } else {
            MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(getActivity(), d.e.ds220)), NoDataViewFactory.d.dq(d.j.select_friend_no_data_tip), null);
        this.aLG.addView(this.mNoDataView, 1);
        if (bundle != null) {
            this.dQi = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.dQi = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dQk != null) {
            MessageManager.getInstance().unRegisterListener(this.dQk);
            this.dQk = null;
        }
        if (this.dQl != null) {
            MessageManager.getInstance().unRegisterListener(this.dQl);
            this.dQl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bcB.onChangeSkinType(getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(findViewById(d.g.select_friend_root_view));
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
        aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long ak = com.baidu.tieba.im.memorycache.b.aAc().ak(String.valueOf(j), 2);
                MessageUtils.createPersonalChatMessage(ak, 9, shareFromPBMsgData.toChatMessageContent(), j, str, str2);
                MessageUtils.createPersonalChatMessage(ak + 1, 1, bVar.getLeaveMsg(), j, str, str2);
                aVar2.dismiss();
                SelectFriendActivity.this.setResult(-1);
                if (!j.hh()) {
                    SelectFriendActivity.this.showToast(SelectFriendActivity.this.getPageContext().getString(d.j.no_network_guide));
                } else {
                    BdToast.b(SelectFriendActivity.this.getPageContext().getPageActivity(), SelectFriendActivity.this.getPageContext().getPageActivity().getString(d.j.share_alert_success), d.f.icon_toast_game_ok).tq();
                }
                SelectFriendActivity.this.finish();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ((InputMethodManager) SelectFriendActivity.this.getPageContext().getPageActivity().getSystemService("input_method")).hideSoftInputFromWindow(bVar.getWindowToken(), 2);
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ShareFromGameCenterMsgData shareFromGameCenterMsgData, final long j, final String str, final String str2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ce(1);
        final b bVar = new b(getPageContext().getPageActivity());
        bVar.setData(shareFromGameCenterMsgData);
        aVar.v(bVar);
        aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long ak = com.baidu.tieba.im.memorycache.b.aAc().ak(String.valueOf(j), 2);
                MessageUtils.createPersonalChatMessage(ak, 9, shareFromGameCenterMsgData.toChatMessageContent(), j, str, str2);
                MessageUtils.createPersonalChatMessage(ak + 1, 1, bVar.getLeaveMsg(), j, str, str2);
                aVar2.dismiss();
                SelectFriendActivity.this.setResult(-1);
                if (!j.hh()) {
                    SelectFriendActivity.this.showToast(SelectFriendActivity.this.getPageContext().getString(d.j.no_network_guide));
                }
                SelectFriendActivity.this.finish();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                ((InputMethodManager) SelectFriendActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(bVar.getWindowToken(), 2);
            }
        });
        aVar.b(getPageContext()).th();
    }
}
