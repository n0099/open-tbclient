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
    private List<String> aNF;
    private RecyclerView.OnScrollListener hKT;
    private RecyclerView imh;
    private n imm;
    private CustomMessageListener imo;
    private final Context mContext;
    private TextView mTitleView;
    private TextView ntN;
    private a ntO;
    private boolean ntP;
    private com.baidu.tbadk.h.f ntQ;

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNF = new ArrayList();
        this.ntP = true;
        this.imo = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.view.GodRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (GodRecommendLayout.this.imm == null) {
                            GodRecommendLayout.this.imm = new n(new l());
                        }
                        GodRecommendLayout.this.imm.a(GodRecommendLayout.this.imh, 1);
                    } else if (GodRecommendLayout.this.imm != null) {
                        GodRecommendLayout.this.imm.rh();
                    }
                }
            }
        };
        this.ntQ = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.view.GodRecommendLayout.2
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
        this.hKT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.3
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                GodRecommendLayout.this.aNF.clear();
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
        this.ntN = (TextView) findViewById(R.id.change);
        this.imh = (RecyclerView) findViewById(R.id.thread_card_list);
        this.ntO = new a(this.mContext);
        this.ntO.setOnItemCoverListener(this.ntQ);
        this.imh.setAdapter(this.ntO);
        this.imh.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.imm = new n(new l());
            this.imm.a(this.imh, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.imh.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.imh.setItemAnimator(new DefaultItemAnimator());
        this.imh.addItemDecoration(new ae(dimens2, dimens, dimens2));
        this.imh.addOnScrollListener(this.hKT);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_a);
        ap.setViewTextColor(this.ntN, R.color.cp_cont_a);
        ap.setBackgroundColor(this, R.color.cp_mask_b_alpha25);
        this.ntO.notifyDataSetChanged();
    }

    public void setData(bo boVar) {
        if (boVar != null) {
            this.ntO.setData(boVar.bjn());
            this.ntO.notifyDataSetChanged();
            this.imh.scrollToPosition(0);
            this.aNF.clear();
            this.ntP = true;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.imo.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.imo);
        this.ntO.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.ntO.setPageContext(tbPageContext);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.ntN.setOnClickListener(onClickListener);
    }

    public void setCouldStatistic(boolean z) {
        this.ntP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends RecyclerView.Adapter<C0854a> {
        private com.baidu.tbadk.h.f<MetaData> aiM;
        private BdUniqueId eUN;
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
        public C0854a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0854a(LayoutInflater.from(this.mContext).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0854a c0854a, int i) {
            MetaData metaData;
            if (c0854a == null || this.mData == null || (metaData = this.mData.get(i)) == null) {
                return;
            }
            c0854a.qF(metaData.isNewGod());
            a(metaData, c0854a);
            c(metaData, c0854a);
            e(metaData, c0854a);
            b(metaData, c0854a);
            if (this.aiM != null) {
                this.aiM.b(c0854a.itemView, metaData, i, i);
            }
            c0854a.onChangeSkinType();
            c0854a.itemView.setTag(R.id.tag_user_id, metaData);
            c0854a.itemView.setTag(R.id.tag_holder, true);
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
        public void onViewAttachedToWindow(@NonNull C0854a c0854a) {
            super.onViewAttachedToWindow(c0854a);
            if (GodRecommendLayout.this.ntP && c0854a.itemView != null && (c0854a.itemView.getTag(R.id.tag_user_id) instanceof MetaData) && (c0854a.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) c0854a.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) c0854a.itemView.getTag(R.id.tag_user_id);
                if (booleanValue && !GodRecommendLayout.this.aNF.contains(metaData.getUserId())) {
                    GodRecommendLayout.this.aNF.add(metaData.getUserId());
                    TiebaStatic.log(new aq("c13902").dR("uid", metaData.getUserId()));
                    c0854a.itemView.setTag(R.id.tag_holder, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onViewDetachedFromWindow(@NonNull C0854a c0854a) {
            super.onViewDetachedFromWindow(c0854a);
            if (GodRecommendLayout.this.aNF.isEmpty() && c0854a.itemView != null) {
                c0854a.itemView.setTag(R.id.tag_holder, true);
            }
        }

        private void a(final MetaData metaData, final C0854a c0854a) {
            c0854a.jqF.setData(metaData, true);
            c0854a.jqF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.d(metaData, c0854a);
                }
            });
        }

        private void b(MetaData metaData, C0854a c0854a) {
            com.baidu.tbadk.core.view.userLike.c cVar = c0854a.ajW;
            if (cVar != null) {
                cVar.l(this.eUN);
                cVar.a(metaData);
            }
        }

        private void c(MetaData metaData, C0854a c0854a) {
            if (metaData != null && c0854a != null) {
                String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                c0854a.eqE.setText(string);
                if (metaData.isNewGod()) {
                    ap.setViewTextColor(c0854a.eqE, R.color.cp_cont_h);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(MetaData metaData, C0854a c0854a) {
            if (this.aiM != null) {
                this.aiM.a(c0854a.itemView, metaData, c0854a.getAdapterPosition(), c0854a.getItemId());
            }
        }

        private void e(MetaData metaData, C0854a c0854a) {
            String string;
            if (metaData != null && c0854a != null) {
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
                c0854a.jqE.setText(string);
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            this.eUN = bdUniqueId;
        }

        /* renamed from: com.baidu.tieba.view.GodRecommendLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public class C0854a extends RecyclerView.ViewHolder {
            public com.baidu.tbadk.core.view.userLike.c ajW;
            public TextView eqE;
            public TextView jqE;
            public HeadPendantClickableView jqF;
            public DynamicUserLikeButton jqG;
            private boolean jqH;
            public LinearLayout mContainer;

            public C0854a(View view) {
                super(view);
                this.jqH = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                this.jqF = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.jqF.getHeadView().setIsRound(true);
                this.jqF.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.jqF.getHeadView().setDefaultResource(17170445);
                this.jqF.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.jqF.getHeadView().setPlaceHolder(2);
                this.jqF.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1));
                this.jqF.getHeadView().setBorderColor(ap.getColor(R.color.cp_border_a));
                this.eqE = (TextView) view.findViewById(R.id.concern_user_name);
                this.jqE = (TextView) view.findViewById(R.id.concern_user_desc);
                this.jqG = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.jqG.setGodRecommendStyle(true);
                this.jqG.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cq(View view2) {
                        if (C0854a.this.ajW != null && C0854a.this.ajW.bri() != null && !C0854a.this.ajW.bri().getIsLike()) {
                            TiebaStatic.log(new aq("c13903").dR("friend_uid", C0854a.this.ajW.bri().getUserId()).dR("obj_name", C0854a.this.jqE.getText().toString()));
                        }
                    }
                });
                this.ajW = new com.baidu.tbadk.core.view.userLike.c(a.this.mPageContext, this.jqG);
                this.ajW.jl(true);
            }

            public void onChangeSkinType() {
                if (!this.jqH) {
                    ap.setViewTextColor(this.eqE, R.color.cp_cont_a);
                } else {
                    ap.setViewTextColor(this.eqE, R.color.cp_cont_h);
                }
                ap.setViewTextColor(this.jqE, R.color.cp_cont_a);
                this.jqG.bqd();
                com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pd(R.color.cp_mask_c_alpha16).pa(R.color.cp_mask_c_alpha16).pf(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1)).Z(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds10)).bg(this.mContainer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void qF(boolean z) {
                this.jqH = z;
            }
        }
    }
}
