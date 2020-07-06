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
    private BaseActivity<?> eXy;
    private int evC;
    private LocationModel.a evJ;
    private LocationModel.b evK;
    private LocationModel evw;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public u(EditorTools editorTools) {
        super(editorTools);
        this.evC = 0;
        this.evJ = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.u.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bfT() {
                u.this.eXy.showToast(R.string.no_network_guide);
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = u.this.eXy;
                if (StringUtils.isNull(str)) {
                    str = u.this.bfa().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.diC())) {
                    u.this.a(2, true, aVar.diC());
                } else {
                    onFail(null);
                }
            }
        };
        this.evK = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.u.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bfU() {
                u.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void yG(String str) {
                u.this.a(2, true, str);
            }
        };
    }

    public void b(BaseActivity<?> baseActivity) {
        this.eXy = baseActivity;
    }

    public void bfB() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.eXy.getActivity(), (int) R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.eXy.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.f.b.toLong(this.mThreadData.getPostId(), 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eXy.getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_PAY_BUBBLE_CODE /* 23004 */:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                default:
                    return;
            }
        }
    }

    public void bfC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.eXy.getActivity())));
    }

    public void bfD() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.eXy.getActivity())) {
            this.eXy.showToast((int) R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bfG();
        } else if (this.evw.diJ()) {
            bfC();
        } else {
            this.evw.uL(false);
            a(1, true, null);
            this.evw.diH();
        }
    }

    public void bfE() {
        if (!com.baidu.tbadk.core.util.ac.checkLocationForGoogle(this.eXy.getActivity())) {
            com.baidu.tbadk.core.util.ac.d(this.eXy.getActivity(), 0);
        } else {
            bfD();
        }
    }

    private void bfG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXy.getActivity());
        aVar.kT(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.u.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    u.this.a(1, true, null);
                    u.this.evw.diL();
                } else {
                    u.this.evJ.bfT();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.u.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                u.this.a(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.eXy.getPageContext());
        aVar.aUN();
    }

    public void bfH() {
        if (this.evw.bKt()) {
            if (this.evw.diJ()) {
                this.evJ.a(com.baidu.tieba.tbadkCore.location.c.diE().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.isNetOk()) {
                this.evw.diH();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public void c(BaseActivity baseActivity) {
        this.evw = new LocationModel(baseActivity.getPageContext());
        this.evw.a(this.evJ);
        this.evw.a(this.evK);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bfa() != null) {
            bfa().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.evw.bKt() && bfa() != null) {
            bfa().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.eXy;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int bfM() {
        return this.evC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.evC = i;
        if (bfa() != null) {
            bfa().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
