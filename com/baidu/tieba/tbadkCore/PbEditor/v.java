package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.TbPageContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aKR;
    final /* synthetic */ PbEditor cqV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbEditor pbEditor, com.baidu.tbadk.editortool.v vVar) {
        this.cqV = pbEditor;
        this.aKR = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        Pattern pattern;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.f)) {
                if (this.cqV.Km()) {
                    com.baidu.adp.lib.util.n.showToast(this.cqV.getContext(), com.baidu.tieba.t.over_limit_tip);
                    return;
                }
                com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) obj;
                if (fVar.getName() != null) {
                    if (PbEditor.jz(this.cqV.cqN.getEditText().getText().toString()) >= 10) {
                        tbPageContext = this.cqV.mPageContext;
                        if (tbPageContext != null) {
                            tbPageContext2 = this.cqV.mPageContext;
                            tbPageContext2.showToast(this.cqV.mContext.getResources().getString(com.baidu.tieba.t.too_many_face));
                            return;
                        }
                    }
                    this.cqV.cqN.getEditText().getText().insert(this.cqV.cqN.getEditText().getSelectionStart(), fVar.getName());
                }
                if (this.cqV.anQ()) {
                    this.cqV.cqN.anO();
                } else {
                    this.cqV.cqN.anP();
                }
            }
        } else if (i == 21) {
            if (this.cqV.cqN.getEditText().getSelectionStart() > 0) {
                String substring = this.cqV.cqN.getEditText().getText().toString().substring(0, this.cqV.cqN.getEditText().getSelectionStart());
                pattern = PbEditor.cqQ;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.cqV.cqN.getEditText().getText().delete(this.cqV.cqN.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cqV.cqN.getEditText().getSelectionStart());
                    return;
                }
                this.cqV.cqN.getEditText().getText().delete(this.cqV.cqN.getEditText().getSelectionStart() - 1, this.cqV.cqN.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.cqV.cqO.ano();
            if (this.cqV.anQ()) {
                this.cqV.cqN.anO();
            } else {
                this.cqV.cqN.anP();
            }
        } else if (i == 15) {
            this.cqV.cqO.abZ();
            if (this.cqV.anQ()) {
                this.cqV.cqN.anO();
            } else {
                this.cqV.cqN.anP();
            }
        } else if (i == 2) {
            this.cqV.iN(i);
            this.cqV.cqN.ane();
        } else if (i == 23) {
            this.cqV.cqN.ane();
            if (this.cqV.cqO.anF()) {
                this.cqV.iN(i);
            } else {
                this.aKR.handleAction(i, obj);
            }
        } else if (i == 22) {
            this.cqV.cqN.ane();
            this.aKR.handleAction(i, obj);
        } else if (i == 13) {
            this.cqV.refresh();
            if (this.cqV.anQ()) {
                this.cqV.cqN.anO();
            } else {
                this.cqV.cqN.anP();
            }
            this.aKR.handleAction(i, obj);
        } else if (i == 0) {
            if (this.cqV.Km()) {
                com.baidu.adp.lib.util.n.showToast(this.cqV.getContext(), com.baidu.tieba.t.over_limit_tip);
            } else {
                this.aKR.handleAction(i, obj);
            }
        } else if (i == 44) {
            this.cqV.iN(i);
            this.cqV.cqN.ane();
        } else if (i == 46) {
            this.cqV.cqN.aod();
        } else if (i == 47) {
            if (!this.cqV.cqO.anF()) {
                this.cqV.refresh();
            }
        } else if (i == 48) {
            this.cqV.cqN.ane();
            if (this.cqV.cqO.anG()) {
                this.cqV.iN(i);
                return;
            }
            this.cqV.cqO.zP();
            this.aKR.handleAction(i, obj);
        } else if (i == 51) {
            if (!this.cqV.cqO.anG()) {
                this.cqV.cqO.anz();
            }
            this.cqV.refresh();
            if (this.cqV.anQ()) {
                this.cqV.cqN.anO();
            } else {
                this.cqV.cqN.anP();
            }
            this.aKR.handleAction(i, obj);
        } else {
            this.aKR.handleAction(i, obj);
        }
    }
}
