package com.baidu.tieba.write.vote;

import android.app.Activity;
import android.text.Editable;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private ArrayList<com.baidu.tbadk.core.dialog.g> dOr;
    private WriteVoteActivity dOu;
    private a dOw;
    private int dOo = 7;
    private boolean dOp = false;
    private com.baidu.tbadk.core.dialog.e dOq = null;
    private com.baidu.tbadk.core.dialog.a dOs = null;
    private EditText dOt = null;
    private final AdapterView.OnItemClickListener bny = new d(this);
    private LayoutInflater dOv = LayoutInflater.from(getActivity());

    /* loaded from: classes.dex */
    public interface a {
        void Q(int i, String str);
    }

    public void a(a aVar) {
        this.dOw = aVar;
    }

    public c(WriteVoteActivity writeVoteActivity) {
        this.dOu = writeVoteActivity;
    }

    public void showDialog() {
        this.dOq = new com.baidu.tbadk.core.dialog.e(this.dOu.getPageContext());
        this.dOr = new ArrayList<>();
        this.dOr.add(new com.baidu.tbadk.core.dialog.g(getString(n.i.one_day), null, this.dOo == 1));
        this.dOr.add(new com.baidu.tbadk.core.dialog.g(getString(n.i.one_week), null, this.dOo == 7));
        this.dOr.add(new com.baidu.tbadk.core.dialog.g(getString(n.i.one_month), null, this.dOo == 30));
        this.dOr.add(new com.baidu.tbadk.core.dialog.g(getString(n.i.custom_time), null, this.dOp));
        this.dOq.bV(n.i.endtime_dialog_title);
        this.dOq.a(this.dOr, this.bny);
        this.dOq.tA();
        this.dOq.tB();
    }

    private String getString(int i) {
        return TbadkCoreApplication.m411getInst().getString(i);
    }

    private Activity getActivity() {
        return this.dOu.getPageContext().getPageActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nB(int i) {
        String string;
        if (this.dOw != null) {
            if (i == 1) {
                string = getString(n.i.one_day);
            } else if (i == 7) {
                string = getString(n.i.one_week);
            } else if (i == 30) {
                string = getString(n.i.one_month);
            } else {
                string = getActivity().getString(n.i.num_day, new Object[]{Integer.valueOf(i)});
            }
            this.dOw.Q(i, string);
            com.baidu.adp.lib.util.k.c(this.dOu.getPageContext().getPageActivity(), this.dOt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIK() {
        this.dOs = new com.baidu.tbadk.core.dialog.a(getActivity());
        View inflate = this.dOv.inflate(n.g.select_day_item, (ViewGroup) null);
        this.dOt = (EditText) inflate.findViewById(n.f.select_date_edittext);
        this.dOs.m(inflate);
        this.dOs.b(n.i.alert_no_button, new e(this));
        this.dOs.a(n.i.alert_yes_button, new f(this));
        this.dOs.b(this.dOu.getPageContext());
        this.dOt.setText(new StringBuilder(String.valueOf(this.dOo)).toString());
        Editable text = this.dOt.getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
        this.dOs.tv();
        this.dOu.ShowSoftKeyPadDelay(this.dOt, 150);
    }
}
