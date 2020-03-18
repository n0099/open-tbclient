package com.baidu.tieba.videoplay.editor;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.d;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class b extends com.baidu.tbadk.editortools.c {
    @Override // com.baidu.tbadk.editortools.c
    protected d dV(Context context) {
        EditorTools editorTools = new EditorTools(context);
        editorTools.setBarLauncherType(4);
        editorTools.setBackgroundColorId(R.color.cp_bg_line_h);
        return new a(editorTools);
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void a(d dVar) {
        if (dVar != null) {
            EditorTools aOy = dVar.aOy();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            aOy.aI(arrayList);
            l mr = aOy.mr(5);
            if (mr != null) {
                mr.gF(false);
                mr.dxM = 0;
            }
            aOy.b(new c(aOy.getContext()));
            aOy.build();
            aOy.b(new com.baidu.tbadk.editortools.a(35, 5, false));
            aOy.hide();
        }
    }

    @Override // com.baidu.tbadk.editortools.c
    protected void b(d dVar) {
        if (dVar instanceof a) {
            EditorTools aOy = dVar.aOy();
            final a aVar = (a) dVar;
            com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.videoplay.editor.b.1
                @Override // com.baidu.tbadk.editortools.b
                public void a(com.baidu.tbadk.editortools.a aVar2) {
                    if (aVar != null && aVar.aOy() != null && aVar2 != null) {
                        switch (aVar2.code) {
                            case 4:
                                aVar.vm((String) aVar2.data);
                                return;
                            case 5:
                            case 6:
                            default:
                                return;
                            case 7:
                                aVar.aJv().showToast((int) R.string.over_limit_tip);
                                return;
                            case 8:
                                aVar.cTG();
                                if (b.this.a(aVar.aJv(), 11001)) {
                                    aVar.aPt();
                                    return;
                                }
                                return;
                        }
                    }
                }
            };
            aOy.setActionListener(4, bVar);
            aOy.setActionListener(7, bVar);
            aOy.setActionListener(8, bVar);
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
