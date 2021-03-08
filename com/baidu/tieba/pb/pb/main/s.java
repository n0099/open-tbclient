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
    private LocationModel fFf;
    private int fFl;
    private LocationModel.a fFt;
    private LocationModel.b fFu;
    private BaseActivity<?> ghP;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public s(EditorTools editorTools) {
        super(editorTools);
        this.fFl = 0;
        this.fFt = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bCk() {
                s.this.ghP.showToast(R.string.no_network_guide);
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = s.this.ghP;
                if (StringUtils.isNull(str)) {
                    str = s.this.bBk().getContext().getString(R.string.location_fail);
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
        this.fFu = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.s.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bCl() {
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Dg(String str) {
                s.this.b(2, true, str);
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.ghP = baseActivity;
    }

    public void bBR() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.ghP.getActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.ghP.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.f.b.toLong(this.mThreadData.getPostId(), 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ghP.getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_PAY_BUBBLE_CODE /* 23004 */:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                default:
                    return;
            }
        }
    }

    public void bBS() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.ghP.getActivity())));
    }

    public void bBT() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.ghP.getActivity())) {
            this.ghP.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBW();
        } else if (this.fFf.dOG()) {
            bBS();
        } else {
            this.fFf.yB(false);
            b(1, true, null);
            this.fFf.dOE();
        }
    }

    public void bBU() {
        if (!com.baidu.tbadk.core.util.ae.checkLocationForGoogle(this.ghP.getActivity())) {
            com.baidu.tbadk.core.util.ae.c(this.ghP.getActivity(), 0);
        } else {
            bBT();
        }
    }

    private void bBW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ghP.getActivity());
        aVar.ny(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.s.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    s.this.b(1, true, null);
                    s.this.fFf.dOI();
                } else {
                    s.this.fFt.bCk();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                s.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.ghP.getPageContext());
        aVar.bqz();
    }

    public void bBX() {
        if (this.fFf.clN()) {
            if (this.fFf.dOG()) {
                this.fFt.a(com.baidu.tieba.tbadkCore.location.b.dOB().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.isNetOk()) {
                this.fFf.dOE();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public void e(BaseActivity baseActivity) {
        this.fFf = new LocationModel(baseActivity.getPageContext());
        this.fFf.a(this.fFt);
        this.fFf.a(this.fFu);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fFf.clN() && bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.ghP;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int bCb() {
        return this.fFl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.fFl = i;
        if (bBk() != null) {
            bBk().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
