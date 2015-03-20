package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class bq implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(WriteActivity writeActivity) {
        this.cyc = writeActivity;
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
        editText = this.cyc.cvO;
        if (view != editText) {
            view2 = this.cyc.mBack;
            if (view != view2) {
                textView2 = this.cyc.cvT;
            }
        }
        if (!z) {
            editText2 = this.cyc.cvO;
            if (view == editText2) {
                textView = this.cyc.cvU;
                textView.setVisibility(0);
            }
        } else {
            this.cyc.cya = true;
            this.cyc.ara();
            tbEditorToolButtonContainer = this.cyc.cxK;
            tbEditorToolButtonContainer.ale();
            editorToolComponetContainer = this.cyc.cmz;
            editText3 = this.cyc.cvO;
            editorToolComponetContainer.aa(editText3);
        }
        editText4 = this.cyc.cvS;
        if (view == editText4) {
            if (!z) {
                writeData = this.cyc.cpU;
                if (writeData.getType() == 0) {
                    editText5 = this.cyc.cvS;
                    editText5.setHint(com.baidu.tieba.y.content);
                    return;
                }
                return;
            }
            this.cyc.cya = false;
            writeData2 = this.cyc.cpU;
            if (writeData2.getType() == 0) {
                editText7 = this.cyc.cvS;
                editText7.setHint((CharSequence) null);
            }
            this.cyc.ara();
            tbEditorToolButtonContainer2 = this.cyc.cxK;
            tbEditorToolButtonContainer2.ale();
            editorToolComponetContainer2 = this.cyc.cmz;
            editText6 = this.cyc.cvS;
            editorToolComponetContainer2.aa(editText6);
        }
    }
}
