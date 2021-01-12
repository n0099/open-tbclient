package com.baidu.yuyinala.more;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaWheatMoreFunctionData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.view.c;
import com.baidu.tbadk.TbConfig;
import com.baidu.yuyinala.more.a.a;
import com.baidu.yuyinala.more.c.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaMoreFunctionDialogData> implements a.b, a.InterfaceC0959a {
    private View epB;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c htL;
    private TextView oMA;
    private HListView oMB;
    private HListView oMC;
    private com.baidu.yuyinala.more.a.a oMD;
    private com.baidu.yuyinala.more.a.a oME;
    private com.baidu.yuyinala.more.c.a oMF;
    private com.baidu.live.e.c oMG;
    private AlaMoreFunctionDialogData oMx;
    private TextView oMz;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.g.activity_ala_audio_more_feature;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaMoreFunctionDialogData alaMoreFunctionDialogData) {
        this.oMx = alaMoreFunctionDialogData;
        if (this.oMx != null) {
            this.oMF.N(this.oMx.getLiveId(), this.oMx.getRoomId(), this.oMx.getCustomRoomId(), this.oMx.getGroupId());
            gw(new ArrayList(this.oMx.getGroupList()));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oMz = (TextView) getViewGroup().findViewById(a.f.func_group_title1_tv);
        this.oMA = (TextView) getViewGroup().findViewById(a.f.func_group_title2_tv);
        this.oMB = (HListView) getViewGroup().findViewById(a.f.function_hlv1);
        this.oMC = (HListView) getViewGroup().findViewById(a.f.function_hlv2);
        this.epB = getViewGroup().findViewById(a.f.group_divider_view);
        this.oMD = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oME = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oMF = new com.baidu.yuyinala.more.c.a(this);
        this.oMB.setAdapter((ListAdapter) this.oMD);
        this.oMC.setAdapter((ListAdapter) this.oME);
        this.oMD.a(this);
        this.oME.a(this);
        int dimension = (int) this.mTbPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds138);
        ViewGroup.LayoutParams layoutParams = this.oMB.getLayoutParams();
        layoutParams.height = dimension;
        this.oMB.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oMB.getLayoutParams();
        layoutParams2.height = dimension;
        this.oMC.setLayoutParams(layoutParams2);
    }

    public void b(com.baidu.live.e.c cVar) {
        this.oMG = cVar;
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.htL = cVar;
    }

    private void gw(List<com.baidu.yuyinala.more.b.b> list) {
        int count = ListUtils.getCount(list);
        com.baidu.yuyinala.more.b.b bVar = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 2);
        if (bVar != null) {
            this.oMz.setText(bVar.getTitle());
            this.oMD.gx(bVar.ehe());
            this.oMz.setVisibility(0);
            this.oMB.setVisibility(0);
            this.epB.setVisibility(0);
        } else {
            this.oMz.setVisibility(8);
            this.oMB.setVisibility(8);
            this.epB.setVisibility(8);
        }
        com.baidu.yuyinala.more.b.b bVar2 = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 1);
        if (bVar2 != null) {
            this.oMA.setText(bVar2.getTitle());
            this.oME.gx(bVar2.ehe());
            this.oMA.setVisibility(0);
            this.oMC.setVisibility(0);
            return;
        }
        this.oMA.setVisibility(8);
        this.oMC.setVisibility(8);
    }

    @Override // com.baidu.yuyinala.more.a.a.b
    public void a(com.baidu.yuyinala.more.b.a aVar, boolean z) {
        if (aVar != null) {
            Runnable runnable = null;
            AlaMoreFunctionDialogData.saveClickedId(aVar);
            String action = aVar.getAction();
            char c = 65535;
            switch (action.hashCode()) {
                case -2061609278:
                    if (action.equals("close_room")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1890252483:
                    if (action.equals("sticker")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1877564121:
                    if (action.equals("play_rule")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1466768554:
                    if (action.equals("first_recharge")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1257946267:
                    if (action.equals("clear_charm")) {
                        c = 4;
                        break;
                    }
                    break;
                case -542676707:
                    if (action.equals("change_background")) {
                        c = 2;
                        break;
                    }
                    break;
                case 109400031:
                    if (action.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                        c = 6;
                        break;
                    }
                    break;
                case 523664713:
                    if (action.equals("room_manage")) {
                        c = 0;
                        break;
                    }
                    break;
                case 847411947:
                    if (action.equals("super_recharge")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1280882667:
                    if (action.equals("transfer")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1946687661:
                    if (action.equals("change_roommode")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oMG != null) {
                                c.this.oMG.za();
                            }
                        }
                    };
                    break;
                case 1:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oMG != null) {
                                c.this.oMG.zb();
                            }
                        }
                    };
                    break;
                case 2:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oMG != null) {
                                c.this.oMG.zc();
                            }
                        }
                    };
                    break;
                case 3:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oMG != null) {
                                c.this.oMG.ze();
                            }
                        }
                    };
                    break;
                case 4:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.egZ();
                        }
                    };
                    break;
                case 5:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.eha();
                        }
                    };
                    break;
                case 6:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.10
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501002));
                        }
                    };
                    break;
                case 7:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oMG != null) {
                                c.this.oMG.zd();
                            }
                        }
                    };
                    break;
                case '\b':
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.12
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501003));
                        }
                    };
                    break;
                case '\t':
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501004));
                        }
                    };
                    break;
                case '\n':
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501005));
                        }
                    };
                    break;
            }
            gW(aVar.getAction(), aVar.getId());
            if (runnable != null) {
                SafeHandler.getInst().postDelayed(runnable, 300L);
            }
            this.htL.dismiss();
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501017, Boolean.valueOf(egY())));
            }
        }
    }

    private boolean egY() {
        if (this.oMx == null || ListUtils.isEmpty(this.oMx.getGroupList())) {
            return false;
        }
        for (com.baidu.yuyinala.more.b.b bVar : this.oMx.getGroupList()) {
            if (bVar != null && !ListUtils.isEmpty(bVar.ehe())) {
                for (com.baidu.yuyinala.more.b.a aVar : bVar.ehe()) {
                    if (aVar != null && aVar.ehd()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egZ() {
        AlaWheatMoreFunctionData alaWheatMoreFunctionData = new AlaWheatMoreFunctionData();
        alaWheatMoreFunctionData.mLiveId = this.oMx.getLiveId();
        alaWheatMoreFunctionData.mCustomRoomId = this.oMx.getCustomRoomId();
        alaWheatMoreFunctionData.mRoomId = this.oMx.getRoomId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501076, alaWheatMoreFunctionData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eha() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(getTbPageContext().getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dv(false);
        cVar.o(getTbPageContext().getString(a.h.ala_audio_close_room_title), "", getTbPageContext().getString(a.h.sdk_alert_yes_button), getTbPageContext().getString(a.h.sdk_live_cancel));
        cVar.fh(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.fi(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dx(false);
        cVar.dy(false);
        cVar.A(getTbPageContext().getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize34));
        cVar.dw(false);
        cVar.a(new c.a() { // from class: com.baidu.yuyinala.more.c.4
            @Override // com.baidu.live.view.c.a
            public void OB() {
                c.this.oMF.ehf();
                c.this.oMF.ehg();
                cVar.dismiss();
                c.this.WW("roomclose_cfm");
            }

            @Override // com.baidu.live.view.c.a
            public void OC() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    private void gW(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oMx != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oMx.getCustomRoomId());
            }
            if (str == "first_recharge" || str == "super_recharge" || str == "transfer") {
                jSONObject.put("cloudctl_id", str2);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, WV(str)).setContentExt(jSONObject));
    }

    private String WV(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -2061609278:
                if (str.equals("close_room")) {
                    c = 4;
                    break;
                }
                break;
            case -1890252483:
                if (str.equals("sticker")) {
                    c = 6;
                    break;
                }
                break;
            case -1877564121:
                if (str.equals("play_rule")) {
                    c = 1;
                    break;
                }
                break;
            case -1466768554:
                if (str.equals("first_recharge")) {
                    c = 7;
                    break;
                }
                break;
            case -1257946267:
                if (str.equals("clear_charm")) {
                    c = 3;
                    break;
                }
                break;
            case -542676707:
                if (str.equals("change_background")) {
                    c = 2;
                    break;
                }
                break;
            case 109400031:
                if (str.equals(TbConfig.TMP_SHARE_DIR_NAME)) {
                    c = 5;
                    break;
                }
                break;
            case 523664713:
                if (str.equals("room_manage")) {
                    c = 0;
                    break;
                }
                break;
            case 847411947:
                if (str.equals("super_recharge")) {
                    c = '\b';
                    break;
                }
                break;
            case 1280882667:
                if (str.equals("transfer")) {
                    c = '\t';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "roomset_clk";
            case 1:
                return "rulebtn_clk";
            case 2:
                return "backchange_clk";
            case 3:
                return "xdremove_clk";
            case 4:
                return "roomclose_clk";
            case 5:
                return "sharebtn_clk";
            case 6:
                return "memebtn_clk";
            case 7:
            case '\b':
            case '\t':
                return "cloudctl_clk";
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WW(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oMx != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oMx.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, str).setContentExt(jSONObject));
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0959a
    public void zT(boolean z) {
        this.mTbPageContext.showToast(z ? a.h.ala_audio_clear_charm_succ : a.h.ala_audio_clear_charm_fail);
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0959a
    public void ehb() {
        this.mTbPageContext.showToast(a.h.ala_audio_close_room_fail);
    }
}
