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
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class GodRecommendLayout extends LinearLayout {
    private List<String> aMX;
    private RecyclerView.OnScrollListener hRq;
    private RecyclerView isT;
    private n isY;
    private CustomMessageListener ita;
    private final Context mContext;
    private TextView mTitleView;
    private TextView nAP;
    private a nAQ;
    private boolean nAR;
    private com.baidu.tbadk.h.f nAS;

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMX = new ArrayList();
        this.nAR = true;
        this.ita = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.view.GodRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (GodRecommendLayout.this.isY == null) {
                            GodRecommendLayout.this.isY = new n(new l());
                        }
                        GodRecommendLayout.this.isY.a(GodRecommendLayout.this.isT, 1);
                    } else if (GodRecommendLayout.this.isY != null) {
                        GodRecommendLayout.this.isY.rh();
                    }
                }
            }
        };
        this.nAS = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.view.GodRecommendLayout.2
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
        this.hRq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.3
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                GodRecommendLayout.this.aMX.clear();
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
        this.nAP = (TextView) findViewById(R.id.change);
        this.isT = (RecyclerView) findViewById(R.id.thread_card_list);
        this.nAQ = new a(this.mContext);
        this.nAQ.setOnItemCoverListener(this.nAS);
        this.isT.setAdapter(this.nAQ);
        this.isT.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.isY = new n(new l());
            this.isY.a(this.isT, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.isT.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.isT.setItemAnimator(new DefaultItemAnimator());
        this.isT.addItemDecoration(new ae(dimens2, dimens, dimens2));
        this.isT.addOnScrollListener(this.hRq);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0101);
        ap.setViewTextColor(this.nAP, R.color.CAM_X0101);
        ap.setBackgroundColor(this, R.color.CAM_X0604);
        this.nAQ.notifyDataSetChanged();
    }

    public void setData(bp bpVar) {
        if (bpVar != null) {
            this.nAQ.setData(bpVar.bkP());
            this.nAQ.notifyDataSetChanged();
            this.isT.scrollToPosition(0);
            this.aMX.clear();
            this.nAR = true;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ita.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.ita);
        this.nAQ.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.nAQ.setPageContext(tbPageContext);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.nAP.setOnClickListener(onClickListener);
    }

    public void setCouldStatistic(boolean z) {
        this.nAR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a extends RecyclerView.Adapter<C0872a> {
        private com.baidu.tbadk.h.f<MetaData> aiR;
        private BdUniqueId eZK;
        private Context mContext;
        private List<MetaData> mData;
        private TbPageContext mPageContext;

        public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
            this.aiR = fVar;
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
        public C0872a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0872a(LayoutInflater.from(this.mContext).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0872a c0872a, int i) {
            MetaData metaData;
            if (c0872a == null || this.mData == null || (metaData = this.mData.get(i)) == null) {
                return;
            }
            c0872a.qR(metaData.isNewGod());
            a(metaData, c0872a);
            c(metaData, c0872a);
            e(metaData, c0872a);
            b(metaData, c0872a);
            if (this.aiR != null) {
                this.aiR.b(c0872a.itemView, metaData, i, i);
            }
            c0872a.onChangeSkinType();
            c0872a.itemView.setTag(R.id.tag_user_id, metaData);
            c0872a.itemView.setTag(R.id.tag_holder, true);
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
        public void onViewAttachedToWindow(@NonNull C0872a c0872a) {
            super.onViewAttachedToWindow(c0872a);
            if (GodRecommendLayout.this.nAR && c0872a.itemView != null && (c0872a.itemView.getTag(R.id.tag_user_id) instanceof MetaData) && (c0872a.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) c0872a.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) c0872a.itemView.getTag(R.id.tag_user_id);
                if (booleanValue && !GodRecommendLayout.this.aMX.contains(metaData.getUserId())) {
                    GodRecommendLayout.this.aMX.add(metaData.getUserId());
                    TiebaStatic.log(new ar("c13902").dR("uid", metaData.getUserId()));
                    c0872a.itemView.setTag(R.id.tag_holder, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onViewDetachedFromWindow(@NonNull C0872a c0872a) {
            super.onViewDetachedFromWindow(c0872a);
            if (GodRecommendLayout.this.aMX.isEmpty() && c0872a.itemView != null) {
                c0872a.itemView.setTag(R.id.tag_holder, true);
            }
        }

        private void a(final MetaData metaData, final C0872a c0872a) {
            c0872a.jxr.setData(metaData, true);
            c0872a.jxr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.d(metaData, c0872a);
                }
            });
        }

        private void b(MetaData metaData, C0872a c0872a) {
            com.baidu.tbadk.core.view.userLike.c cVar = c0872a.ajZ;
            if (cVar != null) {
                cVar.l(this.eZK);
                cVar.a(metaData);
            }
        }

        private void c(MetaData metaData, C0872a c0872a) {
            if (metaData != null && c0872a != null) {
                String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                c0872a.euO.setText(string);
                if (metaData.isNewGod()) {
                    ap.setViewTextColor(c0872a.euO, R.color.CAM_X0301);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(MetaData metaData, C0872a c0872a) {
            if (this.aiR != null) {
                this.aiR.a(c0872a.itemView, metaData, c0872a.getAdapterPosition(), c0872a.getItemId());
            }
        }

        private void e(MetaData metaData, C0872a c0872a) {
            String string;
            if (metaData != null && c0872a != null) {
                String str = null;
                if (metaData.isBaijiahaoUser()) {
                    str = metaData.getBaijiahaoInfo().auth_desc;
                } else if (metaData.isNewGod()) {
                    str = metaData.getNewGodData().getFieldName();
                }
                if (!au.isEmpty(str)) {
                    string = str + TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
                } else {
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
                }
                c0872a.jxq.setText(string);
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            this.eZK = bdUniqueId;
        }

        /* renamed from: com.baidu.tieba.view.GodRecommendLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public class C0872a extends RecyclerView.ViewHolder {
            public com.baidu.tbadk.core.view.userLike.c ajZ;
            public TextView euO;
            public TextView jxq;
            public HeadPendantClickableView jxr;
            public DynamicUserLikeButton jxs;
            private boolean jxt;
            public LinearLayout mContainer;

            public C0872a(View view) {
                super(view);
                this.jxt = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                this.jxr = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.jxr.getHeadView().setIsRound(true);
                this.jxr.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.jxr.getHeadView().setDefaultResource(17170445);
                this.jxr.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.jxr.getHeadView().setPlaceHolder(1);
                this.jxr.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1));
                this.jxr.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
                this.euO = (TextView) view.findViewById(R.id.concern_user_name);
                this.jxq = (TextView) view.findViewById(R.id.concern_user_desc);
                this.jxs = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.jxs.setGodRecommendStyle(true);
                this.jxs.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cz(View view2) {
                        if (C0872a.this.ajZ != null && C0872a.this.ajZ.bsY() != null && !C0872a.this.ajZ.bsY().getIsLike()) {
                            TiebaStatic.log(new ar("c13903").dR("friend_uid", C0872a.this.ajZ.bsY().getUserId()).dR("obj_name", C0872a.this.jxq.getText().toString()));
                        }
                    }
                });
                this.ajZ = new com.baidu.tbadk.core.view.userLike.c(a.this.mPageContext, this.jxs);
                this.ajZ.jv(true);
            }

            public void onChangeSkinType() {
                if (!this.jxt) {
                    ap.setViewTextColor(this.euO, R.color.CAM_X0101);
                } else {
                    ap.setViewTextColor(this.euO, R.color.CAM_X0301);
                }
                ap.setViewTextColor(this.jxq, R.color.CAM_X0101);
                this.jxs.brT();
                com.baidu.tbadk.core.util.e.a.brc().pF(0).pL(R.color.CAM_X0614).pG(R.color.CAM_X0614).pN(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1)).ac(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds10)).bn(this.mContainer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void qR(boolean z) {
                this.jxt = z;
            }
        }
    }
}
