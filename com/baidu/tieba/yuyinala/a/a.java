package com.baidu.tieba.yuyinala.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.r.c;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.data.RedPktSendHttpResponseMessage;
import com.baidu.tieba.yuyinala.data.h;
/* loaded from: classes11.dex */
public class a {
    private Activity activity;
    private String liveId;
    private b olz;
    private String roomId;
    private HttpMessageListener gSK = new HttpMessageListener(1031076) { // from class: com.baidu.tieba.yuyinala.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (a.this.activity.isDestroyed() || a.this.activity.isFinishing()) {
                    return;
                }
            } else if (a.this.activity.isFinishing()) {
                return;
            }
            if ((httpResponsedMessage instanceof RedPktSendHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                c.a(a.this.liveId, ((RedPktSendHttpResponseMessage) httpResponsedMessage).gVd, ((RedPktSendHttpResponseMessage) httpResponsedMessage).gVe, "send_redpacket");
                a.this.activity.finish();
                return;
            }
            if (httpResponsedMessage.getError() == 3501) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(a.this.activity, 0L, "", true, "", true)));
            } else if (!TextUtils.isEmpty(httpResponsedMessage.getErrorString())) {
                BdUtilHelper.showToast(a.this.activity, httpResponsedMessage.getErrorString());
            }
            if (a.this.olz != null) {
                a.this.olz.mY(true);
            }
        }
    };
    private CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (a.this.activity.isDestroyed() || a.this.activity.isFinishing()) {
                    return;
                }
            } else if (a.this.activity.isFinishing()) {
                return;
            }
            a.this.activity.finish();
        }
    };

    public a(Activity activity) {
        this.activity = activity;
        initView();
        bXi();
    }

    private void initView() {
        if (this.activity != null && this.activity.getIntent() != null) {
            Intent intent = this.activity.getIntent();
            this.liveId = intent.getStringExtra("live_id");
            this.roomId = intent.getStringExtra("room_id");
        }
        this.olz = new b(this.activity, this);
    }

    private static void bXh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031076, TbConfig.SERVER_HOST + "liveserver/redpacket/send");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(RedPktSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bXi() {
        bXh();
        MessageManager.getInstance().registerListener(this.gSK);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterTask(1031076);
        MessageManager.getInstance().unRegisterListener(this.gSK);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
    }

    public View getView() {
        if (this.olz != null) {
            return this.olz.getView();
        }
        return null;
    }

    public void a(h hVar) {
        if (hVar != null) {
            hVar.setLiveId(this.liveId);
            hVar.setRoomId(this.roomId);
            hVar.setParams();
            MessageManager.getInstance().sendMessage(hVar);
            if (this.olz != null) {
                this.olz.mY(false);
            }
        }
    }

    public void Is() {
        if (this.olz != null) {
            this.olz.Is();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.olz != null) {
            this.olz.onKeyboardVisibilityChanged(z);
        }
    }
}
