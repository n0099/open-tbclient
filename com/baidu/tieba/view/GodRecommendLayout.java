package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ae;
import com.baidu.adp.widget.ListView.l;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class GodRecommendLayout extends LinearLayout {
    private List<String> aOI;
    private RecyclerView.OnScrollListener hQQ;
    private RecyclerView isf;
    private n isk;
    private CustomMessageListener ism;
    private final Context mContext;
    private TextView mTitleView;
    private TextView nzI;
    private a nzJ;
    private boolean nzK;
    private com.baidu.tbadk.h.f nzL;

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOI = new ArrayList();
        this.nzK = true;
        this.ism = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.view.GodRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (GodRecommendLayout.this.isk == null) {
                            GodRecommendLayout.this.isk = new n(new l());
                        }
                        GodRecommendLayout.this.isk.a(GodRecommendLayout.this.isf, 1);
                    } else if (GodRecommendLayout.this.isk != null) {
                        GodRecommendLayout.this.isk.rh();
                    }
                }
            }
        };
        this.nzL = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.view.GodRecommendLayout.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, MetaData metaData, int i2, long j) {
                if (metaData != null && !StringUtils.isNull(metaData.getUserId())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(GodRecommendLayout.this.mContext, metaData.getUserId(), metaData.getName_show())));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, MetaData metaData, int i2, long j) {
                if (metaData == null) {
                }
            }
        };
        this.hQQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.3
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                GodRecommendLayout.this.aOI.clear();
            }
        };
        this.mContext = context;
        initUI();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if ((this.mContext instanceof BaseFragmentActivity) && ((BaseFragmentActivity) this.mContext).isSwipeBackEnabled()) {
                ((BaseFragmentActivity) this.mContext).disableSwipeJustOnce();
            } else if ((this.mContext instanceof BaseActivity) && ((BaseActivity) this.mContext).isSwipeBackEnabled()) {
                ((BaseActivity) this.mContext).disableSwipeJustOnce();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_god_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.nzI = (TextView) findViewById(R.id.change);
        this.isf = (RecyclerView) findViewById(R.id.thread_card_list);
        this.nzJ = new a(this.mContext);
        this.nzJ.setOnItemCoverListener(this.nzL);
        this.isf.setAdapter(this.nzJ);
        this.isf.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.isk = new n(new l());
            this.isk.a(this.isf, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.isf.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.isf.setItemAnimator(new DefaultItemAnimator());
        this.isf.addItemDecoration(new ae(dimens2, dimens, dimens2));
        this.isf.addOnScrollListener(this.hQQ);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_a);
        ap.setViewTextColor(this.nzI, R.color.cp_cont_a);
        ap.setBackgroundColor(this, R.color.cp_mask_b_alpha25);
        this.nzJ.notifyDataSetChanged();
    }

    public void setData(bo boVar) {
        if (boVar != null) {
            this.nzJ.setData(boVar.blN());
            this.nzJ.notifyDataSetChanged();
            this.isf.scrollToPosition(0);
            this.aOI.clear();
            this.nzK = true;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ism.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ism);
        this.nzJ.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.nzJ.setPageContext(tbPageContext);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.nzI.setOnClickListener(onClickListener);
    }

    public void setCouldStatistic(boolean z) {
        this.nzK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends RecyclerView.Adapter<C0869a> {
        private com.baidu.tbadk.h.f<MetaData> aiM;
        private BdUniqueId faC;
        private Context mContext;
        private List<MetaData> mData;
        private TbPageContext mPageContext;

        public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
            this.aiM = fVar;
        }

        public a(Context context) {
            this.mContext = context;
        }

        public void setData(List<MetaData> list) {
            this.mData = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: O */
        public C0869a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0869a(LayoutInflater.from(this.mContext).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0869a c0869a, int i) {
            MetaData metaData;
            if (c0869a == null || this.mData == null || (metaData = this.mData.get(i)) == null) {
                return;
            }
            c0869a.qO(metaData.isNewGod());
            a(metaData, c0869a);
            c(metaData, c0869a);
            e(metaData, c0869a);
            b(metaData, c0869a);
            if (this.aiM != null) {
                this.aiM.b(c0869a.itemView, metaData, i, i);
            }
            c0869a.onChangeSkinType();
            c0869a.itemView.setTag(R.id.tag_user_id, metaData);
            c0869a.itemView.setTag(R.id.tag_holder, true);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.mData == null) {
                return 0;
            }
            return this.mData.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onViewAttachedToWindow(@NonNull C0869a c0869a) {
            super.onViewAttachedToWindow(c0869a);
            if (GodRecommendLayout.this.nzK && c0869a.itemView != null && (c0869a.itemView.getTag(R.id.tag_user_id) instanceof MetaData) && (c0869a.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) c0869a.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) c0869a.itemView.getTag(R.id.tag_user_id);
                if (booleanValue && !GodRecommendLayout.this.aOI.contains(metaData.getUserId())) {
                    GodRecommendLayout.this.aOI.add(metaData.getUserId());
                    TiebaStatic.log(new aq("c13902").dR("uid", metaData.getUserId()));
                    c0869a.itemView.setTag(R.id.tag_holder, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onViewDetachedFromWindow(@NonNull C0869a c0869a) {
            super.onViewDetachedFromWindow(c0869a);
            if (GodRecommendLayout.this.aOI.isEmpty() && c0869a.itemView != null) {
                c0869a.itemView.setTag(R.id.tag_holder, true);
            }
        }

        private void a(final MetaData metaData, final C0869a c0869a) {
            c0869a.jwC.setData(metaData, true);
            c0869a.jwC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.d(metaData, c0869a);
                }
            });
        }

        private void b(MetaData metaData, C0869a c0869a) {
            com.baidu.tbadk.core.view.userLike.c cVar = c0869a.ajW;
            if (cVar != null) {
                cVar.l(this.faC);
                cVar.a(metaData);
            }
        }

        private void c(MetaData metaData, C0869a c0869a) {
            if (metaData != null && c0869a != null) {
                String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                c0869a.ewx.setText(string);
                if (metaData.isNewGod()) {
                    ap.setViewTextColor(c0869a.ewx, R.color.cp_cont_h);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(MetaData metaData, C0869a c0869a) {
            if (this.aiM != null) {
                this.aiM.a(c0869a.itemView, metaData, c0869a.getAdapterPosition(), c0869a.getItemId());
            }
        }

        private void e(MetaData metaData, C0869a c0869a) {
            String string;
            if (metaData != null && c0869a != null) {
                String str = null;
                if (metaData.isBaijiahaoUser()) {
                    str = metaData.getBaijiahaoInfo().auth_desc;
                } else if (metaData.isNewGod()) {
                    str = metaData.getNewGodData().getFieldName();
                }
                if (!at.isEmpty(str)) {
                    string = str + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
                } else {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
                }
                c0869a.jwB.setText(string);
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            this.faC = bdUniqueId;
        }

        /* renamed from: com.baidu.tieba.view.GodRecommendLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public class C0869a extends RecyclerView.ViewHolder {
            public com.baidu.tbadk.core.view.userLike.c ajW;
            public TextView ewx;
            public TextView jwB;
            public HeadPendantClickableView jwC;
            public DynamicUserLikeButton jwD;
            private boolean jwE;
            public LinearLayout mContainer;

            public C0869a(View view) {
                super(view);
                this.jwE = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                this.jwC = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.jwC.getHeadView().setIsRound(true);
                this.jwC.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.jwC.getHeadView().setDefaultResource(17170445);
                this.jwC.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.jwC.getHeadView().setPlaceHolder(2);
                this.jwC.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1));
                this.jwC.getHeadView().setBorderColor(ap.getColor(R.color.cp_border_a));
                this.ewx = (TextView) view.findViewById(R.id.concern_user_name);
                this.jwB = (TextView) view.findViewById(R.id.concern_user_desc);
                this.jwD = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.jwD.setGodRecommendStyle(true);
                this.jwD.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cv(View view2) {
                        if (C0869a.this.ajW != null && C0869a.this.ajW.btI() != null && !C0869a.this.ajW.btI().getIsLike()) {
                            TiebaStatic.log(new aq("c13903").dR("friend_uid", C0869a.this.ajW.btI().getUserId()).dR("obj_name", C0869a.this.jwB.getText().toString()));
                        }
                    }
                });
                this.ajW = new com.baidu.tbadk.core.view.userLike.c(a.this.mPageContext, this.jwD);
                this.ajW.ju(true);
            }

            public void onChangeSkinType() {
                if (!this.jwE) {
                    ap.setViewTextColor(this.ewx, R.color.cp_cont_a);
                } else {
                    ap.setViewTextColor(this.ewx, R.color.cp_cont_h);
                }
                ap.setViewTextColor(this.jwB, R.color.cp_cont_a);
                this.jwD.bsD();
                com.baidu.tbadk.core.util.e.a.brO().pj(0).po(R.color.cp_mask_c_alpha16).pk(R.color.cp_mask_c_alpha16).pq(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1)).ab(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds10)).bk(this.mContainer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void qO(boolean z) {
                this.jwE = z;
            }
        }
    }
}
