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
    private WriteVoteActivity dnC;
    private a dnE;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dnz;
    private int dnw = 7;
    private boolean dnx = false;
    private com.baidu.tbadk.core.dialog.e dny = null;
    private com.baidu.tbadk.core.dialog.a dnA = null;
    private EditText dnB = null;
    private final AdapterView.OnItemClickListener bgg = new d(this);
    private LayoutInflater dnD = LayoutInflater.from(getActivity());

    /* loaded from: classes.dex */
    public interface a {
        void O(int i, String str);
    }

    public void a(a aVar) {
        this.dnE = aVar;
    }

    public c(WriteVoteActivity writeVoteActivity) {
        this.dnC = writeVoteActivity;
    }

    public void showDialog() {
        this.dny = new com.baidu.tbadk.core.dialog.e(this.dnC.getPageContext());
        this.dnz = new ArrayList<>();
        this.dnz.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.one_day), null, this.dnw == 1));
        this.dnz.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.one_week), null, this.dnw == 7));
        this.dnz.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.one_month), null, this.dnw == 30));
        this.dnz.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.custom_time), null, this.dnx));
        this.dny.bN(i.h.endtime_dialog_title);
        this.dny.a(this.dnz, this.bgg);
        this.dny.sV();
        this.dny.sW();
    }

    private String getString(int i) {
        return TbadkCoreApplication.m411getInst().getString(i);
    }

    private Activity getActivity() {
        return this.dnC.getPageContext().getPageActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(int i) {
        String string;
        if (this.dnE != null) {
            if (i == 1) {
                string = getString(i.h.one_day);
            } else if (i == 7) {
                string = getString(i.h.one_week);
            } else if (i == 30) {
                string = getString(i.h.one_month);
            } else {
                string = getActivity().getString(i.h.num_day, new Object[]{Integer.valueOf(i)});
            }
            this.dnE.O(i, string);
            com.baidu.adp.lib.util.k.c(this.dnC.getPageContext().getPageActivity(), this.dnB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCz() {
        this.dnA = new com.baidu.tbadk.core.dialog.a(getActivity());
        View inflate = this.dnD.inflate(i.g.select_day_item, (ViewGroup) null);
        this.dnB = (EditText) inflate.findViewById(i.f.select_date_edittext);
        this.dnA.m(inflate);
        this.dnA.b(i.h.alert_no_button, new e(this));
        this.dnA.a(i.h.alert_yes_button, new f(this));
        this.dnA.b(this.dnC.getPageContext());
        this.dnB.setText(new StringBuilder(String.valueOf(this.dnw)).toString());
        Editable text = this.dnB.getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
        this.dnA.sR();
        this.dnC.ShowSoftKeyPadDelay(this.dnB, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }
}
