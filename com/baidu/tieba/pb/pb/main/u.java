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
    private com.baidu.tbadk.editortools.b iLt;
    private boolean iLu = false;
    private boolean iLv = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dV(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.iLu) {
            editorTools.setBarLauncherType(2);
        } else if (this.iLv) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.gD(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.gC(true);
        return new t(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof t) {
            EditorTools aOy = dVar.aOy();
            final t tVar = (t) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.u.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (tVar != null && tVar.aOy() != null && aVar != null) {
                        if (u.this.iLt != null) {
                            u.this.iLt.a(aVar);
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
                                    tVar.aPd();
                                    return;
                                }
                                switch (tVar.aPi()) {
                                    case 0:
                                        tVar.aPa();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        tVar.aOZ();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.cMb().sV(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                tVar.aOy().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (u.this.a(tVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    tVar.aOY();
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
            aOy.setActionListener(16, bVar);
            aOy.setActionListener(14, bVar);
            aOy.setActionListener(15, bVar);
            aOy.setActionListener(24, bVar);
            aOy.setActionListener(3, bVar);
            aOy.setActionListener(18, bVar);
            aOy.setActionListener(20, bVar);
            aOy.setActionListener(10, bVar);
            aOy.setActionListener(11, bVar);
            aOy.setActionListener(36, bVar);
            aOy.setActionListener(32, bVar);
            aOy.setActionListener(43, bVar);
            aOy.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar2;
        EditorTools aOy = dVar.aOy();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.iLu) {
            arrayList.add(10);
            aOy.b(new com.baidu.tbadk.editortools.imagetool.d(aOy.getContext(), 3));
        }
        if (!this.iLv) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.cMD() && com.baidu.tieba.tbadkCore.s.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, aOy.getContext()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
                lVar2.dxQ = 4;
                aOy.b(lVar2);
            }
            aOy.b(new com.baidu.tbadk.editortools.a.a(aOy.getContext(), 5));
            if (!this.iLu) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, aOy.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar3 = (com.baidu.tbadk.editortools.l) runTask2.getData();
                    lVar3.dxQ = 9;
                    lVar3.dxM = R.drawable.icon_pure_more_bubble40_svg;
                    aOy.b(lVar3);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, aOy.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar4 = (com.baidu.tbadk.editortools.l) runTask3.getData();
                    lVar4.dxQ = 10;
                    lVar4.dxM = R.drawable.icon_pure_more_tail40_svg;
                    aOy.b(lVar4);
                }
            }
            if (!"PbChosenActivity".equals(aOy.getContext().getClass().getSimpleName()) && !this.iLu) {
                aOy.b(new com.baidu.tbadk.editortools.b.a(aOy.getContext(), 5));
            }
        }
        if (!this.iLu && !this.iLv) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, aOy.getContext()), com.baidu.tbadk.editortools.l.class);
            if (runTask4 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
                lVar.dxQ = 6;
                aOy.b(lVar);
            }
            arrayList.add(8);
        }
        aOy.aI(arrayList);
        com.baidu.tbadk.editortools.l mr = aOy.mr(5);
        if (mr != null) {
            mr.dxQ = 1;
            if (this.iLv) {
                mr.gF(false);
            }
        }
        aOy.build();
        if (this.iLu || this.iLv) {
            aOy.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.iLt = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void pZ(boolean z) {
        this.iLu = z;
    }

    public void qa(boolean z) {
        this.iLv = z;
    }
}
