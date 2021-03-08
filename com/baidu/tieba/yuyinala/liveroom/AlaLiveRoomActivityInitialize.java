package com.baidu.tieba.yuyinala.liveroom;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d;
import com.baidu.live.d.ae;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlManager;
import java.util.Map;
/* loaded from: classes10.dex */
public class AlaLiveRoomActivityInitialize {
    static {
        bZi();
        bZj();
        bZm();
        bZn();
    }

    private static void bZi() {
    }

    public static void bZj() {
        UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomActivityInitialize.1
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
                if (com.baidu.live.adp.lib.util.StringUtils.isNull(r0) == false) goto L21;
             */
            @Override // com.baidu.live.tbadk.core.util.UrlManager.UrlDealListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                String str;
                Map<String, String> paramPair;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.startsWith("http://tieba.baidu.com/ala/share?") || lowerCase.startsWith("https://tieba.baidu.com/ala/share?") || lowerCase.startsWith("http://tieba.baidu.com/ala/share/live") || lowerCase.startsWith("https://tieba.baidu.com/ala/share/live")) {
                    String paramStr = UrlManager.getParamStr(lowerCase);
                    if (!StringUtils.isNull(paramStr) && (paramPair = UrlManager.getParamPair(paramStr)) != null) {
                        str = paramPair.get("from_type");
                    }
                    str = "share_play";
                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                    yuyinAlaLiveRoomActivityConfig.addExtraByUrl(lowerCase, null, str);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void bZm() {
        TbadkCoreApplication.getInst().RegisterIntent(ae.class, AlaLiveFloatWindowActivity.class);
    }

    private static void bZn() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_PERSON_ALA_ENTRANCE_LIVE_ID) { // from class: com.baidu.tieba.yuyinala.liveroom.AlaLiveRoomActivityInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    long j = d.xf().getLong("ala_live_room_last_live_id", -1L);
                    if (j > 0 && longValue > 0 && j == longValue) {
                        d.xf().putBoolean("ala_person_ala_entrance_same_live_room", true);
                    } else {
                        d.xf().putBoolean("ala_person_ala_entrance_same_live_room", false);
                    }
                    d.xf().remove("ala_live_room_last_live_id");
                }
            }
        });
    }
}
