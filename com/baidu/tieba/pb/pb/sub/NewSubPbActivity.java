package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.d {
    private static final String eFV = String.valueOf(com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String eHk = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aOX;
    private com.baidu.adp.lib.e.b<TextView> aOY;
    private com.baidu.adp.lib.e.b<View> aOZ;
    private com.baidu.adp.lib.e.b<View> aPa;
    private com.baidu.adp.lib.e.b<LinearLayout> aPb;
    private com.baidu.adp.lib.e.b<GifView> aPc;
    private View.OnLongClickListener aue;
    private View.OnClickListener cDj;
    private VoiceManager cci;
    private com.baidu.tbadk.baseEditMark.a dPW;
    private com.baidu.tbadk.editortools.pb.n duY;
    private SubPbModel eHl;
    private ForumManageModel eHm;
    private ao eHn;
    private AbsListView.OnScrollListener eHo;
    private TbRichTextView.f eHp;
    private TbRichTextView.e eHq;
    private SubPbModel.a eHr;
    private com.baidu.adp.base.f eHs;
    private BdUniqueId eHx;
    private b eHz;
    private c.b evX;
    private com.baidu.adp.base.g evk;
    private com.baidu.tbadk.core.view.h evl;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int evU = 0;
    private a.InterfaceC0035a evP = null;
    private a eHt = null;
    private a eHu = null;
    private boolean eHv = false;
    private boolean eHw = false;
    private boolean eHy = false;
    private boolean eHA = false;
    private com.baidu.tbadk.editortools.pb.b aBN = new h(this);
    private NewWriteModel.d eHB = new s(this);
    private CustomMessageListener evI = new ad(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener evJ = new ai(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener evK = new aj(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean evV = false;
    private CustomMessageListener cYr = new ak(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.d eFY = new al(this);
    CustomMessageListener ccZ = new am(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        s(bundle);
        if (this.eHA) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.evk = getPageContext();
        this.eHw = true;
        amu();
        aRM();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eHl.aRO()) {
            this.eHz = new b(this, getListView(), this.eHn.aeL());
            this.eHz.aRH();
            this.eHz.a(new an(this));
            this.eHn.e(this.eHz);
            this.eHn.jB(true);
        }
        this.evl = new com.baidu.tbadk.core.view.h();
        this.evl.aju = 1000L;
        registerListener(this.evK);
        registerListener(this.evI);
        registerListener(this.evJ);
        this.eHx = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eHx;
        userMuteAddAndDelCustomMessage.setTag(this.eHx);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eHx;
        userMuteCheckCustomMessage.setTag(this.eHx);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eHn = new ao(this, this.cDj);
        this.eHn.a(this.eHl);
        addContentView(this.eHn.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eHn.setOnScrollListener(this.eHo);
        this.eHn.a(this);
        this.eHn.setOnLinkImageClickListener(this.eHp);
        this.eHn.setOnImageClickListener(this.eHq);
        this.eHn.iv(true);
        this.eHn.setOnLongClickListener(this.aue);
        this.eHn.f(new i(this));
        this.eHn.a(this.eHt);
        this.eHn.b(this.eHu);
        if (this.eHl != null && this.eHl.aRO() && !this.eHl.aSB()) {
            this.eHn.aSd().setVisibility(8);
        } else {
            this.eHn.aSd().setVisibility(0);
        }
        if (this.eHl != null && !this.eHl.aRO()) {
            this.eHn.setIsFromPb(false);
        }
    }

    private boolean s(Bundle bundle) {
        if (bundle != null) {
            this.eHA = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eHA = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eHA;
    }

    public void initData(Bundle bundle) {
        this.eHl = new SubPbModel(getPageContext());
        this.eHl.b(new j(this));
        this.eHm = new ForumManageModel(this);
        this.eHm.setLoadDataCallBack(this.eHs);
        this.cci = new VoiceManager();
        this.cci.onCreate(getPageContext());
        this.dPW = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dPW != null) {
            this.dPW.a(this.evP);
        }
        if (bundle != null) {
            this.eHl.initWithBundle(bundle);
        } else {
            this.eHl.initWithIntent(getIntent());
        }
        this.eHl.a(this.eHr);
        if (this.eHl.aRO()) {
            this.eHl.EX();
        } else {
            this.eHl.aSr();
        }
    }

    public void aRM() {
        this.eHr = new k(this);
        this.evP = new l(this);
        this.eHt = new m(this);
        this.eHu = new n(this);
        this.eHs = new o(this);
    }

    public void amu() {
        registerListener(this.ccZ);
        this.cDj = new p(this);
        this.eHo = new q(this);
        this.evX = new r(this);
        this.aue = new t(this);
        this.eHp = new u(this);
        this.eHq = new v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Ia;
        if (tbRichText == tbRichText2) {
            this.evV = true;
        }
        if (tbRichText != null && tbRichText.HU() != null) {
            int size = tbRichText.HU().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.HU().get(i6) != null && tbRichText.HU().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.HU().get(i6).Ia().getWidth();
                    int height = tbRichText.HU().get(i6).Ia().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.HU().get(i6).Ia().In()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.HU().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (Ia = tbRichTextData.Ia()) != null) {
                            String Ip = Ia.Ip();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Ip;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.evV) {
                            i4 = i7 + 1;
                            i3 = i5;
                        }
                    }
                    i6++;
                    i7 = i4;
                    i5 = i3;
                }
                i3 = i5;
                i4 = i7;
                i6++;
                i7 = i4;
                i5 = i3;
            }
            return i7;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Ia = tbRichTextData.Ia();
        if (Ia != null) {
            if (!StringUtils.isNull(Ia.Im())) {
                return Ia.Im();
            }
            if (Ia.getHeight() * Ia.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ia.getHeight() * Ia.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ia.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ia.getHeight())));
            } else {
                float width = Ia.getWidth() / Ia.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.aw.aI(Ia.Io()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText ap(String str, int i) {
        if (this.eHl == null || this.eHl.aSm() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.n aSm = this.eHl.aSm();
        TbRichText a2 = a(aSm.aNd(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aSm.aNd(), str, i);
            if (a3 != null) {
            }
            return a3;
        }
        return a2;
    }

    private TbRichText a(PostData postData, String str, int i) {
        if (postData == null) {
            return null;
        }
        TbRichText azb = postData.azb();
        if (azb != null) {
            ArrayList<TbRichTextData> HU = azb.HU();
            int size = HU.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (HU.get(i3) != null && HU.get(i3).getType() == 8) {
                    i2++;
                    if (HU.get(i3).Ia().Ip().equals(str)) {
                        int width = HU.get(i3).Ia().getWidth();
                        int height = HU.get(i3).Ia().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.evU = i3;
                        return azb;
                    } else if (i2 > i) {
                        break;
                    }
                }
                i3++;
                i2 = i2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, String str, String str2) {
        long templateId = this.eHl.aSm().aNd().bmC() != null ? this.eHl.aSm().aNd().bmC().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && be.vP().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eHl.aSm().aNj().getId(), this.eHl.aSm().aNj().getName(), this.eHl.aSm().Mv().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
        if (this.eHl.aSn()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.k.hA()) {
            if (i == 4) {
                this.eHn.pb(String.valueOf(str) + "(4)");
            } else {
                this.eHn.ge(w.l.no_data_text);
            }
        } else {
            this.eHn.ge(w.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.duY = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aQ(getActivity());
        this.duY.a(getPageContext());
        this.duY.b(this.eHl);
        this.duY.b(this.eHB);
        this.duY.a(this.aBN);
        this.duY.CG().bB(true);
        this.duY.f(getPageContext());
        if (this.eHn != null) {
            this.eHn.f(this.duY);
        }
        if (this.duY != null && this.eHl != null) {
            this.duY.a(this.eHl.azh());
            this.duY.DE();
        }
    }

    public void aRN() {
        if (!TbadkCoreApplication.isLogin()) {
            this.duY.DE();
        } else if (!StringUtils.isNull(this.eHl.aSw())) {
            this.eHn.pc(this.eHl.aSw());
            if (this.eHn.aRX() && com.baidu.adp.lib.util.k.hA()) {
                this.eHn.acA();
            } else {
                this.eHn.aSa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(w.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(w.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(w.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(w.h.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.eHn.ba(view);
                }
            } else if (booleanValue2) {
                this.eHn.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.eHn.aSf(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(w.h.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(w.h.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(w.l.delete);
            strArr2[1] = z ? getResources().getString(w.l.un_mute) : getResources().getString(w.l.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(w.l.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.cb(w.l.operation);
        cVar.a(strArr, new w(this, sparseArray, z, str));
        cVar.d(getPageContext()).td();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(w.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(w.h.tag_user_mute_mute_userid);
        }
        this.eHn.Qx();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eHx;
        userMuteCheckCustomMessage.setTag(this.eHx);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eHn.a(0, bVar.AM, bVar.fOw, z);
            if (bVar.AM) {
                if (bVar.fOu == 1) {
                    finish();
                } else if (bVar.fOu == 2) {
                    this.eHl.pf(bVar.mPostId);
                    this.eHn.a(this.eHl.aSm(), this.eHl.aMG(), this.eHl.aSC() != null);
                    if (this.eHl.aSx()) {
                        this.eHl.jG(false);
                        this.eHn.aRV();
                        this.eHl.EX();
                    }
                }
                com.baidu.tieba.pb.h hVar = new com.baidu.tieba.pb.h();
                hVar.setData(bVar);
                hVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, hVar));
            }
        }
    }

    public void oJ(String str) {
        if (!StringUtils.isNull(str) && this.eHl != null) {
            String threadID = this.eHl.getThreadID();
            String Db = this.eHl.Db();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Db + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void h(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eHl.isMarked() && postData.getId() != null && postData.getId().equals(this.eHl.aSu())) {
                z = true;
            }
            MarkData j = this.eHl.j(postData);
            if (j != null) {
                this.eHn.azw();
                if (this.dPW != null) {
                    this.dPW.a(j);
                    if (!z) {
                        this.dPW.nB();
                    } else {
                        this.dPW.nA();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eHl != null) {
            this.eHl.p(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.duY != null) {
            this.duY.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.cci != null) {
            this.cci.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eHv = true;
        super.onPause();
        if (this.cci != null) {
            this.cci.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cYr);
        this.eHn.afM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eHv = false;
        super.onResume();
        if (this.cci != null) {
            this.cci.onResume(getPageContext());
        }
        registerListener(this.cYr);
        this.eHn.afN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.cci != null) {
            this.cci.onStop(getPageContext());
        }
        this.duY.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eHl.cancelLoadData();
        this.eHl.destory();
        this.eHm.cancelLoadData();
        if (this.cci != null) {
            this.cci.onDestory(getPageContext());
        }
        this.eHn.azw();
        this.eHn.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.evI);
        MessageManager.getInstance().unRegisterListener(this.evJ);
        MessageManager.getInstance().unRegisterListener(this.evK);
        MessageManager.getInstance().unRegisterListener(this.eHx);
        this.evk = null;
        this.evl = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eHn.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.cci;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aSb = this.eHn.aSb();
        if (aSb == null || (findViewWithTag = aSb.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean oY(String str) {
        Map<String, String> dV;
        if (!TextUtils.isEmpty(str) && (dV = be.dV(be.dW(str))) != null) {
            this.eHy = true;
            String str2 = dV.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return oY(com.baidu.adp.lib.util.j.aJ(str2));
            }
            String str3 = dV.get(eHk);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (oY(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            be.vP().c(getPageContext(), new String[]{str});
            this.eHy = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eHy = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void f(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.eHn != null) {
            return this.eHn.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Iy() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IA() {
        if (this.aOY == null) {
            this.aOY = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aOY;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IB() {
        if (this.aPc == null) {
            this.aPc = new com.baidu.adp.lib.e.b<>(new x(this), 20, 0);
        }
        return this.aPc;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Iz() {
        if (this.aOX == null) {
            this.aOX = new com.baidu.adp.lib.e.b<>(new y(this), 8, 0);
        }
        return this.aOX;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IC() {
        if (this.aPa == null) {
            this.aPa = new com.baidu.adp.lib.e.b<>(new z(this), 8, 0);
        }
        return this.aPa;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> ID() {
        if (this.aPb == null) {
            this.aPb = new com.baidu.adp.lib.e.b<>(new aa(this), 15, 0);
        }
        return this.aPb;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IE() {
        if (this.aOZ == null) {
            this.aOZ = com.baidu.tieba.graffiti.d.p(getPageContext().getPageActivity(), 8);
        }
        return this.aOZ;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eHn.aRX() && com.baidu.adp.lib.util.k.hA()) {
            this.eHl.EX();
        } else {
            this.eHn.aSa();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(w.h.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(w.h.tag_user_mute_mute_username);
        }
        if (sparseArray.get(w.h.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(w.h.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(w.h.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(w.h.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(w.h.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(w.h.tag_user_mute_msg) : str2;
        if (sparseArray.get(w.h.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(w.h.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eHx);
        userMuteAddAndDelCustomMessage.setTag(this.eHx);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ae(Context context, String str) {
        j(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new ab(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eHl != null) {
            if (this.eHl.aSm() != null && this.eHl.aSm().aNj() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eHl.aSm().aNj().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eHl.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean Yp() {
        return this.eHv;
    }

    public boolean aRO() {
        if (this.eHl != null) {
            return this.eHl.aRO();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eHn.Qx();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.evk.getPageActivity());
        if (com.baidu.tbadk.core.util.aw.isEmpty(str)) {
            aVar.cI(this.evk.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cI(str);
        }
        aVar.a(w.l.confirm, new ac(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new ae(this));
        aVar.b(this.evk).ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.evk.getPageActivity());
        aVar.cI(str);
        aVar.b(w.l.know, new af(this));
        aVar.b(this.evk).ta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOf() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cI(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new ag(this));
        aVar.b(w.l.cancel, new ah(this));
        aVar.b(this.evk).ta();
    }

    public String getThreadId() {
        if (this.eHl != null) {
            return this.eHl.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eHl != null) {
            return this.eHl.Db();
        }
        return null;
    }

    public int aMG() {
        if (this.eHl != null) {
            return this.eHl.aMG();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eHA) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eHA) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
