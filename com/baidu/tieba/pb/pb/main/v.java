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
/* loaded from: classes6.dex */
public class v extends com.baidu.tbadk.editortools.c {
    private com.baidu.tbadk.editortools.b iEA;
    private boolean iEB = false;
    private boolean iEC = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dS(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.iEB) {
            editorTools.setBarLauncherType(2);
        } else if (this.iEC) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.gq(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.gp(true);
        return new u(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof u) {
            EditorTools aLC = dVar.aLC();
            final u uVar = (u) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.v.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (uVar != null && uVar.aLC() != null && aVar != null) {
                        if (v.this.iEA != null) {
                            v.this.iEA.a(aVar);
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
                                    uVar.aMh();
                                    return;
                                }
                                switch (uVar.aMm()) {
                                    case 0:
                                        uVar.aMe();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        uVar.aMd();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.cJa().sz(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                uVar.aLC().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (v.this.a(uVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    uVar.aMc();
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
            aLC.setActionListener(16, bVar);
            aLC.setActionListener(14, bVar);
            aLC.setActionListener(15, bVar);
            aLC.setActionListener(24, bVar);
            aLC.setActionListener(3, bVar);
            aLC.setActionListener(18, bVar);
            aLC.setActionListener(20, bVar);
            aLC.setActionListener(10, bVar);
            aLC.setActionListener(11, bVar);
            aLC.setActionListener(36, bVar);
            aLC.setActionListener(32, bVar);
            aLC.setActionListener(43, bVar);
            aLC.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar2;
        EditorTools aLC = dVar.aLC();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.iEB) {
            arrayList.add(10);
            aLC.b(new com.baidu.tbadk.editortools.imagetool.d(aLC.getContext(), 3));
        }
        if (!this.iEC) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.cJF() && com.baidu.tieba.tbadkCore.r.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, aLC.getContext()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
                lVar2.dsY = 4;
                aLC.b(lVar2);
            }
            aLC.b(new com.baidu.tbadk.editortools.a.a(aLC.getContext(), 5));
            if (!this.iEB) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, aLC.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar3 = (com.baidu.tbadk.editortools.l) runTask2.getData();
                    lVar3.dsY = 9;
                    lVar3.dsU = R.drawable.icon_pure_more_bubble40_svg;
                    aLC.b(lVar3);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, aLC.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar4 = (com.baidu.tbadk.editortools.l) runTask3.getData();
                    lVar4.dsY = 10;
                    lVar4.dsU = R.drawable.icon_pure_more_tail40_svg;
                    aLC.b(lVar4);
                }
            }
            if (!"PbChosenActivity".equals(aLC.getContext().getClass().getSimpleName()) && !this.iEB) {
                aLC.b(new com.baidu.tbadk.editortools.b.a(aLC.getContext(), 5));
            }
        }
        if (!this.iEB && !this.iEC) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, aLC.getContext()), com.baidu.tbadk.editortools.l.class);
            if (runTask4 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
                lVar.dsY = 6;
                aLC.b(lVar);
            }
            arrayList.add(8);
        }
        aLC.aJ(arrayList);
        com.baidu.tbadk.editortools.l lX = aLC.lX(5);
        if (lX != null) {
            lX.dsY = 1;
            if (this.iEC) {
                lX.gs(false);
            }
        }
        aLC.build();
        if (this.iEB || this.iEC) {
            aLC.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.iEA = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void pE(boolean z) {
        this.iEB = z;
    }

    public void pF(boolean z) {
        this.iEC = z;
    }
}
