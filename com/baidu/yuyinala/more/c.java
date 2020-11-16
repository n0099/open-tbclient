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
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaMoreFunctionDialogData> implements a.b, a.InterfaceC0944a {
    private View eej;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hcM;
    private AlaMoreFunctionDialogData ovE;
    private TextView ovG;
    private TextView ovH;
    private HListView ovI;
    private HListView ovJ;
    private com.baidu.yuyinala.more.a.a ovK;
    private com.baidu.yuyinala.more.a.a ovL;
    private com.baidu.yuyinala.more.c.a ovM;
    private com.baidu.live.c.c ovN;

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
        this.ovE = alaMoreFunctionDialogData;
        if (this.ovE != null) {
            this.ovM.O(this.ovE.getLiveId(), this.ovE.getRoomId(), this.ovE.getCustomRoomId(), this.ovE.getGroupId());
            gp(new ArrayList(this.ovE.getGroupList()));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.ovG = (TextView) getViewGroup().findViewById(a.f.func_group_title1_tv);
        this.ovH = (TextView) getViewGroup().findViewById(a.f.func_group_title2_tv);
        this.ovI = (HListView) getViewGroup().findViewById(a.f.function_hlv1);
        this.ovJ = (HListView) getViewGroup().findViewById(a.f.function_hlv2);
        this.eej = getViewGroup().findViewById(a.f.group_divider_view);
        this.ovK = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.ovL = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.ovM = new com.baidu.yuyinala.more.c.a(this);
        this.ovI.setAdapter((ListAdapter) this.ovK);
        this.ovJ.setAdapter((ListAdapter) this.ovL);
        this.ovK.a(this);
        this.ovL.a(this);
        int dimension = (int) this.mTbPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds138);
        ViewGroup.LayoutParams layoutParams = this.ovI.getLayoutParams();
        layoutParams.height = dimension;
        this.ovI.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.ovI.getLayoutParams();
        layoutParams2.height = dimension;
        this.ovJ.setLayoutParams(layoutParams2);
    }

    public void b(com.baidu.live.c.c cVar) {
        this.ovN = cVar;
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hcM = cVar;
    }

    private void gp(List<com.baidu.yuyinala.more.b.b> list) {
        int count = ListUtils.getCount(list);
        com.baidu.yuyinala.more.b.b bVar = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 2);
        if (bVar != null) {
            this.ovG.setText(bVar.getTitle());
            this.ovK.gq(bVar.efa());
            this.ovG.setVisibility(0);
            this.ovI.setVisibility(0);
            this.eej.setVisibility(0);
        } else {
            this.ovG.setVisibility(8);
            this.ovI.setVisibility(8);
            this.eej.setVisibility(8);
        }
        com.baidu.yuyinala.more.b.b bVar2 = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 1);
        if (bVar2 != null) {
            this.ovH.setText(bVar2.getTitle());
            this.ovL.gq(bVar2.efa());
            this.ovH.setVisibility(0);
            this.ovJ.setVisibility(0);
            return;
        }
        this.ovH.setVisibility(8);
        this.ovJ.setVisibility(8);
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
                    if (this.ovN != null) {
                        this.ovN.BW();
                        break;
                    }
                    break;
                case 1:
                    if (this.ovN != null) {
                        this.ovN.BX();
                        break;
                    }
                    break;
                case 2:
                    if (this.ovN != null) {
                        this.ovN.BY();
                        break;
                    }
                    break;
                case 3:
                    if (this.ovN != null) {
                        this.ovN.Ca();
                        break;
                    }
                    break;
                case 4:
                    eeV();
                    break;
                case 5:
                    eeW();
                    break;
                case 6:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501002));
                    break;
                case 7:
                    if (this.ovN != null) {
                        this.ovN.BZ();
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
            gR(aVar.getAction(), aVar.getId());
            this.hcM.dismiss();
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501017, Boolean.valueOf(eeU())));
            }
        }
    }

    private boolean eeU() {
        if (this.ovE == null || ListUtils.isEmpty(this.ovE.getGroupList())) {
            return false;
        }
        for (com.baidu.yuyinala.more.b.b bVar : this.ovE.getGroupList()) {
            if (bVar != null && !ListUtils.isEmpty(bVar.efa())) {
                for (com.baidu.yuyinala.more.b.a aVar : bVar.efa()) {
                    if (aVar != null && aVar.eeZ()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    private void eeV() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(getTbPageContext().getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.di(false);
        cVar.o(getTbPageContext().getString(a.h.clear_charm_title), getTbPageContext().getString(a.h.clear_charm_content), getTbPageContext().getString(a.h.sdk_alert_yes_button), getTbPageContext().getString(a.h.sdk_live_cancel));
        cVar.gp(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.gq(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dk(false);
        cVar.dl(false);
        cVar.B(getTbPageContext().getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize34));
        cVar.gn(getTbPageContext().getResources().getColor(a.c.sdk_common_color_10215));
        cVar.C(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize28));
        cVar.a(new c.a() { // from class: com.baidu.yuyinala.more.c.1
            @Override // com.baidu.live.view.c.a
            public void OZ() {
                c.this.ovM.efb();
                cVar.dismiss();
                c.this.Xa("xdremove_cfm");
            }

            @Override // com.baidu.live.view.c.a
            public void Pa() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    private void eeW() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(getTbPageContext().getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.di(false);
        cVar.o(getTbPageContext().getString(a.h.ala_audio_close_room_title), "", getTbPageContext().getString(a.h.sdk_alert_yes_button), getTbPageContext().getString(a.h.sdk_live_cancel));
        cVar.gp(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.gq(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dk(false);
        cVar.dl(false);
        cVar.B(getTbPageContext().getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize34));
        cVar.dj(false);
        cVar.a(new c.a() { // from class: com.baidu.yuyinala.more.c.2
            @Override // com.baidu.live.view.c.a
            public void OZ() {
                c.this.ovM.efc();
                c.this.ovM.efd();
                cVar.dismiss();
                c.this.Xa("roomclose_cfm");
            }

            @Override // com.baidu.live.view.c.a
            public void Pa() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    private void gR(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.ovE != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ovE.getCustomRoomId());
            }
            if (str == "first_recharge" || str == "super_recharge" || str == "transfer") {
                jSONObject.put("cloudctl_id", str2);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, WZ(str)).setContentExt(jSONObject));
    }

    private String WZ(String str) {
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
    public void Xa(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.ovE != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ovE.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, str).setContentExt(jSONObject));
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0944a
    public void zO(boolean z) {
        this.mTbPageContext.showToast(z ? a.h.ala_audio_clear_charm_succ : a.h.ala_audio_clear_charm_fail);
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0944a
    public void eeX() {
        this.mTbPageContext.showToast(a.h.ala_audio_close_room_fail);
    }
}
