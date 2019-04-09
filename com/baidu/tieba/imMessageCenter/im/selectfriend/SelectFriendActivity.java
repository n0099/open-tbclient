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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.d;
import com.baidu.tieba.im.memorycache.b;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.widget.Game2GroupShareDialogView;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    private LinearLayout bFz;
    NavigationBar cPN;
    BdListView epY;
    a gwr;
    private CustomMessageListener gws;
    private CustomMessageListener gwt;
    private NoDataView mNoDataView;
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
                    SelectFriendActivity.this.gwr.setContacts(friendList);
                    SelectFriendActivity.this.gwr.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    };
    private int gwq = -1;
    private CustomMessageListener gwu = new CustomMessageListener(2001184) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.2
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
                    SelectFriendActivity.this.gwr.setContacts(contacts);
                    SelectFriendActivity.this.gwr.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    };
    private AdapterView.OnItemClickListener gwv = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tbadk.coreExtra.relationship.a item = SelectFriendActivity.this.gwr.getItem(i);
            if (item != null) {
                final long userId = item.getUserId();
                final String userName = item.getUserName();
                final String ajL = item.ajL();
                final String ajN = item.ajN();
                if (SelectFriendActivity.this.gwq == 0) {
                    if (SelectFriendActivity.this.gws == null) {
                        SelectFriendActivity.this.gws = new CustomMessageListener(2001261) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.framework.listener.MessageListener
                            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                                if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2001261) {
                                    SelectFriendActivity.this.a((ShareFromGameCenterMsgData) customResponsedMessage.getData(), userId, userName, ajN, ajL);
                                }
                            }
                        };
                        SelectFriendActivity.this.registerListener(SelectFriendActivity.this.gws);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(2001261));
                } else if (SelectFriendActivity.this.gwq == 1) {
                    if (SelectFriendActivity.this.gwt == null) {
                        SelectFriendActivity.this.gwt = new CustomMessageListener(2921015) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.framework.listener.MessageListener
                            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                                if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2921015) {
                                    SelectFriendActivity.this.b((ShareFromPBMsgData) customResponsedMessage.getData(), userId, userName, ajN, ajL);
                                }
                            }
                        };
                        SelectFriendActivity.this.registerListener(SelectFriendActivity.this.gwt);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(2921015));
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, ajL);
                    intent.putExtra("name_show", ajN);
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
        this.bFz = (LinearLayout) findViewById(d.g.select_friend_root_view);
        this.cPN = (NavigationBar) findViewById(d.g.select_friend_nevigation_bar);
        this.cPN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectFriendActivity.this.onBackPressed();
            }
        });
        this.cPN.setTitleText(d.j.select_friend_title);
        this.epY = (BdListView) findViewById(d.g.select_friend_listview);
        this.gwr = new a(getPageContext().getPageActivity());
        this.epY.setAdapter((ListAdapter) this.gwr);
        this.epY.setOnItemClickListener(this.gwv);
        registerListener(this.gwu);
        registerListener(this.httpListener);
        if (TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_LIST));
        } else {
            MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(getActivity(), d.e.ds220)), NoDataViewFactory.d.hT(d.j.select_friend_no_data_tip), null);
        this.bFz.addView(this.mNoDataView, 1);
        if (bundle != null) {
            this.gwq = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.gwq = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gws != null) {
            MessageManager.getInstance().unRegisterListener(this.gws);
            this.gws = null;
        }
        if (this.gwt != null) {
            MessageManager.getInstance().unRegisterListener(this.gwt);
            this.gwt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.cPN.onChangeSkinType(getPageContext(), i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(d.g.select_friend_root_view));
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
    public void b(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.gE(1);
        final Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
        game2GroupShareDialogView.setShareData(shareFromPBMsgData);
        aVar.az(game2GroupShareDialogView);
        aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long aX = b.buC().aX(String.valueOf(j), 2);
                MessageUtils.createPersonalChatMessage(aX, 9, shareFromPBMsgData.toChatMessageContent(), j, str, str2, str3);
                MessageUtils.createPersonalChatMessage(aX + 1, 1, game2GroupShareDialogView.getLeaveMsg(), j, str, str2, str3);
                aVar2.dismiss();
                SelectFriendActivity.this.setResult(-1);
                if (!j.kY()) {
                    SelectFriendActivity.this.showToast(SelectFriendActivity.this.getPageContext().getString(d.j.no_network_guide));
                } else {
                    BdToast.c(SelectFriendActivity.this.getPageContext().getPageActivity(), SelectFriendActivity.this.getPageContext().getPageActivity().getString(d.j.share_alert_success), d.f.icon_toast_game_ok).abe();
                }
                SelectFriendActivity.this.finish();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ((InputMethodManager) SelectFriendActivity.this.getPageContext().getPageActivity().getSystemService("input_method")).hideSoftInputFromWindow(game2GroupShareDialogView.getWindowToken(), 2);
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).aaW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ShareFromGameCenterMsgData shareFromGameCenterMsgData, final long j, final String str, final String str2, final String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.gE(1);
        final Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
        game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
        aVar.az(game2GroupShareDialogView);
        aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long aX = b.buC().aX(String.valueOf(j), 2);
                MessageUtils.createPersonalChatMessage(aX, 9, shareFromGameCenterMsgData.toChatMessageContent(), j, str, str2, str3);
                MessageUtils.createPersonalChatMessage(aX + 1, 1, game2GroupShareDialogView.getLeaveMsg(), j, str, str2, str3);
                aVar2.dismiss();
                SelectFriendActivity.this.setResult(-1);
                if (!j.kY()) {
                    SelectFriendActivity.this.showToast(SelectFriendActivity.this.getPageContext().getString(d.j.no_network_guide));
                }
                SelectFriendActivity.this.finish();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                ((InputMethodManager) SelectFriendActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(game2GroupShareDialogView.getWindowToken(), 2);
            }
        });
        aVar.b(getPageContext()).aaW();
    }
}
