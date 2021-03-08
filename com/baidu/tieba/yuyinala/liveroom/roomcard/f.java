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
/* loaded from: classes10.dex */
public class f extends Dialog {
    private ab aED;
    private View bZD;
    public CustomMessageListener bhY;
    private CommonEmptyView byj;
    private AlaLoadingView cfw;
    private boolean isFollowed;
    private TextView juH;
    private Activity mActivity;
    private com.baidu.tieba.yuyinala.liveroom.rename.e oAP;
    private e oAU;
    private TextView oBA;
    private d oBB;
    private d oBC;
    private g oBD;
    private ImageView oBE;
    private AlaLoadingButton oBF;
    private String oBc;
    private AlphaGradientHListView oBm;
    private ImageView oBn;
    private AlphaGradientHListView oBo;
    private ImageView oBp;
    private ImageView oBq;
    private BarImageView oBr;
    private TextView oBs;
    private TextView oBt;
    private TextView oBu;
    private TextView oBv;
    private View oBw;
    private TextView oBx;
    private TextView oBy;
    private LinearLayout oBz;
    private h otG;

    public f(Activity activity, ab abVar) {
        super(activity, a.i.DialogRoomcardStyle);
        this.isFollowed = false;
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    f.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        this.otG = new h(activity);
        this.aED = abVar;
        init();
    }

    private void init() {
        initView();
        YE();
    }

