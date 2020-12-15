package com.baidu.yuyinala.more;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
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
/* loaded from: classes4.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaMoreFunctionDialogData> implements a.b, a.InterfaceC0961a {
    private View elk;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hmw;
    private AlaMoreFunctionDialogData oKM;
    private TextView oKO;
    private TextView oKP;
    private HListView oKQ;
    private HListView oKR;
    private com.baidu.yuyinala.more.a.a oKS;
    private com.baidu.yuyinala.more.a.a oKT;
    private com.baidu.yuyinala.more.c.a oKU;
    private com.baidu.live.e.c oKV;

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
        this.oKM = alaMoreFunctionDialogData;
        if (this.oKM != null) {
            this.oKU.O(this.oKM.getLiveId(), this.oKM.getRoomId(), this.oKM.getCustomRoomId(), this.oKM.getGroupId());
            gE(new ArrayList(this.oKM.getGroupList()));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.oKO = (TextView) getViewGroup().findViewById(a.f.func_group_title1_tv);
        this.oKP = (TextView) getViewGroup().findViewById(a.f.func_group_title2_tv);
        this.oKQ = (HListView) getViewGroup().findViewById(a.f.function_hlv1);
        this.oKR = (HListView) getViewGroup().findViewById(a.f.function_hlv2);
        this.elk = getViewGroup().findViewById(a.f.group_divider_view);
        this.oKS = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oKT = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oKU = new com.baidu.yuyinala.more.c.a(this);
        this.oKQ.setAdapter((ListAdapter) this.oKS);
        this.oKR.setAdapter((ListAdapter) this.oKT);
        this.oKS.a(this);
        this.oKT.a(this);
        int dimension = (int) this.mTbPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds138);
        ViewGroup.LayoutParams layoutParams = this.oKQ.getLayoutParams();
        layoutParams.height = dimension;
        this.oKQ.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oKQ.getLayoutParams();
        layoutParams2.height = dimension;
        this.oKR.setLayoutParams(layoutParams2);
    }

    public void b(com.baidu.live.e.c cVar) {
        this.oKV = cVar;
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hmw = cVar;
    }

    private void gE(List<com.baidu.yuyinala.more.b.b> list) {
        int count = ListUtils.getCount(list);
        com.baidu.yuyinala.more.b.b bVar = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 2);
        if (bVar != null) {
            this.oKO.setText(bVar.getTitle());
            this.oKS.gF(bVar.ekO());
            this.oKO.setVisibility(0);
            this.oKQ.setVisibility(0);
            this.elk.setVisibility(0);
        } else {
            this.oKO.setVisibility(8);
            this.oKQ.setVisibility(8);
            this.elk.setVisibility(8);
        }
        com.baidu.yuyinala.more.b.b bVar2 = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 1);
        if (bVar2 != null) {
            this.oKP.setText(bVar2.getTitle());
            this.oKT.gF(bVar2.ekO());
            this.oKP.setVisibility(0);
            this.oKR.setVisibility(0);
            return;
        }
        this.oKP.setVisibility(8);
        this.oKR.setVisibility(8);
    }

    @Override // com.baidu.yuyinala.more.a.a.b
    public void a(com.baidu.yuyinala.more.b.a aVar, boolean z) {
        if (aVar != null) {
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
                    if (this.oKV != null) {
                        this.oKV.DG();
                        break;
                    }
                    break;
                case 1:
                    if (this.oKV != null) {
                        this.oKV.DH();
                        break;
                    }
                    break;
                case 2:
                    if (this.oKV != null) {
                        this.oKV.DI();
                        break;
                    }
                    break;
                case 3:
                    if (this.oKV != null) {
                        this.oKV.DK();
                        break;
                    }
                    break;
                case 4:
                    ekJ();
                    break;
                case 5:
                    ekK();
                    break;
                case 6:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501002));
                    break;
                case 7:
                    if (this.oKV != null) {
                        this.oKV.DJ();
                        break;
                    }
                    break;
                case '\b':
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501003));
                    break;
                case '\t':
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501004));
                    break;
                case '\n':
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501005));
                    break;
            }
            gZ(aVar.getAction(), aVar.getId());
            this.hmw.dismiss();
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501017, Boolean.valueOf(ekI())));
            }
        }
    }

    private boolean ekI() {
        if (this.oKM == null || ListUtils.isEmpty(this.oKM.getGroupList())) {
            return false;
        }
        for (com.baidu.yuyinala.more.b.b bVar : this.oKM.getGroupList()) {
            if (bVar != null && !ListUtils.isEmpty(bVar.ekO())) {
                for (com.baidu.yuyinala.more.b.a aVar : bVar.ekO()) {
                    if (aVar != null && aVar.ekN()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    private void ekJ() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(getTbPageContext().getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dw(false);
        cVar.o(getTbPageContext().getString(a.h.clear_charm_title), getTbPageContext().getString(a.h.clear_charm_content), getTbPageContext().getString(a.h.sdk_alert_yes_button), getTbPageContext().getString(a.h.sdk_live_cancel));
        cVar.gN(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.gO(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dy(false);
        cVar.dz(false);
        cVar.A(getTbPageContext().getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize34));
        cVar.gM(getTbPageContext().getResources().getColor(a.c.sdk_common_color_10215));
        cVar.B(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize28));
        cVar.a(new c.a() { // from class: com.baidu.yuyinala.more.c.1
            @Override // com.baidu.live.view.c.a
            public void Rt() {
                c.this.oKU.ekP();
                cVar.dismiss();
                c.this.Yv("xdremove_cfm");
            }

            @Override // com.baidu.live.view.c.a
            public void Ru() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    private void ekK() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(getTbPageContext().getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dw(false);
        cVar.o(getTbPageContext().getString(a.h.ala_audio_close_room_title), "", getTbPageContext().getString(a.h.sdk_alert_yes_button), getTbPageContext().getString(a.h.sdk_live_cancel));
        cVar.gN(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.gO(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dy(false);
        cVar.dz(false);
        cVar.A(getTbPageContext().getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize34));
        cVar.dx(false);
        cVar.a(new c.a() { // from class: com.baidu.yuyinala.more.c.2
            @Override // com.baidu.live.view.c.a
            public void Rt() {
                c.this.oKU.ekQ();
                c.this.oKU.ekR();
                cVar.dismiss();
                c.this.Yv("roomclose_cfm");
            }

            @Override // com.baidu.live.view.c.a
            public void Ru() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    private void gZ(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oKM != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oKM.getCustomRoomId());
            }
            if (str == "first_recharge" || str == "super_recharge" || str == "transfer") {
                jSONObject.put("cloudctl_id", str2);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, Yu(str)).setContentExt(jSONObject));
    }

    private String Yu(String str) {
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
    public void Yv(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oKM != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oKM.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, str).setContentExt(jSONObject));
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0961a
    public void As(boolean z) {
        this.mTbPageContext.showToast(z ? a.h.ala_audio_clear_charm_succ : a.h.ala_audio_clear_charm_fail);
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0961a
    public void ekL() {
        this.mTbPageContext.showToast(a.h.ala_audio_close_room_fail);
    }
}
