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
    private TbPageContext<?> aQq;
    private com.baidu.tieba.tbadkCore.d.b dir;
    private int fBQ;
    private AntiData fCU;
    private boolean fCV;
    private PbFakeFloorModel fKa;
    private m fTm;
    private PbFakeFloorModel.a fTp;
    private com.baidu.adp.framework.listener.a fTq;
    private boolean fVK;
    private String fVL;
    private String fVM;
    private String fVN;
    private boolean fVO;
    private String fVP;
    private a fVQ;
    private int fVR;
    private ArrayList<IconData> fVS;
    private boolean fVT;
    private ArrayList<m> fVU;
    private SmallTailInfo fVV;
    private boolean fVW;
    private ArrayList<String> fVX;
    private ConcurrentHashMap<String, ImageUrlData> fVY;
    private boolean fVZ;
    private boolean fWa;
    private SubPbRequestMessage fWb;
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
            this.fVN = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fVK = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fVL = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fVO = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fVM = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fBQ = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fVV = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fVV != null) {
                this.fVV.updateShowInfo();
            }
            this.fCU = (AntiData) intent.getSerializableExtra("anti");
            this.fVS = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fVT = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fVY = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fVY.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fVX = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fVZ = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
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
            this.fVN = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fVK = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fVL = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fVO = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fVM = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fBQ = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fVV = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fVV != null) {
                this.fVV.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.fCU = new AntiData();
                this.fCU.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.G(stringArrayList)) {
                this.fVS = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fVS.add(iconData);
                    }
                }
            }
            this.fVT = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void x(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fVK);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fVL);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fVM);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fVO);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fBQ);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fVV));
            if (this.fCU != null) {
                bundle.putSerializable("anti", this.fCU.toJsonString());
            }
            if (!v.G(this.fVS)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fVS.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fVN);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.fVK = false;
        this.fVL = null;
        this.fVM = null;
        this.pageFromType = 0;
        this.fVO = false;
        this.fCV = false;
        this.fBQ = 0;
        this.fVP = null;
        this.aQq = null;
        this.fTm = null;
        this.fVQ = null;
        this.fVR = 0;
        this.fVT = false;
        this.fVU = null;
        this.isLoading = false;
        this.dir = null;
        this.fVZ = true;
        this.mOffset = 0;
        this.fKa = null;
        this.fTp = null;
        this.fWa = false;
        this.fTq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.aQq.getPageActivity().finish();
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
                    if (SubPbModel.this.fVU != null && SubPbModel.this.fVU.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fVU.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.fVU.get(size);
                                if (SubPbModel.this.fVW) {
                                    SubPbModel.this.fTm.c(mVar2, true);
                                } else {
                                    SubPbModel.this.fTm.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fVU.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.dir == null) {
                        SubPbModel.this.dir = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.dir != null) {
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
                            SubPbModel.this.dir.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.dir = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.dir = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fVQ != null) {
                                SubPbModel.this.fVQ.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aZo().errorno.intValue() != 0) {
                                if (SubPbModel.this.fVQ != null) {
                                    SubPbModel.this.fVQ.a(false, mVar.fCW.errorno.intValue(), mVar.fCW.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.VW() != null && mVar.VW().yX() != null) {
                                str = mVar.VW().yX().getUserId();
                                if (v.G(mVar.aZp().yX().getIconInfo()) && SubPbModel.this.fVS != null) {
                                    mVar.aZp().yX().setIconInfo(SubPbModel.this.fVS);
                                }
                            }
                            if (!SubPbModel.this.fVW) {
                                for (int i2 = 0; i2 < mVar.aZt().size(); i2++) {
                                    mVar.aZt().get(i2).b(SubPbModel.this.aQq, str.equals(mVar.aZt().get(i2).yX().getUserId()));
                                }
                            }
                            if (mVar.aZp() != null) {
                                SubPbModel.this.postID = mVar.aZp().getId();
                            }
                            if (mVar.VW() != null) {
                                SubPbModel.this.threadID = mVar.VW().getId();
                                SubPbModel.this.fCV = mVar.vk();
                                SubPbModel.this.fVP = mVar.VW().zh();
                            }
                            if (SubPbModel.this.fVP != null && SubPbModel.this.postID != null && SubPbModel.this.fVP.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fCV = true;
                            }
                            if (SubPbModel.this.fVW) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.fVQ != null) {
                                SubPbModel.this.fVQ.a(SubPbModel.this.bfh(), error, errorString, SubPbModel.this.fTm);
                            }
                        }
                    }
                }
            }
        };
        this.aQq = tbPageContext;
        this.fVU = new ArrayList<>();
        this.fTm = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fTq);
        registerListener(this.fTq);
    }

    public String bbB() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String KZ() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m bfg() {
        return this.fTm;
    }

    public AntiData aZx() {
        return this.fCU;
    }

    public boolean bfh() {
        return (this.fTm == null || this.fTm.aZp() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fVQ = aVar;
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
        markData.setFloor(postData.bCl());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fTq);
        if (this.fKa != null) {
            this.fKa.unRegisterListener();
        }
        aoV();
    }

    private void aoV() {
        if (this.dir != null) {
            this.dir.destory();
            this.dir = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.mLoadType;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void qt(String str) {
        if (!TextUtils.isEmpty(str) && this.fTm != null && this.fTm.aZt() != null) {
            ArrayList<PostData> aZt = this.fTm.aZt();
            int size = aZt.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aZt.get(i).getId())) {
                    aZt.remove(i);
                    this.fVR++;
                    this.fTm.setTotalCount(this.fTm.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bfi() {
        int Si = this.fTm.Si();
        if (Si == 0) {
            return Si + 1;
        }
        if (this.mLoadType == 0) {
            return Si + 1;
        }
        if (this.mLoadType == 2 && this.fTm.aZt().size() != 0 && this.fTm.aZt().size() % this.fTm.aZv() == 0) {
            return Si + 1;
        }
        if (this.mLoadType == 3 && this.fVW) {
            return this.fTm.aZr() - 1;
        }
        if (this.mLoadType == 3 && Si > 0) {
            return this.fTm.aZq() - 1;
        }
        return Si;
    }

    private SubPbRequestMessage bew() {
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
            intValue = bfi();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fVW && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aQq.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ao, aq, f, this.stType, i2);
    }

    public boolean Na() {
        return tq(0);
    }

    public boolean bfj() {
        return tq(2);
    }

    public void bfk() {
        int aZv;
        if (this.fVR > 0 && this.fTm != null && (aZv = this.fTm.aZv()) > 0) {
            int Si = this.fTm.Si();
            for (int i = (((this.fVR + aZv) - 1) / aZv) - 1; i >= 0; i--) {
                this.fWb = i(Integer.valueOf(Si - i));
                this.fWb.setTreatDelPage(true);
                sendMessage(this.fWb);
            }
        }
        this.fVR = 0;
    }

    public boolean bfl() {
        return tq(1);
    }

    public boolean bfm() {
        return tq(3);
    }

    public boolean tq(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bfk();
        this.mLoadType = i;
        this.fWb = bew();
        sendMessage(this.fWb);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aZt = mVar.aZt();
        if (aZt == null || aZt.size() == 0) {
            mVar.eY(this.fTm.Si());
        }
        if (this.mLoadType == 1) {
            this.fTm = mVar;
        } else if (this.mLoadType == 2) {
            this.fTm.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.fTm.a(mVar, false);
        } else {
            this.fTm.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.fTm = mVar;
            this.fTm.aZs();
        } else if (this.mLoadType == 2) {
            this.fTm.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.fTm.d(mVar, false);
        } else {
            this.fTm.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.VW() == null || mVar.VW().yX() == null) {
            str = null;
        } else {
            str = mVar.VW().yX().getUserId();
        }
        if (!this.fVW) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aZt().size()) {
                    break;
                }
                mVar.aZt().get(i2).b(this.aQq, str.equals(mVar.aZt().get(i2).yX().getUserId()));
                i = i2 + 1;
            }
        }
        this.fVU.add(mVar);
    }

    public boolean beK() {
        return this.fVK;
    }

    public boolean isMarked() {
        return this.fCV;
    }

    public boolean bfn() {
        return "hot_topic".equals(getStType());
    }

    public void kT(boolean z) {
        this.fCV = z;
    }

    public int aYN() {
        return this.fBQ;
    }

    public String bfo() {
        return this.fVP;
    }

    public void qu(String str) {
        this.fVP = str;
    }

    public boolean bfp() {
        return this.fVO;
    }

    public String bfq() {
        return this.fVM;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fZ(String str) {
        if (this.fTm == null || this.fTm.aZw() == null || this.fTm.VW() == null || this.fTm.aZp() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fTm.aZw().getName());
        writeData.setForumId(this.fTm.aZw().getId());
        writeData.setFloor(this.fTm.aZp().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fTm.VW().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean KY() {
        if (this.fWa) {
            bfs();
        } else {
            bfj();
        }
        return true;
    }

    public boolean bfr() {
        return this.fWa;
    }

    public void kU(boolean z) {
        this.fWa = z;
    }

    private void bfs() {
        if (this.fKa == null) {
            this.fKa = new PbFakeFloorModel(this.aQq);
            this.fKa.setUniqueId(BdUniqueId.gen());
            this.fKa.d(this.fTm);
            this.fKa.setPostId(this.postID);
            this.fKa.a(this.fTp);
        }
        this.fKa.bev();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fTp = aVar;
    }

    public boolean bft() {
        return this.fVW;
    }

    public void kV(boolean z) {
        this.fVW = z;
    }

    public SmallTailInfo bfu() {
        return this.fVV;
    }

    public boolean bfv() {
        return this.fVT;
    }

    public ConcurrentHashMap<String, ImageUrlData> bfw() {
        return this.fVY;
    }

    public ArrayList<String> bfx() {
        return this.fVX;
    }

    public boolean bfy() {
        return this.fVZ;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String bfz() {
        return this.fVN;
    }
}
