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
    private LocationModel aZT;
    private int aZZ;
    private LocationModel.a bag;
    private LocationModel.b bah;
    private BaseActivity<?> mContext;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public t(EditorTools editorTools) {
        super(editorTools);
        this.aZZ = 0;
        this.bag = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.t.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void MO() {
                t.this.mContext.showToast(e.j.no_network_guide);
                t.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void dj(String str) {
                BaseActivity baseActivity = t.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = t.this.LY().getContext().getString(e.j.location_fail);
                }
                baseActivity.showToast(str);
                t.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.bEL())) {
                    t.this.b(2, true, aVar.bEL());
                } else {
                    dj(null);
                }
            }
        };
        this.bah = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.t.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void MP() {
                t.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void hT(String str) {
                t.this.b(2, true, str);
            }
        };
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void My() {
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

    public void Mz() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void MA() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(e.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            MC();
        } else if (this.aZT.bES()) {
            Mz();
        } else {
            this.aZT.nA(false);
            b(1, true, null);
            this.aZT.bEQ();
        }
    }

    private void MC() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.db(e.j.location_app_permission_prompt).a(e.j.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.t.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    t.this.b(1, true, null);
                    t.this.aZT.ams();
                } else {
                    t.this.bag.MO();
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
        aVar.BF();
    }

    public void MD() {
        if (this.aZT.amo()) {
            if (this.aZT.bES()) {
                this.bag.a(com.baidu.tieba.tbadkCore.location.c.bEO().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.ll()) {
                this.aZT.bEQ();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public void c(BaseActivity baseActivity) {
        this.aZT = new LocationModel(baseActivity);
        this.aZT.a(this.bag);
        this.aZT.a(this.bah);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && LY() != null) {
            LY().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.aZT.amo() && LY() != null) {
            LY().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int MH() {
        return this.aZZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aZZ = i;
        if (LY() != null) {
            LY().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
