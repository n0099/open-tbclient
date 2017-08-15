package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.d;
import com.baidu.tieba.likedForum.a;
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
    private com.baidu.tieba.write.transmit.model.a gAN;
    private com.baidu.tieba.likedForum.a gAO;
    private com.baidu.tbadk.core.view.a gAP;
    private List<SimpleForum> gAT;
    private List<ForumInfo> gAU;
    private WriteData mData;
    private TbPageContext oV;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean gAQ = false;
    private boolean gAR = false;
    private boolean gAS = false;
    private a.InterfaceC0126a gAV = new a.InterfaceC0126a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void byi() {
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void B(List<SimpleForum> list) {
            a.this.gAQ = true;
            a.this.gAT = list;
            a.this.byd();
        }
    };
    private a.InterfaceC0105a bot = new a.InterfaceC0105a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0105a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            a.this.gAR = true;
            a.this.gAU = list;
            a.this.byd();
        }
    };
    private DialogInterface.OnCancelListener gAW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.gAN != null) {
                a.this.gAN.aEu();
            }
            if (a.this.gAO != null) {
                a.this.gAO.aEu();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.gAP = null;
        this.oV = tbPageContext;
        this.mData = writeData;
        this.gAN = new com.baidu.tieba.write.transmit.model.a(this.oV.getUniqueId());
        this.gAN.a(this.gAV);
        if (this.mData != null) {
            this.gAN.setForumId(this.mData.getForumId());
        }
        this.gAO = new com.baidu.tieba.likedForum.a(this.oV.getUniqueId());
        this.gAO.a(this.bot);
        this.gAP = new com.baidu.tbadk.core.view.a(this.oV);
        this.gAP.c(this.gAW);
        byc();
    }

    private void byc() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.oV.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long d = com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L);
            if (d > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(d, this.mData.getForumName(), true, 0, str);
                transmitForumData.abl = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byd() {
        if (this.gAQ && this.gAR && !this.gAS) {
            this.gAS = true;
            this.gAP.aH(false);
            ArrayList arrayList = new ArrayList();
            if (u.u(this.gAT) > 0) {
                for (SimpleForum simpleForum : this.gAT) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !da(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (u.u(this.gAU) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.gAU) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !da(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            bye();
        }
    }

    private boolean da(long j) {
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

    private void bye() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.oV.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
        selectForumActivityConfig.setForumList((ArrayList) this.mDataList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void destroy() {
        if (this.gAN != null) {
            this.gAN.destroy();
        }
        if (this.gAO != null) {
            this.gAO.destroy();
        }
    }

    public String getRecommendExt() {
        return this.gAN.getRecommendExt();
    }

    public void cn(String str, String str2) {
        if (this.gAQ && this.gAR) {
            bye();
        } else if (!k.hI()) {
            this.oV.showToast(d.l.neterror);
        } else {
            if (!this.gAQ) {
                this.gAN.setThreadTitle(str);
                this.gAN.setThreadContent(str2);
                this.gAN.Py();
            }
            if (!this.gAR) {
                this.gAO.Fw();
            }
            this.gAP.c(null);
            this.gAP.aH(true);
        }
    }

    public void ae(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST);
        if (parcelableArrayListExtra != null) {
            this.mDataList.clear();
            this.mDataList.addAll(parcelableArrayListExtra);
        }
    }

    public String byf() {
        ArrayList arrayList = new ArrayList();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.abk) {
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

    public String byg() {
        ArrayList arrayList = new ArrayList();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.abk) {
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
                sb.append(transmitForumData2.forumName + this.oV.getResources().getString(d.l.bar));
            }
        }
        return sb.toString();
    }

    public boolean byh() {
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.abk) {
                return true;
            }
        }
        return false;
    }
}
