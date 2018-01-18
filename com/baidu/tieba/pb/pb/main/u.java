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
    private com.baidu.tbadk.editortools.b fLY;
    private boolean fLZ = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f bi(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        if (this.fLZ) {
            iVar.setBarLauncherType(2);
        } else {
            iVar.setBarLauncherType(3);
        }
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.C0107d.cp_bg_line_d);
        iVar.cb(true);
        iVar.setMoreButtonAtEnd(true);
        iVar.ca(true);
        return new t(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof t) {
            com.baidu.tbadk.editortools.i Ku = fVar.Ku();
            final t tVar = (t) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (tVar != null && tVar.Ku() != null && aVar != null) {
                        if (u.this.fLY != null) {
                            u.this.fLY.a(aVar);
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
                                    tVar.KX();
                                    return;
                                }
                                switch (tVar.Lb()) {
                                    case 0:
                                        tVar.KV();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        tVar.KU();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.bwp().mB(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                tVar.Ku().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (u.this.a(tVar.getContext().getPageContext(), 11040)) {
                                    tVar.KT();
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
            Ku.a(16, bVar);
            Ku.a(14, bVar);
            Ku.a(15, bVar);
            Ku.a(24, bVar);
            Ku.a(3, bVar);
            Ku.a(18, bVar);
            Ku.a(20, bVar);
            Ku.a(10, bVar);
            Ku.a(11, bVar);
            Ku.a(36, bVar);
            Ku.a(32, bVar);
            Ku.a(43, bVar);
            Ku.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        com.baidu.tbadk.editortools.r rVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.i Ku = fVar.Ku();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.fLZ) {
            arrayList.add(10);
        }
        arrayList.add(6);
        arrayList.add(9);
        if (!this.fLZ) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(Ku.getContext(), 3);
            dVar.bqN = d.f.new_pbeditor_image_button;
            Ku.b(dVar);
        }
        String str = "";
        if (this.mThreadData != null) {
            str = this.mThreadData.getForumName();
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bwQ() && com.baidu.tieba.tbadkCore.p.a(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, Ku.getContext()), com.baidu.tbadk.editortools.r.class)) != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar2.bqN = d.f.new_pbeditor_voice_button;
            rVar2.bqP = 4;
            Ku.b(rVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Ku.getContext(), 5);
        aVar.bqN = d.f.new_pbeditor_at_button;
        Ku.b(aVar);
        if (!this.fLZ) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, Ku.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask2 != null && runTask2.getData() != null) {
                com.baidu.tbadk.editortools.r rVar3 = (com.baidu.tbadk.editortools.r) runTask2.getData();
                rVar3.bqP = 9;
                rVar3.bqN = d.f.icon_post_more_bubble_n;
                Ku.b(rVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, Ku.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask3 != null && runTask3.getData() != null) {
                com.baidu.tbadk.editortools.r rVar4 = (com.baidu.tbadk.editortools.r) runTask3.getData();
                rVar4.bqP = 10;
                rVar4.bqN = d.f.icon_post_more_tail_n;
                Ku.b(rVar4);
            }
        }
        if (!"PbChosenActivity".equals(Ku.getContext().getClass().getSimpleName()) && !this.fLZ) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(Ku.getContext(), 5);
            aVar2.bqN = d.f.new_pbeditor_gift_button;
            Ku.b(aVar2);
        }
        if (!this.fLZ) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, Ku.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask4 != null && (rVar = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
                rVar.bqP = 6;
                rVar.bqN = d.f.icon_post_more_location;
                Ku.b(rVar);
            }
            arrayList.add(8);
        }
        Ku.I(arrayList);
        com.baidu.tbadk.editortools.r hJ = Ku.hJ(5);
        if (hJ != null) {
            hJ.cd(false);
            hJ.bqP = 1;
            hJ.bqN = d.f.new_pbeditor_face_button;
        }
        Ku.Kv();
        if (this.fLZ) {
            Ku.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.fLY = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void jY(boolean z) {
        this.fLZ = z;
    }
}
