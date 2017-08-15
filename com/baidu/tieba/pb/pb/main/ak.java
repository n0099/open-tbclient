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
    public TextLineView ePF;
    public TextLineView ePG;
    private List<TextLineView> ePH;
    private int ePI;
    private View.OnClickListener ePJ;
    private View.OnClickListener ePK;
    private View.OnClickListener ePL;
    public TextView evV;
    public int mSkinType;

    public ak(View view) {
        super(view);
        this.mSkinType = 3;
        this.ePI = 0;
        this.ePK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.i.hr()) {
                    for (TextLineView textLineView : ak.this.ePH) {
                        if (textLineView != null) {
                            if (textLineView != view2) {
                                textLineView.setSelected(false);
                            } else {
                                textLineView.setSelected(true);
                            }
                        }
                    }
                }
                if (ak.this.ePJ != null) {
                    ak.this.ePJ.onClick(view2);
                }
            }
        };
        this.ePL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.i.hr()) {
                    ak.this.aTu();
                    view2.setTag(Boolean.valueOf(ak.this.ePI == 0));
                }
                if (ak.this.ePJ != null) {
                    ak.this.ePJ.onClick(view2);
                }
            }
        };
        if (view != null) {
            this.ePF = (TextLineView) view.findViewById(d.h.reply_title);
            this.ePF.setOnClickListener(this.ePK);
            this.ePG = (TextLineView) view.findViewById(d.h.floor_owner_reply);
            this.ePG.setOnClickListener(this.ePK);
            this.evV = (TextView) view.findViewById(d.h.pb_sort);
            this.evV.setOnClickListener(this.ePL);
            this.ePF.setSelected(true);
            this.ePG.setSelected(false);
            this.ePH = new ArrayList();
            this.ePH.add(this.ePF);
            this.ePH.add(this.ePG);
            this.cSQ = view.findViewById(d.h.divider_with_reply_title);
            jD(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTu() {
        if (!TbadkCoreApplication.isLogin()) {
            this.evV.setVisibility(8);
            return;
        }
        this.evV.setVisibility(0);
        if (this.ePI == 1) {
            this.evV.setText(d.l.pb_sort_new);
            this.evV.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_sort_new, 0, 0, 0);
            this.ePI = 0;
        } else if (this.ePI == 0) {
            this.evV.setText(d.l.pb_sort_old);
            this.evV.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_sort_old, 0, 0, 0);
            this.ePI = 1;
        }
    }

    public void jD(boolean z) {
        this.ePI = z ? 1 : 0;
        aTu();
    }

    public void jE(boolean z) {
        if (z) {
            this.ePG.setSelected(true);
            this.ePF.setSelected(false);
            return;
        }
        this.ePG.setSelected(false);
        this.ePF.setSelected(true);
    }

    public void H(View.OnClickListener onClickListener) {
        this.ePJ = onClickListener;
    }
}
