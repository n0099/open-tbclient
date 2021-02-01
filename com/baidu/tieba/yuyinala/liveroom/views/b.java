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
    private View.OnClickListener hRZ;
    private ImageView hRq;
    private TbImageView hRw;
    private TextView hRx;
    private d.a oCt;
    private CubicRoundRectRelativeLayout oCu;
    private LinearLayout oCv;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hRZ = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.ala_live_prepare_start) {
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (b.this.oCi != null) {
                                b.this.oCi.cij();
                            }
                        } else {
                            b.this.ckQ();
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
                    b.this.cls();
                } else if (view.getId() == a.f.ala_prepare_close && b.this.oCi != null) {
                    b.this.oCi.onCloseClicked();
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
                b.this.ckT();
                return false;
            }
        });
        ckL();
        this.hPj.setOnClickListener(this.hRZ);
        this.oCu = (CubicRoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hRw = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hRx = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hRw.setIsRound(false);
        this.hRw.setGifIconSupport(false);
        this.hRx.setText(a.h.yuyin_ala_live_add_cover);
        this.hRw.setDefaultResource(a.e.icon_live_yuyin_createroom_default_bg);
        this.hRw.setDefaultBgResource(a.c.sdk_transparent);
        this.hPj.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hRq = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hRq.setOnClickListener(this.hRZ);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hRq.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hRq.setLayoutParams(layoutParams);
        }
        this.oCv = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_bottom_view_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oCu.getLayoutParams();
        layoutParams2.topMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.145d);
        this.oCu.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.oCv.getLayoutParams();
        layoutParams3.bottomMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.125d);
        this.oCv.setLayoutParams(layoutParams3);
        ED();
    }

    private void ED() {
        this.oCu.setOnClickListener(this.hRZ);
    }

    public void cey() {
        ckQ();
    }

    public boolean ces() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cls() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HH(String str) {
        this.hRB = str;
        this.hRx.setText(a.h.yuyin_ala_live_change_cover);
        this.hRx.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.hRx.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_black_alpha40));
        m.a(this.hRw, str, true, false);
    }

    public String cev() {
        return this.hRB;
    }

    public void a(d.a aVar) {
        this.oCt = aVar;
    }
}
