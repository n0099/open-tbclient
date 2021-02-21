package com.baidu.tieba.pb.videopb.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.pageExtra.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.h;
import com.baidu.tieba.NEGFeedBack.i;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ac;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
import tbclient.ForumToolPerm;
/* loaded from: classes2.dex */
public class a {
    public static int mal = 3;
    public static int mam = 0;
    public static int man = 3;
    public static int mao = 4;
    public static int maq = 5;
    public static int mar = 6;
    private at eIQ;
    private com.baidu.tbadk.core.message.a feF;
    private e fep;
    private List<CustomBlueCheckRadioButton> izH;
    private f jRi;
    private String lNs;
    private com.baidu.tieba.pb.pb.report.a lRP;
    private i lRW;
    private k lRX;
    private boolean lRj;
    public BdUniqueId lSm;
    private com.baidu.adp.widget.ImageView.a lSo;
    private String lSp;
    private TbRichTextMemeInfo lSq;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private com.baidu.tieba.NEGFeedBack.i maM;
    private PbFragment.b mba;
    public VideoPbFragment mme;
    private Runnable runnable;
    private i lZC = null;
    private com.baidu.tbadk.core.dialog.a lZu = null;
    private Dialog lZv = null;
    private Dialog lZw = null;
    private View lZx = null;
    private LinearLayout lZy = null;
    private TextView lZz = null;
    private TextView lZA = null;
    private String lZB = null;
    private ScrollView lZF = null;
    private CompoundButton.OnCheckedChangeListener izI = null;
    private i lZt = null;
    private com.baidu.tbadk.core.view.a iDU = null;
    private com.baidu.tbadk.core.dialog.b lRp = null;
    private AlertDialog mfG = null;
    private ac mfH = null;
    PostData kqg = null;
    private boolean lRN = d.biY();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return a.this.dR(view);
        }
    };
    private k.c lSP = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.lRW != null) {
                a.this.lRW.dismiss();
            }
            a.this.FH(i);
            switch (i) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    a.this.dD(view2);
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    }
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    a.this.dD(view3);
                    if (view3 != null) {
                        view3.performClick();
                        return;
                    }
                    return;
                case -2:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (d.bjj() || d.bjk()) {
                        View view4 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_2);
                        AgreeView agreeView = (AgreeView) view4;
                        a.this.dD(view4);
                        if (agreeView != null && agreeView.getImgDisagree() != null) {
                            agreeView.getImgDisagree().performClick();
                            return;
                        }
                        return;
                    }
                    View view5 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_1);
                    AgreeView agreeView2 = (AgreeView) view5;
                    a.this.dD(view5);
                    if (agreeView2 != null && agreeView2.getImgDisagree() != null) {
                        agreeView2.getImgDisagree().performClick();
                        return;
                    }
                    return;
                case -1:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (d.bjj() || d.bjk()) {
                        View view6 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_2);
                        a.this.dD(view6);
                        AgreeView agreeView3 = (AgreeView) view6;
                        if (agreeView3 != null && agreeView3.getImgAgree() != null) {
                            agreeView3.getImgAgree().performClick();
                            return;
                        }
                        return;
                    }
                    View view7 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_1);
                    a.this.dD(view7);
                    AgreeView agreeView4 = (AgreeView) view7;
                    if (agreeView4 != null && agreeView4.getImgAgree() != null) {
                        agreeView4.getImgAgree().performClick();
                        return;
                    }
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (a.this.lSo != null && !TextUtils.isEmpty(a.this.lSp)) {
                        if (a.this.lSq == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lSp));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.lSp;
                            aVar.pkgId = a.this.lSq.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lSq.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.lSo = null;
                        a.this.lSp = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.lSo != null && !TextUtils.isEmpty(a.this.lSp)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.mme.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mme.getPageContext().getPageActivity())) {
                            if (a.this.eIQ == null) {
                                a.this.eIQ = new at(a.this.mme.getPageContext());
                            }
                            a.this.eIQ.p(a.this.lSp, a.this.lSo.getImageByte());
                            a.this.lSo = null;
                            a.this.lSp = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.kqg != null) {
                        a.this.kqg.gW(a.this.mme.getPageContext().getPageActivity());
                        a.this.kqg = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new ar("c11739").ap("obj_locate", 2));
                    if (a.this.mme.checkUpIsLogin()) {
                        a.this.dE(view);
                        if (a.this.mme.dmx().getPbData().dlg() != null && a.this.mme.dmx().getPbData().dlg().bnQ() != null && a.this.mme.dmx().getPbData().dlg().bnQ().getUserId() != null && a.this.mme.dub() != null) {
                            int h = a.this.h(a.this.mme.dmx().getPbData());
                            cb dlg = a.this.mme.dmx().getPbData().dlg();
                            if (dlg.bmx()) {
                                i2 = 2;
                            } else if (dlg.bmy()) {
                                i2 = 3;
                            } else if (dlg.bpN()) {
                                i2 = 4;
                            } else {
                                i2 = dlg.bpO() ? 5 : 1;
                            }
                            TiebaStatic.log(new ar("c12526").dR("tid", a.this.mme.dmx().doA()).ap("obj_locate", 2).dR("obj_id", a.this.mme.dmx().getPbData().dlg().bnQ().getUserId()).ap("obj_type", a.this.mme.dub().bjZ() ? 0 : 1).ap("obj_source", h).ap("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.mme.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new ar("c13079"));
                        a.this.Pu((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new ar("c11739").ap("obj_locate", 4));
                        SparseArray<Object> sparseArray4 = (SparseArray) tag;
                        if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray4.put(R.id.tag_from, 0);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            a.this.f(sparseArray4);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        a.this.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!j.isNetWorkAvailable()) {
                        a.this.mme.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null) {
                        boolean booleanValue = ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray6.put(R.id.tag_from, 1);
                                sparseArray6.put(R.id.tag_check_mute_from, 2);
                                a.this.f(sparseArray6);
                                return;
                            }
                            sparseArray6.put(R.id.tag_check_mute_from, 2);
                            a.this.dL(view);
                            return;
                        } else if (booleanValue2) {
                            a.this.a(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (bh.checkUpIsLogin(a.this.mme.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bpJ() != null) {
                            c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                            if (bR != null) {
                                postData.bpJ().objSource = bR.getCurrentPageKey();
                            }
                            a.this.d(postData.bpJ());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    private final b.InterfaceC0558b lTd = new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.lSo != null && !TextUtils.isEmpty(a.this.lSp)) {
                if (i == 0) {
                    if (a.this.lSq == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lSp));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.lSp;
                        aVar.pkgId = a.this.lSq.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lSq.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.mme.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mme.getPageContext().getPageActivity())) {
                        if (a.this.eIQ == null) {
                            a.this.eIQ = new at(a.this.mme.getPageContext());
                        }
                        a.this.eIQ.p(a.this.lSp, a.this.lSo.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.lSo = null;
                a.this.lSp = null;
            }
        }
    };

    public void dnD() {
        com.baidu.tieba.pb.data.f pbData;
        cb dlg;
        boolean z = true;
        if (this.mme != null && this.mme.dmx() != null && this.mme.dmx().getPbData() != null && (dlg = (pbData = this.mme.dmx().getPbData()).dlg()) != null && dlg.bnQ() != null) {
            this.mme.dqo();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dlg.bnQ().getUserId());
            ad adVar = new ad();
            int dlv = this.mme.dmx().getPbData().dlv();
            if (dlv == 1 || dlv == 3) {
                adVar.lXk = true;
                adVar.lXq = dlg.bnL() == 1;
            } else {
                adVar.lXk = false;
            }
            if (FJ(dlv)) {
                adVar.lXl = true;
                adVar.lXp = dlg.bnM() == 1;
            } else {
                adVar.lXl = false;
            }
            if (dlv == 1002 && !equals) {
                adVar.lXr = true;
            }
            adVar.lXi = vb(equals);
            adVar.lXm = dnE();
            adVar.lXj = vc(equals);
            adVar.FD = this.mme.dmx().doC();
            adVar.lXf = true;
            adVar.lXe = va(equals);
            adVar.lXo = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lXn = true;
            adVar.isHostOnly = this.mme.dmx().getHostMode();
            adVar.lXh = true;
            if (dlg.boh() == null) {
                adVar.lXg = true;
            } else {
                adVar.lXg = false;
            }
            if (pbData.dlJ()) {
                adVar.lXf = false;
                adVar.lXh = false;
                adVar.lXg = false;
                adVar.lXk = false;
                adVar.lXl = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dlJ()) {
                z = false;
            }
            adVar.lXs = z;
            if (this.mme.L(this.mme.dmx().getPbData()) != null) {
                adVar.eVr = this.mme.L(this.mme.dmx().getPbData()).nxK;
            }
            a(adVar);
        }
    }

    public boolean FJ(int i) {
        boolean z;
        List<ForumToolPerm> forumToolAuth;
        switch (i) {
            case 1:
                return true;
            case 2:
            case 3:
            case 4:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z || this.mme.dmx().getPbData().getUserData() == null || (forumToolAuth = this.mme.dmx().getPbData().getUserData().getForumToolAuth()) == null) {
            return false;
        }
        for (int i2 = 0; i2 < forumToolAuth.size(); i2++) {
            ForumToolPerm forumToolPerm = forumToolAuth.get(i2);
            if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean vb(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ad adVar;
        if (this.mme == null || this.mme.dmx() == null || this.mme.dmx().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.mme.dmx().getPbData();
        cb dlg = pbData.dlg();
        if (dlg != null) {
            if (dlg.bmx() || dlg.bmy()) {
                return false;
            }
            if (dlg.bpN() || dlg.bpO()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (dlg == null || dlg.bnQ() == null || !dlg.bnQ().isForumBusinessAccount() || au.isOn()) {
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dlv() != 0) {
                    return pbData.dlv() != 3;
                }
                List<bx> dlD = pbData.dlD();
                if (y.getCount(dlD) > 0) {
                    for (bx bxVar : dlD) {
                        if (bxVar != null && (adVar = bxVar.ePM) != null && adVar.eNw && !adVar.eNx && (adVar.type == 1 || adVar.type == 2)) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                return z2;
            }
            return false;
        }
        return false;
    }

    private boolean vc(boolean z) {
        if (z || this.mme == null || this.mme.dmx() == null || this.mme.dmx().getPbData() == null) {
            return false;
        }
        if (this.mme.dmx().getPbData().getForum() == null || !this.mme.dmx().getPbData().getForum().isBlockBawuDelete) {
            com.baidu.tieba.pb.data.f pbData = this.mme.dmx().getPbData();
            return ((pbData.dlg() != null && pbData.dlg().bnQ() != null && pbData.dlg().bnQ().isForumBusinessAccount() && !au.isOn()) || this.mme.dmx().getPbData().dlv() == 0 || this.mme.dmx().getPbData().dlv() == 3) ? false : true;
        }
        return false;
    }

    private boolean dnE() {
        if (this.mme == null || this.mme.dmx() == null || !this.mme.dmx().doC()) {
            return false;
        }
        return this.mme.dmx().getPageData() == null || this.mme.dmx().getPageData().bmG() != 0;
    }

    public void a(ad adVar) {
        if (!this.mme.getBaseFragmentActivity().isProgressBarShown()) {
            this.mfH = new ac(this.mme, this.mme.aEh);
            this.mfG = new AlertDialog.Builder(this.mme.getContext(), R.style.DialogTheme).create();
            this.mfG.setCanceledOnTouchOutside(true);
            g.showDialog(this.mfG, this.mme.getFragmentActivity());
            Window window = this.mfG.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mfH.getView());
            this.mfH.vq(adVar == null ? false : adVar.lXe);
            this.mfH.vr(adVar == null ? false : adVar.lXi);
            this.mfH.vs(adVar == null ? false : adVar.lXm);
            this.mfH.vu(adVar == null ? false : adVar.lXj);
            this.mfH.vv(adVar == null ? true : adVar.lXg);
            if (adVar == null) {
                this.mfH.aq(false, false);
                this.mfH.ar(false, false);
            } else {
                this.mfH.aq(adVar.lXk, adVar.lXq);
                this.mfH.ar(adVar.lXl, adVar.lXp);
            }
            boolean z = adVar == null ? false : adVar.FD;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lXh;
            boolean z4 = adVar == null ? false : adVar.lXf;
            boolean z5 = adVar == null ? false : adVar.lXo;
            boolean z6 = adVar == null ? false : adVar.lXn;
            this.mfH.ap(z3, z2);
            this.mfH.as(z4, z);
            this.mfH.at(z6, z5);
            if (adVar != null) {
                this.mfH.lXb = adVar.lXr;
                if (adVar.lXr) {
                    this.mfH.dpP().setText(R.string.report_text);
                    this.mfH.vu(false);
                }
            }
            this.mfH.vt(adVar != null ? adVar.lXs : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.mme.dmx() != null && this.mme.dmx().getPbData() != null && this.mme.dmx().getPbData().getThreadId() != null && this.mme.dmx().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.mfH.dpS().setText(R.string.have_called_fans_short);
            }
            dsq();
        }
    }

    private void dsq() {
        if (this.mfH != null) {
            this.mfH.dpW();
        }
    }

    public void baM() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mfG != null) {
                        g.dismissDialog(a.this.mfG, a.this.mme.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mA().postDelayed(this.runnable, 100L);
    }

    public void dsr() {
        if (this.mfG != null) {
            g.dismissDialog(this.mfG, this.mme.getPageContext().getPageActivity());
        }
    }

    public ac dss() {
        return this.mfH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dR(View view) {
        boolean z;
        boolean z2;
        List<com.baidu.tbadk.core.dialog.g> list;
        com.baidu.tbadk.core.dialog.g gVar;
        SparseArray sparseArray;
        if (this.mme == null || !this.mme.isAdded()) {
            return true;
        }
        SparseArray sparseArray2 = null;
        try {
            sparseArray2 = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        if (sparseArray2 == null) {
            if (dG(view)) {
                if (view instanceof TbImageView) {
                    this.lSo = ((TbImageView) view).getBdImage();
                    this.lSp = ((TbImageView) view).getUrl();
                    if (this.lSo == null || TextUtils.isEmpty(this.lSp)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lSq = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lSq = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lSo = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lSp = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lSq = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lSq = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lSo = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lSp = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lSq = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lSq = null;
                    }
                }
                if (view.getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                    } catch (ClassCastException e2) {
                        e2.printStackTrace();
                        sparseArray = sparseArray2;
                    }
                } else if (view.getParent().getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                    } catch (ClassCastException e3) {
                        e3.printStackTrace();
                        sparseArray = sparseArray2;
                    }
                } else {
                    a(this.lTd, this.lSo.isGif());
                }
                if (sparseArray != null) {
                    return true;
                }
                sparseArray2 = sparseArray;
            }
            sparseArray = sparseArray2;
            if (sparseArray != null) {
            }
        }
        this.kqg = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.kqg == null || this.mme.dub() == null) {
            return true;
        }
        if (!this.mme.dub().bjZ() || this.kqg.getId() == null || !this.kqg.getId().equals(this.mme.dmx().bnY())) {
            z = false;
        } else {
            z = true;
        }
        boolean z3 = this.mme.dmx().getPbData() != null && this.mme.dmx().getPbData().dlJ();
        if (this.lRX == null) {
            this.lRX = new k(this.mme.getContext());
            this.lRX.a(this.lSP);
        }
        ArrayList arrayList = new ArrayList();
        if (view != null && sparseArray2 != null) {
            boolean z4 = dG(view) && !z3;
            boolean z5 = (!dG(view) || this.lSo == null || this.lSo.isGif()) ? false : true;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String str = null;
            if (!(sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean)) {
                z2 = false;
            } else {
                z2 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                z6 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z7 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                z8 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z9 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                z10 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String) {
                str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
            }
            if (z4) {
                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.lRX));
            }
            if (z5) {
                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.lRX));
            }
            if (!z4 && !z5) {
                com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.lRX);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.kqg);
                gVar2.eVl.setTag(sparseArray3);
                arrayList.add(gVar2);
            }
            if (!z2 && !z3) {
                if (z) {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.lRX);
                } else {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.lRX);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.kqg);
                sparseArray4.put(R.id.tag_is_subpb, false);
                gVar.eVl.setTag(sparseArray4);
                arrayList.add(gVar);
            }
            if (TbadkCoreApplication.isLogin() && !this.lRN) {
                if (!z8 && z7) {
                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.lRX);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_user_mute_visible, true);
                    sparseArray5.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                    sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                    sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                    sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                    sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                    sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                    sparseArray5.put(R.id.tag_del_post_is_self, sparseArray2.get(R.id.tag_del_post_is_self));
                    sparseArray5.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                    sparseArray5.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                    sparseArray5.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    gVar3.eVl.setTag(sparseArray5);
                    arrayList.add(gVar3);
                } else {
                    if ((va(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lRX);
                        gVar4.eVl.setTag(str);
                        arrayList.add(gVar4);
                    }
                }
                com.baidu.tbadk.core.dialog.g gVar5 = null;
                com.baidu.tbadk.core.dialog.g gVar6 = null;
                if (z8) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.tag_should_manage_visible, true);
                    sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                    sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                    sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                    sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                    if (z9) {
                        sparseArray6.put(R.id.tag_user_mute_visible, true);
                        sparseArray6.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                        sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                        sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                        sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                        sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                    } else {
                        sparseArray6.put(R.id.tag_user_mute_visible, false);
                    }
                    if (z10) {
                        sparseArray6.put(R.id.tag_should_delete_visible, true);
                        sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                        sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lRX);
                        gVar6.eVl.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                    }
                    gVar5 = new com.baidu.tbadk.core.dialog.g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.lRX);
                    gVar5.eVl.setTag(sparseArray6);
                } else if (z10) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_should_manage_visible, false);
                    sparseArray7.put(R.id.tag_user_mute_visible, false);
                    sparseArray7.put(R.id.tag_should_delete_visible, true);
                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                    sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                    if (this.mme.dmx().getPbData().dlv() == 1002 && !z6) {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lRX);
                    } else {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lRX);
                    }
                    gVar6.eVl.setTag(sparseArray7);
                }
                if (gVar6 != null) {
                    arrayList.add(gVar6);
                }
                if (gVar5 != null) {
                    arrayList.add(gVar5);
                }
            }
            if (com.baidu.tbadk.a.d.bjm()) {
                list = com.baidu.tieba.pb.pb.main.d.a.fq(com.baidu.tieba.pb.pb.main.d.a.x(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.kqg.bpJ(), sparseArray2, this.lRX), this.lRj));
                this.lRX.a(com.baidu.tieba.pb.pb.main.d.a.t(this.kqg));
            } else {
                list = arrayList;
            }
            this.lRX.k(list, true);
            this.lRW = new i(this.mme.getPageContext(), this.lRX);
            this.lRW.QE();
            TiebaStatic.log(new ar("c13272").dR("tid", this.mme.dmx().doA()).dR("fid", this.mme.dmx().getForumId()).dR("uid", this.mme.dmx().getPbData().dlg().bnQ().getUserId()).dR("post_id", this.mme.dmx().bBJ()).ap("obj_source", z2 ? 2 : 1));
        }
        return true;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.mme = videoPbFragment;
        this.lSm = videoPbFragment.getUniqueId();
        this.lRP = new com.baidu.tieba.pb.pb.report.a(this.mme.getContext());
        this.lRP.x(this.mme.getUniqueId());
        this.mba = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.17
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.mme.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.mme.dmx().getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                String str3 = "";
                if (objArr.length > 3) {
                    str3 = String.valueOf(objArr[3]);
                }
                String str4 = "";
                if (objArr.length > 4) {
                    str4 = String.valueOf(objArr[4]);
                }
                a.this.mme.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.mme.getPageContext().getPageActivity(), a.this.mme.dmx().getPbData().getForum().getId(), a.this.mme.dmx().getPbData().getForum().getName(), a.this.mme.dmx().getPbData().dlg().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH(int i) {
        TiebaStatic.log(new ar("c14000").dR("tid", this.mme.dmx().doA()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.Gk(i))));
    }

    public void wu(boolean z) {
        this.lRj = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lRj ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            n(postData);
        }
    }

    protected void n(PostData postData) {
        PostData L;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.mme.dmx().bnY())) {
                z = true;
            }
            MarkData o = this.mme.dmx().o(postData);
            if (this.mme.dmx().getPbData() != null && this.mme.dmx().getPbData().dlJ() && (L = this.mme.L(this.mme.dmx().getPbData())) != null) {
                o = this.mme.dmx().o(L);
            }
            if (o != null) {
                this.mme.dqR();
                if (this.mme.dub() != null) {
                    this.mme.dub().a(o);
                    if (!z) {
                        this.mme.dub().bkb();
                    } else {
                        this.mme.dub().bka();
                    }
                }
            }
        }
    }

    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlg() != null) {
            if (fVar.dlg().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dlg().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dlg().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    private boolean va(boolean z) {
        if (this.mme.dmx() == null || this.mme.dmx().getPbData() == null) {
            return false;
        }
        return ((this.mme.dmx().getPbData().dlv() != 0) || this.mme.dmx().getPbData().dlg() == null || this.mme.dmx().getPbData().dlg().bnQ() == null || TextUtils.equals(this.mme.dmx().getPbData().dlg().bnQ().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Pu(String str) {
        if (this.mme.dmx() != null && this.mme.dmx().getPbData() != null && this.mme.dmx().getPbData().dlJ()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mme.dmx().doA(), str);
            cb dlg = this.mme.dmx().getPbData().dlg();
            if (dlg.bmx()) {
                format = format + "&channelid=33833";
            } else if (dlg.bpM()) {
                format = format + "&channelid=33842";
            } else if (dlg.bmy()) {
                format = format + "&channelid=33840";
            }
            Pv(format);
            return;
        }
        this.lRP.PV(str);
    }

    private void Pv(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.mme.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lRW != null && this.lRW.isShowing()) {
                this.lRW.dismiss();
                this.lRW = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.mme.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.19
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.lRW != null) {
                            a.this.lRW.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.lSm);
                            userMuteAddAndDelCustomMessage.setTag(a.this.lSm);
                            a.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        }
                    }
                });
                ArrayList arrayList = new ArrayList();
                int i = -1;
                if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), kVar));
                }
                if (z) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), kVar));
                } else {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), kVar));
                }
                kVar.bw(arrayList);
                this.lRW = new i(this.mme.getPageContext(), kVar);
                this.lRW.QE();
            }
        }
    }

    public void dnZ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mme.getPageContext().getPageActivity());
        aVar.Au(this.mme.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.mme.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mme.getPageContext()).bqx();
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, (String) null);
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(mam, Integer.valueOf(man));
        int i3 = R.string.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = R.string.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = R.string.report_thread_confirm;
            } else {
                i3 = R.string.del_thread_confirm;
            }
        }
        this.lZu = new com.baidu.tbadk.core.dialog.a(this.mme.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lZu.nx(i3);
        } else {
            this.lZu.setOnlyMessageShowCenter(false);
            this.lZu.Au(str2);
        }
        this.lZu.setYesButtonTag(sparseArray);
        this.lZu.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.23
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.mme.a(aVar, (JSONArray) null);
            }
        });
        this.lZu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lZu.jF(true);
        this.lZu.b(this.mme.getPageContext());
        if (z) {
            this.lZu.bqx();
        } else if (dqL()) {
            h hVar = new h(this.mme.dmx().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.mme.dmx().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.mme.dmx().getPbData().dlP().has_forum_rule.intValue());
            hVar.eg(this.mme.dmx().getPbData().getForum().getId(), this.mme.dmx().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.mme.dmx().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.mme.dmx().getPbData().getForum().getUser_level());
            a(this.lZu, i, hVar, this.mme.dmx().getPbData().getUserData());
        } else {
            a(this.lZu, i);
        }
    }

    private boolean dqL() {
        if (this.mme == null || this.mme.dmx().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.mme.dmx().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.mme != null && aVar != null) {
            if (this.jRi == null && this.mme.getView() != null) {
                this.jRi = new f(this.mme.getPageContext(), this.mme.getView());
            }
            AntiData cBz = cBz();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBz != null && cBz.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBz.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.jRi.setDefaultReasonArray(new String[]{this.mme.getString(R.string.delete_thread_reason_1), this.mme.getString(R.string.delete_thread_reason_2), this.mme.getString(R.string.delete_thread_reason_3), this.mme.getString(R.string.delete_thread_reason_4), this.mme.getString(R.string.delete_thread_reason_5)});
            this.jRi.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jRi.Er(str);
            this.jRi.a(new f.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void W(JSONArray jSONArray) {
                    a.this.mme.a(aVar, jSONArray);
                }
            });
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, h hVar, UserData userData) {
        String str;
        if (this.mme != null && aVar != null) {
            if (this.maM == null && this.mme.getView() != null) {
                this.maM = new com.baidu.tieba.NEGFeedBack.i(this.mme.getPageContext(), this.mme.getView(), hVar, userData);
            }
            AntiData cBz = cBz();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBz != null && cBz.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBz.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.maM.setDefaultReasonArray(new String[]{this.mme.getString(R.string.delete_thread_reason_1), this.mme.getString(R.string.delete_thread_reason_2), this.mme.getString(R.string.delete_thread_reason_3), this.mme.getString(R.string.delete_thread_reason_4), this.mme.getString(R.string.delete_thread_reason_5)});
            this.maM.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.maM.Er(str);
            this.maM.a(new i.b() { // from class: com.baidu.tieba.pb.videopb.b.a.4
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void W(JSONArray jSONArray) {
                    a.this.mme.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cBz() {
        if (this.mme.dmx() == null || this.mme.dmx().getPbData() == null) {
            return null;
        }
        return this.mme.dmx().getPbData().getAnti();
    }

    public void dL(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        k kVar = new k(this.mme.getContext());
        kVar.setTitleText(this.mme.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.5
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lZt.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (a.this.mba != null) {
                                a.this.mba.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 12:
                            a.this.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mme.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mme.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eVl.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.mme.getString(R.string.forbidden_person), kVar);
            gVar3.eVl.setTag(sparseArray3);
            arrayList.add(gVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
            if (z) {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mme.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mme.getString(R.string.mute), kVar);
            }
            gVar.eVl.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.bw(arrayList);
        if (this.lZt == null) {
            this.lZt = new com.baidu.tbadk.core.dialog.i(this.mme.getPageContext(), kVar);
        } else {
            this.lZt.a(kVar);
        }
        this.lZt.QE();
    }

    public void dnw() {
        if (this.lRp == null) {
            this.lRp = new com.baidu.tbadk.core.dialog.b(this.mme.getPageContext().getPageActivity());
            this.lRp.a(new String[]{this.mme.getPageContext().getString(R.string.call_phone), this.mme.getPageContext().getString(R.string.sms_phone), this.mme.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.mme.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.lNs = a.this.lNs.trim();
                        UtilHelper.callPhone(a.this.mme.getPageContext().getPageActivity(), a.this.lNs);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mme.dmx().doA(), a.this.lNs, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.mme.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.lNs = a.this.lNs.trim();
                        UtilHelper.smsPhone(a.this.mme.getPageContext().getPageActivity(), a.this.lNs);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mme.dmx().doA(), a.this.lNs, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.lNs = a.this.lNs.trim();
                        UtilHelper.startBaiDuBar(a.this.mme.getPageContext().getPageActivity(), a.this.lNs);
                        bVar.dismiss();
                    }
                }
            }).nD(b.a.BOTTOM_TO_TOP).nE(17).d(this.mme.getPageContext());
        }
    }

    public void dS(final View view) {
        String[] strArr;
        int i = 0;
        if (this.mme != null && this.mme.dmx() != null) {
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mme.getPageContext());
            if (this.mme.dmx().getPbData().lKm == null || this.mme.dmx().getPbData().lKm.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.mme.dmx().getPbData().lKm.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mme.dmx().getPbData().lKm.size()) {
                        break;
                    }
                    strArr2[i2] = this.mme.dmx().getPbData().lKm.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.mme.dmx().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.mme.dmx().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.mme.dmx().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.mme.dmx().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new ar("c12097").ap("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ap("obj_type", i4));
                    if (a.this.mme.dmx().getPbData().lKm != null && a.this.mme.dmx().getPbData().lKm.size() > i3) {
                        i3 = a.this.mme.dmx().getPbData().lKm.get(i3).sort_type.intValue();
                    }
                    boolean FU = a.this.mme.dmx().FU(i3);
                    view.setTag(Integer.valueOf(a.this.mme.dmx().doU()));
                    if (FU) {
                        a.this.mme.setIsLoading(true);
                    }
                }
            });
            iVar.QE();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mme.getActivity());
            aVar.At(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Au(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jF(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ar("c12528").dR("obj_id", metaData.getUserId()).ap("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ar("c12528").dR("obj_id", metaData.getUserId()).ap("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.mme.dum() != null) {
                        a.this.mme.dum().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.mme.getPageContext().getUniqueId(), a.this.mme.dmx().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.mme.getPageContext()).bqx();
            TiebaStatic.log(new ar("c12527"));
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
        }
        if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
        }
        if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lSm);
        userMuteAddAndDelCustomMessage.setTag(this.lSm);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void Da(String str) {
        if (str == null) {
            str = "";
        }
        if (this.mme != null && this.mme.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mme.getPageContext().getPageActivity());
            aVar.Au(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mme.getPageContext()).bqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mme.getBaseFragmentActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.Au(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Au(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mme.getPageContext()).bqx();
    }

    public void showLoadingDialog() {
        if (this.iDU == null) {
            this.iDU = new com.baidu.tbadk.core.view.a(this.mme.getPageContext());
        }
        this.iDU.setDialogVisiable(true);
    }

    public void ckx() {
        if (this.iDU != null) {
            this.iDU.setDialogVisiable(false);
        }
    }

    public void i(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        com.baidu.tbadk.core.dialog.g gVar;
        if (this.mme != null && this.mme.dmx() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.lRX == null) {
                this.lRX = new k(this.mme.getContext());
                this.lRX.a(this.lSP);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.mme.dmx().getPbData() != null && this.mme.dmx().getPbData().dlJ();
            if (sparseArray != null) {
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                if (!(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                    z = false;
                } else {
                    z = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z3 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z4 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z5 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                }
                if (!(sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                    str = null;
                } else {
                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                }
                if (postData.bpJ() != null) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(8, (postData.bpJ().hasAgree && postData.bpt() == 5) ? this.mme.getString(R.string.action_cancel_dislike) : this.mme.getString(R.string.action_dislike), this.lRX);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.eVl.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, this.mme.getString(R.string.mute_option), this.lRX);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_user_mute_visible, true);
                        sparseArray3.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                        sparseArray3.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                        sparseArray3.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                        sparseArray3.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray3.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                        sparseArray3.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                        sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                        sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                        sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                        sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        gVar3.eVl.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((va(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, this.mme.getString(R.string.report_text), this.lRX);
                            gVar4.eVl.setTag(str);
                            arrayList.add(gVar4);
                        }
                    }
                    com.baidu.tbadk.core.dialog.g gVar5 = null;
                    if (z4) {
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_should_manage_visible, true);
                        sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                        sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                        sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                        sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                        if (z5) {
                            sparseArray4.put(R.id.tag_user_mute_visible, true);
                            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                        } else {
                            sparseArray4.put(R.id.tag_user_mute_visible, false);
                        }
                        if (z6) {
                            sparseArray4.put(R.id.tag_should_delete_visible, true);
                            sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                            sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mme.getString(R.string.delete), this.lRX);
                            gVar5.eVl.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new com.baidu.tbadk.core.dialog.g(7, this.mme.getString(R.string.bar_manager), this.lRX);
                        gVar.eVl.setTag(sparseArray4);
                    } else {
                        if (z6) {
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.tag_should_manage_visible, false);
                            sparseArray5.put(R.id.tag_user_mute_visible, false);
                            sparseArray5.put(R.id.tag_should_delete_visible, true);
                            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            if (this.mme.dmx().getPbData().dlv() == 1002 && !z) {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mme.getString(R.string.report_text), this.lRX);
                            } else {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mme.getString(R.string.delete), this.lRX);
                            }
                            gVar5.eVl.setTag(sparseArray5);
                        }
                        gVar = null;
                    }
                    if (gVar5 != null) {
                        arrayList.add(gVar5);
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                this.lRX.bw(arrayList);
                this.lRW = new com.baidu.tbadk.core.dialog.i(this.mme.getPageContext(), this.lRX);
                this.lRW.QE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.feF == null) {
                this.feF = new com.baidu.tbadk.core.message.a();
            }
            if (this.fep == null) {
                this.fep = new e();
                this.fep.uniqueId = this.mme.getUniqueId();
            }
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eMa = 5;
            eVar.eMg = 8;
            eVar.eMf = 2;
            if (this.mme != null && this.mme.dmx() != null) {
                eVar.eMe = this.mme.dmx().dpl();
            }
            if (eVar != null) {
                eVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (eVar != null) {
                        eVar.eMh = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (eVar != null) {
                        eVar.eMh = 1;
                        i = 0;
                    }
                }
                this.feF.a(agreeData, i, this.mme.getUniqueId(), false);
                this.feF.a(agreeData, this.fep);
                if (this.mme == null && this.mme.dmx() != null && this.mme.dmx().getPbData() != null) {
                    this.feF.a(this.mme.doh(), eVar, agreeData, this.mme.dmx().getPbData().dlg());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (eVar != null) {
                eVar.eMh = 1;
            }
            i = 0;
            this.feF.a(agreeData, i, this.mme.getUniqueId(), false);
            this.feF.a(agreeData, this.fep);
            if (this.mme == null) {
            }
        }
    }

    public void a(final b.InterfaceC0558b interfaceC0558b, boolean z) {
        if (this.lZC != null) {
            this.lZC.dismiss();
            this.lZC = null;
        }
        k kVar = new k(this.mme.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.mme.dmx().getPbData() != null && this.mme.dmx().getPbData().dlg() != null && !this.mme.dmx().getPbData().dlg().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.mme.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.mme.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bw(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lZC.dismiss();
                interfaceC0558b.a(null, i, view);
            }
        });
        this.lZC = new com.baidu.tbadk.core.dialog.i(this.mme.getPageContext(), kVar);
        this.lZC.QE();
    }

    public void aZ(ArrayList<al> arrayList) {
        if (this.lZx == null) {
            this.lZx = LayoutInflater.from(this.mme.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.mme.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lZx);
        if (this.lZw == null) {
            this.lZw = new Dialog(this.mme.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lZw.setCanceledOnTouchOutside(true);
            this.lZw.setCancelable(true);
            this.lZF = (ScrollView) this.lZx.findViewById(R.id.good_scroll);
            this.lZw.setContentView(this.lZx);
            WindowManager.LayoutParams attributes = this.lZw.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lZw.getWindow().setAttributes(attributes);
            this.izI = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.lZB = (String) compoundButton.getTag();
                        if (a.this.izH != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.izH) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.lZB != null && !str.equals(a.this.lZB)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lZy = (LinearLayout) this.lZx.findViewById(R.id.good_class_group);
            this.lZA = (TextView) this.lZx.findViewById(R.id.dialog_button_cancel);
            this.lZA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lZw instanceof Dialog) {
                        g.b(a.this.lZw, a.this.mme.getPageContext());
                    }
                }
            });
            this.lZz = (TextView) this.lZx.findViewById(R.id.dialog_button_ok);
            this.lZz.setOnClickListener(this.mme.duc());
        }
        this.lZy.removeAllViews();
        this.izH = new ArrayList();
        CustomBlueCheckRadioButton fU = fU("0", this.mme.getPageContext().getString(R.string.thread_good_class));
        this.izH.add(fU);
        fU.setChecked(true);
        this.lZy.addView(fU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                al alVar = arrayList.get(i2);
                if (alVar != null && !TextUtils.isEmpty(alVar.bmb()) && alVar.bmc() > 0) {
                    CustomBlueCheckRadioButton fU2 = fU(String.valueOf(alVar.bmc()), alVar.bmb());
                    this.izH.add(fU2);
                    View view = new View(this.mme.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lZy.addView(view);
                    this.lZy.addView(fU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lZF.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.mme.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.mme.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.mme.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lZF.setLayoutParams(layoutParams2);
            this.lZF.removeAllViews();
            if (this.lZy != null && this.lZy.getParent() == null) {
                this.lZF.addView(this.lZy);
            }
        }
        g.a(this.lZw, this.mme.getPageContext());
    }

    private CustomBlueCheckRadioButton fU(String str, String str2) {
        Activity pageActivity = this.mme.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.izI);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean dG(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lSm;
        userMuteCheckCustomMessage.setTag(this.lSm);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void drm() {
        if (this.lZu != null) {
            this.lZu.dismiss();
        }
        if (this.lZv != null) {
            g.b(this.lZv, this.mme.getPageContext());
        }
        if (this.lZw != null) {
            g.b(this.lZw, this.mme.getPageContext());
        }
        if (this.lZt != null) {
            this.lZt.dismiss();
        }
    }

    public void duT() {
        if (this.lRW != null) {
            this.lRW.dismiss();
        }
    }

    public void drl() {
        baM();
        this.mme.dqo();
        if (this.lRW != null) {
            this.lRW.dismiss();
        }
        drm();
    }

    public void drk() {
        baM();
        this.mme.dqo();
        if (this.lRW != null) {
            this.lRW.dismiss();
        }
        this.mme.cDc();
        drm();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener due() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b duU() {
        return this.lRp;
    }

    public void setPhoneNumber(String str) {
        this.lNs = str;
    }

    public String dqQ() {
        return this.lZB;
    }

    public View dqP() {
        if (this.lZx != null) {
            return this.lZx.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
