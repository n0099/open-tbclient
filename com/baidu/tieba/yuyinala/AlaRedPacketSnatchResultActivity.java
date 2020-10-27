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
import com.baidu.live.data.ag;
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
    private HeadImageView bhl;
    private String bmv;
    private FrameLayout cqc;
    private TextView eqE;
    private View fSe;
    private LinearLayout fSf;
    private TextView fTF;
    private TextView fTG;
    private TextView fTH;
    private BdListView fTI;
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;
    private a nLo;
    private com.baidu.tieba.yuyinala.data.b nLp;
    private com.baidu.tieba.yuyinala.c.a nLq;
    private CustomMessageListener aAi = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private f nLr = new f() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.yuyinala.c.f
        public void b(com.baidu.tieba.yuyinala.data.b bVar) {
            AlaRedPacketSnatchResultActivity.this.a(bVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.f
        public void t(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.i.sdk_net_fail_tip);
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
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            setContentView(a.h.ala_red_packet_snatch_result_view);
            initView();
            this.nLq = new com.baidu.tieba.yuyinala.c.a(getPageContext(), this.nLr);
            this.nLq.as(this.mRedPacketId, this.mLiveId, this.bmv);
            MessageManager.getInstance().registerListener(this.aAi);
            lg(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bmv = getIntent().getStringExtra("anchor_uk");
    }

    private void initView() {
        this.fSe = findViewById(a.g.rp_result_root_bg);
        this.fSe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.g.rp_result_close_btn);
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
        this.cqc = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.bhl = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.bhl.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.bhl.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.bhl.setIsRound(true);
        this.bhl.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.bhl.setAutoChangeStyle(true);
        this.bhl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fTF = (TextView) findViewById(a.g.p_result_top10_desc);
        this.eqE = (TextView) findViewById(a.g.p_result_user_name);
        this.fTG = (TextView) findViewById(a.g.p_result_loot_amount);
        this.fSf = (LinearLayout) findViewById(a.g.rp_result_content);
        this.fTH = (TextView) findViewById(a.g.p_result_send_gift);
        this.fTI = (BdListView) findViewById(a.g.p_result_listview);
        this.fTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bJG();
            }
        });
        this.fSf.setVisibility(8);
        this.fTH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJG() {
        ag agVar = new ag();
        agVar.aJs = -1;
        agVar.aJt = -1;
        agVar.aJv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, agVar));
    }

    public void a(com.baidu.tieba.yuyinala.data.b bVar) {
        String str;
        this.nLp = bVar;
        this.fSf.setVisibility(0);
        this.fTH.setVisibility(0);
        if (!StringUtils.isNullObject(bVar.portrait)) {
            l.a(this.bhl, bVar.portrait, true, false);
        }
        this.eqE.setText(bVar.userName);
        if (bVar.guq) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(bVar.gtY));
            this.fTH.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fSf.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.fSf.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.fTH.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fSf.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.fSf.setLayoutParams(layoutParams2);
            str = string;
        }
        this.fTG.setText(str);
        W(bVar.gur);
    }

    private void W(ArrayList<b.a> arrayList) {
        this.nLo = new a(getPageContext().getPageActivity(), arrayList);
        this.fTI.setAdapter((ListAdapter) this.nLo);
        this.nLo.notifyDataSetChanged();
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
        lg(configuration.orientation == 2);
    }

    private void lg(boolean z) {
        if (z) {
            i.aa(this.cqc);
            this.cqc.setScaleX(0.85f);
            this.cqc.setScaleY(0.85f);
            return;
        }
        i.ab(this.cqc);
        this.cqc.setScaleX(1.0f);
        this.cqc.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.nLq != null) {
            this.nLq.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.aAi);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends BaseAdapter {
        private ArrayList<b.a> fTO;
        private Context mContext;

        public a(Context context, ArrayList<b.a> arrayList) {
            this.mContext = context;
            this.fTO = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fTO != null) {
                return this.fTO.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: LA */
        public b.a getItem(int i) {
            if (this.fTO != null) {
                return this.fTO.get(i);
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
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_loot_user_item, viewGroup, false);
                bVar2.bgk = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.bgk.setIsRound(true);
                bVar2.bgk.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.bgk.setAutoChangeStyle(true);
                bVar2.bgk.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.fTP = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.fTQ = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            b.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    l.a(bVar.bgk, item.portrait, true, false);
                }
                bVar.fTP.setText(item.userName);
                bVar.fTQ.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.amount)));
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private static class b {
        public HeadImageView bgk;
        public TextView fTP;
        public TextView fTQ;

        private b() {
        }
    }
}
