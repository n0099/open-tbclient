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
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.write.transmit.model.a gAh;
    private com.baidu.tieba.likedForum.a gAi;
    private com.baidu.tbadk.core.view.a gAj;
    private List<SimpleForum> gAn;
    private List<ForumInfo> gAo;
    private WriteData mData;
    private TbPageContext mF;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean gAk = false;
    private boolean gAl = false;
    private boolean gAm = false;
    private a.InterfaceC0128a gAp = new a.InterfaceC0128a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0128a
        public void bxB() {
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0128a
        public void B(List<SimpleForum> list) {
            a.this.gAk = true;
            a.this.gAn = list;
            a.this.bxw();
        }
    };
    private a.InterfaceC0106a bpf = new a.InterfaceC0106a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0106a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            a.this.gAl = true;
            a.this.gAo = list;
            a.this.bxw();
        }
    };
    private DialogInterface.OnCancelListener gAq = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.gAh != null) {
                a.this.gAh.aiz();
            }
            if (a.this.gAi != null) {
                a.this.gAi.aiz();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.gAj = null;
        this.mF = tbPageContext;
        this.mData = writeData;
        this.gAh = new com.baidu.tieba.write.transmit.model.a(this.mF.getUniqueId());
        this.gAh.a(this.gAp);
        if (this.mData != null) {
            this.gAh.setForumId(this.mData.getForumId());
        }
        this.gAi = new com.baidu.tieba.likedForum.a(this.mF.getUniqueId());
        this.gAi.a(this.bpf);
        this.gAj = new com.baidu.tbadk.core.view.a(this.mF);
        this.gAj.c(this.gAq);
        bxv();
    }

    private void bxv() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.mF.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.aaq = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxw() {
        if (this.gAk && this.gAl && !this.gAm) {
            this.gAm = true;
            this.gAj.aH(false);
            ArrayList arrayList = new ArrayList();
            if (v.u(this.gAn) > 0) {
                for (SimpleForum simpleForum : this.gAn) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !cV(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.u(this.gAo) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.gAo) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !cV(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            bxx();
        }
    }

    private boolean cV(long j) {
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

    private void bxx() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mF.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
        selectForumActivityConfig.setForumList((ArrayList) this.mDataList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void destroy() {
        if (this.gAh != null) {
            this.gAh.destroy();
        }
        if (this.gAi != null) {
            this.gAi.destroy();
        }
    }

    public String getRecommendExt() {
        return this.gAh.getRecommendExt();
    }

    public void co(String str, String str2) {
        if (this.gAk && this.gAl) {
            bxx();
        } else if (!k.hz()) {
            this.mF.showToast(d.l.neterror);
        } else {
            if (!this.gAk) {
                this.gAh.setThreadTitle(str);
                this.gAh.setThreadContent(str2);
                this.gAh.PP();
            }
            if (!this.gAl) {
                this.gAi.Fu();
            }
            this.gAj.c(null);
            this.gAj.aH(true);
        }
    }

    public void ae(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST);
        if (parcelableArrayListExtra != null) {
            this.mDataList.clear();
            this.mDataList.addAll(parcelableArrayListExtra);
        }
    }

    public String bxy() {
        ArrayList arrayList = new ArrayList();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.checked) {
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

    public String bxz() {
        ArrayList arrayList = new ArrayList();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.checked) {
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
                sb.append(transmitForumData2.forumName + this.mF.getResources().getString(d.l.forum));
            }
        }
        return sb.toString();
    }

    public boolean bxA() {
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.checked) {
                return true;
            }
        }
        return false;
    }
}
