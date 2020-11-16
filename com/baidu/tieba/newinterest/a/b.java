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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class b extends RecyclerView.Adapter<a> {
    private int lhR;
    private List<com.baidu.tieba.newinterest.data.a> lia = new ArrayList();
    private InterfaceC0801b lib;
    private boolean lic;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0801b {
        void ae(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.lhR;
        bVar.lhR = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.lhR;
        bVar.lhR = i + 1;
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
        if (this.lia == null) {
            return 0;
        }
        return this.lia.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.lia.get(i);
        aVar.lhY.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.bqB().a(aVar.lhX, com.baidu.tieba.newinterest.c.a.FR(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.liK == 0) {
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
                    aVar2.liK = 2;
                }
            } else {
                int i2 = aVar2.liK;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.lii.setEnabled(false);
            } else {
                aVar.lii.setEnabled(true);
            }
            aVar.lii.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.liK));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.liK));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.liK));
                    b.this.lic = b.this.dgi();
                    b.this.notifyItemChanged(i);
                    if (b.this.lib != null) {
                        b.this.lib.ae(b.this.lhR, b.this.lic);
                    }
                    ar arVar = new ar("c13682");
                    arVar.ak("obj_type", 2);
                    arVar.ak("obj_locate", 4);
                    arVar.ak("obj_source", aVar2.class_id.intValue());
                    TiebaStatic.log(arVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, d dVar) {
        String str;
        aVar.lij.setVisibility(0);
        aVar.lim.setVisibility(0);
        aVar.lim.startLoad(dVar.liM.avatar, 10, false);
        aVar.lip.setText(dVar.liM.forum_name);
        if (TextUtils.isEmpty(dVar.liM.slogan)) {
            str = "百度" + dVar.liM.forum_name + "吧";
        } else {
            str = dVar.liM.slogan;
        }
        aVar.lis.setText(str);
        aVar.liv.setText("关注 " + au.numberUniformFormatExtra(dVar.liM.member_count.intValue()));
        aVar.liy.setText("帖子 " + au.numberUniformFormatExtra(dVar.liM.thread_count.intValue()));
        a(aVar.liB, dVar);
        a(dVar, aVar.liB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.lik.setVisibility(0);
        aVar.lin.setVisibility(0);
        aVar.lin.startLoad(dVar.liM.avatar, 10, false);
        aVar.liq.setText(dVar.liM.forum_name);
        if (TextUtils.isEmpty(dVar.liM.slogan)) {
            str = "百度" + dVar.liM.forum_name + "吧";
        } else {
            str = dVar.liM.slogan;
        }
        aVar.lit.setText(str);
        aVar.liw.setText("关注 " + au.numberUniformFormatExtra(dVar.liM.member_count.intValue()));
        aVar.liz.setText("帖子 " + au.numberUniformFormatExtra(dVar.liM.thread_count.intValue()));
        a(aVar.liC, dVar);
        a(dVar, aVar.liC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.lil.setVisibility(0);
        aVar.lio.setVisibility(0);
        aVar.lio.startLoad(dVar.liM.avatar, 10, false);
        aVar.lir.setText(dVar.liM.forum_name);
        if (TextUtils.isEmpty(dVar.liM.slogan)) {
            str = "百度" + dVar.liM.forum_name + "吧";
        } else {
            str = dVar.liM.slogan;
        }
        aVar.liu.setText(str);
        aVar.lix.setText("关注 " + au.numberUniformFormatExtra(dVar.liM.member_count.intValue()));
        aVar.liA.setText("帖子 " + au.numberUniformFormatExtra(dVar.liM.thread_count.intValue()));
        a(aVar.liD, dVar);
        a(dVar, aVar.liD);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.qI(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void cp(List<com.baidu.tieba.newinterest.data.a> list) {
        this.lia.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.liK < i) {
            aVar.liK++;
        } else {
            aVar.liK = 0;
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
                    b.this.lic = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.qI(R.color.CAM_X0109);
                    tBSpecificationBtn.setConfig(bVar);
                    b.this.lic = b.this.dgi();
                }
                if (b.this.lib != null) {
                    b.this.lib.ae(b.this.lhR, b.this.lic);
                }
                ar arVar = new ar("c13682");
                arVar.ak("obj_type", 2);
                arVar.ak("obj_locate", 4);
                arVar.w("fid", dVar.liM.forum_id.longValue());
                TiebaStatic.log(arVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> dgg() {
        return this.lia;
    }

    public void dgh() {
        if (this.lia != null && this.lia.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.lia) {
                int i = aVar.liK;
                aVar.forum_info.get(i).selected = !this.lic;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.lic;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.lic;
                a(aVar, size2);
            }
            this.lic = this.lic ? false : true;
            notifyDataSetChanged();
            if (this.lib != null) {
                if (this.lic) {
                    this.lhR = this.lia.size() * 3;
                    this.lib.ae(this.lia.size() * 3, this.lic);
                    return;
                }
                this.lhR = 0;
                this.lib.ae(0, this.lic);
            }
        }
    }

    public boolean dgi() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.lia) {
            int i = aVar.liK;
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
        if (!this.lic) {
            ar arVar = new ar("c13682");
            arVar.ak("obj_type", 2);
            arVar.ak("obj_locate", 3);
            arVar.w("fid", aVar.forum_info.get(i).liM.forum_id.longValue());
            TiebaStatic.log(arVar);
        }
    }

    /* loaded from: classes22.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView lhX;
        public TextView lhY;
        public TextView liA;
        public TBSpecificationBtn liB;
        public TBSpecificationBtn liC;
        public TBSpecificationBtn liD;
        public TextView lii;
        public RelativeLayout lij;
        public RelativeLayout lik;
        public RelativeLayout lil;
        public BarImageView lim;
        public BarImageView lin;
        public BarImageView lio;
        public TextView lip;
        public TextView liq;
        public TextView lir;
        public TextView lis;
        public TextView lit;
        public TextView liu;
        public TextView liv;
        public TextView liw;
        public TextView lix;
        public TextView liy;
        public TextView liz;

        public a(View view) {
            super(view);
            this.lhX = (ImageView) view.findViewById(R.id.interest_icon);
            this.lhY = (TextView) view.findViewById(R.id.interest_text);
            this.lii = (TextView) view.findViewById(R.id.interest_change);
            this.lij = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.lik = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.lil = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.lim = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.lin = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.lio = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.lip = (TextView) view.findViewById(R.id.top_forum_name);
            this.liq = (TextView) view.findViewById(R.id.middle_forum_name);
            this.lir = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.lis = (TextView) view.findViewById(R.id.top_forum_desc);
            this.lit = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.liu = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.liv = (TextView) view.findViewById(R.id.top_member_text);
            this.liw = (TextView) view.findViewById(R.id.middle_member_text);
            this.lix = (TextView) view.findViewById(R.id.bottom_member_text);
            this.liy = (TextView) view.findViewById(R.id.top_post_text);
            this.liz = (TextView) view.findViewById(R.id.middle_post_text);
            this.liA = (TextView) view.findViewById(R.id.bottom_post_text);
            this.liB = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.liC = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.liD = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.lip, R.color.CAM_X0105);
            ap.setViewTextColor(this.liq, R.color.CAM_X0105);
            ap.setViewTextColor(this.lir, R.color.CAM_X0105);
            ap.setViewTextColor(this.lis, R.color.CAM_X0109);
            ap.setViewTextColor(this.lit, R.color.CAM_X0109);
            ap.setViewTextColor(this.liu, R.color.CAM_X0109);
            ap.setViewTextColor(this.liv, R.color.CAM_X0109);
            ap.setViewTextColor(this.liw, R.color.CAM_X0109);
            ap.setViewTextColor(this.lix, R.color.CAM_X0109);
            ap.setViewTextColor(this.liy, R.color.CAM_X0109);
            ap.setViewTextColor(this.liz, R.color.CAM_X0109);
            ap.setViewTextColor(this.liA, R.color.CAM_X0109);
            ap.setViewTextColor(this.lhY, R.color.CAM_X0105);
            ap.setViewTextColor(this.lii, R.color.CAM_X0107);
            this.lhY.setTypeface(Typeface.DEFAULT_BOLD);
            this.lip.setTypeface(Typeface.DEFAULT_BOLD);
            this.liq.setTypeface(Typeface.DEFAULT_BOLD);
            this.lir.setTypeface(Typeface.DEFAULT_BOLD);
            this.liB.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.liC.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.liD.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            f(this.lim);
            f(this.lin);
            f(this.lio);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.CAM_X0401);
        }
    }

    public void a(InterfaceC0801b interfaceC0801b) {
        this.lib = interfaceC0801b;
    }
}
