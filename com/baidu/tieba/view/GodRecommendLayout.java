package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import d.b.b.e.p.k;
import d.b.b.j.e.j;
import d.b.b.j.e.l;
import d.b.h0.m.f;
import d.b.h0.r.q.s1;
import d.b.h0.z0.l0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class GodRecommendLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public final Context f22079e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22080f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22081g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f22082h;
    public GodRecommendListAdapter i;
    public l j;
    public List<String> k;
    public boolean l;
    public CustomMessageListener m;
    public f n;
    public RecyclerView.OnScrollListener o;

    /* loaded from: classes5.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public Context f22083a;

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext f22084b;

        /* renamed from: c  reason: collision with root package name */
        public BdUniqueId f22085c;

        /* renamed from: d  reason: collision with root package name */
        public List<MetaData> f22086d;

        /* renamed from: e  reason: collision with root package name */
        public f<MetaData> f22087e;

        /* loaded from: classes5.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public LinearLayout f22089a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f22090b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f22091c;

            /* renamed from: d  reason: collision with root package name */
            public HeadPendantClickableView f22092d;

            /* renamed from: e  reason: collision with root package name */
            public DynamicUserLikeButton f22093e;

            /* renamed from: f  reason: collision with root package name */
            public d.b.h0.r.f0.q.c f22094f;

            /* renamed from: g  reason: collision with root package name */
            public boolean f22095g;

            /* loaded from: classes5.dex */
            public class a implements DynamicUserLikeButton.a {
                public a(GodRecommendListAdapter godRecommendListAdapter) {
                }

                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void a(View view) {
                    d.b.h0.r.f0.q.c cVar = GodViewHolder.this.f22094f;
                    if (cVar == null || cVar.j() == null || GodViewHolder.this.f22094f.j().getIsLike()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13903").param(TiebaStatic.Params.FRIEND_UID, GodViewHolder.this.f22094f.j().getUserId()).param("obj_name", GodViewHolder.this.f22091c.getText().toString()));
                }
            }

            public GodViewHolder(View view) {
                super(view);
                this.f22095g = false;
                this.f22089a = (LinearLayout) view.findViewById(R.id.concern_container);
                HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.f22092d = headPendantClickableView;
                headPendantClickableView.getHeadView().setIsRound(true);
                this.f22092d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f22092d.getHeadView().setDefaultResource(17170445);
                this.f22092d.getHeadView().setPlaceHolder(1);
                this.f22092d.getHeadView().setBorderWidth(d.b.b.e.p.l.g(GodRecommendListAdapter.this.f22083a, R.dimen.tbds1));
                this.f22092d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.f22090b = (TextView) view.findViewById(R.id.concern_user_name);
                this.f22091c = (TextView) view.findViewById(R.id.concern_user_desc);
                DynamicUserLikeButton dynamicUserLikeButton = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.f22093e = dynamicUserLikeButton;
                dynamicUserLikeButton.setGodRecommendStyle(true);
                this.f22093e.setOnClickEvent(new a(GodRecommendListAdapter.this));
                d.b.h0.r.f0.q.c cVar = new d.b.h0.r.f0.q.c(GodRecommendListAdapter.this.f22084b, this.f22093e);
                this.f22094f = cVar;
                cVar.k(true);
            }

            public void b() {
                if (!this.f22095g) {
                    SkinManager.setViewTextColor(this.f22090b, R.color.CAM_X0101);
                } else {
                    SkinManager.setViewTextColor(this.f22090b, R.color.CAM_X0301);
                }
                SkinManager.setViewTextColor(this.f22091c, R.color.CAM_X0101);
                this.f22093e.k();
                TBSelector.makeDrawableSelector().setShape(0).defaultStrokeColor(R.color.CAM_X0614).defaultColor(R.color.CAM_X0614).strokeWidth(d.b.b.e.p.l.g(GodRecommendListAdapter.this.f22083a, R.dimen.tbds1)).radius(d.b.b.e.p.l.g(GodRecommendListAdapter.this.f22083a, R.dimen.tbds10)).into(this.f22089a);
            }

            public final void c(boolean z) {
                this.f22095g = z;
            }
        }

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ MetaData f22098e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GodViewHolder f22099f;

            public a(MetaData metaData, GodViewHolder godViewHolder) {
                this.f22098e = metaData;
                this.f22099f = godViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GodRecommendListAdapter.this.h(this.f22098e, this.f22099f);
            }
        }

        public GodRecommendListAdapter(Context context) {
            this.f22083a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public void onBindViewHolder(GodViewHolder godViewHolder, int i) {
            List<MetaData> list;
            MetaData metaData;
            if (godViewHolder == null || (list = this.f22086d) == null || (metaData = list.get(i)) == null) {
                return;
            }
            godViewHolder.c(metaData.isNewGod());
            n(metaData, godViewHolder);
            q(metaData, godViewHolder);
            o(metaData, godViewHolder);
            p(metaData, godViewHolder);
            f<MetaData> fVar = this.f22087e;
            if (fVar != null) {
                fVar.c(godViewHolder.itemView, metaData, i, i);
            }
            godViewHolder.b();
            godViewHolder.itemView.setTag(R.id.tag_user_id, metaData);
            godViewHolder.itemView.setTag(R.id.tag_holder, Boolean.TRUE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g */
        public GodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new GodViewHolder(LayoutInflater.from(this.f22083a).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<MetaData> list = this.f22086d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final void h(MetaData metaData, GodViewHolder godViewHolder) {
            if (this.f22087e != null) {
                this.f22087e.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i */
        public void onViewAttachedToWindow(@NonNull GodViewHolder godViewHolder) {
            View view;
            super.onViewAttachedToWindow(godViewHolder);
            if (GodRecommendLayout.this.l && (view = godViewHolder.itemView) != null && (view.getTag(R.id.tag_user_id) instanceof MetaData) && (godViewHolder.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) godViewHolder.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) godViewHolder.itemView.getTag(R.id.tag_user_id);
                if (!booleanValue || GodRecommendLayout.this.k.contains(metaData.getUserId())) {
                    return;
                }
                GodRecommendLayout.this.k.add(metaData.getUserId());
                TiebaStatic.log(new StatisticItem("c13902").param("uid", metaData.getUserId()));
                godViewHolder.itemView.setTag(R.id.tag_holder, Boolean.FALSE);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j */
        public void onViewDetachedFromWindow(@NonNull GodViewHolder godViewHolder) {
            View view;
            super.onViewDetachedFromWindow(godViewHolder);
            if (GodRecommendLayout.this.k.isEmpty() && (view = godViewHolder.itemView) != null) {
                view.setTag(R.id.tag_holder, Boolean.TRUE);
            }
        }

        public void k(f<MetaData> fVar) {
            this.f22087e = fVar;
        }

        public void l(TbPageContext tbPageContext) {
            this.f22084b = tbPageContext;
        }

        public void m(BdUniqueId bdUniqueId) {
            this.f22085c = bdUniqueId;
        }

        public final void n(MetaData metaData, GodViewHolder godViewHolder) {
            godViewHolder.f22092d.setData(metaData, true);
            godViewHolder.f22092d.setOnClickListener(new a(metaData, godViewHolder));
        }

        public final void o(MetaData metaData, GodViewHolder godViewHolder) {
            String c2;
            if (metaData == null || godViewHolder == null) {
                return;
            }
            String str = null;
            if (metaData.isBaijiahaoUser()) {
                str = metaData.getBaijiahaoInfo().auth_desc;
            } else if (metaData.isNewGod()) {
                str = metaData.getNewGodData().getFieldName();
            }
            if (!k.isEmpty(str)) {
                c2 = str + l0.c(metaData.isVideoGod());
            } else {
                c2 = l0.c(metaData.isVideoGod());
            }
            godViewHolder.f22091c.setText(c2);
        }

        public final void p(MetaData metaData, GodViewHolder godViewHolder) {
            d.b.h0.r.f0.q.c cVar = godViewHolder.f22094f;
            if (cVar != null) {
                cVar.l(this.f22085c);
                cVar.n(metaData);
            }
        }

        public final void q(MetaData metaData, GodViewHolder godViewHolder) {
            if (metaData == null || godViewHolder == null) {
                return;
            }
            String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
            if (!StringUtils.isNull(metaData.getName_show())) {
                string = metaData.getName_show();
            }
            godViewHolder.f22090b.setText(string);
            if (metaData.isNewGod()) {
                SkinManager.setViewTextColor(godViewHolder.f22090b, R.color.CAM_X0301);
            }
        }

        public void setData(List<MetaData> list) {
            this.f22086d = list;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (GodRecommendLayout.this.j == null) {
                    GodRecommendLayout.this.j = new l(new j());
                }
                GodRecommendLayout.this.j.q(GodRecommendLayout.this.f22082h, 1);
            } else if (GodRecommendLayout.this.j != null) {
                GodRecommendLayout.this.j.w();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f<MetaData> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: b */
        public void c(View view, MetaData metaData, int i, long j) {
            if (metaData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: d */
        public void a(View view, MetaData metaData, int i, long j) {
            if (metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(GodRecommendLayout.this.f22079e, metaData.getUserId(), metaData.getName_show())));
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            GodRecommendLayout.this.k.clear();
        }
    }

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Context context = this.f22079e;
            if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) this.f22079e).disableSwipeJustOnce();
            } else {
                Context context2 = this.f22079e;
                if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                    ((BaseActivity) this.f22079e).disableSwipeJustOnce();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void g() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_god_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f22080f = (TextView) findViewById(R.id.title);
        this.f22081g = (TextView) findViewById(R.id.change);
        this.f22082h = (RecyclerView) findViewById(R.id.thread_card_list);
        GodRecommendListAdapter godRecommendListAdapter = new GodRecommendListAdapter(this.f22079e);
        this.i = godRecommendListAdapter;
        godRecommendListAdapter.k(this.n);
        this.f22082h.setAdapter(this.i);
        this.f22082h.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            l lVar = new l(new j());
            this.j = lVar;
            lVar.q(this.f22082h, 1);
        }
        int g2 = d.b.b.e.p.l.g(this.f22079e, R.dimen.tbds21);
        int g3 = d.b.b.e.p.l.g(this.f22079e, R.dimen.tbds44);
        this.f22082h.setLayoutManager(new LinearLayoutManager(this.f22079e, 0, false));
        this.f22082h.setItemAnimator(new DefaultItemAnimator());
        this.f22082h.addItemDecoration(new SpaceItemDecoration(g3, g2, g3));
        this.f22082h.addOnScrollListener(this.o);
        h();
    }

    public void h() {
        SkinManager.setViewTextColor(this.f22080f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f22081g, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0604);
        this.i.notifyDataSetChanged();
    }

    public void setCouldStatistic(boolean z) {
        this.l = z;
    }

    public void setData(s1 s1Var) {
        if (s1Var == null) {
            return;
        }
        this.i.setData(s1Var.z());
        this.i.notifyDataSetChanged();
        this.f22082h.scrollToPosition(0);
        this.k.clear();
        this.l = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.i.l(tbPageContext);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.m.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.m);
        this.i.m(bdUniqueId);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.f22081g.setOnClickListener(onClickListener);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new ArrayList();
        this.l = true;
        this.m = new a(2156674);
        this.n = new b();
        this.o = new c();
        this.f22079e = context;
        g();
    }
}
