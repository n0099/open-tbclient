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
    private com.baidu.tbadk.editortools.b fXL;
    private boolean fXM = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d bN(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.fXM) {
            editorTools.setBarLauncherType(2);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(e.d.cp_bg_line_d);
        editorTools.cr(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.cq(true);
        return new t(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof t) {
            EditorTools LX = dVar.LX();
            final t tVar = (t) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (tVar != null && tVar.LX() != null && aVar != null) {
                        if (u.this.fXL != null) {
                            u.this.fXL.a(aVar);
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
                                    tVar.MC();
                                    return;
                                }
                                switch (tVar.MG()) {
                                    case 0:
                                        tVar.Mz();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        tVar.My();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.bDX().nw(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                tVar.LX().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (u.this.a(tVar.getContext().getPageContext(), 11040)) {
                                    tVar.Mx();
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
            LX.setActionListener(16, bVar);
            LX.setActionListener(14, bVar);
            LX.setActionListener(15, bVar);
            LX.setActionListener(24, bVar);
            LX.setActionListener(3, bVar);
            LX.setActionListener(18, bVar);
            LX.setActionListener(20, bVar);
            LX.setActionListener(10, bVar);
            LX.setActionListener(11, bVar);
            LX.setActionListener(36, bVar);
            LX.setActionListener(32, bVar);
            LX.setActionListener(43, bVar);
            LX.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.k kVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar2;
        EditorTools LX = dVar.LX();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.fXM) {
            arrayList.add(10);
        }
        arrayList.add(6);
        arrayList.add(9);
        if (!this.fXM) {
            com.baidu.tbadk.editortools.imagetool.d dVar2 = new com.baidu.tbadk.editortools.imagetool.d(LX.getContext(), 3);
            dVar2.aYV = e.f.new_pbeditor_image_button;
            LX.b(dVar2);
        }
        String str = "";
        if (this.mThreadData != null) {
            str = this.mThreadData.getForumName();
        }
        if (com.baidu.tieba.tbadkCore.voice.c.bED() && com.baidu.tieba.tbadkCore.p.a(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, LX.getContext()), com.baidu.tbadk.editortools.k.class)) != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar2.aYV = e.f.new_pbeditor_voice_button;
            kVar2.aYX = 4;
            LX.b(kVar2);
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(LX.getContext(), 5);
        aVar.aYV = e.f.new_pbeditor_at_button;
        LX.b(aVar);
        if (!this.fXM) {
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, LX.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask2 != null && runTask2.getData() != null) {
                com.baidu.tbadk.editortools.k kVar3 = (com.baidu.tbadk.editortools.k) runTask2.getData();
                kVar3.aYX = 9;
                kVar3.aYV = e.f.icon_post_more_bubble_n;
                LX.b(kVar3);
            }
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, LX.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask3 != null && runTask3.getData() != null) {
                com.baidu.tbadk.editortools.k kVar4 = (com.baidu.tbadk.editortools.k) runTask3.getData();
                kVar4.aYX = 10;
                kVar4.aYV = e.f.icon_post_more_tail_n;
                LX.b(kVar4);
            }
        }
        if (!"PbChosenActivity".equals(LX.getContext().getClass().getSimpleName()) && !this.fXM) {
            com.baidu.tbadk.editortools.b.a aVar2 = new com.baidu.tbadk.editortools.b.a(LX.getContext(), 5);
            aVar2.aYV = e.f.new_pbeditor_gift_button;
            LX.b(aVar2);
        }
        if (!this.fXM) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, LX.getContext()), com.baidu.tbadk.editortools.k.class);
            if (runTask4 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
                kVar.aYX = 6;
                kVar.aYV = e.f.icon_post_more_location;
                LX.b(kVar);
            }
            arrayList.add(8);
        }
        LX.w(arrayList);
        com.baidu.tbadk.editortools.k fK = LX.fK(5);
        if (fK != null) {
            fK.ct(false);
            fK.aYX = 1;
            fK.aYV = e.f.new_pbeditor_face_button;
        }
        LX.LY();
        if (this.fXM) {
            LX.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public void b(com.baidu.tbadk.editortools.b bVar) {
        this.fXL = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void kT(boolean z) {
        this.fXM = z;
    }
}
