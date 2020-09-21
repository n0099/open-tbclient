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
/* loaded from: classes20.dex */
public class GodRecommendLayout extends LinearLayout {
    private List<String> aJV;
    private RecyclerView hKL;
    private n hKQ;
    private CustomMessageListener hKS;
    private RecyclerView.OnScrollListener hjC;
    private final Context mContext;
    private TextView mRI;
    private a mRJ;
    private boolean mRK;
    private com.baidu.tbadk.h.f mRL;
    private TextView mTitleView;

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJV = new ArrayList();
        this.mRK = true;
        this.hKS = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.view.GodRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (GodRecommendLayout.this.hKQ == null) {
                            GodRecommendLayout.this.hKQ = new n(new l());
                        }
                        GodRecommendLayout.this.hKQ.a(GodRecommendLayout.this.hKL, 1);
                    } else if (GodRecommendLayout.this.hKQ != null) {
                        GodRecommendLayout.this.hKQ.rh();
                    }
                }
            }
        };
        this.mRL = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.view.GodRecommendLayout.2
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
        this.hjC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.3
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                GodRecommendLayout.this.aJV.clear();
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
        this.mRI = (TextView) findViewById(R.id.change);
        this.hKL = (RecyclerView) findViewById(R.id.thread_card_list);
        this.mRJ = new a(this.mContext);
        this.mRJ.setOnItemCoverListener(this.mRL);
        this.hKL.setAdapter(this.mRJ);
        this.hKL.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hKQ = new n(new l());
            this.hKQ.a(this.hKL, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.hKL.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.hKL.setItemAnimator(new DefaultItemAnimator());
        this.hKL.addItemDecoration(new ae(dimens2, dimens, dimens2));
        this.hKL.addOnScrollListener(this.hjC);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_a);
        ap.setViewTextColor(this.mRI, R.color.cp_cont_a);
        ap.setBackgroundColor(this, R.color.cp_mask_b_alpha25);
        this.mRJ.notifyDataSetChanged();
    }

    public void setData(bo boVar) {
        if (boVar != null) {
            this.mRJ.setData(boVar.beL());
            this.mRJ.notifyDataSetChanged();
            this.hKL.scrollToPosition(0);
            this.aJV.clear();
            this.mRK = true;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hKS.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hKS);
        this.mRJ.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.mRJ.setPageContext(tbPageContext);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.mRI.setOnClickListener(onClickListener);
    }

    public void setCouldStatistic(boolean z) {
        this.mRK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a extends RecyclerView.Adapter<C0821a> {
        private com.baidu.tbadk.h.f<MetaData> ait;
        private BdUniqueId eAk;
        private Context mContext;
        private List<MetaData> mData;
        private TbPageContext mPageContext;

        public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
            this.ait = fVar;
        }

        public a(Context context) {
            this.mContext = context;
        }

        public void setData(List<MetaData> list) {
            this.mData = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: M */
        public C0821a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0821a(LayoutInflater.from(this.mContext).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0821a c0821a, int i) {
            MetaData metaData;
            if (c0821a == null || this.mData == null || (metaData = this.mData.get(i)) == null) {
                return;
            }
            c0821a.pH(metaData.isNewGod());
            a(metaData, c0821a);
            c(metaData, c0821a);
            e(metaData, c0821a);
            b(metaData, c0821a);
            if (this.ait != null) {
                this.ait.b(c0821a.itemView, metaData, i, i);
            }
            c0821a.onChangeSkinType();
            c0821a.itemView.setTag(R.id.tag_user_id, metaData);
            c0821a.itemView.setTag(R.id.tag_holder, true);
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
        public void onViewAttachedToWindow(@NonNull C0821a c0821a) {
            super.onViewAttachedToWindow(c0821a);
            if (GodRecommendLayout.this.mRK && c0821a.itemView != null && (c0821a.itemView.getTag(R.id.tag_user_id) instanceof MetaData) && (c0821a.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) c0821a.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) c0821a.itemView.getTag(R.id.tag_user_id);
                if (booleanValue && !GodRecommendLayout.this.aJV.contains(metaData.getUserId())) {
                    GodRecommendLayout.this.aJV.add(metaData.getUserId());
                    TiebaStatic.log(new aq("c13902").dF("uid", metaData.getUserId()));
                    c0821a.itemView.setTag(R.id.tag_holder, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onViewDetachedFromWindow(@NonNull C0821a c0821a) {
            super.onViewDetachedFromWindow(c0821a);
            if (GodRecommendLayout.this.aJV.isEmpty() && c0821a.itemView != null) {
                c0821a.itemView.setTag(R.id.tag_holder, true);
            }
        }

        private void a(final MetaData metaData, final C0821a c0821a) {
            c0821a.iPn.setData(metaData, true);
            c0821a.iPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.d(metaData, c0821a);
                }
            });
        }

        private void b(MetaData metaData, C0821a c0821a) {
            com.baidu.tbadk.core.view.userLike.c cVar = c0821a.ajD;
            if (cVar != null) {
                cVar.l(this.eAk);
                cVar.a(metaData);
            }
        }

        private void c(MetaData metaData, C0821a c0821a) {
            if (metaData != null && c0821a != null) {
                String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                c0821a.dWe.setText(string);
                if (metaData.isNewGod()) {
                    ap.setViewTextColor(c0821a.dWe, R.color.cp_cont_h);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(MetaData metaData, C0821a c0821a) {
            if (this.ait != null) {
                this.ait.a(c0821a.itemView, metaData, c0821a.getAdapterPosition(), c0821a.getItemId());
            }
        }

        private void e(MetaData metaData, C0821a c0821a) {
            String string;
            if (metaData != null && c0821a != null) {
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
                c0821a.iPm.setText(string);
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            this.eAk = bdUniqueId;
        }

        /* renamed from: com.baidu.tieba.view.GodRecommendLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public class C0821a extends RecyclerView.ViewHolder {
            public com.baidu.tbadk.core.view.userLike.c ajD;
            public TextView dWe;
            public TextView iPm;
            public HeadPendantClickableView iPn;
            public DynamicUserLikeButton iPo;
            private boolean iPp;
            public LinearLayout mContainer;

            public C0821a(View view) {
                super(view);
                this.iPp = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                this.iPn = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.iPn.getHeadView().setIsRound(true);
                this.iPn.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.iPn.getHeadView().setDefaultResource(17170445);
                this.iPn.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iPn.getHeadView().setPlaceHolder(2);
                this.iPn.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1));
                this.iPn.getHeadView().setBorderColor(ap.getColor(R.color.cp_border_a));
                this.dWe = (TextView) view.findViewById(R.id.concern_user_name);
                this.iPm = (TextView) view.findViewById(R.id.concern_user_desc);
                this.iPo = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.iPo.setGodRecommendStyle(true);
                this.iPo.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void ci(View view2) {
                        if (C0821a.this.ajD != null && C0821a.this.ajD.bmF() != null && !C0821a.this.ajD.bmF().getIsLike()) {
                            TiebaStatic.log(new aq("c13903").dF("friend_uid", C0821a.this.ajD.bmF().getUserId()).dF("obj_name", C0821a.this.iPm.getText().toString()));
                        }
                    }
                });
                this.ajD = new com.baidu.tbadk.core.view.userLike.c(a.this.mPageContext, this.iPo);
                this.ajD.iA(true);
            }

            public void onChangeSkinType() {
                if (!this.iPp) {
                    ap.setViewTextColor(this.dWe, R.color.cp_cont_a);
                } else {
                    ap.setViewTextColor(this.dWe, R.color.cp_cont_h);
                }
                ap.setViewTextColor(this.iPm, R.color.cp_cont_a);
                this.iPo.blA();
                com.baidu.tbadk.core.util.e.a.bkL().oq(0).ou(R.color.cp_mask_c_alpha16).or(R.color.cp_mask_c_alpha16).ow(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1)).V(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds10)).bb(this.mContainer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void pH(boolean z) {
                this.iPp = z;
            }
        }
    }
}
