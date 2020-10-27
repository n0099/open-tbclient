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
    private BaseActivity<?> fLk;
    private LocationModel fjP;
    private int fjV;
    private LocationModel.a fkc;
    private LocationModel.b fkd;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public w(EditorTools editorTools) {
        super(editorTools);
        this.fjV = 0;
        this.fkc = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.w.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void bxX() {
                w.this.fLk.showToast(R.string.no_network_guide);
                w.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = w.this.fLk;
                if (StringUtils.isNull(str)) {
                    str = w.this.bwY().getContext().getString(R.string.location_fail);
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
        this.fkd = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.w.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void bxY() {
                w.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DE(String str) {
                w.this.a(2, true, str);
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.fLk = baseActivity;
    }

    public void bxF() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.fLk.getActivity(), R.string.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.fLk.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.f.b.toLong(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.f.b.toLong(this.mThreadData.getPostId(), 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_AT /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.fLk.getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                    return;
                case RequestResponseCode.REQUEST_PAY_BUBBLE_CODE /* 23004 */:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                default:
                    return;
            }
        }
    }

    public void bxG() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.fLk.getActivity())));
    }

    public void bxH() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.fLk.getActivity())) {
            this.fLk.showToast(R.string.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bxK();
        } else if (this.fjP.dIf()) {
            bxG();
        } else {
            this.fjP.xn(false);
            a(1, true, null);
            this.fjP.dId();
        }
    }

    public void bxI() {
        if (!com.baidu.tbadk.core.util.ae.checkLocationForGoogle(this.fLk.getActivity())) {
            com.baidu.tbadk.core.util.ae.c(this.fLk.getActivity(), 0);
        } else {
            bxH();
        }
    }

    private void bxK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fLk.getActivity());
        aVar.om(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.w.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    w.this.a(1, true, null);
                    w.this.fjP.dIh();
                } else {
                    w.this.fkc.bxX();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.w.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                w.this.a(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.fLk.getPageContext());
        aVar.bmC();
    }

    public void bxL() {
        if (this.fjP.cfL()) {
            if (this.fjP.dIf()) {
                this.fkc.a(com.baidu.tieba.tbadkCore.location.b.dIa().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.isNetOk()) {
                this.fjP.dId();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public void e(BaseActivity baseActivity) {
        this.fjP = new LocationModel(baseActivity.getPageContext());
        this.fjP.a(this.fkc);
        this.fjP.a(this.fkd);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.fjP.cfL() && bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.fLk;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int bxP() {
        return this.fjV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fjV = i;
        if (bwY() != null) {
            bwY().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
