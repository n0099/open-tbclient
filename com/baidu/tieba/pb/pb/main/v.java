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
public class v extends com.baidu.tbadk.editortools.c {
    private boolean khA = false;
    private boolean khB = false;
    private com.baidu.tbadk.editortools.b khz;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dP(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.khA) {
            editorTools.setBarLauncherType(2);
        } else if (this.khB) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.ig(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.m32if(true);
        return new u(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof u) {
            EditorTools bfa = dVar.bfa();
            final u uVar = (u) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.v.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (uVar != null && uVar.bfa() != null && aVar != null) {
                        if (v.this.khz != null) {
                            v.this.khz.a(aVar);
                        }
                        switch (aVar.code) {
                            case 16:
                                if (v.this.a(uVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(uVar.getContext().getActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar.data != null) {
                                    uVar.bfH();
                                    return;
                                }
                                switch (uVar.bfM()) {
                                    case 0:
                                        uVar.bfE();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        uVar.bfC();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.diD().uK(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                uVar.bfa().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (v.this.a(uVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    uVar.bfB();
                                    return;
                                }
                                return;
                            case 43:
                                if (!com.baidu.tbadk.plugins.b.a(uVar.getContext().getPageContext(), true, false)) {
                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(uVar.getContext().getActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_PB);
                                    if (v.this.mThreadData != null) {
                                        hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(v.this.mThreadData.getForumId(), 0L), v.this.mThreadData.getFirstDir(), v.this.mThreadData.getSecondDir());
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
            bfa.setActionListener(16, bVar);
            bfa.setActionListener(14, bVar);
            bfa.setActionListener(15, bVar);
            bfa.setActionListener(24, bVar);
            bfa.setActionListener(3, bVar);
            bfa.setActionListener(18, bVar);
            bfa.setActionListener(20, bVar);
            bfa.setActionListener(10, bVar);
            bfa.setActionListener(11, bVar);
            bfa.setActionListener(36, bVar);
            bfa.setActionListener(32, bVar);
            bfa.setActionListener(43, bVar);
            bfa.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar;
        EditorTools bfa = dVar.bfa();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.khA) {
            arrayList.add(10);
            bfa.b(new com.baidu.tbadk.editortools.imagetool.d(bfa.getContext(), 1));
        }
        if (!this.khB) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.djm() && com.baidu.tieba.tbadkCore.s.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bfa.getContext()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
                lVar.euy = 2;
                bfa.b(lVar);
            }
            bfa.b(new com.baidu.tbadk.editortools.a.a(bfa.getContext(), 4));
            if (!this.khA) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bfa.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar2 = (com.baidu.tbadk.editortools.l) runTask2.getData();
                    lVar2.euy = 6;
                    bfa.b(lVar2);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bfa.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData();
                    lVar3.euy = 7;
                    bfa.b(lVar3);
                }
            }
            if (!"PbChosenActivity".equals(bfa.getContext().getClass().getSimpleName()) && !this.khA) {
                bfa.b(new com.baidu.tbadk.editortools.b.a(bfa.getContext(), 5));
            }
        }
        if (!this.khA && !this.khB) {
            arrayList.add(8);
        }
        bfa.aW(arrayList);
        com.baidu.tbadk.editortools.l nB = bfa.nB(5);
        if (nB != null) {
            nB.euy = 3;
            if (this.khB) {
                nB.ii(false);
            }
        }
        bfa.build();
        if (this.khA || this.khB) {
            bfa.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.khz = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void rP(boolean z) {
        this.khA = z;
    }

    public void rQ(boolean z) {
        this.khB = z;
    }
}
