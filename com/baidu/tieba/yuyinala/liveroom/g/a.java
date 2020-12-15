package com.baidu.tieba.yuyinala.liveroom.g;

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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d;
import com.baidu.live.data.bo;
import com.baidu.live.data.cf;
import com.baidu.live.data.cg;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private w aLD;
    private cg aSj;
    private Dialog biC;
    private Context context;
    private AnimatorSet hrY;
    private View mContentView;
    private String otherParams;
    private boolean hrZ = false;
    private Handler handler = new Handler();
    private boolean hsa = false;
    private boolean hsb = false;
    private boolean hsc = false;

    public void ID() {
        if (this.biC != null && this.biC.isShowing()) {
            Context context = this.biC.getContext();
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
                this.biC.dismiss();
            } else {
                return;
            }
        }
        this.biC = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(final Context context, w wVar, String str) {
        bo boVar;
        cf cfVar;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i;
        int i2;
        int i3 = 0;
        this.context = context;
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.aLD = wVar;
            this.otherParams = str;
            if (this.aLD != null && this.aLD.aKr != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("test_firstRecharge", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                boolean booleanValue = process.containsKey("test_firstRecharge") ? ((Boolean) process.get("test_firstRecharge")).booleanValue() : false;
                if (booleanValue) {
                    this.aLD.aKr.isNewUser = true;
                }
                this.hsa = this.aLD.aKr.isNewUser;
                if (this.hsa && !this.hrZ && TbadkCoreApplication.isLogin() && (boVar = com.baidu.live.ae.a.RB().bxq) != null && boVar.aQP != null && boVar.aQP.aTi && (cfVar = boVar.aQM) != null) {
                    this.aSj = cfVar.aSj;
                    if (this.aSj != null && this.aSj.aSs && !TextUtils.isEmpty(this.aSj.aSq)) {
                        int i4 = this.aSj.aSe;
                        int i5 = this.aSj.aSf;
                        final String b = k.b(new Date());
                        String string = d.BM().getString("first_recharge_show_trace", "");
                        if (!TextUtils.isEmpty(string)) {
                            try {
                                jSONArray = new JSONArray(string);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            jSONArray2 = booleanValue ? null : jSONArray;
                            if (i4 == 0 || i5 != 0) {
                                if ((i4 < 0 || i5 >= 0) && jSONArray2 != null) {
                                    HashSet hashSet = new HashSet();
                                    for (i = 0; i < jSONArray2.length(); i++) {
                                        JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                                        if (optJSONObject != null) {
                                            String optString = optJSONObject.optString("date");
                                            hashSet.add(optString);
                                            if (TextUtils.equals(optString, b)) {
                                                i3++;
                                            }
                                            if (i4 >= 0 && i3 >= i4) {
                                                return;
                                            }
                                        }
                                    }
                                    if (i5 >= 0) {
                                        if (hashSet.size() <= i5) {
                                            if (hashSet.size() == i5 && i3 == 0) {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                i2 = this.aSj.aRq;
                                if (i2 <= 0) {
                                    i2 = 20;
                                }
                                if (booleanValue) {
                                    i2 = 5;
                                }
                                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.g.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
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
                                        if (a.this.aLD != null && a.this.aLD.aKr != null && a.this.aLD.aKr.isNewUser) {
                                            a.this.a(context, a.this.aSj);
                                            a.this.a(b, a.this.aSj);
                                        }
                                    }
                                }, i2 * 1000);
                                this.hrZ = true;
                            }
                            return;
                        }
                        jSONArray = null;
                        if (booleanValue) {
                        }
                        if (i4 == 0) {
                        }
                        if (i4 < 0) {
                        }
                        HashSet hashSet2 = new HashSet();
                        while (i < jSONArray2.length()) {
                        }
                        if (i5 >= 0) {
                        }
                        i2 = this.aSj.aRq;
                        if (i2 <= 0) {
                        }
                        if (booleanValue) {
                        }
                        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.g.a.1
                            @Override // java.lang.Runnable
                            public void run() {
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
                                if (a.this.aLD != null && a.this.aLD.aKr != null && a.this.aLD.aKr.isNewUser) {
                                    a.this.a(context, a.this.aSj);
                                    a.this.a(b, a.this.aSj);
                                }
                            }
                        }, i2 * 1000);
                        this.hrZ = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final cg cgVar) {
        ID();
        View inflate = LayoutInflater.from(context).inflate(a.g.dialog_first_recharge, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.i.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        this.mContentView = inflate;
        this.biC = dialog;
        cft();
        inflate.findViewById(a.f.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.g.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    a.this.ID();
                    if (a.this.aLD != null && a.this.aLD.mLiveInfo != null) {
                        String str = cgVar.aSq;
                        if (!TextUtils.isEmpty(str)) {
                            BrowserHelper.startInternalWebActivity(context, str.contains("?") ? str + "&liveId=" + a.this.aLD.mLiveInfo.live_id : str + "?liveId=" + a.this.aLD.mLiveInfo.live_id);
                            if (a.this.aLD != null) {
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupLog(a.this.aLD.mLiveInfo.live_id + "", a.this.aLD.mLiveInfo.room_id + "", a.this.aLD.mLiveInfo.feed_id, a.this.otherParams);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "firstcharg_clk").setContentExt(null, "popup", null));
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.g.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    a.this.ID();
                    if (a.this.aLD != null) {
                        LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupCloseLog(a.this.aLD.mLiveInfo.live_id + "", a.this.aLD.mLiveInfo.room_id + "", a.this.aLD.mLiveInfo.feed_id, a.this.otherParams);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.f.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.e.sdk_shape_transparent);
        if (!TextUtils.isEmpty(cgVar.aSp)) {
            tbImageView2.startLoad(cgVar.aSp, 10, false);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.hrY = new AnimatorSet();
        this.hrY.play(ofFloat).with(ofFloat2);
        this.hrY.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hrY.setDuration(2000L);
        this.hrY.setStartDelay(0L);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.yuyinala.liveroom.g.a.4
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.hrY != null) {
                    a.this.hrY.start();
                }
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.g.a.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.hrY != null) {
                    a.this.hrY.cancel();
                }
                a.this.hrZ = false;
            }
        });
        tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.yuyinala.liveroom.g.a.6
            @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
            public void onComplete(String str, boolean z) {
                try {
                    if (context instanceof Activity) {
                        Activity activity = (Activity) context;
                        if (Build.VERSION.SDK_INT >= 17) {
                            if (activity.isDestroyed() || activity.isFinishing()) {
                                return;
                            }
                        } else if (activity.isFinishing()) {
                            return;
                        }
                        if (a.this.aLD != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "firstRechargeDialog"));
                            if (dialog != null && !dialog.isShowing()) {
                                dialog.show();
                                if (a.this.aLD != null) {
                                    LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePopupLog(a.this.aLD.mLiveInfo.live_id + "", a.this.aLD.mLiveInfo.room_id + "", a.this.aLD.mLiveInfo.feed_id, a.this.otherParams);
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "firstcharg_show").setContentExt(null, "popup", null));
                                }
                            }
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
        if (!TextUtils.isEmpty(cgVar.aSo)) {
            tbImageView.startLoad(cgVar.aSo, 10, false);
        }
    }

    public void a(String str, cg cgVar) {
        int i;
        JSONArray jSONArray;
        int i2 = 0;
        if (cgVar != null) {
            try {
                i = cgVar.aSe;
                i2 = cgVar.aSf;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
        }
        if (i >= 0 || i2 >= 0) {
            String string = d.BM().getString("first_recharge_show_trace", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", str);
            jSONArray.put(jSONObject);
            d.BM().putString("first_recharge_show_trace", jSONArray.toString());
        }
    }

    public void onResume() {
        if (!this.hsb && this.hsa && this.context != null && this.aLD != null && this.aLD.aKr != null && !this.aLD.aKr.isNewUser) {
            ID();
            if (this.hsa && this.aSj != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098, this.aSj.aKm));
            }
            this.hsb = true;
            cfs();
        }
    }

    public void n(w wVar) {
        if (!this.hsc && this.hsa && wVar != null && wVar.aKr != null) {
            boolean z = wVar.aKr.isNewUser;
            this.aLD = wVar;
            if (!z && this.hsa) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913115));
                this.hsc = true;
                cfs();
            }
        }
    }

    private void cfs() {
        if (this.hsb && this.hsc) {
            this.hsa = false;
        }
    }

    public void release() {
        this.hrZ = false;
        this.aLD = null;
        this.handler.removeCallbacksAndMessages(null);
        ID();
        if (this.hrY != null) {
            this.hrY.cancel();
            this.hrY = null;
        }
    }

    private void cft() {
        TbImageView tbImageView = (TbImageView) this.mContentView.findViewById(a.f.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) this.mContentView.findViewById(a.f.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.e.sdk_shape_transparent);
        int dimension = (int) (this.context.getResources().getDimension(a.d.sdk_ds400) * 2.0f);
        int dimension2 = (int) this.context.getResources().getDimension(a.d.sdk_ds720);
        int dimension3 = (int) this.context.getResources().getDimension(a.d.sdk_ds176);
        int dimension4 = (int) this.context.getResources().getDimension(a.d.sdk_ds474);
        if (UtilHelper.getRealScreenOrientation(this.biC.getContext()) == 2) {
            int dimension5 = (int) (BdUtilHelper.getScreenDimensions(this.context)[1] - this.context.getResources().getDimension(a.d.sdk_ds120));
            tbImageView.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension) / (dimension + dimension3));
            tbImageView.getLayoutParams().width = (int) (((tbImageView.getLayoutParams().height * dimension2) * 1.0f) / dimension);
            tbImageView2.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension3) / (dimension + dimension3));
            tbImageView2.getLayoutParams().width = (int) (((tbImageView2.getLayoutParams().height * dimension4) * 1.0f) / dimension3);
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.biC.getWindow(), true, false);
            return;
        }
        tbImageView.getLayoutParams().height = dimension;
        tbImageView.getLayoutParams().width = dimension2;
        tbImageView2.getLayoutParams().height = dimension3;
        tbImageView2.getLayoutParams().width = dimension4;
        UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.biC.getWindow(), true, false);
    }
}
