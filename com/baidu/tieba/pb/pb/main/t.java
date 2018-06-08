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
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class t extends com.baidu.tbadk.editortools.c {
    private com.baidu.tbadk.editortools.b fwf;
    private boolean fwg = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d aZ(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.fwg) {
            editorTools.setBarLauncherType(2);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(d.C0141d.cp_bg_line_d);
        editorTools.bC(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.bB(true);
        return new s(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof s) {
            EditorTools Hg = dVar.Hg();
            final s sVar = (s) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.t.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (sVar != null && sVar.Hg() != null && aVar != null) {
                        if (t.this.fwf != null) {
                            t.this.fwf.a(aVar);
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
                                    sVar.HL();
                                    return;
                                }
                                switch (sVar.HP()) {
                                    case 0:
                                        sVar.HI();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        sVar.HH();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.bxH().mz(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                sVar.Hg().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (t.this.a(sVar.getContext().getPageContext(), 11040)) {
                                    sVar.HG();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(sVar.getContext().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(sVar.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                                    if (t.this.mThreadData != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(t.this.mThreadData.getForumId(), 0L), t.this.mThreadData.getFirstDir(), t.this.mThreadData.getSecondDir());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            Hg.setActionListener(16, bVar);
            Hg.setActionListener(14, bVar);
            Hg.setActionListener(15, bVar);
            Hg.setActionListener(24, bVar);
            Hg.setActionListener(3, bVar);
            Hg.setActionListener(18, bVar);
            Hg.setActionListener(20, bVar);
            Hg.setActionListener(10, bVar);
            Hg.setActionListener(11, bVar);
            Hg.setActionListener(36, bVar);
            Hg.setActionListener(32, bVar);
            Hg.setActionListener(43, bVar);
            Hg.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.k kVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar2;
        EditorTools Hg = dVar.Hg();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.fwg) {
            arrayList.add(10);
        }
        arrayList.add(6);
        arrayList.add(9);
        if (!this.fwg) {
            com.baidu.tbadk.editortools.imagetool.d dVar2 = new com.baidu.tbadk.editortools.imagetool.d(Hg.getContext(), 3);
            dVar2.aLW = d.f.new_pbeditor_image_button;
            Hg.b(dVar2);
        }
        String str = "";
        if (this.mThreadData != null) {
            str = this.mThreadData.getForumName();
        }
        if (com.baidu.tieba.tbadkCore.voice.c.byj() && com.baidu.tieba.tbadkCore.p.a(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, Hg.getContext()), com.baidu.tbadk.editortools.k.class)) != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar2.aLW = d.f.new_pbeditor_voice_button;
            kVar2.aLY = 4;
            Hg.b(kVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Hg.getContext(), 5);
        aVar.aLW = d.f.new_pbeditor_at_button;
        Hg.b(aVar);
        if (!this.fwg) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, Hg.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask2 != null && runTask2.getData() != null) {
                com.baidu.tbadk.editortools.k kVar3 = (com.baidu.tbadk.editortools.k) runTask2.getData();
                kVar3.aLY = 9;
                kVar3.aLW = d.f.icon_post_more_bubble_n;
                Hg.b(kVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, Hg.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask3 != null && runTask3.getData() != null) {
                com.baidu.tbadk.editortools.k kVar4 = (com.baidu.tbadk.editortools.k) runTask3.getData();
                kVar4.aLY = 10;
                kVar4.aLW = d.f.icon_post_more_tail_n;
                Hg.b(kVar4);
            }
        }
        if (!"PbChosenActivity".equals(Hg.getContext().getClass().getSimpleName()) && !this.fwg) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(Hg.getContext(), 5);
            aVar2.aLW = d.f.new_pbeditor_gift_button;
            Hg.b(aVar2);
        }
        if (!this.fwg) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, Hg.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask4 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
                kVar.aLY = 6;
                kVar.aLW = d.f.icon_post_more_location;
                Hg.b(kVar);
            }
            arrayList.add(8);
        }
        Hg.F(arrayList);
        com.baidu.tbadk.editortools.k eM = Hg.eM(5);
        if (eM != null) {
            eM.bE(false);
            eM.aLY = 1;
            eM.aLW = d.f.new_pbeditor_face_button;
        }
        Hg.Hh();
        if (this.fwg) {
            Hg.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(d.k.login_to_use), true, i)));
            return false;
        }
        return true;
    }

    public void b(com.baidu.tbadk.editortools.b bVar) {
        this.fwf = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void jS(boolean z) {
        this.fwg = z;
    }
}
