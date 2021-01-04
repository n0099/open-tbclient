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
    private h olM;
    private AlphaGradientHListView otA;
    private ImageView otB;
    private ImageView otC;
    private BarImageView otD;
    private TextView otE;
    private TextView otF;
    private TextView otG;
    private TextView otH;
    private View otI;
    private TextView otJ;
    private TextView otK;
    private TextView otL;
    private d otM;
    private d otN;
    private g otO;
    private ImageView otP;
    private AlaLoadingButton otQ;
    private com.baidu.tieba.yuyinala.liveroom.rename.e otb;
    private e otg;
    private String oto;
    private AlphaGradientHListView oty;
    private ImageView otz;

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
        this.olM = new h(activity);
        init();
    }

    private void init() {
        initView();
        aaD();
    }

    private void aaD() {
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
        this.otC = (ImageView) findViewById(a.f.iv_rename);
        this.otD = (BarImageView) findViewById(a.f.user_portrait);
        this.otE = (TextView) findViewById(a.f.tv_report);
        this.otF = (TextView) findViewById(a.f.tv_banded_post);
        this.otG = (TextView) findViewById(a.f.room_name);
        this.jrK = (TextView) findViewById(a.f.tv_fans_num);
        this.otI = findViewById(a.f.view_divider_line);
        this.otH = (TextView) findViewById(a.f.tv_id);
        this.otP = (ImageView) findViewById(a.f.iv_modify_img);
        this.otJ = (TextView) findViewById(a.f.tv_manager_count);
        this.otK = (TextView) findViewById(a.f.tv_zhuchi_count);
        this.otL = (TextView) findViewById(a.f.tv_bottom_toast);
        this.oty = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.otz = (ImageView) findViewById(a.f.ala_live_manager_listview_bg);
        this.otA = (AlphaGradientHListView) findViewById(a.f.ala_live_zhuchi_listview);
        this.otB = (ImageView) findViewById(a.f.ala_live_zhuchi_listview_bg);
        this.otQ = (AlaLoadingButton) findViewById(a.f.btn_collect_room);
        this.otO = new g(this.mActivity);
        this.otb = new com.baidu.tieba.yuyinala.liveroom.rename.e(this.mActivity);
        this.otM = new d(this.mActivity);
        this.oty.setAdapter((ListAdapter) this.otM);
        this.oty.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        MessageManager.getInstance().registerListener(this.bih);
        this.oty.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> edn;
                e.a aVar;
                if (f.this.otM != null && (edn = f.this.otM.edn()) != null && edn.size() > 0 && (aVar = edn.get(i)) != null && !aVar.otx) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.otD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.otg != null && f.this.otg.otm != 0) {
                    c.edm().a(f.this.mActivity, f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.c.a
                        public void zE(boolean z) {
                            if (z && f.this.otg != null && f.this.otg.otm == 1) {
                                f.this.col();
                            }
                        }
                    });
                }
            }
        });
        this.otF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.5
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
        this.otE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cpA();
            }
        });
        this.otQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ecT();
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
                                f.this.olM.y(f.this.aGe.aLl.aVu, f.this.aGe.aLl.live_id, 0);
                                f.this.otQ.setStatus(3);
                            }
                        });
                    } else {
                        f.this.olM.y(f.this.aGe.aLl.aVu, f.this.aGe.aLl.live_id, 1);
                        f.this.otQ.setStatus(3);
                    }
                    f.this.olM.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = false;
                                f.this.zF(false);
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(false, f.this.aGe.aLl.live_id)));
                                return;
                            }
                            f.this.ecQ();
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
        this.oty.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.oty.setNeedAlphaShade(true);
        this.otA.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.otN = new d(this.mActivity);
        this.otA.setAdapter((ListAdapter) this.otN);
        this.otA.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.otA.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.8
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> edn;
                e.a aVar;
                if (f.this.otN != null && (edn = f.this.otN.edn()) != null && edn.size() > 0 && (aVar = edn.get(i)) != null && !aVar.otx) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.otA.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.otA.setNeedAlphaShade(true);
        this.otD.setShowOval(true);
        this.otD.setStrokeColorResId(a.c.sdk_white_alpha100);
        this.otD.setAutoChangeStyle(false);
        this.otD.setStrokeWith(BdUtilHelper.dip2px(this.mActivity, 2.0f));
        this.otC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aGe != null && f.this.aGe.aLl != null) {
                    new com.baidu.tieba.yuyinala.liveroom.rename.c(f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.rename.c.a
                        public void call(String str) {
                            f.this.otG.setText(str);
                            f.this.otg.room_name = str;
                        }
                    }).af(f.this.aGe);
                }
            }
        });
        this.oty.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecT() {
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
    public void ecQ() {
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
    public void cpA() {
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

    private void VZ(String str) {
        this.otO.request(str);
        this.ceG.setVisibility(0);
        this.otO.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.11
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void b(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
                f.this.otB.setVisibility(8);
                f.this.otz.setVisibility(8);
                f.this.oty.setVisibility(0);
                f.this.otA.setVisibility(0);
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
        if (alaGetRoomCardInfoHttpResponseMessage != null && alaGetRoomCardInfoHttpResponseMessage.edl() != null) {
            this.otg = alaGetRoomCardInfoHttpResponseMessage.edl();
            if (this.otg != null) {
                this.otG.setText(this.otg.room_name);
                if (!TextUtils.isEmpty(this.otg.otu)) {
                    this.otD.startLoad(this.otg.otu, 12, false, false);
                }
                this.jrK.setText("粉丝：" + StringHelper.formatYuyinValue(this.otg.ots));
                this.otH.setText("房间ID：" + this.otg.ott);
                this.otI.setVisibility(0);
                if (this.otg.otr == null || this.otg.otr.size() == 0) {
                    this.otJ.setText("管理员：0人");
                } else {
                    this.otJ.setText("管理员：" + this.otg.otr.size() + "人");
                }
                if (this.otg.otn == 1) {
                    this.otF.setVisibility(0);
                } else {
                    this.otF.setVisibility(8);
                }
                if (this.otg != null && this.otg.otm == 1) {
                    this.otP.setVisibility(0);
                } else {
                    this.otP.setVisibility(8);
                }
                if (this.otg.otr != null && this.otg.otr.size() > 0) {
                    this.otM.gq(this.otg.otr);
                    this.otM.notifyDataSetChanged();
                }
                if (this.otg.otq == null || this.otg.otq.size() == 0) {
                    this.otK.setText("主持：0人");
                    ArrayList arrayList = new ArrayList();
                    e.a aVar = new e.a();
                    aVar.otx = true;
                    aVar.otv = 3;
                    arrayList.add(aVar);
                    this.otN.gq(arrayList);
                    this.otN.notifyDataSetChanged();
                } else {
                    this.otK.setText("主持：" + this.otg.otq.size() + "人");
                }
                if (this.otg.otq != null && this.otg.otq.size() > 0) {
                    this.otN.gq(this.otg.otq);
                    this.otN.notifyDataSetChanged();
                }
                this.isFollowed = this.otg.otp == 1;
                this.oto = this.otg.oto;
                this.otL.setText(this.oto);
                zF(this.otg.otp == 1);
                if (this.otg.otm == 1) {
                    this.otC.setVisibility(0);
                } else {
                    this.otC.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(boolean z) {
        if (z) {
            this.otQ.setStatus(4);
        } else {
            this.otQ.setStatus(1);
        }
    }

    public void ai(x xVar) {
        this.aGe = xVar;
        try {
            show();
            if (this.aGe != null && this.aGe.aLl != null) {
                VZ(this.aGe.aLl.aVu);
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
    public void col() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mActivity, "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Ip(final String str) {
        if (this.otb != null && this.aGe != null && this.aGe.aLl != null) {
            this.otb.f(this.aGe.aLl.aVu, 2, this.aGe.aLl.live_id, str);
            this.otb.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.2
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    m.a(f.this.otD, str, true, false);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mActivity, ExtraParamsManager.getDecryptUserId(aVar.user_uk) + "", aVar.user_name, aVar.otw, 0, 0, null, null, 0L, 0L, 0L, 0, "", this.aGe.aLl.live_id, false, "", null, aVar.user_name, "")));
        }
    }
}
