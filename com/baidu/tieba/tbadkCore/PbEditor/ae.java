package com.baidu.tieba.tbadkCore.PbEditor;

import com.baidu.tbadk.TbPageContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.editortool.w {
    private final /* synthetic */ com.baidu.tbadk.editortool.w aBH;
    final /* synthetic */ PbEditor bUy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.bUy = pbEditor;
        this.aBH = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        Pattern pattern;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.f)) {
                if (this.bUy.Fl()) {
                    com.baidu.adp.lib.util.l.showToast(this.bUy.getContext(), com.baidu.tieba.z.over_limit_tip);
                    return;
                }
                com.baidu.tbadk.coreExtra.data.f fVar = (com.baidu.tbadk.coreExtra.data.f) obj;
                if (fVar.getName() != null) {
                    if (PbEditor.ic(this.bUy.bUr.getEditText().getText().toString()) >= 10) {
                        tbPageContext = this.bUy.mPageContext;
                        if (tbPageContext != null) {
                            tbPageContext2 = this.bUy.mPageContext;
                            tbPageContext2.showToast(this.bUy.mContext.getResources().getString(com.baidu.tieba.z.too_many_face));
                            return;
                        }
                    }
                    this.bUy.bUr.getEditText().getText().insert(this.bUy.bUr.getEditText().getSelectionStart(), fVar.getName());
                }
                if (this.bUy.afD()) {
                    this.bUy.bUr.afB();
                } else {
                    this.bUy.bUr.afC();
                }
            }
        } else if (i == 21) {
            if (this.bUy.bUr.getEditText().getSelectionStart() > 0) {
                String substring = this.bUy.bUr.getEditText().getText().toString().substring(0, this.bUy.bUr.getEditText().getSelectionStart());
                pattern = PbEditor.bUu;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.bUy.bUr.getEditText().getText().delete(this.bUy.bUr.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.bUy.bUr.getEditText().getSelectionStart());
                    return;
                }
                this.bUy.bUr.getEditText().getText().delete(this.bUy.bUr.getEditText().getSelectionStart() - 1, this.bUy.bUr.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.bUy.bUr.afN();
            if (this.bUy.afD()) {
                this.bUy.bUr.afB();
            } else {
                this.bUy.bUr.afC();
            }
        } else if (i == 15) {
            this.bUy.bUr.afO();
            if (this.bUy.afD()) {
                this.bUy.bUr.afB();
            } else {
                this.bUy.bUr.afC();
            }
        } else if (i == 2) {
            this.bUy.hH(i);
            this.bUy.bUr.aeS();
        } else if (i == 23) {
            this.bUy.bUr.aeS();
            if (this.bUy.bUs.afs()) {
                this.bUy.hH(i);
            } else {
                this.aBH.handleAction(i, obj);
            }
        } else if (i == 22) {
            this.bUy.bUr.aeS();
            this.aBH.handleAction(i, obj);
        } else if (i == 13) {
            this.bUy.refresh();
            if (this.bUy.afD()) {
                this.bUy.bUr.afB();
            } else {
                this.bUy.bUr.afC();
            }
            this.aBH.handleAction(i, obj);
        } else if (i == 0) {
            if (this.bUy.Fl()) {
                com.baidu.adp.lib.util.l.showToast(this.bUy.getContext(), com.baidu.tieba.z.over_limit_tip);
            } else {
                this.aBH.handleAction(i, obj);
            }
        } else if (i == 44) {
            this.bUy.hH(i);
            this.bUy.bUr.aeS();
        } else if (i == 46) {
            this.bUy.bUr.afP();
        } else if (i == 47) {
            if (!this.bUy.bUs.afs()) {
                this.bUy.bUr.afQ();
            }
        } else if (i == 48) {
            this.bUy.bUr.aeS();
            if (this.bUy.bUs.aft()) {
                this.bUy.hH(i);
                return;
            }
            this.bUy.bUs.vn();
            this.aBH.handleAction(i, obj);
        } else if (i == 51) {
            if (!this.bUy.bUs.aft()) {
                this.bUy.bUs.afm();
            }
            this.bUy.refresh();
            if (this.bUy.afD()) {
                this.bUy.bUr.afB();
            } else {
                this.bUy.bUr.afC();
            }
            this.aBH.handleAction(i, obj);
        } else {
            this.aBH.handleAction(i, obj);
        }
    }
}
