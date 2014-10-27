package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class bl implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WriteActivity writeActivity) {
        this.bTX = writeActivity;
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
        editText = this.bTX.bJr;
        if (view != editText) {
            view2 = this.bTX.Js;
            if (view != view2) {
                textView2 = this.bTX.bJw;
            }
        }
        if (!z) {
            editText2 = this.bTX.bJr;
            if (view == editText2) {
                textView = this.bTX.bJx;
                textView.setVisibility(0);
            }
        } else {
            this.bTX.bTV = true;
            this.bTX.afr();
            tbEditorToolButtonContainer = this.bTX.bTF;
            tbEditorToolButtonContainer.Bg();
            editorToolComponetContainer = this.bTX.are;
            editText3 = this.bTX.bJr;
            editorToolComponetContainer.x(editText3);
        }
        editText4 = this.bTX.bJv;
        if (view == editText4) {
            if (!z) {
                writeData = this.bTX.bpv;
                if (writeData.getType() == 0) {
                    editText5 = this.bTX.bJv;
                    editText5.setHint(com.baidu.tieba.y.content);
                    return;
                }
                return;
            }
            this.bTX.bTV = false;
            writeData2 = this.bTX.bpv;
            if (writeData2.getType() == 0) {
                editText7 = this.bTX.bJv;
                editText7.setHint((CharSequence) null);
            }
            this.bTX.afr();
            tbEditorToolButtonContainer2 = this.bTX.bTF;
            tbEditorToolButtonContainer2.Bg();
            editorToolComponetContainer2 = this.bTX.are;
            editText6 = this.bTX.bJv;
            editorToolComponetContainer2.x(editText6);
        }
    }
}
