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
    private ArrayList<h> hIE;
    private WriteVoteActivity hIG;
    private a hIH;
    private int hIB = 7;
    private boolean hIC = false;
    private com.baidu.tbadk.core.dialog.e hID = null;
    private com.baidu.tbadk.core.dialog.a hwr = null;
    private EditText hIF = null;
    private final AdapterView.OnItemClickListener eRl = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.vote.c.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.this.hID.refresh(i);
            switch (i) {
                case 0:
                    c.this.hIB = 1;
                    c.this.hIC = false;
                    c.this.xC(c.this.hIB);
                    break;
                case 1:
                    c.this.hIB = 7;
                    c.this.hIC = false;
                    c.this.xC(c.this.hIB);
                    break;
                case 2:
                    c.this.hIB = 30;
                    c.this.hIC = false;
                    c.this.xC(c.this.hIB);
                    break;
                case 3:
                    c.this.bHx();
                    break;
            }
            c.this.hID.dismiss();
        }
    };
    private LayoutInflater kh = LayoutInflater.from(getActivity());

    /* loaded from: classes3.dex */
    public interface a {
        void an(int i, String str);
    }

    public void a(a aVar) {
        this.hIH = aVar;
    }

    public c(WriteVoteActivity writeVoteActivity) {
        this.hIG = writeVoteActivity;
    }

    public void showDialog() {
        this.hID = new com.baidu.tbadk.core.dialog.e(this.hIG.getPageContext());
        this.hIE = new ArrayList<>();
        this.hIE.add(new h(getString(d.j.day_one), null, this.hIB == 1));
        this.hIE.add(new h(getString(d.j.one_week), null, this.hIB == 7));
        this.hIE.add(new h(getString(d.j.one_month), null, this.hIB == 30));
        this.hIE.add(new h(getString(d.j.custom_time), null, this.hIC));
        this.hID.fk(d.j.endtime_dialog_title);
        this.hID.a(this.hIE, this.eRl);
        this.hID.AY();
        this.hID.AZ();
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    private Activity getActivity() {
        return this.hIG.getPageContext().getPageActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xC(int i) {
        if (this.hIH != null) {
            this.hIH.an(i, xD(i));
            l.a(this.hIG.getPageContext().getPageActivity(), this.hIF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHx() {
        this.hwr = new com.baidu.tbadk.core.dialog.a(getActivity());
        View inflate = this.kh.inflate(d.h.select_day_item, (ViewGroup) null);
        this.hIF = (EditText) inflate.findViewById(d.g.select_date_edittext);
        this.hwr.aO(inflate);
        this.hwr.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.vote.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                l.a(c.this.hIG.getPageContext().getPageActivity(), c.this.hIF);
                aVar.dismiss();
            }
        });
        this.hwr.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.vote.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                String trim = c.this.hIF.getText().toString().trim();
                int h = !TextUtils.isEmpty(trim) ? com.baidu.adp.lib.g.b.h(trim, 7) : 0;
                if (h > 0 && h <= 99) {
                    c.this.hIB = h;
                    if (h == 1 || h == 7 || h == 30) {
                        c.this.hIC = false;
                    } else {
                        c.this.hIC = true;
                    }
                    c.this.xC(c.this.hIB);
                    aVar.dismiss();
                } else if (h == 0) {
                    c.this.hIG.showToast(d.j.endtime_input_error);
                }
            }
        });
        this.hwr.b(this.hIG.getPageContext());
        this.hIF.setText(this.hIB + "");
        Editable text = this.hIF.getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
        this.hwr.AU();
        this.hIG.ShowSoftKeyPadDelay(this.hIF, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
    }

    public static String xD(int i) {
        if (i == 1) {
            return TbadkCoreApplication.getInst().getString(d.j.day_one);
        }
        if (i == 7) {
            return TbadkCoreApplication.getInst().getString(d.j.one_week);
        }
        return i == 30 ? TbadkCoreApplication.getInst().getString(d.j.one_month) : TbadkCoreApplication.getInst().getResources().getString(d.j.num_day, Integer.valueOf(i));
    }
}
