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
    private TbPageContext<?> abm;
    private com.baidu.tieba.tbadkCore.d.b cdn;
    private PbFakeFloorModel eEZ;
    private m ePj;
    private PbFakeFloorModel.a ePm;
    private com.baidu.adp.framework.listener.a ePn;
    private boolean eRN;
    private String eRO;
    private String eRP;
    private String eRQ;
    private boolean eRR;
    private String eRS;
    private a eRT;
    private int eRU;
    private ArrayList<IconData> eRV;
    private boolean eRW;
    private ArrayList<m> eRX;
    private SmallTailInfo eRY;
    private boolean eRZ;
    private ArrayList<String> eSa;
    private ConcurrentHashMap<String, ImageUrlData> eSb;
    private boolean eSc;
    private boolean eSd;
    private SubPbRequestMessage eSe;
    private int eyg;
    private AntiData ezd;
    private boolean eze;
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
            this.eRQ = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eRN = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eRO = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eRR = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eRP = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eyg = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eRY = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eRY != null) {
                this.eRY.updateShowInfo();
            }
            this.ezd = (AntiData) intent.getSerializableExtra("anti");
            this.eRV = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eRW = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eSb = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eSb.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eSa = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eSc = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eRQ = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eRN = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eRO = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eRR = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eRP = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eyg = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.eRY = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.eRY != null) {
                this.eRY.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.ezd = new AntiData();
                this.ezd.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.u(stringArrayList)) {
                this.eRV = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.eRV.add(iconData);
                    }
                }
            }
            this.eRW = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void u(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eRN);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eRO);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eRP);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eRR);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eyg);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.eRY));
            if (this.ezd != null) {
                bundle.putSerializable("anti", this.ezd.toJsonString());
            }
            if (!v.u(this.eRV)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.eRV.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.eRQ);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eRN = false;
        this.eRO = null;
        this.eRP = null;
        this.eRR = false;
        this.eze = false;
        this.eyg = 0;
        this.eRS = null;
        this.abm = null;
        this.ePj = null;
        this.eRT = null;
        this.eRU = 0;
        this.eRW = false;
        this.eRX = null;
        this.isLoading = false;
        this.cdn = null;
        this.eSc = true;
        this.mOffset = 0;
        this.eEZ = null;
        this.ePm = null;
        this.eSd = false;
        this.ePn = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.abm.getPageActivity().finish();
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
                    if (SubPbModel.this.eRX != null && SubPbModel.this.eRX.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.eRX.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.eRX.get(size);
                                if (SubPbModel.this.eRZ) {
                                    SubPbModel.this.ePj.c(mVar2, true);
                                } else {
                                    SubPbModel.this.ePj.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.eRX.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cdn == null) {
                        SubPbModel.this.cdn = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cdn != null) {
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
                            SubPbModel.this.cdn.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cdn = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cdn = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.eRT != null) {
                                SubPbModel.this.eRT.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aNE().errorno.intValue() != 0) {
                                if (SubPbModel.this.eRT != null) {
                                    SubPbModel.this.eRT.a(false, mVar.ezf.errorno.intValue(), mVar.ezf.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.Nd() != null && mVar.Nd().getAuthor() != null) {
                                str = mVar.Nd().getAuthor().getUserId();
                                if (v.u(mVar.aNF().getAuthor().getIconInfo()) && SubPbModel.this.eRV != null) {
                                    mVar.aNF().getAuthor().setIconInfo(SubPbModel.this.eRV);
                                }
                            }
                            if (!SubPbModel.this.eRZ) {
                                for (int i2 = 0; i2 < mVar.aNJ().size(); i2++) {
                                    mVar.aNJ().get(i2).b(SubPbModel.this.abm, str.equals(mVar.aNJ().get(i2).getAuthor().getUserId()));
                                }
                            }
                            if (mVar.aNF() != null) {
                                SubPbModel.this.postID = mVar.aNF().getId();
                            }
                            if (mVar.Nd() != null) {
                                SubPbModel.this.threadID = mVar.Nd().getId();
                                SubPbModel.this.eze = mVar.nz();
                                SubPbModel.this.eRS = mVar.Nd().rx();
                            }
                            if (SubPbModel.this.eRS != null && SubPbModel.this.postID != null && SubPbModel.this.eRS.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eze = true;
                            }
                            if (SubPbModel.this.eRZ) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.eRT != null) {
                                SubPbModel.this.eRT.a(SubPbModel.this.aTA(), error, errorString, SubPbModel.this.ePj);
                            }
                        }
                    }
                }
            }
        };
        this.abm = tbPageContext;
        this.eRX = new ArrayList<>();
        this.ePj = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.ePn);
        registerListener(this.ePn);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CO() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m aTz() {
        return this.ePj;
    }

    public AntiData aCg() {
        return this.ezd;
    }

    public boolean aTA() {
        return (this.ePj == null || this.ePj.aNF() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eRT = aVar;
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
        markData.setFloor(postData.brq());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.ePn);
        if (this.eEZ != null) {
            this.eEZ.unRegisterListener();
        }
        adf();
    }

    private void adf() {
        if (this.cdn != null) {
            this.cdn.destory();
            this.cdn = null;
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

    public void pm(String str) {
        if (!TextUtils.isEmpty(str) && this.ePj != null && this.ePj.aNJ() != null) {
            ArrayList<PostData> aNJ = this.ePj.aNJ();
            int size = aNJ.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aNJ.get(i).getId())) {
                    aNJ.remove(i);
                    this.eRU++;
                    this.ePj.setTotalCount(this.ePj.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aTB() {
        int JS = this.ePj.JS();
        if (JS == 0) {
            return JS + 1;
        }
        if (this.mLoadType == 0) {
            return JS + 1;
        }
        if (this.mLoadType == 2 && this.ePj.aNJ().size() != 0 && this.ePj.aNJ().size() % this.ePj.aNL() == 0) {
            return JS + 1;
        }
        if (this.mLoadType == 3 && this.eRZ) {
            return this.ePj.aNH() - 1;
        }
        if (this.mLoadType == 3 && JS > 0) {
            return this.ePj.aNG() - 1;
        }
        return JS;
    }

    private SubPbRequestMessage aSF() {
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
            intValue = aTB();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eRZ && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.abm.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ad, af, f, this.stType, i2);
    }

    public boolean ET() {
        return pK(0);
    }

    public boolean aTC() {
        return pK(2);
    }

    public void aTD() {
        int aNL;
        if (this.eRU > 0 && this.ePj != null && (aNL = this.ePj.aNL()) > 0) {
            int JS = this.ePj.JS();
            for (int i = (((this.eRU + aNL) - 1) / aNL) - 1; i >= 0; i--) {
                this.eSe = h(Integer.valueOf(JS - i));
                this.eSe.setTreatDelPage(true);
                sendMessage(this.eSe);
            }
        }
        this.eRU = 0;
    }

    public boolean aTE() {
        return pK(1);
    }

    public boolean aTF() {
        return pK(3);
    }

    public boolean pK(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aTD();
        this.mLoadType = i;
        this.eSe = aSF();
        sendMessage(this.eSe);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aNJ = mVar.aNJ();
        if (aNJ == null || aNJ.size() == 0) {
            mVar.bX(this.ePj.JS());
        }
        if (this.mLoadType == 1) {
            this.ePj = mVar;
        } else if (this.mLoadType == 2) {
            this.ePj.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.ePj.a(mVar, false);
        } else {
            this.ePj.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.ePj = mVar;
            this.ePj.aNI();
        } else if (this.mLoadType == 2) {
            this.ePj.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.ePj.d(mVar, false);
        } else {
            this.ePj.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.Nd() == null || mVar.Nd().getAuthor() == null) {
            str = null;
        } else {
            str = mVar.Nd().getAuthor().getUserId();
        }
        if (!this.eRZ) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aNJ().size()) {
                    break;
                }
                mVar.aNJ().get(i2).b(this.abm, str.equals(mVar.aNJ().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eRX.add(mVar);
    }

    public boolean aSZ() {
        return this.eRN;
    }

    public boolean isMarked() {
        return this.eze;
    }

    public boolean aTG() {
        return "hot_topic".equals(getStType());
    }

    public void jS(boolean z) {
        this.eze = z;
    }

    public int aNh() {
        return this.eyg;
    }

    public String aTH() {
        return this.eRS;
    }

    public void pn(String str) {
        this.eRS = str;
    }

    public boolean aTI() {
        return this.eRR;
    }

    public String aTJ() {
        return this.eRP;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fI(String str) {
        if (this.ePj == null || this.ePj.aNM() == null || this.ePj.Nd() == null || this.ePj.aNF() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.ePj.aNM().getName());
        writeData.setForumId(this.ePj.aNM().getId());
        writeData.setFloor(this.ePj.aNF().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ePj.Nd().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CN() {
        if (this.eSd) {
            aTL();
        } else {
            aTC();
        }
        return true;
    }

    public boolean aTK() {
        return this.eSd;
    }

    public void jT(boolean z) {
        this.eSd = z;
    }

    private void aTL() {
        if (this.eEZ == null) {
            this.eEZ = new PbFakeFloorModel(this.abm);
            this.eEZ.setUniqueId(BdUniqueId.gen());
            this.eEZ.d(this.ePj);
            this.eEZ.setPostId(this.postID);
            this.eEZ.a(this.ePm);
        }
        this.eEZ.aSE();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.ePm = aVar;
    }

    public boolean aTM() {
        return this.eRZ;
    }

    public void jU(boolean z) {
        this.eRZ = z;
    }

    public SmallTailInfo aTN() {
        return this.eRY;
    }

    public boolean aTO() {
        return this.eRW;
    }

    public ConcurrentHashMap<String, ImageUrlData> aTP() {
        return this.eSb;
    }

    public ArrayList<String> aTQ() {
        return this.eSa;
    }

    public boolean aTR() {
        return this.eSc;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aTS() {
        return this.eRQ;
    }
}
