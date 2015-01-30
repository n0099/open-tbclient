package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
/* loaded from: classes.dex */
class bl implements View.OnFocusChangeListener {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(WriteActivity writeActivity) {
        this.cgS = writeActivity;
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
        editText = this.cgS.bPG;
        if (view != editText) {
            view2 = this.cgS.mBack;
            if (view != view2) {
                textView2 = this.cgS.bPL;
            }
        }
        if (!z) {
            editText2 = this.cgS.bPG;
            if (view == editText2) {
                textView = this.cgS.bPM;
                textView.setVisibility(0);
            }
        } else {
            this.cgS.cgP = true;
            this.cgS.akv();
            tbEditorToolButtonContainer = this.cgS.cgA;
            tbEditorToolButtonContainer.afw();
            editorToolComponetContainer = this.cgS.bWk;
            editText3 = this.cgS.bPG;
            editorToolComponetContainer.X(editText3);
        }
        editText4 = this.cgS.bPK;
        if (view == editText4) {
            if (!z) {
                writeData = this.cgS.bPp;
                if (writeData.getType() == 0) {
                    editText5 = this.cgS.bPK;
                    editText5.setHint(com.baidu.tieba.z.write_activity_content);
                    return;
                }
                return;
            }
            this.cgS.cgP = false;
            writeData2 = this.cgS.bPp;
            if (writeData2.getType() == 0) {
                editText7 = this.cgS.bPK;
                editText7.setHint((CharSequence) null);
            }
            this.cgS.akv();
            tbEditorToolButtonContainer2 = this.cgS.cgA;
            tbEditorToolButtonContainer2.afw();
            editorToolComponetContainer2 = this.cgS.bWk;
            editText6 = this.cgS.bPK;
            editorToolComponetContainer2.X(editText6);
        }
    }
}
