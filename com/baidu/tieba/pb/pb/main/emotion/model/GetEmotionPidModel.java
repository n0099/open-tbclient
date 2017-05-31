package com.baidu.tieba.pb.pb.main.emotion.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.i;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.GetEmotionPidResponseMessage;
/* loaded from: classes.dex */
public class GetEmotionPidModel extends BdBaseModel {
    private a evP;
    private final HttpMessageListener evQ = new com.baidu.tieba.pb.pb.main.emotion.model.a(this, CmdConfigHttp.CMD_GET_PB_EMOTION_PID);

    /* loaded from: classes.dex */
    public interface a {
        void onFail(int i, String str);

        void onSuccess(String str);
    }

    public GetEmotionPidModel() {
        DA();
        this.evQ.setTag(getUniqueId());
        this.evQ.setSelfListener(true);
        registerListener(this.evQ);
    }

    private void DA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_EMOTION_PID, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/meme/pic2id");
        tbHttpMessageTask.setResponsedClass(GetEmotionPidResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, a aVar) {
        this.evP = aVar;
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.onFail(0, "picUrl is empty");
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
        httpMessage.addParam("pic_url", i.bS(str));
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.evQ);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
        return true;
    }
}
