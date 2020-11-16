package com.baidu.tieba.yuyinala.liveroom.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.bo;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.tieba.yuyinala.liveroom.data.LiveTaskResponseMessage;
/* loaded from: classes4.dex */
public class c {
    private bo gWU;
    private long hgc;
    private int hgd;
    private int hge;
    private TbPageContext pageContext;
    private HttpMessageListener hgf = new HttpMessageListener(1031070) { // from class: com.baidu.tieba.yuyinala.liveroom.f.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.hasError()) {
                if (c.this.hge < 2) {
                    c.this.hge++;
                    c.this.ni(false);
                } else {
                    return;
                }
            }
            if (httpResponsedMessage instanceof LiveTaskResponseMessage) {
                LiveTaskResponseMessage liveTaskResponseMessage = (LiveTaskResponseMessage) httpResponsedMessage;
                c.this.a(c.this.pageContext.getPageActivity(), liveTaskResponseMessage.message, liveTaskResponseMessage.btnText, TextUtils.isEmpty(liveTaskResponseMessage.scheme) ? liveTaskResponseMessage.url : liveTaskResponseMessage.scheme, liveTaskResponseMessage.hgM);
            }
        }
    };
    private CustomMessageListener hgg = new CustomMessageListener(2913124) { // from class: com.baidu.tieba.yuyinala.liveroom.f.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.gWU.aOc == 1) {
                c.this.hgd++;
                if (c.this.gWU.aOd <= c.this.hgd) {
                    c.this.ni(true);
                }
            }
        }
    };
    private CustomMessageListener hgh = new CustomMessageListener(2913126) { // from class: com.baidu.tieba.yuyinala.liveroom.f.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (c.this.gWU.aOc == 2 && (customResponsedMessage.getData() instanceof Long)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                c.this.hgc = longValue + c.this.hgc;
                if (c.this.gWU.aOe <= c.this.hgc) {
                    c.this.ni(true);
                }
            }
        }
    };
    private Handler handler = new Handler(Looper.getMainLooper());

    public c(TbPageContext tbPageContext, bo boVar) {
        this.pageContext = tbPageContext;
        this.gWU = boVar;
        caJ();
    }

    public void E(w wVar) {
        if (this.gWU != null && this.gWU.aNZ && wVar.mLiveInfo != null) {
            MessageManager.getInstance().registerListener(this.hgg);
            MessageManager.getInstance().registerListener(this.hgh);
            MessageManager.getInstance().registerListener(this.hgf);
            if (this.gWU.aOc == 3) {
                long j = this.gWU.aOf;
                LiveTimerManager.getInstance().addLiveTimerTask("live_task", wVar.mLiveInfo.live_id, new OnLiveTimerListener() { // from class: com.baidu.tieba.yuyinala.liveroom.f.c.1
                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onComplete(boolean z) {
                        c.this.ni(true);
                    }

                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                    public void onInterrupt() {
                    }
                }, (j <= 0 ? 10L : j) * 1000, true);
            }
        }
    }

    public void onDestroy() {
        LiveTimerManager.getInstance().removeLiveTimerTask("live_task", true);
        MessageManager.getInstance().unRegisterListener(this.hgg);
        MessageManager.getInstance().unRegisterListener(this.hgh);
        MessageManager.getInstance().unRegisterListener(this.hgf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(boolean z) {
        if (this.gWU != null) {
            if (z) {
                this.hge = 0;
            }
            HttpMessage httpMessage = new HttpMessage(1031070);
            httpMessage.addParam("task", this.gWU.aOb);
            httpMessage.addParam("zid", ExtraParamsManager.getBaiduzid());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, String str, String str2, final String str3, long j) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            if (j <= 0) {
                j = 3;
            }
            View inflate = LayoutInflater.from(context).inflate(TbadkCoreApplication.getInst().isMobileBaidu() ? a.g.dialog_task_shoubai : a.g.dialog_task_default, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.i.PlayLevelDialog);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(true);
            dialog.getWindow().getAttributes().gravity = 17;
            ((TextView) inflate.findViewById(a.f.message_textView)).setText(str);
            ((TextView) inflate.findViewById(a.f.tip_textView)).setText(str2);
            View findViewById = inflate.findViewById(a.f.result_layout);
            final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.f.c.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Activity activity = (Activity) context;
                        if (Build.VERSION.SDK_INT >= 17) {
                            if (!activity.isDestroyed() && !activity.isFinishing()) {
                                dialog.dismiss();
                            }
                        } else if (!activity.isFinishing()) {
                            dialog.dismiss();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            this.handler.postDelayed(runnable, 1000 * j);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.f.c.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(str3)) {
                        BrowserHelper.startInternalWebActivity(context, str3);
                    }
                    c.this.handler.removeCallbacks(runnable);
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                dialog.show();
                onDestroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void caJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031070, TbConfig.SERVER_ADDRESS + "ala/task/complete");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveTaskResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
