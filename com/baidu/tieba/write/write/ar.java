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
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText bpW;
        InputMethodManager inputMethodManager2;
        EditText bpV;
        com.baidu.tbadk.editortools.j jVar;
        WriteData writeData;
        boolean z;
        WriteData writeData2;
        EditText bpW2;
        EditText bpV2;
        com.baidu.tieba.write.transmit.model.a aVar;
        com.baidu.tieba.write.transmit.model.a aVar2;
        com.baidu.tieba.write.transmit.model.a aVar3;
        com.baidu.tbadk.core.view.a aVar4;
        com.baidu.tbadk.core.view.a aVar5;
        EditText bpV3;
        EditText bpV4;
        EditText bpW3;
        EditText bpW4;
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
            this.gaR.showToast(w.l.neterror);
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            WriteActivity writeActivity = this.gaR;
            inputMethodManager = this.gaR.mInputManager;
            bpW = this.gaR.bpW();
            writeActivity.HidenSoftKeyPad(inputMethodManager, bpW);
            WriteActivity writeActivity2 = this.gaR;
            inputMethodManager2 = this.gaR.mInputManager;
            bpV = this.gaR.bpV();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bpV);
            jVar = this.gaR.ayP;
            jVar.AG();
            writeData = this.gaR.mData;
            if (writeData.getType() != 7) {
                z = this.gaR.fZz;
                if (!z) {
                    com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c12102");
                    writeData2 = this.gaR.mData;
                    asVar.r("obj_type", StringUtils.isNull(writeData2.getForumName()) ? 1 : 2);
                    TiebaStatic.log(asVar);
                    String str = "";
                    String str2 = "";
                    bpW2 = this.gaR.bpW();
                    if (bpW2 != null) {
                        bpW3 = this.gaR.bpW();
                        if (bpW3.getText() != null) {
                            bpW4 = this.gaR.bpW();
                            str = bpW4.getText().toString();
                            postPrefixData = this.gaR.mPrefixData;
                            if (postPrefixData != null) {
                                postPrefixData5 = this.gaR.mPrefixData;
                                if (postPrefixData5.getPrefixs() != null) {
                                    postPrefixData6 = this.gaR.mPrefixData;
                                    if (postPrefixData6.getPrefixs().size() > 0) {
                                        i = this.gaR.frX;
                                        if (i != 0) {
                                            textView = this.gaR.fsu;
                                            if (textView.getText() != null) {
                                                textView2 = this.gaR.fsu;
                                                str = String.valueOf(textView2.getText().toString()) + str;
                                            }
                                        }
                                    }
                                }
                            }
                            postPrefixData2 = this.gaR.mPrefixData;
                            if (postPrefixData2 != null) {
                                postPrefixData3 = this.gaR.mPrefixData;
                                if (!StringUtils.isNull(postPrefixData3.getImplicitTitle())) {
                                    postPrefixData4 = this.gaR.mPrefixData;
                                    str = String.valueOf(postPrefixData4.getImplicitTitle()) + str;
                                }
                            }
                        }
                    }
                    bpV2 = this.gaR.bpV();
                    if (bpV2 != null) {
                        bpV3 = this.gaR.bpV();
                        if (bpV3.getText() != null) {
                            bpV4 = this.gaR.bpV();
                            str2 = bpV4.getText().toString();
                        }
                    }
                    aVar = this.gaR.fXo;
                    aVar.setThreadTitle(str);
                    aVar2 = this.gaR.fXo;
                    aVar2.setThreadContent(str2);
                    aVar3 = this.gaR.fXo;
                    aVar3.NJ();
                    aVar4 = this.gaR.gap;
                    aVar4.c(null);
                    aVar5 = this.gaR.gap;
                    aVar5.aH(true);
                    return;
                }
                this.gaR.bpc();
                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                return;
            }
            TiebaStatic.log("c12015");
            this.gaR.bpc();
        }
    }
}
