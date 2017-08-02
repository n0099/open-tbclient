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
    public View cPy;
    private List<TextLineView> eMA;
    private int eMB;
    private View.OnClickListener eMC;
    private View.OnClickListener eMD;
    private View.OnClickListener eME;
    public TextLineView eMy;
    public TextLineView eMz;
    public TextView esJ;
    public int mSkinType;

    public ak(View view) {
        super(view);
        this.mSkinType = 3;
        this.eMB = 0;
        this.eMD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.i.hh()) {
                    for (TextLineView textLineView : ak.this.eMA) {
                        if (textLineView != null) {
                            if (textLineView != view2) {
                                textLineView.setSelected(false);
                            } else {
                                textLineView.setSelected(true);
                            }
                        }
                    }
                }
                if (ak.this.eMC != null) {
                    ak.this.eMC.onClick(view2);
                }
            }
        };
        this.eME = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.i.hh()) {
                    ak.this.aSC();
                    view2.setTag(Boolean.valueOf(ak.this.eMB == 0));
                }
                if (ak.this.eMC != null) {
                    ak.this.eMC.onClick(view2);
                }
            }
        };
        if (view != null) {
            this.eMy = (TextLineView) view.findViewById(d.h.reply_title);
            this.eMy.setOnClickListener(this.eMD);
            this.eMz = (TextLineView) view.findViewById(d.h.floor_owner_reply);
            this.eMz.setOnClickListener(this.eMD);
            this.esJ = (TextView) view.findViewById(d.h.pb_sort);
            this.esJ.setOnClickListener(this.eME);
            this.eMy.setSelected(true);
            this.eMz.setSelected(false);
            this.eMA = new ArrayList();
            this.eMA.add(this.eMy);
            this.eMA.add(this.eMz);
            this.cPy = view.findViewById(d.h.divider_with_reply_title);
            jA(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSC() {
        if (!TbadkCoreApplication.isLogin()) {
            this.esJ.setVisibility(8);
            return;
        }
        this.esJ.setVisibility(0);
        if (this.eMB == 1) {
            this.esJ.setText(d.l.pb_sort_new);
            this.esJ.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_sort_new, 0, 0, 0);
            this.eMB = 0;
        } else if (this.eMB == 0) {
            this.esJ.setText(d.l.pb_sort_old);
            this.esJ.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_sort_old, 0, 0, 0);
            this.eMB = 1;
        }
    }

    public void jA(boolean z) {
        this.eMB = z ? 1 : 0;
        aSC();
    }

    public void jB(boolean z) {
        if (z) {
            this.eMz.setSelected(true);
            this.eMy.setSelected(false);
            return;
        }
        this.eMz.setSelected(false);
        this.eMy.setSelected(true);
    }

    public void H(View.OnClickListener onClickListener) {
        this.eMC = onClickListener;
    }
}
