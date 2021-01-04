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
import com.baidu.live.data.g;
import com.baidu.live.data.x;
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
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends Dialog {
    private x aGe;
    private View bYQ;
    private CommonEmptyView bxT;
    private AlphaGradientHListView bze;
    private TextView lYv;
    private Activity mActivity;
    private int mCurrentPosition;
    private List<AlaWheatInfoData> mList;
    private d ooE;
    private com.baidu.tieba.yuyinala.liveroom.chooselover.a ooF;
    private TextView ooG;
    private View ooH;
    private a ooI;
    public CustomMessageListener ooJ;

    /* loaded from: classes11.dex */
    public interface a {
        void e(AlaWheatInfoData alaWheatInfoData);

        void f(AlaWheatInfoData alaWheatInfoData);

        void onDismiss();
    }

    public b(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.mCurrentPosition = -2;
        this.ooJ = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof g) && ((g) customResponsedMessage.getData()).Ex() != 1) {
                    b.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        init();
    }

    private void init() {
        initView();
        aaD();
    }

    private void aaD() {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(262144, 262144);
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(this.mActivity);
            attributes.width = -1;
            attributes.gravity = 80;
            attributes.flags = PlatformPlugin.DEFAULT_SYSTEM_UI;
            window.setAttributes(attributes);
            window.setSoftInputMode(48);
        }
    }

    private void initView() {
        setContentView(a.g.yuyin_layout_dialog_choose_love_person);
        this.bxT = (CommonEmptyView) findViewById(a.f.empty_view);
        this.ooH = findViewById(a.f.not_empty_view);
        this.bYQ = findViewById(a.f.view);
        this.lYv = (TextView) findViewById(a.f.tv_cancel);
        this.ooG = (TextView) findViewById(a.f.tv_confirm);
        this.bze = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.ooF = new com.baidu.tieba.yuyinala.liveroom.chooselover.a(this.mActivity);
        this.ooE = new d(this.mActivity);
        this.bze.setAdapter((ListAdapter) this.ooE);
        this.bze.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.bze.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.bze.setNeedAlphaShade(true);
        this.bze.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bze.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                try {
                    if (b.this.mCurrentPosition < 0 || b.this.mCurrentPosition != i || !((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition)).isSelect) {
                        b.this.mCurrentPosition = i;
                        b.this.ecx();
                        int i2 = 0;
                        while (i2 < b.this.mList.size()) {
                            ((AlaWheatInfoData) b.this.mList.get(i2)).isSelect = i2 == i;
                            i2++;
                        }
                        if (b.this.ooE != null) {
                            b.this.ooE.er(view);
                        }
                        if (b.this.ooI != null) {
                            b.this.ooI.e((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition));
                            return;
                        }
                        return;
                    }
                    for (int i3 = 0; i3 < b.this.mList.size(); i3++) {
                        ((AlaWheatInfoData) b.this.mList.get(i3)).isSelect = false;
                    }
                    b.this.ecx();
                    b.this.mCurrentPosition = -2;
                    if (b.this.ooI != null) {
                        b.this.ooI.e(null);
                    }
                } catch (Exception e) {
                }
            }
        });
        this.bYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dismiss();
            }
        });
        this.lYv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dismiss();
            }
        });
        this.ooG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mCurrentPosition != -2 && b.this.aGe != null && b.this.aGe.aKQ != null && b.this.aGe.aLl != null) {
                    b.this.ooF.m(b.this.aGe.aKQ.userUk, ((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition)).uk, com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(b.this.aGe), com.baidu.tieba.yuyinala.liveroom.wheat.e.g.au(b.this.aGe));
                }
            }
        });
        this.ooF.a(new a.InterfaceC0898a() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.5
            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.a.InterfaceC0898a
            public void a(ChooseLoverHttpResponseMessage chooseLoverHttpResponseMessage) {
                b.this.dismiss();
                BdUtilHelper.showToast(b.this.getContext(), "选择成功");
                if (b.this.ooI != null) {
                    b.this.ooI.f((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition));
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.this.aGe.aLl.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "selectguest_clk").setContentExt(jSONObject));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.a.InterfaceC0898a
            public void onFail(int i, String str) {
                b.this.dismiss();
                BdUtilHelper.showToast(b.this.getContext(), "操作失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecx() {
        for (int i = 0; i < this.bze.getChildCount(); i++) {
            View childAt = this.bze.getChildAt(i);
            if (this.ooE != null) {
                this.ooE.eq(childAt);
            }
        }
    }

    public void ac(x xVar) {
        this.aGe = xVar;
        try {
            show();
            this.mList = ecy();
            if (ListUtils.isEmpty(this.mList)) {
                this.bxT.reset();
                this.bxT.setTitle(a.h.yuyin_ala_dating_none_on_wheat);
                this.bxT.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.LIGHT);
                this.bxT.setVisibility(0);
                this.ooH.setVisibility(8);
            } else {
                this.ooE.setData(this.mList);
                this.ooE.notifyDataSetChanged();
                this.bxT.setVisibility(8);
                this.ooH.setVisibility(0);
            }
        } catch (Exception e) {
        }
    }

    private List<AlaWheatInfoData> ecy() {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            String aar = aar();
            List<AlaWheatInfoData> anchorWheatLists = this.aGe.aLq.getAnchorWheatLists();
            int i2 = 0;
            while (true) {
                if (i2 >= ListUtils.getCount(anchorWheatLists)) {
                    i = -1;
                    break;
                }
                AlaWheatInfoData alaWheatInfoData = anchorWheatLists.get(i2);
                if (alaWheatInfoData != null && aar != null && aar.equals(alaWheatInfoData.uk)) {
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

    public String aar() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        }
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.ooI != null) {
                this.ooI.onDismiss();
            }
            MessageManager.getInstance().unRegisterListener(this.ooJ);
            super.dismiss();
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            MessageManager.getInstance().registerListener(this.ooJ);
        } catch (Throwable th) {
        }
    }

    public void a(a aVar) {
        this.ooI = aVar;
    }
}
