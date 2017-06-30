package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.view.TextLineView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class fw extends z.a {
    public View dSM;
    public TextLineView eBq;
    public TextLineView eBr;
    private List<TextLineView> eBs;
    private int eBt;
    private View.OnClickListener eBu;
    private View.OnClickListener eBv;
    private View.OnClickListener eBw;
    public TextView ehz;
    public int mSkinType;

    public fw(View view) {
        super(view);
        this.mSkinType = 3;
        this.eBt = 0;
        this.eBv = new fx(this);
        this.eBw = new fy(this);
        if (view != null) {
            this.eBq = (TextLineView) view.findViewById(w.h.reply_title);
            this.eBq.setOnClickListener(this.eBv);
            this.eBr = (TextLineView) view.findViewById(w.h.floor_owner_reply);
            this.eBr.setOnClickListener(this.eBv);
            this.ehz = (TextView) view.findViewById(w.h.pb_sort);
            this.ehz.setOnClickListener(this.eBw);
            this.eBq.setSelected(true);
            this.eBr.setSelected(false);
            this.eBs = new ArrayList();
            this.eBs.add(this.eBq);
            this.eBs.add(this.eBr);
            this.dSM = view.findViewById(w.h.divider_with_reply_title);
            jg(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPZ() {
        if (!TbadkCoreApplication.isLogin()) {
            this.ehz.setVisibility(8);
            return;
        }
        this.ehz.setVisibility(0);
        if (this.eBt == 1) {
            this.ehz.setText(w.l.pb_sort_new);
            this.ehz.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_sort_new, 0, 0, 0);
            this.eBt = 0;
        } else if (this.eBt == 0) {
            this.ehz.setText(w.l.pb_sort_old);
            this.ehz.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_sort_old, 0, 0, 0);
            this.eBt = 1;
        }
    }

    public void jg(boolean z) {
        this.eBt = z ? 1 : 0;
        aPZ();
    }

    public void jh(boolean z) {
        if (z) {
            this.eBr.setSelected(true);
            this.eBq.setSelected(false);
            return;
        }
        this.eBr.setSelected(false);
        this.eBq.setSelected(true);
    }

    public void J(View.OnClickListener onClickListener) {
        this.eBu = onClickListener;
    }
}
