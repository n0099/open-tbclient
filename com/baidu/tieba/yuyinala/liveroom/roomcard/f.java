package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.android.common.logging.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.b.z;
import com.baidu.live.data.w;
import com.baidu.live.message.FollowRoom;
import com.baidu.live.message.ModifyRoomCover;
import com.baidu.live.message.YuyinFollowRoomMessage;
import com.baidu.live.message.YuyinModifyRoomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlbumActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinBannedPostActivityConfig;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.horizonallist.widget.AdapterView;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.live.utils.l;
import com.baidu.live.view.AlphaGradientHListView;
import com.baidu.tieba.yuyinala.liveroom.rename.AlaGetRoomNameRenameHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.rename.c;
import com.baidu.tieba.yuyinala.liveroom.rename.e;
import com.baidu.tieba.yuyinala.liveroom.roomcard.c;
import com.baidu.tieba.yuyinala.liveroom.roomcard.e;
import com.baidu.tieba.yuyinala.liveroom.roomcard.g;
import com.baidu.tieba.yuyinala.liveroom.roomcard.h;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f extends Dialog {
    private w aDh;
    private View bOa;
    public CustomMessageListener bcy;
    private CommonEmptyView bnY;
    private TextView iUn;
    private boolean isFollowed;
    private Activity mActivity;
    private h nUY;
    private com.baidu.tieba.yuyinala.liveroom.rename.e oaH;
    private e oaM;
    private String oaU;
    private AlphaGradientHListView obe;
    private AlphaGradientHListView obf;
    private ImageView obg;
    private BarImageView obh;
    private TextView obi;
    private TextView obk;
    private TextView obl;
    private TextView obm;
    private TextView obn;
    private TextView obo;
    private TextView obp;
    private TextView obq;
    private d obr;
    private d obs;
    private g obt;
    private ImageView obu;

    public f(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.isFollowed = false;
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    f.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        this.nUY = new h(activity);
        init();
    }

    private void init() {
        initView();
        WP();
    }

    private void WP() {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(262144, 262144);
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getContext());
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(this.mActivity);
            attributes.width = -1;
            attributes.gravity = 80;
            attributes.flags = PlatformPlugin.DEFAULT_SYSTEM_UI;
            window.setAttributes(attributes);
            window.setSoftInputMode(48);
        }
    }

    private void initView() {
        setContentView(a.g.yuyin_layout_dialog_room_card);
        this.bnY = (CommonEmptyView) findViewById(a.f.empty_yuyin_view);
        this.bOa = findViewById(a.f.view);
        this.obg = (ImageView) findViewById(a.f.iv_rename);
        this.obh = (BarImageView) findViewById(a.f.user_portrait);
        this.obi = (TextView) findViewById(a.f.tv_report);
        this.obk = (TextView) findViewById(a.f.tv_banded_post);
        this.obl = (TextView) findViewById(a.f.room_name);
        this.iUn = (TextView) findViewById(a.f.tv_fans_num);
        this.obm = (TextView) findViewById(a.f.tv_id);
        this.obu = (ImageView) findViewById(a.f.iv_modify_img);
        this.obn = (TextView) findViewById(a.f.tv_manager_count);
        this.obo = (TextView) findViewById(a.f.tv_zhuchi_count);
        this.obp = (TextView) findViewById(a.f.tv_collect_room);
        this.obq = (TextView) findViewById(a.f.tv_bottom_toast);
        this.obe = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.obf = (AlphaGradientHListView) findViewById(a.f.ala_live_zhuchi_listview);
        this.obt = new g(this.mActivity);
        this.oaH = new com.baidu.tieba.yuyinala.liveroom.rename.e(this.mActivity);
        this.obr = new d(this.mActivity);
        this.obe.setAdapter((ListAdapter) this.obr);
        this.obe.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        MessageManager.getInstance().registerListener(this.bcy);
        this.obe.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> dYq;
                e.a aVar;
                if (f.this.obr != null && (dYq = f.this.obr.dYq()) != null && dYq.size() > 0 && (aVar = dYq.get(i)) != null && !aVar.obd) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.obh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.oaM != null && f.this.oaM.oaS != 0) {
                    c.dYp().a(f.this.mActivity, f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.c.a
                        public void za(boolean z) {
                            if (z && f.this.oaM != null && f.this.oaM.oaS == 1) {
                                f.this.chy();
                            }
                        }
                    });
                }
            }
        });
        this.obk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (f.this.aDh != null) {
                        f.this.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinBannedPostActivityConfig(f.this.mActivity, String.valueOf(f.this.aDh.aHZ.aRe), String.valueOf(f.this.aDh.aHZ.live_id), Long.toString(f.this.aDh.mLiveInfo.group_id))));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.obi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ciN();
            }
        });
        this.obp.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.obp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dXX();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(f.this.mActivity);
                } else if (f.this.aDh != null && f.this.aDh.aHZ != null) {
                    if (f.this.isFollowed) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g gVar = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(f.this.mActivity);
                        gVar.show();
                        gVar.setText("确认取消收藏本房间吗");
                        gVar.UY("算了");
                        gVar.bS("确认", a.c.sdk_color_ff1e66);
                        gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onCancel() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onConfirm() {
                                f.this.nUY.w(f.this.aDh.aHZ.aRe, f.this.aDh.aHZ.live_id, 0);
                            }
                        });
                    } else {
                        f.this.nUY.w(f.this.aDh.aHZ.aRe, f.this.aDh.aHZ.live_id, 1);
                    }
                    f.this.nUY.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = false;
                                f.this.zb(false);
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(false, f.this.aDh.aHZ.live_id)));
                                return;
                            }
                            f.this.dXY();
                            f.this.isFollowed = true;
                            f.this.zb(true);
                            BdUtilHelper.showToast(f.this.mActivity, "收藏成功，将收到房间的开播提醒", 3000);
                            MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, f.this.aDh.aHZ.live_id)));
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = true;
                                return;
                            }
                            BdUtilHelper.showToast(f.this.mActivity, "房间收藏失败", 3000);
                            f.this.isFollowed = false;
                        }
                    });
                }
            }
        });
        this.obe.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.obe.setNeedAlphaShade(true);
        this.obf.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.obs = new d(this.mActivity);
        this.obf.setAdapter((ListAdapter) this.obs);
        this.obf.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.obf.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.8
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> dYq;
                e.a aVar;
                if (f.this.obs != null && (dYq = f.this.obs.dYq()) != null && dYq.size() > 0 && (aVar = dYq.get(i)) != null && !aVar.obd) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.obf.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.obf.setNeedAlphaShade(true);
        this.obh.setShowOval(true);
        this.obh.setStrokeColorResId(a.c.sdk_white_alpha100);
        this.obh.setAutoChangeStyle(false);
        this.obh.setStrokeWith(BdUtilHelper.dip2px(this.mActivity, 2.0f));
        this.obg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aDh != null && f.this.aDh.aHZ != null) {
                    new com.baidu.tieba.yuyinala.liveroom.rename.c(f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.rename.c.a
                        public void call(String str) {
                            f.this.obl.setText(str);
                            f.this.oaM.room_name = str;
                        }
                    }).X(f.this.aDh);
                }
            }
        });
        this.obe.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bOa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDh.aHZ.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDh.aHZ.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciN() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getContext());
            return;
        }
        dismiss();
        if (this.aDh != null && this.aDh.aHZ != null) {
            z zVar = new z(getContext());
            zVar.ah(this.aDh.aHZ.live_id, this.aDh.aHZ.aRe);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, zVar));
        }
    }

    private void Vd(String str) {
        this.obt.request(str);
        this.obt.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.11
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void b(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
                f.this.a(alaGetRoomCardInfoHttpResponseMessage);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void onFail(int i, String str2) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
        if (alaGetRoomCardInfoHttpResponseMessage != null && alaGetRoomCardInfoHttpResponseMessage.dYo() != null) {
            this.oaM = alaGetRoomCardInfoHttpResponseMessage.dYo();
            this.obl.setText(this.oaM.room_name);
            if (!TextUtils.isEmpty(this.oaM.oba)) {
                this.obh.startLoad(this.oaM.oba, 12, false, false);
            }
            this.iUn.setText("粉丝：" + StringHelper.formatYuyinValue(this.oaM.oaY));
            this.obm.setText("房间ID：" + this.oaM.oaZ);
            if (this.oaM.oaX == null || this.oaM.oaX.size() == 0) {
                this.obn.setText("管理员：0人");
            } else {
                this.obn.setText("管理员：" + this.oaM.oaX.size() + "人");
            }
            if (this.oaM.oaT == 1) {
                this.obk.setVisibility(0);
            } else {
                this.obk.setVisibility(8);
            }
            if (this.oaM != null && this.oaM.oaS == 1) {
                this.obu.setVisibility(0);
            } else {
                this.obu.setVisibility(8);
            }
            if (this.oaM.oaX != null && this.oaM.oaX.size() > 0) {
                this.obr.gk(this.oaM.oaX);
                this.obr.notifyDataSetChanged();
            }
            if (this.oaM.oaW == null || this.oaM.oaW.size() == 0) {
                this.obo.setText("主持：0人");
                ArrayList arrayList = new ArrayList();
                e.a aVar = new e.a();
                aVar.obd = true;
                aVar.obb = 3;
                arrayList.add(aVar);
                this.obs.gk(arrayList);
                this.obs.notifyDataSetChanged();
            } else {
                this.obo.setText("主持：" + this.oaM.oaW.size() + "人");
            }
            if (this.oaM.oaW != null && this.oaM.oaW.size() > 0) {
                this.obs.gk(this.oaM.oaW);
                this.obs.notifyDataSetChanged();
            }
            this.isFollowed = this.oaM.oaV == 1;
            this.oaU = this.oaM.oaU;
            zb(this.oaM.oaV == 1);
            if (this.oaM.oaS == 1) {
                this.obg.setVisibility(0);
            } else {
                this.obg.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb(boolean z) {
        if (z) {
            this.obp.setText("已收藏");
            this.obp.setBackgroundResource(a.e.yuyin_ala_room_card_uncollect_bg);
            this.obp.setTextColor(getContext().getResources().getColor(a.c.sdk_color_858585));
            this.obp.setVisibility(0);
            this.obq.setVisibility(0);
            this.obq.setText(this.oaU);
            return;
        }
        this.obp.setText("收藏本房间");
        this.obp.setBackgroundResource(a.e.yuyin_ala_room_card_collect_bg);
        this.obp.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        this.obp.setVisibility(0);
        this.obq.setVisibility(0);
        this.obq.setText(this.oaU);
    }

    public void Z(w wVar) {
        this.aDh = wVar;
        try {
            show();
            if (this.aDh != null && this.aDh.aHZ != null) {
                Vd(this.aDh.aHZ.aRe);
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
    public void chy() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mActivity, "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Hy(final String str) {
        if (this.oaH != null && this.aDh != null && this.aDh.aHZ != null) {
            this.oaH.f(this.aDh.aHZ.aRe, 2, this.aDh.aHZ.live_id, str);
            this.oaH.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.2
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    l.a(f.this.obh, str, true, false);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mActivity, ExtraParamsManager.getDecryptUserId(aVar.user_uk) + "", aVar.user_name, aVar.obc, 0, 0, null, null, 0L, 0L, 0L, 0, "", this.aDh.aHZ.live_id, false, "", null, aVar.user_name, "")));
        }
    }
}
