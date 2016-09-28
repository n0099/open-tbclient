package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.ax;
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
    private static final String ewV = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String exq = "tbgametype";
    private com.baidu.adp.lib.f.b<ImageView> aIL;
    private com.baidu.adp.lib.f.b<TextView> aIM;
    private com.baidu.adp.lib.f.b<View> aIN;
    private com.baidu.adp.lib.f.b<View> aIO;
    private com.baidu.adp.lib.f.b<LinearLayout> aIP;
    private com.baidu.adp.lib.f.b<GifView> aIQ;
    private View.OnLongClickListener anY;
    private VoiceManager bQb;
    private View.OnClickListener bmo;
    private com.baidu.tbadk.baseEditMark.a dMU;
    private com.baidu.tbadk.editortools.e.p duz;
    private c.b epS;
    private com.baidu.adp.base.h eps;
    private com.baidu.tbadk.core.view.h ept;
    private BdUniqueId exD;
    private ax exr;
    private com.baidu.tieba.tbadkCore.f.a exs;
    private ag exu;
    private AbsListView.OnScrollListener exv;
    private TbRichTextView.f exw;
    private TbRichTextView.e exx;
    private ax.a exy;
    private com.baidu.adp.base.g exz;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int epP = 0;
    private a.InterfaceC0032a epK = null;
    private a exA = null;
    private a exB = null;
    private boolean exC = false;
    private com.baidu.tbadk.editortools.e.c avT = new com.baidu.tieba.pb.pb.sub.a(this);
    private b.d exE = new l(this);
    private CustomMessageListener epE = new w(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener epF = new aa(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener epG = new ab(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean epQ = false;
    private CustomMessageListener cVP = new ac(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.d ewY = new ad(this);
    CustomMessageListener bPQ = new ae(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eps = getPageContext();
        aoE();
        aQS();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        aQT();
        this.ept = new com.baidu.tbadk.core.view.h();
        this.ept.aeT = 1000L;
        registerListener(this.epG);
        registerListener(this.epE);
        registerListener(this.epF);
        this.exD = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.exD;
        userMuteAddAndDelCustomMessage.setTag(this.exD);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.exD;
        userMuteCheckCustomMessage.setTag(this.exD);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.exu = new ag(this, this.bmo);
        addContentView(this.exu.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.exu.setOnScrollListener(this.exv);
        this.exu.d(this);
        this.exu.setOnLinkImageClickListener(this.exw);
        this.exu.setOnImageClickListener(this.exx);
        this.exu.setOnEmotionClickListener(this.ewY);
        this.exu.hQ(true);
        this.exu.hR(com.baidu.tbadk.core.l.oH().oJ());
        this.exu.setOnLongClickListener(this.anY);
        this.exu.f(new af(this));
        this.exu.a(this.exA);
        this.exu.b(this.exB);
        if (this.exr != null && this.exr.aQU() && !this.exr.aRH()) {
            this.exu.aRd().setVisibility(8);
        } else {
            this.exu.aRd().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.exr = new ax(getPageContext());
        this.exs = new com.baidu.tieba.tbadkCore.f.a(this);
        this.exs.setLoadDataCallBack(this.exz);
        this.bQb = new VoiceManager();
        this.bQb.onCreate(getPageContext());
        this.dMU = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dMU != null) {
            this.dMU.a(this.epK);
        }
        if (bundle != null) {
            this.exr.initWithBundle(bundle);
        } else {
            this.exr.initWithIntent(getIntent());
        }
        this.exr.a(this.exy);
        if (this.exr.aQU()) {
            this.exr.Fa();
        } else {
            this.exr.aRy();
        }
    }

    public void aQS() {
        this.exy = new b(this);
        this.epK = new c(this);
        this.exA = new d(this);
        this.exB = new e(this);
        this.exz = new f(this);
    }

    public void aoE() {
        registerListener(this.bPQ);
        this.bmo = new g(this);
        this.exv = new h(this);
        this.epS = new i(this);
        this.anY = new j(this);
        this.exw = new k(this);
        this.exx = new m(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g Ie;
        if (aVar == aVar2) {
            this.epQ = true;
        }
        if (aVar != null && aVar.HZ() != null) {
            int size = aVar.HZ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.HZ().get(i6) != null && aVar.HZ().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.HZ().get(i6).Ie().getWidth();
                    int height = aVar.HZ().get(i6).Ie().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.HZ().get(i6).Ie().Ir()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.HZ().get(i6);
                        String c = c(cVar);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && cVar != null && (Ie = cVar.Ie()) != null) {
                            String It = Ie.It();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = It;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.epQ) {
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
        com.baidu.tbadk.widget.richText.g Ie = cVar.Ie();
        if (Ie != null) {
            if (!StringUtils.isNull(Ie.Iq())) {
                return Ie.Iq();
            }
            if (Ie.getHeight() * Ie.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ie.getHeight() * Ie.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ie.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ie.getHeight())));
            } else {
                float width = Ie.getWidth() / Ie.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(az.aP(Ie.Is()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a ay(String str, int i) {
        if (this.exr == null || this.exr.aRs() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.n aRs = this.exr.aRs();
        com.baidu.tbadk.widget.richText.a a2 = a(aRs.aMN(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(aRs.aMN(), str, i);
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
        com.baidu.tbadk.widget.richText.a aAI = qVar.aAI();
        if (aAI != null) {
            ArrayList<com.baidu.tbadk.widget.richText.c> HZ = aAI.HZ();
            int size = HZ.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (HZ.get(i3) != null && HZ.get(i3).getType() == 8) {
                    i2++;
                    if (HZ.get(i3).Ie().It().equals(str)) {
                        int width = HZ.get(i3).Ie().getWidth();
                        int height = HZ.get(i3).Ie().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.epP = i3;
                        return aAI;
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
        long templateId = this.exr.aRs().aMN().bjY() != null ? this.exr.aRs().aMN().bjY().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && bh.vL().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.exr.aRs().aMT().getId(), this.exr.aRs().aMT().getName(), this.exr.aRs().Jv().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        if (!this.exr.aRt()) {
            if (com.baidu.adp.lib.util.k.gD()) {
                if (i == 4) {
                    this.exu.pw(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.exu.gs(r.j.no_data_text);
                    return;
                }
            }
            this.exu.gs(r.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.duz = (com.baidu.tbadk.editortools.e.p) new com.baidu.tbadk.editortools.e.t().an(getActivity());
        this.duz.a(getPageContext());
        this.duz.b(this.exr);
        this.duz.b(this.exE);
        this.duz.a(this.avT);
        this.duz.CG().by(true);
        this.duz.e(getPageContext());
        if (this.exu != null) {
            this.exu.f(this.duz);
        }
        if (this.duz != null && this.exr != null) {
            this.duz.a(this.exr.getAntiData());
        }
    }

    public void aQT() {
        if (!TbadkCoreApplication.isLogin()) {
            this.duz.DO();
        } else if (this.exr.aRD()) {
            if (!StringUtils.isNull(this.exr.aRA()) && !StringUtils.isNull(this.exr.aRE())) {
                new Handler().postDelayed(new n(this), 500L);
            } else {
                this.duz.fN(null);
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
                    this.exu.aY(view);
                }
            } else if (booleanValue2) {
                this.exu.a(((Integer) sparseArray.get(r.g.tag_del_post_type)).intValue(), (String) sparseArray.get(r.g.tag_del_post_id), ((Integer) sparseArray.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(r.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.exu.aRe(), getPageContext().getPageActivity());
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
        cVar.cc(r.j.operation);
        cVar.a(strArr, new o(this, sparseArray, z, str));
        cVar.d(getPageContext()).tp();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(r.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(r.g.tag_user_mute_mute_userid);
        }
        this.exu.ayI();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.exD;
        userMuteCheckCustomMessage.setTag(this.exD);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(a.b bVar, boolean z) {
        if (bVar != null) {
            this.exu.a(0, bVar.ub, bVar.fxv, z);
            if (bVar.ub) {
                if (bVar.fxt == 1) {
                    finish();
                } else if (bVar.fxt == 2) {
                    this.exr.pA(bVar.mPostId);
                    this.exu.a(this.exr.aRs(), this.exr.aMz(), this.exr.aRI() != null);
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void pd(String str) {
        if (!StringUtils.isNull(str) && this.exr != null) {
            String threadID = this.exr.getThreadID();
            String Dg = this.exr.Dg();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(r.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dg + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void d(com.baidu.tieba.tbadkCore.data.q qVar) {
        if (qVar != null) {
            boolean z = false;
            if (this.exr.isMarked() && qVar.getId() != null && qVar.getId().equals(this.exr.aRC())) {
                z = true;
            }
            MarkData e = this.exr.e(qVar);
            if (e != null) {
                this.exu.aBc();
                if (this.dMU != null) {
                    this.dMU.a(e);
                    if (!z) {
                        this.dMU.nx();
                    } else {
                        this.dMU.nw();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hZ(boolean z) {
        return (this.exr == null || this.exr.aRs() == null || z || this.exr.aMz() != 0 || this.exr.aRs().Jv() == null || this.exr.aRs().Jv().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.exr.aRs().Jv().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.exr != null) {
            this.exr.n(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.duz != null) {
            this.duz.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bQb != null) {
            this.bQb.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.exC = true;
        super.onPause();
        if (this.bQb != null) {
            this.bQb.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cVP);
        this.exu.ady();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.exC = false;
        super.onResume();
        if (this.bQb != null) {
            this.bQb.onResume(getPageContext());
        }
        registerListener(this.cVP);
        this.exu.azt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bQb != null) {
            this.bQb.onStop(getPageContext());
        }
        this.duz.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.exr.cancelLoadData();
        this.exr.destory();
        this.exs.cancelLoadData();
        if (this.bQb != null) {
            this.bQb.onDestory(getPageContext());
        }
        this.exu.aBc();
        this.exu.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.epE);
        MessageManager.getInstance().unRegisterListener(this.epF);
        MessageManager.getInstance().unRegisterListener(this.epG);
        MessageManager.getInstance().unRegisterListener(this.exD);
        this.eps = null;
        this.ept = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.exu.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bQb;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aRc = this.exu.aRc();
        if (aRc == null || (findViewWithTag = aRc.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean ps(String str) {
        Map<String, String> dI;
        if (!TextUtils.isEmpty(str) && (dI = bh.dI(bh.dJ(str))) != null) {
            String str2 = dI.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ps(com.baidu.adp.lib.util.j.aQ(str2));
            }
            String str3 = dI.get(exq);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ps(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                bh.vL().c(getPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
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
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int IC() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> IE() {
        if (this.aIM == null) {
            this.aIM = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aIM;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> IF() {
        if (this.aIQ == null) {
            this.aIQ = new com.baidu.adp.lib.f.b<>(new p(this), 20, 0);
        }
        return this.aIQ;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> ID() {
        if (this.aIL == null) {
            this.aIL = new com.baidu.adp.lib.f.b<>(new q(this), 8, 0);
        }
        return this.aIL;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IG() {
        if (this.aIO == null) {
            this.aIO = new com.baidu.adp.lib.f.b<>(new r(this), 8, 0);
        }
        return this.aIO;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> IH() {
        if (this.aIP == null) {
            this.aIP = new com.baidu.adp.lib.f.b<>(new s(this), 15, 0);
        }
        return this.aIP;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> II() {
        if (this.aIN == null) {
            this.aIN = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 8);
        }
        return this.aIN;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fy(int i) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (this.exu.aQY() && com.baidu.adp.lib.util.k.gD()) {
            this.exr.Fa();
        } else {
            this.exu.aRb();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.exD);
        userMuteAddAndDelCustomMessage.setTag(this.exD);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pv(String str) {
        String string;
        if (!StringUtils.isNull(str) && bm.ak(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.uh().getString("bubble_link", ""))) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(r.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
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
        return new t(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.exr != null) {
            if (this.exr.aRs() != null && this.exr.aRs().aMT() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.exr.aRs().aMT().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.exr.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean Rn() {
        return this.exC;
    }

    public boolean aQU() {
        if (this.exr != null) {
            return this.exr.aQU();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.exu.ayI();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eps.getPageActivity());
        if (az.isEmpty(str)) {
            aVar.cD(this.eps.getResources().getString(r.j.block_mute_message_alert, str2));
        } else {
            aVar.cD(str);
        }
        aVar.a(r.j.confirm, new u(this, userMuteAddAndDelCustomMessage));
        aVar.b(r.j.cancel, new v(this));
        aVar.b(this.eps).tm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eps.getPageActivity());
        aVar.cD(str);
        aVar.b(r.j.know, new x(this));
        aVar.b(this.eps).tm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNP() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cD(getResources().getString(r.j.mute_is_super_member_function));
        aVar.a(r.j.open_now, new y(this));
        aVar.b(r.j.cancel, new z(this));
        aVar.b(this.eps).tm();
    }

    public String getThreadId() {
        if (this.exr != null) {
            return this.exr.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.exr != null) {
            return this.exr.Dg();
        }
        return null;
    }

    public int aMz() {
        if (this.exr != null) {
            return this.exr.aMz();
        }
        return 0;
    }
}
