package com.baidu.tieba.mainentrance;

import android.text.Selection;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareSearchActivity squareSearchActivity) {
        this.bnc = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        int i3;
        a aVar;
        a aVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        String str = (String) ((ListView) adapterView).getAdapter().getItem(i);
        i2 = this.bnc.mMode;
        if (i2 != 0) {
            i3 = this.bnc.mMode;
            if (i3 == 3) {
                this.bnc.fz(str);
                return;
            } else if (str != null && str.length() > 0) {
                aVar = this.bnc.bmD;
                aVar.gs(i);
                aVar2 = this.bnc.bmD;
                aVar2.notifyDataSetChanged();
                this.bnc.o(1, str);
                editText = this.bnc.bmv;
                editText.setText(str);
                editText2 = this.bnc.bmv;
                editText2.requestFocus();
                editText3 = this.bnc.bmv;
                Selection.setSelection(editText3.getText(), str.length());
                return;
            } else {
                return;
            }
        }
        com.baidu.tieba.util.j.hz(str);
        this.bnc.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bnc).createNormalCfg(str, FrsActivityConfig.FRS_FROM_SEARCH)));
    }
}
