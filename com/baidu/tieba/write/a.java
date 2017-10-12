package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
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
    private com.baidu.tieba.write.transmit.model.a gFo;
    private com.baidu.tieba.likedForum.a gFp;
    private com.baidu.tbadk.core.view.a gFq;
    private List<SimpleForum> gFu;
    private List<ForumInfo> gFv;
    private WriteData mData;
    private TbPageContext mG;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean gFr = false;
    private boolean gFs = false;
    private boolean gFt = false;
    private a.InterfaceC0139a gFw = new a.InterfaceC0139a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0139a
        public void byP() {
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0139a
        public void A(List<SimpleForum> list) {
            a.this.gFr = true;
            a.this.gFu = list;
            a.this.byK();
        }
    };
    private a.InterfaceC0106a bqO = new a.InterfaceC0106a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0106a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            a.this.gFs = true;
            a.this.gFv = list;
            a.this.byK();
        }
    };
    private DialogInterface.OnCancelListener gFx = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.gFo != null) {
                a.this.gFo.aiD();
            }
            if (a.this.gFp != null) {
                a.this.gFp.aiD();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.gFq = null;
        this.mG = tbPageContext;
        this.mData = writeData;
        this.gFo = new com.baidu.tieba.write.transmit.model.a(this.mG.getUniqueId());
        this.gFo.a(this.gFw);
        if (this.mData != null) {
            this.gFo.setForumId(this.mData.getForumId());
        }
        this.gFp = new com.baidu.tieba.likedForum.a(this.mG.getUniqueId());
        this.gFp.a(this.bqO);
        this.gFq = new com.baidu.tbadk.core.view.a(this.mG);
        this.gFq.c(this.gFx);
        byJ();
    }

    private void byJ() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.mG.getPageActivity().getIntent();
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
    public void byK() {
        if (this.gFr && this.gFs && !this.gFt) {
            this.gFt = true;
            this.gFq.aH(false);
            ArrayList arrayList = new ArrayList();
            if (v.t(this.gFu) > 0) {
                for (SimpleForum simpleForum : this.gFu) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !cT(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.t(this.gFv) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.gFv) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !cT(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            byL();
        }
    }

    private boolean cT(long j) {
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

    private void byL() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mG.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
        selectForumActivityConfig.setForumList((ArrayList) this.mDataList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void destroy() {
        if (this.gFo != null) {
            this.gFo.destroy();
        }
        if (this.gFp != null) {
            this.gFp.destroy();
        }
    }

    public String getRecommendExt() {
        return this.gFo.getRecommendExt();
    }

    public void cn(String str, String str2) {
        if (this.gFr && this.gFs) {
            byL();
        } else if (!l.hy()) {
            this.mG.showToast(d.l.neterror);
        } else {
            if (!this.gFr) {
                this.gFo.setThreadTitle(str);
                this.gFo.setThreadContent(str2);
                this.gFo.Qj();
            }
            if (!this.gFs) {
                this.gFp.EZ();
            }
            this.gFq.c(null);
            this.gFq.aH(true);
        }
    }

    public void aa(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST);
        if (parcelableArrayListExtra != null) {
            this.mDataList.clear();
            this.mDataList.addAll(parcelableArrayListExtra);
        }
    }

    public String byM() {
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

    public String byN() {
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
                sb.append(transmitForumData2.forumName + this.mG.getResources().getString(d.l.forum));
            }
        }
        return sb.toString();
    }

    public boolean byO() {
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.checked) {
                return true;
            }
        }
        return false;
    }
}
