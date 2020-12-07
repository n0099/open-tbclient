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
    private InterfaceC0817b lvA;
    private boolean lvB;
    private int lvq;
    private List<com.baidu.tieba.newinterest.data.a> lvz = new ArrayList();

    /* renamed from: com.baidu.tieba.newinterest.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0817b {
        void ae(int i, boolean z);
    }

    static /* synthetic */ int d(b bVar) {
        int i = bVar.lvq;
        bVar.lvq = i - 1;
        return i;
    }

    static /* synthetic */ int e(b bVar) {
        int i = bVar.lvq;
        bVar.lvq = i + 1;
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
        if (this.lvz == null) {
            return 0;
        }
        return this.lvz.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final a aVar, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar2 = this.lvz.get(i);
        aVar.lvx.setText(aVar2.class_name);
        if (aVar2.class_id.intValue() > 0) {
            SvgManager.btW().a(aVar.lvw, com.baidu.tieba.newinterest.c.a.GG(aVar2.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar2.forum_info != null && aVar2.forum_info.size() != 0) {
            if (aVar2.lwj == 0) {
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
                    aVar2.lwj = 2;
                }
            } else {
                int i2 = aVar2.lwj;
                c(aVar, aVar2.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar2.forum_info.size() - 1 : i2 - 1;
                b(aVar, aVar2.forum_info.get(size));
                a(aVar, aVar2.forum_info.get(size + (-1) < 0 ? aVar2.forum_info.size() - 1 : size - 1));
            }
            if (aVar2.forum_info.size() <= 3) {
                aVar.lvH.setEnabled(false);
            } else {
                aVar.lvH.setEnabled(true);
            }
            aVar.lvH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar2.forum_info.size() - 1;
                    b.this.a(size2, aVar2);
                    b.this.a(aVar, aVar2.forum_info.get(aVar2.lwj));
                    b.this.a(size2, aVar2);
                    b.this.b(aVar, aVar2.forum_info.get(aVar2.lwj));
                    b.this.a(size2, aVar2);
                    b.this.c(aVar, aVar2.forum_info.get(aVar2.lwj));
                    b.this.lvB = b.this.dlu();
                    b.this.notifyItemChanged(i);
                    if (b.this.lvA != null) {
                        b.this.lvA.ae(b.this.lvq, b.this.lvB);
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
        aVar.lvI.setVisibility(0);
        aVar.lvL.setVisibility(0);
        aVar.lvL.startLoad(dVar.lwl.avatar, 10, false);
        aVar.lvO.setText(dVar.lwl.forum_name);
        if (TextUtils.isEmpty(dVar.lwl.slogan)) {
            str = "百度" + dVar.lwl.forum_name + "吧";
        } else {
            str = dVar.lwl.slogan;
        }
        aVar.lvR.setText(str);
        aVar.lvU.setText("关注 " + au.numberUniformFormatExtra(dVar.lwl.member_count.intValue()));
        aVar.lvX.setText("帖子 " + au.numberUniformFormatExtra(dVar.lwl.thread_count.intValue()));
        a(aVar.lwa, dVar);
        a(dVar, aVar.lwa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, d dVar) {
        String str;
        aVar.lvJ.setVisibility(0);
        aVar.lvM.setVisibility(0);
        aVar.lvM.startLoad(dVar.lwl.avatar, 10, false);
        aVar.lvP.setText(dVar.lwl.forum_name);
        if (TextUtils.isEmpty(dVar.lwl.slogan)) {
            str = "百度" + dVar.lwl.forum_name + "吧";
        } else {
            str = dVar.lwl.slogan;
        }
        aVar.lvS.setText(str);
        aVar.lvV.setText("关注 " + au.numberUniformFormatExtra(dVar.lwl.member_count.intValue()));
        aVar.lvY.setText("帖子 " + au.numberUniformFormatExtra(dVar.lwl.thread_count.intValue()));
        a(aVar.lwb, dVar);
        a(dVar, aVar.lwb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar, d dVar) {
        String str;
        aVar.lvK.setVisibility(0);
        aVar.lvN.setVisibility(0);
        aVar.lvN.startLoad(dVar.lwl.avatar, 10, false);
        aVar.lvQ.setText(dVar.lwl.forum_name);
        if (TextUtils.isEmpty(dVar.lwl.slogan)) {
            str = "百度" + dVar.lwl.forum_name + "吧";
        } else {
            str = dVar.lwl.slogan;
        }
        aVar.lvT.setText(str);
        aVar.lvW.setText("关注 " + au.numberUniformFormatExtra(dVar.lwl.member_count.intValue()));
        aVar.lvZ.setText("帖子 " + au.numberUniformFormatExtra(dVar.lwl.thread_count.intValue()));
        a(aVar.lwc, dVar);
        a(dVar, aVar.lwc);
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
        this.lvz.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.lwj < i) {
            aVar.lwj++;
        } else {
            aVar.lwj = 0;
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
                    b.this.lvB = false;
                } else {
                    b.e(b.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.rj(R.color.CAM_X0109);
                    tBSpecificationBtn.setConfig(bVar);
                    b.this.lvB = b.this.dlu();
                }
                if (b.this.lvA != null) {
                    b.this.lvA.ae(b.this.lvq, b.this.lvB);
                }
                ar arVar = new ar("c13682");
                arVar.al("obj_type", 2);
                arVar.al("obj_locate", 4);
                arVar.w("fid", dVar.lwl.forum_id.longValue());
                TiebaStatic.log(arVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> dls() {
        return this.lvz;
    }

    public void dlt() {
        if (this.lvz != null && this.lvz.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.lvz) {
                int i = aVar.lwj;
                aVar.forum_info.get(i).selected = !this.lvB;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.lvB;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.lvB;
                a(aVar, size2);
            }
            this.lvB = this.lvB ? false : true;
            notifyDataSetChanged();
            if (this.lvA != null) {
                if (this.lvB) {
                    this.lvq = this.lvz.size() * 3;
                    this.lvA.ae(this.lvz.size() * 3, this.lvB);
                    return;
                }
                this.lvq = 0;
                this.lvA.ae(0, this.lvB);
            }
        }
    }

    public boolean dlu() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.lvz) {
            int i = aVar.lwj;
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
        if (!this.lvB) {
            ar arVar = new ar("c13682");
            arVar.al("obj_type", 2);
            arVar.al("obj_locate", 3);
            arVar.w("fid", aVar.forum_info.get(i).lwl.forum_id.longValue());
            TiebaStatic.log(arVar);
        }
    }

    /* loaded from: classes23.dex */
    public static class a extends RecyclerView.ViewHolder {
        public TextView lvH;
        public RelativeLayout lvI;
        public RelativeLayout lvJ;
        public RelativeLayout lvK;
        public BarImageView lvL;
        public BarImageView lvM;
        public BarImageView lvN;
        public TextView lvO;
        public TextView lvP;
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
        public ImageView lvw;
        public TextView lvx;
        public TBSpecificationBtn lwa;
        public TBSpecificationBtn lwb;
        public TBSpecificationBtn lwc;

        public a(View view) {
            super(view);
            this.lvw = (ImageView) view.findViewById(R.id.interest_icon);
            this.lvx = (TextView) view.findViewById(R.id.interest_text);
            this.lvH = (TextView) view.findViewById(R.id.interest_change);
            this.lvI = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.lvJ = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.lvK = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.lvL = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.lvM = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.lvN = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.lvO = (TextView) view.findViewById(R.id.top_forum_name);
            this.lvP = (TextView) view.findViewById(R.id.middle_forum_name);
            this.lvQ = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.lvR = (TextView) view.findViewById(R.id.top_forum_desc);
            this.lvS = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.lvT = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.lvU = (TextView) view.findViewById(R.id.top_member_text);
            this.lvV = (TextView) view.findViewById(R.id.middle_member_text);
            this.lvW = (TextView) view.findViewById(R.id.bottom_member_text);
            this.lvX = (TextView) view.findViewById(R.id.top_post_text);
            this.lvY = (TextView) view.findViewById(R.id.middle_post_text);
            this.lvZ = (TextView) view.findViewById(R.id.bottom_post_text);
            this.lwa = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.lwb = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.lwc = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.lvO, R.color.CAM_X0105);
            ap.setViewTextColor(this.lvP, R.color.CAM_X0105);
            ap.setViewTextColor(this.lvQ, R.color.CAM_X0105);
            ap.setViewTextColor(this.lvR, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvS, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvT, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvU, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvV, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvW, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvX, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvY, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvZ, R.color.CAM_X0109);
            ap.setViewTextColor(this.lvx, R.color.CAM_X0105);
            ap.setViewTextColor(this.lvH, R.color.CAM_X0107);
            this.lvx.setTypeface(Typeface.DEFAULT_BOLD);
            this.lvO.setTypeface(Typeface.DEFAULT_BOLD);
            this.lvP.setTypeface(Typeface.DEFAULT_BOLD);
            this.lvQ.setTypeface(Typeface.DEFAULT_BOLD);
            this.lwa.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.lwb.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            this.lwc.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
            f(this.lvL);
            f(this.lvM);
            f(this.lvN);
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
        this.lvA = interfaceC0817b;
    }
}
