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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.switchs.FansCallSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ab;
import com.baidu.tieba.pb.pb.main.ac;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes6.dex */
public class a {
    public static int iJT = 3;
    public static int iJU = 0;
    public static int iJV = 3;
    public static int iJW = 4;
    public static int iJX = 5;
    public static int iJY = 6;
    private List<CustomBlueCheckRadioButton> fGl;
    private e gKU;
    private au gLl;
    public BdUniqueId iCO;
    private com.baidu.adp.widget.ImageView.a iCQ;
    private String iCR;
    private TbRichTextMemeInfo iCS;
    private com.baidu.tieba.pb.pb.report.a iCq;
    private i iCy;
    private k iCz;
    private PbFragment.b iKB;
    public VideoPbFragment iUK;
    private String iyO;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private Runnable runnable;
    private i iJp = null;
    private com.baidu.tbadk.core.dialog.a iJh = null;
    private Dialog iJi = null;
    private Dialog iJj = null;
    private View iJk = null;
    private LinearLayout iJl = null;
    private TextView iJm = null;
    private TextView iJn = null;
    private String iJo = null;
    private ScrollView iJs = null;
    private CompoundButton.OnCheckedChangeListener fGm = null;
    private i iJg = null;
    private com.baidu.tbadk.core.view.a fKp = null;
    private com.baidu.tbadk.core.dialog.b iBX = null;
    private AlertDialog iOS = null;
    private ab iOT = null;
    PostData hbU = null;
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
            if (a.this.iUK == null || !a.this.iUK.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.cr(view)) {
                    if (view instanceof TbImageView) {
                        a.this.iCQ = ((TbImageView) view).getBdImage();
                        a.this.iCR = ((TbImageView) view).getUrl();
                        if (a.this.iCQ == null || TextUtils.isEmpty(a.this.iCR)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.iCS = null;
                        } else {
                            a.this.iCS = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.iCQ = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.iCR = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.iCS = null;
                            } else {
                                a.this.iCS = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.iCQ = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.iCR = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.iCS = null;
                        } else {
                            a.this.iCS = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.iDB, a.this.iCQ.isGif());
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
            a.this.hbU = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.hbU == null || a.this.iUK.cqh() == null) {
                return true;
            }
            if (!a.this.iUK.cqh().awd() || a.this.hbU.getId() == null || !a.this.hbU.getId().equals(a.this.iUK.ciU().azN())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.iUK.ciU().getPbData() != null && a.this.iUK.ciU().getPbData().cik();
            if (a.this.iCz == null) {
                a.this.iCz = new k(a.this.iUK.getContext());
                a.this.iCz.a(a.this.iDC);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cr(view) && !z3;
                boolean z5 = (!a.this.cr(view) || a.this.iCQ == null || a.this.iCQ.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.iCz));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.iCz));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.iCz);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.hbU);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.iCz);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.iCz);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.hbU);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.iCz);
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
                        if ((a.this.pw(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.iCz);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.iCz);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.iCz);
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
                            if (a.this.iUK.ciU().getPbData().chW() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.iCz);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.iCz);
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
                a.this.iCz.aA(arrayList);
                a.this.iCy = new i(a.this.iUK.getPageContext(), a.this.iCz);
                a.this.iCy.showDialog();
                TiebaStatic.log(new an("c13272").cp("tid", a.this.iUK.ciU().ckU()).cp("fid", a.this.iUK.ciU().getForumId()).cp("uid", a.this.iUK.ciU().getPbData().chK().azE().getUserId()).cp("post_id", a.this.iUK.ciU().aLX()).Z("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c iDC = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            int i2;
            if (a.this.iCy != null) {
                a.this.iCy.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.iCQ != null && !TextUtils.isEmpty(a.this.iCR)) {
                        if (a.this.iCS == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.iCR));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.iCR;
                            aVar.pkgId = a.this.iCS.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.iCS.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.iCQ = null;
                        a.this.iCR = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.iCQ != null && !TextUtils.isEmpty(a.this.iCR)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.iUK.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.iUK.getPageContext().getPageActivity())) {
                            if (a.this.gLl == null) {
                                a.this.gLl = new au(a.this.iUK.getPageContext());
                            }
                            a.this.gLl.j(a.this.iCR, a.this.iCQ.getImageByte());
                            a.this.iCQ = null;
                            a.this.iCR = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.hbU != null) {
                        a.this.hbU.fu(a.this.iUK.getPageContext().getPageActivity());
                        a.this.hbU = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new an("c11739").Z("obj_locate", 2));
                    if (a.this.iUK.checkUpIsLogin()) {
                        a.this.cq(view);
                        if (a.this.iUK.ciU().getPbData().chK() != null && a.this.iUK.ciU().getPbData().chK().azE() != null && a.this.iUK.ciU().getPbData().chK().azE().getUserId() != null && a.this.iUK.cqh() != null) {
                            int g = a.this.g(a.this.iUK.ciU().getPbData());
                            bj chK = a.this.iUK.ciU().getPbData().chK();
                            if (chK.ays()) {
                                i2 = 2;
                            } else if (chK.aBz()) {
                                i2 = 3;
                            } else if (chK.aBA()) {
                                i2 = 4;
                            } else {
                                i2 = chK.aBB() ? 5 : 1;
                            }
                            TiebaStatic.log(new an("c12526").cp("tid", a.this.iUK.ciU().ckU()).Z("obj_locate", 2).cp("obj_id", a.this.iUK.ciU().getPbData().chK().azE().getUserId()).Z("obj_type", a.this.iUK.cqh().awd() ? 0 : 1).Z("obj_source", g).Z("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.iUK.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new an("c13079"));
                        a.this.Fq((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new an("c11739").Z("obj_locate", 4));
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
                        a.this.iUK.showToast(R.string.network_not_available);
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
                            a.this.cw(view);
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
    private final b.a iDB = new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.iCQ != null && !TextUtils.isEmpty(a.this.iCR)) {
                if (i == 0) {
                    if (a.this.iCS == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.iCR));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.iCR;
                        aVar.pkgId = a.this.iCS.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.iCS.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.iUK.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.iUK.getPageContext().getPageActivity())) {
                        if (a.this.gLl == null) {
                            a.this.gLl = new au(a.this.iUK.getPageContext());
                        }
                        a.this.gLl.j(a.this.iCR, a.this.iCQ.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.iCQ = null;
                a.this.iCR = null;
            }
        }
    };

    public void ckb() {
        f pbData;
        bj chK;
        if (this.iUK != null && this.iUK.ciU() != null && this.iUK.ciU().getPbData() != null && (chK = (pbData = this.iUK.ciU().getPbData()).chK()) != null && chK.azE() != null) {
            this.iUK.cmG();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), chK.azE().getUserId());
            ac acVar = new ac();
            int chW = this.iUK.ciU().getPbData().chW();
            if (chW == 1 || chW == 3) {
                acVar.iGZ = true;
                acVar.iGY = true;
                acVar.iHf = chK.azz() == 1;
                acVar.iHe = chK.azA() == 1;
            } else {
                acVar.iGZ = false;
                acVar.iGY = false;
            }
            if (chW == 1002 && !equals) {
                acVar.iHg = true;
            }
            acVar.iGW = px(equals);
            acVar.iHa = ckc();
            acVar.iGX = py(equals);
            acVar.hS = this.iUK.ciU().ckV();
            acVar.iGT = true;
            acVar.iGS = pw(equals);
            acVar.iHc = cka();
            acVar.iHd = TbadkCoreApplication.getInst().getSkinType() == 1;
            acVar.iHb = true;
            acVar.isHostOnly = this.iUK.ciU().getHostMode();
            acVar.iGV = true;
            if (chK.azV() == null) {
                acVar.iGU = true;
            } else {
                acVar.iGU = false;
            }
            if (pbData.cik()) {
                acVar.iGT = false;
                acVar.iGV = false;
                acVar.iGU = false;
                acVar.iGY = false;
                acVar.iGZ = false;
            }
            a(acVar);
        }
    }

    public String cka() {
        f pbData;
        if (!FansCallSwitch.getIsOn()) {
            return "";
        }
        PostData E = this.iUK.E(this.iUK.ciU().getPbData());
        if (this.iUK.ciU() == null || (pbData = this.iUK.ciU().getPbData()) == null || pbData.getUserData() == null || pbData.chK() == null || E == null || E.azE() == null || !UtilHelper.isCurrentAccount(pbData.getUserData().getUserId()) || pbData.getUserData().getGodUserData() == null || !E.azE().isBigV()) {
            return "";
        }
        if (pbData.getUserData().getLeft_call_num() < 1 && pbData.chK().azk() == 0) {
            return "";
        }
        if (pbData.chK().azk() == 0) {
            return TbadkCoreApplication.getInst().getString(R.string.fans_call);
        }
        return TbadkCoreApplication.getInst().getString(R.string.haved_fans_call);
    }

    private boolean px(boolean z) {
        boolean z2;
        w wVar;
        if (this.iUK == null || this.iUK.ciU() == null || this.iUK.ciU().getPbData() == null) {
            return false;
        }
        f pbData = this.iUK.ciU().getPbData();
        bj chK = pbData.chK();
        if (chK != null) {
            if (chK.ays() || chK.aBz()) {
                return false;
            }
            if (chK.aBA() || chK.aBB()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.chW() != 0) {
                return pbData.chW() != 3;
            }
            List<bf> cie = pbData.cie();
            if (v.getCount(cie) > 0) {
                for (bf bfVar : cie) {
                    if (bfVar != null && (wVar = bfVar.cMB) != null && wVar.cKu && !wVar.cKv && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean py(boolean z) {
        if (z || this.iUK == null || this.iUK.ciU() == null || this.iUK.ciU().getPbData() == null) {
            return false;
        }
        return ((this.iUK.ciU().getPbData().getForum() != null && this.iUK.ciU().getPbData().getForum().isBlockBawuDelete) || this.iUK.ciU().getPbData().chW() == 0 || this.iUK.ciU().getPbData().chW() == 3) ? false : true;
    }

    private boolean ckc() {
        if (this.iUK == null || this.iUK.ciU() == null || !this.iUK.ciU().ckV()) {
            return false;
        }
        return this.iUK.ciU().getPageData() == null || this.iUK.ciU().getPageData().ayz() != 0;
    }

    public void a(ac acVar) {
        if (!this.iUK.getBaseFragmentActivity().isProgressBarShown()) {
            this.iOT = new ab(this.iUK, this.iUK.aqZ);
            this.iOS = new AlertDialog.Builder(this.iUK.getContext(), R.style.DialogTheme).create();
            this.iOS.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.iOS, this.iUK.getFragmentActivity());
            Window window = this.iOS.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iOT.getView());
            this.iOT.pK(acVar == null ? false : acVar.iGS);
            this.iOT.pL(acVar == null ? false : acVar.iGW);
            this.iOT.pM(acVar == null ? false : acVar.iHa);
            this.iOT.pN(acVar == null ? false : acVar.iGX);
            this.iOT.pO(acVar == null ? true : acVar.iGU);
            if (acVar == null) {
                this.iOT.Y(false, false);
                this.iOT.Z(false, false);
                this.iOT.v(false, "");
            } else {
                this.iOT.Y(acVar.iGY, acVar.iHf);
                this.iOT.Z(acVar.iGZ, acVar.iHe);
                this.iOT.v(StringUtils.isNull(acVar.iHc) ? false : true, acVar.iHc);
            }
            boolean z = acVar == null ? false : acVar.hS;
            boolean z2 = acVar == null ? false : acVar.isHostOnly;
            boolean z3 = acVar == null ? false : acVar.iGV;
            boolean z4 = acVar == null ? false : acVar.iGT;
            boolean z5 = acVar == null ? false : acVar.iHd;
            boolean z6 = acVar == null ? false : acVar.iHb;
            this.iOT.X(z3, z2);
            this.iOT.aa(z4, z);
            this.iOT.ab(z6, z5);
            if (acVar != null) {
                this.iOT.iGP = acVar.iHg;
                if (acVar.iHg) {
                    this.iOT.cmi().setText(R.string.report_text);
                    this.iOT.pN(false);
                }
            }
            coz();
        }
    }

    private void coz() {
        if (this.iOT != null) {
            this.iOT.cmp();
        }
    }

    public void apm() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.iOS != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.iOS, a.this.iUK.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.gy().postDelayed(this.runnable, 100L);
    }

    public void coA() {
        if (this.iOS != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.iOS, this.iUK.getPageContext().getPageActivity());
        }
    }

    public ab coB() {
        return this.iOT;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.iUK = videoPbFragment;
        this.iCO = videoPbFragment.getUniqueId();
        this.iCq = new com.baidu.tieba.pb.pb.report.a(this.iUK.getContext());
        this.iCq.t(this.iUK.getUniqueId());
        this.iKB = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.iUK.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.iUK.ciU().getPbData().getUserData().getUserId());
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
                a.this.iUK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.iUK.getPageContext().getPageActivity(), a.this.iUK.ciU().getPbData().getForum().getId(), a.this.iUK.ciU().getPbData().getForum().getName(), a.this.iUK.ciU().getPbData().chK().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(View view) {
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
        PostData E;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.iUK.ciU().azN())) {
                z = true;
            }
            MarkData l = this.iUK.ciU().l(postData);
            if (this.iUK.ciU().getPbData() != null && this.iUK.ciU().getPbData().cik() && (E = this.iUK.E(this.iUK.ciU().getPbData())) != null) {
                l = this.iUK.ciU().l(E);
            }
            if (l != null) {
                this.iUK.cnf();
                if (this.iUK.cqh() != null) {
                    this.iUK.cqh().a(l);
                    if (!z) {
                        this.iUK.cqh().awf();
                    } else {
                        this.iUK.cqh().awe();
                    }
                }
            }
        }
    }

    public int g(f fVar) {
        if (fVar != null && fVar.chK() != null) {
            if (fVar.chK().getThreadType() == 0) {
                return 1;
            }
            if (fVar.chK().getThreadType() == 54) {
                return 2;
            }
            if (fVar.chK().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pw(boolean z) {
        if (this.iUK.ciU() == null || this.iUK.ciU().getPbData() == null) {
            return false;
        }
        return ((this.iUK.ciU().getPbData().chW() != 0) || this.iUK.ciU().getPbData().chK() == null || this.iUK.ciU().getPbData().chK().azE() == null || TextUtils.equals(this.iUK.ciU().getPbData().chK().azE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Fq(String str) {
        if (this.iUK.ciU() != null && this.iUK.ciU().getPbData() != null && this.iUK.ciU().getPbData().cik()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iUK.ciU().ckU(), str);
            bj chK = this.iUK.ciU().getPbData().chK();
            if (chK.ays()) {
                format = format + "&channelid=33833";
            } else if (chK.aBy()) {
                format = format + "&channelid=33842";
            } else if (chK.aBz()) {
                format = format + "&channelid=33840";
            }
            Fr(format);
            return;
        }
        this.iCq.FQ(str);
    }

    private void Fr(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.iUK.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iCy != null && this.iCy.isShowing()) {
                this.iCy.dismiss();
                this.iCy = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.iUK.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.iCy != null) {
                            a.this.iCy.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.iCO);
                            userMuteAddAndDelCustomMessage.setTag(a.this.iCO);
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
                kVar.aA(arrayList);
                this.iCy = new i(this.iUK.getPageContext(), kVar);
                this.iCy.showDialog();
            }
        }
    }

    public void ckx() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iUK.getPageContext().getPageActivity());
        aVar.sz(this.iUK.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.iUK.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.iUK.getPageContext()).aBW();
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
        sparseArray.put(iJU, Integer.valueOf(iJV));
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
        this.iJh = new com.baidu.tbadk.core.dialog.a(this.iUK.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iJh.jF(i3);
        } else {
            this.iJh.setOnlyMessageShowCenter(false);
            this.iJh.sz(str2);
        }
        this.iJh.setYesButtonTag(sparseArray);
        this.iJh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iUK.a(aVar, (JSONArray) null);
            }
        });
        this.iJh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iJh.fu(true);
        this.iJh.b(this.iUK.getPageContext());
        if (z) {
            this.iJh.aBW();
        } else {
            a(this.iJh, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.iUK != null && aVar != null) {
            if (this.gKU == null && this.iUK.getView() != null) {
                this.gKU = new e(this.iUK.getPageContext(), this.iUK.getView());
            }
            AntiData bAs = bAs();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bAs != null && bAs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bAs.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gKU.setDefaultReasonArray(new String[]{this.iUK.getString(R.string.delete_thread_reason_1), this.iUK.getString(R.string.delete_thread_reason_2), this.iUK.getString(R.string.delete_thread_reason_3), this.iUK.getString(R.string.delete_thread_reason_4), this.iUK.getString(R.string.delete_thread_reason_5)});
            this.gKU.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gKU.vO(str);
            this.gKU.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void R(JSONArray jSONArray) {
                    a.this.iUK.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData bAs() {
        if (this.iUK.ciU() == null || this.iUK.ciU().getPbData() == null) {
            return null;
        }
        return this.iUK.ciU().getPbData().getAnti();
    }

    public void cw(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.iUK.getContext());
        kVar.setTitleText(this.iUK.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.iJg.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.iKB != null) {
                                a.this.iKB.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.iUK.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.iUK.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.iUK.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.iUK.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.iUK.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aA(arrayList);
        if (this.iJg == null) {
            this.iJg = new i(this.iUK.getPageContext(), kVar);
        } else {
            this.iJg.a(kVar);
        }
        this.iJg.showDialog();
    }

    public void cjT() {
        if (this.iBX == null) {
            this.iBX = new com.baidu.tbadk.core.dialog.b(this.iUK.getPageContext().getPageActivity());
            this.iBX.a(new String[]{this.iUK.getPageContext().getString(R.string.call_phone), this.iUK.getPageContext().getString(R.string.sms_phone), this.iUK.getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.iUK.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.iyO = a.this.iyO.trim();
                        UtilHelper.callPhone(a.this.iUK.getPageContext().getPageActivity(), a.this.iyO);
                        new com.baidu.tieba.pb.pb.main.a(a.this.iUK.ciU().ckU(), a.this.iyO, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.iUK.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.iyO = a.this.iyO.trim();
                        UtilHelper.smsPhone(a.this.iUK.getPageContext().getPageActivity(), a.this.iyO);
                        new com.baidu.tieba.pb.pb.main.a(a.this.iUK.ciU().ckU(), a.this.iyO, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.iyO = a.this.iyO.trim();
                        UtilHelper.startBaiDuBar(a.this.iUK.getPageContext().getPageActivity(), a.this.iyO);
                        bVar.dismiss();
                    }
                }
            }).jK(R.style.dialog_ani_b2t).jL(17).d(this.iUK.getPageContext());
        }
    }

    public void cC(final View view) {
        String[] strArr;
        int i = 0;
        if (this.iUK != null && this.iUK.ciU() != null) {
            final i iVar = new i(this.iUK.getPageContext());
            if (this.iUK.ciU().getPbData().iwf == null || this.iUK.ciU().getPbData().iwf.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.iUK.ciU().getPbData().iwf.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.iUK.ciU().getPbData().iwf.size()) {
                        break;
                    }
                    strArr2[i2] = this.iUK.ciU().getPbData().iwf.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.iUK.ciU().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.iUK.ciU().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.iUK.ciU().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.iUK.ciU().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new an("c12097").Z("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).Z("obj_type", i4));
                    if (a.this.iUK.ciU().getPbData().iwf != null && a.this.iUK.ciU().getPbData().iwf.size() > i3) {
                        i3 = a.this.iUK.ciU().getPbData().iwf.get(i3).sort_type.intValue();
                    }
                    boolean yL = a.this.iUK.ciU().yL(i3);
                    view.setTag(Integer.valueOf(a.this.iUK.ciU().cln()));
                    if (yL) {
                        a.this.iUK.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iUK.getActivity());
            aVar.sy(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.sz(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.fu(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cp("obj_id", metaData.getUserId()).Z("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cp("obj_id", metaData.getUserId()).Z("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.iUK.cqs() != null) {
                        a.this.iUK.cqs().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.iUK.getPageContext().getUniqueId(), a.this.iUK.ciU().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.iUK.getPageContext()).aBW();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iCO);
        userMuteAddAndDelCustomMessage.setTag(this.iCO);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void uU(String str) {
        if (str == null) {
            str = "";
        }
        if (this.iUK != null && this.iUK.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iUK.getPageContext().getPageActivity());
            aVar.sz(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iUK.getPageContext()).aBW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iUK.getBaseFragmentActivity());
        if (aq.isEmpty(str)) {
            aVar.sz(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sz(str);
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
        aVar.b(this.iUK.getPageContext()).aBW();
    }

    public void showLoadingDialog() {
        if (this.fKp == null) {
            this.fKp = new com.baidu.tbadk.core.view.a(this.iUK.getPageContext());
        }
        this.fKp.setDialogVisiable(true);
    }

    public void bnJ() {
        if (this.fKp != null) {
            this.fKp.setDialogVisiable(false);
        }
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iJp != null) {
            this.iJp.dismiss();
            this.iJp = null;
        }
        k kVar = new k(this.iUK.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.iUK.ciU().getPbData() != null && this.iUK.ciU().getPbData().chK() != null && !this.iUK.ciU().getPbData().chK().isBjh()) {
            arrayList.add(new g(0, this.iUK.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.iUK.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aA(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.iJp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iJp = new i(this.iUK.getPageContext(), kVar);
        this.iJp.showDialog();
    }

    public void aM(ArrayList<ad> arrayList) {
        if (this.iJk == null) {
            this.iJk = LayoutInflater.from(this.iUK.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.iUK.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iJk);
        if (this.iJj == null) {
            this.iJj = new Dialog(this.iUK.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iJj.setCanceledOnTouchOutside(true);
            this.iJj.setCancelable(true);
            this.iJs = (ScrollView) this.iJk.findViewById(R.id.good_scroll);
            this.iJj.setContentView(this.iJk);
            WindowManager.LayoutParams attributes = this.iJj.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iJj.getWindow().setAttributes(attributes);
            this.fGm = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.iJo = (String) compoundButton.getTag();
                        if (a.this.fGl != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.fGl) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.iJo != null && !str.equals(a.this.iJo)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iJl = (LinearLayout) this.iJk.findViewById(R.id.good_class_group);
            this.iJn = (TextView) this.iJk.findViewById(R.id.dialog_button_cancel);
            this.iJn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iJj instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.iJj, a.this.iUK.getPageContext());
                    }
                }
            });
            this.iJm = (TextView) this.iJk.findViewById(R.id.dialog_button_ok);
            this.iJm.setOnClickListener(this.iUK.cqi());
        }
        this.iJl.removeAllViews();
        this.fGl = new ArrayList();
        CustomBlueCheckRadioButton dU = dU("0", this.iUK.getPageContext().getString(R.string.thread_good_class));
        this.fGl.add(dU);
        dU.setChecked(true);
        this.iJl.addView(dU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aya()) && adVar.ayb() > 0) {
                    CustomBlueCheckRadioButton dU2 = dU(String.valueOf(adVar.ayb()), adVar.aya());
                    this.fGl.add(dU2);
                    View view = new View(this.iUK.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iJl.addView(view);
                    this.iJl.addView(dU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iJs.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.iUK.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.iUK.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.iUK.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iJs.setLayoutParams(layoutParams2);
            this.iJs.removeAllViews();
            if (this.iJl != null && this.iJl.getParent() == null) {
                this.iJs.addView(this.iJl);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iJj, this.iUK.getPageContext());
    }

    private CustomBlueCheckRadioButton dU(String str, String str2) {
        Activity pageActivity = this.iUK.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fGm);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean cr(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.iCO;
        userMuteCheckCustomMessage.setTag(this.iCO);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cnA() {
        if (this.iJh != null) {
            this.iJh.dismiss();
        }
        if (this.iJi != null) {
            com.baidu.adp.lib.f.g.b(this.iJi, this.iUK.getPageContext());
        }
        if (this.iJj != null) {
            com.baidu.adp.lib.f.g.b(this.iJj, this.iUK.getPageContext());
        }
        if (this.iJg != null) {
            this.iJg.dismiss();
        }
    }

    public void cqR() {
        if (this.iCy != null) {
            this.iCy.dismiss();
        }
    }

    public void cnz() {
        apm();
        this.iUK.cmG();
        if (this.iCy != null) {
            this.iCy.dismiss();
        }
        cnA();
    }

    public void cny() {
        apm();
        this.iUK.cmG();
        if (this.iCy != null) {
            this.iCy.dismiss();
        }
        this.iUK.bBE();
        cnA();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener cqk() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b cqS() {
        return this.iBX;
    }

    public void setPhoneNumber(String str) {
        this.iyO = str;
    }

    public String cne() {
        return this.iJo;
    }

    public View cnd() {
        if (this.iJk != null) {
            return this.iJk.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
