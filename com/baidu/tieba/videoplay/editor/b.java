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
/* loaded from: classes18.dex */
public class b extends com.baidu.tbadk.editortools.c {
    @Override // com.baidu.tbadk.editortools.c
    protected e ed(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(R.color.cp_bg_line_h);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(e eVar) {
        if (eVar != null) {
            EditorTools brv = eVar.brv();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            brv.bc(arrayList);
            m qe = brv.qe(5);
            if (qe != null) {
                qe.jk(false);
                qe.eLk = 0;
            }
            brv.b(new c(brv.getContext()));
            brv.build();
            brv.b(new com.baidu.tbadk.editortools.a(35, 5, false));
            brv.hide();
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(e eVar) {
        if (eVar instanceof a) {
            EditorTools brv = eVar.brv();
            final a aVar = (a) eVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.videoplay.editor.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    if (aVar != null && aVar.brv() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.BZ((String) aVar2.data);
                                return;
                            case 5:
                            case 6:
                            default:
                                return;
                            case 7:
                                aVar.bmF().showToast(R.string.over_limit_tip);
                                return;
                            case 8:
                                aVar.dEP();
                                if (b.this.a(aVar.bmF(), RequestResponseCode.REQUEST_LOGIN_WRITE)) {
                                    aVar.bsu();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            brv.setActionListener(4, bVar);
            brv.setActionListener(7, bVar);
            brv.setActionListener(8, bVar);
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
