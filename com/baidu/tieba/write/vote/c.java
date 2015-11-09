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
    private ArrayList<com.baidu.tbadk.core.dialog.g> dpo;
    private WriteVoteActivity dpr;
    private a dpt;
    private int dpl = 7;
    private boolean dpm = false;
    private com.baidu.tbadk.core.dialog.e dpn = null;
    private com.baidu.tbadk.core.dialog.a dpp = null;
    private EditText dpq = null;
    private final AdapterView.OnItemClickListener bgM = new d(this);
    private LayoutInflater dps = LayoutInflater.from(getActivity());

    /* loaded from: classes.dex */
    public interface a {
        void P(int i, String str);
    }

    public void a(a aVar) {
        this.dpt = aVar;
    }

    public c(WriteVoteActivity writeVoteActivity) {
        this.dpr = writeVoteActivity;
    }

    public void showDialog() {
        this.dpn = new com.baidu.tbadk.core.dialog.e(this.dpr.getPageContext());
        this.dpo = new ArrayList<>();
        this.dpo.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.one_day), null, this.dpl == 1));
        this.dpo.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.one_week), null, this.dpl == 7));
        this.dpo.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.one_month), null, this.dpl == 30));
        this.dpo.add(new com.baidu.tbadk.core.dialog.g(getString(i.h.custom_time), null, this.dpm));
        this.dpn.bN(i.h.endtime_dialog_title);
        this.dpn.a(this.dpo, this.bgM);
        this.dpn.sV();
        this.dpn.sW();
    }

    private String getString(int i) {
        return TbadkCoreApplication.m411getInst().getString(i);
    }

    private Activity getActivity() {
        return this.dpr.getPageContext().getPageActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp(int i) {
        String string;
        if (this.dpt != null) {
            if (i == 1) {
                string = getString(i.h.one_day);
            } else if (i == 7) {
                string = getString(i.h.one_week);
            } else if (i == 30) {
                string = getString(i.h.one_month);
            } else {
                string = getActivity().getString(i.h.num_day, new Object[]{Integer.valueOf(i)});
            }
            this.dpt.P(i, string);
            com.baidu.adp.lib.util.k.c(this.dpr.getPageContext().getPageActivity(), this.dpq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDn() {
        this.dpp = new com.baidu.tbadk.core.dialog.a(getActivity());
        View inflate = this.dps.inflate(i.g.select_day_item, (ViewGroup) null);
        this.dpq = (EditText) inflate.findViewById(i.f.select_date_edittext);
        this.dpp.m(inflate);
        this.dpp.b(i.h.alert_no_button, new e(this));
        this.dpp.a(i.h.alert_yes_button, new f(this));
        this.dpp.b(this.dpr.getPageContext());
        this.dpq.setText(new StringBuilder(String.valueOf(this.dpl)).toString());
        Editable text = this.dpq.getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
        this.dpp.sR();
        this.dpr.ShowSoftKeyPadDelay(this.dpq, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }
}
