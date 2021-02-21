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
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes2.dex */
public class s extends com.baidu.tbadk.editortools.e {
    private LocationModel fDG;
    private int fDM;
    private LocationModel.a fDU;
    private LocationModel.b fDV;
    private BaseActivity<?> ggm;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public s(EditorTools editorTools) {
        super(editorTools);
        this.fDM = 0;
        this.fDU = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bCh() {
                s.this.ggm.showToast(R.string.no_network_guide);
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = s.this.ggm;
                if (StringUtils.isNull(str)) {
                    str = s.this.bBh().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(LocationData locationData) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    s.this.b(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        };
        this.fDV = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.s.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bCi() {
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void CZ(String str) {
                s.this.b(2, true, str);
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.ggm = baseActivity;
    }

    public void bBO() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.ggm.getActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.ggm.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.f.b.toLong(this.mThreadData.getPostId(), 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ggm.getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_PAY_BUBBLE_CODE /* 23004 */:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                default:
                    return;
            }
        }
    }

    public void bBP() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.ggm.getActivity())));
    }

    public void bBQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.ggm.getActivity())) {
            this.ggm.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBT();
        } else if (this.fDG.dOx()) {
            bBP();
        } else {
            this.fDG.yC(false);
            b(1, true, null);
            this.fDG.dOv();
        }
    }

    public void bBR() {
        if (!com.baidu.tbadk.core.util.ae.checkLocationForGoogle(this.ggm.getActivity())) {
            com.baidu.tbadk.core.util.ae.c(this.ggm.getActivity(), 0);
        } else {
            bBQ();
        }
    }

    private void bBT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ggm.getActivity());
        aVar.nx(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.s.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    s.this.b(1, true, null);
                    s.this.fDG.dOz();
                } else {
                    s.this.fDU.bCh();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                s.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.ggm.getPageContext());
        aVar.bqx();
    }

    public void bBU() {
        if (this.fDG.clH()) {
            if (this.fDG.dOx()) {
                this.fDU.a(com.baidu.tieba.tbadkCore.location.b.dOs().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.isNetOk()) {
                this.fDG.dOv();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public void e(BaseActivity baseActivity) {
        this.fDG = new LocationModel(baseActivity.getPageContext());
        this.fDG.a(this.fDU);
        this.fDG.a(this.fDV);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fDG.clH() && bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.ggm;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int bBY() {
        return this.fDM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fDM = i;
        if (bBh() != null) {
            bBh().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
