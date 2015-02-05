package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.TbPageContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.editortool.w {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aCF;
    final /* synthetic */ PbEditor bWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.bWp = pbEditor;
        this.aCF = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        Pattern pattern;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.f)) {
                if (this.bWp.FD()) {
                    com.baidu.adp.lib.util.l.showToast(this.bWp.getContext(), com.baidu.tieba.z.over_limit_tip);
                    return;
                }
                com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) obj;
                if (fVar.getName() != null) {
                    if (PbEditor.ii(this.bWp.bWi.getEditText().getText().toString()) >= 10) {
                        tbPageContext = this.bWp.mPageContext;
                        if (tbPageContext != null) {
                            tbPageContext2 = this.bWp.mPageContext;
                            tbPageContext2.showToast(this.bWp.mContext.getResources().getString(com.baidu.tieba.z.too_many_face));
                            return;
                        }
                    }
                    this.bWp.bWi.getEditText().getText().insert(this.bWp.bWi.getEditText().getSelectionStart(), fVar.getName());
                }
                if (this.bWp.agc()) {
                    this.bWp.bWi.aga();
                } else {
                    this.bWp.bWi.agb();
                }
            }
        } else if (i == 21) {
            if (this.bWp.bWi.getEditText().getSelectionStart() > 0) {
                String substring = this.bWp.bWi.getEditText().getText().toString().substring(0, this.bWp.bWi.getEditText().getSelectionStart());
                pattern = PbEditor.bWl;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.bWp.bWi.getEditText().getText().delete(this.bWp.bWi.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.bWp.bWi.getEditText().getSelectionStart());
                    return;
                }
                this.bWp.bWi.getEditText().getText().delete(this.bWp.bWi.getEditText().getSelectionStart() - 1, this.bWp.bWi.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.bWp.bWi.agm();
            if (this.bWp.agc()) {
                this.bWp.bWi.aga();
            } else {
                this.bWp.bWi.agb();
            }
        } else if (i == 15) {
            this.bWp.bWi.agn();
            if (this.bWp.agc()) {
                this.bWp.bWi.aga();
            } else {
                this.bWp.bWi.agb();
            }
        } else if (i == 2) {
            this.bWp.hQ(i);
            this.bWp.bWi.afr();
        } else if (i == 23) {
            this.bWp.bWi.afr();
            if (this.bWp.bWj.afR()) {
                this.bWp.hQ(i);
            } else {
                this.aCF.handleAction(i, obj);
            }
        } else if (i == 22) {
            this.bWp.bWi.afr();
            this.aCF.handleAction(i, obj);
        } else if (i == 13) {
            this.bWp.refresh();
            if (this.bWp.agc()) {
                this.bWp.bWi.aga();
            } else {
                this.bWp.bWi.agb();
            }
            this.aCF.handleAction(i, obj);
        } else if (i == 0) {
            if (this.bWp.FD()) {
                com.baidu.adp.lib.util.l.showToast(this.bWp.getContext(), com.baidu.tieba.z.over_limit_tip);
            } else {
                this.aCF.handleAction(i, obj);
            }
        } else if (i == 44) {
            this.bWp.hQ(i);
            this.bWp.bWi.afr();
        } else if (i == 46) {
            this.bWp.bWi.ago();
        } else if (i == 47) {
            this.bWp.refresh();
        } else if (i == 48) {
            this.bWp.bWi.afr();
            if (this.bWp.bWj.afS()) {
                this.bWp.hQ(i);
                return;
            }
            this.bWp.bWj.vy();
            this.aCF.handleAction(i, obj);
        } else if (i == 51) {
            if (!this.bWp.bWj.afS()) {
                this.bWp.bWj.afL();
            }
            this.bWp.refresh();
            if (this.bWp.agc()) {
                this.bWp.bWi.aga();
            } else {
                this.bWp.bWi.agb();
            }
            this.aCF.handleAction(i, obj);
        } else {
            this.aCF.handleAction(i, obj);
        }
    }
}
