package com.baidu.tieba.newinterest.a;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class b extends RecyclerView.Adapter<a> {
    private int lbD;
    private List<com.baidu.tieba.newinterest.data.a> lbM = new ArrayList();
    private InterfaceC0784b lbN;
    private boolean lbO;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0784b {
        void ae(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.lbD;
        bVar.lbD = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.lbD;
        bVar.lbD = i + 1;
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: K */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.lbM == null) {
            return 0;
        }
        return this.lbM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.lbM.get(i);
        aVar.lbK.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.boN().a(aVar.lbJ, com.baidu.tieba.newinterest.c.a.Fg(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.lcw == 0) {
                if (aVar2.forum_info.size() >= 1) {
                    a(aVar, aVar2.forum_info.get(0));
                }
                if (aVar2.forum_info.size() >= 2) {
                    b(aVar, aVar2.forum_info.get(1));
                }
                if (aVar2.forum_info.size() >= 3) {
                    c(aVar, aVar2.forum_info.get(2));
                }
                if (aVar2.forum_info.size() > 3) {
                    aVar2.lcw = 2;
                }
            } else {
                int i2 = aVar2.lcw;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.lbU.setEnabled(false);
            } else {
                aVar.lbU.setEnabled(true);
            }
            aVar.lbU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.lcw));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.lcw));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.lcw));
                    b.this.lbO = b.this.dej();
                    b.this.notifyItemChanged(i);
                    if (b.this.lbN != null) {
                        b.this.lbN.ae(b.this.lbD, b.this.lbO);
                    }
                    aq aqVar = new aq("c13682");
                    aqVar.aj("obj_type", 2);
                    aqVar.aj("obj_locate", 4);
                    aqVar.aj("obj_source", aVar2.class_id.intValue());
                    TiebaStatic.log(aqVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, d dVar) {
        String str;
        aVar.lbV.setVisibility(0);
        aVar.lbY.setVisibility(0);
        aVar.lbY.startLoad(dVar.lcy.avatar, 10, false);
        aVar.lcb.setText(dVar.lcy.forum_name);
        if (TextUtils.isEmpty(dVar.lcy.slogan)) {
            str = "百度" + dVar.lcy.forum_name + "吧";
        } else {
            str = dVar.lcy.slogan;
        }
        aVar.lce.setText(str);
        aVar.lch.setText("关注 " + at.numberUniformFormatExtra(dVar.lcy.member_count.intValue()));
        aVar.lck.setText("帖子 " + at.numberUniformFormatExtra(dVar.lcy.thread_count.intValue()));
        a(aVar.lcn, dVar);
        a(dVar, aVar.lcn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.lbW.setVisibility(0);
        aVar.lbZ.setVisibility(0);
        aVar.lbZ.startLoad(dVar.lcy.avatar, 10, false);
        aVar.lcc.setText(dVar.lcy.forum_name);
        if (TextUtils.isEmpty(dVar.lcy.slogan)) {
            str = "百度" + dVar.lcy.forum_name + "吧";
        } else {
            str = dVar.lcy.slogan;
        }
        aVar.lcf.setText(str);
        aVar.lci.setText("关注 " + at.numberUniformFormatExtra(dVar.lcy.member_count.intValue()));
        aVar.lcl.setText("帖子 " + at.numberUniformFormatExtra(dVar.lcy.thread_count.intValue()));
        a(aVar.lco, dVar);
        a(dVar, aVar.lco);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.lbX.setVisibility(0);
        aVar.lca.setVisibility(0);
        aVar.lca.startLoad(dVar.lcy.avatar, 10, false);
        aVar.lcd.setText(dVar.lcy.forum_name);
        if (TextUtils.isEmpty(dVar.lcy.slogan)) {
            str = "百度" + dVar.lcy.forum_name + "吧";
        } else {
            str = dVar.lcy.slogan;
        }
        aVar.lcg.setText(str);
        aVar.lcj.setText("关注 " + at.numberUniformFormatExtra(dVar.lcy.member_count.intValue()));
        aVar.lcm.setText("帖子 " + at.numberUniformFormatExtra(dVar.lcy.thread_count.intValue()));
        a(aVar.lcp, dVar);
        a(dVar, aVar.lcp);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.qa(R.color.cp_cont_d);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void ci(List<com.baidu.tieba.newinterest.data.a> list) {
        this.lbM.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.lcw < i) {
            aVar.lcw++;
        } else {
            aVar.lcw = 0;
        }
    }

    private void a(final d dVar, final TBSpecificationBtn tBSpecificationBtn) {
        tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dVar.selected = !dVar.selected;
                com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
                if (!dVar.selected) {
                    b.d(b.this);
                    tBSpecificationBtn.setText("感兴趣");
                    tBSpecificationBtn.setConfig(bVar);
                    b.this.lbO = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.qa(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(bVar);
                    b.this.lbO = b.this.dej();
                }
                if (b.this.lbN != null) {
                    b.this.lbN.ae(b.this.lbD, b.this.lbO);
                }
                aq aqVar = new aq("c13682");
                aqVar.aj("obj_type", 2);
                aqVar.aj("obj_locate", 4);
                aqVar.w("fid", dVar.lcy.forum_id.longValue());
                TiebaStatic.log(aqVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> deh() {
        return this.lbM;
    }

    public void dei() {
        if (this.lbM != null && this.lbM.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.lbM) {
                int i = aVar.lcw;
                aVar.forum_info.get(i).selected = !this.lbO;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.lbO;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.lbO;
                a(aVar, size2);
            }
            this.lbO = this.lbO ? false : true;
            notifyDataSetChanged();
            if (this.lbN != null) {
                if (this.lbO) {
                    this.lbD = this.lbM.size() * 3;
                    this.lbN.ae(this.lbM.size() * 3, this.lbO);
                    return;
                }
                this.lbD = 0;
                this.lbN.ae(0, this.lbO);
            }
        }
    }

    public boolean dej() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.lbM) {
            int i = aVar.lcw;
            if (!aVar.forum_info.get(i).selected) {
                return false;
            }
            int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
            if (!aVar.forum_info.get(size).selected) {
                return false;
            }
            if (!aVar.forum_info.get(size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1).selected) {
                return false;
            }
        }
        return true;
    }

    private void a(com.baidu.tieba.newinterest.data.a aVar, int i) {
        if (!this.lbO) {
            aq aqVar = new aq("c13682");
            aqVar.aj("obj_type", 2);
            aqVar.aj("obj_locate", 3);
            aqVar.w("fid", aVar.forum_info.get(i).lcy.forum_id.longValue());
            TiebaStatic.log(aqVar);
        }
    }

    /* loaded from: classes23.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView lbJ;
        public TextView lbK;
        public TextView lbU;
        public RelativeLayout lbV;
        public RelativeLayout lbW;
        public RelativeLayout lbX;
        public BarImageView lbY;
        public BarImageView lbZ;
        public BarImageView lca;
        public TextView lcb;
        public TextView lcc;
        public TextView lcd;
        public TextView lce;
        public TextView lcf;
        public TextView lcg;
        public TextView lch;
        public TextView lci;
        public TextView lcj;
        public TextView lck;
        public TextView lcl;
        public TextView lcm;
        public TBSpecificationBtn lcn;
        public TBSpecificationBtn lco;
        public TBSpecificationBtn lcp;

        public a(View view) {
            super(view);
            this.lbJ = (ImageView) view.findViewById(R.id.interest_icon);
            this.lbK = (TextView) view.findViewById(R.id.interest_text);
            this.lbU = (TextView) view.findViewById(R.id.interest_change);
            this.lbV = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.lbW = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.lbX = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.lbY = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.lbZ = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.lca = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.lcb = (TextView) view.findViewById(R.id.top_forum_name);
            this.lcc = (TextView) view.findViewById(R.id.middle_forum_name);
            this.lcd = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.lce = (TextView) view.findViewById(R.id.top_forum_desc);
            this.lcf = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.lcg = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.lch = (TextView) view.findViewById(R.id.top_member_text);
            this.lci = (TextView) view.findViewById(R.id.middle_member_text);
            this.lcj = (TextView) view.findViewById(R.id.bottom_member_text);
            this.lck = (TextView) view.findViewById(R.id.top_post_text);
            this.lcl = (TextView) view.findViewById(R.id.middle_post_text);
            this.lcm = (TextView) view.findViewById(R.id.bottom_post_text);
            this.lcn = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.lco = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.lcp = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.lcb, R.color.cp_cont_b);
            ap.setViewTextColor(this.lcc, R.color.cp_cont_b);
            ap.setViewTextColor(this.lcd, R.color.cp_cont_b);
            ap.setViewTextColor(this.lce, R.color.cp_cont_d);
            ap.setViewTextColor(this.lcf, R.color.cp_cont_d);
            ap.setViewTextColor(this.lcg, R.color.cp_cont_d);
            ap.setViewTextColor(this.lch, R.color.cp_cont_d);
            ap.setViewTextColor(this.lci, R.color.cp_cont_d);
            ap.setViewTextColor(this.lcj, R.color.cp_cont_d);
            ap.setViewTextColor(this.lck, R.color.cp_cont_d);
            ap.setViewTextColor(this.lcl, R.color.cp_cont_d);
            ap.setViewTextColor(this.lcm, R.color.cp_cont_d);
            ap.setViewTextColor(this.lbK, R.color.cp_cont_b);
            ap.setViewTextColor(this.lbU, R.color.cp_cont_j);
            this.lbK.setTypeface(Typeface.DEFAULT_BOLD);
            this.lcb.setTypeface(Typeface.DEFAULT_BOLD);
            this.lcc.setTypeface(Typeface.DEFAULT_BOLD);
            this.lcd.setTypeface(Typeface.DEFAULT_BOLD);
            this.lcn.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.lco.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.lcp.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            f(this.lbY);
            f(this.lbZ);
            f(this.lca);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.cp_border_a);
        }
    }

    public void a(InterfaceC0784b interfaceC0784b) {
        this.lbN = interfaceC0784b;
    }
}
