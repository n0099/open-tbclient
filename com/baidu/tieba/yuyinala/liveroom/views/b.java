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
    private View.OnClickListener hqY;
    private ImageView hqr;
    private TbImageView hqy;
    private TextView hqz;
    private d.a nTp;
    private CubicRoundRectRelativeLayout nTq;
    private LinearLayout nTr;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hqY = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.ala_live_prepare_start) {
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (b.this.nTh != null) {
                                b.this.nTh.ccE();
                            }
                        } else {
                            b.this.cfb();
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_CREATE_ROOM, "createroom_clk").setContentExt(jSONObject));
                    }
                } else if (view.getId() == a.g.ala_prepare_cover_frame_layout) {
                    b.this.cfD();
                } else if (view.getId() == a.g.ala_prepare_close && b.this.nTh != null) {
                    b.this.nTh.onCloseClicked();
                }
            }
        };
        initViews();
    }

    private void initViews() {
        this.mRootView = (ViewGroup) View.inflate(this.mPageContext.getPageActivity(), a.h.yuyin_ala_live_prepare_common_view, null);
        this.mRootView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                b.this.cfe();
                return false;
            }
        });
        ceW();
        this.hol.setOnClickListener(this.hqY);
        this.nTq = (CubicRoundRectRelativeLayout) this.mRootView.findViewById(a.g.ala_prepare_cover_frame_layout);
        this.hqy = (TbImageView) this.mRootView.findViewById(a.g.ala_prepare_portrait);
        this.hqz = (TextView) this.mRootView.findViewById(a.g.ala_prepare_photo_label);
        this.hqy.setIsRound(false);
        this.hqy.setGifIconSupport(false);
        this.hqz.setText(a.i.yuyin_ala_live_add_cover);
        this.hqy.setDefaultResource(a.f.icon_live_yuyin_createroom_default_bg);
        this.hqy.setDefaultBgResource(a.d.sdk_transparent);
        this.hol.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hqr = (ImageView) this.mRootView.findViewById(a.g.ala_prepare_close);
        this.hqr.setOnClickListener(this.hqY);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hqr.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds24);
            this.hqr.setLayoutParams(layoutParams);
        }
        this.nTr = (LinearLayout) this.mRootView.findViewById(a.g.ala_prepare_bottom_view_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nTq.getLayoutParams();
        layoutParams2.topMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.145d);
        this.nTq.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.nTr.getLayoutParams();
        layoutParams3.bottomMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.125d);
        this.nTr.setLayoutParams(layoutParams3);
        Ga();
    }

    private void Ga() {
        this.nTq.setOnClickListener(this.hqY);
    }

    public void bYN() {
        cfb();
    }

    public boolean bYH() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfD() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HF(String str) {
        this.hqD = str;
        this.hqz.setText(a.i.yuyin_ala_live_change_cover);
        this.hqz.setTextColor(this.mPageContext.getResources().getColor(a.d.sdk_white_alpha50));
        this.hqz.setBackgroundColor(this.mPageContext.getResources().getColor(a.d.sdk_black_alpha40));
        l.a(this.hqy, str, true, false);
    }

    public String bYK() {
        return this.hqD;
    }

    public void a(d.a aVar) {
        this.nTp = aVar;
    }
}
