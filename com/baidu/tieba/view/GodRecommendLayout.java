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
import d.a.c.k.e.j;
import d.a.c.k.e.l;
import d.a.n0.m.f;
import d.a.n0.r.q.s1;
import d.a.n0.z0.l0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class GodRecommendLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public final Context f21784e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21785f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21786g;

    /* renamed from: h  reason: collision with root package name */
    public RecyclerView f21787h;

    /* renamed from: i  reason: collision with root package name */
    public GodRecommendListAdapter f21788i;
    public l j;
    public List<String> k;
    public boolean l;
    public CustomMessageListener m;
    public f n;
    public RecyclerView.OnScrollListener o;

    /* loaded from: classes5.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public Context f21789a;

        /* renamed from: b  reason: collision with root package name */
        public TbPageContext f21790b;

        /* renamed from: c  reason: collision with root package name */
        public BdUniqueId f21791c;

        /* renamed from: d  reason: collision with root package name */
        public List<MetaData> f21792d;

        /* renamed from: e  reason: collision with root package name */
        public f<MetaData> f21793e;

        /* loaded from: classes5.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public LinearLayout f21795a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f21796b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f21797c;

            /* renamed from: d  reason: collision with root package name */
            public HeadPendantClickableView f21798d;

            /* renamed from: e  reason: collision with root package name */
            public DynamicUserLikeButton f21799e;

            /* renamed from: f  reason: collision with root package name */
            public d.a.n0.r.f0.q.c f21800f;

            /* renamed from: g  reason: collision with root package name */
            public boolean f21801g;

            /* loaded from: classes5.dex */
            public class a implements DynamicUserLikeButton.a {
                public a(GodRecommendListAdapter godRecommendListAdapter) {
                }

                @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                public void a(View view) {
                    d.a.n0.r.f0.q.c cVar = GodViewHolder.this.f21800f;
                    if (cVar == null || cVar.j() == null || GodViewHolder.this.f21800f.j().getIsLike()) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13903").param(TiebaStatic.Params.FRIEND_UID, GodViewHolder.this.f21800f.j().getUserId()).param("obj_name", GodViewHolder.this.f21797c.getText().toString()));
                }
            }

            public GodViewHolder(View view) {
                super(view);
                this.f21801g = false;
                this.f21795a = (LinearLayout) view.findViewById(R.id.concern_container);
                HeadPendantClickableView headPendantClickableView = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.f21798d = headPendantClickableView;
                headPendantClickableView.getHeadView().setIsRound(true);
                this.f21798d.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.f21798d.getHeadView().setDefaultResource(17170445);
                this.f21798d.getHeadView().setPlaceHolder(1);
                this.f21798d.getHeadView().setBorderWidth(d.a.c.e.p.l.g(GodRecommendListAdapter.this.f21789a, R.dimen.tbds1));
                this.f21798d.getHeadView().setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.f21796b = (TextView) view.findViewById(R.id.concern_user_name);
                this.f21797c = (TextView) view.findViewById(R.id.concern_user_desc);
                DynamicUserLikeButton dynamicUserLikeButton = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.f21799e = dynamicUserLikeButton;
                dynamicUserLikeButton.setGodRecommendStyle(true);
                this.f21799e.setOnClickEvent(new a(GodRecommendListAdapter.this));
                d.a.n0.r.f0.q.c cVar = new d.a.n0.r.f0.q.c(GodRecommendListAdapter.this.f21790b, this.f21799e);
                this.f21800f = cVar;
                cVar.k(true);
            }

            public void b() {
                if (!this.f21801g) {
                    SkinManager.setViewTextColor(this.f21796b, R.color.CAM_X0101);
                } else {
                    SkinManager.setViewTextColor(this.f21796b, R.color.CAM_X0301);
                }
                SkinManager.setViewTextColor(this.f21797c, R.color.CAM_X0101);
                this.f21799e.k();
                TBSelector.makeDrawableSelector().setShape(0).defaultStrokeColor(R.color.CAM_X0614).defaultColor(R.color.CAM_X0614).strokeWidth(d.a.c.e.p.l.g(GodRecommendListAdapter.this.f21789a, R.dimen.tbds1)).radius(d.a.c.e.p.l.g(GodRecommendListAdapter.this.f21789a, R.dimen.tbds10)).into(this.f21795a);
            }

            public final void c(boolean z) {
                this.f21801g = z;
            }
        }

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ MetaData f21804e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GodViewHolder f21805f;

            public a(MetaData metaData, GodViewHolder godViewHolder) {
                this.f21804e = metaData;
                this.f21805f = godViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GodRecommendListAdapter.this.h(this.f21804e, this.f21805f);
            }
        }

        public GodRecommendListAdapter(Context context) {
            this.f21789a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f */
        public void onBindViewHolder(GodViewHolder godViewHolder, int i2) {
            List<MetaData> list;
            MetaData metaData;
            if (godViewHolder == null || (list = this.f21792d) == null || (metaData = list.get(i2)) == null) {
                return;
            }
            godViewHolder.c(metaData.isNewGod());
            n(metaData, godViewHolder);
            q(metaData, godViewHolder);
            o(metaData, godViewHolder);
            p(metaData, godViewHolder);
            f<MetaData> fVar = this.f21793e;
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
            return new GodViewHolder(LayoutInflater.from(this.f21789a).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<MetaData> list = this.f21792d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final void h(MetaData metaData, GodViewHolder godViewHolder) {
            if (this.f21793e != null) {
                this.f21793e.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
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
            this.f21793e = fVar;
        }

        public void l(TbPageContext tbPageContext) {
            this.f21790b = tbPageContext;
        }

        public void m(BdUniqueId bdUniqueId) {
            this.f21791c = bdUniqueId;
        }

        public final void n(MetaData metaData, GodViewHolder godViewHolder) {
            godViewHolder.f21798d.setData(metaData, true);
            godViewHolder.f21798d.setOnClickListener(new a(metaData, godViewHolder));
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
            godViewHolder.f21797c.setText(d2);
        }

        public final void p(MetaData metaData, GodViewHolder godViewHolder) {
            d.a.n0.r.f0.q.c cVar = godViewHolder.f21800f;
            if (cVar != null) {
                cVar.l(this.f21791c);
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
            godViewHolder.f21796b.setText(string);
            if (metaData.isNewGod()) {
                SkinManager.setViewTextColor(godViewHolder.f21796b, R.color.CAM_X0301);
            }
        }

        public void setData(List<MetaData> list) {
            this.f21792d = list;
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
                GodRecommendLayout.this.j.q(GodRecommendLayout.this.f21787h, 1);
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
        @Override // d.a.n0.m.f
        /* renamed from: b */
        public void c(View view, MetaData metaData, int i2, long j) {
            if (metaData == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: d */
        public void a(View view, MetaData metaData, int i2, long j) {
            if (metaData == null || StringUtils.isNull(metaData.getUserId())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(GodRecommendLayout.this.f21784e, metaData.getUserId(), metaData.getName_show())));
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
            Context context = this.f21784e;
            if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) this.f21784e).disableSwipeJustOnce();
            } else {
                Context context2 = this.f21784e;
                if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                    ((BaseActivity) this.f21784e).disableSwipeJustOnce();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void g() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_god_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f21785f = (TextView) findViewById(R.id.title);
        this.f21786g = (TextView) findViewById(R.id.change);
        this.f21787h = (RecyclerView) findViewById(R.id.thread_card_list);
        GodRecommendListAdapter godRecommendListAdapter = new GodRecommendListAdapter(this.f21784e);
        this.f21788i = godRecommendListAdapter;
        godRecommendListAdapter.k(this.n);
        this.f21787h.setAdapter(this.f21788i);
        this.f21787h.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            l lVar = new l(new j());
            this.j = lVar;
            lVar.q(this.f21787h, 1);
        }
        int g2 = d.a.c.e.p.l.g(this.f21784e, R.dimen.tbds21);
        int g3 = d.a.c.e.p.l.g(this.f21784e, R.dimen.tbds44);
        this.f21787h.setLayoutManager(new LinearLayoutManager(this.f21784e, 0, false));
        this.f21787h.setItemAnimator(new DefaultItemAnimator());
        this.f21787h.addItemDecoration(new SpaceItemDecoration(g3, g2, g3));
        this.f21787h.addOnScrollListener(this.o);
        h();
    }

    public void h() {
        SkinManager.setViewTextColor(this.f21785f, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f21786g, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0604);
        this.f21788i.notifyDataSetChanged();
    }

    public void setCouldStatistic(boolean z) {
        this.l = z;
    }

    public void setData(s1 s1Var) {
        if (s1Var == null) {
            return;
        }
        this.f21788i.setData(s1Var.z());
        this.f21788i.notifyDataSetChanged();
        this.f21787h.scrollToPosition(0);
        this.k.clear();
        this.l = true;
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.f21788i.l(tbPageContext);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.m.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.m);
        this.f21788i.m(bdUniqueId);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.f21786g.setOnClickListener(onClickListener);
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
        this.f21784e = context;
        g();
    }
}
