package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes6.dex */
public class t extends com.baidu.tbadk.editortools.d {
    private LocationModel aVD;
    private int aVJ;
    private LocationModel.a aVQ;
    private LocationModel.b aVR;
    private BaseActivity<?> mContext;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public t(EditorTools editorTools) {
        super(editorTools);
        this.aVJ = 0;
        this.aVQ = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.t.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void Lx() {
                t.this.mContext.showToast(e.j.no_network_guide);
                t.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void hz(String str) {
                BaseActivity baseActivity = t.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = t.this.KH().getContext().getString(e.j.location_fail);
                }
                baseActivity.showToast(str);
                t.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bCD())) {
                    t.this.b(2, true, aVar.bCD());
                } else {
                    hz(null);
                }
            }
        };
        this.aVR = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.t.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void Ly() {
                t.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void hA(String str) {
                t.this.b(2, true, str);
            }
        };
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void Lh() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.mContext.getActivity(), e.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.mContext.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.d(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.g.b.d(this.mThreadData.getPostId(), 0L))));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 11025:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.mContext.getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
                default:
                    return;
            }
        }
    }

    public void Li() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void Lj() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(e.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Ll();
        } else if (this.aVD.bCL()) {
            Li();
        } else {
            this.aVD.nk(false);
            b(1, true, null);
            this.aVD.bCJ();
        }
    }

    private void Ll() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cz(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.t.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kX()) {
                    t.this.b(1, true, null);
                    t.this.aVD.aln();
                } else {
                    t.this.aVQ.Lx();
                }
                aVar2.dismiss();
            }
        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.t.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                t.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.Au();
    }

    public void Lm() {
        if (this.aVD.alj()) {
            if (this.aVD.bCL()) {
                this.aVQ.a(com.baidu.tieba.tbadkCore.location.c.bCH().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.lo()) {
                this.aVD.bCJ();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public void c(BaseActivity baseActivity) {
        this.aVD = new LocationModel(baseActivity);
        this.aVD.a(this.aVQ);
        this.aVD.a(this.aVR);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aVD.alj() && KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int Lq() {
        return this.aVJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aVJ = i;
        if (KH() != null) {
            KH().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
