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
    private w aFN;
    private View bTg;
    public CustomMessageListener bgy;
    private CommonEmptyView btg;
    private boolean isFollowed;
    private TextView jfj;
    private Activity mActivity;
    private h ojW;
    private com.baidu.tieba.yuyinala.liveroom.rename.e opI;
    private e opN;
    private String opV;
    private AlphaGradientHListView oqf;
    private AlphaGradientHListView oqg;
    private ImageView oqh;
    private BarImageView oqi;
    private TextView oqj;
    private TextView oqk;
    private TextView oql;
    private TextView oqm;
    private TextView oqn;
    private TextView oqo;
    private TextView oqp;
    private TextView oqq;
    private d oqr;
    private d oqs;
    private g oqt;
    private ImageView oqu;

    public f(Activity activity) {
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
        this.ojW = new h(activity);
        init();
    }

    private void init() {
        initView();
        Zo();
    }

    private void Zo() {
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
        this.btg = (CommonEmptyView) findViewById(a.f.empty_yuyin_view);
        this.bTg = findViewById(a.f.view);
        this.oqh = (ImageView) findViewById(a.f.iv_rename);
        this.oqi = (BarImageView) findViewById(a.f.user_portrait);
        this.oqj = (TextView) findViewById(a.f.tv_report);
        this.oqk = (TextView) findViewById(a.f.tv_banded_post);
        this.oql = (TextView) findViewById(a.f.room_name);
        this.jfj = (TextView) findViewById(a.f.tv_fans_num);
        this.oqm = (TextView) findViewById(a.f.tv_id);
        this.oqu = (ImageView) findViewById(a.f.iv_modify_img);
        this.oqn = (TextView) findViewById(a.f.tv_manager_count);
        this.oqo = (TextView) findViewById(a.f.tv_zhuchi_count);
        this.oqp = (TextView) findViewById(a.f.tv_collect_room);
        this.oqq = (TextView) findViewById(a.f.tv_bottom_toast);
        this.oqf = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.oqg = (AlphaGradientHListView) findViewById(a.f.ala_live_zhuchi_listview);
        this.oqt = new g(this.mActivity);
        this.opI = new com.baidu.tieba.yuyinala.liveroom.rename.e(this.mActivity);
        this.oqr = new d(this.mActivity);
        this.oqf.setAdapter((ListAdapter) this.oqr);
        this.oqf.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        MessageManager.getInstance().registerListener(this.bgy);
        this.oqf.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> edU;
                e.a aVar;
                if (f.this.oqr != null && (edU = f.this.oqr.edU()) != null && edU.size() > 0 && (aVar = edU.get(i)) != null && !aVar.oqe) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.oqi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.opN != null && f.this.opN.opT != 0) {
                    c.edT().a(f.this.mActivity, f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.c.a
                        public void zE(boolean z) {
                            if (z && f.this.opN != null && f.this.opN.opT == 1) {
                                f.this.clt();
                            }
                        }
                    });
                }
            }
        });
        this.oqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (f.this.aFN != null) {
                        f.this.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinBannedPostActivityConfig(f.this.mActivity, String.valueOf(f.this.aFN.aKL.aUg), String.valueOf(f.this.aFN.aKL.live_id), Long.toString(f.this.aFN.mLiveInfo.group_id))));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.oqj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cmH();
            }
        });
        this.oqp.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oqp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.edB();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(f.this.mActivity);
                } else if (f.this.aFN != null && f.this.aFN.aKL != null) {
                    if (f.this.isFollowed) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g gVar = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(f.this.mActivity);
                        gVar.show();
                        gVar.setText("确认取消收藏本房间吗");
                        gVar.Wn("算了");
                        gVar.bV("确认", a.c.sdk_color_ff1e66);
                        gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onCancel() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onConfirm() {
                                f.this.ojW.w(f.this.aFN.aKL.aUg, f.this.aFN.aKL.live_id, 0);
                            }
                        });
                    } else {
                        f.this.ojW.w(f.this.aFN.aKL.aUg, f.this.aFN.aKL.live_id, 1);
                    }
                    f.this.ojW.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = false;
                                f.this.zF(false);
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(false, f.this.aFN.aKL.live_id)));
                                return;
                            }
                            f.this.edC();
                            f.this.isFollowed = true;
                            f.this.zF(true);
                            BdUtilHelper.showToast(f.this.mActivity, "收藏成功，将收到房间的开播提醒", 3000);
                            MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, f.this.aFN.aKL.live_id)));
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
        this.oqf.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.oqf.setNeedAlphaShade(true);
        this.oqg.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.oqs = new d(this.mActivity);
        this.oqg.setAdapter((ListAdapter) this.oqs);
        this.oqg.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oqg.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.8
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> edU;
                e.a aVar;
                if (f.this.oqs != null && (edU = f.this.oqs.edU()) != null && edU.size() > 0 && (aVar = edU.get(i)) != null && !aVar.oqe) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.oqg.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.oqg.setNeedAlphaShade(true);
        this.oqi.setShowOval(true);
        this.oqi.setStrokeColorResId(a.c.sdk_white_alpha100);
        this.oqi.setAutoChangeStyle(false);
        this.oqi.setStrokeWith(BdUtilHelper.dip2px(this.mActivity, 2.0f));
        this.oqh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aFN != null && f.this.aFN.aKL != null) {
                    new com.baidu.tieba.yuyinala.liveroom.rename.c(f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.rename.c.a
                        public void call(String str) {
                            f.this.oql.setText(str);
                            f.this.opN.room_name = str;
                        }
                    }).ac(f.this.aFN);
                }
            }
        });
        this.oqf.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bTg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
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
        if (this.aFN != null && this.aFN.aKL != null) {
            aa aaVar = new aa(getContext());
            aaVar.am(this.aFN.aKL.live_id, this.aFN.aKL.aUg);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, aaVar));
        }
    }

    private void Ws(String str) {
        this.oqt.request(str);
        this.oqt.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.11
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
        if (alaGetRoomCardInfoHttpResponseMessage != null && alaGetRoomCardInfoHttpResponseMessage.edS() != null) {
            this.opN = alaGetRoomCardInfoHttpResponseMessage.edS();
            if (this.opN != null) {
                this.oql.setText(this.opN.room_name);
                if (!TextUtils.isEmpty(this.opN.oqb)) {
                    this.oqi.startLoad(this.opN.oqb, 12, false, false);
                }
                this.jfj.setText("粉丝：" + StringHelper.formatYuyinValue(this.opN.opZ));
                this.oqm.setText("房间ID：" + this.opN.oqa);
                if (this.opN.opY == null || this.opN.opY.size() == 0) {
                    this.oqn.setText("管理员：0人");
                } else {
                    this.oqn.setText("管理员：" + this.opN.opY.size() + "人");
                }
                if (this.opN.opU == 1) {
                    this.oqk.setVisibility(0);
                } else {
                    this.oqk.setVisibility(8);
                }
                if (this.opN != null && this.opN.opT == 1) {
                    this.oqu.setVisibility(0);
                } else {
                    this.oqu.setVisibility(8);
                }
                if (this.opN.opY != null && this.opN.opY.size() > 0) {
                    this.oqr.gy(this.opN.opY);
                    this.oqr.notifyDataSetChanged();
                }
                if (this.opN.opX == null || this.opN.opX.size() == 0) {
                    this.oqo.setText("主持：0人");
                    ArrayList arrayList = new ArrayList();
                    e.a aVar = new e.a();
                    aVar.oqe = true;
                    aVar.oqc = 3;
                    arrayList.add(aVar);
                    this.oqs.gy(arrayList);
                    this.oqs.notifyDataSetChanged();
                } else {
                    this.oqo.setText("主持：" + this.opN.opX.size() + "人");
                }
                if (this.opN.opX != null && this.opN.opX.size() > 0) {
                    this.oqs.gy(this.opN.opX);
                    this.oqs.notifyDataSetChanged();
                }
                this.isFollowed = this.opN.opW == 1;
                this.opV = this.opN.opV;
                zF(this.opN.opW == 1);
                if (this.opN.opT == 1) {
                    this.oqh.setVisibility(0);
                } else {
                    this.oqh.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(boolean z) {
        if (z) {
            this.oqp.setText("已收藏");
            this.oqp.setBackgroundResource(a.e.yuyin_ala_room_card_uncollect_bg);
            this.oqp.setTextColor(getContext().getResources().getColor(a.c.sdk_color_858585));
            this.oqp.setVisibility(0);
            this.oqq.setVisibility(0);
            this.oqq.setText(this.opV);
            return;
        }
        this.oqp.setText("收藏本房间");
        this.oqp.setBackgroundResource(a.e.yuyin_ala_room_card_collect_bg);
        this.oqp.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        this.oqp.setVisibility(0);
        this.oqq.setVisibility(0);
        this.oqq.setText(this.opV);
    }

    public void ae(w wVar) {
        this.aFN = wVar;
        try {
            show();
            if (this.aFN != null && this.aFN.aKL != null) {
                Ws(this.aFN.aKL.aUg);
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
    public void clt() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mActivity, "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void In(final String str) {
        if (this.opI != null && this.aFN != null && this.aFN.aKL != null) {
            this.opI.f(this.aFN.aKL.aUg, 2, this.aFN.aKL.live_id, str);
            this.opI.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.2
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    l.a(f.this.oqi, str, true, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinModifyRoomMessage(new ModifyRoomCover(str)));
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void p(int i, String str2, String str3) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e.a aVar) {
        if (aVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mActivity, ExtraParamsManager.getDecryptUserId(aVar.user_uk) + "", aVar.user_name, aVar.oqd, 0, 0, null, null, 0L, 0L, 0L, 0, "", this.aFN.aKL.live_id, false, "", null, aVar.user_name, "")));
        }
    }
}
