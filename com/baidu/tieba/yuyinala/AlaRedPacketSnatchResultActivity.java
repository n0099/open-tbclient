package com.baidu.tieba.yuyinala;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.ah;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.i;
import com.baidu.live.utils.l;
import com.baidu.tieba.yuyinala.c.f;
import com.baidu.tieba.yuyinala.data.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private HeadImageView bgT;
    private String bme;
    private FrameLayout cuo;
    private TextView euO;
    private View fXB;
    private LinearLayout fXC;
    private TextView fZc;
    private TextView fZd;
    private TextView fZe;
    private BdListView fZf;
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;
    private a nSL;
    private com.baidu.tieba.yuyinala.data.b nSM;
    private com.baidu.tieba.yuyinala.c.a nSN;
    private CustomMessageListener ayx = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private f nSO = new f() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.yuyinala.c.f
        public void b(com.baidu.tieba.yuyinala.data.b bVar) {
            AlaRedPacketSnatchResultActivity.this.a(bVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.f
        public void t(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.h.sdk_net_fail_tip);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (getIntent() == null) {
                finish();
                return;
            }
            parserIntent();
            if (StringUtils.isNullObject(this.mRedPacketId)) {
                finish();
                return;
            }
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            setContentView(a.g.ala_red_packet_snatch_result_view);
            initView();
            this.nSN = new com.baidu.tieba.yuyinala.c.a(getPageContext(), this.nSO);
            this.nSN.at(this.mRedPacketId, this.mLiveId, this.bme);
            MessageManager.getInstance().registerListener(this.ayx);
            lq(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bme = getIntent().getStringExtra("anchor_uk");
    }

    private void initView() {
        this.fXB = findViewById(a.f.rp_result_root_bg);
        this.fXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.f.rp_result_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.cuo = (FrameLayout) findViewById(a.f.rp_result_root_container);
        this.bgT = (HeadImageView) findViewById(a.f.rp_result_user_icon);
        this.bgT.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bgT.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bgT.setIsRound(true);
        this.bgT.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bgT.setAutoChangeStyle(true);
        this.bgT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fZc = (TextView) findViewById(a.f.p_result_top10_desc);
        this.euO = (TextView) findViewById(a.f.p_result_user_name);
        this.fZd = (TextView) findViewById(a.f.p_result_loot_amount);
        this.fXC = (LinearLayout) findViewById(a.f.rp_result_content);
        this.fZe = (TextView) findViewById(a.f.p_result_send_gift);
        this.fZf = (BdListView) findViewById(a.f.p_result_listview);
        this.fZe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bLy();
            }
        });
        this.fXC.setVisibility(8);
        this.fZe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        ah ahVar = new ah();
        ahVar.aIH = -1;
        ahVar.aII = -1;
        ahVar.aIK = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
    }

    public void a(com.baidu.tieba.yuyinala.data.b bVar) {
        String str;
        this.nSM = bVar;
        this.fXC.setVisibility(0);
        this.fZe.setVisibility(0);
        if (!StringUtils.isNullObject(bVar.portrait)) {
            l.a(this.bgT, bVar.portrait, true, false);
        }
        this.euO.setText(bVar.userName);
        if (bVar.gzL) {
            String format = String.format(getPageContext().getResources().getString(a.h.snatch_red_packet_amount_desc), Long.valueOf(bVar.gzt));
            this.fZe.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fXC.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds184);
            this.fXC.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.h.snatch_red_packet_failed_1);
            this.fZe.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fXC.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.fXC.setLayoutParams(layoutParams2);
            str = string;
        }
        this.fZd.setText(str);
        W(bVar.gzM);
    }

    private void W(ArrayList<b.a> arrayList) {
        this.nSL = new a(getPageContext().getPageActivity(), arrayList);
        this.fZf.setAdapter((ListAdapter) this.nSL);
        this.nSL.notifyDataSetChanged();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        lq(configuration.orientation == 2);
    }

    private void lq(boolean z) {
        if (z) {
            i.ae(this.cuo);
            this.cuo.setScaleX(0.85f);
            this.cuo.setScaleY(0.85f);
            return;
        }
        i.af(this.cuo);
        this.cuo.setScaleX(1.0f);
        this.cuo.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.nSN != null) {
            this.nSN.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.ayx);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends BaseAdapter {
        private ArrayList<b.a> fZl;
        private Context mContext;

        public a(Context context, ArrayList<b.a> arrayList) {
            this.mContext = context;
            this.fZl = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fZl != null) {
                return this.fZl.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: Mq */
        public b.a getItem(int i) {
            if (this.fZl != null) {
                return this.fZl.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.mContext).inflate(a.g.ala_loot_user_item, viewGroup, false);
                bVar2.bfS = (HeadImageView) view.findViewById(a.f.rp_user_list_icon);
                bVar2.bfS.setIsRound(true);
                bVar2.bfS.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
                bVar2.bfS.setAutoChangeStyle(true);
                bVar2.bfS.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.fZm = (TextView) view.findViewById(a.f.rp_user_list_name);
                bVar2.fZn = (TextView) view.findViewById(a.f.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            b.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    l.a(bVar.bfS, item.portrait, true, false);
                }
                bVar.fZm.setText(item.userName);
                bVar.fZn.setText(String.format(this.mContext.getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(item.amount)));
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private static class b {
        public HeadImageView bfS;
        public TextView fZm;
        public TextView fZn;

        private b() {
        }
    }
}
