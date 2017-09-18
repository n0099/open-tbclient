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
    private com.baidu.tieba.tbadkCore.d.b cdy;
    private AntiData eFV;
    private boolean eFW;
    private int eFa;
    private PbFakeFloorModel eLN;
    private m eVv;
    private PbFakeFloorModel.a eVy;
    private com.baidu.adp.framework.listener.a eVz;
    private boolean eXS;
    private String eXT;
    private String eXU;
    private String eXV;
    private boolean eXW;
    private String eXX;
    private a eXY;
    private int eXZ;
    private ArrayList<IconData> eYa;
    private boolean eYb;
    private ArrayList<m> eYc;
    private SmallTailInfo eYd;
    private boolean eYe;
    private ArrayList<String> eYf;
    private ConcurrentHashMap<String, ImageUrlData> eYg;
    private boolean eYh;
    private boolean eYi;
    private SubPbRequestMessage eYj;
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
            this.eXV = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eXS = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eXT = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eXW = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eXU = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eFa = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eYd = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eYd != null) {
                this.eYd.updateShowInfo();
            }
            this.eFV = (AntiData) intent.getSerializableExtra("anti");
            this.eYa = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eYb = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eYg = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eYg.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eYf = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eYh = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eXV = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eXS = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eXT = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eXW = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eXU = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eFa = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.eYd = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.eYd != null) {
                this.eYd.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.eFV = new AntiData();
                this.eFV.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.v(stringArrayList)) {
                this.eYa = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.eYa.add(iconData);
                    }
                }
            }
            this.eYb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void t(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eXS);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eXT);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eXU);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eXW);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eFa);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.eYd));
            if (this.eFV != null) {
                bundle.putSerializable("anti", this.eFV.toJsonString());
            }
            if (!v.v(this.eYa)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.eYa.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.eXV);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eXS = false;
        this.eXT = null;
        this.eXU = null;
        this.eXW = false;
        this.eFW = false;
        this.eFa = 0;
        this.eXX = null;
        this.aby = null;
        this.eVv = null;
        this.eXY = null;
        this.eXZ = 0;
        this.eYb = false;
        this.eYc = null;
        this.isLoading = false;
        this.cdy = null;
        this.eYh = true;
        this.mOffset = 0;
        this.eLN = null;
        this.eVy = null;
        this.eYi = false;
        this.eVz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                    if (SubPbModel.this.eYc != null && SubPbModel.this.eYc.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.eYc.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.eYc.get(size);
                                if (SubPbModel.this.eYe) {
                                    SubPbModel.this.eVv.c(mVar2, true);
                                } else {
                                    SubPbModel.this.eVv.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.eYc.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cdy == null) {
                        SubPbModel.this.cdy = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cdy != null) {
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
                            SubPbModel.this.cdy.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cdy = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cdy = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.eXY != null) {
                                SubPbModel.this.eXY.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aPP().errorno.intValue() != 0) {
                                if (SubPbModel.this.eXY != null) {
                                    SubPbModel.this.eXY.a(false, mVar.eFX.errorno.intValue(), mVar.eFX.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.MR() != null && mVar.MR().getAuthor() != null) {
                                str = mVar.MR().getAuthor().getUserId();
                                if (v.v(mVar.aPQ().getAuthor().getIconInfo()) && SubPbModel.this.eYa != null) {
                                    mVar.aPQ().getAuthor().setIconInfo(SubPbModel.this.eYa);
                                }
                            }
                            if (!SubPbModel.this.eYe) {
                                for (int i2 = 0; i2 < mVar.aPU().size(); i2++) {
                                    mVar.aPU().get(i2).b(SubPbModel.this.aby, str.equals(mVar.aPU().get(i2).getAuthor().getUserId()));
                                }
                            }
                            if (mVar.aPQ() != null) {
                                SubPbModel.this.postID = mVar.aPQ().getId();
                            }
                            if (mVar.MR() != null) {
                                SubPbModel.this.threadID = mVar.MR().getId();
                                SubPbModel.this.eFW = mVar.nG();
                                SubPbModel.this.eXX = mVar.MR().rK();
                            }
                            if (SubPbModel.this.eXX != null && SubPbModel.this.postID != null && SubPbModel.this.eXX.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eFW = true;
                            }
                            if (SubPbModel.this.eYe) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.eXY != null) {
                                SubPbModel.this.eXY.a(SubPbModel.this.aVw(), error, errorString, SubPbModel.this.eVv);
                            }
                        }
                    }
                }
            }
        };
        this.aby = tbPageContext;
        this.eYc = new ArrayList<>();
        this.eVv = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eVz);
        registerListener(this.eVz);
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

    public m aVv() {
        return this.eVv;
    }

    public AntiData aDx() {
        return this.eFV;
    }

    public boolean aVw() {
        return (this.eVv == null || this.eVv.aPQ() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eXY = aVar;
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
        markData.setFloor(postData.bsz());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eVz);
        if (this.eLN != null) {
            this.eLN.unRegisterListener();
        }
        adw();
    }

    private void adw() {
        if (this.cdy != null) {
            this.cdy.destory();
            this.cdy = null;
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

    public void pE(String str) {
        if (!TextUtils.isEmpty(str) && this.eVv != null && this.eVv.aPU() != null) {
            ArrayList<PostData> aPU = this.eVv.aPU();
            int size = aPU.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aPU.get(i).getId())) {
                    aPU.remove(i);
                    this.eXZ++;
                    this.eVv.setTotalCount(this.eVv.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aVx() {
        int JP = this.eVv.JP();
        if (JP == 0) {
            return JP + 1;
        }
        if (this.mLoadType == 0) {
            return JP + 1;
        }
        if (this.mLoadType == 2 && this.eVv.aPU().size() != 0 && this.eVv.aPU().size() % this.eVv.aPW() == 0) {
            return JP + 1;
        }
        if (this.mLoadType == 3 && this.eYe) {
            return this.eVv.aPS() - 1;
        }
        if (this.mLoadType == 3 && JP > 0) {
            return this.eVv.aPR() - 1;
        }
        return JP;
    }

    private SubPbRequestMessage aUB() {
        this.isLoading = true;
        return h((Integer) null);
    }

    private SubPbRequestMessage h(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ae = k.ae(TbadkCoreApplication.getInst().getApp());
        int af = k.af(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aVx();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eYe && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aby.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ae, af, f, this.stType, i2);
    }

    public boolean Fu() {
        return pQ(0);
    }

    public boolean aVy() {
        return pQ(2);
    }

    public void aVz() {
        int aPW;
        if (this.eXZ > 0 && this.eVv != null && (aPW = this.eVv.aPW()) > 0) {
            int JP = this.eVv.JP();
            for (int i = (((this.eXZ + aPW) - 1) / aPW) - 1; i >= 0; i--) {
                this.eYj = h(Integer.valueOf(JP - i));
                this.eYj.setTreatDelPage(true);
                sendMessage(this.eYj);
            }
        }
        this.eXZ = 0;
    }

    public boolean aVA() {
        return pQ(1);
    }

    public boolean aVB() {
        return pQ(3);
    }

    public boolean pQ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aVz();
        this.mLoadType = i;
        this.eYj = aUB();
        sendMessage(this.eYj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aPU = mVar.aPU();
        if (aPU == null || aPU.size() == 0) {
            mVar.bX(this.eVv.JP());
        }
        if (this.mLoadType == 1) {
            this.eVv = mVar;
        } else if (this.mLoadType == 2) {
            this.eVv.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.eVv.a(mVar, false);
        } else {
            this.eVv.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.eVv = mVar;
            this.eVv.aPT();
        } else if (this.mLoadType == 2) {
            this.eVv.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.eVv.d(mVar, false);
        } else {
            this.eVv.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.MR() == null || mVar.MR().getAuthor() == null) {
            str = null;
        } else {
            str = mVar.MR().getAuthor().getUserId();
        }
        if (!this.eYe) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aPU().size()) {
                    break;
                }
                mVar.aPU().get(i2).b(this.aby, str.equals(mVar.aPU().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eYc.add(mVar);
    }

    public boolean aUV() {
        return this.eXS;
    }

    public boolean isMarked() {
        return this.eFW;
    }

    public boolean aVC() {
        return "hot_topic".equals(getStType());
    }

    public void ke(boolean z) {
        this.eFW = z;
    }

    public int aPt() {
        return this.eFa;
    }

    public String aVD() {
        return this.eXX;
    }

    public void pF(String str) {
        this.eXX = str;
    }

    public boolean aVE() {
        return this.eXW;
    }

    public String aVF() {
        return this.eXU;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fQ(String str) {
        if (this.eVv == null || this.eVv.aPX() == null || this.eVv.MR() == null || this.eVv.aPQ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eVv.aPX().getName());
        writeData.setForumId(this.eVv.aPX().getId());
        writeData.setFloor(this.eVv.aPQ().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eVv.MR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dp() {
        if (this.eYi) {
            aVH();
        } else {
            aVy();
        }
        return true;
    }

    public boolean aVG() {
        return this.eYi;
    }

    public void kf(boolean z) {
        this.eYi = z;
    }

    private void aVH() {
        if (this.eLN == null) {
            this.eLN = new PbFakeFloorModel(this.aby);
            this.eLN.setUniqueId(BdUniqueId.gen());
            this.eLN.d(this.eVv);
            this.eLN.setPostId(this.postID);
            this.eLN.a(this.eVy);
        }
        this.eLN.aUA();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.eVy = aVar;
    }

    public boolean aVI() {
        return this.eYe;
    }

    public void kg(boolean z) {
        this.eYe = z;
    }

    public SmallTailInfo aVJ() {
        return this.eYd;
    }

    public boolean aVK() {
        return this.eYb;
    }

    public ConcurrentHashMap<String, ImageUrlData> aVL() {
        return this.eYg;
    }

    public ArrayList<String> aVM() {
        return this.eYf;
    }

    public boolean aVN() {
        return this.eYh;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aVO() {
        return this.eXV;
    }
}
