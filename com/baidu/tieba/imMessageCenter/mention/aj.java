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
    protected boolean CF;
    protected ArrayList<FeedData> cnj = new ArrayList<>();
    protected com.baidu.tbadk.core.data.u cnk = new com.baidu.tbadk.core.data.u();
    protected af cnl = new af();

    public ArrayList<FeedData> ahQ() {
        return this.cnj;
    }

    public com.baidu.tbadk.core.data.u getPage() {
        return this.cnk;
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
                            this.cnj.add(feedData);
                        }
                    } else {
                        this.cnj.add(feedData);
                    }
                }
            }
            this.cnl.parserJson(jSONObject.optJSONObject("message"));
            this.cnk.parserJson(jSONObject.optJSONObject("page"));
            this.CF = true;
        } catch (Exception e) {
            this.CF = false;
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
                                this.cnj.add(feedData);
                            }
                        } else {
                            this.cnj.add(feedData);
                        }
                    }
                }
                this.cnk.a(dataRes.page);
                this.CF = true;
            } catch (Exception e) {
                this.CF = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
