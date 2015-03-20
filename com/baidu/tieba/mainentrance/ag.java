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
public class ag implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        int i3;
        m mVar;
        m mVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        boolean z;
        ListView listView = (ListView) adapterView;
        i2 = this.bzG.mMode;
        if (i2 != 0) {
            i3 = this.bzG.mMode;
            if (i3 == 3) {
                this.bzG.fg((String) listView.getAdapter().getItem(i));
                return;
            }
            String str = (String) listView.getAdapter().getItem(i);
            if (str != null && str.length() > 0) {
                mVar = this.bzG.byX;
                mVar.gM(i);
                mVar2 = this.bzG.byX;
                mVar2.notifyDataSetChanged();
                this.bzG.y(1, str);
                editText = this.bzG.byS;
                editText.setText(str);
                editText2 = this.bzG.byS;
                editText2.requestFocus();
                editText3 = this.bzG.byS;
                Selection.setSelection(editText3.getText(), str.length());
                return;
            }
            return;
        }
        z = this.bzG.bzt;
        if (!z || i != 0) {
            String str2 = (String) listView.getAdapter().getItem(i);
            com.baidu.tieba.tbadkCore.util.j.iK(str2);
            this.bzG.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bzG.getPageContext().getPageActivity()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_SEARCH)));
        }
    }
}
