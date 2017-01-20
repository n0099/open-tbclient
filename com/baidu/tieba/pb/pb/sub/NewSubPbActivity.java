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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.d {
    private static final String eqx = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String erk = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aHC;
    private com.baidu.adp.lib.e.b<TextView> aHD;
    private com.baidu.adp.lib.e.b<View> aHE;
    private com.baidu.adp.lib.e.b<View> aHF;
    private com.baidu.adp.lib.e.b<LinearLayout> aHG;
    private com.baidu.adp.lib.e.b<GifView> aHH;
    private View.OnLongClickListener anA;
    private VoiceManager bFE;
    private View.OnClickListener cpK;
    private com.baidu.tbadk.baseEditMark.a dGi;
    private com.baidu.tbadk.editortools.pb.n dkr;
    private c.b eiM;
    private com.baidu.adp.base.g eik;
    private com.baidu.tbadk.core.view.h eil;
    private SubPbModel erl;
    private ForumManageModel erm;
    private ao ern;
    private AbsListView.OnScrollListener ero;
    private TbRichTextView.f erp;
    private TbRichTextView.e erq;
    private SubPbModel.a err;
    private com.baidu.adp.base.f ers;
    private BdUniqueId erx;
    private b erz;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int eiJ = 0;
    private a.InterfaceC0031a eiE = null;
    private a ert = null;
    private a eru = null;
    private boolean erv = false;
    private boolean erw = false;
    private boolean ery = false;
    private boolean erA = false;
    private com.baidu.tbadk.editortools.pb.b avn = new h(this);
    private NewWriteModel.d erB = new s(this);
    private CustomMessageListener eiy = new ad(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener eiz = new ai(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener eiA = new aj(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean eiK = false;
    private CustomMessageListener cNS = new ak(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.d eqA = new al(this);
    CustomMessageListener bGx = new am(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        r(bundle);
        if (this.erA) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eik = getPageContext();
        this.erw = true;
        amh();
        aON();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.erl.aOQ()) {
            this.erz = new b(this, getListView(), this.ern.Jo());
            this.erz.aOI();
            this.erz.a(new an(this));
            this.ern.e(this.erz);
            this.ern.jc(true);
        }
        this.eil = new com.baidu.tbadk.core.view.h();
        this.eil.adV = 1000L;
        registerListener(this.eiA);
        registerListener(this.eiy);
        registerListener(this.eiz);
        this.erx = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.erx;
        userMuteAddAndDelCustomMessage.setTag(this.erx);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.erx;
        userMuteCheckCustomMessage.setTag(this.erx);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.ern = new ao(this, this.cpK);
        this.ern.a(this.erl);
        addContentView(this.ern.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.ern.setOnScrollListener(this.ero);
        this.ern.a(this);
        this.ern.setOnLinkImageClickListener(this.erp);
        this.ern.setOnImageClickListener(this.erq);
        this.ern.ii(true);
        this.ern.setOnLongClickListener(this.anA);
        this.ern.f(new i(this));
        this.ern.a(this.ert);
        this.ern.b(this.eru);
        if (this.erl != null && this.erl.aOQ() && !this.erl.aPC()) {
            this.ern.aPe().setVisibility(8);
        } else {
            this.ern.aPe().setVisibility(0);
        }
        if (this.erl != null && !this.erl.aOQ()) {
            this.ern.setIsFromPb(false);
        }
    }

    private boolean r(Bundle bundle) {
        if (bundle != null) {
            this.erA = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.erA = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.erA;
    }

    public void initData(Bundle bundle) {
        this.erl = new SubPbModel(getPageContext());
        this.erl.b(new j(this));
        this.erm = new ForumManageModel(this);
        this.erm.setLoadDataCallBack(this.ers);
        this.bFE = new VoiceManager();
        this.bFE.onCreate(getPageContext());
        this.dGi = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dGi != null) {
            this.dGi.a(this.eiE);
        }
        if (bundle != null) {
            this.erl.initWithBundle(bundle);
        } else {
            this.erl.initWithIntent(getIntent());
        }
        this.erl.a(this.err);
        if (this.erl.aOQ()) {
            this.erl.EH();
        } else {
            this.erl.aPs();
        }
    }

    public void aON() {
        this.err = new k(this);
        this.eiE = new l(this);
        this.ert = new m(this);
        this.eru = new n(this);
        this.ers = new o(this);
    }

    public void amh() {
        registerListener(this.bGx);
        this.cpK = new p(this);
        this.ero = new q(this);
        this.eiM = new r(this);
        this.anA = new t(this);
        this.erp = new u(this);
        this.erq = new v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Hv;
        if (tbRichText == tbRichText2) {
            this.eiK = true;
        }
        if (tbRichText != null && tbRichText.Hq() != null) {
            int size = tbRichText.Hq().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Hq().get(i6) != null && tbRichText.Hq().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Hq().get(i6).Hv().getWidth();
                    int height = tbRichText.Hq().get(i6).Hv().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Hq().get(i6).Hv().HH()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Hq().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (Hv = tbRichTextData.Hv()) != null) {
                            String HJ = Hv.HJ();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = HJ;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.eiK) {
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
        TbRichTextImageInfo Hv = tbRichTextData.Hv();
        if (Hv != null) {
            if (!StringUtils.isNull(Hv.HG())) {
                return Hv.HG();
            }
            if (Hv.getHeight() * Hv.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Hv.getHeight() * Hv.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Hv.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Hv.getHeight())));
            } else {
                float width = Hv.getWidth() / Hv.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.at.aO(Hv.HI()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText at(String str, int i) {
        if (this.erl == null || this.erl.aPn() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.j aPn = this.erl.aPn();
        TbRichText a2 = a(aPn.aKw(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aPn.aKw(), str, i);
            if (a3 != null) {
            }
            return a3;
        }
        return a2;
    }

    private TbRichText a(com.baidu.tieba.tbadkCore.data.p pVar, String str, int i) {
        if (pVar == null) {
            return null;
        }
        TbRichText awW = pVar.awW();
        if (awW != null) {
            ArrayList<TbRichTextData> Hq = awW.Hq();
            int size = Hq.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Hq.get(i3) != null && Hq.get(i3).getType() == 8) {
                    i2++;
                    if (Hq.get(i3).Hv().HJ().equals(str)) {
                        int width = Hq.get(i3).Hv().getWidth();
                        int height = Hq.get(i3).Hv().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.eiJ = i3;
                        return awW;
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
    public void g(Context context, String str, String str2) {
        long templateId = this.erl.aPn().aKw().bhY() != null ? this.erl.aPn().aKw().bhY().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.ba.vt().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.erl.aPn().aKC().getId(), this.erl.aPn().aKC().getName(), this.erl.aPn().Ji().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, String str) {
        if (this.erl.aPo()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.k.gB()) {
            if (i == 4) {
                this.ern.oA(String.valueOf(str) + "(4)");
            } else {
                this.ern.fX(r.l.no_data_text);
            }
        } else {
            this.ern.fX(r.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dkr = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().an(getActivity());
        this.dkr.a(getPageContext());
        this.dkr.b(this.erl);
        this.dkr.b(this.erB);
        this.dkr.a(this.avn);
        this.dkr.Cw().bC(true);
        this.dkr.f(getPageContext());
        if (this.ern != null) {
            this.ern.f(this.dkr);
        }
        if (this.dkr != null && this.erl != null) {
            this.dkr.a(this.erl.axd());
            this.dkr.Dv();
        }
    }

    public void aOO() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dkr.Dv();
        } else if (!StringUtils.isNull(this.erl.aPx())) {
            this.ern.oB(this.erl.aPx());
            if (this.ern.aOY() && com.baidu.adp.lib.util.k.gB()) {
                this.ern.WK();
            } else {
                this.ern.aPb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(r.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.h.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(r.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.h.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(r.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.h.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(r.h.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.ern.bd(view);
                }
            } else if (booleanValue2) {
                this.ern.a(((Integer) sparseArray.get(r.h.tag_del_post_type)).intValue(), (String) sparseArray.get(r.h.tag_del_post_id), ((Integer) sparseArray.get(r.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.h.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.ern.aPg(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(r.h.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(r.h.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(r.h.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(r.l.delete);
            strArr2[1] = z ? getResources().getString(r.l.un_mute) : getResources().getString(r.l.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(r.l.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.cd(r.l.operation);
        cVar.a(strArr, new w(this, sparseArray, z, str));
        cVar.d(getPageContext()).sY();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(r.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(r.h.tag_user_mute_mute_userid);
        }
        this.ern.avh();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.erx;
        userMuteCheckCustomMessage.setTag(this.erx);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.ern.a(0, bVar.tT, bVar.frT, z);
            if (bVar.tT) {
                if (bVar.frR == 1) {
                    finish();
                } else if (bVar.frR == 2) {
                    this.erl.oE(bVar.mPostId);
                    this.ern.a(this.erl.aPn(), this.erl.aKj(), this.erl.aPD() != null);
                    if (this.erl.aPy()) {
                        this.erl.jg(false);
                        this.ern.aOW();
                        this.erl.EH();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            }
        }
    }

    public void oi(String str) {
        if (!StringUtils.isNull(str) && this.erl != null) {
            String threadID = this.erl.getThreadID();
            String CS = this.erl.CS();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(r.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + CS + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void d(com.baidu.tieba.tbadkCore.data.p pVar) {
        if (pVar != null) {
            boolean z = false;
            if (this.erl.isMarked() && pVar.getId() != null && pVar.getId().equals(this.erl.aPv())) {
                z = true;
            }
            MarkData e = this.erl.e(pVar);
            if (e != null) {
                this.ern.axs();
                if (this.dGi != null) {
                    this.dGi.a(e);
                    if (!z) {
                        this.dGi.nv();
                    } else {
                        this.dGi.nu();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.erl != null) {
            this.erl.o(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dkr != null) {
            this.dkr.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bFE != null) {
            this.bFE.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.erv = true;
        super.onPause();
        if (this.bFE != null) {
            this.bFE.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cNS);
        this.ern.aaj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.erv = false;
        super.onResume();
        if (this.bFE != null) {
            this.bFE.onResume(getPageContext());
        }
        registerListener(this.cNS);
        this.ern.aak();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bFE != null) {
            this.bFE.onStop(getPageContext());
        }
        this.dkr.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.erl.cancelLoadData();
        this.erl.destory();
        this.erm.cancelLoadData();
        if (this.bFE != null) {
            this.bFE.onDestory(getPageContext());
        }
        this.ern.axs();
        this.ern.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.eiy);
        MessageManager.getInstance().unRegisterListener(this.eiz);
        MessageManager.getInstance().unRegisterListener(this.eiA);
        MessageManager.getInstance().unRegisterListener(this.erx);
        this.eik = null;
        this.eil = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ern.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bFE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aPc = this.ern.aPc();
        if (aPc == null || (findViewWithTag = aPc.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean ox(String str) {
        Map<String, String> dG;
        if (!TextUtils.isEmpty(str) && (dG = com.baidu.tbadk.core.util.ba.dG(com.baidu.tbadk.core.util.ba.dH(str))) != null) {
            this.ery = true;
            String str2 = dG.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ox(com.baidu.adp.lib.util.j.aP(str2));
            }
            String str3 = dG.get(erk);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void B(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ox(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            com.baidu.tbadk.core.util.ba.vt().c(getPageContext(), new String[]{str});
            this.ery = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ery = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void C(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void D(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void E(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void d(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.ern != null) {
            return this.ern.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int HS() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> HU() {
        if (this.aHD == null) {
            this.aHD = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.aHD;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> HV() {
        if (this.aHH == null) {
            this.aHH = new com.baidu.adp.lib.e.b<>(new x(this), 20, 0);
        }
        return this.aHH;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> HT() {
        if (this.aHC == null) {
            this.aHC = new com.baidu.adp.lib.e.b<>(new y(this), 8, 0);
        }
        return this.aHC;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> HW() {
        if (this.aHF == null) {
            this.aHF = new com.baidu.adp.lib.e.b<>(new z(this), 8, 0);
        }
        return this.aHF;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> HX() {
        if (this.aHG == null) {
            this.aHG = new com.baidu.adp.lib.e.b<>(new aa(this), 15, 0);
        }
        return this.aHG;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> HY() {
        if (this.aHE == null) {
            this.aHE = com.baidu.tieba.graffiti.d.m(getPageContext().getPageActivity(), 8);
        }
        return this.aHE;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kp() {
        if (this.ern.aOY() && com.baidu.adp.lib.util.k.gB()) {
            this.erl.EH();
        } else {
            this.ern.aPb();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(r.h.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(r.h.tag_user_mute_mute_username);
        }
        if (sparseArray.get(r.h.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(r.h.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(r.h.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(r.h.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(r.h.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(r.h.tag_user_mute_msg) : str2;
        if (sparseArray.get(r.h.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(r.h.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.erx);
        userMuteAddAndDelCustomMessage.setTag(this.erx);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void F(Context context, String str) {
        g(context, str, "BUTTON");
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
        if (pageStayDurationItem != null && this.erl != null) {
            if (this.erl.aPn() != null && this.erl.aPn().aKC() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.erl.aPn().aKC().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.erl.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aOP() {
        return this.erv;
    }

    public boolean aOQ() {
        if (this.erl != null) {
            return this.erl.aOQ();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.ern.avh();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eik.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.cE(this.eik.getResources().getString(r.l.block_mute_message_alert, str2));
        } else {
            aVar.cE(str);
        }
        aVar.a(r.l.confirm, new ac(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.l.cancel, new ae(this));
        aVar.b(this.eik).sV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eik.getPageActivity());
        aVar.cE(str);
        aVar.b(r.l.know, new af(this));
        aVar.b(this.eik).sV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLs() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cE(getResources().getString(r.l.mute_is_super_member_function));
        aVar.a(r.l.open_now, new ag(this));
        aVar.b(r.l.cancel, new ah(this));
        aVar.b(this.eik).sV();
    }

    public String getThreadId() {
        if (this.erl != null) {
            return this.erl.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.erl != null) {
            return this.erl.CS();
        }
        return null;
    }

    public int aKj() {
        if (this.erl != null) {
            return this.erl.aKj();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.erA) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.erA) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
