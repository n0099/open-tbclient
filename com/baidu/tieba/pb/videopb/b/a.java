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
    private List<CustomBlueCheckRadioButton> gGC;
    private az hRB;
    private e hRk;
    private String jHR;
    private com.baidu.tieba.pb.pb.report.a jLC;
    private i jLK;
    private k jLL;
    public BdUniqueId jMa;
    private com.baidu.adp.widget.ImageView.a jMc;
    private String jMd;
    private TbRichTextMemeInfo jMe;
    private PbFragment.b jUe;
    public VideoPbFragment keN;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    public static int jTw = 3;
    public static int jTx = 0;
    public static int jTy = 3;
    public static int jTz = 4;
    public static int jTA = 5;
    public static int jTB = 6;
    private i jSO = null;
    private com.baidu.tbadk.core.dialog.a jSG = null;
    private Dialog jSH = null;
    private Dialog jSI = null;
    private View jSJ = null;
    private LinearLayout jSK = null;
    private TextView jSL = null;
    private TextView jSM = null;
    private String jSN = null;
    private ScrollView jSR = null;
    private CompoundButton.OnCheckedChangeListener gGD = null;
    private i jSF = null;
    private com.baidu.tbadk.core.view.a gKA = null;
    private com.baidu.tbadk.core.dialog.b jLi = null;
    private AlertDialog jYI = null;
    private af jYJ = null;
    PostData iiy = null;
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
            if (a.this.keN == null || !a.this.keN.isAdded()) {
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
                        a.this.jMc = ((TbImageView) view).getBdImage();
                        a.this.jMd = ((TbImageView) view).getUrl();
                        if (a.this.jMc == null || TextUtils.isEmpty(a.this.jMd)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.jMe = null;
                        } else {
                            a.this.jMe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.jMc = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.jMd = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.jMe = null;
                            } else {
                                a.this.jMe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.jMc = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.jMd = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.jMe = null;
                        } else {
                            a.this.jMe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.jMO, a.this.jMc.isGif());
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
            a.this.iiy = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.iiy == null || a.this.keN.cKU() == null) {
                return true;
            }
            if (!a.this.keN.cKU().aML() || a.this.iiy.getId() == null || !a.this.iiy.getId().equals(a.this.keN.cDO().aQG())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.keN.cDO().getPbData() != null && a.this.keN.cDO().getPbData().cCZ();
            if (a.this.jLL == null) {
                a.this.jLL = new k(a.this.keN.getContext());
                a.this.jLL.a(a.this.jMP);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cD(view) && !z3;
                boolean z5 = (!a.this.cD(view) || a.this.jMc == null || a.this.jMc.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.jLL));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.jLL));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.jLL);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.iiy);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.jLL);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.jLL);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.iiy);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.jLL);
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
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.jLL);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.jLL);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.jLL);
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
                            if (a.this.keN.cDO().getPbData().cCN() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.jLL);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.jLL);
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
                a.this.jLL.aD(arrayList);
                a.this.jLK = new i(a.this.keN.getPageContext(), a.this.jLL);
                a.this.jLK.showDialog();
                TiebaStatic.log(new an("c13272").dh("tid", a.this.keN.cDO().cFJ()).dh("fid", a.this.keN.cDO().getForumId()).dh("uid", a.this.keN.cDO().getPbData().cCy().aQx().getUserId()).dh("post_id", a.this.keN.cDO().bds()).ag("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c jMP = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            int i2;
            if (a.this.jLK != null) {
                a.this.jLK.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.jMc != null && !TextUtils.isEmpty(a.this.jMd)) {
                        if (a.this.jMe == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.jMd));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.jMd;
                            aVar.pkgId = a.this.jMe.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.jMe.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.jMc = null;
                        a.this.jMd = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.jMc != null && !TextUtils.isEmpty(a.this.jMd)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.keN.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.keN.getPageContext().getPageActivity())) {
                            if (a.this.hRB == null) {
                                a.this.hRB = new az(a.this.keN.getPageContext());
                            }
                            a.this.hRB.j(a.this.jMd, a.this.jMc.getImageByte());
                            a.this.jMc = null;
                            a.this.jMd = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.iiy != null) {
                        a.this.iiy.fp(a.this.keN.getPageContext().getPageActivity());
                        a.this.iiy = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new an("c11739").ag("obj_locate", 2));
                    if (a.this.keN.checkUpIsLogin()) {
                        a.this.cC(view);
                        if (a.this.keN.cDO().getPbData().cCy() != null && a.this.keN.cDO().getPbData().cCy().aQx() != null && a.this.keN.cDO().getPbData().cCy().aQx().getUserId() != null && a.this.keN.cKU() != null) {
                            int h = a.this.h(a.this.keN.cDO().getPbData());
                            bk cCy = a.this.keN.cDO().getPbData().cCy();
                            if (cCy.aPm()) {
                                i2 = 2;
                            } else if (cCy.aPn()) {
                                i2 = 3;
                            } else if (cCy.aSv()) {
                                i2 = 4;
                            } else {
                                i2 = cCy.aSw() ? 5 : 1;
                            }
                            TiebaStatic.log(new an("c12526").dh("tid", a.this.keN.cDO().cFJ()).ag("obj_locate", 2).dh("obj_id", a.this.keN.cDO().getPbData().cCy().aQx().getUserId()).ag("obj_type", a.this.keN.cKU().aML() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.keN.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new an("c13079"));
                        a.this.Jm((String) tag);
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
                        a.this.keN.showToast(R.string.network_not_available);
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
    private final b.a jMO = new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.jMc != null && !TextUtils.isEmpty(a.this.jMd)) {
                if (i == 0) {
                    if (a.this.jMe == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.jMd));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.jMd;
                        aVar.pkgId = a.this.jMe.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.jMe.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.keN.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.keN.getPageContext().getPageActivity())) {
                        if (a.this.hRB == null) {
                            a.this.hRB = new az(a.this.keN.getPageContext());
                        }
                        a.this.hRB.j(a.this.jMd, a.this.jMc.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.jMc = null;
                a.this.jMd = null;
            }
        }
    };

    public void cEP() {
        com.baidu.tieba.pb.data.e pbData;
        bk cCy;
        if (this.keN != null && this.keN.cDO() != null && this.keN.cDO().getPbData() != null && (cCy = (pbData = this.keN.cDO().getPbData()).cCy()) != null && cCy.aQx() != null) {
            this.keN.cHs();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cCy.aQx().getUserId());
            ag agVar = new ag();
            int cCN = this.keN.cDO().getPbData().cCN();
            if (cCN == 1 || cCN == 3) {
                agVar.jQw = true;
                agVar.jQv = true;
                agVar.jQB = cCy.aQs() == 1;
                agVar.jQA = cCy.aQt() == 1;
            } else {
                agVar.jQw = false;
                agVar.jQv = false;
            }
            if (cCN == 1002 && !equals) {
                agVar.jQC = true;
            }
            agVar.jQt = rv(equals);
            agVar.jQx = cEQ();
            agVar.jQu = rw(equals);
            agVar.DC = this.keN.cDO().cFL();
            agVar.jQq = true;
            agVar.jQp = ru(equals);
            agVar.jQz = TbadkCoreApplication.getInst().getSkinType() == 1;
            agVar.jQy = true;
            agVar.isHostOnly = this.keN.cDO().getHostMode();
            agVar.jQs = true;
            if (cCy.aQQ() == null) {
                agVar.jQr = true;
            } else {
                agVar.jQr = false;
            }
            if (pbData.cCZ()) {
                agVar.jQq = false;
                agVar.jQs = false;
                agVar.jQr = false;
                agVar.jQv = false;
                agVar.jQw = false;
            }
            a(agVar);
        }
    }

    private boolean rv(boolean z) {
        boolean z2;
        v vVar;
        if (this.keN == null || this.keN.cDO() == null || this.keN.cDO().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.keN.cDO().getPbData();
        bk cCy = pbData.cCy();
        if (cCy != null) {
            if (cCy.aPm() || cCy.aPn()) {
                return false;
            }
            if (cCy.aSv() || cCy.aSw()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cCN() != 0) {
                return pbData.cCN() != 3;
            }
            List<bg> cCU = pbData.cCU();
            if (com.baidu.tbadk.core.util.v.getCount(cCU) > 0) {
                for (bg bgVar : cCU) {
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
        if (z || this.keN == null || this.keN.cDO() == null || this.keN.cDO().getPbData() == null) {
            return false;
        }
        return ((this.keN.cDO().getPbData().getForum() != null && this.keN.cDO().getPbData().getForum().isBlockBawuDelete) || this.keN.cDO().getPbData().cCN() == 0 || this.keN.cDO().getPbData().cCN() == 3) ? false : true;
    }

    private boolean cEQ() {
        if (this.keN == null || this.keN.cDO() == null || !this.keN.cDO().cFL()) {
            return false;
        }
        return this.keN.cDO().getPageData() == null || this.keN.cDO().getPageData().aPu() != 0;
    }

    public void a(ag agVar) {
        if (!this.keN.getBaseFragmentActivity().isProgressBarShown()) {
            this.jYJ = new af(this.keN, this.keN.aUZ);
            this.jYI = new AlertDialog.Builder(this.keN.getContext(), R.style.DialogTheme).create();
            this.jYI.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.jYI, this.keN.getFragmentActivity());
            Window window = this.jYI.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.jYJ.getView());
            this.jYJ.rI(agVar == null ? false : agVar.jQp);
            this.jYJ.rJ(agVar == null ? false : agVar.jQt);
            this.jYJ.rK(agVar == null ? false : agVar.jQx);
            this.jYJ.rL(agVar == null ? false : agVar.jQu);
            this.jYJ.rM(agVar == null ? true : agVar.jQr);
            if (agVar == null) {
                this.jYJ.ae(false, false);
                this.jYJ.af(false, false);
            } else {
                this.jYJ.ae(agVar.jQv, agVar.jQB);
                this.jYJ.af(agVar.jQw, agVar.jQA);
            }
            boolean z = agVar == null ? false : agVar.DC;
            boolean z2 = agVar == null ? false : agVar.isHostOnly;
            boolean z3 = agVar == null ? false : agVar.jQs;
            boolean z4 = agVar == null ? false : agVar.jQq;
            boolean z5 = agVar == null ? false : agVar.jQz;
            boolean z6 = agVar == null ? false : agVar.jQy;
            this.jYJ.ad(z3, z2);
            this.jYJ.ag(z4, z);
            this.jYJ.ah(z6, z5);
            if (agVar != null) {
                this.jYJ.jQm = agVar.jQC;
                if (agVar.jQC) {
                    this.jYJ.cGV().setText(R.string.report_text);
                    this.jYJ.rL(false);
                }
            }
            cJn();
        }
    }

    private void cJn() {
        if (this.jYJ != null) {
            this.jYJ.cHb();
        }
    }

    public void aEa() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.jYI != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.jYI, a.this.keN.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.ld().postDelayed(this.runnable, 100L);
    }

    public void cJo() {
        if (this.jYI != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.jYI, this.keN.getPageContext().getPageActivity());
        }
    }

    public af cJp() {
        return this.jYJ;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.keN = videoPbFragment;
        this.jMa = videoPbFragment.getUniqueId();
        this.jLC = new com.baidu.tieba.pb.pb.report.a(this.keN.getContext());
        this.jLC.w(this.keN.getUniqueId());
        this.jUe = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.keN.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.keN.cDO().getPbData().getUserData().getUserId());
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
                a.this.keN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.keN.getPageContext().getPageActivity(), a.this.keN.cDO().getPbData().getForum().getId(), a.this.keN.cDO().getPbData().getForum().getName(), a.this.keN.cDO().getPbData().cCy().getId(), valueOf, str, str3, str2, str4)));
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
            if (postData.getId() != null && postData.getId().equals(this.keN.cDO().aQG())) {
                z = true;
            }
            MarkData o = this.keN.cDO().o(postData);
            if (this.keN.cDO().getPbData() != null && this.keN.cDO().getPbData().cCZ() && (H = this.keN.H(this.keN.cDO().getPbData())) != null) {
                o = this.keN.cDO().o(H);
            }
            if (o != null) {
                this.keN.cHR();
                if (this.keN.cKU() != null) {
                    this.keN.cKU().a(o);
                    if (!z) {
                        this.keN.cKU().aMN();
                    } else {
                        this.keN.cKU().aMM();
                    }
                }
            }
        }
    }

    public int h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cCy() != null) {
            if (eVar.cCy().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cCy().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cCy().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ru(boolean z) {
        if (this.keN.cDO() == null || this.keN.cDO().getPbData() == null) {
            return false;
        }
        return ((this.keN.cDO().getPbData().cCN() != 0) || this.keN.cDO().getPbData().cCy() == null || this.keN.cDO().getPbData().cCy().aQx() == null || TextUtils.equals(this.keN.cDO().getPbData().cCy().aQx().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Jm(String str) {
        if (this.keN.cDO() != null && this.keN.cDO().getPbData() != null && this.keN.cDO().getPbData().cCZ()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.keN.cDO().cFJ(), str);
            bk cCy = this.keN.cDO().getPbData().cCy();
            if (cCy.aPm()) {
                format = format + "&channelid=33833";
            } else if (cCy.aSu()) {
                format = format + "&channelid=33842";
            } else if (cCy.aPn()) {
                format = format + "&channelid=33840";
            }
            Jn(format);
            return;
        }
        this.jLC.JN(str);
    }

    private void Jn(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.keN.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.jLK != null && this.jLK.isShowing()) {
                this.jLK.dismiss();
                this.jLK = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.keN.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.jLK != null) {
                            a.this.jLK.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.jMa);
                            userMuteAddAndDelCustomMessage.setTag(a.this.jMa);
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
                this.jLK = new i(this.keN.getPageContext(), kVar);
                this.jLK.showDialog();
            }
        }
    }

    public void cFl() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.keN.getPageContext().getPageActivity());
        aVar.vO(this.keN.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.keN.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.keN.getPageContext()).aST();
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
        sparseArray.put(jTx, Integer.valueOf(jTy));
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
        this.jSG = new com.baidu.tbadk.core.dialog.a(this.keN.getActivity());
        if (StringUtils.isNull(str2)) {
            this.jSG.kF(i3);
        } else {
            this.jSG.setOnlyMessageShowCenter(false);
            this.jSG.vO(str2);
        }
        this.jSG.setYesButtonTag(sparseArray);
        this.jSG.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.keN.a(aVar, (JSONArray) null);
            }
        });
        this.jSG.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jSG.gW(true);
        this.jSG.b(this.keN.getPageContext());
        if (z) {
            this.jSG.aST();
        } else {
            a(this.jSG, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.keN != null && aVar != null) {
            if (this.hRk == null && this.keN.getView() != null) {
                this.hRk = new e(this.keN.getPageContext(), this.keN.getView());
            }
            AntiData bUc = bUc();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bUc != null && bUc.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bUc.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            ak akVar = new ak();
            akVar.setFeedBackReasonMap(sparseArray);
            this.hRk.setDefaultReasonArray(new String[]{this.keN.getString(R.string.delete_thread_reason_1), this.keN.getString(R.string.delete_thread_reason_2), this.keN.getString(R.string.delete_thread_reason_3), this.keN.getString(R.string.delete_thread_reason_4), this.keN.getString(R.string.delete_thread_reason_5)});
            this.hRk.setData(akVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.hRk.zj(str);
            this.hRk.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    a.this.keN.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData bUc() {
        if (this.keN.cDO() == null || this.keN.cDO().getPbData() == null) {
            return null;
        }
        return this.keN.cDO().getPbData().getAnti();
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
        k kVar = new k(this.keN.getContext());
        kVar.setTitleText(this.keN.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.jSF.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.jUe != null) {
                                a.this.jUe.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.keN.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.keN.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.keN.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.keN.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.keN.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aD(arrayList);
        if (this.jSF == null) {
            this.jSF = new i(this.keN.getPageContext(), kVar);
        } else {
            this.jSF.a(kVar);
        }
        this.jSF.showDialog();
    }

    public void cEI() {
        if (this.jLi == null) {
            this.jLi = new com.baidu.tbadk.core.dialog.b(this.keN.getPageContext().getPageActivity());
            this.jLi.a(new String[]{this.keN.getPageContext().getString(R.string.call_phone), this.keN.getPageContext().getString(R.string.sms_phone), this.keN.getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.keN.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.jHR = a.this.jHR.trim();
                        UtilHelper.callPhone(a.this.keN.getPageContext().getPageActivity(), a.this.jHR);
                        new com.baidu.tieba.pb.pb.main.b(a.this.keN.cDO().cFJ(), a.this.jHR, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.keN.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.jHR = a.this.jHR.trim();
                        UtilHelper.smsPhone(a.this.keN.getPageContext().getPageActivity(), a.this.jHR);
                        new com.baidu.tieba.pb.pb.main.b(a.this.keN.cDO().cFJ(), a.this.jHR, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.jHR = a.this.jHR.trim();
                        UtilHelper.startBaiDuBar(a.this.keN.getPageContext().getPageActivity(), a.this.jHR);
                        bVar.dismiss();
                    }
                }
            }).kK(R.style.dialog_ani_b2t).kL(17).d(this.keN.getPageContext());
        }
    }

    public void cP(final View view) {
        String[] strArr;
        int i = 0;
        if (this.keN != null && this.keN.cDO() != null) {
            final i iVar = new i(this.keN.getPageContext());
            if (this.keN.cDO().getPbData().jFb == null || this.keN.cDO().getPbData().jFb.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.keN.cDO().getPbData().jFb.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.keN.cDO().getPbData().jFb.size()) {
                        break;
                    }
                    strArr2[i2] = this.keN.cDO().getPbData().jFb.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.keN.cDO().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.keN.cDO().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.keN.cDO().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.keN.cDO().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new an("c12097").ag("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ag("obj_type", i4));
                    if (a.this.keN.cDO().getPbData().jFb != null && a.this.keN.cDO().getPbData().jFb.size() > i3) {
                        i3 = a.this.keN.cDO().getPbData().jFb.get(i3).sort_type.intValue();
                    }
                    boolean As = a.this.keN.cDO().As(i3);
                    view.setTag(Integer.valueOf(a.this.keN.cDO().cGc()));
                    if (As) {
                        a.this.keN.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.keN.getActivity());
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
                    if (a.this.keN.cLf() != null) {
                        a.this.keN.cLf().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.keN.getPageContext().getUniqueId(), a.this.keN.cDO().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.keN.getPageContext()).aST();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.jMa);
        userMuteAddAndDelCustomMessage.setTag(this.jMa);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void yo(String str) {
        if (str == null) {
            str = "";
        }
        if (this.keN != null && this.keN.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.keN.getPageContext().getPageActivity());
            aVar.vO(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.keN.getPageContext()).aST();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.keN.getBaseFragmentActivity());
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
        aVar.b(this.keN.getPageContext()).aST();
    }

    public void showLoadingDialog() {
        if (this.gKA == null) {
            this.gKA = new com.baidu.tbadk.core.view.a(this.keN.getPageContext());
        }
        this.gKA.setDialogVisiable(true);
    }

    public void bGh() {
        if (this.gKA != null) {
            this.gKA.setDialogVisiable(false);
        }
    }

    public void a(final b.a aVar, boolean z) {
        if (this.jSO != null) {
            this.jSO.dismiss();
            this.jSO = null;
        }
        k kVar = new k(this.keN.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.keN.cDO().getPbData() != null && this.keN.cDO().getPbData().cCy() != null && !this.keN.cDO().getPbData().cCy().isBjh()) {
            arrayList.add(new g(0, this.keN.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.keN.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aD(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.jSO.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jSO = new i(this.keN.getPageContext(), kVar);
        this.jSO.showDialog();
    }

    public void aP(ArrayList<ac> arrayList) {
        if (this.jSJ == null) {
            this.jSJ = LayoutInflater.from(this.keN.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.keN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jSJ);
        if (this.jSI == null) {
            this.jSI = new Dialog(this.keN.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jSI.setCanceledOnTouchOutside(true);
            this.jSI.setCancelable(true);
            this.jSR = (ScrollView) this.jSJ.findViewById(R.id.good_scroll);
            this.jSI.setContentView(this.jSJ);
            WindowManager.LayoutParams attributes = this.jSI.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.jSI.getWindow().setAttributes(attributes);
            this.gGD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.jSN = (String) compoundButton.getTag();
                        if (a.this.gGC != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.gGC) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.jSN != null && !str.equals(a.this.jSN)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.jSK = (LinearLayout) this.jSJ.findViewById(R.id.good_class_group);
            this.jSM = (TextView) this.jSJ.findViewById(R.id.dialog_button_cancel);
            this.jSM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jSI instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.jSI, a.this.keN.getPageContext());
                    }
                }
            });
            this.jSL = (TextView) this.jSJ.findViewById(R.id.dialog_button_ok);
            this.jSL.setOnClickListener(this.keN.cKV());
        }
        this.jSK.removeAllViews();
        this.gGC = new ArrayList();
        CustomBlueCheckRadioButton eT = eT("0", this.keN.getPageContext().getString(R.string.thread_good_class));
        this.gGC.add(eT);
        eT.setChecked(true);
        this.jSK.addView(eT);
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
                    this.gGC.add(eT2);
                    View view = new View(this.keN.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.jSK.addView(view);
                    this.jSK.addView(eT2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.jSR.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.keN.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.keN.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.keN.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.jSR.setLayoutParams(layoutParams2);
            this.jSR.removeAllViews();
            if (this.jSK != null && this.jSK.getParent() == null) {
                this.jSR.addView(this.jSK);
            }
        }
        com.baidu.adp.lib.f.g.a(this.jSI, this.keN.getPageContext());
    }

    private CustomBlueCheckRadioButton eT(String str, String str2) {
        Activity pageActivity = this.keN.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.gGD);
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
        userMuteCheckCustomMessage.mId = this.jMa;
        userMuteCheckCustomMessage.setTag(this.jMa);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cIm() {
        if (this.jSG != null) {
            this.jSG.dismiss();
        }
        if (this.jSH != null) {
            com.baidu.adp.lib.f.g.b(this.jSH, this.keN.getPageContext());
        }
        if (this.jSI != null) {
            com.baidu.adp.lib.f.g.b(this.jSI, this.keN.getPageContext());
        }
        if (this.jSF != null) {
            this.jSF.dismiss();
        }
    }

    public void cLI() {
        if (this.jLK != null) {
            this.jLK.dismiss();
        }
    }

    public void cIl() {
        aEa();
        this.keN.cHs();
        if (this.jLK != null) {
            this.jLK.dismiss();
        }
        cIm();
    }

    public void cIk() {
        aEa();
        this.keN.cHs();
        if (this.jLK != null) {
            this.jLK.dismiss();
        }
        this.keN.bVq();
        cIm();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener cKX() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b cLJ() {
        return this.jLi;
    }

    public void setPhoneNumber(String str) {
        this.jHR = str;
    }

    public String cHQ() {
        return this.jSN;
    }

    public View cHP() {
        if (this.jSJ != null) {
            return this.jSJ.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
