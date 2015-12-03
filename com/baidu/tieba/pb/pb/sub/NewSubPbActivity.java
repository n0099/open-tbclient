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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.an;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.l {
    private com.baidu.adp.lib.f.b<LinearLayout> aDA;
    private com.baidu.adp.lib.f.b<ImageView> aDx;
    private com.baidu.adp.lib.f.b<TextView> aDy;
    private com.baidu.adp.lib.f.b<View> aDz;
    private View.OnLongClickListener alK;
    private View.OnClickListener bfL;
    private com.baidu.tbadk.baseEditMark.a cBH;
    private c.b cCj;
    private an cGS;
    private com.baidu.tieba.tbadkCore.f.a cGT;
    private w cGU;
    private AbsListView.OnScrollListener cGV;
    private TbRichTextView.e cGW;
    private TbRichTextView.d cGX;
    private an.a cGY;
    private com.baidu.adp.base.g cGZ;
    private com.baidu.tbadk.editortools.d.p ceY;
    private VoiceManager mVoiceManager;
    private static final String cGm = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String cBB = "tbgametype";
    private boolean mIsFromCDN = true;
    private int cCg = 0;
    private com.baidu.tieba.usermute.i cBK = null;
    private a.InterfaceC0040a cCb = null;
    private a cHa = null;
    private a cHb = null;
    private UserMuteAddAndDelModel cBJ = null;
    private i.a cBZ = new com.baidu.tieba.pb.pb.sub.a(this);
    private com.baidu.tbadk.editortools.d.c asJ = new l(this);
    private a.d cHc = new p(this);
    boolean cCh = false;
    private CustomMessageListener richTextIntentClickListener = new q(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.c cGp = new r(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TJ();
        amj();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        amk();
    }

    public void initUI() {
        this.cGU = new w(this, this.bfL);
        addContentView(this.cGU.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.cGU.setOnScrollListener(this.cGV);
        this.cGU.b((BdListView.e) this);
        this.cGU.setOnLinkImageClickListener(this.cGW);
        this.cGU.setOnImageClickListener(this.cGX);
        this.cGU.setOnEmotionClickListener(this.cGp);
        this.cGU.eT(true);
        this.cGU.eV(com.baidu.tbadk.core.m.rh().rj());
        this.cGU.setOnLongClickListener(this.alK);
        this.cGU.b(new s(this));
        this.cGU.a(this.cHa);
        this.cGU.b(this.cHb);
        if (this.cGS != null && this.cGS.amg() && !this.cGS.amU()) {
            this.cGU.amu().setVisibility(8);
        } else {
            this.cGU.amu().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.cBK = new com.baidu.tieba.usermute.i(getPageContext(), this.cBZ);
        this.cBJ = new UserMuteAddAndDelModel(getPageContext());
        this.cGS = new an(getPageContext());
        this.cGT = new com.baidu.tieba.tbadkCore.f.a(this);
        this.cGT.setLoadDataCallBack(this.cGZ);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.cBH = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cBH != null) {
            this.cBH.a(this.cCb);
        }
        if (bundle != null) {
            this.cGS.initWithBundle(bundle);
        } else {
            this.cGS.initWithIntent(getIntent());
        }
        this.cGS.a(this.cGY);
        if (this.cGS.amg()) {
            this.cGS.DJ();
        } else {
            this.cGS.amM();
        }
    }

    public void amj() {
        this.cGY = new t(this);
        this.cCb = new u(this);
        this.cHa = new v(this);
        this.cHb = new b(this);
        this.cGZ = new c(this);
    }

    public void TJ() {
        this.bfL = new d(this);
        this.cGV = new e(this);
        this.cCj = new f(this);
        this.alK = new g(this);
        this.cGW = new h(this);
        this.cGX = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.f FQ;
        if (aVar == aVar2) {
            this.cCh = true;
        }
        if (aVar != null) {
            int size = aVar.FL().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.FL().get(i6) != null && aVar.FL().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.FL().get(i6).FQ().getWidth();
                    int height = aVar.FL().get(i6).FQ().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.FL().get(i6).FQ().Ga()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.FL().get(i6);
                        String d = d(cVar);
                        arrayList.add(d);
                        if (!TextUtils.isEmpty(d) && cVar != null && (FQ = cVar.FQ()) != null) {
                            String Gb = FQ.Gb();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Gb;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (hashMap != null) {
                                hashMap.put(d, imageUrlData);
                            }
                        }
                        if (!this.cCh) {
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
    public String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.f FQ = cVar.FQ();
        if (FQ != null) {
            if (!StringUtils.isNull(FQ.FZ())) {
                return FQ.FZ();
            }
            if (FQ.getHeight() * FQ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (FQ.getHeight() * FQ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (FQ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * FQ.getHeight())));
            } else {
                float width = FQ.getWidth() / FQ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ax.aT(FQ.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a ac(String str, int i) {
        if (this.cGS == null || this.cGS.amF() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.d amF = this.cGS.amF();
        com.baidu.tbadk.widget.richText.a a2 = a(amF.ajK(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(amF.ajK(), str, i);
            if (a3 != null) {
            }
            return a3;
        }
        return a2;
    }

    private com.baidu.tbadk.widget.richText.a a(com.baidu.tieba.tbadkCore.data.o oVar, String str, int i) {
        if (oVar == null) {
            return null;
        }
        com.baidu.tbadk.widget.richText.a aDe = oVar.aDe();
        ArrayList<com.baidu.tbadk.widget.richText.c> FL = aDe.FL();
        int size = FL.size();
        int i2 = -1;
        int i3 = 0;
        while (i3 < size) {
            if (FL.get(i3) != null && FL.get(i3).getType() == 8) {
                i2++;
                if (FL.get(i3).FQ().Gb().equals(str)) {
                    int width = FL.get(i3).FQ().getWidth();
                    int height = FL.get(i3).FQ().getHeight();
                    if (width < 80 || height < 80 || height * width < 10000) {
                        return null;
                    }
                    this.cCg = i3;
                    return aDe;
                } else if (i2 > i) {
                    break;
                }
            }
            i3++;
            i2 = i2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context, String str, String str2) {
        long aCJ = this.cGS.amF().ajK().aDn() != null ? this.cGS.amF().ajK().aDn().aCJ() : 0L;
        if (!TextUtils.isEmpty(str) && bf.vD().b(getPageContext(), new String[]{str}) && aCJ != 0) {
            com.baidu.tieba.pb.a.a(aCJ, str, "PB", str2, "CLICK", "ad_tpoint", this.cGS.amF().ajR().getId(), this.cGS.amF().ajR().getName(), this.cGS.amF().ajT().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        if (!this.cGS.amG()) {
            if (com.baidu.adp.lib.util.k.jg()) {
                if (i == 4) {
                    this.cGU.hk(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.cGU.fA(n.i.no_data_text);
                    return;
                }
            }
            this.cGU.fA(n.i.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.ceY = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().al(getActivity());
        this.ceY.a(getPageContext());
        this.ceY.b(this.cGS);
        this.ceY.b(this.cHc);
        this.ceY.a(this.asJ);
        this.ceY.e(getPageContext());
        if (this.cGU != null) {
            this.cGU.e(this.ceY);
        }
        if (this.ceY != null && this.cGS != null) {
            this.ceY.a(this.cGS.ajS());
        }
    }

    public void amk() {
        if (!TbadkCoreApplication.isLogin()) {
            this.ceY.CD();
        } else if (this.cGS.amR()) {
            if (!StringUtils.isNull(this.cGS.amO()) && !StringUtils.isNull(this.cGS.amS())) {
                new Handler().postDelayed(new j(this), 500L);
            } else {
                this.ceY.fv(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(n.f.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.f.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(n.f.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.f.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(n.f.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.f.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(n.f.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.cGU.ak(view);
                }
            } else if (booleanValue2) {
                this.cGU.a(((Integer) sparseArray.get(n.f.tag_del_post_type)).intValue(), (String) sparseArray.get(n.f.tag_del_post_id), ((Integer) sparseArray.get(n.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(n.f.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.cGU.amw(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(n.f.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(n.f.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(n.f.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(n.i.delete);
            strArr2[1] = z ? getResources().getString(n.i.un_mute) : getResources().getString(n.i.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(n.i.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bQ(n.i.operation);
        cVar.a(strArr, new k(this, sparseArray, z, str));
        cVar.d(getPageContext()).tz();
    }

    public void d(SparseArray<Object> sparseArray) {
        String str;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!(sparseArray.get(n.f.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(n.f.tag_user_mute_mute_userid);
        }
        this.cGU.acC();
        this.cBK.a(com.baidu.adp.lib.h.b.c(currentAccount, 0L), com.baidu.adp.lib.h.b.c(str, 0L), sparseArray);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.cGU.a(0, bVar.At, bVar.dBx, true);
            if (bVar.At) {
                if (bVar.dBv == 1) {
                    finish();
                } else if (bVar.dBv == 2) {
                    this.cGS.kQ(bVar.mPostId);
                    this.cGU.a(this.cGS.amF(), this.cGS.ajD());
                }
                ap apVar = new ap();
                apVar.setData(bVar);
                apVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, apVar));
            }
        }
    }

    public void kz(String str) {
        if (!StringUtils.isNull(str) && this.cGS != null) {
            String threadID = this.cGS.getThreadID();
            String BU = this.cGS.BU();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(n.i.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + BU + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (oVar != null) {
            boolean z = false;
            if (this.cGS.isMarked() && oVar.getId() != null && oVar.getId().equals(this.cGS.amQ())) {
                z = true;
            }
            MarkData d = this.cGS.d(oVar);
            if (d != null) {
                this.cGU.alO();
                if (this.cBH != null) {
                    this.cBH.a(d);
                    if (!z) {
                        this.cBH.qr();
                    } else {
                        this.cBH.qq();
                    }
                }
            }
        }
    }

    public void replyPost(View view) {
        if (this.cGU.amw() == null || this.cGU.amv() == null) {
            this.cGU.akc();
        }
        if (this.cGU.amw().getIsIntercepted()) {
            this.cGU.amw().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.o oVar = sparseArray.get(n.f.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.o ? (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(n.f.tag_load_sub_data) : null;
            View view2 = sparseArray.get(n.f.tag_load_sub_view) instanceof View ? (View) sparseArray.get(n.f.tag_load_sub_view) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(n.f.tag_load_sub_data, oVar);
            sparseArray2.put(n.f.tag_load_sub_view, view2);
            this.cGU.amv().ali().setTag(sparseArray2);
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.o oVar2 = sparseArray3.get(n.f.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.o ? (com.baidu.tieba.tbadkCore.data.o) sparseArray3.get(n.f.tag_clip_board) : null;
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(n.f.tag_clip_board, oVar2);
            sparseArray4.put(n.f.tag_is_subpb, false);
            this.cGU.amv().akU().setTag(sparseArray4);
            SparseArray sparseArray5 = (SparseArray) view.getTag();
            boolean booleanValue = sparseArray5.get(n.f.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(n.f.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray5.get(n.f.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(n.f.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray5.get(n.f.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(n.f.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray5.get(n.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray5.get(n.f.tag_del_post_is_self)).booleanValue() : false;
            if (sparseArray5.get(n.f.tag_forbid_user_post_id) instanceof String) {
                String str = (String) sparseArray5.get(n.f.tag_forbid_user_post_id);
            }
            if (booleanValue) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(n.f.tag_should_manage_visible, true);
                sparseArray6.put(n.f.tag_manage_user_identity, sparseArray5.get(n.f.tag_manage_user_identity));
                sparseArray6.put(n.f.tag_del_post_is_self, sparseArray5.get(n.f.tag_del_post_is_self));
                sparseArray6.put(n.f.tag_del_post_id, sparseArray5.get(n.f.tag_del_post_id));
                sparseArray6.put(n.f.tag_del_post_type, sparseArray5.get(n.f.tag_del_post_type));
                sparseArray6.put(n.f.tag_forbid_user_name, sparseArray5.get(n.f.tag_forbid_user_name));
                sparseArray6.put(n.f.tag_forbid_user_post_id, sparseArray5.get(n.f.tag_forbid_user_post_id));
                if (booleanValue2) {
                    sparseArray6.put(n.f.tag_user_mute_visible, true);
                    sparseArray6.put(n.f.tag_is_mem, sparseArray5.get(n.f.tag_is_mem));
                    sparseArray6.put(n.f.tag_user_mute_mute_userid, sparseArray5.get(n.f.tag_user_mute_mute_userid));
                    sparseArray6.put(n.f.tag_user_mute_mute_username, sparseArray5.get(n.f.tag_user_mute_mute_username));
                    sparseArray6.put(n.f.tag_user_mute_post_id, sparseArray5.get(n.f.tag_user_mute_post_id));
                    sparseArray6.put(n.f.tag_user_mute_thread_id, sparseArray5.get(n.f.tag_user_mute_thread_id));
                } else {
                    sparseArray6.put(n.f.tag_user_mute_visible, false);
                }
                if (booleanValue3) {
                    sparseArray6.put(n.f.tag_should_delete_visible, true);
                    sparseArray6.put(n.f.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                    sparseArray6.put(n.f.tag_del_post_id, sparseArray5.get(n.f.tag_del_post_id));
                    sparseArray6.put(n.f.tag_del_post_type, sparseArray5.get(n.f.tag_del_post_type));
                } else {
                    sparseArray6.put(n.f.tag_should_delete_visible, false);
                }
                this.cGU.amv().alj().setTag(sparseArray6);
                if (!"".equals(sparseArray5.get(n.f.tag_forbid_user_name)) && !"".equals(sparseArray5.get(n.f.tag_del_post_id))) {
                    as.c(this.cGU.amv().alj(), n.e.icon_pb_set_n);
                } else {
                    as.c(this.cGU.amv().alj(), n.e.icon_pb_del_n);
                }
                this.cGU.amv().alj().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(n.f.tag_should_manage_visible, false);
                sparseArray7.put(n.f.tag_user_mute_visible, false);
                sparseArray7.put(n.f.tag_should_delete_visible, true);
                sparseArray7.put(n.f.tag_manage_user_identity, sparseArray5.get(n.f.tag_manage_user_identity));
                sparseArray7.put(n.f.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray7.put(n.f.tag_del_post_id, sparseArray5.get(n.f.tag_del_post_id));
                sparseArray7.put(n.f.tag_del_post_type, sparseArray5.get(n.f.tag_del_post_type));
                this.cGU.amv().alj().setTag(sparseArray7);
                as.c(this.cGU.amv().alj(), n.e.icon_pb_del_n);
                this.cGU.amv().alj().setVisibility(0);
            } else {
                this.cGU.amv().alj().setVisibility(8);
            }
            SparseArray sparseArray8 = (SparseArray) view.getTag();
            boolean booleanValue5 = sparseArray8.get(n.f.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray8.get(n.f.tag_user_mute_visible)).booleanValue() : false;
            if (!((Boolean) sparseArray8.get(n.f.tag_should_manage_visible)).booleanValue() && booleanValue5) {
                SparseArray sparseArray9 = new SparseArray();
                sparseArray9.put(n.f.tag_user_mute_visible, true);
                sparseArray9.put(n.f.tag_is_mem, sparseArray8.get(n.f.tag_is_mem));
                sparseArray9.put(n.f.tag_user_mute_mute_userid, sparseArray8.get(n.f.tag_user_mute_mute_userid));
                sparseArray9.put(n.f.tag_user_mute_mute_username, sparseArray8.get(n.f.tag_user_mute_mute_username));
                sparseArray9.put(n.f.tag_user_mute_post_id, sparseArray8.get(n.f.tag_user_mute_post_id));
                sparseArray9.put(n.f.tag_user_mute_thread_id, sparseArray8.get(n.f.tag_user_mute_thread_id));
                sparseArray9.put(n.f.tag_del_post_is_self, sparseArray8.get(n.f.tag_del_post_is_self));
                sparseArray9.put(n.f.tag_del_post_type, sparseArray8.get(n.f.tag_del_post_type));
                sparseArray9.put(n.f.tag_del_post_id, sparseArray8.get(n.f.tag_del_post_id));
                sparseArray9.put(n.f.tag_manage_user_identity, sparseArray8.get(n.f.tag_manage_user_identity));
                this.cGU.amv().alk().setTag(sparseArray9);
                this.cGU.amv().alk().setVisibility(0);
                this.cGU.amv().alj().setVisibility(8);
                as.c(this.cGU.amv().alk(), n.e.icon_pb_gag);
            } else {
                boolean booleanValue6 = sparseArray8.get(n.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray8.get(n.f.tag_del_post_is_self)).booleanValue() : false;
                String str2 = sparseArray8.get(n.f.tag_forbid_user_post_id) instanceof String ? (String) sparseArray8.get(n.f.tag_forbid_user_post_id) : null;
                if (eY(booleanValue6) & isLogin()) {
                    this.cGU.amv().alk().setVisibility(0);
                    this.cGU.amv().alk().setTag(str2);
                } else {
                    this.cGU.amv().alk().setVisibility(8);
                }
            }
        }
        if (this.cGS.isMarked()) {
            this.cGU.amv().akU().setText(n.i.marked);
            this.cGU.amv().akU().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.cGU.amv().akU().setText(n.i.mark);
            this.cGU.amv().akU().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.cGU.amv().fi(false);
        this.cGU.amw().reLayoutWidth();
        if (view != null) {
            this.cGU.amw().showWindowInLeftCenterOfHost(view, false);
        }
    }

    private boolean eY(boolean z) {
        return (this.cGS == null || this.cGS.amF() == null || z || this.cGS.ajD() != 0 || this.cGS.amF().ajT() == null || this.cGS.amF().ajT().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.cGS.amF().ajT().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.cGS != null) {
            this.cGS.saveToBundle(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.ceY != null) {
            this.ceY.onActivityResult(i, i2, intent);
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
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        registerListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
        this.ceY.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cBK.onDestroy();
        this.cGS.cancelLoadData();
        this.cGS.destory();
        this.cGT.cancelLoadData();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        this.cGU.alO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cGU.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View amt = this.cGU.amt();
        if (amt == null || (findViewWithTag = amt.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean kA(String str) {
        Map<String, String> dB;
        if (!TextUtils.isEmpty(str) && (dB = bf.dB(bf.dC(str))) != null) {
            String str2 = dB.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return kA(com.baidu.adp.lib.util.j.aU(str2));
            }
            String str3 = dB.get(cBB);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (kA(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                bf.vD().b(getPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onVideoClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onSongClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onVideoP2PClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onPhoneClicked(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public int getRichTextViewId() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<TextView> getTextViewPool() {
        if (this.aDy == null) {
            this.aDy = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aDy;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<ImageView> getImageViewPool() {
        if (this.aDx == null) {
            this.aDx = new com.baidu.adp.lib.f.b<>(new m(this), 8, 0);
        }
        return this.aDx;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<View> getVoiceViewPool() {
        if (this.aDz == null) {
            this.aDz = new com.baidu.adp.lib.f.b<>(new n(this), 8, 0);
        }
        return this.aDz;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aDA == null) {
            this.aDA = new com.baidu.adp.lib.f.b<>(new o(this), 15, 0);
        }
        return this.aDA;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cGU.amp() && com.baidu.adp.lib.util.k.jg()) {
            this.cGS.DJ();
        } else {
            this.cGU.ams();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (sparseArray.get(n.f.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(n.f.tag_user_mute_mute_username);
        }
        if (sparseArray.get(n.f.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(n.f.tag_user_mute_thread_id);
        }
        if (sparseArray.get(n.f.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(n.f.tag_user_mute_post_id);
        }
        this.cBJ.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kN(String str) {
        String string;
        if (!StringUtils.isNull(str) && bj.ah(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tZ().getString("bubble_link", ""))) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(n.i.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onLinkButtonClicked(Context context, String str) {
        g(context, str, "BUTTON");
    }
}
