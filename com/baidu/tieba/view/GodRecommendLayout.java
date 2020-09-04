package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
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
/* loaded from: classes15.dex */
public class GodRecommendLayout extends LinearLayout {
    private List<String> aIF;
    private RecyclerView hDJ;
    private n hDO;
    private CustomMessageListener hDQ;
    private RecyclerView.OnScrollListener hcD;
    private final Context mContext;
    private TextView mHW;
    private a mHX;
    private LinearLayoutManager mHY;
    private boolean mHZ;
    private com.baidu.tbadk.h.f mIa;
    private TextView mTitleView;

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aIF = new ArrayList();
        this.mHZ = true;
        this.hDQ = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.view.GodRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (GodRecommendLayout.this.hDO == null) {
                            GodRecommendLayout.this.hDO = new n(new l());
                        }
                        GodRecommendLayout.this.hDO.a(GodRecommendLayout.this.hDJ, 1);
                    } else if (GodRecommendLayout.this.hDO != null) {
                        GodRecommendLayout.this.hDO.rc();
                    }
                }
            }
        };
        this.mIa = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.view.GodRecommendLayout.2
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
        this.hcD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.3
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                GodRecommendLayout.this.aIF.clear();
            }
        };
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.recommend_god_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.mHW = (TextView) findViewById(R.id.change);
        this.hDJ = (RecyclerView) findViewById(R.id.thread_card_list);
        this.mHX = new a(this.mContext);
        this.mHX.setOnItemCoverListener(this.mIa);
        this.hDJ.setAdapter(this.mHX);
        this.hDJ.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hDO = new n(new l());
            this.hDO.a(this.hDJ, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        RecyclerView recyclerView = this.hDJ;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext, 0, false);
        this.mHY = linearLayoutManager;
        recyclerView.setLayoutManager(linearLayoutManager);
        this.hDJ.setItemAnimator(new DefaultItemAnimator());
        this.hDJ.addItemDecoration(new ae(dimens2, dimens, dimens2));
        this.hDJ.addOnScrollListener(this.hcD);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_a);
        ap.setViewTextColor(this.mHW, R.color.cp_cont_a);
        ap.setBackgroundColor(this, R.color.cp_mask_b_alpha25);
        this.mHX.notifyDataSetChanged();
    }

    public void setData(bo boVar) {
        if (boVar != null) {
            this.mHX.setData(boVar.bdR());
            this.mHX.notifyDataSetChanged();
            this.hDJ.scrollToPosition(0);
            this.aIF.clear();
            this.mHZ = true;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hDQ.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hDQ);
        this.mHX.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mHX.setPageContext(tbPageContext);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.mHW.setOnClickListener(onClickListener);
    }

    public void setCouldStatistic(boolean z) {
        this.mHZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends RecyclerView.Adapter<C0824a> {
        private com.baidu.tbadk.h.f<MetaData> ahY;
        private BdUniqueId eyf;
        private Context mContext;
        private List<MetaData> mData;
        private TbPageContext mPageContext;

        public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
            this.ahY = fVar;
        }

        public a(Context context) {
            this.mContext = context;
        }

        public void setData(List<MetaData> list) {
            this.mData = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: K */
        public C0824a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0824a(LayoutInflater.from(this.mContext).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0824a c0824a, int i) {
            MetaData metaData;
            if (c0824a == null || this.mData == null || (metaData = this.mData.get(i)) == null) {
                return;
            }
            c0824a.pB(metaData.isNewGod());
            a(metaData, c0824a);
            c(metaData, c0824a);
            e(metaData, c0824a);
            b(metaData, c0824a);
            if (this.ahY != null) {
                this.ahY.b(c0824a.itemView, metaData, i, i);
            }
            c0824a.onChangeSkinType();
            c0824a.itemView.setTag(R.id.tag_user_id, metaData);
            c0824a.itemView.setTag(R.id.tag_holder, true);
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
        public void onViewAttachedToWindow(@NonNull C0824a c0824a) {
            super.onViewAttachedToWindow(c0824a);
            if (GodRecommendLayout.this.mHZ && c0824a.itemView != null && (c0824a.itemView.getTag(R.id.tag_user_id) instanceof MetaData) && (c0824a.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) c0824a.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) c0824a.itemView.getTag(R.id.tag_user_id);
                if (booleanValue && !GodRecommendLayout.this.aIF.contains(metaData.getUserId())) {
                    GodRecommendLayout.this.aIF.add(metaData.getUserId());
                    TiebaStatic.log(new aq("c13902").dD("uid", metaData.getUserId()));
                    c0824a.itemView.setTag(R.id.tag_holder, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onViewDetachedFromWindow(@NonNull C0824a c0824a) {
            super.onViewDetachedFromWindow(c0824a);
            if (GodRecommendLayout.this.aIF.isEmpty() && c0824a.itemView != null) {
                c0824a.itemView.setTag(R.id.tag_holder, true);
            }
        }

        private void a(final MetaData metaData, final C0824a c0824a) {
            c0824a.iHA.setData(metaData, true);
            c0824a.iHA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.d(metaData, c0824a);
                }
            });
        }

        private void b(MetaData metaData, C0824a c0824a) {
            com.baidu.tbadk.core.view.userLike.c cVar = c0824a.aje;
            if (cVar != null) {
                cVar.m(this.eyf);
                cVar.a(metaData);
            }
        }

        private void c(MetaData metaData, C0824a c0824a) {
            if (metaData != null && c0824a != null) {
                String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                c0824a.dTU.setText(string);
                if (metaData.isNewGod()) {
                    ap.setViewTextColor(c0824a.dTU, R.color.cp_cont_h);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(MetaData metaData, C0824a c0824a) {
            if (this.ahY != null) {
                this.ahY.a(c0824a.itemView, metaData, c0824a.getAdapterPosition(), c0824a.getItemId());
            }
        }

        private void e(MetaData metaData, C0824a c0824a) {
            String string;
            if (metaData != null && c0824a != null) {
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
                c0824a.iHz.setText(string);
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            this.eyf = bdUniqueId;
        }

        /* renamed from: com.baidu.tieba.view.GodRecommendLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public class C0824a extends RecyclerView.ViewHolder {
            public com.baidu.tbadk.core.view.userLike.c aje;
            public TextView dTU;
            public HeadPendantClickableView iHA;
            public DynamicUserLikeButton iHB;
            private boolean iHC;
            public TextView iHz;
            public LinearLayout mContainer;

            public C0824a(View view) {
                super(view);
                this.iHC = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                this.iHA = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.iHA.getHeadView().setIsRound(true);
                this.iHA.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.iHA.getHeadView().setDefaultResource(17170445);
                this.iHA.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iHA.getHeadView().setPlaceHolder(2);
                this.iHA.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1));
                this.iHA.getHeadView().setBorderColor(ap.getColor(R.color.cp_border_a));
                this.dTU = (TextView) view.findViewById(R.id.concern_user_name);
                this.iHz = (TextView) view.findViewById(R.id.concern_user_desc);
                this.iHB = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.iHB.setGodRecommendStyle(true);
                this.iHB.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void bZ(View view2) {
                        if (C0824a.this.aje != null && C0824a.this.aje.blL() != null && !C0824a.this.aje.blL().getIsLike()) {
                            TiebaStatic.log(new aq("c13903").dD("friend_uid", C0824a.this.aje.blL().getUserId()).dD("obj_name", C0824a.this.iHz.getText().toString()));
                        }
                    }
                });
                this.aje = new com.baidu.tbadk.core.view.userLike.c(a.this.mPageContext, this.iHB);
                this.aje.iD(true);
            }

            public void onChangeSkinType() {
                if (!this.iHC) {
                    ap.setViewTextColor(this.dTU, R.color.cp_cont_a);
                } else {
                    ap.setViewTextColor(this.dTU, R.color.cp_cont_h);
                }
                ap.setViewTextColor(this.iHz, R.color.cp_cont_a);
                this.iHB.bkF();
                com.baidu.tbadk.core.util.e.a.bjQ().oe(0).oi(R.color.cp_mask_c_alpha16).of(R.color.cp_mask_c_alpha16).ok(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1)).V(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds10)).aZ(this.mContainer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void pB(boolean z) {
                this.iHC = z;
            }
        }
    }
}
