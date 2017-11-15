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
    private com.baidu.tieba.write.transmit.model.a gPX;
    private com.baidu.tieba.likedForum.a gPY;
    private com.baidu.tbadk.core.view.a gPZ;
    private List<SimpleForum> gQd;
    private List<ForumInfo> gQe;
    private WriteData mData;
    private TbPageContext mPageContext;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean gQa = false;
    private boolean gQb = false;
    private boolean gQc = false;
    private a.InterfaceC0143a gQf = new a.InterfaceC0143a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0143a
        public void bCo() {
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0143a
        public void B(List<SimpleForum> list) {
            a.this.gQa = true;
            a.this.gQd = list;
            a.this.bCj();
        }
    };
    private a.InterfaceC0104a bsB = new a.InterfaceC0104a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0104a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            a.this.gQb = true;
            a.this.gQe = list;
            a.this.bCj();
        }
    };
    private DialogInterface.OnCancelListener gQg = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.gPX != null) {
                a.this.gPX.akY();
            }
            if (a.this.gPY != null) {
                a.this.gPY.akY();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.gPZ = null;
        this.mPageContext = tbPageContext;
        this.mData = writeData;
        this.gPX = new com.baidu.tieba.write.transmit.model.a(this.mPageContext.getUniqueId());
        this.gPX.a(this.gQf);
        if (this.mData != null) {
            this.gPX.setForumId(this.mData.getForumId());
        }
        this.gPY = new com.baidu.tieba.likedForum.a(this.mPageContext.getUniqueId());
        this.gPY.a(this.bsB);
        this.gPZ = new com.baidu.tbadk.core.view.a(this.mPageContext);
        this.gPZ.c(this.gQg);
        bCi();
    }

    private void bCi() {
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
    public void bCj() {
        if (this.gQa && this.gQb && !this.gQc) {
            this.gQc = true;
            this.gPZ.aE(false);
            ArrayList arrayList = new ArrayList();
            if (v.u(this.gQd) > 0) {
                for (SimpleForum simpleForum : this.gQd) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !cX(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.u(this.gQe) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.gQe) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !cX(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            bCk();
        }
    }

    private boolean cX(long j) {
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

    private void bCk() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mPageContext.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
        selectForumActivityConfig.setForumList((ArrayList) this.mDataList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void destroy() {
        if (this.gPX != null) {
            this.gPX.destroy();
        }
        if (this.gPY != null) {
            this.gPY.destroy();
        }
    }

    public String getRecommendExt() {
        return this.gPX.getRecommendExt();
    }

    public void cn(String str, String str2) {
        if (this.gQa && this.gQb) {
            bCk();
        } else if (!l.hy()) {
            this.mPageContext.showToast(d.j.neterror);
        } else {
            if (!this.gQa) {
                this.gPX.setThreadTitle(str);
                this.gPX.setThreadContent(str2);
                this.gPX.RG();
            }
            if (!this.gQb) {
                this.gPY.Fr();
            }
            this.gPZ.c(null);
            this.gPZ.aE(true);
        }
    }

    public void aa(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST);
        if (parcelableArrayListExtra != null) {
            this.mDataList.clear();
            this.mDataList.addAll(parcelableArrayListExtra);
        }
    }

    public String bCl() {
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

    public String bCm() {
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

    public boolean bCn() {
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.checked) {
                return true;
            }
        }
        return false;
    }
}
