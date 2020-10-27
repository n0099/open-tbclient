package com.baidu.yuyinala.more;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.view.d;
import com.baidu.tbadk.TbConfig;
import com.baidu.yuyinala.more.a.a;
import com.baidu.yuyinala.more.c.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.baidu.live.tieba.pb.interactionpopupwindow.b<AlaMoreFunctionDialogData> implements a.b, a.InterfaceC0923a {
    private View dZZ;
    private com.baidu.live.tieba.pb.interactionpopupwindow.c gXb;
    private AlaMoreFunctionDialogData okD;
    private TextView okF;
    private TextView okG;
    private BdGridView okH;
    private BdGridView okI;
    private com.baidu.yuyinala.more.a.a okJ;
    private com.baidu.yuyinala.more.a.a okK;
    private com.baidu.yuyinala.more.c.a okL;
    private com.baidu.live.c.c okM;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public int getLayout() {
        return a.h.activity_ala_audio_more_feature;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void a(AlaMoreFunctionDialogData alaMoreFunctionDialogData) {
        this.okD = alaMoreFunctionDialogData;
        if (this.okD != null) {
            this.okL.O(this.okD.getLiveId(), this.okD.getRoomId(), this.okD.getCustomRoomId(), this.okD.getGroupId());
            gg(new ArrayList(this.okD.getGroupList()));
        }
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.d
    public void initView() {
        this.okF = (TextView) getViewGroup().findViewById(a.g.func_group_title1_tv);
        this.okG = (TextView) getViewGroup().findViewById(a.g.func_group_title2_tv);
        this.okH = (BdGridView) getViewGroup().findViewById(a.g.function_gv1);
        this.okI = (BdGridView) getViewGroup().findViewById(a.g.function_gv2);
        this.dZZ = getViewGroup().findViewById(a.g.group_divider_view);
        this.okJ = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.okK = new com.baidu.yuyinala.more.a.a(getTbPageContext());
        this.okL = new com.baidu.yuyinala.more.c.a(this);
        this.okH.setAdapter((ListAdapter) this.okJ);
        this.okI.setAdapter((ListAdapter) this.okK);
        this.okJ.a(this);
        this.okK.a(this);
    }

    public void b(com.baidu.live.c.c cVar) {
        this.okM = cVar;
    }

    public void a(com.baidu.live.tieba.pb.interactionpopupwindow.c cVar) {
        this.gXb = cVar;
    }

    private void gg(List<com.baidu.yuyinala.more.b.b> list) {
        int count = ListUtils.getCount(list);
        com.baidu.yuyinala.more.b.b bVar = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 2);
        if (bVar != null) {
            this.okF.setText(bVar.getTitle());
            this.okJ.gh(bVar.ebn());
            this.okF.setVisibility(0);
            this.okH.setVisibility(0);
            this.dZZ.setVisibility(0);
        } else {
            this.okF.setVisibility(8);
            this.okH.setVisibility(8);
            this.dZZ.setVisibility(8);
        }
        com.baidu.yuyinala.more.b.b bVar2 = (com.baidu.yuyinala.more.b.b) ListUtils.getItem(list, count - 1);
        if (bVar2 != null) {
            this.okG.setText(bVar2.getTitle());
            this.okK.gh(bVar2.ebn());
            this.okG.setVisibility(0);
            this.okI.setVisibility(0);
            return;
        }
        this.okG.setVisibility(8);
        this.okI.setVisibility(8);
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
                        c = 4;
                        break;
                    }
                    break;
                case -1890252483:
                    if (action.equals("sticker")) {
                        c = 6;
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
                        c = 7;
                        break;
                    }
                    break;
                case -1257946267:
                    if (action.equals("clear_charm")) {
                        c = 3;
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
                        c = 5;
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
                        c = '\b';
                        break;
                    }
                    break;
                case 1280882667:
                    if (action.equals("transfer")) {
                        c = '\t';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (this.okM != null) {
                        this.okM.Cn();
                        break;
                    }
                    break;
                case 1:
                    if (this.okM != null) {
                        this.okM.Co();
                        break;
                    }
                    break;
                case 2:
                    if (this.okM != null) {
                        this.okM.Cp();
                        break;
                    }
                    break;
                case 3:
                    ebi();
                    break;
                case 4:
                    ebj();
                    break;
                case 5:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501002));
                    break;
                case 6:
                    if (this.okM != null) {
                        this.okM.Cq();
                        break;
                    }
                    break;
                case 7:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501003));
                    break;
                case '\b':
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501004));
                    break;
                case '\t':
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501005));
                    break;
            }
            gP(aVar.getAction(), aVar.getId());
            this.gXb.dismiss();
            if (z) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501017, Boolean.valueOf(ebh())));
            }
        }
    }

    private boolean ebh() {
        if (this.okD == null || ListUtils.isEmpty(this.okD.getGroupList())) {
            return false;
        }
        for (com.baidu.yuyinala.more.b.b bVar : this.okD.getGroupList()) {
            if (bVar != null && !ListUtils.isEmpty(bVar.ebn())) {
                for (com.baidu.yuyinala.more.b.a aVar : bVar.ebn()) {
                    if (aVar != null && aVar.ebm()) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    private void ebi() {
        final d dVar = new d(getTbPageContext().getPageActivity());
        dVar.setCancelable(false);
        dVar.setCanceledOnTouchOutside(false);
        dVar.cZ(false);
        dVar.o(getTbPageContext().getString(a.i.clear_charm_title), getTbPageContext().getString(a.i.clear_charm_content), getTbPageContext().getString(a.i.sdk_alert_yes_button), getTbPageContext().getString(a.i.sdk_live_cancel));
        dVar.gi(getTbPageContext().getResources().getColor(a.d.sdk_black_alpha100));
        dVar.gj(getTbPageContext().getResources().getColor(a.d.sdk_black_alpha100));
        dVar.db(false);
        dVar.dc(false);
        dVar.B(getTbPageContext().getResources().getDimension(a.e.sdk_ds12));
        dVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.e.sdk_fontsize34));
        dVar.gh(getTbPageContext().getResources().getColor(a.d.sdk_common_color_10215));
        dVar.C(getTbPageContext().getResources().getDimension(a.e.sdk_fontsize28));
        dVar.a(new d.a() { // from class: com.baidu.yuyinala.more.c.1
            @Override // com.baidu.live.view.d.a
            public void Pi() {
                c.this.okL.ebo();
                dVar.dismiss();
                c.this.WL("xdremove_cfm");
            }

            @Override // com.baidu.live.view.d.a
            public void Pj() {
                dVar.dismiss();
            }
        });
        dVar.show();
    }

    private void ebj() {
        final d dVar = new d(getTbPageContext().getPageActivity());
        dVar.setCancelable(false);
        dVar.setCanceledOnTouchOutside(false);
        dVar.cZ(false);
        dVar.o(getTbPageContext().getString(a.i.ala_audio_close_room_title), "", getTbPageContext().getString(a.i.sdk_alert_yes_button), getTbPageContext().getString(a.i.sdk_live_cancel));
        dVar.gi(getTbPageContext().getResources().getColor(a.d.sdk_black_alpha100));
        dVar.gj(getTbPageContext().getResources().getColor(a.d.sdk_black_alpha100));
        dVar.db(false);
        dVar.dc(false);
        dVar.B(getTbPageContext().getResources().getDimension(a.e.sdk_ds12));
        dVar.setTitleTextSize(getTbPageContext().getResources().getDimension(a.e.sdk_fontsize34));
        dVar.da(false);
        dVar.a(new d.a() { // from class: com.baidu.yuyinala.more.c.2
            @Override // com.baidu.live.view.d.a
            public void Pi() {
                c.this.okL.ebp();
                c.this.okL.ebq();
                dVar.dismiss();
                c.this.WL("roomclose_cfm");
            }

            @Override // com.baidu.live.view.d.a
            public void Pj() {
                dVar.dismiss();
            }
        });
        dVar.show();
    }

    private void gP(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.okD != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.okD.getCustomRoomId());
            }
            if (str == "first_recharge" || str == "super_recharge" || str == "transfer") {
                jSONObject.put("cloudctl_id", str2);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, WK(str)).setContentExt(jSONObject));
    }

    private String WK(String str) {
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
    public void WL(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "moretab");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            if (this.okD != null) {
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.okD.getCustomRoomId());
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, str).setContentExt(jSONObject));
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0923a
    public void zw(boolean z) {
        this.mTbPageContext.showToast(z ? a.i.ala_audio_clear_charm_succ : a.i.ala_audio_clear_charm_fail);
    }

    @Override // com.baidu.yuyinala.more.c.a.InterfaceC0923a
    public void ebk() {
        this.mTbPageContext.showToast(a.i.ala_audio_close_room_fail);
    }
}
