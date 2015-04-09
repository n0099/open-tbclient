package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.TbPageContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIJ;
    final /* synthetic */ PbEditor cmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbEditor pbEditor, com.baidu.tbadk.editortool.v vVar) {
        this.cmW = pbEditor;
        this.aIJ = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        Pattern pattern;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.f)) {
                if (this.cmW.Ji()) {
                    com.baidu.adp.lib.util.n.showToast(this.cmW.getContext(), com.baidu.tieba.y.over_limit_tip);
                    return;
                }
                com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) obj;
                if (fVar.getName() != null) {
                    if (PbEditor.iG(this.cmW.cmO.getEditText().getText().toString()) >= 10) {
                        tbPageContext = this.cmW.mPageContext;
                        if (tbPageContext != null) {
                            tbPageContext2 = this.cmW.mPageContext;
                            tbPageContext2.showToast(this.cmW.mContext.getResources().getString(com.baidu.tieba.y.too_many_face));
                            return;
                        }
                    }
                    this.cmW.cmO.getEditText().getText().insert(this.cmW.cmO.getEditText().getSelectionStart(), fVar.getName());
                }
                if (this.cmW.ame()) {
                    this.cmW.cmO.amc();
                } else {
                    this.cmW.cmO.amd();
                }
            }
        } else if (i == 21) {
            if (this.cmW.cmO.getEditText().getSelectionStart() > 0) {
                String substring = this.cmW.cmO.getEditText().getText().toString().substring(0, this.cmW.cmO.getEditText().getSelectionStart());
                pattern = PbEditor.cmR;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.cmW.cmO.getEditText().getText().delete(this.cmW.cmO.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cmW.cmO.getEditText().getSelectionStart());
                    return;
                }
                this.cmW.cmO.getEditText().getText().delete(this.cmW.cmO.getEditText().getSelectionStart() - 1, this.cmW.cmO.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.cmW.cmO.amp();
            if (this.cmW.ame()) {
                this.cmW.cmO.amc();
            } else {
                this.cmW.cmO.amd();
            }
        } else if (i == 15) {
            this.cmW.cmO.amq();
            if (this.cmW.ame()) {
                this.cmW.cmO.amc();
            } else {
                this.cmW.cmO.amd();
            }
        } else if (i == 2) {
            this.cmW.ir(i);
            this.cmW.cmO.alt();
        } else if (i == 23) {
            this.cmW.cmO.alt();
            if (this.cmW.cmP.alT()) {
                this.cmW.ir(i);
            } else {
                this.aIJ.handleAction(i, obj);
            }
        } else if (i == 22) {
            this.cmW.cmO.alt();
            this.aIJ.handleAction(i, obj);
        } else if (i == 13) {
            this.cmW.refresh();
            if (this.cmW.ame()) {
                this.cmW.cmO.amc();
            } else {
                this.cmW.cmO.amd();
            }
            this.aIJ.handleAction(i, obj);
        } else if (i == 0) {
            if (this.cmW.Ji()) {
                com.baidu.adp.lib.util.n.showToast(this.cmW.getContext(), com.baidu.tieba.y.over_limit_tip);
            } else {
                this.aIJ.handleAction(i, obj);
            }
        } else if (i == 44) {
            this.cmW.ir(i);
            this.cmW.cmO.alt();
        } else if (i == 46) {
            this.cmW.cmO.amr();
        } else if (i == 47) {
            if (!this.cmW.cmP.alT()) {
                this.cmW.refresh();
            }
        } else if (i == 48) {
            this.cmW.cmO.alt();
            if (this.cmW.cmP.alU()) {
                this.cmW.ir(i);
                return;
            }
            this.cmW.cmP.zc();
            this.aIJ.handleAction(i, obj);
        } else if (i == 51) {
            if (!this.cmW.cmP.alU()) {
                this.cmW.cmP.alN();
            }
            this.cmW.refresh();
            if (this.cmW.ame()) {
                this.cmW.cmO.amc();
            } else {
                this.cmW.cmO.amd();
            }
            this.aIJ.handleAction(i, obj);
        } else {
            this.aIJ.handleAction(i, obj);
        }
    }
}
