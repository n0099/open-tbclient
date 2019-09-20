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
import com.baidu.tieba.R;
import com.baidu.tieba.im.memorycache.b;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.widget.Game2GroupShareDialogView;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectFriendActivity extends BaseActivity<SelectFriendActivity> {
    private LinearLayout bOF;
    NavigationBar dbp;
    BdListView eMs;
    a gWC;
    private CustomMessageListener gWD;
    private CustomMessageListener gWE;
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
                    SelectFriendActivity.this.gWC.setContacts(friendList);
                    SelectFriendActivity.this.gWC.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    };
    private int gWB = -1;
    private CustomMessageListener gWF = new CustomMessageListener(2001184) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.2
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
                    SelectFriendActivity.this.gWC.setContacts(contacts);
                    SelectFriendActivity.this.gWC.notifyDataSetChanged();
                    return;
                }
                SelectFriendActivity.this.mNoDataView.setVisibility(0);
            }
        }
    };
    private AdapterView.OnItemClickListener gWG = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.tbadk.coreExtra.relationship.a item = SelectFriendActivity.this.gWC.getItem(i);
            if (item != null) {
                final long userId = item.getUserId();
                final String userName = item.getUserName();
                final String aqg = item.aqg();
                final String aqi = item.aqi();
                if (SelectFriendActivity.this.gWB == 0) {
                    if (SelectFriendActivity.this.gWD == null) {
                        SelectFriendActivity.this.gWD = new CustomMessageListener(2001261) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.framework.listener.MessageListener
                            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                                if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2001261) {
                                    SelectFriendActivity.this.a((ShareFromGameCenterMsgData) customResponsedMessage.getData(), userId, userName, aqi, aqg);
                                }
                            }
                        };
                        SelectFriendActivity.this.registerListener(SelectFriendActivity.this.gWD);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(2001261));
                } else if (SelectFriendActivity.this.gWB == 1) {
                    if (SelectFriendActivity.this.gWE == null) {
                        SelectFriendActivity.this.gWE = new CustomMessageListener(2921015) { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.4.2
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.adp.framework.listener.MessageListener
                            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                                if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2921015) {
                                    SelectFriendActivity.this.b((ShareFromPBMsgData) customResponsedMessage.getData(), userId, userName, aqi, aqg);
                                }
                            }
                        };
                        SelectFriendActivity.this.registerListener(SelectFriendActivity.this.gWE);
                    }
                    SelectFriendActivity.this.sendMessage(new CustomMessage(2921015));
                } else {
                    Intent intent = new Intent();
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
                    intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, aqg);
                    intent.putExtra("name_show", aqi);
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
        this.bOF = (LinearLayout) findViewById(R.id.select_friend_root_view);
        this.dbp = (NavigationBar) findViewById(R.id.select_friend_nevigation_bar);
        this.dbp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectFriendActivity.this.onBackPressed();
            }
        });
        this.dbp.setTitleText(R.string.select_friend_title);
        this.eMs = (BdListView) findViewById(R.id.select_friend_listview);
        this.gWC = new a(getPageContext().getPageActivity());
        this.eMs.setAdapter((ListAdapter) this.gWC);
        this.eMs.setOnItemClickListener(this.gWG);
        registerListener(this.gWF);
        registerListener(this.httpListener);
        if (TbadkCoreApplication.getInst().getIntentClass(AddressListActivityConfig.class) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_LIST));
        } else {
            MessageManager.getInstance().sendMessage(new GetContactListRequestMessage());
        }
        this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(getActivity(), R.dimen.ds220)), NoDataViewFactory.d.iQ(R.string.select_friend_no_data_tip), null);
        this.bOF.addView(this.mNoDataView, 1);
        if (bundle != null) {
            this.gWB = bundle.getInt("key_from_where");
        } else if (getIntent() != null) {
            this.gWB = getIntent().getIntExtra("key_from_where", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gWD != null) {
            MessageManager.getInstance().unRegisterListener(this.gWD);
            this.gWD = null;
        }
        if (this.gWE != null) {
            MessageManager.getInstance().unRegisterListener(this.gWE);
            this.gWE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dbp.onChangeSkinType(getPageContext(), i);
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
        this.mNoDataView.akI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final ShareFromPBMsgData shareFromPBMsgData, final long j, final String str, final String str2, final String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hy(1);
        final Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
        game2GroupShareDialogView.setShareData(shareFromPBMsgData);
        aVar.aH(game2GroupShareDialogView);
        aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long aW = b.bGb().aW(String.valueOf(j), 2);
                MessageUtils.createPersonalChatMessage(aW, 9, shareFromPBMsgData.toChatMessageContent(), j, str, str2, str3);
                MessageUtils.createPersonalChatMessage(aW + 1, 1, game2GroupShareDialogView.getLeaveMsg(), j, str, str2, str3);
                aVar2.dismiss();
                SelectFriendActivity.this.setResult(-1);
                if (!j.kc()) {
                    SelectFriendActivity.this.showToast(SelectFriendActivity.this.getPageContext().getString(R.string.no_network_guide));
                } else {
                    BdToast.b(SelectFriendActivity.this.getPageContext().getPageActivity(), SelectFriendActivity.this.getPageContext().getPageActivity().getString(R.string.share_alert_success), R.drawable.icon_pure_toast_succeed_n_svg, true).agW();
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
        aVar.b(getPageContext()).agO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ShareFromGameCenterMsgData shareFromGameCenterMsgData, final long j, final String str, final String str2, final String str3) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.hy(1);
        final Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getPageActivity());
        game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
        aVar.aH(game2GroupShareDialogView);
        aVar.a(R.string.share, new a.b() { // from class: com.baidu.tieba.imMessageCenter.im.selectfriend.SelectFriendActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                long aW = b.bGb().aW(String.valueOf(j), 2);
                MessageUtils.createPersonalChatMessage(aW, 9, shareFromGameCenterMsgData.toChatMessageContent(), j, str, str2, str3);
                MessageUtils.createPersonalChatMessage(aW + 1, 1, game2GroupShareDialogView.getLeaveMsg(), j, str, str2, str3);
                aVar2.dismiss();
                SelectFriendActivity.this.setResult(-1);
                if (!j.kc()) {
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
        aVar.b(getPageContext()).agO();
    }
}
