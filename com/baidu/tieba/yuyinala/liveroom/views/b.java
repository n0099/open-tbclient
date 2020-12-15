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
    private ImageView hFC;
    private TbImageView hFI;
    private TextView hFJ;
    private View.OnClickListener hGj;
    private d.a orj;
    private CubicRoundRectRelativeLayout ork;
    private LinearLayout orl;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hGj = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.ala_live_prepare_start) {
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (b.this.ora != null) {
                                b.this.ora.ciu();
                            }
                        } else {
                            b.this.ckS();
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
                    b.this.clu();
                } else if (view.getId() == a.f.ala_prepare_close && b.this.ora != null) {
                    b.this.ora.onCloseClicked();
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
                b.this.ckV();
                return false;
            }
        });
        ckN();
        this.hDv.setOnClickListener(this.hGj);
        this.ork = (CubicRoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hFI = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hFJ = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hFI.setIsRound(false);
        this.hFI.setGifIconSupport(false);
        this.hFJ.setText(a.h.yuyin_ala_live_add_cover);
        this.hFI.setDefaultResource(a.e.icon_live_yuyin_createroom_default_bg);
        this.hFI.setDefaultBgResource(a.c.sdk_transparent);
        this.hDv.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hFC = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hFC.setOnClickListener(this.hGj);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hFC.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hFC.setLayoutParams(layoutParams);
        }
        this.orl = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_bottom_view_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ork.getLayoutParams();
        layoutParams2.topMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.145d);
        this.ork.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.orl.getLayoutParams();
        layoutParams3.bottomMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.125d);
        this.orl.setLayoutParams(layoutParams3);
        HH();
    }

    private void HH() {
        this.ork.setOnClickListener(this.hGj);
    }

    public void ceE() {
        ckS();
    }

    public boolean cey() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clu() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void In(String str) {
        this.hFN = str;
        this.hFJ.setText(a.h.yuyin_ala_live_change_cover);
        this.hFJ.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.hFJ.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_black_alpha40));
        l.a(this.hFI, str, true, false);
    }

    public String ceB() {
        return this.hFN;
    }

    public void a(d.a aVar) {
        this.orj = aVar;
    }
}
