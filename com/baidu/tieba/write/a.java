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
    private TbPageContext ako;
    private com.baidu.tieba.write.transmit.model.a gxK;
    private com.baidu.tieba.likedForum.a gxL;
    private com.baidu.tbadk.core.view.a gxM;
    private List<SimpleForum> gxQ;
    private List<ForumInfo> gxR;
    private WriteData mData;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean gxN = false;
    private boolean gxO = false;
    private boolean gxP = false;
    private a.InterfaceC0126a gxS = new a.InterfaceC0126a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void bxt() {
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0126a
        public void B(List<SimpleForum> list) {
            a.this.gxN = true;
            a.this.gxQ = list;
            a.this.bxo();
        }
    };
    private a.InterfaceC0105a bmK = new a.InterfaceC0105a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0105a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            a.this.gxO = true;
            a.this.gxR = list;
            a.this.bxo();
        }
    };
    private DialogInterface.OnCancelListener gxT = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.gxK != null) {
                a.this.gxK.aDC();
            }
            if (a.this.gxL != null) {
                a.this.gxL.aDC();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.gxM = null;
        this.ako = tbPageContext;
        this.mData = writeData;
        this.gxK = new com.baidu.tieba.write.transmit.model.a(this.ako.getUniqueId());
        this.gxK.a(this.gxS);
        if (this.mData != null) {
            this.gxK.setForumId(this.mData.getForumId());
        }
        this.gxL = new com.baidu.tieba.likedForum.a(this.ako.getUniqueId());
        this.gxL.a(this.bmK);
        this.gxM = new com.baidu.tbadk.core.view.a(this.ako);
        this.gxM.c(this.gxT);
        bxn();
    }

    private void bxn() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.ako.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.ZN = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxo() {
        if (this.gxN && this.gxO && !this.gxP) {
            this.gxP = true;
            this.gxM.aH(false);
            ArrayList arrayList = new ArrayList();
            if (u.u(this.gxQ) > 0) {
                for (SimpleForum simpleForum : this.gxQ) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !da(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (u.u(this.gxR) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.gxR) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !da(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            bxp();
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

    private void bxp() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.ako.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
        selectForumActivityConfig.setForumList((ArrayList) this.mDataList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void destroy() {
        if (this.gxK != null) {
            this.gxK.destroy();
        }
        if (this.gxL != null) {
            this.gxL.destroy();
        }
    }

    public String getRecommendExt() {
        return this.gxK.getRecommendExt();
    }

    public void cm(String str, String str2) {
        if (this.gxN && this.gxO) {
            bxp();
        } else if (!k.hy()) {
            this.ako.showToast(d.l.neterror);
        } else {
            if (!this.gxN) {
                this.gxK.setThreadTitle(str);
                this.gxK.setThreadContent(str2);
                this.gxK.Pm();
            }
            if (!this.gxO) {
                this.gxL.Fo();
            }
            this.gxM.c(null);
            this.gxM.aH(true);
        }
    }

    public void ac(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST);
        if (parcelableArrayListExtra != null) {
            this.mDataList.clear();
            this.mDataList.addAll(parcelableArrayListExtra);
        }
    }

    public String bxq() {
        ArrayList arrayList = new ArrayList();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.ZM) {
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

    public String bxr() {
        ArrayList arrayList = new ArrayList();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.ZM) {
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
                sb.append(transmitForumData2.forumName + this.ako.getResources().getString(d.l.bar));
            }
        }
        return sb.toString();
    }

    public boolean bxs() {
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.ZM) {
                return true;
            }
        }
        return false;
    }
}
