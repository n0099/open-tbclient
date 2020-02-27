package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class u extends com.baidu.tbadk.editortools.c {
    private com.baidu.tbadk.editortools.b iJE;
    private boolean iJF = false;
    private boolean iJG = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dW(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.iJF) {
            editorTools.setBarLauncherType(2);
        } else if (this.iJG) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.gC(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.gB(true);
        return new t(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof t) {
            EditorTools aOr = dVar.aOr();
            final t tVar = (t) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (tVar != null && tVar.aOr() != null && aVar != null) {
                        if (u.this.iJE != null) {
                            u.this.iJE.a(aVar);
                        }
                        switch (aVar.code) {
                            case 16:
                                if (u.this.a(tVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(tVar.getContext().getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    tVar.aOW();
                                    return;
                                }
                                switch (tVar.aPb()) {
                                    case 0:
                                        tVar.aOT();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        tVar.aOS();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.cLE().sP(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                tVar.aOr().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (u.this.a(tVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    tVar.aOR();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(tVar.getContext().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(tVar.getContext().getActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (u.this.mThreadData != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(u.this.mThreadData.getForumId(), 0L), u.this.mThreadData.getFirstDir(), u.this.mThreadData.getSecondDir());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            aOr.setActionListener(16, bVar);
            aOr.setActionListener(14, bVar);
            aOr.setActionListener(15, bVar);
            aOr.setActionListener(24, bVar);
            aOr.setActionListener(3, bVar);
            aOr.setActionListener(18, bVar);
            aOr.setActionListener(20, bVar);
            aOr.setActionListener(10, bVar);
            aOr.setActionListener(11, bVar);
            aOr.setActionListener(36, bVar);
            aOr.setActionListener(32, bVar);
            aOr.setActionListener(43, bVar);
            aOr.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar2;
        EditorTools aOr = dVar.aOr();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.iJF) {
            arrayList.add(10);
            aOr.b(new com.baidu.tbadk.editortools.imagetool.d(aOr.getContext(), 3));
        }
        if (!this.iJG) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.cMg() && com.baidu.tieba.tbadkCore.r.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, aOr.getContext()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
                lVar2.dxp = 4;
                aOr.b(lVar2);
            }
            aOr.b(new com.baidu.tbadk.editortools.a.a(aOr.getContext(), 5));
            if (!this.iJF) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, aOr.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar3 = (com.baidu.tbadk.editortools.l) runTask2.getData();
                    lVar3.dxp = 9;
                    lVar3.dxl = R.drawable.icon_pure_more_bubble40_svg;
                    aOr.b(lVar3);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, aOr.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar4 = (com.baidu.tbadk.editortools.l) runTask3.getData();
                    lVar4.dxp = 10;
                    lVar4.dxl = R.drawable.icon_pure_more_tail40_svg;
                    aOr.b(lVar4);
                }
            }
            if (!"PbChosenActivity".equals(aOr.getContext().getClass().getSimpleName()) && !this.iJF) {
                aOr.b(new com.baidu.tbadk.editortools.b.a(aOr.getContext(), 5));
            }
        }
        if (!this.iJF && !this.iJG) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, aOr.getContext()), com.baidu.tbadk.editortools.l.class);
            if (runTask4 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
                lVar.dxp = 6;
                aOr.b(lVar);
            }
            arrayList.add(8);
        }
        aOr.aI(arrayList);
        com.baidu.tbadk.editortools.l mp = aOr.mp(5);
        if (mp != null) {
            mp.dxp = 1;
            if (this.iJG) {
                mp.gE(false);
            }
        }
        aOr.build();
        if (this.iJF || this.iJG) {
            aOr.b(new com.baidu.tbadk.editortools.a(35, 5, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    public void b(com.baidu.tbadk.editortools.b bVar) {
        this.iJE = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void pT(boolean z) {
        this.iJF = z;
    }

    public void pU(boolean z) {
        this.iJG = z;
    }
}
