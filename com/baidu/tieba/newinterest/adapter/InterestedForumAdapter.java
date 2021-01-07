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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {
    private int lAA;
    private List<com.baidu.tieba.newinterest.data.a> lAJ = new ArrayList();
    private a lAK;
    private boolean lAL;

    /* loaded from: classes8.dex */
    public interface a {
        void ac(int i, boolean z);
    }

    static /* synthetic */ int d(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.lAA;
        interestedForumAdapter.lAA = i - 1;
        return i;
    }

    static /* synthetic */ int e(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.lAA;
        interestedForumAdapter.lAA = i + 1;
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: O */
    public InterestedForumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new InterestedForumViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_interested_forum, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.lAJ == null) {
            return 0;
        }
        return this.lAJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final InterestedForumViewHolder interestedForumViewHolder, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar = this.lAJ.get(i);
        interestedForumViewHolder.lAH.setText(aVar.class_name);
        if (aVar.class_id.intValue() > 0) {
            SvgManager.bwr().a(interestedForumViewHolder.lAG, com.baidu.tieba.newinterest.b.a.Gy(aVar.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar.forum_info != null && aVar.forum_info.size() != 0) {
            if (aVar.lBt == 0) {
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
                    aVar.lBt = 2;
                }
            } else {
                int i2 = aVar.lBt;
                c(interestedForumViewHolder, aVar.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar.forum_info.size() - 1 : i2 - 1;
                b(interestedForumViewHolder, aVar.forum_info.get(size));
                a(interestedForumViewHolder, aVar.forum_info.get(size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1));
            }
            if (aVar.forum_info.size() <= 3) {
                interestedForumViewHolder.lAR.setEnabled(false);
            } else {
                interestedForumViewHolder.lAR.setEnabled(true);
            }
            interestedForumViewHolder.lAR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar.forum_info.size() - 1;
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.a(interestedForumViewHolder, aVar.forum_info.get(aVar.lBt));
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.b(interestedForumViewHolder, aVar.forum_info.get(aVar.lBt));
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.c(interestedForumViewHolder, aVar.forum_info.get(aVar.lBt));
                    InterestedForumAdapter.this.lAL = InterestedForumAdapter.this.dlg();
                    InterestedForumAdapter.this.notifyItemChanged(i);
                    if (InterestedForumAdapter.this.lAK != null) {
                        InterestedForumAdapter.this.lAK.ac(InterestedForumAdapter.this.lAA, InterestedForumAdapter.this.lAL);
                    }
                    aq aqVar = new aq("c13682");
                    aqVar.an("obj_type", 2);
                    aqVar.an("obj_locate", 4);
                    aqVar.an("obj_source", aVar.class_id.intValue());
                    TiebaStatic.log(aqVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lAS.setVisibility(0);
        interestedForumViewHolder.lAV.setVisibility(0);
        interestedForumViewHolder.lAV.startLoad(dVar.lBv.avatar, 10, false);
        interestedForumViewHolder.lAY.setText(dVar.lBv.forum_name);
        if (TextUtils.isEmpty(dVar.lBv.slogan)) {
            str = "百度" + dVar.lBv.forum_name + "吧";
        } else {
            str = dVar.lBv.slogan;
        }
        interestedForumViewHolder.lBb.setText(str);
        interestedForumViewHolder.lBe.setText("关注 " + at.numberUniformFormatExtra(dVar.lBv.member_count.intValue()));
        interestedForumViewHolder.lBh.setText("帖子 " + at.numberUniformFormatExtra(dVar.lBv.thread_count.intValue()));
        a(interestedForumViewHolder.lBk, dVar);
        a(dVar, interestedForumViewHolder.lBk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lAT.setVisibility(0);
        interestedForumViewHolder.lAW.setVisibility(0);
        interestedForumViewHolder.lAW.startLoad(dVar.lBv.avatar, 10, false);
        interestedForumViewHolder.lAZ.setText(dVar.lBv.forum_name);
        if (TextUtils.isEmpty(dVar.lBv.slogan)) {
            str = "百度" + dVar.lBv.forum_name + "吧";
        } else {
            str = dVar.lBv.slogan;
        }
        interestedForumViewHolder.lBc.setText(str);
        interestedForumViewHolder.lBf.setText("关注 " + at.numberUniformFormatExtra(dVar.lBv.member_count.intValue()));
        interestedForumViewHolder.lBi.setText("帖子 " + at.numberUniformFormatExtra(dVar.lBv.thread_count.intValue()));
        a(interestedForumViewHolder.lBl, dVar);
        a(dVar, interestedForumViewHolder.lBl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lAU.setVisibility(0);
        interestedForumViewHolder.lAX.setVisibility(0);
        interestedForumViewHolder.lAX.startLoad(dVar.lBv.avatar, 10, false);
        interestedForumViewHolder.lBa.setText(dVar.lBv.forum_name);
        if (TextUtils.isEmpty(dVar.lBv.slogan)) {
            str = "百度" + dVar.lBv.forum_name + "吧";
        } else {
            str = dVar.lBv.slogan;
        }
        interestedForumViewHolder.lBd.setText(str);
        interestedForumViewHolder.lBg.setText("关注 " + at.numberUniformFormatExtra(dVar.lBv.member_count.intValue()));
        interestedForumViewHolder.lBj.setText("帖子 " + at.numberUniformFormatExtra(dVar.lBv.thread_count.intValue()));
        a(interestedForumViewHolder.lBm, dVar);
        a(dVar, interestedForumViewHolder.lBm);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        b bVar = new b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.ru(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void cA(List<com.baidu.tieba.newinterest.data.a> list) {
        this.lAJ.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.lBt < i) {
            aVar.lBt++;
        } else {
            aVar.lBt = 0;
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
                    InterestedForumAdapter.this.lAL = false;
                } else {
                    InterestedForumAdapter.e(InterestedForumAdapter.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.ru(R.color.CAM_X0109);
                    tBSpecificationBtn.setConfig(bVar);
                    InterestedForumAdapter.this.lAL = InterestedForumAdapter.this.dlg();
                }
                if (InterestedForumAdapter.this.lAK != null) {
                    InterestedForumAdapter.this.lAK.ac(InterestedForumAdapter.this.lAA, InterestedForumAdapter.this.lAL);
                }
                aq aqVar = new aq("c13682");
                aqVar.an("obj_type", 2);
                aqVar.an("obj_locate", 4);
                aqVar.w("fid", dVar.lBv.forum_id.longValue());
                TiebaStatic.log(aqVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> dle() {
        return this.lAJ;
    }

    public void dlf() {
        if (this.lAJ != null && this.lAJ.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.lAJ) {
                int i = aVar.lBt;
                aVar.forum_info.get(i).selected = !this.lAL;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.lAL;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.lAL;
                a(aVar, size2);
            }
            this.lAL = this.lAL ? false : true;
            notifyDataSetChanged();
            if (this.lAK != null) {
                if (this.lAL) {
                    this.lAA = this.lAJ.size() * 3;
                    this.lAK.ac(this.lAJ.size() * 3, this.lAL);
                    return;
                }
                this.lAA = 0;
                this.lAK.ac(0, this.lAL);
            }
        }
    }

    public boolean dlg() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.lAJ) {
            int i = aVar.lBt;
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
        if (!this.lAL) {
            aq aqVar = new aq("c13682");
            aqVar.an("obj_type", 2);
            aqVar.an("obj_locate", 3);
            aqVar.w("fid", aVar.forum_info.get(i).lBv.forum_id.longValue());
            TiebaStatic.log(aqVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {
        public ImageView lAG;
        public TextView lAH;
        public TextView lAR;
        public RelativeLayout lAS;
        public RelativeLayout lAT;
        public RelativeLayout lAU;
        public BarImageView lAV;
        public BarImageView lAW;
        public BarImageView lAX;
        public TextView lAY;
        public TextView lAZ;
        public TextView lBa;
        public TextView lBb;
        public TextView lBc;
        public TextView lBd;
        public TextView lBe;
        public TextView lBf;
        public TextView lBg;
        public TextView lBh;
        public TextView lBi;
        public TextView lBj;
        public TBSpecificationBtn lBk;
        public TBSpecificationBtn lBl;
        public TBSpecificationBtn lBm;

        public InterestedForumViewHolder(View view) {
            super(view);
            this.lAG = (ImageView) view.findViewById(R.id.interest_icon);
            this.lAH = (TextView) view.findViewById(R.id.interest_text);
            this.lAR = (TextView) view.findViewById(R.id.interest_change);
            this.lAS = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.lAT = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.lAU = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.lAV = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.lAW = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.lAX = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.lAY = (TextView) view.findViewById(R.id.top_forum_name);
            this.lAZ = (TextView) view.findViewById(R.id.middle_forum_name);
            this.lBa = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.lBb = (TextView) view.findViewById(R.id.top_forum_desc);
            this.lBc = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.lBd = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.lBe = (TextView) view.findViewById(R.id.top_member_text);
            this.lBf = (TextView) view.findViewById(R.id.middle_member_text);
            this.lBg = (TextView) view.findViewById(R.id.bottom_member_text);
            this.lBh = (TextView) view.findViewById(R.id.top_post_text);
            this.lBi = (TextView) view.findViewById(R.id.middle_post_text);
            this.lBj = (TextView) view.findViewById(R.id.bottom_post_text);
            this.lBk = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.lBl = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.lBm = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ao.setViewTextColor(this.lAY, R.color.CAM_X0105);
            ao.setViewTextColor(this.lAZ, R.color.CAM_X0105);
            ao.setViewTextColor(this.lBa, R.color.CAM_X0105);
            ao.setViewTextColor(this.lBb, R.color.CAM_X0109);
            ao.setViewTextColor(this.lBc, R.color.CAM_X0109);
            ao.setViewTextColor(this.lBd, R.color.CAM_X0109);
            ao.setViewTextColor(this.lBe, R.color.CAM_X0109);
            ao.setViewTextColor(this.lBf, R.color.CAM_X0109);
            ao.setViewTextColor(this.lBg, R.color.CAM_X0109);
            ao.setViewTextColor(this.lBh, R.color.CAM_X0109);
            ao.setViewTextColor(this.lBi, R.color.CAM_X0109);
            ao.setViewTextColor(this.lBj, R.color.CAM_X0109);
            ao.setViewTextColor(this.lAH, R.color.CAM_X0105);
            ao.setViewTextColor(this.lAR, R.color.CAM_X0107);
            this.lAH.setTypeface(Typeface.DEFAULT_BOLD);
            this.lAY.setTypeface(Typeface.DEFAULT_BOLD);
            this.lAZ.setTypeface(Typeface.DEFAULT_BOLD);
            this.lBa.setTypeface(Typeface.DEFAULT_BOLD);
            this.lBk.setConfig(new b());
            this.lBl.setConfig(new b());
            this.lBm.setConfig(new b());
            a(this.lAV);
            a(this.lAW);
            a(this.lAX);
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
        this.lAK = aVar;
    }
}
