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
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class t extends com.baidu.tbadk.editortools.d {
    private com.baidu.tbadk.editortools.b fPC;
    private boolean fPD = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.d
    protected com.baidu.tbadk.editortools.f be(Context context) {
        com.baidu.tbadk.editortools.i iVar = new com.baidu.tbadk.editortools.i(context);
        iVar.setIsFromPb(true);
        iVar.setBarMaxLauCount(5);
        if (this.fPD) {
            iVar.setBarLauncherType(2);
        } else {
            iVar.setBarLauncherType(3);
        }
        iVar.setBackgroundColorId(0);
        iVar.setBarBackgroundColorId(d.C0140d.cp_bg_line_d);
        iVar.cg(true);
        iVar.setMoreButtonAtEnd(true);
        iVar.cf(true);
        return new s(iVar);
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void b(com.baidu.tbadk.editortools.f fVar) {
        if (fVar instanceof s) {
            com.baidu.tbadk.editortools.i Lc = fVar.Lc();
            final s sVar = (s) fVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.t.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (sVar != null && sVar.Lc() != null && aVar != null) {
                        if (t.this.fPC != null) {
                            t.this.fPC.a(aVar);
                        }
                        switch (aVar.code) {
                            case 16:
                                if (t.this.a(sVar.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(sVar.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    sVar.LG();
                                    return;
                                }
                                switch (sVar.LK()) {
                                    case 0:
                                        sVar.LE();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        sVar.LD();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.bxA().mL(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                sVar.Lc().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (t.this.a(sVar.getContext().getPageContext(), 11040)) {
                                    sVar.LC();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.a.a(sVar.getContext().getPageContext(), true, false)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotSelectActivityConfig(sVar.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB)));
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            Lc.a(16, bVar);
            Lc.a(14, bVar);
            Lc.a(15, bVar);
            Lc.a(24, bVar);
            Lc.a(3, bVar);
            Lc.a(18, bVar);
            Lc.a(20, bVar);
            Lc.a(10, bVar);
            Lc.a(11, bVar);
            Lc.a(36, bVar);
            Lc.a(32, bVar);
            Lc.a(43, bVar);
            Lc.a(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.d
    protected void a(com.baidu.tbadk.editortools.f fVar) {
        com.baidu.tbadk.editortools.r rVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.r rVar2;
        com.baidu.tbadk.editortools.i Lc = fVar.Lc();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.fPD) {
            arrayList.add(10);
        }
        arrayList.add(6);
        arrayList.add(9);
        if (!this.fPD) {
            com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(Lc.getContext(), 3);
            dVar.btj = d.f.new_pbeditor_image_button;
            Lc.b(dVar);
        }
        String str = "";
        if (this.mThreadData != null) {
            str = this.mThreadData.getForumName();
        }
        if (com.baidu.tieba.tbadkCore.voice.c.byc() && com.baidu.tieba.tbadkCore.p.a(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, Lc.getContext()), com.baidu.tbadk.editortools.r.class)) != null && (rVar2 = (com.baidu.tbadk.editortools.r) runTask.getData()) != null) {
            rVar2.btj = d.f.new_pbeditor_voice_button;
            rVar2.btl = 4;
            Lc.b(rVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Lc.getContext(), 5);
        aVar.btj = d.f.new_pbeditor_at_button;
        Lc.b(aVar);
        if (!this.fPD) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, Lc.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask2 != null && runTask2.getData() != null) {
                com.baidu.tbadk.editortools.r rVar3 = (com.baidu.tbadk.editortools.r) runTask2.getData();
                rVar3.btl = 9;
                rVar3.btj = d.f.icon_post_more_bubble_n;
                Lc.b(rVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, Lc.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask3 != null && runTask3.getData() != null) {
                com.baidu.tbadk.editortools.r rVar4 = (com.baidu.tbadk.editortools.r) runTask3.getData();
                rVar4.btl = 10;
                rVar4.btj = d.f.icon_post_more_tail_n;
                Lc.b(rVar4);
            }
        }
        if (!"PbChosenActivity".equals(Lc.getContext().getClass().getSimpleName()) && !this.fPD) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(Lc.getContext(), 5);
            aVar2.btj = d.f.new_pbeditor_gift_button;
            Lc.b(aVar2);
        }
        if (!this.fPD) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, Lc.getContext()), com.baidu.tbadk.editortools.r.class);
            if (runTask4 != null && (rVar = (com.baidu.tbadk.editortools.r) runTask4.getData()) != null) {
                rVar.btl = 6;
                rVar.btj = d.f.icon_post_more_location;
                Lc.b(rVar);
            }
            arrayList.add(8);
        }
        Lc.K(arrayList);
        com.baidu.tbadk.editortools.r hI = Lc.hI(5);
        if (hI != null) {
            hI.ci(false);
            hI.btl = 1;
            hI.btj = d.f.new_pbeditor_face_button;
        }
        Lc.Ld();
        if (this.fPD) {
            Lc.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.j.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    public void b(com.baidu.tbadk.editortools.b bVar) {
        this.fPC = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void kk(boolean z) {
        this.fPD = z;
    }
}
