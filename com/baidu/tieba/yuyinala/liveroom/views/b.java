package com.baidu.tieba.yuyinala.liveroom.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlbumActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.l;
import com.baidu.live.view.CubicRoundRectRelativeLayout;
import com.baidu.tieba.yuyinala.liveroom.views.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends a {
    private View.OnClickListener hwV;
    private ImageView hwp;
    private TbImageView hwv;
    private TextView hww;
    private d.a oaC;
    private CubicRoundRectRelativeLayout oaD;
    private LinearLayout oaE;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hwV = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.ala_live_prepare_start) {
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (b.this.oau != null) {
                                b.this.oau.cff();
                            }
                        } else {
                            b.this.chE();
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_CREATE_ROOM, "createroom_clk").setContentExt(jSONObject));
                    }
                } else if (view.getId() == a.f.ala_prepare_cover_frame_layout) {
                    b.this.cif();
                } else if (view.getId() == a.f.ala_prepare_close && b.this.oau != null) {
                    b.this.oau.onCloseClicked();
                }
            }
        };
        initViews();
    }

    private void initViews() {
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.g.yuyin_ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                b.this.chH();
                return false;
            }
        });
        chz();
        this.huj.setOnClickListener(this.hwV);
        this.oaD = (CubicRoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hwv = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hww = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hwv.setIsRound(false);
        this.hwv.setGifIconSupport(false);
        this.hww.setText(a.h.yuyin_ala_live_add_cover);
        this.hwv.setDefaultResource(a.e.icon_live_yuyin_createroom_default_bg);
        this.hwv.setDefaultBgResource(a.c.sdk_transparent);
        this.huj.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hwp = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hwp.setOnClickListener(this.hwV);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hwp.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hwp.setLayoutParams(layoutParams);
        }
        this.oaE = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_bottom_view_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oaD.getLayoutParams();
        layoutParams2.topMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.145d);
        this.oaD.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.oaE.getLayoutParams();
        layoutParams3.bottomMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.125d);
        this.oaE.setLayoutParams(layoutParams3);
        GB();
    }

    private void GB() {
        this.oaD.setOnClickListener(this.hwV);
    }

    public void cbp() {
        chE();
    }

    public boolean cbj() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cif() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HX(String str) {
        this.hwA = str;
        this.hww.setText(a.h.yuyin_ala_live_change_cover);
        this.hww.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.hww.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_black_alpha40));
        l.a(this.hwv, str, true, false);
    }

    public String cbm() {
        return this.hwA;
    }

    public void a(d.a aVar) {
        this.oaC = aVar;
    }
}
