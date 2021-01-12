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
/* loaded from: classes7.dex */
public class InterestedForumAdapter extends RecyclerView.Adapter<InterestedForumViewHolder> {
    private int lvU;
    private List<com.baidu.tieba.newinterest.data.a> lwd = new ArrayList();
    private a lwe;
    private boolean lwf;

    /* loaded from: classes7.dex */
    public interface a {
        void ac(int i, boolean z);
    }

    static /* synthetic */ int d(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.lvU;
        interestedForumAdapter.lvU = i - 1;
        return i;
    }

    static /* synthetic */ int e(InterestedForumAdapter interestedForumAdapter) {
        int i = interestedForumAdapter.lvU;
        interestedForumAdapter.lvU = i + 1;
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
        if (this.lwd == null) {
            return 0;
        }
        return this.lwd.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(@NonNull final InterestedForumViewHolder interestedForumViewHolder, final int i) {
        final com.baidu.tieba.newinterest.data.a aVar = this.lwd.get(i);
        interestedForumViewHolder.lwb.setText(aVar.class_name);
        if (aVar.class_id.intValue() > 0) {
            SvgManager.bsx().a(interestedForumViewHolder.lwa, com.baidu.tieba.newinterest.b.a.ES(aVar.class_id.intValue()), (SvgManager.SvgResourceStateType) null);
        }
        if (aVar.forum_info != null && aVar.forum_info.size() != 0) {
            if (aVar.lwN == 0) {
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
                    aVar.lwN = 2;
                }
            } else {
                int i2 = aVar.lwN;
                c(interestedForumViewHolder, aVar.forum_info.get(i2));
                int size = i2 + (-1) < 0 ? aVar.forum_info.size() - 1 : i2 - 1;
                b(interestedForumViewHolder, aVar.forum_info.get(size));
                a(interestedForumViewHolder, aVar.forum_info.get(size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1));
            }
            if (aVar.forum_info.size() <= 3) {
                interestedForumViewHolder.lwl.setEnabled(false);
            } else {
                interestedForumViewHolder.lwl.setEnabled(true);
            }
            interestedForumViewHolder.lwl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int size2 = aVar.forum_info.size() - 1;
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.a(interestedForumViewHolder, aVar.forum_info.get(aVar.lwN));
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.b(interestedForumViewHolder, aVar.forum_info.get(aVar.lwN));
                    InterestedForumAdapter.this.a(size2, aVar);
                    InterestedForumAdapter.this.c(interestedForumViewHolder, aVar.forum_info.get(aVar.lwN));
                    InterestedForumAdapter.this.lwf = InterestedForumAdapter.this.dho();
                    InterestedForumAdapter.this.notifyItemChanged(i);
                    if (InterestedForumAdapter.this.lwe != null) {
                        InterestedForumAdapter.this.lwe.ac(InterestedForumAdapter.this.lvU, InterestedForumAdapter.this.lwf);
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
        interestedForumViewHolder.lwm.setVisibility(0);
        interestedForumViewHolder.lwp.setVisibility(0);
        interestedForumViewHolder.lwp.startLoad(dVar.lwP.avatar, 10, false);
        interestedForumViewHolder.lws.setText(dVar.lwP.forum_name);
        if (TextUtils.isEmpty(dVar.lwP.slogan)) {
            str = "百度" + dVar.lwP.forum_name + "吧";
        } else {
            str = dVar.lwP.slogan;
        }
        interestedForumViewHolder.lwv.setText(str);
        interestedForumViewHolder.lwy.setText("关注 " + at.numberUniformFormatExtra(dVar.lwP.member_count.intValue()));
        interestedForumViewHolder.lwB.setText("帖子 " + at.numberUniformFormatExtra(dVar.lwP.thread_count.intValue()));
        a(interestedForumViewHolder.lwE, dVar);
        a(dVar, interestedForumViewHolder.lwE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lwn.setVisibility(0);
        interestedForumViewHolder.lwq.setVisibility(0);
        interestedForumViewHolder.lwq.startLoad(dVar.lwP.avatar, 10, false);
        interestedForumViewHolder.lwt.setText(dVar.lwP.forum_name);
        if (TextUtils.isEmpty(dVar.lwP.slogan)) {
            str = "百度" + dVar.lwP.forum_name + "吧";
        } else {
            str = dVar.lwP.slogan;
        }
        interestedForumViewHolder.lww.setText(str);
        interestedForumViewHolder.lwz.setText("关注 " + at.numberUniformFormatExtra(dVar.lwP.member_count.intValue()));
        interestedForumViewHolder.lwC.setText("帖子 " + at.numberUniformFormatExtra(dVar.lwP.thread_count.intValue()));
        a(interestedForumViewHolder.lwF, dVar);
        a(dVar, interestedForumViewHolder.lwF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(InterestedForumViewHolder interestedForumViewHolder, d dVar) {
        String str;
        interestedForumViewHolder.lwo.setVisibility(0);
        interestedForumViewHolder.lwr.setVisibility(0);
        interestedForumViewHolder.lwr.startLoad(dVar.lwP.avatar, 10, false);
        interestedForumViewHolder.lwu.setText(dVar.lwP.forum_name);
        if (TextUtils.isEmpty(dVar.lwP.slogan)) {
            str = "百度" + dVar.lwP.forum_name + "吧";
        } else {
            str = dVar.lwP.slogan;
        }
        interestedForumViewHolder.lwx.setText(str);
        interestedForumViewHolder.lwA.setText("关注 " + at.numberUniformFormatExtra(dVar.lwP.member_count.intValue()));
        interestedForumViewHolder.lwD.setText("帖子 " + at.numberUniformFormatExtra(dVar.lwP.thread_count.intValue()));
        a(interestedForumViewHolder.lwG, dVar);
        a(dVar, interestedForumViewHolder.lwG);
    }

    private void a(TBSpecificationBtn tBSpecificationBtn, d dVar) {
        b bVar = new b();
        if (!dVar.selected) {
            tBSpecificationBtn.setText("感兴趣");
            tBSpecificationBtn.setConfig(bVar);
            return;
        }
        tBSpecificationBtn.setText("已选择");
        bVar.pO(R.color.CAM_X0109);
        tBSpecificationBtn.setConfig(bVar);
    }

    public void cA(List<com.baidu.tieba.newinterest.data.a> list) {
        this.lwd.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.newinterest.data.a aVar) {
        if (aVar.lwN < i) {
            aVar.lwN++;
        } else {
            aVar.lwN = 0;
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
                    InterestedForumAdapter.this.lwf = false;
                } else {
                    InterestedForumAdapter.e(InterestedForumAdapter.this);
                    tBSpecificationBtn.setText("已选择");
                    bVar.pO(R.color.CAM_X0109);
                    tBSpecificationBtn.setConfig(bVar);
                    InterestedForumAdapter.this.lwf = InterestedForumAdapter.this.dho();
                }
                if (InterestedForumAdapter.this.lwe != null) {
                    InterestedForumAdapter.this.lwe.ac(InterestedForumAdapter.this.lvU, InterestedForumAdapter.this.lwf);
                }
                aq aqVar = new aq("c13682");
                aqVar.an("obj_type", 2);
                aqVar.an("obj_locate", 4);
                aqVar.w("fid", dVar.lwP.forum_id.longValue());
                TiebaStatic.log(aqVar);
            }
        });
    }

    public List<com.baidu.tieba.newinterest.data.a> dhm() {
        return this.lwd;
    }

    public void dhn() {
        if (this.lwd != null && this.lwd.size() != 0) {
            for (com.baidu.tieba.newinterest.data.a aVar : this.lwd) {
                int i = aVar.lwN;
                aVar.forum_info.get(i).selected = !this.lwf;
                a(aVar, i);
                int size = i + (-1) < 0 ? aVar.forum_info.size() - 1 : i - 1;
                aVar.forum_info.get(size).selected = !this.lwf;
                a(aVar, size);
                int size2 = size + (-1) < 0 ? aVar.forum_info.size() - 1 : size - 1;
                aVar.forum_info.get(size2).selected = !this.lwf;
                a(aVar, size2);
            }
            this.lwf = this.lwf ? false : true;
            notifyDataSetChanged();
            if (this.lwe != null) {
                if (this.lwf) {
                    this.lvU = this.lwd.size() * 3;
                    this.lwe.ac(this.lwd.size() * 3, this.lwf);
                    return;
                }
                this.lvU = 0;
                this.lwe.ac(0, this.lwf);
            }
        }
    }

    public boolean dho() {
        for (com.baidu.tieba.newinterest.data.a aVar : this.lwd) {
            int i = aVar.lwN;
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
        if (!this.lwf) {
            aq aqVar = new aq("c13682");
            aqVar.an("obj_type", 2);
            aqVar.an("obj_locate", 3);
            aqVar.w("fid", aVar.forum_info.get(i).lwP.forum_id.longValue());
            TiebaStatic.log(aqVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class InterestedForumViewHolder extends RecyclerView.ViewHolder {
        public TextView lwA;
        public TextView lwB;
        public TextView lwC;
        public TextView lwD;
        public TBSpecificationBtn lwE;
        public TBSpecificationBtn lwF;
        public TBSpecificationBtn lwG;
        public ImageView lwa;
        public TextView lwb;
        public TextView lwl;
        public RelativeLayout lwm;
        public RelativeLayout lwn;
        public RelativeLayout lwo;
        public BarImageView lwp;
        public BarImageView lwq;
        public BarImageView lwr;
        public TextView lws;
        public TextView lwt;
        public TextView lwu;
        public TextView lwv;
        public TextView lww;
        public TextView lwx;
        public TextView lwy;
        public TextView lwz;

        public InterestedForumViewHolder(View view) {
            super(view);
            this.lwa = (ImageView) view.findViewById(R.id.interest_icon);
            this.lwb = (TextView) view.findViewById(R.id.interest_text);
            this.lwl = (TextView) view.findViewById(R.id.interest_change);
            this.lwm = (RelativeLayout) view.findViewById(R.id.top_recommend_layout);
            this.lwn = (RelativeLayout) view.findViewById(R.id.middle_recommend_layout);
            this.lwo = (RelativeLayout) view.findViewById(R.id.bottom_recommend_layout);
            this.lwp = (BarImageView) view.findViewById(R.id.top_forum_image);
            this.lwq = (BarImageView) view.findViewById(R.id.middle_forum_image);
            this.lwr = (BarImageView) view.findViewById(R.id.bottom_forum_image);
            this.lws = (TextView) view.findViewById(R.id.top_forum_name);
            this.lwt = (TextView) view.findViewById(R.id.middle_forum_name);
            this.lwu = (TextView) view.findViewById(R.id.bottom_forum_name);
            this.lwv = (TextView) view.findViewById(R.id.top_forum_desc);
            this.lww = (TextView) view.findViewById(R.id.middle_forum_desc);
            this.lwx = (TextView) view.findViewById(R.id.bottom_forum_desc);
            this.lwy = (TextView) view.findViewById(R.id.top_member_text);
            this.lwz = (TextView) view.findViewById(R.id.middle_member_text);
            this.lwA = (TextView) view.findViewById(R.id.bottom_member_text);
            this.lwB = (TextView) view.findViewById(R.id.top_post_text);
            this.lwC = (TextView) view.findViewById(R.id.middle_post_text);
            this.lwD = (TextView) view.findViewById(R.id.bottom_post_text);
            this.lwE = (TBSpecificationBtn) view.findViewById(R.id.top_select_interest);
            this.lwF = (TBSpecificationBtn) view.findViewById(R.id.middle_select_interest);
            this.lwG = (TBSpecificationBtn) view.findViewById(R.id.bottom_select_interest);
            ao.setViewTextColor(this.lws, R.color.CAM_X0105);
            ao.setViewTextColor(this.lwt, R.color.CAM_X0105);
            ao.setViewTextColor(this.lwu, R.color.CAM_X0105);
            ao.setViewTextColor(this.lwv, R.color.CAM_X0109);
            ao.setViewTextColor(this.lww, R.color.CAM_X0109);
            ao.setViewTextColor(this.lwx, R.color.CAM_X0109);
            ao.setViewTextColor(this.lwy, R.color.CAM_X0109);
            ao.setViewTextColor(this.lwz, R.color.CAM_X0109);
            ao.setViewTextColor(this.lwA, R.color.CAM_X0109);
            ao.setViewTextColor(this.lwB, R.color.CAM_X0109);
            ao.setViewTextColor(this.lwC, R.color.CAM_X0109);
            ao.setViewTextColor(this.lwD, R.color.CAM_X0109);
            ao.setViewTextColor(this.lwb, R.color.CAM_X0105);
            ao.setViewTextColor(this.lwl, R.color.CAM_X0107);
            this.lwb.setTypeface(Typeface.DEFAULT_BOLD);
            this.lws.setTypeface(Typeface.DEFAULT_BOLD);
            this.lwt.setTypeface(Typeface.DEFAULT_BOLD);
            this.lwu.setTypeface(Typeface.DEFAULT_BOLD);
            this.lwE.setConfig(new b());
            this.lwF.setConfig(new b());
            this.lwG.setConfig(new b());
            a(this.lwp);
            a(this.lwq);
            a(this.lwr);
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
        this.lwe = aVar;
    }
}
