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
/* loaded from: classes23.dex */
public class b extends RecyclerView.Adapter<a> {
    private List<com.baidu.tieba.newinterest.data.a> lvB = new ArrayList();
    private InterfaceC0817b lvC;
    private boolean lvD;
    private int lvs;

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0817b {
        void ae(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.lvs;
        bVar.lvs = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.lvs;
        bVar.lvs = i + 1;
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
        if (this.lvB == null) {
            return 0;
        }
        return this.lvB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.lvB.get(i);
        aVar.lvz.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.btW().a(aVar.lvy, com.baidu.tieba.newinterest.c.a.GG(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.lwl == 0) {
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
                    aVar2.lwl = 2;
                }
            } else {
                int i2 = aVar2.lwl;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.lvJ.setEnabled(false);
            } else {
                aVar.lvJ.setEnabled(true);
            }
            aVar.lvJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.lwl));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.lwl));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.lwl));
                    b.this.lvD = b.this.dlv();
                    b.this.notifyItemChanged(i);
                    if (b.this.lvC != null) {
                        b.this.lvC.ae(b.this.lvs, b.this.lvD);
                    }
                    ar arVar = new ar("c13682");
                    arVar.al("obj_type", 2);
                    arVar.al("obj_locate", 4);
                    arVar.al("obj_source", aVar2.class_id.intValue());
                    TiebaStatic.log(arVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar, d dVar) {
        String str;
        aVar.lvK.setVisibility(0);
        aVar.lvN.setVisibility(0);
        aVar.lvN.startLoad(dVar.lwn.avatar, 10, false);
        aVar.lvQ.setText(dVar.lwn.forum_name);
        if (TextUtils.isEmpty(dVar.lwn.slogan)) {
            str = "百度" + dVar.lwn.forum_name + "吧";
        } else {
            str = dVar.lwn.slogan;
        }
        aVar.lvT.setText(str);
        aVar.lvW.setText("关注 " + au.numberUniformFormatExtra(dVar.lwn.member_count.intValue()));
        aVar.lvZ.setText("帖子 " + au.numberUniformFormatExtra(dVar.lwn.thread_count.intValue()));
        a(aVar.lwc, dVar);
        a(dVar, aVar.lwc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.lvL.setVisibility(0);
        aVar.lvO.setVisibility(0);
        aVar.lvO.startLoad(dVar.lwn.avatar, 10, false);
        aVar.lvR.setText(dVar.lwn.forum_name);
        if (TextUtils.isEmpty(dVar.lwn.slogan)) {
            str = "百度" + dVar.lwn.forum_name + "吧";
        } else {
            str = dVar.lwn.slogan;
        }
        aVar.lvU.setText(str);
        aVar.lvX.setText("关注 " + au.numberUniformFormatExtra(dVar.lwn.member_count.intValue()));
        aVar.lwa.setText("帖子 " + au.numberUniformFormatExtra(dVar.lwn.thread_count.intValue()));
        a(aVar.lwd, dVar);
        a(dVar, aVar.lwd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.lvM.setVisibility(0);
        aVar.lvP.setVisibility(0);
        aVar.lvP.startLoad(dVar.lwn.avatar, 10, false);
        aVar.lvS.setText(dVar.lwn.forum_name);
        if (TextUtils.isEmpty(dVar.lwn.slogan)) {
            str = "百度" + dVar.lwn.forum_name + "吧";
        } else {
            str = dVar.lwn.slogan;
        }
        aVar.lvV.setText(str);
        aVar.lvY.setText("关注 " + au.numberUniformFormatExtra(dVar.lwn.member_count.intValue()));
        aVar.lwb.setText("帖子 " + au.numberUniformFormatExtra(dVar.lwn.thread_count.intValue()));
        a(aVar.lwe, dVar);
        a(dVar, aVar.lwe);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.rj(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void ct(List<com.baidu.tieba.newinterest.data.a> list) {
        this.lvB.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.lwl < i) {
            aVar.lwl++;
        } else {
            aVar.lwl = 0;
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
                    b.this.lvD = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.rj(R.color.CAM_X0109);
                    tBSpecificationBtn.setConfig(bVar);
                    b.this.lvD = b.this.dlv();
                }
                if (b.this.lvC != null) {
                    b.this.lvC.ae(b.this.lvs, b.this.lvD);
                }
                ar arVar = new ar("c13682");
                arVar.al("obj_type", 2);
                arVar.al("obj_locate", 4);
                arVar.w("fid", dVar.lwn.forum_id.longValue());
                TiebaStatic.log(arVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> dlt() {
        return this.lvB;
    }

    public void dlu() {
        if (this.lvB != null && this.lvB.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.lvB) {
                int i = aVar.lwl;
                aVar.forum_info.get(i).selected = !this.lvD;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.lvD;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.lvD;
                a(aVar, size2);
            }
            this.lvD = this.lvD ? false : true;
            notifyDataSetChanged();
            if (this.lvC != null) {
                if (this.lvD) {
                    this.lvs = this.lvB.size() * 3;
                    this.lvC.ae(this.lvB.size() * 3, this.lvD);
                    return;
                }
                this.lvs = 0;
                this.lvC.ae(0, this.lvD);
            }
        }
    }

    public boolean dlv() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.lvB) {
            int i = aVar.lwl;
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
        if (!this.lvD) {
            ar arVar = new ar("c13682");
            arVar.al("obj_type", 2);
            arVar.al("obj_locate", 3);
            arVar.w("fid", aVar.forum_info.get(i).lwn.forum_id.longValue());
            TiebaStatic.log(arVar);
        }
    }

    /* loaded from: classes23.dex */
    public static class a extends RecyclerView.ViewHolder {
        public TextView lvJ;
        public RelativeLayout lvK;
        public RelativeLayout lvL;
        public RelativeLayout lvM;
        public BarImageView lvN;
        public BarImageView lvO;
        public BarImageView lvP;
        public TextView lvQ;
        public TextView lvR;
        public TextView lvS;
        public TextView lvT;
        public TextView lvU;
        public TextView lvV;
        public TextView lvW;
        public TextView lvX;
        public TextView lvY;
        public TextView lvZ;
        public ImageView lvy;
        public TextView lvz;
        public TextView lwa;
        public TextView lwb;
        public TBSpecificationBtn lwc;
        public TBSpecificationBtn lwd;
        public TBSpecificationBtn lwe;

        public a(View view) {
            super(view);
            this.lvy = (ImageView) view.findViewById(R.id.interest_icon);
            this.lvz = (TextView) view.findViewById(R.id.interest_text);
            this.lvJ = (TextView) view.findViewById(R.id.interest_change);
            this.lvK = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.lvL = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.lvM = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.lvN = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.lvO = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.lvP = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.lvQ = (TextView) view.findViewById(R.id.top_forum_name);
            this.lvR = (TextView) view.findViewById(R.id.middle_forum_name);
            this.lvS = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.lvT = (TextView) view.findViewById(R.id.top_forum_desc);
            this.lvU = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.lvV = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.lvW = (TextView) view.findViewById(R.id.top_member_text);
            this.lvX = (TextView) view.findViewById(R.id.middle_member_text);
            this.lvY = (TextView) view.findViewById(R.id.bottom_member_text);
            this.lvZ = (TextView) view.findViewById(R.id.top_post_text);
            this.lwa = (TextView) view.findViewById(R.id.middle_post_text);
            this.lwb = (TextView) view.findViewById(R.id.bottom_post_text);
            this.lwc = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.lwd = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.lwe = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.lvQ, R.color.CAM_X0105);
            ap.setViewTextColor(this.lvR, R.color.CAM_X0105);
            ap.setViewTextColor(this.lvS, R.color.CAM_X0105);
            ap.setViewTextColor(this.lvT, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvU, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvV, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvW, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvX, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvY, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvZ, R.color.CAM_X0109);
            ap.setViewTextColor(this.lwa, R.color.CAM_X0109);
            ap.setViewTextColor(this.lwb, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvz, R.color.CAM_X0105);
            ap.setViewTextColor(this.lvJ, R.color.CAM_X0107);
            this.lvz.setTypeface(Typeface.DEFAULT_BOLD);
            this.lvQ.setTypeface(Typeface.DEFAULT_BOLD);
            this.lvR.setTypeface(Typeface.DEFAULT_BOLD);
            this.lvS.setTypeface(Typeface.DEFAULT_BOLD);
            this.lwc.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.lwd.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.lwe.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            f(this.lvN);
            f(this.lvO);
            f(this.lvP);
        }

        private void f(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.CAM_X0401);
        }
    }

    public void a(InterfaceC0817b interfaceC0817b) {
        this.lvC = interfaceC0817b;
    }
}
