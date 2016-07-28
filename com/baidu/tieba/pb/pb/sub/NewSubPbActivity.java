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
import com.baidu.tieba.pb.pb.sub.aw;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private static final String eiI = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String ejd = "tbgametype";
    private com.baidu.adp.lib.f.b<ImageView> aGa;
    private com.baidu.adp.lib.f.b<TextView> aGb;
    private com.baidu.adp.lib.f.b<View> aGc;
    private com.baidu.adp.lib.f.b<View> aGd;
    private com.baidu.adp.lib.f.b<LinearLayout> aGe;
    private com.baidu.adp.lib.f.b<GifView> aGf;
    private View.OnLongClickListener alj;
    private VoiceManager bEE;
    private View.OnClickListener baF;
    private com.baidu.tbadk.editortools.d.p dhw;
    private com.baidu.tbadk.baseEditMark.a dzj;
    private c.b ebL;
    private com.baidu.adp.base.h ebn;
    private com.baidu.tbadk.core.view.h ebo;
    private aw eje;
    private com.baidu.tieba.tbadkCore.f.a ejf;
    private af ejg;
    private AbsListView.OnScrollListener ejh;
    private TbRichTextView.e eji;
    private TbRichTextView.d ejj;
    private aw.a ejk;
    private com.baidu.adp.base.g ejl;
    private BdUniqueId ejp;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int ebI = 0;
    private a.InterfaceC0032a ebD = null;
    private a ejm = null;
    private a ejn = null;
    private boolean ejo = false;
    private com.baidu.tbadk.editortools.d.c atj = new com.baidu.tieba.pb.pb.sub.a(this);
    private a.d ejq = new l(this);
    private CustomMessageListener ebx = new w(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener eby = new z(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener ebz = new aa(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean ebJ = false;
    private CustomMessageListener cIQ = new ab(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.c eiL = new ac(this);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ebn = getPageContext();
        ajC();
        aLs();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        aLt();
        this.ebo = new com.baidu.tbadk.core.view.h();
        this.ebo.abS = 1000L;
        registerListener(this.ebz);
        registerListener(this.ebx);
        registerListener(this.eby);
        this.ejp = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.ejp;
        userMuteAddAndDelCustomMessage.setTag(this.ejp);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.ejp;
        userMuteCheckCustomMessage.setTag(this.ejp);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.ejg = new af(this, this.baF);
        addContentView(this.ejg.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.ejg.setOnScrollListener(this.ejh);
        this.ejg.d(this);
        this.ejg.setOnLinkImageClickListener(this.eji);
        this.ejg.setOnImageClickListener(this.ejj);
        this.ejg.setOnEmotionClickListener(this.eiL);
        this.ejg.hr(true);
        this.ejg.hs(com.baidu.tbadk.core.l.nL().nN());
        this.ejg.setOnLongClickListener(this.alj);
        this.ejg.f(new ad(this));
        this.ejg.a(this.ejm);
        this.ejg.b(this.ejn);
        if (this.eje != null && this.eje.aLv() && !this.eje.aMh()) {
            this.ejg.aLF().setVisibility(8);
        } else {
            this.ejg.aLF().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.eje = new aw(getPageContext());
        this.ejf = new com.baidu.tieba.tbadkCore.f.a(this);
        this.ejf.setLoadDataCallBack(this.ejl);
        this.bEE = new VoiceManager();
        this.bEE.onCreate(getPageContext());
        this.dzj = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dzj != null) {
            this.dzj.a(this.ebD);
        }
        if (bundle != null) {
            this.eje.initWithBundle(bundle);
        } else {
            this.eje.initWithIntent(getIntent());
        }
        this.eje.a(this.ejk);
        if (this.eje.aLv()) {
            this.eje.DG();
        } else {
            this.eje.aLY();
        }
    }

    public void aLs() {
        this.ejk = new ae(this);
        this.ebD = new b(this);
        this.ejm = new c(this);
        this.ejn = new d(this);
        this.ejl = new e(this);
    }

    public void ajC() {
        this.baF = new f(this);
        this.ejh = new g(this);
        this.ebL = new h(this);
        this.alj = new i(this);
        this.eji = new j(this);
        this.ejj = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g GI;
        if (aVar == aVar2) {
            this.ebJ = true;
        }
        if (aVar != null && aVar.GD() != null) {
            int size = aVar.GD().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.GD().get(i6) != null && aVar.GD().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.GD().get(i6).GI().getWidth();
                    int height = aVar.GD().get(i6).GI().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.GD().get(i6).GI().GU()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.GD().get(i6);
                        String c = c(cVar);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && cVar != null && (GI = cVar.GI()) != null) {
                            String GV = GI.GV();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = GV;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.ebJ) {
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
        com.baidu.tbadk.widget.richText.g GI = cVar.GI();
        if (GI != null) {
            if (!StringUtils.isNull(GI.GT())) {
                return GI.GT();
            }
            if (GI.getHeight() * GI.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (GI.getHeight() * GI.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (GI.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * GI.getHeight())));
            } else {
                float width = GI.getWidth() / GI.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ba.aO(GI.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a az(String str, int i) {
        if (this.eje == null || this.eje.aLS() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.m aLS = this.eje.aLS();
        com.baidu.tbadk.widget.richText.a a2 = a(aLS.aHp(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(aLS.aHp(), str, i);
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
        com.baidu.tbadk.widget.richText.a avx = sVar.avx();
        if (avx != null) {
            ArrayList<com.baidu.tbadk.widget.richText.c> GD = avx.GD();
            int size = GD.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (GD.get(i3) != null && GD.get(i3).getType() == 8) {
                    i2++;
                    if (GD.get(i3).GI().GV().equals(str)) {
                        int width = GD.get(i3).GI().getWidth();
                        int height = GD.get(i3).GI().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.ebI = i3;
                        return avx;
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
        long templateId = this.eje.aLS().aHp().bfL() != null ? this.eje.aLS().aHp().bfL().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && bi.us().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.eje.aLS().aHv().getId(), this.eje.aLS().aHv().getName(), this.eje.aLS().Iw().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, String str) {
        if (!this.eje.aLT()) {
            if (com.baidu.adp.lib.util.k.fH()) {
                if (i == 4) {
                    this.ejg.ox(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.ejg.fM(u.j.no_data_text);
                    return;
                }
            }
            this.ejg.fM(u.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dhw = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().af(getActivity());
        this.dhw.a(getPageContext());
        this.dhw.b(this.eje);
        this.dhw.b(this.ejq);
        this.dhw.a(this.atj);
        this.dhw.Bl().bx(true);
        this.dhw.e(getPageContext());
        if (this.ejg != null) {
            this.ejg.f(this.dhw);
        }
        if (this.dhw != null && this.eje != null) {
            this.dhw.a(this.eje.getAntiData());
        }
    }

    public void aLt() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dhw.Ct();
        } else if (this.eje.aMd()) {
            if (!StringUtils.isNull(this.eje.aMa()) && !StringUtils.isNull(this.eje.aMe())) {
                new Handler().postDelayed(new m(this), 500L);
            } else {
                this.dhw.fG(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(u.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(u.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(u.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(u.g.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.ejg.aZ(view);
                }
            } else if (booleanValue2) {
                this.ejg.a(((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray.get(u.g.tag_del_post_id), ((Integer) sparseArray.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(u.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.ejg.aLG(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(u.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(u.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(u.j.delete);
            strArr2[1] = z ? getResources().getString(u.j.un_mute) : getResources().getString(u.j.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(u.j.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bP(u.j.operation);
        cVar.a(strArr, new n(this, sparseArray, z, str));
        cVar.d(getPageContext()).rV();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(u.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(u.g.tag_user_mute_mute_userid);
        }
        this.ejg.atw();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.ejp;
        userMuteCheckCustomMessage.setTag(this.ejp);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.ejg.a(0, bVar.rJ, bVar.fmU, true);
            if (bVar.rJ) {
                if (bVar.fmS == 1) {
                    finish();
                } else if (bVar.fmS == 2) {
                    this.eje.oA(bVar.mPostId);
                    this.ejg.a(this.eje.aLS(), this.eje.aHf(), this.eje.aMi() != null);
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void oe(String str) {
        if (!StringUtils.isNull(str) && this.eje != null) {
            String threadID = this.eje.getThreadID();
            String BL = this.eje.BL();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(u.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + BL + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void d(com.baidu.tieba.tbadkCore.data.s sVar) {
        if (sVar != null) {
            boolean z = false;
            if (this.eje.isMarked() && sVar.getId() != null && sVar.getId().equals(this.eje.aMc())) {
                z = true;
            }
            MarkData e = this.eje.e(sVar);
            if (e != null) {
                this.ejg.avR();
                if (this.dzj != null) {
                    this.dzj.a(e);
                    if (!z) {
                        this.dzj.mC();
                    } else {
                        this.dzj.mB();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hA(boolean z) {
        return (this.eje == null || this.eje.aLS() == null || z || this.eje.aHf() != 0 || this.eje.aLS().Iw() == null || this.eje.aLS().Iw().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.eje.aLS().Iw().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.eje != null) {
            this.eje.n(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dhw != null) {
            this.dhw.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bEE != null) {
            this.bEE.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.ejo = true;
        super.onPause();
        if (this.bEE != null) {
            this.bEE.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cIQ);
        this.ejg.Yy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ejo = false;
        super.onResume();
        if (this.bEE != null) {
            this.bEE.onResume(getPageContext());
        }
        registerListener(this.cIQ);
        this.ejg.auh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bEE != null) {
            this.bEE.onStop(getPageContext());
        }
        this.dhw.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eje.cancelLoadData();
        this.eje.destory();
        this.ejf.cancelLoadData();
        if (this.bEE != null) {
            this.bEE.onDestory(getPageContext());
        }
        this.ejg.avR();
        this.ejg.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.ebx);
        MessageManager.getInstance().unRegisterListener(this.eby);
        MessageManager.getInstance().unRegisterListener(this.ebz);
        MessageManager.getInstance().unRegisterListener(this.ejp);
        this.ebn = null;
        this.ebo = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ejg.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bEE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aLE = this.ejg.aLE();
        if (aLE == null || (findViewWithTag = aLE.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean ot(String str) {
        Map<String, String> dD;
        if (!TextUtils.isEmpty(str) && (dD = bi.dD(bi.dE(str))) != null) {
            String str2 = dD.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return ot(com.baidu.adp.lib.util.j.aP(str2));
            }
            String str3 = dD.get(ejd);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ot(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                bi.us().c(getPageContext(), new String[]{str});
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
    public int He() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> Hg() {
        if (this.aGb == null) {
            this.aGb = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.aGb;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> Hh() {
        if (this.aGf == null) {
            this.aGf = new com.baidu.adp.lib.f.b<>(new o(this), 20, 0);
        }
        return this.aGf;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> Hf() {
        if (this.aGa == null) {
            this.aGa = new com.baidu.adp.lib.f.b<>(new p(this), 8, 0);
        }
        return this.aGa;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hi() {
        if (this.aGd == null) {
            this.aGd = new com.baidu.adp.lib.f.b<>(new q(this), 8, 0);
        }
        return this.aGd;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> Hj() {
        if (this.aGe == null) {
            this.aGe = new com.baidu.adp.lib.f.b<>(new r(this), 15, 0);
        }
        return this.aGe;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hk() {
        if (this.aGc == null) {
            this.aGc = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 8);
        }
        return this.aGc;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fj(int i) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jC() {
        if (this.ejg.aLA() && com.baidu.adp.lib.util.k.fH()) {
            this.eje.DG();
        } else {
            this.ejg.aLD();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(u.g.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(u.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(u.g.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(u.g.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(u.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(u.g.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(u.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(u.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(u.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(u.g.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.ejp);
        userMuteAddAndDelCustomMessage.setTag(this.ejp);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ow(String str) {
        String string;
        if (!StringUtils.isNull(str) && bn.ab(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.sN().getString("bubble_link", ""))) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(u.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void F(Context context, String str) {
        e(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new s(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.eje != null) {
            if (this.eje.aLS() != null && this.eje.aLS().aHv() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.eje.aLS().aHv().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.eje.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aLu() {
        return this.ejo;
    }

    public boolean aLv() {
        if (this.eje != null) {
            return this.eje.aLv();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.ejg.atw();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ebn.getPageActivity());
        if (ba.isEmpty(str)) {
            aVar.cz(this.ebn.getResources().getString(u.j.block_mute_message_alert, str2));
        } else {
            aVar.cz(str);
        }
        aVar.a(u.j.confirm, new t(this, userMuteAddAndDelCustomMessage));
        aVar.b(u.j.cancel, new u(this));
        aVar.b(this.ebn).rS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ebn.getPageActivity());
        aVar.cz(str);
        aVar.b(u.j.know, new v(this));
        aVar.b(this.ebn).rS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cz(getResources().getString(u.j.mute_is_super_member_function));
        aVar.a(u.j.open_now, new x(this));
        aVar.b(u.j.cancel, new y(this));
        aVar.b(this.ebn).rS();
    }
}
