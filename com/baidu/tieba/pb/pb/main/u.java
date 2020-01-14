package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes7.dex */
public class u extends com.baidu.tbadk.editortools.d {
    private BaseActivity<?> dTQ;
    private LocationModel due;
    private int duk;
    private LocationModel.a dur;
    private LocationModel.b dus;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public u(EditorTools editorTools) {
        super(editorTools);
        this.duk = 0;
        this.dur = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.u.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void aMM() {
                u.this.dTQ.showToast(R.string.no_network_guide);
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = u.this.dTQ;
                if (StringUtils.isNull(str)) {
                    str = u.this.aLV().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.cKe())) {
                    u.this.a(2, true, aVar.cKe());
                } else {
                    onFail(null);
                }
            }
        };
        this.dus = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.u.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void aMN() {
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void uY(String str) {
                u.this.a(2, true, str);
            }
        };
    }

    public void b(BaseActivity<?> baseActivity) {
        this.dTQ = baseActivity;
    }

    public void aMv() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.dTQ.getActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.dTQ.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.f.b.toLong(this.mThreadData.getPostId(), 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.dTQ.getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_PAY_BUBBLE_CODE /* 23004 */:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                default:
                    return;
            }
        }
    }

    public void aMw() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.dTQ.getActivity())));
    }

    public void aMx() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.dTQ.getActivity())) {
            this.dTQ.showToast((int) R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            aMz();
        } else if (this.due.cKl()) {
            aMw();
        } else {
            this.due.sM(false);
            a(1, true, null);
            this.due.cKj();
        }
    }

    private void aMz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dTQ.getActivity());
        aVar.jF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.u.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    u.this.a(1, true, null);
                    u.this.due.cKn();
                } else {
                    u.this.dur.aMM();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.u.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                u.this.a(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.dTQ.getPageContext());
        aVar.aCp();
    }

    public void aMA() {
        if (this.due.bpD()) {
            if (this.due.cKl()) {
                this.dur.a(com.baidu.tieba.tbadkCore.location.c.cKg().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.isNetOk()) {
                this.due.cKj();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public void c(BaseActivity baseActivity) {
        this.due = new LocationModel(baseActivity.getPageContext());
        this.due.a(this.dur);
        this.due.a(this.dus);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(2, 12, HanziToPinyin.Token.SEPARATOR));
        }
        if (!this.due.bpD() && aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.dTQ;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int aMF() {
        return this.duk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.duk = i;
        if (aLV() != null) {
            aLV().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
