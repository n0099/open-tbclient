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
    private TbPageContext<?> aca;
    private com.baidu.tieba.tbadkCore.d.b ctU;
    private int ePu;
    private AntiData eQt;
    private boolean eQu;
    private PbFakeFloorModel eXm;
    private m fgq;
    private PbFakeFloorModel.a fgt;
    private com.baidu.adp.framework.listener.a fgu;
    private boolean fiO;
    private String fiP;
    private String fiQ;
    private String fiR;
    private boolean fiS;
    private String fiT;
    private a fiU;
    private int fiV;
    private ArrayList<IconData> fiW;
    private boolean fiX;
    private ArrayList<m> fiY;
    private SmallTailInfo fiZ;
    private boolean fja;
    private ArrayList<String> fjb;
    private ConcurrentHashMap<String, ImageUrlData> fjc;
    private boolean fjd;
    private boolean fje;
    private SubPbRequestMessage fjf;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, m mVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fiR = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fiO = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fiP = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fiS = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fiQ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.ePu = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fiZ = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fiZ != null) {
                this.fiZ.updateShowInfo();
            }
            this.eQt = (AntiData) intent.getSerializableExtra("anti");
            this.fiW = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fiX = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fjc = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fjc.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fjb = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fjd = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
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
            this.fiR = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fiO = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fiP = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fiS = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fiQ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.ePu = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fiZ = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fiZ != null) {
                this.fiZ.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.eQt = new AntiData();
                this.eQt.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.w(stringArrayList)) {
                this.fiW = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fiW.add(iconData);
                    }
                }
            }
            this.fiX = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void u(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fiO);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fiP);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fiQ);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fiS);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.ePu);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fiZ));
            if (this.eQt != null) {
                bundle.putSerializable("anti", this.eQt.toJsonString());
            }
            if (!v.w(this.fiW)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fiW.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fiR);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.fiO = false;
        this.fiP = null;
        this.fiQ = null;
        this.pageFromType = 0;
        this.fiS = false;
        this.eQu = false;
        this.ePu = 0;
        this.fiT = null;
        this.aca = null;
        this.fgq = null;
        this.fiU = null;
        this.fiV = 0;
        this.fiX = false;
        this.fiY = null;
        this.isLoading = false;
        this.ctU = null;
        this.fjd = true;
        this.mOffset = 0;
        this.eXm = null;
        this.fgt = null;
        this.fje = false;
        this.fgu = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.aca.getPageActivity().finish();
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
                    if (SubPbModel.this.fiY != null && SubPbModel.this.fiY.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fiY.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.fiY.get(size);
                                if (SubPbModel.this.fja) {
                                    SubPbModel.this.fgq.c(mVar2, true);
                                } else {
                                    SubPbModel.this.fgq.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fiY.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.ctU == null) {
                        SubPbModel.this.ctU = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.ctU != null) {
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
                            SubPbModel.this.ctU.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.ctU = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.ctU = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fiU != null) {
                                SubPbModel.this.fiU.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aSb().errorno.intValue() != 0) {
                                if (SubPbModel.this.fiU != null) {
                                    SubPbModel.this.fiU.a(false, mVar.eQv.errorno.intValue(), mVar.eQv.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.Ox() != null && mVar.Ox().rv() != null) {
                                str = mVar.Ox().rv().getUserId();
                                if (v.w(mVar.aSc().rv().getIconInfo()) && SubPbModel.this.fiW != null) {
                                    mVar.aSc().rv().setIconInfo(SubPbModel.this.fiW);
                                }
                            }
                            if (!SubPbModel.this.fja) {
                                for (int i2 = 0; i2 < mVar.aSg().size(); i2++) {
                                    mVar.aSg().get(i2).b(SubPbModel.this.aca, str.equals(mVar.aSg().get(i2).rv().getUserId()));
                                }
                            }
                            if (mVar.aSc() != null) {
                                SubPbModel.this.postID = mVar.aSc().getId();
                            }
                            if (mVar.Ox() != null) {
                                SubPbModel.this.threadID = mVar.Ox().getId();
                                SubPbModel.this.eQu = mVar.nH();
                                SubPbModel.this.fiT = mVar.Ox().rF();
                            }
                            if (SubPbModel.this.fiT != null && SubPbModel.this.postID != null && SubPbModel.this.fiT.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eQu = true;
                            }
                            if (SubPbModel.this.fja) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.fiU != null) {
                                SubPbModel.this.fiU.a(SubPbModel.this.aXR(), error, errorString, SubPbModel.this.fgq);
                            }
                        }
                    }
                }
            }
        };
        this.aca = tbPageContext;
        this.fiY = new ArrayList<>();
        this.fgq = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fgu);
        registerListener(this.fgu);
    }

    public String aUn() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dy() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m aXQ() {
        return this.fgq;
    }

    public AntiData aSk() {
        return this.eQt;
    }

    public boolean aXR() {
        return (this.fgq == null || this.fgq.aSc() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fiU = aVar;
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
        markData.setFloor(postData.bwV());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fgu);
        if (this.eXm != null) {
            this.eXm.unRegisterListener();
        }
        ahu();
    }

    private void ahu() {
        if (this.ctU != null) {
            this.ctU.destory();
            this.ctU = null;
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

    public void qi(String str) {
        if (!TextUtils.isEmpty(str) && this.fgq != null && this.fgq.aSg() != null) {
            ArrayList<PostData> aSg = this.fgq.aSg();
            int size = aSg.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aSg.get(i).getId())) {
                    aSg.remove(i);
                    this.fiV++;
                    this.fgq.setTotalCount(this.fgq.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aXS() {
        int KJ = this.fgq.KJ();
        if (KJ == 0) {
            return KJ + 1;
        }
        if (this.mLoadType == 0) {
            return KJ + 1;
        }
        if (this.mLoadType == 2 && this.fgq.aSg().size() != 0 && this.fgq.aSg().size() % this.fgq.aSi() == 0) {
            return KJ + 1;
        }
        if (this.mLoadType == 3 && this.fja) {
            return this.fgq.aSe() - 1;
        }
        if (this.mLoadType == 3 && KJ > 0) {
            return this.fgq.aSd() - 1;
        }
        return KJ;
    }

    private SubPbRequestMessage aXi() {
        this.isLoading = true;
        return i((Integer) null);
    }

    private SubPbRequestMessage i(Integer num) {
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
            intValue = aXS();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fja && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aca.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ac, ae, f, this.stType, i2);
    }

    public boolean Fz() {
        return qw(0);
    }

    public boolean aXT() {
        return qw(2);
    }

    public void aXU() {
        int aSi;
        if (this.fiV > 0 && this.fgq != null && (aSi = this.fgq.aSi()) > 0) {
            int KJ = this.fgq.KJ();
            for (int i = (((this.fiV + aSi) - 1) / aSi) - 1; i >= 0; i--) {
                this.fjf = i(Integer.valueOf(KJ - i));
                this.fjf.setTreatDelPage(true);
                sendMessage(this.fjf);
            }
        }
        this.fiV = 0;
    }

    public boolean aXV() {
        return qw(1);
    }

    public boolean aXW() {
        return qw(3);
    }

    public boolean qw(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aXU();
        this.mLoadType = i;
        this.fjf = aXi();
        sendMessage(this.fjf);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aSg = mVar.aSg();
        if (aSg == null || aSg.size() == 0) {
            mVar.bY(this.fgq.KJ());
        }
        if (this.mLoadType == 1) {
            this.fgq = mVar;
        } else if (this.mLoadType == 2) {
            this.fgq.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.fgq.a(mVar, false);
        } else {
            this.fgq.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.fgq = mVar;
            this.fgq.aSf();
        } else if (this.mLoadType == 2) {
            this.fgq.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.fgq.d(mVar, false);
        } else {
            this.fgq.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.Ox() == null || mVar.Ox().rv() == null) {
            str = null;
        } else {
            str = mVar.Ox().rv().getUserId();
        }
        if (!this.fja) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aSg().size()) {
                    break;
                }
                mVar.aSg().get(i2).b(this.aca, str.equals(mVar.aSg().get(i2).rv().getUserId()));
                i = i2 + 1;
            }
        }
        this.fiY.add(mVar);
    }

    public boolean aXu() {
        return this.fiO;
    }

    public boolean isMarked() {
        return this.eQu;
    }

    public boolean aXX() {
        return "hot_topic".equals(getStType());
    }

    public void kq(boolean z) {
        this.eQu = z;
    }

    public int aRB() {
        return this.ePu;
    }

    public String aXY() {
        return this.fiT;
    }

    public void qj(String str) {
        this.fiT = str;
    }

    public boolean aXZ() {
        return this.fiS;
    }

    public String aYa() {
        return this.fiQ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.fgq == null || this.fgq.aSj() == null || this.fgq.Ox() == null || this.fgq.aSc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fgq.aSj().getName());
        writeData.setForumId(this.fgq.aSj().getId());
        writeData.setFloor(this.fgq.aSc().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fgq.Ox().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dx() {
        if (this.fje) {
            aYc();
        } else {
            aXT();
        }
        return true;
    }

    public boolean aYb() {
        return this.fje;
    }

    public void kr(boolean z) {
        this.fje = z;
    }

    private void aYc() {
        if (this.eXm == null) {
            this.eXm = new PbFakeFloorModel(this.aca);
            this.eXm.setUniqueId(BdUniqueId.gen());
            this.eXm.d(this.fgq);
            this.eXm.setPostId(this.postID);
            this.eXm.a(this.fgt);
        }
        this.eXm.aXh();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fgt = aVar;
    }

    public boolean aYd() {
        return this.fja;
    }

    public void ks(boolean z) {
        this.fja = z;
    }

    public SmallTailInfo aYe() {
        return this.fiZ;
    }

    public boolean aYf() {
        return this.fiX;
    }

    public ConcurrentHashMap<String, ImageUrlData> aYg() {
        return this.fjc;
    }

    public ArrayList<String> aYh() {
        return this.fjb;
    }

    public boolean aYi() {
        return this.fjd;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aYj() {
        return this.fiR;
    }
}
