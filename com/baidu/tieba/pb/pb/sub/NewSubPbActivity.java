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
    private static final String eho = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String eia = "tbgametype";
    private com.baidu.adp.lib.f.b<ImageView> aIV;
    private com.baidu.adp.lib.f.b<TextView> aIW;
    private com.baidu.adp.lib.f.b<View> aIX;
    private com.baidu.adp.lib.f.b<View> aIY;
    private com.baidu.adp.lib.f.b<LinearLayout> aIZ;
    private com.baidu.adp.lib.f.b<GifView> aJa;
    private View.OnLongClickListener aou;
    private VoiceManager byf;
    private View.OnClickListener cjr;
    private com.baidu.tbadk.core.view.h dZA;
    private c.b dZZ;
    private com.baidu.adp.base.h dZz;
    private com.baidu.tbadk.editortools.e.p ddg;
    private com.baidu.tbadk.baseEditMark.a dxb;
    private bc eib;
    private com.baidu.tieba.tbadkCore.f.a eic;
    private ao eid;
    private AbsListView.OnScrollListener eie;
    private TbRichTextView.f eif;
    private TbRichTextView.e eig;
    private bc.a eih;
    private com.baidu.adp.base.g eii;
    private BdUniqueId ein;
    private b eip;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int dZW = 0;
    private a.InterfaceC0032a dZR = null;
    private a eij = null;
    private a eik = null;
    private boolean eil = false;
    private boolean eim = false;
    private boolean eio = false;
    private boolean eiq = false;
    private com.baidu.tbadk.editortools.e.c awj = new h(this);
    private b.d eir = new s(this);
    private CustomMessageListener dZL = new ad(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener dZM = new ai(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener dZN = new aj(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean dZX = false;
    private CustomMessageListener cGK = new ak(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.d ehr = new al(this);
    CustomMessageListener byX = new am(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        q(bundle);
        if (this.eiq) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.dZz = getPageContext();
        this.eim = true;
        ala();
        aMS();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.eib.aMU()) {
            this.eip = new b(this, getListView(), this.eid.Ja());
            this.eip.aMN();
            this.eip.a(new an(this));
            this.eid.e(this.eip);
            this.eid.iQ(true);
        }
        this.dZA = new com.baidu.tbadk.core.view.h();
        this.dZA.aeK = 1000L;
        registerListener(this.dZN);
        registerListener(this.dZL);
        registerListener(this.dZM);
        this.ein = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.ein;
        userMuteAddAndDelCustomMessage.setTag(this.ein);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.ein;
        userMuteCheckCustomMessage.setTag(this.ein);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.eid = new ao(this, this.cjr);
        this.eid.a(this.eib);
        addContentView(this.eid.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.eid.setOnScrollListener(this.eie);
        this.eid.d(this);
        this.eid.setOnLinkImageClickListener(this.eif);
        this.eid.setOnImageClickListener(this.eig);
        this.eid.hX(true);
        this.eid.setOnLongClickListener(this.aou);
        this.eid.f(new i(this));
        this.eid.a(this.eij);
        this.eid.b(this.eik);
        if (this.eib != null && this.eib.aMU() && !this.eib.aNG()) {
            this.eid.aNi().setVisibility(8);
        } else {
            this.eid.aNi().setVisibility(0);
        }
        if (this.eib != null && !this.eib.aMU()) {
            this.eid.setIsFromPb(false);
        }
    }

    private boolean q(Bundle bundle) {
        if (bundle != null) {
            this.eiq = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eiq = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eiq;
    }

    public void initData(Bundle bundle) {
        this.eib = new bc(getPageContext());
        this.eib.b(new j(this));
        this.eic = new com.baidu.tieba.tbadkCore.f.a(this);
        this.eic.setLoadDataCallBack(this.eii);
        this.byf = new VoiceManager();
        this.byf.onCreate(getPageContext());
        this.dxb = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dxb != null) {
            this.dxb.a(this.dZR);
        }
        if (bundle != null) {
            this.eib.initWithBundle(bundle);
        } else {
            this.eib.initWithIntent(getIntent());
        }
        this.eib.a(this.eih);
        if (this.eib.aMU()) {
            this.eib.EN();
        } else {
            this.eib.aNw();
        }
    }

    public void aMS() {
        this.eih = new k(this);
        this.dZR = new l(this);
        this.eij = new m(this);
        this.eik = new n(this);
        this.eii = new o(this);
    }

    public void ala() {
        registerListener(this.byX);
        this.cjr = new p(this);
        this.eie = new q(this);
        this.dZZ = new r(this);
        this.aou = new t(this);
        this.eif = new u(this);
        this.eig = new v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g HD;
        if (aVar == aVar2) {
            this.dZX = true;
        }
        if (aVar != null && aVar.Hy() != null) {
            int size = aVar.Hy().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Hy().get(i6) != null && aVar.Hy().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.Hy().get(i6).HD().getWidth();
                    int height = aVar.Hy().get(i6).HD().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Hy().get(i6).HD().HP()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Hy().get(i6);
                        String c = c(cVar);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && cVar != null && (HD = cVar.HD()) != null) {
                            String HR = HD.HR();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = HR;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.dZX) {
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
        com.baidu.tbadk.widget.richText.g HD = cVar.HD();
        if (HD != null) {
            if (!StringUtils.isNull(HD.HO())) {
                return HD.HO();
            }
            if (HD.getHeight() * HD.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (HD.getHeight() * HD.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (HD.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * HD.getHeight())));
            } else {
                float width = HD.getWidth() / HD.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.av.aP(HD.HQ()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a at(String str, int i) {
        if (this.eib == null || this.eib.aNr() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.j aNr = this.eib.aNr();
        com.baidu.tbadk.widget.richText.a a2 = a(aNr.aIF(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(aNr.aIF(), str, i);
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
        com.baidu.tbadk.widget.richText.a avP = qVar.avP();
        if (avP != null) {
            ArrayList<com.baidu.tbadk.widget.richText.c> Hy = avP.Hy();
            int size = Hy.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Hy.get(i3) != null && Hy.get(i3).getType() == 8) {
                    i2++;
                    if (Hy.get(i3).HD().HR().equals(str)) {
                        int width = Hy.get(i3).HD().getWidth();
                        int height = Hy.get(i3).HD().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.dZW = i3;
                        return avP;
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
        long templateId = this.eib.aNr().aIF().bgi() != null ? this.eib.aNr().aIF().bgi().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bc.vz().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eib.aNr().aIL().getId(), this.eib.aNr().aIL().getName(), this.eib.aNr().IU().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        if (this.eib.aNs()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.k.gD()) {
            if (i == 4) {
                this.eid.ok(String.valueOf(str) + "(4)");
            } else {
                this.eid.m23if(r.j.no_data_text);
            }
        } else {
            this.eid.m23if(r.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.ddg = (com.baidu.tbadk.editortools.e.p) new com.baidu.tbadk.editortools.e.t().al(getActivity());
        this.ddg.a(getPageContext());
        this.ddg.b(this.eib);
        this.ddg.b(this.eir);
        this.ddg.a(this.awj);
        this.ddg.CB().bC(true);
        this.ddg.f(getPageContext());
        if (this.eid != null) {
            this.eid.f(this.ddg);
        }
        if (this.ddg != null && this.eib != null) {
            this.ddg.a(this.eib.avW());
            this.ddg.DA();
        }
    }

    public void aMT() {
        if (!TbadkCoreApplication.isLogin()) {
            this.ddg.DA();
        } else if (!StringUtils.isNull(this.eib.aNB())) {
            this.eid.ol(this.eib.aNB());
            if (this.eid.aNc() && com.baidu.adp.lib.util.k.gD()) {
                this.eid.Vq();
            } else {
                this.eid.aNf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(View view) {
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
                    this.eid.aW(view);
                }
            } else if (booleanValue2) {
                this.eid.a(((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray.get(r.g.tag_del_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.eid.aNk(), getPageContext().getPageActivity());
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
        cVar.ce(r.j.operation);
        cVar.a(strArr, new w(this, sparseArray, z, str));
        cVar.d(getPageContext()).te();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(r.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(r.g.tag_user_mute_mute_userid);
        }
        this.eid.aub();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.ein;
        userMuteCheckCustomMessage.setTag(this.ein);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(a.b bVar, boolean z) {
        if (bVar != null) {
            this.eid.a(0, bVar.uc, bVar.fiH, z);
            if (bVar.uc) {
                if (bVar.fiF == 1) {
                    finish();
                } else if (bVar.fiF == 2) {
                    this.eib.oo(bVar.mPostId);
                    this.eid.a(this.eib.aNr(), this.eib.aIu(), this.eib.aNH() != null);
                    if (this.eib.aNC()) {
                        this.eib.iU(false);
                        this.eid.aNa();
                        this.eib.EN();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            }
        }
    }

    public void nR(String str) {
        if (!StringUtils.isNull(str) && this.eib != null) {
            String threadID = this.eib.getThreadID();
            String CX = this.eib.CX();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(r.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + CX + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void e(com.baidu.tieba.tbadkCore.data.q qVar) {
        if (qVar != null) {
            boolean z = false;
            if (this.eib.isMarked() && qVar.getId() != null && qVar.getId().equals(this.eib.aNz())) {
                z = true;
            }
            MarkData f = this.eib.f(qVar);
            if (f != null) {
                this.eid.awl();
                if (this.dxb != null) {
                    this.dxb.a(f);
                    if (!z) {
                        this.dxb.nB();
                    } else {
                        this.dxb.nA();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eib != null) {
            this.eib.n(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.ddg != null) {
            this.ddg.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.byf != null) {
            this.byf.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.eil = true;
        super.onPause();
        if (this.byf != null) {
            this.byf.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cGK);
        this.eid.Zh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.eil = false;
        super.onResume();
        if (this.byf != null) {
            this.byf.onResume(getPageContext());
        }
        registerListener(this.cGK);
        this.eid.Zi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.byf != null) {
            this.byf.onStop(getPageContext());
        }
        this.ddg.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eib.cancelLoadData();
        this.eib.destory();
        this.eic.cancelLoadData();
        if (this.byf != null) {
            this.byf.onDestory(getPageContext());
        }
        this.eid.awl();
        this.eid.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.dZL);
        MessageManager.getInstance().unRegisterListener(this.dZM);
        MessageManager.getInstance().unRegisterListener(this.dZN);
        MessageManager.getInstance().unRegisterListener(this.ein);
        this.dZz = null;
        this.dZA = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eid.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.byf;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aNg = this.eid.aNg();
        if (aNg == null || (findViewWithTag = aNg.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean oh(String str) {
        Map<String, String> dI;
        if (!TextUtils.isEmpty(str) && (dI = com.baidu.tbadk.core.util.bc.dI(com.baidu.tbadk.core.util.bc.dJ(str))) != null) {
            this.eio = true;
            String str2 = dI.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return oh(com.baidu.adp.lib.util.j.aQ(str2));
            }
            String str3 = dI.get(eia);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (oh(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            com.baidu.tbadk.core.util.bc.vz().c(getPageContext(), new String[]{str});
            this.eio = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eio = true;
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
        if (this.eid != null) {
            return this.eid.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int Ia() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> Ic() {
        if (this.aIW == null) {
            this.aIW = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aIW;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> Id() {
        if (this.aJa == null) {
            this.aJa = new com.baidu.adp.lib.f.b<>(new x(this), 20, 0);
        }
        return this.aJa;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> Ib() {
        if (this.aIV == null) {
            this.aIV = new com.baidu.adp.lib.f.b<>(new y(this), 8, 0);
        }
        return this.aIV;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Ie() {
        if (this.aIY == null) {
            this.aIY = new com.baidu.adp.lib.f.b<>(new z(this), 8, 0);
        }
        return this.aIY;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> If() {
        if (this.aIZ == null) {
            this.aIZ = new com.baidu.adp.lib.f.b<>(new aa(this), 15, 0);
        }
        return this.aIZ;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Ig() {
        if (this.aIX == null) {
            this.aIX = com.baidu.tieba.graffiti.e.l(getPageContext().getPageActivity(), 8);
        }
        return this.aIX;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (this.eid.aNc() && com.baidu.adp.lib.util.k.gD()) {
            this.eib.EN();
        } else {
            this.eid.aNf();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.ein);
        userMuteAddAndDelCustomMessage.setTag(this.ein);
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
        if (pageStayDurationItem != null && this.eib != null) {
            if (this.eib.aNr() != null && this.eib.aNr().aIL() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.eib.aNr().aIL().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.eib.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean RO() {
        return this.eil;
    }

    public boolean aMU() {
        if (this.eib != null) {
            return this.eib.aMU();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.eid.aub();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dZz.getPageActivity());
        if (com.baidu.tbadk.core.util.av.isEmpty(str)) {
            aVar.cG(this.dZz.getResources().getString(r.j.block_mute_message_alert, str2));
        } else {
            aVar.cG(str);
        }
        aVar.a(r.j.confirm, new ac(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.j.cancel, new ae(this));
        aVar.b(this.dZz).tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fL(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dZz.getPageActivity());
        aVar.cG(str);
        aVar.b(r.j.know, new af(this));
        aVar.b(this.dZz).tb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cG(getResources().getString(r.j.mute_is_super_member_function));
        aVar.a(r.j.open_now, new ag(this));
        aVar.b(r.j.cancel, new ah(this));
        aVar.b(this.dZz).tb();
    }

    public String getThreadId() {
        if (this.eib != null) {
            return this.eib.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.eib != null) {
            return this.eib.CX();
        }
        return null;
    }

    public int aIu() {
        if (this.eib != null) {
            return this.eib.aIu();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eiq) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eiq) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
