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
    private int kro;
    private List<com.baidu.tieba.newinterest.data.a> krx = new ArrayList();
    private InterfaceC0754b kry;
    private boolean krz;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC0754b {
        void ab(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.kro;
        bVar.kro = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.kro;
        bVar.kro = i + 1;
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
        if (this.krx == null) {
            return 0;
        }
        return this.krx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.krx.get(i);
        aVar.krv.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.bjq().a(aVar.kru, com.baidu.tieba.newinterest.c.a.DG(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.ksh == 0) {
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
                    aVar2.ksh = 2;
                }
            } else {
                int i2 = aVar2.ksh;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.krF.setEnabled(false);
            } else {
                aVar.krF.setEnabled(true);
            }
            aVar.krF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.ksh));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.ksh));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.ksh));
                    b.this.krz = b.this.cTM();
                    b.this.notifyItemChanged(i);
                    if (b.this.kry != null) {
                        b.this.kry.ab(b.this.kro, b.this.krz);
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
        aVar.krG.setVisibility(0);
        aVar.krJ.setVisibility(0);
        aVar.krJ.startLoad(dVar.ksj.avatar, 10, false);
        aVar.krM.setText(dVar.ksj.forum_name);
        if (TextUtils.isEmpty(dVar.ksj.slogan)) {
            str = "百度" + dVar.ksj.forum_name + "吧";
        } else {
            str = dVar.ksj.slogan;
        }
        aVar.krP.setText(str);
        aVar.krS.setText("关注 " + at.numberUniformFormatExtra(dVar.ksj.member_count.intValue()));
        aVar.krV.setText("帖子 " + at.numberUniformFormatExtra(dVar.ksj.thread_count.intValue()));
        a(aVar.krY, dVar);
        a(dVar, aVar.krY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.krH.setVisibility(0);
        aVar.krK.setVisibility(0);
        aVar.krK.startLoad(dVar.ksj.avatar, 10, false);
        aVar.krN.setText(dVar.ksj.forum_name);
        if (TextUtils.isEmpty(dVar.ksj.slogan)) {
            str = "百度" + dVar.ksj.forum_name + "吧";
        } else {
            str = dVar.ksj.slogan;
        }
        aVar.krQ.setText(str);
        aVar.krT.setText("关注 " + at.numberUniformFormatExtra(dVar.ksj.member_count.intValue()));
        aVar.krW.setText("帖子 " + at.numberUniformFormatExtra(dVar.ksj.thread_count.intValue()));
        a(aVar.krZ, dVar);
        a(dVar, aVar.krZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.krI.setVisibility(0);
        aVar.krL.setVisibility(0);
        aVar.krL.startLoad(dVar.ksj.avatar, 10, false);
        aVar.krO.setText(dVar.ksj.forum_name);
        if (TextUtils.isEmpty(dVar.ksj.slogan)) {
            str = "百度" + dVar.ksj.forum_name + "吧";
        } else {
            str = dVar.ksj.slogan;
        }
        aVar.krR.setText(str);
        aVar.krU.setText("关注 " + at.numberUniformFormatExtra(dVar.ksj.member_count.intValue()));
        aVar.krX.setText("帖子 " + at.numberUniformFormatExtra(dVar.ksj.thread_count.intValue()));
        a(aVar.ksa, dVar);
        a(dVar, aVar.ksa);
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
        this.krx.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.ksh < i) {
            aVar.ksh++;
        } else {
            aVar.ksh = 0;
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
                    b.this.krz = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.pd(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(bVar);
                    b.this.krz = b.this.cTM();
                }
                if (b.this.kry != null) {
                    b.this.kry.ab(b.this.kro, b.this.krz);
                }
                aq aqVar = new aq("c13682");
                aqVar.ai("obj_type", 2);
                aqVar.ai("obj_locate", 4);
                aqVar.u("fid", dVar.ksj.forum_id.longValue());
                TiebaStatic.log(aqVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> cTK() {
        return this.krx;
    }

    public void cTL() {
        if (this.krx != null && this.krx.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.krx) {
                int i = aVar.ksh;
                aVar.forum_info.get(i).selected = !this.krz;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.krz;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.krz;
                a(aVar, size2);
            }
            this.krz = this.krz ? false : true;
            notifyDataSetChanged();
            if (this.kry != null) {
                if (this.krz) {
                    this.kro = this.krx.size() * 3;
                    this.kry.ab(this.krx.size() * 3, this.krz);
                    return;
                }
                this.kro = 0;
                this.kry.ab(0, this.krz);
            }
        }
    }

    public boolean cTM() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.krx) {
            int i = aVar.ksh;
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
        if (!this.krz) {
            aq aqVar = new aq("c13682");
            aqVar.ai("obj_type", 2);
            aqVar.ai("obj_locate", 3);
            aqVar.u("fid", aVar.forum_info.get(i).ksj.forum_id.longValue());
            TiebaStatic.log(aqVar);
        }
    }

    /* loaded from: classes17.dex */
    public static class a extends RecyclerView.ViewHolder {
        public TextView krF;
        public RelativeLayout krG;
        public RelativeLayout krH;
        public RelativeLayout krI;
        public BarImageView krJ;
        public BarImageView krK;
        public BarImageView krL;
        public TextView krM;
        public TextView krN;
        public TextView krO;
        public TextView krP;
        public TextView krQ;
        public TextView krR;
        public TextView krS;
        public TextView krT;
        public TextView krU;
        public TextView krV;
        public TextView krW;
        public TextView krX;
        public TBSpecificationBtn krY;
        public TBSpecificationBtn krZ;
        public ImageView kru;
        public TextView krv;
        public TBSpecificationBtn ksa;

        public a(View view) {
            super(view);
            this.kru = (ImageView) view.findViewById(R.id.interest_icon);
            this.krv = (TextView) view.findViewById(R.id.interest_text);
            this.krF = (TextView) view.findViewById(R.id.interest_change);
            this.krG = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.krH = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.krI = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.krJ = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.krK = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.krL = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.krM = (TextView) view.findViewById(R.id.top_forum_name);
            this.krN = (TextView) view.findViewById(R.id.middle_forum_name);
            this.krO = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.krP = (TextView) view.findViewById(R.id.top_forum_desc);
            this.krQ = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.krR = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.krS = (TextView) view.findViewById(R.id.top_member_text);
            this.krT = (TextView) view.findViewById(R.id.middle_member_text);
            this.krU = (TextView) view.findViewById(R.id.bottom_member_text);
            this.krV = (TextView) view.findViewById(R.id.top_post_text);
            this.krW = (TextView) view.findViewById(R.id.middle_post_text);
            this.krX = (TextView) view.findViewById(R.id.bottom_post_text);
            this.krY = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.krZ = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.ksa = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.krM, R.color.cp_cont_b);
            ap.setViewTextColor(this.krN, R.color.cp_cont_b);
            ap.setViewTextColor(this.krO, R.color.cp_cont_b);
            ap.setViewTextColor(this.krP, R.color.cp_cont_d);
            ap.setViewTextColor(this.krQ, R.color.cp_cont_d);
            ap.setViewTextColor(this.krR, R.color.cp_cont_d);
            ap.setViewTextColor(this.krS, R.color.cp_cont_d);
            ap.setViewTextColor(this.krT, R.color.cp_cont_d);
            ap.setViewTextColor(this.krU, R.color.cp_cont_d);
            ap.setViewTextColor(this.krV, R.color.cp_cont_d);
            ap.setViewTextColor(this.krW, R.color.cp_cont_d);
            ap.setViewTextColor(this.krX, R.color.cp_cont_d);
            ap.setViewTextColor(this.krv, R.color.cp_cont_b);
            ap.setViewTextColor(this.krF, R.color.cp_cont_j);
            this.krv.setTypeface(Typeface.DEFAULT_BOLD);
            this.krM.setTypeface(Typeface.DEFAULT_BOLD);
            this.krN.setTypeface(Typeface.DEFAULT_BOLD);
            this.krO.setTypeface(Typeface.DEFAULT_BOLD);
            this.krY.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.krZ.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.ksa.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            f(this.krJ);
            f(this.krK);
            f(this.krL);
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
        this.kry = interfaceC0754b;
    }
}
