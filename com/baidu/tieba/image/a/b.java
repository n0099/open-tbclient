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
/* loaded from: classes8.dex */
public class b extends com.baidu.tbadk.editortools.c {
    private boolean fGH = false;
    private String forumId;
    private String forumName;
    public boolean kSC;

    public void ej(String str, String str2) {
        this.forumName = str;
        this.forumId = str2;
    }

    @Override // com.baidu.tbadk.editortools.c
    protected e fk(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarMaxLauCount(5);
        editorTools.setBarLauncherType(this.kSC ? 2 : 3);
        editorTools.setBackgroundColorId(0);
        editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
        editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
        editorTools.kP(false);
        editorTools.setMoreButtonAtEnd(true);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(e eVar) {
        CustomResponsedMessage runTask;
        m mVar;
        EditorTools bEI = eVar.bEI();
        if (com.baidu.tieba.tbadkCore.voice.c.dQz() && u.d(this.forumName, true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, bEI.getContext()), m.class)) != null && (mVar = (m) runTask.getData()) != null) {
            mVar.fEA = 2;
            bEI.b(mVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        bEI.bL(arrayList);
        m sv = bEI.sv(5);
        if (sv != null) {
            sv.kR(!this.kSC);
            sv.fEA = this.kSC ? 1 : 3;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(bEI.getContext(), 4);
        aVar.fEx = false;
        bEI.b(aVar);
        if (!this.kSC) {
            bEI.b(new d(bEI.getContext(), 1));
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, bEI.getContext()), m.class);
            if (runTask2 != null && runTask2.getData() != null) {
                m mVar2 = (m) runTask2.getData();
                mVar2.fEA = 6;
                bEI.b(mVar2);
            }
            bEI.b(new f(bEI.getContext(), false, true));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, bEI.getContext()), m.class);
            if (runTask3 != null && runTask3.getData() != null) {
                m mVar3 = (m) runTask3.getData();
                mVar3.fEA = 7;
                bEI.b(mVar3);
            }
            bEI.b(new com.baidu.tbadk.editortools.b.a(bEI.getContext(), 5));
        } else {
            bEI.b(new f(bEI.getContext(), false, false));
        }
        bEI.build();
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(e eVar) {
        if (eVar instanceof a) {
            EditorTools bEI = eVar.bEI();
            final a aVar = (a) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.image.a.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    int size;
                    if (aVar != null && aVar.bEI() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.DT(aVar2.data.toString());
                                if (aVar2.data instanceof SpanGroupManager) {
                                    aVar.setSpanGroupManager((SpanGroupManager) aVar2.data);
                                }
                                b.this.fGH = false;
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
                                b.this.fGH = true;
                                return;
                            case 8:
                                if (b.this.a(aVar.bzM(), (int) RequestResponseCode.REQUEST_LOGIN_WRITE)) {
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
                                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(aVar.bzM().getPageActivity(), aVar.getWriteImagesInfo().toJsonString(), true, true);
                                if (!StringUtils.isNull(b.this.forumId, true)) {
                                    albumFloatActivityConfig.getIntent().putExtra("forum_id", b.this.forumId);
                                }
                                albumFloatActivityConfig.setRequestCode(12002);
                                if (com.baidu.tbadk.editortools.pb.a.bFl().getStatus() == 1) {
                                    albumFloatActivityConfig.setRequestFrom(2);
                                    if (aVar.getWriteImagesInfo() != null) {
                                        aVar.getWriteImagesInfo().setMaxImagesAllowed(1);
                                    }
                                } else if (aVar.getWriteImagesInfo() != null) {
                                    aVar.getWriteImagesInfo().setMaxImagesAllowed(9);
                                }
                                l.hideSoftKeyPad(aVar.bzM().getPageActivity(), aVar.bzM().getPageActivity().getCurrentFocus());
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
                                return;
                            case 15:
                                int intValue = ((Integer) aVar2.data).intValue();
                                if (aVar.getWriteImagesInfo() != null && aVar.getWriteImagesInfo().getChosedFiles() != null && (size = aVar.getWriteImagesInfo().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(aVar.bzM().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, aVar.getWriteImagesInfo(), intValue)));
                                    return;
                                }
                                return;
                            case 16:
                                if (b.this.fGH) {
                                    l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                                }
                                if (b.this.a(aVar.bzM(), (int) RequestResponseCode.REQUEST_LOGIN_PB_AT)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(aVar.bzM().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                                    return;
                                }
                                return;
                            case 18:
                                if (aVar2.data != null) {
                                    aVar.bFv();
                                    return;
                                }
                                switch (aVar.bFz()) {
                                    case 0:
                                        aVar.bFs();
                                        return;
                                    case 1:
                                    default:
                                        return;
                                    case 2:
                                        aVar.bFq();
                                        return;
                                }
                            case 20:
                                aVar.bEI().b(new com.baidu.tbadk.editortools.a(2, 7, null));
                                com.baidu.tieba.tbadkCore.location.b.dPQ().ym(true);
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                                return;
                            case 32:
                                aVar.bEI().b(new com.baidu.tbadk.editortools.a(1, 11, null));
                                return;
                            case 36:
                                if (b.this.a(aVar.bzM(), (int) RequestResponseCode.REQUEST_LOGIN_PB_GIFT_TAB)) {
                                    aVar.bFp();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bEI.setActionListener(5, bVar);
            bEI.setActionListener(4, bVar);
            bEI.setActionListener(7, bVar);
            bEI.setActionListener(16, bVar);
            bEI.setActionListener(14, bVar);
            bEI.setActionListener(15, bVar);
            bEI.setActionListener(8, bVar);
            bEI.setActionListener(18, bVar);
            bEI.setActionListener(20, bVar);
            bEI.setActionListener(10, bVar);
            bEI.setActionListener(11, bVar);
            bEI.setActionListener(36, bVar);
            bEI.setActionListener(32, bVar);
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
