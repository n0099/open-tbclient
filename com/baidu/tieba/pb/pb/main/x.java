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
    private com.baidu.tbadk.editortools.b lwb;
    private boolean lwc = false;
    private boolean lwd = false;
    private PbEditorData.ThreadData mThreadData;

    @Override // com.baidu.tbadk.editortools.c
    protected com.baidu.tbadk.editortools.e ej(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setIsFromPb(true);
        editorTools.setBarMaxLauCount(5);
        if (this.lwc) {
            editorTools.setBarLauncherType(2);
        } else if (this.lwd) {
            editorTools.setBarLauncherType(5);
        } else {
            editorTools.setBarLauncherType(3);
        }
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.cp_bg_line_h);
        editorTools.kc(true);
        editorTools.setMoreButtonAtEnd(true);
        editorTools.kb(true);
        return new w(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.e eVar) {
        if (eVar instanceof w) {
            EditorTools bzx = eVar.bzx();
            final w wVar = (w) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.pb.main.x.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar) {
                    if (wVar != null && wVar.bzx() != null && aVar != null) {
                        if (x.this.lwb != null) {
                            x.this.lwb.a(aVar);
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
                                    wVar.bAk();
                                    return;
                                }
                                switch (wVar.bAo()) {
                                    case 0:
                                        wVar.bAh();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        wVar.bAf();
                                        return;
                                }
                            case 20:
                                com.baidu.tieba.tbadkCore.location.b.dKC().xv(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                wVar.bzx().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (x.this.a(wVar.getContext().getPageContext(), RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    wVar.bAe();
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
            bzx.setActionListener(16, bVar);
            bzx.setActionListener(14, bVar);
            bzx.setActionListener(15, bVar);
            bzx.setActionListener(24, bVar);
            bzx.setActionListener(3, bVar);
            bzx.setActionListener(18, bVar);
            bzx.setActionListener(20, bVar);
            bzx.setActionListener(10, bVar);
            bzx.setActionListener(11, bVar);
            bzx.setActionListener(36, bVar);
            bzx.setActionListener(32, bVar);
            bzx.setActionListener(43, bVar);
            bzx.setActionListener(45, bVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.e eVar) {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.m mVar;
        EditorTools bzx = eVar.bzx();
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        if (!this.lwc) {
            arrayList.add(10);
            bzx.b(new com.baidu.tbadk.editortools.imagetool.d(bzx.getContext(), 1));
        }
        if (!this.lwd) {
            arrayList.add(6);
            arrayList.add(9);
            String str = "";
            if (this.mThreadData != null) {
                str = this.mThreadData.getForumName();
            }
            if (com.baidu.tieba.tbadkCore.voice.c.dLl() && com.baidu.tieba.tbadkCore.t.d(str, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bzx.getContext()), com.baidu.tbadk.editortools.m.class)) != null && (mVar = (com.baidu.tbadk.editortools.m) runTask.getData()) != null) {
                mVar.foi = 2;
                bzx.b(mVar);
            }
            bzx.b(new com.baidu.tbadk.editortools.a.a(bzx.getContext(), 4));
            if (!this.lwc) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bzx.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar2 = (com.baidu.tbadk.editortools.m) runTask2.getData();
                    mVar2.foi = 6;
                    bzx.b(mVar2);
                }
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bzx.getContext()), com.baidu.tbadk.editortools.m.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    com.baidu.tbadk.editortools.m mVar3 = (com.baidu.tbadk.editortools.m) runTask3.getData();
                    mVar3.foi = 7;
                    bzx.b(mVar3);
                }
            }
            if (!"PbChosenActivity".equals(bzx.getContext().getClass().getSimpleName()) && !this.lwc) {
                bzx.b(new com.baidu.tbadk.editortools.b.a(bzx.getContext(), 5));
            }
        }
        if (!this.lwc && !this.lwd) {
            arrayList.add(8);
        }
        bzx.bA(arrayList);
        com.baidu.tbadk.editortools.m rk = bzx.rk(5);
        if (rk != null) {
            rk.foi = 3;
            if (this.lwd) {
                rk.ke(false);
            }
        }
        bzx.build();
        if (this.lwc || this.lwd) {
            bzx.b(new com.baidu.tbadk.editortools.a(35, 5, false));
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
        this.lwb = bVar;
    }

    public void setThreadData(PbEditorData.ThreadData threadData) {
        this.mThreadData = threadData;
    }

    public void us(boolean z) {
        this.lwc = z;
    }

    public void ut(boolean z) {
        this.lwd = z;
    }
}
