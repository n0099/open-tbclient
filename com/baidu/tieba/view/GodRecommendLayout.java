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
import com.baidu.adp.widget.ListView.j;
import com.baidu.adp.widget.ListView.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GodRecommendLayout extends LinearLayout {
    private List<String> aQL;
    private RecyclerView iPZ;
    private l iQe;
    private CustomMessageListener iQg;
    private RecyclerView.OnScrollListener ioM;
    private final Context mContext;
    private TextView mTitleView;
    private TextView nSo;
    private GodRecommendListAdapter nSp;
    private boolean nSq;
    private com.baidu.tbadk.h.f nSr;

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQL = new ArrayList();
        this.nSq = true;
        this.iQg = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.view.GodRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (GodRecommendLayout.this.iQe == null) {
                            GodRecommendLayout.this.iQe = new l(new j());
                        }
                        GodRecommendLayout.this.iQe.a(GodRecommendLayout.this.iPZ, 1);
                    } else if (GodRecommendLayout.this.iQe != null) {
                        GodRecommendLayout.this.iQe.qL();
                    }
                }
            }
        };
        this.nSr = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.view.GodRecommendLayout.2
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
        this.ioM = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                GodRecommendLayout.this.aQL.clear();
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
        this.nSo = (TextView) findViewById(R.id.change);
        this.iPZ = (RecyclerView) findViewById(R.id.thread_card_list);
        this.nSp = new GodRecommendListAdapter(this.mContext);
        this.nSp.setOnItemCoverListener(this.nSr);
        this.iPZ.setAdapter(this.nSp);
        this.iPZ.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iQe = new l(new j());
            this.iQe.a(this.iPZ, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.iPZ.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.iPZ.setItemAnimator(new DefaultItemAnimator());
        this.iPZ.addItemDecoration(new SpaceItemDecoration(dimens2, dimens, dimens2));
        this.iPZ.addOnScrollListener(this.ioM);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0101);
        ao.setViewTextColor(this.nSo, R.color.CAM_X0101);
        ao.setBackgroundColor(this, R.color.CAM_X0604);
        this.nSp.notifyDataSetChanged();
    }

    public void setData(br brVar) {
        if (brVar != null) {
            this.nSp.setData(brVar.bqE());
            this.nSp.notifyDataSetChanged();
            this.iPZ.scrollToPosition(0);
            this.aQL.clear();
            this.nSq = true;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iQg.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iQg);
        this.nSp.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.nSp.setPageContext(tbPageContext);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.nSo.setOnClickListener(onClickListener);
    }

    public void setCouldStatistic(boolean z) {
        this.nSq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {
        private com.baidu.tbadk.h.f<MetaData> aks;
        private BdUniqueId fqR;
        private Context mContext;
        private List<MetaData> mData;
        private TbPageContext mPageContext;

        public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
            this.aks = fVar;
        }

        public GodRecommendListAdapter(Context context) {
            this.mContext = context;
        }

        public void setData(List<MetaData> list) {
            this.mData = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: S */
        public GodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new GodViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(GodViewHolder godViewHolder, int i) {
            MetaData metaData;
            if (godViewHolder == null || this.mData == null || (metaData = this.mData.get(i)) == null) {
                return;
            }
            godViewHolder.rP(metaData.isNewGod());
            a(metaData, godViewHolder);
            c(metaData, godViewHolder);
            e(metaData, godViewHolder);
            b(metaData, godViewHolder);
            if (this.aks != null) {
                this.aks.b(godViewHolder.itemView, metaData, i, i);
            }
            godViewHolder.onChangeSkinType();
            godViewHolder.itemView.setTag(R.id.tag_user_id, metaData);
            godViewHolder.itemView.setTag(R.id.tag_holder, true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.mData == null) {
                return 0;
            }
            return this.mData.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onViewAttachedToWindow(@NonNull GodViewHolder godViewHolder) {
            super.onViewAttachedToWindow(godViewHolder);
            if (GodRecommendLayout.this.nSq && godViewHolder.itemView != null && (godViewHolder.itemView.getTag(R.id.tag_user_id) instanceof MetaData) && (godViewHolder.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) godViewHolder.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) godViewHolder.itemView.getTag(R.id.tag_user_id);
                if (booleanValue && !GodRecommendLayout.this.aQL.contains(metaData.getUserId())) {
                    GodRecommendLayout.this.aQL.add(metaData.getUserId());
                    TiebaStatic.log(new aq("c13902").dX("uid", metaData.getUserId()));
                    godViewHolder.itemView.setTag(R.id.tag_holder, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onViewDetachedFromWindow(@NonNull GodViewHolder godViewHolder) {
            super.onViewDetachedFromWindow(godViewHolder);
            if (GodRecommendLayout.this.aQL.isEmpty() && godViewHolder.itemView != null) {
                godViewHolder.itemView.setTag(R.id.tag_holder, true);
            }
        }

        private void a(final MetaData metaData, final GodViewHolder godViewHolder) {
            godViewHolder.jYk.setData(metaData, true);
            godViewHolder.jYk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.GodRecommendListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GodRecommendListAdapter.this.d(metaData, godViewHolder);
                }
            });
        }

        private void b(MetaData metaData, GodViewHolder godViewHolder) {
            com.baidu.tbadk.core.view.userLike.c cVar = godViewHolder.alC;
            if (cVar != null) {
                cVar.l(this.fqR);
                cVar.a(metaData);
            }
        }

        private void c(MetaData metaData, GodViewHolder godViewHolder) {
            if (metaData != null && godViewHolder != null) {
                String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                godViewHolder.eLt.setText(string);
                if (metaData.isNewGod()) {
                    ao.setViewTextColor(godViewHolder.eLt, R.color.CAM_X0301);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(MetaData metaData, GodViewHolder godViewHolder) {
            if (this.aks != null) {
                this.aks.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
            }
        }

        private void e(MetaData metaData, GodViewHolder godViewHolder) {
            String lB;
            if (metaData != null && godViewHolder != null) {
                String str = null;
                if (metaData.isBaijiahaoUser()) {
                    str = metaData.getBaijiahaoInfo().auth_desc;
                } else if (metaData.isNewGod()) {
                    str = metaData.getNewGodData().getFieldName();
                }
                if (!at.isEmpty(str)) {
                    lB = str + ag.lB(metaData.isVideoGod());
                } else {
                    lB = ag.lB(metaData.isVideoGod());
                }
                godViewHolder.jYj.setText(lB);
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            this.fqR = bdUniqueId;
        }

        /* loaded from: classes.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {
            public com.baidu.tbadk.core.view.userLike.c alC;
            public TextView eLt;
            public TextView jYj;
            public HeadPendantClickableView jYk;
            public DynamicUserLikeButton jYl;
            private boolean jYm;
            public LinearLayout mContainer;

            public GodViewHolder(View view) {
                super(view);
                this.jYm = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                this.jYk = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.jYk.getHeadView().setIsRound(true);
                this.jYk.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.jYk.getHeadView().setDefaultResource(17170445);
                this.jYk.getHeadView().setPlaceHolder(1);
                this.jYk.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(GodRecommendListAdapter.this.mContext, R.dimen.tbds1));
                this.jYk.getHeadView().setBorderColor(ao.getColor(R.color.CAM_X0401));
                this.eLt = (TextView) view.findViewById(R.id.concern_user_name);
                this.jYj = (TextView) view.findViewById(R.id.concern_user_desc);
                this.jYl = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.jYl.setGodRecommendStyle(true);
                this.jYl.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.view.GodRecommendLayout.GodRecommendListAdapter.GodViewHolder.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cQ(View view2) {
                        if (GodViewHolder.this.alC != null && GodViewHolder.this.alC.byS() != null && !GodViewHolder.this.alC.byS().getIsLike()) {
                            TiebaStatic.log(new aq("c13903").dX("friend_uid", GodViewHolder.this.alC.byS().getUserId()).dX("obj_name", GodViewHolder.this.jYj.getText().toString()));
                        }
                    }
                });
                this.alC = new com.baidu.tbadk.core.view.userLike.c(GodRecommendListAdapter.this.mPageContext, this.jYl);
                this.alC.kh(true);
            }

            public void onChangeSkinType() {
                if (!this.jYm) {
                    ao.setViewTextColor(this.eLt, R.color.CAM_X0101);
                } else {
                    ao.setViewTextColor(this.eLt, R.color.CAM_X0301);
                }
                ao.setViewTextColor(this.jYj, R.color.CAM_X0101);
                this.jYl.bxP();
                com.baidu.tbadk.core.util.f.a.bwV().qq(0).qw(R.color.CAM_X0614).qr(R.color.CAM_X0614).qy(com.baidu.adp.lib.util.l.getDimens(GodRecommendListAdapter.this.mContext, R.dimen.tbds1)).ae(com.baidu.adp.lib.util.l.getDimens(GodRecommendListAdapter.this.mContext, R.dimen.tbds10)).bz(this.mContainer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void rP(boolean z) {
                this.jYm = z;
            }
        }
    }
}
