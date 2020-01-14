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
/* loaded from: classes7.dex */
public class v extends com.baidu.tbadk.editortools.c {
    private com.baidu.tbadk.editortools.b iIe;
    private boolean iIf = false;
    private boolean iIg = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.d dS(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.iIf) {
            editorTools.setBarLauncherType(2);
        } else if (this.iIg) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.gv(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.gu(true);
        return new u(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof u) {
            EditorTools aLV = dVar.aLV();
            final u uVar = (u) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.v.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (uVar != null && uVar.aLV() != null && aVar != null) {
                        if (v.this.iIe != null) {
                            v.this.iIe.a(aVar);
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
                                    uVar.aMA();
                                    return;
                                }
                                switch (uVar.aMF()) {
                                    case 0:
                                        uVar.aMx();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        uVar.aMw();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.c.cKg().sL(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                uVar.aLV().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (v.this.a(uVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    uVar.aMv();
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
            aLV.setActionListener(16, bVar);
            aLV.setActionListener(14, bVar);
            aLV.setActionListener(15, bVar);
            aLV.setActionListener(24, bVar);
            aLV.setActionListener(3, bVar);
            aLV.setActionListener(18, bVar);
            aLV.setActionListener(20, bVar);
            aLV.setActionListener(10, bVar);
            aLV.setActionListener(11, bVar);
            aLV.setActionListener(36, bVar);
            aLV.setActionListener(32, bVar);
            aLV.setActionListener(43, bVar);
            aLV.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar2;
        EditorTools aLV = dVar.aLV();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.iIf) {
            arrayList.add(10);
            aLV.b(new com.baidu.tbadk.editortools.imagetool.d(aLV.getContext(), 3));
        }
        if (!this.iIg) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.cKL() && com.baidu.tieba.tbadkCore.r.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, aLV.getContext()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
                lVar2.dtj = 4;
                aLV.b(lVar2);
            }
            aLV.b(new com.baidu.tbadk.editortools.a.a(aLV.getContext(), 5));
            if (!this.iIf) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, aLV.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar3 = (com.baidu.tbadk.editortools.l) runTask2.getData();
                    lVar3.dtj = 9;
                    lVar3.dtf = R.drawable.icon_pure_more_bubble40_svg;
                    aLV.b(lVar3);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, aLV.getContext()), com.baidu.tbadk.editortools.l.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.l lVar4 = (com.baidu.tbadk.editortools.l) runTask3.getData();
                    lVar4.dtj = 10;
                    lVar4.dtf = R.drawable.icon_pure_more_tail40_svg;
                    aLV.b(lVar4);
                }
            }
            if (!"PbChosenActivity".equals(aLV.getContext().getClass().getSimpleName()) && !this.iIf) {
                aLV.b(new com.baidu.tbadk.editortools.b.a(aLV.getContext(), 5));
            }
        }
        if (!this.iIf && !this.iIg) {
            CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_LOCATION_TOOL_CRTL, aLV.getContext()), com.baidu.tbadk.editortools.l.class);
            if (runTask4 != null && (lVar = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
                lVar.dtj = 6;
                aLV.b(lVar);
            }
            arrayList.add(8);
        }
        aLV.aI(arrayList);
        com.baidu.tbadk.editortools.l lX = aLV.lX(5);
        if (lX != null) {
            lX.dtj = 1;
            if (this.iIg) {
                lX.gx(false);
            }
        }
        aLV.build();
        if (this.iIf || this.iIg) {
            aLV.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.iIe = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void pQ(boolean z) {
        this.iIf = z;
    }

    public void pR(boolean z) {
        this.iIg = z;
    }
}
