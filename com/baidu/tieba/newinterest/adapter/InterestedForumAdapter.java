package com.baidu.tieba.newinterest.adapter;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {
    private int lGo;
    private List<com.baidu.tieba.newinterest.data.a> lGx = new ArrayList();
    private a lGy;
    private boolean lGz;

    /* loaded from: classes7.dex */
    public interface a {
        void ac(int i, boolean z);
    }

    static /* synthetic */ int d(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.lGo;
        interestedForumAdapter.lGo = i - 1;
        return i;
    }

    static /* synthetic */ int e(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.lGo;
        interestedForumAdapter.lGo = i + 1;
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: P */
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.lGx == null) {
            return 0;
        }
        return this.lGx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final InterestedForumViewHolder interestedForumViewHolder, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar = this.lGx.get(i);
        interestedForumViewHolder.lGv.setText(aVar.class_name);
        if (aVar.class_id.intValue() > 0) {
            SvgManager.bsU().a(interestedForumViewHolder.lGu, com.baidu.tieba.newinterest.b.a.Fn(aVar.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar.forum_info != null && aVar.forum_info.size() != 0) {
            if (aVar.lHh == 0) {
                if (aVar.forum_info.size() >= 1) {
                    a(interestedForumViewHolder, aVar.forum_info.get(0));
                }
                if (aVar.forum_info.size() >= 2) {
                    b(interestedForumViewHolder, aVar.forum_info.get(1));
                }
                if (aVar.forum_info.size() >= 3) {
                    c(interestedForumViewHolder, aVar.forum_info.get(2));
                }
                if (aVar.forum_info.size() > 3) {
                    aVar.lHh = 2;
                }
            } else {
                int i2 = aVar.lHh;
                c(interestedForumViewHolder, aVar.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar.forum_info.size() - 1 : i2 - 1;
                b(interestedForumViewHolder, aVar.forum_info.get(size));
                a(interestedForumViewHolder, aVar.forum_info.get(size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1));
            }
            if (aVar.forum_info.size() <= 3) {
                interestedForumViewHolder.lGF.setEnabled(false);
            } else {
                interestedForumViewHolder.lGF.setEnabled(true);
            }
            interestedForumViewHolder.lGF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar.forum_info.size() - 1;
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.a(interestedForumViewHolder, aVar.forum_info.get(aVar.lHh));
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.b(interestedForumViewHolder, aVar.forum_info.get(aVar.lHh));
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.c(interestedForumViewHolder, aVar.forum_info.get(aVar.lHh));
                    InterestedForumAdapter.this.lGz = InterestedForumAdapter.this.djF();
                    InterestedForumAdapter.this.notifyItemChanged(i);
                    if (InterestedForumAdapter.this.lGy != null) {
                        InterestedForumAdapter.this.lGy.ac(InterestedForumAdapter.this.lGo, InterestedForumAdapter.this.lGz);
                    }
                    ar arVar = new ar("c13682");
                    arVar.aq("obj_type", 2);
                    arVar.aq("obj_locate", 4);
                    arVar.aq("obj_source", aVar.class_id.intValue());
                    TiebaStatic.log(arVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lGG.setVisibility(0);
        interestedForumViewHolder.lGJ.setVisibility(0);
        interestedForumViewHolder.lGJ.startLoad(dVar.lHj.avatar, 10, false);
        interestedForumViewHolder.lGM.setText(dVar.lHj.forum_name);
        if (TextUtils.isEmpty(dVar.lHj.slogan)) {
            str = "百度" + dVar.lHj.forum_name + "吧";
        } else {
            str = dVar.lHj.slogan;
        }
        interestedForumViewHolder.lGP.setText(str);
        interestedForumViewHolder.lGS.setText("关注 " + au.numberUniformFormatExtra(dVar.lHj.member_count.intValue()));
        interestedForumViewHolder.lGV.setText("帖子 " + au.numberUniformFormatExtra(dVar.lHj.thread_count.intValue()));
        a(interestedForumViewHolder.lGY, dVar);
        a(dVar, interestedForumViewHolder.lGY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lGH.setVisibility(0);
        interestedForumViewHolder.lGK.setVisibility(0);
        interestedForumViewHolder.lGK.startLoad(dVar.lHj.avatar, 10, false);
        interestedForumViewHolder.lGN.setText(dVar.lHj.forum_name);
        if (TextUtils.isEmpty(dVar.lHj.slogan)) {
            str = "百度" + dVar.lHj.forum_name + "吧";
        } else {
            str = dVar.lHj.slogan;
        }
        interestedForumViewHolder.lGQ.setText(str);
        interestedForumViewHolder.lGT.setText("关注 " + au.numberUniformFormatExtra(dVar.lHj.member_count.intValue()));
        interestedForumViewHolder.lGW.setText("帖子 " + au.numberUniformFormatExtra(dVar.lHj.thread_count.intValue()));
        a(interestedForumViewHolder.lGZ, dVar);
        a(dVar, interestedForumViewHolder.lGZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lGI.setVisibility(0);
        interestedForumViewHolder.lGL.setVisibility(0);
        interestedForumViewHolder.lGL.startLoad(dVar.lHj.avatar, 10, false);
        interestedForumViewHolder.lGO.setText(dVar.lHj.forum_name);
        if (TextUtils.isEmpty(dVar.lHj.slogan)) {
            str = "百度" + dVar.lHj.forum_name + "吧";
        } else {
            str = dVar.lHj.slogan;
        }
        interestedForumViewHolder.lGR.setText(str);
        interestedForumViewHolder.lGU.setText("关注 " + au.numberUniformFormatExtra(dVar.lHj.member_count.intValue()));
        interestedForumViewHolder.lGX.setText("帖子 " + au.numberUniformFormatExtra(dVar.lHj.thread_count.intValue()));
        a(interestedForumViewHolder.lHa, dVar);
        a(dVar, interestedForumViewHolder.lHa);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        b bVar = new b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.pU(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void cv(List<com.baidu.tieba.newinterest.data.a> list) {
        this.lGx.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.lHh < i) {
            aVar.lHh++;
        } else {
            aVar.lHh = 0;
        }
    }

    private void a(final d dVar, final TBSpecificationBtn tBSpecificationBtn) {
        tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dVar.selected = !dVar.selected;
                b bVar = new b();
                if (!dVar.selected) {
                    InterestedForumAdapter.d(InterestedForumAdapter.this);
                    tBSpecificationBtn.setText("感兴趣");
                    tBSpecificationBtn.setConfig(bVar);
                    InterestedForumAdapter.this.lGz = false;
                } else {
                    InterestedForumAdapter.e(InterestedForumAdapter.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.pU(R.color.CAM_X0109);
                    tBSpecificationBtn.setConfig(bVar);
                    InterestedForumAdapter.this.lGz = InterestedForumAdapter.this.djF();
                }
                if (InterestedForumAdapter.this.lGy != null) {
                    InterestedForumAdapter.this.lGy.ac(InterestedForumAdapter.this.lGo, InterestedForumAdapter.this.lGz);
                }
                ar arVar = new ar("c13682");
                arVar.aq("obj_type", 2);
                arVar.aq("obj_locate", 4);
                arVar.v("fid", dVar.lHj.forum_id.longValue());
                TiebaStatic.log(arVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> djD() {
        return this.lGx;
    }

    public void djE() {
        if (this.lGx != null && this.lGx.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.lGx) {
                int i = aVar.lHh;
                aVar.forum_info.get(i).selected = !this.lGz;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.lGz;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.lGz;
                a(aVar, size2);
            }
            this.lGz = this.lGz ? false : true;
            notifyDataSetChanged();
            if (this.lGy != null) {
                if (this.lGz) {
                    this.lGo = this.lGx.size() * 3;
                    this.lGy.ac(this.lGx.size() * 3, this.lGz);
                    return;
                }
                this.lGo = 0;
                this.lGy.ac(0, this.lGz);
            }
        }
    }

    public boolean djF() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.lGx) {
            int i = aVar.lHh;
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
        if (!this.lGz) {
            ar arVar = new ar("c13682");
            arVar.aq("obj_type", 2);
            arVar.aq("obj_locate", 3);
            arVar.v("fid", aVar.forum_info.get(i).lHj.forum_id.longValue());
            TiebaStatic.log(arVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {
        public TextView lGF;
        public RelativeLayout lGG;
        public RelativeLayout lGH;
        public RelativeLayout lGI;
        public BarImageView lGJ;
        public BarImageView lGK;
        public BarImageView lGL;
        public TextView lGM;
        public TextView lGN;
        public TextView lGO;
        public TextView lGP;
        public TextView lGQ;
        public TextView lGR;
        public TextView lGS;
        public TextView lGT;
        public TextView lGU;
        public TextView lGV;
        public TextView lGW;
        public TextView lGX;
        public TBSpecificationBtn lGY;
        public TBSpecificationBtn lGZ;
        public ImageView lGu;
        public TextView lGv;
        public TBSpecificationBtn lHa;

        public InterestedForumViewHolder(View view) {
            super(view);
            this.lGu = (ImageView) view.findViewById(R.id.interest_icon);
            this.lGv = (TextView) view.findViewById(R.id.interest_text);
            this.lGF = (TextView) view.findViewById(R.id.interest_change);
            this.lGG = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.lGH = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.lGI = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.lGJ = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.lGK = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.lGL = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.lGM = (TextView) view.findViewById(R.id.top_forum_name);
            this.lGN = (TextView) view.findViewById(R.id.middle_forum_name);
            this.lGO = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.lGP = (TextView) view.findViewById(R.id.top_forum_desc);
            this.lGQ = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.lGR = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.lGS = (TextView) view.findViewById(R.id.top_member_text);
            this.lGT = (TextView) view.findViewById(R.id.middle_member_text);
            this.lGU = (TextView) view.findViewById(R.id.bottom_member_text);
            this.lGV = (TextView) view.findViewById(R.id.top_post_text);
            this.lGW = (TextView) view.findViewById(R.id.middle_post_text);
            this.lGX = (TextView) view.findViewById(R.id.bottom_post_text);
            this.lGY = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.lGZ = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.lHa = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.lGM, R.color.CAM_X0105);
            ap.setViewTextColor(this.lGN, R.color.CAM_X0105);
            ap.setViewTextColor(this.lGO, R.color.CAM_X0105);
            ap.setViewTextColor(this.lGP, R.color.CAM_X0109);
            ap.setViewTextColor(this.lGQ, R.color.CAM_X0109);
            ap.setViewTextColor(this.lGR, R.color.CAM_X0109);
            ap.setViewTextColor(this.lGS, R.color.CAM_X0109);
            ap.setViewTextColor(this.lGT, R.color.CAM_X0109);
            ap.setViewTextColor(this.lGU, R.color.CAM_X0109);
            ap.setViewTextColor(this.lGV, R.color.CAM_X0109);
            ap.setViewTextColor(this.lGW, R.color.CAM_X0109);
            ap.setViewTextColor(this.lGX, R.color.CAM_X0109);
            ap.setViewTextColor(this.lGv, R.color.CAM_X0105);
            ap.setViewTextColor(this.lGF, R.color.CAM_X0107);
            this.lGv.setTypeface(Typeface.DEFAULT_BOLD);
            this.lGM.setTypeface(Typeface.DEFAULT_BOLD);
            this.lGN.setTypeface(Typeface.DEFAULT_BOLD);
            this.lGO.setTypeface(Typeface.DEFAULT_BOLD);
            this.lGY.setConfig(new b());
            this.lGZ.setConfig(new b());
            this.lHa.setConfig(new b());
            a(this.lGJ);
            a(this.lGK);
            a(this.lGL);
        }

        private void a(BarImageView barImageView) {
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setShowInnerBorder(true);
            barImageView.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            barImageView.setStrokeColorResId(R.color.CAM_X0401);
        }
    }

    public void a(a aVar) {
        this.lGy = aVar;
    }
}
