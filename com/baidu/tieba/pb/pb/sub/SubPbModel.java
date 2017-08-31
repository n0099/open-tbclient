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
import com.baidu.adp.lib.util.k;
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
/* loaded from: classes.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> aby;
    private com.baidu.tieba.tbadkCore.d.b ccG;
    private int eEg;
    private AntiData eFb;
    private boolean eFc;
    private PbFakeFloorModel eKT;
    private m eUB;
    private PbFakeFloorModel.a eUE;
    private com.baidu.adp.framework.listener.a eUF;
    private boolean eWY;
    private String eWZ;
    private String eXa;
    private String eXb;
    private boolean eXc;
    private String eXd;
    private a eXe;
    private int eXf;
    private ArrayList<IconData> eXg;
    private boolean eXh;
    private ArrayList<m> eXi;
    private SmallTailInfo eXj;
    private boolean eXk;
    private ArrayList<String> eXl;
    private ConcurrentHashMap<String, ImageUrlData> eXm;
    private boolean eXn;
    private boolean eXo;
    private SubPbRequestMessage eXp;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, m mVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.eXb = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eWY = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eWZ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eXc = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eXa = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eEg = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eXj = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eXj != null) {
                this.eXj.updateShowInfo();
            }
            this.eFb = (AntiData) intent.getSerializableExtra("anti");
            this.eXg = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eXh = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eXm = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eXm.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eXl = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eXn = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eXb = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eWY = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eWZ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eXc = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eXa = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eEg = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.eXj = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.eXj != null) {
                this.eXj.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.eFb = new AntiData();
                this.eFb.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.v(stringArrayList)) {
                this.eXg = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.eXg.add(iconData);
                    }
                }
            }
            this.eXh = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void t(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eWY);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eWZ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eXa);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eXc);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eEg);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.eXj));
            if (this.eFb != null) {
                bundle.putSerializable("anti", this.eFb.toJsonString());
            }
            if (!v.v(this.eXg)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.eXg.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.eXb);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eWY = false;
        this.eWZ = null;
        this.eXa = null;
        this.eXc = false;
        this.eFc = false;
        this.eEg = 0;
        this.eXd = null;
        this.aby = null;
        this.eUB = null;
        this.eXe = null;
        this.eXf = 0;
        this.eXh = false;
        this.eXi = null;
        this.isLoading = false;
        this.ccG = null;
        this.eXn = true;
        this.mOffset = 0;
        this.eKT = null;
        this.eUE = null;
        this.eXo = false;
        this.eUF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.aby.getPageActivity().finish();
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
                        ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
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
                    if (SubPbModel.this.eXi != null && SubPbModel.this.eXi.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.eXi.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.eXi.get(size);
                                if (SubPbModel.this.eXk) {
                                    SubPbModel.this.eUB.c(mVar2, true);
                                } else {
                                    SubPbModel.this.eUB.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.eXi.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.ccG == null) {
                        SubPbModel.this.ccG = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.ccG != null) {
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
                            SubPbModel.this.ccG.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.ccG = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.ccG = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.eXe != null) {
                                SubPbModel.this.eXe.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aPE().errorno.intValue() != 0) {
                                if (SubPbModel.this.eXe != null) {
                                    SubPbModel.this.eXe.a(false, mVar.eFd.errorno.intValue(), mVar.eFd.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.MR() != null && mVar.MR().getAuthor() != null) {
                                str = mVar.MR().getAuthor().getUserId();
                                if (v.v(mVar.aPF().getAuthor().getIconInfo()) && SubPbModel.this.eXg != null) {
                                    mVar.aPF().getAuthor().setIconInfo(SubPbModel.this.eXg);
                                }
                            }
                            if (!SubPbModel.this.eXk) {
                                for (int i2 = 0; i2 < mVar.aPJ().size(); i2++) {
                                    mVar.aPJ().get(i2).b(SubPbModel.this.aby, str.equals(mVar.aPJ().get(i2).getAuthor().getUserId()));
                                }
                            }
                            if (mVar.aPF() != null) {
                                SubPbModel.this.postID = mVar.aPF().getId();
                            }
                            if (mVar.MR() != null) {
                                SubPbModel.this.threadID = mVar.MR().getId();
                                SubPbModel.this.eFc = mVar.nG();
                                SubPbModel.this.eXd = mVar.MR().rK();
                            }
                            if (SubPbModel.this.eXd != null && SubPbModel.this.postID != null && SubPbModel.this.eXd.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eFc = true;
                            }
                            if (SubPbModel.this.eXk) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.eXe != null) {
                                SubPbModel.this.eXe.a(SubPbModel.this.aVl(), error, errorString, SubPbModel.this.eUB);
                            }
                        }
                    }
                }
            }
        };
        this.aby = tbPageContext;
        this.eXi = new ArrayList<>();
        this.eUB = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eUF);
        registerListener(this.eUF);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dq() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m aVk() {
        return this.eUB;
    }

    public AntiData aDm() {
        return this.eFb;
    }

    public boolean aVl() {
        return (this.eUB == null || this.eUB.aPF() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eXe = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(postData.bso());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eUF);
        if (this.eKT != null) {
            this.eKT.unRegisterListener();
        }
        adl();
    }

    private void adl() {
        if (this.ccG != null) {
            this.ccG.destory();
            this.ccG = null;
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

    public void pC(String str) {
        if (!TextUtils.isEmpty(str) && this.eUB != null && this.eUB.aPJ() != null) {
            ArrayList<PostData> aPJ = this.eUB.aPJ();
            int size = aPJ.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aPJ.get(i).getId())) {
                    aPJ.remove(i);
                    this.eXf++;
                    this.eUB.setTotalCount(this.eUB.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aVm() {
        int JP = this.eUB.JP();
        if (JP == 0) {
            return JP + 1;
        }
        if (this.mLoadType == 0) {
            return JP + 1;
        }
        if (this.mLoadType == 2 && this.eUB.aPJ().size() != 0 && this.eUB.aPJ().size() % this.eUB.aPL() == 0) {
            return JP + 1;
        }
        if (this.mLoadType == 3 && this.eXk) {
            return this.eUB.aPH() - 1;
        }
        if (this.mLoadType == 3 && JP > 0) {
            return this.eUB.aPG() - 1;
        }
        return JP;
    }

    private SubPbRequestMessage aUq() {
        this.isLoading = true;
        return h((Integer) null);
    }

    private SubPbRequestMessage h(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ad = k.ad(TbadkCoreApplication.getInst().getApp());
        int ae = k.ae(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aVm();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eXk && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aby.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ad, ae, f, this.stType, i2);
    }

    public boolean Fu() {
        return pO(0);
    }

    public boolean aVn() {
        return pO(2);
    }

    public void aVo() {
        int aPL;
        if (this.eXf > 0 && this.eUB != null && (aPL = this.eUB.aPL()) > 0) {
            int JP = this.eUB.JP();
            for (int i = (((this.eXf + aPL) - 1) / aPL) - 1; i >= 0; i--) {
                this.eXp = h(Integer.valueOf(JP - i));
                this.eXp.setTreatDelPage(true);
                sendMessage(this.eXp);
            }
        }
        this.eXf = 0;
    }

    public boolean aVp() {
        return pO(1);
    }

    public boolean aVq() {
        return pO(3);
    }

    public boolean pO(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aVo();
        this.mLoadType = i;
        this.eXp = aUq();
        sendMessage(this.eXp);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aPJ = mVar.aPJ();
        if (aPJ == null || aPJ.size() == 0) {
            mVar.bX(this.eUB.JP());
        }
        if (this.mLoadType == 1) {
            this.eUB = mVar;
        } else if (this.mLoadType == 2) {
            this.eUB.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.eUB.a(mVar, false);
        } else {
            this.eUB.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.eUB = mVar;
            this.eUB.aPI();
        } else if (this.mLoadType == 2) {
            this.eUB.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.eUB.d(mVar, false);
        } else {
            this.eUB.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.MR() == null || mVar.MR().getAuthor() == null) {
            str = null;
        } else {
            str = mVar.MR().getAuthor().getUserId();
        }
        if (!this.eXk) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aPJ().size()) {
                    break;
                }
                mVar.aPJ().get(i2).b(this.aby, str.equals(mVar.aPJ().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eXi.add(mVar);
    }

    public boolean aUK() {
        return this.eWY;
    }

    public boolean isMarked() {
        return this.eFc;
    }

    public boolean aVr() {
        return "hot_topic".equals(getStType());
    }

    public void kd(boolean z) {
        this.eFc = z;
    }

    public int aPi() {
        return this.eEg;
    }

    public String aVs() {
        return this.eXd;
    }

    public void pD(String str) {
        this.eXd = str;
    }

    public boolean aVt() {
        return this.eXc;
    }

    public String aVu() {
        return this.eXa;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fQ(String str) {
        if (this.eUB == null || this.eUB.aPM() == null || this.eUB.MR() == null || this.eUB.aPF() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eUB.aPM().getName());
        writeData.setForumId(this.eUB.aPM().getId());
        writeData.setFloor(this.eUB.aPF().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eUB.MR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dp() {
        if (this.eXo) {
            aVw();
        } else {
            aVn();
        }
        return true;
    }

    public boolean aVv() {
        return this.eXo;
    }

    public void ke(boolean z) {
        this.eXo = z;
    }

    private void aVw() {
        if (this.eKT == null) {
            this.eKT = new PbFakeFloorModel(this.aby);
            this.eKT.setUniqueId(BdUniqueId.gen());
            this.eKT.d(this.eUB);
            this.eKT.setPostId(this.postID);
            this.eKT.a(this.eUE);
        }
        this.eKT.aUp();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.eUE = aVar;
    }

    public boolean aVx() {
        return this.eXk;
    }

    public void kf(boolean z) {
        this.eXk = z;
    }

    public SmallTailInfo aVy() {
        return this.eXj;
    }

    public boolean aVz() {
        return this.eXh;
    }

    public ConcurrentHashMap<String, ImageUrlData> aVA() {
        return this.eXm;
    }

    public ArrayList<String> aVB() {
        return this.eXl;
    }

    public boolean aVC() {
        return this.eXn;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aVD() {
        return this.eXb;
    }
}
