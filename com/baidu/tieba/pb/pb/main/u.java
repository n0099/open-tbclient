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
/* loaded from: classes4.dex */
public class u extends com.baidu.tbadk.editortools.c {
    private com.baidu.tbadk.editortools.b hrE;
    private boolean hrF = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d de(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.hrF) {
            editorTools.setBarLauncherType(2);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(d.C0277d.cp_bg_line_d);
        editorTools.eI(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.eH(true);
        return new t(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof t) {
            EditorTools alS = dVar.alS();
            final t tVar = (t) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (tVar != null && tVar.alS() != null && aVar != null) {
                        if (u.this.hrE != null) {
                            u.this.hrE.a(aVar);
                        }
                        switch (aVar.code) {
                            case 16:
                                if (u.this.a(tVar.getContext().getPageContext(), 11025)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(tVar.getContext().getActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    tVar.amy();
                                    return;
                                }
                                switch (tVar.amC()) {
                                    case 0:
                                        tVar.amv();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        tVar.amu();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.ceZ().qa(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                tVar.alS().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (u.this.a(tVar.getContext().getPageContext(), 11040)) {
                                    tVar.amt();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(tVar.getContext().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(tVar.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                                    if (u.this.mThreadData != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.d(u.this.mThreadData.getForumId(), 0L), u.this.mThreadData.getFirstDir(), u.this.mThreadData.getSecondDir());
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
            alS.setActionListener(16, bVar);
            alS.setActionListener(14, bVar);
            alS.setActionListener(15, bVar);
            alS.setActionListener(24, bVar);
            alS.setActionListener(3, bVar);
            alS.setActionListener(18, bVar);
            alS.setActionListener(20, bVar);
            alS.setActionListener(10, bVar);
            alS.setActionListener(11, bVar);
            alS.setActionListener(36, bVar);
            alS.setActionListener(32, bVar);
            alS.setActionListener(43, bVar);
            alS.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.k kVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar2;
        EditorTools alS = dVar.alS();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.hrF) {
            arrayList.add(10);
        }
        arrayList.add(6);
        arrayList.add(9);
        if (!this.hrF) {
            com.baidu.tbadk.editortools.imagetool.d dVar2 = new com.baidu.tbadk.editortools.imagetool.d(alS.getContext(), 3);
            dVar2.cji = d.f.new_pbeditor_image_button;
            alS.b(dVar2);
        }
        String str = "";
        if (this.mThreadData != null) {
            str = this.mThreadData.getForumName();
        }
        if (com.baidu.tieba.tbadkCore.voice.c.cfE() && com.baidu.tieba.tbadkCore.p.b(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, alS.getContext()), com.baidu.tbadk.editortools.k.class)) != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar2.cji = d.f.new_pbeditor_voice_button;
            kVar2.cjk = 4;
            alS.b(kVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(alS.getContext(), 5);
        aVar.cji = d.f.new_pbeditor_at_button;
        alS.b(aVar);
        if (!this.hrF) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, alS.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask2 != null && runTask2.getData() != null) {
                com.baidu.tbadk.editortools.k kVar3 = (com.baidu.tbadk.editortools.k) runTask2.getData();
                kVar3.cjk = 9;
                kVar3.cji = d.f.icon_post_more_bubble_n;
                alS.b(kVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, alS.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask3 != null && runTask3.getData() != null) {
                com.baidu.tbadk.editortools.k kVar4 = (com.baidu.tbadk.editortools.k) runTask3.getData();
                kVar4.cjk = 10;
                kVar4.cji = d.f.icon_post_more_tail_n;
                alS.b(kVar4);
            }
        }
        if (!"PbChosenActivity".equals(alS.getContext().getClass().getSimpleName()) && !this.hrF) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(alS.getContext(), 5);
            aVar2.cji = d.f.new_pbeditor_gift_button;
            alS.b(aVar2);
        }
        if (!this.hrF) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, alS.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask4 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
                kVar.cjk = 6;
                kVar.cji = d.f.icon_post_more_location;
                alS.b(kVar);
            }
            arrayList.add(8);
        }
        alS.ab(arrayList);
        com.baidu.tbadk.editortools.k jw = alS.jw(5);
        if (jw != null) {
            jw.cjk = 1;
            jw.cji = d.f.new_pbeditor_face_button;
        }
        alS.alT();
        if (this.hrF) {
            alS.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public void b(com.baidu.tbadk.editortools.b bVar) {
        this.hrE = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void nx(boolean z) {
        this.hrF = z;
    }
}
