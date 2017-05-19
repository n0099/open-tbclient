package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText box;
        InputMethodManager inputMethodManager2;
        EditText bow;
        com.baidu.tbadk.editortools.j jVar;
        WriteData writeData;
        boolean z;
        WriteData writeData2;
        EditText box2;
        EditText bow2;
        com.baidu.tieba.write.transmit.model.a aVar;
        com.baidu.tieba.write.transmit.model.a aVar2;
        com.baidu.tieba.write.transmit.model.a aVar3;
        com.baidu.tbadk.core.view.a aVar4;
        com.baidu.tbadk.core.view.a aVar5;
        EditText bow3;
        EditText bow4;
        EditText box3;
        EditText box4;
        PostPrefixData postPrefixData;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        PostPrefixData postPrefixData5;
        PostPrefixData postPrefixData6;
        int i;
        TextView textView;
        TextView textView2;
        if (!com.baidu.adp.lib.util.i.hk()) {
            this.fSV.showToast(w.l.neterror);
        }
        if (!com.baidu.tieba.write.d.a.isFastDoubleClick()) {
            WriteActivity writeActivity = this.fSV;
            inputMethodManager = this.fSV.mInputManager;
            box = this.fSV.box();
            writeActivity.HidenSoftKeyPad(inputMethodManager, box);
            WriteActivity writeActivity2 = this.fSV;
            inputMethodManager2 = this.fSV.mInputManager;
            bow = this.fSV.bow();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bow);
            jVar = this.fSV.azd;
            jVar.AN();
            writeData = this.fSV.mData;
            if (writeData.getType() != 7) {
                z = this.fSV.fRD;
                if (!z) {
                    com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c12102");
                    writeData2 = this.fSV.mData;
                    asVar.s("obj_type", StringUtils.isNull(writeData2.getForumName()) ? 1 : 2);
                    TiebaStatic.log(asVar);
                    String str = "";
                    String str2 = "";
                    box2 = this.fSV.box();
                    if (box2 != null) {
                        box3 = this.fSV.box();
                        if (box3.getText() != null) {
                            box4 = this.fSV.box();
                            str = box4.getText().toString();
                            postPrefixData = this.fSV.mPrefixData;
                            if (postPrefixData != null) {
                                postPrefixData5 = this.fSV.mPrefixData;
                                if (postPrefixData5.getPrefixs() != null) {
                                    postPrefixData6 = this.fSV.mPrefixData;
                                    if (postPrefixData6.getPrefixs().size() > 0) {
                                        i = this.fSV.fkf;
                                        if (i != 0) {
                                            textView = this.fSV.fkC;
                                            if (textView.getText() != null) {
                                                textView2 = this.fSV.fkC;
                                                str = String.valueOf(textView2.getText().toString()) + str;
                                            }
                                        }
                                    }
                                }
                            }
                            postPrefixData2 = this.fSV.mPrefixData;
                            if (postPrefixData2 != null) {
                                postPrefixData3 = this.fSV.mPrefixData;
                                if (!StringUtils.isNull(postPrefixData3.getImplicitTitle())) {
                                    postPrefixData4 = this.fSV.mPrefixData;
                                    str = String.valueOf(postPrefixData4.getImplicitTitle()) + str;
                                }
                            }
                        }
                    }
                    bow2 = this.fSV.bow();
                    if (bow2 != null) {
                        bow3 = this.fSV.bow();
                        if (bow3.getText() != null) {
                            bow4 = this.fSV.bow();
                            str2 = bow4.getText().toString();
                        }
                    }
                    aVar = this.fSV.fPs;
                    aVar.setThreadTitle(str);
                    aVar2 = this.fSV.fPs;
                    aVar2.setThreadContent(str2);
                    aVar3 = this.fSV.fPs;
                    aVar3.NA();
                    aVar4 = this.fSV.fSt;
                    aVar4.c(null);
                    aVar5 = this.fSV.fSt;
                    aVar5.aI(true);
                    return;
                }
                this.fSV.bnD();
                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                return;
            }
            TiebaStatic.log("c12015");
            this.fSV.bnD();
        }
    }
}
