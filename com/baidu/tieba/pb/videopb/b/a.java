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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.w;
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
import com.baidu.tbadk.core.util.v;
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
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.main.z;
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
    public static int iPg = 3;
    public static int iPh = 0;
    public static int iPi = 3;
    public static int iPj = 4;
    public static int iPk = 5;
    public static int iPl = 6;
    private List<CustomBlueCheckRadioButton> fMh;
    private ar gQN;
    private e gQv;
    private String iEq;
    private com.baidu.tieba.pb.pb.report.a iHM;
    private i iHU;
    private k iHV;
    public BdUniqueId iIk;
    private com.baidu.adp.widget.ImageView.a iIm;
    private String iIn;
    private TbRichTextMemeInfo iIo;
    private PbFragment.b iPO;
    public VideoPbFragment jah;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i iOB = null;
    private com.baidu.tbadk.core.dialog.a iOt = null;
    private Dialog iOu = null;
    private Dialog iOv = null;
    private View iOw = null;
    private LinearLayout iOx = null;
    private TextView iOy = null;
    private TextView iOz = null;
    private String iOA = null;
    private ScrollView iOE = null;
    private CompoundButton.OnCheckedChangeListener fMi = null;
    private i iOs = null;
    private com.baidu.tbadk.core.view.a fQi = null;
    private com.baidu.tbadk.core.dialog.b iHt = null;
    private AlertDialog iUf = null;
    private y iUg = null;
    PostData hhL = null;
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
            if (a.this.jah == null || !a.this.jah.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.cv(view)) {
                    if (view instanceof TbImageView) {
                        a.this.iIm = ((TbImageView) view).getBdImage();
                        a.this.iIn = ((TbImageView) view).getUrl();
                        if (a.this.iIm == null || TextUtils.isEmpty(a.this.iIn)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.iIo = null;
                        } else {
                            a.this.iIo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.iIm = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.iIn = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.iIo = null;
                            } else {
                                a.this.iIo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.iIm = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.iIn = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.iIo = null;
                        } else {
                            a.this.iIo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.iIW, a.this.iIm.isGif());
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
            a.this.hhL = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.hhL == null || a.this.jah.csI() == null) {
                return true;
            }
            if (!a.this.jah.csI().ayL() || a.this.hhL.getId() == null || !a.this.hhL.getId().equals(a.this.jah.clC().aCx())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.jah.clC().getPbData() != null && a.this.jah.clC().getPbData().ckT();
            if (a.this.iHV == null) {
                a.this.iHV = new k(a.this.jah.getContext());
                a.this.iHV.a(a.this.iIX);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cv(view) && !z3;
                boolean z5 = (!a.this.cv(view) || a.this.iIm == null || a.this.iIm.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.iHV));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.iHV));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.iHV);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.hhL);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.iHV);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.iHV);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.hhL);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.iHV);
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
                        if ((a.this.pL(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.iHV);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.iHV);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.iHV);
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
                            if (a.this.jah.clC().getPbData().ckH() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.iHV);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.iHV);
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
                a.this.iHV.az(arrayList);
                a.this.iHU = new i(a.this.jah.getPageContext(), a.this.iHV);
                a.this.iHU.showDialog();
                TiebaStatic.log(new an("c13272").cy("tid", a.this.jah.clC().cnz()).cy("fid", a.this.jah.clC().getForumId()).cy("uid", a.this.jah.clC().getPbData().ckv().aCo().getUserId()).cy("post_id", a.this.jah.clC().aOP()).X("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c iIX = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            int i2;
            if (a.this.iHU != null) {
                a.this.iHU.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.iIm != null && !TextUtils.isEmpty(a.this.iIn)) {
                        if (a.this.iIo == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.iIn));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.iIn;
                            aVar.pkgId = a.this.iIo.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.iIo.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.iIm = null;
                        a.this.iIn = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.iIm != null && !TextUtils.isEmpty(a.this.iIn)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.jah.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.jah.getPageContext().getPageActivity())) {
                            if (a.this.gQN == null) {
                                a.this.gQN = new ar(a.this.jah.getPageContext());
                            }
                            a.this.gQN.j(a.this.iIn, a.this.iIm.getImageByte());
                            a.this.iIm = null;
                            a.this.iIn = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.hhL != null) {
                        a.this.hhL.fv(a.this.jah.getPageContext().getPageActivity());
                        a.this.hhL = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new an("c11739").X("obj_locate", 2));
                    if (a.this.jah.checkUpIsLogin()) {
                        a.this.cu(view);
                        if (a.this.jah.clC().getPbData().ckv() != null && a.this.jah.clC().getPbData().ckv().aCo() != null && a.this.jah.clC().getPbData().ckv().aCo().getUserId() != null && a.this.jah.csI() != null) {
                            int g = a.this.g(a.this.jah.clC().getPbData());
                            bj ckv = a.this.jah.clC().getPbData().ckv();
                            if (ckv.aBd()) {
                                i2 = 2;
                            } else if (ckv.aBe()) {
                                i2 = 3;
                            } else if (ckv.aEg()) {
                                i2 = 4;
                            } else {
                                i2 = ckv.aEh() ? 5 : 1;
                            }
                            TiebaStatic.log(new an("c12526").cy("tid", a.this.jah.clC().cnz()).X("obj_locate", 2).cy("obj_id", a.this.jah.clC().getPbData().ckv().aCo().getUserId()).X("obj_type", a.this.jah.csI().ayL() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.jah.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new an("c13079"));
                        a.this.FQ((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new an("c11739").X("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            a.this.b(sparseArray);
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
                        a.this.jah.showToast(R.string.network_not_available);
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
                                a.this.b(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            a.this.cA(view);
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
    private final b.a iIW = new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.iIm != null && !TextUtils.isEmpty(a.this.iIn)) {
                if (i == 0) {
                    if (a.this.iIo == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.iIn));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.iIn;
                        aVar.pkgId = a.this.iIo.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.iIo.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.jah.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.jah.getPageContext().getPageActivity())) {
                        if (a.this.gQN == null) {
                            a.this.gQN = new ar(a.this.jah.getPageContext());
                        }
                        a.this.gQN.j(a.this.iIn, a.this.iIm.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.iIm = null;
                a.this.iIn = null;
            }
        }
    };

    public void cmG() {
        com.baidu.tieba.pb.data.e pbData;
        bj ckv;
        if (this.jah != null && this.jah.clC() != null && this.jah.clC().getPbData() != null && (ckv = (pbData = this.jah.clC().getPbData()).ckv()) != null && ckv.aCo() != null) {
            this.jah.cph();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), ckv.aCo().getUserId());
            z zVar = new z();
            int ckH = this.jah.clC().getPbData().ckH();
            if (ckH == 1 || ckH == 3) {
                zVar.iMn = true;
                zVar.iMm = true;
                zVar.iMs = ckv.aCj() == 1;
                zVar.iMr = ckv.aCk() == 1;
            } else {
                zVar.iMn = false;
                zVar.iMm = false;
            }
            if (ckH == 1002 && !equals) {
                zVar.iMt = true;
            }
            zVar.iMk = pM(equals);
            zVar.iMo = cmH();
            zVar.iMl = pN(equals);
            zVar.hW = this.jah.clC().cnA();
            zVar.iMh = true;
            zVar.iMg = pL(equals);
            zVar.iMq = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.iMp = true;
            zVar.isHostOnly = this.jah.clC().getHostMode();
            zVar.iMj = true;
            if (ckv.aCF() == null) {
                zVar.iMi = true;
            } else {
                zVar.iMi = false;
            }
            if (pbData.ckT()) {
                zVar.iMh = false;
                zVar.iMj = false;
                zVar.iMi = false;
                zVar.iMm = false;
                zVar.iMn = false;
            }
            a(zVar);
        }
    }

    private boolean pM(boolean z) {
        boolean z2;
        w wVar;
        if (this.jah == null || this.jah.clC() == null || this.jah.clC().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.jah.clC().getPbData();
        bj ckv = pbData.ckv();
        if (ckv != null) {
            if (ckv.aBd() || ckv.aBe()) {
                return false;
            }
            if (ckv.aEg() || ckv.aEh()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.ckH() != 0) {
                return pbData.ckH() != 3;
            }
            List<bf> ckO = pbData.ckO();
            if (v.getCount(ckO) > 0) {
                for (bf bfVar : ckO) {
                    if (bfVar != null && (wVar = bfVar.cQQ) != null && wVar.cOK && !wVar.cOL && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean pN(boolean z) {
        if (z || this.jah == null || this.jah.clC() == null || this.jah.clC().getPbData() == null) {
            return false;
        }
        return ((this.jah.clC().getPbData().getForum() != null && this.jah.clC().getPbData().getForum().isBlockBawuDelete) || this.jah.clC().getPbData().ckH() == 0 || this.jah.clC().getPbData().ckH() == 3) ? false : true;
    }

    private boolean cmH() {
        if (this.jah == null || this.jah.clC() == null || !this.jah.clC().cnA()) {
            return false;
        }
        return this.jah.clC().getPageData() == null || this.jah.clC().getPageData().aBl() != 0;
    }

    public void a(z zVar) {
        if (!this.jah.getBaseFragmentActivity().isProgressBarShown()) {
            this.iUg = new y(this.jah, this.jah.auY);
            this.iUf = new AlertDialog.Builder(this.jah.getContext(), R.style.DialogTheme).create();
            this.iUf.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.iUf, this.jah.getFragmentActivity());
            Window window = this.iUf.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iUg.getView());
            this.iUg.pZ(zVar == null ? false : zVar.iMg);
            this.iUg.qa(zVar == null ? false : zVar.iMk);
            this.iUg.qb(zVar == null ? false : zVar.iMo);
            this.iUg.qc(zVar == null ? false : zVar.iMl);
            this.iUg.qd(zVar == null ? true : zVar.iMi);
            if (zVar == null) {
                this.iUg.aa(false, false);
                this.iUg.ab(false, false);
            } else {
                this.iUg.aa(zVar.iMm, zVar.iMs);
                this.iUg.ab(zVar.iMn, zVar.iMr);
            }
            boolean z = zVar == null ? false : zVar.hW;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.iMj;
            boolean z4 = zVar == null ? false : zVar.iMh;
            boolean z5 = zVar == null ? false : zVar.iMq;
            boolean z6 = zVar == null ? false : zVar.iMp;
            this.iUg.Z(z3, z2);
            this.iUg.ac(z4, z);
            this.iUg.ad(z6, z5);
            if (zVar != null) {
                this.iUg.iMd = zVar.iMt;
                if (zVar.iMt) {
                    this.iUg.coK().setText(R.string.report_text);
                    this.iUg.qc(false);
                }
            }
            crb();
        }
    }

    private void crb() {
        if (this.iUg != null) {
            this.iUg.coQ();
        }
    }

    public void arU() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.iUf != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.iUf, a.this.jah.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.gx().postDelayed(this.runnable, 100L);
    }

    public void crc() {
        if (this.iUf != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.iUf, this.jah.getPageContext().getPageActivity());
        }
    }

    public y crd() {
        return this.iUg;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.jah = videoPbFragment;
        this.iIk = videoPbFragment.getUniqueId();
        this.iHM = new com.baidu.tieba.pb.pb.report.a(this.jah.getContext());
        this.iHM.t(this.jah.getUniqueId());
        this.iPO = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.jah.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.jah.clC().getPbData().getUserData().getUserId());
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
                a.this.jah.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.jah.getPageContext().getPageActivity(), a.this.jah.clC().getPbData().getForum().getId(), a.this.jah.clC().getPbData().getForum().getName(), a.this.jah.clC().getPbData().ckv().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            k(postData);
        }
    }

    protected void k(PostData postData) {
        PostData F;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.jah.clC().aCx())) {
                z = true;
            }
            MarkData l = this.jah.clC().l(postData);
            if (this.jah.clC().getPbData() != null && this.jah.clC().getPbData().ckT() && (F = this.jah.F(this.jah.clC().getPbData())) != null) {
                l = this.jah.clC().l(F);
            }
            if (l != null) {
                this.jah.cpG();
                if (this.jah.csI() != null) {
                    this.jah.csI().a(l);
                    if (!z) {
                        this.jah.csI().ayN();
                    } else {
                        this.jah.csI().ayM();
                    }
                }
            }
        }
    }

    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckv() != null) {
            if (eVar.ckv().getThreadType() == 0) {
                return 1;
            }
            if (eVar.ckv().getThreadType() == 54) {
                return 2;
            }
            if (eVar.ckv().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.jah.clC() == null || this.jah.clC().getPbData() == null) {
            return false;
        }
        return ((this.jah.clC().getPbData().ckH() != 0) || this.jah.clC().getPbData().ckv() == null || this.jah.clC().getPbData().ckv().aCo() == null || TextUtils.equals(this.jah.clC().getPbData().ckv().aCo().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void FQ(String str) {
        if (this.jah.clC() != null && this.jah.clC().getPbData() != null && this.jah.clC().getPbData().ckT()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jah.clC().cnz(), str);
            bj ckv = this.jah.clC().getPbData().ckv();
            if (ckv.aBd()) {
                format = format + "&channelid=33833";
            } else if (ckv.aEf()) {
                format = format + "&channelid=33842";
            } else if (ckv.aBe()) {
                format = format + "&channelid=33840";
            }
            FR(format);
            return;
        }
        this.iHM.Gq(str);
    }

    private void FR(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.jah.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iHU != null && this.iHU.isShowing()) {
                this.iHU.dismiss();
                this.iHU = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.jah.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.iHU != null) {
                            a.this.iHU.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.iIk);
                            userMuteAddAndDelCustomMessage.setTag(a.this.iIk);
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
                kVar.az(arrayList);
                this.iHU = new i(this.jah.getPageContext(), kVar);
                this.iHU.showDialog();
            }
        }
    }

    public void cnc() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jah.getPageContext().getPageActivity());
        aVar.sS(this.jah.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.jah.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.jah.getPageContext()).aEC();
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
        sparseArray.put(iPh, Integer.valueOf(iPi));
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
        this.iOt = new com.baidu.tbadk.core.dialog.a(this.jah.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iOt.jW(i3);
        } else {
            this.iOt.setOnlyMessageShowCenter(false);
            this.iOt.sS(str2);
        }
        this.iOt.setYesButtonTag(sparseArray);
        this.iOt.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jah.a(aVar, (JSONArray) null);
            }
        });
        this.iOt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iOt.fG(true);
        this.iOt.b(this.jah.getPageContext());
        if (z) {
            this.iOt.aEC();
        } else {
            a(this.iOt, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.jah != null && aVar != null) {
            if (this.gQv == null && this.jah.getView() != null) {
                this.gQv = new e(this.jah.getPageContext(), this.jah.getView());
            }
            AntiData bCZ = bCZ();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bCZ != null && bCZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCZ.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gQv.setDefaultReasonArray(new String[]{this.jah.getString(R.string.delete_thread_reason_1), this.jah.getString(R.string.delete_thread_reason_2), this.jah.getString(R.string.delete_thread_reason_3), this.jah.getString(R.string.delete_thread_reason_4), this.jah.getString(R.string.delete_thread_reason_5)});
            this.gQv.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gQv.wn(str);
            this.gQv.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    a.this.jah.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData bCZ() {
        if (this.jah.clC() == null || this.jah.clC().getPbData() == null) {
            return null;
        }
        return this.jah.clC().getPbData().getAnti();
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.jah.getContext());
        kVar.setTitleText(this.jah.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.iOs.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.iPO != null) {
                                a.this.iPO.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.jah.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.jah.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.jah.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.jah.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.jah.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.az(arrayList);
        if (this.iOs == null) {
            this.iOs = new i(this.jah.getPageContext(), kVar);
        } else {
            this.iOs.a(kVar);
        }
        this.iOs.showDialog();
    }

    public void cmy() {
        if (this.iHt == null) {
            this.iHt = new com.baidu.tbadk.core.dialog.b(this.jah.getPageContext().getPageActivity());
            this.iHt.a(new String[]{this.jah.getPageContext().getString(R.string.call_phone), this.jah.getPageContext().getString(R.string.sms_phone), this.jah.getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.jah.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.iEq = a.this.iEq.trim();
                        UtilHelper.callPhone(a.this.jah.getPageContext().getPageActivity(), a.this.iEq);
                        new com.baidu.tieba.pb.pb.main.a(a.this.jah.clC().cnz(), a.this.iEq, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.jah.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.iEq = a.this.iEq.trim();
                        UtilHelper.smsPhone(a.this.jah.getPageContext().getPageActivity(), a.this.iEq);
                        new com.baidu.tieba.pb.pb.main.a(a.this.jah.clC().cnz(), a.this.iEq, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.iEq = a.this.iEq.trim();
                        UtilHelper.startBaiDuBar(a.this.jah.getPageContext().getPageActivity(), a.this.iEq);
                        bVar.dismiss();
                    }
                }
            }).kb(R.style.dialog_ani_b2t).kc(17).d(this.jah.getPageContext());
        }
    }

    public void cG(final View view) {
        String[] strArr;
        int i = 0;
        if (this.jah != null && this.jah.clC() != null) {
            final i iVar = new i(this.jah.getPageContext());
            if (this.jah.clC().getPbData().iBP == null || this.jah.clC().getPbData().iBP.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.jah.clC().getPbData().iBP.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.jah.clC().getPbData().iBP.size()) {
                        break;
                    }
                    strArr2[i2] = this.jah.clC().getPbData().iBP.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.jah.clC().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.jah.clC().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.jah.clC().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.jah.clC().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new an("c12097").X("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).X("obj_type", i4));
                    if (a.this.jah.clC().getPbData().iBP != null && a.this.jah.clC().getPbData().iBP.size() > i3) {
                        i3 = a.this.jah.clC().getPbData().iBP.get(i3).sort_type.intValue();
                    }
                    boolean yW = a.this.jah.clC().yW(i3);
                    view.setTag(Integer.valueOf(a.this.jah.clC().cnR()));
                    if (yW) {
                        a.this.jah.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jah.getActivity());
            aVar.sR(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.sS(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.fG(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cy("obj_id", metaData.getUserId()).X("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cy("obj_id", metaData.getUserId()).X("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.jah.csT() != null) {
                        a.this.jah.csT().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.jah.getPageContext().getUniqueId(), a.this.jah.clC().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.jah.getPageContext()).aEC();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iIk);
        userMuteAddAndDelCustomMessage.setTag(this.iIk);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void vr(String str) {
        if (str == null) {
            str = "";
        }
        if (this.jah != null && this.jah.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jah.getPageContext().getPageActivity());
            aVar.sS(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jah.getPageContext()).aEC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jah.getBaseFragmentActivity());
        if (aq.isEmpty(str)) {
            aVar.sS(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sS(str);
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
        aVar.b(this.jah.getPageContext()).aEC();
    }

    public void showLoadingDialog() {
        if (this.fQi == null) {
            this.fQi = new com.baidu.tbadk.core.view.a(this.jah.getPageContext());
        }
        this.fQi.setDialogVisiable(true);
    }

    public void bqs() {
        if (this.fQi != null) {
            this.fQi.setDialogVisiable(false);
        }
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iOB != null) {
            this.iOB.dismiss();
            this.iOB = null;
        }
        k kVar = new k(this.jah.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.jah.clC().getPbData() != null && this.jah.clC().getPbData().ckv() != null && !this.jah.clC().getPbData().ckv().isBjh()) {
            arrayList.add(new g(0, this.jah.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.jah.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.iOB.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iOB = new i(this.jah.getPageContext(), kVar);
        this.iOB.showDialog();
    }

    public void aM(ArrayList<ad> arrayList) {
        if (this.iOw == null) {
            this.iOw = LayoutInflater.from(this.jah.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.jah.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iOw);
        if (this.iOv == null) {
            this.iOv = new Dialog(this.jah.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iOv.setCanceledOnTouchOutside(true);
            this.iOv.setCancelable(true);
            this.iOE = (ScrollView) this.iOw.findViewById(R.id.good_scroll);
            this.iOv.setContentView(this.iOw);
            WindowManager.LayoutParams attributes = this.iOv.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iOv.getWindow().setAttributes(attributes);
            this.fMi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.iOA = (String) compoundButton.getTag();
                        if (a.this.fMh != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.fMh) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.iOA != null && !str.equals(a.this.iOA)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iOx = (LinearLayout) this.iOw.findViewById(R.id.good_class_group);
            this.iOz = (TextView) this.iOw.findViewById(R.id.dialog_button_cancel);
            this.iOz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iOv instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.iOv, a.this.jah.getPageContext());
                    }
                }
            });
            this.iOy = (TextView) this.iOw.findViewById(R.id.dialog_button_ok);
            this.iOy.setOnClickListener(this.jah.csJ());
        }
        this.iOx.removeAllViews();
        this.fMh = new ArrayList();
        CustomBlueCheckRadioButton ef = ef("0", this.jah.getPageContext().getString(R.string.thread_good_class));
        this.fMh.add(ef);
        ef.setChecked(true);
        this.iOx.addView(ef);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aAJ()) && adVar.aAK() > 0) {
                    CustomBlueCheckRadioButton ef2 = ef(String.valueOf(adVar.aAK()), adVar.aAJ());
                    this.fMh.add(ef2);
                    View view = new View(this.jah.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iOx.addView(view);
                    this.iOx.addView(ef2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iOE.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.jah.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.jah.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.jah.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iOE.setLayoutParams(layoutParams2);
            this.iOE.removeAllViews();
            if (this.iOx != null && this.iOx.getParent() == null) {
                this.iOE.addView(this.iOx);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iOv, this.jah.getPageContext());
    }

    private CustomBlueCheckRadioButton ef(String str, String str2) {
        Activity pageActivity = this.jah.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fMi);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean cv(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.iIk;
        userMuteCheckCustomMessage.setTag(this.iIk);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cqb() {
        if (this.iOt != null) {
            this.iOt.dismiss();
        }
        if (this.iOu != null) {
            com.baidu.adp.lib.f.g.b(this.iOu, this.jah.getPageContext());
        }
        if (this.iOv != null) {
            com.baidu.adp.lib.f.g.b(this.iOv, this.jah.getPageContext());
        }
        if (this.iOs != null) {
            this.iOs.dismiss();
        }
    }

    public void ctw() {
        if (this.iHU != null) {
            this.iHU.dismiss();
        }
    }

    public void cqa() {
        arU();
        this.jah.cph();
        if (this.iHU != null) {
            this.iHU.dismiss();
        }
        cqb();
    }

    public void cpZ() {
        arU();
        this.jah.cph();
        if (this.iHU != null) {
            this.iHU.dismiss();
        }
        this.jah.bEm();
        cqb();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener csL() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b ctx() {
        return this.iHt;
    }

    public void setPhoneNumber(String str) {
        this.iEq = str;
    }

    public String cpF() {
        return this.iOA;
    }

    public View cpE() {
        if (this.iOw != null) {
            return this.iOw.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
