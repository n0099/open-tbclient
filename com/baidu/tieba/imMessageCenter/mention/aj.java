package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ReplyMe.DataRes;
import tbclient.ReplyMe.ReplyList;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes.dex */
public class aj implements com.baidu.tbadk.mvc.b.j {
    protected boolean Cv;
    protected ArrayList<FeedData> ciJ = new ArrayList<>();
    protected com.baidu.tbadk.core.data.q ciK = new com.baidu.tbadk.core.data.q();
    protected af ciL = new af();

    public ArrayList<FeedData> aeH() {
        return this.ciJ;
    }

    public com.baidu.tbadk.core.data.q getPage() {
        return this.ciK;
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void g(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    FeedData feedData = new FeedData();
                    feedData.parserJson(optJSONArray2.optJSONObject(i));
                    if (feedData.getThread_Type() == 33) {
                        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.ciJ.add(feedData);
                        }
                    } else {
                        this.ciJ.add(feedData);
                    }
                }
            }
            this.ciL.parserJson(jSONObject.optJSONObject("message"));
            this.ciK.parserJson(jSONObject.optJSONObject("page"));
            this.Cv = true;
        } catch (Exception e) {
            this.Cv = false;
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        if (message instanceof ReplyMeResIdl) {
            DataRes dataRes = ((ReplyMeResIdl) message).data;
            try {
                List<ReplyList> list = dataRes.reply_list;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        FeedData feedData = new FeedData();
                        feedData.parserProtoBuf(list.get(i));
                        if (feedData.getThread_Type() == 33) {
                            if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                this.ciJ.add(feedData);
                            }
                        } else {
                            this.ciJ.add(feedData);
                        }
                    }
                }
                this.ciK.a(dataRes.page);
                this.Cv = true;
            } catch (Exception e) {
                this.Cv = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
