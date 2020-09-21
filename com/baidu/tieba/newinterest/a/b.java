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
/* loaded from: classes22.dex */
public class b extends RecyclerView.Adapter<a> {
    private List<com.baidu.tieba.newinterest.data.a> kAd = new ArrayList();
    private InterfaceC0751b kAe;
    private boolean kAf;
    private int kzU;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0751b {
        void ac(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.kzU;
        bVar.kzU = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.kzU;
        bVar.kzU = i + 1;
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: I */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.kAd == null) {
            return 0;
        }
        return this.kAd.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.kAd.get(i);
        aVar.kAb.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.bkl().a(aVar.kAa, com.baidu.tieba.newinterest.c.a.Eh(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.kAN == 0) {
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
                    aVar2.kAN = 2;
                }
            } else {
                int i2 = aVar2.kAN;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.kAl.setEnabled(false);
            } else {
                aVar.kAl.setEnabled(true);
            }
            aVar.kAl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.kAN));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.kAN));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.kAN));
                    b.this.kAf = b.this.cXs();
                    b.this.notifyItemChanged(i);
                    if (b.this.kAe != null) {
                        b.this.kAe.ac(b.this.kzU, b.this.kAf);
                    }
                    aq aqVar = new aq("c13682");
                    aqVar.ai("obj_type", 2);
                    aqVar.ai("obj_locate", 4);
                    aqVar.ai("obj_source", aVar2.class_id.intValue());
                    TiebaStatic.log(aqVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, d dVar) {
        String str;
        aVar.kAm.setVisibility(0);
        aVar.kAp.setVisibility(0);
        aVar.kAp.startLoad(dVar.kAP.avatar, 10, false);
        aVar.kAs.setText(dVar.kAP.forum_name);
        if (TextUtils.isEmpty(dVar.kAP.slogan)) {
            str = "百度" + dVar.kAP.forum_name + "吧";
        } else {
            str = dVar.kAP.slogan;
        }
        aVar.kAv.setText(str);
        aVar.kAy.setText("关注 " + at.numberUniformFormatExtra(dVar.kAP.member_count.intValue()));
        aVar.kAB.setText("帖子 " + at.numberUniformFormatExtra(dVar.kAP.thread_count.intValue()));
        a(aVar.kAE, dVar);
        a(dVar, aVar.kAE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.kAn.setVisibility(0);
        aVar.kAq.setVisibility(0);
        aVar.kAq.startLoad(dVar.kAP.avatar, 10, false);
        aVar.kAt.setText(dVar.kAP.forum_name);
        if (TextUtils.isEmpty(dVar.kAP.slogan)) {
            str = "百度" + dVar.kAP.forum_name + "吧";
        } else {
            str = dVar.kAP.slogan;
        }
        aVar.kAw.setText(str);
        aVar.kAz.setText("关注 " + at.numberUniformFormatExtra(dVar.kAP.member_count.intValue()));
        aVar.kAC.setText("帖子 " + at.numberUniformFormatExtra(dVar.kAP.thread_count.intValue()));
        a(aVar.kAF, dVar);
        a(dVar, aVar.kAF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.kAo.setVisibility(0);
        aVar.kAr.setVisibility(0);
        aVar.kAr.startLoad(dVar.kAP.avatar, 10, false);
        aVar.kAu.setText(dVar.kAP.forum_name);
        if (TextUtils.isEmpty(dVar.kAP.slogan)) {
            str = "百度" + dVar.kAP.forum_name + "吧";
        } else {
            str = dVar.kAP.slogan;
        }
        aVar.kAx.setText(str);
        aVar.kAA.setText("关注 " + at.numberUniformFormatExtra(dVar.kAP.member_count.intValue()));
        aVar.kAD.setText("帖子 " + at.numberUniformFormatExtra(dVar.kAP.thread_count.intValue()));
        a(aVar.kAG, dVar);
        a(dVar, aVar.kAG);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.pr(R.color.cp_cont_d);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void bV(List<com.baidu.tieba.newinterest.data.a> list) {
        this.kAd.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.kAN < i) {
            aVar.kAN++;
        } else {
            aVar.kAN = 0;
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
                    b.this.kAf = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.pr(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(bVar);
                    b.this.kAf = b.this.cXs();
                }
                if (b.this.kAe != null) {
                    b.this.kAe.ac(b.this.kzU, b.this.kAf);
                }
                aq aqVar = new aq("c13682");
                aqVar.ai("obj_type", 2);
                aqVar.ai("obj_locate", 4);
                aqVar.u("fid", dVar.kAP.forum_id.longValue());
                TiebaStatic.log(aqVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> cXq() {
        return this.kAd;
    }

    public void cXr() {
        if (this.kAd != null && this.kAd.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.kAd) {
                int i = aVar.kAN;
                aVar.forum_info.get(i).selected = !this.kAf;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.kAf;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.kAf;
                a(aVar, size2);
            }
            this.kAf = this.kAf ? false : true;
            notifyDataSetChanged();
            if (this.kAe != null) {
                if (this.kAf) {
                    this.kzU = this.kAd.size() * 3;
                    this.kAe.ac(this.kAd.size() * 3, this.kAf);
                    return;
                }
                this.kzU = 0;
                this.kAe.ac(0, this.kAf);
            }
        }
    }

    public boolean cXs() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.kAd) {
            int i = aVar.kAN;
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
        if (!this.kAf) {
            aq aqVar = new aq("c13682");
            aqVar.ai("obj_type", 2);
            aqVar.ai("obj_locate", 3);
            aqVar.u("fid", aVar.forum_info.get(i).kAP.forum_id.longValue());
            TiebaStatic.log(aqVar);
        }
    }

    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.ViewHolder {
        public TextView kAA;
        public TextView kAB;
        public TextView kAC;
        public TextView kAD;
        public TBSpecificationBtn kAE;
        public TBSpecificationBtn kAF;
        public TBSpecificationBtn kAG;
        public ImageView kAa;
        public TextView kAb;
        public TextView kAl;
        public RelativeLayout kAm;
        public RelativeLayout kAn;
        public RelativeLayout kAo;
        public BarImageView kAp;
        public BarImageView kAq;
        public BarImageView kAr;
        public TextView kAs;
        public TextView kAt;
        public TextView kAu;
        public TextView kAv;
        public TextView kAw;
        public TextView kAx;
        public TextView kAy;
        public TextView kAz;

        public a(View view) {
            super(view);
            this.kAa = (ImageView) view.findViewById(R.id.interest_icon);
            this.kAb = (TextView) view.findViewById(R.id.interest_text);
            this.kAl = (TextView) view.findViewById(R.id.interest_change);
            this.kAm = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.kAn = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.kAo = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.kAp = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.kAq = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.kAr = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.kAs = (TextView) view.findViewById(R.id.top_forum_name);
            this.kAt = (TextView) view.findViewById(R.id.middle_forum_name);
            this.kAu = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.kAv = (TextView) view.findViewById(R.id.top_forum_desc);
            this.kAw = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.kAx = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.kAy = (TextView) view.findViewById(R.id.top_member_text);
            this.kAz = (TextView) view.findViewById(R.id.middle_member_text);
            this.kAA = (TextView) view.findViewById(R.id.bottom_member_text);
            this.kAB = (TextView) view.findViewById(R.id.top_post_text);
            this.kAC = (TextView) view.findViewById(R.id.middle_post_text);
            this.kAD = (TextView) view.findViewById(R.id.bottom_post_text);
            this.kAE = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.kAF = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.kAG = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.kAs, R.color.cp_cont_b);
            ap.setViewTextColor(this.kAt, R.color.cp_cont_b);
            ap.setViewTextColor(this.kAu, R.color.cp_cont_b);
            ap.setViewTextColor(this.kAv, R.color.cp_cont_d);
            ap.setViewTextColor(this.kAw, R.color.cp_cont_d);
            ap.setViewTextColor(this.kAx, R.color.cp_cont_d);
            ap.setViewTextColor(this.kAy, R.color.cp_cont_d);
            ap.setViewTextColor(this.kAz, R.color.cp_cont_d);
            ap.setViewTextColor(this.kAA, R.color.cp_cont_d);
            ap.setViewTextColor(this.kAB, R.color.cp_cont_d);
            ap.setViewTextColor(this.kAC, R.color.cp_cont_d);
            ap.setViewTextColor(this.kAD, R.color.cp_cont_d);
            ap.setViewTextColor(this.kAb, R.color.cp_cont_b);
            ap.setViewTextColor(this.kAl, R.color.cp_cont_j);
            this.kAb.setTypeface(Typeface.DEFAULT_BOLD);
            this.kAs.setTypeface(Typeface.DEFAULT_BOLD);
            this.kAt.setTypeface(Typeface.DEFAULT_BOLD);
            this.kAu.setTypeface(Typeface.DEFAULT_BOLD);
            this.kAE.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.kAF.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.kAG.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            f(this.kAp);
            f(this.kAq);
            f(this.kAr);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.cp_border_a);
        }
    }

    public void a(InterfaceC0751b interfaceC0751b) {
        this.kAe = interfaceC0751b;
    }
}
