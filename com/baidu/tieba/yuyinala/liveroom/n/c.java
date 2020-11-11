package com.baidu.tieba.yuyinala.liveroom.n;

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
import com.baidu.live.data.aj;
import com.baidu.live.data.w;
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
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private w aKv;
    private Dialog bgb;
    public aj bom;
    private Context context;
    private AnimatorSet hiO;
    private View mContentView;
    private boolean hiP = false;
    private Handler handler = new Handler();
    private boolean hiQ = false;
    private boolean hiR = false;
    public boolean htb = false;
    public boolean htc = false;
    private HttpMessageListener bug = new HttpMessageListener(1031064) { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031064 && (httpResponsedMessage instanceof GetYuyinSuperCustomerInfoHttpResponseMessage) && c.this.context != null) {
                if (httpResponsedMessage.getError() == 0) {
                    GetYuyinSuperCustomerInfoHttpResponseMessage getYuyinSuperCustomerInfoHttpResponseMessage = (GetYuyinSuperCustomerInfoHttpResponseMessage) httpResponsedMessage;
                    if (getYuyinSuperCustomerInfoHttpResponseMessage.Ol() != null) {
                        c.this.bom = getYuyinSuperCustomerInfoHttpResponseMessage.Ol();
                        b.dYt().bom = c.this.bom;
                        c.this.Bd();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "refreshInfo"));
                    }
                }
            }
        }
    };
    private CustomMessageListener bkH = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof String) && c.this.context != null) {
                String str = (String) customResponsedMessage.getData();
                if ("consumeSuc".equals(str) && !c.this.htc) {
                    c.this.htc = true;
                    BdLog.d("consumeSuc");
                    c.this.a(c.this.aKv, c.this.aKv.aJr.userId);
                }
                if ("chargeSuc".equals(str) && !c.this.htb) {
                    BdLog.d("chargeSuc");
                    c.this.htb = true;
                    c.this.a(c.this.aKv, c.this.aKv.aJr.userId);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.context = tbPageContext.getPageActivity();
        this.bug.setTag(tbPageContext.getUniqueId());
        this.bkH.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bug);
        MessageManager.getInstance().registerListener(this.bkH);
    }

    public void a(w wVar, long j) {
        this.aKv = wVar;
        HttpMessage httpMessage = new HttpMessage(1031064);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
        BdLog.d("requestSuperCustomerInfoMessage user_id:" + j);
    }

    public void Hv() {
        if (this.bgb != null && this.bgb.isShowing()) {
            Context context = this.bgb.getContext();
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
                this.bgb.dismiss();
            } else {
                return;
            }
        }
        this.bgb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Bd() {
        JSONArray jSONArray;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aKv != null && this.aKv.aJr != null) {
            if (this.aKv.mLiveInfo == null || this.aKv.mLiveInfo.screen_direction != 2) {
                BdLog.d("deal--isTiming:" + this.hiP);
                if (!this.hiP && TbadkCoreApplication.isLogin() && this.bom != null && this.bom.aKz != 1 && !TextUtils.isEmpty(this.bom.aKA)) {
                    if (this.bom == null || this.bom.aKC) {
                        int i = this.bom.limit;
                        String string = d.AZ().getString("super_constomer_show_trace_monthly", "");
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
                                        arrayList.add(new a().eC(jSONArray2.optJSONObject(i2)));
                                    }
                                }
                                for (a aVar : arrayList) {
                                    if (aVar != null && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.uid)) {
                                        Date iE = k.iE(aVar.date);
                                        if (iE == null) {
                                            break;
                                        } else if (!k.d(iE)) {
                                            if (k.c(iE) && aVar.dGM >= i) {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                int i3 = this.bom.aKy;
                                if (i3 <= 0) {
                                    i3 = 20;
                                }
                                BdLog.d("deal--postDelayed");
                                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.3
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
                                        if (c.this.aKv != null && c.this.aKv.aJr != null) {
                                            c.this.a(c.this.context, c.this.bom);
                                            c.this.a(arrayList, c.this.bom);
                                        }
                                    }
                                }, i3 * 1000);
                                this.hiP = true;
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
    public void a(final Context context, final aj ajVar) {
        Hv();
        View inflate = LayoutInflater.from(context).inflate(a.g.dialog_super_customer, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.i.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        this.mContentView = inflate;
        this.bgb = dialog;
        inflate.findViewById(a.f.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                try {
                    c.this.Hv();
                    if (c.this.aKv != null && c.this.aKv.mLiveInfo != null) {
                        String str2 = ajVar.aKA;
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.contains("?")) {
                                str = str2 + "&live_id=" + c.this.aKv.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                            } else {
                                str = str2 + "?live_id=" + c.this.aKv.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(context, str)));
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "largebag_clk").setContentExt(null, "popup", null));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.Hv();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                BdLog.d("dialog onShow 播放动画");
                if (c.this.hiO != null) {
                    c.this.hiO.start();
                }
            }
        });
        BdLog.d("dialog setOnDismissListener");
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                BdLog.d("dialog 停止动画");
                if (c.this.hiO != null) {
                    c.this.hiO.cancel();
                }
                c.this.hiP = false;
            }
        });
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.super_bg);
        tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
        tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.8
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
                        if (c.this.aKv != null && dialog != null && !dialog.isShowing()) {
                            BdLog.d("dialog.show()");
                            dialog.show();
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "largebag_show").setContentExt(null, "popup", null));
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
        if (!TextUtils.isEmpty(ajVar.picUrl)) {
            BdLog.d("picUrl:" + ajVar.picUrl);
            tbImageView.startLoad(ajVar.picUrl, 10, false);
        }
        TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.f.super_entry);
        tbImageView2.setDefaultBgResource(a.e.sdk_shape_transparent);
        if (!TextUtils.isEmpty(ajVar.aKB)) {
            tbImageView2.startLoad(ajVar.aKB, 10, false);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.hiO = new AnimatorSet();
        this.hiO.play(ofFloat).with(ofFloat2);
        this.hiO.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hiO.setDuration(2000L);
        this.hiO.setStartDelay(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list, aj ajVar) {
        int i;
        boolean z;
        int i2;
        if (ajVar != null) {
            try {
                i = ajVar.limit;
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
                    if (k.c(k.iE(next.date))) {
                        i2 = next.dGM + 1;
                        next.dGM = i2;
                    } else {
                        i2 = 1;
                    }
                    next.dGM = i2;
                    next.date = k.b(new Date());
                    z = true;
                }
            }
            if (!z) {
                a aVar = new a();
                aVar.uid = TbadkCoreApplication.getCurrentAccount();
                aVar.date = k.b(new Date());
                aVar.dGM = 1;
                list.add(aVar);
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar2 : list) {
                jSONArray.put(new JSONObject(aVar2.toJsonString()));
            }
            d.AZ().putString("super_constomer_show_trace_monthly", jSONArray.toString());
        }
    }

    public void onResume() {
        if (this.hiR || !this.hiQ || this.context == null || this.aKv == null || this.aKv.aJr == null) {
        }
    }

    public void release() {
        this.hiP = false;
        this.aKv = null;
        this.htb = false;
        this.htc = false;
        this.handler.removeCallbacksAndMessages(null);
        Hv();
        this.bom = null;
        b.dYt().bom = null;
        if (this.hiO != null) {
            this.hiO.cancel();
            this.hiO = null;
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
