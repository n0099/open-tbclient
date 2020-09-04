package com.baidu.tieba.pb.videopb.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ak;
import com.baidu.tieba.pb.pb.main.bd;
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
/* loaded from: classes16.dex */
public class a {
    public static int kLX = 3;
    public static int kLY = 0;
    public static int kLZ = 3;
    public static int kMa = 4;
    public static int kMb = 5;
    public static int kMc = 6;
    private bd dTW;
    private e eod;
    private com.baidu.tbadk.core.message.a eou;
    private List<CustomBlueCheckRadioButton> hme;
    private com.baidu.tieba.NEGFeedBack.e izf;
    private com.baidu.tieba.pb.pb.report.a kDD;
    private i kDK;
    private k kDL;
    public BdUniqueId kEa;
    private com.baidu.adp.widget.ImageView.a kEc;
    private String kEd;
    private TbRichTextMemeInfo kEe;
    private PbFragment.b kMG;
    public VideoPbFragment kXu;
    private String kzG;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i kLp = null;
    private com.baidu.tbadk.core.dialog.a kLh = null;
    private Dialog kLi = null;
    private Dialog kLj = null;
    private View kLk = null;
    private LinearLayout kLl = null;
    private TextView kLm = null;
    private TextView kLn = null;
    private String kLo = null;
    private ScrollView kLs = null;
    private CompoundButton.OnCheckedChangeListener hmf = null;
    private i kLg = null;
    private com.baidu.tbadk.core.view.a hqa = null;
    private com.baidu.tbadk.core.dialog.b kDi = null;
    private AlertDialog kRc = null;
    private aj kRd = null;
    PostData iUM = null;
    private boolean kBf = d.baf();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01f5  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            boolean z2;
            g gVar;
            g gVar2;
            SparseArray sparseArray;
            if (a.this.kXu == null || !a.this.kXu.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.cO(view)) {
                    if (view instanceof TbImageView) {
                        a.this.kEc = ((TbImageView) view).getBdImage();
                        a.this.kEd = ((TbImageView) view).getUrl();
                        if (a.this.kEc == null || TextUtils.isEmpty(a.this.kEd)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.kEe = null;
                        } else {
                            a.this.kEe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.kEc = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.kEd = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.kEe = null;
                            } else {
                                a.this.kEe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.kEc = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.kEd = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.kEe = null;
                        } else {
                            a.this.kEe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e2) {
                            e2.printStackTrace();
                            sparseArray = sparseArray2;
                        }
                    } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                        a.this.a(a.this.kER, a.this.kEc.isGif());
                    } else {
                        try {
                            sparseArray = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray = sparseArray2;
                        }
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
            a.this.iUM = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.iUM == null || a.this.kXu.ddS() == null) {
                return true;
            }
            if (!a.this.kXu.ddS().baA() || a.this.iUM.getId() == null || !a.this.iUM.getId().equals(a.this.kXu.cWE().beM())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.kXu.cWE().getPbData() != null && a.this.kXu.cWE().getPbData().cVP();
            if (a.this.kDL == null) {
                a.this.kDL = new k(a.this.kXu.getContext());
                a.this.kDL.a(a.this.kED);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cO(view) && !z3;
                boolean z5 = (!a.this.cO(view) || a.this.kEc == null || a.this.kEc.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.kDL));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.kDL));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.kDL);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.iUM);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.kDL);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.kDL);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.iUM);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin() && !a.this.kBf) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.kDL);
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
                        gVar4.mTextView.setTag(sparseArray5);
                        arrayList.add(gVar4);
                    } else {
                        if ((a.this.sV(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.kDL);
                            gVar5.mTextView.setTag(str);
                            arrayList.add(gVar5);
                        }
                    }
                    g gVar6 = null;
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.kDL);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.kDL);
                        gVar.mTextView.setTag(sparseArray6);
                    } else {
                        if (z10) {
                            SparseArray sparseArray7 = new SparseArray();
                            sparseArray7.put(R.id.tag_should_manage_visible, false);
                            sparseArray7.put(R.id.tag_user_mute_visible, false);
                            sparseArray7.put(R.id.tag_should_delete_visible, true);
                            sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                            sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                            sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                            sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                            if (a.this.kXu.cWE().getPbData().cVB() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.kDL);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.kDL);
                            }
                            gVar6.mTextView.setTag(sparseArray7);
                        }
                        gVar = null;
                    }
                    if (gVar6 != null) {
                        arrayList.add(gVar6);
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                a.this.kDL.aT(arrayList);
                a.this.kDK = new i(a.this.kXu.getPageContext(), a.this.kDL);
                a.this.kDK.Nv();
                TiebaStatic.log(new aq("c13272").dD("tid", a.this.kXu.cWE().cYC()).dD("fid", a.this.kXu.cWE().getForumId()).dD("uid", a.this.kXu.cWE().getPbData().cVm().beE().getUserId()).dD("post_id", a.this.kXu.cWE().brT()).ai("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c kED = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.kDK != null) {
                a.this.kDK.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.kEc != null && !TextUtils.isEmpty(a.this.kEd)) {
                        if (a.this.kEe == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.kEd));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.kEd;
                            aVar.pkgId = a.this.kEe.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.kEe.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.kEc = null;
                        a.this.kEd = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.kEc != null && !TextUtils.isEmpty(a.this.kEd)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.kXu.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.kXu.getPageContext().getPageActivity())) {
                            if (a.this.dTW == null) {
                                a.this.dTW = new bd(a.this.kXu.getPageContext());
                            }
                            a.this.dTW.j(a.this.kEd, a.this.kEc.getImageByte());
                            a.this.kEc = null;
                            a.this.kEd = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.iUM != null) {
                        a.this.iUM.fF(a.this.kXu.getPageContext().getPageActivity());
                        a.this.iUM = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new aq("c11739").ai("obj_locate", 2));
                    if (a.this.kXu.checkUpIsLogin()) {
                        a.this.cN(view);
                        if (a.this.kXu.cWE().getPbData().cVm() != null && a.this.kXu.cWE().getPbData().cVm().beE() != null && a.this.kXu.cWE().getPbData().cVm().beE().getUserId() != null && a.this.kXu.ddS() != null) {
                            int h = a.this.h(a.this.kXu.cWE().getPbData());
                            bw cVm = a.this.kXu.cWE().getPbData().cVm();
                            if (cVm.bdm()) {
                                i2 = 2;
                            } else if (cVm.bdn()) {
                                i2 = 3;
                            } else if (cVm.bgz()) {
                                i2 = 4;
                            } else {
                                i2 = cVm.bgA() ? 5 : 1;
                            }
                            TiebaStatic.log(new aq("c12526").dD("tid", a.this.kXu.cWE().cYC()).ai("obj_locate", 2).dD("obj_id", a.this.kXu.cWE().getPbData().cVm().beE().getUserId()).ai("obj_type", a.this.kXu.ddS().baA() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.kXu.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new aq("c13079"));
                        a.this.Nv((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new aq("c11739").ai("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            a.this.c(sparseArray2);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!j.isNetWorkAvailable()) {
                        a.this.kXu.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null) {
                        boolean booleanValue = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray4.put(R.id.tag_from, 1);
                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                a.this.c(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            a.this.cT(view);
                            return;
                        } else if (booleanValue2) {
                            a.this.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (bg.checkUpIsLogin(a.this.kXu.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bgv() != null) {
                            a.this.d(postData.bgv());
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final b.InterfaceC0538b kER = new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.kEc != null && !TextUtils.isEmpty(a.this.kEd)) {
                if (i == 0) {
                    if (a.this.kEe == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.kEd));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.kEd;
                        aVar.pkgId = a.this.kEe.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.kEe.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.kXu.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.kXu.getPageContext().getPageActivity())) {
                        if (a.this.dTW == null) {
                            a.this.dTW = new bd(a.this.kXu.getPageContext());
                        }
                        a.this.dTW.j(a.this.kEd, a.this.kEc.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.kEc = null;
                a.this.kEd = null;
            }
        }
    };

    public void cXF() {
        f pbData;
        bw cVm;
        boolean z = true;
        if (this.kXu != null && this.kXu.cWE() != null && this.kXu.cWE().getPbData() != null && (cVm = (pbData = this.kXu.cWE().getPbData()).cVm()) != null && cVm.beE() != null) {
            this.kXu.dan();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cVm.beE().getUserId());
            ak akVar = new ak();
            int cVB = this.kXu.cWE().getPbData().cVB();
            if (cVB == 1 || cVB == 3) {
                akVar.kIY = true;
                akVar.kIX = true;
                akVar.kJd = cVm.bez() == 1;
                akVar.kJc = cVm.beA() == 1;
            } else {
                akVar.kIY = false;
                akVar.kIX = false;
            }
            if (cVB == 1002 && !equals) {
                akVar.kJe = true;
            }
            akVar.kIV = sW(equals);
            akVar.kIZ = cXG();
            akVar.kIW = sX(equals);
            akVar.EK = this.kXu.cWE().cYE();
            akVar.kIS = true;
            akVar.kIR = sV(equals);
            akVar.kJb = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.kJa = true;
            akVar.isHostOnly = this.kXu.cWE().getHostMode();
            akVar.kIU = true;
            if (cVm.beW() == null) {
                akVar.kIT = true;
            } else {
                akVar.kIT = false;
            }
            if (pbData.cVP()) {
                akVar.kIS = false;
                akVar.kIU = false;
                akVar.kIT = false;
                akVar.kIX = false;
                akVar.kIY = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.cVP()) {
                z = false;
            }
            akVar.kJf = z;
            a(akVar);
        }
    }

    private boolean sW(boolean z) {
        boolean z2;
        ab abVar;
        if (this.kXu == null || this.kXu.cWE() == null || this.kXu.cWE().getPbData() == null) {
            return false;
        }
        f pbData = this.kXu.cWE().getPbData();
        bw cVm = pbData.cVm();
        if (cVm != null) {
            if (cVm.bdm() || cVm.bdn()) {
                return false;
            }
            if (cVm.bgz() || cVm.bgA()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cVB() != 0) {
                return pbData.cVB() != 3;
            }
            List<bs> cVJ = pbData.cVJ();
            if (y.getCount(cVJ) > 0) {
                for (bs bsVar : cVJ) {
                    if (bsVar != null && (abVar = bsVar.eay) != null && abVar.dYk && !abVar.dYl && (abVar.type == 1 || abVar.type == 2)) {
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

    private boolean sX(boolean z) {
        if (z || this.kXu == null || this.kXu.cWE() == null || this.kXu.cWE().getPbData() == null) {
            return false;
        }
        return ((this.kXu.cWE().getPbData().getForum() != null && this.kXu.cWE().getPbData().getForum().isBlockBawuDelete) || this.kXu.cWE().getPbData().cVB() == 0 || this.kXu.cWE().getPbData().cVB() == 3) ? false : true;
    }

    private boolean cXG() {
        if (this.kXu == null || this.kXu.cWE() == null || !this.kXu.cWE().cYE()) {
            return false;
        }
        return this.kXu.cWE().getPageData() == null || this.kXu.cWE().getPageData().bdv() != 0;
    }

    public void a(ak akVar) {
        if (!this.kXu.getBaseFragmentActivity().isProgressBarShown()) {
            this.kRd = new aj(this.kXu, this.kXu.aBm);
            this.kRc = new AlertDialog.Builder(this.kXu.getContext(), R.style.DialogTheme).create();
            this.kRc.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.kRc, this.kXu.getFragmentActivity());
            Window window = this.kRc.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.kRd.getView());
            this.kRd.tl(akVar == null ? false : akVar.kIR);
            this.kRd.tm(akVar == null ? false : akVar.kIV);
            this.kRd.tn(akVar == null ? false : akVar.kIZ);
            this.kRd.tp(akVar == null ? false : akVar.kIW);
            this.kRd.tq(akVar == null ? true : akVar.kIT);
            if (akVar == null) {
                this.kRd.ak(false, false);
                this.kRd.al(false, false);
            } else {
                this.kRd.ak(akVar.kIX, akVar.kJd);
                this.kRd.al(akVar.kIY, akVar.kJc);
            }
            boolean z = akVar == null ? false : akVar.EK;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.kIU;
            boolean z4 = akVar == null ? false : akVar.kIS;
            boolean z5 = akVar == null ? false : akVar.kJb;
            boolean z6 = akVar == null ? false : akVar.kJa;
            this.kRd.aj(z3, z2);
            this.kRd.am(z4, z);
            this.kRd.an(z6, z5);
            if (akVar != null) {
                this.kRd.kIO = akVar.kJe;
                if (akVar.kJe) {
                    this.kRd.cZP().setText(R.string.report_text);
                    this.kRd.tp(false);
                }
            }
            this.kRd.to(akVar != null ? akVar.kJf : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kXu.cWE() != null && this.kXu.cWE().getPbData() != null && this.kXu.cWE().getPbData().getThreadId() != null && this.kXu.cWE().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.kRd.cZS().setText(R.string.have_called_fans_short);
            }
            dcj();
        }
    }

    private void dcj() {
        if (this.kRd != null) {
            this.kRd.cZW();
        }
    }

    public void aRN() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.kRc != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.kRc, a.this.kXu.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mS().postDelayed(this.runnable, 100L);
    }

    public void dck() {
        if (this.kRc != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.kRc, this.kXu.getPageContext().getPageActivity());
        }
    }

    public aj dcl() {
        return this.kRd;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.kXu = videoPbFragment;
        this.kEa = videoPbFragment.getUniqueId();
        this.kDD = new com.baidu.tieba.pb.pb.report.a(this.kXu.getContext());
        this.kDD.x(this.kXu.getUniqueId());
        this.kMG = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.kXu.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.kXu.cWE().getPbData().getUserData().getUserId());
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
                a.this.kXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.kXu.getPageContext().getPageActivity(), a.this.kXu.cWE().getPbData().getForum().getId(), a.this.kXu.cWE().getPbData().getForum().getName(), a.this.kXu.cWE().getPbData().cVm().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(View view) {
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
        PostData I;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.kXu.cWE().beM())) {
                z = true;
            }
            MarkData o = this.kXu.cWE().o(postData);
            if (this.kXu.cWE().getPbData() != null && this.kXu.cWE().getPbData().cVP() && (I = this.kXu.I(this.kXu.cWE().getPbData())) != null) {
                o = this.kXu.cWE().o(I);
            }
            if (o != null) {
                this.kXu.daM();
                if (this.kXu.ddS() != null) {
                    this.kXu.ddS().a(o);
                    if (!z) {
                        this.kXu.ddS().baC();
                    } else {
                        this.kXu.ddS().baB();
                    }
                }
            }
        }
    }

    public int h(f fVar) {
        if (fVar != null && fVar.cVm() != null) {
            if (fVar.cVm().getThreadType() == 0) {
                return 1;
            }
            if (fVar.cVm().getThreadType() == 54) {
                return 2;
            }
            if (fVar.cVm().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sV(boolean z) {
        if (this.kXu.cWE() == null || this.kXu.cWE().getPbData() == null) {
            return false;
        }
        return ((this.kXu.cWE().getPbData().cVB() != 0) || this.kXu.cWE().getPbData().cVm() == null || this.kXu.cWE().getPbData().cVm().beE() == null || TextUtils.equals(this.kXu.cWE().getPbData().cVm().beE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Nv(String str) {
        if (this.kXu.cWE() != null && this.kXu.cWE().getPbData() != null && this.kXu.cWE().getPbData().cVP()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kXu.cWE().cYC(), str);
            bw cVm = this.kXu.cWE().getPbData().cVm();
            if (cVm.bdm()) {
                format = format + "&channelid=33833";
            } else if (cVm.bgy()) {
                format = format + "&channelid=33842";
            } else if (cVm.bdn()) {
                format = format + "&channelid=33840";
            }
            Nw(format);
            return;
        }
        this.kDD.NW(str);
    }

    private void Nw(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.kXu.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.kDK != null && this.kDK.isShowing()) {
                this.kDK.dismiss();
                this.kDK = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.kXu.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.kDK != null) {
                            a.this.kDK.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.kEa);
                            userMuteAddAndDelCustomMessage.setTag(a.this.kEa);
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
                    arrayList.add(new g(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), kVar));
                }
                if (z) {
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), kVar));
                } else {
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), kVar));
                }
                kVar.aT(arrayList);
                this.kDK = new i(this.kXu.getPageContext(), kVar);
                this.kDK.Nv();
            }
        }
    }

    public void cYb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kXu.getPageContext().getPageActivity());
        aVar.zA(this.kXu.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.kXu.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kXu.getPageContext()).bhg();
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
        sparseArray.put(kLY, Integer.valueOf(kLZ));
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
        this.kLh = new com.baidu.tbadk.core.dialog.a(this.kXu.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kLh.nt(i3);
        } else {
            this.kLh.setOnlyMessageShowCenter(false);
            this.kLh.zA(str2);
        }
        this.kLh.setYesButtonTag(sparseArray);
        this.kLh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.kXu.a(aVar, (JSONArray) null);
            }
        });
        this.kLh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kLh.ig(true);
        this.kLh.b(this.kXu.getPageContext());
        if (z) {
            this.kLh.bhg();
        } else {
            a(this.kLh, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kXu != null && aVar != null) {
            if (this.izf == null && this.kXu.getView() != null) {
                this.izf = new com.baidu.tieba.NEGFeedBack.e(this.kXu.getPageContext(), this.kXu.getView());
            }
            AntiData ckU = ckU();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ckU != null && ckU.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ckU.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.izf.setDefaultReasonArray(new String[]{this.kXu.getString(R.string.delete_thread_reason_1), this.kXu.getString(R.string.delete_thread_reason_2), this.kXu.getString(R.string.delete_thread_reason_3), this.kXu.getString(R.string.delete_thread_reason_4), this.kXu.getString(R.string.delete_thread_reason_5)});
            this.izf.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.izf.Df(str);
            this.izf.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    a.this.kXu.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData ckU() {
        if (this.kXu.cWE() == null || this.kXu.cWE().getPbData() == null) {
            return null;
        }
        return this.kXu.cWE().getPbData().getAnti();
    }

    public void cT(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.kXu.getContext());
        kVar.setTitleText(this.kXu.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.kLg.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.kMG != null) {
                                a.this.kMG.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
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
                gVar2 = new g(0, this.kXu.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.kXu.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            g gVar3 = new g(1, this.kXu.getString(R.string.forbidden_person), kVar);
            gVar3.mTextView.setTag(sparseArray3);
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
                gVar = new g(2, this.kXu.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.kXu.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aT(arrayList);
        if (this.kLg == null) {
            this.kLg = new i(this.kXu.getPageContext(), kVar);
        } else {
            this.kLg.a(kVar);
        }
        this.kLg.Nv();
    }

    public void cXy() {
        if (this.kDi == null) {
            this.kDi = new com.baidu.tbadk.core.dialog.b(this.kXu.getPageContext().getPageActivity());
            this.kDi.a(new String[]{this.kXu.getPageContext().getString(R.string.call_phone), this.kXu.getPageContext().getString(R.string.sms_phone), this.kXu.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.kXu.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.kzG = a.this.kzG.trim();
                        UtilHelper.callPhone(a.this.kXu.getPageContext().getPageActivity(), a.this.kzG);
                        new com.baidu.tieba.pb.pb.main.b(a.this.kXu.cWE().cYC(), a.this.kzG, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.kXu.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.kzG = a.this.kzG.trim();
                        UtilHelper.smsPhone(a.this.kXu.getPageContext().getPageActivity(), a.this.kzG);
                        new com.baidu.tieba.pb.pb.main.b(a.this.kXu.cWE().cYC(), a.this.kzG, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.kzG = a.this.kzG.trim();
                        UtilHelper.startBaiDuBar(a.this.kXu.getPageContext().getPageActivity(), a.this.kzG);
                        bVar.dismiss();
                    }
                }
            }).ny(b.a.BOTTOM_TO_TOP).nz(17).d(this.kXu.getPageContext());
        }
    }

    public void da(final View view) {
        String[] strArr;
        int i = 0;
        if (this.kXu != null && this.kXu.cWE() != null) {
            final i iVar = new i(this.kXu.getPageContext());
            if (this.kXu.cWE().getPbData().kwO == null || this.kXu.cWE().getPbData().kwO.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.kXu.cWE().getPbData().kwO.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.kXu.cWE().getPbData().kwO.size()) {
                        break;
                    }
                    strArr2[i2] = this.kXu.cWE().getPbData().kwO.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.kXu.cWE().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.kXu.cWE().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.kXu.cWE().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.kXu.cWE().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new aq("c12097").ai("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ai("obj_type", i4));
                    if (a.this.kXu.cWE().getPbData().kwO != null && a.this.kXu.cWE().getPbData().kwO.size() > i3) {
                        i3 = a.this.kXu.cWE().getPbData().kwO.get(i3).sort_type.intValue();
                    }
                    boolean En = a.this.kXu.cWE().En(i3);
                    view.setTag(Integer.valueOf(a.this.kXu.cWE().cYV()));
                    if (En) {
                        a.this.kXu.setIsLoading(true);
                    }
                }
            });
            iVar.Nv();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kXu.getActivity());
            aVar.zz(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.zA(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.ig(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dD("obj_id", metaData.getUserId()).ai("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dD("obj_id", metaData.getUserId()).ai("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.kXu.ded() != null) {
                        a.this.kXu.ded().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.kXu.getPageContext().getUniqueId(), a.this.kXu.cWE().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.kXu.getPageContext()).bhg();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.kEa);
        userMuteAddAndDelCustomMessage.setTag(this.kEa);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void Ce(String str) {
        if (str == null) {
            str = "";
        }
        if (this.kXu != null && this.kXu.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kXu.getPageContext().getPageActivity());
            aVar.zA(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kXu.getPageContext()).bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kXu.getBaseFragmentActivity());
        if (at.isEmpty(str)) {
            aVar.zA(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.zA(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kXu.getPageContext()).bhg();
    }

    public void showLoadingDialog() {
        if (this.hqa == null) {
            this.hqa = new com.baidu.tbadk.core.view.a(this.kXu.getPageContext());
        }
        this.hqa.setDialogVisiable(true);
    }

    public void bWr() {
        if (this.hqa != null) {
            this.hqa.setDialogVisiable(false);
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        g gVar;
        if (this.kXu != null && this.kXu.cWE() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.kDL == null) {
                this.kDL = new k(this.kXu.getContext());
                this.kDL.a(this.kED);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.kXu.cWE().getPbData() != null && this.kXu.cWE().getPbData().cVP();
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
                if (postData.bgv() != null) {
                    g gVar2 = new g(8, (postData.bgv().hasAgree && postData.bgf() == 5) ? this.kXu.getString(R.string.action_cancel_dislike) : this.kXu.getString(R.string.action_dislike), this.kDL);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.mTextView.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        g gVar3 = new g(5, this.kXu.getString(R.string.mute_option), this.kDL);
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
                        gVar3.mTextView.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((sV(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            g gVar4 = new g(5, this.kXu.getString(R.string.report_text), this.kDL);
                            gVar4.mTextView.setTag(str);
                            arrayList.add(gVar4);
                        }
                    }
                    g gVar5 = null;
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
                            gVar5 = new g(6, this.kXu.getString(R.string.delete), this.kDL);
                            gVar5.mTextView.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, this.kXu.getString(R.string.bar_manager), this.kDL);
                        gVar.mTextView.setTag(sparseArray4);
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
                            if (this.kXu.cWE().getPbData().cVB() == 1002 && !z) {
                                gVar5 = new g(6, this.kXu.getString(R.string.report_text), this.kDL);
                            } else {
                                gVar5 = new g(6, this.kXu.getString(R.string.delete), this.kDL);
                            }
                            gVar5.mTextView.setTag(sparseArray5);
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
                this.kDL.aT(arrayList);
                this.kDK = new i(this.kXu.getPageContext(), this.kDL);
                this.kDK.Nv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eou == null) {
                this.eou = new com.baidu.tbadk.core.message.a();
            }
            if (this.eod == null) {
                this.eod = new com.baidu.tieba.tbadkCore.data.e();
                this.eod.uniqueId = this.kXu.getUniqueId();
            }
            c cVar = new c();
            cVar.dWO = 5;
            cVar.dWU = 8;
            cVar.dWT = 2;
            if (this.kXu != null && this.kXu.cWE() != null) {
                cVar.dWS = this.kXu.cWE().cZm();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dWV = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dWV = 1;
                        i = 0;
                    }
                }
                this.eou.a(agreeData, i, this.kXu.getUniqueId(), false);
                this.eou.a(agreeData, this.eod);
                if (this.kXu == null && this.kXu.cWE() != null && this.kXu.cWE().getPbData() != null) {
                    this.eou.a(this.kXu.cYj(), cVar, agreeData, this.kXu.cWE().getPbData().cVm());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dWV = 1;
            }
            i = 0;
            this.eou.a(agreeData, i, this.kXu.getUniqueId(), false);
            this.eou.a(agreeData, this.eod);
            if (this.kXu == null) {
            }
        }
    }

    public void a(final b.InterfaceC0538b interfaceC0538b, boolean z) {
        if (this.kLp != null) {
            this.kLp.dismiss();
            this.kLp = null;
        }
        k kVar = new k(this.kXu.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kXu.cWE().getPbData() != null && this.kXu.cWE().getPbData().cVm() != null && !this.kXu.cWE().getPbData().cVm().isBjh()) {
            arrayList.add(new g(0, this.kXu.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.kXu.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aT(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.kLp.dismiss();
                interfaceC0538b.a(null, i, view);
            }
        });
        this.kLp = new i(this.kXu.getPageContext(), kVar);
        this.kLp.Nv();
    }

    public void aX(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.kLk == null) {
            this.kLk = LayoutInflater.from(this.kXu.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kXu.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kLk);
        if (this.kLj == null) {
            this.kLj = new Dialog(this.kXu.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kLj.setCanceledOnTouchOutside(true);
            this.kLj.setCancelable(true);
            this.kLs = (ScrollView) this.kLk.findViewById(R.id.good_scroll);
            this.kLj.setContentView(this.kLk);
            WindowManager.LayoutParams attributes = this.kLj.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kLj.getWindow().setAttributes(attributes);
            this.hmf = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.kLo = (String) compoundButton.getTag();
                        if (a.this.hme != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.hme) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.kLo != null && !str.equals(a.this.kLo)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kLl = (LinearLayout) this.kLk.findViewById(R.id.good_class_group);
            this.kLn = (TextView) this.kLk.findViewById(R.id.dialog_button_cancel);
            this.kLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.kLj instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.kLj, a.this.kXu.getPageContext());
                    }
                }
            });
            this.kLm = (TextView) this.kLk.findViewById(R.id.dialog_button_ok);
            this.kLm.setOnClickListener(this.kXu.ddT());
        }
        this.kLl.removeAllViews();
        this.hme = new ArrayList();
        CustomBlueCheckRadioButton fu = fu("0", this.kXu.getPageContext().getString(R.string.thread_good_class));
        this.hme.add(fu);
        fu.setChecked(true);
        this.kLl.addView(fu);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bcS()) && ajVar.bcT() > 0) {
                    CustomBlueCheckRadioButton fu2 = fu(String.valueOf(ajVar.bcT()), ajVar.bcS());
                    this.hme.add(fu2);
                    View view = new View(this.kXu.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kLl.addView(view);
                    this.kLl.addView(fu2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kLs.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.kXu.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.kXu.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.kXu.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kLs.setLayoutParams(layoutParams2);
            this.kLs.removeAllViews();
            if (this.kLl != null && this.kLl.getParent() == null) {
                this.kLs.addView(this.kLl);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kLj, this.kXu.getPageContext());
    }

    private CustomBlueCheckRadioButton fu(String str, String str2) {
        Activity pageActivity = this.kXu.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.hmf);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean cO(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.kEa;
        userMuteCheckCustomMessage.setTag(this.kEa);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void dbh() {
        if (this.kLh != null) {
            this.kLh.dismiss();
        }
        if (this.kLi != null) {
            com.baidu.adp.lib.f.g.b(this.kLi, this.kXu.getPageContext());
        }
        if (this.kLj != null) {
            com.baidu.adp.lib.f.g.b(this.kLj, this.kXu.getPageContext());
        }
        if (this.kLg != null) {
            this.kLg.dismiss();
        }
    }

    public void deK() {
        if (this.kDK != null) {
            this.kDK.dismiss();
        }
    }

    public void dbg() {
        aRN();
        this.kXu.dan();
        if (this.kDK != null) {
            this.kDK.dismiss();
        }
        dbh();
    }

    public void dbf() {
        aRN();
        this.kXu.dan();
        if (this.kDK != null) {
            this.kDK.dismiss();
        }
        this.kXu.cmt();
        dbh();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener ddV() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b deL() {
        return this.kDi;
    }

    public void setPhoneNumber(String str) {
        this.kzG = str;
    }

    public String daL() {
        return this.kLo;
    }

    public View daK() {
        if (this.kLk != null) {
            return this.kLk.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
