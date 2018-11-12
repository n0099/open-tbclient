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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class u extends com.baidu.tbadk.editortools.c {
    private com.baidu.tbadk.editortools.b fQV;
    private boolean fQW = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d bK(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.fQW) {
            editorTools.setBarLauncherType(2);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(e.d.cp_bg_line_d);
        editorTools.cq(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.cp(true);
        return new t(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof t) {
            EditorTools KT = dVar.KT();
            final t tVar = (t) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (tVar != null && tVar.KT() != null && aVar != null) {
                        if (u.this.fQV != null) {
                            u.this.fQV.a(aVar);
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
                                    tVar.Ly();
                                    return;
                                }
                                switch (tVar.LC()) {
                                    case 0:
                                        tVar.Lv();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        tVar.Lu();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.bCc().nu(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                tVar.KT().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (u.this.a(tVar.getContext().getPageContext(), 11040)) {
                                    tVar.Lt();
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
            KT.setActionListener(16, bVar);
            KT.setActionListener(14, bVar);
            KT.setActionListener(15, bVar);
            KT.setActionListener(24, bVar);
            KT.setActionListener(3, bVar);
            KT.setActionListener(18, bVar);
            KT.setActionListener(20, bVar);
            KT.setActionListener(10, bVar);
            KT.setActionListener(11, bVar);
            KT.setActionListener(36, bVar);
            KT.setActionListener(32, bVar);
            KT.setActionListener(43, bVar);
            KT.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.k kVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar2;
        EditorTools KT = dVar.KT();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.fQW) {
            arrayList.add(10);
        }
        arrayList.add(6);
        arrayList.add(9);
        if (!this.fQW) {
            com.baidu.tbadk.editortools.imagetool.d dVar2 = new com.baidu.tbadk.editortools.imagetool.d(KT.getContext(), 3);
            dVar2.aVy = e.f.new_pbeditor_image_button;
            KT.b(dVar2);
        }
        String str = "";
        if (this.mThreadData != null) {
            str = this.mThreadData.getForumName();
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bCI() && com.baidu.tieba.tbadkCore.p.a(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, KT.getContext()), com.baidu.tbadk.editortools.k.class)) != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar2.aVy = e.f.new_pbeditor_voice_button;
            kVar2.aVA = 4;
            KT.b(kVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(KT.getContext(), 5);
        aVar.aVy = e.f.new_pbeditor_at_button;
        KT.b(aVar);
        if (!this.fQW) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, KT.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask2 != null && runTask2.getData() != null) {
                com.baidu.tbadk.editortools.k kVar3 = (com.baidu.tbadk.editortools.k) runTask2.getData();
                kVar3.aVA = 9;
                kVar3.aVy = e.f.icon_post_more_bubble_n;
                KT.b(kVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, KT.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask3 != null && runTask3.getData() != null) {
                com.baidu.tbadk.editortools.k kVar4 = (com.baidu.tbadk.editortools.k) runTask3.getData();
                kVar4.aVA = 10;
                kVar4.aVy = e.f.icon_post_more_tail_n;
                KT.b(kVar4);
            }
        }
        if (!"PbChosenActivity".equals(KT.getContext().getClass().getSimpleName()) && !this.fQW) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(KT.getContext(), 5);
            aVar2.aVy = e.f.new_pbeditor_gift_button;
            KT.b(aVar2);
        }
        if (!this.fQW) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, KT.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask4 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
                kVar.aVA = 6;
                kVar.aVy = e.f.icon_post_more_location;
                KT.b(kVar);
            }
            arrayList.add(8);
        }
        KT.w(arrayList);
        com.baidu.tbadk.editortools.k fw = KT.fw(5);
        if (fw != null) {
            fw.cs(false);
            fw.aVA = 1;
            fw.aVy = e.f.new_pbeditor_face_button;
        }
        KT.KU();
        if (this.fQW) {
            KT.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.fQV = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void kQ(boolean z) {
        this.fQW = z;
    }
}
