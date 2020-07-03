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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends RecyclerView.Adapter<a> {
    private List<com.baidu.tieba.newinterest.data.a> jTB = new ArrayList();
    private InterfaceC0691b jTC;
    private boolean jTD;
    private int jTs;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0691b {
        void aa(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.jTs;
        bVar.jTs = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.jTs;
        bVar.jTs = i + 1;
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: F */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.jTB == null) {
            return 0;
        }
        return this.jTB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.jTB.get(i);
        aVar.jTz.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.aWQ().a(aVar.jTy, com.baidu.tieba.newinterest.c.a.AO(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.jUl == 0) {
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
                    aVar2.jUl = 2;
                }
            } else {
                int i2 = aVar2.jUl;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.jTJ.setEnabled(false);
            } else {
                aVar.jTJ.setEnabled(true);
            }
            aVar.jTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.jUl));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.jUl));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.jUl));
                    b.this.jTD = b.this.cFn();
                    b.this.notifyItemChanged(i);
                    if (b.this.jTC != null) {
                        b.this.jTC.aa(b.this.jTs, b.this.jTD);
                    }
                    ao aoVar = new ao("c13682");
                    aoVar.ag("obj_type", 2);
                    aoVar.ag("obj_locate", 4);
                    aoVar.ag("obj_source", aVar2.class_id.intValue());
                    TiebaStatic.log(aoVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, d dVar) {
        String str;
        aVar.jTK.setVisibility(0);
        aVar.jTN.setVisibility(0);
        aVar.jTN.startLoad(dVar.jUn.avatar, 10, false);
        aVar.jTQ.setText(dVar.jUn.forum_name);
        if (TextUtils.isEmpty(dVar.jUn.slogan)) {
            str = "百度" + dVar.jUn.forum_name + "吧";
        } else {
            str = dVar.jUn.slogan;
        }
        aVar.jTT.setText(str);
        aVar.jTW.setText("关注 " + ar.numberUniformFormatExtra(dVar.jUn.member_count.intValue()));
        aVar.jTZ.setText("帖子 " + ar.numberUniformFormatExtra(dVar.jUn.thread_count.intValue()));
        a(aVar.jUc, dVar);
        a(dVar, aVar.jUc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.jTL.setVisibility(0);
        aVar.jTO.setVisibility(0);
        aVar.jTO.startLoad(dVar.jUn.avatar, 10, false);
        aVar.jTR.setText(dVar.jUn.forum_name);
        if (TextUtils.isEmpty(dVar.jUn.slogan)) {
            str = "百度" + dVar.jUn.forum_name + "吧";
        } else {
            str = dVar.jUn.slogan;
        }
        aVar.jTU.setText(str);
        aVar.jTX.setText("关注 " + ar.numberUniformFormatExtra(dVar.jUn.member_count.intValue()));
        aVar.jUa.setText("帖子 " + ar.numberUniformFormatExtra(dVar.jUn.thread_count.intValue()));
        a(aVar.jUd, dVar);
        a(dVar, aVar.jUd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.jTM.setVisibility(0);
        aVar.jTP.setVisibility(0);
        aVar.jTP.startLoad(dVar.jUn.avatar, 10, false);
        aVar.jTS.setText(dVar.jUn.forum_name);
        if (TextUtils.isEmpty(dVar.jUn.slogan)) {
            str = "百度" + dVar.jUn.forum_name + "吧";
        } else {
            str = dVar.jUn.slogan;
        }
        aVar.jTV.setText(str);
        aVar.jTY.setText("关注 " + ar.numberUniformFormatExtra(dVar.jUn.member_count.intValue()));
        aVar.jUb.setText("帖子 " + ar.numberUniformFormatExtra(dVar.jUn.thread_count.intValue()));
        a(aVar.jUe, dVar);
        a(dVar, aVar.jUe);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        c cVar = new c();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(cVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        cVar.mE(R.color.cp_cont_d);
        tBSpecificationBtn.setConfig(cVar);
    }

    public void bL(List<com.baidu.tieba.newinterest.data.a> list) {
        this.jTB.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.jUl < i) {
            aVar.jUl++;
        } else {
            aVar.jUl = 0;
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
                    b.this.jTD = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    cVar.mE(R.color.cp_cont_d);
                    tBSpecificationBtn.setConfig(cVar);
                    b.this.jTD = b.this.cFn();
                }
                if (b.this.jTC != null) {
                    b.this.jTC.aa(b.this.jTs, b.this.jTD);
                }
                ao aoVar = new ao("c13682");
                aoVar.ag("obj_type", 2);
                aoVar.ag("obj_locate", 4);
                aoVar.s("fid", dVar.jUn.forum_id.longValue());
                TiebaStatic.log(aoVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> cFl() {
        return this.jTB;
    }

    public void cFm() {
        if (this.jTB != null && this.jTB.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.jTB) {
                int i = aVar.jUl;
                aVar.forum_info.get(i).selected = !this.jTD;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.jTD;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.jTD;
                a(aVar, size2);
            }
            this.jTD = this.jTD ? false : true;
            notifyDataSetChanged();
            if (this.jTC != null) {
                if (this.jTD) {
                    this.jTs = this.jTB.size() * 3;
                    this.jTC.aa(this.jTB.size() * 3, this.jTD);
                    return;
                }
                this.jTs = 0;
                this.jTC.aa(0, this.jTD);
            }
        }
    }

    public boolean cFn() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.jTB) {
            int i = aVar.jUl;
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
        if (!this.jTD) {
            ao aoVar = new ao("c13682");
            aoVar.ag("obj_type", 2);
            aoVar.ag("obj_locate", 3);
            aoVar.s("fid", aVar.forum_info.get(i).jUn.forum_id.longValue());
            TiebaStatic.log(aoVar);
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends RecyclerView.ViewHolder {
        public TextView jTJ;
        public RelativeLayout jTK;
        public RelativeLayout jTL;
        public RelativeLayout jTM;
        public BarImageView jTN;
        public BarImageView jTO;
        public BarImageView jTP;
        public TextView jTQ;
        public TextView jTR;
        public TextView jTS;
        public TextView jTT;
        public TextView jTU;
        public TextView jTV;
        public TextView jTW;
        public TextView jTX;
        public TextView jTY;
        public TextView jTZ;
        public ImageView jTy;
        public TextView jTz;
        public TextView jUa;
        public TextView jUb;
        public TBSpecificationBtn jUc;
        public TBSpecificationBtn jUd;
        public TBSpecificationBtn jUe;

        public a(View view) {
            super(view);
            this.jTy = (ImageView) view.findViewById(R.id.interest_icon);
            this.jTz = (TextView) view.findViewById(R.id.interest_text);
            this.jTJ = (TextView) view.findViewById(R.id.interest_change);
            this.jTK = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.jTL = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.jTM = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.jTN = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.jTO = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.jTP = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.jTQ = (TextView) view.findViewById(R.id.top_forum_name);
            this.jTR = (TextView) view.findViewById(R.id.middle_forum_name);
            this.jTS = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.jTT = (TextView) view.findViewById(R.id.top_forum_desc);
            this.jTU = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.jTV = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.jTW = (TextView) view.findViewById(R.id.top_member_text);
            this.jTX = (TextView) view.findViewById(R.id.middle_member_text);
            this.jTY = (TextView) view.findViewById(R.id.bottom_member_text);
            this.jTZ = (TextView) view.findViewById(R.id.top_post_text);
            this.jUa = (TextView) view.findViewById(R.id.middle_post_text);
            this.jUb = (TextView) view.findViewById(R.id.bottom_post_text);
            this.jUc = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.jUd = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.jUe = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            an.setViewTextColor(this.jTQ, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.jTR, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.jTS, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.jTT, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jTU, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jTV, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jTW, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jTX, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jTY, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jTZ, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jUa, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jUb, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.jTz, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.jTJ, (int) R.color.cp_cont_j);
            this.jTz.setTypeface(Typeface.DEFAULT_BOLD);
            this.jTQ.setTypeface(Typeface.DEFAULT_BOLD);
            this.jTR.setTypeface(Typeface.DEFAULT_BOLD);
            this.jTS.setTypeface(Typeface.DEFAULT_BOLD);
            this.jUc.setConfig(new c());
            this.jUd.setConfig(new c());
            this.jUe.setConfig(new c());
            f(this.jTN);
            f(this.jTO);
            f(this.jTP);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.cp_border_a);
        }
    }

    public void a(InterfaceC0691b interfaceC0691b) {
        this.jTC = interfaceC0691b;
    }
}
