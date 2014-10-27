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
    final /* synthetic */ SquareSearchActivity bmO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(SquareSearchActivity squareSearchActivity) {
        this.bmO = squareSearchActivity;
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
        i2 = this.bmO.mMode;
        if (i2 != 0) {
            i3 = this.bmO.mMode;
            if (i3 == 3) {
                this.bmO.fz(str);
                return;
            } else if (str != null && str.length() > 0) {
                aVar = this.bmO.bmp;
                aVar.gs(i);
                aVar2 = this.bmO.bmp;
                aVar2.notifyDataSetChanged();
                this.bmO.o(1, str);
                editText = this.bmO.bmh;
                editText.setText(str);
                editText2 = this.bmO.bmh;
                editText2.requestFocus();
                editText3 = this.bmO.bmh;
                Selection.setSelection(editText3.getText(), str.length());
                return;
            } else {
                return;
            }
        }
        com.baidu.tieba.util.j.hz(str);
        this.bmO.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bmO).createNormalCfg(str, FrsActivityConfig.FRS_FROM_SEARCH)));
    }
}