    private void YE() {
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
        this.byj = (CommonEmptyView) findViewById(a.f.empty_yuyin_view);
        this.cfw = (AlaLoadingView) findViewById(a.f.loading_view);
        this.bZD = findViewById(a.f.view);
        this.oBq = (ImageView) findViewById(a.f.iv_rename);
        this.oBr = (BarImageView) findViewById(a.f.user_portrait);
        this.oBs = (TextView) findViewById(a.f.tv_report);
        this.oBt = (TextView) findViewById(a.f.tv_banded_post);
        this.oBu = (TextView) findViewById(a.f.room_name);
        this.juH = (TextView) findViewById(a.f.tv_fans_num);
        this.oBw = findViewById(a.f.view_divider_line);
        this.oBv = (TextView) findViewById(a.f.tv_id);
        this.oBE = (ImageView) findViewById(a.f.iv_modify_img);
        this.oBx = (TextView) findViewById(a.f.tv_manager_count);
        this.oBz = (LinearLayout) findViewById(a.f.ll_zhuchi_count);
        this.oBy = (TextView) findViewById(a.f.tv_zhuchi_count);
        this.oBA = (TextView) findViewById(a.f.tv_bottom_toast);
        this.oBm = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.oBn = (ImageView) findViewById(a.f.ala_live_manager_listview_bg);
        this.oBo = (AlphaGradientHListView) findViewById(a.f.ala_live_zhuchi_listview);
        this.oBp = (ImageView) findViewById(a.f.ala_live_zhuchi_listview_bg);
        this.oBF = (AlaLoadingButton) findViewById(a.f.btn_collect_room);
        this.oBD = new g(this.mActivity);
        this.oAP = new com.baidu.tieba.yuyinala.liveroom.rename.e(this.mActivity);
        this.oBB = new d(this.mActivity);
        this.oBm.setAdapter((ListAdapter) this.oBB);
        this.oBm.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        MessageManager.getInstance().registerListener(this.bhY);
        this.oBm.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> ebZ;
                e.a aVar;
                if (f.this.oBB != null && (ebZ = f.this.oBB.ebZ()) != null && ebZ.size() > 0 && (aVar = ebZ.get(i)) != null && !aVar.oBl) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.oBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.oAU != null && f.this.oAU.oBa != 0) {
                    c.ebY().a(f.this.mActivity, f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.c.a
                        public void zV(boolean z) {
                            if (z && f.this.oAU != null && f.this.oAU.oBa == 1) {
                                f.this.clF();
                            }
                        }
                    });
                }
            }
        });
        this.oBt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (f.this.aED != null) {
                        f.this.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinBannedPostActivityConfig(f.this.mActivity, String.valueOf(f.this.aED.aKu.aVk), String.valueOf(f.this.aED.aKu.live_id), Long.toString(f.this.aED.mLiveInfo.group_id))));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.oBs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cmU();
            }
        });
        this.oBF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.ebE();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(f.this.mActivity);
                } else if (f.this.aED != null && f.this.aED.aKu != null) {
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
                                f.this.otG.y(f.this.aED.aKu.aVk, f.this.aED.aKu.live_id, 0);
                                f.this.oBF.setStatus(3);
                            }
                        });
                    } else {
                        f.this.otG.y(f.this.aED.aKu.aVk, f.this.aED.aKu.live_id, 1);
                        f.this.oBF.setStatus(3);
                    }
                    f.this.otG.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = false;
                                f.this.zW(false);
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(false, f.this.aED.aKu.live_id)));
                                return;
                            }
                            f.this.ebB();
                            f.this.isFollowed = true;
                            f.this.zW(true);
                            BdUtilHelper.showToast(f.this.mActivity, "收藏成功，将收到房间的开播提醒", 3000);
                            MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, f.this.aED.aKu.live_id)));
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = true;
                            } else {
                                BdUtilHelper.showToast(f.this.mActivity, "房间收藏失败", 3000);
                                f.this.isFollowed = false;
                            }
                            f.this.zW(f.this.isFollowed);
                        }
                    });
                }
            }
        });
        this.oBm.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.oBm.setNeedAlphaShade(true);
        this.oBo.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.oBC = new d(this.mActivity);
        this.oBo.setAdapter((ListAdapter) this.oBC);
        this.oBo.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oBo.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.8
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> ebZ;
                e.a aVar;
                if (f.this.oBC != null && (ebZ = f.this.oBC.ebZ()) != null && ebZ.size() > 0 && (aVar = ebZ.get(i)) != null && !aVar.oBl) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.oBo.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.oBo.setNeedAlphaShade(true);
        this.oBr.setShowOval(true);
        this.oBr.setStrokeColorResId(a.c.sdk_white_alpha100);
        this.oBr.setAutoChangeStyle(false);
        this.oBr.setStrokeWith(BdUtilHelper.dip2px(this.mActivity, 2.0f));
        this.oBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aED != null && f.this.aED.aKu != null) {
                    new com.baidu.tieba.yuyinala.liveroom.rename.c(f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.rename.c.a
                        public void call(String str) {
                            f.this.oBu.setText(str);
                            f.this.oAU.room_name = str;
                        }
                    }).ae(f.this.aED);
                }
            }
        });
        this.oBm.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bZD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
        if (this.aED.aKu.aVu == 1) {
            this.oBz.setVisibility(0);
        } else {
            this.oBz.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebE() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getContext());
            return;
        }
        dismiss();
        if (this.aED != null && this.aED.aKu != null) {
            aa aaVar = new aa(getContext());
            aaVar.ak(this.aED.aKu.live_id, this.aED.aKu.aVk);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, aaVar));
        }
    }

    private void Wi(String str) {
        this.oBD.request(str);
        this.cfw.setVisibility(0);
        this.oBD.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.11
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void b(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
                f.this.oBp.setVisibility(8);
                f.this.oBn.setVisibility(8);
                f.this.oBm.setVisibility(0);
                f.this.oBo.setVisibility(0);
                f.this.cfw.setVisibility(8);
                f.this.a(alaGetRoomCardInfoHttpResponseMessage);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void onFail(int i, String str2) {
                f.this.cfw.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
        if (alaGetRoomCardInfoHttpResponseMessage != null && alaGetRoomCardInfoHttpResponseMessage.ebX() != null) {
            this.oAU = alaGetRoomCardInfoHttpResponseMessage.ebX();
            if (this.oAU != null) {
                this.oBu.setText(this.oAU.room_name);
                if (!TextUtils.isEmpty(this.oAU.oBi)) {
                    this.oBr.startLoad(this.oAU.oBi, 12, false, false);
                }
                this.juH.setText("粉丝：" + StringHelper.formatYuyinValue(this.oAU.oBg));
                this.oBv.setText("房间ID：" + this.oAU.oBh);
                this.oBw.setVisibility(0);
                if (this.oAU.oBf == null || this.oAU.oBf.size() == 0) {
                    this.oBx.setText("管理员：0人");
                } else {
                    this.oBx.setText("管理员：" + this.oAU.oBf.size() + "人");
                }
                if (this.oAU.oBb == 1) {
                    this.oBt.setVisibility(0);
                } else {
                    this.oBt.setVisibility(8);
                }
                if (this.oAU != null && this.oAU.oBa == 1) {
                    this.oBE.setVisibility(0);
                } else {
                    this.oBE.setVisibility(8);
                }
                if (this.oAU.oBf != null && this.oAU.oBf.size() > 0) {
                    this.oBB.go(this.oAU.oBf);
                    this.oBB.notifyDataSetChanged();
                }
                if (this.oAU.oBe == null || this.oAU.oBe.size() == 0) {
                    this.oBy.setText("主持：0人");
                    ArrayList arrayList = new ArrayList();
                    e.a aVar = new e.a();
                    aVar.oBl = true;
                    aVar.oBj = 3;
                    arrayList.add(aVar);
                    this.oBC.go(arrayList);
                    this.oBC.notifyDataSetChanged();
                    this.oBz.setVisibility(8);
                } else {
                    this.oBz.setVisibility(0);
                    this.oBy.setText("主持：" + this.oAU.oBe.size() + "人");
                }
                if (this.oAU.oBe != null && this.oAU.oBe.size() > 0) {
                    this.oBC.go(this.oAU.oBe);
                    this.oBC.notifyDataSetChanged();
                }
                this.isFollowed = this.oAU.oBd == 1;
                this.oBc = this.oAU.oBc;
                this.oBA.setText(this.oBc);
                zW(this.oAU.oBd == 1);
                if (this.oAU.oBa == 1) {
                    this.oBq.setVisibility(0);
                } else {
                    this.oBq.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zW(boolean z) {
        if (z) {
            this.oBF.setStatus(4);
        } else {
            this.oBF.setStatus(1);
        }
    }

    public void ai(ab abVar) {
        this.aED = abVar;
        try {
            show();
            if (this.aED != null && this.aED.aKu != null) {
                Wi(this.aED.aKu.aVk);
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
    public void clF() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mActivity, "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void HR(final String str) {
        if (this.oAP != null && this.aED != null && this.aED.aKu != null) {
            this.oAP.f(this.aED.aKu.aVk, 2, this.aED.aKu.live_id, str);
            this.oAP.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.2
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    m.a(f.this.oBr, str, true, false);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mActivity, ExtraParamsManager.getDecryptUserId(aVar.user_uk) + "", aVar.user_name, aVar.oBk, 0, 0, null, null, 0L, 0L, 0L, 0, "", this.aED.aKu.live_id, false, "", null, aVar.user_name, "")));
        }
    }
}
