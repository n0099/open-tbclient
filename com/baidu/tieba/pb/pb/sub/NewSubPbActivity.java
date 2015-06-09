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
    private com.baidu.tieba.tbadkCore.writeModel.a aJU;
    private View.OnClickListener aPn;
    private View.OnLongClickListener afC;
    private com.baidu.adp.lib.e.b<TextView> aur;
    private com.baidu.adp.lib.e.b<View> aus;
    private com.baidu.adp.lib.e.b<LinearLayout> aut;
    private com.baidu.tbadk.core.dialog.h bKT;
    private com.baidu.tbadk.baseEditMark.a bKx;
    private com.baidu.tbadk.editortool.v bOj;
    private ak bPo;
    private com.baidu.tieba.tbadkCore.h.a bPp;
    private String bPq;
    private s bPr;
    private AbsListView.OnScrollListener bPs;
    private am bPt;
    private com.baidu.adp.base.i bPu;
    private VoiceManager mVoiceManager;
    private static final String bOJ = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/135_1";
    private static String bKo = "tbgametype";
    private com.baidu.tbadk.baseEditMark.b bKJ = null;
    private com.baidu.tieba.tbadkCore.writeModel.e bKK = null;
    private r bPv = null;
    private r bPw = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        acV();
        acU();
        initData(bundle);
        initUI();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        acX();
    }

    public void initUI() {
        this.bPr = new s(getPageContext(), this.aPn);
        addContentView(this.bPr.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.bPr.setOnActionListener(this.bOj);
        this.bPr.setOnScrollListener(this.bPs);
        this.bPr.d(this);
        this.bPr.setIsShowImage(false);
        this.bPr.dT(com.baidu.tbadk.core.n.qc().qe());
        this.bPr.setOnLongClickListener(this.afC);
        this.bPr.c(new a(this));
        this.bPr.a(this.bPv);
        this.bPr.b(this.bPw);
        if (this.bPo != null && this.bPo.acQ()) {
            this.bPr.adr().setVisibility(8);
        } else {
            this.bPr.adr().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.bPo = new ak(this);
        this.aJU = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aJU.a(this.bKK);
        this.bPp = new com.baidu.tieba.tbadkCore.h.a(this);
        this.bPp.setLoadDataCallBack(this.bPu);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.bKx = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.bKx != null) {
            this.bKx.a(this.bKJ);
        }
        if (bundle != null) {
            this.bPo.initWithBundle(bundle);
        } else {
            this.bPo.initWithIntent(getIntent());
        }
        this.bPo.a(this.bPt);
        if (this.bPo.acQ()) {
            this.bPo.BM();
        } else {
            this.bPo.adI();
        }
        ao.b(this.bPo.ZQ(), new j(this));
    }

    public void acU() {
        this.bPt = new k(this);
        this.bKJ = new l(this);
        this.bKK = new m(this);
        this.bPv = new n(this);
        this.bPw = new o(this);
        this.bPu = new p(this);
    }

    public void acV() {
        this.aPn = new q(this);
        this.bPs = new b(this);
        this.bOj = new c(this);
        this.bKT = new d(this);
        this.afC = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acW() {
        if (!this.bPo.adD()) {
            if (com.baidu.adp.lib.util.n.isNetOk()) {
                this.bPr.fv(com.baidu.tieba.t.no_data_text);
            } else {
                this.bPr.fv(com.baidu.tieba.t.recommend_pb_no_net_text);
            }
        }
    }

    public void doManager(View view) {
        SparseArray sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            if (!"".equals(sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name)) && !"".equals(sparseArray.get(com.baidu.tieba.q.tag_del_post_id))) {
                this.bPr.P(view);
            } else {
                this.bPr.a(((Integer) sparseArray.get(com.baidu.tieba.q.tag_del_post_type)).intValue(), (String) sparseArray.get(com.baidu.tieba.q.tag_del_post_id), ((Integer) sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue());
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
            this.bPr.a(0, cVar.AA, cVar.ctU, true);
            if (cVar.AA) {
                if (cVar.ctS == 1) {
                    finish();
                } else if (cVar.ctS == 2) {
                    this.bPo.iy(cVar.mPostId);
                    this.bPr.a(this.bPo.adC(), this.bPo.aaw());
                }
                an anVar = new an();
                anVar.setData(cVar);
                anVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, anVar));
            }
        }
    }

    public void im(String str) {
        if (!StringUtils.isNull(str) && this.bPo != null) {
            String abp = this.bPo.abp();
            String ZQ = this.bPo.ZQ();
            sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(com.baidu.tieba.t.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + ZQ + "&tid=" + abp + "&pid=" + str, true)));
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.j jVar) {
        if (jVar != null) {
            boolean z = false;
            if (this.bPo.isMarked() && jVar.getId() != null && jVar.getId().equals(this.bPo.adK())) {
                z = true;
            }
            MarkData c = this.bPo.c(jVar);
            if (c != null) {
                this.bPr.acx();
                if (this.bKx != null) {
                    this.bKx.a(c);
                    if (!z) {
                        this.bKx.ps();
                    } else {
                        this.bKx.pr();
                    }
                }
            }
        }
    }

    public void gg(String str) {
        VoiceData.VoiceModel audioData;
        if (this.aJU.JT() == null) {
            this.aJU.c(this.bPo.JT());
        }
        if (this.aJU.JT() != null) {
            if (this.bPr.Kj() != null) {
                this.aJU.JT().setHasLocationData(this.bPr.Kj().getLocationInfoViewState() == 2);
            }
            if (str == null) {
                this.aJU.JT().setContent(this.bPr.adl());
                audioData = this.bPr.getAudioData();
                this.bPr.Ks();
            } else {
                this.aJU.JT().setContent(this.bPr.adl());
                this.aJU.JT().setRepostId(this.bPr.ade());
                audioData = this.bPr.getAudioData();
                this.bPr.Ks();
            }
            if (audioData != null) {
                if (audioData.getId() != null) {
                    this.aJU.JT().setVoice(audioData.getId());
                    this.aJU.JT().setVoiceDuringTime(audioData.duration);
                } else {
                    this.aJU.JT().setVoice(null);
                    this.aJU.JT().setVoiceDuringTime(-1);
                }
            } else {
                this.aJU.JT().setVoice(null);
                this.aJU.JT().setVoiceDuringTime(-1);
            }
            if (!this.aJU.apK()) {
                showToast(com.baidu.tieba.t.write_img_limit);
            } else if (this.aJU.apI()) {
                this.bPr.adm();
            }
        }
    }

    public void replyPost(View view) {
        if (this.bPr.adt() == null || this.bPr.ads() == null) {
            this.bPr.aaP();
        }
        if (this.bPr.adt().getIsIntercepted()) {
            this.bPr.adt().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(com.baidu.tieba.q.tag_clip_board, (com.baidu.tieba.tbadkCore.data.j) ((SparseArray) view.getTag()).get(com.baidu.tieba.q.tag_clip_board));
            sparseArray.put(com.baidu.tieba.q.tag_is_subpb, true);
            this.bPr.ads().abF().setTag(sparseArray);
        }
        if (this.bPo.isMarked()) {
            this.bPr.ads().abF().setText(com.baidu.tieba.t.marked);
            this.bPr.ads().abF().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.bPr.ads().abF().setText(com.baidu.tieba.t.mark);
            this.bPr.ads().abF().setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
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
                this.bPr.ads().abR().setTag(sparseArray3);
                if (!"".equals(sparseArray2.get(com.baidu.tieba.q.tag_forbid_user_name)) && !"".equals(sparseArray2.get(com.baidu.tieba.q.tag_del_post_id))) {
                    ay.c(this.bPr.ads().abR(), com.baidu.tieba.p.icon_pb_set_n);
                } else {
                    ay.c(this.bPr.ads().abR(), com.baidu.tieba.p.icon_pb_del_n);
                }
                this.bPr.ads().abR().setVisibility(0);
            } else {
                this.bPr.ads().abR().setVisibility(8);
            }
            String str = sparseArray2.get(com.baidu.tieba.q.tag_forbid_user_post_id) instanceof String ? (String) sparseArray2.get(com.baidu.tieba.q.tag_forbid_user_post_id) : null;
            if (dQ(sparseArray2.get(com.baidu.tieba.q.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(com.baidu.tieba.q.tag_del_post_is_self)).booleanValue() : false)) {
                this.bPr.ads().abS().setVisibility(0);
                this.bPr.ads().abS().setTag(str);
            } else {
                this.bPr.ads().abS().setVisibility(8);
            }
        }
        this.bPr.ads().ea(false);
        this.bPr.adt().reLayoutWidth();
        this.bPr.adt().showWindowInLeftCenterOfHost(view, false);
    }

    private boolean dQ(boolean z) {
        return (this.bPo == null || this.bPo.adC() == null || z || this.bPo.aaw() != 0 || this.bPo.adC().aaI() == null || this.bPo.adC().aaI().getAuthor() == null || TextUtils.equals(this.bPo.adC().aaI().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.bPo != null) {
            this.bPo.saveToBundle(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12005:
                    this.bPr.add();
                    ArrayList<String> U = com.baidu.tieba.tbadkCore.util.i.U(intent);
                    if (U != null) {
                        this.bPr.u(U);
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
        if (this.bPr.adz() != null) {
            this.bPr.adz().refresh();
        }
    }

    public void acX() {
        if (this.bPo.adJ() != null || this.bPo.adM() != null) {
            new Handler().postDelayed(new f(this), 200L);
            return;
        }
        if (this.bPr.adz() != null && StringUtils.isNull(this.bPr.adz().getContent())) {
            this.bPr.adz().setContent(this.bPq);
        }
        if (this.bPo.adL()) {
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
        aaO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        acY();
        this.aJU.cancelLoadData();
        this.bPo.cancelLoadData();
        this.bPo.destory();
        this.bPp.cancelLoadData();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        this.bPr.acx();
    }

    public void acY() {
        WriteData writeData = new WriteData(2);
        writeData.setContent(this.bPq);
        writeData.setThreadId(this.bPo.ZQ());
        ao.c(this.bPo.ZQ(), writeData);
    }

    public void acZ() {
        ao.c(this.bPo.ZQ(), (WriteData) null);
    }

    public void aaO() {
        if (this.bPr.Kj() != null) {
            this.bPq = this.bPr.adl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bPr.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.j
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View adp = this.bPr.adp();
        if (adp == null || (findViewWithTag = adp.findViewWithTag(voiceModel)) == null) {
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
            String str3 = de.get(bKo);
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
        if (this.bPr.adj() && com.baidu.adp.lib.util.n.isNetOk()) {
            this.bPo.BM();
        } else {
            this.bPr.ado();
        }
    }
}
