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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.CubicRoundRectRelativeLayout;
import com.baidu.tieba.yuyinala.liveroom.views.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends a {
    private View.OnClickListener hTW;
    private ImageView hTn;
    private TbImageView hTt;
    private TextView hTu;
    private d.a oEY;
    private CubicRoundRectRelativeLayout oEZ;
    private LinearLayout oFa;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hTW = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.ala_live_prepare_start) {
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (b.this.oEN != null) {
                                b.this.oEN.ciw();
                            }
                        } else {
                            b.this.cld();
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
                    b.this.clF();
                } else if (view.getId() == a.f.ala_prepare_close && b.this.oEN != null) {
                    b.this.oEN.onCloseClicked();
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
                b.this.clg();
                return false;
            }
        });
        ckY();
        this.hRg.setOnClickListener(this.hTW);
        this.oEZ = (CubicRoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hTt = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hTu = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hTt.setIsRound(false);
        this.hTt.setGifIconSupport(false);
        this.hTu.setText(a.h.yuyin_ala_live_add_cover);
        this.hTt.setDefaultResource(a.e.icon_live_yuyin_createroom_default_bg);
        this.hTt.setDefaultBgResource(a.c.sdk_transparent);
        this.hRg.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hTn = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hTn.setOnClickListener(this.hTW);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hTn.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hTn.setLayoutParams(layoutParams);
        }
        this.oFa = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_bottom_view_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oEZ.getLayoutParams();
        layoutParams2.topMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.145d);
        this.oEZ.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.oFa.getLayoutParams();
        layoutParams3.bottomMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.125d);
        this.oFa.setLayoutParams(layoutParams3);
        EG();
    }

    private void EG() {
        this.oEZ.setOnClickListener(this.hTW);
    }

    public void ceL() {
        cld();
    }

    public boolean ceF() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clF() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HR(String str) {
        this.hTy = str;
        this.hTu.setText(a.h.yuyin_ala_live_change_cover);
        this.hTu.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.hTu.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_black_alpha40));
        m.a(this.hTt, str, true, false);
    }

    public String ceI() {
        return this.hTy;
    }

    public void a(d.a aVar) {
        this.oEY = aVar;
    }
}
