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
    private TbPageContext<?> abX;
    private com.baidu.tieba.tbadkCore.d.b ctQ;
    private int ePp;
    private AntiData eQo;
    private boolean eQp;
    private PbFakeFloorModel eXh;
    private m fgl;
    private PbFakeFloorModel.a fgo;
    private com.baidu.adp.framework.listener.a fgp;
    private boolean fiJ;
    private String fiK;
    private String fiL;
    private String fiM;
    private boolean fiN;
    private String fiO;
    private a fiP;
    private int fiQ;
    private ArrayList<IconData> fiR;
    private boolean fiS;
    private ArrayList<m> fiT;
    private SmallTailInfo fiU;
    private boolean fiV;
    private ArrayList<String> fiW;
    private ConcurrentHashMap<String, ImageUrlData> fiX;
    private boolean fiY;
    private boolean fiZ;
    private SubPbRequestMessage fja;
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
            this.fiM = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fiJ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fiK = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fiN = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fiL = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.ePp = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fiU = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fiU != null) {
                this.fiU.updateShowInfo();
            }
            this.eQo = (AntiData) intent.getSerializableExtra("anti");
            this.fiR = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fiS = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fiX = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fiX.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fiW = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fiY = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
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
            this.fiM = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fiJ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fiK = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fiN = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fiL = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.ePp = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fiU = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fiU != null) {
                this.fiU.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.eQo = new AntiData();
                this.eQo.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.w(stringArrayList)) {
                this.fiR = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fiR.add(iconData);
                    }
                }
            }
            this.fiS = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void u(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fiJ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fiK);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fiL);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fiN);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.ePp);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fiU));
            if (this.eQo != null) {
                bundle.putSerializable("anti", this.eQo.toJsonString());
            }
            if (!v.w(this.fiR)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fiR.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fiM);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.fiJ = false;
        this.fiK = null;
        this.fiL = null;
        this.pageFromType = 0;
        this.fiN = false;
        this.eQp = false;
        this.ePp = 0;
        this.fiO = null;
        this.abX = null;
        this.fgl = null;
        this.fiP = null;
        this.fiQ = 0;
        this.fiS = false;
        this.fiT = null;
        this.isLoading = false;
        this.ctQ = null;
        this.fiY = true;
        this.mOffset = 0;
        this.eXh = null;
        this.fgo = null;
        this.fiZ = false;
        this.fgp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.abX.getPageActivity().finish();
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
                    if (SubPbModel.this.fiT != null && SubPbModel.this.fiT.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fiT.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.fiT.get(size);
                                if (SubPbModel.this.fiV) {
                                    SubPbModel.this.fgl.c(mVar2, true);
                                } else {
                                    SubPbModel.this.fgl.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fiT.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.ctQ == null) {
                        SubPbModel.this.ctQ = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.ctQ != null) {
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
                            SubPbModel.this.ctQ.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.ctQ = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.ctQ = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fiP != null) {
                                SubPbModel.this.fiP.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aSa().errorno.intValue() != 0) {
                                if (SubPbModel.this.fiP != null) {
                                    SubPbModel.this.fiP.a(false, mVar.eQq.errorno.intValue(), mVar.eQq.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.Ox() != null && mVar.Ox().rv() != null) {
                                str = mVar.Ox().rv().getUserId();
                                if (v.w(mVar.aSb().rv().getIconInfo()) && SubPbModel.this.fiR != null) {
                                    mVar.aSb().rv().setIconInfo(SubPbModel.this.fiR);
                                }
                            }
                            if (!SubPbModel.this.fiV) {
                                for (int i2 = 0; i2 < mVar.aSf().size(); i2++) {
                                    mVar.aSf().get(i2).b(SubPbModel.this.abX, str.equals(mVar.aSf().get(i2).rv().getUserId()));
                                }
                            }
                            if (mVar.aSb() != null) {
                                SubPbModel.this.postID = mVar.aSb().getId();
                            }
                            if (mVar.Ox() != null) {
                                SubPbModel.this.threadID = mVar.Ox().getId();
                                SubPbModel.this.eQp = mVar.nH();
                                SubPbModel.this.fiO = mVar.Ox().rF();
                            }
                            if (SubPbModel.this.fiO != null && SubPbModel.this.postID != null && SubPbModel.this.fiO.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eQp = true;
                            }
                            if (SubPbModel.this.fiV) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.fiP != null) {
                                SubPbModel.this.fiP.a(SubPbModel.this.aXQ(), error, errorString, SubPbModel.this.fgl);
                            }
                        }
                    }
                }
            }
        };
        this.abX = tbPageContext;
        this.fiT = new ArrayList<>();
        this.fgl = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fgp);
        registerListener(this.fgp);
    }

    public String aUm() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dy() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m aXP() {
        return this.fgl;
    }

    public AntiData aSj() {
        return this.eQo;
    }

    public boolean aXQ() {
        return (this.fgl == null || this.fgl.aSb() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fiP = aVar;
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
        markData.setFloor(postData.bwU());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fgp);
        if (this.eXh != null) {
            this.eXh.unRegisterListener();
        }
        ahu();
    }

    private void ahu() {
        if (this.ctQ != null) {
            this.ctQ.destory();
            this.ctQ = null;
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
        if (!TextUtils.isEmpty(str) && this.fgl != null && this.fgl.aSf() != null) {
            ArrayList<PostData> aSf = this.fgl.aSf();
            int size = aSf.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aSf.get(i).getId())) {
                    aSf.remove(i);
                    this.fiQ++;
                    this.fgl.setTotalCount(this.fgl.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aXR() {
        int KJ = this.fgl.KJ();
        if (KJ == 0) {
            return KJ + 1;
        }
        if (this.mLoadType == 0) {
            return KJ + 1;
        }
        if (this.mLoadType == 2 && this.fgl.aSf().size() != 0 && this.fgl.aSf().size() % this.fgl.aSh() == 0) {
            return KJ + 1;
        }
        if (this.mLoadType == 3 && this.fiV) {
            return this.fgl.aSd() - 1;
        }
        if (this.mLoadType == 3 && KJ > 0) {
            return this.fgl.aSc() - 1;
        }
        return KJ;
    }

    private SubPbRequestMessage aXh() {
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
            intValue = aXR();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fiV && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.abX.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ac, ae, f, this.stType, i2);
    }

    public boolean Fz() {
        return qw(0);
    }

    public boolean aXS() {
        return qw(2);
    }

    public void aXT() {
        int aSh;
        if (this.fiQ > 0 && this.fgl != null && (aSh = this.fgl.aSh()) > 0) {
            int KJ = this.fgl.KJ();
            for (int i = (((this.fiQ + aSh) - 1) / aSh) - 1; i >= 0; i--) {
                this.fja = i(Integer.valueOf(KJ - i));
                this.fja.setTreatDelPage(true);
                sendMessage(this.fja);
            }
        }
        this.fiQ = 0;
    }

    public boolean aXU() {
        return qw(1);
    }

    public boolean aXV() {
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
        aXT();
        this.mLoadType = i;
        this.fja = aXh();
        sendMessage(this.fja);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aSf = mVar.aSf();
        if (aSf == null || aSf.size() == 0) {
            mVar.bY(this.fgl.KJ());
        }
        if (this.mLoadType == 1) {
            this.fgl = mVar;
        } else if (this.mLoadType == 2) {
            this.fgl.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.fgl.a(mVar, false);
        } else {
            this.fgl.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.fgl = mVar;
            this.fgl.aSe();
        } else if (this.mLoadType == 2) {
            this.fgl.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.fgl.d(mVar, false);
        } else {
            this.fgl.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.Ox() == null || mVar.Ox().rv() == null) {
            str = null;
        } else {
            str = mVar.Ox().rv().getUserId();
        }
        if (!this.fiV) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aSf().size()) {
                    break;
                }
                mVar.aSf().get(i2).b(this.abX, str.equals(mVar.aSf().get(i2).rv().getUserId()));
                i = i2 + 1;
            }
        }
        this.fiT.add(mVar);
    }

    public boolean aXt() {
        return this.fiJ;
    }

    public boolean isMarked() {
        return this.eQp;
    }

    public boolean aXW() {
        return "hot_topic".equals(getStType());
    }

    public void kq(boolean z) {
        this.eQp = z;
    }

    public int aRA() {
        return this.ePp;
    }

    public String aXX() {
        return this.fiO;
    }

    public void qj(String str) {
        this.fiO = str;
    }

    public boolean aXY() {
        return this.fiN;
    }

    public String aXZ() {
        return this.fiL;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.fgl == null || this.fgl.aSi() == null || this.fgl.Ox() == null || this.fgl.aSb() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fgl.aSi().getName());
        writeData.setForumId(this.fgl.aSi().getId());
        writeData.setFloor(this.fgl.aSb().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fgl.Ox().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dx() {
        if (this.fiZ) {
            aYb();
        } else {
            aXS();
        }
        return true;
    }

    public boolean aYa() {
        return this.fiZ;
    }

    public void kr(boolean z) {
        this.fiZ = z;
    }

    private void aYb() {
        if (this.eXh == null) {
            this.eXh = new PbFakeFloorModel(this.abX);
            this.eXh.setUniqueId(BdUniqueId.gen());
            this.eXh.d(this.fgl);
            this.eXh.setPostId(this.postID);
            this.eXh.a(this.fgo);
        }
        this.eXh.aXg();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fgo = aVar;
    }

    public boolean aYc() {
        return this.fiV;
    }

    public void ks(boolean z) {
        this.fiV = z;
    }

    public SmallTailInfo aYd() {
        return this.fiU;
    }

    public boolean aYe() {
        return this.fiS;
    }

    public ConcurrentHashMap<String, ImageUrlData> aYf() {
        return this.fiX;
    }

    public ArrayList<String> aYg() {
        return this.fiW;
    }

    public boolean aYh() {
        return this.fiY;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aYi() {
        return this.fiM;
    }
}
