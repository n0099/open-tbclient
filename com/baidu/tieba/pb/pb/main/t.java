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
/* loaded from: classes4.dex */
public class t extends com.baidu.tbadk.editortools.d {
    private LocationModel ckg;
    private int ckm;
    private LocationModel.a ckt;
    private LocationModel.b cku;
    private BaseActivity<?> mContext;
    private PbEditorData.ThreadData mThreadData;
    private VoiceData.VoiceModel mVoiceModel;

    public t(EditorTools editorTools) {
        super(editorTools);
        this.ckm = 0;
        this.ckt = new LocationModel.a() { // from class: com.baidu.tieba.pb.pb.main.t.1
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void amG() {
                t.this.mContext.showToast(d.j.no_network_guide);
                t.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void onFail(String str) {
                BaseActivity baseActivity = t.this.mContext;
                if (StringUtils.isNull(str)) {
                    str = t.this.alP().getContext().getString(d.j.location_fail);
                }
                baseActivity.showToast(str);
                t.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
            public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
                if (aVar != null && !StringUtils.isNull(aVar.ceS())) {
                    t.this.b(2, true, aVar.ceS());
                } else {
                    onFail(null);
                }
            }
        };
        this.cku = new LocationModel.b() { // from class: com.baidu.tieba.pb.pb.main.t.2
            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void amH() {
                t.this.b(0, false, null);
            }

            @Override // com.baidu.tieba.tbadkCore.location.LocationModel.b
            public void oW(String str) {
                t.this.b(2, true, str);
            }
        };
    }

    public void b(BaseActivity<?> baseActivity) {
        this.mContext = baseActivity;
    }

    public void amq() {
        if (this.mThreadData != null && !StringUtils.isNull(this.mThreadData.getAuthorName()) && this.mThreadData.getAuthorId() > 0) {
            String valueOf = String.valueOf(this.mThreadData.getAuthorId());
            if (valueOf == null || valueOf.equalsIgnoreCase(TbadkCoreApplication.getCurrentAccount())) {
                com.baidu.adp.lib.util.l.showToast(this.mContext.getActivity(), d.j.can_not_send_gift_to_yourself);
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

    public void amr() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this.mContext.getActivity())));
    }

    public void ams() {
        if (!UtilHelper.isSystemLocationProviderEnabled(this.mContext.getActivity())) {
            this.mContext.showToast(d.j.location_system_permission_prompt);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            amu();
        } else if (this.ckg.ceZ()) {
            amr();
        } else {
            this.ckg.qb(false);
            b(1, true, null);
            this.ckg.ceX();
        }
    }

    private void amu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getActivity());
        aVar.gC(d.j.location_app_permission_prompt).a(d.j.isopen, new a.b() { // from class: com.baidu.tieba.pb.pb.main.t.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    t.this.b(1, true, null);
                    t.this.ckg.aNy();
                } else {
                    t.this.ckt.amG();
                }
                aVar2.dismiss();
            }
        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.main.t.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                t.this.b(0, true, null);
                aVar2.dismiss();
            }
        }).b(this.mContext.getPageContext());
        aVar.aaW();
    }

    public void amv() {
        if (this.ckg.aNu()) {
            if (this.ckg.ceZ()) {
                this.ckt.a(com.baidu.tieba.tbadkCore.location.c.ceV().getLocationData());
                return;
            }
            if (com.baidu.adp.lib.util.l.lo()) {
                this.ckg.ceX();
            }
            b(0, true, null);
            return;
        }
        b(0, false, null);
    }

    public void c(BaseActivity baseActivity) {
        this.ckg = new LocationModel(baseActivity);
        this.ckg.a(this.ckt);
        this.ckg.a(this.cku);
        if (!StringUtils.isNull(TbadkCoreApplication.getInst().getDefaultBubble()) && alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(2, 12, " "));
        }
        if (!this.ckg.aNu() && alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(20, 8, null));
        }
    }

    public BaseActivity<?> getContext() {
        return this.mContext;
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        this.mVoiceModel = voiceModel;
    }

    public int amz() {
        return this.ckm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.ckm = i;
        if (alP() != null) {
            alP().b(new com.baidu.tbadk.editortools.a(19, 8, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    public VoiceData.VoiceModel getVoiceModel() {
        return this.mVoiceModel;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }
}
