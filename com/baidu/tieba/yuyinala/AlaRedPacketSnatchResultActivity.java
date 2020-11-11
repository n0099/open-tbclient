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
    private HeadImageView biH;
    private String bnP;
    private FrameLayout cwa;
    private TextView ewx;
    private View fXU;
    private LinearLayout fXV;
    private TextView fZv;
    private TextView fZw;
    private TextView fZx;
    private BdListView fZy;
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;
    private a nRi;
    private com.baidu.tieba.yuyinala.data.b nRj;
    private com.baidu.tieba.yuyinala.c.a nRk;
    private CustomMessageListener aAi = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private f nRl = new f() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.2
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
            this.nRk = new com.baidu.tieba.yuyinala.c.a(getPageContext(), this.nRl);
            this.nRk.at(this.mRedPacketId, this.mLiveId, this.bnP);
            MessageManager.getInstance().registerListener(this.aAi);
            lp(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bnP = getIntent().getStringExtra("anchor_uk");
    }

    private void initView() {
        this.fXU = findViewById(a.f.rp_result_root_bg);
        this.fXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.3
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
        this.cwa = (FrameLayout) findViewById(a.f.rp_result_root_container);
        this.biH = (HeadImageView) findViewById(a.f.rp_result_user_icon);
        this.biH.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.biH.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.biH.setIsRound(true);
        this.biH.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.biH.setAutoChangeStyle(true);
        this.biH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fZv = (TextView) findViewById(a.f.p_result_top10_desc);
        this.ewx = (TextView) findViewById(a.f.p_result_user_name);
        this.fZw = (TextView) findViewById(a.f.p_result_loot_amount);
        this.fXV = (LinearLayout) findViewById(a.f.rp_result_content);
        this.fZx = (TextView) findViewById(a.f.p_result_send_gift);
        this.fZy = (BdListView) findViewById(a.f.p_result_listview);
        this.fZx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bMf();
            }
        });
        this.fXV.setVisibility(8);
        this.fZx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMf() {
        ah ahVar = new ah();
        ahVar.aKs = -1;
        ahVar.aKt = -1;
        ahVar.aKv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
    }

    public void a(com.baidu.tieba.yuyinala.data.b bVar) {
        String str;
        this.nRj = bVar;
        this.fXV.setVisibility(0);
        this.fZx.setVisibility(0);
        if (!StringUtils.isNullObject(bVar.portrait)) {
            l.a(this.biH, bVar.portrait, true, false);
        }
        this.ewx.setText(bVar.userName);
        if (bVar.gAe) {
            String format = String.format(getPageContext().getResources().getString(a.h.snatch_red_packet_amount_desc), Long.valueOf(bVar.gzM));
            this.fZx.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fXV.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds184);
            this.fXV.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.h.snatch_red_packet_failed_1);
            this.fZx.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fXV.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.fXV.setLayoutParams(layoutParams2);
            str = string;
        }
        this.fZw.setText(str);
        W(bVar.gAf);
    }

    private void W(ArrayList<b.a> arrayList) {
        this.nRi = new a(getPageContext().getPageActivity(), arrayList);
        this.fZy.setAdapter((ListAdapter) this.nRi);
        this.nRi.notifyDataSetChanged();
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
        lp(configuration.orientation == 2);
    }

    private void lp(boolean z) {
        if (z) {
            i.ae(this.cwa);
            this.cwa.setScaleX(0.85f);
            this.cwa.setScaleY(0.85f);
            return;
        }
        i.af(this.cwa);
        this.cwa.setScaleX(1.0f);
        this.cwa.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.nRk != null) {
            this.nRk.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aAi);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends BaseAdapter {
        private ArrayList<b.a> fZE;
        private Context mContext;

        public a(Context context, ArrayList<b.a> arrayList) {
            this.mContext = context;
            this.fZE = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fZE != null) {
                return this.fZE.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: LN */
        public b.a getItem(int i) {
            if (this.fZE != null) {
                return this.fZE.get(i);
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
                bVar2.bhE = (HeadImageView) view.findViewById(a.f.rp_user_list_icon);
                bVar2.bhE.setIsRound(true);
                bVar2.bhE.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
                bVar2.bhE.setAutoChangeStyle(true);
                bVar2.bhE.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.fZF = (TextView) view.findViewById(a.f.rp_user_list_name);
                bVar2.fZG = (TextView) view.findViewById(a.f.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            b.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    l.a(bVar.bhE, item.portrait, true, false);
                }
                bVar.fZF.setText(item.userName);
                bVar.fZG.setText(String.format(this.mContext.getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(item.amount)));
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private static class b {
        public HeadImageView bhE;
        public TextView fZF;
        public TextView fZG;

        private b() {
        }
    }
}
