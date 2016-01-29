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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private ArrayList<com.baidu.tbadk.core.dialog.h> eqJ;
    private WriteVoteActivity eqM;
    private a eqO;
    private int eqG = 7;
    private boolean eqH = false;
    private com.baidu.tbadk.core.dialog.f eqI = null;
    private com.baidu.tbadk.core.dialog.a eqK = null;
    private EditText eqL = null;
    private final AdapterView.OnItemClickListener buu = new d(this);
    private LayoutInflater eqN = LayoutInflater.from(getActivity());

    /* loaded from: classes.dex */
    public interface a {
        void U(int i, String str);
    }

    public void a(a aVar) {
        this.eqO = aVar;
    }

    public c(WriteVoteActivity writeVoteActivity) {
        this.eqM = writeVoteActivity;
    }

    public void Gp() {
        this.eqI = new com.baidu.tbadk.core.dialog.f(this.eqM.getPageContext());
        this.eqJ = new ArrayList<>();
        this.eqJ.add(new com.baidu.tbadk.core.dialog.h(getString(t.j.one_day), null, this.eqG == 1));
        this.eqJ.add(new com.baidu.tbadk.core.dialog.h(getString(t.j.one_week), null, this.eqG == 7));
        this.eqJ.add(new com.baidu.tbadk.core.dialog.h(getString(t.j.one_month), null, this.eqG == 30));
        this.eqJ.add(new com.baidu.tbadk.core.dialog.h(getString(t.j.custom_time), null, this.eqH));
        this.eqI.ch(t.j.endtime_dialog_title);
        this.eqI.a(this.eqJ, this.buu);
        this.eqI.uo();
        this.eqI.up();
    }

    private String getString(int i) {
        return TbadkCoreApplication.m411getInst().getString(i);
    }

    private Activity getActivity() {
        return this.eqM.getPageContext().getPageActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pO(int i) {
        String string;
        if (this.eqO != null) {
            if (i == 1) {
                string = getString(t.j.one_day);
            } else if (i == 7) {
                string = getString(t.j.one_week);
            } else if (i == 30) {
                string = getString(t.j.one_month);
            } else {
                string = getActivity().getString(t.j.num_day, new Object[]{Integer.valueOf(i)});
            }
            this.eqO.U(i, string);
            com.baidu.adp.lib.util.k.c(this.eqM.getPageContext().getPageActivity(), this.eqL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUa() {
        this.eqK = new com.baidu.tbadk.core.dialog.a(getActivity());
        View inflate = this.eqN.inflate(t.h.select_day_item, (ViewGroup) null);
        this.eqL = (EditText) inflate.findViewById(t.g.select_date_edittext);
        this.eqK.z(inflate);
        this.eqK.b(t.j.alert_no_button, new e(this));
        this.eqK.a(t.j.alert_yes_button, new f(this));
        this.eqK.b(this.eqM.getPageContext());
        this.eqL.setText(new StringBuilder(String.valueOf(this.eqG)).toString());
        Editable text = this.eqL.getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
        this.eqK.uj();
        this.eqM.ShowSoftKeyPadDelay(this.eqL, 150);
    }
}
