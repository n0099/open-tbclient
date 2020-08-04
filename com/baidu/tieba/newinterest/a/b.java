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
    private int kbT;
    private List<com.baidu.tieba.newinterest.data.a> kcc = new ArrayList();
    private InterfaceC0703b kcd;
    private boolean kce;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC0703b {
        void Z(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.kbT;
        bVar.kbT = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.kbT;
        bVar.kbT = i + 1;
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
        if (this.kcc == null) {
            return 0;
        }
        return this.kcc.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.kcc.get(i);
        aVar.kca.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.baR().a(aVar.kbZ, com.baidu.tieba.newinterest.c.a.Bn(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.kcM == 0) {
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
                    aVar2.kcM = 2;
                }
            } else {
                int i2 = aVar2.kcM;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.kck.setEnabled(false);
            } else {
                aVar.kck.setEnabled(true);
            }
            aVar.kck.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.kcM));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.kcM));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.kcM));
                    b.this.kce = b.this.cIX();
                    b.this.notifyItemChanged(i);
                    if (b.this.kcd != null) {
                        b.this.kcd.Z(b.this.kbT, b.this.kce);
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
        aVar.kcl.setVisibility(0);
        aVar.kco.setVisibility(0);
        aVar.kco.startLoad(dVar.kcO.avatar, 10, false);
        aVar.kcr.setText(dVar.kcO.forum_name);
        if (TextUtils.isEmpty(dVar.kcO.slogan)) {
            str = "百度" + dVar.kcO.forum_name + "吧";
        } else {
            str = dVar.kcO.slogan;
        }
        aVar.kcu.setText(str);
        aVar.kcx.setText("关注 " + as.numberUniformFormatExtra(dVar.kcO.member_count.intValue()));
        aVar.kcA.setText("帖子 " + as.numberUniformFormatExtra(dVar.kcO.thread_count.intValue()));
        a(aVar.kcD, dVar);
        a(dVar, aVar.kcD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.kcm.setVisibility(0);
        aVar.kcp.setVisibility(0);
        aVar.kcp.startLoad(dVar.kcO.avatar, 10, false);
        aVar.kcs.setText(dVar.kcO.forum_name);
        if (TextUtils.isEmpty(dVar.kcO.slogan)) {
            str = "百度" + dVar.kcO.forum_name + "吧";
        } else {
            str = dVar.kcO.slogan;
        }
        aVar.kcv.setText(str);
        aVar.kcy.setText("关注 " + as.numberUniformFormatExtra(dVar.kcO.member_count.intValue()));
        aVar.kcB.setText("帖子 " + as.numberUniformFormatExtra(dVar.kcO.thread_count.intValue()));
        a(aVar.kcE, dVar);
        a(dVar, aVar.kcE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.kcn.setVisibility(0);
        aVar.kcq.setVisibility(0);
        aVar.kcq.startLoad(dVar.kcO.avatar, 10, false);
        aVar.kct.setText(dVar.kcO.forum_name);
        if (TextUtils.isEmpty(dVar.kcO.slogan)) {
            str = "百度" + dVar.kcO.forum_name + "吧";
        } else {
            str = dVar.kcO.slogan;
        }
        aVar.kcw.setText(str);
        aVar.kcz.setText("关注 " + as.numberUniformFormatExtra(dVar.kcO.member_count.intValue()));
        aVar.kcC.setText("帖子 " + as.numberUniformFormatExtra(dVar.kcO.thread_count.intValue()));
        a(aVar.kcF, dVar);
        a(dVar, aVar.kcF);
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
        this.kcc.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.kcM < i) {
            aVar.kcM++;
        } else {
            aVar.kcM = 0;
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
                    b.this.kce = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    cVar.mX(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(cVar);
                    b.this.kce = b.this.cIX();
                }
                if (b.this.kcd != null) {
                    b.this.kcd.Z(b.this.kbT, b.this.kce);
                }
                ap apVar = new ap("c13682");
                apVar.ah("obj_type", 2);
                apVar.ah("obj_locate", 4);
                apVar.t("fid", dVar.kcO.forum_id.longValue());
                TiebaStatic.log(apVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> cIV() {
        return this.kcc;
    }

    public void cIW() {
        if (this.kcc != null && this.kcc.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.kcc) {
                int i = aVar.kcM;
                aVar.forum_info.get(i).selected = !this.kce;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.kce;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.kce;
                a(aVar, size2);
            }
            this.kce = this.kce ? false : true;
            notifyDataSetChanged();
            if (this.kcd != null) {
                if (this.kce) {
                    this.kbT = this.kcc.size() * 3;
                    this.kcd.Z(this.kcc.size() * 3, this.kce);
                    return;
                }
                this.kbT = 0;
                this.kcd.Z(0, this.kce);
            }
        }
    }

    public boolean cIX() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.kcc) {
            int i = aVar.kcM;
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
        if (!this.kce) {
            ap apVar = new ap("c13682");
            apVar.ah("obj_type", 2);
            apVar.ah("obj_locate", 3);
            apVar.t("fid", aVar.forum_info.get(i).kcO.forum_id.longValue());
            TiebaStatic.log(apVar);
        }
    }

    /* loaded from: classes17.dex */
    public static class a extends RecyclerView.ViewHolder {
        public ImageView kbZ;
        public TextView kcA;
        public TextView kcB;
        public TextView kcC;
        public TBSpecificationBtn kcD;
        public TBSpecificationBtn kcE;
        public TBSpecificationBtn kcF;
        public TextView kca;
        public TextView kck;
        public RelativeLayout kcl;
        public RelativeLayout kcm;
        public RelativeLayout kcn;
        public BarImageView kco;
        public BarImageView kcp;
        public BarImageView kcq;
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
            this.kbZ = (ImageView) view.findViewById(R.id.interest_icon);
            this.kca = (TextView) view.findViewById(R.id.interest_text);
            this.kck = (TextView) view.findViewById(R.id.interest_change);
            this.kcl = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.kcm = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.kcn = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.kco = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.kcp = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.kcq = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.kcr = (TextView) view.findViewById(R.id.top_forum_name);
            this.kcs = (TextView) view.findViewById(R.id.middle_forum_name);
            this.kct = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.kcu = (TextView) view.findViewById(R.id.top_forum_desc);
            this.kcv = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.kcw = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.kcx = (TextView) view.findViewById(R.id.top_member_text);
            this.kcy = (TextView) view.findViewById(R.id.middle_member_text);
            this.kcz = (TextView) view.findViewById(R.id.bottom_member_text);
            this.kcA = (TextView) view.findViewById(R.id.top_post_text);
            this.kcB = (TextView) view.findViewById(R.id.middle_post_text);
            this.kcC = (TextView) view.findViewById(R.id.bottom_post_text);
            this.kcD = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.kcE = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.kcF = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ao.setViewTextColor(this.kcr, R.color.cp_cont_b);
            ao.setViewTextColor(this.kcs, R.color.cp_cont_b);
            ao.setViewTextColor(this.kct, R.color.cp_cont_b);
            ao.setViewTextColor(this.kcu, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcv, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcw, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcx, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcy, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcz, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcA, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcB, R.color.cp_cont_d);
            ao.setViewTextColor(this.kcC, R.color.cp_cont_d);
            ao.setViewTextColor(this.kca, R.color.cp_cont_b);
            ao.setViewTextColor(this.kck, R.color.cp_cont_j);
            this.kca.setTypeface(Typeface.DEFAULT_BOLD);
            this.kcr.setTypeface(Typeface.DEFAULT_BOLD);
            this.kcs.setTypeface(Typeface.DEFAULT_BOLD);
            this.kct.setTypeface(Typeface.DEFAULT_BOLD);
            this.kcD.setConfig(new c());
            this.kcE.setConfig(new c());
            this.kcF.setConfig(new c());
            f(this.kco);
            f(this.kcp);
            f(this.kcq);
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
        this.kcd = interfaceC0703b;
    }
}
