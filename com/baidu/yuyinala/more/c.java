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
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaMoreFunctionDialogData> implements a.b, a.InterfaceC0965a {
    private View erI;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hyj;
    private AlaMoreFunctionDialogData oXe;
    private TextView oXg;
    private TextView oXh;
    private HListView oXi;
    private HListView oXj;
    private com.baidu.yuyinala.more.a.a oXk;
    private com.baidu.yuyinala.more.a.a oXl;
    private com.baidu.yuyinala.more.c.a oXm;
    private com.baidu.live.audiolive.a oXn;
    private e oXo;

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
        this.oXe = alaMoreFunctionDialogData;
        if (this.oXe != null) {
            this.oXm.L(this.oXe.getLiveId(), this.oXe.getRoomId(), this.oXe.getCustomRoomId(), this.oXe.getGroupId());
            gu(new ArrayList(this.oXe.getGroupList()));
            if (this.oXe.findFunctionByAction("phone_frame_h5") != null) {
                this.oXn.request();
                ejB();
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oXg = (TextView) getViewGroup().findViewById(a.f.func_group_title1_tv);
        this.oXh = (TextView) getViewGroup().findViewById(a.f.func_group_title2_tv);
        this.oXi = (HListView) getViewGroup().findViewById(a.f.function_hlv1);
        this.oXj = (HListView) getViewGroup().findViewById(a.f.function_hlv2);
        this.erI = getViewGroup().findViewById(a.f.group_divider_view);
        this.oXk = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oXl = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oXm = new com.baidu.yuyinala.more.c.a(this);
        this.oXn = new com.baidu.live.audiolive.a(null, new a.InterfaceC0164a() { // from class: com.baidu.yuyinala.more.c.1
            @Override // com.baidu.live.audiolive.a.InterfaceC0164a
            public void a(NewFrameHttpResponseMessage newFrameHttpResponseMessage) {
                com.baidu.yuyinala.more.b.a findFunctionByAction;
                if (newFrameHttpResponseMessage != null && newFrameHttpResponseMessage.zI() >= 0 && (findFunctionByAction = c.this.oXe.findFunctionByAction("phone_frame_h5")) != null) {
                    if (newFrameHttpResponseMessage.zI() > 0) {
                        findFunctionByAction.Yj(newFrameHttpResponseMessage.zI() + "");
                        findFunctionByAction.AI(true);
                    } else {
                        findFunctionByAction.AI(false);
                    }
                    c.this.gu(c.this.oXe.getGroupList());
                }
            }

            @Override // com.baidu.live.audiolive.a.InterfaceC0164a
            public void onFail(int i, String str) {
            }
        });
        this.oXi.setAdapter((ListAdapter) this.oXk);
        this.oXj.setAdapter((ListAdapter) this.oXl);
        this.oXk.a(this);
        this.oXl.a(this);
        int dimension = (int) this.mTbPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds138);
        ViewGroup.LayoutParams layoutParams = this.oXi.getLayoutParams();
        layoutParams.height = dimension;
        this.oXi.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oXi.getLayoutParams();
        layoutParams2.height = dimension;
        this.oXj.setLayoutParams(layoutParams2);
    }

    public void b(e eVar) {
        this.oXo = eVar;
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hyj = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gu(List<com.baidu.yuyinala.more.b.b> list) {
        int count = ListUtils.getCount(list);
        com.baidu.yuyinala.more.b.b bVar = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 2);
        if (bVar != null) {
            this.oXg.setText(bVar.getTitle());
            this.oXk.gv(bVar.ejG());
            this.oXg.setVisibility(0);
            this.oXi.setVisibility(0);
            this.erI.setVisibility(0);
        } else {
            this.oXg.setVisibility(8);
            this.oXi.setVisibility(8);
            this.erI.setVisibility(8);
        }
        com.baidu.yuyinala.more.b.b bVar2 = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 1);
        if (bVar2 != null) {
            this.oXh.setText(bVar2.getTitle());
            this.oXl.gv(bVar2.ejG());
            this.oXh.setVisibility(0);
            this.oXj.setVisibility(0);
            return;
        }
        this.oXh.setVisibility(8);
        this.oXj.setVisibility(8);
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
                            if (c.this.oXo != null) {
                                c.this.oXo.zK();
                            }
                        }
                    };
                    break;
                case 1:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oXo != null) {
                                c.this.oXo.zL();
                            }
                        }
                    };
                    break;
                case 2:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oXo != null) {
                                c.this.oXo.zM();
                            }
                        }
                    };
                    break;
                case 3:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oXo != null) {
                                c.this.oXo.zO();
                            }
                        }
                    };
                    break;
                case 4:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.11
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ejz();
                        }
                    };
                    break;
                case 5:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.12
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ejA();
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
                            if (c.this.oXo != null) {
                                c.this.oXo.zN();
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
                            if (c.this.oXo != null) {
                                c.this.oXo.fl(aVar.BS());
                            }
                        }
                    };
                    break;
            }
            hf(aVar.getAction(), aVar.getId());
            if (runnable != null) {
                SafeHandler.getInst().postDelayed(runnable, 300L);
            }
            this.hyj.dismiss();
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501017, Boolean.valueOf(ejy())));
            }
        }
    }

    private boolean ejy() {
        if (this.oXe == null || ListUtils.isEmpty(this.oXe.getGroupList())) {
            return false;
        }
        for (com.baidu.yuyinala.more.b.b bVar : this.oXe.getGroupList()) {
            if (bVar != null && !ListUtils.isEmpty(bVar.ejG())) {
                for (com.baidu.yuyinala.more.b.a aVar : bVar.ejG()) {
                    if (aVar != null && aVar.ejF()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejz() {
        AlaWheatMoreFunctionData alaWheatMoreFunctionData = new AlaWheatMoreFunctionData();
        alaWheatMoreFunctionData.mLiveId = this.oXe.getLiveId();
        alaWheatMoreFunctionData.mCustomRoomId = this.oXe.getCustomRoomId();
        alaWheatMoreFunctionData.mRoomId = this.oXe.getRoomId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501076, alaWheatMoreFunctionData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejA() {
        if (!com.baidu.live.ao.a.Yj().Yk()) {
            new d(getTbPageContext().getPageActivity(), this.oXm).show();
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
                c.this.oXm.ejH();
                c.this.oXm.ejI();
                cVar.dismiss();
                c.this.Yi("roomclose_cfm");
            }

            @Override // com.baidu.live.view.c.a
            public void Qb() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    private void ejB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oXe != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oXe.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "voiceframe_show").setContentExt(jSONObject));
    }

    private void hf(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oXe != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oXe.getCustomRoomId());
            }
            if (str == "first_recharge" || str == "super_recharge" || str == "transfer") {
                jSONObject.put("cloudctl_id", str2);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, Yh(str)).setContentExt(jSONObject));
    }

    private String Yh(String str) {
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
    public void Yi(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oXe != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oXe.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, str).setContentExt(jSONObject));
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0965a
    public void Am(boolean z) {
        this.mTbPageContext.showToast(z ? a.h.ala_audio_clear_charm_succ : a.h.ala_audio_clear_charm_fail);
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0965a
    public void ejC() {
        this.mTbPageContext.showToast(a.h.ala_audio_close_room_fail);
    }
}
