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
    private TbPageContext<?> abz;
    private com.baidu.tieba.tbadkCore.d.b cdz;
    private PbFakeFloorModel eFn;
    private PbFakeFloorModel.a ePA;
    private com.baidu.adp.framework.listener.a ePB;
    private m ePx;
    private boolean eSb;
    private String eSc;
    private String eSd;
    private String eSe;
    private boolean eSf;
    private String eSg;
    private a eSh;
    private int eSi;
    private ArrayList<IconData> eSj;
    private boolean eSk;
    private ArrayList<m> eSl;
    private SmallTailInfo eSm;
    private boolean eSn;
    private ArrayList<String> eSo;
    private ConcurrentHashMap<String, ImageUrlData> eSp;
    private boolean eSq;
    private boolean eSr;
    private SubPbRequestMessage eSs;
    private int eyv;
    private AntiData ezr;
    private boolean ezs;
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
            this.eSe = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eSb = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eSc = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eSf = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eSd = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eyv = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eSm = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eSm != null) {
                this.eSm.updateShowInfo();
            }
            this.ezr = (AntiData) intent.getSerializableExtra("anti");
            this.eSj = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eSk = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eSp = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eSp.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eSo = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eSq = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eSe = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eSb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eSc = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eSf = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eSd = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eyv = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.eSm = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.eSm != null) {
                this.eSm.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.ezr = new AntiData();
                this.ezr.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.u(stringArrayList)) {
                this.eSj = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.eSj.add(iconData);
                    }
                }
            }
            this.eSk = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void u(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eSb);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eSc);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eSd);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eSf);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eyv);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.eSm));
            if (this.ezr != null) {
                bundle.putSerializable("anti", this.ezr.toJsonString());
            }
            if (!v.u(this.eSj)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.eSj.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.eSe);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eSb = false;
        this.eSc = null;
        this.eSd = null;
        this.eSf = false;
        this.ezs = false;
        this.eyv = 0;
        this.eSg = null;
        this.abz = null;
        this.ePx = null;
        this.eSh = null;
        this.eSi = 0;
        this.eSk = false;
        this.eSl = null;
        this.isLoading = false;
        this.cdz = null;
        this.eSq = true;
        this.mOffset = 0;
        this.eFn = null;
        this.ePA = null;
        this.eSr = false;
        this.ePB = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.abz.getPageActivity().finish();
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
                    if (SubPbModel.this.eSl != null && SubPbModel.this.eSl.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.eSl.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.eSl.get(size);
                                if (SubPbModel.this.eSn) {
                                    SubPbModel.this.ePx.c(mVar2, true);
                                } else {
                                    SubPbModel.this.ePx.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.eSl.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cdz == null) {
                        SubPbModel.this.cdz = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cdz != null) {
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
                            SubPbModel.this.cdz.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cdz = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cdz = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.eSh != null) {
                                SubPbModel.this.eSh.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aNJ().errorno.intValue() != 0) {
                                if (SubPbModel.this.eSh != null) {
                                    SubPbModel.this.eSh.a(false, mVar.ezt.errorno.intValue(), mVar.ezt.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.Nj() != null && mVar.Nj().getAuthor() != null) {
                                str = mVar.Nj().getAuthor().getUserId();
                                if (v.u(mVar.aNK().getAuthor().getIconInfo()) && SubPbModel.this.eSj != null) {
                                    mVar.aNK().getAuthor().setIconInfo(SubPbModel.this.eSj);
                                }
                            }
                            if (!SubPbModel.this.eSn) {
                                for (int i2 = 0; i2 < mVar.aNO().size(); i2++) {
                                    mVar.aNO().get(i2).b(SubPbModel.this.abz, str.equals(mVar.aNO().get(i2).getAuthor().getUserId()));
                                }
                            }
                            if (mVar.aNK() != null) {
                                SubPbModel.this.postID = mVar.aNK().getId();
                            }
                            if (mVar.Nj() != null) {
                                SubPbModel.this.threadID = mVar.Nj().getId();
                                SubPbModel.this.ezs = mVar.nG();
                                SubPbModel.this.eSg = mVar.Nj().rE();
                            }
                            if (SubPbModel.this.eSg != null && SubPbModel.this.postID != null && SubPbModel.this.eSg.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.ezs = true;
                            }
                            if (SubPbModel.this.eSn) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.eSh != null) {
                                SubPbModel.this.eSh.a(SubPbModel.this.aTF(), error, errorString, SubPbModel.this.ePx);
                            }
                        }
                    }
                }
            }
        };
        this.abz = tbPageContext;
        this.eSl = new ArrayList<>();
        this.ePx = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.ePB);
        registerListener(this.ePB);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CU() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m aTE() {
        return this.ePx;
    }

    public AntiData aCl() {
        return this.ezr;
    }

    public boolean aTF() {
        return (this.ePx == null || this.ePx.aNK() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eSh = aVar;
    }

    public MarkData i(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(postData.brx());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.ePB);
        if (this.eFn != null) {
            this.eFn.unRegisterListener();
        }
        adj();
    }

    private void adj() {
        if (this.cdz != null) {
            this.cdz.destory();
            this.cdz = null;
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

    public void pn(String str) {
        if (!TextUtils.isEmpty(str) && this.ePx != null && this.ePx.aNO() != null) {
            ArrayList<PostData> aNO = this.ePx.aNO();
            int size = aNO.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aNO.get(i).getId())) {
                    aNO.remove(i);
                    this.eSi++;
                    this.ePx.setTotalCount(this.ePx.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aTG() {
        int JY = this.ePx.JY();
        if (JY == 0) {
            return JY + 1;
        }
        if (this.mLoadType == 0) {
            return JY + 1;
        }
        if (this.mLoadType == 2 && this.ePx.aNO().size() != 0 && this.ePx.aNO().size() % this.ePx.aNQ() == 0) {
            return JY + 1;
        }
        if (this.mLoadType == 3 && this.eSn) {
            return this.ePx.aNM() - 1;
        }
        if (this.mLoadType == 3 && JY > 0) {
            return this.ePx.aNL() - 1;
        }
        return JY;
    }

    private SubPbRequestMessage aSK() {
        this.isLoading = true;
        return h((Integer) null);
    }

    private SubPbRequestMessage h(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ad = l.ad(TbadkCoreApplication.getInst().getApp());
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aTG();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eSn && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.abz.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ad, af, f, this.stType, i2);
    }

    public boolean EZ() {
        return pL(0);
    }

    public boolean aTH() {
        return pL(2);
    }

    public void aTI() {
        int aNQ;
        if (this.eSi > 0 && this.ePx != null && (aNQ = this.ePx.aNQ()) > 0) {
            int JY = this.ePx.JY();
            for (int i = (((this.eSi + aNQ) - 1) / aNQ) - 1; i >= 0; i--) {
                this.eSs = h(Integer.valueOf(JY - i));
                this.eSs.setTreatDelPage(true);
                sendMessage(this.eSs);
            }
        }
        this.eSi = 0;
    }

    public boolean aTJ() {
        return pL(1);
    }

    public boolean aTK() {
        return pL(3);
    }

    public boolean pL(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aTI();
        this.mLoadType = i;
        this.eSs = aSK();
        sendMessage(this.eSs);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aNO = mVar.aNO();
        if (aNO == null || aNO.size() == 0) {
            mVar.bY(this.ePx.JY());
        }
        if (this.mLoadType == 1) {
            this.ePx = mVar;
        } else if (this.mLoadType == 2) {
            this.ePx.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.ePx.a(mVar, false);
        } else {
            this.ePx.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.ePx = mVar;
            this.ePx.aNN();
        } else if (this.mLoadType == 2) {
            this.ePx.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.ePx.d(mVar, false);
        } else {
            this.ePx.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.Nj() == null || mVar.Nj().getAuthor() == null) {
            str = null;
        } else {
            str = mVar.Nj().getAuthor().getUserId();
        }
        if (!this.eSn) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aNO().size()) {
                    break;
                }
                mVar.aNO().get(i2).b(this.abz, str.equals(mVar.aNO().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eSl.add(mVar);
    }

    public boolean aTe() {
        return this.eSb;
    }

    public boolean isMarked() {
        return this.ezs;
    }

    public boolean aTL() {
        return "hot_topic".equals(getStType());
    }

    public void jT(boolean z) {
        this.ezs = z;
    }

    public int aNm() {
        return this.eyv;
    }

    public String aTM() {
        return this.eSg;
    }

    public void po(String str) {
        this.eSg = str;
    }

    public boolean aTN() {
        return this.eSf;
    }

    public String aTO() {
        return this.eSd;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fJ(String str) {
        if (this.ePx == null || this.ePx.aNR() == null || this.ePx.Nj() == null || this.ePx.aNK() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.ePx.aNR().getName());
        writeData.setForumId(this.ePx.aNR().getId());
        writeData.setFloor(this.ePx.aNK().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ePx.Nj().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CT() {
        if (this.eSr) {
            aTQ();
        } else {
            aTH();
        }
        return true;
    }

    public boolean aTP() {
        return this.eSr;
    }

    public void jU(boolean z) {
        this.eSr = z;
    }

    private void aTQ() {
        if (this.eFn == null) {
            this.eFn = new PbFakeFloorModel(this.abz);
            this.eFn.setUniqueId(BdUniqueId.gen());
            this.eFn.d(this.ePx);
            this.eFn.setPostId(this.postID);
            this.eFn.a(this.ePA);
        }
        this.eFn.aSJ();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.ePA = aVar;
    }

    public boolean aTR() {
        return this.eSn;
    }

    public void jV(boolean z) {
        this.eSn = z;
    }

    public SmallTailInfo aTS() {
        return this.eSm;
    }

    public boolean aTT() {
        return this.eSk;
    }

    public ConcurrentHashMap<String, ImageUrlData> aTU() {
        return this.eSp;
    }

    public ArrayList<String> aTV() {
        return this.eSo;
    }

    public boolean aTW() {
        return this.eSq;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aTX() {
        return this.eSe;
    }
}
