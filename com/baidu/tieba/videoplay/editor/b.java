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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b extends com.baidu.tbadk.editortools.c {
    @Override // com.baidu.tbadk.editortools.c
    protected d de(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(d.C0277d.cp_bg_line_d);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(com.baidu.tbadk.editortools.d dVar) {
        if (dVar != null) {
            EditorTools alS = dVar.alS();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            alS.ab(arrayList);
            k jw = alS.jw(5);
            if (jw != null) {
                jw.eK(false);
                jw.cji = 0;
            }
            alS.b(new c(alS.getContext()));
            alS.alT();
            alS.b(new com.baidu.tbadk.editortools.a(35, 5, false));
            alS.hide();
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(com.baidu.tbadk.editortools.d dVar) {
        if (dVar instanceof a) {
            EditorTools alS = dVar.alS();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.videoplay.editor.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    if (aVar != null && aVar.alS() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.oS((String) aVar2.data);
                                return;
                            case 5:
                            case 6:
                            default:
                                return;
                            case 7:
                                aVar.agj().showToast(d.j.over_limit_tip);
                                return;
                            case 8:
                                aVar.cmO();
                                if (b.this.a(aVar.agj(), SapiGIDEvent.SYSTEM_NETWORK_CHANGE_TO_AVALIABLE)) {
                                    aVar.amL();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            alS.setActionListener(4, bVar);
            alS.setActionListener(7, bVar);
            alS.setActionListener(8, bVar);
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
