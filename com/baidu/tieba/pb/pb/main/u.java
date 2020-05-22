package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes9.dex */
public class u extends com.baidu.tbadk.editortools.d {
    private BaseActivity<?> eNb;
    private LocationModel emG;
    private int emM;
    private LocationModel.a emT;
    private LocationModel.b emU;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public u(EditorTools editorTools) {
        super(editorTools);
        this.emM = 0;
        this.emT = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.u.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bdN() {
                u.this.eNb.showToast(R.string.no_network_guide);
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = u.this.eNb;
                if (StringUtils.isNull(str)) {
                    str = u.this.bcW().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.dea())) {
                    u.this.a(2, true, aVar.dea());
                } else {
                    onFail(null);
                }
            }
        };
        this.emU = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.u.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bdO() {
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void yn(String str) {
                u.this.a(2, true, str);
            }
        };
    }

    public void b(BaseActivity<?> baseActivity) {
        this.eNb = baseActivity;
    }

    public void bdw() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.eNb.getActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eNb.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.f.b.toLong(this.mThreadData.getPostId(), 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eNb.getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_PAY_BUBBLE_CODE /* 23004 */:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                default:
                    return;
            }
        }
    }

    public void bdx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eNb.getActivity())));
    }

    public void bdy() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eNb.getActivity())) {
            this.eNb.showToast((int) R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdA();
        } else if (this.emG.deh()) {
            bdx();
        } else {
            this.emG.uw(false);
            a(1, true, null);
            this.emG.def();
        }
    }

    private void bdA() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNb.getActivity());
        aVar.kD(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.u.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    u.this.a(1, true, null);
                    u.this.emG.dej();
                } else {
                    u.this.emT.bdN();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.u.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                u.this.a(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.eNb.getPageContext());
        aVar.aST();
    }

    public void bdB() {
        if (this.emG.bHm()) {
            if (this.emG.deh()) {
                this.emT.a(com.baidu.tieba.tbadkCore.location.c.dec().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.isNetOk()) {
                this.emG.def();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public void c(BaseActivity baseActivity) {
        this.emG = new LocationModel(baseActivity.getPageContext());
        this.emG.a(this.emT);
        this.emG.a(this.emU);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.emG.bHm() && bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.eNb;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int bdG() {
        return this.emM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.emM = i;
        if (bcW() != null) {
            bcW().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
