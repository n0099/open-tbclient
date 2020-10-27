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
    private com.baidu.tbadk.editortools.b lqe;
    private boolean lqf = false;
    private boolean lqg = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e ej(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.lqf) {
            editorTools.setBarLauncherType(2);
        } else if (this.lqg) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.jT(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.jS(true);
        return new w(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar instanceof w) {
            EditorTools bwY = eVar.bwY();
            final w wVar = (w) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (wVar != null && wVar.bwY() != null && aVar != null) {
                        if (x.this.lqe != null) {
                            x.this.lqe.a(aVar);
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
                                    wVar.bxL();
                                    return;
                                }
                                switch (wVar.bxP()) {
                                    case 0:
                                        wVar.bxI();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        wVar.bxG();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.b.dIa().xm(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                wVar.bwY().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (x.this.a(wVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    wVar.bxF();
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
            bwY.setActionListener(16, bVar);
            bwY.setActionListener(14, bVar);
            bwY.setActionListener(15, bVar);
            bwY.setActionListener(24, bVar);
            bwY.setActionListener(3, bVar);
            bwY.setActionListener(18, bVar);
            bwY.setActionListener(20, bVar);
            bwY.setActionListener(10, bVar);
            bwY.setActionListener(11, bVar);
            bwY.setActionListener(36, bVar);
            bwY.setActionListener(32, bVar);
            bwY.setActionListener(43, bVar);
            bwY.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.m mVar;
        EditorTools bwY = eVar.bwY();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.lqf) {
            arrayList.add(10);
            bwY.b(new com.baidu.tbadk.editortools.imagetool.d(bwY.getContext(), 1));
        }
        if (!this.lqg) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.dIJ() && com.baidu.tieba.tbadkCore.t.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bwY.getContext()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
                mVar.fiq = 2;
                bwY.b(mVar);
            }
            bwY.b(new com.baidu.tbadk.editortools.a.a(bwY.getContext(), 4));
            if (!this.lqf) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bwY.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData();
                    mVar2.fiq = 6;
                    bwY.b(mVar2);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bwY.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData();
                    mVar3.fiq = 7;
                    bwY.b(mVar3);
                }
            }
            if (!"PbChosenActivity".equals(bwY.getContext().getClass().getSimpleName()) && !this.lqf) {
                bwY.b(new com.baidu.tbadk.editortools.b.a(bwY.getContext(), 5));
            }
        }
        if (!this.lqf && !this.lqg) {
            arrayList.add(8);
        }
        bwY.bt(arrayList);
        com.baidu.tbadk.editortools.m ra = bwY.ra(5);
        if (ra != null) {
            ra.fiq = 3;
            if (this.lqg) {
                ra.jV(false);
            }
        }
        bwY.build();
        if (this.lqf || this.lqg) {
            bwY.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.lqe = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void uj(boolean z) {
        this.lqf = z;
    }

    public void uk(boolean z) {
        this.lqg = z;
    }
}
