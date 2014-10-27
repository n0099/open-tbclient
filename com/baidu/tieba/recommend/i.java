package com.baidu.tieba.recommend;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.q {
    private Activity aBF;
    private l bHX;
    int vM;
    private boolean yB;
    private ArrayList<m> bIa = new ArrayList<>();
    private SimpleDateFormat bHY = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat bHZ = new SimpleDateFormat("MM-dd");

    public i(Activity activity, l lVar) {
        this.aBF = activity;
        this.yB = TbadkApplication.m251getInst().getSkinType() == 1;
        this.bHX = lVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bIa.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        k kVar;
        n nVar;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null || view.getTag() == null) {
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.aBF, w.daily_recommend_time, null);
                    n nVar2 = new n();
                    nVar2.aQH = (TextView) view.findViewById(v.time);
                    nVar2.bIf = (TextView) view.findViewById(v.count);
                    a(nVar2);
                    view.setTag(v.position, nVar2);
                    nVar = nVar2;
                } else {
                    nVar = (n) view.getTag(v.position);
                }
                view.setTag(Integer.valueOf(i));
                a(nVar, i);
                break;
            case 1:
                if (view == null || view.getTag() == null) {
                    view = com.baidu.adp.lib.g.b.ek().inflate(this.aBF, w.daily_recommend_concentratio, null);
                    k kVar2 = new k();
                    kVar2.bId = view.findViewById(v.father);
                    kVar2.bIe = (LinearLayout) view.findViewById(v.head_bottom);
                    kVar2.bhZ = view.findViewById(v.frs_line);
                    kVar2.bIg = (TextView) view.findViewById(v.bar_name);
                    kVar2.bIf = (TextView) view.findViewById(v.count);
                    kVar2.bfk = (TextView) view.findViewById(v.desc);
                    kVar2.QG = (TextView) view.findViewById(v.title);
                    kVar2.aEg = (TextView) view.findViewById(v.user_name);
                    a(kVar2);
                    view.setTag(kVar2);
                    kVar = kVar2;
                } else {
                    kVar = (k) view.getTag();
                }
                a(kVar, i);
                break;
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        if (i < this.bIa.size()) {
            return this.bIa.get(i).type;
        }
        return -1;
    }

    private void a(n nVar) {
        aw.b(nVar.aQH, com.baidu.tieba.s.cp_cont_i, 1);
        aw.b(nVar.bIf, com.baidu.tieba.s.cp_cont_d, 1);
    }

    public void a(n nVar, int i) {
        if (this.bIa.get(i).type == 0) {
            com.baidu.tieba.data.n nVar2 = (com.baidu.tieba.data.n) this.bIa.get(i).data;
            Date date = new Date();
            try {
                date = this.bHY.parse(nVar2.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            nVar.aQH.setText(this.bHZ.format(date));
            if (nVar2.yK()) {
                aw.h((View) nVar.aQH, u.icon_daily_sentence_bar_red);
            } else {
                aw.h((View) nVar.aQH, u.icon_daily_sentence_bar_gray);
            }
            nVar.bIf.setText(String.valueOf(nVar2.yI()) + this.aBF.getResources().getString(y.hot_count));
            if (this.vM < i) {
                nVar.aQH.setVisibility(0);
            }
        }
    }

    private void a(k kVar) {
        aw.h(kVar.bId, com.baidu.tieba.s.cp_bg_line_c);
        aw.h(kVar.bIe, u.daily_recommend_item_selector);
        aw.h(kVar.bhZ, com.baidu.tieba.s.cp_bg_line_b);
        aw.b(kVar.QG, com.baidu.tieba.s.cp_cont_b, 1);
        int paddingLeft = kVar.bIf.getPaddingLeft();
        int paddingRight = kVar.bIf.getPaddingRight();
        aw.b(kVar.bIf, com.baidu.tieba.s.cp_cont_d, 1);
        kVar.bIf.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        kVar.bIf.setPadding(paddingLeft, 0, paddingRight, 0);
        int paddingLeft2 = kVar.aEg.getPaddingLeft();
        int paddingRight2 = kVar.aEg.getPaddingRight();
        aw.b(kVar.aEg, com.baidu.tieba.s.cp_cont_d, 1);
        kVar.aEg.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_name), (Drawable) null, (Drawable) null, (Drawable) null);
        kVar.aEg.setPadding(paddingLeft2, 0, paddingRight2, 0);
        aw.b(kVar.bfk, com.baidu.tieba.s.cp_cont_c, 1);
        aw.b(kVar.bIg, com.baidu.tieba.s.cp_cont_d, 1);
    }

    public void a(k kVar, int i) {
        if (this.bIa.get(i).type == 1) {
            com.baidu.tieba.data.m mVar = (com.baidu.tieba.data.m) this.bIa.get(i).data;
            kVar.QG.setText(mVar.getTitle());
            kVar.bIf.setText(mVar.yH());
            kVar.aEg.setText(mVar.getUserName());
            kVar.bfk.setText(mVar.kK());
            kVar.bIg.setText(String.valueOf(mVar.getForumName()) + "吧");
            kVar.bId.setOnClickListener(new j(this, mVar));
        }
    }

    public void b(com.baidu.tieba.data.l lVar) {
        if (lVar != null) {
            this.bIa.clear();
            if (lVar.yG() != null && lVar.yG().size() > 0) {
                ArrayList<com.baidu.tieba.data.n> yG = lVar.yG();
                for (int i = 0; i < yG.size(); i++) {
                    com.baidu.tieba.data.n nVar = yG.get(i);
                    String time = nVar.getTime();
                    if (this.bHX != null) {
                        this.bHX.hk(time);
                    }
                    this.bIa.add(new m(this, 0, nVar, time));
                    if (nVar.yJ() != null && nVar.yJ().size() > 0) {
                        for (int i2 = 0; i2 < nVar.yJ().size(); i2++) {
                            com.baidu.tieba.data.m mVar = nVar.yJ().get(i2);
                            if (mVar.getType().equals("0")) {
                                this.bIa.add(new m(this, 1, mVar, time));
                            }
                        }
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.adp.widget.q
    public int hZ() {
        return 0;
    }

    @Override // com.baidu.adp.widget.q
    public View ia() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aBF, w.daily_recommend_time, null);
        inflate.findViewById(v.count).setVisibility(8);
        return inflate;
    }

    @Override // com.baidu.adp.widget.q
    public void a(View view, AdapterView<?> adapterView, int i) {
        Date date;
        if (i == -1) {
            View findViewWithTag = adapterView.findViewWithTag(Integer.valueOf(hh(i)));
            if (findViewWithTag != null) {
                findViewWithTag.findViewById(v.time).setVisibility(0);
                return;
            }
            return;
        }
        m mVar = this.bIa.get(i);
        TextView textView = (TextView) view.findViewById(v.time);
        Date date2 = new Date();
        try {
            date = this.bHY.parse(mVar.time);
        } catch (ParseException e) {
            e.printStackTrace();
            date = date2;
        }
        textView.setText(this.bHZ.format(date));
        aw.b(textView, com.baidu.tieba.s.cp_cont_i, 1);
        if (i <= 0) {
            aw.h((View) textView, u.icon_daily_sentence_bar_red_s);
        } else {
            aw.h((View) textView, u.icon_daily_sentence_bar_gray_s);
        }
        this.vM = i;
        View findViewWithTag2 = adapterView.findViewWithTag(Integer.valueOf(hh(i)));
        if (findViewWithTag2 != null) {
            findViewWithTag2.findViewById(v.time).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hg */
    public m getItem(int i) {
        return this.bIa.get(i);
    }

    private int hh(int i) {
        int count = getCount();
        for (int i2 = i + 1; i2 < count; i2++) {
            if (getItemViewType(i2) == hZ()) {
                return i2;
            }
        }
        return i;
    }
}
