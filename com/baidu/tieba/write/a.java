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
    private com.baidu.tieba.write.transmit.model.a gEZ;
    private com.baidu.tieba.likedForum.a gFa;
    private com.baidu.tbadk.core.view.a gFb;
    private List<SimpleForum> gFf;
    private List<ForumInfo> gFg;
    private WriteData mData;
    private TbPageContext mH;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean gFc = false;
    private boolean gFd = false;
    private boolean gFe = false;
    private a.InterfaceC0139a gFh = new a.InterfaceC0139a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0139a
        public void byJ() {
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0139a
        public void A(List<SimpleForum> list) {
            a.this.gFc = true;
            a.this.gFf = list;
            a.this.byE();
        }
    };
    private a.InterfaceC0106a bqC = new a.InterfaceC0106a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0106a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            a.this.gFd = true;
            a.this.gFg = list;
            a.this.byE();
        }
    };
    private DialogInterface.OnCancelListener gFi = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.gEZ != null) {
                a.this.gEZ.aiy();
            }
            if (a.this.gFa != null) {
                a.this.gFa.aiy();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.gFb = null;
        this.mH = tbPageContext;
        this.mData = writeData;
        this.gEZ = new com.baidu.tieba.write.transmit.model.a(this.mH.getUniqueId());
        this.gEZ.a(this.gFh);
        if (this.mData != null) {
            this.gEZ.setForumId(this.mData.getForumId());
        }
        this.gFa = new com.baidu.tieba.likedForum.a(this.mH.getUniqueId());
        this.gFa.a(this.bqC);
        this.gFb = new com.baidu.tbadk.core.view.a(this.mH);
        this.gFb.c(this.gFi);
        byD();
    }

    private void byD() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.mH.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.aae = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byE() {
        if (this.gFc && this.gFd && !this.gFe) {
            this.gFe = true;
            this.gFb.aG(false);
            ArrayList arrayList = new ArrayList();
            if (v.t(this.gFf) > 0) {
                for (SimpleForum simpleForum : this.gFf) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !cU(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.t(this.gFg) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.gFg) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !cU(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            byF();
        }
    }

    private boolean cU(long j) {
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

    private void byF() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mH.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
        selectForumActivityConfig.setForumList((ArrayList) this.mDataList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void destroy() {
        if (this.gEZ != null) {
            this.gEZ.destroy();
        }
        if (this.gFa != null) {
            this.gFa.destroy();
        }
    }

    public String getRecommendExt() {
        return this.gEZ.getRecommendExt();
    }

    public void cm(String str, String str2) {
        if (this.gFc && this.gFd) {
            byF();
        } else if (!l.hy()) {
            this.mH.showToast(d.l.neterror);
        } else {
            if (!this.gFc) {
                this.gEZ.setThreadTitle(str);
                this.gEZ.setThreadContent(str2);
                this.gEZ.Qf();
            }
            if (!this.gFd) {
                this.gFa.ET();
            }
            this.gFb.c(null);
            this.gFb.aG(true);
        }
    }

    public void aa(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST);
        if (parcelableArrayListExtra != null) {
            this.mDataList.clear();
            this.mDataList.addAll(parcelableArrayListExtra);
        }
    }

    public String byG() {
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

    public String byH() {
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
                sb.append(transmitForumData2.forumName + this.mH.getResources().getString(d.l.forum));
            }
        }
        return sb.toString();
    }

    public boolean byI() {
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.checked) {
                return true;
            }
        }
        return false;
    }
}
