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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes2.dex */
public class s extends com.baidu.tbadk.editortools.d {
    private LocationModel aMS;
    private int aMY;
    private LocationModel.a aNf;
    private LocationModel.b aNg;
    private BaseActivity<?> mContext;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public s(EditorTools editorTools) {
        super(editorTools);
        this.aMY = 0;
        this.aNf = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.s.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void HW() {
                s.this.mContext.showToast(d.k.no_network_guide);
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void gP(String str) {
                BaseActivity baseActivity = s.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = s.this.Hg().getContext().getString(d.k.location_fail);
                }
                baseActivity.showToast(str);
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bxD())) {
                    s.this.b(2, true, aVar.bxD());
                } else {
                    gP(null);
                }
            }
        };
        this.aNg = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.s.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void HX() {
                s.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void gQ(String str) {
                s.this.b(2, true, str);
            }
        };
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void HG() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.mContext.getActivity(), d.k.can_not_send_gift_to_yourself);
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

    public void HH() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void HI() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.k.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            HK();
        } else if (this.aMS.bxL()) {
            HH();
        } else {
            this.aMS.mA(false);
            b(1, true, null);
            this.aMS.bxJ();
        }
    }

    private void HK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.cc(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.s.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jD()) {
                    s.this.b(1, true, null);
                    s.this.aMS.aeS();
                } else {
                    s.this.aNf.HW();
                }
                aVar2.dismiss();
            }
        }).b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.s.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                s.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.xa();
    }

    public void HL() {
        if (this.aMS.aeO()) {
            if (this.aMS.bxL()) {
                this.aNf.a(com.baidu.tieba.tbadkCore.location.c.bxH().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.jU()) {
                this.aMS.bxJ();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public void c(BaseActivity baseActivity) {
        this.aMS = new LocationModel(baseActivity);
        this.aMS.a(this.aNf);
        this.aMS.a(this.aNg);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aMS.aeO() && Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int HP() {
        return this.aMY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aMY = i;
        if (Hg() != null) {
            Hg().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
