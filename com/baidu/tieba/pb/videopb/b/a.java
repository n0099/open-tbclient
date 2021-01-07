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
    public static int lVD = 3;
    public static int lVE = 0;
    public static int lVF = 3;
    public static int lVG = 4;
    public static int lVH = 5;
    public static int lVI = 6;
    private at eLv;
    private e fgI;
    private com.baidu.tbadk.core.message.a fgY;
    private List<CustomBlueCheckRadioButton> iyq;
    private f jOD;
    private String lIT;
    private boolean lME;
    public BdUniqueId lNE;
    private com.baidu.adp.widget.ImageView.a lNG;
    private String lNH;
    private TbRichTextMemeInfo lNI;
    private com.baidu.tieba.pb.pb.report.a lNh;
    private i lNo;
    private k lNp;
    private com.baidu.tieba.NEGFeedBack.i lWc;
    private PbFragment.b lWq;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    public VideoPbFragment mhs;
    private Runnable runnable;
    private i lUV = null;
    private com.baidu.tbadk.core.dialog.a lUN = null;
    private Dialog lUO = null;
    private Dialog lUP = null;
    private View lUQ = null;
    private LinearLayout lUR = null;
    private TextView lUS = null;
    private TextView lUT = null;
    private String lUU = null;
    private ScrollView lUY = null;
    private CompoundButton.OnCheckedChangeListener iyr = null;
    private i lUM = null;
    private com.baidu.tbadk.core.view.a iCD = null;
    private com.baidu.tbadk.core.dialog.b lMK = null;
    private AlertDialog maT = null;
    private ac maU = null;
    PostData kmq = null;
    private boolean lNf = d.bmG();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return a.this.dT(view);
        }
    };
    private k.c lOh = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.lNo != null) {
                a.this.lNo.dismiss();
            }
            a.this.GU(i);
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
                    if (d.bmR() || d.bmS()) {
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
                    if (d.bmR() || d.bmS()) {
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
                    if (a.this.lNG != null && !TextUtils.isEmpty(a.this.lNH)) {
                        if (a.this.lNI == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lNH));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.lNH;
                            aVar.pkgId = a.this.lNI.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lNI.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.lNG = null;
                        a.this.lNH = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.lNG != null && !TextUtils.isEmpty(a.this.lNH)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.mhs.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mhs.getPageContext().getPageActivity())) {
                            if (a.this.eLv == null) {
                                a.this.eLv = new at(a.this.mhs.getPageContext());
                            }
                            a.this.eLv.p(a.this.lNH, a.this.lNG.getImageByte());
                            a.this.lNG = null;
                            a.this.lNH = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.kmq != null) {
                        a.this.kmq.gV(a.this.mhs.getPageContext().getPageActivity());
                        a.this.kmq = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new aq("c11739").an("obj_locate", 2));
                    if (a.this.mhs.checkUpIsLogin()) {
                        a.this.dG(view);
                        if (a.this.mhs.dnW().getPbData().dmF() != null && a.this.mhs.dnW().getPbData().dmF().brr() != null && a.this.mhs.dnW().getPbData().dmF().brr().getUserId() != null && a.this.mhs.dvz() != null) {
                            int h = a.this.h(a.this.mhs.dnW().getPbData());
                            bz dmF = a.this.mhs.dnW().getPbData().dmF();
                            if (dmF.bpY()) {
                                i2 = 2;
                            } else if (dmF.bpZ()) {
                                i2 = 3;
                            } else if (dmF.btp()) {
                                i2 = 4;
                            } else {
                                i2 = dmF.btq() ? 5 : 1;
                            }
                            TiebaStatic.log(new aq("c12526").dX("tid", a.this.mhs.dnW().dpX()).an("obj_locate", 2).dX("obj_id", a.this.mhs.dnW().getPbData().dmF().brr().getUserId()).an("obj_type", a.this.mhs.dvz().bny() ? 0 : 1).an("obj_source", h).an("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.mhs.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new aq("c13079"));
                        a.this.PJ((String) tag);
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
                        a.this.mhs.showToast(R.string.network_not_available);
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
                    if (bg.checkUpIsLogin(a.this.mhs.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.btl() != null) {
                            c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                            if (bV != null) {
                                postData.btl().objSource = bV.getCurrentPageKey();
                            }
                            a.this.d(postData.btl());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    private final b.InterfaceC0578b lOv = new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.lNG != null && !TextUtils.isEmpty(a.this.lNH)) {
                if (i == 0) {
                    if (a.this.lNI == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lNH));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.lNH;
                        aVar.pkgId = a.this.lNI.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lNI.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.mhs.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mhs.getPageContext().getPageActivity())) {
                        if (a.this.eLv == null) {
                            a.this.eLv = new at(a.this.mhs.getPageContext());
                        }
                        a.this.eLv.p(a.this.lNH, a.this.lNG.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.lNG = null;
                a.this.lNH = null;
            }
        }
    };

    public void dpa() {
        com.baidu.tieba.pb.data.f pbData;
        bz dmF;
        boolean z = true;
        if (this.mhs != null && this.mhs.dnW() != null && this.mhs.dnW().getPbData() != null && (dmF = (pbData = this.mhs.dnW().getPbData()).dmF()) != null && dmF.brr() != null) {
            this.mhs.drL();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dmF.brr().getUserId());
            ad adVar = new ad();
            int dmU = this.mhs.dnW().getPbData().dmU();
            if (dmU == 1 || dmU == 3) {
                adVar.lSD = true;
                adVar.lSJ = dmF.brm() == 1;
            } else {
                adVar.lSD = false;
            }
            if (GW(dmU)) {
                adVar.lSE = true;
                adVar.lSI = dmF.brn() == 1;
            } else {
                adVar.lSE = false;
            }
            if (dmU == 1002 && !equals) {
                adVar.lSK = true;
            }
            adVar.lSB = uQ(equals);
            adVar.lSF = dpb();
            adVar.lSC = uR(equals);
            adVar.FF = this.mhs.dnW().dpZ();
            adVar.lSy = true;
            adVar.lSx = uP(equals);
            adVar.lSH = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lSG = true;
            adVar.isHostOnly = this.mhs.dnW().getHostMode();
            adVar.lSA = true;
            if (dmF.brI() == null) {
                adVar.lSz = true;
            } else {
                adVar.lSz = false;
            }
            if (pbData.dni()) {
                adVar.lSy = false;
                adVar.lSA = false;
                adVar.lSz = false;
                adVar.lSD = false;
                adVar.lSE = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dni()) {
                z = false;
            }
            adVar.lSL = z;
            a(adVar);
        }
    }

    public boolean GW(int i) {
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
        if (!z || this.mhs.dnW().getPbData().getUserData() == null || (forumToolAuth = this.mhs.dnW().getPbData().getUserData().getForumToolAuth()) == null) {
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

    private boolean uQ(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ac acVar;
        if (this.mhs == null || this.mhs.dnW() == null || this.mhs.dnW().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.mhs.dnW().getPbData();
        if (pbData.getUserData() == null || !pbData.getUserData().isForumBusinessAccount() || au.isOn()) {
            bz dmF = pbData.dmF();
            if (dmF != null) {
                if (dmF.bpY() || dmF.bpZ()) {
                    return false;
                }
                if (dmF.btp() || dmF.btq()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dmU() != 0) {
                    return pbData.dmU() != 3;
                }
                List<bv> dnc = pbData.dnc();
                if (x.getCount(dnc) > 0) {
                    for (bv bvVar : dnc) {
                        if (bvVar != null && (acVar = bvVar.eSl) != null && acVar.ePV && !acVar.ePW && (acVar.type == 1 || acVar.type == 2)) {
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

    private boolean uR(boolean z) {
        if (z || this.mhs == null || this.mhs.dnW() == null || this.mhs.dnW().getPbData() == null) {
            return false;
        }
        return ((this.mhs.dnW().getPbData().getForum() != null && this.mhs.dnW().getPbData().getForum().isBlockBawuDelete) || this.mhs.dnW().getPbData().dmU() == 0 || this.mhs.dnW().getPbData().dmU() == 3) ? false : true;
    }

    private boolean dpb() {
        if (this.mhs == null || this.mhs.dnW() == null || !this.mhs.dnW().dpZ()) {
            return false;
        }
        return this.mhs.dnW().getPageData() == null || this.mhs.dnW().getPageData().bqh() != 0;
    }

    public void a(ad adVar) {
        if (!this.mhs.getBaseFragmentActivity().isProgressBarShown()) {
            this.maU = new ac(this.mhs, this.mhs.aHh);
            this.maT = new AlertDialog.Builder(this.mhs.getContext(), R.style.DialogTheme).create();
            this.maT.setCanceledOnTouchOutside(true);
            g.showDialog(this.maT, this.mhs.getFragmentActivity());
            Window window = this.maT.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.maU.getView());
            this.maU.vf(adVar == null ? false : adVar.lSx);
            this.maU.vg(adVar == null ? false : adVar.lSB);
            this.maU.vh(adVar == null ? false : adVar.lSF);
            this.maU.vj(adVar == null ? false : adVar.lSC);
            this.maU.vk(adVar == null ? true : adVar.lSz);
            if (adVar == null) {
                this.maU.aq(false, false);
                this.maU.ar(false, false);
            } else {
                this.maU.aq(adVar.lSD, adVar.lSJ);
                this.maU.ar(adVar.lSE, adVar.lSI);
            }
            boolean z = adVar == null ? false : adVar.FF;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lSA;
            boolean z4 = adVar == null ? false : adVar.lSy;
            boolean z5 = adVar == null ? false : adVar.lSH;
            boolean z6 = adVar == null ? false : adVar.lSG;
            this.maU.ap(z3, z2);
            this.maU.as(z4, z);
            this.maU.at(z6, z5);
            if (adVar != null) {
                this.maU.lSu = adVar.lSK;
                if (adVar.lSK) {
                    this.maU.drm().setText(R.string.report_text);
                    this.maU.vj(false);
                }
            }
            this.maU.vi(adVar != null ? adVar.lSL : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.mhs.dnW() != null && this.mhs.dnW().getPbData() != null && this.mhs.dnW().getPbData().getThreadId() != null && this.mhs.dnW().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.maU.drp().setText(R.string.have_called_fans_short);
            }
            dtN();
        }
    }

    private void dtN() {
        if (this.maU != null) {
            this.maU.drt();
        }
    }

    public void bet() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.maT != null) {
                        g.dismissDialog(a.this.maT, a.this.mhs.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mB().postDelayed(this.runnable, 100L);
    }

    public void dtO() {
        if (this.maT != null) {
            g.dismissDialog(this.maT, this.mhs.getPageContext().getPageActivity());
        }
    }

    public ac dtP() {
        return this.maU;
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
        if (this.mhs == null || !this.mhs.isAdded()) {
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
                    this.lNG = ((TbImageView) view).getBdImage();
                    this.lNH = ((TbImageView) view).getUrl();
                    if (this.lNG == null || TextUtils.isEmpty(this.lNH)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lNI = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lNI = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lNG = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lNH = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lNI = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lNI = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lNG = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lNH = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lNI = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lNI = null;
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
                    a(this.lOv, this.lNG.isGif());
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
        this.kmq = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.kmq == null || this.mhs.dvz() == null) {
            return true;
        }
        if (!this.mhs.dvz().bny() || this.kmq.getId() == null || !this.kmq.getId().equals(this.mhs.dnW().brz())) {
            z = false;
        } else {
            z = true;
        }
        boolean z3 = this.mhs.dnW().getPbData() != null && this.mhs.dnW().getPbData().dni();
        if (this.lNp == null) {
            this.lNp = new k(this.mhs.getContext());
            this.lNp.a(this.lOh);
        }
        ArrayList arrayList = new ArrayList();
        if (view != null && sparseArray2 != null) {
            boolean z4 = dI(view) && !z3;
            boolean z5 = (!dI(view) || this.lNG == null || this.lNG.isGif()) ? false : true;
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
                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.lNp));
            }
            if (z5) {
                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.lNp));
            }
            if (!z4 && !z5) {
                com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.lNp);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.kmq);
                gVar2.eXH.setTag(sparseArray3);
                arrayList.add(gVar2);
            }
            if (!z2 && !z3) {
                if (z) {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.lNp);
                } else {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.lNp);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.kmq);
                sparseArray4.put(R.id.tag_is_subpb, false);
                gVar.eXH.setTag(sparseArray4);
                arrayList.add(gVar);
            }
            if (TbadkCoreApplication.isLogin() && !this.lNf) {
                if (!z8 && z7) {
                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.lNp);
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
                    gVar3.eXH.setTag(sparseArray5);
                    arrayList.add(gVar3);
                } else {
                    if ((uP(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lNp);
                        gVar4.eXH.setTag(str);
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
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lNp);
                        gVar6.eXH.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                    }
                    gVar5 = new com.baidu.tbadk.core.dialog.g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.lNp);
                    gVar5.eXH.setTag(sparseArray6);
                } else if (z10) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_should_manage_visible, false);
                    sparseArray7.put(R.id.tag_user_mute_visible, false);
                    sparseArray7.put(R.id.tag_should_delete_visible, true);
                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                    sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                    if (this.mhs.dnW().getPbData().dmU() == 1002 && !z6) {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lNp);
                    } else {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lNp);
                    }
                    gVar6.eXH.setTag(sparseArray7);
                }
                if (gVar6 != null) {
                    arrayList.add(gVar6);
                }
                if (gVar5 != null) {
                    arrayList.add(gVar5);
                }
            }
            if (com.baidu.tbadk.a.d.bmU()) {
                list = com.baidu.tieba.pb.pb.main.d.a.fs(com.baidu.tieba.pb.pb.main.d.a.w(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.kmq.btl(), sparseArray2, this.lNp), this.lME));
                this.lNp.a(com.baidu.tieba.pb.pb.main.d.a.t(this.kmq));
            } else {
                list = arrayList;
            }
            this.lNp.k(list, true);
            this.lNo = new i(this.mhs.getPageContext(), this.lNp);
            this.lNo.SY();
            TiebaStatic.log(new aq("c13272").dX("tid", this.mhs.dnW().dpX()).dX("fid", this.mhs.dnW().getForumId()).dX("uid", this.mhs.dnW().getPbData().dmF().brr().getUserId()).dX("post_id", this.mhs.dnW().bFl()).an("obj_source", z2 ? 2 : 1));
        }
        return true;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.mhs = videoPbFragment;
        this.lNE = videoPbFragment.getUniqueId();
        this.lNh = new com.baidu.tieba.pb.pb.report.a(this.mhs.getContext());
        this.lNh.w(this.mhs.getUniqueId());
        this.lWq = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.17
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.mhs.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.mhs.dnW().getPbData().getUserData().getUserId());
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
                a.this.mhs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.mhs.getPageContext().getPageActivity(), a.this.mhs.dnW().getPbData().getForum().getId(), a.this.mhs.dnW().getPbData().getForum().getName(), a.this.mhs.dnW().getPbData().dmF().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU(int i) {
        TiebaStatic.log(new aq("c14000").dX("tid", this.mhs.dnW().dpX()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.Hx(i))));
    }

    public void wh(boolean z) {
        this.lME = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lME ? 2 : 3));
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
            if (postData.getId() != null && postData.getId().equals(this.mhs.dnW().brz())) {
                z = true;
            }
            MarkData o = this.mhs.dnW().o(postData);
            if (this.mhs.dnW().getPbData() != null && this.mhs.dnW().getPbData().dni() && (L = this.mhs.L(this.mhs.dnW().getPbData())) != null) {
                o = this.mhs.dnW().o(L);
            }
            if (o != null) {
                this.mhs.dso();
                if (this.mhs.dvz() != null) {
                    this.mhs.dvz().a(o);
                    if (!z) {
                        this.mhs.dvz().bnA();
                    } else {
                        this.mhs.dvz().bnz();
                    }
                }
            }
        }
    }

    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmF() != null) {
            if (fVar.dmF().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dmF().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dmF().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    private boolean uP(boolean z) {
        if (this.mhs.dnW() == null || this.mhs.dnW().getPbData() == null) {
            return false;
        }
        return ((this.mhs.dnW().getPbData().dmU() != 0) || this.mhs.dnW().getPbData().dmF() == null || this.mhs.dnW().getPbData().dmF().brr() == null || TextUtils.equals(this.mhs.dnW().getPbData().dmF().brr().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void PJ(String str) {
        if (this.mhs.dnW() != null && this.mhs.dnW().getPbData() != null && this.mhs.dnW().getPbData().dni()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mhs.dnW().dpX(), str);
            bz dmF = this.mhs.dnW().getPbData().dmF();
            if (dmF.bpY()) {
                format = format + "&channelid=33833";
            } else if (dmF.bto()) {
                format = format + "&channelid=33842";
            } else if (dmF.bpZ()) {
                format = format + "&channelid=33840";
            }
            PK(format);
            return;
        }
        this.lNh.Qk(str);
    }

    private void PK(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.mhs.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lNo != null && this.lNo.isShowing()) {
                this.lNo.dismiss();
                this.lNo = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.mhs.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.19
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.lNo != null) {
                            a.this.lNo.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.lNE);
                            userMuteAddAndDelCustomMessage.setTag(a.this.lNE);
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
                this.lNo = new i(this.mhs.getPageContext(), kVar);
                this.lNo.SY();
            }
        }
    }

    public void dpw() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mhs.getPageContext().getPageActivity());
        aVar.Bo(this.mhs.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.mhs.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.mhs.getPageContext()).btY();
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
        sparseArray.put(lVE, Integer.valueOf(lVF));
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
        this.lUN = new com.baidu.tbadk.core.dialog.a(this.mhs.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lUN.pa(i3);
        } else {
            this.lUN.setOnlyMessageShowCenter(false);
            this.lUN.Bo(str2);
        }
        this.lUN.setYesButtonTag(sparseArray);
        this.lUN.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.23
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.mhs.a(aVar, (JSONArray) null);
            }
        });
        this.lUN.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lUN.jH(true);
        this.lUN.b(this.mhs.getPageContext());
        if (z) {
            this.lUN.btY();
        } else if (dsi()) {
            h hVar = new h(this.mhs.dnW().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.mhs.dnW().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.mhs.dnW().getPbData().dno().has_forum_rule.intValue());
            hVar.ej(this.mhs.dnW().getPbData().getForum().getId(), this.mhs.dnW().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.mhs.dnW().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.mhs.dnW().getPbData().getForum().getUser_level());
            a(this.lUN, i, hVar, this.mhs.dnW().getPbData().getUserData());
        } else {
            a(this.lUN, i);
        }
    }

    private boolean dsi() {
        if (this.mhs == null || this.mhs.dnW().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.mhs.dnW().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.mhs != null && aVar != null) {
            if (this.jOD == null && this.mhs.getView() != null) {
                this.jOD = new f(this.mhs.getPageContext(), this.mhs.getView());
            }
            AntiData cDZ = cDZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cDZ != null && cDZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.jOD.setDefaultReasonArray(new String[]{this.mhs.getString(R.string.delete_thread_reason_1), this.mhs.getString(R.string.delete_thread_reason_2), this.mhs.getString(R.string.delete_thread_reason_3), this.mhs.getString(R.string.delete_thread_reason_4), this.mhs.getString(R.string.delete_thread_reason_5)});
            this.jOD.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jOD.Fg(str);
            this.jOD.a(new f.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    a.this.mhs.a(aVar, jSONArray);
                }
            });
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, h hVar, UserData userData) {
        String str;
        if (this.mhs != null && aVar != null) {
            if (this.lWc == null && this.mhs.getView() != null) {
                this.lWc = new com.baidu.tieba.NEGFeedBack.i(this.mhs.getPageContext(), this.mhs.getView(), hVar, userData);
            }
            AntiData cDZ = cDZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cDZ != null && cDZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.lWc.setDefaultReasonArray(new String[]{this.mhs.getString(R.string.delete_thread_reason_1), this.mhs.getString(R.string.delete_thread_reason_2), this.mhs.getString(R.string.delete_thread_reason_3), this.mhs.getString(R.string.delete_thread_reason_4), this.mhs.getString(R.string.delete_thread_reason_5)});
            this.lWc.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.lWc.Fg(str);
            this.lWc.a(new i.b() { // from class: com.baidu.tieba.pb.videopb.b.a.4
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    a.this.mhs.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cDZ() {
        if (this.mhs.dnW() == null || this.mhs.dnW().getPbData() == null) {
            return null;
        }
        return this.mhs.dnW().getPbData().getAnti();
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
        k kVar = new k(this.mhs.getContext());
        kVar.setTitleText(this.mhs.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.5
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lUM.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (a.this.lWq != null) {
                                a.this.lWq.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mhs.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mhs.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eXH.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.mhs.getString(R.string.forbidden_person), kVar);
            gVar3.eXH.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mhs.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mhs.getString(R.string.mute), kVar);
            }
            gVar.eXH.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.bB(arrayList);
        if (this.lUM == null) {
            this.lUM = new com.baidu.tbadk.core.dialog.i(this.mhs.getPageContext(), kVar);
        } else {
            this.lUM.a(kVar);
        }
        this.lUM.SY();
    }

    public void doT() {
        if (this.lMK == null) {
            this.lMK = new com.baidu.tbadk.core.dialog.b(this.mhs.getPageContext().getPageActivity());
            this.lMK.a(new String[]{this.mhs.getPageContext().getString(R.string.call_phone), this.mhs.getPageContext().getString(R.string.sms_phone), this.mhs.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.mhs.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.lIT = a.this.lIT.trim();
                        UtilHelper.callPhone(a.this.mhs.getPageContext().getPageActivity(), a.this.lIT);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mhs.dnW().dpX(), a.this.lIT, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.mhs.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.lIT = a.this.lIT.trim();
                        UtilHelper.smsPhone(a.this.mhs.getPageContext().getPageActivity(), a.this.lIT);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mhs.dnW().dpX(), a.this.lIT, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.lIT = a.this.lIT.trim();
                        UtilHelper.startBaiDuBar(a.this.mhs.getPageContext().getPageActivity(), a.this.lIT);
                        bVar.dismiss();
                    }
                }
            }).pg(b.a.BOTTOM_TO_TOP).ph(17).d(this.mhs.getPageContext());
        }
    }

    public void dU(final View view) {
        String[] strArr;
        int i = 0;
        if (this.mhs != null && this.mhs.dnW() != null) {
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mhs.getPageContext());
            if (this.mhs.dnW().getPbData().lFQ == null || this.mhs.dnW().getPbData().lFQ.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.mhs.dnW().getPbData().lFQ.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mhs.dnW().getPbData().lFQ.size()) {
                        break;
                    }
                    strArr2[i2] = this.mhs.dnW().getPbData().lFQ.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.mhs.dnW().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.mhs.dnW().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.mhs.dnW().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.mhs.dnW().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new aq("c12097").an("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).an("obj_type", i4));
                    if (a.this.mhs.dnW().getPbData().lFQ != null && a.this.mhs.dnW().getPbData().lFQ.size() > i3) {
                        i3 = a.this.mhs.dnW().getPbData().lFQ.get(i3).sort_type.intValue();
                    }
                    boolean Hh = a.this.mhs.dnW().Hh(i3);
                    view.setTag(Integer.valueOf(a.this.mhs.dnW().dqr()));
                    if (Hh) {
                        a.this.mhs.setIsLoading(true);
                    }
                }
            });
            iVar.SY();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mhs.getActivity());
            aVar.Bn(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Bo(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jH(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dX("obj_id", metaData.getUserId()).an("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dX("obj_id", metaData.getUserId()).an("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.mhs.dvK() != null) {
                        a.this.mhs.dvK().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.mhs.getPageContext().getUniqueId(), a.this.mhs.dnW().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.mhs.getPageContext()).btY();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lNE);
        userMuteAddAndDelCustomMessage.setTag(this.lNE);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void DW(String str) {
        if (str == null) {
            str = "";
        }
        if (this.mhs != null && this.mhs.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mhs.getPageContext().getPageActivity());
            aVar.Bo(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mhs.getPageContext()).btY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mhs.getBaseFragmentActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.Bo(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bo(str);
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
        aVar.b(this.mhs.getPageContext()).btY();
    }

    public void showLoadingDialog() {
        if (this.iCD == null) {
            this.iCD = new com.baidu.tbadk.core.view.a(this.mhs.getPageContext());
        }
        this.iCD.setDialogVisiable(true);
    }

    public void cnj() {
        if (this.iCD != null) {
            this.iCD.setDialogVisiable(false);
        }
    }

    public void i(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        com.baidu.tbadk.core.dialog.g gVar;
        if (this.mhs != null && this.mhs.dnW() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.lNp == null) {
                this.lNp = new k(this.mhs.getContext());
                this.lNp.a(this.lOh);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.mhs.dnW().getPbData() != null && this.mhs.dnW().getPbData().dni();
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
                if (postData.btl() != null) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(8, (postData.btl().hasAgree && postData.bsV() == 5) ? this.mhs.getString(R.string.action_cancel_dislike) : this.mhs.getString(R.string.action_dislike), this.lNp);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.eXH.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, this.mhs.getString(R.string.mute_option), this.lNp);
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
                        gVar3.eXH.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((uP(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, this.mhs.getString(R.string.report_text), this.lNp);
                            gVar4.eXH.setTag(str);
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
                            gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mhs.getString(R.string.delete), this.lNp);
                            gVar5.eXH.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new com.baidu.tbadk.core.dialog.g(7, this.mhs.getString(R.string.bar_manager), this.lNp);
                        gVar.eXH.setTag(sparseArray4);
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
                            if (this.mhs.dnW().getPbData().dmU() == 1002 && !z) {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mhs.getString(R.string.report_text), this.lNp);
                            } else {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mhs.getString(R.string.delete), this.lNp);
                            }
                            gVar5.eXH.setTag(sparseArray5);
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
                this.lNp.bB(arrayList);
                this.lNo = new com.baidu.tbadk.core.dialog.i(this.mhs.getPageContext(), this.lNp);
                this.lNo.SY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.fgY == null) {
                this.fgY = new com.baidu.tbadk.core.message.a();
            }
            if (this.fgI == null) {
                this.fgI = new e();
                this.fgI.uniqueId = this.mhs.getUniqueId();
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eOz = 5;
            dVar.eOF = 8;
            dVar.eOE = 2;
            if (this.mhs != null && this.mhs.dnW() != null) {
                dVar.eOD = this.mhs.dnW().dqI();
            }
            if (dVar != null) {
                dVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.eOG = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.eOG = 1;
                        i = 0;
                    }
                }
                this.fgY.a(agreeData, i, this.mhs.getUniqueId(), false);
                this.fgY.a(agreeData, this.fgI);
                if (this.mhs == null && this.mhs.dnW() != null && this.mhs.dnW().getPbData() != null) {
                    this.fgY.a(this.mhs.dpE(), dVar, agreeData, this.mhs.dnW().getPbData().dmF());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.eOG = 1;
            }
            i = 0;
            this.fgY.a(agreeData, i, this.mhs.getUniqueId(), false);
            this.fgY.a(agreeData, this.fgI);
            if (this.mhs == null) {
            }
        }
    }

    public void a(final b.InterfaceC0578b interfaceC0578b, boolean z) {
        if (this.lUV != null) {
            this.lUV.dismiss();
            this.lUV = null;
        }
        k kVar = new k(this.mhs.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.mhs.dnW().getPbData() != null && this.mhs.dnW().getPbData().dmF() != null && !this.mhs.dnW().getPbData().dmF().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.mhs.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.mhs.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bB(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lUV.dismiss();
                interfaceC0578b.a(null, i, view);
            }
        });
        this.lUV = new com.baidu.tbadk.core.dialog.i(this.mhs.getPageContext(), kVar);
        this.lUV.SY();
    }

    public void bf(ArrayList<ak> arrayList) {
        if (this.lUQ == null) {
            this.lUQ = LayoutInflater.from(this.mhs.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.mhs.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lUQ);
        if (this.lUP == null) {
            this.lUP = new Dialog(this.mhs.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lUP.setCanceledOnTouchOutside(true);
            this.lUP.setCancelable(true);
            this.lUY = (ScrollView) this.lUQ.findViewById(R.id.good_scroll);
            this.lUP.setContentView(this.lUQ);
            WindowManager.LayoutParams attributes = this.lUP.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lUP.getWindow().setAttributes(attributes);
            this.iyr = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.lUU = (String) compoundButton.getTag();
                        if (a.this.iyq != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.iyq) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.lUU != null && !str.equals(a.this.lUU)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lUR = (LinearLayout) this.lUQ.findViewById(R.id.good_class_group);
            this.lUT = (TextView) this.lUQ.findViewById(R.id.dialog_button_cancel);
            this.lUT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lUP instanceof Dialog) {
                        g.b(a.this.lUP, a.this.mhs.getPageContext());
                    }
                }
            });
            this.lUS = (TextView) this.lUQ.findViewById(R.id.dialog_button_ok);
            this.lUS.setOnClickListener(this.mhs.dvA());
        }
        this.lUR.removeAllViews();
        this.iyq = new ArrayList();
        CustomBlueCheckRadioButton fV = fV("0", this.mhs.getPageContext().getString(R.string.thread_good_class));
        this.iyq.add(fV);
        fV.setChecked(true);
        this.lUR.addView(fV);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ak akVar = arrayList.get(i2);
                if (akVar != null && !TextUtils.isEmpty(akVar.bpD()) && akVar.bpE() > 0) {
                    CustomBlueCheckRadioButton fV2 = fV(String.valueOf(akVar.bpE()), akVar.bpD());
                    this.iyq.add(fV2);
                    View view = new View(this.mhs.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ao.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lUR.addView(view);
                    this.lUR.addView(fV2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lUY.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.mhs.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.mhs.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.mhs.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lUY.setLayoutParams(layoutParams2);
            this.lUY.removeAllViews();
            if (this.lUR != null && this.lUR.getParent() == null) {
                this.lUY.addView(this.lUR);
            }
        }
        g.a(this.lUP, this.mhs.getPageContext());
    }

    private CustomBlueCheckRadioButton fV(String str, String str2) {
        Activity pageActivity = this.mhs.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.iyr);
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
        userMuteCheckCustomMessage.mId = this.lNE;
        userMuteCheckCustomMessage.setTag(this.lNE);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void dsJ() {
        if (this.lUN != null) {
            this.lUN.dismiss();
        }
        if (this.lUO != null) {
            g.b(this.lUO, this.mhs.getPageContext());
        }
        if (this.lUP != null) {
            g.b(this.lUP, this.mhs.getPageContext());
        }
        if (this.lUM != null) {
            this.lUM.dismiss();
        }
    }

    public void dwr() {
        if (this.lNo != null) {
            this.lNo.dismiss();
        }
    }

    public void dsI() {
        bet();
        this.mhs.drL();
        if (this.lNo != null) {
            this.lNo.dismiss();
        }
        dsJ();
    }

    public void dsH() {
        bet();
        this.mhs.drL();
        if (this.lNo != null) {
            this.lNo.dismiss();
        }
        this.mhs.cFB();
        dsJ();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener dvC() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b dws() {
        return this.lMK;
    }

    public void setPhoneNumber(String str) {
        this.lIT = str;
    }

    public String dsn() {
        return this.lUU;
    }

    public View dsm() {
        if (this.lUQ != null) {
            return this.lUQ.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
