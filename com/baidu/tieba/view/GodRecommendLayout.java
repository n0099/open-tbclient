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
import d.a.c.e.p.k;
import d.a.c.j.e.j;
import d.a.c.j.e.l;
import d.a.j0.m.f;
import d.a.j0.r.q.s1;
import d.a.j0.z0.l0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class GodRecommendLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public final Context f21671e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21672f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21673g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f21674h;

    /* renamed from: i  reason: collision with root package name */
    public GodRecommendListAdapter f21675i;
    public l j;
    public List<String> k;
    public boolean l;
    public CustomMessageListener m;
    public f n;
    public RecyclerView.OnScrollListener o;

    /* loaded from: classes5.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public Context f21676a;

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext f21677b;

        /* renamed from: c  reason: collision with root package name */
        public BdUniqueId f21678c;

        /* renamed from: d  reason: collision with root package name */
        public List<MetaData> f21679d;

        /* renamed from: e  reason: collision with root package name */
        public f<MetaData> f21680e;

        /* loaded from: classes5.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public LinearLayout f21682a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f21683b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f21684c;

            /* renamed from: d  reason: collision with root package name */
            public HeadPendantClickableView f21685d;

            /* renamed from: e  reason: collision with root package name */
            public DynamicUserLikeButton f21686e;

            /* renamed from: f  reason: collision with root package name */
            public d.a.j0.r.f0.q.c f21687f;

            /* renamed from: g  reason: collision with root package name */
            public boolean f21688g;

            /* loaded from: classes5.dex */
            public class a implements DynamicUserLikeButton.a {
                public a(GodRecommendListAdapter godRecommendListAdapter) {
                }

                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void a(View view) {
                    d.a.j0.r.f0.q.c cVar = GodViewHolder.this.f21687f;
                    if (cVar == null || cVar.j() == null || GodViewHolder.this.f21687f.j().getIsLike()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13903").param(TiebaStatic.Params.FRIEND_UID, GodViewHolder.this.f21687f.j().getUserId()).param("obj_name", GodViewHolder.this.f21684c.getText().toString()));
                }
            }

            public GodViewHolder(View view) {
                super(view);
                this.f21688g = false;
                this.f21682a = (LinearLayout) view.findViewById(R.id.concern_container);
                HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.f21685d = headPendantClickableView;
                headPendantClickableView.getHeadView().setIsRound(true);
                this.f21685d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f21685d.getHeadView().setDefaultResource(17170445);
                this.f21685d.getHeadView().setPlaceHolder(1);
                this.f21685d.getHeadView().setBorderWidth(d.a.c.e.p.l.g(GodRecommendListAdapter.this.f21676a, R.dimen.tbds1));
                this.f21685d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.f21683b = (TextView) view.findViewById(R.id.concern_user_name);
                this.f21684c = (TextView) view.findViewById(R.id.concern_user_desc);
                DynamicUserLikeButton dynamicUserLikeButton = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.f21686e = dynamicUserLikeButton;
                dynamicUserLikeButton.setGodRecommendStyle(true);
                this.f21686e.setOnClickEvent(new a(GodRecommendListAdapter.this));
                d.a.j0.r.f0.q.c cVar = new d.a.j0.r.f0.q.c(GodRecommendListAdapter.this.f21677b, this.f21686e);
                this.f21687f = cVar;
                cVar.k(true);
            }

            public void b() {
                if (!this.f21688g) {
                    SkinManager.setViewTextColor(this.f21683b, R.color.CAM_X0101);
                } else {
                    SkinManager.setViewTextColor(this.f21683b, R.color.CAM_X0301);
                }
                SkinManager.setViewTextColor(this.f21684c, R.color.CAM_X0101);
                this.f21686e.k();
                TBSelector.makeDrawableSelector().setShape(0).defaultStrokeColor(R.color.CAM_X0614).defaultColor(R.color.CAM_X0614).strokeWidth(d.a.c.e.p.l.g(GodRecommendListAdapter.this.f21676a, R.dimen.tbds1)).radius(d.a.c.e.p.l.g(GodRecommendListAdapter.this.f21676a, R.dimen.tbds10)).into(this.f21682a);
            }

            public final void c(boolean z) {
                this.f21688g = z;
            }
        }

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ MetaData f21691e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GodViewHolder f21692f;

            public a(MetaData metaData, GodViewHolder godViewHolder) {
                this.f21691e = metaData;
                this.f21692f = godViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GodRecommendListAdapter.this.h(this.f21691e, this.f21692f);
            }
        }

        public GodRecommendListAdapter(Context context) {
            this.f21676a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public void onBindViewHolder(GodViewHolder godViewHolder, int i2) {
            List<MetaData> list;
            MetaData metaData;
            if (godViewHolder == null || (list = this.f21679d) == null || (metaData = list.get(i2)) == null) {
                return;
            }
            godViewHolder.c(metaData.isNewGod());
            n(metaData, godViewHolder);
            q(metaData, godViewHolder);
            o(metaData, godViewHolder);
            p(metaData, godViewHolder);
            f<MetaData> fVar = this.f21680e;
            if (fVar != null) {
                fVar.c(godViewHolder.itemView, metaData, i2, i2);
            }
            godViewHolder.b();
            godViewHolder.itemView.setTag(R.id.tag_user_id, metaData);
            godViewHolder.itemView.setTag(R.id.tag_holder, Boolean.TRUE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g */
        public GodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new GodViewHolder(LayoutInflater.from(this.f21676a).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<MetaData> list = this.f21679d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final void h(MetaData metaData, GodViewHolder godViewHolder) {
            if (this.f21680e != null) {
                this.f21680e.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
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
            this.f21680e = fVar;
        }

        public void l(TbPageContext tbPageContext) {
            this.f21677b = tbPageContext;
        }

        public void m(BdUniqueId bdUniqueId) {
            this.f21678c = bdUniqueId;
        }

        public final void n(MetaData metaData, GodViewHolder godViewHolder) {
            godViewHolder.f21685d.setData(metaData, true);
            godViewHolder.f21685d.setOnClickListener(new a(metaData, godViewHolder));
        }

        public final void o(MetaData metaData, GodViewHolder godViewHolder) {
            String d2;
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
                d2 = str + l0.d(metaData.isVideoGod());
            } else {
                d2 = l0.d(metaData.isVideoGod());
            }
            godViewHolder.f21684c.setText(d2);
        }

        public final void p(MetaData metaData, GodViewHolder godViewHolder) {
            d.a.j0.r.f0.q.c cVar = godViewHolder.f21687f;
            if (cVar != null) {
                cVar.l(this.f21678c);
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
            godViewHolder.f21683b.setText(string);
            if (metaData.isNewGod()) {
                SkinManager.setViewTextColor(godViewHolder.f21683b, R.color.CAM_X0301);
            }
        }

        public void setData(List<MetaData> list) {
            this.f21679d = list;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
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
                GodRecommendLayout.this.j.q(GodRecommendLayout.this.f21674h, 1);
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
        @Override // d.a.j0.m.f
        /* renamed from: b */
        public void c(View view, MetaData metaData, int i2, long j) {
            if (metaData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.m.f
        /* renamed from: d */
        public void a(View view, MetaData metaData, int i2, long j) {
            if (metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(GodRecommendLayout.this.f21671e, metaData.getUserId(), metaData.getName_show())));
        }
    }

    /* loaded from: classes5.dex */
    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            GodRecommendLayout.this.k.clear();
        }
    }

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            Context context = this.f21671e;
            if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) this.f21671e).disableSwipeJustOnce();
            } else {
                Context context2 = this.f21671e;
                if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                    ((BaseActivity) this.f21671e).disableSwipeJustOnce();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void g() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_god_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f21672f = (TextView) findViewById(R.id.title);
        this.f21673g = (TextView) findViewById(R.id.change);
        this.f21674h = (RecyclerView) findViewById(R.id.thread_card_list);
        GodRecommendListAdapter godRecommendListAdapter = new GodRecommendListAdapter(this.f21671e);
        this.f21675i = godRecommendListAdapter;
        godRecommendListAdapter.k(this.n);
        this.f21674h.setAdapter(this.f21675i);
        this.f21674h.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            l lVar = new l(new j());
            this.j = lVar;
            lVar.q(this.f21674h, 1);
        }
        int g2 = d.a.c.e.p.l.g(this.f21671e, R.dimen.tbds21);
        int g3 = d.a.c.e.p.l.g(this.f21671e, R.dimen.tbds44);
        this.f21674h.setLayoutManager(new LinearLayoutManager(this.f21671e, 0, false));
        this.f21674h.setItemAnimator(new DefaultItemAnimator());
        this.f21674h.addItemDecoration(new SpaceItemDecoration(g3, g2, g3));
        this.f21674h.addOnScrollListener(this.o);
        h();
    }

    public void h() {
        SkinManager.setViewTextColor(this.f21672f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f21673g, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0604);
        this.f21675i.notifyDataSetChanged();
    }

    public void setCouldStatistic(boolean z) {
        this.l = z;
    }

    public void setData(s1 s1Var) {
        if (s1Var == null) {
            return;
        }
        this.f21675i.setData(s1Var.z());
        this.f21675i.notifyDataSetChanged();
        this.f21674h.scrollToPosition(0);
        this.k.clear();
        this.l = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.f21675i.l(tbPageContext);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.m.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.m);
        this.f21675i.m(bdUniqueId);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.f21673g.setOnClickListener(onClickListener);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new ArrayList();
        this.l = true;
        this.m = new a(2156674);
        this.n = new b();
        this.o = new c();
        this.f21671e = context;
        g();
    }
}
