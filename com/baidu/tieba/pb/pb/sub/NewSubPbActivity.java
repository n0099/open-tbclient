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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.am;
import com.baidu.tieba.tbadkCore.h.a;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.l {
    private com.baidu.adp.lib.e.b<ImageView> aAL;
    private com.baidu.adp.lib.e.b<TextView> aAM;
    private com.baidu.adp.lib.e.b<View> aAN;
    private com.baidu.adp.lib.e.b<LinearLayout> aAO;
    private View.OnClickListener aZI;
    private View.OnLongClickListener ajZ;
    private com.baidu.tbadk.editortools.c.p cbv;
    private c.b cjM;
    private com.baidu.tbadk.baseEditMark.a cjk;
    private am cnH;
    private com.baidu.tieba.tbadkCore.h.a cnI;
    private v cnJ;
    private AbsListView.OnScrollListener cnK;
    private TbRichTextView.e cnL;
    private TbRichTextView.d cnM;
    private am.a cnN;
    private com.baidu.adp.base.g cnO;
    private VoiceManager mVoiceManager;
    private static final String cnb = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String cje = "tbgametype";
    private boolean mIsFromCDN = true;
    private int cjJ = 0;
    private com.baidu.tieba.usermute.i cjn = null;
    private a.InterfaceC0039a cjE = null;
    private a cnP = null;
    private a cnQ = null;
    private UserMuteAddAndDelModel<NewSubPbActivity> cjm = null;
    private i.a cjC = new com.baidu.tieba.pb.pb.sub.a(this);
    private com.baidu.tbadk.editortools.c.c aqG = new l(this);
    private a.d cnR = new o(this);
    boolean cjK = false;
    private CustomMessageListener richTextIntentClickListener = new p(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Rf();
        ahG();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        ahH();
    }

    public void initUI() {
        this.cnJ = new v(this, this.aZI);
        addContentView(this.cnJ.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.cnJ.setOnScrollListener(this.cnK);
        this.cnJ.d(this);
        this.cnJ.setOnLinkImageClickListener(this.cnL);
        this.cnJ.setOnImageClickListener(this.cnM);
        this.cnJ.er(true);
        this.cnJ.et(com.baidu.tbadk.core.m.qV().qX());
        this.cnJ.setOnLongClickListener(this.ajZ);
        this.cnJ.b(new q(this));
        this.cnJ.a(this.cnP);
        this.cnJ.b(this.cnQ);
        if (this.cnH != null && this.cnH.ahD() && !this.cnH.air()) {
            this.cnJ.ahR().setVisibility(8);
        } else {
            this.cnJ.ahR().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.cjn = new com.baidu.tieba.usermute.i(getPageContext(), this.cjC);
        this.cjm = new UserMuteAddAndDelModel<>(this);
        this.cnH = new am(getPageContext());
        this.cnI = new com.baidu.tieba.tbadkCore.h.a(this);
        this.cnI.setLoadDataCallBack(this.cnO);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.cjk = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cjk != null) {
            this.cjk.a(this.cjE);
        }
        if (bundle != null) {
            this.cnH.initWithBundle(bundle);
        } else {
            this.cnH.initWithIntent(getIntent());
        }
        this.cnH.a(this.cnN);
        if (this.cnH.ahD()) {
            this.cnH.CI();
        } else {
            this.cnH.aij();
        }
    }

    public void ahG() {
        this.cnN = new r(this);
        this.cjE = new s(this);
        this.cnP = new t(this);
        this.cnQ = new u(this);
        this.cnO = new b(this);
    }

    public void Rf() {
        this.aZI = new c(this);
        this.cnK = new d(this);
        this.cjM = new e(this);
        this.ajZ = new f(this);
        this.cnL = new g(this);
        this.cnM = new h(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, HashMap<String, ImageUrlData> hashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.f EN;
        if (aVar == aVar2) {
            this.cjK = true;
        }
        if (aVar != null) {
            int size = aVar.EI().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.EI().get(i6) != null && aVar.EI().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.EI().get(i6).EN().getWidth();
                    int height = aVar.EI().get(i6).EN().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.EI().get(i6).EN().EX()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.EI().get(i6);
                        String d = d(cVar);
                        arrayList.add(d);
                        if (!TextUtils.isEmpty(d) && cVar != null && (EN = cVar.EN()) != null) {
                            String EY = EN.EY();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = EY;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (hashMap != null) {
                                hashMap.put(d, imageUrlData);
                            }
                        }
                        if (!this.cjK) {
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
        StringBuilder sb = new StringBuilder((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        com.baidu.tbadk.widget.richText.f EN = cVar.EN();
        if (EN != null) {
            if (!StringUtils.isNull(EN.EW())) {
                return EN.EW();
            }
            if (EN.getHeight() * EN.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (EN.getHeight() * EN.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (EN.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * EN.getHeight())));
            } else {
                float width = EN.getWidth() / EN.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(as.aP(EN.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a W(String str, int i) {
        if (this.cnH == null || this.cnH.aic() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.d aic = this.cnH.aic();
        com.baidu.tbadk.widget.richText.a a2 = a(aic.afs(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(aic.afs(), str, i);
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
        com.baidu.tbadk.widget.richText.a axu = oVar.axu();
        ArrayList<com.baidu.tbadk.widget.richText.c> EI = axu.EI();
        int size = EI.size();
        int i2 = -1;
        int i3 = 0;
        while (i3 < size) {
            if (EI.get(i3) != null && EI.get(i3).getType() == 8) {
                i2++;
                if (EI.get(i3).EN().EY().equals(str)) {
                    int width = EI.get(i3).EN().getWidth();
                    int height = EI.get(i3).EN().getHeight();
                    if (width < 80 || height < 80 || height * width < 10000) {
                        return null;
                    }
                    this.cjJ = i3;
                    return axu;
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
        long awX = this.cnH.aic().afs().axC() != null ? this.cnH.aic().afs().axC().awX() : 0L;
        if (!TextUtils.isEmpty(str) && az.uX().b(getPageContext(), new String[]{str}) && awX != 0) {
            com.baidu.tieba.pb.a.a(awX, str, "PB", str2, "CLICK", "ad_tpoint", this.cnH.aic().afz().getId(), this.cnH.aic().afz().getName(), this.cnH.aic().afB().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, String str) {
        if (!this.cnH.aid()) {
            if (com.baidu.adp.lib.util.k.je()) {
                if (i == 4) {
                    this.cnJ.jW(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.cnJ.gu(i.h.no_data_text);
                    return;
                }
            }
            this.cnJ.gu(i.h.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.cbv = (com.baidu.tbadk.editortools.c.p) new com.baidu.tbadk.editortools.c.t().ak(getActivity());
        this.cbv.b(this);
        this.cbv.b(this.cnH);
        this.cbv.b(this.cnR);
        this.cbv.a(this.aqG);
        this.cbv.c(this);
        if (this.cnJ != null) {
            this.cnJ.e(this.cbv);
        }
        if (this.cbv != null && this.cnH != null) {
            this.cbv.a(this.cnH.afA());
        }
    }

    public void ahH() {
        if (!TbadkCoreApplication.isLogin()) {
            this.cbv.BC();
        } else if (this.cnH.aio()) {
            if (!StringUtils.isNull(this.cnH.ail()) && !StringUtils.isNull(this.cnH.aip())) {
                new Handler().postDelayed(new i(this), 500L);
            } else {
                this.cbv.fg(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(i.f.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.f.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(i.f.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.f.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean ? ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(i.f.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.cnJ.ab(view);
                }
            } else if (booleanValue2) {
                this.cnJ.a(((Integer) sparseArray.get(i.f.tag_del_post_type)).intValue(), (String) sparseArray.get(i.f.tag_del_post_id), ((Integer) sparseArray.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(i.f.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.cnJ.ahT(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(i.f.tag_disable_reply_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        }
        if (((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(i.h.delete);
            strArr2[1] = z ? getResources().getString(i.h.un_mute) : getResources().getString(i.h.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(i.h.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bI(i.h.operation);
        cVar.a(strArr, new j(this, sparseArray, z, str));
        cVar.d(getPageContext()).sU();
    }

    public void d(SparseArray<Object> sparseArray) {
        String str;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!(sparseArray.get(i.f.tag_disable_reply_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(i.f.tag_disable_reply_mute_userid);
        }
        this.cnJ.Zw();
        this.cjn.a(com.baidu.adp.lib.g.b.c(currentAccount, 0L), com.baidu.adp.lib.g.b.c(str, 0L), sparseArray);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.cnJ.a(0, bVar.An, bVar.ddm, true);
            if (bVar.An) {
                if (bVar.ddk == 1) {
                    finish();
                } else if (bVar.ddk == 2) {
                    this.cnH.jZ(bVar.mPostId);
                    this.cnJ.a(this.cnH.aic(), this.cnH.afl());
                }
                ao aoVar = new ao();
                aoVar.setData(bVar);
                aoVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, aoVar));
            }
        }
    }

    public void jK(String str) {
        if (!StringUtils.isNull(str) && this.cnH != null) {
            String threadID = this.cnH.getThreadID();
            String AV = this.cnH.AV();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(i.h.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + AV + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void c(com.baidu.tieba.tbadkCore.data.o oVar) {
        if (oVar != null) {
            boolean z = false;
            if (this.cnH.isMarked() && oVar.getId() != null && oVar.getId().equals(this.cnH.ain())) {
                z = true;
            }
            MarkData d = this.cnH.d(oVar);
            if (d != null) {
                this.cnJ.aho();
                if (this.cjk != null) {
                    this.cjk.a(d);
                    if (!z) {
                        this.cjk.qk();
                    } else {
                        this.cjk.qj();
                    }
                }
            }
        }
    }

    public void replyPost(View view) {
        if (this.cnJ.ahT() == null || this.cnJ.ahS() == null) {
            this.cnJ.afK();
        }
        if (this.cnJ.ahT().getIsIntercepted()) {
            this.cnJ.ahT().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.o oVar = sparseArray.get(i.f.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.o ? (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(i.f.tag_load_sub_data) : null;
            View view2 = sparseArray.get(i.f.tag_load_sub_view) instanceof View ? (View) sparseArray.get(i.f.tag_load_sub_view) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(i.f.tag_load_sub_data, oVar);
            sparseArray2.put(i.f.tag_load_sub_view, view2);
            this.cnJ.ahS().agK().setTag(sparseArray2);
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.o oVar2 = sparseArray3.get(i.f.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.o ? (com.baidu.tieba.tbadkCore.data.o) sparseArray3.get(i.f.tag_clip_board) : null;
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(i.f.tag_clip_board, oVar2);
            sparseArray4.put(i.f.tag_is_subpb, false);
            this.cnJ.ahS().agz().setTag(sparseArray4);
            SparseArray sparseArray5 = (SparseArray) view.getTag();
            boolean booleanValue = sparseArray5.get(i.f.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(i.f.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray5.get(i.f.tag_display_reply_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(i.f.tag_display_reply_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray5.get(i.f.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(i.f.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray5.get(i.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray5.get(i.f.tag_del_post_is_self)).booleanValue() : false;
            if (sparseArray5.get(i.f.tag_forbid_user_post_id) instanceof String) {
                String str = (String) sparseArray5.get(i.f.tag_forbid_user_post_id);
            }
            if (booleanValue) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(i.f.tag_should_manage_visible, true);
                sparseArray6.put(i.f.tag_manage_user_identity, sparseArray5.get(i.f.tag_manage_user_identity));
                sparseArray6.put(i.f.tag_del_post_is_self, sparseArray5.get(i.f.tag_del_post_is_self));
                sparseArray6.put(i.f.tag_del_post_id, sparseArray5.get(i.f.tag_del_post_id));
                sparseArray6.put(i.f.tag_del_post_type, sparseArray5.get(i.f.tag_del_post_type));
                sparseArray6.put(i.f.tag_forbid_user_name, sparseArray5.get(i.f.tag_forbid_user_name));
                sparseArray6.put(i.f.tag_forbid_user_post_id, sparseArray5.get(i.f.tag_forbid_user_post_id));
                if (booleanValue2) {
                    sparseArray6.put(i.f.tag_display_reply_visible, true);
                    sparseArray6.put(i.f.tag_is_mem, sparseArray5.get(i.f.tag_is_mem));
                    sparseArray6.put(i.f.tag_disable_reply_mute_userid, sparseArray5.get(i.f.tag_disable_reply_mute_userid));
                    sparseArray6.put(i.f.tag_disable_reply_mute_username, sparseArray5.get(i.f.tag_disable_reply_mute_username));
                    sparseArray6.put(i.f.tag_disable_reply_post_id, sparseArray5.get(i.f.tag_disable_reply_post_id));
                    sparseArray6.put(i.f.tag_disable_reply_thread_id, sparseArray5.get(i.f.tag_disable_reply_thread_id));
                } else {
                    sparseArray6.put(i.f.tag_display_reply_visible, false);
                }
                if (booleanValue3) {
                    sparseArray6.put(i.f.tag_should_delete_visible, true);
                    sparseArray6.put(i.f.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                    sparseArray6.put(i.f.tag_del_post_id, sparseArray5.get(i.f.tag_del_post_id));
                    sparseArray6.put(i.f.tag_del_post_type, sparseArray5.get(i.f.tag_del_post_type));
                } else {
                    sparseArray6.put(i.f.tag_should_delete_visible, false);
                }
                this.cnJ.ahS().agL().setTag(sparseArray6);
                if (!"".equals(sparseArray5.get(i.f.tag_forbid_user_name)) && !"".equals(sparseArray5.get(i.f.tag_del_post_id))) {
                    com.baidu.tbadk.core.util.an.c(this.cnJ.ahS().agL(), i.e.icon_pb_set_n);
                } else {
                    com.baidu.tbadk.core.util.an.c(this.cnJ.ahS().agL(), i.e.icon_pb_del_n);
                }
                this.cnJ.ahS().agL().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(i.f.tag_should_manage_visible, false);
                sparseArray7.put(i.f.tag_display_reply_visible, false);
                sparseArray7.put(i.f.tag_should_delete_visible, true);
                sparseArray7.put(i.f.tag_manage_user_identity, sparseArray5.get(i.f.tag_manage_user_identity));
                sparseArray7.put(i.f.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray7.put(i.f.tag_del_post_id, sparseArray5.get(i.f.tag_del_post_id));
                sparseArray7.put(i.f.tag_del_post_type, sparseArray5.get(i.f.tag_del_post_type));
                this.cnJ.ahS().agL().setTag(sparseArray7);
                com.baidu.tbadk.core.util.an.c(this.cnJ.ahS().agL(), i.e.icon_pb_del_n);
                this.cnJ.ahS().agL().setVisibility(0);
            } else {
                this.cnJ.ahS().agL().setVisibility(8);
            }
            SparseArray sparseArray8 = (SparseArray) view.getTag();
            boolean booleanValue5 = sparseArray8.get(i.f.tag_display_reply_visible) instanceof Boolean ? ((Boolean) sparseArray8.get(i.f.tag_display_reply_visible)).booleanValue() : false;
            if (!((Boolean) sparseArray8.get(i.f.tag_should_manage_visible)).booleanValue() && booleanValue5) {
                SparseArray sparseArray9 = new SparseArray();
                sparseArray9.put(i.f.tag_display_reply_visible, true);
                sparseArray9.put(i.f.tag_is_mem, sparseArray8.get(i.f.tag_is_mem));
                sparseArray9.put(i.f.tag_disable_reply_mute_userid, sparseArray8.get(i.f.tag_disable_reply_mute_userid));
                sparseArray9.put(i.f.tag_disable_reply_mute_username, sparseArray8.get(i.f.tag_disable_reply_mute_username));
                sparseArray9.put(i.f.tag_disable_reply_post_id, sparseArray8.get(i.f.tag_disable_reply_post_id));
                sparseArray9.put(i.f.tag_disable_reply_thread_id, sparseArray8.get(i.f.tag_disable_reply_thread_id));
                sparseArray9.put(i.f.tag_del_post_is_self, sparseArray8.get(i.f.tag_del_post_is_self));
                sparseArray9.put(i.f.tag_del_post_type, sparseArray8.get(i.f.tag_del_post_type));
                sparseArray9.put(i.f.tag_del_post_id, sparseArray8.get(i.f.tag_del_post_id));
                sparseArray9.put(i.f.tag_manage_user_identity, sparseArray8.get(i.f.tag_manage_user_identity));
                this.cnJ.ahS().agM().setTag(sparseArray9);
                this.cnJ.ahS().agM().setVisibility(0);
                this.cnJ.ahS().agL().setVisibility(8);
                com.baidu.tbadk.core.util.an.c(this.cnJ.ahS().agM(), i.e.icon_pb_gag);
            } else {
                boolean booleanValue6 = sparseArray8.get(i.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray8.get(i.f.tag_del_post_is_self)).booleanValue() : false;
                String str2 = sparseArray8.get(i.f.tag_forbid_user_post_id) instanceof String ? (String) sparseArray8.get(i.f.tag_forbid_user_post_id) : null;
                if (ev(booleanValue6) & isLogin()) {
                    this.cnJ.ahS().agM().setVisibility(0);
                    this.cnJ.ahS().agM().setTag(str2);
                } else {
                    this.cnJ.ahS().agM().setVisibility(8);
                }
            }
        }
        if (this.cnH.isMarked()) {
            this.cnJ.ahS().agz().setText(i.h.marked);
            this.cnJ.ahS().agz().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.cnJ.ahS().agz().setText(i.h.mark);
            this.cnJ.ahS().agz().setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.cnJ.ahS().eF(false);
        this.cnJ.ahT().reLayoutWidth();
        if (view != null) {
            this.cnJ.ahT().showWindowInLeftCenterOfHost(view, false);
        }
    }

    private boolean ev(boolean z) {
        return (this.cnH == null || this.cnH.aic() == null || z || this.cnH.afl() != 0 || this.cnH.aic().afB() == null || this.cnH.aic().afB().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.cnH.aic().afB().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.cnH != null) {
            this.cnH.saveToBundle(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cbv != null) {
            this.cbv.onActivityResult(i, i2, intent);
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
        this.cbv.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cjn.onDestroy();
        this.cnH.cancelLoadData();
        this.cnH.destory();
        this.cnI.cancelLoadData();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        this.cnJ.aho();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cnJ.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View ahQ = this.cnJ.ahQ();
        if (ahQ == null || (findViewWithTag = ahQ.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean jL(String str) {
        Map<String, String> dr;
        if (!TextUtils.isEmpty(str) && (dr = az.dr(az.ds(str))) != null) {
            String str2 = dr.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return jL(com.baidu.adp.lib.util.j.aQ(str2));
            }
            String str3 = dr.get(cje);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (jL(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                az.uX().b(getPageContext(), new String[]{str});
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
    public com.baidu.adp.lib.e.b<TextView> getTextViewPool() {
        if (this.aAM == null) {
            this.aAM = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aAM;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.e.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.e.b<ImageView> getImageViewPool() {
        if (this.aAL == null) {
            this.aAL = new com.baidu.adp.lib.e.b<>(new k(this), 8, 0);
        }
        return this.aAL;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.e.b<View> getVoiceViewPool() {
        if (this.aAN == null) {
            this.aAN = new com.baidu.adp.lib.e.b<>(new m(this), 8, 0);
        }
        return this.aAN;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.e.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aAO == null) {
            this.aAO = new com.baidu.adp.lib.e.b<>(new n(this), 15, 0);
        }
        return this.aAO;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cnJ.ahM() && com.baidu.adp.lib.util.k.je()) {
            this.cnH.CI();
        } else {
            this.cnJ.ahP();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (sparseArray.get(i.f.tag_disable_reply_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(i.f.tag_disable_reply_mute_username);
        }
        if (sparseArray.get(i.f.tag_disable_reply_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(i.f.tag_disable_reply_thread_id);
        }
        if (sparseArray.get(i.f.tag_disable_reply_post_id) instanceof String) {
            str4 = (String) sparseArray.get(i.f.tag_disable_reply_post_id);
        }
        this.cjm.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jV(String str) {
        String string;
        if (!StringUtils.isNull(str) && bd.ah(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tu().getString("bubble_link", ""))) {
                com.baidu.tbadk.browser.g.a(getPageContext().getPageActivity(), getResources().getString(i.h.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onLinkButtonClicked(Context context, String str) {
        g(context, str, "BUTTON");
    }
}
