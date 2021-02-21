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
    private com.baidu.tbadk.editortools.b lUb;
    private boolean lUc = false;
    private boolean lUd = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e fh(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.lUc) {
            editorTools.setBarLauncherType(2);
        } else if (this.lUd) {
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
            EditorTools bBh = eVar.bBh();
            final s sVar = (s) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.t.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (sVar != null && sVar.bBh() != null && aVar != null) {
                        if (t.this.lUb != null) {
                            t.this.lUb.a(aVar);
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
                                    sVar.bBU();
                                    return;
                                }
                                switch (sVar.bBY()) {
                                    case 0:
                                        sVar.bBR();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        sVar.bBP();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.b.dOs().yB(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                sVar.bBh().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (t.this.a(sVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    sVar.bBO();
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
            bBh.setActionListener(16, bVar);
            bBh.setActionListener(14, bVar);
            bBh.setActionListener(15, bVar);
            bBh.setActionListener(24, bVar);
            bBh.setActionListener(3, bVar);
            bBh.setActionListener(18, bVar);
            bBh.setActionListener(20, bVar);
            bBh.setActionListener(10, bVar);
            bBh.setActionListener(11, bVar);
            bBh.setActionListener(36, bVar);
            bBh.setActionListener(32, bVar);
            bBh.setActionListener(43, bVar);
            bBh.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.m mVar;
        EditorTools bBh = eVar.bBh();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.lUc) {
            arrayList.add(10);
            bBh.b(new com.baidu.tbadk.editortools.imagetool.d(bBh.getContext(), 1));
        }
        if (!this.lUd) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.dPb() && com.baidu.tieba.tbadkCore.u.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bBh.getContext()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
                mVar.fCh = 2;
                bBh.b(mVar);
            }
            bBh.b(new com.baidu.tbadk.editortools.a.a(bBh.getContext(), 4));
            if (!this.lUc) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bBh.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData();
                    mVar2.fCh = 6;
                    bBh.b(mVar2);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bBh.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData();
                    mVar3.fCh = 7;
                    bBh.b(mVar3);
                }
            }
            if (!"PbChosenActivity".equals(bBh.getContext().getClass().getSimpleName()) && !this.lUc) {
                bBh.b(new com.baidu.tbadk.editortools.b.a(bBh.getContext(), 5));
            }
        }
        if (!this.lUc && !this.lUd) {
            arrayList.add(8);
        }
        bBh.bG(arrayList);
        com.baidu.tbadk.editortools.m qU = bBh.qU(5);
        if (qU != null) {
            qU.fCh = 3;
            if (this.lUd) {
                qU.kQ(false);
            }
        }
        bBh.build();
        if (this.lUc || this.lUd) {
            bBh.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.lUb = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void vj(boolean z) {
        this.lUc = z;
    }

    public void vk(boolean z) {
        this.lUd = z;
    }
}
