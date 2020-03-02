package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Context;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.R;
import com.baidu.tieba.im.memorycache.b;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.widget.Game2GroupShareDialogView;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    NavigationBar ebS;
    BdListView fOw;
    a hNr;
    private CustomMessageListener hNs;
    private CustomMessageListener hNt;
    private NoDataView mNoDataView;
    private LinearLayout mRootView;
    private HttpMessageListener httpListener = new HttpMessageListener(1003004) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.1
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
                    SelectFriendActivity.this.hNr.setContacts(friendList);
                    SelectFriendActivity.this.hNr.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    };
    private int hNq = -1;
    private CustomMessageListener hNu = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_CONTACT_LIST) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.2
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
                    SelectFriendActivity.this.hNr.setContacts(contacts);
                    SelectFriendActivity.this.hNr.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    };
    private AdapterView.OnItemClickListener hNv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tbadk.coreExtra.relationship.a item = SelectFriendActivity.this.hNr.getItem(i);
            if (item != null) {
                final long userId = item.getUserId();
                final String userName = item.getUserName();
                final String aMn = item.aMn();
                final String aMp = item.aMp();
                if (SelectFriendActivity.this.hNq == 0) {
                    if (SelectFriendActivity.this.hNs == null) {
                        SelectFriendActivity.this.hNs = new CustomMessageListener(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.framework.listener.MessageListener
                            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                                if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2001261) {
                                    SelectFriendActivity.this.a((ShareFromGameCenterMsgData) customResponsedMessage.getData(), userId, userName, aMp, aMn);
                                }
                            }
                        };
                        SelectFriendActivity.this.registerListener(SelectFriendActivity.this.hNs);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA));
                } else if (SelectFriendActivity.this.hNq == 1) {
                    if (SelectFriendActivity.this.hNt == null) {
                        SelectFriendActivity.this.hNt = new CustomMessageListener(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.framework.listener.MessageListener
                            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                                if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2921015) {
                                    SelectFriendActivity.this.b((ShareFromPBMsgData) customResponsedMessage.getData(), userId, userName, aMp, aMn);
                                }
                            }
                        };
                        SelectFriendActivity.this.registerListener(SelectFriendActivity.this.hNt);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA));
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, aMn);
                    intent.putExtra("name_show", aMp);
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
        setContentView(R.layout.select_friend_main);
        this.mRootView = (LinearLayout) findViewById(R.id.select_friend_root_view);
        this.ebS = (NavigationBar) findViewById(R.id.select_friend_nevigation_bar);
        this.ebS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectFriendActivity.this.onBackPressed();
            }
        });
        this.ebS.setTitleText(R.string.select_friend_title);
        this.fOw = (BdListView) findViewById(R.id.select_friend_listview);
        this.hNr = new a(getPageContext().getPageActivity());
        this.fOw.setAdapter((ListAdapter) this.hNr);
        this.fOw.setOnItemClickListener(this.hNv);
        registerListener(this.hNu);
        registerListener(this.httpListener);
        if (TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null) {
            sendMessage(new HttpMessage(1003004));
        } else {
            MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.ds220)), NoDataViewFactory.d.lh(R.string.select_friend_no_data_tip), null);
        this.mRootView.addView(this.mNoDataView, 1);
        if (bundle != null) {
            this.hNq = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.hNq = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hNs != null) {
            MessageManager.getInstance().unRegisterListener(this.hNs);
            this.hNs = null;
        }
        if (this.hNt != null) {
            MessageManager.getInstance().unRegisterListener(this.hNt);
            this.hNt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ebS.onChangeSkinType(getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(R.id.select_friend_root_view));
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
        this.mNoDataView.aHB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jZ(1);
        final Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
        game2GroupShareDialogView.setShareData(shareFromPBMsgData);
        aVar.aO(game2GroupShareDialogView);
        aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long aZ = b.bWI().aZ(String.valueOf(j), 2);
                MessageUtils.createPersonalChatMessage(aZ, 9, shareFromPBMsgData.toChatMessageContent(), j, str, str2, str3);
                MessageUtils.createPersonalChatMessage(aZ + 1, 1, game2GroupShareDialogView.getLeaveMsg(), j, str, str2, str3);
                aVar2.dismiss();
                SelectFriendActivity.this.setResult(-1);
                if (!j.isNetWorkAvailable()) {
                    SelectFriendActivity.this.showToast(SelectFriendActivity.this.getPageContext().getString(R.string.no_network_guide));
                } else {
                    BdToast.a((Context) SelectFriendActivity.this.getPageContext().getPageActivity(), (CharSequence) SelectFriendActivity.this.getPageContext().getPageActivity().getString(R.string.share_alert_success), (int) R.drawable.icon_pure_toast_succeed40_svg, true).aEH();
                }
                SelectFriendActivity.this.finish();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ((InputMethodManager) SelectFriendActivity.this.getPageContext().getPageActivity().getSystemService("input_method")).hideSoftInputFromWindow(game2GroupShareDialogView.getWindowToken(), 2);
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).aEC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ShareFromGameCenterMsgData shareFromGameCenterMsgData, final long j, final String str, final String str2, final String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jZ(1);
        final Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
        game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
        aVar.aO(game2GroupShareDialogView);
        aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long aZ = b.bWI().aZ(String.valueOf(j), 2);
                MessageUtils.createPersonalChatMessage(aZ, 9, shareFromGameCenterMsgData.toChatMessageContent(), j, str, str2, str3);
                MessageUtils.createPersonalChatMessage(aZ + 1, 1, game2GroupShareDialogView.getLeaveMsg(), j, str, str2, str3);
                aVar2.dismiss();
                SelectFriendActivity.this.setResult(-1);
                if (!j.isNetWorkAvailable()) {
                    SelectFriendActivity.this.showToast(SelectFriendActivity.this.getPageContext().getString(R.string.no_network_guide));
                }
                SelectFriendActivity.this.finish();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                ((InputMethodManager) SelectFriendActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(game2GroupShareDialogView.getWindowToken(), 2);
            }
        });
        aVar.b(getPageContext()).aEC();
    }
}
