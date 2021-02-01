package com.baidu.yuyinala.more;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.audiolive.NewFrameHttpResponseMessage;
import com.baidu.live.audiolive.a;
import com.baidu.live.audiolive.e;
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
/* loaded from: classes11.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaMoreFunctionDialogData> implements a.b, a.InterfaceC0963a {
    private View erI;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hxV;
    private AlaMoreFunctionDialogData oWE;
    private TextView oWG;
    private TextView oWH;
    private HListView oWI;
    private HListView oWJ;
    private com.baidu.yuyinala.more.a.a oWK;
    private com.baidu.yuyinala.more.a.a oWL;
    private com.baidu.yuyinala.more.c.a oWM;
    private com.baidu.live.audiolive.a oWN;
    private e oWO;

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
        this.oWE = alaMoreFunctionDialogData;
        if (this.oWE != null) {
            this.oWM.L(this.oWE.getLiveId(), this.oWE.getRoomId(), this.oWE.getCustomRoomId(), this.oWE.getGroupId());
            gu(new ArrayList(this.oWE.getGroupList()));
            if (this.oWE.findFunctionByAction("phone_frame_h5") != null) {
                this.oWN.request();
                ejt();
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oWG = (TextView) getViewGroup().findViewById(a.f.func_group_title1_tv);
        this.oWH = (TextView) getViewGroup().findViewById(a.f.func_group_title2_tv);
        this.oWI = (HListView) getViewGroup().findViewById(a.f.function_hlv1);
        this.oWJ = (HListView) getViewGroup().findViewById(a.f.function_hlv2);
        this.erI = getViewGroup().findViewById(a.f.group_divider_view);
        this.oWK = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oWL = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oWM = new com.baidu.yuyinala.more.c.a(this);
        this.oWN = new com.baidu.live.audiolive.a(null, new a.InterfaceC0164a() { // from class: com.baidu.yuyinala.more.c.1
            @Override // com.baidu.live.audiolive.a.InterfaceC0164a
            public void a(NewFrameHttpResponseMessage newFrameHttpResponseMessage) {
                com.baidu.yuyinala.more.b.a findFunctionByAction;
                if (newFrameHttpResponseMessage != null && newFrameHttpResponseMessage.zI() >= 0 && (findFunctionByAction = c.this.oWE.findFunctionByAction("phone_frame_h5")) != null) {
                    if (newFrameHttpResponseMessage.zI() > 0) {
                        findFunctionByAction.XX(newFrameHttpResponseMessage.zI() + "");
                        findFunctionByAction.AI(true);
                    } else {
                        findFunctionByAction.AI(false);
                    }
                    c.this.gu(c.this.oWE.getGroupList());
                }
            }

            @Override // com.baidu.live.audiolive.a.InterfaceC0164a
            public void onFail(int i, String str) {
            }
        });
        this.oWI.setAdapter((ListAdapter) this.oWK);
        this.oWJ.setAdapter((ListAdapter) this.oWL);
        this.oWK.a(this);
        this.oWL.a(this);
        int dimension = (int) this.mTbPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds138);
        ViewGroup.LayoutParams layoutParams = this.oWI.getLayoutParams();
        layoutParams.height = dimension;
        this.oWI.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oWI.getLayoutParams();
        layoutParams2.height = dimension;
        this.oWJ.setLayoutParams(layoutParams2);
    }

    public void b(e eVar) {
        this.oWO = eVar;
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hxV = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gu(List<com.baidu.yuyinala.more.b.b> list) {
        int count = ListUtils.getCount(list);
        com.baidu.yuyinala.more.b.b bVar = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 2);
        if (bVar != null) {
            this.oWG.setText(bVar.getTitle());
            this.oWK.gv(bVar.ejy());
            this.oWG.setVisibility(0);
            this.oWI.setVisibility(0);
            this.erI.setVisibility(0);
        } else {
            this.oWG.setVisibility(8);
            this.oWI.setVisibility(8);
            this.erI.setVisibility(8);
        }
        com.baidu.yuyinala.more.b.b bVar2 = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 1);
        if (bVar2 != null) {
            this.oWH.setText(bVar2.getTitle());
            this.oWL.gv(bVar2.ejy());
            this.oWH.setVisibility(0);
            this.oWJ.setVisibility(0);
            return;
        }
        this.oWH.setVisibility(8);
        this.oWJ.setVisibility(8);
    }

    @Override // com.baidu.yuyinala.more.a.a.b
    public void a(final com.baidu.yuyinala.more.b.a aVar, boolean z) {
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
                case 182510736:
                    if (action.equals("phone_frame_h5")) {
                        c = 11;
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
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oWO != null) {
                                c.this.oWO.zK();
                            }
                        }
                    };
                    break;
                case 1:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oWO != null) {
                                c.this.oWO.zL();
                            }
                        }
                    };
                    break;
                case 2:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oWO != null) {
                                c.this.oWO.zM();
                            }
                        }
                    };
                    break;
                case 3:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oWO != null) {
                                c.this.oWO.zO();
                            }
                        }
                    };
                    break;
                case 4:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.11
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ejr();
                        }
                    };
                    break;
                case 5:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.12
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ejs();
                        }
                    };
                    break;
                case 6:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.13
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501002));
                        }
                    };
                    break;
                case 7:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.14
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oWO != null) {
                                c.this.oWO.zN();
                            }
                        }
                    };
                    break;
                case '\b':
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.2
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501003));
                        }
                    };
                    break;
                case '\t':
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.3
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501004));
                        }
                    };
                    break;
                case '\n':
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.4
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501005));
                        }
                    };
                    break;
                case 11:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oWO != null) {
                                c.this.oWO.fl(aVar.BS());
                            }
                        }
                    };
                    break;
            }
            hd(aVar.getAction(), aVar.getId());
            if (runnable != null) {
                SafeHandler.getInst().postDelayed(runnable, 300L);
            }
            this.hxV.dismiss();
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501017, Boolean.valueOf(ejq())));
            }
        }
    }

    private boolean ejq() {
        if (this.oWE == null || ListUtils.isEmpty(this.oWE.getGroupList())) {
            return false;
        }
        for (com.baidu.yuyinala.more.b.b bVar : this.oWE.getGroupList()) {
            if (bVar != null && !ListUtils.isEmpty(bVar.ejy())) {
                for (com.baidu.yuyinala.more.b.a aVar : bVar.ejy()) {
                    if (aVar != null && aVar.ejx()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejr() {
        AlaWheatMoreFunctionData alaWheatMoreFunctionData = new AlaWheatMoreFunctionData();
        alaWheatMoreFunctionData.mLiveId = this.oWE.getLiveId();
        alaWheatMoreFunctionData.mCustomRoomId = this.oWE.getCustomRoomId();
        alaWheatMoreFunctionData.mRoomId = this.oWE.getRoomId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501076, alaWheatMoreFunctionData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejs() {
        if (!com.baidu.live.ao.a.Yj().Yk()) {
            new d(getTbPageContext().getPageActivity(), this.oWM).show();
            return;
        }
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(getTbPageContext().getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dD(false);
        cVar.o(getTbPageContext().getString(a.h.ala_audio_close_room_title), "", getTbPageContext().getString(a.h.sdk_alert_yes_button), getTbPageContext().getString(a.h.sdk_live_cancel));
        cVar.fl(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.fm(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dF(false);
        cVar.dG(false);
        cVar.A(getTbPageContext().getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize34));
        cVar.dE(false);
        cVar.a(new c.a() { // from class: com.baidu.yuyinala.more.c.6
            @Override // com.baidu.live.view.c.a
            public void Qa() {
                c.this.oWM.ejz();
                c.this.oWM.ejA();
                cVar.dismiss();
                c.this.XW("roomclose_cfm");
            }

            @Override // com.baidu.live.view.c.a
            public void Qb() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    private void ejt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oWE != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oWE.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "voiceframe_show").setContentExt(jSONObject));
    }

    private void hd(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oWE != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oWE.getCustomRoomId());
            }
            if (str == "first_recharge" || str == "super_recharge" || str == "transfer") {
                jSONObject.put("cloudctl_id", str2);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, XV(str)).setContentExt(jSONObject));
    }

    private String XV(String str) {
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
                    c = '\b';
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
            case 182510736:
                if (str.equals("phone_frame_h5")) {
                    c = 7;
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
                    c = '\t';
                    break;
                }
                break;
            case 1280882667:
                if (str.equals("transfer")) {
                    c = '\n';
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
                return "voiceframe_clk";
            case '\b':
            case '\t':
            case '\n':
                return "cloudctl_clk";
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XW(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oWE != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oWE.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, str).setContentExt(jSONObject));
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0963a
    public void Am(boolean z) {
        this.mTbPageContext.showToast(z ? a.h.ala_audio_clear_charm_succ : a.h.ala_audio_clear_charm_fail);
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0963a
    public void eju() {
        this.mTbPageContext.showToast(a.h.ala_audio_close_room_fail);
    }
}
