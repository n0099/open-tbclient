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
import com.baidu.live.d.aa;
import com.baidu.live.data.x;
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
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends Dialog {
    private x aGe;
    private View bYQ;
    public CustomMessageListener bih;
    private CommonEmptyView bxT;
    private AlaLoadingView ceG;
    private boolean isFollowed;
    private TextView jrK;
    private Activity mActivity;
    private h olL;
    private ImageView otA;
    private ImageView otB;
    private BarImageView otC;
    private TextView otD;
    private TextView otE;
    private TextView otF;
    private TextView otG;
    private View otH;
    private TextView otI;
    private TextView otJ;
    private TextView otK;
    private d otL;
    private d otM;
    private g otN;
    private ImageView otO;
    private AlaLoadingButton otP;
    private com.baidu.tieba.yuyinala.liveroom.rename.e ota;
    private e otf;
    private String otn;
    private AlphaGradientHListView otx;
    private ImageView oty;
    private AlphaGradientHListView otz;

    public f(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.isFollowed = false;
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    f.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        this.olL = new h(activity);
        init();
    }

    private void init() {
        initView();
        aaE();
    }

    private void aaE() {
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
        this.bxT = (CommonEmptyView) findViewById(a.f.empty_yuyin_view);
        this.ceG = (AlaLoadingView) findViewById(a.f.loading_view);
        this.bYQ = findViewById(a.f.view);
        this.otB = (ImageView) findViewById(a.f.iv_rename);
        this.otC = (BarImageView) findViewById(a.f.user_portrait);
        this.otD = (TextView) findViewById(a.f.tv_report);
        this.otE = (TextView) findViewById(a.f.tv_banded_post);
        this.otF = (TextView) findViewById(a.f.room_name);
        this.jrK = (TextView) findViewById(a.f.tv_fans_num);
        this.otH = findViewById(a.f.view_divider_line);
        this.otG = (TextView) findViewById(a.f.tv_id);
        this.otO = (ImageView) findViewById(a.f.iv_modify_img);
        this.otI = (TextView) findViewById(a.f.tv_manager_count);
        this.otJ = (TextView) findViewById(a.f.tv_zhuchi_count);
        this.otK = (TextView) findViewById(a.f.tv_bottom_toast);
        this.otx = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.oty = (ImageView) findViewById(a.f.ala_live_manager_listview_bg);
        this.otz = (AlphaGradientHListView) findViewById(a.f.ala_live_zhuchi_listview);
        this.otA = (ImageView) findViewById(a.f.ala_live_zhuchi_listview_bg);
        this.otP = (AlaLoadingButton) findViewById(a.f.btn_collect_room);
        this.otN = new g(this.mActivity);
        this.ota = new com.baidu.tieba.yuyinala.liveroom.rename.e(this.mActivity);
        this.otL = new d(this.mActivity);
        this.otx.setAdapter((ListAdapter) this.otL);
        this.otx.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        MessageManager.getInstance().registerListener(this.bih);
        this.otx.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> edo;
                e.a aVar;
                if (f.this.otL != null && (edo = f.this.otL.edo()) != null && edo.size() > 0 && (aVar = edo.get(i)) != null && !aVar.otw) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.otC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.otf != null && f.this.otf.otl != 0) {
                    c.edn().a(f.this.mActivity, f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.c.a
                        public void zE(boolean z) {
                            if (z && f.this.otf != null && f.this.otf.otl == 1) {
                                f.this.com();
                            }
                        }
                    });
                }
            }
        });
        this.otE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (f.this.aGe != null) {
                        f.this.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinBannedPostActivityConfig(f.this.mActivity, String.valueOf(f.this.aGe.aLl.aVu), String.valueOf(f.this.aGe.aLl.live_id), Long.toString(f.this.aGe.mLiveInfo.group_id))));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.otD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cpB();
            }
        });
        this.otP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ecU();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(f.this.mActivity);
                } else if (f.this.aGe != null && f.this.aGe.aLl != null) {
                    if (f.this.isFollowed) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g gVar = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(f.this.mActivity);
                        gVar.show();
                        gVar.setText("确认不收藏该房间了么");
                        gVar.cc(PayHelper.STATUS_CANCEL_DESC, a.c.sdk_color_ff1e66);
                        gVar.cd("确认", a.c.sdk_black_alpha100);
                        gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onCancel() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onConfirm() {
                                f.this.olL.y(f.this.aGe.aLl.aVu, f.this.aGe.aLl.live_id, 0);
                                f.this.otP.setStatus(3);
                            }
                        });
                    } else {
                        f.this.olL.y(f.this.aGe.aLl.aVu, f.this.aGe.aLl.live_id, 1);
                        f.this.otP.setStatus(3);
                    }
                    f.this.olL.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = false;
                                f.this.zF(false);
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(false, f.this.aGe.aLl.live_id)));
                                return;
                            }
                            f.this.ecR();
                            f.this.isFollowed = true;
                            f.this.zF(true);
                            BdUtilHelper.showToast(f.this.mActivity, "收藏成功，将收到房间的开播提醒", 3000);
                            MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, f.this.aGe.aLl.live_id)));
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = true;
                            } else {
                                BdUtilHelper.showToast(f.this.mActivity, "房间收藏失败", 3000);
                                f.this.isFollowed = false;
                            }
                            f.this.zF(f.this.isFollowed);
                        }
                    });
                }
            }
        });
        this.otx.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.otx.setNeedAlphaShade(true);
        this.otz.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.otM = new d(this.mActivity);
        this.otz.setAdapter((ListAdapter) this.otM);
        this.otz.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.otz.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.8
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> edo;
                e.a aVar;
                if (f.this.otM != null && (edo = f.this.otM.edo()) != null && edo.size() > 0 && (aVar = edo.get(i)) != null && !aVar.otw) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.otz.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.otz.setNeedAlphaShade(true);
        this.otC.setShowOval(true);
        this.otC.setStrokeColorResId(a.c.sdk_white_alpha100);
        this.otC.setAutoChangeStyle(false);
        this.otC.setStrokeWith(BdUtilHelper.dip2px(this.mActivity, 2.0f));
        this.otB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aGe != null && f.this.aGe.aLl != null) {
                    new com.baidu.tieba.yuyinala.liveroom.rename.c(f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.rename.c.a
                        public void call(String str) {
                            f.this.otF.setText(str);
                            f.this.otf.room_name = str;
                        }
                    }).af(f.this.aGe);
                }
            }
        });
        this.otx.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecU() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpB() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getContext());
            return;
        }
        dismiss();
        if (this.aGe != null && this.aGe.aLl != null) {
            aa aaVar = new aa(getContext());
            aaVar.al(this.aGe.aLl.live_id, this.aGe.aLl.aVu);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, aaVar));
        }
    }

    private void VY(String str) {
        this.otN.request(str);
        this.ceG.setVisibility(0);
        this.otN.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.11
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void b(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
                f.this.otA.setVisibility(8);
                f.this.oty.setVisibility(8);
                f.this.otx.setVisibility(0);
                f.this.otz.setVisibility(0);
                f.this.ceG.setVisibility(8);
                f.this.a(alaGetRoomCardInfoHttpResponseMessage);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void onFail(int i, String str2) {
                f.this.ceG.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
        if (alaGetRoomCardInfoHttpResponseMessage != null && alaGetRoomCardInfoHttpResponseMessage.edm() != null) {
            this.otf = alaGetRoomCardInfoHttpResponseMessage.edm();
            if (this.otf != null) {
                this.otF.setText(this.otf.room_name);
                if (!TextUtils.isEmpty(this.otf.ott)) {
                    this.otC.startLoad(this.otf.ott, 12, false, false);
                }
                this.jrK.setText("粉丝：" + StringHelper.formatYuyinValue(this.otf.otr));
                this.otG.setText("房间ID：" + this.otf.ots);
                this.otH.setVisibility(0);
                if (this.otf.otq == null || this.otf.otq.size() == 0) {
                    this.otI.setText("管理员：0人");
                } else {
                    this.otI.setText("管理员：" + this.otf.otq.size() + "人");
                }
                if (this.otf.otm == 1) {
                    this.otE.setVisibility(0);
                } else {
                    this.otE.setVisibility(8);
                }
                if (this.otf != null && this.otf.otl == 1) {
                    this.otO.setVisibility(0);
                } else {
                    this.otO.setVisibility(8);
                }
                if (this.otf.otq != null && this.otf.otq.size() > 0) {
                    this.otL.gq(this.otf.otq);
                    this.otL.notifyDataSetChanged();
                }
                if (this.otf.otp == null || this.otf.otp.size() == 0) {
                    this.otJ.setText("主持：0人");
                    ArrayList arrayList = new ArrayList();
                    e.a aVar = new e.a();
                    aVar.otw = true;
                    aVar.otu = 3;
                    arrayList.add(aVar);
                    this.otM.gq(arrayList);
                    this.otM.notifyDataSetChanged();
                } else {
                    this.otJ.setText("主持：" + this.otf.otp.size() + "人");
                }
                if (this.otf.otp != null && this.otf.otp.size() > 0) {
                    this.otM.gq(this.otf.otp);
                    this.otM.notifyDataSetChanged();
                }
                this.isFollowed = this.otf.oto == 1;
                this.otn = this.otf.otn;
                this.otK.setText(this.otn);
                zF(this.otf.oto == 1);
                if (this.otf.otl == 1) {
                    this.otB.setVisibility(0);
                } else {
                    this.otB.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(boolean z) {
        if (z) {
            this.otP.setStatus(4);
        } else {
            this.otP.setStatus(1);
        }
    }

    public void ai(x xVar) {
        this.aGe = xVar;
        try {
            show();
            if (this.aGe != null && this.aGe.aLl != null) {
                VY(this.aGe.aLl.aVu);
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
    public void com() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mActivity, "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Io(final String str) {
        if (this.ota != null && this.aGe != null && this.aGe.aLl != null) {
            this.ota.f(this.aGe.aLl.aVu, 2, this.aGe.aLl.live_id, str);
            this.ota.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.2
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    m.a(f.this.otC, str, true, false);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mActivity, ExtraParamsManager.getDecryptUserId(aVar.user_uk) + "", aVar.user_name, aVar.otv, 0, 0, null, null, 0L, 0L, 0L, 0, "", this.aGe.aLl.live_id, false, "", null, aVar.user_name, "")));
        }
    }
}
