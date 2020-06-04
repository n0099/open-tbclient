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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends RecyclerView.Adapter<a> {
    private List<com.baidu.tieba.newinterest.data.a> jAi = new ArrayList();
    private InterfaceC0676b jAj;
    private boolean jAk;
    private int jzZ;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0676b {
        void X(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.jzZ;
        bVar.jzZ = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.jzZ;
        bVar.jzZ = i + 1;
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: A */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jAi == null) {
            return 0;
        }
        return this.jAi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.jAi.get(i);
        aVar.jAg.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.aUW().a(aVar.jAf, com.baidu.tieba.newinterest.c.a.zM(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.jAS == 0) {
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
                    aVar2.jAS = 2;
                }
            } else {
                int i2 = aVar2.jAS;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.jAq.setEnabled(false);
            } else {
                aVar.jAq.setEnabled(true);
            }
            aVar.jAq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.jAS));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.jAS));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.jAS));
                    b.this.jAk = b.this.cAX();
                    b.this.notifyItemChanged(i);
                    if (b.this.jAj != null) {
                        b.this.jAj.X(b.this.jzZ, b.this.jAk);
                    }
                    an anVar = new an("c13682");
                    anVar.ag("obj_type", 2);
                    anVar.ag("obj_locate", 4);
                    anVar.ag("obj_source", aVar2.class_id.intValue());
                    TiebaStatic.log(anVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, d dVar) {
        String str;
        aVar.jAr.setVisibility(0);
        aVar.jAu.setVisibility(0);
        aVar.jAu.startLoad(dVar.jAU.avatar, 10, false);
        aVar.jAx.setText(dVar.jAU.forum_name);
        if (TextUtils.isEmpty(dVar.jAU.slogan)) {
            str = "百度" + dVar.jAU.forum_name + "吧";
        } else {
            str = dVar.jAU.slogan;
        }
        aVar.jAA.setText(str);
        aVar.jAD.setText("关注 " + aq.numberUniformFormatExtra(dVar.jAU.member_count.intValue()));
        aVar.jAG.setText("帖子 " + aq.numberUniformFormatExtra(dVar.jAU.thread_count.intValue()));
        a(aVar.jAJ, dVar);
        a(dVar, aVar.jAJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.jAs.setVisibility(0);
        aVar.jAv.setVisibility(0);
        aVar.jAv.startLoad(dVar.jAU.avatar, 10, false);
        aVar.jAy.setText(dVar.jAU.forum_name);
        if (TextUtils.isEmpty(dVar.jAU.slogan)) {
            str = "百度" + dVar.jAU.forum_name + "吧";
        } else {
            str = dVar.jAU.slogan;
        }
        aVar.jAB.setText(str);
        aVar.jAE.setText("关注 " + aq.numberUniformFormatExtra(dVar.jAU.member_count.intValue()));
        aVar.jAH.setText("帖子 " + aq.numberUniformFormatExtra(dVar.jAU.thread_count.intValue()));
        a(aVar.jAK, dVar);
        a(dVar, aVar.jAK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.jAt.setVisibility(0);
        aVar.jAw.setVisibility(0);
        aVar.jAw.startLoad(dVar.jAU.avatar, 10, false);
        aVar.jAz.setText(dVar.jAU.forum_name);
        if (TextUtils.isEmpty(dVar.jAU.slogan)) {
            str = "百度" + dVar.jAU.forum_name + "吧";
        } else {
            str = dVar.jAU.slogan;
        }
        aVar.jAC.setText(str);
        aVar.jAF.setText("关注 " + aq.numberUniformFormatExtra(dVar.jAU.member_count.intValue()));
        aVar.jAI.setText("帖子 " + aq.numberUniformFormatExtra(dVar.jAU.thread_count.intValue()));
        a(aVar.jAL, dVar);
        a(dVar, aVar.jAL);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        c cVar = new c();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(cVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        cVar.mm(R.color.cp_cont_d);
        tBSpecificationBtn.setConfig(cVar);
    }

    public void bC(List<com.baidu.tieba.newinterest.data.a> list) {
        this.jAi.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.jAS < i) {
            aVar.jAS++;
        } else {
            aVar.jAS = 0;
        }
    }

    private void a(final d dVar, final TBSpecificationBtn tBSpecificationBtn) {
        tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dVar.selected = !dVar.selected;
                c cVar = new c();
                if (!dVar.selected) {
                    b.d(b.this);
                    tBSpecificationBtn.setText("感兴趣");
                    tBSpecificationBtn.setConfig(cVar);
                    b.this.jAk = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    cVar.mm(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(cVar);
                    b.this.jAk = b.this.cAX();
                }
                if (b.this.jAj != null) {
                    b.this.jAj.X(b.this.jzZ, b.this.jAk);
                }
                an anVar = new an("c13682");
                anVar.ag("obj_type", 2);
                anVar.ag("obj_locate", 4);
                anVar.s("fid", dVar.jAU.forum_id.longValue());
                TiebaStatic.log(anVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> cAV() {
        return this.jAi;
    }

    public void cAW() {
        if (this.jAi != null && this.jAi.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.jAi) {
                int i = aVar.jAS;
                aVar.forum_info.get(i).selected = !this.jAk;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.jAk;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.jAk;
                a(aVar, size2);
            }
            this.jAk = this.jAk ? false : true;
            notifyDataSetChanged();
            if (this.jAj != null) {
                if (this.jAk) {
                    this.jzZ = this.jAi.size() * 3;
                    this.jAj.X(this.jAi.size() * 3, this.jAk);
                    return;
                }
                this.jzZ = 0;
                this.jAj.X(0, this.jAk);
            }
        }
    }

    public boolean cAX() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.jAi) {
            int i = aVar.jAS;
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
        if (!this.jAk) {
            an anVar = new an("c13682");
            anVar.ag("obj_type", 2);
            anVar.ag("obj_locate", 3);
            anVar.s("fid", aVar.forum_info.get(i).jAU.forum_id.longValue());
            TiebaStatic.log(anVar);
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends RecyclerView.ViewHolder {
        public TextView jAA;
        public TextView jAB;
        public TextView jAC;
        public TextView jAD;
        public TextView jAE;
        public TextView jAF;
        public TextView jAG;
        public TextView jAH;
        public TextView jAI;
        public TBSpecificationBtn jAJ;
        public TBSpecificationBtn jAK;
        public TBSpecificationBtn jAL;
        public ImageView jAf;
        public TextView jAg;
        public TextView jAq;
        public RelativeLayout jAr;
        public RelativeLayout jAs;
        public RelativeLayout jAt;
        public BarImageView jAu;
        public BarImageView jAv;
        public BarImageView jAw;
        public TextView jAx;
        public TextView jAy;
        public TextView jAz;

        public a(View view) {
            super(view);
            this.jAf = (ImageView) view.findViewById(R.id.interest_icon);
            this.jAg = (TextView) view.findViewById(R.id.interest_text);
            this.jAq = (TextView) view.findViewById(R.id.interest_change);
            this.jAr = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.jAs = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.jAt = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.jAu = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.jAv = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.jAw = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.jAx = (TextView) view.findViewById(R.id.top_forum_name);
            this.jAy = (TextView) view.findViewById(R.id.middle_forum_name);
            this.jAz = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.jAA = (TextView) view.findViewById(R.id.top_forum_desc);
            this.jAB = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.jAC = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.jAD = (TextView) view.findViewById(R.id.top_member_text);
            this.jAE = (TextView) view.findViewById(R.id.middle_member_text);
            this.jAF = (TextView) view.findViewById(R.id.bottom_member_text);
            this.jAG = (TextView) view.findViewById(R.id.top_post_text);
            this.jAH = (TextView) view.findViewById(R.id.middle_post_text);
            this.jAI = (TextView) view.findViewById(R.id.bottom_post_text);
            this.jAJ = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.jAK = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.jAL = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            am.setViewTextColor(this.jAx, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jAy, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jAz, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jAA, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jAB, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jAC, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jAD, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jAE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jAF, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jAG, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jAH, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jAI, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jAg, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jAq, (int) R.color.cp_cont_j);
            this.jAg.setTypeface(Typeface.DEFAULT_BOLD);
            this.jAx.setTypeface(Typeface.DEFAULT_BOLD);
            this.jAy.setTypeface(Typeface.DEFAULT_BOLD);
            this.jAz.setTypeface(Typeface.DEFAULT_BOLD);
            this.jAJ.setConfig(new c());
            this.jAK.setConfig(new c());
            this.jAL.setConfig(new c());
            f(this.jAu);
            f(this.jAv);
            f(this.jAw);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.cp_border_a);
        }
    }

    public void a(InterfaceC0676b interfaceC0676b) {
        this.jAj = interfaceC0676b;
    }
}
