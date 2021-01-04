package com.baidu.tieba.yuyinala.liveroom.wheat.message;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class BaseJsonHttpResponsedMessage extends JsonHttpResponsedMessage {
    private String errmsg;
    private int errno;
    private String usermsg;

    public BaseJsonHttpResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (com.baidu.tieba.yuyinala.liveroom.wheat.a.a.oyv) {
            Log.i("ymcrequest", "cmd:" + i + "BaseJsonHttpResponsedMessage:" + jSONObject.toString());
        }
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject != null) {
                this.errno = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
                this.errmsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
                this.usermsg = optJSONObject.optString("usermsg");
            }
            if (this.errno == 110003) {
                if (!TextUtils.isEmpty(this.usermsg)) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BdToast.makeText(TbadkCoreApplication.getInst(), BaseJsonHttpResponsedMessage.this.usermsg).show();
                        }
                    });
                }
            } else if (this.errno == 210009) {
                if (!TextUtils.isEmpty(this.usermsg)) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BdToast.makeText(TbadkCoreApplication.getInst(), BaseJsonHttpResponsedMessage.this.usermsg).show();
                        }
                    });
                }
            } else if (this.errno == 110000 && o.eff().efl() != null && o.eff().efl().getPageActivity() != null) {
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.message.BaseJsonHttpResponsedMessage.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ViewHelper.skipToLoginActivity(o.eff().efl().getPageActivity());
                    }
                });
            }
        }
    }

    public int getErrno() {
        return this.errno;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public String getUserMsg() {
        return this.usermsg;
    }

    public boolean isError() {
        return this.errno == 110003 || this.errno == 210009 || this.errno == 110000;
    }
}
