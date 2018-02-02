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
/* loaded from: classes2.dex */
public class u extends com.baidu.tbadk.editortools.d {
    private com.baidu.tbadk.editortools.b fMt;
    private boolean fMu = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f bf(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        if (this.fMu) {
            iVar.setBarLauncherType(2);
        } else {
            iVar.setBarLauncherType(3);
        }
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.C0108d.cp_bg_line_d);
        iVar.cc(true);
        iVar.setMoreButtonAtEnd(true);
        iVar.cb(true);
        return new t(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof t) {
            com.baidu.tbadk.editortools.i Kw = fVar.Kw();
            final t tVar = (t) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (tVar != null && tVar.Kw() != null && aVar != null) {
                        if (u.this.fMt != null) {
                            u.this.fMt.a(aVar);
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
                                    tVar.KZ();
                                    return;
                                }
                                switch (tVar.Ld()) {
                                    case 0:
                                        tVar.KX();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        tVar.KW();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.bwr().mE(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                tVar.Kw().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (u.this.a(tVar.getContext().getPageContext(), 11040)) {
                                    tVar.KV();
                                    return;
                                }
                                return;
                            case 43:
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
            Kw.a(16, bVar);
            Kw.a(14, bVar);
            Kw.a(15, bVar);
            Kw.a(24, bVar);
            Kw.a(3, bVar);
            Kw.a(18, bVar);
            Kw.a(20, bVar);
            Kw.a(10, bVar);
            Kw.a(11, bVar);
            Kw.a(36, bVar);
            Kw.a(32, bVar);
            Kw.a(43, bVar);
            Kw.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        com.baidu.tbadk.editortools.r rVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.i Kw = fVar.Kw();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.fMu) {
            arrayList.add(10);
        }
        arrayList.add(6);
        arrayList.add(9);
        if (!this.fMu) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(Kw.getContext(), 3);
            dVar.bqW = d.f.new_pbeditor_image_button;
            Kw.b(dVar);
        }
        String str = "";
        if (this.mThreadData != null) {
            str = this.mThreadData.getForumName();
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bwS() && com.baidu.tieba.tbadkCore.p.a(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, Kw.getContext()), com.baidu.tbadk.editortools.r.class)) != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar2.bqW = d.f.new_pbeditor_voice_button;
            rVar2.bqY = 4;
            Kw.b(rVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Kw.getContext(), 5);
        aVar.bqW = d.f.new_pbeditor_at_button;
        Kw.b(aVar);
        if (!this.fMu) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Kw.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask2 != null && runTask2.getData() != null) {
                com.baidu.tbadk.editortools.r rVar3 = (com.baidu.tbadk.editortools.r) runTask2.getData();
                rVar3.bqY = 9;
                rVar3.bqW = d.f.icon_post_more_bubble_n;
                Kw.b(rVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Kw.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask3 != null && runTask3.getData() != null) {
                com.baidu.tbadk.editortools.r rVar4 = (com.baidu.tbadk.editortools.r) runTask3.getData();
                rVar4.bqY = 10;
                rVar4.bqW = d.f.icon_post_more_tail_n;
                Kw.b(rVar4);
            }
        }
        if (!"PbChosenActivity".equals(Kw.getContext().getClass().getSimpleName()) && !this.fMu) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(Kw.getContext(), 5);
            aVar2.bqW = d.f.new_pbeditor_gift_button;
            Kw.b(aVar2);
        }
        if (!this.fMu) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, Kw.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask4 != null && (rVar = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
                rVar.bqY = 6;
                rVar.bqW = d.f.icon_post_more_location;
                Kw.b(rVar);
            }
            arrayList.add(8);
        }
        Kw.I(arrayList);
        com.baidu.tbadk.editortools.r hJ = Kw.hJ(5);
        if (hJ != null) {
            hJ.ce(false);
            hJ.bqY = 1;
            hJ.bqW = d.f.new_pbeditor_face_button;
        }
        Kw.Kx();
        if (this.fMu) {
            Kw.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.fMt = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void kb(boolean z) {
        this.fMu = z;
    }
}
