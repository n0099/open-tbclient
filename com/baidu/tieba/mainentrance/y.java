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
public class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity brF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.brF = squareSearchActivity;
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
        i2 = this.brF.mMode;
        if (i2 != 0) {
            i3 = this.brF.mMode;
            if (i3 == 3) {
                this.brF.fR(str);
                return;
            } else if (str != null && str.length() > 0) {
                aVar = this.brF.brg;
                aVar.gD(i);
                aVar2 = this.brF.brg;
                aVar2.notifyDataSetChanged();
                this.brF.y(1, str);
                editText = this.brF.bqY;
                editText.setText(str);
                editText2 = this.brF.bqY;
                editText2.requestFocus();
                editText3 = this.brF.bqY;
                Selection.setSelection(editText3.getText(), str.length());
                return;
            } else {
                return;
            }
        }
        com.baidu.tieba.tbadkCore.util.j.il(str);
        this.brF.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.brF.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_SEARCH)));
    }
}
