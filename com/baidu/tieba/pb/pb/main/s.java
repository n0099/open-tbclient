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
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes2.dex */
public class s extends com.baidu.tbadk.editortools.f {
    private LocationModel btW;
    private int buc;
    private LocationModel.a buk;
    private LocationModel.b bul;
    private BaseActivity<?> mContext;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public s(com.baidu.tbadk.editortools.i iVar) {
        super(iVar);
        this.buc = 0;
        this.buk = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void LR() {
                s.this.mContext.showToast(d.j.no_network_guide);
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gA(String str) {
                BaseActivity baseActivity = s.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = s.this.Lc().getContext().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bxA())) {
                    s.this.b(2, true, aVar.bxA());
                } else {
                    gA(null);
                }
            }
        };
        this.bul = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.s.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void LS() {
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gB(String str) {
                s.this.b(2, true, str);
            }
        };
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void LC() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.mContext.getActivity(), d.j.can_not_send_gift_to_yourself);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.mContext.getActivity(), this.mThreadData.getAuthorId(), this.mThreadData.getAuthorName(), this.mThreadData.getAuthorNameShow(), GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.g.b.c(this.mThreadData.getThreadId(), 0L), com.baidu.adp.lib.g.b.c(this.mThreadData.getPostId(), 0L))));
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

    public void LD() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void LE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            LF();
        } else if (this.btW.bxI()) {
            LD();
        } else {
            this.btW.mR(false);
            b(1, true, null);
            this.btW.bxG();
        }
    }

    private void LF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.fb(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.s.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    s.this.b(1, true, null);
                    s.this.btW.ahm();
                } else {
                    s.this.buk.LR();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                s.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.AV();
    }

    public void LG() {
        if (this.btW.ahi()) {
            if (this.btW.bxI()) {
                this.buk.a(com.baidu.tieba.tbadkCore.location.c.bxE().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.pa()) {
                this.btW.bxG();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public void c(BaseActivity baseActivity) {
        this.btW = new LocationModel(baseActivity);
        this.btW.a(this.buk);
        this.btW.a(this.bul);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.btW.ahi() && Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int LK() {
        return this.buc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.buc = i;
        if (Lc() != null) {
            Lc().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
