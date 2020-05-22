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
    private int jyT;
    private List<com.baidu.tieba.newinterest.data.a> jzc = new ArrayList();
    private InterfaceC0675b jzd;
    private boolean jze;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0675b {
        void X(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.jyT;
        bVar.jyT = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.jyT;
        bVar.jyT = i + 1;
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: z */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jzc == null) {
            return 0;
        }
        return this.jzc.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.jzc.get(i);
        aVar.jza.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.aUV().a(aVar.jyZ, com.baidu.tieba.newinterest.c.a.zK(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.jzM == 0) {
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
                    aVar2.jzM = 2;
                }
            } else {
                int i2 = aVar2.jzM;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.jzk.setEnabled(false);
            } else {
                aVar.jzk.setEnabled(true);
            }
            aVar.jzk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.jzM));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.jzM));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.jzM));
                    b.this.jze = b.this.cAG();
                    b.this.notifyItemChanged(i);
                    if (b.this.jzd != null) {
                        b.this.jzd.X(b.this.jyT, b.this.jze);
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
        aVar.jzl.setVisibility(0);
        aVar.jzo.setVisibility(0);
        aVar.jzo.startLoad(dVar.jzO.avatar, 10, false);
        aVar.jzr.setText(dVar.jzO.forum_name);
        if (TextUtils.isEmpty(dVar.jzO.slogan)) {
            str = "百度" + dVar.jzO.forum_name + "吧";
        } else {
            str = dVar.jzO.slogan;
        }
        aVar.jzu.setText(str);
        aVar.jzx.setText("关注 " + aq.numberUniformFormatExtra(dVar.jzO.member_count.intValue()));
        aVar.jzA.setText("帖子 " + aq.numberUniformFormatExtra(dVar.jzO.thread_count.intValue()));
        a(aVar.jzD, dVar);
        a(dVar, aVar.jzD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.jzm.setVisibility(0);
        aVar.jzp.setVisibility(0);
        aVar.jzp.startLoad(dVar.jzO.avatar, 10, false);
        aVar.jzs.setText(dVar.jzO.forum_name);
        if (TextUtils.isEmpty(dVar.jzO.slogan)) {
            str = "百度" + dVar.jzO.forum_name + "吧";
        } else {
            str = dVar.jzO.slogan;
        }
        aVar.jzv.setText(str);
        aVar.jzy.setText("关注 " + aq.numberUniformFormatExtra(dVar.jzO.member_count.intValue()));
        aVar.jzB.setText("帖子 " + aq.numberUniformFormatExtra(dVar.jzO.thread_count.intValue()));
        a(aVar.jzE, dVar);
        a(dVar, aVar.jzE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.jzn.setVisibility(0);
        aVar.jzq.setVisibility(0);
        aVar.jzq.startLoad(dVar.jzO.avatar, 10, false);
        aVar.jzt.setText(dVar.jzO.forum_name);
        if (TextUtils.isEmpty(dVar.jzO.slogan)) {
            str = "百度" + dVar.jzO.forum_name + "吧";
        } else {
            str = dVar.jzO.slogan;
        }
        aVar.jzw.setText(str);
        aVar.jzz.setText("关注 " + aq.numberUniformFormatExtra(dVar.jzO.member_count.intValue()));
        aVar.jzC.setText("帖子 " + aq.numberUniformFormatExtra(dVar.jzO.thread_count.intValue()));
        a(aVar.jzF, dVar);
        a(dVar, aVar.jzF);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        c cVar = new c();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(cVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        cVar.mk(R.color.cp_cont_d);
        tBSpecificationBtn.setConfig(cVar);
    }

    public void bC(List<com.baidu.tieba.newinterest.data.a> list) {
        this.jzc.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.jzM < i) {
            aVar.jzM++;
        } else {
            aVar.jzM = 0;
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
                    b.this.jze = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    cVar.mk(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(cVar);
                    b.this.jze = b.this.cAG();
                }
                if (b.this.jzd != null) {
                    b.this.jzd.X(b.this.jyT, b.this.jze);
                }
                an anVar = new an("c13682");
                anVar.ag("obj_type", 2);
                anVar.ag("obj_locate", 4);
                anVar.s("fid", dVar.jzO.forum_id.longValue());
                TiebaStatic.log(anVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> cAE() {
        return this.jzc;
    }

    public void cAF() {
        if (this.jzc != null && this.jzc.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.jzc) {
                int i = aVar.jzM;
                aVar.forum_info.get(i).selected = !this.jze;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.jze;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.jze;
                a(aVar, size2);
            }
            this.jze = this.jze ? false : true;
            notifyDataSetChanged();
            if (this.jzd != null) {
                if (this.jze) {
                    this.jyT = this.jzc.size() * 3;
                    this.jzd.X(this.jzc.size() * 3, this.jze);
                    return;
                }
                this.jyT = 0;
                this.jzd.X(0, this.jze);
            }
        }
    }

    public boolean cAG() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.jzc) {
            int i = aVar.jzM;
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
        if (!this.jze) {
            an anVar = new an("c13682");
            anVar.ag("obj_type", 2);
            anVar.ag("obj_locate", 3);
            anVar.s("fid", aVar.forum_info.get(i).jzO.forum_id.longValue());
            TiebaStatic.log(anVar);
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView jyZ;
        public TextView jzA;
        public TextView jzB;
        public TextView jzC;
        public TBSpecificationBtn jzD;
        public TBSpecificationBtn jzE;
        public TBSpecificationBtn jzF;
        public TextView jza;
        public TextView jzk;
        public RelativeLayout jzl;
        public RelativeLayout jzm;
        public RelativeLayout jzn;
        public BarImageView jzo;
        public BarImageView jzp;
        public BarImageView jzq;
        public TextView jzr;
        public TextView jzs;
        public TextView jzt;
        public TextView jzu;
        public TextView jzv;
        public TextView jzw;
        public TextView jzx;
        public TextView jzy;
        public TextView jzz;

        public a(View view) {
            super(view);
            this.jyZ = (ImageView) view.findViewById(R.id.interest_icon);
            this.jza = (TextView) view.findViewById(R.id.interest_text);
            this.jzk = (TextView) view.findViewById(R.id.interest_change);
            this.jzl = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.jzm = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.jzn = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.jzo = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.jzp = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.jzq = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.jzr = (TextView) view.findViewById(R.id.top_forum_name);
            this.jzs = (TextView) view.findViewById(R.id.middle_forum_name);
            this.jzt = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.jzu = (TextView) view.findViewById(R.id.top_forum_desc);
            this.jzv = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.jzw = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.jzx = (TextView) view.findViewById(R.id.top_member_text);
            this.jzy = (TextView) view.findViewById(R.id.middle_member_text);
            this.jzz = (TextView) view.findViewById(R.id.bottom_member_text);
            this.jzA = (TextView) view.findViewById(R.id.top_post_text);
            this.jzB = (TextView) view.findViewById(R.id.middle_post_text);
            this.jzC = (TextView) view.findViewById(R.id.bottom_post_text);
            this.jzD = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.jzE = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.jzF = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            am.setViewTextColor(this.jzr, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jzs, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jzt, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jzu, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jzv, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jzw, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jzx, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jzy, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jzz, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jzA, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jzB, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jzC, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.jza, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.jzk, (int) R.color.cp_cont_j);
            this.jza.setTypeface(Typeface.DEFAULT_BOLD);
            this.jzr.setTypeface(Typeface.DEFAULT_BOLD);
            this.jzs.setTypeface(Typeface.DEFAULT_BOLD);
            this.jzt.setTypeface(Typeface.DEFAULT_BOLD);
            this.jzD.setConfig(new c());
            this.jzE.setConfig(new c());
            this.jzF.setConfig(new c());
            f(this.jzo);
            f(this.jzp);
            f(this.jzq);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.cp_border_a);
        }
    }

    public void a(InterfaceC0675b interfaceC0675b) {
        this.jzd = interfaceC0675b;
    }
}
