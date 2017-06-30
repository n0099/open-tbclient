package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.likedForum.a;
import com.baidu.tieba.w;
import com.baidu.tieba.write.transmit.SelectForumActivityConfig;
import com.baidu.tieba.write.transmit.TransmitForumData;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.RecommendForumListForBottle.ForumInfo;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class a {
    private TbPageContext ajP;
    private com.baidu.tieba.write.transmit.model.a gdp;
    private com.baidu.tieba.likedForum.a gdq;
    private com.baidu.tbadk.core.view.a gdr;
    private List<SimpleForum> gdv;
    private List<ForumInfo> gdw;
    private WriteData mData;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean gds = false;
    private boolean gdt = false;
    private boolean gdu = false;
    private a.InterfaceC0088a gdx = new b(this);
    private a.InterfaceC0073a bjn = new c(this);
    private DialogInterface.OnCancelListener gdy = new d(this);

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.gdr = null;
        this.ajP = tbPageContext;
        this.mData = writeData;
        this.gdp = new com.baidu.tieba.write.transmit.model.a(this.ajP.getUniqueId());
        this.gdp.a(this.gdx);
        if (this.mData != null) {
            this.gdp.setForumId(this.mData.getForumId());
        }
        this.gdq = new com.baidu.tieba.likedForum.a(this.ajP.getUniqueId());
        this.gdq.a(this.bjn);
        this.gdr = new com.baidu.tbadk.core.view.a(this.ajP);
        this.gdr.c(this.gdy);
        brr();
    }

    private void brr() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.ajP.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.ghN = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brs() {
        if (this.gds && this.gdt && !this.gdu) {
            this.gdu = true;
            this.gdr.aI(false);
            ArrayList arrayList = new ArrayList();
            if (z.s(this.gdv) > 0) {
                for (SimpleForum simpleForum : this.gdv) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !cN(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (z.s(this.gdw) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.gdw) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !cN(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            PF();
        }
    }

    private boolean cN(long j) {
        if (this.mDataList == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    private void PF() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.ajP.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
        selectForumActivityConfig.setForumList((ArrayList) this.mDataList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void destroy() {
        if (this.gdp != null) {
            this.gdp.destroy();
        }
        if (this.gdq != null) {
            this.gdq.destroy();
        }
    }

    public String getRecommendExt() {
        return this.gdp.getRecommendExt();
    }

    public void ck(String str, String str2) {
        if (this.gds && this.gdt) {
            PF();
        } else if (!com.baidu.adp.lib.util.k.hA()) {
            this.ajP.showToast(w.l.neterror);
        } else {
            if (!this.gds) {
                this.gdp.setThreadTitle(str);
                this.gdp.setThreadContent(str2);
                this.gdp.OZ();
            }
            if (!this.gdt) {
                this.gdq.EX();
            }
            this.gdr.c(null);
            this.gdr.aI(true);
        }
    }

    public void aa(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST);
        if (parcelableArrayListExtra != null) {
            this.mDataList.clear();
            this.mDataList.addAll(parcelableArrayListExtra);
        }
    }

    public String brt() {
        ArrayList arrayList = new ArrayList();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.aaP) {
                arrayList.add(transmitForumData);
            }
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TransmitForumData transmitForumData2 = (TransmitForumData) it.next();
            if (transmitForumData2 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(String.valueOf(transmitForumData2.forumId), transmitForumData2.type);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONArray.toString();
    }

    public String bru() {
        ArrayList arrayList = new ArrayList();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.aaP) {
                arrayList.add(transmitForumData);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TransmitForumData transmitForumData2 = (TransmitForumData) it.next();
            if (transmitForumData2 != null) {
                if (!StringUtils.isNull(sb.toString())) {
                    sb.append("、");
                }
                sb.append(String.valueOf(transmitForumData2.forumName) + this.ajP.getResources().getString(w.l.bar));
            }
        }
        return sb.toString();
    }

    public boolean brv() {
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.aaP) {
                return true;
            }
        }
        return false;
    }
}
