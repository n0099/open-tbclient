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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
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
    public static int lQZ = 3;
    public static int lRa = 0;
    public static int lRb = 3;
    public static int lRc = 4;
    public static int lRd = 5;
    public static int lRe = 6;
    private at eGK;
    private e fbZ;
    private com.baidu.tbadk.core.message.a fcq;
    private List<CustomBlueCheckRadioButton> itJ;
    private f jJX;
    private String lEo;
    private com.baidu.tieba.pb.pb.report.a lID;
    private i lIK;
    private k lIL;
    private boolean lIa;
    public BdUniqueId lJa;
    private com.baidu.adp.widget.ImageView.a lJc;
    private String lJd;
    private TbRichTextMemeInfo lJe;
    private PbFragment.b lRM;
    private com.baidu.tieba.NEGFeedBack.i lRy;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    public VideoPbFragment mcN;
    private Runnable runnable;
    private i lQr = null;
    private com.baidu.tbadk.core.dialog.a lQj = null;
    private Dialog lQk = null;
    private Dialog lQl = null;
    private View lQm = null;
    private LinearLayout lQn = null;
    private TextView lQo = null;
    private TextView lQp = null;
    private String lQq = null;
    private ScrollView lQu = null;
    private CompoundButton.OnCheckedChangeListener itK = null;
    private i lQi = null;
    private com.baidu.tbadk.core.view.a ixW = null;
    private com.baidu.tbadk.core.dialog.b lIg = null;
    private AlertDialog lWm = null;
    private ac lWn = null;
    PostData khK = null;
    private boolean lIB = d.biM();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return a.this.dT(view);
        }
    };
    private k.c lJD = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.lIK != null) {
                a.this.lIK.dismiss();
            }
            a.this.Fo(i);
            switch (i) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    a.this.dF(view2);
                    view2.performClick();
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    a.this.dF(view3);
                    view3.performClick();
                    return;
                case -2:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (d.biX() || d.biY()) {
                        View view4 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_2);
                        a.this.dF(view4);
                        ((AgreeView) view4).getImgDisagree().performClick();
                        return;
                    }
                    View view5 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_1);
                    a.this.dF(view5);
                    ((AgreeView) view5).getImgDisagree().performClick();
                    return;
                case -1:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (d.biX() || d.biY()) {
                        View view6 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_2);
                        a.this.dF(view6);
                        ((AgreeView) view6).getImgAgree().performClick();
                        return;
                    }
                    View view7 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_1);
                    a.this.dF(view7);
                    ((AgreeView) view7).getImgAgree().performClick();
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (a.this.lJc != null && !TextUtils.isEmpty(a.this.lJd)) {
                        if (a.this.lJe == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lJd));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.lJd;
                            aVar.pkgId = a.this.lJe.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lJe.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.lJc = null;
                        a.this.lJd = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.lJc != null && !TextUtils.isEmpty(a.this.lJd)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.mcN.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mcN.getPageContext().getPageActivity())) {
                            if (a.this.eGK == null) {
                                a.this.eGK = new at(a.this.mcN.getPageContext());
                            }
                            a.this.eGK.p(a.this.lJd, a.this.lJc.getImageByte());
                            a.this.lJc = null;
                            a.this.lJd = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.khK != null) {
                        a.this.khK.gT(a.this.mcN.getPageContext().getPageActivity());
                        a.this.khK = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new aq("c11739").an("obj_locate", 2));
                    if (a.this.mcN.checkUpIsLogin()) {
                        a.this.dG(view);
                        if (a.this.mcN.dkd().getPbData().diN() != null && a.this.mcN.dkd().getPbData().diN().bnx() != null && a.this.mcN.dkd().getPbData().diN().bnx().getUserId() != null && a.this.mcN.drH() != null) {
                            int h = a.this.h(a.this.mcN.dkd().getPbData());
                            bz diN = a.this.mcN.dkd().getPbData().diN();
                            if (diN.bme()) {
                                i2 = 2;
                            } else if (diN.bmf()) {
                                i2 = 3;
                            } else if (diN.bpv()) {
                                i2 = 4;
                            } else {
                                i2 = diN.bpw() ? 5 : 1;
                            }
                            TiebaStatic.log(new aq("c12526").dW("tid", a.this.mcN.dkd().dme()).an("obj_locate", 2).dW("obj_id", a.this.mcN.dkd().getPbData().diN().bnx().getUserId()).an("obj_type", a.this.mcN.drH().bjE() ? 0 : 1).an("obj_source", h).an("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.mcN.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new aq("c13079"));
                        a.this.OC((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new aq("c11739").an("obj_locate", 4));
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
                        a.this.mcN.showToast(R.string.network_not_available);
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
                            a.this.dN(view);
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
                    if (bg.checkUpIsLogin(a.this.mcN.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bpr() != null) {
                            c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                            if (bV != null) {
                                postData.bpr().objSource = bV.getCurrentPageKey();
                            }
                            a.this.d(postData.bpr());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    private final b.InterfaceC0561b lJR = new b.InterfaceC0561b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.lJc != null && !TextUtils.isEmpty(a.this.lJd)) {
                if (i == 0) {
                    if (a.this.lJe == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lJd));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.lJd;
                        aVar.pkgId = a.this.lJe.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lJe.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.mcN.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mcN.getPageContext().getPageActivity())) {
                        if (a.this.eGK == null) {
                            a.this.eGK = new at(a.this.mcN.getPageContext());
                        }
                        a.this.eGK.p(a.this.lJd, a.this.lJc.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.lJc = null;
                a.this.lJd = null;
            }
        }
    };

    public void dlh() {
        com.baidu.tieba.pb.data.f pbData;
        bz diN;
        boolean z = true;
        if (this.mcN != null && this.mcN.dkd() != null && this.mcN.dkd().getPbData() != null && (diN = (pbData = this.mcN.dkd().getPbData()).diN()) != null && diN.bnx() != null) {
            this.mcN.dnT();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), diN.bnx().getUserId());
            ad adVar = new ad();
            int djc = this.mcN.dkd().getPbData().djc();
            if (djc == 1 || djc == 3) {
                adVar.lNZ = true;
                adVar.lOf = diN.bns() == 1;
            } else {
                adVar.lNZ = false;
            }
            if (Fq(djc)) {
                adVar.lOa = true;
                adVar.lOe = diN.bnt() == 1;
            } else {
                adVar.lOa = false;
            }
            if (djc == 1002 && !equals) {
                adVar.lOg = true;
            }
            adVar.lNX = uM(equals);
            adVar.lOb = dli();
            adVar.lNY = uN(equals);
            adVar.FD = this.mcN.dkd().dmg();
            adVar.lNU = true;
            adVar.lNT = uL(equals);
            adVar.lOd = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lOc = true;
            adVar.isHostOnly = this.mcN.dkd().getHostMode();
            adVar.lNW = true;
            if (diN.bnO() == null) {
                adVar.lNV = true;
            } else {
                adVar.lNV = false;
            }
            if (pbData.djq()) {
                adVar.lNU = false;
                adVar.lNW = false;
                adVar.lNV = false;
                adVar.lNZ = false;
                adVar.lOa = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.djq()) {
                z = false;
            }
            adVar.lOh = z;
            a(adVar);
        }
    }

    public boolean Fq(int i) {
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
        if (!z || this.mcN.dkd().getPbData().getUserData() == null || (forumToolAuth = this.mcN.dkd().getPbData().getUserData().getForumToolAuth()) == null) {
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

    private boolean uM(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ac acVar;
        if (this.mcN == null || this.mcN.dkd() == null || this.mcN.dkd().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.mcN.dkd().getPbData();
        if (pbData.getUserData() == null || !pbData.getUserData().isForumBusinessAccount() || au.isOn()) {
            bz diN = pbData.diN();
            if (diN != null) {
                if (diN.bme() || diN.bmf()) {
                    return false;
                }
                if (diN.bpv() || diN.bpw()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.djc() != 0) {
                    return pbData.djc() != 3;
                }
                List<bv> djk = pbData.djk();
                if (x.getCount(djk) > 0) {
                    for (bv bvVar : djk) {
                        if (bvVar != null && (acVar = bvVar.eNA) != null && acVar.eLk && !acVar.eLl && (acVar.type == 1 || acVar.type == 2)) {
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

    private boolean uN(boolean z) {
        if (z || this.mcN == null || this.mcN.dkd() == null || this.mcN.dkd().getPbData() == null) {
            return false;
        }
        return ((this.mcN.dkd().getPbData().getForum() != null && this.mcN.dkd().getPbData().getForum().isBlockBawuDelete) || this.mcN.dkd().getPbData().djc() == 0 || this.mcN.dkd().getPbData().djc() == 3) ? false : true;
    }

    private boolean dli() {
        if (this.mcN == null || this.mcN.dkd() == null || !this.mcN.dkd().dmg()) {
            return false;
        }
        return this.mcN.dkd().getPageData() == null || this.mcN.dkd().getPageData().bmn() != 0;
    }

    public void a(ad adVar) {
        if (!this.mcN.getBaseFragmentActivity().isProgressBarShown()) {
            this.lWn = new ac(this.mcN, this.mcN.aCu);
            this.lWm = new AlertDialog.Builder(this.mcN.getContext(), R.style.DialogTheme).create();
            this.lWm.setCanceledOnTouchOutside(true);
            g.showDialog(this.lWm, this.mcN.getFragmentActivity());
            Window window = this.lWm.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lWn.getView());
            this.lWn.vb(adVar == null ? false : adVar.lNT);
            this.lWn.vc(adVar == null ? false : adVar.lNX);
            this.lWn.vd(adVar == null ? false : adVar.lOb);
            this.lWn.vf(adVar == null ? false : adVar.lNY);
            this.lWn.vg(adVar == null ? true : adVar.lNV);
            if (adVar == null) {
                this.lWn.aq(false, false);
                this.lWn.ar(false, false);
            } else {
                this.lWn.aq(adVar.lNZ, adVar.lOf);
                this.lWn.ar(adVar.lOa, adVar.lOe);
            }
            boolean z = adVar == null ? false : adVar.FD;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lNW;
            boolean z4 = adVar == null ? false : adVar.lNU;
            boolean z5 = adVar == null ? false : adVar.lOd;
            boolean z6 = adVar == null ? false : adVar.lOc;
            this.lWn.ap(z3, z2);
            this.lWn.as(z4, z);
            this.lWn.at(z6, z5);
            if (adVar != null) {
                this.lWn.lNQ = adVar.lOg;
                if (adVar.lOg) {
                    this.lWn.dnu().setText(R.string.report_text);
                    this.lWn.vf(false);
                }
            }
            this.lWn.ve(adVar != null ? adVar.lOh : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.mcN.dkd() != null && this.mcN.dkd().getPbData() != null && this.mcN.dkd().getPbData().getThreadId() != null && this.mcN.dkd().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lWn.dnx().setText(R.string.have_called_fans_short);
            }
            dpV();
        }
    }

    private void dpV() {
        if (this.lWn != null) {
            this.lWn.dnB();
        }
    }

    public void baz() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.lWm != null) {
                        g.dismissDialog(a.this.lWm, a.this.mcN.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mB().postDelayed(this.runnable, 100L);
    }

    public void dpW() {
        if (this.lWm != null) {
            g.dismissDialog(this.lWm, this.mcN.getPageContext().getPageActivity());
        }
    }

    public ac dpX() {
        return this.lWn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dT(View view) {
        boolean z;
        boolean z2;
        List<com.baidu.tbadk.core.dialog.g> list;
        com.baidu.tbadk.core.dialog.g gVar;
        SparseArray sparseArray;
        if (this.mcN == null || !this.mcN.isAdded()) {
            return true;
        }
        SparseArray sparseArray2 = null;
        try {
            sparseArray2 = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        if (sparseArray2 == null) {
            if (dI(view)) {
                if (view instanceof TbImageView) {
                    this.lJc = ((TbImageView) view).getBdImage();
                    this.lJd = ((TbImageView) view).getUrl();
                    if (this.lJc == null || TextUtils.isEmpty(this.lJd)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lJe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lJe = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lJc = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lJd = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lJe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lJe = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lJc = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lJd = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lJe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lJe = null;
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
                    a(this.lJR, this.lJc.isGif());
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
        this.khK = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.khK == null || this.mcN.drH() == null) {
            return true;
        }
        if (!this.mcN.drH().bjE() || this.khK.getId() == null || !this.khK.getId().equals(this.mcN.dkd().bnF())) {
            z = false;
        } else {
            z = true;
        }
        boolean z3 = this.mcN.dkd().getPbData() != null && this.mcN.dkd().getPbData().djq();
        if (this.lIL == null) {
            this.lIL = new k(this.mcN.getContext());
            this.lIL.a(this.lJD);
        }
        ArrayList arrayList = new ArrayList();
        if (view != null && sparseArray2 != null) {
            boolean z4 = dI(view) && !z3;
            boolean z5 = (!dI(view) || this.lJc == null || this.lJc.isGif()) ? false : true;
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
                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.lIL));
            }
            if (z5) {
                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.lIL));
            }
            if (!z4 && !z5) {
                com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.lIL);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.khK);
                gVar2.eSW.setTag(sparseArray3);
                arrayList.add(gVar2);
            }
            if (!z2 && !z3) {
                if (z) {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.lIL);
                } else {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.lIL);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.khK);
                sparseArray4.put(R.id.tag_is_subpb, false);
                gVar.eSW.setTag(sparseArray4);
                arrayList.add(gVar);
            }
            if (TbadkCoreApplication.isLogin() && !this.lIB) {
                if (!z8 && z7) {
                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.lIL);
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
                    gVar3.eSW.setTag(sparseArray5);
                    arrayList.add(gVar3);
                } else {
                    if ((uL(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lIL);
                        gVar4.eSW.setTag(str);
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
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lIL);
                        gVar6.eSW.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                    }
                    gVar5 = new com.baidu.tbadk.core.dialog.g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.lIL);
                    gVar5.eSW.setTag(sparseArray6);
                } else if (z10) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_should_manage_visible, false);
                    sparseArray7.put(R.id.tag_user_mute_visible, false);
                    sparseArray7.put(R.id.tag_should_delete_visible, true);
                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                    sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                    if (this.mcN.dkd().getPbData().djc() == 1002 && !z6) {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lIL);
                    } else {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lIL);
                    }
                    gVar6.eSW.setTag(sparseArray7);
                }
                if (gVar6 != null) {
                    arrayList.add(gVar6);
                }
                if (gVar5 != null) {
                    arrayList.add(gVar5);
                }
            }
            if (com.baidu.tbadk.a.d.bja()) {
                list = com.baidu.tieba.pb.pb.main.d.a.fs(com.baidu.tieba.pb.pb.main.d.a.w(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.khK.bpr(), sparseArray2, this.lIL), this.lIa));
                this.lIL.a(com.baidu.tieba.pb.pb.main.d.a.t(this.khK));
            } else {
                list = arrayList;
            }
            this.lIL.k(list, true);
            this.lIK = new i(this.mcN.getPageContext(), this.lIL);
            this.lIK.Pd();
            TiebaStatic.log(new aq("c13272").dW("tid", this.mcN.dkd().dme()).dW("fid", this.mcN.dkd().getForumId()).dW("uid", this.mcN.dkd().getPbData().diN().bnx().getUserId()).dW("post_id", this.mcN.dkd().bBr()).an("obj_source", z2 ? 2 : 1));
        }
        return true;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.mcN = videoPbFragment;
        this.lJa = videoPbFragment.getUniqueId();
        this.lID = new com.baidu.tieba.pb.pb.report.a(this.mcN.getContext());
        this.lID.w(this.mcN.getUniqueId());
        this.lRM = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.17
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.mcN.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.mcN.dkd().getPbData().getUserData().getUserId());
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
                a.this.mcN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.mcN.getPageContext().getPageActivity(), a.this.mcN.dkd().getPbData().getForum().getId(), a.this.mcN.dkd().getPbData().getForum().getName(), a.this.mcN.dkd().getPbData().diN().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fo(int i) {
        TiebaStatic.log(new aq("c14000").dW("tid", this.mcN.dkd().dme()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.FR(i))));
    }

    public void wd(boolean z) {
        this.lIa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lIa ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dG(View view) {
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
            if (postData.getId() != null && postData.getId().equals(this.mcN.dkd().bnF())) {
                z = true;
            }
            MarkData o = this.mcN.dkd().o(postData);
            if (this.mcN.dkd().getPbData() != null && this.mcN.dkd().getPbData().djq() && (L = this.mcN.L(this.mcN.dkd().getPbData())) != null) {
                o = this.mcN.dkd().o(L);
            }
            if (o != null) {
                this.mcN.dow();
                if (this.mcN.drH() != null) {
                    this.mcN.drH().a(o);
                    if (!z) {
                        this.mcN.drH().bjG();
                    } else {
                        this.mcN.drH().bjF();
                    }
                }
            }
        }
    }

    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.diN() != null) {
            if (fVar.diN().getThreadType() == 0) {
                return 1;
            }
            if (fVar.diN().getThreadType() == 54) {
                return 2;
            }
            if (fVar.diN().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    private boolean uL(boolean z) {
        if (this.mcN.dkd() == null || this.mcN.dkd().getPbData() == null) {
            return false;
        }
        return ((this.mcN.dkd().getPbData().djc() != 0) || this.mcN.dkd().getPbData().diN() == null || this.mcN.dkd().getPbData().diN().bnx() == null || TextUtils.equals(this.mcN.dkd().getPbData().diN().bnx().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void OC(String str) {
        if (this.mcN.dkd() != null && this.mcN.dkd().getPbData() != null && this.mcN.dkd().getPbData().djq()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mcN.dkd().dme(), str);
            bz diN = this.mcN.dkd().getPbData().diN();
            if (diN.bme()) {
                format = format + "&channelid=33833";
            } else if (diN.bpu()) {
                format = format + "&channelid=33842";
            } else if (diN.bmf()) {
                format = format + "&channelid=33840";
            }
            OD(format);
            return;
        }
        this.lID.Pd(str);
    }

    private void OD(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.mcN.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lIK != null && this.lIK.isShowing()) {
                this.lIK.dismiss();
                this.lIK = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.mcN.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.19
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.lIK != null) {
                            a.this.lIK.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.lJa);
                            userMuteAddAndDelCustomMessage.setTag(a.this.lJa);
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
                kVar.bB(arrayList);
                this.lIK = new i(this.mcN.getPageContext(), kVar);
                this.lIK.Pd();
            }
        }
    }

    public void dlD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mcN.getPageContext().getPageActivity());
        aVar.Ad(this.mcN.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.mcN.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.mcN.getPageContext()).bqe();
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
        sparseArray.put(lRa, Integer.valueOf(lRb));
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
        this.lQj = new com.baidu.tbadk.core.dialog.a(this.mcN.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lQj.nu(i3);
        } else {
            this.lQj.setOnlyMessageShowCenter(false);
            this.lQj.Ad(str2);
        }
        this.lQj.setYesButtonTag(sparseArray);
        this.lQj.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.23
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.mcN.a(aVar, (JSONArray) null);
            }
        });
        this.lQj.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lQj.jD(true);
        this.lQj.b(this.mcN.getPageContext());
        if (z) {
            this.lQj.bqe();
        } else if (doq()) {
            h hVar = new h(this.mcN.dkd().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.mcN.dkd().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.mcN.dkd().getPbData().djw().has_forum_rule.intValue());
            hVar.ei(this.mcN.dkd().getPbData().getForum().getId(), this.mcN.dkd().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.mcN.dkd().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.mcN.dkd().getPbData().getForum().getUser_level());
            a(this.lQj, i, hVar, this.mcN.dkd().getPbData().getUserData());
        } else {
            a(this.lQj, i);
        }
    }

    private boolean doq() {
        if (this.mcN == null || this.mcN.dkd().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.mcN.dkd().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.mcN != null && aVar != null) {
            if (this.jJX == null && this.mcN.getView() != null) {
                this.jJX = new f(this.mcN.getPageContext(), this.mcN.getView());
            }
            AntiData cAh = cAh();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cAh != null && cAh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cAh.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.jJX.setDefaultReasonArray(new String[]{this.mcN.getString(R.string.delete_thread_reason_1), this.mcN.getString(R.string.delete_thread_reason_2), this.mcN.getString(R.string.delete_thread_reason_3), this.mcN.getString(R.string.delete_thread_reason_4), this.mcN.getString(R.string.delete_thread_reason_5)});
            this.jJX.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jJX.DV(str);
            this.jJX.a(new f.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    a.this.mcN.a(aVar, jSONArray);
                }
            });
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, h hVar, UserData userData) {
        String str;
        if (this.mcN != null && aVar != null) {
            if (this.lRy == null && this.mcN.getView() != null) {
                this.lRy = new com.baidu.tieba.NEGFeedBack.i(this.mcN.getPageContext(), this.mcN.getView(), hVar, userData);
            }
            AntiData cAh = cAh();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cAh != null && cAh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cAh.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.lRy.setDefaultReasonArray(new String[]{this.mcN.getString(R.string.delete_thread_reason_1), this.mcN.getString(R.string.delete_thread_reason_2), this.mcN.getString(R.string.delete_thread_reason_3), this.mcN.getString(R.string.delete_thread_reason_4), this.mcN.getString(R.string.delete_thread_reason_5)});
            this.lRy.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.lRy.DV(str);
            this.lRy.a(new i.b() { // from class: com.baidu.tieba.pb.videopb.b.a.4
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    a.this.mcN.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cAh() {
        if (this.mcN.dkd() == null || this.mcN.dkd().getPbData() == null) {
            return null;
        }
        return this.mcN.dkd().getPbData().getAnti();
    }

    public void dN(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        k kVar = new k(this.mcN.getContext());
        kVar.setTitleText(this.mcN.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.5
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lQi.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (a.this.lRM != null) {
                                a.this.lRM.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mcN.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mcN.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eSW.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.mcN.getString(R.string.forbidden_person), kVar);
            gVar3.eSW.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mcN.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mcN.getString(R.string.mute), kVar);
            }
            gVar.eSW.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.bB(arrayList);
        if (this.lQi == null) {
            this.lQi = new com.baidu.tbadk.core.dialog.i(this.mcN.getPageContext(), kVar);
        } else {
            this.lQi.a(kVar);
        }
        this.lQi.Pd();
    }

    public void dla() {
        if (this.lIg == null) {
            this.lIg = new com.baidu.tbadk.core.dialog.b(this.mcN.getPageContext().getPageActivity());
            this.lIg.a(new String[]{this.mcN.getPageContext().getString(R.string.call_phone), this.mcN.getPageContext().getString(R.string.sms_phone), this.mcN.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0561b() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.mcN.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.lEo = a.this.lEo.trim();
                        UtilHelper.callPhone(a.this.mcN.getPageContext().getPageActivity(), a.this.lEo);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mcN.dkd().dme(), a.this.lEo, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.mcN.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.lEo = a.this.lEo.trim();
                        UtilHelper.smsPhone(a.this.mcN.getPageContext().getPageActivity(), a.this.lEo);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mcN.dkd().dme(), a.this.lEo, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.lEo = a.this.lEo.trim();
                        UtilHelper.startBaiDuBar(a.this.mcN.getPageContext().getPageActivity(), a.this.lEo);
                        bVar.dismiss();
                    }
                }
            }).nA(b.a.BOTTOM_TO_TOP).nB(17).d(this.mcN.getPageContext());
        }
    }

    public void dU(final View view) {
        String[] strArr;
        int i = 0;
        if (this.mcN != null && this.mcN.dkd() != null) {
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mcN.getPageContext());
            if (this.mcN.dkd().getPbData().lBl == null || this.mcN.dkd().getPbData().lBl.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.mcN.dkd().getPbData().lBl.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mcN.dkd().getPbData().lBl.size()) {
                        break;
                    }
                    strArr2[i2] = this.mcN.dkd().getPbData().lBl.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.mcN.dkd().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.mcN.dkd().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.mcN.dkd().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.mcN.dkd().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new aq("c12097").an("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).an("obj_type", i4));
                    if (a.this.mcN.dkd().getPbData().lBl != null && a.this.mcN.dkd().getPbData().lBl.size() > i3) {
                        i3 = a.this.mcN.dkd().getPbData().lBl.get(i3).sort_type.intValue();
                    }
                    boolean FB = a.this.mcN.dkd().FB(i3);
                    view.setTag(Integer.valueOf(a.this.mcN.dkd().dmy()));
                    if (FB) {
                        a.this.mcN.setIsLoading(true);
                    }
                }
            });
            iVar.Pd();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mcN.getActivity());
            aVar.Ac(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Ad(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jD(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dW("obj_id", metaData.getUserId()).an("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dW("obj_id", metaData.getUserId()).an("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.mcN.drS() != null) {
                        a.this.mcN.drS().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.mcN.getPageContext().getUniqueId(), a.this.mcN.dkd().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.mcN.getPageContext()).bqe();
            TiebaStatic.log(new aq("c12527"));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lJa);
        userMuteAddAndDelCustomMessage.setTag(this.lJa);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void CL(String str) {
        if (str == null) {
            str = "";
        }
        if (this.mcN != null && this.mcN.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mcN.getPageContext().getPageActivity());
            aVar.Ad(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mcN.getPageContext()).bqe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mcN.getBaseFragmentActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.Ad(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Ad(str);
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
        aVar.b(this.mcN.getPageContext()).bqe();
    }

    public void showLoadingDialog() {
        if (this.ixW == null) {
            this.ixW = new com.baidu.tbadk.core.view.a(this.mcN.getPageContext());
        }
        this.ixW.setDialogVisiable(true);
    }

    public void cjr() {
        if (this.ixW != null) {
            this.ixW.setDialogVisiable(false);
        }
    }

    public void i(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        com.baidu.tbadk.core.dialog.g gVar;
        if (this.mcN != null && this.mcN.dkd() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.lIL == null) {
                this.lIL = new k(this.mcN.getContext());
                this.lIL.a(this.lJD);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.mcN.dkd().getPbData() != null && this.mcN.dkd().getPbData().djq();
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
                if (postData.bpr() != null) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(8, (postData.bpr().hasAgree && postData.bpb() == 5) ? this.mcN.getString(R.string.action_cancel_dislike) : this.mcN.getString(R.string.action_dislike), this.lIL);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.eSW.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, this.mcN.getString(R.string.mute_option), this.lIL);
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
                        gVar3.eSW.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((uL(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, this.mcN.getString(R.string.report_text), this.lIL);
                            gVar4.eSW.setTag(str);
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
                            gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mcN.getString(R.string.delete), this.lIL);
                            gVar5.eSW.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new com.baidu.tbadk.core.dialog.g(7, this.mcN.getString(R.string.bar_manager), this.lIL);
                        gVar.eSW.setTag(sparseArray4);
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
                            if (this.mcN.dkd().getPbData().djc() == 1002 && !z) {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mcN.getString(R.string.report_text), this.lIL);
                            } else {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mcN.getString(R.string.delete), this.lIL);
                            }
                            gVar5.eSW.setTag(sparseArray5);
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
                this.lIL.bB(arrayList);
                this.lIK = new com.baidu.tbadk.core.dialog.i(this.mcN.getPageContext(), this.lIL);
                this.lIK.Pd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.fcq == null) {
                this.fcq = new com.baidu.tbadk.core.message.a();
            }
            if (this.fbZ == null) {
                this.fbZ = new e();
                this.fbZ.uniqueId = this.mcN.getUniqueId();
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eJO = 5;
            dVar.eJU = 8;
            dVar.eJT = 2;
            if (this.mcN != null && this.mcN.dkd() != null) {
                dVar.eJS = this.mcN.dkd().dmP();
            }
            if (dVar != null) {
                dVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.eJV = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.eJV = 1;
                        i = 0;
                    }
                }
                this.fcq.a(agreeData, i, this.mcN.getUniqueId(), false);
                this.fcq.a(agreeData, this.fbZ);
                if (this.mcN == null && this.mcN.dkd() != null && this.mcN.dkd().getPbData() != null) {
                    this.fcq.a(this.mcN.dlL(), dVar, agreeData, this.mcN.dkd().getPbData().diN());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.eJV = 1;
            }
            i = 0;
            this.fcq.a(agreeData, i, this.mcN.getUniqueId(), false);
            this.fcq.a(agreeData, this.fbZ);
            if (this.mcN == null) {
            }
        }
    }

    public void a(final b.InterfaceC0561b interfaceC0561b, boolean z) {
        if (this.lQr != null) {
            this.lQr.dismiss();
            this.lQr = null;
        }
        k kVar = new k(this.mcN.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.mcN.dkd().getPbData() != null && this.mcN.dkd().getPbData().diN() != null && !this.mcN.dkd().getPbData().diN().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.mcN.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.mcN.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bB(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lQr.dismiss();
                interfaceC0561b.a(null, i, view);
            }
        });
        this.lQr = new com.baidu.tbadk.core.dialog.i(this.mcN.getPageContext(), kVar);
        this.lQr.Pd();
    }

    public void ba(ArrayList<ak> arrayList) {
        if (this.lQm == null) {
            this.lQm = LayoutInflater.from(this.mcN.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.mcN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lQm);
        if (this.lQl == null) {
            this.lQl = new Dialog(this.mcN.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lQl.setCanceledOnTouchOutside(true);
            this.lQl.setCancelable(true);
            this.lQu = (ScrollView) this.lQm.findViewById(R.id.good_scroll);
            this.lQl.setContentView(this.lQm);
            WindowManager.LayoutParams attributes = this.lQl.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lQl.getWindow().setAttributes(attributes);
            this.itK = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.lQq = (String) compoundButton.getTag();
                        if (a.this.itJ != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.itJ) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.lQq != null && !str.equals(a.this.lQq)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lQn = (LinearLayout) this.lQm.findViewById(R.id.good_class_group);
            this.lQp = (TextView) this.lQm.findViewById(R.id.dialog_button_cancel);
            this.lQp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lQl instanceof Dialog) {
                        g.b(a.this.lQl, a.this.mcN.getPageContext());
                    }
                }
            });
            this.lQo = (TextView) this.lQm.findViewById(R.id.dialog_button_ok);
            this.lQo.setOnClickListener(this.mcN.drI());
        }
        this.lQn.removeAllViews();
        this.itJ = new ArrayList();
        CustomBlueCheckRadioButton fU = fU("0", this.mcN.getPageContext().getString(R.string.thread_good_class));
        this.itJ.add(fU);
        fU.setChecked(true);
        this.lQn.addView(fU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ak akVar = arrayList.get(i2);
                if (akVar != null && !TextUtils.isEmpty(akVar.blJ()) && akVar.blK() > 0) {
                    CustomBlueCheckRadioButton fU2 = fU(String.valueOf(akVar.blK()), akVar.blJ());
                    this.itJ.add(fU2);
                    View view = new View(this.mcN.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ao.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lQn.addView(view);
                    this.lQn.addView(fU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lQu.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.mcN.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.mcN.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.mcN.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lQu.setLayoutParams(layoutParams2);
            this.lQu.removeAllViews();
            if (this.lQn != null && this.lQn.getParent() == null) {
                this.lQu.addView(this.lQn);
            }
        }
        g.a(this.lQl, this.mcN.getPageContext());
    }

    private CustomBlueCheckRadioButton fU(String str, String str2) {
        Activity pageActivity = this.mcN.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.itK);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean dI(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lJa;
        userMuteCheckCustomMessage.setTag(this.lJa);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void doR() {
        if (this.lQj != null) {
            this.lQj.dismiss();
        }
        if (this.lQk != null) {
            g.b(this.lQk, this.mcN.getPageContext());
        }
        if (this.lQl != null) {
            g.b(this.lQl, this.mcN.getPageContext());
        }
        if (this.lQi != null) {
            this.lQi.dismiss();
        }
    }

    public void dsz() {
        if (this.lIK != null) {
            this.lIK.dismiss();
        }
    }

    public void doQ() {
        baz();
        this.mcN.dnT();
        if (this.lIK != null) {
            this.lIK.dismiss();
        }
        doR();
    }

    public void doP() {
        baz();
        this.mcN.dnT();
        if (this.lIK != null) {
            this.lIK.dismiss();
        }
        this.mcN.cBJ();
        doR();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener drK() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b dsA() {
        return this.lIg;
    }

    public void setPhoneNumber(String str) {
        this.lEo = str;
    }

    public String dov() {
        return this.lQq;
    }

    public View dou() {
        if (this.lQm != null) {
            return this.lQm.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
