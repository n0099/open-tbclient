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
public class af implements AdapterView.OnItemClickListener {
    final /* synthetic */ SquareSearchActivity bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SquareSearchActivity squareSearchActivity) {
        this.bzT = squareSearchActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        int i3;
        l lVar;
        l lVar2;
        EditText editText;
        EditText editText2;
        EditText editText3;
        boolean z;
        ListView listView = (ListView) adapterView;
        i2 = this.bzT.mMode;
        if (i2 != 0) {
            i3 = this.bzT.mMode;
            if (i3 == 3) {
                this.bzT.fj((String) listView.getAdapter().getItem(i));
                return;
            }
            String str = (String) listView.getAdapter().getItem(i);
            if (str != null && str.length() > 0) {
                lVar = this.bzT.bzj;
                lVar.gO(i);
                lVar2 = this.bzT.bzj;
                lVar2.notifyDataSetChanged();
                this.bzT.y(1, str);
                editText = this.bzT.bze;
                editText.setText(str);
                editText2 = this.bzT.bze;
                editText2.requestFocus();
                editText3 = this.bzT.bze;
                Selection.setSelection(editText3.getText(), str.length());
                return;
            }
            return;
        }
        z = this.bzT.bzG;
        if (!z || i != 0) {
            String str2 = (String) listView.getAdapter().getItem(i);
            com.baidu.tieba.tbadkCore.util.j.iN(str2);
            this.bzT.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.bzT.getPageContext().getPageActivity()).createNormalCfg(str2, FrsActivityConfig.FRS_FROM_SEARCH)));
        }
    }
}
