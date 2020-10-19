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
    private List<String> aNa;
    private RecyclerView hZG;
    private n hZL;
    private CustomMessageListener hZN;
    private RecyclerView.OnScrollListener hyx;
    private final Context mContext;
    private TextView mTitleView;
    private TextView nhm;
    private a nhn;
    private boolean nho;
    private com.baidu.tbadk.h.f nhp;

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNa = new ArrayList();
        this.nho = true;
        this.hZN = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.view.GodRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (GodRecommendLayout.this.hZL == null) {
                            GodRecommendLayout.this.hZL = new n(new l());
                        }
                        GodRecommendLayout.this.hZL.a(GodRecommendLayout.this.hZG, 1);
                    } else if (GodRecommendLayout.this.hZL != null) {
                        GodRecommendLayout.this.hZL.rh();
                    }
                }
            }
        };
        this.nhp = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.view.GodRecommendLayout.2
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
        this.hyx = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.3
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                GodRecommendLayout.this.aNa.clear();
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
        this.nhm = (TextView) findViewById(R.id.change);
        this.hZG = (RecyclerView) findViewById(R.id.thread_card_list);
        this.nhn = new a(this.mContext);
        this.nhn.setOnItemCoverListener(this.nhp);
        this.hZG.setAdapter(this.nhn);
        this.hZG.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.hZL = new n(new l());
            this.hZL.a(this.hZG, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.hZG.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.hZG.setItemAnimator(new DefaultItemAnimator());
        this.hZG.addItemDecoration(new ae(dimens2, dimens, dimens2));
        this.hZG.addOnScrollListener(this.hyx);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_a);
        ap.setViewTextColor(this.nhm, R.color.cp_cont_a);
        ap.setBackgroundColor(this, R.color.cp_mask_b_alpha25);
        this.nhn.notifyDataSetChanged();
    }

    public void setData(bo boVar) {
        if (boVar != null) {
            this.nhn.setData(boVar.bhu());
            this.nhn.notifyDataSetChanged();
            this.hZG.scrollToPosition(0);
            this.aNa.clear();
            this.nho = true;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.hZN.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.hZN);
        this.nhn.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.nhn.setPageContext(tbPageContext);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.nhm.setOnClickListener(onClickListener);
    }

    public void setCouldStatistic(boolean z) {
        this.nho = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a extends RecyclerView.Adapter<C0839a> {
        private com.baidu.tbadk.h.f<MetaData> aiL;
        private BdUniqueId eMr;
        private Context mContext;
        private List<MetaData> mData;
        private TbPageContext mPageContext;

        public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
            this.aiL = fVar;
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
        public C0839a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0839a(LayoutInflater.from(this.mContext).inflate(R.layout.recommend_god_item, (ViewGroup) null));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0839a c0839a, int i) {
            MetaData metaData;
            if (c0839a == null || this.mData == null || (metaData = this.mData.get(i)) == null) {
                return;
            }
            c0839a.qn(metaData.isNewGod());
            a(metaData, c0839a);
            c(metaData, c0839a);
            e(metaData, c0839a);
            b(metaData, c0839a);
            if (this.aiL != null) {
                this.aiL.b(c0839a.itemView, metaData, i, i);
            }
            c0839a.onChangeSkinType();
            c0839a.itemView.setTag(R.id.tag_user_id, metaData);
            c0839a.itemView.setTag(R.id.tag_holder, true);
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
        public void onViewAttachedToWindow(@NonNull C0839a c0839a) {
            super.onViewAttachedToWindow(c0839a);
            if (GodRecommendLayout.this.nho && c0839a.itemView != null && (c0839a.itemView.getTag(R.id.tag_user_id) instanceof MetaData) && (c0839a.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) c0839a.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) c0839a.itemView.getTag(R.id.tag_user_id);
                if (booleanValue && !GodRecommendLayout.this.aNa.contains(metaData.getUserId())) {
                    GodRecommendLayout.this.aNa.add(metaData.getUserId());
                    TiebaStatic.log(new aq("c13902").dK("uid", metaData.getUserId()));
                    c0839a.itemView.setTag(R.id.tag_holder, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onViewDetachedFromWindow(@NonNull C0839a c0839a) {
            super.onViewDetachedFromWindow(c0839a);
            if (GodRecommendLayout.this.aNa.isEmpty() && c0839a.itemView != null) {
                c0839a.itemView.setTag(R.id.tag_holder, true);
            }
        }

        private void a(final MetaData metaData, final C0839a c0839a) {
            c0839a.jeh.setData(metaData, true);
            c0839a.jeh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.d(metaData, c0839a);
                }
            });
        }

        private void b(MetaData metaData, C0839a c0839a) {
            com.baidu.tbadk.core.view.userLike.c cVar = c0839a.ajV;
            if (cVar != null) {
                cVar.l(this.eMr);
                cVar.a(metaData);
            }
        }

        private void c(MetaData metaData, C0839a c0839a) {
            if (metaData != null && c0839a != null) {
                String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                c0839a.eig.setText(string);
                if (metaData.isNewGod()) {
                    ap.setViewTextColor(c0839a.eig, R.color.cp_cont_h);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(MetaData metaData, C0839a c0839a) {
            if (this.aiL != null) {
                this.aiL.a(c0839a.itemView, metaData, c0839a.getAdapterPosition(), c0839a.getItemId());
            }
        }

        private void e(MetaData metaData, C0839a c0839a) {
            String string;
            if (metaData != null && c0839a != null) {
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
                c0839a.jeg.setText(string);
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            this.eMr = bdUniqueId;
        }

        /* renamed from: com.baidu.tieba.view.GodRecommendLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public class C0839a extends RecyclerView.ViewHolder {
            public com.baidu.tbadk.core.view.userLike.c ajV;
            public TextView eig;
            public TextView jeg;
            public HeadPendantClickableView jeh;
            public DynamicUserLikeButton jei;
            private boolean jej;
            public LinearLayout mContainer;

            public C0839a(View view) {
                super(view);
                this.jej = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                this.jeh = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.jeh.getHeadView().setIsRound(true);
                this.jeh.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.jeh.getHeadView().setDefaultResource(17170445);
                this.jeh.getHeadView().setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.jeh.getHeadView().setPlaceHolder(2);
                this.jeh.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1));
                this.jeh.getHeadView().setBorderColor(ap.getColor(R.color.cp_border_a));
                this.eig = (TextView) view.findViewById(R.id.concern_user_name);
                this.jeg = (TextView) view.findViewById(R.id.concern_user_desc);
                this.jei = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.jei.setGodRecommendStyle(true);
                this.jei.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.view.GodRecommendLayout.a.a.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cm(View view2) {
                        if (C0839a.this.ajV != null && C0839a.this.ajV.bpp() != null && !C0839a.this.ajV.bpp().getIsLike()) {
                            TiebaStatic.log(new aq("c13903").dK("friend_uid", C0839a.this.ajV.bpp().getUserId()).dK("obj_name", C0839a.this.jeg.getText().toString()));
                        }
                    }
                });
                this.ajV = new com.baidu.tbadk.core.view.userLike.c(a.this.mPageContext, this.jei);
                this.ajV.iY(true);
            }

            public void onChangeSkinType() {
                if (!this.jej) {
                    ap.setViewTextColor(this.eig, R.color.cp_cont_a);
                } else {
                    ap.setViewTextColor(this.eig, R.color.cp_cont_h);
                }
                ap.setViewTextColor(this.jeg, R.color.cp_cont_a);
                this.jei.bok();
                com.baidu.tbadk.core.util.e.a.bnv().oO(0).oS(R.color.cp_mask_c_alpha16).oP(R.color.cp_mask_c_alpha16).oU(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds1)).X(com.baidu.adp.lib.util.l.getDimens(a.this.mContext, R.dimen.tbds10)).bf(this.mContainer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void qn(boolean z) {
                this.jej = z;
            }
        }
    }
}
