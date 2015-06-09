package com.baidu.tieba.mainentrance;

import android.text.Selection;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bCF;
    private String mName;

    public aq(SquareSearchActivity squareSearchActivity, String str) {
        this.bCF = squareSearchActivity;
        this.mName = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        if (!TextUtils.isEmpty(this.mName)) {
            i = this.bCF.mMode;
            if (i != 0) {
                i2 = this.bCF.mMode;
                if (i2 == 3) {
                    this.bCF.fE(this.mName);
                    return;
                }
                this.bCF.z(1, this.mName);
                editText = this.bCF.bBN;
                editText.setText(this.mName);
                editText2 = this.bCF.bBN;
                editText2.requestFocus();
                editText3 = this.bCF.bBN;
                Selection.setSelection(editText3.getText(), this.mName.length());
                return;
            }
            com.baidu.tieba.tbadkCore.util.j.jH(this.mName);
            this.bCF.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bCF.getActivity()).createNormalCfg(this.mName, FrsActivityConfig.FRS_FROM_SEARCH)));
        }
    }
}
