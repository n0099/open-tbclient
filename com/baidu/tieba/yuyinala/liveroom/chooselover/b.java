package com.baidu.tieba.yuyinala.liveroom.chooselover;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.view.AlphaGradientHListView;
import com.baidu.tieba.yuyinala.liveroom.chooselover.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.g;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends Dialog {
    private w aFN;
    private View bTg;
    private AlphaGradientHListView but;
    private TextView lTh;
    private Activity mActivity;
    private int mCurrentPosition;
    private List<AlaWheatInfoData> mList;
    private d olI;
    private com.baidu.tieba.yuyinala.liveroom.chooselover.a olJ;
    private TextView olK;
    private a olL;

    /* loaded from: classes4.dex */
    public interface a {
        void g(AlaWheatInfoData alaWheatInfoData);

        void h(AlaWheatInfoData alaWheatInfoData);

        void onDismiss();
    }

    public b(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.mCurrentPosition = -2;
        this.mActivity = activity;
        init();
    }

    private void init() {
        initView();
        Zo();
    }

    private void Zo() {
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
        this.bTg = findViewById(a.f.view);
        this.lTh = (TextView) findViewById(a.f.tv_cancel);
        this.olK = (TextView) findViewById(a.f.tv_confirm);
        this.but = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.olJ = new com.baidu.tieba.yuyinala.liveroom.chooselover.a(this.mActivity);
        this.olI = new d(this.mActivity);
        this.but.setAdapter((ListAdapter) this.olI);
        this.but.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.but.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.but.setNeedAlphaShade(true);
        this.but.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.but.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                try {
                    if (b.this.mCurrentPosition < 0 || b.this.mCurrentPosition != i || !((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition)).isSelect) {
                        b.this.mCurrentPosition = i;
                        b.this.edn();
                        int i2 = 0;
                        while (i2 < b.this.mList.size()) {
                            ((AlaWheatInfoData) b.this.mList.get(i2)).isSelect = i2 == i;
                            i2++;
                        }
                        if (b.this.olI != null) {
                            b.this.olI.eh(view);
                        }
                        if (b.this.olL != null) {
                            b.this.olL.g((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition));
                            return;
                        }
                        return;
                    }
                    for (int i3 = 0; i3 < b.this.mList.size(); i3++) {
                        ((AlaWheatInfoData) b.this.mList.get(i3)).isSelect = false;
                    }
                    b.this.edn();
                    b.this.mCurrentPosition = -2;
                    if (b.this.olL != null) {
                        b.this.olL.g(null);
                    }
                } catch (Exception e) {
                }
            }
        });
        this.bTg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dismiss();
            }
        });
        this.lTh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.dismiss();
            }
        });
        this.olK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mCurrentPosition != -2 && b.this.aFN != null && b.this.aFN.aKr != null && b.this.aFN.aKL != null) {
                    b.this.olJ.h(b.this.aFN.aKr.userUk, ((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition)).uk, g.ar(b.this.aFN), g.aq(b.this.aFN));
                }
            }
        });
        this.olJ.a(new a.InterfaceC0924a() { // from class: com.baidu.tieba.yuyinala.liveroom.chooselover.b.5
            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.a.InterfaceC0924a
            public void a(ChooseLoverHttpResponseMessage chooseLoverHttpResponseMessage) {
                b.this.dismiss();
                BdUtilHelper.showToast(b.this.getContext(), "选择成功");
                if (b.this.olL != null) {
                    b.this.olL.h((AlaWheatInfoData) b.this.mList.get(b.this.mCurrentPosition));
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.this.aFN.aKL.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "selectguest_clk").setContentExt(jSONObject));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.chooselover.a.InterfaceC0924a
            public void onFail(int i, String str) {
                b.this.dismiss();
                BdUtilHelper.showToast(b.this.getContext(), "操作失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edn() {
        for (int i = 0; i < this.but.getChildCount(); i++) {
            View childAt = this.but.getChildAt(i);
            if (this.olI != null) {
                this.olI.eg(childAt);
            }
        }
    }

    public void Y(w wVar) {
        this.aFN = wVar;
        try {
            show();
            this.mList = edo();
            this.olI.setData(this.mList);
            this.olI.notifyDataSetChanged();
        } catch (Exception e) {
        }
    }

    private List<AlaWheatInfoData> edo() {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            String Zc = Zc();
            List<AlaWheatInfoData> anchorWheatLists = this.aFN.aKQ.getAnchorWheatLists();
            int i2 = 0;
            while (true) {
                if (i2 >= ListUtils.getCount(anchorWheatLists)) {
                    i = -1;
                    break;
                }
                AlaWheatInfoData alaWheatInfoData = anchorWheatLists.get(i2);
                if (alaWheatInfoData != null && Zc != null && Zc.equals(alaWheatInfoData.uk)) {
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

    public String Zc() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            return ExtraParamsManager.getEncryptionUserId(currentAccountInfo.getID());
        }
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.olL != null) {
                this.olL.onDismiss();
            }
            super.dismiss();
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Throwable th) {
        }
    }

    public void a(a aVar) {
        this.olL = aVar;
    }
}
