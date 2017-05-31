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
public class fn extends z.a {
    public View bvl;
    public TextView dYG;
    public TextLineView esf;
    public TextLineView esg;
    private List<TextLineView> esh;
    private int esi;
    private View.OnClickListener esj;
    private View.OnClickListener esk;
    private View.OnClickListener esl;
    public int mSkinType;

    public fn(View view) {
        super(view);
        this.mSkinType = 3;
        this.esi = 0;
        this.esk = new fo(this);
        this.esl = new fp(this);
        if (view != null) {
            this.esf = (TextLineView) view.findViewById(w.h.reply_title);
            this.esf.setOnClickListener(this.esk);
            this.esg = (TextLineView) view.findViewById(w.h.floor_owner_reply);
            this.esg.setOnClickListener(this.esk);
            this.dYG = (TextView) view.findViewById(w.h.pb_sort);
            this.dYG.setOnClickListener(this.esl);
            this.esf.setSelected(true);
            this.esg.setSelected(false);
            this.esh = new ArrayList();
            this.esh.add(this.esf);
            this.esh.add(this.esg);
            this.bvl = view.findViewById(w.h.divider_with_reply_title);
            iK(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMb() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dYG.setVisibility(8);
            return;
        }
        this.dYG.setVisibility(0);
        if (this.esi == 1) {
            this.dYG.setText(w.l.pb_sort_new);
            this.dYG.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_sort_new, 0, 0, 0);
            this.esi = 0;
        } else if (this.esi == 0) {
            this.dYG.setText(w.l.pb_sort_old);
            this.dYG.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_sort_old, 0, 0, 0);
            this.esi = 1;
        }
    }

    public void iK(boolean z) {
        this.esi = z ? 1 : 0;
        aMb();
    }

    public void iL(boolean z) {
        if (z) {
            this.esg.setSelected(true);
            this.esf.setSelected(false);
            return;
        }
        this.esg.setSelected(false);
        this.esf.setSelected(true);
    }

    public void I(View.OnClickListener onClickListener) {
        this.esj = onClickListener;
    }
}
