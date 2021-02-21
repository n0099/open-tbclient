package com.baidu.tieba.yuyinala.liveroom.chooselover;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.data.g;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import com.baidu.tieba.yuyinala.liveroom.chooselover.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends Dialog {
    private ab aDd;
    private View bYd;
    private CommonEmptyView bwJ;
    private AlphaGradientHListView bxP;
    private Activity mActivity;
    private int mCurrentPosition;
    private List<AlaWheatInfoData> mList;
    private TextView mdj;
    private d our;
    private com.baidu.tieba.yuyinala.liveroom.chooselover.a ous;
    private TextView ouu;
    private View ouv;
    private a ouw;
    public CustomMessageListener oux;

    /* loaded from: classes11.dex */
    public interface a {
        void e(AlaWheatInfoData alaWheatInfoData);

        void f(AlaWheatInfoData alaWheatInfoData);

        void onDismiss();
    }

    public b(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.mCurrentPosition = -2;
        this.oux = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof g) && ((g) customResponsedMessage.getData()).Bm() != 1) {
                    b.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        init();
    }

    private void init() {
        initView();
        YB();
    }

    private void YB() {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(262144, 262144);
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(this.mActivity);
            attributes.width = -1;
            attributes.gravity = 80;
            attributes.flags = 1280;
            window.setAttributes(attributes);
            window.setSoftInputMode(48);
        }
    }

    private void initView() {
        setContentView(a.g.yuyin_layout_dialog_choose_love_person);
        this.bwJ = (CommonEmptyView) findViewById(a.f.empty_view);
        this.ouv = findViewById(a.f.not_empty_view);
        this.bYd = findViewById(a.f.view);
        this.mdj = (TextView) findViewById(a.f.tv_cancel);
        this.ouu = (TextView) findViewById(a.f.tv_confirm);
        this.bxP = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.ous = new com.baidu.tieba.yuyinala.liveroom.chooselover.a(this.mActivity);
        this.our = new d(this.mActivity);
        this.bxP.setAdapter((ListAdapter) this.our);
        this.bxP.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.bxP.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.bxP.setNeedAlphaShade(true);
        this.bxP.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bxP.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                try {
                    if (b.this.mCurrentPosition < 0 || b.this.mCurrentPosition != i || !((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition)).isSelect) {
                        b.this.mCurrentPosition = i;
                        b.this.ebb();
                        int i2 = 0;
                        while (i2 < b.this.mList.size()) {
                            ((AlaWheatInfoData) b.this.mList.get(i2)).isSelect = i2 == i;
                            i2++;
                        }
                        if (b.this.our != null) {
                            b.this.our.ep(view);
                        }
                        if (b.this.ouw != null) {
                            b.this.ouw.e((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition));
                            return;
                        }
                        return;
                    }
                    for (int i3 = 0; i3 < b.this.mList.size(); i3++) {
                        ((AlaWheatInfoData) b.this.mList.get(i3)).isSelect = false;
                    }
                    b.this.ebb();
                    b.this.mCurrentPosition = -2;
                    if (b.this.ouw != null) {
                        b.this.ouw.e(null);
                    }
                } catch (Exception e) {
                }
            }
        });
        this.bYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dismiss();
            }
        });
        this.mdj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dismiss();
            }
        });
        this.ouu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mCurrentPosition != -2 && b.this.aDd != null && b.this.aDd.aIz != null && b.this.aDd.aIU != null) {
                    b.this.ous.m(b.this.aDd.aIz.userUk, ((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition)).uk, com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(b.this.aDd), com.baidu.tieba.yuyinala.liveroom.wheat.e.g.au(b.this.aDd));
                }
            }
        });
        this.ous.a(new a.InterfaceC0925a() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.5
            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.a.InterfaceC0925a
            public void a(ChooseLoverHttpResponseMessage chooseLoverHttpResponseMessage) {
                b.this.dismiss();
                BdUtilHelper.showToast(b.this.getContext(), "选择成功");
                if (b.this.ouw != null) {
                    b.this.ouw.f((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition));
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.this.aDd.aIU.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "selectguest_clk").setContentExt(jSONObject));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.a.InterfaceC0925a
            public void onFail(int i, String str) {
                b.this.dismiss();
                BdUtilHelper.showToast(b.this.getContext(), "操作失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebb() {
        for (int i = 0; i < this.bxP.getChildCount(); i++) {
            View childAt = this.bxP.getChildAt(i);
            if (this.our != null) {
                this.our.eo(childAt);
            }
        }
    }

    public void ab(ab abVar) {
        this.aDd = abVar;
        try {
            show();
            this.mList = ebc();
            if (ListUtils.isEmpty(this.mList)) {
                this.bwJ.reset();
                this.bwJ.setTitle(a.h.yuyin_ala_dating_none_on_wheat);
                this.bwJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
                this.bwJ.setVisibility(0);
                this.ouv.setVisibility(8);
            } else {
                this.our.setData(this.mList);
                this.our.notifyDataSetChanged();
                this.bwJ.setVisibility(8);
                this.ouv.setVisibility(0);
            }
        } catch (Exception e) {
        }
    }

    private List<AlaWheatInfoData> ebc() {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            String Yp = Yp();
            List<AlaWheatInfoData> anchorWheatLists = this.aDd.aIY.getAnchorWheatLists();
            int i2 = 0;
            while (true) {
                if (i2 >= ListUtils.getCount(anchorWheatLists)) {
                    i = -1;
                    break;
                }
                AlaWheatInfoData alaWheatInfoData = anchorWheatLists.get(i2);
                if (alaWheatInfoData != null && Yp != null && Yp.equals(alaWheatInfoData.uk)) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i <= 3) {
                for (int i3 = 4; i3 < 8; i3++) {
                    if (anchorWheatLists.get(i3) != null) {
                        arrayList.add(anchorWheatLists.get(i3));
                    }
                }
            } else {
                for (int i4 = 0; i4 < 4; i4++) {
                    if (anchorWheatLists.get(i4) != null) {
                        arrayList.add(anchorWheatLists.get(i4));
                    }
                }
            }
        } catch (Exception e) {
        }
        return arrayList;
    }

    public String Yp() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        }
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.ouw != null) {
                this.ouw.onDismiss();
            }
            MessageManager.getInstance().unRegisterListener(this.oux);
            super.dismiss();
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            MessageManager.getInstance().registerListener(this.oux);
        } catch (Throwable th) {
        }
    }

    public void a(a aVar) {
        this.ouw = aVar;
    }
}
