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
/* loaded from: classes11.dex */
public class b extends a {
    private ImageView hRE;
    private TbImageView hRK;
    private TextView hRL;
    private View.OnClickListener hSn;
    private d.a oCT;
    private CubicRoundRectRelativeLayout oCU;
    private LinearLayout oCV;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hSn = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.ala_live_prepare_start) {
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (b.this.oCI != null) {
                                b.this.oCI.ciq();
                            }
                        } else {
                            b.this.ckX();
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
                    b.this.clz();
                } else if (view.getId() == a.f.ala_prepare_close && b.this.oCI != null) {
                    b.this.oCI.onCloseClicked();
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
                b.this.cla();
                return false;
            }
        });
        ckS();
        this.hPx.setOnClickListener(this.hSn);
        this.oCU = (CubicRoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hRK = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hRL = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hRK.setIsRound(false);
        this.hRK.setGifIconSupport(false);
        this.hRL.setText(a.h.yuyin_ala_live_add_cover);
        this.hRK.setDefaultResource(a.e.icon_live_yuyin_createroom_default_bg);
        this.hRK.setDefaultBgResource(a.c.sdk_transparent);
        this.hPx.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hRE = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hRE.setOnClickListener(this.hSn);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hRE.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hRE.setLayoutParams(layoutParams);
        }
        this.oCV = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_bottom_view_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oCU.getLayoutParams();
        layoutParams2.topMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.145d);
        this.oCU.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.oCV.getLayoutParams();
        layoutParams3.bottomMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.125d);
        this.oCV.setLayoutParams(layoutParams3);
        ED();
    }

    private void ED() {
        this.oCU.setOnClickListener(this.hSn);
    }

    public void ceF() {
        ckX();
    }

    public boolean cez() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clz() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HI(String str) {
        this.hRP = str;
        this.hRL.setText(a.h.yuyin_ala_live_change_cover);
        this.hRL.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.hRL.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_black_alpha40));
        m.a(this.hRK, str, true, false);
    }

    public String ceC() {
        return this.hRP;
    }

    public void a(d.a aVar) {
        this.oCT = aVar;
    }
}
