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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class b extends RecyclerView.Adapter<a> {
    private int kbR;
    private List<com.baidu.tieba.newinterest.data.a> kca = new ArrayList();
    private InterfaceC0703b kcb;
    private boolean kcc;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC0703b {
        void Z(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.kbR;
        bVar.kbR = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.kbR;
        bVar.kbR = i + 1;
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
        if (this.kca == null) {
            return 0;
        }
        return this.kca.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.kca.get(i);
        aVar.kbY.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.baR().a(aVar.kbX, com.baidu.tieba.newinterest.c.a.Bn(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.kcK == 0) {
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
                    aVar2.kcK = 2;
                }
            } else {
                int i2 = aVar2.kcK;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.kci.setEnabled(false);
            } else {
                aVar.kci.setEnabled(true);
            }
            aVar.kci.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.kcK));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.kcK));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.kcK));
                    b.this.kcc = b.this.cIX();
                    b.this.notifyItemChanged(i);
                    if (b.this.kcb != null) {
                        b.this.kcb.Z(b.this.kbR, b.this.kcc);
                    }
                    ap apVar = new ap("c13682");
                    apVar.ah("obj_type", 2);
                    apVar.ah("obj_locate", 4);
                    apVar.ah("obj_source", aVar2.class_id.intValue());
                    TiebaStatic.log(apVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, d dVar) {
        String str;
        aVar.kcj.setVisibility(0);
        aVar.kcm.setVisibility(0);
        aVar.kcm.startLoad(dVar.kcM.avatar, 10, false);
        aVar.kcp.setText(dVar.kcM.forum_name);
        if (TextUtils.isEmpty(dVar.kcM.slogan)) {
            str = "百度" + dVar.kcM.forum_name + "吧";
        } else {
            str = dVar.kcM.slogan;
        }
        aVar.kcs.setText(str);
        aVar.kcv.setText("关注 " + as.numberUniformFormatExtra(dVar.kcM.member_count.intValue()));
        aVar.kcy.setText("帖子 " + as.numberUniformFormatExtra(dVar.kcM.thread_count.intValue()));
        a(aVar.kcB, dVar);
        a(dVar, aVar.kcB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.kck.setVisibility(0);
        aVar.kcn.setVisibility(0);
        aVar.kcn.startLoad(dVar.kcM.avatar, 10, false);
        aVar.kcq.setText(dVar.kcM.forum_name);
        if (TextUtils.isEmpty(dVar.kcM.slogan)) {
            str = "百度" + dVar.kcM.forum_name + "吧";
        } else {
            str = dVar.kcM.slogan;
        }
        aVar.kct.setText(str);
        aVar.kcw.setText("关注 " + as.numberUniformFormatExtra(dVar.kcM.member_count.intValue()));
        aVar.kcz.setText("帖子 " + as.numberUniformFormatExtra(dVar.kcM.thread_count.intValue()));
        a(aVar.kcC, dVar);
        a(dVar, aVar.kcC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.kcl.setVisibility(0);
        aVar.kco.setVisibility(0);
        aVar.kco.startLoad(dVar.kcM.avatar, 10, false);
        aVar.kcr.setText(dVar.kcM.forum_name);
        if (TextUtils.isEmpty(dVar.kcM.slogan)) {
            str = "百度" + dVar.kcM.forum_name + "吧";
        } else {
            str = dVar.kcM.slogan;
        }
        aVar.kcu.setText(str);
        aVar.kcx.setText("关注 " + as.numberUniformFormatExtra(dVar.kcM.member_count.intValue()));
        aVar.kcA.setText("帖子 " + as.numberUniformFormatExtra(dVar.kcM.thread_count.intValue()));
        a(aVar.kcD, dVar);
        a(dVar, aVar.kcD);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        c cVar = new c();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(cVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        cVar.mX(R.color.cp_cont_d);
        tBSpecificationBtn.setConfig(cVar);
    }

    public void bP(List<com.baidu.tieba.newinterest.data.a> list) {
        this.kca.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.kcK < i) {
            aVar.kcK++;
        } else {
            aVar.kcK = 0;
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
                    b.this.kcc = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    cVar.mX(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(cVar);
                    b.this.kcc = b.this.cIX();
                }
                if (b.this.kcb != null) {
                    b.this.kcb.Z(b.this.kbR, b.this.kcc);
                }
                ap apVar = new ap("c13682");
                apVar.ah("obj_type", 2);
                apVar.ah("obj_locate", 4);
                apVar.t("fid", dVar.kcM.forum_id.longValue());
                TiebaStatic.log(apVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> cIV() {
        return this.kca;
    }

    public void cIW() {
        if (this.kca != null && this.kca.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.kca) {
                int i = aVar.kcK;
                aVar.forum_info.get(i).selected = !this.kcc;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.kcc;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.kcc;
                a(aVar, size2);
            }
            this.kcc = this.kcc ? false : true;
            notifyDataSetChanged();
            if (this.kcb != null) {
                if (this.kcc) {
                    this.kbR = this.kca.size() * 3;
                    this.kcb.Z(this.kca.size() * 3, this.kcc);
                    return;
                }
                this.kbR = 0;
                this.kcb.Z(0, this.kcc);
            }
        }
    }

    public boolean cIX() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.kca) {
            int i = aVar.kcK;
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
        if (!this.kcc) {
            ap apVar = new ap("c13682");
            apVar.ah("obj_type", 2);
            apVar.ah("obj_locate", 3);
            apVar.t("fid", aVar.forum_info.get(i).kcM.forum_id.longValue());
            TiebaStatic.log(apVar);
        }
    }

    /* loaded from: classes17.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView kbX;
        public TextView kbY;
        public TextView kcA;
        public TBSpecificationBtn kcB;
        public TBSpecificationBtn kcC;
        public TBSpecificationBtn kcD;
        public TextView kci;
        public RelativeLayout kcj;
        public RelativeLayout kck;
        public RelativeLayout kcl;
        public BarImageView kcm;
        public BarImageView kcn;
        public BarImageView kco;
        public TextView kcp;
        public TextView kcq;
        public TextView kcr;
        public TextView kcs;
        public TextView kct;
        public TextView kcu;
        public TextView kcv;
        public TextView kcw;
        public TextView kcx;
        public TextView kcy;
        public TextView kcz;

        public a(View view) {
            super(view);
            this.kbX = (ImageView) view.findViewById(R.id.interest_icon);
            this.kbY = (TextView) view.findViewById(R.id.interest_text);
            this.kci = (TextView) view.findViewById(R.id.interest_change);
            this.kcj = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.kck = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.kcl = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.kcm = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.kcn = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.kco = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.kcp = (TextView) view.findViewById(R.id.top_forum_name);
            this.kcq = (TextView) view.findViewById(R.id.middle_forum_name);
            this.kcr = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.kcs = (TextView) view.findViewById(R.id.top_forum_desc);
            this.kct = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.kcu = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.kcv = (TextView) view.findViewById(R.id.top_member_text);
            this.kcw = (TextView) view.findViewById(R.id.middle_member_text);
            this.kcx = (TextView) view.findViewById(R.id.bottom_member_text);
            this.kcy = (TextView) view.findViewById(R.id.top_post_text);
            this.kcz = (TextView) view.findViewById(R.id.middle_post_text);
            this.kcA = (TextView) view.findViewById(R.id.bottom_post_text);
            this.kcB = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.kcC = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.kcD = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ao.setViewTextColor(this.kcp, R.color.cp_cont_b);
            ao.setViewTextColor(this.kcq, R.color.cp_cont_b);
            ao.setViewTextColor(this.kcr, R.color.cp_cont_b);
            ao.setViewTextColor(this.kcs, R.color.cp_cont_d);
            ao.setViewTextColor(this.kct, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcu, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcv, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcw, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcx, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcy, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcz, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcA, R.color.cp_cont_d);
            ao.setViewTextColor(this.kbY, R.color.cp_cont_b);
            ao.setViewTextColor(this.kci, R.color.cp_cont_j);
            this.kbY.setTypeface(Typeface.DEFAULT_BOLD);
            this.kcp.setTypeface(Typeface.DEFAULT_BOLD);
            this.kcq.setTypeface(Typeface.DEFAULT_BOLD);
            this.kcr.setTypeface(Typeface.DEFAULT_BOLD);
            this.kcB.setConfig(new c());
            this.kcC.setConfig(new c());
            this.kcD.setConfig(new c());
            f(this.kcm);
            f(this.kcn);
            f(this.kco);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.cp_border_a);
        }
    }

    public void a(InterfaceC0703b interfaceC0703b) {
        this.kcb = interfaceC0703b;
    }
}
