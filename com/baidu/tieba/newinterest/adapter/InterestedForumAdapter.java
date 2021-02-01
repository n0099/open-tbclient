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
/* loaded from: classes8.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {
    private int lDY;
    private List<com.baidu.tieba.newinterest.data.a> lEh = new ArrayList();
    private a lEi;
    private boolean lEj;

    /* loaded from: classes8.dex */
    public interface a {
        void ac(int i, boolean z);
    }

    static /* synthetic */ int d(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.lDY;
        interestedForumAdapter.lDY = i - 1;
        return i;
    }

    static /* synthetic */ int e(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.lDY;
        interestedForumAdapter.lDY = i + 1;
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
        if (this.lEh == null) {
            return 0;
        }
        return this.lEh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final InterestedForumViewHolder interestedForumViewHolder, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar = this.lEh.get(i);
        interestedForumViewHolder.lEf.setText(aVar.class_name);
        if (aVar.class_id.intValue() > 0) {
            SvgManager.bsR().a(interestedForumViewHolder.lEe, com.baidu.tieba.newinterest.b.a.Fk(aVar.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar.forum_info != null && aVar.forum_info.size() != 0) {
            if (aVar.lER == 0) {
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
                    aVar.lER = 2;
                }
            } else {
                int i2 = aVar.lER;
                c(interestedForumViewHolder, aVar.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar.forum_info.size() - 1 : i2 - 1;
                b(interestedForumViewHolder, aVar.forum_info.get(size));
                a(interestedForumViewHolder, aVar.forum_info.get(size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1));
            }
            if (aVar.forum_info.size() <= 3) {
                interestedForumViewHolder.lEp.setEnabled(false);
            } else {
                interestedForumViewHolder.lEp.setEnabled(true);
            }
            interestedForumViewHolder.lEp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar.forum_info.size() - 1;
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.a(interestedForumViewHolder, aVar.forum_info.get(aVar.lER));
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.b(interestedForumViewHolder, aVar.forum_info.get(aVar.lER));
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.c(interestedForumViewHolder, aVar.forum_info.get(aVar.lER));
                    InterestedForumAdapter.this.lEj = InterestedForumAdapter.this.djp();
                    InterestedForumAdapter.this.notifyItemChanged(i);
                    if (InterestedForumAdapter.this.lEi != null) {
                        InterestedForumAdapter.this.lEi.ac(InterestedForumAdapter.this.lDY, InterestedForumAdapter.this.lEj);
                    }
                    ar arVar = new ar("c13682");
                    arVar.ap("obj_type", 2);
                    arVar.ap("obj_locate", 4);
                    arVar.ap("obj_source", aVar.class_id.intValue());
                    TiebaStatic.log(arVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lEq.setVisibility(0);
        interestedForumViewHolder.lEt.setVisibility(0);
        interestedForumViewHolder.lEt.startLoad(dVar.lET.avatar, 10, false);
        interestedForumViewHolder.lEw.setText(dVar.lET.forum_name);
        if (TextUtils.isEmpty(dVar.lET.slogan)) {
            str = "百度" + dVar.lET.forum_name + "吧";
        } else {
            str = dVar.lET.slogan;
        }
        interestedForumViewHolder.lEz.setText(str);
        interestedForumViewHolder.lEC.setText("关注 " + au.numberUniformFormatExtra(dVar.lET.member_count.intValue()));
        interestedForumViewHolder.lEF.setText("帖子 " + au.numberUniformFormatExtra(dVar.lET.thread_count.intValue()));
        a(interestedForumViewHolder.lEI, dVar);
        a(dVar, interestedForumViewHolder.lEI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lEr.setVisibility(0);
        interestedForumViewHolder.lEu.setVisibility(0);
        interestedForumViewHolder.lEu.startLoad(dVar.lET.avatar, 10, false);
        interestedForumViewHolder.lEx.setText(dVar.lET.forum_name);
        if (TextUtils.isEmpty(dVar.lET.slogan)) {
            str = "百度" + dVar.lET.forum_name + "吧";
        } else {
            str = dVar.lET.slogan;
        }
        interestedForumViewHolder.lEA.setText(str);
        interestedForumViewHolder.lED.setText("关注 " + au.numberUniformFormatExtra(dVar.lET.member_count.intValue()));
        interestedForumViewHolder.lEG.setText("帖子 " + au.numberUniformFormatExtra(dVar.lET.thread_count.intValue()));
        a(interestedForumViewHolder.lEJ, dVar);
        a(dVar, interestedForumViewHolder.lEJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lEs.setVisibility(0);
        interestedForumViewHolder.lEv.setVisibility(0);
        interestedForumViewHolder.lEv.startLoad(dVar.lET.avatar, 10, false);
        interestedForumViewHolder.lEy.setText(dVar.lET.forum_name);
        if (TextUtils.isEmpty(dVar.lET.slogan)) {
            str = "百度" + dVar.lET.forum_name + "吧";
        } else {
            str = dVar.lET.slogan;
        }
        interestedForumViewHolder.lEB.setText(str);
        interestedForumViewHolder.lEE.setText("关注 " + au.numberUniformFormatExtra(dVar.lET.member_count.intValue()));
        interestedForumViewHolder.lEH.setText("帖子 " + au.numberUniformFormatExtra(dVar.lET.thread_count.intValue()));
        a(interestedForumViewHolder.lEK, dVar);
        a(dVar, interestedForumViewHolder.lEK);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        b bVar = new b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.pT(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void cv(List<com.baidu.tieba.newinterest.data.a> list) {
        this.lEh.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.lER < i) {
            aVar.lER++;
        } else {
            aVar.lER = 0;
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
                    InterestedForumAdapter.this.lEj = false;
                } else {
                    InterestedForumAdapter.e(InterestedForumAdapter.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.pT(R.color.CAM_X0109);
                    tBSpecificationBtn.setConfig(bVar);
                    InterestedForumAdapter.this.lEj = InterestedForumAdapter.this.djp();
                }
                if (InterestedForumAdapter.this.lEi != null) {
                    InterestedForumAdapter.this.lEi.ac(InterestedForumAdapter.this.lDY, InterestedForumAdapter.this.lEj);
                }
                ar arVar = new ar("c13682");
                arVar.ap("obj_type", 2);
                arVar.ap("obj_locate", 4);
                arVar.v("fid", dVar.lET.forum_id.longValue());
                TiebaStatic.log(arVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> djn() {
        return this.lEh;
    }

    public void djo() {
        if (this.lEh != null && this.lEh.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.lEh) {
                int i = aVar.lER;
                aVar.forum_info.get(i).selected = !this.lEj;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.lEj;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.lEj;
                a(aVar, size2);
            }
            this.lEj = this.lEj ? false : true;
            notifyDataSetChanged();
            if (this.lEi != null) {
                if (this.lEj) {
                    this.lDY = this.lEh.size() * 3;
                    this.lEi.ac(this.lEh.size() * 3, this.lEj);
                    return;
                }
                this.lDY = 0;
                this.lEi.ac(0, this.lEj);
            }
        }
    }

    public boolean djp() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.lEh) {
            int i = aVar.lER;
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
        if (!this.lEj) {
            ar arVar = new ar("c13682");
            arVar.ap("obj_type", 2);
            arVar.ap("obj_locate", 3);
            arVar.v("fid", aVar.forum_info.get(i).lET.forum_id.longValue());
            TiebaStatic.log(arVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {
        public TextView lEA;
        public TextView lEB;
        public TextView lEC;
        public TextView lED;
        public TextView lEE;
        public TextView lEF;
        public TextView lEG;
        public TextView lEH;
        public TBSpecificationBtn lEI;
        public TBSpecificationBtn lEJ;
        public TBSpecificationBtn lEK;
        public ImageView lEe;
        public TextView lEf;
        public TextView lEp;
        public RelativeLayout lEq;
        public RelativeLayout lEr;
        public RelativeLayout lEs;
        public BarImageView lEt;
        public BarImageView lEu;
        public BarImageView lEv;
        public TextView lEw;
        public TextView lEx;
        public TextView lEy;
        public TextView lEz;

        public InterestedForumViewHolder(View view) {
            super(view);
            this.lEe = (ImageView) view.findViewById(R.id.interest_icon);
            this.lEf = (TextView) view.findViewById(R.id.interest_text);
            this.lEp = (TextView) view.findViewById(R.id.interest_change);
            this.lEq = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.lEr = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.lEs = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.lEt = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.lEu = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.lEv = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.lEw = (TextView) view.findViewById(R.id.top_forum_name);
            this.lEx = (TextView) view.findViewById(R.id.middle_forum_name);
            this.lEy = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.lEz = (TextView) view.findViewById(R.id.top_forum_desc);
            this.lEA = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.lEB = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.lEC = (TextView) view.findViewById(R.id.top_member_text);
            this.lED = (TextView) view.findViewById(R.id.middle_member_text);
            this.lEE = (TextView) view.findViewById(R.id.bottom_member_text);
            this.lEF = (TextView) view.findViewById(R.id.top_post_text);
            this.lEG = (TextView) view.findViewById(R.id.middle_post_text);
            this.lEH = (TextView) view.findViewById(R.id.bottom_post_text);
            this.lEI = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.lEJ = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.lEK = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.lEw, R.color.CAM_X0105);
            ap.setViewTextColor(this.lEx, R.color.CAM_X0105);
            ap.setViewTextColor(this.lEy, R.color.CAM_X0105);
            ap.setViewTextColor(this.lEz, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEA, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEB, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEC, R.color.CAM_X0109);
            ap.setViewTextColor(this.lED, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEE, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEF, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEG, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEH, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEf, R.color.CAM_X0105);
            ap.setViewTextColor(this.lEp, R.color.CAM_X0107);
            this.lEf.setTypeface(Typeface.DEFAULT_BOLD);
            this.lEw.setTypeface(Typeface.DEFAULT_BOLD);
            this.lEx.setTypeface(Typeface.DEFAULT_BOLD);
            this.lEy.setTypeface(Typeface.DEFAULT_BOLD);
            this.lEI.setConfig(new b());
            this.lEJ.setConfig(new b());
            this.lEK.setConfig(new b());
            a(this.lEt);
            a(this.lEu);
            a(this.lEv);
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
        this.lEi = aVar;
    }
}
