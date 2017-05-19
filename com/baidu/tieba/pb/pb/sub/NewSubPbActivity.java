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
    private static final String epA = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String eqC = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aNK;
    private com.baidu.adp.lib.e.b<TextView> aNL;
    private com.baidu.adp.lib.e.b<View> aNM;
    private com.baidu.adp.lib.e.b<View> aNN;
    private com.baidu.adp.lib.e.b<LinearLayout> aNO;
    private com.baidu.adp.lib.e.b<GifView> aNP;
    private View.OnLongClickListener atr;
    private VoiceManager bOm;
    private View.OnClickListener coZ;
    private com.baidu.tbadk.baseEditMark.a dCb;
    private com.baidu.tbadk.editortools.pb.n dhG;
    private com.baidu.adp.base.g egJ;
    private com.baidu.tbadk.core.view.h egK;
    private c.b ehp;
    private SubPbModel eqD;
    private ForumManageModel eqE;
    private ao eqF;
    private AbsListView.OnScrollListener eqG;
    private TbRichTextView.f eqH;
    private TbRichTextView.e eqI;
    private SubPbModel.a eqJ;
    private com.baidu.adp.base.f eqK;
    private BdUniqueId eqP;
    private b eqR;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int ehm = 0;
    private a.InterfaceC0033a ehh = null;
    private a eqL = null;
    private a eqM = null;
    private boolean eqN = false;
    private boolean eqO = false;
    private boolean eqQ = false;
    private boolean eqS = false;
    private com.baidu.tbadk.editortools.pb.b aAY = new h(this);
    private NewWriteModel.d eqT = new s(this);
    private CustomMessageListener ehb = new ad(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener ehc = new ai(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener ehd = new aj(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean ehn = false;
    private CustomMessageListener cKX = new ak(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.d epD = new al(this);
    CustomMessageListener bPc = new am(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        s(bundle);
        if (this.eqS) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.egJ = getPageContext();
        this.eqO = true;
        aht();
        aMD();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eqD.aMG()) {
            this.eqR = new b(this, getListView(), this.eqF.JH());
            this.eqR.aMy();
            this.eqR.a(new an(this));
            this.eqF.e(this.eqR);
            this.eqF.iM(true);
        }
        this.egK = new com.baidu.tbadk.core.view.h();
        this.egK.aiW = 1000L;
        registerListener(this.ehd);
        registerListener(this.ehb);
        registerListener(this.ehc);
        this.eqP = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eqP;
        userMuteAddAndDelCustomMessage.setTag(this.eqP);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eqP;
        userMuteCheckCustomMessage.setTag(this.eqP);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eqF = new ao(this, this.coZ);
        this.eqF.a(this.eqD);
        addContentView(this.eqF.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eqF.setOnScrollListener(this.eqG);
        this.eqF.a(this);
        this.eqF.setOnLinkImageClickListener(this.eqH);
        this.eqF.setOnImageClickListener(this.eqI);
        this.eqF.hL(true);
        this.eqF.setOnLongClickListener(this.atr);
        this.eqF.f(new i(this));
        this.eqF.a(this.eqL);
        this.eqF.b(this.eqM);
        if (this.eqD != null && this.eqD.aMG() && !this.eqD.aNt()) {
            this.eqF.aMV().setVisibility(8);
        } else {
            this.eqF.aMV().setVisibility(0);
        }
        if (this.eqD != null && !this.eqD.aMG()) {
            this.eqF.setIsFromPb(false);
        }
    }

    private boolean s(Bundle bundle) {
        if (bundle != null) {
            this.eqS = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eqS = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eqS;
    }

    public void initData(Bundle bundle) {
        this.eqD = new SubPbModel(getPageContext());
        this.eqD.b(new j(this));
        this.eqE = new ForumManageModel(this);
        this.eqE.setLoadDataCallBack(this.eqK);
        this.bOm = new VoiceManager();
        this.bOm.onCreate(getPageContext());
        this.dCb = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dCb != null) {
            this.dCb.a(this.ehh);
        }
        if (bundle != null) {
            this.eqD.initWithBundle(bundle);
        } else {
            this.eqD.initWithIntent(getIntent());
        }
        this.eqD.a(this.eqJ);
        if (this.eqD.aMG()) {
            this.eqD.EG();
        } else {
            this.eqD.aNj();
        }
    }

    public void aMD() {
        this.eqJ = new k(this);
        this.ehh = new l(this);
        this.eqL = new m(this);
        this.eqM = new n(this);
        this.eqK = new o(this);
    }

    public void aht() {
        registerListener(this.bPc);
        this.coZ = new p(this);
        this.eqG = new q(this);
        this.ehp = new r(this);
        this.atr = new t(this);
        this.eqH = new u(this);
        this.eqI = new v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo HI;
        if (tbRichText == tbRichText2) {
            this.ehn = true;
        }
        if (tbRichText != null && tbRichText.HC() != null) {
            int size = tbRichText.HC().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.HC().get(i6) != null && tbRichText.HC().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.HC().get(i6).HI().getWidth();
                    int height = tbRichText.HC().get(i6).HI().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.HC().get(i6).HI().HU()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.HC().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (HI = tbRichTextData.HI()) != null) {
                            String HW = HI.HW();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = HW;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.ehn) {
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
        TbRichTextImageInfo HI = tbRichTextData.HI();
        if (HI != null) {
            if (!StringUtils.isNull(HI.HT())) {
                return HI.HT();
            }
            if (HI.getHeight() * HI.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (HI.getHeight() * HI.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (HI.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * HI.getHeight())));
            } else {
                float width = HI.getWidth() / HI.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.au.aD(HI.HV()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText an(String str, int i) {
        if (this.eqD == null || this.eqD.aNe() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.l aNe = this.eqD.aNe();
        TbRichText a2 = a(aNe.aIr(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aNe.aIr(), str, i);
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
        TbRichText aui = postData.aui();
        if (aui != null) {
            ArrayList<TbRichTextData> HC = aui.HC();
            int size = HC.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (HC.get(i3) != null && HC.get(i3).getType() == 8) {
                    i2++;
                    if (HC.get(i3).HI().HW().equals(str)) {
                        int width = HC.get(i3).HI().getWidth();
                        int height = HC.get(i3).HI().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.ehm = i3;
                        return aui;
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
    public void i(Context context, String str, String str2) {
        long templateId = this.eqD.aNe().aIr().bgU() != null ? this.eqD.aNe().aIr().bgU().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bb.vB().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eqD.aNe().aIx().getId(), this.eqD.aNe().aIx().getName(), this.eqD.aNe().JB().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i, String str) {
        if (this.eqD.aNf()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.k.hB()) {
            if (i == 4) {
                this.eqF.nT(String.valueOf(str) + "(4)");
            } else {
                this.eqF.fS(w.l.no_data_text);
            }
        } else {
            this.eqF.fS(w.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dhG = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aQ(getActivity());
        this.dhG.a(getPageContext());
        this.dhG.b(this.eqD);
        this.dhG.b(this.eqT);
        this.dhG.a(this.aAY);
        this.dhG.Cs().bD(true);
        this.dhG.f(getPageContext());
        if (this.eqF != null) {
            this.eqF.f(this.dhG);
        }
        if (this.dhG != null && this.eqD != null) {
            this.dhG.a(this.eqD.aup());
            this.dhG.Dq();
        }
    }

    public void aME() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dhG.Dq();
        } else if (!StringUtils.isNull(this.eqD.aNo())) {
            this.eqF.nU(this.eqD.aNo());
            if (this.eqF.aMP() && com.baidu.adp.lib.util.k.hB()) {
                this.eqF.XY();
            } else {
                this.eqF.aMS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(View view) {
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
                    this.eqF.aW(view);
                }
            } else if (booleanValue2) {
                this.eqF.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.eqF.aMX(), getPageContext().getPageActivity());
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
        cVar.ca(w.l.operation);
        cVar.a(strArr, new w(this, sparseArray, z, str));
        cVar.d(getPageContext()).tg();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(w.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(w.h.tag_user_mute_mute_userid);
        }
        this.eqF.asr();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eqP;
        userMuteCheckCustomMessage.setTag(this.eqP);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.eqF.a(0, bVar.AM, bVar.fwz, z);
            if (bVar.AM) {
                if (bVar.fwx == 1) {
                    finish();
                } else if (bVar.fwx == 2) {
                    this.eqD.nX(bVar.mPostId);
                    this.eqF.a(this.eqD.aNe(), this.eqD.aHR(), this.eqD.aNu() != null);
                    if (this.eqD.aNp()) {
                        this.eqD.iQ(false);
                        this.eqF.aMN();
                        this.eqD.EG();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            }
        }
    }

    public void nD(String str) {
        if (!StringUtils.isNull(str) && this.eqD != null) {
            String threadID = this.eqD.getThreadID();
            String CN = this.eqD.CN();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + CN + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.eqD.isMarked() && postData.getId() != null && postData.getId().equals(this.eqD.aNm())) {
                z = true;
            }
            MarkData g = this.eqD.g(postData);
            if (g != null) {
                this.eqF.auE();
                if (this.dCb != null) {
                    this.dCb.a(g);
                    if (!z) {
                        this.dCb.nN();
                    } else {
                        this.dCb.nM();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eqD != null) {
            this.eqD.p(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dhG != null) {
            this.dhG.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bOm != null) {
            this.bOm.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eqN = true;
        super.onPause();
        if (this.bOm != null) {
            this.bOm.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cKX);
        this.eqF.aaR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eqN = false;
        super.onResume();
        if (this.bOm != null) {
            this.bOm.onResume(getPageContext());
        }
        registerListener(this.cKX);
        this.eqF.aaS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bOm != null) {
            this.bOm.onStop(getPageContext());
        }
        this.dhG.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eqD.cancelLoadData();
        this.eqD.destory();
        this.eqE.cancelLoadData();
        if (this.bOm != null) {
            this.bOm.onDestory(getPageContext());
        }
        this.eqF.auE();
        this.eqF.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.ehb);
        MessageManager.getInstance().unRegisterListener(this.ehc);
        MessageManager.getInstance().unRegisterListener(this.ehd);
        MessageManager.getInstance().unRegisterListener(this.eqP);
        this.egJ = null;
        this.egK = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eqF.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bOm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aMT = this.eqF.aMT();
        if (aMT == null || (findViewWithTag = aMT.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean nR(String str) {
        Map<String, String> dE;
        if (!TextUtils.isEmpty(str) && (dE = com.baidu.tbadk.core.util.bb.dE(com.baidu.tbadk.core.util.bb.dF(str))) != null) {
            this.eqQ = true;
            String str2 = dE.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return nR(com.baidu.adp.lib.util.j.aE(str2));
            }
            String str3 = dE.get(eqC);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (nR(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            com.baidu.tbadk.core.util.bb.vB().c(getPageContext(), new String[]{str});
            this.eqQ = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eqQ = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void f(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.eqF != null) {
            return this.eqF.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int If() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Ih() {
        if (this.aNL == null) {
            this.aNL = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aNL;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Ii() {
        if (this.aNP == null) {
            this.aNP = new com.baidu.adp.lib.e.b<>(new x(this), 20, 0);
        }
        return this.aNP;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Ig() {
        if (this.aNK == null) {
            this.aNK = new com.baidu.adp.lib.e.b<>(new y(this), 8, 0);
        }
        return this.aNK;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Ij() {
        if (this.aNN == null) {
            this.aNN = new com.baidu.adp.lib.e.b<>(new z(this), 8, 0);
        }
        return this.aNN;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Ik() {
        if (this.aNO == null) {
            this.aNO = new com.baidu.adp.lib.e.b<>(new aa(this), 15, 0);
        }
        return this.aNO;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Il() {
        if (this.aNM == null) {
            this.aNM = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 8);
        }
        return this.aNM;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void ln() {
        if (this.eqF.aMP() && com.baidu.adp.lib.util.k.hB()) {
            this.eqD.EG();
        } else {
            this.eqF.aMS();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eqP);
        userMuteAddAndDelCustomMessage.setTag(this.eqP);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
        i(context, str, "BUTTON");
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
        if (pageStayDurationItem != null && this.eqD != null) {
            if (this.eqD.aNe() != null && this.eqD.aNe().aIx() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.eqD.aNe().aIx().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.eqD.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aMF() {
        return this.eqN;
    }

    public boolean aMG() {
        if (this.eqD != null) {
            return this.eqD.aMG();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eqF.asr();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.egJ.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cC(this.egJ.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cC(str);
        }
        aVar.a(w.l.confirm, new ac(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new ae(this));
        aVar.b(this.egJ).td();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fA(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.egJ.getPageActivity());
        aVar.cC(str);
        aVar.b(w.l.know, new af(this));
        aVar.b(this.egJ).td();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJq() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cC(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new ag(this));
        aVar.b(w.l.cancel, new ah(this));
        aVar.b(this.egJ).td();
    }

    public String getThreadId() {
        if (this.eqD != null) {
            return this.eqD.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eqD != null) {
            return this.eqD.CN();
        }
        return null;
    }

    public int aHR() {
        if (this.eqD != null) {
            return this.eqD.aHR();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eqS) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eqS) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
