package com.baidu.tieba.yuyinala.liveroom.p;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.d;
import com.baidu.live.data.ab;
import com.baidu.live.data.aq;
import com.baidu.live.message.GetYuyinSuperCustomerInfoHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends BdBaseModel {
    private ab aLz;
    private Dialog bka;
    public aq bwG;
    private Context context;
    private AnimatorSet hFv;
    private View mContentView;
    private boolean hFw = false;
    private Handler handler = new Handler();
    private boolean hFx = false;
    private boolean hFy = false;
    public boolean hQe = false;
    public boolean hQf = false;
    private HttpMessageListener bCE = new HttpMessageListener(1031064) { // from class: com.baidu.tieba.yuyinala.liveroom.p.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031064 && (httpResponsedMessage instanceof GetYuyinSuperCustomerInfoHttpResponseMessage) && c.this.context != null) {
                if (httpResponsedMessage.getError() == 0) {
                    GetYuyinSuperCustomerInfoHttpResponseMessage getYuyinSuperCustomerInfoHttpResponseMessage = (GetYuyinSuperCustomerInfoHttpResponseMessage) httpResponsedMessage;
                    if (getYuyinSuperCustomerInfoHttpResponseMessage.OA() != null) {
                        c.this.bwG = getYuyinSuperCustomerInfoHttpResponseMessage.OA();
                        b.ecb().bwG = c.this.bwG;
                        c.this.xj();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "refreshInfo"));
                    }
                }
            }
        }
    };
    private CustomMessageListener bpb = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.p.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof String) && c.this.context != null) {
                String str = (String) customResponsedMessage.getData();
                if ("consumeSuc".equals(str) && !c.this.hQf) {
                    c.this.hQf = true;
                    BdLog.d("consumeSuc");
                    c.this.a(c.this.aLz, c.this.aLz.aJZ.userId);
                }
                if ("chargeSuc".equals(str) && !c.this.hQe) {
                    BdLog.d("chargeSuc");
                    c.this.hQe = true;
                    c.this.a(c.this.aLz, c.this.aLz.aJZ.userId);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.context = tbPageContext.getPageActivity();
        this.bCE.setTag(tbPageContext.getUniqueId());
        this.bpb.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bCE);
        MessageManager.getInstance().registerListener(this.bpb);
    }

    public void a(ab abVar, long j) {
        this.aLz = abVar;
        HttpMessage httpMessage = new HttpMessage(1031064);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
        BdLog.d("requestSuperCustomerInfoMessage user_id:" + j);
    }

    public void FD() {
        if (this.bka != null && this.bka.isShowing()) {
            Context context = this.bka.getContext();
            if (context != null) {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (Build.VERSION.SDK_INT >= 17) {
                        if (activity.isDestroyed() || activity.isFinishing()) {
                            return;
                        }
                    } else if (activity.isFinishing()) {
                        return;
                    }
                }
                this.bka.dismiss();
            } else {
                return;
            }
        }
        this.bka = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void xj() {
        JSONArray jSONArray;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aLz != null && this.aLz.aJZ != null) {
            if (this.aLz.mLiveInfo == null || this.aLz.mLiveInfo.screen_direction != 2) {
                BdLog.d("deal--isTiming:" + this.hFw);
                if (!this.hFw && TbadkCoreApplication.isLogin() && this.bwG != null && this.bwG.aLC != 1 && !TextUtils.isEmpty(this.bwG.aLD)) {
                    if (this.bwG == null || this.bwG.aLF) {
                        int i = this.bwG.limit;
                        String string = d.xf().getString("super_constomer_show_trace_monthly", "");
                        BdLog.d("deal-- trace:" + string);
                        if (!TextUtils.isEmpty(string)) {
                            try {
                                jSONArray = new JSONArray(string);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            JSONArray jSONArray2 = jSONArray;
                            if (i == 0) {
                                final ArrayList<a> arrayList = new ArrayList();
                                if (jSONArray2 != null) {
                                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                        arrayList.add(new a().eR(jSONArray2.optJSONObject(i2)));
                                    }
                                }
                                for (a aVar : arrayList) {
                                    if (aVar != null && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.uid)) {
                                        Date ih = k.ih(aVar.date);
                                        if (ih == null) {
                                            break;
                                        } else if (!k.d(ih)) {
                                            if (k.c(ih) && aVar.bsP >= i) {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                int i3 = this.bwG.interval;
                                if (i3 <= 0) {
                                    i3 = 20;
                                }
                                BdLog.d("deal--postDelayed");
                                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.p.c.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        BdLog.d("deal--postDelayed run");
                                        if (c.this.context instanceof Activity) {
                                            Activity activity = (Activity) c.this.context;
                                            if (Build.VERSION.SDK_INT >= 17) {
                                                if (activity.isDestroyed() || activity.isFinishing()) {
                                                    return;
                                                }
                                            } else if (activity.isFinishing()) {
                                                return;
                                            }
                                        }
                                        if (c.this.aLz != null && c.this.aLz.aJZ != null) {
                                            c.this.a(c.this.context, c.this.bwG);
                                            c.this.a(arrayList, c.this.bwG);
                                        }
                                    }
                                }, i3 * 1000);
                                this.hFw = true;
                                return;
                            }
                            return;
                        }
                        jSONArray = null;
                        JSONArray jSONArray22 = jSONArray;
                        if (i == 0) {
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final aq aqVar) {
        FD();
        View inflate = LayoutInflater.from(context).inflate(a.g.dialog_super_customer, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.i.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        this.mContentView = inflate;
        this.bka = dialog;
        inflate.findViewById(a.f.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.p.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                try {
                    c.this.FD();
                    if (c.this.aLz != null && c.this.aLz.mLiveInfo != null) {
                        String str2 = aqVar.aLD;
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.contains("?")) {
                                str = str2 + "&live_id=" + c.this.aLz.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                            } else {
                                str = str2 + "?live_id=" + c.this.aLz.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(context, str)));
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "largebag_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.p.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.FD();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.yuyinala.liveroom.p.c.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                BdLog.d("dialog onShow 播放动画");
                if (c.this.hFv != null) {
                    c.this.hFv.start();
                }
            }
        });
        BdLog.d("dialog setOnDismissListener");
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.p.c.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                BdLog.d("dialog 停止动画");
                if (c.this.hFv != null) {
                    c.this.hFv.cancel();
                }
                c.this.hFw = false;
            }
        });
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.super_bg);
        tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
        tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.yuyinala.liveroom.p.c.8
            @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
            public void onComplete(String str, boolean z) {
                BdLog.d("dialog imageView onComplete");
                try {
                    if (context instanceof Activity) {
                        BdLog.d("dialog imageView context instanceof Activity");
                        Activity activity = (Activity) context;
                        if (Build.VERSION.SDK_INT >= 17) {
                            if (activity.isDestroyed() || activity.isFinishing()) {
                                return;
                            }
                        } else if (activity.isFinishing()) {
                            return;
                        }
                        if (c.this.aLz != null && dialog != null && !dialog.isShowing()) {
                            BdLog.d("dialog.show()");
                            dialog.show();
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "largebag_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
            public void onCancel() {
            }
        });
        if (!TextUtils.isEmpty(aqVar.picUrl)) {
            BdLog.d("picUrl:" + aqVar.picUrl);
            tbImageView.startLoad(aqVar.picUrl, 10, false);
        }
        TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.f.super_entry);
        tbImageView2.setDefaultBgResource(a.e.sdk_shape_transparent);
        if (!TextUtils.isEmpty(aqVar.aLE)) {
            tbImageView2.startLoad(aqVar.aLE, 10, false);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.hFv = new AnimatorSet();
        this.hFv.play(ofFloat).with(ofFloat2);
        this.hFv.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hFv.setDuration(2000L);
        this.hFv.setStartDelay(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list, aq aqVar) {
        int i;
        boolean z;
        int i2;
        if (aqVar != null) {
            try {
                i = aqVar.limit;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
        }
        if (i >= 0) {
            if (list == null) {
                list = new ArrayList<>();
            }
            Iterator<a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                a next = it.next();
                if (next != null && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(next.uid)) {
                    if (k.c(k.ih(next.date))) {
                        i2 = next.bsP + 1;
                        next.bsP = i2;
                    } else {
                        i2 = 1;
                    }
                    next.bsP = i2;
                    next.date = k.b(new Date());
                    z = true;
                }
            }
            if (!z) {
                a aVar = new a();
                aVar.uid = TbadkCoreApplication.getCurrentAccount();
                aVar.date = k.b(new Date());
                aVar.bsP = 1;
                list.add(aVar);
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar2 : list) {
                jSONArray.put(new JSONObject(aVar2.toJsonString()));
            }
            d.xf().putString("super_constomer_show_trace_monthly", jSONArray.toString());
        }
    }

    public void onResume() {
        if (this.hFy || !this.hFx || this.context == null || this.aLz == null || this.aLz.aJZ == null) {
        }
    }

    public void release() {
        this.hFw = false;
        this.aLz = null;
        this.hQe = false;
        this.hQf = false;
        this.handler.removeCallbacksAndMessages(null);
        FD();
        this.bwG = null;
        b.ecb().bwG = null;
        if (this.hFv != null) {
            this.hFv.cancel();
            this.hFv = null;
        }
        this.context = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
