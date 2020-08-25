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
    private com.baidu.tbadk.editortools.b kFJ;
    private boolean kFK = false;
    private boolean kFL = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e ed(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.kFK) {
            editorTools.setBarLauncherType(2);
        } else if (this.kFL) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.ji(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.jh(true);
        return new w(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar instanceof w) {
            EditorTools brv = eVar.brv();
            final w wVar = (w) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (wVar != null && wVar.brv() != null && aVar != null) {
                        if (x.this.kFJ != null) {
                            x.this.kFJ.a(aVar);
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
                                    wVar.bsd();
                                    return;
                                }
                                switch (wVar.bsh()) {
                                    case 0:
                                        wVar.bsa();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        wVar.brY();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.b.dxi().wd(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                wVar.brv().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (x.this.a(wVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    wVar.brX();
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
            brv.setActionListener(16, bVar);
            brv.setActionListener(14, bVar);
            brv.setActionListener(15, bVar);
            brv.setActionListener(24, bVar);
            brv.setActionListener(3, bVar);
            brv.setActionListener(18, bVar);
            brv.setActionListener(20, bVar);
            brv.setActionListener(10, bVar);
            brv.setActionListener(11, bVar);
            brv.setActionListener(36, bVar);
            brv.setActionListener(32, bVar);
            brv.setActionListener(43, bVar);
            brv.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.m mVar;
        EditorTools brv = eVar.brv();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.kFK) {
            arrayList.add(10);
            brv.b(new com.baidu.tbadk.editortools.imagetool.d(brv.getContext(), 1));
        }
        if (!this.kFL) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.dxR() && com.baidu.tieba.tbadkCore.t.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, brv.getContext()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
                mVar.eLq = 2;
                brv.b(mVar);
            }
            brv.b(new com.baidu.tbadk.editortools.a.a(brv.getContext(), 4));
            if (!this.kFK) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, brv.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData();
                    mVar2.eLq = 6;
                    brv.b(mVar2);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, brv.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData();
                    mVar3.eLq = 7;
                    brv.b(mVar3);
                }
            }
            if (!"PbChosenActivity".equals(brv.getContext().getClass().getSimpleName()) && !this.kFK) {
                brv.b(new com.baidu.tbadk.editortools.b.a(brv.getContext(), 5));
            }
        }
        if (!this.kFK && !this.kFL) {
            arrayList.add(8);
        }
        brv.bc(arrayList);
        com.baidu.tbadk.editortools.m qe = brv.qe(5);
        if (qe != null) {
            qe.eLq = 3;
            if (this.kFL) {
                qe.jk(false);
            }
        }
        brv.build();
        if (this.kFK || this.kFL) {
            brv.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.kFJ = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void tc(boolean z) {
        this.kFK = z;
    }

    public void td(boolean z) {
        this.kFL = z;
    }
}
