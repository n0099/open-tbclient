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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> aQp;
    private com.baidu.tieba.tbadkCore.d.b dmS;
    private int fDq;
    private AntiData fEu;
    private boolean fEv;
    private PbFakeFloorModel fLA;
    private m fUM;
    private PbFakeFloorModel.a fUP;
    private com.baidu.adp.framework.listener.a fUQ;
    private boolean fXA;
    private SubPbRequestMessage fXB;
    private boolean fXk;
    private String fXl;
    private String fXm;
    private String fXn;
    private boolean fXo;
    private String fXp;
    private a fXq;
    private int fXr;
    private ArrayList<IconData> fXs;
    private boolean fXt;
    private ArrayList<m> fXu;
    private SmallTailInfo fXv;
    private boolean fXw;
    private ArrayList<String> fXx;
    private ConcurrentHashMap<String, ImageUrlData> fXy;
    private boolean fXz;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, int i, String str, m mVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fXn = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fXk = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fXl = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fXo = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fXm = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fDq = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fXv = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fXv != null) {
                this.fXv.updateShowInfo();
            }
            this.fEu = (AntiData) intent.getSerializableExtra("anti");
            this.fXs = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fXt = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fXy = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fXy.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fXx = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fXz = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fXn = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fXk = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fXl = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fXo = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fXm = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fDq = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fXv = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fXv != null) {
                this.fXv.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.fEu = new AntiData();
                this.fEu.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.E(stringArrayList)) {
                this.fXs = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fXs.add(iconData);
                    }
                }
            }
            this.fXt = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void x(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fXk);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fXl);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fXm);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fXo);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fDq);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fXv));
            if (this.fEu != null) {
                bundle.putSerializable("anti", this.fEu.toJsonString());
            }
            if (!v.E(this.fXs)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fXs.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fXn);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.fXk = false;
        this.fXl = null;
        this.fXm = null;
        this.pageFromType = 0;
        this.fXo = false;
        this.fEv = false;
        this.fDq = 0;
        this.fXp = null;
        this.aQp = null;
        this.fUM = null;
        this.fXq = null;
        this.fXr = 0;
        this.fXt = false;
        this.fXu = null;
        this.isLoading = false;
        this.dmS = null;
        this.fXz = true;
        this.mOffset = 0;
        this.fLA = null;
        this.fUP = null;
        this.fXA = false;
        this.fUQ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                m mVar;
                long j2;
                long j3;
                long j4 = 0;
                String str = null;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.aQp.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.g(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.g(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.fXu != null && SubPbModel.this.fXu.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fXu.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.fXu.get(size);
                                if (SubPbModel.this.fXw) {
                                    SubPbModel.this.fUM.c(mVar2, true);
                                } else {
                                    SubPbModel.this.fUM.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fXu.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.dmS == null) {
                        SubPbModel.this.dmS = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.dmS != null) {
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
                            SubPbModel.this.dmS.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.dmS = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.dmS = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fXq != null) {
                                SubPbModel.this.fXq.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aZs().errorno.intValue() != 0) {
                                if (SubPbModel.this.fXq != null) {
                                    SubPbModel.this.fXq.a(false, mVar.fEw.errorno.intValue(), mVar.fEw.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.VK() != null && mVar.VK().yS() != null) {
                                str = mVar.VK().yS().getUserId();
                                if (v.E(mVar.aZt().yS().getIconInfo()) && SubPbModel.this.fXs != null) {
                                    mVar.aZt().yS().setIconInfo(SubPbModel.this.fXs);
                                }
                            }
                            if (!SubPbModel.this.fXw) {
                                for (int i2 = 0; i2 < mVar.aZx().size(); i2++) {
                                    mVar.aZx().get(i2).b(SubPbModel.this.aQp, str.equals(mVar.aZx().get(i2).yS().getUserId()));
                                }
                            }
                            if (mVar.aZt() != null) {
                                SubPbModel.this.postID = mVar.aZt().getId();
                            }
                            if (mVar.VK() != null) {
                                SubPbModel.this.threadID = mVar.VK().getId();
                                SubPbModel.this.fEv = mVar.vk();
                                SubPbModel.this.fXp = mVar.VK().zc();
                            }
                            if (SubPbModel.this.fXp != null && SubPbModel.this.postID != null && SubPbModel.this.fXp.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fEv = true;
                            }
                            if (SubPbModel.this.fXw) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.fXq != null) {
                                SubPbModel.this.fXq.a(SubPbModel.this.bfl(), error, errorString, SubPbModel.this.fUM);
                            }
                        }
                    }
                }
            }
        };
        this.aQp = tbPageContext;
        this.fXu = new ArrayList<>();
        this.fUM = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fUQ);
        registerListener(this.fUQ);
    }

    public String bbF() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String KO() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m bfk() {
        return this.fUM;
    }

    public AntiData aZB() {
        return this.fEu;
    }

    public boolean bfl() {
        return (this.fUM == null || this.fUM.aZt() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fXq = aVar;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(postData.bvH());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fUQ);
        if (this.fLA != null) {
            this.fLA.unRegisterListener();
        }
        apY();
    }

    private void apY() {
        if (this.dmS != null) {
            this.dmS.destory();
            this.dmS = null;
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

    public void qv(String str) {
        if (!TextUtils.isEmpty(str) && this.fUM != null && this.fUM.aZx() != null) {
            ArrayList<PostData> aZx = this.fUM.aZx();
            int size = aZx.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aZx.get(i).getId())) {
                    aZx.remove(i);
                    this.fXr++;
                    this.fUM.setTotalCount(this.fUM.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bfm() {
        int RW = this.fUM.RW();
        if (RW == 0) {
            return RW + 1;
        }
        if (this.mLoadType == 0) {
            return RW + 1;
        }
        if (this.mLoadType == 2 && this.fUM.aZx().size() != 0 && this.fUM.aZx().size() % this.fUM.aZz() == 0) {
            return RW + 1;
        }
        if (this.mLoadType == 3 && this.fXw) {
            return this.fUM.aZv() - 1;
        }
        if (this.mLoadType == 3 && RW > 0) {
            return this.fUM.aZu() - 1;
        }
        return RW;
    }

    private SubPbRequestMessage beA() {
        this.isLoading = true;
        return i((Integer) null);
    }

    private SubPbRequestMessage i(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ao = l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = l.aq(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = bfm();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fXw && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aQp.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ao, aq, f, this.stType, i2);
    }

    public boolean MO() {
        return ti(0);
    }

    public boolean bfn() {
        return ti(2);
    }

    public void bfo() {
        int aZz;
        if (this.fXr > 0 && this.fUM != null && (aZz = this.fUM.aZz()) > 0) {
            int RW = this.fUM.RW();
            for (int i = (((this.fXr + aZz) - 1) / aZz) - 1; i >= 0; i--) {
                this.fXB = i(Integer.valueOf(RW - i));
                this.fXB.setTreatDelPage(true);
                sendMessage(this.fXB);
            }
        }
        this.fXr = 0;
    }

    public boolean bfp() {
        return ti(1);
    }

    public boolean ti(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bfo();
        this.mLoadType = i;
        this.fXB = beA();
        sendMessage(this.fXB);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aZx = mVar.aZx();
        if (aZx == null || aZx.size() == 0) {
            mVar.eW(this.fUM.RW());
        }
        if (this.mLoadType == 1) {
            this.fUM = mVar;
        } else if (this.mLoadType == 2) {
            this.fUM.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.fUM.a(mVar, false);
        } else {
            this.fUM.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.fUM = mVar;
            this.fUM.aZw();
        } else if (this.mLoadType == 2) {
            this.fUM.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.fUM.d(mVar, false);
        } else {
            this.fUM.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.VK() == null || mVar.VK().yS() == null) {
            str = null;
        } else {
            str = mVar.VK().yS().getUserId();
        }
        if (!this.fXw) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aZx().size()) {
                    break;
                }
                mVar.aZx().get(i2).b(this.aQp, str.equals(mVar.aZx().get(i2).yS().getUserId()));
                i = i2 + 1;
            }
        }
        this.fXu.add(mVar);
    }

    public boolean beO() {
        return this.fXk;
    }

    public boolean isMarked() {
        return this.fEv;
    }

    public boolean bfq() {
        return "hot_topic".equals(getStType());
    }

    public void kW(boolean z) {
        this.fEv = z;
    }

    public int aYS() {
        return this.fDq;
    }

    public String bfr() {
        return this.fXp;
    }

    public void qw(String str) {
        this.fXp = str;
    }

    public String bfs() {
        return this.fXm;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ga(String str) {
        if (this.fUM == null || this.fUM.aZA() == null || this.fUM.VK() == null || this.fUM.aZt() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fUM.aZA().getName());
        writeData.setForumId(this.fUM.aZA().getId());
        writeData.setFloor(this.fUM.aZt().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fUM.VK().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean KN() {
        if (this.fXA) {
            bfu();
        } else {
            bfn();
        }
        return true;
    }

    public boolean bft() {
        return this.fXA;
    }

    public void kX(boolean z) {
        this.fXA = z;
    }

    private void bfu() {
        if (this.fLA == null) {
            this.fLA = new PbFakeFloorModel(this.aQp);
            this.fLA.setUniqueId(BdUniqueId.gen());
            this.fLA.d(this.fUM);
            this.fLA.setPostId(this.postID);
            this.fLA.a(this.fUP);
        }
        this.fLA.bez();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fUP = aVar;
    }

    public SmallTailInfo bfv() {
        return this.fXv;
    }

    public boolean bfw() {
        return this.fXt;
    }

    public ConcurrentHashMap<String, ImageUrlData> bfx() {
        return this.fXy;
    }

    public ArrayList<String> bfy() {
        return this.fXx;
    }

    public boolean bfz() {
        return this.fXz;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String bfA() {
        return this.fXn;
    }
}
