package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class fe extends y.a {
    public View dES;
    public TextView dTl;
    public TextLineView ems;
    public TextLineView emt;
    private List<TextLineView> emu;
    private int emv;
    private View.OnClickListener emw;
    private View.OnClickListener emx;
    private View.OnClickListener emy;
    public int mSkinType;

    public fe(View view) {
        super(view);
        this.mSkinType = 3;
        this.emv = 0;
        this.emx = new ff(this);
        this.emy = new fg(this);
        if (view != null) {
            this.ems = (TextLineView) view.findViewById(w.h.reply_title);
            this.ems.setOnClickListener(this.emx);
            this.emt = (TextLineView) view.findViewById(w.h.floor_owner_reply);
            this.emt.setOnClickListener(this.emx);
            this.dTl = (TextView) view.findViewById(w.h.pb_sort);
            this.dTl.setOnClickListener(this.emy);
            this.ems.setSelected(true);
            this.emt.setSelected(false);
            this.emu = new ArrayList();
            this.emu.add(this.ems);
            this.emu.add(this.emt);
            this.dES = view.findViewById(w.h.divider_with_reply_title);
            iu(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLf() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dTl.setVisibility(8);
            return;
        }
        this.dTl.setVisibility(0);
        if (this.emv == 1) {
            this.dTl.setText(w.l.pb_sort_new);
            this.dTl.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_sort_new, 0, 0, 0);
            this.emv = 0;
        } else if (this.emv == 0) {
            this.dTl.setText(w.l.pb_sort_old);
            this.dTl.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_sort_old, 0, 0, 0);
            this.emv = 1;
        }
    }

    public void iu(boolean z) {
        this.emv = z ? 1 : 0;
        aLf();
    }

    public void iv(boolean z) {
        if (z) {
            this.emt.setSelected(true);
            this.ems.setSelected(false);
            return;
        }
        this.emt.setSelected(false);
        this.ems.setSelected(true);
    }

    public void I(View.OnClickListener onClickListener) {
        this.emw = onClickListener;
    }
}
