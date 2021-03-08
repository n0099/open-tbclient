package com.baidu.tieba.realauthen;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ae.a;
import com.baidu.live.data.bv;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.FaceRecognitionActivityConfig;
import com.baidu.live.tbadk.realAuthen.AuthenCallback;
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.tieba.realauthen.activity.FaceRecognitionActivity;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class RealAuthenInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(FaceRecognitionActivityConfig.class, FaceRecognitionActivity.class);
        dDh();
    }

    private static void dDh() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913222) { // from class: com.baidu.tieba.realauthen.RealAuthenInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (RealAuthenManager.getInstance().getRealAuthen() != null) {
                    HashMap hashMap = new HashMap();
                    bv bvVar = a.Qm().bCs;
                    if (bvVar != null && bvVar.aRs != null && !TextUtils.isEmpty(bvVar.aRs.aSO)) {
                        hashMap.put("certify_url", bvVar.aRs.aSO);
                    }
                    RealAuthenManager.getInstance().getRealAuthen().doAuthen(hashMap, new AuthenCallback() { // from class: com.baidu.tieba.realauthen.RealAuthenInitialize.1.1
                        @Override // com.baidu.live.tbadk.realAuthen.AuthenCallback
                        public void onAuthenResult(int i, Map<String, Object> map) {
                            String str;
                            if (!map.containsKey("resultMsg")) {
                                str = "";
                            } else {
                                str = (String) map.get("resultMsg");
                            }
                            if (map != null) {
                                for (String str2 : map.keySet()) {
                                    Log.i("realAuth", "@@ 实名认证 回调 key=" + str2 + ", value=" + map.get(str2));
                                }
                            }
                            if (i == 0 || i == 110000) {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), a.h.sdk_authen_suc);
                            } else if (!TextUtils.isEmpty(str)) {
                                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
                            }
                        }
                    });
                }
            }
        });
    }
}
