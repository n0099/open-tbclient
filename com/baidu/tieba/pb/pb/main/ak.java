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
    public View cQR;
    public TextLineView eNL;
    public TextLineView eNM;
    private List<TextLineView> eNN;
    private int eNO;
    private View.OnClickListener eNP;
    private View.OnClickListener eNQ;
    private View.OnClickListener eNR;
    public TextView eub;
    public int mSkinType;

    public ak(View view) {
        super(view);
        this.mSkinType = 3;
        this.eNO = 0;
        this.eNQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.i.hr()) {
                    for (TextLineView textLineView : ak.this.eNN) {
                        if (textLineView != null) {
                            if (textLineView != view2) {
                                textLineView.setSelected(false);
                            } else {
                                textLineView.setSelected(true);
                            }
                        }
                    }
                }
                if (ak.this.eNP != null) {
                    ak.this.eNP.onClick(view2);
                }
            }
        };
        this.eNR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.adp.lib.util.i.hr()) {
                    ak.this.aSN();
                    view2.setTag(Boolean.valueOf(ak.this.eNO == 0));
                }
                if (ak.this.eNP != null) {
                    ak.this.eNP.onClick(view2);
                }
            }
        };
        if (view != null) {
            this.eNL = (TextLineView) view.findViewById(d.h.reply_title);
            this.eNL.setOnClickListener(this.eNQ);
            this.eNM = (TextLineView) view.findViewById(d.h.floor_owner_reply);
            this.eNM.setOnClickListener(this.eNQ);
            this.eub = (TextView) view.findViewById(d.h.pb_sort);
            this.eub.setOnClickListener(this.eNR);
            this.eNL.setSelected(true);
            this.eNM.setSelected(false);
            this.eNN = new ArrayList();
            this.eNN.add(this.eNL);
            this.eNN.add(this.eNM);
            this.cQR = view.findViewById(d.h.divider_with_reply_title);
            jA(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSN() {
        if (!TbadkCoreApplication.isLogin()) {
            this.eub.setVisibility(8);
            return;
        }
        this.eub.setVisibility(0);
        if (this.eNO == 1) {
            this.eub.setText(d.l.pb_sort_new);
            this.eub.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_sort_new, 0, 0, 0);
            this.eNO = 0;
        } else if (this.eNO == 0) {
            this.eub.setText(d.l.pb_sort_old);
            this.eub.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_sort_old, 0, 0, 0);
            this.eNO = 1;
        }
    }

    public void jA(boolean z) {
        this.eNO = z ? 1 : 0;
        aSN();
    }

    public void jB(boolean z) {
        if (z) {
            this.eNM.setSelected(true);
            this.eNL.setSelected(false);
            return;
        }
        this.eNM.setSelected(false);
        this.eNL.setSelected(true);
    }

    public void H(View.OnClickListener onClickListener) {
        this.eNP = onClickListener;
    }
}
