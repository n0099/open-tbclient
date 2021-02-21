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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.util.aj;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GodRecommendLayout extends LinearLayout {
    private List<String> aOV;
    private RecyclerView iRo;
    private l iRt;
    private CustomMessageListener iRv;
    private RecyclerView.OnScrollListener ipZ;
    private final Context mContext;
    private TextView mTitleView;
    private TextView nYo;
    private GodRecommendListAdapter nYp;
    private boolean nYq;
    private com.baidu.tbadk.h.f nYr;

    public GodRecommendLayout(Context context) {
        this(context, null);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GodRecommendLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOV = new ArrayList();
        this.nYq = true;
        this.iRv = new CustomMessageListener(2156674) { // from class: com.baidu.tieba.view.GodRecommendLayout.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (GodRecommendLayout.this.iRt == null) {
                            GodRecommendLayout.this.iRt = new l(new j());
                        }
                        GodRecommendLayout.this.iRt.a(GodRecommendLayout.this.iRo, 1);
                    } else if (GodRecommendLayout.this.iRt != null) {
                        GodRecommendLayout.this.iRt.qJ();
                    }
                }
            }
        };
        this.nYr = new com.baidu.tbadk.h.f<MetaData>() { // from class: com.baidu.tieba.view.GodRecommendLayout.2
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
        this.ipZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                GodRecommendLayout.this.aOV.clear();
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
        this.nYo = (TextView) findViewById(R.id.change);
        this.iRo = (RecyclerView) findViewById(R.id.thread_card_list);
        this.nYp = new GodRecommendListAdapter(this.mContext);
        this.nYp.setOnItemCoverListener(this.nYr);
        this.iRo.setAdapter(this.nYp);
        this.iRo.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            this.iRt = new l(new j());
            this.iRt.a(this.iRo, 1);
        }
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds21);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44);
        this.iRo.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.iRo.setItemAnimator(new DefaultItemAnimator());
        this.iRo.addItemDecoration(new SpaceItemDecoration(dimens2, dimens, dimens2));
        this.iRo.addOnScrollListener(this.ipZ);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0101);
        ap.setViewTextColor(this.nYo, R.color.CAM_X0101);
        ap.setBackgroundColor(this, R.color.CAM_X0604);
        this.nYp.notifyDataSetChanged();
    }

    public void setData(bt btVar) {
        if (btVar != null) {
            this.nYp.setData(btVar.bnd());
            this.nYp.notifyDataSetChanged();
            this.iRo.scrollToPosition(0);
            this.aOV.clear();
            this.nYq = true;
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.iRv.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.iRv);
        this.nYp.setPageUniqueId(bdUniqueId);
    }

    public void setPageContext(TbPageContext tbPageContext) {
        this.nYp.setPageContext(tbPageContext);
    }

    public void setRefreshListener(View.OnClickListener onClickListener) {
        this.nYo.setOnClickListener(onClickListener);
    }

    public void setCouldStatistic(boolean z) {
        this.nYq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GodRecommendListAdapter extends RecyclerView.Adapter<GodViewHolder> {
        private com.baidu.tbadk.h.f<MetaData> ajq;
        private BdUniqueId foA;
        private Context mContext;
        private List<MetaData> mData;
        private TbPageContext mPageContext;

        public void setOnItemCoverListener(com.baidu.tbadk.h.f<MetaData> fVar) {
            this.ajq = fVar;
        }

        public GodRecommendListAdapter(Context context) {
            this.mContext = context;
        }

        public void setData(List<MetaData> list) {
            this.mData = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: T */
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
            godViewHolder.rX(metaData.isNewGod());
            a(metaData, godViewHolder);
            c(metaData, godViewHolder);
            e(metaData, godViewHolder);
            b(metaData, godViewHolder);
            if (this.ajq != null) {
                this.ajq.b(godViewHolder.itemView, metaData, i, i);
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
            if (GodRecommendLayout.this.nYq && godViewHolder.itemView != null && (godViewHolder.itemView.getTag(R.id.tag_user_id) instanceof MetaData) && (godViewHolder.itemView.getTag(R.id.tag_holder) instanceof Boolean)) {
                boolean booleanValue = ((Boolean) godViewHolder.itemView.getTag(R.id.tag_holder)).booleanValue();
                MetaData metaData = (MetaData) godViewHolder.itemView.getTag(R.id.tag_user_id);
                if (booleanValue && !GodRecommendLayout.this.aOV.contains(metaData.getUserId())) {
                    GodRecommendLayout.this.aOV.add(metaData.getUserId());
                    TiebaStatic.log(new ar("c13902").dR("uid", metaData.getUserId()));
                    godViewHolder.itemView.setTag(R.id.tag_holder, false);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onViewDetachedFromWindow(@NonNull GodViewHolder godViewHolder) {
            super.onViewDetachedFromWindow(godViewHolder);
            if (GodRecommendLayout.this.aOV.isEmpty() && godViewHolder.itemView != null) {
                godViewHolder.itemView.setTag(R.id.tag_holder, true);
            }
        }

        private void a(final MetaData metaData, final GodViewHolder godViewHolder) {
            godViewHolder.kbu.setData(metaData, true);
            godViewHolder.kbu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.GodRecommendLayout.GodRecommendListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GodRecommendListAdapter.this.d(metaData, godViewHolder);
                }
            });
        }

        private void b(MetaData metaData, GodViewHolder godViewHolder) {
            com.baidu.tbadk.core.view.userLike.c cVar = godViewHolder.akz;
            if (cVar != null) {
                cVar.l(this.foA);
                cVar.a(metaData);
            }
        }

        private void c(MetaData metaData, GodViewHolder godViewHolder) {
            if (metaData != null && godViewHolder != null) {
                String string = GodRecommendLayout.this.getResources().getString(R.string.god_default_name);
                if (!StringUtils.isNull(metaData.getName_show())) {
                    string = metaData.getName_show();
                }
                godViewHolder.eIO.setText(string);
                if (metaData.isNewGod()) {
                    ap.setViewTextColor(godViewHolder.eIO, R.color.CAM_X0301);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(MetaData metaData, GodViewHolder godViewHolder) {
            if (this.ajq != null) {
                this.ajq.a(godViewHolder.itemView, metaData, godViewHolder.getAdapterPosition(), godViewHolder.getItemId());
            }
        }

        private void e(MetaData metaData, GodViewHolder godViewHolder) {
            String lA;
            if (metaData != null && godViewHolder != null) {
                String str = null;
                if (metaData.isBaijiahaoUser()) {
                    str = metaData.getBaijiahaoInfo().auth_desc;
                } else if (metaData.isNewGod()) {
                    str = metaData.getNewGodData().getFieldName();
                }
                if (!au.isEmpty(str)) {
                    lA = str + aj.lA(metaData.isVideoGod());
                } else {
                    lA = aj.lA(metaData.isVideoGod());
                }
                godViewHolder.kbt.setText(lA);
            }
        }

        public void setPageContext(TbPageContext tbPageContext) {
            this.mPageContext = tbPageContext;
        }

        public void setPageUniqueId(BdUniqueId bdUniqueId) {
            this.foA = bdUniqueId;
        }

        /* loaded from: classes.dex */
        public class GodViewHolder extends RecyclerView.ViewHolder {
            public com.baidu.tbadk.core.view.userLike.c akz;
            public TextView eIO;
            public TextView kbt;
            public HeadPendantClickableView kbu;
            public DynamicUserLikeButton kbv;
            private boolean kbw;
            public LinearLayout mContainer;

            public GodViewHolder(View view) {
                super(view);
                this.kbw = false;
                this.mContainer = (LinearLayout) view.findViewById(R.id.concern_container);
                this.kbu = (HeadPendantClickableView) view.findViewById(R.id.concern_user_image);
                this.kbu.getHeadView().setIsRound(true);
                this.kbu.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.kbu.getHeadView().setDefaultResource(17170445);
                this.kbu.getHeadView().setPlaceHolder(1);
                this.kbu.getHeadView().setBorderWidth(com.baidu.adp.lib.util.l.getDimens(GodRecommendListAdapter.this.mContext, R.dimen.tbds1));
                this.kbu.getHeadView().setBorderColor(ap.getColor(R.color.CAM_X0401));
                this.eIO = (TextView) view.findViewById(R.id.concern_user_name);
                this.kbt = (TextView) view.findViewById(R.id.concern_user_desc);
                this.kbv = (DynamicUserLikeButton) view.findViewById(R.id.user_recommend_like_btn);
                this.kbv.setGodRecommendStyle(true);
                this.kbv.setOnClickEvent(new DynamicUserLikeButton.a() { // from class: com.baidu.tieba.view.GodRecommendLayout.GodRecommendListAdapter.GodViewHolder.1
                    @Override // com.baidu.tieba.view.DynamicUserLikeButton.a
                    public void cO(View view2) {
                        if (GodViewHolder.this.akz != null && GodViewHolder.this.akz.bvs() != null && !GodViewHolder.this.akz.bvs().getIsLike()) {
                            TiebaStatic.log(new ar("c13903").dR("friend_uid", GodViewHolder.this.akz.bvs().getUserId()).dR("obj_name", GodViewHolder.this.kbt.getText().toString()));
                        }
                    }
                });
                this.akz = new com.baidu.tbadk.core.view.userLike.c(GodRecommendListAdapter.this.mPageContext, this.kbv);
                this.akz.kg(true);
            }

            public void onChangeSkinType() {
                if (!this.kbw) {
                    ap.setViewTextColor(this.eIO, R.color.CAM_X0101);
                } else {
                    ap.setViewTextColor(this.eIO, R.color.CAM_X0301);
                }
                ap.setViewTextColor(this.kbt, R.color.CAM_X0101);
                this.kbv.bup();
                com.baidu.tbadk.core.util.f.a.btv().oO(0).oU(R.color.CAM_X0614).oP(R.color.CAM_X0614).oW(com.baidu.adp.lib.util.l.getDimens(GodRecommendListAdapter.this.mContext, R.dimen.tbds1)).af(com.baidu.adp.lib.util.l.getDimens(GodRecommendListAdapter.this.mContext, R.dimen.tbds10)).bv(this.mContainer);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void rX(boolean z) {
                this.kbw = z;
            }
        }
    }
}
