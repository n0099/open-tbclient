package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.TbPageContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKS;
    final /* synthetic */ PbEditor cqW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbEditor pbEditor, com.baidu.tbadk.editortool.v vVar) {
        this.cqW = pbEditor;
        this.aKS = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        Pattern pattern;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.f)) {
                if (this.cqW.Kn()) {
                    com.baidu.adp.lib.util.n.showToast(this.cqW.getContext(), com.baidu.tieba.t.over_limit_tip);
                    return;
                }
                com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) obj;
                if (fVar.getName() != null) {
                    if (PbEditor.jz(this.cqW.cqO.getEditText().getText().toString()) >= 10) {
                        tbPageContext = this.cqW.mPageContext;
                        if (tbPageContext != null) {
                            tbPageContext2 = this.cqW.mPageContext;
                            tbPageContext2.showToast(this.cqW.mContext.getResources().getString(com.baidu.tieba.t.too_many_face));
                            return;
                        }
                    }
                    this.cqW.cqO.getEditText().getText().insert(this.cqW.cqO.getEditText().getSelectionStart(), fVar.getName());
                }
                if (this.cqW.anR()) {
                    this.cqW.cqO.anP();
                } else {
                    this.cqW.cqO.anQ();
                }
            }
        } else if (i == 21) {
            if (this.cqW.cqO.getEditText().getSelectionStart() > 0) {
                String substring = this.cqW.cqO.getEditText().getText().toString().substring(0, this.cqW.cqO.getEditText().getSelectionStart());
                pattern = PbEditor.cqR;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.cqW.cqO.getEditText().getText().delete(this.cqW.cqO.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cqW.cqO.getEditText().getSelectionStart());
                    return;
                }
                this.cqW.cqO.getEditText().getText().delete(this.cqW.cqO.getEditText().getSelectionStart() - 1, this.cqW.cqO.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.cqW.cqP.anp();
            if (this.cqW.anR()) {
                this.cqW.cqO.anP();
            } else {
                this.cqW.cqO.anQ();
            }
        } else if (i == 15) {
            this.cqW.cqP.aca();
            if (this.cqW.anR()) {
                this.cqW.cqO.anP();
            } else {
                this.cqW.cqO.anQ();
            }
        } else if (i == 2) {
            this.cqW.iN(i);
            this.cqW.cqO.anf();
        } else if (i == 23) {
            this.cqW.cqO.anf();
            if (this.cqW.cqP.anG()) {
                this.cqW.iN(i);
            } else {
                this.aKS.handleAction(i, obj);
            }
        } else if (i == 22) {
            this.cqW.cqO.anf();
            this.aKS.handleAction(i, obj);
        } else if (i == 13) {
            this.cqW.refresh();
            if (this.cqW.anR()) {
                this.cqW.cqO.anP();
            } else {
                this.cqW.cqO.anQ();
            }
            this.aKS.handleAction(i, obj);
        } else if (i == 0) {
            if (this.cqW.Kn()) {
                com.baidu.adp.lib.util.n.showToast(this.cqW.getContext(), com.baidu.tieba.t.over_limit_tip);
            } else {
                this.aKS.handleAction(i, obj);
            }
        } else if (i == 44) {
            this.cqW.iN(i);
            this.cqW.cqO.anf();
        } else if (i == 46) {
            this.cqW.cqO.aoe();
        } else if (i == 47) {
            if (!this.cqW.cqP.anG()) {
                this.cqW.refresh();
            }
        } else if (i == 48) {
            this.cqW.cqO.anf();
            if (this.cqW.cqP.anH()) {
                this.cqW.iN(i);
                return;
            }
            this.cqW.cqP.zQ();
            this.aKS.handleAction(i, obj);
        } else if (i == 51) {
            if (!this.cqW.cqP.anH()) {
                this.cqW.cqP.anA();
            }
            this.cqW.refresh();
            if (this.cqW.anR()) {
                this.cqW.cqO.anP();
            } else {
                this.cqW.cqO.anQ();
            }
            this.aKS.handleAction(i, obj);
        } else {
            this.aKS.handleAction(i, obj);
        }
    }
}
