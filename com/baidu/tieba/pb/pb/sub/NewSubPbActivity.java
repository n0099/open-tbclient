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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.ap;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.k;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private static final String dpI = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String dqb = "tbgametype";
    private com.baidu.adp.lib.f.b<ImageView> aEI;
    private com.baidu.adp.lib.f.b<TextView> aEJ;
    private com.baidu.adp.lib.f.b<View> aEK;
    private com.baidu.adp.lib.f.b<View> aEL;
    private com.baidu.adp.lib.f.b<LinearLayout> aEM;
    private com.baidu.adp.lib.f.b<GifView> aEN;
    private View.OnLongClickListener ajO;
    private VoiceManager beZ;
    private View.OnClickListener bnn;
    private com.baidu.tbadk.baseEditMark.a cPW;
    private com.baidu.tbadk.editortools.d.p czd;
    private c.b djw;
    private ap dqc;
    private com.baidu.tieba.tbadkCore.f.a dqd;
    private y dqe;
    private AbsListView.OnScrollListener dqf;
    private TbRichTextView.e dqg;
    private TbRichTextView.d dqh;
    private ap.a dqi;
    private com.baidu.adp.base.g dqj;
    private boolean mIsFromCDN = true;
    private int djt = 0;
    private com.baidu.tieba.usermute.k diQ = null;
    private a.InterfaceC0032a djo = null;
    private a dqk = null;
    private a dql = null;
    private UserMuteAddAndDelModel diP = null;
    private k.a djk = new com.baidu.tieba.pb.pb.sub.a(this);
    private com.baidu.tbadk.editortools.d.c arE = new l(this);
    private a.d dqm = new r(this);
    boolean dju = false;
    private CustomMessageListener caR = new s(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.c dpL = new t(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aaQ();
        azQ();
        initData(bundle);
        nq();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        azR();
    }

    public void nq() {
        this.dqe = new y(this, this.bnn);
        addContentView(this.dqe.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.dqe.setOnScrollListener(this.dqf);
        this.dqe.d(this);
        this.dqe.setOnLinkImageClickListener(this.dqg);
        this.dqe.setOnImageClickListener(this.dqh);
        this.dqe.setOnEmotionClickListener(this.dpL);
        this.dqe.gq(true);
        this.dqe.gr(com.baidu.tbadk.core.l.ob().od());
        this.dqe.setOnLongClickListener(this.ajO);
        this.dqe.f(new u(this));
        this.dqe.a(this.dqk);
        this.dqe.b(this.dql);
        if (this.dqc != null && this.dqc.aAv() && !this.dqc.aAD()) {
            this.dqe.aAb().setVisibility(8);
        } else {
            this.dqe.aAb().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.diQ = new com.baidu.tieba.usermute.k(getPageContext(), this.djk);
        this.diP = new UserMuteAddAndDelModel(getPageContext());
        this.dqc = new ap(getPageContext());
        this.dqd = new com.baidu.tieba.tbadkCore.f.a(this);
        this.dqd.setLoadDataCallBack(this.dqj);
        this.beZ = new VoiceManager();
        this.beZ.onCreate(getPageContext());
        this.cPW = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cPW != null) {
            this.cPW.a(this.djo);
        }
        if (bundle != null) {
            this.dqc.initWithBundle(bundle);
        } else {
            this.dqc.initWithIntent(getIntent());
        }
        this.dqc.a(this.dqi);
        if (this.dqc.aAv()) {
            this.dqc.Dy();
        } else {
            this.dqc.aAt();
        }
    }

    public void azQ() {
        this.dqi = new v(this);
        this.djo = new w(this);
        this.dqk = new x(this);
        this.dql = new b(this);
        this.dqj = new c(this);
    }

    public void aaQ() {
        this.bnn = new d(this);
        this.dqf = new e(this);
        this.djw = new f(this);
        this.ajO = new g(this);
        this.dqg = new h(this);
        this.dqh = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g GH;
        if (aVar == aVar2) {
            this.dju = true;
        }
        if (aVar != null && aVar.GC() != null) {
            int size = aVar.GC().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.GC().get(i6) != null && aVar.GC().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.GC().get(i6).GH().getWidth();
                    int height = aVar.GC().get(i6).GH().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.GC().get(i6).GH().GT()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.GC().get(i6);
                        String c = c(cVar);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && cVar != null && (GH = cVar.GH()) != null) {
                            String GU = GH.GU();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = GU;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.dju) {
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
        com.baidu.tbadk.widget.richText.g GH = cVar.GH();
        if (GH != null) {
            if (!StringUtils.isNull(GH.GS())) {
                return GH.GS();
            }
            if (GH.getHeight() * GH.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (GH.getHeight() * GH.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (GH.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * GH.getHeight())));
            } else {
                float width = GH.getWidth() / GH.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ay.aN(GH.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a ar(String str, int i) {
        if (this.dqc == null || this.dqc.aAn() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.h aAn = this.dqc.aAn();
        com.baidu.tbadk.widget.richText.a a2 = a(aAn.avO(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(aAn.avO(), str, i);
            if (a3 != null) {
            }
            return a3;
        }
        return a2;
    }

    private com.baidu.tbadk.widget.richText.a a(com.baidu.tieba.tbadkCore.data.s sVar, String str, int i) {
        if (sVar == null) {
            return null;
        }
        com.baidu.tbadk.widget.richText.a amw = sVar.amw();
        if (amw != null) {
            ArrayList<com.baidu.tbadk.widget.richText.c> GC = amw.GC();
            int size = GC.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (GC.get(i3) != null && GC.get(i3).getType() == 8) {
                    i2++;
                    if (GC.get(i3).GH().GU().equals(str)) {
                        int width = GC.get(i3).GH().getWidth();
                        int height = GC.get(i3).GH().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.djt = i3;
                        return amw;
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
    public void e(Context context, String str, String str2) {
        long templateId = this.dqc.aAn().avO().aUc() != null ? this.dqc.aAn().avO().aUc().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && bg.us().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.dqc.aAn().avV().getId(), this.dqc.aAn().avV().getName(), this.dqc.aAn().Kl().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        if (!this.dqc.aAo()) {
            if (com.baidu.adp.lib.util.k.fH()) {
                if (i == 4) {
                    this.dqe.mj(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.dqe.hc(t.j.no_data_text);
                    return;
                }
            }
            this.dqe.hc(t.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.czd = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().ag(getActivity());
        this.czd.a(getPageContext());
        this.czd.b(this.dqc);
        this.czd.b(this.dqm);
        this.czd.a(this.arE);
        this.czd.e(getPageContext());
        if (this.dqe != null) {
            this.dqe.e(this.czd);
        }
        if (this.czd != null && this.dqc != null) {
            this.czd.a(this.dqc.getAntiData());
        }
    }

    public void azR() {
        if (!TbadkCoreApplication.isLogin()) {
            this.czd.Cl();
        } else if (this.dqc.aAz()) {
            if (!StringUtils.isNull(this.dqc.aAw()) && !StringUtils.isNull(this.dqc.aAA())) {
                new Handler().postDelayed(new j(this), 500L);
            } else {
                this.czd.fC(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(t.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(t.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(t.g.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.dqe.aR(view);
                }
            } else if (booleanValue2) {
                this.dqe.a(((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray.get(t.g.tag_del_post_id), ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.dqe.aAc(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(t.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(t.j.delete);
            strArr2[1] = z ? getResources().getString(t.j.un_mute) : getResources().getString(t.j.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(t.j.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bP(t.j.operation);
        cVar.a(strArr, new k(this, sparseArray, z, str));
        cVar.d(getPageContext()).rX();
    }

    public void d(SparseArray<Object> sparseArray) {
        String str;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!(sparseArray.get(t.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
        }
        this.dqe.akv();
        this.diQ.a(com.baidu.adp.lib.h.b.c(currentAccount, 0L), com.baidu.adp.lib.h.b.c(str, 0L), sparseArray);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.dqe.a(0, bVar.rg, bVar.evb, true);
            if (bVar.rg) {
                if (bVar.euZ == 1) {
                    finish();
                } else if (bVar.euZ == 2) {
                    this.dqc.mm(bVar.mPostId);
                    this.dqe.a(this.dqc.aAn(), this.dqc.avH(), this.dqc.aAE() != null);
                }
                com.baidu.tieba.pb.f fVar = new com.baidu.tieba.pb.f();
                fVar.setData(bVar);
                fVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, fVar));
            }
        }
    }

    public void lR(String str) {
        if (!StringUtils.isNull(str) && this.dqc != null) {
            String threadID = this.dqc.getThreadID();
            String BB = this.dqc.BB();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(t.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + BB + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void d(com.baidu.tieba.tbadkCore.data.s sVar) {
        if (sVar != null) {
            boolean z = false;
            if (this.dqc.isMarked() && sVar.getId() != null && sVar.getId().equals(this.dqc.aAy())) {
                z = true;
            }
            MarkData e = this.dqc.e(sVar);
            if (e != null) {
                this.dqe.amQ();
                if (this.cPW != null) {
                    this.cPW.a(e);
                    if (!z) {
                        this.cPW.mR();
                    } else {
                        this.cPW.mQ();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gw(boolean z) {
        return (this.dqc == null || this.dqc.aAn() == null || z || this.dqc.avH() != 0 || this.dqc.aAn().Kl() == null || this.dqc.aAn().Kl().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.dqc.aAn().Kl().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.dqc != null) {
            this.dqc.p(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.czd != null) {
            this.czd.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.beZ != null) {
            this.beZ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.beZ != null) {
            this.beZ.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.caR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.beZ != null) {
            this.beZ.onResume(getPageContext());
        }
        registerListener(this.caR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.beZ != null) {
            this.beZ.onStop(getPageContext());
        }
        this.czd.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.diQ.onDestroy();
        this.dqc.cancelLoadData();
        this.dqc.destory();
        this.dqd.cancelLoadData();
        if (this.beZ != null) {
            this.beZ.onDestory(getPageContext());
        }
        this.dqe.amQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dqe.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.beZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aAa = this.dqe.aAa();
        if (aAa == null || (findViewWithTag = aAa.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean mf(String str) {
        Map<String, String> dB;
        if (!TextUtils.isEmpty(str) && (dB = bg.dB(bg.dC(str))) != null) {
            String str2 = dB.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return mf(com.baidu.adp.lib.util.j.aO(str2));
            }
            String str3 = dB.get(dqb);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (mf(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                bg.us().c(getPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void z(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void d(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int Hd() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> Hf() {
        if (this.aEJ == null) {
            this.aEJ = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.aEJ;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> Hg() {
        if (this.aEN == null) {
            this.aEN = new com.baidu.adp.lib.f.b<>(new m(this), 20, 0);
        }
        return this.aEN;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> He() {
        if (this.aEI == null) {
            this.aEI = new com.baidu.adp.lib.f.b<>(new n(this), 8, 0);
        }
        return this.aEI;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hh() {
        if (this.aEL == null) {
            this.aEL = new com.baidu.adp.lib.f.b<>(new o(this), 8, 0);
        }
        return this.aEL;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> Hi() {
        if (this.aEM == null) {
            this.aEM = new com.baidu.adp.lib.f.b<>(new p(this), 15, 0);
        }
        return this.aEM;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hj() {
        if (this.aEK == null) {
            this.aEK = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 8);
        }
        return this.aEK;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> ff(int i) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        if (this.dqe.azW() && com.baidu.adp.lib.util.k.fH()) {
            this.dqc.Dy();
        } else {
            this.dqe.azZ();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(t.g.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(t.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(t.g.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(t.g.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(t.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(t.g.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(t.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(t.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(t.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(t.g.tag_user_mute_msg);
        }
        this.diP.a(z, str, str3, str4, str6, UserMuteAddAndDelModel.From.PB, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(String str) {
        String string;
        if (!StringUtils.isNull(str) && bl.ac(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.sQ().getString("bubble_link", ""))) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.m11getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(t.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void E(Context context, String str) {
        e(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new q(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dqc != null) {
            if (this.dqc.aAn() != null && this.dqc.aAn().avV() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.dqc.aAn().avV().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.dqc.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }
}
