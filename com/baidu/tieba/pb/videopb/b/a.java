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
    public static int iQH = 3;
    public static int iQI = 0;
    public static int iQJ = 3;
    public static int iQK = 4;
    public static int iQL = 5;
    public static int iQM = 6;
    private List<CustomBlueCheckRadioButton> fMP;
    private e gRC;
    private ar gRU;
    private String iFR;
    public BdUniqueId iJL;
    private com.baidu.adp.widget.ImageView.a iJN;
    private String iJO;
    private TbRichTextMemeInfo iJP;
    private com.baidu.tieba.pb.pb.report.a iJn;
    private i iJv;
    private k iJw;
    private PbFragment.b iRp;
    public VideoPbFragment jbH;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i iQc = null;
    private com.baidu.tbadk.core.dialog.a iPU = null;
    private Dialog iPV = null;
    private Dialog iPW = null;
    private View iPX = null;
    private LinearLayout iPY = null;
    private TextView iPZ = null;
    private TextView iQa = null;
    private String iQb = null;
    private ScrollView iQf = null;
    private CompoundButton.OnCheckedChangeListener fMQ = null;
    private i iPT = null;
    private com.baidu.tbadk.core.view.a fQQ = null;
    private com.baidu.tbadk.core.dialog.b iIU = null;
    private AlertDialog iVG = null;
    private y iVH = null;
    PostData hjm = null;
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
            if (a.this.jbH == null || !a.this.jbH.isAdded()) {
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
                        a.this.iJN = ((TbImageView) view).getBdImage();
                        a.this.iJO = ((TbImageView) view).getUrl();
                        if (a.this.iJN == null || TextUtils.isEmpty(a.this.iJO)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.iJP = null;
                        } else {
                            a.this.iJP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.iJN = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.iJO = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.iJP = null;
                            } else {
                                a.this.iJP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.iJN = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.iJO = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.iJP = null;
                        } else {
                            a.this.iJP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.iKx, a.this.iJN.isGif());
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
            a.this.hjm = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.hjm == null || a.this.jbH.ctd() == null) {
                return true;
            }
            if (!a.this.jbH.ctd().ayO() || a.this.hjm.getId() == null || !a.this.hjm.getId().equals(a.this.jbH.clX().aCA())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.jbH.clX().getPbData() != null && a.this.jbH.clX().getPbData().cln();
            if (a.this.iJw == null) {
                a.this.iJw = new k(a.this.jbH.getContext());
                a.this.iJw.a(a.this.iKy);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cv(view) && !z3;
                boolean z5 = (!a.this.cv(view) || a.this.iJN == null || a.this.iJN.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.iJw));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.iJw));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.iJw);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.hjm);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.iJw);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.iJw);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.hjm);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.iJw);
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
                        if ((a.this.pR(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.iJw);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.iJw);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.iJw);
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
                            if (a.this.jbH.clX().getPbData().clb() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.iJw);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.iJw);
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
                a.this.iJw.az(arrayList);
                a.this.iJv = new i(a.this.jbH.getPageContext(), a.this.iJw);
                a.this.iJv.showDialog();
                TiebaStatic.log(new an("c13272").cx("tid", a.this.jbH.clX().cnU()).cx("fid", a.this.jbH.clX().getForumId()).cx("uid", a.this.jbH.clX().getPbData().ckP().aCr().getUserId()).cx("post_id", a.this.jbH.clX().aOT()).X("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c iKy = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            int i2;
            if (a.this.iJv != null) {
                a.this.iJv.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.iJN != null && !TextUtils.isEmpty(a.this.iJO)) {
                        if (a.this.iJP == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.iJO));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.iJO;
                            aVar.pkgId = a.this.iJP.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.iJP.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.iJN = null;
                        a.this.iJO = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.iJN != null && !TextUtils.isEmpty(a.this.iJO)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.jbH.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.jbH.getPageContext().getPageActivity())) {
                            if (a.this.gRU == null) {
                                a.this.gRU = new ar(a.this.jbH.getPageContext());
                            }
                            a.this.gRU.j(a.this.iJO, a.this.iJN.getImageByte());
                            a.this.iJN = null;
                            a.this.iJO = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.hjm != null) {
                        a.this.hjm.fu(a.this.jbH.getPageContext().getPageActivity());
                        a.this.hjm = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new an("c11739").X("obj_locate", 2));
                    if (a.this.jbH.checkUpIsLogin()) {
                        a.this.cu(view);
                        if (a.this.jbH.clX().getPbData().ckP() != null && a.this.jbH.clX().getPbData().ckP().aCr() != null && a.this.jbH.clX().getPbData().ckP().aCr().getUserId() != null && a.this.jbH.ctd() != null) {
                            int g = a.this.g(a.this.jbH.clX().getPbData());
                            bj ckP = a.this.jbH.clX().getPbData().ckP();
                            if (ckP.aBg()) {
                                i2 = 2;
                            } else if (ckP.aBh()) {
                                i2 = 3;
                            } else if (ckP.aEk()) {
                                i2 = 4;
                            } else {
                                i2 = ckP.aEl() ? 5 : 1;
                            }
                            TiebaStatic.log(new an("c12526").cx("tid", a.this.jbH.clX().cnU()).X("obj_locate", 2).cx("obj_id", a.this.jbH.clX().getPbData().ckP().aCr().getUserId()).X("obj_type", a.this.jbH.ctd().ayO() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.jbH.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new an("c13079"));
                        a.this.FP((String) tag);
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
                        a.this.jbH.showToast(R.string.network_not_available);
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
    private final b.a iKx = new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.iJN != null && !TextUtils.isEmpty(a.this.iJO)) {
                if (i == 0) {
                    if (a.this.iJP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.iJO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.iJO;
                        aVar.pkgId = a.this.iJP.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.iJP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.jbH.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.jbH.getPageContext().getPageActivity())) {
                        if (a.this.gRU == null) {
                            a.this.gRU = new ar(a.this.jbH.getPageContext());
                        }
                        a.this.gRU.j(a.this.iJO, a.this.iJN.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.iJN = null;
                a.this.iJO = null;
            }
        }
    };

    public void cnb() {
        com.baidu.tieba.pb.data.e pbData;
        bj ckP;
        if (this.jbH != null && this.jbH.clX() != null && this.jbH.clX().getPbData() != null && (ckP = (pbData = this.jbH.clX().getPbData()).ckP()) != null && ckP.aCr() != null) {
            this.jbH.cpC();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), ckP.aCr().getUserId());
            z zVar = new z();
            int clb = this.jbH.clX().getPbData().clb();
            if (clb == 1 || clb == 3) {
                zVar.iNO = true;
                zVar.iNN = true;
                zVar.iNT = ckP.aCm() == 1;
                zVar.iNS = ckP.aCn() == 1;
            } else {
                zVar.iNO = false;
                zVar.iNN = false;
            }
            if (clb == 1002 && !equals) {
                zVar.iNU = true;
            }
            zVar.iNL = pS(equals);
            zVar.iNP = cnc();
            zVar.iNM = pT(equals);
            zVar.hV = this.jbH.clX().cnV();
            zVar.iNI = true;
            zVar.iNH = pR(equals);
            zVar.iNR = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.iNQ = true;
            zVar.isHostOnly = this.jbH.clX().getHostMode();
            zVar.iNK = true;
            if (ckP.aCI() == null) {
                zVar.iNJ = true;
            } else {
                zVar.iNJ = false;
            }
            if (pbData.cln()) {
                zVar.iNI = false;
                zVar.iNK = false;
                zVar.iNJ = false;
                zVar.iNN = false;
                zVar.iNO = false;
            }
            a(zVar);
        }
    }

    private boolean pS(boolean z) {
        boolean z2;
        w wVar;
        if (this.jbH == null || this.jbH.clX() == null || this.jbH.clX().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.jbH.clX().getPbData();
        bj ckP = pbData.ckP();
        if (ckP != null) {
            if (ckP.aBg() || ckP.aBh()) {
                return false;
            }
            if (ckP.aEk() || ckP.aEl()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.clb() != 0) {
                return pbData.clb() != 3;
            }
            List<bf> cli = pbData.cli();
            if (v.getCount(cli) > 0) {
                for (bf bfVar : cli) {
                    if (bfVar != null && (wVar = bfVar.cRd) != null && wVar.cOX && !wVar.cOY && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean pT(boolean z) {
        if (z || this.jbH == null || this.jbH.clX() == null || this.jbH.clX().getPbData() == null) {
            return false;
        }
        return ((this.jbH.clX().getPbData().getForum() != null && this.jbH.clX().getPbData().getForum().isBlockBawuDelete) || this.jbH.clX().getPbData().clb() == 0 || this.jbH.clX().getPbData().clb() == 3) ? false : true;
    }

    private boolean cnc() {
        if (this.jbH == null || this.jbH.clX() == null || !this.jbH.clX().cnV()) {
            return false;
        }
        return this.jbH.clX().getPageData() == null || this.jbH.clX().getPageData().aBo() != 0;
    }

    public void a(z zVar) {
        if (!this.jbH.getBaseFragmentActivity().isProgressBarShown()) {
            this.iVH = new y(this.jbH, this.jbH.avi);
            this.iVG = new AlertDialog.Builder(this.jbH.getContext(), R.style.DialogTheme).create();
            this.iVG.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.iVG, this.jbH.getFragmentActivity());
            Window window = this.iVG.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iVH.getView());
            this.iVH.qf(zVar == null ? false : zVar.iNH);
            this.iVH.qg(zVar == null ? false : zVar.iNL);
            this.iVH.qh(zVar == null ? false : zVar.iNP);
            this.iVH.qi(zVar == null ? false : zVar.iNM);
            this.iVH.qj(zVar == null ? true : zVar.iNJ);
            if (zVar == null) {
                this.iVH.aa(false, false);
                this.iVH.ab(false, false);
            } else {
                this.iVH.aa(zVar.iNN, zVar.iNT);
                this.iVH.ab(zVar.iNO, zVar.iNS);
            }
            boolean z = zVar == null ? false : zVar.hV;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.iNK;
            boolean z4 = zVar == null ? false : zVar.iNI;
            boolean z5 = zVar == null ? false : zVar.iNR;
            boolean z6 = zVar == null ? false : zVar.iNQ;
            this.iVH.Z(z3, z2);
            this.iVH.ac(z4, z);
            this.iVH.ad(z6, z5);
            if (zVar != null) {
                this.iVH.iNE = zVar.iNU;
                if (zVar.iNU) {
                    this.iVH.cpf().setText(R.string.report_text);
                    this.iVH.qi(false);
                }
            }
            crw();
        }
    }

    private void crw() {
        if (this.iVH != null) {
            this.iVH.cpl();
        }
    }

    public void arX() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.iVG != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.iVG, a.this.jbH.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.gx().postDelayed(this.runnable, 100L);
    }

    public void crx() {
        if (this.iVG != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.iVG, this.jbH.getPageContext().getPageActivity());
        }
    }

    public y cry() {
        return this.iVH;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.jbH = videoPbFragment;
        this.iJL = videoPbFragment.getUniqueId();
        this.iJn = new com.baidu.tieba.pb.pb.report.a(this.jbH.getContext());
        this.iJn.t(this.jbH.getUniqueId());
        this.iRp = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.jbH.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.jbH.clX().getPbData().getUserData().getUserId());
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
                a.this.jbH.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.jbH.getPageContext().getPageActivity(), a.this.jbH.clX().getPbData().getForum().getId(), a.this.jbH.clX().getPbData().getForum().getName(), a.this.jbH.clX().getPbData().ckP().getId(), valueOf, str, str3, str2, str4)));
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
            if (postData.getId() != null && postData.getId().equals(this.jbH.clX().aCA())) {
                z = true;
            }
            MarkData l = this.jbH.clX().l(postData);
            if (this.jbH.clX().getPbData() != null && this.jbH.clX().getPbData().cln() && (F = this.jbH.F(this.jbH.clX().getPbData())) != null) {
                l = this.jbH.clX().l(F);
            }
            if (l != null) {
                this.jbH.cqb();
                if (this.jbH.ctd() != null) {
                    this.jbH.ctd().a(l);
                    if (!z) {
                        this.jbH.ctd().ayQ();
                    } else {
                        this.jbH.ctd().ayP();
                    }
                }
            }
        }
    }

    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.ckP() != null) {
            if (eVar.ckP().getThreadType() == 0) {
                return 1;
            }
            if (eVar.ckP().getThreadType() == 54) {
                return 2;
            }
            if (eVar.ckP().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pR(boolean z) {
        if (this.jbH.clX() == null || this.jbH.clX().getPbData() == null) {
            return false;
        }
        return ((this.jbH.clX().getPbData().clb() != 0) || this.jbH.clX().getPbData().ckP() == null || this.jbH.clX().getPbData().ckP().aCr() == null || TextUtils.equals(this.jbH.clX().getPbData().ckP().aCr().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void FP(String str) {
        if (this.jbH.clX() != null && this.jbH.clX().getPbData() != null && this.jbH.clX().getPbData().cln()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jbH.clX().cnU(), str);
            bj ckP = this.jbH.clX().getPbData().ckP();
            if (ckP.aBg()) {
                format = format + "&channelid=33833";
            } else if (ckP.aEj()) {
                format = format + "&channelid=33842";
            } else if (ckP.aBh()) {
                format = format + "&channelid=33840";
            }
            FQ(format);
            return;
        }
        this.iJn.Gp(str);
    }

    private void FQ(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.jbH.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iJv != null && this.iJv.isShowing()) {
                this.iJv.dismiss();
                this.iJv = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.jbH.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.iJv != null) {
                            a.this.iJv.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.iJL);
                            userMuteAddAndDelCustomMessage.setTag(a.this.iJL);
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
                this.iJv = new i(this.jbH.getPageContext(), kVar);
                this.iJv.showDialog();
            }
        }
    }

    public void cnx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jbH.getPageContext().getPageActivity());
        aVar.sR(this.jbH.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.jbH.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.jbH.getPageContext()).aEG();
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
        sparseArray.put(iQI, Integer.valueOf(iQJ));
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
        this.iPU = new com.baidu.tbadk.core.dialog.a(this.jbH.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iPU.jW(i3);
        } else {
            this.iPU.setOnlyMessageShowCenter(false);
            this.iPU.sR(str2);
        }
        this.iPU.setYesButtonTag(sparseArray);
        this.iPU.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jbH.a(aVar, (JSONArray) null);
            }
        });
        this.iPU.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iPU.fH(true);
        this.iPU.b(this.jbH.getPageContext());
        if (z) {
            this.iPU.aEG();
        } else {
            a(this.iPU, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.jbH != null && aVar != null) {
            if (this.gRC == null && this.jbH.getView() != null) {
                this.gRC = new e(this.jbH.getPageContext(), this.jbH.getView());
            }
            AntiData bDg = bDg();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bDg != null && bDg.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bDg.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gRC.setDefaultReasonArray(new String[]{this.jbH.getString(R.string.delete_thread_reason_1), this.jbH.getString(R.string.delete_thread_reason_2), this.jbH.getString(R.string.delete_thread_reason_3), this.jbH.getString(R.string.delete_thread_reason_4), this.jbH.getString(R.string.delete_thread_reason_5)});
            this.gRC.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gRC.wn(str);
            this.gRC.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    a.this.jbH.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData bDg() {
        if (this.jbH.clX() == null || this.jbH.clX().getPbData() == null) {
            return null;
        }
        return this.jbH.clX().getPbData().getAnti();
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
        k kVar = new k(this.jbH.getContext());
        kVar.setTitleText(this.jbH.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.iPT.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.iRp != null) {
                                a.this.iRp.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.jbH.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.jbH.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.jbH.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.jbH.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.jbH.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.az(arrayList);
        if (this.iPT == null) {
            this.iPT = new i(this.jbH.getPageContext(), kVar);
        } else {
            this.iPT.a(kVar);
        }
        this.iPT.showDialog();
    }

    public void cmT() {
        if (this.iIU == null) {
            this.iIU = new com.baidu.tbadk.core.dialog.b(this.jbH.getPageContext().getPageActivity());
            this.iIU.a(new String[]{this.jbH.getPageContext().getString(R.string.call_phone), this.jbH.getPageContext().getString(R.string.sms_phone), this.jbH.getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.jbH.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.iFR = a.this.iFR.trim();
                        UtilHelper.callPhone(a.this.jbH.getPageContext().getPageActivity(), a.this.iFR);
                        new com.baidu.tieba.pb.pb.main.a(a.this.jbH.clX().cnU(), a.this.iFR, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.jbH.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.iFR = a.this.iFR.trim();
                        UtilHelper.smsPhone(a.this.jbH.getPageContext().getPageActivity(), a.this.iFR);
                        new com.baidu.tieba.pb.pb.main.a(a.this.jbH.clX().cnU(), a.this.iFR, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.iFR = a.this.iFR.trim();
                        UtilHelper.startBaiDuBar(a.this.jbH.getPageContext().getPageActivity(), a.this.iFR);
                        bVar.dismiss();
                    }
                }
            }).kb(R.style.dialog_ani_b2t).kc(17).d(this.jbH.getPageContext());
        }
    }

    public void cG(final View view) {
        String[] strArr;
        int i = 0;
        if (this.jbH != null && this.jbH.clX() != null) {
            final i iVar = new i(this.jbH.getPageContext());
            if (this.jbH.clX().getPbData().iDp == null || this.jbH.clX().getPbData().iDp.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.jbH.clX().getPbData().iDp.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.jbH.clX().getPbData().iDp.size()) {
                        break;
                    }
                    strArr2[i2] = this.jbH.clX().getPbData().iDp.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.jbH.clX().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.jbH.clX().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.jbH.clX().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.jbH.clX().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new an("c12097").X("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).X("obj_type", i4));
                    if (a.this.jbH.clX().getPbData().iDp != null && a.this.jbH.clX().getPbData().iDp.size() > i3) {
                        i3 = a.this.jbH.clX().getPbData().iDp.get(i3).sort_type.intValue();
                    }
                    boolean ze = a.this.jbH.clX().ze(i3);
                    view.setTag(Integer.valueOf(a.this.jbH.clX().com()));
                    if (ze) {
                        a.this.jbH.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jbH.getActivity());
            aVar.sQ(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.sR(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.fH(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cx("obj_id", metaData.getUserId()).X("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cx("obj_id", metaData.getUserId()).X("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.jbH.cto() != null) {
                        a.this.jbH.cto().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.jbH.getPageContext().getUniqueId(), a.this.jbH.clX().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.jbH.getPageContext()).aEG();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iJL);
        userMuteAddAndDelCustomMessage.setTag(this.iJL);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void vq(String str) {
        if (str == null) {
            str = "";
        }
        if (this.jbH != null && this.jbH.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jbH.getPageContext().getPageActivity());
            aVar.sR(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jbH.getPageContext()).aEG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jbH.getBaseFragmentActivity());
        if (aq.isEmpty(str)) {
            aVar.sR(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sR(str);
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
        aVar.b(this.jbH.getPageContext()).aEG();
    }

    public void showLoadingDialog() {
        if (this.fQQ == null) {
            this.fQQ = new com.baidu.tbadk.core.view.a(this.jbH.getPageContext());
        }
        this.fQQ.setDialogVisiable(true);
    }

    public void bqx() {
        if (this.fQQ != null) {
            this.fQQ.setDialogVisiable(false);
        }
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iQc != null) {
            this.iQc.dismiss();
            this.iQc = null;
        }
        k kVar = new k(this.jbH.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.jbH.clX().getPbData() != null && this.jbH.clX().getPbData().ckP() != null && !this.jbH.clX().getPbData().ckP().isBjh()) {
            arrayList.add(new g(0, this.jbH.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.jbH.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.iQc.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iQc = new i(this.jbH.getPageContext(), kVar);
        this.iQc.showDialog();
    }

    public void aM(ArrayList<ad> arrayList) {
        if (this.iPX == null) {
            this.iPX = LayoutInflater.from(this.jbH.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.jbH.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iPX);
        if (this.iPW == null) {
            this.iPW = new Dialog(this.jbH.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iPW.setCanceledOnTouchOutside(true);
            this.iPW.setCancelable(true);
            this.iQf = (ScrollView) this.iPX.findViewById(R.id.good_scroll);
            this.iPW.setContentView(this.iPX);
            WindowManager.LayoutParams attributes = this.iPW.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iPW.getWindow().setAttributes(attributes);
            this.fMQ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.iQb = (String) compoundButton.getTag();
                        if (a.this.fMP != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.fMP) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.iQb != null && !str.equals(a.this.iQb)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iPY = (LinearLayout) this.iPX.findViewById(R.id.good_class_group);
            this.iQa = (TextView) this.iPX.findViewById(R.id.dialog_button_cancel);
            this.iQa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iPW instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.iPW, a.this.jbH.getPageContext());
                    }
                }
            });
            this.iPZ = (TextView) this.iPX.findViewById(R.id.dialog_button_ok);
            this.iPZ.setOnClickListener(this.jbH.cte());
        }
        this.iPY.removeAllViews();
        this.fMP = new ArrayList();
        CustomBlueCheckRadioButton ed = ed("0", this.jbH.getPageContext().getString(R.string.thread_good_class));
        this.fMP.add(ed);
        ed.setChecked(true);
        this.iPY.addView(ed);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aAM()) && adVar.aAN() > 0) {
                    CustomBlueCheckRadioButton ed2 = ed(String.valueOf(adVar.aAN()), adVar.aAM());
                    this.fMP.add(ed2);
                    View view = new View(this.jbH.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iPY.addView(view);
                    this.iPY.addView(ed2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iQf.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.jbH.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.jbH.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.jbH.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iQf.setLayoutParams(layoutParams2);
            this.iQf.removeAllViews();
            if (this.iPY != null && this.iPY.getParent() == null) {
                this.iQf.addView(this.iPY);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iPW, this.jbH.getPageContext());
    }

    private CustomBlueCheckRadioButton ed(String str, String str2) {
        Activity pageActivity = this.jbH.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fMQ);
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
        userMuteCheckCustomMessage.mId = this.iJL;
        userMuteCheckCustomMessage.setTag(this.iJL);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cqw() {
        if (this.iPU != null) {
            this.iPU.dismiss();
        }
        if (this.iPV != null) {
            com.baidu.adp.lib.f.g.b(this.iPV, this.jbH.getPageContext());
        }
        if (this.iPW != null) {
            com.baidu.adp.lib.f.g.b(this.iPW, this.jbH.getPageContext());
        }
        if (this.iPT != null) {
            this.iPT.dismiss();
        }
    }

    public void ctR() {
        if (this.iJv != null) {
            this.iJv.dismiss();
        }
    }

    public void cqv() {
        arX();
        this.jbH.cpC();
        if (this.iJv != null) {
            this.iJv.dismiss();
        }
        cqw();
    }

    public void cqu() {
        arX();
        this.jbH.cpC();
        if (this.iJv != null) {
            this.iJv.dismiss();
        }
        this.jbH.bEv();
        cqw();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener ctg() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b ctS() {
        return this.iIU;
    }

    public void setPhoneNumber(String str) {
        this.iFR = str;
    }

    public String cqa() {
        return this.iQb;
    }

    public View cpZ() {
        if (this.iPX != null) {
            return this.iPX.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
