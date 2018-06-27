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
public class u extends com.baidu.tbadk.editortools.c {
    private com.baidu.tbadk.editortools.b fAg;
    private boolean fAh = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d aZ(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.fAh) {
            editorTools.setBarLauncherType(2);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(d.C0142d.cp_bg_line_d);
        editorTools.bF(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.bE(true);
        return new t(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof t) {
            EditorTools Hy = dVar.Hy();
            final t tVar = (t) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (tVar != null && tVar.Hy() != null && aVar != null) {
                        if (u.this.fAg != null) {
                            u.this.fAg.a(aVar);
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
                                    tVar.Id();
                                    return;
                                }
                                switch (tVar.Ih()) {
                                    case 0:
                                        tVar.Ia();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        tVar.HZ();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.byk().mK(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                tVar.Hy().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (u.this.a(tVar.getContext().getPageContext(), 11040)) {
                                    tVar.HY();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(tVar.getContext().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(tVar.getContext().getActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                                    if (u.this.mThreadData != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(u.this.mThreadData.getForumId(), 0L), u.this.mThreadData.getFirstDir(), u.this.mThreadData.getSecondDir());
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
            Hy.setActionListener(16, bVar);
            Hy.setActionListener(14, bVar);
            Hy.setActionListener(15, bVar);
            Hy.setActionListener(24, bVar);
            Hy.setActionListener(3, bVar);
            Hy.setActionListener(18, bVar);
            Hy.setActionListener(20, bVar);
            Hy.setActionListener(10, bVar);
            Hy.setActionListener(11, bVar);
            Hy.setActionListener(36, bVar);
            Hy.setActionListener(32, bVar);
            Hy.setActionListener(43, bVar);
            Hy.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.k kVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar2;
        EditorTools Hy = dVar.Hy();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.fAh) {
            arrayList.add(10);
        }
        arrayList.add(6);
        arrayList.add(9);
        if (!this.fAh) {
            com.baidu.tbadk.editortools.imagetool.d dVar2 = new com.baidu.tbadk.editortools.imagetool.d(Hy.getContext(), 3);
            dVar2.aMS = d.f.new_pbeditor_image_button;
            Hy.b(dVar2);
        }
        String str = "";
        if (this.mThreadData != null) {
            str = this.mThreadData.getForumName();
        }
        if (com.baidu.tieba.tbadkCore.voice.c.byN() && com.baidu.tieba.tbadkCore.p.a(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, Hy.getContext()), com.baidu.tbadk.editortools.k.class)) != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar2.aMS = d.f.new_pbeditor_voice_button;
            kVar2.aMU = 4;
            Hy.b(kVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(Hy.getContext(), 5);
        aVar.aMS = d.f.new_pbeditor_at_button;
        Hy.b(aVar);
        if (!this.fAh) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, Hy.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask2 != null && runTask2.getData() != null) {
                com.baidu.tbadk.editortools.k kVar3 = (com.baidu.tbadk.editortools.k) runTask2.getData();
                kVar3.aMU = 9;
                kVar3.aMS = d.f.icon_post_more_bubble_n;
                Hy.b(kVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, Hy.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask3 != null && runTask3.getData() != null) {
                com.baidu.tbadk.editortools.k kVar4 = (com.baidu.tbadk.editortools.k) runTask3.getData();
                kVar4.aMU = 10;
                kVar4.aMS = d.f.icon_post_more_tail_n;
                Hy.b(kVar4);
            }
        }
        if (!"PbChosenActivity".equals(Hy.getContext().getClass().getSimpleName()) && !this.fAh) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(Hy.getContext(), 5);
            aVar2.aMS = d.f.new_pbeditor_gift_button;
            Hy.b(aVar2);
        }
        if (!this.fAh) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, Hy.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask4 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
                kVar.aMU = 6;
                kVar.aMS = d.f.icon_post_more_location;
                Hy.b(kVar);
            }
            arrayList.add(8);
        }
        Hy.G(arrayList);
        com.baidu.tbadk.editortools.k eN = Hy.eN(5);
        if (eN != null) {
            eN.bH(false);
            eN.aMU = 1;
            eN.aMS = d.f.new_pbeditor_face_button;
        }
        Hy.Hz();
        if (this.fAh) {
            Hy.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.fAg = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void kc(boolean z) {
        this.fAh = z;
    }
}
