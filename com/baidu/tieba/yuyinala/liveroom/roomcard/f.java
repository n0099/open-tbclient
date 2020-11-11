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
    private w aES;
    private View bPK;
    public CustomMessageListener bek;
    private CommonEmptyView bpJ;
    private TextView iTB;
    private boolean isFollowed;
    private Activity mActivity;
    private h nTv;
    private AlphaGradientHListView nZB;
    private AlphaGradientHListView nZC;
    private ImageView nZD;
    private BarImageView nZE;
    private TextView nZF;
    private TextView nZG;
    private TextView nZH;
    private TextView nZI;
    private TextView nZJ;
    private TextView nZK;
    private TextView nZL;
    private TextView nZM;
    private d nZN;
    private d nZO;
    private g nZP;
    private ImageView nZQ;
    private com.baidu.tieba.yuyinala.liveroom.rename.e nZe;
    private e nZj;
    private String nZr;

    public f(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.isFollowed = false;
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    f.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        this.nTv = new h(activity);
        init();
    }

    private void init() {
        initView();
        Xy();
    }

    private void Xy() {
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
        this.bpJ = (CommonEmptyView) findViewById(a.f.empty_yuyin_view);
        this.bPK = findViewById(a.f.view);
        this.nZD = (ImageView) findViewById(a.f.iv_rename);
        this.nZE = (BarImageView) findViewById(a.f.user_portrait);
        this.nZF = (TextView) findViewById(a.f.tv_report);
        this.nZG = (TextView) findViewById(a.f.tv_banded_post);
        this.nZH = (TextView) findViewById(a.f.room_name);
        this.iTB = (TextView) findViewById(a.f.tv_fans_num);
        this.nZI = (TextView) findViewById(a.f.tv_id);
        this.nZQ = (ImageView) findViewById(a.f.iv_modify_img);
        this.nZJ = (TextView) findViewById(a.f.tv_manager_count);
        this.nZK = (TextView) findViewById(a.f.tv_zhuchi_count);
        this.nZL = (TextView) findViewById(a.f.tv_collect_room);
        this.nZM = (TextView) findViewById(a.f.tv_bottom_toast);
        this.nZB = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.nZC = (AlphaGradientHListView) findViewById(a.f.ala_live_zhuchi_listview);
        this.nZP = new g(this.mActivity);
        this.nZe = new com.baidu.tieba.yuyinala.liveroom.rename.e(this.mActivity);
        this.nZN = new d(this.mActivity);
        this.nZB.setAdapter((ListAdapter) this.nZN);
        this.nZB.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        MessageManager.getInstance().registerListener(this.bek);
        this.nZB.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> dYr;
                e.a aVar;
                if (f.this.nZN != null && (dYr = f.this.nZN.dYr()) != null && dYr.size() > 0 && (aVar = dYr.get(i)) != null && !aVar.nZA) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.nZE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.nZj != null && f.this.nZj.nZp != 0) {
                    c.dYq().a(f.this.mActivity, f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.c.a
                        public void yT(boolean z) {
                            if (z && f.this.nZj != null && f.this.nZj.nZp == 1) {
                                f.this.cif();
                            }
                        }
                    });
                }
            }
        });
        this.nZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (f.this.aES != null) {
                        f.this.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinBannedPostActivityConfig(f.this.mActivity, String.valueOf(f.this.aES.aJK.aSP), String.valueOf(f.this.aES.aJK.live_id), Long.toString(f.this.aES.mLiveInfo.group_id))));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.nZF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cju();
            }
        });
        this.nZL.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.nZL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dXY();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(f.this.mActivity);
                } else if (f.this.aES != null && f.this.aES.aJK != null) {
                    if (f.this.isFollowed) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g gVar = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(f.this.mActivity);
                        gVar.show();
                        gVar.setText("确认取消收藏本房间吗");
                        gVar.Vn("算了");
                        gVar.bT("确认", a.c.sdk_color_ff1e66);
                        gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onCancel() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onConfirm() {
                                f.this.nTv.w(f.this.aES.aJK.aSP, f.this.aES.aJK.live_id, 0);
                            }
                        });
                    } else {
                        f.this.nTv.w(f.this.aES.aJK.aSP, f.this.aES.aJK.live_id, 1);
                    }
                    f.this.nTv.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = false;
                                f.this.yU(false);
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(false, f.this.aES.aJK.live_id)));
                                return;
                            }
                            f.this.dXZ();
                            f.this.isFollowed = true;
                            f.this.yU(true);
                            BdUtilHelper.showToast(f.this.mActivity, "收藏成功，将收到房间的开播提醒", 3000);
                            MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, f.this.aES.aJK.live_id)));
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
        this.nZB.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.nZB.setNeedAlphaShade(true);
        this.nZC.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.nZO = new d(this.mActivity);
        this.nZC.setAdapter((ListAdapter) this.nZO);
        this.nZC.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.nZC.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.8
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> dYr;
                e.a aVar;
                if (f.this.nZO != null && (dYr = f.this.nZO.dYr()) != null && dYr.size() > 0 && (aVar = dYr.get(i)) != null && !aVar.nZA) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.nZC.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.nZC.setNeedAlphaShade(true);
        this.nZE.setShowOval(true);
        this.nZE.setStrokeColorResId(a.c.sdk_white_alpha100);
        this.nZE.setAutoChangeStyle(false);
        this.nZE.setStrokeWith(BdUtilHelper.dip2px(this.mActivity, 2.0f));
        this.nZD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aES != null && f.this.aES.aJK != null) {
                    new com.baidu.tieba.yuyinala.liveroom.rename.c(f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.rename.c.a
                        public void call(String str) {
                            f.this.nZH.setText(str);
                            f.this.nZj.room_name = str;
                        }
                    }).X(f.this.aES);
                }
            }
        });
        this.nZB.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bPK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cju() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getContext());
            return;
        }
        dismiss();
        if (this.aES != null && this.aES.aJK != null) {
            z zVar = new z(getContext());
            zVar.ai(this.aES.aJK.live_id, this.aES.aJK.aSP);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, zVar));
        }
    }

    private void Vs(String str) {
        this.nZP.request(str);
        this.nZP.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.11
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
        if (alaGetRoomCardInfoHttpResponseMessage != null && alaGetRoomCardInfoHttpResponseMessage.dYp() != null) {
            this.nZj = alaGetRoomCardInfoHttpResponseMessage.dYp();
            this.nZH.setText(this.nZj.room_name);
            if (!TextUtils.isEmpty(this.nZj.nZx)) {
                this.nZE.startLoad(this.nZj.nZx, 12, false, false);
            }
            this.iTB.setText("粉丝：" + StringHelper.formatYuyinValue(this.nZj.nZv));
            this.nZI.setText("房间ID：" + this.nZj.nZw);
            if (this.nZj.nZu == null || this.nZj.nZu.size() == 0) {
                this.nZJ.setText("管理员：0人");
            } else {
                this.nZJ.setText("管理员：" + this.nZj.nZu.size() + "人");
            }
            if (this.nZj.nZq == 1) {
                this.nZG.setVisibility(0);
            } else {
                this.nZG.setVisibility(8);
            }
            if (this.nZj != null && this.nZj.nZp == 1) {
                this.nZQ.setVisibility(0);
            } else {
                this.nZQ.setVisibility(8);
            }
            if (this.nZj.nZu != null && this.nZj.nZu.size() > 0) {
                this.nZN.gk(this.nZj.nZu);
                this.nZN.notifyDataSetChanged();
            }
            if (this.nZj.nZt == null || this.nZj.nZt.size() == 0) {
                this.nZK.setText("主持：0人");
                ArrayList arrayList = new ArrayList();
                e.a aVar = new e.a();
                aVar.nZA = true;
                aVar.nZy = 3;
                arrayList.add(aVar);
                this.nZO.gk(arrayList);
                this.nZO.notifyDataSetChanged();
            } else {
                this.nZK.setText("主持：" + this.nZj.nZt.size() + "人");
            }
            if (this.nZj.nZt != null && this.nZj.nZt.size() > 0) {
                this.nZO.gk(this.nZj.nZt);
                this.nZO.notifyDataSetChanged();
            }
            this.isFollowed = this.nZj.nZs == 1;
            this.nZr = this.nZj.nZr;
            yU(this.nZj.nZs == 1);
            if (this.nZj.nZp == 1) {
                this.nZD.setVisibility(0);
            } else {
                this.nZD.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yU(boolean z) {
        if (z) {
            this.nZL.setText("已收藏");
            this.nZL.setBackgroundResource(a.e.yuyin_ala_room_card_uncollect_bg);
            this.nZL.setTextColor(getContext().getResources().getColor(a.c.sdk_color_858585));
            this.nZL.setVisibility(0);
            this.nZM.setVisibility(0);
            this.nZM.setText(this.nZr);
            return;
        }
        this.nZL.setText("收藏本房间");
        this.nZL.setBackgroundResource(a.e.yuyin_ala_room_card_collect_bg);
        this.nZL.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        this.nZL.setVisibility(0);
        this.nZM.setVisibility(0);
        this.nZM.setText(this.nZr);
    }

    public void Z(w wVar) {
        this.aES = wVar;
        try {
            show();
            if (this.aES != null && this.aES.aJK != null) {
                Vs(this.aES.aJK.aSP);
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
    public void cif() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mActivity, "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HX(final String str) {
        if (this.nZe != null && this.aES != null && this.aES.aJK != null) {
            this.nZe.f(this.aES.aJK.aSP, 2, this.aES.aJK.live_id, str);
            this.nZe.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.2
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    l.a(f.this.nZE, str, true, false);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mActivity, ExtraParamsManager.getDecryptUserId(aVar.user_uk) + "", aVar.user_name, aVar.nZz, 0, 0, null, null, 0L, 0L, 0L, 0, "", this.aES.aJK.live_id, false, "", null, aVar.user_name, "")));
        }
    }
}
