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
/* loaded from: classes.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> abI;
    private com.baidu.tieba.tbadkCore.d.b clb;
    private int eGD;
    private AntiData eHA;
    private boolean eHB;
    private PbFakeFloorModel eOc;
    private com.baidu.adp.framework.listener.a eYA;
    private m eYw;
    private PbFakeFloorModel.a eYz;
    private boolean faQ;
    private String faR;
    private String faS;
    private String faT;
    private boolean faU;
    private String faV;
    private a faW;
    private int faX;
    private ArrayList<IconData> faY;
    private boolean faZ;
    private ArrayList<m> fba;
    private SmallTailInfo fbb;
    private boolean fbc;
    private ArrayList<String> fbd;
    private ConcurrentHashMap<String, ImageUrlData> fbe;
    private boolean fbf;
    private boolean fbg;
    private SubPbRequestMessage fbh;
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
            this.faT = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.faQ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.faR = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.faU = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.faS = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eGD = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fbb = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fbb != null) {
                this.fbb.updateShowInfo();
            }
            this.eHA = (AntiData) intent.getSerializableExtra("anti");
            this.faY = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.faZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fbe = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fbe.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fbd = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fbf = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.faT = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.faQ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.faR = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.faU = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.faS = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eGD = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fbb = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fbb != null) {
                this.fbb.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.eHA = new AntiData();
                this.eHA.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.v(stringArrayList)) {
                this.faY = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.faY.add(iconData);
                    }
                }
            }
            this.faZ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void t(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.faQ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.faR);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.faS);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.faU);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eGD);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fbb));
            if (this.eHA != null) {
                bundle.putSerializable("anti", this.eHA.toJsonString());
            }
            if (!v.v(this.faY)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.faY.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.faT);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.faQ = false;
        this.faR = null;
        this.faS = null;
        this.faU = false;
        this.eHB = false;
        this.eGD = 0;
        this.faV = null;
        this.abI = null;
        this.eYw = null;
        this.faW = null;
        this.faX = 0;
        this.faZ = false;
        this.fba = null;
        this.isLoading = false;
        this.clb = null;
        this.fbf = true;
        this.mOffset = 0;
        this.eOc = null;
        this.eYz = null;
        this.fbg = false;
        this.eYA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.abI.getPageActivity().finish();
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
                    if (SubPbModel.this.fba != null && SubPbModel.this.fba.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fba.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.fba.get(size);
                                if (SubPbModel.this.fbc) {
                                    SubPbModel.this.eYw.c(mVar2, true);
                                } else {
                                    SubPbModel.this.eYw.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fba.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.clb == null) {
                        SubPbModel.this.clb = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.clb != null) {
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
                            SubPbModel.this.clb.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.clb = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.clb = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.faW != null) {
                                SubPbModel.this.faW.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aQF().errorno.intValue() != 0) {
                                if (SubPbModel.this.faW != null) {
                                    SubPbModel.this.faW.a(false, mVar.eHC.errorno.intValue(), mVar.eHC.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.NA() != null && mVar.NA().rt() != null) {
                                str = mVar.NA().rt().getUserId();
                                if (v.v(mVar.aQG().rt().getIconInfo()) && SubPbModel.this.faY != null) {
                                    mVar.aQG().rt().setIconInfo(SubPbModel.this.faY);
                                }
                            }
                            if (!SubPbModel.this.fbc) {
                                for (int i2 = 0; i2 < mVar.aQK().size(); i2++) {
                                    mVar.aQK().get(i2).b(SubPbModel.this.abI, str.equals(mVar.aQK().get(i2).rt().getUserId()));
                                }
                            }
                            if (mVar.aQG() != null) {
                                SubPbModel.this.postID = mVar.aQG().getId();
                            }
                            if (mVar.NA() != null) {
                                SubPbModel.this.threadID = mVar.NA().getId();
                                SubPbModel.this.eHB = mVar.nC();
                                SubPbModel.this.faV = mVar.NA().rD();
                            }
                            if (SubPbModel.this.faV != null && SubPbModel.this.postID != null && SubPbModel.this.faV.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eHB = true;
                            }
                            if (SubPbModel.this.fbc) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.faW != null) {
                                SubPbModel.this.faW.a(SubPbModel.this.aWK(), error, errorString, SubPbModel.this.eYw);
                            }
                        }
                    }
                }
            }
        };
        this.abI = tbPageContext;
        this.fba = new ArrayList<>();
        this.eYw = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eYA);
        registerListener(this.eYA);
    }

    public String aSH() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Do() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m aWJ() {
        return this.eYw;
    }

    public AntiData aEF() {
        return this.eHA;
    }

    public boolean aWK() {
        return (this.eYw == null || this.eYw.aQG() == null) ? false : true;
    }

    public void a(a aVar) {
        this.faW = aVar;
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
        markData.setFloor(postData.buG());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eYA);
        if (this.eOc != null) {
            this.eOc.unRegisterListener();
        }
        afB();
    }

    private void afB() {
        if (this.clb != null) {
            this.clb.destory();
            this.clb = null;
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

    public void pV(String str) {
        if (!TextUtils.isEmpty(str) && this.eYw != null && this.eYw.aQK() != null) {
            ArrayList<PostData> aQK = this.eYw.aQK();
            int size = aQK.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aQK.get(i).getId())) {
                    aQK.remove(i);
                    this.faX++;
                    this.eYw.setTotalCount(this.eYw.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aWL() {
        int Km = this.eYw.Km();
        if (Km == 0) {
            return Km + 1;
        }
        if (this.mLoadType == 0) {
            return Km + 1;
        }
        if (this.mLoadType == 2 && this.eYw.aQK().size() != 0 && this.eYw.aQK().size() % this.eYw.aQM() == 0) {
            return Km + 1;
        }
        if (this.mLoadType == 3 && this.fbc) {
            return this.eYw.aQI() - 1;
        }
        if (this.mLoadType == 3 && Km > 0) {
            return this.eYw.aQH() - 1;
        }
        return Km;
    }

    private SubPbRequestMessage aWb() {
        this.isLoading = true;
        return h((Integer) null);
    }

    private SubPbRequestMessage h(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ac = l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = l.ae(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aWL();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fbc && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.abI.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ac, ae, f, this.stType, i2);
    }

    public boolean Fr() {
        return qe(0);
    }

    public boolean aWM() {
        return qe(2);
    }

    public void aWN() {
        int aQM;
        if (this.faX > 0 && this.eYw != null && (aQM = this.eYw.aQM()) > 0) {
            int Km = this.eYw.Km();
            for (int i = (((this.faX + aQM) - 1) / aQM) - 1; i >= 0; i--) {
                this.fbh = h(Integer.valueOf(Km - i));
                this.fbh.setTreatDelPage(true);
                sendMessage(this.fbh);
            }
        }
        this.faX = 0;
    }

    public boolean aWO() {
        return qe(1);
    }

    public boolean aWP() {
        return qe(3);
    }

    public boolean qe(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aWN();
        this.mLoadType = i;
        this.fbh = aWb();
        sendMessage(this.fbh);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aQK = mVar.aQK();
        if (aQK == null || aQK.size() == 0) {
            mVar.bX(this.eYw.Km());
        }
        if (this.mLoadType == 1) {
            this.eYw = mVar;
        } else if (this.mLoadType == 2) {
            this.eYw.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.eYw.a(mVar, false);
        } else {
            this.eYw.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.eYw = mVar;
            this.eYw.aQJ();
        } else if (this.mLoadType == 2) {
            this.eYw.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.eYw.d(mVar, false);
        } else {
            this.eYw.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.NA() == null || mVar.NA().rt() == null) {
            str = null;
        } else {
            str = mVar.NA().rt().getUserId();
        }
        if (!this.fbc) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aQK().size()) {
                    break;
                }
                mVar.aQK().get(i2).b(this.abI, str.equals(mVar.aQK().get(i2).rt().getUserId()));
                i = i2 + 1;
            }
        }
        this.fba.add(mVar);
    }

    public boolean aWn() {
        return this.faQ;
    }

    public boolean isMarked() {
        return this.eHB;
    }

    public boolean aWQ() {
        return "hot_topic".equals(getStType());
    }

    public void jR(boolean z) {
        this.eHB = z;
    }

    public int aQh() {
        return this.eGD;
    }

    public String aWR() {
        return this.faV;
    }

    public void pW(String str) {
        this.faV = str;
    }

    public boolean aWS() {
        return this.faU;
    }

    public String aWT() {
        return this.faS;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fQ(String str) {
        if (this.eYw == null || this.eYw.aQN() == null || this.eYw.NA() == null || this.eYw.aQG() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eYw.aQN().getName());
        writeData.setForumId(this.eYw.aQN().getId());
        writeData.setFloor(this.eYw.aQG().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eYw.NA().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dn() {
        if (this.fbg) {
            aWV();
        } else {
            aWM();
        }
        return true;
    }

    public boolean aWU() {
        return this.fbg;
    }

    public void jS(boolean z) {
        this.fbg = z;
    }

    private void aWV() {
        if (this.eOc == null) {
            this.eOc = new PbFakeFloorModel(this.abI);
            this.eOc.setUniqueId(BdUniqueId.gen());
            this.eOc.d(this.eYw);
            this.eOc.setPostId(this.postID);
            this.eOc.a(this.eYz);
        }
        this.eOc.aWa();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.eYz = aVar;
    }

    public boolean aWW() {
        return this.fbc;
    }

    public void jT(boolean z) {
        this.fbc = z;
    }

    public SmallTailInfo aWX() {
        return this.fbb;
    }

    public boolean aWY() {
        return this.faZ;
    }

    public ConcurrentHashMap<String, ImageUrlData> aWZ() {
        return this.fbe;
    }

    public ArrayList<String> aXa() {
        return this.fbd;
    }

    public boolean aXb() {
        return this.fbf;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aXc() {
        return this.faT;
    }
}
