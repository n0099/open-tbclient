package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class bq implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(WriteActivity writeActivity) {
        this.cyx = writeActivity;
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
        editText = this.cyx.cwe;
        if (view != editText) {
            view2 = this.cyx.mBack;
            if (view != view2) {
                textView2 = this.cyx.cwj;
            }
        }
        if (!z) {
            editText2 = this.cyx.cwe;
            if (view == editText2) {
                textView = this.cyx.cwk;
                textView.setVisibility(0);
            }
        } else {
            this.cyx.cyv = true;
            this.cyx.arp();
            tbEditorToolButtonContainer = this.cyx.cyf;
            tbEditorToolButtonContainer.alt();
            editorToolComponetContainer = this.cyx.cmP;
            editText3 = this.cyx.cwe;
            editorToolComponetContainer.aa(editText3);
        }
        editText4 = this.cyx.cwi;
        if (view == editText4) {
            if (!z) {
                writeData = this.cyx.cqk;
                if (writeData.getType() == 0) {
                    editText5 = this.cyx.cwi;
                    editText5.setHint(com.baidu.tieba.y.content);
                    return;
                }
                return;
            }
            this.cyx.cyv = false;
            writeData2 = this.cyx.cqk;
            if (writeData2.getType() == 0) {
                editText7 = this.cyx.cwi;
                editText7.setHint((CharSequence) null);
            }
            this.cyx.arp();
            tbEditorToolButtonContainer2 = this.cyx.cyf;
            tbEditorToolButtonContainer2.alt();
            editorToolComponetContainer2 = this.cyx.cmP;
            editText6 = this.cyx.cwi;
            editorToolComponetContainer2.aa(editText6);
        }
    }
}
