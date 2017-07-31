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
    private TbPageContext alI;
    private com.baidu.tieba.write.transmit.model.a gyV;
    private com.baidu.tieba.likedForum.a gyW;
    private com.baidu.tbadk.core.view.a gyX;
    private List<SimpleForum> gzb;
    private List<ForumInfo> gzc;
    private WriteData mData;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean gyY = false;
    private boolean gyZ = false;
    private boolean gza = false;
    private a.InterfaceC0125a gzd = new a.InterfaceC0125a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0125a
        public void bxA() {
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0125a
        public void B(List<SimpleForum> list) {
            a.this.gyY = true;
            a.this.gzb = list;
            a.this.bxv();
        }
    };
    private a.InterfaceC0104a bnU = new a.InterfaceC0104a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0104a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            a.this.gyZ = true;
            a.this.gzc = list;
            a.this.bxv();
        }
    };
    private DialogInterface.OnCancelListener gze = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.gyV != null) {
                a.this.gyV.aDN();
            }
            if (a.this.gyW != null) {
                a.this.gyW.aDN();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.gyX = null;
        this.alI = tbPageContext;
        this.mData = writeData;
        this.gyV = new com.baidu.tieba.write.transmit.model.a(this.alI.getUniqueId());
        this.gyV.a(this.gzd);
        if (this.mData != null) {
            this.gyV.setForumId(this.mData.getForumId());
        }
        this.gyW = new com.baidu.tieba.likedForum.a(this.alI.getUniqueId());
        this.gyW.a(this.bnU);
        this.gyX = new com.baidu.tbadk.core.view.a(this.alI);
        this.gyX.c(this.gze);
        bxu();
    }

    private void bxu() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.alI.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long d = com.baidu.adp.lib.g.b.d(this.mData.getForumId(), 0L);
            if (d > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(d, this.mData.getForumName(), true, 0, str);
                transmitForumData.abj = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxv() {
        if (this.gyY && this.gyZ && !this.gza) {
            this.gza = true;
            this.gyX.aH(false);
            ArrayList arrayList = new ArrayList();
            if (u.u(this.gzb) > 0) {
                for (SimpleForum simpleForum : this.gzb) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !da(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (u.u(this.gzc) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.gzc) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !da(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            bxw();
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

    private void bxw() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.alI.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
        selectForumActivityConfig.setForumList((ArrayList) this.mDataList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void destroy() {
        if (this.gyV != null) {
            this.gyV.destroy();
        }
        if (this.gyW != null) {
            this.gyW.destroy();
        }
    }

    public String getRecommendExt() {
        return this.gyV.getRecommendExt();
    }

    public void cm(String str, String str2) {
        if (this.gyY && this.gyZ) {
            bxw();
        } else if (!k.hI()) {
            this.alI.showToast(d.l.neterror);
        } else {
            if (!this.gyY) {
                this.gyV.setThreadTitle(str);
                this.gyV.setThreadContent(str2);
                this.gyV.Pr();
            }
            if (!this.gyZ) {
                this.gyW.Fw();
            }
            this.gyX.c(null);
            this.gyX.aH(true);
        }
    }

    public void ac(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST);
        if (parcelableArrayListExtra != null) {
            this.mDataList.clear();
            this.mDataList.addAll(parcelableArrayListExtra);
        }
    }

    public String bxx() {
        ArrayList arrayList = new ArrayList();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.abi) {
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

    public String bxy() {
        ArrayList arrayList = new ArrayList();
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.abi) {
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
                sb.append(transmitForumData2.forumName + this.alI.getResources().getString(d.l.bar));
            }
        }
        return sb.toString();
    }

    public boolean bxz() {
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.abi) {
                return true;
            }
        }
        return false;
    }
}
