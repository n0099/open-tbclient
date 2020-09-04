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
/* loaded from: classes17.dex */
public class b extends RecyclerView.Adapter<a> {
    private List<com.baidu.tieba.newinterest.data.a> krE = new ArrayList();
    private InterfaceC0754b krF;
    private boolean krG;
    private int krv;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC0754b {
        void ab(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.krv;
        bVar.krv = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.krv;
        bVar.krv = i + 1;
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: G */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.krE == null) {
            return 0;
        }
        return this.krE.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.krE.get(i);
        aVar.krC.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.bjq().a(aVar.krB, com.baidu.tieba.newinterest.c.a.DG(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.kso == 0) {
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
                    aVar2.kso = 2;
                }
            } else {
                int i2 = aVar2.kso;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.krM.setEnabled(false);
            } else {
                aVar.krM.setEnabled(true);
            }
            aVar.krM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.kso));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.kso));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.kso));
                    b.this.krG = b.this.cTN();
                    b.this.notifyItemChanged(i);
                    if (b.this.krF != null) {
                        b.this.krF.ab(b.this.krv, b.this.krG);
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
        aVar.krN.setVisibility(0);
        aVar.krQ.setVisibility(0);
        aVar.krQ.startLoad(dVar.ksq.avatar, 10, false);
        aVar.krT.setText(dVar.ksq.forum_name);
        if (TextUtils.isEmpty(dVar.ksq.slogan)) {
            str = "百度" + dVar.ksq.forum_name + "吧";
        } else {
            str = dVar.ksq.slogan;
        }
        aVar.krW.setText(str);
        aVar.krZ.setText("关注 " + at.numberUniformFormatExtra(dVar.ksq.member_count.intValue()));
        aVar.ksc.setText("帖子 " + at.numberUniformFormatExtra(dVar.ksq.thread_count.intValue()));
        a(aVar.ksf, dVar);
        a(dVar, aVar.ksf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.krO.setVisibility(0);
        aVar.krR.setVisibility(0);
        aVar.krR.startLoad(dVar.ksq.avatar, 10, false);
        aVar.krU.setText(dVar.ksq.forum_name);
        if (TextUtils.isEmpty(dVar.ksq.slogan)) {
            str = "百度" + dVar.ksq.forum_name + "吧";
        } else {
            str = dVar.ksq.slogan;
        }
        aVar.krX.setText(str);
        aVar.ksa.setText("关注 " + at.numberUniformFormatExtra(dVar.ksq.member_count.intValue()));
        aVar.ksd.setText("帖子 " + at.numberUniformFormatExtra(dVar.ksq.thread_count.intValue()));
        a(aVar.ksg, dVar);
        a(dVar, aVar.ksg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.krP.setVisibility(0);
        aVar.krS.setVisibility(0);
        aVar.krS.startLoad(dVar.ksq.avatar, 10, false);
        aVar.krV.setText(dVar.ksq.forum_name);
        if (TextUtils.isEmpty(dVar.ksq.slogan)) {
            str = "百度" + dVar.ksq.forum_name + "吧";
        } else {
            str = dVar.ksq.slogan;
        }
        aVar.krY.setText(str);
        aVar.ksb.setText("关注 " + at.numberUniformFormatExtra(dVar.ksq.member_count.intValue()));
        aVar.kse.setText("帖子 " + at.numberUniformFormatExtra(dVar.ksq.thread_count.intValue()));
        a(aVar.ksh, dVar);
        a(dVar, aVar.ksh);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.pd(R.color.cp_cont_d);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void bQ(List<com.baidu.tieba.newinterest.data.a> list) {
        this.krE.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.kso < i) {
            aVar.kso++;
        } else {
            aVar.kso = 0;
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
                    b.this.krG = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.pd(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(bVar);
                    b.this.krG = b.this.cTN();
                }
                if (b.this.krF != null) {
                    b.this.krF.ab(b.this.krv, b.this.krG);
                }
                aq aqVar = new aq("c13682");
                aqVar.ai("obj_type", 2);
                aqVar.ai("obj_locate", 4);
                aqVar.u("fid", dVar.ksq.forum_id.longValue());
                TiebaStatic.log(aqVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> cTL() {
        return this.krE;
    }

    public void cTM() {
        if (this.krE != null && this.krE.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.krE) {
                int i = aVar.kso;
                aVar.forum_info.get(i).selected = !this.krG;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.krG;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.krG;
                a(aVar, size2);
            }
            this.krG = this.krG ? false : true;
            notifyDataSetChanged();
            if (this.krF != null) {
                if (this.krG) {
                    this.krv = this.krE.size() * 3;
                    this.krF.ab(this.krE.size() * 3, this.krG);
                    return;
                }
                this.krv = 0;
                this.krF.ab(0, this.krG);
            }
        }
    }

    public boolean cTN() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.krE) {
            int i = aVar.kso;
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
        if (!this.krG) {
            aq aqVar = new aq("c13682");
            aqVar.ai("obj_type", 2);
            aqVar.ai("obj_locate", 3);
            aqVar.u("fid", aVar.forum_info.get(i).ksq.forum_id.longValue());
            TiebaStatic.log(aqVar);
        }
    }

    /* loaded from: classes17.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView krB;
        public TextView krC;
        public TextView krM;
        public RelativeLayout krN;
        public RelativeLayout krO;
        public RelativeLayout krP;
        public BarImageView krQ;
        public BarImageView krR;
        public BarImageView krS;
        public TextView krT;
        public TextView krU;
        public TextView krV;
        public TextView krW;
        public TextView krX;
        public TextView krY;
        public TextView krZ;
        public TextView ksa;
        public TextView ksb;
        public TextView ksc;
        public TextView ksd;
        public TextView kse;
        public TBSpecificationBtn ksf;
        public TBSpecificationBtn ksg;
        public TBSpecificationBtn ksh;

        public a(View view) {
            super(view);
            this.krB = (ImageView) view.findViewById(R.id.interest_icon);
            this.krC = (TextView) view.findViewById(R.id.interest_text);
            this.krM = (TextView) view.findViewById(R.id.interest_change);
            this.krN = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.krO = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.krP = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.krQ = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.krR = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.krS = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.krT = (TextView) view.findViewById(R.id.top_forum_name);
            this.krU = (TextView) view.findViewById(R.id.middle_forum_name);
            this.krV = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.krW = (TextView) view.findViewById(R.id.top_forum_desc);
            this.krX = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.krY = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.krZ = (TextView) view.findViewById(R.id.top_member_text);
            this.ksa = (TextView) view.findViewById(R.id.middle_member_text);
            this.ksb = (TextView) view.findViewById(R.id.bottom_member_text);
            this.ksc = (TextView) view.findViewById(R.id.top_post_text);
            this.ksd = (TextView) view.findViewById(R.id.middle_post_text);
            this.kse = (TextView) view.findViewById(R.id.bottom_post_text);
            this.ksf = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.ksg = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.ksh = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.krT, R.color.cp_cont_b);
            ap.setViewTextColor(this.krU, R.color.cp_cont_b);
            ap.setViewTextColor(this.krV, R.color.cp_cont_b);
            ap.setViewTextColor(this.krW, R.color.cp_cont_d);
            ap.setViewTextColor(this.krX, R.color.cp_cont_d);
            ap.setViewTextColor(this.krY, R.color.cp_cont_d);
            ap.setViewTextColor(this.krZ, R.color.cp_cont_d);
            ap.setViewTextColor(this.ksa, R.color.cp_cont_d);
            ap.setViewTextColor(this.ksb, R.color.cp_cont_d);
            ap.setViewTextColor(this.ksc, R.color.cp_cont_d);
            ap.setViewTextColor(this.ksd, R.color.cp_cont_d);
            ap.setViewTextColor(this.kse, R.color.cp_cont_d);
            ap.setViewTextColor(this.krC, R.color.cp_cont_b);
            ap.setViewTextColor(this.krM, R.color.cp_cont_j);
            this.krC.setTypeface(Typeface.DEFAULT_BOLD);
            this.krT.setTypeface(Typeface.DEFAULT_BOLD);
            this.krU.setTypeface(Typeface.DEFAULT_BOLD);
            this.krV.setTypeface(Typeface.DEFAULT_BOLD);
            this.ksf.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.ksg.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.ksh.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            f(this.krQ);
            f(this.krR);
            f(this.krS);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.cp_border_a);
        }
    }

    public void a(InterfaceC0754b interfaceC0754b) {
        this.krF = interfaceC0754b;
    }
}
