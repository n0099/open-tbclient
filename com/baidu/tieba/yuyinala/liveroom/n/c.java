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
import com.baidu.live.data.ai;
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
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private w aJv;
    private Dialog beG;
    public ai bmT;
    private Context context;
    private AnimatorSet hcS;
    private View mContentView;
    private boolean hcT = false;
    private Handler handler = new Handler();
    private boolean hcU = false;
    private boolean hcV = false;
    public boolean hnd = false;
    public boolean hne = false;
    private HttpMessageListener bsK = new HttpMessageListener(1031064) { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031064 && (httpResponsedMessage instanceof GetYuyinSuperCustomerInfoHttpResponseMessage) && c.this.context != null) {
                if (httpResponsedMessage.getError() == 0) {
                    GetYuyinSuperCustomerInfoHttpResponseMessage getYuyinSuperCustomerInfoHttpResponseMessage = (GetYuyinSuperCustomerInfoHttpResponseMessage) httpResponsedMessage;
                    if (getYuyinSuperCustomerInfoHttpResponseMessage.NL() != null) {
                        c.this.bmT = getYuyinSuperCustomerInfoHttpResponseMessage.NL();
                        b.dVE().bmT = c.this.bmT;
                        c.this.Bd();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "refreshInfo"));
                    }
                }
            }
        }
    };
    private CustomMessageListener bjn = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof String) && c.this.context != null) {
                String str = (String) customResponsedMessage.getData();
                if ("consumeSuc".equals(str) && !c.this.hne) {
                    c.this.hne = true;
                    BdLog.d("consumeSuc");
                    c.this.a(c.this.aJv, c.this.aJv.aIA.userId);
                }
                if ("chargeSuc".equals(str) && !c.this.hnd) {
                    BdLog.d("chargeSuc");
                    c.this.hnd = true;
                    c.this.a(c.this.aJv, c.this.aJv.aIA.userId);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.context = tbPageContext.getPageActivity();
        this.bsK.setTag(tbPageContext.getUniqueId());
        this.bjn.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bsK);
        MessageManager.getInstance().registerListener(this.bjn);
    }

    public void a(w wVar, long j) {
        this.aJv = wVar;
        HttpMessage httpMessage = new HttpMessage(1031064);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
        BdLog.d("requestSuperCustomerInfoMessage user_id:" + j);
    }

    public void GU() {
        if (this.beG != null && this.beG.isShowing()) {
            Context context = this.beG.getContext();
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
                this.beG.dismiss();
            } else {
                return;
            }
        }
        this.beG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Bd() {
        JSONArray jSONArray;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aJv != null && this.aJv.aIA != null) {
            if (this.aJv.mLiveInfo == null || this.aJv.mLiveInfo.screen_direction != 2) {
                BdLog.d("deal--isTiming:" + this.hcT);
                if (!this.hcT && TbadkCoreApplication.isLogin() && this.bmT != null && this.bmT.aJz != 1 && !TextUtils.isEmpty(this.bmT.aJA)) {
                    if (this.bmT == null || this.bmT.aJC) {
                        int i = this.bmT.limit;
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
                                        arrayList.add(new a().ew(jSONArray2.optJSONObject(i2)));
                                    }
                                }
                                for (a aVar : arrayList) {
                                    if (aVar != null && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.uid)) {
                                        Date il = k.il(aVar.date);
                                        if (il == null) {
                                            break;
                                        } else if (!k.d(il)) {
                                            if (k.c(il) && aVar.dAU >= i) {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                int i3 = this.bmT.aJy;
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
                                        if (c.this.aJv != null && c.this.aJv.aIA != null) {
                                            c.this.a(c.this.context, c.this.bmT);
                                            c.this.a(arrayList, c.this.bmT);
                                        }
                                    }
                                }, i3 * 1000);
                                this.hcT = true;
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
    public void a(final Context context, final ai aiVar) {
        GU();
        View inflate = LayoutInflater.from(context).inflate(a.h.dialog_super_customer, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        this.mContentView = inflate;
        this.beG = dialog;
        inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                try {
                    c.this.GU();
                    if (c.this.aJv != null && c.this.aJv.mLiveInfo != null) {
                        String str2 = aiVar.aJA;
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.contains("?")) {
                                str = str2 + "&live_id=" + c.this.aJv.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                            } else {
                                str = str2 + "?live_id=" + c.this.aJv.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(context, str)));
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "largebag_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.GU();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                BdLog.d("dialog onShow 播放动画");
                if (c.this.hcS != null) {
                    c.this.hcS.start();
                }
            }
        });
        BdLog.d("dialog setOnDismissListener");
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.n.c.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                BdLog.d("dialog 停止动画");
                if (c.this.hcS != null) {
                    c.this.hcS.cancel();
                }
                c.this.hcT = false;
            }
        });
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.super_bg);
        tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
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
                        if (c.this.aJv != null && dialog != null && !dialog.isShowing()) {
                            BdLog.d("dialog.show()");
                            dialog.show();
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "largebag_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
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
        if (!TextUtils.isEmpty(aiVar.picUrl)) {
            BdLog.d("picUrl:" + aiVar.picUrl);
            tbImageView.startLoad(aiVar.picUrl, 10, false);
        }
        TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.g.super_entry);
        tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
        if (!TextUtils.isEmpty(aiVar.aJB)) {
            tbImageView2.startLoad(aiVar.aJB, 10, false);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.hcS = new AnimatorSet();
        this.hcS.play(ofFloat).with(ofFloat2);
        this.hcS.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hcS.setDuration(2000L);
        this.hcS.setStartDelay(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list, ai aiVar) {
        int i;
        boolean z;
        int i2;
        if (aiVar != null) {
            try {
                i = aiVar.limit;
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
                    if (k.c(k.il(next.date))) {
                        i2 = next.dAU + 1;
                        next.dAU = i2;
                    } else {
                        i2 = 1;
                    }
                    next.dAU = i2;
                    next.date = k.b(new Date());
                    z = true;
                }
            }
            if (!z) {
                a aVar = new a();
                aVar.uid = TbadkCoreApplication.getCurrentAccount();
                aVar.date = k.b(new Date());
                aVar.dAU = 1;
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
        if (this.hcV || !this.hcU || this.context == null || this.aJv == null || this.aJv.aIA == null) {
        }
    }

    public void release() {
        this.hcT = false;
        this.aJv = null;
        this.hnd = false;
        this.hne = false;
        this.handler.removeCallbacksAndMessages(null);
        GU();
        this.bmT = null;
        b.dVE().bmT = null;
        if (this.hcS != null) {
            this.hcS.cancel();
            this.hcS = null;
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
