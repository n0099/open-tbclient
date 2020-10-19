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
    private int kPf;
    private List<com.baidu.tieba.newinterest.data.a> kPo = new ArrayList();
    private InterfaceC0769b kPp;
    private boolean kPq;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0769b {
        void ae(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.kPf;
        bVar.kPf = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.kPf;
        bVar.kPf = i + 1;
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
        if (this.kPo == null) {
            return 0;
        }
        return this.kPo.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.kPo.get(i);
        aVar.kPm.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.bmU().a(aVar.kPl, com.baidu.tieba.newinterest.c.a.EN(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.kPY == 0) {
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
                    aVar2.kPY = 2;
                }
            } else {
                int i2 = aVar2.kPY;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.kPw.setEnabled(false);
            } else {
                aVar.kPw.setEnabled(true);
            }
            aVar.kPw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.kPY));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.kPY));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.kPY));
                    b.this.kPq = b.this.dbb();
                    b.this.notifyItemChanged(i);
                    if (b.this.kPp != null) {
                        b.this.kPp.ae(b.this.kPf, b.this.kPq);
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
        aVar.kPx.setVisibility(0);
        aVar.kPA.setVisibility(0);
        aVar.kPA.startLoad(dVar.kQa.avatar, 10, false);
        aVar.kPD.setText(dVar.kQa.forum_name);
        if (TextUtils.isEmpty(dVar.kQa.slogan)) {
            str = "百度" + dVar.kQa.forum_name + "吧";
        } else {
            str = dVar.kQa.slogan;
        }
        aVar.kPG.setText(str);
        aVar.kPJ.setText("关注 " + at.numberUniformFormatExtra(dVar.kQa.member_count.intValue()));
        aVar.kPM.setText("帖子 " + at.numberUniformFormatExtra(dVar.kQa.thread_count.intValue()));
        a(aVar.kPP, dVar);
        a(dVar, aVar.kPP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.kPy.setVisibility(0);
        aVar.kPB.setVisibility(0);
        aVar.kPB.startLoad(dVar.kQa.avatar, 10, false);
        aVar.kPE.setText(dVar.kQa.forum_name);
        if (TextUtils.isEmpty(dVar.kQa.slogan)) {
            str = "百度" + dVar.kQa.forum_name + "吧";
        } else {
            str = dVar.kQa.slogan;
        }
        aVar.kPH.setText(str);
        aVar.kPK.setText("关注 " + at.numberUniformFormatExtra(dVar.kQa.member_count.intValue()));
        aVar.kPN.setText("帖子 " + at.numberUniformFormatExtra(dVar.kQa.thread_count.intValue()));
        a(aVar.kPQ, dVar);
        a(dVar, aVar.kPQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.kPz.setVisibility(0);
        aVar.kPC.setVisibility(0);
        aVar.kPC.startLoad(dVar.kQa.avatar, 10, false);
        aVar.kPF.setText(dVar.kQa.forum_name);
        if (TextUtils.isEmpty(dVar.kQa.slogan)) {
            str = "百度" + dVar.kQa.forum_name + "吧";
        } else {
            str = dVar.kQa.slogan;
        }
        aVar.kPI.setText(str);
        aVar.kPL.setText("关注 " + at.numberUniformFormatExtra(dVar.kQa.member_count.intValue()));
        aVar.kPO.setText("帖子 " + at.numberUniformFormatExtra(dVar.kQa.thread_count.intValue()));
        a(aVar.kPR, dVar);
        a(dVar, aVar.kPR);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.pP(R.color.cp_cont_d);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void bY(List<com.baidu.tieba.newinterest.data.a> list) {
        this.kPo.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.kPY < i) {
            aVar.kPY++;
        } else {
            aVar.kPY = 0;
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
                    b.this.kPq = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.pP(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(bVar);
                    b.this.kPq = b.this.dbb();
                }
                if (b.this.kPp != null) {
                    b.this.kPp.ae(b.this.kPf, b.this.kPq);
                }
                aq aqVar = new aq("c13682");
                aqVar.aj("obj_type", 2);
                aqVar.aj("obj_locate", 4);
                aqVar.u("fid", dVar.kQa.forum_id.longValue());
                TiebaStatic.log(aqVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> daZ() {
        return this.kPo;
    }

    public void dba() {
        if (this.kPo != null && this.kPo.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.kPo) {
                int i = aVar.kPY;
                aVar.forum_info.get(i).selected = !this.kPq;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.kPq;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.kPq;
                a(aVar, size2);
            }
            this.kPq = this.kPq ? false : true;
            notifyDataSetChanged();
            if (this.kPp != null) {
                if (this.kPq) {
                    this.kPf = this.kPo.size() * 3;
                    this.kPp.ae(this.kPo.size() * 3, this.kPq);
                    return;
                }
                this.kPf = 0;
                this.kPp.ae(0, this.kPq);
            }
        }
    }

    public boolean dbb() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.kPo) {
            int i = aVar.kPY;
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
        if (!this.kPq) {
            aq aqVar = new aq("c13682");
            aqVar.aj("obj_type", 2);
            aqVar.aj("obj_locate", 3);
            aqVar.u("fid", aVar.forum_info.get(i).kQa.forum_id.longValue());
            TiebaStatic.log(aqVar);
        }
    }

    /* loaded from: classes23.dex */
    public static class a extends RecyclerView.ViewHolder {
        public BarImageView kPA;
        public BarImageView kPB;
        public BarImageView kPC;
        public TextView kPD;
        public TextView kPE;
        public TextView kPF;
        public TextView kPG;
        public TextView kPH;
        public TextView kPI;
        public TextView kPJ;
        public TextView kPK;
        public TextView kPL;
        public TextView kPM;
        public TextView kPN;
        public TextView kPO;
        public TBSpecificationBtn kPP;
        public TBSpecificationBtn kPQ;
        public TBSpecificationBtn kPR;
        public ImageView kPl;
        public TextView kPm;
        public TextView kPw;
        public RelativeLayout kPx;
        public RelativeLayout kPy;
        public RelativeLayout kPz;

        public a(View view) {
            super(view);
            this.kPl = (ImageView) view.findViewById(R.id.interest_icon);
            this.kPm = (TextView) view.findViewById(R.id.interest_text);
            this.kPw = (TextView) view.findViewById(R.id.interest_change);
            this.kPx = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.kPy = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.kPz = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.kPA = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.kPB = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.kPC = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.kPD = (TextView) view.findViewById(R.id.top_forum_name);
            this.kPE = (TextView) view.findViewById(R.id.middle_forum_name);
            this.kPF = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.kPG = (TextView) view.findViewById(R.id.top_forum_desc);
            this.kPH = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.kPI = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.kPJ = (TextView) view.findViewById(R.id.top_member_text);
            this.kPK = (TextView) view.findViewById(R.id.middle_member_text);
            this.kPL = (TextView) view.findViewById(R.id.bottom_member_text);
            this.kPM = (TextView) view.findViewById(R.id.top_post_text);
            this.kPN = (TextView) view.findViewById(R.id.middle_post_text);
            this.kPO = (TextView) view.findViewById(R.id.bottom_post_text);
            this.kPP = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.kPQ = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.kPR = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.kPD, R.color.cp_cont_b);
            ap.setViewTextColor(this.kPE, R.color.cp_cont_b);
            ap.setViewTextColor(this.kPF, R.color.cp_cont_b);
            ap.setViewTextColor(this.kPG, R.color.cp_cont_d);
            ap.setViewTextColor(this.kPH, R.color.cp_cont_d);
            ap.setViewTextColor(this.kPI, R.color.cp_cont_d);
            ap.setViewTextColor(this.kPJ, R.color.cp_cont_d);
            ap.setViewTextColor(this.kPK, R.color.cp_cont_d);
            ap.setViewTextColor(this.kPL, R.color.cp_cont_d);
            ap.setViewTextColor(this.kPM, R.color.cp_cont_d);
            ap.setViewTextColor(this.kPN, R.color.cp_cont_d);
            ap.setViewTextColor(this.kPO, R.color.cp_cont_d);
            ap.setViewTextColor(this.kPm, R.color.cp_cont_b);
            ap.setViewTextColor(this.kPw, R.color.cp_cont_j);
            this.kPm.setTypeface(Typeface.DEFAULT_BOLD);
            this.kPD.setTypeface(Typeface.DEFAULT_BOLD);
            this.kPE.setTypeface(Typeface.DEFAULT_BOLD);
            this.kPF.setTypeface(Typeface.DEFAULT_BOLD);
            this.kPP.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.kPQ.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.kPR.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            f(this.kPA);
            f(this.kPB);
            f(this.kPC);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.cp_border_a);
        }
    }

    public void a(InterfaceC0769b interfaceC0769b) {
        this.kPp = interfaceC0769b;
    }
}
