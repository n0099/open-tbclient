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
    private com.baidu.tieba.write.transmit.model.a gOP;
    private com.baidu.tieba.likedForum.a gOQ;
    private com.baidu.tbadk.core.view.a gOR;
    private List<SimpleForum> gOV;
    private List<ForumInfo> gOW;
    private WriteData mData;
    private TbPageContext mPageContext;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean gOS = false;
    private boolean gOT = false;
    private boolean gOU = false;
    private a.InterfaceC0140a gOX = new a.InterfaceC0140a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0140a
        public void bCc() {
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0140a
        public void B(List<SimpleForum> list) {
            a.this.gOS = true;
            a.this.gOV = list;
            a.this.bBX();
        }
    };
    private a.InterfaceC0104a bsr = new a.InterfaceC0104a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0104a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            a.this.gOT = true;
            a.this.gOW = list;
            a.this.bBX();
        }
    };
    private DialogInterface.OnCancelListener gOY = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.gOP != null) {
                a.this.gOP.akK();
            }
            if (a.this.gOQ != null) {
                a.this.gOQ.akK();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.gOR = null;
        this.mPageContext = tbPageContext;
        this.mData = writeData;
        this.gOP = new com.baidu.tieba.write.transmit.model.a(this.mPageContext.getUniqueId());
        this.gOP.a(this.gOX);
        if (this.mData != null) {
            this.gOP.setForumId(this.mData.getForumId());
        }
        this.gOQ = new com.baidu.tieba.likedForum.a(this.mPageContext.getUniqueId());
        this.gOQ.a(this.bsr);
        this.gOR = new com.baidu.tbadk.core.view.a(this.mPageContext);
        this.gOR.c(this.gOY);
        bBW();
    }

    private void bBW() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.mPageContext.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.aaB = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBX() {
        if (this.gOS && this.gOT && !this.gOU) {
            this.gOU = true;
            this.gOR.aE(false);
            ArrayList arrayList = new ArrayList();
            if (v.u(this.gOV) > 0) {
                for (SimpleForum simpleForum : this.gOV) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !cV(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.u(this.gOW) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.gOW) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !cV(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            bBY();
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

    private void bBY() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mPageContext.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
        selectForumActivityConfig.setForumList((ArrayList) this.mDataList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void destroy() {
        if (this.gOP != null) {
            this.gOP.destroy();
        }
        if (this.gOQ != null) {
            this.gOQ.destroy();
        }
    }

    public String getRecommendExt() {
        return this.gOP.getRecommendExt();
    }

    public void cj(String str, String str2) {
        if (this.gOS && this.gOT) {
            bBY();
        } else if (!l.hy()) {
            this.mPageContext.showToast(d.j.neterror);
        } else {
            if (!this.gOS) {
                this.gOP.setThreadTitle(str);
                this.gOP.setThreadContent(str2);
                this.gOP.Rx();
            }
            if (!this.gOT) {
                this.gOQ.Ff();
            }
            this.gOR.c(null);
            this.gOR.aE(true);
        }
    }

    public void aa(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST);
        if (parcelableArrayListExtra != null) {
            this.mDataList.clear();
            this.mDataList.addAll(parcelableArrayListExtra);
        }
    }

    public String bBZ() {
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

    public String bCa() {
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
                sb.append(transmitForumData2.forumName + this.mPageContext.getResources().getString(d.j.forum));
            }
        }
        return sb.toString();
    }

    public boolean bCb() {
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.checked) {
                return true;
            }
        }
        return false;
    }
}
