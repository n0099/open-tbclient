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
    private ArrayList<h> hJc;
    private WriteVoteActivity hJe;
    private a hJf;
    private int hIZ = 7;
    private boolean hJa = false;
    private com.baidu.tbadk.core.dialog.e hJb = null;
    private com.baidu.tbadk.core.dialog.a hwP = null;
    private EditText hJd = null;
    private final AdapterView.OnItemClickListener eRA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.vote.c.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c.this.hJb.refresh(i);
            switch (i) {
                case 0:
                    c.this.hIZ = 1;
                    c.this.hJa = false;
                    c.this.xC(c.this.hIZ);
                    break;
                case 1:
                    c.this.hIZ = 7;
                    c.this.hJa = false;
                    c.this.xC(c.this.hIZ);
                    break;
                case 2:
                    c.this.hIZ = 30;
                    c.this.hJa = false;
                    c.this.xC(c.this.hIZ);
                    break;
                case 3:
                    c.this.bHC();
                    break;
            }
            c.this.hJb.dismiss();
        }
    };
    private LayoutInflater kh = LayoutInflater.from(getActivity());

    /* loaded from: classes3.dex */
    public interface a {
        void an(int i, String str);
    }

    public void a(a aVar) {
        this.hJf = aVar;
    }

    public c(WriteVoteActivity writeVoteActivity) {
        this.hJe = writeVoteActivity;
    }

    public void showDialog() {
        this.hJb = new com.baidu.tbadk.core.dialog.e(this.hJe.getPageContext());
        this.hJc = new ArrayList<>();
        this.hJc.add(new h(getString(d.j.day_one), null, this.hIZ == 1));
        this.hJc.add(new h(getString(d.j.one_week), null, this.hIZ == 7));
        this.hJc.add(new h(getString(d.j.one_month), null, this.hIZ == 30));
        this.hJc.add(new h(getString(d.j.custom_time), null, this.hJa));
        this.hJb.fk(d.j.endtime_dialog_title);
        this.hJb.a(this.hJc, this.eRA);
        this.hJb.AZ();
        this.hJb.Ba();
    }

    private String getString(int i) {
        return TbadkCoreApplication.getInst().getString(i);
    }

    private Activity getActivity() {
        return this.hJe.getPageContext().getPageActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xC(int i) {
        if (this.hJf != null) {
            this.hJf.an(i, xD(i));
            l.a(this.hJe.getPageContext().getPageActivity(), this.hJd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHC() {
        this.hwP = new com.baidu.tbadk.core.dialog.a(getActivity());
        View inflate = this.kh.inflate(d.h.select_day_item, (ViewGroup) null);
        this.hJd = (EditText) inflate.findViewById(d.g.select_date_edittext);
        this.hwP.aO(inflate);
        this.hwP.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.vote.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                l.a(c.this.hJe.getPageContext().getPageActivity(), c.this.hJd);
                aVar.dismiss();
            }
        });
        this.hwP.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.write.vote.c.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                String trim = c.this.hJd.getText().toString().trim();
                int h = !TextUtils.isEmpty(trim) ? com.baidu.adp.lib.g.b.h(trim, 7) : 0;
                if (h > 0 && h <= 99) {
                    c.this.hIZ = h;
                    if (h == 1 || h == 7 || h == 30) {
                        c.this.hJa = false;
                    } else {
                        c.this.hJa = true;
                    }
                    c.this.xC(c.this.hIZ);
                    aVar.dismiss();
                } else if (h == 0) {
                    c.this.hJe.showToast(d.j.endtime_input_error);
                }
            }
        });
        this.hwP.b(this.hJe.getPageContext());
        this.hJd.setText(this.hIZ + "");
        Editable text = this.hJd.getText();
        if (text != null) {
            Selection.setSelection(text, text.length());
        }
        this.hwP.AV();
        this.hJe.ShowSoftKeyPadDelay(this.hJd, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
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
