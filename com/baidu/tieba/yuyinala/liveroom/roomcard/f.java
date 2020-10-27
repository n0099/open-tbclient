package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.android.common.logging.Log;
import com.baidu.ar.arplay.core.message.ARPMessageType;
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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f extends Dialog {
    private w aEc;
    private View bKe;
    public CustomMessageListener bcQ;
    private CommonEmptyView boq;
    private TextView iNE;
    private boolean isFollowed;
    private Activity mActivity;
    private h nNB;
    private com.baidu.tieba.yuyinala.liveroom.rename.e nRR;
    private e nRW;
    private d nSA;
    private d nSB;
    private g nSC;
    private ImageView nSD;
    private String nSe;
    private AlphaGradientHListView nSo;
    private AlphaGradientHListView nSp;
    private ImageView nSq;
    private BarImageView nSr;
    private TextView nSs;
    private TextView nSt;
    private TextView nSu;
    private TextView nSv;
    private TextView nSw;
    private TextView nSx;
    private TextView nSy;
    private TextView nSz;

    public f(Activity activity) {
        super(activity, a.j.DialogRoomcardStyle);
        this.isFollowed = false;
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    f.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        this.nNB = new h(activity);
        init();
    }

    private void init() {
        initView();
        UZ();
    }

    private void UZ() {
        Window window = getWindow();
        if (window != null) {
            window.setFlags(262144, 262144);
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
            window.setSoftInputMode(48);
        }
    }

    private void initView() {
        setContentView(a.h.yuyin_layout_dialog_room_card);
        this.boq = (CommonEmptyView) findViewById(a.g.empty_yuyin_view);
        this.bKe = findViewById(a.g.view);
        this.nSq = (ImageView) findViewById(a.g.iv_rename);
        this.nSr = (BarImageView) findViewById(a.g.user_portrait);
        this.nSs = (TextView) findViewById(a.g.tv_report);
        this.nSt = (TextView) findViewById(a.g.tv_banded_post);
        this.nSu = (TextView) findViewById(a.g.room_name);
        this.iNE = (TextView) findViewById(a.g.tv_fans_num);
        this.nSv = (TextView) findViewById(a.g.tv_id);
        this.nSD = (ImageView) findViewById(a.g.iv_modify_img);
        this.nSw = (TextView) findViewById(a.g.tv_manager_count);
        this.nSx = (TextView) findViewById(a.g.tv_zhuchi_count);
        this.nSy = (TextView) findViewById(a.g.tv_collect_room);
        this.nSz = (TextView) findViewById(a.g.tv_bottom_toast);
        this.nSo = (AlphaGradientHListView) findViewById(a.g.ala_live_manager_listview);
        this.nSp = (AlphaGradientHListView) findViewById(a.g.ala_live_zhuchi_listview);
        this.nSC = new g(this.mActivity);
        this.nRR = new com.baidu.tieba.yuyinala.liveroom.rename.e(this.mActivity);
        this.nSA = new d(this.mActivity);
        this.nSo.setAdapter((ListAdapter) this.nSA);
        this.nSo.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        MessageManager.getInstance().registerListener(this.bcQ);
        this.nSo.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> dVC;
                e.a aVar;
                if (f.this.nSA != null && (dVC = f.this.nSA.dVC()) != null && dVC.size() > 0 && (aVar = dVC.get(i)) != null && !aVar.nSn) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.nSr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.nRW != null && f.this.nRW.nSc != 0) {
                    c.dVB().a(f.this.mActivity, f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.c.a
                        public void yK(boolean z) {
                            if (z && f.this.nRW != null && f.this.nRW.nSc == 1) {
                                f.this.cfD();
                            }
                        }
                    });
                }
            }
        });
        this.nSt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (f.this.aEc != null) {
                        f.this.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinBannedPostActivityConfig(f.this.mActivity, String.valueOf(f.this.aEc.aIS.aRy), String.valueOf(f.this.aEc.aIS.live_id), Long.toString(f.this.aEc.mLiveInfo.group_id))));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.nSs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cgS();
            }
        });
        this.nSy.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.nSy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dVj();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(f.this.mActivity);
                } else if (f.this.aEc != null && f.this.aEc.aIS != null) {
                    if (f.this.isFollowed) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g gVar = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(f.this.mActivity);
                        gVar.show();
                        gVar.setText("确认取消收藏本房间吗");
                        gVar.UW("算了");
                        gVar.bR("确认", a.d.sdk_color_ff1e66);
                        gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onCancel() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onConfirm() {
                                f.this.nNB.v(f.this.aEc.aIS.aRy, f.this.aEc.aIS.live_id, 0);
                            }
                        });
                    } else {
                        f.this.nNB.v(f.this.aEc.aIS.aRy, f.this.aEc.aIS.live_id, 1);
                    }
                    f.this.nNB.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = false;
                                f.this.yL(false);
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(false, f.this.aEc.aIS.live_id)));
                                return;
                            }
                            f.this.dVk();
                            f.this.isFollowed = true;
                            f.this.yL(true);
                            BdUtilHelper.showToast(f.this.mActivity, "收藏成功，将收到房间的开播提醒", 3000);
                            MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, f.this.aEc.aIS.live_id)));
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
        this.nSo.setColor(this.mActivity.getResources().getColor(a.d.sdk_white_alpha100), this.mActivity.getResources().getColor(a.d.sdk_white_alpha0));
        this.nSo.setNeedAlphaShade(true);
        this.nSp.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.e.sdk_ds0));
        this.nSB = new d(this.mActivity);
        this.nSp.setAdapter((ListAdapter) this.nSB);
        this.nSp.setSelector(this.mActivity.getResources().getDrawable(a.f.sdk_transparent_bg));
        this.nSp.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.8
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> dVC;
                e.a aVar;
                if (f.this.nSB != null && (dVC = f.this.nSB.dVC()) != null && dVC.size() > 0 && (aVar = dVC.get(i)) != null && !aVar.nSn) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.nSp.setColor(this.mActivity.getResources().getColor(a.d.sdk_white_alpha100), this.mActivity.getResources().getColor(a.d.sdk_white_alpha0));
        this.nSp.setNeedAlphaShade(true);
        this.nSr.setShowOval(true);
        this.nSr.setStrokeColorResId(a.d.sdk_white_alpha100);
        this.nSr.setAutoChangeStyle(false);
        this.nSr.setStrokeWith(BdUtilHelper.dip2px(this.mActivity, 2.0f));
        this.nSq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aEc != null && f.this.aEc.aIS != null) {
                    new com.baidu.tieba.yuyinala.liveroom.rename.c(f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.rename.c.a
                        public void call(String str) {
                            f.this.nSu.setText(str);
                            f.this.nRW.room_name = str;
                        }
                    }).P(f.this.aEc);
                }
            }
        });
        this.nSo.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.e.sdk_ds0));
        this.bKe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aEc.aIS.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aEc.aIS.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgS() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getContext());
            return;
        }
        dismiss();
        if (this.aEc != null && this.aEc.aIS != null) {
            z zVar = new z(getContext());
            zVar.ah(this.aEc.aIS.live_id, this.aEc.aIS.aRy);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, zVar));
        }
    }

    private void Vb(String str) {
        this.nSC.request(str);
        this.nSC.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.11
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
        if (alaGetRoomCardInfoHttpResponseMessage != null && alaGetRoomCardInfoHttpResponseMessage.dVA() != null) {
            this.nRW = alaGetRoomCardInfoHttpResponseMessage.dVA();
            this.nSu.setText(this.nRW.room_name);
            if (!TextUtils.isEmpty(this.nRW.nSk)) {
                this.nSr.startLoad(this.nRW.nSk, 12, false, false);
            }
            this.iNE.setText("粉丝：" + StringHelper.formatYuyinValue(this.nRW.nSi));
            this.nSv.setText("房间ID：" + this.nRW.nSj);
            if (this.nRW.nSh == null || this.nRW.nSh.size() == 0) {
                this.nSw.setText("管理员：0人");
            } else {
                this.nSw.setText("管理员：" + this.nRW.nSh.size() + "人");
            }
            if (this.nRW.nSd == 1) {
                this.nSt.setVisibility(0);
            } else {
                this.nSt.setVisibility(8);
            }
            if (this.nRW != null && this.nRW.nSc == 1) {
                this.nSD.setVisibility(0);
            } else {
                this.nSD.setVisibility(8);
            }
            if (this.nRW.nSh != null && this.nRW.nSh.size() > 0) {
                this.nSA.gc(this.nRW.nSh);
                this.nSA.notifyDataSetChanged();
            }
            if (this.nRW.nSg == null || this.nRW.nSg.size() == 0) {
                this.nSx.setText("主持：0人");
                ArrayList arrayList = new ArrayList();
                e.a aVar = new e.a();
                aVar.nSn = true;
                aVar.nSl = 3;
                arrayList.add(aVar);
                this.nSB.gc(arrayList);
                this.nSB.notifyDataSetChanged();
            } else {
                this.nSx.setText("主持：" + this.nRW.nSg.size() + "人");
            }
            if (this.nRW.nSg != null && this.nRW.nSg.size() > 0) {
                this.nSB.gc(this.nRW.nSg);
                this.nSB.notifyDataSetChanged();
            }
            this.isFollowed = this.nRW.nSf == 1;
            this.nSe = this.nRW.nSe;
            yL(this.nRW.nSf == 1);
            if (this.nRW.nSc == 1) {
                this.nSq.setVisibility(0);
            } else {
                this.nSq.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yL(boolean z) {
        if (z) {
            this.nSy.setText("已收藏");
            this.nSy.setBackgroundResource(a.f.yuyin_ala_room_card_uncollect_bg);
            this.nSy.setTextColor(getContext().getResources().getColor(a.d.sdk_color_858585));
            this.nSy.setVisibility(0);
            this.nSz.setVisibility(4);
            return;
        }
        this.nSy.setText("收藏本房间");
        this.nSy.setBackgroundResource(a.f.yuyin_ala_room_card_collect_bg);
        this.nSy.setTextColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
        this.nSy.setVisibility(0);
        this.nSz.setVisibility(0);
        this.nSz.setText(this.nSe);
    }

    public void S(w wVar) {
        this.aEc = wVar;
        try {
            show();
            if (this.aEc != null && this.aEc.aIS != null) {
                Vb(this.aEc.aIS.aRy);
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
    public void cfD() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mActivity, "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HF(final String str) {
        if (this.nRR != null && this.aEc != null && this.aEc.aIS != null) {
            this.nRR.f(this.aEc.aIS.aRy, 2, this.aEc.aIS.live_id, str);
            this.nRR.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.2
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    l.a(f.this.nSr, str, true, false);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mActivity, ExtraParamsManager.getDecryptUserId(aVar.user_uk) + "", aVar.user_name, aVar.nSm, 0, 0, null, null, 0L, 0L, 0L, 0, "", this.aEc.aIS.live_id, false, "", null, aVar.user_name, "")));
        }
    }
}
