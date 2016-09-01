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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.ax;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private static final String euP = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String evk = "tbgametype";
    private com.baidu.adp.lib.f.b<ImageView> aJm;
    private com.baidu.adp.lib.f.b<TextView> aJn;
    private com.baidu.adp.lib.f.b<View> aJo;
    private com.baidu.adp.lib.f.b<View> aJp;
    private com.baidu.adp.lib.f.b<LinearLayout> aJq;
    private com.baidu.adp.lib.f.b<GifView> aJr;
    private View.OnLongClickListener aoq;
    private VoiceManager bQi;
    private View.OnClickListener bmb;
    private com.baidu.tbadk.baseEditMark.a dKY;
    private com.baidu.tbadk.editortools.d.p dtc;
    private c.b enT;
    private com.baidu.adp.base.h env;
    private com.baidu.tbadk.core.view.h enw;
    private ax evl;
    private com.baidu.tieba.tbadkCore.f.a evm;
    private ag evn;
    private AbsListView.OnScrollListener evo;
    private TbRichTextView.e evp;
    private TbRichTextView.d evq;
    private ax.a evr;
    private com.baidu.adp.base.g evs;
    private BdUniqueId evw;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int enQ = 0;
    private a.InterfaceC0032a enL = null;
    private a evt = null;
    private a evu = null;
    private boolean evv = false;
    private com.baidu.tbadk.editortools.d.c awq = new com.baidu.tieba.pb.pb.sub.a(this);
    private b.d evx = new l(this);
    private CustomMessageListener enF = new w(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener enG = new aa(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener enH = new ab(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean enR = false;
    private CustomMessageListener cUv = new ac(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.c euS = new ad(this);
    CustomMessageListener bPX = new ae(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.env = getPageContext();
        aoq();
        aQj();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        aQk();
        this.enw = new com.baidu.tbadk.core.view.h();
        this.enw.aeI = 1000L;
        registerListener(this.enH);
        registerListener(this.enF);
        registerListener(this.enG);
        this.evw = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.evw;
        userMuteAddAndDelCustomMessage.setTag(this.evw);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.evw;
        userMuteCheckCustomMessage.setTag(this.evw);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.evn = new ag(this, this.bmb);
        addContentView(this.evn.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.evn.setOnScrollListener(this.evo);
        this.evn.d(this);
        this.evn.setOnLinkImageClickListener(this.evp);
        this.evn.setOnImageClickListener(this.evq);
        this.evn.setOnEmotionClickListener(this.euS);
        this.evn.hN(true);
        this.evn.hO(com.baidu.tbadk.core.l.oG().oI());
        this.evn.setOnLongClickListener(this.aoq);
        this.evn.f(new af(this));
        this.evn.a(this.evt);
        this.evn.b(this.evu);
        if (this.evl != null && this.evl.aQl() && !this.evl.aQZ()) {
            this.evn.aQv().setVisibility(8);
        } else {
            this.evn.aQv().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.evl = new ax(getPageContext());
        this.evm = new com.baidu.tieba.tbadkCore.f.a(this);
        this.evm.setLoadDataCallBack(this.evs);
        this.bQi = new VoiceManager();
        this.bQi.onCreate(getPageContext());
        this.dKY = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dKY != null) {
            this.dKY.a(this.enL);
        }
        if (bundle != null) {
            this.evl.initWithBundle(bundle);
        } else {
            this.evl.initWithIntent(getIntent());
        }
        this.evl.a(this.evr);
        if (this.evl.aQl()) {
            this.evl.Fa();
        } else {
            this.evl.aQQ();
        }
    }

    public void aQj() {
        this.evr = new b(this);
        this.enL = new c(this);
        this.evt = new d(this);
        this.evu = new e(this);
        this.evs = new f(this);
    }

    public void aoq() {
        registerListener(this.bPX);
        this.bmb = new g(this);
        this.evo = new h(this);
        this.enT = new i(this);
        this.aoq = new j(this);
        this.evp = new k(this);
        this.evq = new m(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g If;
        if (aVar == aVar2) {
            this.enR = true;
        }
        if (aVar != null && aVar.Ia() != null) {
            int size = aVar.Ia().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Ia().get(i6) != null && aVar.Ia().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.Ia().get(i6).If().getWidth();
                    int height = aVar.Ia().get(i6).If().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Ia().get(i6).If().Is()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Ia().get(i6);
                        String c = c(cVar);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && cVar != null && (If = cVar.If()) != null) {
                            String Iu = If.Iu();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Iu;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.enR) {
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
        com.baidu.tbadk.widget.richText.g If = cVar.If();
        if (If != null) {
            if (!StringUtils.isNull(If.Ir())) {
                return If.Ir();
            }
            if (If.getHeight() * If.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (If.getHeight() * If.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (If.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * If.getHeight())));
            } else {
                float width = If.getWidth() / If.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ba.aP(If.It()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a az(String str, int i) {
        if (this.evl == null || this.evl.aQK() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.m aQK = this.evl.aQK();
        com.baidu.tbadk.widget.richText.a a2 = a(aQK.aMh(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(aQK.aMh(), str, i);
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
        com.baidu.tbadk.widget.richText.a aAk = qVar.aAk();
        if (aAk != null) {
            ArrayList<com.baidu.tbadk.widget.richText.c> Ia = aAk.Ia();
            int size = Ia.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Ia.get(i3) != null && Ia.get(i3).getType() == 8) {
                    i2++;
                    if (Ia.get(i3).If().Iu().equals(str)) {
                        int width = Ia.get(i3).If().getWidth();
                        int height = Ia.get(i3).If().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.enQ = i3;
                        return aAk;
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
        long templateId = this.evl.aQK().aMh().bjm() != null ? this.evl.aQK().aMh().bjm().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && bi.vx().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.evl.aQK().aMn().getId(), this.evl.aQK().aMn().getName(), this.evl.aQK().Kw().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        if (!this.evl.aQL()) {
            if (com.baidu.adp.lib.util.k.gD()) {
                if (i == 4) {
                    this.evn.pg(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.evn.go(t.j.no_data_text);
                    return;
                }
            }
            this.evn.go(t.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dtc = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().ap(getActivity());
        this.dtc.a(getPageContext());
        this.dtc.b(this.evl);
        this.dtc.b(this.evx);
        this.dtc.a(this.awq);
        this.dtc.CG().bz(true);
        this.dtc.e(getPageContext());
        if (this.evn != null) {
            this.evn.f(this.dtc);
        }
        if (this.dtc != null && this.evl != null) {
            this.dtc.a(this.evl.getAntiData());
        }
    }

    public void aQk() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dtc.DO();
        } else if (this.evl.aQV()) {
            if (!StringUtils.isNull(this.evl.aQS()) && !StringUtils.isNull(this.evl.aQW())) {
                new Handler().postDelayed(new n(this), 500L);
            } else {
                this.dtc.fJ(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(View view) {
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
                    this.evn.aZ(view);
                }
            } else if (booleanValue2) {
                this.evn.a(((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray.get(t.g.tag_del_post_id), ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.evn.aQw(), getPageContext().getPageActivity());
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
        cVar.cc(t.j.operation);
        cVar.a(strArr, new o(this, sparseArray, z, str));
        cVar.d(getPageContext()).ta();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(t.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
        }
        this.evn.ayk();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.evw;
        userMuteCheckCustomMessage.setTag(this.evw);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(a.b bVar, boolean z) {
        if (bVar != null) {
            this.evn.a(0, bVar.ub, bVar.fuO, z);
            if (bVar.ub) {
                if (bVar.fuM == 1) {
                    finish();
                } else if (bVar.fuM == 2) {
                    this.evl.pk(bVar.mPostId);
                    this.evn.a(this.evl.aQK(), this.evl.aLX(), this.evl.aRa() != null);
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void oO(String str) {
        if (!StringUtils.isNull(str) && this.evl != null) {
            String threadID = this.evl.getThreadID();
            String Dg = this.evl.Dg();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(t.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + Dg + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void d(com.baidu.tieba.tbadkCore.data.q qVar) {
        if (qVar != null) {
            boolean z = false;
            if (this.evl.isMarked() && qVar.getId() != null && qVar.getId().equals(this.evl.aQU())) {
                z = true;
            }
            MarkData e = this.evl.e(qVar);
            if (e != null) {
                this.evn.aAE();
                if (this.dKY != null) {
                    this.dKY.a(e);
                    if (!z) {
                        this.dKY.nx();
                    } else {
                        this.dKY.nw();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hW(boolean z) {
        return (this.evl == null || this.evl.aQK() == null || z || this.evl.aLX() != 0 || this.evl.aQK().Kw() == null || this.evl.aQK().Kw().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.evl.aQK().Kw().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.evl != null) {
            this.evl.n(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dtc != null) {
            this.dtc.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bQi != null) {
            this.bQi.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.evv = true;
        super.onPause();
        if (this.bQi != null) {
            this.bQi.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cUv);
        this.evn.adk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.evv = false;
        super.onResume();
        if (this.bQi != null) {
            this.bQi.onResume(getPageContext());
        }
        registerListener(this.cUv);
        this.evn.ayV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bQi != null) {
            this.bQi.onStop(getPageContext());
        }
        this.dtc.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.evl.cancelLoadData();
        this.evl.destory();
        this.evm.cancelLoadData();
        if (this.bQi != null) {
            this.bQi.onDestory(getPageContext());
        }
        this.evn.aAE();
        this.evn.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.enF);
        MessageManager.getInstance().unRegisterListener(this.enG);
        MessageManager.getInstance().unRegisterListener(this.enH);
        MessageManager.getInstance().unRegisterListener(this.evw);
        this.env = null;
        this.enw = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.evn.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bQi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aQu = this.evn.aQu();
        if (aQu == null || (findViewWithTag = aQu.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean pc(String str) {
        Map<String, String> dF;
        if (!TextUtils.isEmpty(str) && (dF = bi.dF(bi.dG(str))) != null) {
            String str2 = dF.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return pc(com.baidu.adp.lib.util.j.aQ(str2));
            }
            String str3 = dF.get(evk);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (pc(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                bi.vx().c(getPageContext(), new String[]{str});
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
    public int ID() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> IF() {
        if (this.aJn == null) {
            this.aJn = TbRichTextView.j(getPageContext().getPageActivity(), 8);
        }
        return this.aJn;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> IG() {
        if (this.aJr == null) {
            this.aJr = new com.baidu.adp.lib.f.b<>(new p(this), 20, 0);
        }
        return this.aJr;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> IE() {
        if (this.aJm == null) {
            this.aJm = new com.baidu.adp.lib.f.b<>(new q(this), 8, 0);
        }
        return this.aJm;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IH() {
        if (this.aJp == null) {
            this.aJp = new com.baidu.adp.lib.f.b<>(new r(this), 8, 0);
        }
        return this.aJp;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> II() {
        if (this.aJq == null) {
            this.aJq = new com.baidu.adp.lib.f.b<>(new s(this), 15, 0);
        }
        return this.aJq;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IJ() {
        if (this.aJo == null) {
            this.aJo = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 8);
        }
        return this.aJo;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fz(int i) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void kx() {
        if (this.evn.aQq() && com.baidu.adp.lib.util.k.gD()) {
            this.evl.Fa();
        } else {
            this.evn.aQt();
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
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.evw);
        userMuteAddAndDelCustomMessage.setTag(this.evw);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf(String str) {
        String string;
        if (!StringUtils.isNull(str) && bn.al(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tS().getString("bubble_link", ""))) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(t.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
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
        if (pageStayDurationItem != null && this.evl != null) {
            if (this.evl.aQK() != null && this.evl.aQK().aMn() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.evl.aQK().aMn().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.evl.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean QV() {
        return this.evv;
    }

    public boolean aQl() {
        if (this.evl != null) {
            return this.evl.aQl();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.evn.ayk();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.env.getPageActivity());
        if (ba.isEmpty(str)) {
            aVar.cB(this.env.getResources().getString(t.j.block_mute_message_alert, str2));
        } else {
            aVar.cB(str);
        }
        aVar.a(t.j.confirm, new u(this, userMuteAddAndDelCustomMessage));
        aVar.b(t.j.cancel, new v(this));
        aVar.b(this.env).sX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.env.getPageActivity());
        aVar.cB(str);
        aVar.b(t.j.know, new x(this));
        aVar.b(this.env).sX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNj() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cB(getResources().getString(t.j.mute_is_super_member_function));
        aVar.a(t.j.open_now, new y(this));
        aVar.b(t.j.cancel, new z(this));
        aVar.b(this.env).sX();
    }

    public String getThreadId() {
        if (this.evl != null) {
            return this.evl.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.evl != null) {
            return this.evl.Dg();
        }
        return null;
    }

    public int aLX() {
        if (this.evl != null) {
            return this.evl.aLX();
        }
        return 0;
    }
}
