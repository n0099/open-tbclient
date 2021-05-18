package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes5.dex */
public class UserMuteQueryModel extends BdBaseModel {
    public static int NET_SUCCESS;

    /* renamed from: e  reason: collision with root package name */
    public b f20597e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f20598f;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof UserMuteQuerySocketResponsedMessage) {
                UserMuteQuerySocketResponsedMessage userMuteQuerySocketResponsedMessage = (UserMuteQuerySocketResponsedMessage) responsedMessage;
                if (userMuteQuerySocketResponsedMessage.getResult() == null) {
                    return;
                }
                List<MuteUser> list = userMuteQuerySocketResponsedMessage.getResult().mute_user;
                ArrayList<MuteUser> arrayList = new ArrayList<>();
                if (list != null) {
                    arrayList.addAll(list);
                }
                UserMuteQueryModel.this.f20597e.a(arrayList, userMuteQuerySocketResponsedMessage.getError(), userMuteQuerySocketResponsedMessage.getErrorString());
            }
            if (responsedMessage instanceof UserMuteQueryHttpResponsedMessage) {
                UserMuteQueryHttpResponsedMessage userMuteQueryHttpResponsedMessage = (UserMuteQueryHttpResponsedMessage) responsedMessage;
                if (userMuteQueryHttpResponsedMessage.getResult() == null) {
                    return;
                }
                List<MuteUser> list2 = userMuteQueryHttpResponsedMessage.getResult().mute_user;
                ArrayList<MuteUser> arrayList2 = new ArrayList<>();
                if (list2 != null) {
                    for (MuteUser muteUser : list2) {
                        arrayList2.add(muteUser);
                    }
                }
                UserMuteQueryModel.this.f20597e.a(arrayList2, userMuteQueryHttpResponsedMessage.getError(), userMuteQueryHttpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(ArrayList<MuteUser> arrayList, int i2, String str);
    }

    public UserMuteQueryModel(b bVar) {
        a aVar = new a(CmdConfigHttp.CMD_USER_MUTE_QUERY, 303028);
        this.f20598f = aVar;
        this.f20597e = bVar;
        registerListener(aVar);
        d.a.k0.d3.d0.a.f(303028, UserMuteQuerySocketResponsedMessage.class, false);
        d.a.k0.d3.d0.a.c(303028, CmdConfigHttp.CMD_USER_MUTE_QUERY, TbConfig.USER_MUTE_QUERY, UserMuteQueryHttpResponsedMessage.class, false, false, true, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f20598f);
    }

    public void t(long j) {
        u(j, 1, 10);
    }

    public void u(long j, int i2, int i3) {
        UserMuteQueryRequestMessage userMuteQueryRequestMessage = new UserMuteQueryRequestMessage();
        userMuteQueryRequestMessage.setUserId(j);
        userMuteQueryRequestMessage.setPn(i2);
        userMuteQueryRequestMessage.setRn(i3);
        sendMessage(userMuteQueryRequestMessage);
    }
}
