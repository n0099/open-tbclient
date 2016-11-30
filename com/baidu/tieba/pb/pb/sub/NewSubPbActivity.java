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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.bc;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private static final String eDi = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String eEa = "tbgametype";
    private com.baidu.adp.lib.f.b<ImageView> aJD;
    private com.baidu.adp.lib.f.b<TextView> aJE;
    private com.baidu.adp.lib.f.b<View> aJF;
    private com.baidu.adp.lib.f.b<View> aJG;
    private com.baidu.adp.lib.f.b<LinearLayout> aJH;
    private com.baidu.adp.lib.f.b<GifView> aJI;
    private View.OnLongClickListener aoS;
    private VoiceManager bRV;
    private View.OnClickListener bpk;
    private com.baidu.tbadk.editortools.e.p dAe;
    private com.baidu.tbadk.baseEditMark.a dSz;
    private bc eEb;
    private com.baidu.tieba.tbadkCore.f.a eEc;
    private ao eEd;
    private AbsListView.OnScrollListener eEe;
    private TbRichTextView.f eEf;
    private TbRichTextView.e eEg;
    private bc.a eEh;
    private com.baidu.adp.base.g eEi;
    private BdUniqueId eEn;
    private b eEp;
    private c.b evD;
    private com.baidu.adp.base.h eve;
    private com.baidu.tbadk.core.view.h evf;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int evA = 0;
    private a.InterfaceC0032a evv = null;
    private a eEj = null;
    private a eEk = null;
    private boolean eEl = false;
    private boolean eEm = false;
    private boolean eEo = false;
    private boolean eEq = false;
    private com.baidu.tbadk.editortools.e.c awM = new h(this);
    private b.d eEr = new s(this);
    private CustomMessageListener evp = new ad(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener evq = new ai(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener evr = new aj(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean evB = false;
    private CustomMessageListener dbA = new ak(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.d eDl = new al(this);
    CustomMessageListener bSN = new am(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        q(bundle);
        if (this.eEq) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.eve = getPageContext();
        this.eEm = true;
        aqy();
        aTb();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eEb.aTd()) {
            this.eEp = new b(this, getListView(), this.eEd.JF());
            this.eEp.aSW();
            this.eEp.a(new an(this));
            this.eEd.e(this.eEp);
            this.eEd.jf(true);
        }
        this.evf = new com.baidu.tbadk.core.view.h();
        this.evf.afr = 1000L;
        registerListener(this.evr);
        registerListener(this.evp);
        registerListener(this.evq);
        this.eEn = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.eEn;
        userMuteAddAndDelCustomMessage.setTag(this.eEn);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.eEn;
        userMuteCheckCustomMessage.setTag(this.eEn);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eEd = new ao(this, this.bpk);
        this.eEd.a(this.eEb);
        addContentView(this.eEd.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eEd.setOnScrollListener(this.eEe);
        this.eEd.d(this);
        this.eEd.setOnLinkImageClickListener(this.eEf);
        this.eEd.setOnImageClickListener(this.eEg);
        this.eEd.ij(true);
        this.eEd.setOnLongClickListener(this.aoS);
        this.eEd.f(new i(this));
        this.eEd.a(this.eEj);
        this.eEd.b(this.eEk);
        if (this.eEb != null && this.eEb.aTd() && !this.eEb.aTP()) {
            this.eEd.aTr().setVisibility(8);
        } else {
            this.eEd.aTr().setVisibility(0);
        }
        if (this.eEb != null && !this.eEb.aTd()) {
            this.eEd.setIsFromPb(false);
        }
    }

    private boolean q(Bundle bundle) {
        if (bundle != null) {
            this.eEq = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eEq = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eEq;
    }

    public void initData(Bundle bundle) {
        this.eEb = new bc(getPageContext());
        this.eEb.b(new j(this));
        this.eEc = new com.baidu.tieba.tbadkCore.f.a(this);
        this.eEc.setLoadDataCallBack(this.eEi);
        this.bRV = new VoiceManager();
        this.bRV.onCreate(getPageContext());
        this.dSz = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dSz != null) {
            this.dSz.a(this.evv);
        }
        if (bundle != null) {
            this.eEb.initWithBundle(bundle);
        } else {
            this.eEb.initWithIntent(getIntent());
        }
        this.eEb.a(this.eEh);
        if (this.eEb.aTd()) {
            this.eEb.Ff();
        } else {
            this.eEb.aTF();
        }
    }

    public void aTb() {
        this.eEh = new k(this);
        this.evv = new l(this);
        this.eEj = new m(this);
        this.eEk = new n(this);
        this.eEi = new o(this);
    }

    public void aqy() {
        registerListener(this.bSN);
        this.bpk = new p(this);
        this.eEe = new q(this);
        this.evD = new r(this);
        this.aoS = new t(this);
        this.eEf = new u(this);
        this.eEg = new v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g Ih;
        if (aVar == aVar2) {
            this.evB = true;
        }
        if (aVar != null && aVar.Ic() != null) {
            int size = aVar.Ic().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Ic().get(i6) != null && aVar.Ic().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.Ic().get(i6).Ih().getWidth();
                    int height = aVar.Ic().get(i6).Ih().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Ic().get(i6).Ih().Iu()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Ic().get(i6);
                        String c = c(cVar);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && cVar != null && (Ih = cVar.Ih()) != null) {
                            String Iw = Ih.Iw();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Iw;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.evB) {
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
    public String c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g Ih = cVar.Ih();
        if (Ih != null) {
            if (!StringUtils.isNull(Ih.It())) {
                return Ih.It();
            }
            if (Ih.getHeight() * Ih.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ih.getHeight() * Ih.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ih.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ih.getHeight())));
            } else {
                float width = Ih.getWidth() / Ih.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.ax.aP(Ih.Iv()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a ay(String str, int i) {
        if (this.eEb == null || this.eEb.aTA() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.n aTA = this.eEb.aTA();
        com.baidu.tbadk.widget.richText.a a2 = a(aTA.aOG(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(aTA.aOG(), str, i);
            if (a3 != null) {
            }
            return a3;
        }
        return a2;
    }

    private com.baidu.tbadk.widget.richText.a a(com.baidu.tieba.tbadkCore.data.q qVar, String str, int i) {
        if (qVar == null) {
            return null;
        }
        com.baidu.tbadk.widget.richText.a aCE = qVar.aCE();
        if (aCE != null) {
            ArrayList<com.baidu.tbadk.widget.richText.c> Ic = aCE.Ic();
            int size = Ic.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Ic.get(i3) != null && Ic.get(i3).getType() == 8) {
                    i2++;
                    if (Ic.get(i3).Ih().Iw().equals(str)) {
                        int width = Ic.get(i3).Ih().getWidth();
                        int height = Ic.get(i3).Ih().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.evA = i3;
                        return aCE;
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
        long templateId = this.eEb.aTA().aOG().bmt() != null ? this.eEb.aTA().aOG().bmt().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && bf.vP().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eEb.aTA().aOM().getId(), this.eEb.aTA().aOM().getName(), this.eEb.aTA().Jz().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        if (this.eEb.aTB()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.k.gD()) {
            if (i == 4) {
                this.eEd.pJ(String.valueOf(str) + "(4)");
            } else {
                this.eEd.gt(r.j.no_data_text);
            }
        } else {
            this.eEd.gt(r.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dAe = (com.baidu.tbadk.editortools.e.p) new com.baidu.tbadk.editortools.e.t().an(getActivity());
        this.dAe.a(getPageContext());
        this.dAe.b(this.eEb);
        this.dAe.b(this.eEr);
        this.dAe.a(this.awM);
        this.dAe.CO().bC(true);
        this.dAe.e(getPageContext());
        if (this.eEd != null) {
            this.eEd.f(this.dAe);
        }
        if (this.dAe != null && this.eEb != null) {
            this.dAe.a(this.eEb.getAntiData());
            this.dAe.DS();
        }
    }

    public void aTc() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dAe.DS();
        } else if (!StringUtils.isNull(this.eEb.aTK())) {
            this.eEd.pK(this.eEb.aTK());
            if (this.eEd.aTl() && com.baidu.adp.lib.util.k.gD()) {
                this.eEd.abd();
            } else {
                this.eEd.aTo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(r.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(r.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(r.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(r.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(r.g.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.eEd.aX(view);
                }
            } else if (booleanValue2) {
                this.eEd.a(((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray.get(r.g.tag_del_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.eEd.aTt(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(r.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(r.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(r.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(r.j.delete);
            strArr2[1] = z ? getResources().getString(r.j.un_mute) : getResources().getString(r.j.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(r.j.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.cd(r.j.operation);
        cVar.a(strArr, new w(this, sparseArray, z, str));
        cVar.d(getPageContext()).tt();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(r.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(r.g.tag_user_mute_mute_userid);
        }
        this.eEd.aAF();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.eEn;
        userMuteCheckCustomMessage.setTag(this.eEn);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(a.b bVar, boolean z) {
        if (bVar != null) {
            this.eEd.a(0, bVar.uc, bVar.fEA, z);
            if (bVar.uc) {
                if (bVar.fEy == 1) {
                    finish();
                } else if (bVar.fEy == 2) {
                    this.eEb.pN(bVar.mPostId);
                    this.eEd.a(this.eEb.aTA(), this.eEb.aOt(), this.eEb.aTQ() != null);
                    if (this.eEb.aTL()) {
                        this.eEb.jj(false);
                        this.eEd.aTj();
                        this.eEb.Ff();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void pq(String str) {
        if (!StringUtils.isNull(str) && this.eEb != null) {
            String threadID = this.eEb.getThreadID();
            String Do = this.eEb.Do();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(r.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Do + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void e(com.baidu.tieba.tbadkCore.data.q qVar) {
        if (qVar != null) {
            boolean z = false;
            if (this.eEb.isMarked() && qVar.getId() != null && qVar.getId().equals(this.eEb.aTI())) {
                z = true;
            }
            MarkData f = this.eEb.f(qVar);
            if (f != null) {
                this.eEd.aCY();
                if (this.dSz != null) {
                    this.dSz.a(f);
                    if (!z) {
                        this.dSz.nB();
                    } else {
                        this.dSz.nA();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eEb != null) {
            this.eEb.n(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dAe != null) {
            this.dAe.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bRV != null) {
            this.bRV.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eEl = true;
        super.onPause();
        if (this.bRV != null) {
            this.bRV.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.dbA);
        this.eEd.aeM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eEl = false;
        super.onResume();
        if (this.bRV != null) {
            this.bRV.onResume(getPageContext());
        }
        registerListener(this.dbA);
        this.eEd.aeN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bRV != null) {
            this.bRV.onStop(getPageContext());
        }
        this.dAe.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eEb.cancelLoadData();
        this.eEb.destory();
        this.eEc.cancelLoadData();
        if (this.bRV != null) {
            this.bRV.onDestory(getPageContext());
        }
        this.eEd.aCY();
        this.eEd.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.evp);
        MessageManager.getInstance().unRegisterListener(this.evq);
        MessageManager.getInstance().unRegisterListener(this.evr);
        MessageManager.getInstance().unRegisterListener(this.eEn);
        this.eve = null;
        this.evf = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eEd.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bRV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aTp = this.eEd.aTp();
        if (aTp == null || (findViewWithTag = aTp.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pF(String str) {
        Map<String, String> dK;
        if (!TextUtils.isEmpty(str) && (dK = bf.dK(bf.dL(str))) != null) {
            this.eEo = true;
            String str2 = dK.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pF(com.baidu.adp.lib.util.j.aQ(str2));
            }
            String str3 = dK.get(eEa);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pF(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            bf.vP().c(getPageContext(), new String[]{str});
            this.eEo = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eEo = true;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void E(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void d(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public ListView getListView() {
        if (this.eEd != null) {
            return this.eEd.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int IF() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> IH() {
        if (this.aJE == null) {
            this.aJE = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aJE;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> II() {
        if (this.aJI == null) {
            this.aJI = new com.baidu.adp.lib.f.b<>(new x(this), 20, 0);
        }
        return this.aJI;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> IG() {
        if (this.aJD == null) {
            this.aJD = new com.baidu.adp.lib.f.b<>(new y(this), 8, 0);
        }
        return this.aJD;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IJ() {
        if (this.aJG == null) {
            this.aJG = new com.baidu.adp.lib.f.b<>(new z(this), 8, 0);
        }
        return this.aJG;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> IK() {
        if (this.aJH == null) {
            this.aJH = new com.baidu.adp.lib.f.b<>(new aa(this), 15, 0);
        }
        return this.aJH;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IL() {
        if (this.aJF == null) {
            this.aJF = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 8);
        }
        return this.aJF;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fB(int i) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (this.eEd.aTl() && com.baidu.adp.lib.util.k.gD()) {
            this.eEb.Ff();
        } else {
            this.eEd.aTo();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(r.g.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(r.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(r.g.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(r.g.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(r.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(r.g.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(r.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(r.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(r.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(r.g.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.eEn);
        userMuteAddAndDelCustomMessage.setTag(this.eEn);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.m
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
        if (pageStayDurationItem != null && this.eEb != null) {
            if (this.eEb.aTA() != null && this.eEb.aTA().aOM() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.eEb.aTA().aOM().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.eEb.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean Sp() {
        return this.eEl;
    }

    public boolean aTd() {
        if (this.eEb != null) {
            return this.eEb.aTd();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eEd.aAF();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eve.getPageActivity());
        if (com.baidu.tbadk.core.util.ax.isEmpty(str)) {
            aVar.cF(this.eve.getResources().getString(r.j.block_mute_message_alert, str2));
        } else {
            aVar.cF(str);
        }
        aVar.a(r.j.confirm, new ac(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.j.cancel, new ae(this));
        aVar.b(this.eve).tq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eve.getPageActivity());
        aVar.cF(str);
        aVar.b(r.j.know, new af(this));
        aVar.b(this.eve).tq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cF(getResources().getString(r.j.mute_is_super_member_function));
        aVar.a(r.j.open_now, new ag(this));
        aVar.b(r.j.cancel, new ah(this));
        aVar.b(this.eve).tq();
    }

    public String getThreadId() {
        if (this.eEb != null) {
            return this.eEb.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eEb != null) {
            return this.eEb.Do();
        }
        return null;
    }

    public int aOt() {
        if (this.eEb != null) {
            return this.eEb.aOt();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eEq) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eEq) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
