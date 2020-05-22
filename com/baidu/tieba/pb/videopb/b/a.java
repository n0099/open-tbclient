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
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.af;
import com.baidu.tieba.pb.pb.main.ag;
import com.baidu.tieba.pb.pb.main.az;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes9.dex */
public class a {
    public static int jSq = 3;
    public static int jSr = 0;
    public static int jSs = 3;
    public static int jSt = 4;
    public static int jSu = 5;
    public static int jSv = 6;
    private List<CustomBlueCheckRadioButton> gGr;
    private az hQO;
    private e hQx;
    private String jGL;
    private i jKE;
    private k jKF;
    public BdUniqueId jKU;
    private com.baidu.adp.widget.ImageView.a jKW;
    private String jKX;
    private TbRichTextMemeInfo jKY;
    private com.baidu.tieba.pb.pb.report.a jKw;
    private PbFragment.b jSY;
    public VideoPbFragment kdG;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i jRI = null;
    private com.baidu.tbadk.core.dialog.a jRA = null;
    private Dialog jRB = null;
    private Dialog jRC = null;
    private View jRD = null;
    private LinearLayout jRE = null;
    private TextView jRF = null;
    private TextView jRG = null;
    private String jRH = null;
    private ScrollView jRL = null;
    private CompoundButton.OnCheckedChangeListener gGs = null;
    private i jRz = null;
    private com.baidu.tbadk.core.view.a gKp = null;
    private com.baidu.tbadk.core.dialog.b jKc = null;
    private AlertDialog jXC = null;
    private af jXD = null;
    PostData ihL = null;
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        /* JADX WARN: Removed duplicated region for block: B:32:0x00af A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01fe  */
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
            if (a.this.kdG == null || !a.this.kdG.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.cD(view)) {
                    if (view instanceof TbImageView) {
                        a.this.jKW = ((TbImageView) view).getBdImage();
                        a.this.jKX = ((TbImageView) view).getUrl();
                        if (a.this.jKW == null || TextUtils.isEmpty(a.this.jKX)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.jKY = null;
                        } else {
                            a.this.jKY = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.jKW = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.jKX = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.jKY = null;
                            } else {
                                a.this.jKY = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.jKW = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.jKX = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.jKY = null;
                        } else {
                            a.this.jKY = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.jLI, a.this.jKW.isGif());
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
            a.this.ihL = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.ihL == null || a.this.kdG.cKE() == null) {
                return true;
            }
            if (!a.this.kdG.cKE().aML() || a.this.ihL.getId() == null || !a.this.ihL.getId().equals(a.this.kdG.cDy().aQG())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.kdG.cDy().getPbData() != null && a.this.kdG.cDy().getPbData().cCJ();
            if (a.this.jKF == null) {
                a.this.jKF = new k(a.this.kdG.getContext());
                a.this.jKF.a(a.this.jLJ);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cD(view) && !z3;
                boolean z5 = (!a.this.cD(view) || a.this.jKW == null || a.this.jKW.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.jKF));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.jKF));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.jKF);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.ihL);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.jKF);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.jKF);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.ihL);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.jKF);
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
                        if ((a.this.ru(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.jKF);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.jKF);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.jKF);
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
                            if (a.this.kdG.cDy().getPbData().cCx() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.jKF);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.jKF);
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
                a.this.jKF.aD(arrayList);
                a.this.jKE = new i(a.this.kdG.getPageContext(), a.this.jKF);
                a.this.jKE.showDialog();
                TiebaStatic.log(new an("c13272").dh("tid", a.this.kdG.cDy().cFt()).dh("fid", a.this.kdG.cDy().getForumId()).dh("uid", a.this.kdG.cDy().getPbData().cCi().aQx().getUserId()).dh("post_id", a.this.kdG.cDy().bdr()).ag("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c jLJ = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            int i2;
            if (a.this.jKE != null) {
                a.this.jKE.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.jKW != null && !TextUtils.isEmpty(a.this.jKX)) {
                        if (a.this.jKY == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.jKX));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.jKX;
                            aVar.pkgId = a.this.jKY.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.jKY.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.jKW = null;
                        a.this.jKX = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.jKW != null && !TextUtils.isEmpty(a.this.jKX)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.kdG.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.kdG.getPageContext().getPageActivity())) {
                            if (a.this.hQO == null) {
                                a.this.hQO = new az(a.this.kdG.getPageContext());
                            }
                            a.this.hQO.j(a.this.jKX, a.this.jKW.getImageByte());
                            a.this.jKW = null;
                            a.this.jKX = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.ihL != null) {
                        a.this.ihL.fp(a.this.kdG.getPageContext().getPageActivity());
                        a.this.ihL = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new an("c11739").ag("obj_locate", 2));
                    if (a.this.kdG.checkUpIsLogin()) {
                        a.this.cC(view);
                        if (a.this.kdG.cDy().getPbData().cCi() != null && a.this.kdG.cDy().getPbData().cCi().aQx() != null && a.this.kdG.cDy().getPbData().cCi().aQx().getUserId() != null && a.this.kdG.cKE() != null) {
                            int h = a.this.h(a.this.kdG.cDy().getPbData());
                            bk cCi = a.this.kdG.cDy().getPbData().cCi();
                            if (cCi.aPm()) {
                                i2 = 2;
                            } else if (cCi.aPn()) {
                                i2 = 3;
                            } else if (cCi.aSv()) {
                                i2 = 4;
                            } else {
                                i2 = cCi.aSw() ? 5 : 1;
                            }
                            TiebaStatic.log(new an("c12526").dh("tid", a.this.kdG.cDy().cFt()).ag("obj_locate", 2).dh("obj_id", a.this.kdG.cDy().getPbData().cCi().aQx().getUserId()).ag("obj_type", a.this.kdG.cKE().aML() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.kdG.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new an("c13079"));
                        a.this.Jl((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new an("c11739").ag("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            a.this.c(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!j.isNetWorkAvailable()) {
                        a.this.kdG.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray3.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray3.put(R.id.tag_from, 1);
                                sparseArray3.put(R.id.tag_check_mute_from, 2);
                                a.this.c(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            a.this.cI(view);
                            return;
                        } else if (booleanValue2) {
                            a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final b.a jLI = new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.jKW != null && !TextUtils.isEmpty(a.this.jKX)) {
                if (i == 0) {
                    if (a.this.jKY == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.jKX));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.jKX;
                        aVar.pkgId = a.this.jKY.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.jKY.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.kdG.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.kdG.getPageContext().getPageActivity())) {
                        if (a.this.hQO == null) {
                            a.this.hQO = new az(a.this.kdG.getPageContext());
                        }
                        a.this.hQO.j(a.this.jKX, a.this.jKW.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.jKW = null;
                a.this.jKX = null;
            }
        }
    };

    public void cEz() {
        com.baidu.tieba.pb.data.e pbData;
        bk cCi;
        if (this.kdG != null && this.kdG.cDy() != null && this.kdG.cDy().getPbData() != null && (cCi = (pbData = this.kdG.cDy().getPbData()).cCi()) != null && cCi.aQx() != null) {
            this.kdG.cHc();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cCi.aQx().getUserId());
            ag agVar = new ag();
            int cCx = this.kdG.cDy().getPbData().cCx();
            if (cCx == 1 || cCx == 3) {
                agVar.jPq = true;
                agVar.jPp = true;
                agVar.jPv = cCi.aQs() == 1;
                agVar.jPu = cCi.aQt() == 1;
            } else {
                agVar.jPq = false;
                agVar.jPp = false;
            }
            if (cCx == 1002 && !equals) {
                agVar.jPw = true;
            }
            agVar.jPn = rv(equals);
            agVar.jPr = cEA();
            agVar.jPo = rw(equals);
            agVar.DC = this.kdG.cDy().cFv();
            agVar.jPk = true;
            agVar.jPj = ru(equals);
            agVar.jPt = TbadkCoreApplication.getInst().getSkinType() == 1;
            agVar.jPs = true;
            agVar.isHostOnly = this.kdG.cDy().getHostMode();
            agVar.jPm = true;
            if (cCi.aQQ() == null) {
                agVar.jPl = true;
            } else {
                agVar.jPl = false;
            }
            if (pbData.cCJ()) {
                agVar.jPk = false;
                agVar.jPm = false;
                agVar.jPl = false;
                agVar.jPp = false;
                agVar.jPq = false;
            }
            a(agVar);
        }
    }

    private boolean rv(boolean z) {
        boolean z2;
        v vVar;
        if (this.kdG == null || this.kdG.cDy() == null || this.kdG.cDy().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.kdG.cDy().getPbData();
        bk cCi = pbData.cCi();
        if (cCi != null) {
            if (cCi.aPm() || cCi.aPn()) {
                return false;
            }
            if (cCi.aSv() || cCi.aSw()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cCx() != 0) {
                return pbData.cCx() != 3;
            }
            List<bg> cCE = pbData.cCE();
            if (com.baidu.tbadk.core.util.v.getCount(cCE) > 0) {
                for (bg bgVar : cCE) {
                    if (bgVar != null && (vVar = bgVar.dEk) != null && vVar.dCh && !vVar.dCi && (vVar.type == 1 || vVar.type == 2)) {
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

    private boolean rw(boolean z) {
        if (z || this.kdG == null || this.kdG.cDy() == null || this.kdG.cDy().getPbData() == null) {
            return false;
        }
        return ((this.kdG.cDy().getPbData().getForum() != null && this.kdG.cDy().getPbData().getForum().isBlockBawuDelete) || this.kdG.cDy().getPbData().cCx() == 0 || this.kdG.cDy().getPbData().cCx() == 3) ? false : true;
    }

    private boolean cEA() {
        if (this.kdG == null || this.kdG.cDy() == null || !this.kdG.cDy().cFv()) {
            return false;
        }
        return this.kdG.cDy().getPageData() == null || this.kdG.cDy().getPageData().aPu() != 0;
    }

    public void a(ag agVar) {
        if (!this.kdG.getBaseFragmentActivity().isProgressBarShown()) {
            this.jXD = new af(this.kdG, this.kdG.aUZ);
            this.jXC = new AlertDialog.Builder(this.kdG.getContext(), R.style.DialogTheme).create();
            this.jXC.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.jXC, this.kdG.getFragmentActivity());
            Window window = this.jXC.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.jXD.getView());
            this.jXD.rI(agVar == null ? false : agVar.jPj);
            this.jXD.rJ(agVar == null ? false : agVar.jPn);
            this.jXD.rK(agVar == null ? false : agVar.jPr);
            this.jXD.rL(agVar == null ? false : agVar.jPo);
            this.jXD.rM(agVar == null ? true : agVar.jPl);
            if (agVar == null) {
                this.jXD.ae(false, false);
                this.jXD.af(false, false);
            } else {
                this.jXD.ae(agVar.jPp, agVar.jPv);
                this.jXD.af(agVar.jPq, agVar.jPu);
            }
            boolean z = agVar == null ? false : agVar.DC;
            boolean z2 = agVar == null ? false : agVar.isHostOnly;
            boolean z3 = agVar == null ? false : agVar.jPm;
            boolean z4 = agVar == null ? false : agVar.jPk;
            boolean z5 = agVar == null ? false : agVar.jPt;
            boolean z6 = agVar == null ? false : agVar.jPs;
            this.jXD.ad(z3, z2);
            this.jXD.ag(z4, z);
            this.jXD.ah(z6, z5);
            if (agVar != null) {
                this.jXD.jPg = agVar.jPw;
                if (agVar.jPw) {
                    this.jXD.cGF().setText(R.string.report_text);
                    this.jXD.rL(false);
                }
            }
            cIX();
        }
    }

    private void cIX() {
        if (this.jXD != null) {
            this.jXD.cGL();
        }
    }

    public void aEa() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.jXC != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.jXC, a.this.kdG.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.ld().postDelayed(this.runnable, 100L);
    }

    public void cIY() {
        if (this.jXC != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.jXC, this.kdG.getPageContext().getPageActivity());
        }
    }

    public af cIZ() {
        return this.jXD;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.kdG = videoPbFragment;
        this.jKU = videoPbFragment.getUniqueId();
        this.jKw = new com.baidu.tieba.pb.pb.report.a(this.kdG.getContext());
        this.jKw.w(this.kdG.getUniqueId());
        this.jSY = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.kdG.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.kdG.cDy().getPbData().getUserData().getUserId());
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
                a.this.kdG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.kdG.getPageContext().getPageActivity(), a.this.kdG.cDy().getPbData().getForum().getId(), a.this.kdG.cDy().getPbData().getForum().getName(), a.this.kdG.cDy().getPbData().cCi().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(View view) {
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
        PostData H;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.kdG.cDy().aQG())) {
                z = true;
            }
            MarkData o = this.kdG.cDy().o(postData);
            if (this.kdG.cDy().getPbData() != null && this.kdG.cDy().getPbData().cCJ() && (H = this.kdG.H(this.kdG.cDy().getPbData())) != null) {
                o = this.kdG.cDy().o(H);
            }
            if (o != null) {
                this.kdG.cHB();
                if (this.kdG.cKE() != null) {
                    this.kdG.cKE().a(o);
                    if (!z) {
                        this.kdG.cKE().aMN();
                    } else {
                        this.kdG.cKE().aMM();
                    }
                }
            }
        }
    }

    public int h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCi() != null) {
            if (eVar.cCi().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cCi().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cCi().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ru(boolean z) {
        if (this.kdG.cDy() == null || this.kdG.cDy().getPbData() == null) {
            return false;
        }
        return ((this.kdG.cDy().getPbData().cCx() != 0) || this.kdG.cDy().getPbData().cCi() == null || this.kdG.cDy().getPbData().cCi().aQx() == null || TextUtils.equals(this.kdG.cDy().getPbData().cCi().aQx().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Jl(String str) {
        if (this.kdG.cDy() != null && this.kdG.cDy().getPbData() != null && this.kdG.cDy().getPbData().cCJ()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kdG.cDy().cFt(), str);
            bk cCi = this.kdG.cDy().getPbData().cCi();
            if (cCi.aPm()) {
                format = format + "&channelid=33833";
            } else if (cCi.aSu()) {
                format = format + "&channelid=33842";
            } else if (cCi.aPn()) {
                format = format + "&channelid=33840";
            }
            Jm(format);
            return;
        }
        this.jKw.JM(str);
    }

    private void Jm(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.kdG.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.jKE != null && this.jKE.isShowing()) {
                this.jKE.dismiss();
                this.jKE = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.kdG.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.jKE != null) {
                            a.this.jKE.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.jKU);
                            userMuteAddAndDelCustomMessage.setTag(a.this.jKU);
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
                kVar.aD(arrayList);
                this.jKE = new i(this.kdG.getPageContext(), kVar);
                this.jKE.showDialog();
            }
        }
    }

    public void cEV() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kdG.getPageContext().getPageActivity());
        aVar.vO(this.kdG.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.kdG.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.kdG.getPageContext()).aST();
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
        sparseArray.put(jSr, Integer.valueOf(jSs));
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
        this.jRA = new com.baidu.tbadk.core.dialog.a(this.kdG.getActivity());
        if (StringUtils.isNull(str2)) {
            this.jRA.kD(i3);
        } else {
            this.jRA.setOnlyMessageShowCenter(false);
            this.jRA.vO(str2);
        }
        this.jRA.setYesButtonTag(sparseArray);
        this.jRA.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.kdG.a(aVar, (JSONArray) null);
            }
        });
        this.jRA.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jRA.gW(true);
        this.jRA.b(this.kdG.getPageContext());
        if (z) {
            this.jRA.aST();
        } else {
            a(this.jRA, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kdG != null && aVar != null) {
            if (this.hQx == null && this.kdG.getView() != null) {
                this.hQx = new e(this.kdG.getPageContext(), this.kdG.getView());
            }
            AntiData bUa = bUa();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bUa != null && bUa.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bUa.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            ak akVar = new ak();
            akVar.setFeedBackReasonMap(sparseArray);
            this.hQx.setDefaultReasonArray(new String[]{this.kdG.getString(R.string.delete_thread_reason_1), this.kdG.getString(R.string.delete_thread_reason_2), this.kdG.getString(R.string.delete_thread_reason_3), this.kdG.getString(R.string.delete_thread_reason_4), this.kdG.getString(R.string.delete_thread_reason_5)});
            this.hQx.setData(akVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.hQx.zj(str);
            this.hQx.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    a.this.kdG.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData bUa() {
        if (this.kdG.cDy() == null || this.kdG.cDy().getPbData() == null) {
            return null;
        }
        return this.kdG.cDy().getPbData().getAnti();
    }

    public void cI(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.kdG.getContext());
        kVar.setTitleText(this.kdG.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.jRz.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.jSY != null) {
                                a.this.jSY.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
        int i = -1;
        if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
        }
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i != 2) {
            int i2 = -1;
            if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            }
            if (i2 == 0) {
                gVar2 = new g(0, this.kdG.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.kdG.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.kdG.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.kdG.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.kdG.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aD(arrayList);
        if (this.jRz == null) {
            this.jRz = new i(this.kdG.getPageContext(), kVar);
        } else {
            this.jRz.a(kVar);
        }
        this.jRz.showDialog();
    }

    public void cEs() {
        if (this.jKc == null) {
            this.jKc = new com.baidu.tbadk.core.dialog.b(this.kdG.getPageContext().getPageActivity());
            this.jKc.a(new String[]{this.kdG.getPageContext().getString(R.string.call_phone), this.kdG.getPageContext().getString(R.string.sms_phone), this.kdG.getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.kdG.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.jGL = a.this.jGL.trim();
                        UtilHelper.callPhone(a.this.kdG.getPageContext().getPageActivity(), a.this.jGL);
                        new com.baidu.tieba.pb.pb.main.b(a.this.kdG.cDy().cFt(), a.this.jGL, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.kdG.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.jGL = a.this.jGL.trim();
                        UtilHelper.smsPhone(a.this.kdG.getPageContext().getPageActivity(), a.this.jGL);
                        new com.baidu.tieba.pb.pb.main.b(a.this.kdG.cDy().cFt(), a.this.jGL, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.jGL = a.this.jGL.trim();
                        UtilHelper.startBaiDuBar(a.this.kdG.getPageContext().getPageActivity(), a.this.jGL);
                        bVar.dismiss();
                    }
                }
            }).kI(R.style.dialog_ani_b2t).kJ(17).d(this.kdG.getPageContext());
        }
    }

    public void cP(final View view) {
        String[] strArr;
        int i = 0;
        if (this.kdG != null && this.kdG.cDy() != null) {
            final i iVar = new i(this.kdG.getPageContext());
            if (this.kdG.cDy().getPbData().jDV == null || this.kdG.cDy().getPbData().jDV.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.kdG.cDy().getPbData().jDV.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.kdG.cDy().getPbData().jDV.size()) {
                        break;
                    }
                    strArr2[i2] = this.kdG.cDy().getPbData().jDV.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.kdG.cDy().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.kdG.cDy().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.kdG.cDy().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.kdG.cDy().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new an("c12097").ag("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ag("obj_type", i4));
                    if (a.this.kdG.cDy().getPbData().jDV != null && a.this.kdG.cDy().getPbData().jDV.size() > i3) {
                        i3 = a.this.kdG.cDy().getPbData().jDV.get(i3).sort_type.intValue();
                    }
                    boolean Aq = a.this.kdG.cDy().Aq(i3);
                    view.setTag(Integer.valueOf(a.this.kdG.cDy().cFM()));
                    if (Aq) {
                        a.this.kdG.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kdG.getActivity());
            aVar.vN(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.vO(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.gW(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").dh("obj_id", metaData.getUserId()).ag("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").dh("obj_id", metaData.getUserId()).ag("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.kdG.cKP() != null) {
                        a.this.kdG.cKP().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.kdG.getPageContext().getUniqueId(), a.this.kdG.cDy().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.kdG.getPageContext()).aST();
            TiebaStatic.log(new an("c12527"));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.jKU);
        userMuteAddAndDelCustomMessage.setTag(this.jKU);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void yo(String str) {
        if (str == null) {
            str = "";
        }
        if (this.kdG != null && this.kdG.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kdG.getPageContext().getPageActivity());
            aVar.vO(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kdG.getPageContext()).aST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kdG.getBaseFragmentActivity());
        if (aq.isEmpty(str)) {
            aVar.vO(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.vO(str);
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
        aVar.b(this.kdG.getPageContext()).aST();
    }

    public void showLoadingDialog() {
        if (this.gKp == null) {
            this.gKp = new com.baidu.tbadk.core.view.a(this.kdG.getPageContext());
        }
        this.gKp.setDialogVisiable(true);
    }

    public void bGf() {
        if (this.gKp != null) {
            this.gKp.setDialogVisiable(false);
        }
    }

    public void a(final b.a aVar, boolean z) {
        if (this.jRI != null) {
            this.jRI.dismiss();
            this.jRI = null;
        }
        k kVar = new k(this.kdG.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kdG.cDy().getPbData() != null && this.kdG.cDy().getPbData().cCi() != null && !this.kdG.cDy().getPbData().cCi().isBjh()) {
            arrayList.add(new g(0, this.kdG.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.kdG.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aD(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.jRI.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jRI = new i(this.kdG.getPageContext(), kVar);
        this.jRI.showDialog();
    }

    public void aP(ArrayList<ac> arrayList) {
        if (this.jRD == null) {
            this.jRD = LayoutInflater.from(this.kdG.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kdG.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jRD);
        if (this.jRC == null) {
            this.jRC = new Dialog(this.kdG.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jRC.setCanceledOnTouchOutside(true);
            this.jRC.setCancelable(true);
            this.jRL = (ScrollView) this.jRD.findViewById(R.id.good_scroll);
            this.jRC.setContentView(this.jRD);
            WindowManager.LayoutParams attributes = this.jRC.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.jRC.getWindow().setAttributes(attributes);
            this.gGs = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.jRH = (String) compoundButton.getTag();
                        if (a.this.gGr != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.gGr) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.jRH != null && !str.equals(a.this.jRH)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.jRE = (LinearLayout) this.jRD.findViewById(R.id.good_class_group);
            this.jRG = (TextView) this.jRD.findViewById(R.id.dialog_button_cancel);
            this.jRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jRC instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.jRC, a.this.kdG.getPageContext());
                    }
                }
            });
            this.jRF = (TextView) this.jRD.findViewById(R.id.dialog_button_ok);
            this.jRF.setOnClickListener(this.kdG.cKF());
        }
        this.jRE.removeAllViews();
        this.gGr = new ArrayList();
        CustomBlueCheckRadioButton eT = eT("0", this.kdG.getPageContext().getString(R.string.thread_good_class));
        this.gGr.add(eT);
        eT.setChecked(true);
        this.jRE.addView(eT);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ac acVar = arrayList.get(i2);
                if (acVar != null && !TextUtils.isEmpty(acVar.aOS()) && acVar.aOT() > 0) {
                    CustomBlueCheckRadioButton eT2 = eT(String.valueOf(acVar.aOT()), acVar.aOS());
                    this.gGr.add(eT2);
                    View view = new View(this.kdG.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.jRE.addView(view);
                    this.jRE.addView(eT2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.jRL.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.kdG.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.kdG.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.kdG.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.jRL.setLayoutParams(layoutParams2);
            this.jRL.removeAllViews();
            if (this.jRE != null && this.jRE.getParent() == null) {
                this.jRL.addView(this.jRE);
            }
        }
        com.baidu.adp.lib.f.g.a(this.jRC, this.kdG.getPageContext());
    }

    private CustomBlueCheckRadioButton eT(String str, String str2) {
        Activity pageActivity = this.kdG.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.gGs);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean cD(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.jKU;
        userMuteCheckCustomMessage.setTag(this.jKU);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cHW() {
        if (this.jRA != null) {
            this.jRA.dismiss();
        }
        if (this.jRB != null) {
            com.baidu.adp.lib.f.g.b(this.jRB, this.kdG.getPageContext());
        }
        if (this.jRC != null) {
            com.baidu.adp.lib.f.g.b(this.jRC, this.kdG.getPageContext());
        }
        if (this.jRz != null) {
            this.jRz.dismiss();
        }
    }

    public void cLs() {
        if (this.jKE != null) {
            this.jKE.dismiss();
        }
    }

    public void cHV() {
        aEa();
        this.kdG.cHc();
        if (this.jKE != null) {
            this.jKE.dismiss();
        }
        cHW();
    }

    public void cHU() {
        aEa();
        this.kdG.cHc();
        if (this.jKE != null) {
            this.jKE.dismiss();
        }
        this.kdG.bVo();
        cHW();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener cKH() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b cLt() {
        return this.jKc;
    }

    public void setPhoneNumber(String str) {
        this.jGL = str;
    }

    public String cHA() {
        return this.jRH;
    }

    public View cHz() {
        if (this.jRD != null) {
            return this.jRD.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
