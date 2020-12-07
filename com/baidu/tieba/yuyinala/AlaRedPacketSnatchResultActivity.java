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
import com.baidu.live.data.ai;
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
    private HeadImageView bli;
    private String brl;
    private FrameLayout cBi;
    private TextView eBQ;
    private View gfM;
    private LinearLayout gfN;
    private TextView ghn;
    private TextView gho;
    private TextView ghp;
    private BdListView ghq;
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;
    private a ohJ;
    private com.baidu.tieba.yuyinala.data.b ohK;
    private com.baidu.tieba.yuyinala.c.a ohL;
    private CustomMessageListener aAS = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private f ohM = new f() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.2
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
            this.ohL = new com.baidu.tieba.yuyinala.c.a(getPageContext(), this.ohM);
            this.ohL.av(this.mRedPacketId, this.mLiveId, this.brl);
            MessageManager.getInstance().registerListener(this.aAS);
            lL(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.brl = getIntent().getStringExtra("anchor_uk");
    }

    private void initView() {
        this.gfM = findViewById(a.f.rp_result_root_bg);
        this.gfM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.3
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
        this.cBi = (FrameLayout) findViewById(a.f.rp_result_root_container);
        this.bli = (HeadImageView) findViewById(a.f.rp_result_user_icon);
        this.bli.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bli.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bli.setIsRound(true);
        this.bli.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bli.setAutoChangeStyle(true);
        this.bli.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ghn = (TextView) findViewById(a.f.p_result_top10_desc);
        this.eBQ = (TextView) findViewById(a.f.p_result_user_name);
        this.gho = (TextView) findViewById(a.f.p_result_loot_amount);
        this.gfN = (LinearLayout) findViewById(a.f.rp_result_content);
        this.ghp = (TextView) findViewById(a.f.p_result_send_gift);
        this.ghq = (BdListView) findViewById(a.f.p_result_listview);
        this.ghp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bPh();
            }
        });
        this.gfN.setVisibility(8);
        this.ghp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPh() {
        ai aiVar = new ai();
        aiVar.aLA = -1;
        aiVar.aLB = -1;
        aiVar.aLD = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
    }

    public void a(com.baidu.tieba.yuyinala.data.b bVar) {
        String str;
        this.ohK = bVar;
        this.gfN.setVisibility(0);
        this.ghp.setVisibility(0);
        if (!StringUtils.isNullObject(bVar.portrait)) {
            l.a(this.bli, bVar.portrait, true, false);
        }
        this.eBQ.setText(bVar.userName);
        if (bVar.gIH) {
            String format = String.format(getPageContext().getResources().getString(a.h.snatch_red_packet_amount_desc), Long.valueOf(bVar.gIp));
            this.ghp.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gfN.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds184);
            this.gfN.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.h.snatch_red_packet_failed_1);
            this.ghp.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gfN.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.d.sdk_ds50);
            this.gfN.setLayoutParams(layoutParams2);
            str = string;
        }
        this.gho.setText(str);
        W(bVar.gII);
    }

    private void W(ArrayList<b.a> arrayList) {
        this.ohJ = new a(getPageContext().getPageActivity(), arrayList);
        this.ghq.setAdapter((ListAdapter) this.ohJ);
        this.ohJ.notifyDataSetChanged();
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
        lL(configuration.orientation == 2);
    }

    private void lL(boolean z) {
        if (z) {
            i.ae(this.cBi);
            this.cBi.setScaleX(0.85f);
            this.cBi.setScaleY(0.85f);
            return;
        }
        i.af(this.cBi);
        this.cBi.setScaleX(1.0f);
        this.cBi.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ohL != null) {
            this.ohL.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aAS);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends BaseAdapter {
        private ArrayList<b.a> ghw;
        private Context mContext;

        public a(Context context, ArrayList<b.a> arrayList) {
            this.mContext = context;
            this.ghw = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.ghw != null) {
                return this.ghw.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: Ni */
        public b.a getItem(int i) {
            if (this.ghw != null) {
                return this.ghw.get(i);
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
                bVar2.bki = (HeadImageView) view.findViewById(a.f.rp_user_list_icon);
                bVar2.bki.setIsRound(true);
                bVar2.bki.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
                bVar2.bki.setAutoChangeStyle(true);
                bVar2.bki.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.ghx = (TextView) view.findViewById(a.f.rp_user_list_name);
                bVar2.ghy = (TextView) view.findViewById(a.f.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            b.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    l.a(bVar.bki, item.portrait, true, false);
                }
                bVar.ghx.setText(item.userName);
                bVar.ghy.setText(String.format(this.mContext.getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(item.amount)));
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private static class b {
        public HeadImageView bki;
        public TextView ghx;
        public TextView ghy;

        private b() {
        }
    }
}
