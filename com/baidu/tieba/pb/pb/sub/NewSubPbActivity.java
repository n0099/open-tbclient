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
    private static final String etE = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String euy = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aNa;
    private com.baidu.adp.lib.e.b<TextView> aNb;
    private com.baidu.adp.lib.e.b<View> aNc;
    private com.baidu.adp.lib.e.b<View> aNd;
    private com.baidu.adp.lib.e.b<LinearLayout> aNe;
    private com.baidu.adp.lib.e.b<GifView> aNf;
    private View.OnLongClickListener asV;
    private VoiceManager bMM;
    private View.OnClickListener crj;
    private com.baidu.tbadk.baseEditMark.a dIP;
    private com.baidu.tbadk.editortools.pb.n dmL;
    private c.b elF;
    private com.baidu.adp.base.g elb;
    private com.baidu.tbadk.core.view.h elc;
    private ForumManageModel euA;
    private ao euB;
    private AbsListView.OnScrollListener euC;
    private TbRichTextView.f euD;
    private TbRichTextView.e euE;
    private SubPbModel.a euF;
    private com.baidu.adp.base.f euG;
    private BdUniqueId euL;
    private b euN;
    private SubPbModel euz;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int elC = 0;
    private a.InterfaceC0030a elx = null;
    private a euH = null;
    private a euI = null;
    private boolean euJ = false;
    private boolean euK = false;
    private boolean euM = false;
    private boolean euO = false;
    private com.baidu.tbadk.editortools.pb.b aAI = new h(this);
    private NewWriteModel.d euP = new s(this);
    private CustomMessageListener elr = new ad(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener els = new ai(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener elt = new aj(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean elD = false;
    private CustomMessageListener cQh = new ak(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.d etH = new al(this);
    CustomMessageListener bNG = new am(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        r(bundle);
        if (this.euO) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.elb = getPageContext();
        this.euK = true;
        alu();
        aOe();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.euz.aOh()) {
            this.euN = new b(this, getListView(), this.euB.JT());
            this.euN.aNZ();
            this.euN.a(new an(this));
            this.euB.e(this.euN);
            this.euB.iY(true);
        }
        this.elc = new com.baidu.tbadk.core.view.h();
        this.elc.ajk = 1000L;
        registerListener(this.elt);
        registerListener(this.elr);
        registerListener(this.els);
        this.euL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.euL;
        userMuteAddAndDelCustomMessage.setTag(this.euL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.euL;
        userMuteCheckCustomMessage.setTag(this.euL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.euB = new ao(this, this.crj);
        this.euB.a(this.euz);
        addContentView(this.euB.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.euB.setOnScrollListener(this.euC);
        this.euB.a(this);
        this.euB.setOnLinkImageClickListener(this.euD);
        this.euB.setOnImageClickListener(this.euE);
        this.euB.ib(true);
        this.euB.setOnLongClickListener(this.asV);
        this.euB.f(new i(this));
        this.euB.a(this.euH);
        this.euB.b(this.euI);
        if (this.euz != null && this.euz.aOh() && !this.euz.aOT()) {
            this.euB.aOv().setVisibility(8);
        } else {
            this.euB.aOv().setVisibility(0);
        }
        if (this.euz != null && !this.euz.aOh()) {
            this.euB.setIsFromPb(false);
        }
    }

    private boolean r(Bundle bundle) {
        if (bundle != null) {
            this.euO = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.euO = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.euO;
    }

    public void initData(Bundle bundle) {
        this.euz = new SubPbModel(getPageContext());
        this.euz.b(new j(this));
        this.euA = new ForumManageModel(this);
        this.euA.setLoadDataCallBack(this.euG);
        this.bMM = new VoiceManager();
        this.bMM.onCreate(getPageContext());
        this.dIP = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dIP != null) {
            this.dIP.a(this.elx);
        }
        if (bundle != null) {
            this.euz.initWithBundle(bundle);
        } else {
            this.euz.initWithIntent(getIntent());
        }
        this.euz.a(this.euF);
        if (this.euz.aOh()) {
            this.euz.Fe();
        } else {
            this.euz.aOJ();
        }
    }

    public void aOe() {
        this.euF = new k(this);
        this.elx = new l(this);
        this.euH = new m(this);
        this.euI = new n(this);
        this.euG = new o(this);
    }

    public void alu() {
        registerListener(this.bNG);
        this.crj = new p(this);
        this.euC = new q(this);
        this.elF = new r(this);
        this.asV = new t(this);
        this.euD = new u(this);
        this.euE = new v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo HV;
        if (tbRichText == tbRichText2) {
            this.elD = true;
        }
        if (tbRichText != null && tbRichText.HP() != null) {
            int size = tbRichText.HP().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.HP().get(i6) != null && tbRichText.HP().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.HP().get(i6).HV().getWidth();
                    int height = tbRichText.HP().get(i6).HV().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.HP().get(i6).HV().Ih()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.HP().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (HV = tbRichTextData.HV()) != null) {
                            String Ij = HV.Ij();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Ij;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.elD) {
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
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo HV = tbRichTextData.HV();
        if (HV != null) {
            if (!StringUtils.isNull(HV.Ig())) {
                return HV.Ig();
            }
            if (HV.getHeight() * HV.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (HV.getHeight() * HV.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (HV.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * HV.getHeight())));
            } else {
                float width = HV.getWidth() / HV.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.au.aI(HV.Ii()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText am(String str, int i) {
        if (this.euz == null || this.euz.aOE() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.j aOE = this.euz.aOE();
        TbRichText a2 = a(aOE.aJO(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aOE.aJO(), str, i);
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
        TbRichText aws = postData.aws();
        if (aws != null) {
            ArrayList<TbRichTextData> HP = aws.HP();
            int size = HP.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (HP.get(i3) != null && HP.get(i3).getType() == 8) {
                    i2++;
                    if (HP.get(i3).HV().Ij().equals(str)) {
                        int width = HP.get(i3).HV().getWidth();
                        int height = HP.get(i3).HV().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.elC = i3;
                        return aws;
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
        long templateId = this.euz.aOE().aJO().bhL() != null ? this.euz.aOE().aJO().bhL().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bb.vQ().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.euz.aOE().aJU().getId(), this.euz.aOE().aJU().getName(), this.euz.aOE().JN().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        if (this.euz.aOF()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.k.hv()) {
            if (i == 4) {
                this.euB.nI(String.valueOf(str) + "(4)");
            } else {
                this.euB.fS(w.l.no_data_text);
            }
        } else {
            this.euB.fS(w.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dmL = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aL(getActivity());
        this.dmL.a(getPageContext());
        this.dmL.b(this.euz);
        this.dmL.b(this.euP);
        this.dmL.a(this.aAI);
        this.dmL.CP().bB(true);
        this.dmL.f(getPageContext());
        if (this.euB != null) {
            this.euB.f(this.dmL);
        }
        if (this.dmL != null && this.euz != null) {
            this.dmL.a(this.euz.awz());
            this.dmL.DO();
        }
    }

    public void aOf() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dmL.DO();
        } else if (!StringUtils.isNull(this.euz.aOO())) {
            this.euB.nJ(this.euz.aOO());
            if (this.euB.aOp() && com.baidu.adp.lib.util.k.hv()) {
                this.euB.XI();
            } else {
                this.euB.aOs();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(View view) {
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
                    this.euB.bc(view);
                }
            } else if (booleanValue2) {
                this.euB.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.euB.aOx(), getPageContext().getPageActivity());
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
        cVar.bZ(w.l.operation);
        cVar.a(strArr, new w(this, sparseArray, z, str));
        cVar.d(getPageContext()).tv();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(w.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(w.h.tag_user_mute_mute_userid);
        }
        this.euB.auC();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.euL;
        userMuteCheckCustomMessage.setTag(this.euL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.euB.a(0, bVar.Bi, bVar.fwq, z);
            if (bVar.Bi) {
                if (bVar.fwo == 1) {
                    finish();
                } else if (bVar.fwo == 2) {
                    this.euz.nM(bVar.mPostId);
                    this.euB.a(this.euz.aOE(), this.euz.aJA(), this.euz.aOU() != null);
                    if (this.euz.aOP()) {
                        this.euz.jc(false);
                        this.euB.aOn();
                        this.euz.Fe();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            }
        }
    }

    public void np(String str) {
        if (!StringUtils.isNull(str) && this.euz != null) {
            String threadID = this.euz.getThreadID();
            String Dl = this.euz.Dl();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dl + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void d(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.euz.isMarked() && postData.getId() != null && postData.getId().equals(this.euz.aOM())) {
                z = true;
            }
            MarkData e = this.euz.e(postData);
            if (e != null) {
                this.euB.awO();
                if (this.dIP != null) {
                    this.dIP.a(e);
                    if (!z) {
                        this.dIP.nJ();
                    } else {
                        this.dIP.nI();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.euz != null) {
            this.euz.o(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dmL != null) {
            this.dmL.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bMM != null) {
            this.bMM.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.euJ = true;
        super.onPause();
        if (this.bMM != null) {
            this.bMM.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cQh);
        this.euB.abg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.euJ = false;
        super.onResume();
        if (this.bMM != null) {
            this.bMM.onResume(getPageContext());
        }
        registerListener(this.cQh);
        this.euB.abh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bMM != null) {
            this.bMM.onStop(getPageContext());
        }
        this.dmL.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.euz.cancelLoadData();
        this.euz.destory();
        this.euA.cancelLoadData();
        if (this.bMM != null) {
            this.bMM.onDestory(getPageContext());
        }
        this.euB.awO();
        this.euB.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.elr);
        MessageManager.getInstance().unRegisterListener(this.els);
        MessageManager.getInstance().unRegisterListener(this.elt);
        MessageManager.getInstance().unRegisterListener(this.euL);
        this.elb = null;
        this.elc = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.euB.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bMM;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aOt = this.euB.aOt();
        if (aOt == null || (findViewWithTag = aOt.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean nF(String str) {
        Map<String, String> dA;
        if (!TextUtils.isEmpty(str) && (dA = com.baidu.tbadk.core.util.bb.dA(com.baidu.tbadk.core.util.bb.dB(str))) != null) {
            this.euM = true;
            String str2 = dA.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return nF(com.baidu.adp.lib.util.j.aJ(str2));
            }
            String str3 = dA.get(euy);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void V(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (nF(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            com.baidu.tbadk.core.util.bb.vQ().c(getPageContext(), new String[]{str});
            this.euM = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void U(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.euM = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void W(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void X(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void f(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.euB != null) {
            return this.euB.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Is() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Iu() {
        if (this.aNb == null) {
            this.aNb = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aNb;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Iv() {
        if (this.aNf == null) {
            this.aNf = new com.baidu.adp.lib.e.b<>(new x(this), 20, 0);
        }
        return this.aNf;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> It() {
        if (this.aNa == null) {
            this.aNa = new com.baidu.adp.lib.e.b<>(new y(this), 8, 0);
        }
        return this.aNa;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Iw() {
        if (this.aNd == null) {
            this.aNd = new com.baidu.adp.lib.e.b<>(new z(this), 8, 0);
        }
        return this.aNd;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> Ix() {
        if (this.aNe == null) {
            this.aNe = new com.baidu.adp.lib.e.b<>(new aa(this), 15, 0);
        }
        return this.aNe;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Iy() {
        if (this.aNc == null) {
            this.aNc = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 8);
        }
        return this.aNc;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lj() {
        if (this.euB.aOp() && com.baidu.adp.lib.util.k.hv()) {
            this.euz.Fe();
        } else {
            this.euB.aOs();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.euL);
        userMuteAddAndDelCustomMessage.setTag(this.euL);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
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
        if (pageStayDurationItem != null && this.euz != null) {
            if (this.euz.aOE() != null && this.euz.aOE().aJU() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.euz.aOE().aJU().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.euz.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aOg() {
        return this.euJ;
    }

    public boolean aOh() {
        if (this.euz != null) {
            return this.euz.aOh();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.euB.auC();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elb.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cx(this.elb.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cx(str);
        }
        aVar.a(w.l.confirm, new ac(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new ae(this));
        aVar.b(this.elb).ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elb.getPageActivity());
        aVar.cx(str);
        aVar.b(w.l.know, new af(this));
        aVar.b(this.elb).ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKN() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cx(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new ag(this));
        aVar.b(w.l.cancel, new ah(this));
        aVar.b(this.elb).ts();
    }

    public String getThreadId() {
        if (this.euz != null) {
            return this.euz.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.euz != null) {
            return this.euz.Dl();
        }
        return null;
    }

    public int aJA() {
        if (this.euz != null) {
            return this.euz.aJA();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.euO) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.euO) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
