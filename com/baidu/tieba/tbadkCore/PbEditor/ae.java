package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.TbPageContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.editortool.w {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCI;
    final /* synthetic */ PbEditor bWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.bWq = pbEditor;
        this.aCI = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        Pattern pattern;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.f)) {
                if (this.bWq.FJ()) {
                    com.baidu.adp.lib.util.l.showToast(this.bWq.getContext(), com.baidu.tieba.z.over_limit_tip);
                    return;
                }
                com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) obj;
                if (fVar.getName() != null) {
                    if (PbEditor.ik(this.bWq.bWj.getEditText().getText().toString()) >= 10) {
                        tbPageContext = this.bWq.mPageContext;
                        if (tbPageContext != null) {
                            tbPageContext2 = this.bWq.mPageContext;
                            tbPageContext2.showToast(this.bWq.mContext.getResources().getString(com.baidu.tieba.z.too_many_face));
                            return;
                        }
                    }
                    this.bWq.bWj.getEditText().getText().insert(this.bWq.bWj.getEditText().getSelectionStart(), fVar.getName());
                }
                if (this.bWq.agh()) {
                    this.bWq.bWj.agf();
                } else {
                    this.bWq.bWj.agg();
                }
            }
        } else if (i == 21) {
            if (this.bWq.bWj.getEditText().getSelectionStart() > 0) {
                String substring = this.bWq.bWj.getEditText().getText().toString().substring(0, this.bWq.bWj.getEditText().getSelectionStart());
                pattern = PbEditor.bWm;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.bWq.bWj.getEditText().getText().delete(this.bWq.bWj.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.bWq.bWj.getEditText().getSelectionStart());
                    return;
                }
                this.bWq.bWj.getEditText().getText().delete(this.bWq.bWj.getEditText().getSelectionStart() - 1, this.bWq.bWj.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.bWq.bWj.agr();
            if (this.bWq.agh()) {
                this.bWq.bWj.agf();
            } else {
                this.bWq.bWj.agg();
            }
        } else if (i == 15) {
            this.bWq.bWj.ags();
            if (this.bWq.agh()) {
                this.bWq.bWj.agf();
            } else {
                this.bWq.bWj.agg();
            }
        } else if (i == 2) {
            this.bWq.hQ(i);
            this.bWq.bWj.afw();
        } else if (i == 23) {
            this.bWq.bWj.afw();
            if (this.bWq.bWk.afW()) {
                this.bWq.hQ(i);
            } else {
                this.aCI.handleAction(i, obj);
            }
        } else if (i == 22) {
            this.bWq.bWj.afw();
            this.aCI.handleAction(i, obj);
        } else if (i == 13) {
            this.bWq.refresh();
            if (this.bWq.agh()) {
                this.bWq.bWj.agf();
            } else {
                this.bWq.bWj.agg();
            }
            this.aCI.handleAction(i, obj);
        } else if (i == 0) {
            if (this.bWq.FJ()) {
                com.baidu.adp.lib.util.l.showToast(this.bWq.getContext(), com.baidu.tieba.z.over_limit_tip);
            } else {
                this.aCI.handleAction(i, obj);
            }
        } else if (i == 44) {
            this.bWq.hQ(i);
            this.bWq.bWj.afw();
        } else if (i == 46) {
            this.bWq.bWj.agt();
        } else if (i == 47) {
            this.bWq.refresh();
        } else if (i == 48) {
            this.bWq.bWj.afw();
            if (this.bWq.bWk.afX()) {
                this.bWq.hQ(i);
                return;
            }
            this.bWq.bWk.vE();
            this.aCI.handleAction(i, obj);
        } else if (i == 51) {
            if (!this.bWq.bWk.afX()) {
                this.bWq.bWk.afQ();
            }
            this.bWq.refresh();
            if (this.bWq.agh()) {
                this.bWq.bWj.agf();
            } else {
                this.bWq.bWj.agg();
            }
            this.aCI.handleAction(i, obj);
        } else {
            this.aCI.handleAction(i, obj);
        }
    }
}
