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
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaMoreFunctionDialogData> implements a.b, a.InterfaceC0941a {
    private View efQ;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c hdf;
    private AlaMoreFunctionDialogData oua;
    private TextView ouc;
    private TextView oud;
    private HListView oue;
    private HListView ouf;
    private com.baidu.yuyinala.more.a.a oug;
    private com.baidu.yuyinala.more.a.a ouh;
    private com.baidu.yuyinala.more.c.a oui;
    private com.baidu.live.c.c ouj;

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
        this.oua = alaMoreFunctionDialogData;
        if (this.oua != null) {
            this.oui.O(this.oua.getLiveId(), this.oua.getRoomId(), this.oua.getCustomRoomId(), this.oua.getGroupId());
            gp(new ArrayList(this.oua.getGroupList()));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.ouc = (TextView) getViewGroup().findViewById(a.f.func_group_title1_tv);
        this.oud = (TextView) getViewGroup().findViewById(a.f.func_group_title2_tv);
        this.oue = (HListView) getViewGroup().findViewById(a.f.function_hlv1);
        this.ouf = (HListView) getViewGroup().findViewById(a.f.function_hlv2);
        this.efQ = getViewGroup().findViewById(a.f.group_divider_view);
        this.oug = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.ouh = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.oui = new com.baidu.yuyinala.more.c.a(this);
        this.oue.setAdapter((ListAdapter) this.oug);
        this.ouf.setAdapter((ListAdapter) this.ouh);
        this.oug.a(this);
        this.ouh.a(this);
        int dimension = (int) this.mTbPageContext.getPageActivity().getResources().getDimension(a.d.sdk_ds138);
        ViewGroup.LayoutParams layoutParams = this.oue.getLayoutParams();
        layoutParams.height = dimension;
        this.oue.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oue.getLayoutParams();
        layoutParams2.height = dimension;
        this.ouf.setLayoutParams(layoutParams2);
    }

    public void b(com.baidu.live.c.c cVar) {
        this.ouj = cVar;
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.hdf = cVar;
    }

    private void gp(List<com.baidu.yuyinala.more.b.b> list) {
        int count = ListUtils.getCount(list);
        com.baidu.yuyinala.more.b.b bVar = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 2);
        if (bVar != null) {
            this.ouc.setText(bVar.getTitle());
            this.oug.gq(bVar.efc());
            this.ouc.setVisibility(0);
            this.oue.setVisibility(0);
            this.efQ.setVisibility(0);
        } else {
            this.ouc.setVisibility(8);
            this.oue.setVisibility(8);
            this.efQ.setVisibility(8);
        }
        com.baidu.yuyinala.more.b.b bVar2 = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 1);
        if (bVar2 != null) {
            this.oud.setText(bVar2.getTitle());
            this.ouh.gq(bVar2.efc());
            this.oud.setVisibility(0);
            this.ouf.setVisibility(0);
            return;
        }
        this.oud.setVisibility(8);
        this.ouf.setVisibility(8);
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
                    if (this.ouj != null) {
                        this.ouj.CF();
                        break;
                    }
                    break;
                case 1:
                    if (this.ouj != null) {
                        this.ouj.CG();
                        break;
                    }
                    break;
                case 2:
                    if (this.ouj != null) {
                        this.ouj.CH();
                        break;
                    }
                    break;
                case 3:
                    if (this.ouj != null) {
                        this.ouj.CJ();
                        break;
                    }
                    break;
                case 4:
                    eeX();
                    break;
                case 5:
                    eeY();
                    break;
                case 6:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501002));
                    break;
                case 7:
                    if (this.ouj != null) {
                        this.ouj.CI();
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
            this.hdf.dismiss();
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501017, Boolean.valueOf(eeW())));
            }
        }
    }

    private boolean eeW() {
        if (this.oua == null || ListUtils.isEmpty(this.oua.getGroupList())) {
            return false;
        }
        for (com.baidu.yuyinala.more.b.b bVar : this.oua.getGroupList()) {
            if (bVar != null && !ListUtils.isEmpty(bVar.efc())) {
                for (com.baidu.yuyinala.more.b.a aVar : bVar.efc()) {
                    if (aVar != null && aVar.efb()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    private void eeX() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(getTbPageContext().getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dg(false);
        cVar.o(getTbPageContext().getString(a.h.clear_charm_title), getTbPageContext().getString(a.h.clear_charm_content), getTbPageContext().getString(a.h.sdk_alert_yes_button), getTbPageContext().getString(a.h.sdk_live_cancel));
        cVar.gt(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.gu(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.di(false);
        cVar.dj(false);
        cVar.C(getTbPageContext().getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize34));
        cVar.gs(getTbPageContext().getResources().getColor(a.c.sdk_common_color_10215));
        cVar.D(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize28));
        cVar.a(new c.a() { // from class: com.baidu.yuyinala.more.c.1
            @Override // com.baidu.live.view.c.a
            public void PI() {
                c.this.oui.efd();
                cVar.dismiss();
                c.this.Xp("xdremove_cfm");
            }

            @Override // com.baidu.live.view.c.a
            public void PJ() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    private void eeY() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(getTbPageContext().getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dg(false);
        cVar.o(getTbPageContext().getString(a.h.ala_audio_close_room_title), "", getTbPageContext().getString(a.h.sdk_alert_yes_button), getTbPageContext().getString(a.h.sdk_live_cancel));
        cVar.gt(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.gu(getTbPageContext().getResources().getColor(a.c.sdk_black_alpha100));
        cVar.di(false);
        cVar.dj(false);
        cVar.C(getTbPageContext().getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.d.sdk_fontsize34));
        cVar.dh(false);
        cVar.a(new c.a() { // from class: com.baidu.yuyinala.more.c.2
            @Override // com.baidu.live.view.c.a
            public void PI() {
                c.this.oui.efe();
                c.this.oui.eff();
                cVar.dismiss();
                c.this.Xp("roomclose_cfm");
            }

            @Override // com.baidu.live.view.c.a
            public void PJ() {
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
            if (this.oua != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oua.getCustomRoomId());
            }
            if (str == "first_recharge" || str == "super_recharge" || str == "transfer") {
                jSONObject.put("cloudctl_id", str2);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, Xo(str)).setContentExt(jSONObject));
    }

    private String Xo(String str) {
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
    public void Xp(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.oua != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oua.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, str).setContentExt(jSONObject));
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0941a
    public void zH(boolean z) {
        this.mTbPageContext.showToast(z ? a.h.ala_audio_clear_charm_succ : a.h.ala_audio_clear_charm_fail);
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0941a
    public void eeZ() {
        this.mTbPageContext.showToast(a.h.ala_audio_close_room_fail);
    }
}
