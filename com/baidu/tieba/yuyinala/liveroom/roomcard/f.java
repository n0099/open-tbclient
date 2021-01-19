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
/* loaded from: classes10.dex */
public class f extends Dialog {
    private x aBr;
    private View bUe;
    private AlaLoadingView bZQ;
    public CustomMessageListener bdo;
    private CommonEmptyView btf;
    private boolean isFollowed;
    private TextView jne;
    private Activity mActivity;
    private h ohh;
    private String ooH;
    private AlphaGradientHListView ooR;
    private ImageView ooS;
    private AlphaGradientHListView ooT;
    private ImageView ooU;
    private ImageView ooV;
    private BarImageView ooW;
    private TextView ooX;
    private TextView ooY;
    private TextView ooZ;
    private com.baidu.tieba.yuyinala.liveroom.rename.e oou;
    private e ooz;
    private TextView opa;
    private View opb;
    private TextView opc;
    private TextView opd;
    private TextView ope;
    private d opf;
    private d opg;
    private g oph;
    private ImageView opi;
    private AlaLoadingButton opj;

    public f(Activity activity) {
        super(activity, a.i.DialogRoomcardStyle);
        this.isFollowed = false;
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (f.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    f.this.dismiss();
                }
            }
        };
        this.mActivity = activity;
        this.ohh = new h(activity);
        init();
    }

    private void init() {
        initView();
        WL();
    }

    private void WL() {
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
        this.btf = (CommonEmptyView) findViewById(a.f.empty_yuyin_view);
        this.bZQ = (AlaLoadingView) findViewById(a.f.loading_view);
        this.bUe = findViewById(a.f.view);
        this.ooV = (ImageView) findViewById(a.f.iv_rename);
        this.ooW = (BarImageView) findViewById(a.f.user_portrait);
        this.ooX = (TextView) findViewById(a.f.tv_report);
        this.ooY = (TextView) findViewById(a.f.tv_banded_post);
        this.ooZ = (TextView) findViewById(a.f.room_name);
        this.jne = (TextView) findViewById(a.f.tv_fans_num);
        this.opb = findViewById(a.f.view_divider_line);
        this.opa = (TextView) findViewById(a.f.tv_id);
        this.opi = (ImageView) findViewById(a.f.iv_modify_img);
        this.opc = (TextView) findViewById(a.f.tv_manager_count);
        this.opd = (TextView) findViewById(a.f.tv_zhuchi_count);
        this.ope = (TextView) findViewById(a.f.tv_bottom_toast);
        this.ooR = (AlphaGradientHListView) findViewById(a.f.ala_live_manager_listview);
        this.ooS = (ImageView) findViewById(a.f.ala_live_manager_listview_bg);
        this.ooT = (AlphaGradientHListView) findViewById(a.f.ala_live_zhuchi_listview);
        this.ooU = (ImageView) findViewById(a.f.ala_live_zhuchi_listview_bg);
        this.opj = (AlaLoadingButton) findViewById(a.f.btn_collect_room);
        this.oph = new g(this.mActivity);
        this.oou = new com.baidu.tieba.yuyinala.liveroom.rename.e(this.mActivity);
        this.opf = new d(this.mActivity);
        this.ooR.setAdapter((ListAdapter) this.opf);
        this.ooR.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        MessageManager.getInstance().registerListener(this.bdo);
        this.ooR.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> dZw;
                e.a aVar;
                if (f.this.opf != null && (dZw = f.this.opf.dZw()) != null && dZw.size() > 0 && (aVar = dZw.get(i)) != null && !aVar.ooQ) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.ooW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.ooz != null && f.this.ooz.ooF != 0) {
                    c.dZv().a(f.this.mActivity, f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.c.a
                        public void zA(boolean z) {
                            if (z && f.this.ooz != null && f.this.ooz.ooF == 1) {
                                f.this.cku();
                            }
                        }
                    });
                }
            }
        });
        this.ooY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    if (f.this.aBr != null) {
                        f.this.dismiss();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinBannedPostActivityConfig(f.this.mActivity, String.valueOf(f.this.aBr.aGy.aQH), String.valueOf(f.this.aBr.aGy.live_id), Long.toString(f.this.aBr.mLiveInfo.group_id))));
                    }
                } catch (Exception e) {
                }
            }
        });
        this.ooX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.clJ();
            }
        });
        this.opj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dZc();
                if (!TbadkCoreApplication.isLogin()) {
                    ViewHelper.skipToLoginActivity(f.this.mActivity);
                } else if (f.this.aBr != null && f.this.aBr.aGy != null) {
                    if (f.this.isFollowed) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g gVar = new com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g(f.this.mActivity);
                        gVar.show();
                        gVar.setText("确认不收藏该房间了么");
                        gVar.cd(PayHelper.STATUS_CANCEL_DESC, a.c.sdk_color_ff1e66);
                        gVar.ce("确认", a.c.sdk_black_alpha100);
                        gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.1
                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onCancel() {
                            }

                            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                            public void onConfirm() {
                                f.this.ohh.y(f.this.aBr.aGy.aQH, f.this.aBr.aGy.live_id, 0);
                                f.this.opj.setStatus(3);
                            }
                        });
                    } else {
                        f.this.ohh.y(f.this.aBr.aGy.aQH, f.this.aBr.aGy.live_id, 1);
                        f.this.opj.setStatus(3);
                    }
                    f.this.ohh.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.7.2
                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = false;
                                f.this.zB(false);
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(false, f.this.aBr.aGy.live_id)));
                                return;
                            }
                            f.this.dYZ();
                            f.this.isFollowed = true;
                            f.this.zB(true);
                            BdUtilHelper.showToast(f.this.mActivity, "收藏成功，将收到房间的开播提醒", 3000);
                            MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, f.this.aBr.aGy.live_id)));
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
                        public void onFail(int i, String str) {
                            if (f.this.isFollowed) {
                                f.this.isFollowed = true;
                            } else {
                                BdUtilHelper.showToast(f.this.mActivity, "房间收藏失败", 3000);
                                f.this.isFollowed = false;
                            }
                            f.this.zB(f.this.isFollowed);
                        }
                    });
                }
            }
        });
        this.ooR.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.ooR.setNeedAlphaShade(true);
        this.ooT.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.opg = new d(this.mActivity);
        this.ooT.setAdapter((ListAdapter) this.opg);
        this.ooT.setSelector(this.mActivity.getResources().getDrawable(a.e.sdk_transparent_bg));
        this.ooT.setOnItemClickListener(new AdapterView.c() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.8
            @Override // com.baidu.live.tieba.horizonallist.widget.AdapterView.c
            public void a(AdapterView<?> adapterView, View view, int i, long j) {
                List<e.a> dZw;
                e.a aVar;
                if (f.this.opg != null && (dZw = f.this.opg.dZw()) != null && dZw.size() > 0 && (aVar = dZw.get(i)) != null && !aVar.ooQ) {
                    f.this.dismiss();
                    f.this.a(aVar);
                }
            }
        });
        this.ooT.setColor(this.mActivity.getResources().getColor(a.c.sdk_white_alpha100), this.mActivity.getResources().getColor(a.c.sdk_white_alpha0));
        this.ooT.setNeedAlphaShade(true);
        this.ooW.setShowOval(true);
        this.ooW.setStrokeColorResId(a.c.sdk_white_alpha100);
        this.ooW.setAutoChangeStyle(false);
        this.ooW.setStrokeWith(BdUtilHelper.dip2px(this.mActivity, 2.0f));
        this.ooV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.aBr != null && f.this.aBr.aGy != null) {
                    new com.baidu.tieba.yuyinala.liveroom.rename.c(f.this.mActivity, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.9.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.rename.c.a
                        public void call(String str) {
                            f.this.ooZ.setText(str);
                            f.this.ooz.room_name = str;
                        }
                    }).af(f.this.aBr);
                }
            }
        });
        this.ooR.setDividerWidth(BdUtilHelper.getDimens(this.mActivity, a.d.sdk_ds0));
        this.bUe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
            jSONObject.put("loc", "roominfo");
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "collect_succ").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clJ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(getContext());
            return;
        }
        dismiss();
        if (this.aBr != null && this.aBr.aGy != null) {
            aa aaVar = new aa(getContext());
            aaVar.ak(this.aBr.aGy.live_id, this.aBr.aGy.aQH);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, aaVar));
        }
    }

    private void UR(String str) {
        this.oph.request(str);
        this.bZQ.setVisibility(0);
        this.oph.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.11
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void b(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
                f.this.ooU.setVisibility(8);
                f.this.ooS.setVisibility(8);
                f.this.ooR.setVisibility(0);
                f.this.ooT.setVisibility(0);
                f.this.bZQ.setVisibility(8);
                f.this.a(alaGetRoomCardInfoHttpResponseMessage);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.g.a
            public void onFail(int i, String str2) {
                f.this.bZQ.setVisibility(8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaGetRoomCardInfoHttpResponseMessage alaGetRoomCardInfoHttpResponseMessage) {
        if (alaGetRoomCardInfoHttpResponseMessage != null && alaGetRoomCardInfoHttpResponseMessage.dZu() != null) {
            this.ooz = alaGetRoomCardInfoHttpResponseMessage.dZu();
            if (this.ooz != null) {
                this.ooZ.setText(this.ooz.room_name);
                if (!TextUtils.isEmpty(this.ooz.ooN)) {
                    this.ooW.startLoad(this.ooz.ooN, 12, false, false);
                }
                this.jne.setText("粉丝：" + StringHelper.formatYuyinValue(this.ooz.ooL));
                this.opa.setText("房间ID：" + this.ooz.ooM);
                this.opb.setVisibility(0);
                if (this.ooz.ooK == null || this.ooz.ooK.size() == 0) {
                    this.opc.setText("管理员：0人");
                } else {
                    this.opc.setText("管理员：" + this.ooz.ooK.size() + "人");
                }
                if (this.ooz.ooG == 1) {
                    this.ooY.setVisibility(0);
                } else {
                    this.ooY.setVisibility(8);
                }
                if (this.ooz != null && this.ooz.ooF == 1) {
                    this.opi.setVisibility(0);
                } else {
                    this.opi.setVisibility(8);
                }
                if (this.ooz.ooK != null && this.ooz.ooK.size() > 0) {
                    this.opf.gq(this.ooz.ooK);
                    this.opf.notifyDataSetChanged();
                }
                if (this.ooz.ooJ == null || this.ooz.ooJ.size() == 0) {
                    this.opd.setText("主持：0人");
                    ArrayList arrayList = new ArrayList();
                    e.a aVar = new e.a();
                    aVar.ooQ = true;
                    aVar.ooO = 3;
                    arrayList.add(aVar);
                    this.opg.gq(arrayList);
                    this.opg.notifyDataSetChanged();
                } else {
                    this.opd.setText("主持：" + this.ooz.ooJ.size() + "人");
                }
                if (this.ooz.ooJ != null && this.ooz.ooJ.size() > 0) {
                    this.opg.gq(this.ooz.ooJ);
                    this.opg.notifyDataSetChanged();
                }
                this.isFollowed = this.ooz.ooI == 1;
                this.ooH = this.ooz.ooH;
                this.ope.setText(this.ooH);
                zB(this.ooz.ooI == 1);
                if (this.ooz.ooF == 1) {
                    this.ooV.setVisibility(0);
                } else {
                    this.ooV.setVisibility(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zB(boolean z) {
        if (z) {
            this.opj.setStatus(4);
        } else {
            this.opj.setStatus(1);
        }
    }

    public void ai(x xVar) {
        this.aBr = xVar;
        try {
            show();
            if (this.aBr != null && this.aBr.aGy != null) {
                UR(this.aBr.aGy.aQH);
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
    public void cku() {
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mActivity, "{\"maxImagesAllowed\":1,\"isOriginalImg\":false}", true, true);
        albumActivityConfig.setRequestCode(12001);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
    }

    public void Hd(final String str) {
        if (this.oou != null && this.aBr != null && this.aBr.aGy != null) {
            this.oou.f(this.aBr.aGy.aQH, 2, this.aBr.aGy.live_id, str);
            this.oou.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.f.2
                @Override // com.baidu.tieba.yuyinala.liveroom.rename.e.a
                public void a(AlaGetRoomNameRenameHttpResponseMessage alaGetRoomNameRenameHttpResponseMessage) {
                    m.a(f.this.ooW, str, true, false);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mActivity, ExtraParamsManager.getDecryptUserId(aVar.user_uk) + "", aVar.user_name, aVar.ooP, 0, 0, null, null, 0L, 0L, 0L, 0, "", this.aBr.aGy.live_id, false, "", null, aVar.user_name, "")));
        }
    }
}
