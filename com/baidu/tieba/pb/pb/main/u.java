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
    private BaseActivity<?> eNm;
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
            public void bdO() {
                u.this.eNm.showToast(R.string.no_network_guide);
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = u.this.eNm;
                if (StringUtils.isNull(str)) {
                    str = u.this.bcX().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.dep())) {
                    u.this.a(2, true, aVar.dep());
                } else {
                    onFail(null);
                }
            }
        };
        this.emU = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.u.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bdP() {
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void yn(String str) {
                u.this.a(2, true, str);
            }
        };
    }

    public void b(BaseActivity<?> baseActivity) {
        this.eNm = baseActivity;
    }

    public void bdx() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.eNm.getActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eNm.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.f.b.toLong(this.mThreadData.getPostId(), 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eNm.getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_PAY_BUBBLE_CODE /* 23004 */:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                default:
                    return;
            }
        }
    }

    public void bdy() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eNm.getActivity())));
    }

    public void bdz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eNm.getActivity())) {
            this.eNm.showToast((int) R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bdB();
        } else if (this.emG.dew()) {
            bdy();
        } else {
            this.emG.uw(false);
            a(1, true, null);
            this.emG.deu();
        }
    }

    private void bdB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eNm.getActivity());
        aVar.kF(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.u.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    u.this.a(1, true, null);
                    u.this.emG.dey();
                } else {
                    u.this.emT.bdO();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.u.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                u.this.a(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.eNm.getPageContext());
        aVar.aST();
    }

    public void bdC() {
        if (this.emG.bHo()) {
            if (this.emG.dew()) {
                this.emT.a(com.baidu.tieba.tbadkCore.location.c.der().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.isNetOk()) {
                this.emG.deu();
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
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bcX() != null) {
            bcX().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.emG.bHo() && bcX() != null) {
            bcX().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.eNm;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int bdH() {
        return this.emM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.emM = i;
        if (bcX() != null) {
            bcX().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
