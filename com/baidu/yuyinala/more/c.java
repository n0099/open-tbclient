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
/* loaded from: classes10.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaMoreFunctionDialogData> implements a.b, a.InterfaceC0971a {
    private View etk;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hzS;
    private AlaMoreFunctionDialogData oZj;
    private TextView oZl;
    private TextView oZm;
    private HListView oZn;
    private HListView oZo;
    private com.baidu.yuyinala.more.a.a oZp;
    private com.baidu.yuyinala.more.a.a oZq;
    private com.baidu.yuyinala.more.c.a oZr;
    private com.baidu.live.audiolive.a oZs;
    private e oZt;

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
        this.oZj = alaMoreFunctionDialogData;
        if (this.oZj != null) {
            this.oZr.L(this.oZj.getLiveId(), this.oZj.getRoomId(), this.oZj.getCustomRoomId(), this.oZj.getGroupId());
            gu(new ArrayList(this.oZj.getGroupList()));
            if (this.oZj.findFunctionByAction("phone_frame_h5") != null) {
                this.oZs.request();
                ejL();
            }
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oZl = (TextView) getViewGroup().findViewById(a.f.func_group_title1_tv);
        this.oZm = (TextView) getViewGroup().findViewById(a.f.func_group_title2_tv);
        this.oZn = (HListView) getViewGroup().findViewById(a.f.function_hlv1);
        this.oZo = (HListView) getViewGroup().findViewById(a.f.function_hlv2);
        this.etk = getViewGroup().findViewById(a.f.group_divider_view);
        this.oZp = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oZq = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oZr = new com.baidu.yuyinala.more.c.a(this);
        this.oZs = new com.baidu.live.audiolive.a(null, new a.InterfaceC0170a() { // from class: com.baidu.yuyinala.more.c.1
            @Override // com.baidu.live.audiolive.a.InterfaceC0170a
            public void a(NewFrameHttpResponseMessage newFrameHttpResponseMessage) {
                com.baidu.yuyinala.more.b.a findFunctionByAction;
                if (newFrameHttpResponseMessage != null && newFrameHttpResponseMessage.zL() >= 0 && (findFunctionByAction = c.this.oZj.findFunctionByAction("phone_frame_h5")) != null) {
                    if (newFrameHttpResponseMessage.zL() > 0) {
                        findFunctionByAction.Yq(newFrameHttpResponseMessage.zL() + "");
                        findFunctionByAction.AH(true);
                    } else {
                        findFunctionByAction.AH(false);
                    }
                    c.this.gu(c.this.oZj.getGroupList());
                }
            }

            @Override // com.baidu.live.audiolive.a.InterfaceC0170a
            public void onFail(int i, String str) {
            }
        });
        this.oZn.setAdapter((ListAdapter) this.oZp);
        this.oZo.setAdapter((ListAdapter) this.oZq);
        this.oZp.a(this);
        this.oZq.a(this);
        int dimension = (int) this.mTbPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds138);
        ViewGroup.LayoutParams layoutParams = this.oZn.getLayoutParams();
        layoutParams.height = dimension;
        this.oZn.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oZn.getLayoutParams();
        layoutParams2.height = dimension;
        this.oZo.setLayoutParams(layoutParams2);
    }

    public void b(e eVar) {
        this.oZt = eVar;
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hzS = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gu(List<com.baidu.yuyinala.more.b.b> list) {
        int count = ListUtils.getCount(list);
        com.baidu.yuyinala.more.b.b bVar = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 2);
        if (bVar != null) {
            this.oZl.setText(bVar.getTitle());
            this.oZp.gv(bVar.ejQ());
            this.oZl.setVisibility(0);
            this.oZn.setVisibility(0);
            this.etk.setVisibility(0);
        } else {
            this.oZl.setVisibility(8);
            this.oZn.setVisibility(8);
            this.etk.setVisibility(8);
        }
        com.baidu.yuyinala.more.b.b bVar2 = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 1);
        if (bVar2 != null) {
            this.oZm.setText(bVar2.getTitle());
            this.oZq.gv(bVar2.ejQ());
            this.oZm.setVisibility(0);
            this.oZo.setVisibility(0);
            return;
        }
        this.oZm.setVisibility(8);
        this.oZo.setVisibility(8);
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
                            if (c.this.oZt != null) {
                                c.this.oZt.zN();
                            }
                        }
                    };
                    break;
                case 1:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oZt != null) {
                                c.this.oZt.zO();
                            }
                        }
                    };
                    break;
                case 2:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oZt != null) {
                                c.this.oZt.zP();
                            }
                        }
                    };
                    break;
                case 3:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.10
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.oZt != null) {
                                c.this.oZt.zR();
                            }
                        }
                    };
                    break;
                case 4:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.11
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ejJ();
                        }
                    };
                    break;
                case 5:
                    runnable = new Runnable() { // from class: com.baidu.yuyinala.more.c.12
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.ejK();
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
                            if (c.this.oZt != null) {
                                c.this.oZt.zQ();
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
                            if (c.this.oZt != null) {
                                c.this.oZt.fr(aVar.BV());
                            }
                        }
                    };
                    break;
            }
            hf(aVar.getAction(), aVar.getId());
            if (runnable != null) {
                SafeHandler.getInst().postDelayed(runnable, 300L);
            }
            this.hzS.dismiss();
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501017, Boolean.valueOf(ejI())));
            }
        }
    }

    private boolean ejI() {
        if (this.oZj == null || ListUtils.isEmpty(this.oZj.getGroupList())) {
            return false;
        }
        for (com.baidu.yuyinala.more.b.b bVar : this.oZj.getGroupList()) {
            if (bVar != null && !ListUtils.isEmpty(bVar.ejQ())) {
                for (com.baidu.yuyinala.more.b.a aVar : bVar.ejQ()) {
                    if (aVar != null && aVar.ejP()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejJ() {
        AlaWheatMoreFunctionData alaWheatMoreFunctionData = new AlaWheatMoreFunctionData();
        alaWheatMoreFunctionData.mLiveId = this.oZj.getLiveId();
        alaWheatMoreFunctionData.mCustomRoomId = this.oZj.getCustomRoomId();
        alaWheatMoreFunctionData.mRoomId = this.oZj.getRoomId();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501076, alaWheatMoreFunctionData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejK() {
        if (!com.baidu.live.ao.a.Ym().Yn()) {
            new d(getTbPageContext().getPageActivity(), this.oZr).show();
            return;
        }
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(getTbPageContext().getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dD(false);
        cVar.o(getTbPageContext().getString(a.h.ala_audio_close_room_title), "", getTbPageContext().getString(a.h.sdk_alert_yes_button), getTbPageContext().getString(a.h.sdk_live_cancel));
        cVar.fm(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.fn(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dF(false);
        cVar.dG(false);
        cVar.E(getTbPageContext().getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize34));
        cVar.dE(false);
        cVar.a(new c.a() { // from class: com.baidu.yuyinala.more.c.6
            @Override // com.baidu.live.view.c.a
            public void Qd() {
                c.this.oZr.ejR();
                c.this.oZr.ejS();
                cVar.dismiss();
                c.this.Yp("roomclose_cfm");
            }

            @Override // com.baidu.live.view.c.a
            public void Qe() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    private void ejL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oZj != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oZj.getCustomRoomId());
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
            if (this.oZj != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oZj.getCustomRoomId());
            }
            if (str == "first_recharge" || str == "super_recharge" || str == "transfer") {
                jSONObject.put("cloudctl_id", str2);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, Yo(str)).setContentExt(jSONObject));
    }

    private String Yo(String str) {
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
    public void Yp(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oZj != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oZj.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, str).setContentExt(jSONObject));
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0971a
    public void Al(boolean z) {
        this.mTbPageContext.showToast(z ? a.h.ala_audio_clear_charm_succ : a.h.ala_audio_clear_charm_fail);
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0971a
    public void ejM() {
        this.mTbPageContext.showToast(a.h.ala_audio_close_room_fail);
    }
}
