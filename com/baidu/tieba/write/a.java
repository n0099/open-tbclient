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
    private com.baidu.tieba.write.transmit.model.a gzn;
    private com.baidu.tieba.likedForum.a gzo;
    private com.baidu.tbadk.core.view.a gzp;
    private List<SimpleForum> gzt;
    private List<ForumInfo> gzu;
    private WriteData mData;
    private TbPageContext mF;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean gzq = false;
    private boolean gzr = false;
    private boolean gzs = false;
    private a.InterfaceC0129a gzv = new a.InterfaceC0129a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0129a
        public void bxq() {
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0129a
        public void B(List<SimpleForum> list) {
            a.this.gzq = true;
            a.this.gzt = list;
            a.this.bxl();
        }
    };
    private a.InterfaceC0107a boS = new a.InterfaceC0107a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0107a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            a.this.gzr = true;
            a.this.gzu = list;
            a.this.bxl();
        }
    };
    private DialogInterface.OnCancelListener gzw = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.gzn != null) {
                a.this.gzn.aio();
            }
            if (a.this.gzo != null) {
                a.this.gzo.aio();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.gzp = null;
        this.mF = tbPageContext;
        this.mData = writeData;
        this.gzn = new com.baidu.tieba.write.transmit.model.a(this.mF.getUniqueId());
        this.gzn.a(this.gzv);
        if (this.mData != null) {
            this.gzn.setForumId(this.mData.getForumId());
        }
        this.gzo = new com.baidu.tieba.likedForum.a(this.mF.getUniqueId());
        this.gzo.a(this.boS);
        this.gzp = new com.baidu.tbadk.core.view.a(this.mF);
        this.gzp.c(this.gzw);
        bxk();
    }

    private void bxk() {
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
    public void bxl() {
        if (this.gzq && this.gzr && !this.gzs) {
            this.gzs = true;
            this.gzp.aH(false);
            ArrayList arrayList = new ArrayList();
            if (v.u(this.gzt) > 0) {
                for (SimpleForum simpleForum : this.gzt) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !cV(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.u(this.gzu) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.gzu) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !cV(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            bxm();
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

    private void bxm() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mF.getPageActivity(), 25018);
        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig);
        selectForumActivityConfig.setForumList((ArrayList) this.mDataList);
        MessageManager.getInstance().sendMessage(customMessage);
    }

    public void destroy() {
        if (this.gzn != null) {
            this.gzn.destroy();
        }
        if (this.gzo != null) {
            this.gzo.destroy();
        }
    }

    public String getRecommendExt() {
        return this.gzn.getRecommendExt();
    }

    public void co(String str, String str2) {
        if (this.gzq && this.gzr) {
            bxm();
        } else if (!k.hz()) {
            this.mF.showToast(d.l.neterror);
        } else {
            if (!this.gzq) {
                this.gzn.setThreadTitle(str);
                this.gzn.setThreadContent(str2);
                this.gzn.PN();
            }
            if (!this.gzr) {
                this.gzo.Fu();
            }
            this.gzp.c(null);
            this.gzp.aH(true);
        }
    }

    public void af(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST);
        if (parcelableArrayListExtra != null) {
            this.mDataList.clear();
            this.mDataList.addAll(parcelableArrayListExtra);
        }
    }

    public String bxn() {
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

    public String bxo() {
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

    public boolean bxp() {
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.checked) {
                return true;
            }
        }
        return false;
    }
}
