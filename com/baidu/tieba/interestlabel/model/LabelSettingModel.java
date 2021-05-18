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
    public TbPageContext<?> f17833e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.k0.h1.c.a f17834f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.h1.b.b f17835g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f17836h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f17837i;

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
            if (((responsedMessage instanceof ResponseHttpGetLabelMessage) || (responsedMessage instanceof ResponseSocketGetLabelMessage)) && LabelSettingModel.this.unique_id == responsedMessage.getOrginalMessage().getTag() && LabelSettingModel.this.f17834f != null) {
                LabelSettingModel.this.f17834f.callback(LabelRequestEnum.GET_LABEL, responsedMessage.getError() == 0 ? LabelSettingModel.this.f17835g : null, responsedMessage.getError());
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
                    LabelSettingModel.this.f17833e.showToast(responsedMessage.getErrorString());
                }
                if (LabelSettingModel.this.f17834f == null) {
                    return;
                }
                LabelSettingModel.this.f17834f.callback(LabelRequestEnum.SUB_LABEL, null, responsedMessage.getError());
            }
        }
    }

    public LabelSettingModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f17836h = new a(CmdConfigHttp.CMD_GET_INTEREST_LABEL_LIST, 309467);
        this.f17837i = new b(CmdConfigHttp.CMD_SUB_INTEREST_LABEL_LIST, 309468);
        this.f17833e = tbPageContext;
        this.f17835g = new d.a.k0.h1.b.b();
        registerListener(this.f17836h);
        registerListener(this.f17837i);
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

    public void x() {
        if (!j.A()) {
            d.a.k0.h1.c.a aVar = this.f17834f;
            if (aVar != null) {
                aVar.callback(LabelRequestEnum.GET_LABEL, null, -1);
                return;
            }
            return;
        }
        RequestGetLabelMessage requestGetLabelMessage = new RequestGetLabelMessage();
        requestGetLabelMessage.setFrom(1);
        requestGetLabelMessage.setLabelDataSet(this.f17835g);
        requestGetLabelMessage.setTag(this.unique_id);
        sendMessage(requestGetLabelMessage);
    }

    public void y(List<Integer> list) {
        if (!j.A()) {
            this.f17833e.showToast(R.string.neterror);
            return;
        }
        RequestSubLabelMessage requestSubLabelMessage = new RequestSubLabelMessage();
        requestSubLabelMessage.setLabelList(list);
        requestSubLabelMessage.setTag(this.unique_id);
        sendMessage(requestSubLabelMessage);
    }

    public void z(d.a.k0.h1.c.a aVar) {
        this.f17834f = aVar;
    }
}
