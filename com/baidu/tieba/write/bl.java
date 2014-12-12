package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class bl implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r4 == r0) goto L22;
     */
    @Override // android.view.View.OnFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFocusChange(View view, boolean z) {
        EditText editText;
        EditText editText2;
        TextView textView;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        EditText editText3;
        EditText editText4;
        WriteData writeData;
        EditText editText5;
        WriteData writeData2;
        TbEditorToolButtonContainer tbEditorToolButtonContainer2;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditText editText6;
        EditText editText7;
        View view2;
        TextView textView2;
        editText = this.cft.bNW;
        if (view != editText) {
            view2 = this.cft.mBack;
            if (view != view2) {
                textView2 = this.cft.bOb;
            }
        }
        if (!z) {
            editText2 = this.cft.bNW;
            if (view == editText2) {
                textView = this.cft.bOc;
                textView.setVisibility(0);
            }
        } else {
            this.cft.cfr = true;
            this.cft.ajY();
            tbEditorToolButtonContainer = this.cft.cfb;
            tbEditorToolButtonContainer.aeS();
            editorToolComponetContainer = this.cft.bUs;
            editText3 = this.cft.bNW;
            editorToolComponetContainer.V(editText3);
        }
        editText4 = this.cft.bOa;
        if (view == editText4) {
            if (!z) {
                writeData = this.cft.bNF;
                if (writeData.getType() == 0) {
                    editText5 = this.cft.bOa;
                    editText5.setHint(com.baidu.tieba.z.content);
                    return;
                }
                return;
            }
            this.cft.cfr = false;
            writeData2 = this.cft.bNF;
            if (writeData2.getType() == 0) {
                editText7 = this.cft.bOa;
                editText7.setHint((CharSequence) null);
            }
            this.cft.ajY();
            tbEditorToolButtonContainer2 = this.cft.cfb;
            tbEditorToolButtonContainer2.aeS();
            editorToolComponetContainer2 = this.cft.bUs;
            editText6 = this.cft.bOa;
            editorToolComponetContainer2.V(editText6);
        }
    }
}
