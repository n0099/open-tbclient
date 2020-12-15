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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class GodRecommendLayout extends LinearLayout {
    private List<String> aPW;
    private RecyclerView iDN;
    private n iDS;
    private CustomMessageListener iDU;
    private RecyclerView.OnScrollListener icm;
    private final Context mContext;
    private TextView mTitleView;
    private TextView nOT;
    private a nOU;
    private boolean nOV;
    private com.baidu.tbadk.h.f nOW;

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aPW = new ArrayList();
        this.nOV = true;
        this.iDU = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.view.GodRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (GodRecommendLayout.this.iDS == null) {
                            GodRecommendLayout.this.iDS = new n(new l());
                        }
                        GodRecommendLayout.this.iDS.a(GodRecommendLayout.this.iDN, 1);
                    } else if (GodRecommendLayout.this.iDS != null) {
                        GodRecommendLayout.this.iDS.rj();
                    }
                }
            }
        };
        this.nOW = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.view.GodRecommendLayout.2
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
        this.icm = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.3
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                GodRecommendLayout.this.aPW.clear();
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
        this.nOT = (TextView) findViewById(R.id.change);
        this.iDN = (RecyclerView) findViewById(R.id.thread_card_list);
        this.nOU = new a(this.mContext);
        this.nOU.setOnItemCoverListener(this.nOW);
        this.iDN.setAdapter(this.nOU);
        this.iDN.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iDS = new n(new l());
            this.iDS.a(this.iDN, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.iDN.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.iDN.setItemAnimator(new DefaultItemAnimator());
        this.iDN.addItemDecoration(new ae(dimens2, dimens, dimens2));
        this.iDN.addOnScrollListener(this.icm);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0101);
        ap.setViewTextColor(this.nOT, R.color.CAM_X0101);
        ap.setBackgroundColor(this, R.color.CAM_X0604);
        this.nOU.notifyDataSetChanged();
    }

    public void setData(bq bqVar) {
        if (bqVar != null) {
            this.nOU.setData(bqVar.boc());
            this.nOU.notifyDataSetChanged();
            this.iDN.scrollToPosition(0);
            this.aPW.clear();
            this.nOV = true;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iDU.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iDU);
        this.nOU.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.nOU.setPageContext(tbPageContext);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.nOT.setOnClickListener(onClickListener);
    }

    public void setCouldStatistic(boolean z) {
        this.nOV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends RecyclerView.Adapter<C0888a> {
        private com.baidu.tbadk.h.f<MetaData> ajQ;
        private BdUniqueId fhh;
        private Context mContext;
        private List<MetaData> mData;
        private TbPageContext mPageContext;

        public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
            this.ajQ = fVar;
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
        public C0888a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0888a(LayoutInflater.from(this.mContext).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0888a c0888a, int i) {
            MetaData metaData;
            if (c0888a == null || this.mData == null || (metaData = this.mData.get(i)) == null) {
                return;
            }
            c0888a.rs(metaData.isNewGod());
            a(metaData, c0888a);
            c(metaData, c0888a);
            e(metaData, c0888a);
            b(metaData, c0888a);
            if (this.ajQ != null) {
                this.ajQ.b(c0888a.itemView, metaData, i, i);
            }
            c0888a.onChangeSkinType();
            c0888a.itemView.setTag(R.id.tag_user_id, metaData);
            c0888a.itemView.setTag(R.id.tag_holder, true);
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
        public void onViewAttachedToWindow(@NonNull C0888a c0888a) {
            super.onViewAttachedToWindow(c0888a);
            if (GodRecommendLayout.this.nOV && c0888a.itemView != null && (c0888a.itemView.getTag(R.id.tag_user_id) instanceof MetaData) && (c0888a.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) c0888a.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) c0888a.itemView.getTag(R.id.tag_user_id);
                if (booleanValue && !GodRecommendLayout.this.aPW.contains(metaData.getUserId())) {
                    GodRecommendLayout.this.aPW.add(metaData.getUserId());
                    TiebaStatic.log(new ar("c13902").dY("uid", metaData.getUserId()));
                    c0888a.itemView.setTag(R.id.tag_holder, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onViewDetachedFromWindow(@NonNull C0888a c0888a) {
            super.onViewDetachedFromWindow(c0888a);
            if (GodRecommendLayout.this.aPW.isEmpty() && c0888a.itemView != null) {
                c0888a.itemView.setTag(R.id.tag_holder, true);
            }
        }

        private void a(final MetaData metaData, final C0888a c0888a) {
            c0888a.jKV.setData(metaData, true);
            c0888a.jKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.d(metaData, c0888a);
                }
            });
        }

        private void b(MetaData metaData, C0888a c0888a) {
            com.baidu.tbadk.core.view.userLike.c cVar = c0888a.akZ;
            if (cVar != null) {
                cVar.l(this.fhh);
                cVar.a(metaData);
            }
        }

        private void c(MetaData metaData, C0888a c0888a) {
            if (metaData != null && c0888a != null) {
                String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                c0888a.eBQ.setText(string);
                if (metaData.isNewGod()) {
                    ap.setViewTextColor(c0888a.eBQ, R.color.CAM_X0301);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(MetaData metaData, C0888a c0888a) {
            if (this.ajQ != null) {
                this.ajQ.a(c0888a.itemView, metaData, c0888a.getAdapterPosition(), c0888a.getItemId());
            }
        }

        private void e(MetaData metaData, C0888a c0888a) {
            String lf;
            if (metaData != null && c0888a != null) {
                String str = null;
                if (metaData.isBaijiahaoUser()) {
                    str = metaData.getBaijiahaoInfo().auth_desc;
                } else if (metaData.isNewGod()) {
                    str = metaData.getNewGodData().getFieldName();
                }
                if (!au.isEmpty(str)) {
                    lf = str + ah.lf(metaData.isVideoGod());
                } else {
                    lf = ah.lf(metaData.isVideoGod());
                }
                c0888a.jKU.setText(lf);
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            this.fhh = bdUniqueId;
        }

        /* renamed from: com.baidu.tieba.view.GodRecommendLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public class C0888a extends RecyclerView.ViewHolder {
            public com.baidu.tbadk.core.view.userLike.c akZ;
            public TextView eBQ;
            public TextView jKU;
            public HeadPendantClickableView jKV;
            public DynamicUserLikeButton jKW;
            private boolean jKX;
            public LinearLayout mContainer;

            public C0888a(View view) {
                super(view);
                this.jKX = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                this.jKV = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.jKV.getHeadView().setIsRound(true);
                this.jKV.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.jKV.getHeadView().setDefaultResource(17170445);
                this.jKV.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.jKV.getHeadView().setPlaceHolder(1);
                this.jKV.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1));
                this.jKV.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
                this.eBQ = (TextView) view.findViewById(R.id.concern_user_name);
                this.jKU = (TextView) view.findViewById(R.id.concern_user_desc);
                this.jKW = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.jKW.setGodRecommendStyle(true);
                this.jKW.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cG(View view2) {
                        if (C0888a.this.akZ != null && C0888a.this.akZ.bwy() != null && !C0888a.this.akZ.bwy().getIsLike()) {
                            TiebaStatic.log(new ar("c13903").dY("friend_uid", C0888a.this.akZ.bwy().getUserId()).dY("obj_name", C0888a.this.jKU.getText().toString()));
                        }
                    }
                });
                this.akZ = new com.baidu.tbadk.core.view.userLike.c(a.this.mPageContext, this.jKW);
                this.akZ.jL(true);
            }

            public void onChangeSkinType() {
                if (!this.jKX) {
                    ap.setViewTextColor(this.eBQ, R.color.CAM_X0101);
                } else {
                    ap.setViewTextColor(this.eBQ, R.color.CAM_X0301);
                }
                ap.setViewTextColor(this.jKU, R.color.CAM_X0101);
                this.jKW.bvt();
                com.baidu.tbadk.core.util.e.a.buz().qf(0).ql(R.color.CAM_X0614).qg(R.color.CAM_X0614).qn(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1)).ac(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds10)).bq(this.mContainer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void rs(boolean z) {
                this.jKX = z;
            }
        }
    }
}
