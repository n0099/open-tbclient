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
    final /* synthetic */ SquareSearchActivity bta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.bta = squareSearchActivity;
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
        i2 = this.bta.mMode;
        if (i2 != 0) {
            i3 = this.bta.mMode;
            if (i3 == 3) {
                this.bta.fT(str);
                return;
            } else if (str != null && str.length() > 0) {
                aVar = this.bta.bsD;
                aVar.gM(i);
                aVar2 = this.bta.bsD;
                aVar2.notifyDataSetChanged();
                this.bta.y(1, str);
                editText = this.bta.bsv;
                editText.setText(str);
                editText2 = this.bta.bsv;
                editText2.requestFocus();
                editText3 = this.bta.bsv;
                Selection.setSelection(editText3.getText(), str.length());
                return;
            } else {
                return;
            }
        }
        com.baidu.tieba.tbadkCore.util.j.iq(str);
        this.bta.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bta.getPageContext().getPageActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_SEARCH)));
    }
}
