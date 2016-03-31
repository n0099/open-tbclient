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
    private ArrayList<com.baidu.tbadk.core.dialog.h> eKE;
    private WriteVoteActivity eKG;
    private a eKI;
    private int eKB = 7;
    private boolean eKC = false;
    private com.baidu.tbadk.core.dialog.f eKD = null;
    private com.baidu.tbadk.core.dialog.a bNg = null;
    private EditText eKF = null;
    private final AdapterView.OnItemClickListener bzC = new d(this);
    private LayoutInflater eKH = LayoutInflater.from(getActivity());

    /* loaded from: classes.dex */
    public interface a {
        void Q(int i, String str);
    }

    public void a(a aVar) {
        this.eKI = aVar;
    }

    public c(WriteVoteActivity writeVoteActivity) {
        this.eKG = writeVoteActivity;
    }

    public void Hl() {
        this.eKD = new com.baidu.tbadk.core.dialog.f(this.eKG.getPageContext());
        this.eKE = new ArrayList<>();
        this.eKE.add(new com.baidu.tbadk.core.dialog.h(getString(t.j.one_day), null, this.eKB == 1));
        this.eKE.add(new com.baidu.tbadk.core.dialog.h(getString(t.j.one_week), null, this.eKB == 7));
        this.eKE.add(new com.baidu.tbadk.core.dialog.h(getString(t.j.one_month), null, this.eKB == 30));
        this.eKE.add(new com.baidu.tbadk.core.dialog.h(getString(t.j.custom_time), null, this.eKC));
        this.eKD.cj(t.j.endtime_dialog_title);
        this.eKD.a(this.eKE, this.bzC);
        this.eKD.ut();
        this.eKD.uu();
    }

    private String getString(int i) {
        return TbadkCoreApplication.m411getInst().getString(i);
    }

    private Activity getActivity() {
        return this.eKG.getPageContext().getPageActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qH(int i) {
        if (this.eKI != null) {
            this.eKI.Q(i, qI(i));
            com.baidu.adp.lib.util.k.c(this.eKG.getPageContext().getPageActivity(), this.eKF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baA() {
        this.bNg = new com.baidu.tbadk.core.dialog.a(getActivity());
        View inflate = this.eKH.inflate(t.h.select_day_item, (ViewGroup) null);
        this.eKF = (EditText) inflate.findViewById(t.g.select_date_edittext);
        this.bNg.z(inflate);
        this.bNg.b(t.j.alert_no_button, new e(this));
        this.bNg.a(t.j.alert_yes_button, new f(this));
        this.bNg.b(this.eKG.getPageContext());
        this.eKF.setText(new StringBuilder(String.valueOf(this.eKB)).toString());
        Editable text = this.eKF.getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
        this.bNg.up();
        this.eKG.ShowSoftKeyPadDelay(this.eKF, 150);
    }

    public static String qI(int i) {
        if (i == 1) {
            return TbadkCoreApplication.m411getInst().getString(t.j.one_day);
        }
        if (i == 7) {
            return TbadkCoreApplication.m411getInst().getString(t.j.one_week);
        }
        return i == 30 ? TbadkCoreApplication.m411getInst().getString(t.j.one_month) : TbadkCoreApplication.m411getInst().getResources().getString(t.j.num_day, Integer.valueOf(i));
    }
}
