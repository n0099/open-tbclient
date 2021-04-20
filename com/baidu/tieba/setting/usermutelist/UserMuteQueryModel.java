package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import java.util.ArrayList;
import java.util.List;
import tbclient.UserMuteQuery.MuteUser;
/* loaded from: classes4.dex */
public class UserMuteQueryModel extends BdBaseModel {
    public static int NET_SUCCESS;

    /* renamed from: e  reason: collision with root package name */
    public b f20785e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.c.c.g.a f20786f;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
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
                UserMuteQueryModel.this.f20785e.a(arrayList, userMuteQuerySocketResponsedMessage.getError(), userMuteQuerySocketResponsedMessage.getErrorString());
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
                UserMuteQueryModel.this.f20785e.a(arrayList2, userMuteQueryHttpResponsedMessage.getError(), userMuteQueryHttpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(ArrayList<MuteUser> arrayList, int i, String str);
    }

    public UserMuteQueryModel(b bVar) {
        a aVar = new a(CmdConfigHttp.CMD_USER_MUTE_QUERY, 303028);
        this.f20786f = aVar;
        this.f20785e = bVar;
        registerListener(aVar);
        d.b.i0.d3.d0.a.f(303028, UserMuteQuerySocketResponsedMessage.class, false);
        d.b.i0.d3.d0.a.c(303028, CmdConfigHttp.CMD_USER_MUTE_QUERY, TbConfig.USER_MUTE_QUERY, UserMuteQueryHttpResponsedMessage.class, false, false, true, false);
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
        MessageManager.getInstance().unRegisterListener(this.f20786f);
    }

    public void t(long j) {
        u(j, 1, 10);
    }

    public void u(long j, int i, int i2) {
        UserMuteQueryRequestMessage userMuteQueryRequestMessage = new UserMuteQueryRequestMessage();
        userMuteQueryRequestMessage.setUserId(j);
        userMuteQueryRequestMessage.setPn(i);
        userMuteQueryRequestMessage.setRn(i2);
        sendMessage(userMuteQueryRequestMessage);
    }
}
