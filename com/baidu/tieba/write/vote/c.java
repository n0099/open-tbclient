package com.baidu.tieba.write.vote;

import android.app.Activity;
import android.text.Editable;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private ArrayList<com.baidu.tbadk.core.dialog.g> dmZ;
    private WriteVoteActivity dnc;
    private a dne;
    private int dmW = 7;
    private boolean dmX = false;
    private com.baidu.tbadk.core.dialog.e dmY = null;
    private com.baidu.tbadk.core.dialog.a dna = null;
    private EditText dnb = null;
    private final AdapterView.OnItemClickListener bfV = new d(this);
    private LayoutInflater dnd = LayoutInflater.from(getActivity());

    /* loaded from: classes.dex */
    public interface a {
        void O(int i, String str);
    }

    public void a(a aVar) {
        this.dne = aVar;
    }

    public c(WriteVoteActivity writeVoteActivity) {
        this.dnc = writeVoteActivity;
    }

    public void showDialog() {
        this.dmY = new com.baidu.tbadk.core.dialog.e(this.dnc.getPageContext());
        this.dmZ = new ArrayList<>();
        this.dmZ.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.one_day), null, this.dmW == 1));
        this.dmZ.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.one_week), null, this.dmW == 7));
        this.dmZ.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.one_month), null, this.dmW == 30));
        this.dmZ.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.custom_time), null, this.dmX));
        this.dmY.bN(i.h.endtime_dialog_title);
        this.dmY.a(this.dmZ, this.bfV);
        this.dmY.sV();
        this.dmY.sW();
    }

    private String getString(int i) {
        return TbadkCoreApplication.m411getInst().getString(i);
    }

    private Activity getActivity() {
        return this.dnc.getPageContext().getPageActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lZ(int i) {
        String string;
        if (this.dne != null) {
            if (i == 1) {
                string = getString(i.h.one_day);
            } else if (i == 7) {
                string = getString(i.h.one_week);
            } else if (i == 30) {
                string = getString(i.h.one_month);
            } else {
                string = getActivity().getString(i.h.num_day, new Object[]{Integer.valueOf(i)});
            }
            this.dne.O(i, string);
            com.baidu.adp.lib.util.k.c(this.dnc.getPageContext().getPageActivity(), this.dnb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCp() {
        this.dna = new com.baidu.tbadk.core.dialog.a(getActivity());
        View inflate = this.dnd.inflate(i.g.select_day_item, (ViewGroup) null);
        this.dnb = (EditText) inflate.findViewById(i.f.select_date_edittext);
        this.dna.m(inflate);
        this.dna.b(i.h.alert_no_button, new e(this));
        this.dna.a(i.h.alert_yes_button, new f(this));
        this.dna.b(this.dnc.getPageContext());
        this.dnb.setText(new StringBuilder(String.valueOf(this.dmW)).toString());
        Editable text = this.dnb.getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
        this.dna.sR();
        this.dnc.ShowSoftKeyPadDelay(this.dnb, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }
}
