package com.baidu.tieba.image.a;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.e;
import com.baidu.tbadk.editortools.imagetool.d;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.f;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.ArrayList;
/* loaded from: classes21.dex */
public class b extends com.baidu.tbadk.editortools.c {
    private String forumId;
    private String forumName;
    private boolean fxb = false;
    public boolean kMX;

    public void ek(String str, String str2) {
        this.forumName = str;
        this.forumId = str2;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected e eO(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(this.kMX ? 2 : 3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
        editorTools.kt(false);
        editorTools.setMoreButtonAtEnd(true);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools bCn = eVar.bCn();
        if (com.baidu.tieba.tbadkCore.voice.c.dQC() && u.d(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bCn.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
            mVar.fuU = 2;
            bCn.b(mVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        bCn.bE(arrayList);
        m sj = bCn.sj(5);
        if (sj != null) {
            sj.kv(!this.kMX);
            sj.fuU = this.kMX ? 1 : 3;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(bCn.getContext(), 4);
        aVar.fuR = false;
        bCn.b(aVar);
        if (!this.kMX) {
            bCn.b(new d(bCn.getContext(), 1));
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bCn.getContext()), m.class);
            if (runTask2 != null && runTask2.getData() != null) {
                m mVar2 = (m) runTask2.getData();
                mVar2.fuU = 6;
                bCn.b(mVar2);
            }
            bCn.b(new f(bCn.getContext(), false, true));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bCn.getContext()), m.class);
            if (runTask3 != null && runTask3.getData() != null) {
                m mVar3 = (m) runTask3.getData();
                mVar3.fuU = 7;
                bCn.b(mVar3);
            }
            bCn.b(new com.baidu.tbadk.editortools.b.a(bCn.getContext(), 5));
        } else {
            bCn.b(new f(bCn.getContext(), false, false));
        }
        bCn.build();
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(e eVar) {
        if (eVar instanceof a) {
            EditorTools bCn = eVar.bCn();
            final a aVar = (a) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.image.a.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    int size;
                    if (aVar != null && aVar.bCn() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.DW(aVar2.data.toString());
                                if (aVar2.data instanceof SpanGroupManager) {
                                    aVar.setSpanGroupManager((SpanGroupManager) aVar2.data);
                                }
                                b.this.fxb = false;
                                return;
                            case 5:
                            case 6:
                            case 9:
                            case 12:
                            case 13:
                            case 17:
                            case 19:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 33:
                            case 34:
                            case 35:
                            default:
                                return;
                            case 7:
                                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                                b.this.fxb = true;
                                return;
                            case 8:
                                if (b.this.a(aVar.bxs(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                                    aVar.a((String) null, (WriteData) null);
                                    return;
                                }
                                return;
                            case 10:
                                if (aVar2.data instanceof VoiceData.VoiceModel) {
                                    aVar.setVoiceModel((VoiceData.VoiceModel) aVar2.data);
                                    aVar.a(true, (PostWriteCallBackData) null);
                                    return;
                                }
                                return;
                            case 11:
                                aVar.setVoiceModel(null);
                                return;
                            case 14:
                                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(aVar.bxs().getPageActivity(), aVar.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(b.this.forumId, true)) {
                                    albumFloatActivityConfig.getIntent().putExtra("forum_id", b.this.forumId);
                                }
                                albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                                if (com.baidu.tbadk.editortools.pb.a.bCQ().getStatus() == 1) {
                                    albumFloatActivityConfig.setRequestFrom(2);
                                    if (aVar.getWriteImagesInfo() != null) {
                                        aVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (aVar.getWriteImagesInfo() != null) {
                                    aVar.getWriteImagesInfo().setMaxImagesAllowed(9);
                                }
                                l.hideSoftKeyPad(aVar.bxs().getPageActivity(), aVar.bxs().getPageActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar2.data).intValue();
                                if (aVar.getWriteImagesInfo() != null && aVar.getWriteImagesInfo().getChosedFiles() != null && (size = aVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(aVar.bxs().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, aVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (b.this.fxb) {
                                    l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                                }
                                if (b.this.a(aVar.bxs(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(aVar.bxs().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar2.data != null) {
                                    aVar.bDa();
                                    return;
                                }
                                switch (aVar.bDe()) {
                                    case 0:
                                        aVar.bCX();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        aVar.bCV();
                                        return;
                                }
                            case 20:
                                aVar.bCn().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.b.dPT().yh(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                aVar.bCn().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (b.this.a(aVar.bxs(), (int) RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    aVar.bCU();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bCn.setActionListener(5, bVar);
            bCn.setActionListener(4, bVar);
            bCn.setActionListener(7, bVar);
            bCn.setActionListener(16, bVar);
            bCn.setActionListener(14, bVar);
            bCn.setActionListener(15, bVar);
            bCn.setActionListener(8, bVar);
            bCn.setActionListener(18, bVar);
            bCn.setActionListener(20, bVar);
            bCn.setActionListener(10, bVar);
            bCn.setActionListener(11, bVar);
            bCn.setActionListener(36, bVar);
            bCn.setActionListener(32, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (com.baidu.tbadk.mutiprocess.f.isLogin()) {
            return true;
        }
        TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
        return false;
    }
}
