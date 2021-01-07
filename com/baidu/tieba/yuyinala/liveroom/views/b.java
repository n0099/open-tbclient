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
    private ImageView hRC;
    private TbImageView hRI;
    private TextView hRJ;
    private View.OnClickListener hSj;
    private d.a oxn;
    private CubicRoundRectRelativeLayout oxo;
    private LinearLayout oxp;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hSj = new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.ala_live_prepare_start) {
                    if (!UtilHelper.isFastDoubleClick()) {
                        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                            if (b.this.oxc != null) {
                                b.this.oxc.cli();
                            }
                        } else {
                            b.this.cnK();
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
                    b.this.com();
                } else if (view.getId() == a.f.ala_prepare_close && b.this.oxc != null) {
                    b.this.oxc.onCloseClicked();
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
                b.this.cnN();
                return false;
            }
        });
        cnF();
        this.hPv.setOnClickListener(this.hSj);
        this.oxo = (CubicRoundRectRelativeLayout) this.mRootView.findViewById(a.f.ala_prepare_cover_frame_layout);
        this.hRI = (TbImageView) this.mRootView.findViewById(a.f.ala_prepare_portrait);
        this.hRJ = (TextView) this.mRootView.findViewById(a.f.ala_prepare_photo_label);
        this.hRI.setIsRound(false);
        this.hRI.setGifIconSupport(false);
        this.hRJ.setText(a.h.yuyin_ala_live_add_cover);
        this.hRI.setDefaultResource(a.e.icon_live_yuyin_createroom_default_bg);
        this.hRI.setDefaultBgResource(a.c.sdk_transparent);
        this.hPv.setBackgroundResource(a.e.sdk_round_btn_qm_bg_radius_circle_selector);
        this.hRC = (ImageView) this.mRootView.findViewById(a.f.ala_prepare_close);
        this.hRC.setOnClickListener(this.hSj);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hRC.getLayoutParams();
            layoutParams.topMargin += this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds24);
            this.hRC.setLayoutParams(layoutParams);
        }
        this.oxp = (LinearLayout) this.mRootView.findViewById(a.f.ala_prepare_bottom_view_container);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oxo.getLayoutParams();
        layoutParams2.topMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.145d);
        this.oxo.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.oxp.getLayoutParams();
        layoutParams3.bottomMargin = (int) (ScreenHelper.getRealScreenHeight(this.mPageContext.getPageActivity()) * 0.125d);
        this.oxp.setLayoutParams(layoutParams3);
        Hi();
    }

    private void Hi() {
        this.oxo.setOnClickListener(this.hSj);
    }

    public void chv() {
        cnK();
    }

    public boolean chp() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void com() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Io(String str) {
        this.hRN = str;
        this.hRJ.setText(a.h.yuyin_ala_live_change_cover);
        this.hRJ.setTextColor(this.mPageContext.getResources().getColor(a.c.sdk_white_alpha50));
        this.hRJ.setBackgroundColor(this.mPageContext.getResources().getColor(a.c.sdk_black_alpha40));
        m.a(this.hRI, str, true, false);
    }

    public String chs() {
        return this.hRN;
    }

    public void a(d.a aVar) {
        this.oxn = aVar;
    }
}
