package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.tbadkCore.ao;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements com.baidu.adp.widget.ListView.x, com.baidu.tbadk.core.voice.j, com.baidu.tbadk.widget.richText.j {
    private com.baidu.tieba.tbadkCore.writeModel.a aJT;
    private View.OnClickListener aPm;
    private View.OnLongClickListener afC;
    private com.baidu.adp.lib.e.b<TextView> aur;
    private com.baidu.adp.lib.e.b<View> aus;
    private com.baidu.adp.lib.e.b<LinearLayout> aut;
    private com.baidu.tbadk.core.dialog.h bKS;
    private com.baidu.tbadk.baseEditMark.a bKw;
    private com.baidu.tbadk.editortool.v bOi;
    private ak bPn;
    private com.baidu.tieba.tbadkCore.h.a bPo;
    private String bPp;
    private s bPq;
    private AbsListView.OnScrollListener bPr;
    private am bPs;
    private com.baidu.adp.base.i bPt;
    private VoiceManager mVoiceManager;
    private static final String bOI = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/135_1";
    private static String bKn = "tbgametype";
    private com.baidu.tbadk.baseEditMark.b bKI = null;
    private com.baidu.tieba.tbadkCore.writeModel.e bKJ = null;
    private r bPu = null;
    private r bPv = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        acU();
        acT();
        initData(bundle);
        initUI();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        acW();
    }

    public void initUI() {
        this.bPq = new s(getPageContext(), this.aPm);
        addContentView(this.bPq.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.bPq.setOnActionListener(this.bOi);
        this.bPq.setOnScrollListener(this.bPr);
        this.bPq.d(this);
        this.bPq.setIsShowImage(false);
        this.bPq.dT(com.baidu.tbadk.core.n.qc().qe());
        this.bPq.setOnLongClickListener(this.afC);
        this.bPq.c(new a(this));
        this.bPq.a(this.bPu);
        this.bPq.b(this.bPv);
        if (this.bPn != null && this.bPn.acP()) {
            this.bPq.adq().setVisibility(8);
        } else {
            this.bPq.adq().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.bPn = new ak(this);
        this.aJT = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aJT.a(this.bKJ);
        this.bPo = new com.baidu.tieba.tbadkCore.h.a(this);
        this.bPo.setLoadDataCallBack(this.bPt);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.bKw = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.bKw != null) {
            this.bKw.a(this.bKI);
        }
        if (bundle != null) {
            this.bPn.initWithBundle(bundle);
        } else {
            this.bPn.initWithIntent(getIntent());
        }
        this.bPn.a(this.bPs);
        if (this.bPn.acP()) {
            this.bPn.BL();
        } else {
            this.bPn.adH();
        }
        ao.b(this.bPn.ZP(), new j(this));
    }

    public void acT() {
        this.bPs = new k(this);
        this.bKI = new l(this);
        this.bKJ = new m(this);
        this.bPu = new n(this);
        this.bPv = new o(this);
        this.bPt = new p(this);
    }

    public void acU() {
        this.aPm = new q(this);
        this.bPr = new b(this);
        this.bOi = new c(this);
        this.bKS = new d(this);
        this.afC = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acV() {
        if (!this.bPn.adC()) {
            if (com.baidu.adp.lib.util.n.isNetOk()) {
                this.bPq.fv(com.baidu.tieba.t.no_data_text);
            } else {
                this.bPq.fv(com.baidu.tieba.t.recommend_pb_no_net_text);
            }
        }
    }

    public void doManager(View view) {
        SparseArray sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            if (!"".equals(sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name)) && !"".equals(sparseArray.get(com.baidu.tieba.q.tag_del_post_id))) {
                this.bPq.P(view);
            } else {
                this.bPq.a(((Integer) sparseArray.get(com.baidu.tieba.q.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.q.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    public void a(AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.FLOOR_IN_FLOOR);
        } else {
            showToast(str);
        }
    }

    public void a(com.baidu.tieba.tbadkCore.h.c cVar) {
        if (cVar != null) {
            this.bPq.a(0, cVar.AA, cVar.ctT, true);
            if (cVar.AA) {
                if (cVar.ctR == 1) {
                    finish();
                } else if (cVar.ctR == 2) {
                    this.bPn.iy(cVar.mPostId);
                    this.bPq.a(this.bPn.adB(), this.bPn.aav());
                }
                an anVar = new an();
                anVar.setData(cVar);
                anVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, anVar));
            }
        }
    }

    public void im(String str) {
        if (!StringUtils.isNull(str) && this.bPn != null) {
            String abo = this.bPn.abo();
            String ZP = this.bPn.ZP();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.t.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + ZP + "&tid=" + abo + "&pid=" + str, true)));
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.j jVar) {
        if (jVar != null) {
            boolean z = false;
            if (this.bPn.isMarked() && jVar.getId() != null && jVar.getId().equals(this.bPn.adJ())) {
                z = true;
            }
            MarkData c = this.bPn.c(jVar);
            if (c != null) {
                this.bPq.acw();
                if (this.bKw != null) {
                    this.bKw.a(c);
                    if (!z) {
                        this.bKw.ps();
                    } else {
                        this.bKw.pr();
                    }
                }
            }
        }
    }

    public void gg(String str) {
        VoiceData.VoiceModel audioData;
        if (this.aJT.JS() == null) {
            this.aJT.c(this.bPn.JS());
        }
        if (this.aJT.JS() != null) {
            if (this.bPq.Ki() != null) {
                this.aJT.JS().setHasLocationData(this.bPq.Ki().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.aJT.JS().setContent(this.bPq.adk());
                audioData = this.bPq.getAudioData();
                this.bPq.Kr();
            } else {
                this.aJT.JS().setContent(this.bPq.adk());
                this.aJT.JS().setRepostId(this.bPq.add());
                audioData = this.bPq.getAudioData();
                this.bPq.Kr();
            }
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aJT.JS().setVoice(audioData.getId());
                    this.aJT.JS().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aJT.JS().setVoice(null);
                    this.aJT.JS().setVoiceDuringTime(-1);
                }
            } else {
                this.aJT.JS().setVoice(null);
                this.aJT.JS().setVoiceDuringTime(-1);
            }
            if (!this.aJT.apJ()) {
                showToast(com.baidu.tieba.t.write_img_limit);
            } else if (this.aJT.apH()) {
                this.bPq.adl();
            }
        }
    }

    public void replyPost(View view) {
        if (this.bPq.ads() == null || this.bPq.adr() == null) {
            this.bPq.aaO();
        }
        if (this.bPq.ads().getIsIntercepted()) {
            this.bPq.ads().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(com.baidu.tieba.q.tag_clip_board, (com.baidu.tieba.tbadkCore.data.j) ((SparseArray) view.getTag()).get(com.baidu.tieba.q.tag_clip_board));
            sparseArray.put(com.baidu.tieba.q.tag_is_subpb, true);
            this.bPq.adr().abE().setTag(sparseArray);
        }
        if (this.bPn.isMarked()) {
            this.bPq.adr().abE().setText(com.baidu.tieba.t.marked);
            this.bPq.adr().abE().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.bPq.adr().abE().setText(com.baidu.tieba.t.mark);
            this.bPq.adr().abE().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray2 = (SparseArray) view.getTag();
            if (((Boolean) sparseArray2.get(com.baidu.tieba.q.tag_should_manage_visible)).booleanValue()) {
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(com.baidu.tieba.q.tag_manage_user_identity, sparseArray2.get(com.baidu.tieba.q.tag_manage_user_identity));
                sparseArray3.put(com.baidu.tieba.q.tag_del_post_is_self, sparseArray2.get(com.baidu.tieba.q.tag_del_post_is_self));
                sparseArray3.put(com.baidu.tieba.q.tag_del_post_id, sparseArray2.get(com.baidu.tieba.q.tag_del_post_id));
                sparseArray3.put(com.baidu.tieba.q.tag_del_post_type, sparseArray2.get(com.baidu.tieba.q.tag_del_post_type));
                sparseArray3.put(com.baidu.tieba.q.tag_forbid_user_name, sparseArray2.get(com.baidu.tieba.q.tag_forbid_user_name));
                sparseArray3.put(com.baidu.tieba.q.tag_forbid_user_post_id, sparseArray2.get(com.baidu.tieba.q.tag_forbid_user_post_id));
                this.bPq.adr().abQ().setTag(sparseArray3);
                if (!"".equals(sparseArray2.get(com.baidu.tieba.q.tag_forbid_user_name)) && !"".equals(sparseArray2.get(com.baidu.tieba.q.tag_del_post_id))) {
                    ay.c(this.bPq.adr().abQ(), com.baidu.tieba.p.icon_pb_set_n);
                } else {
                    ay.c(this.bPq.adr().abQ(), com.baidu.tieba.p.icon_pb_del_n);
                }
                this.bPq.adr().abQ().setVisibility(0);
            } else {
                this.bPq.adr().abQ().setVisibility(8);
            }
            String str = sparseArray2.get(com.baidu.tieba.q.tag_forbid_user_post_id) instanceof String ? (String) sparseArray2.get(com.baidu.tieba.q.tag_forbid_user_post_id) : null;
            if (dQ(sparseArray2.get(com.baidu.tieba.q.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue() : false)) {
                this.bPq.adr().abR().setVisibility(0);
                this.bPq.adr().abR().setTag(str);
            } else {
                this.bPq.adr().abR().setVisibility(8);
            }
        }
        this.bPq.adr().ea(false);
        this.bPq.ads().reLayoutWidth();
        this.bPq.ads().showWindowInLeftCenterOfHost(view, false);
    }

    private boolean dQ(boolean z) {
        return (this.bPn == null || this.bPn.adB() == null || z || this.bPn.aav() != 0 || this.bPn.adB().aaH() == null || this.bPn.adB().aaH().getAuthor() == null || TextUtils.equals(this.bPn.adB().aaH().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.bPn != null) {
            this.bPn.saveToBundle(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    this.bPq.adc();
                    ArrayList<String> U = com.baidu.tieba.tbadkCore.util.i.U(intent);
                    if (U != null) {
                        this.bPq.u(U);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        if (this.bPq.ady() != null) {
            this.bPq.ady().refresh();
        }
    }

    public void acW() {
        if (this.bPn.adI() != null || this.bPn.adL() != null) {
            new Handler().postDelayed(new f(this), 200L);
            return;
        }
        if (this.bPq.ady() != null && StringUtils.isNull(this.bPq.ady().getContent())) {
            this.bPq.ady().setContent(this.bPp);
        }
        if (this.bPn.adK()) {
            new Handler().postDelayed(new g(this), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
        aaN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        acX();
        this.aJT.cancelLoadData();
        this.bPn.cancelLoadData();
        this.bPn.destory();
        this.bPo.cancelLoadData();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        this.bPq.acw();
    }

    public void acX() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.bPp);
        writeData.setThreadId(this.bPn.ZP());
        ao.c(this.bPn.ZP(), writeData);
    }

    public void acY() {
        ao.c(this.bPn.ZP(), (WriteData) null);
    }

    public void aaN() {
        if (this.bPq.Ki() != null) {
            this.bPp = this.bPq.adk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bPq.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View ado = this.bPq.ado();
        if (ado == null || (findViewWithTag = ado.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.i) findViewWithTag;
    }

    public boolean in(String str) {
        Map<String, String> de;
        if (!TextUtils.isEmpty(str) && (de = bi.de(bi.df(str))) != null) {
            String str2 = de.get(ImageViewerConfig.URL);
            if (!TextUtils.isEmpty(str2)) {
                return in(com.baidu.adp.lib.util.m.aW(str2));
            }
            String str3 = de.get(bKn);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (in(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                bi.tO().b(getPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onSongClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onVideoP2PClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void onPhoneClicked(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int getRichTextViewId() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.aur == null) {
            this.aur = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.aur;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aus == null) {
            this.aus = new com.baidu.adp.lib.e.b<>(new h(this), 8, 0);
        }
        return this.aus;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aut == null) {
            this.aut = new com.baidu.adp.lib.e.b<>(new i(this), 15, 0);
        }
        return this.aut;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (this.bPq.adi() && com.baidu.adp.lib.util.n.isNetOk()) {
            this.bPn.BL();
        } else {
            this.bPq.adn();
        }
    }
}
