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
/* loaded from: classes22.dex */
public class w extends com.baidu.tbadk.editortools.e {
    private BaseActivity<?> fRa;
    private LocationModel fpH;
    private int fpN;
    private LocationModel.a fpU;
    private LocationModel.b fpV;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public w(EditorTools editorTools) {
        super(editorTools);
        this.fpN = 0;
        this.fpU = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.w.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bAw() {
                w.this.fRa.showToast(R.string.no_network_guide);
                w.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = w.this.fRa;
                if (StringUtils.isNull(str)) {
                    str = w.this.bzx().getContext().getString(R.string.location_fail);
                }
                baseActivity.showToast(str);
                w.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(LocationData locationData) {
                if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                    w.this.a(2, true, locationData.getFormatted_address());
                } else {
                    onFail(null);
                }
            }
        };
        this.fpV = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.w.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bAx() {
                w.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DS(String str) {
                w.this.a(2, true, str);
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.fRa = baseActivity;
    }

    public void bAe() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.fRa.getActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.fRa.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.f.b.toLong(this.mThreadData.getPostId(), 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.fRa.getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_PAY_BUBBLE_CODE /* 23004 */:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                default:
                    return;
            }
        }
    }

    public void bAf() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.fRa.getActivity())));
    }

    public void bAg() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fRa.getActivity())) {
            this.fRa.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bAj();
        } else if (this.fpH.dKH()) {
            bAf();
        } else {
            this.fpH.xw(false);
            a(1, true, null);
            this.fpH.dKF();
        }
    }

    public void bAh() {
        if (!com.baidu.tbadk.core.util.ae.checkLocationForGoogle(this.fRa.getActivity())) {
            com.baidu.tbadk.core.util.ae.c(this.fRa.getActivity(), 0);
        } else {
            bAg();
        }
    }

    private void bAj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fRa.getActivity());
        aVar.ow(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.w.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    w.this.a(1, true, null);
                    w.this.fpH.dKJ();
                } else {
                    w.this.fpU.bAw();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.w.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                w.this.a(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.fRa.getPageContext());
        aVar.bpc();
    }

    public void bAk() {
        if (this.fpH.cin()) {
            if (this.fpH.dKH()) {
                this.fpU.a(com.baidu.tieba.tbadkCore.location.b.dKC().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.isNetOk()) {
                this.fpH.dKF();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public void e(BaseActivity baseActivity) {
        this.fpH = new LocationModel(baseActivity.getPageContext());
        this.fpH.a(this.fpU);
        this.fpH.a(this.fpV);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fpH.cin() && bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.fRa;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int bAo() {
        return this.fpN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fpN = i;
        if (bzx() != null) {
            bzx().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
