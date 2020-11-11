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
    private int lhA;
    private List<com.baidu.tieba.newinterest.data.a> lhJ = new ArrayList();
    private InterfaceC0799b lhK;
    private boolean lhL;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0799b {
        void ae(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.lhA;
        bVar.lhA = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.lhA;
        bVar.lhA = i + 1;
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
        if (this.lhJ == null) {
            return 0;
        }
        return this.lhJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.lhJ.get(i);
        aVar.lhH.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.brn().a(aVar.lhG, com.baidu.tieba.newinterest.c.a.Ft(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.lit == 0) {
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
                    aVar2.lit = 2;
                }
            } else {
                int i2 = aVar2.lit;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.lhR.setEnabled(false);
            } else {
                aVar.lhR.setEnabled(true);
            }
            aVar.lhR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.lit));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.lit));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.lit));
                    b.this.lhL = b.this.dgL();
                    b.this.notifyItemChanged(i);
                    if (b.this.lhK != null) {
                        b.this.lhK.ae(b.this.lhA, b.this.lhL);
                    }
                    aq aqVar = new aq("c13682");
                    aqVar.al("obj_type", 2);
                    aqVar.al("obj_locate", 4);
                    aqVar.al("obj_source", aVar2.class_id.intValue());
                    TiebaStatic.log(aqVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, d dVar) {
        String str;
        aVar.lhS.setVisibility(0);
        aVar.lhV.setVisibility(0);
        aVar.lhV.startLoad(dVar.liv.avatar, 10, false);
        aVar.lhY.setText(dVar.liv.forum_name);
        if (TextUtils.isEmpty(dVar.liv.slogan)) {
            str = "百度" + dVar.liv.forum_name + "吧";
        } else {
            str = dVar.liv.slogan;
        }
        aVar.lib.setText(str);
        aVar.lie.setText("关注 " + at.numberUniformFormatExtra(dVar.liv.member_count.intValue()));
        aVar.lih.setText("帖子 " + at.numberUniformFormatExtra(dVar.liv.thread_count.intValue()));
        a(aVar.lik, dVar);
        a(dVar, aVar.lik);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.lhT.setVisibility(0);
        aVar.lhW.setVisibility(0);
        aVar.lhW.startLoad(dVar.liv.avatar, 10, false);
        aVar.lhZ.setText(dVar.liv.forum_name);
        if (TextUtils.isEmpty(dVar.liv.slogan)) {
            str = "百度" + dVar.liv.forum_name + "吧";
        } else {
            str = dVar.liv.slogan;
        }
        aVar.lic.setText(str);
        aVar.lif.setText("关注 " + at.numberUniformFormatExtra(dVar.liv.member_count.intValue()));
        aVar.lii.setText("帖子 " + at.numberUniformFormatExtra(dVar.liv.thread_count.intValue()));
        a(aVar.lil, dVar);
        a(dVar, aVar.lil);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.lhU.setVisibility(0);
        aVar.lhX.setVisibility(0);
        aVar.lhX.startLoad(dVar.liv.avatar, 10, false);
        aVar.lia.setText(dVar.liv.forum_name);
        if (TextUtils.isEmpty(dVar.liv.slogan)) {
            str = "百度" + dVar.liv.forum_name + "吧";
        } else {
            str = dVar.liv.slogan;
        }
        aVar.lid.setText(str);
        aVar.lig.setText("关注 " + at.numberUniformFormatExtra(dVar.liv.member_count.intValue()));
        aVar.lij.setText("帖子 " + at.numberUniformFormatExtra(dVar.liv.thread_count.intValue()));
        a(aVar.lim, dVar);
        a(dVar, aVar.lim);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.qk(R.color.cp_cont_d);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void cp(List<com.baidu.tieba.newinterest.data.a> list) {
        this.lhJ.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.lit < i) {
            aVar.lit++;
        } else {
            aVar.lit = 0;
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
                    b.this.lhL = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.qk(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(bVar);
                    b.this.lhL = b.this.dgL();
                }
                if (b.this.lhK != null) {
                    b.this.lhK.ae(b.this.lhA, b.this.lhL);
                }
                aq aqVar = new aq("c13682");
                aqVar.al("obj_type", 2);
                aqVar.al("obj_locate", 4);
                aqVar.w("fid", dVar.liv.forum_id.longValue());
                TiebaStatic.log(aqVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> dgJ() {
        return this.lhJ;
    }

    public void dgK() {
        if (this.lhJ != null && this.lhJ.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.lhJ) {
                int i = aVar.lit;
                aVar.forum_info.get(i).selected = !this.lhL;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.lhL;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.lhL;
                a(aVar, size2);
            }
            this.lhL = this.lhL ? false : true;
            notifyDataSetChanged();
            if (this.lhK != null) {
                if (this.lhL) {
                    this.lhA = this.lhJ.size() * 3;
                    this.lhK.ae(this.lhJ.size() * 3, this.lhL);
                    return;
                }
                this.lhA = 0;
                this.lhK.ae(0, this.lhL);
            }
        }
    }

    public boolean dgL() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.lhJ) {
            int i = aVar.lit;
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
        if (!this.lhL) {
            aq aqVar = new aq("c13682");
            aqVar.al("obj_type", 2);
            aqVar.al("obj_locate", 3);
            aqVar.w("fid", aVar.forum_info.get(i).liv.forum_id.longValue());
            TiebaStatic.log(aqVar);
        }
    }

    /* loaded from: classes23.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView lhG;
        public TextView lhH;
        public TextView lhR;
        public RelativeLayout lhS;
        public RelativeLayout lhT;
        public RelativeLayout lhU;
        public BarImageView lhV;
        public BarImageView lhW;
        public BarImageView lhX;
        public TextView lhY;
        public TextView lhZ;
        public TextView lia;
        public TextView lib;
        public TextView lic;
        public TextView lid;
        public TextView lie;
        public TextView lif;
        public TextView lig;
        public TextView lih;
        public TextView lii;
        public TextView lij;
        public TBSpecificationBtn lik;
        public TBSpecificationBtn lil;
        public TBSpecificationBtn lim;

        public a(View view) {
            super(view);
            this.lhG = (ImageView) view.findViewById(R.id.interest_icon);
            this.lhH = (TextView) view.findViewById(R.id.interest_text);
            this.lhR = (TextView) view.findViewById(R.id.interest_change);
            this.lhS = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.lhT = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.lhU = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.lhV = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.lhW = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.lhX = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.lhY = (TextView) view.findViewById(R.id.top_forum_name);
            this.lhZ = (TextView) view.findViewById(R.id.middle_forum_name);
            this.lia = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.lib = (TextView) view.findViewById(R.id.top_forum_desc);
            this.lic = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.lid = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.lie = (TextView) view.findViewById(R.id.top_member_text);
            this.lif = (TextView) view.findViewById(R.id.middle_member_text);
            this.lig = (TextView) view.findViewById(R.id.bottom_member_text);
            this.lih = (TextView) view.findViewById(R.id.top_post_text);
            this.lii = (TextView) view.findViewById(R.id.middle_post_text);
            this.lij = (TextView) view.findViewById(R.id.bottom_post_text);
            this.lik = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.lil = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.lim = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.lhY, R.color.cp_cont_b);
            ap.setViewTextColor(this.lhZ, R.color.cp_cont_b);
            ap.setViewTextColor(this.lia, R.color.cp_cont_b);
            ap.setViewTextColor(this.lib, R.color.cp_cont_d);
            ap.setViewTextColor(this.lic, R.color.cp_cont_d);
            ap.setViewTextColor(this.lid, R.color.cp_cont_d);
            ap.setViewTextColor(this.lie, R.color.cp_cont_d);
            ap.setViewTextColor(this.lif, R.color.cp_cont_d);
            ap.setViewTextColor(this.lig, R.color.cp_cont_d);
            ap.setViewTextColor(this.lih, R.color.cp_cont_d);
            ap.setViewTextColor(this.lii, R.color.cp_cont_d);
            ap.setViewTextColor(this.lij, R.color.cp_cont_d);
            ap.setViewTextColor(this.lhH, R.color.cp_cont_b);
            ap.setViewTextColor(this.lhR, R.color.cp_cont_j);
            this.lhH.setTypeface(Typeface.DEFAULT_BOLD);
            this.lhY.setTypeface(Typeface.DEFAULT_BOLD);
            this.lhZ.setTypeface(Typeface.DEFAULT_BOLD);
            this.lia.setTypeface(Typeface.DEFAULT_BOLD);
            this.lik.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.lil.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.lim.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            f(this.lhV);
            f(this.lhW);
            f(this.lhX);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.cp_border_a);
        }
    }

    public void a(InterfaceC0799b interfaceC0799b) {
        this.lhK = interfaceC0799b;
    }
}
