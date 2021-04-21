package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.model.message.AddPollPostHttpResponseMessage;
import com.baidu.tieba.model.message.AddPollPostRequestNetMessage;
import com.baidu.tieba.model.message.AddPollPostSocketResponseMessage;
/* loaded from: classes3.dex */
public class AddPollPostModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f18714e;

    /* renamed from: f  reason: collision with root package name */
    public long f18715f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f18716g;

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            if (responsedMessage != null && (responsedMessage.getOrginalMessage().getExtra() instanceof AddPollPostRequestNetMessage) && AddPollPostModel.this.f18715f == ((AddPollPostRequestNetMessage) responsedMessage.getOrginalMessage().getExtra()).getThreadId()) {
                boolean z = responsedMessage instanceof AddPollPostHttpResponseMessage;
                if (z || (responsedMessage instanceof AddPollPostSocketResponseMessage)) {
                    AddPollPostHttpResponseMessage addPollPostHttpResponseMessage = z ? (AddPollPostHttpResponseMessage) responsedMessage : null;
                    AddPollPostSocketResponseMessage addPollPostSocketResponseMessage = responsedMessage instanceof AddPollPostSocketResponseMessage ? (AddPollPostSocketResponseMessage) responsedMessage : null;
                    int i = 0;
                    if (responsedMessage.getError() != 0) {
                        i = responsedMessage.getError();
                        str = responsedMessage.getErrorString();
                    } else if (addPollPostHttpResponseMessage != null && addPollPostHttpResponseMessage.getIdl() != null && addPollPostHttpResponseMessage.getIdl().data != null && addPollPostHttpResponseMessage.getIdl().data.error_code.intValue() != 0) {
                        i = addPollPostHttpResponseMessage.getIdl().data.error_code.intValue();
                        str = addPollPostHttpResponseMessage.getIdl().data.error_msg;
                    } else if (addPollPostSocketResponseMessage == null || addPollPostSocketResponseMessage.getIdl() == null || addPollPostSocketResponseMessage.getIdl().data == null || addPollPostSocketResponseMessage.getIdl().data.error_code.intValue() == 0) {
                        str = "";
                    } else {
                        i = addPollPostSocketResponseMessage.getIdl().data.error_code.intValue();
                        str = addPollPostSocketResponseMessage.getIdl().data.error_msg;
                    }
                    if (AddPollPostModel.this.f18714e != null) {
                        AddPollPostModel.this.f18714e.a(i, str);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str);
    }

    public AddPollPostModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f18716g = new a(CmdConfigHttp.CMD_ADD_POLL_POST, 309006);
        v();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void registerListener() {
        registerListener(this.f18716g);
    }

    public void u(String str, String str2, long j) {
        AddPollPostRequestNetMessage addPollPostRequestNetMessage = new AddPollPostRequestNetMessage();
        addPollPostRequestNetMessage.setThreadId(d.b.c.e.m.b.f(str, 0L));
        addPollPostRequestNetMessage.setOptions(str2);
        addPollPostRequestNetMessage.setForumId(j);
        sendMessage(addPollPostRequestNetMessage);
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.f18716g);
    }

    public final void v() {
        d.b.j0.d3.d0.a.h(309006, AddPollPostSocketResponseMessage.class, false, false);
        d.b.j0.d3.d0.a.c(309006, CmdConfigHttp.CMD_ADD_POLL_POST, TbConfig.VOTE_ADD, AddPollPostHttpResponseMessage.class, false, false, false, false);
    }

    public void w(b bVar) {
        this.f18714e = bVar;
    }

    public void x(long j) {
        this.f18715f = j;
    }
}
