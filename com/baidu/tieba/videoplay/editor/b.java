package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.e;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b extends com.baidu.tbadk.editortools.c {
    @Override // com.baidu.tbadk.editortools.c
    protected e fh(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(R.color.CAM_X0207);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(e eVar) {
        if (eVar != null) {
            EditorTools bBh = eVar.bBh();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            bBh.bG(arrayList);
            m qU = bBh.qU(5);
            if (qU != null) {
                qU.kQ(false);
                qU.fCb = 0;
            }
            bBh.b(new c(bBh.getContext()));
            bBh.build();
            bBh.b(new com.baidu.tbadk.editortools.a(35, 5, false));
            bBh.hide();
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(e eVar) {
        if (eVar instanceof a) {
            EditorTools bBh = eVar.bBh();
            final a aVar = (a) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.videoplay.editor.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    if (aVar != null && aVar.bBh() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.CW((String) aVar2.data);
                                return;
                            case 5:
                            case 6:
                            default:
                                return;
                            case 7:
                                aVar.bwm().showToast(R.string.over_limit_tip);
                                return;
                            case 8:
                                aVar.dVO();
                                if (b.this.a(aVar.bwm(), RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                                    aVar.bCm();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            bBh.setActionListener(4, bVar);
            bBh.setActionListener(7, bVar);
            bBh.setActionListener(8, bVar);
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
}
