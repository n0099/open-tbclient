package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.f {
    private int aDE;
    private LocationModel.a aDL;
    private LocationModel.b aDM;
    private LocationModel aDy;
    private BaseActivity<?> mContext;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public t(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.aDE = 0;
        this.aDL = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.t.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void DS() {
                t.this.mContext.showToast(d.j.no_network_guide);
                t.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gb(String str) {
                BaseActivity baseActivity = t.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = t.this.Dd().getContext().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                t.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bwS())) {
                    t.this.a(2, true, aVar.bwS());
                } else {
                    gb(null);
                }
            }
        };
        this.aDM = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.t.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void DT() {
                t.this.a(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gc(String str) {
                t.this.a(2, true, str);
            }
        };
    }

    public void d(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void DC() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.mContext.getActivity(), d.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(this.mContext.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.g.b.c(this.mThreadData.getPostId(), 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.mContext.getActivity(), 12004, true)));
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                    return;
                default:
                    return;
            }
        }
    }

    public void DD() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void DE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            DF();
        } else if (this.aDy.bxa()) {
            DD();
        } else {
            this.aDy.ne(false);
            a(1, true, null);
            this.aDy.bwY();
        }
    }

    private void DF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cd(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.t.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.hh()) {
                    t.this.a(1, true, null);
                    t.this.aDy.YM();
                } else {
                    t.this.aDL.DS();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.t.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                t.this.a(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.tk();
    }

    public void DG() {
        if (this.aDy.YI()) {
            if (this.aDy.bxa()) {
                this.aDL.a(com.baidu.tieba.tbadkCore.location.c.bwW().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.hy()) {
                this.aDy.bwY();
            }
            a(0, true, null);
            return;
        }
        a(0, false, null);
    }

    public void e(BaseActivity baseActivity) {
        this.aDy = new LocationModel(baseActivity);
        this.aDy.a(this.aDL);
        this.aDy.a(this.aDM);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aDy.YI() && Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int DK() {
        return this.aDE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.aDE = i;
        if (Dd() != null) {
            Dd().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
