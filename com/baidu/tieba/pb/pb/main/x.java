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
/* loaded from: classes16.dex */
public class x extends com.baidu.tbadk.editortools.c {
    private com.baidu.tbadk.editortools.b kqr;
    private boolean kqs = false;
    private boolean kqt = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dU(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.kqs) {
            editorTools.setBarLauncherType(2);
        } else if (this.kqt) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.iK(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.iJ(true);
        return new w(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof w) {
            EditorTools biJ = dVar.biJ();
            final w wVar = (w) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (wVar != null && wVar.biJ() != null && aVar != null) {
                        if (x.this.kqr != null) {
                            x.this.kqr.a(aVar);
                        }
                        switch (aVar.code) {
                            case 16:
                                if (x.this.a(wVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(wVar.getContext().getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    wVar.bjr();
                                    return;
                                }
                                switch (wVar.bjw()) {
                                    case 0:
                                        wVar.bjo();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        wVar.bjm();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.dlN().vo(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                wVar.biJ().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (x.this.a(wVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    wVar.bjl();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(wVar.getContext().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(wVar.getContext().getActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (x.this.mThreadData != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(x.this.mThreadData.getForumId(), 0L), x.this.mThreadData.getFirstDir(), x.this.mThreadData.getSecondDir());
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
            biJ.setActionListener(16, bVar);
            biJ.setActionListener(14, bVar);
            biJ.setActionListener(15, bVar);
            biJ.setActionListener(24, bVar);
            biJ.setActionListener(3, bVar);
            biJ.setActionListener(18, bVar);
            biJ.setActionListener(20, bVar);
            biJ.setActionListener(10, bVar);
            biJ.setActionListener(11, bVar);
            biJ.setActionListener(36, bVar);
            biJ.setActionListener(32, bVar);
            biJ.setActionListener(43, bVar);
            biJ.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar;
        EditorTools biJ = dVar.biJ();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.kqs) {
            arrayList.add(10);
            biJ.b(new com.baidu.tbadk.editortools.imagetool.d(biJ.getContext(), 1));
        }
        if (!this.kqt) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.dmw() && com.baidu.tieba.tbadkCore.s.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, biJ.getContext()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
                lVar.eAR = 2;
                biJ.b(lVar);
            }
            biJ.b(new com.baidu.tbadk.editortools.a.a(biJ.getContext(), 4));
            if (!this.kqs) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, biJ.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar2 = (com.baidu.tbadk.editortools.l) runTask2.getData();
                    lVar2.eAR = 6;
                    biJ.b(lVar2);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, biJ.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData();
                    lVar3.eAR = 7;
                    biJ.b(lVar3);
                }
            }
            if (!"PbChosenActivity".equals(biJ.getContext().getClass().getSimpleName()) && !this.kqs) {
                biJ.b(new com.baidu.tbadk.editortools.b.a(biJ.getContext(), 5));
            }
        }
        if (!this.kqs && !this.kqt) {
            arrayList.add(8);
        }
        biJ.bc(arrayList);
        com.baidu.tbadk.editortools.l nT = biJ.nT(5);
        if (nT != null) {
            nT.eAR = 3;
            if (this.kqt) {
                nT.iM(false);
            }
        }
        biJ.build();
        if (this.kqs || this.kqt) {
            biJ.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.kqr = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void su(boolean z) {
        this.kqs = z;
    }

    public void sv(boolean z) {
        this.kqt = z;
    }
}
