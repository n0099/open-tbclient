package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import java.util.ArrayList;
import java.util.List;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes25.dex */
public class UserMuteQueryModel extends BdBaseModel {
    public static int NET_SUCCESS = 0;
    private com.baidu.adp.framework.listener.a mbF = new com.baidu.adp.framework.listener.a(1003026, CmdConfigSocket.CMD_USER_MUTE_QUERY) { // from class: com.baidu.tieba.setting.usermutelist.UserMuteQueryModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof UserMuteQuerySocketResponsedMessage) {
                UserMuteQuerySocketResponsedMessage userMuteQuerySocketResponsedMessage = (UserMuteQuerySocketResponsedMessage) responsedMessage;
                if (userMuteQuerySocketResponsedMessage.getResult() != null) {
                    List<MuteUser> list = userMuteQuerySocketResponsedMessage.getResult().mute_user;
                    ArrayList<MuteUser> arrayList = new ArrayList<>();
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                    UserMuteQueryModel.this.mcj.a(arrayList, userMuteQuerySocketResponsedMessage.getError(), userMuteQuerySocketResponsedMessage.getErrorString());
                } else {
                    return;
                }
            }
            if (responsedMessage instanceof UserMuteQueryHttpResponsedMessage) {
                UserMuteQueryHttpResponsedMessage userMuteQueryHttpResponsedMessage = (UserMuteQueryHttpResponsedMessage) responsedMessage;
                if (userMuteQueryHttpResponsedMessage.getResult() != null) {
                    List<MuteUser> list2 = userMuteQueryHttpResponsedMessage.getResult().mute_user;
                    ArrayList<MuteUser> arrayList2 = new ArrayList<>();
                    if (list2 != null) {
                        for (MuteUser muteUser : list2) {
                            arrayList2.add(muteUser);
                        }
                    }
                    UserMuteQueryModel.this.mcj.a(arrayList2, userMuteQueryHttpResponsedMessage.getError(), userMuteQueryHttpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private a mcj;

    /* loaded from: classes25.dex */
    public interface a {
        void a(ArrayList<MuteUser> arrayList, int i, String str);
    }

    public UserMuteQueryModel(a aVar) {
        this.mcj = aVar;
        registerListener(this.mbF);
        com.baidu.tieba.tbadkCore.a.a.c(CmdConfigSocket.CMD_USER_MUTE_QUERY, UserMuteQuerySocketResponsedMessage.class, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_USER_MUTE_QUERY, 1003026, "c/u/user/userMuteQuery", UserMuteQueryHttpResponsedMessage.class, false, false, true, false);
    }

    public void d(long j, int i, int i2) {
        UserMuteQueryRequestMessage userMuteQueryRequestMessage = new UserMuteQueryRequestMessage();
        userMuteQueryRequestMessage.setUserId(j);
        userMuteQueryRequestMessage.setPn(i);
        userMuteQueryRequestMessage.setRn(i2);
        sendMessage(userMuteQueryRequestMessage);
    }

    public void gh(long j) {
        d(j, 1, 10);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mbF);
    }
}
