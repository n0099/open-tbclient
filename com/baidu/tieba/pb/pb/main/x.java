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
/* loaded from: classes22.dex */
public class x extends com.baidu.tbadk.editortools.c {
    private com.baidu.tbadk.editortools.b lKe;
    private boolean lKf = false;
    private boolean lKg = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e eO(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.lKf) {
            editorTools.setBarLauncherType(2);
        } else if (this.lKg) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.kt(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.ks(true);
        return new w(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar instanceof w) {
            EditorTools bCn = eVar.bCn();
            final w wVar = (w) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (wVar != null && wVar.bCn() != null && aVar != null) {
                        if (x.this.lKe != null) {
                            x.this.lKe.a(aVar);
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
                                    wVar.bDa();
                                    return;
                                }
                                switch (wVar.bDe()) {
                                    case 0:
                                        wVar.bCX();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        wVar.bCV();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.b.dPT().yh(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                wVar.bCn().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (x.this.a(wVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    wVar.bCU();
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
            bCn.setActionListener(16, bVar);
            bCn.setActionListener(14, bVar);
            bCn.setActionListener(15, bVar);
            bCn.setActionListener(24, bVar);
            bCn.setActionListener(3, bVar);
            bCn.setActionListener(18, bVar);
            bCn.setActionListener(20, bVar);
            bCn.setActionListener(10, bVar);
            bCn.setActionListener(11, bVar);
            bCn.setActionListener(36, bVar);
            bCn.setActionListener(32, bVar);
            bCn.setActionListener(43, bVar);
            bCn.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.m mVar;
        EditorTools bCn = eVar.bCn();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.lKf) {
            arrayList.add(10);
            bCn.b(new com.baidu.tbadk.editortools.imagetool.d(bCn.getContext(), 1));
        }
        if (!this.lKg) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.dQC() && com.baidu.tieba.tbadkCore.u.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bCn.getContext()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
                mVar.fuU = 2;
                bCn.b(mVar);
            }
            bCn.b(new com.baidu.tbadk.editortools.a.a(bCn.getContext(), 4));
            if (!this.lKf) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bCn.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData();
                    mVar2.fuU = 6;
                    bCn.b(mVar2);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bCn.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData();
                    mVar3.fuU = 7;
                    bCn.b(mVar3);
                }
            }
            if (!"PbChosenActivity".equals(bCn.getContext().getClass().getSimpleName()) && !this.lKf) {
                bCn.b(new com.baidu.tbadk.editortools.b.a(bCn.getContext(), 5));
            }
        }
        if (!this.lKf && !this.lKg) {
            arrayList.add(8);
        }
        bCn.bE(arrayList);
        com.baidu.tbadk.editortools.m sj = bCn.sj(5);
        if (sj != null) {
            sj.fuU = 3;
            if (this.lKg) {
                sj.kv(false);
            }
        }
        bCn.build();
        if (this.lKf || this.lKg) {
            bCn.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.lKe = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void uX(boolean z) {
        this.lKf = z;
    }

    public void uY(boolean z) {
        this.lKg = z;
    }
}
