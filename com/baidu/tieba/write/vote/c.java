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
    private ArrayList<com.baidu.tbadk.core.dialog.g> dVQ;
    private WriteVoteActivity dVT;
    private a dVV;
    private int dVN = 7;
    private boolean dVO = false;
    private com.baidu.tbadk.core.dialog.e dVP = null;
    private com.baidu.tbadk.core.dialog.a dVR = null;
    private EditText dVS = null;
    private final AdapterView.OnItemClickListener bro = new d(this);
    private LayoutInflater dVU = LayoutInflater.from(getActivity());

    /* loaded from: classes.dex */
    public interface a {
        void R(int i, String str);
    }

    public void a(a aVar) {
        this.dVV = aVar;
    }

    public c(WriteVoteActivity writeVoteActivity) {
        this.dVT = writeVoteActivity;
    }

    public void showDialog() {
        this.dVP = new com.baidu.tbadk.core.dialog.e(this.dVT.getPageContext());
        this.dVQ = new ArrayList<>();
        this.dVQ.add(new com.baidu.tbadk.core.dialog.g(getString(n.j.one_day), null, this.dVN == 1));
        this.dVQ.add(new com.baidu.tbadk.core.dialog.g(getString(n.j.one_week), null, this.dVN == 7));
        this.dVQ.add(new com.baidu.tbadk.core.dialog.g(getString(n.j.one_month), null, this.dVN == 30));
        this.dVQ.add(new com.baidu.tbadk.core.dialog.g(getString(n.j.custom_time), null, this.dVO));
        this.dVP.bO(n.j.endtime_dialog_title);
        this.dVP.a(this.dVQ, this.bro);
        this.dVP.tk();
        this.dVP.tl();
    }

    private String getString(int i) {
        return TbadkCoreApplication.m411getInst().getString(i);
    }

    private Activity getActivity() {
        return this.dVT.getPageContext().getPageActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot(int i) {
        String string;
        if (this.dVV != null) {
            if (i == 1) {
                string = getString(n.j.one_day);
            } else if (i == 7) {
                string = getString(n.j.one_week);
            } else if (i == 30) {
                string = getString(n.j.one_month);
            } else {
                string = getActivity().getString(n.j.num_day, new Object[]{Integer.valueOf(i)});
            }
            this.dVV.R(i, string);
            com.baidu.adp.lib.util.k.c(this.dVT.getPageContext().getPageActivity(), this.dVS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLf() {
        this.dVR = new com.baidu.tbadk.core.dialog.a(getActivity());
        View inflate = this.dVU.inflate(n.h.select_day_item, (ViewGroup) null);
        this.dVS = (EditText) inflate.findViewById(n.g.select_date_edittext);
        this.dVR.m(inflate);
        this.dVR.b(n.j.alert_no_button, new e(this));
        this.dVR.a(n.j.alert_yes_button, new f(this));
        this.dVR.b(this.dVT.getPageContext());
        this.dVS.setText(new StringBuilder(String.valueOf(this.dVN)).toString());
        Editable text = this.dVS.getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
        this.dVR.tf();
        this.dVT.ShowSoftKeyPadDelay(this.dVS, 150);
    }
}
