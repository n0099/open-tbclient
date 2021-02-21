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
    private int lEm;
    private List<com.baidu.tieba.newinterest.data.a> lEv = new ArrayList();
    private a lEw;
    private boolean lEx;

    /* loaded from: classes8.dex */
    public interface a {
        void ac(int i, boolean z);
    }

    static /* synthetic */ int d(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.lEm;
        interestedForumAdapter.lEm = i - 1;
        return i;
    }

    static /* synthetic */ int e(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.lEm;
        interestedForumAdapter.lEm = i + 1;
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
        if (this.lEv == null) {
            return 0;
        }
        return this.lEv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final InterestedForumViewHolder interestedForumViewHolder, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar = this.lEv.get(i);
        interestedForumViewHolder.lEt.setText(aVar.class_name);
        if (aVar.class_id.intValue() > 0) {
            SvgManager.bsR().a(interestedForumViewHolder.lEs, com.baidu.tieba.newinterest.b.a.Fk(aVar.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar.forum_info != null && aVar.forum_info.size() != 0) {
            if (aVar.lFf == 0) {
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
                    aVar.lFf = 2;
                }
            } else {
                int i2 = aVar.lFf;
                c(interestedForumViewHolder, aVar.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar.forum_info.size() - 1 : i2 - 1;
                b(interestedForumViewHolder, aVar.forum_info.get(size));
                a(interestedForumViewHolder, aVar.forum_info.get(size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1));
            }
            if (aVar.forum_info.size() <= 3) {
                interestedForumViewHolder.lED.setEnabled(false);
            } else {
                interestedForumViewHolder.lED.setEnabled(true);
            }
            interestedForumViewHolder.lED.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar.forum_info.size() - 1;
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.a(interestedForumViewHolder, aVar.forum_info.get(aVar.lFf));
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.b(interestedForumViewHolder, aVar.forum_info.get(aVar.lFf));
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.c(interestedForumViewHolder, aVar.forum_info.get(aVar.lFf));
                    InterestedForumAdapter.this.lEx = InterestedForumAdapter.this.djw();
                    InterestedForumAdapter.this.notifyItemChanged(i);
                    if (InterestedForumAdapter.this.lEw != null) {
                        InterestedForumAdapter.this.lEw.ac(InterestedForumAdapter.this.lEm, InterestedForumAdapter.this.lEx);
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
        interestedForumViewHolder.lEE.setVisibility(0);
        interestedForumViewHolder.lEH.setVisibility(0);
        interestedForumViewHolder.lEH.startLoad(dVar.lFh.avatar, 10, false);
        interestedForumViewHolder.lEK.setText(dVar.lFh.forum_name);
        if (TextUtils.isEmpty(dVar.lFh.slogan)) {
            str = "百度" + dVar.lFh.forum_name + "吧";
        } else {
            str = dVar.lFh.slogan;
        }
        interestedForumViewHolder.lEN.setText(str);
        interestedForumViewHolder.lEQ.setText("关注 " + au.numberUniformFormatExtra(dVar.lFh.member_count.intValue()));
        interestedForumViewHolder.lET.setText("帖子 " + au.numberUniformFormatExtra(dVar.lFh.thread_count.intValue()));
        a(interestedForumViewHolder.lEW, dVar);
        a(dVar, interestedForumViewHolder.lEW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lEF.setVisibility(0);
        interestedForumViewHolder.lEI.setVisibility(0);
        interestedForumViewHolder.lEI.startLoad(dVar.lFh.avatar, 10, false);
        interestedForumViewHolder.lEL.setText(dVar.lFh.forum_name);
        if (TextUtils.isEmpty(dVar.lFh.slogan)) {
            str = "百度" + dVar.lFh.forum_name + "吧";
        } else {
            str = dVar.lFh.slogan;
        }
        interestedForumViewHolder.lEO.setText(str);
        interestedForumViewHolder.lER.setText("关注 " + au.numberUniformFormatExtra(dVar.lFh.member_count.intValue()));
        interestedForumViewHolder.lEU.setText("帖子 " + au.numberUniformFormatExtra(dVar.lFh.thread_count.intValue()));
        a(interestedForumViewHolder.lEX, dVar);
        a(dVar, interestedForumViewHolder.lEX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lEG.setVisibility(0);
        interestedForumViewHolder.lEJ.setVisibility(0);
        interestedForumViewHolder.lEJ.startLoad(dVar.lFh.avatar, 10, false);
        interestedForumViewHolder.lEM.setText(dVar.lFh.forum_name);
        if (TextUtils.isEmpty(dVar.lFh.slogan)) {
            str = "百度" + dVar.lFh.forum_name + "吧";
        } else {
            str = dVar.lFh.slogan;
        }
        interestedForumViewHolder.lEP.setText(str);
        interestedForumViewHolder.lES.setText("关注 " + au.numberUniformFormatExtra(dVar.lFh.member_count.intValue()));
        interestedForumViewHolder.lEV.setText("帖子 " + au.numberUniformFormatExtra(dVar.lFh.thread_count.intValue()));
        a(interestedForumViewHolder.lEY, dVar);
        a(dVar, interestedForumViewHolder.lEY);
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
        this.lEv.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.lFf < i) {
            aVar.lFf++;
        } else {
            aVar.lFf = 0;
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
                    InterestedForumAdapter.this.lEx = false;
                } else {
                    InterestedForumAdapter.e(InterestedForumAdapter.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.pT(R.color.CAM_X0109);
                    tBSpecificationBtn.setConfig(bVar);
                    InterestedForumAdapter.this.lEx = InterestedForumAdapter.this.djw();
                }
                if (InterestedForumAdapter.this.lEw != null) {
                    InterestedForumAdapter.this.lEw.ac(InterestedForumAdapter.this.lEm, InterestedForumAdapter.this.lEx);
                }
                ar arVar = new ar("c13682");
                arVar.ap("obj_type", 2);
                arVar.ap("obj_locate", 4);
                arVar.v("fid", dVar.lFh.forum_id.longValue());
                TiebaStatic.log(arVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> dju() {
        return this.lEv;
    }

    public void djv() {
        if (this.lEv != null && this.lEv.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.lEv) {
                int i = aVar.lFf;
                aVar.forum_info.get(i).selected = !this.lEx;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.lEx;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.lEx;
                a(aVar, size2);
            }
            this.lEx = this.lEx ? false : true;
            notifyDataSetChanged();
            if (this.lEw != null) {
                if (this.lEx) {
                    this.lEm = this.lEv.size() * 3;
                    this.lEw.ac(this.lEv.size() * 3, this.lEx);
                    return;
                }
                this.lEm = 0;
                this.lEw.ac(0, this.lEx);
            }
        }
    }

    public boolean djw() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.lEv) {
            int i = aVar.lFf;
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
        if (!this.lEx) {
            ar arVar = new ar("c13682");
            arVar.ap("obj_type", 2);
            arVar.ap("obj_locate", 3);
            arVar.v("fid", aVar.forum_info.get(i).lFh.forum_id.longValue());
            TiebaStatic.log(arVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {
        public TextView lED;
        public RelativeLayout lEE;
        public RelativeLayout lEF;
        public RelativeLayout lEG;
        public BarImageView lEH;
        public BarImageView lEI;
        public BarImageView lEJ;
        public TextView lEK;
        public TextView lEL;
        public TextView lEM;
        public TextView lEN;
        public TextView lEO;
        public TextView lEP;
        public TextView lEQ;
        public TextView lER;
        public TextView lES;
        public TextView lET;
        public TextView lEU;
        public TextView lEV;
        public TBSpecificationBtn lEW;
        public TBSpecificationBtn lEX;
        public TBSpecificationBtn lEY;
        public ImageView lEs;
        public TextView lEt;

        public InterestedForumViewHolder(View view) {
            super(view);
            this.lEs = (ImageView) view.findViewById(R.id.interest_icon);
            this.lEt = (TextView) view.findViewById(R.id.interest_text);
            this.lED = (TextView) view.findViewById(R.id.interest_change);
            this.lEE = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.lEF = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.lEG = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.lEH = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.lEI = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.lEJ = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.lEK = (TextView) view.findViewById(R.id.top_forum_name);
            this.lEL = (TextView) view.findViewById(R.id.middle_forum_name);
            this.lEM = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.lEN = (TextView) view.findViewById(R.id.top_forum_desc);
            this.lEO = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.lEP = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.lEQ = (TextView) view.findViewById(R.id.top_member_text);
            this.lER = (TextView) view.findViewById(R.id.middle_member_text);
            this.lES = (TextView) view.findViewById(R.id.bottom_member_text);
            this.lET = (TextView) view.findViewById(R.id.top_post_text);
            this.lEU = (TextView) view.findViewById(R.id.middle_post_text);
            this.lEV = (TextView) view.findViewById(R.id.bottom_post_text);
            this.lEW = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.lEX = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.lEY = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ap.setViewTextColor(this.lEK, R.color.CAM_X0105);
            ap.setViewTextColor(this.lEL, R.color.CAM_X0105);
            ap.setViewTextColor(this.lEM, R.color.CAM_X0105);
            ap.setViewTextColor(this.lEN, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEO, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEP, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEQ, R.color.CAM_X0109);
            ap.setViewTextColor(this.lER, R.color.CAM_X0109);
            ap.setViewTextColor(this.lES, R.color.CAM_X0109);
            ap.setViewTextColor(this.lET, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEU, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEV, R.color.CAM_X0109);
            ap.setViewTextColor(this.lEt, R.color.CAM_X0105);
            ap.setViewTextColor(this.lED, R.color.CAM_X0107);
            this.lEt.setTypeface(Typeface.DEFAULT_BOLD);
            this.lEK.setTypeface(Typeface.DEFAULT_BOLD);
            this.lEL.setTypeface(Typeface.DEFAULT_BOLD);
            this.lEM.setTypeface(Typeface.DEFAULT_BOLD);
            this.lEW.setConfig(new b());
            this.lEX.setConfig(new b());
            this.lEY.setConfig(new b());
            a(this.lEH);
            a(this.lEI);
            a(this.lEJ);
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
        this.lEw = aVar;
    }
}
