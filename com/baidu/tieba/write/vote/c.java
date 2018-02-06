package com.baidu.tieba.write.vote;

import android.app.Activity;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private ArrayList<h> hIR;
    private WriteVoteActivity hIT;
    private a hIU;
    private int hIO = 7;
    private boolean hIP = false;
    private com.baidu.tbadk.core.dialog.e hIQ = null;
    private com.baidu.tbadk.core.dialog.a hwE = null;
    private EditText hIS = null;
    private final AdapterView.OnItemClickListener eRx = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.vote.c.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.this.hIQ.refresh(i);
            switch (i) {
                case 0:
                    c.this.hIO = 1;
                    c.this.hIP = false;
                    c.this.xB(c.this.hIO);
                    break;
                case 1:
                    c.this.hIO = 7;
                    c.this.hIP = false;
                    c.this.xB(c.this.hIO);
                    break;
                case 2:
                    c.this.hIO = 30;
                    c.this.hIP = false;
                    c.this.xB(c.this.hIO);
                    break;
                case 3:
                    c.this.bHy();
                    break;
            }
            c.this.hIQ.dismiss();
        }
    };
    private LayoutInflater kh = LayoutInflater.from(getActivity());

    /* loaded from: classes3.dex */
    public interface a {
        void an(int i, String str);
    }

    public void a(a aVar) {
        this.hIU = aVar;
    }

    public c(WriteVoteActivity writeVoteActivity) {
        this.hIT = writeVoteActivity;
    }

    public void showDialog() {
        this.hIQ = new com.baidu.tbadk.core.dialog.e(this.hIT.getPageContext());
        this.hIR = new ArrayList<>();
        this.hIR.add(new h(getString(d.j.day_one), null, this.hIO == 1));
        this.hIR.add(new h(getString(d.j.one_week), null, this.hIO == 7));
        this.hIR.add(new h(getString(d.j.one_month), null, this.hIO == 30));
        this.hIR.add(new h(getString(d.j.custom_time), null, this.hIP));
        this.hIQ.fk(d.j.endtime_dialog_title);
        this.hIQ.a(this.hIR, this.eRx);
        this.hIQ.AY();
        this.hIQ.AZ();
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    private Activity getActivity() {
        return this.hIT.getPageContext().getPageActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB(int i) {
        if (this.hIU != null) {
            this.hIU.an(i, xC(i));
            l.a(this.hIT.getPageContext().getPageActivity(), this.hIS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHy() {
        this.hwE = new com.baidu.tbadk.core.dialog.a(getActivity());
        View inflate = this.kh.inflate(d.h.select_day_item, (ViewGroup) null);
        this.hIS = (EditText) inflate.findViewById(d.g.select_date_edittext);
        this.hwE.aO(inflate);
        this.hwE.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.vote.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                l.a(c.this.hIT.getPageContext().getPageActivity(), c.this.hIS);
                aVar.dismiss();
            }
        });
        this.hwE.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.vote.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                String trim = c.this.hIS.getText().toString().trim();
                int h = !TextUtils.isEmpty(trim) ? com.baidu.adp.lib.g.b.h(trim, 7) : 0;
                if (h > 0 && h <= 99) {
                    c.this.hIO = h;
                    if (h == 1 || h == 7 || h == 30) {
                        c.this.hIP = false;
                    } else {
                        c.this.hIP = true;
                    }
                    c.this.xB(c.this.hIO);
                    aVar.dismiss();
                } else if (h == 0) {
                    c.this.hIT.showToast(d.j.endtime_input_error);
                }
            }
        });
        this.hwE.b(this.hIT.getPageContext());
        this.hIS.setText(this.hIO + "");
        Editable text = this.hIS.getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
        this.hwE.AU();
        this.hIT.ShowSoftKeyPadDelay(this.hIS, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
    }

    public static String xC(int i) {
        if (i == 1) {
            return TbadkCoreApplication.getInst().getString(d.j.day_one);
        }
        if (i == 7) {
            return TbadkCoreApplication.getInst().getString(d.j.one_week);
        }
        return i == 30 ? TbadkCoreApplication.getInst().getString(d.j.one_month) : TbadkCoreApplication.getInst().getResources().getString(d.j.num_day, Integer.valueOf(i));
    }
}
