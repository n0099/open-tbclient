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
    private static final String erH = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String esD = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aNq;
    private com.baidu.adp.lib.e.b<TextView> aNr;
    private com.baidu.adp.lib.e.b<View> aNs;
    private com.baidu.adp.lib.e.b<View> aNt;
    private com.baidu.adp.lib.e.b<LinearLayout> aNu;
    private com.baidu.adp.lib.e.b<GifView> aNv;
    private View.OnLongClickListener atl;
    private VoiceManager bMC;
    private View.OnClickListener cpI;
    private com.baidu.tbadk.baseEditMark.a dFo;
    private com.baidu.tbadk.editortools.pb.n dlk;
    private c.b ejL;
    private com.baidu.adp.base.g ejh;
    private com.baidu.tbadk.core.view.h eji;
    private SubPbModel esE;
    private ForumManageModel esF;
    private ao esG;
    private AbsListView.OnScrollListener esH;
    private TbRichTextView.f esI;
    private TbRichTextView.e esJ;
    private SubPbModel.a esK;
    private com.baidu.adp.base.f esL;
    private BdUniqueId esQ;
    private b esS;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int ejI = 0;
    private a.InterfaceC0028a ejD = null;
    private a esM = null;
    private a esN = null;
    private boolean esO = false;
    private boolean esP = false;
    private boolean esR = false;
    private boolean esT = false;
    private com.baidu.tbadk.editortools.pb.b aAY = new h(this);
    private NewWriteModel.d esU = new s(this);
    private CustomMessageListener ejx = new ad(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener ejy = new ai(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener ejz = new aj(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean ejJ = false;
    private CustomMessageListener cOE = new ak(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.d erK = new al(this);
    CustomMessageListener bNv = new am(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        s(bundle);
        if (this.esT) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.ejh = getPageContext();
        this.esP = true;
        alo();
        aOn();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.esE.aOq()) {
            this.esS = new b(this, getListView(), this.esG.Kt());
            this.esS.aOi();
            this.esS.a(new an(this));
            this.esG.e(this.esS);
            this.esG.iX(true);
        }
        this.eji = new com.baidu.tbadk.core.view.h();
        this.eji.ajy = 1000L;
        registerListener(this.ejz);
        registerListener(this.ejx);
        registerListener(this.ejy);
        this.esQ = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.esQ;
        userMuteAddAndDelCustomMessage.setTag(this.esQ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.esQ;
        userMuteCheckCustomMessage.setTag(this.esQ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.esG = new ao(this, this.cpI);
        this.esG.a(this.esE);
        addContentView(this.esG.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.esG.setOnScrollListener(this.esH);
        this.esG.a(this);
        this.esG.setOnLinkImageClickListener(this.esI);
        this.esG.setOnImageClickListener(this.esJ);
        this.esG.ia(true);
        this.esG.setOnLongClickListener(this.atl);
        this.esG.f(new i(this));
        this.esG.a(this.esM);
        this.esG.b(this.esN);
        if (this.esE != null && this.esE.aOq() && !this.esE.aPc()) {
            this.esG.aOE().setVisibility(8);
        } else {
            this.esG.aOE().setVisibility(0);
        }
        if (this.esE != null && !this.esE.aOq()) {
            this.esG.setIsFromPb(false);
        }
    }

    private boolean s(Bundle bundle) {
        if (bundle != null) {
            this.esT = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.esT = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.esT;
    }

    public void initData(Bundle bundle) {
        this.esE = new SubPbModel(getPageContext());
        this.esE.b(new j(this));
        this.esF = new ForumManageModel(this);
        this.esF.setLoadDataCallBack(this.esL);
        this.bMC = new VoiceManager();
        this.bMC.onCreate(getPageContext());
        this.dFo = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dFo != null) {
            this.dFo.a(this.ejD);
        }
        if (bundle != null) {
            this.esE.initWithBundle(bundle);
        } else {
            this.esE.initWithIntent(getIntent());
        }
        this.esE.a(this.esK);
        if (this.esE.aOq()) {
            this.esE.FC();
        } else {
            this.esE.aOS();
        }
    }

    public void aOn() {
        this.esK = new k(this);
        this.ejD = new l(this);
        this.esM = new m(this);
        this.esN = new n(this);
        this.esL = new o(this);
    }

    public void alo() {
        registerListener(this.bNv);
        this.cpI = new p(this);
        this.esH = new q(this);
        this.ejL = new r(this);
        this.atl = new t(this);
        this.esI = new u(this);
        this.esJ = new v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Iu;
        if (tbRichText == tbRichText2) {
            this.ejJ = true;
        }
        if (tbRichText != null && tbRichText.Io() != null) {
            int size = tbRichText.Io().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Io().get(i6) != null && tbRichText.Io().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Io().get(i6).Iu().getWidth();
                    int height = tbRichText.Io().get(i6).Iu().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Io().get(i6).Iu().IG()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Io().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (Iu = tbRichTextData.Iu()) != null) {
                            String II = Iu.II();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = II;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.ejJ) {
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
        TbRichTextImageInfo Iu = tbRichTextData.Iu();
        if (Iu != null) {
            if (!StringUtils.isNull(Iu.IF())) {
                return Iu.IF();
            }
            if (Iu.getHeight() * Iu.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Iu.getHeight() * Iu.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Iu.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Iu.getHeight())));
            } else {
                float width = Iu.getWidth() / Iu.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.au.aD(Iu.IH()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText am(String str, int i) {
        if (this.esE == null || this.esE.aON() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.j aON = this.esE.aON();
        TbRichText a2 = a(aON.aJV(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aON.aJV(), str, i);
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
        TbRichText awl = postData.awl();
        if (awl != null) {
            ArrayList<TbRichTextData> Io = awl.Io();
            int size = Io.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Io.get(i3) != null && Io.get(i3).getType() == 8) {
                    i2++;
                    if (Io.get(i3).Iu().II().equals(str)) {
                        int width = Io.get(i3).Iu().getWidth();
                        int height = Io.get(i3).Iu().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.ejI = i3;
                        return awl;
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
        long templateId = this.esE.aON().aJV().biw() != null ? this.esE.aON().aJV().biw().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bb.wn().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.esE.aON().aKb().getId(), this.esE.aON().aKb().getName(), this.esE.aON().Kn().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        if (this.esE.aOO()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.k.hA()) {
            if (i == 4) {
                this.esG.nM(String.valueOf(str) + "(4)");
            } else {
                this.esG.fV(w.l.no_data_text);
            }
        } else {
            this.esG.fV(w.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dlk = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aN(getActivity());
        this.dlk.a(getPageContext());
        this.dlk.b(this.esE);
        this.dlk.b(this.esU);
        this.dlk.a(this.aAY);
        this.dlk.Dn().bD(true);
        this.dlk.f(getPageContext());
        if (this.esG != null) {
            this.esG.f(this.dlk);
        }
        if (this.dlk != null && this.esE != null) {
            this.dlk.a(this.esE.aws());
            this.dlk.Em();
        }
    }

    public void aOo() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dlk.Em();
        } else if (!StringUtils.isNull(this.esE.aOX())) {
            this.esG.nN(this.esE.aOX());
            if (this.esG.aOy() && com.baidu.adp.lib.util.k.hA()) {
                this.esG.Yg();
            } else {
                this.esG.aOB();
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
                    this.esG.ba(view);
                }
            } else if (booleanValue2) {
                this.esG.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.esG.aOG(), getPageContext().getPageActivity());
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
        cVar.cc(w.l.operation);
        cVar.a(strArr, new w(this, sparseArray, z, str));
        cVar.d(getPageContext()).tT();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(w.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(w.h.tag_user_mute_mute_userid);
        }
        this.esG.auv();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.esQ;
        userMuteCheckCustomMessage.setTag(this.esQ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.esG.a(0, bVar.AJ, bVar.fya, z);
            if (bVar.AJ) {
                if (bVar.fxY == 1) {
                    finish();
                } else if (bVar.fxY == 2) {
                    this.esE.nQ(bVar.mPostId);
                    this.esG.a(this.esE.aON(), this.esE.aJH(), this.esE.aPd() != null);
                    if (this.esE.aOY()) {
                        this.esE.jb(false);
                        this.esG.aOw();
                        this.esE.FC();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            }
        }
    }

    public void nv(String str) {
        if (!StringUtils.isNull(str) && this.esE != null) {
            String threadID = this.esE.getThreadID();
            String DJ = this.esE.DJ();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + DJ + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void d(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.esE.isMarked() && postData.getId() != null && postData.getId().equals(this.esE.aOV())) {
                z = true;
            }
            MarkData e = this.esE.e(postData);
            if (e != null) {
                this.esG.awH();
                if (this.dFo != null) {
                    this.dFo.a(e);
                    if (!z) {
                        this.dFo.og();
                    } else {
                        this.dFo.of();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.esE != null) {
            this.esE.p(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dlk != null) {
            this.dlk.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bMC != null) {
            this.bMC.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.esO = true;
        super.onPause();
        if (this.bMC != null) {
            this.bMC.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cOE);
        this.esG.abD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.esO = false;
        super.onResume();
        if (this.bMC != null) {
            this.bMC.onResume(getPageContext());
        }
        registerListener(this.cOE);
        this.esG.abE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bMC != null) {
            this.bMC.onStop(getPageContext());
        }
        this.dlk.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.esE.cancelLoadData();
        this.esE.destory();
        this.esF.cancelLoadData();
        if (this.bMC != null) {
            this.bMC.onDestory(getPageContext());
        }
        this.esG.awH();
        this.esG.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.ejx);
        MessageManager.getInstance().unRegisterListener(this.ejy);
        MessageManager.getInstance().unRegisterListener(this.ejz);
        MessageManager.getInstance().unRegisterListener(this.esQ);
        this.ejh = null;
        this.eji = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.esG.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bMC;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aOC = this.esG.aOC();
        if (aOC == null || (findViewWithTag = aOC.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean nK(String str) {
        Map<String, String> dG;
        if (!TextUtils.isEmpty(str) && (dG = com.baidu.tbadk.core.util.bb.dG(com.baidu.tbadk.core.util.bb.dH(str))) != null) {
            this.esR = true;
            String str2 = dG.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return nK(com.baidu.adp.lib.util.j.aE(str2));
            }
            String str3 = dG.get(esD);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (nK(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            com.baidu.tbadk.core.util.bb.wn().c(getPageContext(), new String[]{str});
            this.esR = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.esR = true;
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
        if (this.esG != null) {
            return this.esG.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IR() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IT() {
        if (this.aNr == null) {
            this.aNr = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aNr;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IU() {
        if (this.aNv == null) {
            this.aNv = new com.baidu.adp.lib.e.b<>(new x(this), 20, 0);
        }
        return this.aNv;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IS() {
        if (this.aNq == null) {
            this.aNq = new com.baidu.adp.lib.e.b<>(new y(this), 8, 0);
        }
        return this.aNq;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IV() {
        if (this.aNt == null) {
            this.aNt = new com.baidu.adp.lib.e.b<>(new z(this), 8, 0);
        }
        return this.aNt;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IW() {
        if (this.aNu == null) {
            this.aNu = new com.baidu.adp.lib.e.b<>(new aa(this), 15, 0);
        }
        return this.aNu;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IX() {
        if (this.aNs == null) {
            this.aNs = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 8);
        }
        return this.aNs;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void ln() {
        if (this.esG.aOy() && com.baidu.adp.lib.util.k.hA()) {
            this.esE.FC();
        } else {
            this.esG.aOB();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.esQ);
        userMuteAddAndDelCustomMessage.setTag(this.esQ);
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
        if (pageStayDurationItem != null && this.esE != null) {
            if (this.esE.aON() != null && this.esE.aON().aKb() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.esE.aON().aKb().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.esE.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aOp() {
        return this.esO;
    }

    public boolean aOq() {
        if (this.esE != null) {
            return this.esE.aOq();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.esG.auv();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ejh.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cE(this.ejh.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cE(str);
        }
        aVar.a(w.l.confirm, new ac(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new ae(this));
        aVar.b(this.ejh).tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ejh.getPageActivity());
        aVar.cE(str);
        aVar.b(w.l.know, new af(this));
        aVar.b(this.ejh).tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cE(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new ag(this));
        aVar.b(w.l.cancel, new ah(this));
        aVar.b(this.ejh).tQ();
    }

    public String getThreadId() {
        if (this.esE != null) {
            return this.esE.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.esE != null) {
            return this.esE.DJ();
        }
        return null;
    }

    public int aJH() {
        if (this.esE != null) {
            return this.esE.aJH();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.esT) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.esT) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
