package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.editortools.d {
    private com.baidu.tbadk.editortools.b eXD;
    private boolean eXE = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f aW(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        if (this.eXE) {
            iVar.setBarLauncherType(2);
        } else {
            iVar.setBarLauncherType(3);
        }
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.C0096d.cp_bg_line_d);
        iVar.bz(true);
        iVar.setMoreButtonAtEnd(true);
        iVar.by(true);
        return new t(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof t) {
            com.baidu.tbadk.editortools.i De = fVar.De();
            final t tVar = (t) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (tVar != null && tVar.De() != null && aVar != null) {
                        if (u.this.eXD != null) {
                            u.this.eXD.a(aVar);
                        }
                        switch (aVar.code) {
                            case 16:
                                if (u.this.a(tVar.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(tVar.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    tVar.DH();
                                    return;
                                }
                                switch (tVar.DL()) {
                                    case 0:
                                        tVar.DF();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        tVar.DE();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.bxC().nf(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                tVar.De().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case d.l.View_clickable /* 36 */:
                                if (u.this.a(tVar.getContext().getPageContext(), 11040)) {
                                    tVar.DD();
                                    return;
                                }
                                return;
                            case d.l.View_minHeight /* 43 */:
                                if (!com.baidu.tbadk.plugins.a.a(tVar.getContext().getPageContext(), true, false)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotSelectActivityConfig(tVar.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            De.a(16, bVar);
            De.a(14, bVar);
            De.a(15, bVar);
            De.a(24, bVar);
            De.a(3, bVar);
            De.a(18, bVar);
            De.a(20, bVar);
            De.a(10, bVar);
            De.a(11, bVar);
            De.a(36, bVar);
            De.a(32, bVar);
            De.a(43, bVar);
            De.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        com.baidu.tbadk.editortools.r rVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.i De = fVar.De();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.eXE) {
            arrayList.add(10);
        }
        arrayList.add(6);
        arrayList.add(9);
        if (!this.eXE) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(De.getContext(), 3);
            dVar.aCG = d.f.new_pbeditor_image_button;
            De.b(dVar);
        }
        String str = "";
        if (this.mThreadData != null) {
            str = this.mThreadData.getForumName();
        }
        if (com.baidu.tieba.tbadkCore.voice.c.byb() && com.baidu.tieba.tbadkCore.o.a(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, De.getContext()), com.baidu.tbadk.editortools.r.class)) != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar2.aCG = d.f.new_pbeditor_voice_button;
            rVar2.aCI = 4;
            De.b(rVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(De.getContext(), 5);
        aVar.aCG = d.f.new_pbeditor_at_button;
        De.b(aVar);
        if (!this.eXE) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, De.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask2 != null && runTask2.getData() != null) {
                com.baidu.tbadk.editortools.r rVar3 = (com.baidu.tbadk.editortools.r) runTask2.getData();
                rVar3.aCI = 9;
                rVar3.aCG = d.f.icon_post_more_bubble_n;
                De.b(rVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, De.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask3 != null && runTask3.getData() != null) {
                com.baidu.tbadk.editortools.r rVar4 = (com.baidu.tbadk.editortools.r) runTask3.getData();
                rVar4.aCI = 10;
                rVar4.aCG = d.f.icon_post_more_tail_n;
                De.b(rVar4);
            }
        }
        if (!"PbChosenActivity".equals(De.getContext().getClass().getSimpleName()) && !this.eXE) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(De.getContext(), 5);
            aVar2.aCG = d.f.new_pbeditor_gift_button;
            De.b(aVar2);
        }
        if (!this.eXE) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, De.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask4 != null && (rVar = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
                rVar.aCI = 6;
                rVar.aCG = d.f.icon_post_more_location;
                De.b(rVar);
            }
            arrayList.add(8);
        }
        De.B(arrayList);
        com.baidu.tbadk.editortools.r eP = De.eP(5);
        if (eP != null) {
            eP.bB(false);
            eP.aCI = 1;
            eP.aCG = d.f.new_pbeditor_face_button;
        }
        De.Df();
        if (this.eXE) {
            De.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    public void b(com.baidu.tbadk.editortools.b bVar) {
        this.eXD = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void jt(boolean z) {
        this.eXE = z;
    }
}
