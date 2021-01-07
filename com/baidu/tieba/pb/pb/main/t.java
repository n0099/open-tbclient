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
/* loaded from: classes2.dex */
public class t extends com.baidu.tbadk.editortools.c {
    private com.baidu.tbadk.editortools.b lPu;
    private boolean lPv = false;
    private boolean lPw = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e fk(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.lPv) {
            editorTools.setBarLauncherType(2);
        } else if (this.lPw) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.kP(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.kO(true);
        return new s(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar instanceof s) {
            EditorTools bEJ = eVar.bEJ();
            final s sVar = (s) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.t.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (sVar != null && sVar.bEJ() != null && aVar != null) {
                        if (t.this.lPu != null) {
                            t.this.lPu.a(aVar);
                        }
                        switch (aVar.code) {
                            case 16:
                                if (t.this.a(sVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(sVar.getContext().getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    sVar.bFw();
                                    return;
                                }
                                switch (sVar.bFA()) {
                                    case 0:
                                        sVar.bFt();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        sVar.bFr();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.b.dPR().ym(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                sVar.bEJ().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (t.this.a(sVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    sVar.bFq();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(sVar.getContext().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(sVar.getContext().getActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (t.this.mThreadData != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(t.this.mThreadData.getForumId(), 0L), t.this.mThreadData.getFirstDir(), t.this.mThreadData.getSecondDir());
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
            bEJ.setActionListener(16, bVar);
            bEJ.setActionListener(14, bVar);
            bEJ.setActionListener(15, bVar);
            bEJ.setActionListener(24, bVar);
            bEJ.setActionListener(3, bVar);
            bEJ.setActionListener(18, bVar);
            bEJ.setActionListener(20, bVar);
            bEJ.setActionListener(10, bVar);
            bEJ.setActionListener(11, bVar);
            bEJ.setActionListener(36, bVar);
            bEJ.setActionListener(32, bVar);
            bEJ.setActionListener(43, bVar);
            bEJ.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.m mVar;
        EditorTools bEJ = eVar.bEJ();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.lPv) {
            arrayList.add(10);
            bEJ.b(new com.baidu.tbadk.editortools.imagetool.d(bEJ.getContext(), 1));
        }
        if (!this.lPw) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.dQA() && com.baidu.tieba.tbadkCore.u.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bEJ.getContext()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
                mVar.fEA = 2;
                bEJ.b(mVar);
            }
            bEJ.b(new com.baidu.tbadk.editortools.a.a(bEJ.getContext(), 4));
            if (!this.lPv) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bEJ.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData();
                    mVar2.fEA = 6;
                    bEJ.b(mVar2);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bEJ.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData();
                    mVar3.fEA = 7;
                    bEJ.b(mVar3);
                }
            }
            if (!"PbChosenActivity".equals(bEJ.getContext().getClass().getSimpleName()) && !this.lPv) {
                bEJ.b(new com.baidu.tbadk.editortools.b.a(bEJ.getContext(), 5));
            }
        }
        if (!this.lPv && !this.lPw) {
            arrayList.add(8);
        }
        bEJ.bL(arrayList);
        com.baidu.tbadk.editortools.m sv = bEJ.sv(5);
        if (sv != null) {
            sv.fEA = 3;
            if (this.lPw) {
                sv.kR(false);
            }
        }
        bEJ.build();
        if (this.lPv || this.lPw) {
            bEJ.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.lPu = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void uY(boolean z) {
        this.lPv = z;
    }

    public void uZ(boolean z) {
        this.lPw = z;
    }
}
