package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.TbPageContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.editortool.v {
    private final /* synthetic */ com.baidu.tbadk.editortool.v aIB;
    final /* synthetic */ PbEditor cmG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbEditor pbEditor, com.baidu.tbadk.editortool.v vVar) {
        this.cmG = pbEditor;
        this.aIB = vVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        Pattern pattern;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.f)) {
                if (this.cmG.Jc()) {
                    com.baidu.adp.lib.util.n.showToast(this.cmG.getContext(), com.baidu.tieba.y.over_limit_tip);
                    return;
                }
                com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) obj;
                if (fVar.getName() != null) {
                    if (PbEditor.iD(this.cmG.cmy.getEditText().getText().toString()) >= 10) {
                        tbPageContext = this.cmG.mPageContext;
                        if (tbPageContext != null) {
                            tbPageContext2 = this.cmG.mPageContext;
                            tbPageContext2.showToast(this.cmG.mContext.getResources().getString(com.baidu.tieba.y.too_many_face));
                            return;
                        }
                    }
                    this.cmG.cmy.getEditText().getText().insert(this.cmG.cmy.getEditText().getSelectionStart(), fVar.getName());
                }
                if (this.cmG.alP()) {
                    this.cmG.cmy.alN();
                } else {
                    this.cmG.cmy.alO();
                }
            }
        } else if (i == 21) {
            if (this.cmG.cmy.getEditText().getSelectionStart() > 0) {
                String substring = this.cmG.cmy.getEditText().getText().toString().substring(0, this.cmG.cmy.getEditText().getSelectionStart());
                pattern = PbEditor.cmB;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.cmG.cmy.getEditText().getText().delete(this.cmG.cmy.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cmG.cmy.getEditText().getSelectionStart());
                    return;
                }
                this.cmG.cmy.getEditText().getText().delete(this.cmG.cmy.getEditText().getSelectionStart() - 1, this.cmG.cmy.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.cmG.cmy.ama();
            if (this.cmG.alP()) {
                this.cmG.cmy.alN();
            } else {
                this.cmG.cmy.alO();
            }
        } else if (i == 15) {
            this.cmG.cmy.amb();
            if (this.cmG.alP()) {
                this.cmG.cmy.alN();
            } else {
                this.cmG.cmy.alO();
            }
        } else if (i == 2) {
            this.cmG.io(i);
            this.cmG.cmy.ale();
        } else if (i == 23) {
            this.cmG.cmy.ale();
            if (this.cmG.cmz.alE()) {
                this.cmG.io(i);
            } else {
                this.aIB.handleAction(i, obj);
            }
        } else if (i == 22) {
            this.cmG.cmy.ale();
            this.aIB.handleAction(i, obj);
        } else if (i == 13) {
            this.cmG.refresh();
            if (this.cmG.alP()) {
                this.cmG.cmy.alN();
            } else {
                this.cmG.cmy.alO();
            }
            this.aIB.handleAction(i, obj);
        } else if (i == 0) {
            if (this.cmG.Jc()) {
                com.baidu.adp.lib.util.n.showToast(this.cmG.getContext(), com.baidu.tieba.y.over_limit_tip);
            } else {
                this.aIB.handleAction(i, obj);
            }
        } else if (i == 44) {
            this.cmG.io(i);
            this.cmG.cmy.ale();
        } else if (i == 46) {
            this.cmG.cmy.amc();
        } else if (i == 47) {
            if (!this.cmG.cmz.alE()) {
                this.cmG.refresh();
            }
        } else if (i == 48) {
            this.cmG.cmy.ale();
            if (this.cmG.cmz.alF()) {
                this.cmG.io(i);
                return;
            }
            this.cmG.cmz.yW();
            this.aIB.handleAction(i, obj);
        } else if (i == 51) {
            if (!this.cmG.cmz.alF()) {
                this.cmG.cmz.aly();
            }
            this.cmG.refresh();
            if (this.cmG.alP()) {
                this.cmG.cmy.alN();
            } else {
                this.cmG.cmy.alO();
            }
            this.aIB.handleAction(i, obj);
        } else {
            this.aIB.handleAction(i, obj);
        }
    }
}
