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
    private List<String> aLY;
    private RecyclerView iLs;
    private l iLx;
    private CustomMessageListener iLz;
    private RecyclerView.OnScrollListener ikd;
    private final Context mContext;
    private TextView mTitleView;
    private TextView nNK;
    private GodRecommendListAdapter nNL;
    private boolean nNM;
    private com.baidu.tbadk.h.f nNN;

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLY = new ArrayList();
        this.nNM = true;
        this.iLz = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.view.GodRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (GodRecommendLayout.this.iLx == null) {
                            GodRecommendLayout.this.iLx = new l(new j());
                        }
                        GodRecommendLayout.this.iLx.a(GodRecommendLayout.this.iLs, 1);
                    } else if (GodRecommendLayout.this.iLx != null) {
                        GodRecommendLayout.this.iLx.qL();
                    }
                }
            }
        };
        this.nNN = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.view.GodRecommendLayout.2
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
        this.ikd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                GodRecommendLayout.this.aLY.clear();
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
        this.nNK = (TextView) findViewById(R.id.change);
        this.iLs = (RecyclerView) findViewById(R.id.thread_card_list);
        this.nNL = new GodRecommendListAdapter(this.mContext);
        this.nNL.setOnItemCoverListener(this.nNN);
        this.iLs.setAdapter(this.nNL);
        this.iLs.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iLx = new l(new j());
            this.iLx.a(this.iLs, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.iLs.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.iLs.setItemAnimator(new DefaultItemAnimator());
        this.iLs.addItemDecoration(new SpaceItemDecoration(dimens2, dimens, dimens2));
        this.iLs.addOnScrollListener(this.ikd);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mTitleView, R.color.CAM_X0101);
        ao.setViewTextColor(this.nNK, R.color.CAM_X0101);
        ao.setBackgroundColor(this, R.color.CAM_X0604);
        this.nNL.notifyDataSetChanged();
    }

    public void setData(br brVar) {
        if (brVar != null) {
            this.nNL.setData(brVar.bmK());
            this.nNL.notifyDataSetChanged();
            this.iLs.scrollToPosition(0);
            this.aLY.clear();
            this.nNM = true;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iLz.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iLz);
        this.nNL.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.nNL.setPageContext(tbPageContext);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.nNK.setOnClickListener(onClickListener);
    }

    public void setCouldStatistic(boolean z) {
        this.nNM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {
        private com.baidu.tbadk.h.f<MetaData> ajB;
        private BdUniqueId fmh;
        private Context mContext;
        private List<MetaData> mData;
        private TbPageContext mPageContext;

        public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
            this.ajB = fVar;
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
            godViewHolder.rL(metaData.isNewGod());
            a(metaData, godViewHolder);
            c(metaData, godViewHolder);
            e(metaData, godViewHolder);
            b(metaData, godViewHolder);
            if (this.ajB != null) {
                this.ajB.b(godViewHolder.itemView, metaData, i, i);
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
            if (GodRecommendLayout.this.nNM && godViewHolder.itemView != null && (godViewHolder.itemView.getTag(R.id.tag_user_id) instanceof MetaData) && (godViewHolder.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) godViewHolder.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) godViewHolder.itemView.getTag(R.id.tag_user_id);
                if (booleanValue && !GodRecommendLayout.this.aLY.contains(metaData.getUserId())) {
                    GodRecommendLayout.this.aLY.add(metaData.getUserId());
                    TiebaStatic.log(new aq("c13902").dW("uid", metaData.getUserId()));
                    godViewHolder.itemView.setTag(R.id.tag_holder, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onViewDetachedFromWindow(@NonNull GodViewHolder godViewHolder) {
            super.onViewDetachedFromWindow(godViewHolder);
            if (GodRecommendLayout.this.aLY.isEmpty() && godViewHolder.itemView != null) {
                godViewHolder.itemView.setTag(R.id.tag_holder, true);
            }
        }

        private void a(final MetaData metaData, final GodViewHolder godViewHolder) {
            godViewHolder.jTF.setData(metaData, true);
            godViewHolder.jTF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.GodRecommendListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GodRecommendListAdapter.this.d(metaData, godViewHolder);
                }
            });
        }

        private void b(MetaData metaData, GodViewHolder godViewHolder) {
            com.baidu.tbadk.core.view.userLike.c cVar = godViewHolder.akK;
            if (cVar != null) {
                cVar.l(this.fmh);
                cVar.a(metaData);
            }
        }

        private void c(MetaData metaData, GodViewHolder godViewHolder) {
            if (metaData != null && godViewHolder != null) {
                String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                godViewHolder.eGI.setText(string);
                if (metaData.isNewGod()) {
                    ao.setViewTextColor(godViewHolder.eGI, R.color.CAM_X0301);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(MetaData metaData, GodViewHolder godViewHolder) {
            if (this.ajB != null) {
                this.ajB.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
            }
        }

        private void e(MetaData metaData, GodViewHolder godViewHolder) {
            String lx;
            if (metaData != null && godViewHolder != null) {
                String str = null;
                if (metaData.isBaijiahaoUser()) {
                    str = metaData.getBaijiahaoInfo().auth_desc;
                } else if (metaData.isNewGod()) {
                    str = metaData.getNewGodData().getFieldName();
                }
                if (!at.isEmpty(str)) {
                    lx = str + ag.lx(metaData.isVideoGod());
                } else {
                    lx = ag.lx(metaData.isVideoGod());
                }
                godViewHolder.jTE.setText(lx);
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            this.fmh = bdUniqueId;
        }

        /* loaded from: classes.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {
            public com.baidu.tbadk.core.view.userLike.c akK;
            public TextView eGI;
            public TextView jTE;
            public HeadPendantClickableView jTF;
            public DynamicUserLikeButton jTG;
            private boolean jTH;
            public LinearLayout mContainer;

            public GodViewHolder(View view) {
                super(view);
                this.jTH = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                this.jTF = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.jTF.getHeadView().setIsRound(true);
                this.jTF.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.jTF.getHeadView().setDefaultResource(17170445);
                this.jTF.getHeadView().setPlaceHolder(1);
                this.jTF.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(GodRecommendListAdapter.this.mContext, R.dimen.tbds1));
                this.jTF.getHeadView().setBorderColor(ao.getColor(R.color.CAM_X0401));
                this.eGI = (TextView) view.findViewById(R.id.concern_user_name);
                this.jTE = (TextView) view.findViewById(R.id.concern_user_desc);
                this.jTG = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.jTG.setGodRecommendStyle(true);
                this.jTG.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.view.GodRecommendLayout.GodRecommendListAdapter.GodViewHolder.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cQ(View view2) {
                        if (GodViewHolder.this.akK != null && GodViewHolder.this.akK.buY() != null && !GodViewHolder.this.akK.buY().getIsLike()) {
                            TiebaStatic.log(new aq("c13903").dW("friend_uid", GodViewHolder.this.akK.buY().getUserId()).dW("obj_name", GodViewHolder.this.jTE.getText().toString()));
                        }
                    }
                });
                this.akK = new com.baidu.tbadk.core.view.userLike.c(GodRecommendListAdapter.this.mPageContext, this.jTG);
                this.akK.kd(true);
            }

            public void onChangeSkinType() {
                if (!this.jTH) {
                    ao.setViewTextColor(this.eGI, R.color.CAM_X0101);
                } else {
                    ao.setViewTextColor(this.eGI, R.color.CAM_X0301);
                }
                ao.setViewTextColor(this.jTE, R.color.CAM_X0101);
                this.jTG.btV();
                com.baidu.tbadk.core.util.f.a.btb().oJ(0).oP(R.color.CAM_X0614).oK(R.color.CAM_X0614).oR(com.baidu.adp.lib.util.l.getDimens(GodRecommendListAdapter.this.mContext, R.dimen.tbds1)).ae(com.baidu.adp.lib.util.l.getDimens(GodRecommendListAdapter.this.mContext, R.dimen.tbds10)).bz(this.mContainer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void rL(boolean z) {
                this.jTH = z;
            }
        }
    }
}
