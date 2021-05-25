package com.baidu.tieba.ueg;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.c.e.p.j;
/* loaded from: classes5.dex */
public class UEGCancelModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f21163e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.c.c.g.a f21164f = new a(CmdConfigHttp.CMD_UEG_CANCEL, 309615);

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            UEGCancelResponsedMessage uEGCancelResponsedMessage;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof UEGCancelSocketResponseMessage;
            if ((z || (responsedMessage instanceof UEGCancelResponsedMessage)) && UEGCancelModel.this.f21163e != null) {
                if (z) {
                    UEGCancelSocketResponseMessage uEGCancelSocketResponseMessage = (UEGCancelSocketResponseMessage) responsedMessage;
                    if (uEGCancelSocketResponseMessage != null && uEGCancelSocketResponseMessage.getError() == 0) {
                        UEGCancelModel.this.f21163e.a(uEGCancelSocketResponseMessage.getData());
                    }
                } else if ((responsedMessage instanceof UEGCancelResponsedMessage) && (uEGCancelResponsedMessage = (UEGCancelResponsedMessage) responsedMessage) != null && uEGCancelResponsedMessage.getError() == 0) {
                    UEGCancelModel.this.f21163e.a(uEGCancelResponsedMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(BlockPopInfoData blockPopInfoData);
    }

    public UEGCancelModel() {
        d.a.n0.e3.d0.a.h(309615, UEGCancelSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309615, CmdConfigHttp.CMD_UEG_CANCEL, "c/f/forum/queryBlockAndAppealInfo", UEGCancelResponsedMessage.class, false, false, true, false);
        registerListener(this.f21164f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f21164f);
    }

    public void t() {
        if (!j.z() || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        UEGCancelRequestMessage uEGCancelRequestMessage = new UEGCancelRequestMessage();
        uEGCancelRequestMessage.setUser_id(TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(uEGCancelRequestMessage);
    }

    public void u(b bVar) {
        this.f21163e = bVar;
    }
}
