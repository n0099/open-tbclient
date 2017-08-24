package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ak extends j.a {
    public View cSQ;
    public TextLineView ePH;
    public TextLineView ePI;
    private List<TextLineView> ePJ;
    private int ePK;
    private View.OnClickListener ePL;
    private View.OnClickListener ePM;
    private View.OnClickListener ePN;
    public TextView evX;
    public int mSkinType;

    public ak(View view) {
        super(view);
        this.mSkinType = 3;
        this.ePK = 0;
        this.ePM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.i.hr()) {
                    for (TextLineView textLineView : ak.this.ePJ) {
                        if (textLineView != null) {
                            if (textLineView != view2) {
                                textLineView.setSelected(false);
                            } else {
                                textLineView.setSelected(true);
                            }
                        }
                    }
                }
                if (ak.this.ePL != null) {
                    ak.this.ePL.onClick(view2);
                }
            }
        };
        this.ePN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.i.hr()) {
                    ak.this.aTp();
                    view2.setTag(Boolean.valueOf(ak.this.ePK == 0));
                }
                if (ak.this.ePL != null) {
                    ak.this.ePL.onClick(view2);
                }
            }
        };
        if (view != null) {
            this.ePH = (TextLineView) view.findViewById(d.h.reply_title);
            this.ePH.setOnClickListener(this.ePM);
            this.ePI = (TextLineView) view.findViewById(d.h.floor_owner_reply);
            this.ePI.setOnClickListener(this.ePM);
            this.evX = (TextView) view.findViewById(d.h.pb_sort);
            this.evX.setOnClickListener(this.ePN);
            this.ePH.setSelected(true);
            this.ePI.setSelected(false);
            this.ePJ = new ArrayList();
            this.ePJ.add(this.ePH);
            this.ePJ.add(this.ePI);
            this.cSQ = view.findViewById(d.h.divider_with_reply_title);
            jD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTp() {
        if (!TbadkCoreApplication.isLogin()) {
            this.evX.setVisibility(8);
            return;
        }
        this.evX.setVisibility(0);
        if (this.ePK == 1) {
            this.evX.setText(d.l.pb_sort_new);
            this.evX.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_sort_new, 0, 0, 0);
            this.ePK = 0;
        } else if (this.ePK == 0) {
            this.evX.setText(d.l.pb_sort_old);
            this.evX.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_sort_old, 0, 0, 0);
            this.ePK = 1;
        }
    }

    public void jD(boolean z) {
        this.ePK = z ? 1 : 0;
        aTp();
    }

    public void jE(boolean z) {
        if (z) {
            this.ePI.setSelected(true);
            this.ePH.setSelected(false);
            return;
        }
        this.ePI.setSelected(false);
        this.ePH.setSelected(true);
    }

    public void D(View.OnClickListener onClickListener) {
        this.ePL = onClickListener;
    }
}
