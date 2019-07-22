package com.baidu.tieba.pb.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private AntiData cfT;
    private com.baidu.tieba.tbadkCore.d.b eYu;
    private int hHr;
    private boolean hIz;
    private PbFakeFloorModel hOQ;
    private k hYD;
    private PbFakeFloorModel.a hYG;
    private com.baidu.adp.framework.listener.a hYH;
    private String ibd;
    private boolean ibe;
    private String ibf;
    private String ibg;
    private String ibh;
    private String ibi;
    private String ibj;
    private boolean ibk;
    private String ibl;
    private a ibm;
    private int ibn;
    private ArrayList<IconData> ibo;
    private AttentionHostData ibp;
    private boolean ibq;
    private ArrayList<k> ibr;
    private SmallTailInfo ibs;
    private boolean ibt;
    private ArrayList<String> ibu;
    private ConcurrentHashMap<String, ImageUrlData> ibv;
    private boolean ibw;
    private boolean ibx;
    private SubPbRequestMessage iby;
    private boolean isLoading;
    private TbPageContext<?> mContext;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, int i, String str, k kVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.ibd = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.ibi = intent.getStringExtra("from_forum_id");
            this.ibj = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.ibe = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ibf = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ibk = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ibg = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hHr = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ibs = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.ibs != null) {
                this.ibs.updateShowInfo();
            }
            this.cfT = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.ibo = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.ibq = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.ibv = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.ibv.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.ibu = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.ibw = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.ibh = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.ibd = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.ibi = bundle.getString("from_forum_id");
            this.ibj = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.ibe = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ibf = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ibk = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ibg = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hHr = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.ibs = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.ibs != null) {
                this.ibs.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.cfT = new AntiData();
                this.cfT.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.aa(stringArrayList)) {
                this.ibo = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.ibo.add(iconData);
                    }
                }
            }
            this.ibq = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.ibh = bundle.getString("high_light_post_id");
        }
    }

    public void ab(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.ibd);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.ibe);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.ibf);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.ibg);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.ibk);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hHr);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.ibs));
            if (this.cfT != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.cfT.toJsonString());
            }
            if (!v.aa(this.ibo)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.ibo.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.ibi);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.ibj);
            bundle.putString("high_light_post_id", this.ibh);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.ibd = null;
        this.postID = null;
        this.stType = null;
        this.ibe = false;
        this.ibf = null;
        this.ibg = null;
        this.ibh = null;
        this.pageFromType = 0;
        this.ibk = false;
        this.hIz = false;
        this.hHr = 0;
        this.ibl = null;
        this.mContext = null;
        this.hYD = null;
        this.ibm = null;
        this.ibn = 0;
        this.ibq = false;
        this.ibr = null;
        this.isLoading = false;
        this.eYu = null;
        this.ibw = true;
        this.mOffset = 0;
        this.hOQ = null;
        this.hYG = null;
        this.ibx = false;
        this.hYH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                k kVar;
                long j2;
                long j3;
                long j4 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.mContext.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.ibr.add(subPbHttpResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                        j = costTime;
                        z = true;
                    } else {
                        j = 0;
                        z = false;
                    }
                    if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        j4 = responsedMessage.getCostTime();
                        SubPbSocketResponseMessage subPbSocketResponseMessage = (SubPbSocketResponseMessage) responsedMessage;
                        if (subPbSocketResponseMessage.isTreatDelPage()) {
                            if (!subPbSocketResponseMessage.hasError()) {
                                SubPbModel.this.ibr.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.ibr != null && SubPbModel.this.ibr.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.ibr.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.ibr.get(size);
                                if (SubPbModel.this.ibt) {
                                    SubPbModel.this.hYD.c(kVar2, true);
                                } else {
                                    SubPbModel.this.hYD.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.ibr.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.eYu == null) {
                        SubPbModel.this.eYu = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.eYu != null) {
                        if (error == 0) {
                            int i = -1;
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                i = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                                j2 = j4;
                                j3 = responsedMessage.getCostTime();
                            } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                                i = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                                j2 = responsedMessage.getCostTime();
                                j3 = j;
                            } else {
                                j2 = j4;
                                j3 = j;
                            }
                            SubPbModel.this.eYu.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.eYu = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.eYu = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.ibm != null) {
                                SubPbModel.this.ibm.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bTf().errorno.intValue() != 0) {
                                if (SubPbModel.this.ibm != null) {
                                    SubPbModel.this.ibm.a(false, kVar.hIA.errorno.intValue(), kVar.hIA.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.acx() != null && kVar.acx().aex() != null) {
                                kVar.acx().aex().getUserId();
                                if (v.aa(kVar.bTg().aex().getIconInfo()) && SubPbModel.this.ibo != null) {
                                    kVar.bTg().aex().setIconInfo(SubPbModel.this.ibo);
                                }
                            }
                            if (kVar.bTg() != null) {
                                SubPbModel.this.postID = kVar.bTg().getId();
                            }
                            if (kVar.acx() != null) {
                                SubPbModel.this.ibd = kVar.acx().getId();
                                SubPbModel.this.hIz = kVar.aaB();
                                SubPbModel.this.ibl = kVar.acx().aeG();
                            }
                            if (SubPbModel.this.ibl != null && SubPbModel.this.postID != null && SubPbModel.this.ibl.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hIz = true;
                            }
                            if (SubPbModel.this.ibt) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.ibm != null) {
                                SubPbModel.this.ibm.a(SubPbModel.this.bZn(), error, errorString, SubPbModel.this.hYD);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.ibr = new ArrayList<>();
        this.hYD = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hYH);
        registerListener(this.hYH);
    }

    public String bVv() {
        return this.ibd;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String asu() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bZm() {
        return this.hYD;
    }

    public AntiData blb() {
        return this.cfT;
    }

    public boolean bZn() {
        return (this.hYD == null || this.hYD.bTg() == null) ? false : true;
    }

    public void a(a aVar) {
        this.ibm = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ibd);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.ibd);
        markData.setFloor(postData.cpp());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hYH);
        if (this.hOQ != null) {
            this.hOQ.unRegisterListener();
        }
        bgq();
    }

    private void bgq() {
        if (this.eYu != null) {
            this.eYu.destory();
            this.eYu = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void Cq(String str) {
        if (!TextUtils.isEmpty(str) && this.hYD != null && this.hYD.bTk() != null) {
            ArrayList<PostData> bTk = this.hYD.bTk();
            int size = bTk.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bTk.get(i).getId())) {
                    bTk.remove(i);
                    this.ibn++;
                    this.hYD.setTotalCount(this.hYD.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bZo() {
        int aAL = this.hYD.aAL();
        if (aAL == 0) {
            return aAL + 1;
        }
        if (this.mLoadType == 0) {
            return aAL + 1;
        }
        if (this.mLoadType == 2 && this.hYD.bTk().size() != 0 && this.hYD.bTk().size() % this.hYD.getPageSize() == 0) {
            return aAL + 1;
        }
        if (this.mLoadType == 3 && this.ibt) {
            return this.hYD.bTi() - 1;
        }
        if (this.mLoadType == 3 && aAL > 0) {
            return this.hYD.bTh() - 1;
        }
        return aAL;
    }

    private SubPbRequestMessage bYz() {
        this.isLoading = true;
        return l(null);
    }

    private SubPbRequestMessage l(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = bZo();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.ibt && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.ibd), j, j2, i, af, ah, f, this.stType, i2);
    }

    public boolean auD() {
        return yp(0);
    }

    public boolean bZp() {
        return yp(2);
    }

    public void bZq() {
        int pageSize;
        if (this.ibn > 0 && this.hYD != null && (pageSize = this.hYD.getPageSize()) > 0) {
            int aAL = this.hYD.aAL();
            for (int i = (((this.ibn + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.iby = l(Integer.valueOf(aAL - i));
                this.iby.setTreatDelPage(true);
                sendMessage(this.iby);
            }
        }
        this.ibn = 0;
    }

    public boolean bZr() {
        return yp(1);
    }

    public boolean yp(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.ibd == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bZq();
        this.mLoadType = i;
        this.iby = bYz();
        sendMessage(this.iby);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bTk = kVar.bTk();
        if (bTk == null || bTk.size() == 0) {
            kVar.setCurrentPage(this.hYD.aAL());
        }
        if (this.mLoadType == 1) {
            this.hYD = kVar;
        } else if (this.mLoadType == 2) {
            this.hYD.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hYD.a(kVar, false);
        } else {
            this.hYD.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.hYD = kVar;
            this.hYD.bTj();
        } else if (this.mLoadType == 2) {
            this.hYD.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hYD.d(kVar, false);
        } else {
            this.hYD.a(kVar);
        }
    }

    public boolean bYP() {
        return this.ibe;
    }

    public boolean bZs() {
        return this.hIz;
    }

    public boolean bZt() {
        return "hot_topic".equals(getStType());
    }

    public void pr(boolean z) {
        this.hIz = z;
    }

    public int bSJ() {
        return this.hHr;
    }

    public String bZu() {
        return this.ibl;
    }

    public void Cr(String str) {
        this.ibl = str;
    }

    public String bZv() {
        return this.ibg;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData qm(String str) {
        if (this.hYD == null || this.hYD.bTm() == null || this.hYD.acx() == null || this.hYD.bTg() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hYD.bTm().getName());
        writeData.setForumId(this.hYD.bTm().getId());
        writeData.setFromForumId(this.ibj);
        writeData.setFloor(this.hYD.bTg().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hYD.acx().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean ast() {
        bZp();
        return true;
    }

    public boolean bZw() {
        return this.ibx;
    }

    public void ps(boolean z) {
        this.ibx = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hYG = aVar;
    }

    public SmallTailInfo bZx() {
        return this.ibs;
    }

    public boolean bZy() {
        return this.ibq;
    }

    public ConcurrentHashMap<String, ImageUrlData> bZz() {
        return this.ibv;
    }

    public ArrayList<String> bZA() {
        return this.ibu;
    }

    public boolean bZB() {
        return this.ibw;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.ibi;
    }

    public AttentionHostData bZC() {
        if (this.ibp == null) {
            this.ibp = new AttentionHostData();
            if (this.hYD != null && this.hYD.acx() != null && this.hYD.acx().aex() != null) {
                this.ibp.parserWithMetaData(this.hYD.acx().aex());
            }
        }
        return this.ibp;
    }

    public boolean bWl() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bVu() {
        return this.ibh;
    }
}
