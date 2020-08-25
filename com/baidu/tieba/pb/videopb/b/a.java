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
    public static int kLQ = 3;
    public static int kLR = 0;
    public static int kLS = 3;
    public static int kLT = 4;
    public static int kLU = 5;
    public static int kLV = 6;
    private bd dTS;
    private e enZ;
    private com.baidu.tbadk.core.message.a eoq;
    private List<CustomBlueCheckRadioButton> hma;
    private com.baidu.tieba.NEGFeedBack.e iyZ;
    private i kDD;
    private k kDE;
    public BdUniqueId kDT;
    private com.baidu.adp.widget.ImageView.a kDV;
    private String kDW;
    private TbRichTextMemeInfo kDX;
    private com.baidu.tieba.pb.pb.report.a kDw;
    private PbFragment.b kMz;
    public VideoPbFragment kXn;
    private String kzz;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i kLi = null;
    private com.baidu.tbadk.core.dialog.a kLa = null;
    private Dialog kLb = null;
    private Dialog kLc = null;
    private View kLd = null;
    private LinearLayout kLe = null;
    private TextView kLf = null;
    private TextView kLg = null;
    private String kLh = null;
    private ScrollView kLl = null;
    private CompoundButton.OnCheckedChangeListener hmb = null;
    private i kKZ = null;
    private com.baidu.tbadk.core.view.a hpW = null;
    private com.baidu.tbadk.core.dialog.b kDb = null;
    private AlertDialog kQV = null;
    private aj kQW = null;
    PostData iUG = null;
    private boolean kAY = d.baf();
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
            if (a.this.kXn == null || !a.this.kXn.isAdded()) {
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
                        a.this.kDV = ((TbImageView) view).getBdImage();
                        a.this.kDW = ((TbImageView) view).getUrl();
                        if (a.this.kDV == null || TextUtils.isEmpty(a.this.kDW)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.kDX = null;
                        } else {
                            a.this.kDX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.kDV = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.kDW = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.kDX = null;
                            } else {
                                a.this.kDX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.kDV = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.kDW = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.kDX = null;
                        } else {
                            a.this.kDX = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.kEK, a.this.kDV.isGif());
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
            a.this.iUG = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.iUG == null || a.this.kXn.ddR() == null) {
                return true;
            }
            if (!a.this.kXn.ddR().baA() || a.this.iUG.getId() == null || !a.this.iUG.getId().equals(a.this.kXn.cWD().beM())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.kXn.cWD().getPbData() != null && a.this.kXn.cWD().getPbData().cVO();
            if (a.this.kDE == null) {
                a.this.kDE = new k(a.this.kXn.getContext());
                a.this.kDE.a(a.this.kEw);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cO(view) && !z3;
                boolean z5 = (!a.this.cO(view) || a.this.kDV == null || a.this.kDV.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.kDE));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.kDE));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.kDE);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.iUG);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.kDE);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.kDE);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.iUG);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin() && !a.this.kAY) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.kDE);
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
                        if ((a.this.sT(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.kDE);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.kDE);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.kDE);
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
                            if (a.this.kXn.cWD().getPbData().cVA() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.kDE);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.kDE);
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
                a.this.kDE.aT(arrayList);
                a.this.kDD = new i(a.this.kXn.getPageContext(), a.this.kDE);
                a.this.kDD.Nv();
                TiebaStatic.log(new aq("c13272").dD("tid", a.this.kXn.cWD().cYB()).dD("fid", a.this.kXn.cWD().getForumId()).dD("uid", a.this.kXn.cWD().getPbData().cVl().beE().getUserId()).dD("post_id", a.this.kXn.cWD().brS()).ai("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c kEw = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.kDD != null) {
                a.this.kDD.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.kDV != null && !TextUtils.isEmpty(a.this.kDW)) {
                        if (a.this.kDX == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.kDW));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.kDW;
                            aVar.pkgId = a.this.kDX.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.kDX.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.kDV = null;
                        a.this.kDW = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.kDV != null && !TextUtils.isEmpty(a.this.kDW)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.kXn.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.kXn.getPageContext().getPageActivity())) {
                            if (a.this.dTS == null) {
                                a.this.dTS = new bd(a.this.kXn.getPageContext());
                            }
                            a.this.dTS.j(a.this.kDW, a.this.kDV.getImageByte());
                            a.this.kDV = null;
                            a.this.kDW = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.iUG != null) {
                        a.this.iUG.fF(a.this.kXn.getPageContext().getPageActivity());
                        a.this.iUG = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new aq("c11739").ai("obj_locate", 2));
                    if (a.this.kXn.checkUpIsLogin()) {
                        a.this.cN(view);
                        if (a.this.kXn.cWD().getPbData().cVl() != null && a.this.kXn.cWD().getPbData().cVl().beE() != null && a.this.kXn.cWD().getPbData().cVl().beE().getUserId() != null && a.this.kXn.ddR() != null) {
                            int h = a.this.h(a.this.kXn.cWD().getPbData());
                            bw cVl = a.this.kXn.cWD().getPbData().cVl();
                            if (cVl.bdm()) {
                                i2 = 2;
                            } else if (cVl.bdn()) {
                                i2 = 3;
                            } else if (cVl.bgz()) {
                                i2 = 4;
                            } else {
                                i2 = cVl.bgA() ? 5 : 1;
                            }
                            TiebaStatic.log(new aq("c12526").dD("tid", a.this.kXn.cWD().cYB()).ai("obj_locate", 2).dD("obj_id", a.this.kXn.cWD().getPbData().cVl().beE().getUserId()).ai("obj_type", a.this.kXn.ddR().baA() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.kXn.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new aq("c13079"));
                        a.this.Nu((String) tag);
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
                        a.this.kXn.showToast(R.string.network_not_available);
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
                    if (bg.checkUpIsLogin(a.this.kXn.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
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
    private final b.InterfaceC0538b kEK = new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.kDV != null && !TextUtils.isEmpty(a.this.kDW)) {
                if (i == 0) {
                    if (a.this.kDX == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.kDW));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.kDW;
                        aVar.pkgId = a.this.kDX.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.kDX.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.kXn.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.kXn.getPageContext().getPageActivity())) {
                        if (a.this.dTS == null) {
                            a.this.dTS = new bd(a.this.kXn.getPageContext());
                        }
                        a.this.dTS.j(a.this.kDW, a.this.kDV.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.kDV = null;
                a.this.kDW = null;
            }
        }
    };

    public void cXE() {
        f pbData;
        bw cVl;
        boolean z = true;
        if (this.kXn != null && this.kXn.cWD() != null && this.kXn.cWD().getPbData() != null && (cVl = (pbData = this.kXn.cWD().getPbData()).cVl()) != null && cVl.beE() != null) {
            this.kXn.dam();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cVl.beE().getUserId());
            ak akVar = new ak();
            int cVA = this.kXn.cWD().getPbData().cVA();
            if (cVA == 1 || cVA == 3) {
                akVar.kIR = true;
                akVar.kIQ = true;
                akVar.kIW = cVl.bez() == 1;
                akVar.kIV = cVl.beA() == 1;
            } else {
                akVar.kIR = false;
                akVar.kIQ = false;
            }
            if (cVA == 1002 && !equals) {
                akVar.kIX = true;
            }
            akVar.kIO = sU(equals);
            akVar.kIS = cXF();
            akVar.kIP = sV(equals);
            akVar.EK = this.kXn.cWD().cYD();
            akVar.kIL = true;
            akVar.kIK = sT(equals);
            akVar.kIU = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.kIT = true;
            akVar.isHostOnly = this.kXn.cWD().getHostMode();
            akVar.kIN = true;
            if (cVl.beW() == null) {
                akVar.kIM = true;
            } else {
                akVar.kIM = false;
            }
            if (pbData.cVO()) {
                akVar.kIL = false;
                akVar.kIN = false;
                akVar.kIM = false;
                akVar.kIQ = false;
                akVar.kIR = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.cVO()) {
                z = false;
            }
            akVar.kIY = z;
            a(akVar);
        }
    }

    private boolean sU(boolean z) {
        boolean z2;
        ab abVar;
        if (this.kXn == null || this.kXn.cWD() == null || this.kXn.cWD().getPbData() == null) {
            return false;
        }
        f pbData = this.kXn.cWD().getPbData();
        bw cVl = pbData.cVl();
        if (cVl != null) {
            if (cVl.bdm() || cVl.bdn()) {
                return false;
            }
            if (cVl.bgz() || cVl.bgA()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cVA() != 0) {
                return pbData.cVA() != 3;
            }
            List<bs> cVI = pbData.cVI();
            if (y.getCount(cVI) > 0) {
                for (bs bsVar : cVI) {
                    if (bsVar != null && (abVar = bsVar.eau) != null && abVar.dYg && !abVar.dYh && (abVar.type == 1 || abVar.type == 2)) {
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

    private boolean sV(boolean z) {
        if (z || this.kXn == null || this.kXn.cWD() == null || this.kXn.cWD().getPbData() == null) {
            return false;
        }
        return ((this.kXn.cWD().getPbData().getForum() != null && this.kXn.cWD().getPbData().getForum().isBlockBawuDelete) || this.kXn.cWD().getPbData().cVA() == 0 || this.kXn.cWD().getPbData().cVA() == 3) ? false : true;
    }

    private boolean cXF() {
        if (this.kXn == null || this.kXn.cWD() == null || !this.kXn.cWD().cYD()) {
            return false;
        }
        return this.kXn.cWD().getPageData() == null || this.kXn.cWD().getPageData().bdv() != 0;
    }

    public void a(ak akVar) {
        if (!this.kXn.getBaseFragmentActivity().isProgressBarShown()) {
            this.kQW = new aj(this.kXn, this.kXn.aBk);
            this.kQV = new AlertDialog.Builder(this.kXn.getContext(), R.style.DialogTheme).create();
            this.kQV.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.kQV, this.kXn.getFragmentActivity());
            Window window = this.kQV.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.kQW.getView());
            this.kQW.tj(akVar == null ? false : akVar.kIK);
            this.kQW.tk(akVar == null ? false : akVar.kIO);
            this.kQW.tl(akVar == null ? false : akVar.kIS);
            this.kQW.tn(akVar == null ? false : akVar.kIP);
            this.kQW.to(akVar == null ? true : akVar.kIM);
            if (akVar == null) {
                this.kQW.ak(false, false);
                this.kQW.al(false, false);
            } else {
                this.kQW.ak(akVar.kIQ, akVar.kIW);
                this.kQW.al(akVar.kIR, akVar.kIV);
            }
            boolean z = akVar == null ? false : akVar.EK;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.kIN;
            boolean z4 = akVar == null ? false : akVar.kIL;
            boolean z5 = akVar == null ? false : akVar.kIU;
            boolean z6 = akVar == null ? false : akVar.kIT;
            this.kQW.aj(z3, z2);
            this.kQW.am(z4, z);
            this.kQW.an(z6, z5);
            if (akVar != null) {
                this.kQW.kIH = akVar.kIX;
                if (akVar.kIX) {
                    this.kQW.cZO().setText(R.string.report_text);
                    this.kQW.tn(false);
                }
            }
            this.kQW.tm(akVar != null ? akVar.kIY : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kXn.cWD() != null && this.kXn.cWD().getPbData() != null && this.kXn.cWD().getPbData().getThreadId() != null && this.kXn.cWD().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.kQW.cZR().setText(R.string.have_called_fans_short);
            }
            dci();
        }
    }

    private void dci() {
        if (this.kQW != null) {
            this.kQW.cZV();
        }
    }

    public void aRN() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.kQV != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.kQV, a.this.kXn.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mS().postDelayed(this.runnable, 100L);
    }

    public void dcj() {
        if (this.kQV != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.kQV, this.kXn.getPageContext().getPageActivity());
        }
    }

    public aj dck() {
        return this.kQW;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.kXn = videoPbFragment;
        this.kDT = videoPbFragment.getUniqueId();
        this.kDw = new com.baidu.tieba.pb.pb.report.a(this.kXn.getContext());
        this.kDw.x(this.kXn.getUniqueId());
        this.kMz = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.kXn.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.kXn.cWD().getPbData().getUserData().getUserId());
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
                a.this.kXn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.kXn.getPageContext().getPageActivity(), a.this.kXn.cWD().getPbData().getForum().getId(), a.this.kXn.cWD().getPbData().getForum().getName(), a.this.kXn.cWD().getPbData().cVl().getId(), valueOf, str, str3, str2, str4)));
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
            if (postData.getId() != null && postData.getId().equals(this.kXn.cWD().beM())) {
                z = true;
            }
            MarkData o = this.kXn.cWD().o(postData);
            if (this.kXn.cWD().getPbData() != null && this.kXn.cWD().getPbData().cVO() && (I = this.kXn.I(this.kXn.cWD().getPbData())) != null) {
                o = this.kXn.cWD().o(I);
            }
            if (o != null) {
                this.kXn.daL();
                if (this.kXn.ddR() != null) {
                    this.kXn.ddR().a(o);
                    if (!z) {
                        this.kXn.ddR().baC();
                    } else {
                        this.kXn.ddR().baB();
                    }
                }
            }
        }
    }

    public int h(f fVar) {
        if (fVar != null && fVar.cVl() != null) {
            if (fVar.cVl().getThreadType() == 0) {
                return 1;
            }
            if (fVar.cVl().getThreadType() == 54) {
                return 2;
            }
            if (fVar.cVl().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sT(boolean z) {
        if (this.kXn.cWD() == null || this.kXn.cWD().getPbData() == null) {
            return false;
        }
        return ((this.kXn.cWD().getPbData().cVA() != 0) || this.kXn.cWD().getPbData().cVl() == null || this.kXn.cWD().getPbData().cVl().beE() == null || TextUtils.equals(this.kXn.cWD().getPbData().cVl().beE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Nu(String str) {
        if (this.kXn.cWD() != null && this.kXn.cWD().getPbData() != null && this.kXn.cWD().getPbData().cVO()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kXn.cWD().cYB(), str);
            bw cVl = this.kXn.cWD().getPbData().cVl();
            if (cVl.bdm()) {
                format = format + "&channelid=33833";
            } else if (cVl.bgy()) {
                format = format + "&channelid=33842";
            } else if (cVl.bdn()) {
                format = format + "&channelid=33840";
            }
            Nv(format);
            return;
        }
        this.kDw.NV(str);
    }

    private void Nv(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.kXn.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.kDD != null && this.kDD.isShowing()) {
                this.kDD.dismiss();
                this.kDD = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.kXn.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.kDD != null) {
                            a.this.kDD.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.kDT);
                            userMuteAddAndDelCustomMessage.setTag(a.this.kDT);
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
                this.kDD = new i(this.kXn.getPageContext(), kVar);
                this.kDD.Nv();
            }
        }
    }

    public void cYa() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kXn.getPageContext().getPageActivity());
        aVar.zz(this.kXn.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.kXn.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.kXn.getPageContext()).bhg();
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
        sparseArray.put(kLR, Integer.valueOf(kLS));
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
        this.kLa = new com.baidu.tbadk.core.dialog.a(this.kXn.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kLa.nt(i3);
        } else {
            this.kLa.setOnlyMessageShowCenter(false);
            this.kLa.zz(str2);
        }
        this.kLa.setYesButtonTag(sparseArray);
        this.kLa.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.kXn.a(aVar, (JSONArray) null);
            }
        });
        this.kLa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kLa.m39if(true);
        this.kLa.b(this.kXn.getPageContext());
        if (z) {
            this.kLa.bhg();
        } else {
            a(this.kLa, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kXn != null && aVar != null) {
            if (this.iyZ == null && this.kXn.getView() != null) {
                this.iyZ = new com.baidu.tieba.NEGFeedBack.e(this.kXn.getPageContext(), this.kXn.getView());
            }
            AntiData ckT = ckT();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (ckT != null && ckT.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = ckT.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.iyZ.setDefaultReasonArray(new String[]{this.kXn.getString(R.string.delete_thread_reason_1), this.kXn.getString(R.string.delete_thread_reason_2), this.kXn.getString(R.string.delete_thread_reason_3), this.kXn.getString(R.string.delete_thread_reason_4), this.kXn.getString(R.string.delete_thread_reason_5)});
            this.iyZ.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.iyZ.De(str);
            this.iyZ.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    a.this.kXn.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData ckT() {
        if (this.kXn.cWD() == null || this.kXn.cWD().getPbData() == null) {
            return null;
        }
        return this.kXn.cWD().getPbData().getAnti();
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
        k kVar = new k(this.kXn.getContext());
        kVar.setTitleText(this.kXn.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.kKZ.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.kMz != null) {
                                a.this.kMz.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.kXn.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.kXn.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.kXn.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.kXn.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.kXn.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aT(arrayList);
        if (this.kKZ == null) {
            this.kKZ = new i(this.kXn.getPageContext(), kVar);
        } else {
            this.kKZ.a(kVar);
        }
        this.kKZ.Nv();
    }

    public void cXx() {
        if (this.kDb == null) {
            this.kDb = new com.baidu.tbadk.core.dialog.b(this.kXn.getPageContext().getPageActivity());
            this.kDb.a(new String[]{this.kXn.getPageContext().getString(R.string.call_phone), this.kXn.getPageContext().getString(R.string.sms_phone), this.kXn.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.kXn.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.kzz = a.this.kzz.trim();
                        UtilHelper.callPhone(a.this.kXn.getPageContext().getPageActivity(), a.this.kzz);
                        new com.baidu.tieba.pb.pb.main.b(a.this.kXn.cWD().cYB(), a.this.kzz, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.kXn.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.kzz = a.this.kzz.trim();
                        UtilHelper.smsPhone(a.this.kXn.getPageContext().getPageActivity(), a.this.kzz);
                        new com.baidu.tieba.pb.pb.main.b(a.this.kXn.cWD().cYB(), a.this.kzz, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.kzz = a.this.kzz.trim();
                        UtilHelper.startBaiDuBar(a.this.kXn.getPageContext().getPageActivity(), a.this.kzz);
                        bVar.dismiss();
                    }
                }
            }).ny(b.a.BOTTOM_TO_TOP).nz(17).d(this.kXn.getPageContext());
        }
    }

    public void da(final View view) {
        String[] strArr;
        int i = 0;
        if (this.kXn != null && this.kXn.cWD() != null) {
            final i iVar = new i(this.kXn.getPageContext());
            if (this.kXn.cWD().getPbData().kwH == null || this.kXn.cWD().getPbData().kwH.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.kXn.cWD().getPbData().kwH.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.kXn.cWD().getPbData().kwH.size()) {
                        break;
                    }
                    strArr2[i2] = this.kXn.cWD().getPbData().kwH.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.kXn.cWD().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.kXn.cWD().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.kXn.cWD().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.kXn.cWD().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new aq("c12097").ai("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ai("obj_type", i4));
                    if (a.this.kXn.cWD().getPbData().kwH != null && a.this.kXn.cWD().getPbData().kwH.size() > i3) {
                        i3 = a.this.kXn.cWD().getPbData().kwH.get(i3).sort_type.intValue();
                    }
                    boolean En = a.this.kXn.cWD().En(i3);
                    view.setTag(Integer.valueOf(a.this.kXn.cWD().cYU()));
                    if (En) {
                        a.this.kXn.setIsLoading(true);
                    }
                }
            });
            iVar.Nv();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kXn.getActivity());
            aVar.zy(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.zz(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.m39if(false);
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
                    if (a.this.kXn.dec() != null) {
                        a.this.kXn.dec().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.kXn.getPageContext().getUniqueId(), a.this.kXn.cWD().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.kXn.getPageContext()).bhg();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.kDT);
        userMuteAddAndDelCustomMessage.setTag(this.kDT);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void Cd(String str) {
        if (str == null) {
            str = "";
        }
        if (this.kXn != null && this.kXn.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kXn.getPageContext().getPageActivity());
            aVar.zz(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kXn.getPageContext()).bhg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kXn.getBaseFragmentActivity());
        if (at.isEmpty(str)) {
            aVar.zz(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.zz(str);
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
        aVar.b(this.kXn.getPageContext()).bhg();
    }

    public void showLoadingDialog() {
        if (this.hpW == null) {
            this.hpW = new com.baidu.tbadk.core.view.a(this.kXn.getPageContext());
        }
        this.hpW.setDialogVisiable(true);
    }

    public void bWq() {
        if (this.hpW != null) {
            this.hpW.setDialogVisiable(false);
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        g gVar;
        if (this.kXn != null && this.kXn.cWD() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.kDE == null) {
                this.kDE = new k(this.kXn.getContext());
                this.kDE.a(this.kEw);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.kXn.cWD().getPbData() != null && this.kXn.cWD().getPbData().cVO();
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
                    g gVar2 = new g(8, (postData.bgv().hasAgree && postData.bgf() == 5) ? this.kXn.getString(R.string.action_cancel_dislike) : this.kXn.getString(R.string.action_dislike), this.kDE);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.mTextView.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        g gVar3 = new g(5, this.kXn.getString(R.string.mute_option), this.kDE);
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
                        if ((sT(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            g gVar4 = new g(5, this.kXn.getString(R.string.report_text), this.kDE);
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
                            gVar5 = new g(6, this.kXn.getString(R.string.delete), this.kDE);
                            gVar5.mTextView.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, this.kXn.getString(R.string.bar_manager), this.kDE);
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
                            if (this.kXn.cWD().getPbData().cVA() == 1002 && !z) {
                                gVar5 = new g(6, this.kXn.getString(R.string.report_text), this.kDE);
                            } else {
                                gVar5 = new g(6, this.kXn.getString(R.string.delete), this.kDE);
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
                this.kDE.aT(arrayList);
                this.kDD = new i(this.kXn.getPageContext(), this.kDE);
                this.kDD.Nv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eoq == null) {
                this.eoq = new com.baidu.tbadk.core.message.a();
            }
            if (this.enZ == null) {
                this.enZ = new com.baidu.tieba.tbadkCore.data.e();
                this.enZ.uniqueId = this.kXn.getUniqueId();
            }
            c cVar = new c();
            cVar.dWK = 5;
            cVar.dWQ = 8;
            cVar.dWP = 2;
            if (this.kXn != null && this.kXn.cWD() != null) {
                cVar.dWO = this.kXn.cWD().cZl();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dWR = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dWR = 1;
                        i = 0;
                    }
                }
                this.eoq.a(agreeData, i, this.kXn.getUniqueId(), false);
                this.eoq.a(agreeData, this.enZ);
                if (this.kXn == null && this.kXn.cWD() != null && this.kXn.cWD().getPbData() != null) {
                    this.eoq.a(this.kXn.cYi(), cVar, agreeData, this.kXn.cWD().getPbData().cVl());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dWR = 1;
            }
            i = 0;
            this.eoq.a(agreeData, i, this.kXn.getUniqueId(), false);
            this.eoq.a(agreeData, this.enZ);
            if (this.kXn == null) {
            }
        }
    }

    public void a(final b.InterfaceC0538b interfaceC0538b, boolean z) {
        if (this.kLi != null) {
            this.kLi.dismiss();
            this.kLi = null;
        }
        k kVar = new k(this.kXn.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kXn.cWD().getPbData() != null && this.kXn.cWD().getPbData().cVl() != null && !this.kXn.cWD().getPbData().cVl().isBjh()) {
            arrayList.add(new g(0, this.kXn.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.kXn.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aT(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.kLi.dismiss();
                interfaceC0538b.a(null, i, view);
            }
        });
        this.kLi = new i(this.kXn.getPageContext(), kVar);
        this.kLi.Nv();
    }

    public void aX(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.kLd == null) {
            this.kLd = LayoutInflater.from(this.kXn.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kXn.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kLd);
        if (this.kLc == null) {
            this.kLc = new Dialog(this.kXn.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kLc.setCanceledOnTouchOutside(true);
            this.kLc.setCancelable(true);
            this.kLl = (ScrollView) this.kLd.findViewById(R.id.good_scroll);
            this.kLc.setContentView(this.kLd);
            WindowManager.LayoutParams attributes = this.kLc.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kLc.getWindow().setAttributes(attributes);
            this.hmb = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.kLh = (String) compoundButton.getTag();
                        if (a.this.hma != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.hma) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.kLh != null && !str.equals(a.this.kLh)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kLe = (LinearLayout) this.kLd.findViewById(R.id.good_class_group);
            this.kLg = (TextView) this.kLd.findViewById(R.id.dialog_button_cancel);
            this.kLg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.kLc instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.kLc, a.this.kXn.getPageContext());
                    }
                }
            });
            this.kLf = (TextView) this.kLd.findViewById(R.id.dialog_button_ok);
            this.kLf.setOnClickListener(this.kXn.ddS());
        }
        this.kLe.removeAllViews();
        this.hma = new ArrayList();
        CustomBlueCheckRadioButton ft = ft("0", this.kXn.getPageContext().getString(R.string.thread_good_class));
        this.hma.add(ft);
        ft.setChecked(true);
        this.kLe.addView(ft);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bcS()) && ajVar.bcT() > 0) {
                    CustomBlueCheckRadioButton ft2 = ft(String.valueOf(ajVar.bcT()), ajVar.bcS());
                    this.hma.add(ft2);
                    View view = new View(this.kXn.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kLe.addView(view);
                    this.kLe.addView(ft2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kLl.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.kXn.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.kXn.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.kXn.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kLl.setLayoutParams(layoutParams2);
            this.kLl.removeAllViews();
            if (this.kLe != null && this.kLe.getParent() == null) {
                this.kLl.addView(this.kLe);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kLc, this.kXn.getPageContext());
    }

    private CustomBlueCheckRadioButton ft(String str, String str2) {
        Activity pageActivity = this.kXn.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.hmb);
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
        userMuteCheckCustomMessage.mId = this.kDT;
        userMuteCheckCustomMessage.setTag(this.kDT);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void dbg() {
        if (this.kLa != null) {
            this.kLa.dismiss();
        }
        if (this.kLb != null) {
            com.baidu.adp.lib.f.g.b(this.kLb, this.kXn.getPageContext());
        }
        if (this.kLc != null) {
            com.baidu.adp.lib.f.g.b(this.kLc, this.kXn.getPageContext());
        }
        if (this.kKZ != null) {
            this.kKZ.dismiss();
        }
    }

    public void deJ() {
        if (this.kDD != null) {
            this.kDD.dismiss();
        }
    }

    public void dbf() {
        aRN();
        this.kXn.dam();
        if (this.kDD != null) {
            this.kDD.dismiss();
        }
        dbg();
    }

    public void dbe() {
        aRN();
        this.kXn.dam();
        if (this.kDD != null) {
            this.kDD.dismiss();
        }
        this.kXn.cms();
        dbg();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener ddU() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b deK() {
        return this.kDb;
    }

    public void setPhoneNumber(String str) {
        this.kzz = str;
    }

    public String daK() {
        return this.kLh;
    }

    public View daJ() {
        if (this.kLd != null) {
            return this.kLd.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
