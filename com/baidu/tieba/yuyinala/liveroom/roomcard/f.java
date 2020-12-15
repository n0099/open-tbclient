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
    private TextView jfl;
    private Activity mActivity;
    private h ojY;
    private com.baidu.tieba.yuyinala.liveroom.rename.e opK;
    private e opP;
    private String opX;
    private AlphaGradientHListView oqh;
    private AlphaGradientHListView oqi;
    private ImageView oqj;
    private BarImageView oqk;
    private TextView oql;
    private TextView oqm;
    private TextView oqn;
    private TextView oqo;
    private TextView oqp;
    private TextView oqq;
    private TextView oqr;
    private TextView oqs;
    private d oqt;
    private d oqu;
    private g oqv;
    private ImageView oqw;

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
        this.ojY = new h(activity);
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
        this.oqj = (ImageView) findViewById(a.f.iv_rename);
        this.oqk = (BarImageView) findViewById(a.f.user_portrait);
        this.oql = (TextView) findViewById(a.f.tv_report);
        this.oqm = (TextView) findViewById(a.f.tv_banded_post);
        this.oqn = (TextView) findViewById(a.f.room_name);
        this.jfl = (TextView) findViewById(a.f.tv_fans_num);
        this.oqo = (TextView) findViewById(a.f.tv_id);
        this.oqw = (ImageView) findViewById(a.f.iv_modify_img);
        this.oqp = (TextView) findViewById(a.f.tv_manager_count);
        this.oqq = (TextView) findViewById(a.f.tv_zhuchi_count);
        this.oqr = (TextView) findViewById(a.f.tv_collect_room);
        this.oqs = (TextView) findViewById(a.f.tv_bottom_toast);
        this.oqh = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.oqi = (AlphaGradientHListView) findViewById(a.f.ala_live_zhuchi_listview);
        this.oqv = new g(this.mActivity);
        this.opK = new com.baidu.tieba.yuyinala.liveroom.rename.e(this.mActivity);
        this.oqt = new d(this.mActivity);
        this.oqh.setAdapter((ListAdapter) this.oqt);
        this.oqh.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        MessageManager.getInstance().registerListener(this.bgy);
        this.oqh.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> edV;
                e.a aVar;
                if (f.this.oqt != null && (edV = f.this.oqt.edV()) != null && edV.size() > 0 && (aVar = edV.get(i)) != null && !aVar.oqg) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.oqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.opP != null && f.this.opP.opV != 0) {
                    c.edU().a(f.this.mActivity, f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.c.a
                        public void zE(boolean z) {
                            if (z && f.this.opP != null && f.this.opP.opV == 1) {
                                f.this.clu();
                            }
                        }
                    });
                }
            }
        });
        this.oqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.5
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
        this.oql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.cmI();
            }
        });
        this.oqr.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        this.oqr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.edC();
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
                                f.this.ojY.w(f.this.aFN.aKL.aUg, f.this.aFN.aKL.live_id, 0);
                            }
                        });
                    } else {
                        f.this.ojY.w(f.this.aFN.aKL.aUg, f.this.aFN.aKL.live_id, 1);
                    }
                    f.this.ojY.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = false;
                                f.this.zF(false);
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(false, f.this.aFN.aKL.live_id)));
                                return;
                            }
                            f.this.edD();
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
        this.oqh.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.oqh.setNeedAlphaShade(true);
        this.oqi.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.oqu = new d(this.mActivity);
        this.oqi.setAdapter((ListAdapter) this.oqu);
        this.oqi.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.oqi.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.8
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> edV;
                e.a aVar;
                if (f.this.oqu != null && (edV = f.this.oqu.edV()) != null && edV.size() > 0 && (aVar = edV.get(i)) != null && !aVar.oqg) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.oqi.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.oqi.setNeedAlphaShade(true);
        this.oqk.setShowOval(true);
        this.oqk.setStrokeColorResId(a.c.sdk_white_alpha100);
        this.oqk.setAutoChangeStyle(false);
        this.oqk.setStrokeWith(BdUtilHelper.dip2px(this.mActivity, 2.0f));
        this.oqj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aFN != null && f.this.aFN.aKL != null) {
                    new com.baidu.tieba.yuyinala.liveroom.rename.c(f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.rename.c.a
                        public void call(String str) {
                            f.this.oqn.setText(str);
                            f.this.opP.room_name = str;
                        }
                    }).ac(f.this.aFN);
                }
            }
        });
        this.oqh.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bTg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
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
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edD() {
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
    public void cmI() {
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
        this.oqv.request(str);
        this.oqv.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.11
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
        if (alaGetRoomCardInfoHttpResponseMessage != null && alaGetRoomCardInfoHttpResponseMessage.edT() != null) {
            this.opP = alaGetRoomCardInfoHttpResponseMessage.edT();
            if (this.opP != null) {
                this.oqn.setText(this.opP.room_name);
                if (!TextUtils.isEmpty(this.opP.oqd)) {
                    this.oqk.startLoad(this.opP.oqd, 12, false, false);
                }
                this.jfl.setText("粉丝：" + StringHelper.formatYuyinValue(this.opP.oqb));
                this.oqo.setText("房间ID：" + this.opP.oqc);
                if (this.opP.oqa == null || this.opP.oqa.size() == 0) {
                    this.oqp.setText("管理员：0人");
                } else {
                    this.oqp.setText("管理员：" + this.opP.oqa.size() + "人");
                }
                if (this.opP.opW == 1) {
                    this.oqm.setVisibility(0);
                } else {
                    this.oqm.setVisibility(8);
                }
                if (this.opP != null && this.opP.opV == 1) {
                    this.oqw.setVisibility(0);
                } else {
                    this.oqw.setVisibility(8);
                }
                if (this.opP.oqa != null && this.opP.oqa.size() > 0) {
                    this.oqt.gy(this.opP.oqa);
                    this.oqt.notifyDataSetChanged();
                }
                if (this.opP.opZ == null || this.opP.opZ.size() == 0) {
                    this.oqq.setText("主持：0人");
                    ArrayList arrayList = new ArrayList();
                    e.a aVar = new e.a();
                    aVar.oqg = true;
                    aVar.oqe = 3;
                    arrayList.add(aVar);
                    this.oqu.gy(arrayList);
                    this.oqu.notifyDataSetChanged();
                } else {
                    this.oqq.setText("主持：" + this.opP.opZ.size() + "人");
                }
                if (this.opP.opZ != null && this.opP.opZ.size() > 0) {
                    this.oqu.gy(this.opP.opZ);
                    this.oqu.notifyDataSetChanged();
                }
                this.isFollowed = this.opP.opY == 1;
                this.opX = this.opP.opX;
                zF(this.opP.opY == 1);
                if (this.opP.opV == 1) {
                    this.oqj.setVisibility(0);
                } else {
                    this.oqj.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(boolean z) {
        if (z) {
            this.oqr.setText("已收藏");
            this.oqr.setBackgroundResource(a.e.yuyin_ala_room_card_uncollect_bg);
            this.oqr.setTextColor(getContext().getResources().getColor(a.c.sdk_color_858585));
            this.oqr.setVisibility(0);
            this.oqs.setVisibility(0);
            this.oqs.setText(this.opX);
            return;
        }
        this.oqr.setText("收藏本房间");
        this.oqr.setBackgroundResource(a.e.yuyin_ala_room_card_collect_bg);
        this.oqr.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
        this.oqr.setVisibility(0);
        this.oqs.setVisibility(0);
        this.oqs.setText(this.opX);
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
    public void clu() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mActivity, "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_CAMERA);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void In(final String str) {
        if (this.opK != null && this.aFN != null && this.aFN.aKL != null) {
            this.opK.f(this.aFN.aKL.aUg, 2, this.aFN.aKL.live_id, str);
            this.opK.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.2
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    l.a(f.this.oqk, str, true, false);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mActivity, ExtraParamsManager.getDecryptUserId(aVar.user_uk) + "", aVar.user_name, aVar.oqf, 0, 0, null, null, 0L, 0L, 0L, 0, "", this.aFN.aKL.live_id, false, "", null, aVar.user_name, "")));
        }
    }
}
