package com.baidu.tieba.interestlabel.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.message.RequestGetLabelMessage;
import com.baidu.tieba.interestlabel.message.RequestSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseHttpSubLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketGetLabelMessage;
import com.baidu.tieba.interestlabel.message.ResponseSocketSubLabelMessage;
import d.a.c.e.p.j;
import java.util.List;
/* loaded from: classes4.dex */
public class LabelSettingModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f17819e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.i1.c.a f17820f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.i1.b.b f17821g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f17822h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f17823i;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpGetLabelMessage) || (responsedMessage instanceof ResponseSocketGetLabelMessage)) && LabelSettingModel.this.unique_id == responsedMessage.getOrginalMessage().getTag() && LabelSettingModel.this.f17820f != null) {
                LabelSettingModel.this.f17820f.callback(LabelRequestEnum.GET_LABEL, responsedMessage.getError() == 0 ? LabelSettingModel.this.f17821g : null, responsedMessage.getError());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ResponseHttpSubLabelMessage) || (responsedMessage instanceof ResponseSocketSubLabelMessage)) && LabelSettingModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getError() != 0 && !StringUtils.isNull(responsedMessage.getErrorString())) {
                    LabelSettingModel.this.f17819e.showToast(responsedMessage.getErrorString());
                }
                if (LabelSettingModel.this.f17820f == null) {
                    return;
                }
                LabelSettingModel.this.f17820f.callback(LabelRequestEnum.SUB_LABEL, null, responsedMessage.getError());
            }
        }
    }

    public LabelSettingModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f17822h = new a(CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, 309467);
        this.f17823i = new b(CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, 309468);
        this.f17819e = tbPageContext;
        this.f17821g = new d.a.n0.i1.b.b();
        registerListener(this.f17822h);
        registerListener(this.f17823i);
    }

    public void B() {
        if (!j.A()) {
            d.a.n0.i1.c.a aVar = this.f17820f;
            if (aVar != null) {
                aVar.callback(LabelRequestEnum.GET_LABEL, null, -1);
                return;
            }
            return;
        }
        RequestGetLabelMessage requestGetLabelMessage = new RequestGetLabelMessage();
        requestGetLabelMessage.setFrom(1);
        requestGetLabelMessage.setLabelDataSet(this.f17821g);
        requestGetLabelMessage.setTag(this.unique_id);
        sendMessage(requestGetLabelMessage);
    }

    public void C(List<Integer> list) {
        if (!j.A()) {
            this.f17819e.showToast(R.string.neterror);
            return;
        }
        RequestSubLabelMessage requestSubLabelMessage = new RequestSubLabelMessage();
        requestSubLabelMessage.setLabelList(list);
        requestSubLabelMessage.setTag(this.unique_id);
        sendMessage(requestSubLabelMessage);
    }

    public void D(d.a.n0.i1.c.a aVar) {
        this.f17820f = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }
}
