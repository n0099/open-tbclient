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
    private ImageView hMW;
    private View.OnClickListener hND;
    private TbImageView hNc;
    private TextView hNd;
    private d.a osH;
    private CubicRoundRectRelativeLayout osI;
    private LinearLayout osJ;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hND = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.ala_live_prepare_start) {
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (b.this.osw != null) {
                                b.this.osw.chq();
                            }
                        } else {
                            b.this.cjS();
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
                    b.this.cku();
                } else if (view.getId() == a.f.ala_prepare_close && b.this.osw != null) {
                    b.this.osw.onCloseClicked();
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
                b.this.cjV();
                return false;
            }
        });
        cjN();
        this.hKP.setOnClickListener(this.hND);
        this.osI = (CubicRoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hNc = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hNd = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hNc.setIsRound(false);
        this.hNc.setGifIconSupport(false);
        this.hNd.setText(a.h.yuyin_ala_live_add_cover);
        this.hNc.setDefaultResource(a.e.icon_live_yuyin_createroom_default_bg);
        this.hNc.setDefaultBgResource(a.c.sdk_transparent);
        this.hKP.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hMW = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hMW.setOnClickListener(this.hND);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hMW.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hMW.setLayoutParams(layoutParams);
        }
        this.osJ = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_bottom_view_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.osI.getLayoutParams();
        layoutParams2.topMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.145d);
        this.osI.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.osJ.getLayoutParams();
        layoutParams3.bottomMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.125d);
        this.osJ.setLayoutParams(layoutParams3);
        Dn();
    }

    private void Dn() {
        this.osI.setOnClickListener(this.hND);
    }

    public void cdD() {
        cjS();
    }

    public boolean cdx() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cku() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Hd(String str) {
        this.hNh = str;
        this.hNd.setText(a.h.yuyin_ala_live_change_cover);
        this.hNd.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.hNd.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_black_alpha40));
        m.a(this.hNc, str, true, false);
    }

    public String cdA() {
        return this.hNh;
    }

    public void a(d.a aVar) {
        this.osH = aVar;
    }
}
