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
    private com.baidu.tbadk.editortools.b lWd;
    private boolean lWe = false;
    private boolean lWf = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e fg(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.lWe) {
            editorTools.setBarLauncherType(2);
        } else if (this.lWf) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.kO(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.kN(true);
        return new s(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar instanceof s) {
            EditorTools bBk = eVar.bBk();
            final s sVar = (s) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.t.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (sVar != null && sVar.bBk() != null && aVar != null) {
                        if (t.this.lWd != null) {
                            t.this.lWd.a(aVar);
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
                                    sVar.bBX();
                                    return;
                                }
                                switch (sVar.bCb()) {
                                    case 0:
                                        sVar.bBU();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        sVar.bBS();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.b.dOB().yA(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                sVar.bBk().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (t.this.a(sVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    sVar.bBR();
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
            bBk.setActionListener(16, bVar);
            bBk.setActionListener(14, bVar);
            bBk.setActionListener(15, bVar);
            bBk.setActionListener(24, bVar);
            bBk.setActionListener(3, bVar);
            bBk.setActionListener(18, bVar);
            bBk.setActionListener(20, bVar);
            bBk.setActionListener(10, bVar);
            bBk.setActionListener(11, bVar);
            bBk.setActionListener(36, bVar);
            bBk.setActionListener(32, bVar);
            bBk.setActionListener(43, bVar);
            bBk.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.m mVar;
        EditorTools bBk = eVar.bBk();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.lWe) {
            arrayList.add(10);
            bBk.b(new com.baidu.tbadk.editortools.imagetool.d(bBk.getContext(), 1));
        }
        if (!this.lWf) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.dPk() && com.baidu.tieba.tbadkCore.u.e(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bBk.getContext()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
                mVar.fDG = 2;
                bBk.b(mVar);
            }
            bBk.b(new com.baidu.tbadk.editortools.a.a(bBk.getContext(), 4));
            if (!this.lWe) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bBk.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData();
                    mVar2.fDG = 6;
                    bBk.b(mVar2);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bBk.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData();
                    mVar3.fDG = 7;
                    bBk.b(mVar3);
                }
            }
            if (!"PbChosenActivity".equals(bBk.getContext().getClass().getSimpleName()) && !this.lWe) {
                bBk.b(new com.baidu.tbadk.editortools.b.a(bBk.getContext(), 5));
            }
        }
        if (!this.lWe && !this.lWf) {
            arrayList.add(8);
        }
        bBk.bG(arrayList);
        com.baidu.tbadk.editortools.m qV = bBk.qV(5);
        if (qV != null) {
            qV.fDG = 3;
            if (this.lWf) {
                qV.kQ(false);
            }
        }
        bBk.build();
        if (this.lWe || this.lWf) {
            bBk.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.lWd = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void vj(boolean z) {
        this.lWe = z;
    }

    public void vk(boolean z) {
        this.lWf = z;
    }
}
