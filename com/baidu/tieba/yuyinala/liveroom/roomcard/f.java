package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.android.common.logging.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d.aa;
import com.baidu.live.data.ab;
import com.baidu.live.message.FollowRoom;
import com.baidu.live.message.ModifyRoomCover;
import com.baidu.live.message.YuyinFollowRoomMessage;
import com.baidu.live.message.YuyinModifyRoomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlbumActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinBannedPostActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.AlaLoadingButton;
import com.baidu.live.view.AlaLoadingView;
import com.baidu.live.view.AlphaGradientHListView;
import com.baidu.tieba.yuyinala.liveroom.rename.AlaGetRoomNameRenameHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.rename.c;
import com.baidu.tieba.yuyinala.liveroom.rename.e;
import com.baidu.tieba.yuyinala.liveroom.roomcard.c;
import com.baidu.tieba.yuyinala.liveroom.roomcard.e;
import com.baidu.tieba.yuyinala.liveroom.roomcard.g;
import com.baidu.tieba.yuyinala.liveroom.roomcard.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends Dialog {
    private ab aDd;
    private View bYd;
    public CustomMessageListener bgy;
    private CommonEmptyView bwJ;
    private AlaLoadingView cdW;
    private boolean isFollowed;
    private TextView jsK;
    private Activity mActivity;
    private h ora;
    private AlphaGradientHListView oyH;
    private ImageView oyI;
    private AlphaGradientHListView oyJ;
    private ImageView oyK;
    private ImageView oyL;
    private BarImageView oyM;
    private TextView oyN;
    private TextView oyO;
    private TextView oyP;
    private TextView oyQ;
    private View oyR;
    private TextView oyS;
    private TextView oyT;
    private LinearLayout oyU;
    private TextView oyV;
    private d oyW;
    private d oyX;
    private g oyY;
    private ImageView oyZ;
    private com.baidu.tieba.yuyinala.liveroom.rename.e oyk;
    private e oyp;
    private String oyx;
    private AlaLoadingButton oza;

    public f(Activity activity, ab abVar) {
        super(activity, a.i.DialogRoomcardStyle);
        this.isFollowed = false;
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    f.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        this.ora = new h(activity);
        this.aDd = abVar;
        init();
    }

    private void init() {
        initView();
        YB();
    }

    private void YB() {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(262144, 262144);
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(this.mActivity);
            attributes.width = -1;
            attributes.gravity = 80;
            attributes.flags = 1280;
            window.setAttributes(attributes);
            window.setSoftInputMode(48);
        }
    }

    private void initView() {
        setContentView(a.g.yuyin_layout_dialog_room_card);
        this.bwJ = (CommonEmptyView) findViewById(a.f.empty_yuyin_view);
        this.cdW = (AlaLoadingView) findViewById(a.f.loading_view);
        this.bYd = findViewById(a.f.view);
        this.oyL = (ImageView) findViewById(a.f.iv_rename);
        this.oyM = (BarImageView) findViewById(a.f.user_portrait);
        this.oyN = (TextView) findViewById(a.f.tv_report);
        this.oyO = (TextView) findViewById(a.f.tv_banded_post);
        this.oyP = (TextView) findViewById(a.f.room_name);
        this.jsK = (TextView) findViewById(a.f.tv_fans_num);
        this.oyR = findViewById(a.f.view_divider_line);
        this.oyQ = (TextView) findViewById(a.f.tv_id);
        this.oyZ = (ImageView) findViewById(a.f.iv_modify_img);
        this.oyS = (TextView) findViewById(a.f.tv_manager_count);
        this.oyU = (LinearLayout) findViewById(a.f.ll_zhuchi_count);
        this.oyT = (TextView) findViewById(a.f.tv_zhuchi_count);
        this.oyV = (TextView) findViewById(a.f.tv_bottom_toast);
        this.oyH = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.oyI = (ImageView) findViewById(a.f.ala_live_manager_listview_bg);
        this.oyJ = (AlphaGradientHListView) findViewById(a.f.ala_live_zhuchi_listview);
        this.oyK = (ImageView) findViewById(a.f.ala_live_zhuchi_listview_bg);
        this.oza = (AlaLoadingButton) findViewById(a.f.btn_collect_room);
        this.oyY = new g(this.mActivity);
        this.oyk = new com.baidu.tieba.yuyinala.liveroom.rename.e(this.mActivity);
        this.oyW = new d(this.mActivity);
        this.oyH.setAdapter((ListAdapter) this.oyW);
        this.oyH.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        MessageManager.getInstance().registerListener(this.bgy);
        this.oyH.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> ebJ;
                e.a aVar;
                if (f.this.oyW != null && (ebJ = f.this.oyW.ebJ()) != null && ebJ.size() > 0 && (aVar = ebJ.get(i)) != null && !aVar.oyG) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.oyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.oyp != null && f.this.oyp.oyv != 0) {
                    c.ebI().a(f.this.mActivity, f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.c.a
                        public void zW(boolean z) {
                            if (z && f.this.oyp != null && f.this.oyp.oyv == 1) {
                                f.this.cls();
                            }
                        }
                    });
                }
            }
        });
        this.oyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (f.this.aDd != null) {
                        f.this.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinBannedPostActivityConfig(f.this.mActivity, String.valueOf(f.this.aDd.aIU.aTK), String.valueOf(f.this.aDd.aIU.live_id), Long.toString(f.this.aDd.mLiveInfo.group_id))));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.oyN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cmH();
            }
        });
        this.oza.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ebo();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(f.this.mActivity);
                } else if (f.this.aDd != null && f.this.aDd.aIU != null) {
                    if (f.this.isFollowed) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g gVar = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(f.this.mActivity);
                        gVar.show();
                        gVar.setText("确认不收藏该房间了么");
                        gVar.ce(PayHelper.STATUS_CANCEL_DESC, a.c.sdk_color_ff1e66);
                        gVar.cf("确认", a.c.sdk_black_alpha100);
                        gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onCancel() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onConfirm() {
                                f.this.ora.y(f.this.aDd.aIU.aTK, f.this.aDd.aIU.live_id, 0);
                                f.this.oza.setStatus(3);
                            }
                        });
                    } else {
                        f.this.ora.y(f.this.aDd.aIU.aTK, f.this.aDd.aIU.live_id, 1);
                        f.this.oza.setStatus(3);
                    }
                    f.this.ora.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = false;
                                f.this.zX(false);
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(false, f.this.aDd.aIU.live_id)));
                                return;
                            }
                            f.this.ebl();
                            f.this.isFollowed = true;
                            f.this.zX(true);
                            BdUtilHelper.showToast(f.this.mActivity, "收藏成功，将收到房间的开播提醒", 3000);
                            MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, f.this.aDd.aIU.live_id)));
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = true;
                            } else {
                                BdUtilHelper.showToast(f.this.mActivity, "房间收藏失败", 3000);
                                f.this.isFollowed = false;
                            }
                            f.this.zX(f.this.isFollowed);
                        }
                    });
                }
            }
        });
        this.oyH.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.oyH.setNeedAlphaShade(true);
        this.oyJ.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.oyX = new d(this.mActivity);
        this.oyJ.setAdapter((ListAdapter) this.oyX);
        this.oyJ.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oyJ.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.8
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> ebJ;
                e.a aVar;
                if (f.this.oyX != null && (ebJ = f.this.oyX.ebJ()) != null && ebJ.size() > 0 && (aVar = ebJ.get(i)) != null && !aVar.oyG) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.oyJ.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.oyJ.setNeedAlphaShade(true);
        this.oyM.setShowOval(true);
        this.oyM.setStrokeColorResId(a.c.sdk_white_alpha100);
        this.oyM.setAutoChangeStyle(false);
        this.oyM.setStrokeWith(BdUtilHelper.dip2px(this.mActivity, 2.0f));
        this.oyL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aDd != null && f.this.aDd.aIU != null) {
                    new com.baidu.tieba.yuyinala.liveroom.rename.c(f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.rename.c.a
                        public void call(String str) {
                            f.this.oyP.setText(str);
                            f.this.oyp.room_name = str;
                        }
                    }).ae(f.this.aDd);
                }
            }
        });
        this.oyH.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
        if (this.aDd.aIU.aTU == 1) {
            this.oyU.setVisibility(0);
        } else {
            this.oyU.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmH() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getContext());
            return;
        }
        dismiss();
        if (this.aDd != null && this.aDd.aIU != null) {
            aa aaVar = new aa(getContext());
            aaVar.ak(this.aDd.aIU.live_id, this.aDd.aIU.aTK);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, aaVar));
        }
    }

    private void VP(String str) {
        this.oyY.request(str);
        this.cdW.setVisibility(0);
        this.oyY.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.11
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void b(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
                f.this.oyK.setVisibility(8);
                f.this.oyI.setVisibility(8);
                f.this.oyH.setVisibility(0);
                f.this.oyJ.setVisibility(0);
                f.this.cdW.setVisibility(8);
                f.this.a(alaGetRoomCardInfoHttpResponseMessage);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void onFail(int i, String str2) {
                f.this.cdW.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
        if (alaGetRoomCardInfoHttpResponseMessage != null && alaGetRoomCardInfoHttpResponseMessage.ebH() != null) {
            this.oyp = alaGetRoomCardInfoHttpResponseMessage.ebH();
            if (this.oyp != null) {
                this.oyP.setText(this.oyp.room_name);
                if (!TextUtils.isEmpty(this.oyp.oyD)) {
                    this.oyM.startLoad(this.oyp.oyD, 12, false, false);
                }
                this.jsK.setText("粉丝：" + StringHelper.formatYuyinValue(this.oyp.oyB));
                this.oyQ.setText("房间ID：" + this.oyp.oyC);
                this.oyR.setVisibility(0);
                if (this.oyp.oyA == null || this.oyp.oyA.size() == 0) {
                    this.oyS.setText("管理员：0人");
                } else {
                    this.oyS.setText("管理员：" + this.oyp.oyA.size() + "人");
                }
                if (this.oyp.oyw == 1) {
                    this.oyO.setVisibility(0);
                } else {
                    this.oyO.setVisibility(8);
                }
                if (this.oyp != null && this.oyp.oyv == 1) {
                    this.oyZ.setVisibility(0);
                } else {
                    this.oyZ.setVisibility(8);
                }
                if (this.oyp.oyA != null && this.oyp.oyA.size() > 0) {
                    this.oyW.go(this.oyp.oyA);
                    this.oyW.notifyDataSetChanged();
                }
                if (this.oyp.oyz == null || this.oyp.oyz.size() == 0) {
                    this.oyT.setText("主持：0人");
                    ArrayList arrayList = new ArrayList();
                    e.a aVar = new e.a();
                    aVar.oyG = true;
                    aVar.oyE = 3;
                    arrayList.add(aVar);
                    this.oyX.go(arrayList);
                    this.oyX.notifyDataSetChanged();
                    this.oyU.setVisibility(8);
                } else {
                    this.oyU.setVisibility(0);
                    this.oyT.setText("主持：" + this.oyp.oyz.size() + "人");
                }
                if (this.oyp.oyz != null && this.oyp.oyz.size() > 0) {
                    this.oyX.go(this.oyp.oyz);
                    this.oyX.notifyDataSetChanged();
                }
                this.isFollowed = this.oyp.oyy == 1;
                this.oyx = this.oyp.oyx;
                this.oyV.setText(this.oyx);
                zX(this.oyp.oyy == 1);
                if (this.oyp.oyv == 1) {
                    this.oyL.setVisibility(0);
                } else {
                    this.oyL.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zX(boolean z) {
        if (z) {
            this.oza.setStatus(4);
        } else {
            this.oza.setStatus(1);
        }
    }

    public void ai(ab abVar) {
        this.aDd = abVar;
        try {
            show();
            if (this.aDd != null && this.aDd.aIU != null) {
                VP(this.aDd.aIU.aTK);
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th) {
            Log.d(":nht...", th.getMessage());
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cls() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mActivity, "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HH(final String str) {
        if (this.oyk != null && this.aDd != null && this.aDd.aIU != null) {
            this.oyk.f(this.aDd.aIU.aTK, 2, this.aDd.aIU.live_id, str);
            this.oyk.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.2
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    m.a(f.this.oyM, str, true, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinModifyRoomMessage(new ModifyRoomCover(str)));
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void n(int i, String str2, String str3) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar) {
        if (aVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mActivity, ExtraParamsManager.getDecryptUserId(aVar.user_uk) + "", aVar.user_name, aVar.oyF, 0, 0, null, null, 0L, 0L, 0L, 0, "", this.aDd.aIU.live_id, false, "", null, aVar.user_name, "")));
        }
    }
}
