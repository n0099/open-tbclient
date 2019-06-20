package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.editortools.c {
    @Override // com.baidu.tbadk.editortools.c
    protected d cK(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(R.color.cp_bg_line_d);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(d dVar) {
        if (dVar != null) {
            EditorTools aqS = dVar.aqS();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            aqS.ai(arrayList);
            k kj = aqS.kj(5);
            if (kj != null) {
                kj.fg(false);
                kj.cru = 0;
            }
            aqS.b(new c(aqS.getContext()));
            aqS.aqT();
            aqS.b(new com.baidu.tbadk.editortools.a(35, 5, false));
            aqS.hide();
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(d dVar) {
        if (dVar instanceof a) {
            EditorTools aqS = dVar.aqS();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.videoplay.editor.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    if (aVar != null && aVar.aqS() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.qa((String) aVar2.data);
                                return;
                            case 5:
                            case 6:
                            default:
                                return;
                            case 7:
                                aVar.alf().showToast((int) R.string.over_limit_tip);
                                return;
                            case 8:
                                aVar.cuQ();
                                if (b.this.a(aVar.alf(), SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                                    aVar.arL();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            aqS.setActionListener(4, bVar);
            aqS.setActionListener(7, bVar);
            aqS.setActionListener(8, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return true;
    }
}
