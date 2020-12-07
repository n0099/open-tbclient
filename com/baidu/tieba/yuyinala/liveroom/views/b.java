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
    private ImageView hFA;
    private TbImageView hFG;
    private TextView hFH;
    private View.OnClickListener hGh;
    private d.a orh;
    private CubicRoundRectRelativeLayout ori;
    private LinearLayout orj;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hGh = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.ala_live_prepare_start) {
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (b.this.oqY != null) {
                                b.this.oqY.cit();
                            }
                        } else {
                            b.this.ckR();
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
                    b.this.clt();
                } else if (view.getId() == a.f.ala_prepare_close && b.this.oqY != null) {
                    b.this.oqY.onCloseClicked();
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
                b.this.ckU();
                return false;
            }
        });
        ckM();
        this.hDt.setOnClickListener(this.hGh);
        this.ori = (CubicRoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hFG = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hFH = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hFG.setIsRound(false);
        this.hFG.setGifIconSupport(false);
        this.hFH.setText(a.h.yuyin_ala_live_add_cover);
        this.hFG.setDefaultResource(a.e.icon_live_yuyin_createroom_default_bg);
        this.hFG.setDefaultBgResource(a.c.sdk_transparent);
        this.hDt.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hFA = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hFA.setOnClickListener(this.hGh);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hFA.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hFA.setLayoutParams(layoutParams);
        }
        this.orj = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_bottom_view_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ori.getLayoutParams();
        layoutParams2.topMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.145d);
        this.ori.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.orj.getLayoutParams();
        layoutParams3.bottomMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.125d);
        this.orj.setLayoutParams(layoutParams3);
        HH();
    }

    private void HH() {
        this.ori.setOnClickListener(this.hGh);
    }

    public void ceD() {
        ckR();
    }

    public boolean cex() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clt() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void In(String str) {
        this.hFL = str;
        this.hFH.setText(a.h.yuyin_ala_live_change_cover);
        this.hFH.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.hFH.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_black_alpha40));
        l.a(this.hFG, str, true, false);
    }

    public String ceA() {
        return this.hFL;
    }

    public void a(d.a aVar) {
        this.orh = aVar;
    }
}
